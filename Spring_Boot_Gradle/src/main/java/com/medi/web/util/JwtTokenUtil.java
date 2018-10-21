package com.medi.web.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medi.web.view.LoginInfoView;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultClock;

@Component
public class JwtTokenUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateWebToken(LoginInfoView loginInfoView) {
		final Clock clock = DefaultClock.INSTANCE;
		final Date currentDate = clock.now();
		final Date expirationDate = getExpirationDate(currentDate);
		final Claims claims = Jwts.claims().setSubject(loginInfoView.getEmail());
		claims.setId(String.valueOf(loginInfoView.getUserId()));
		claims.setIssuedAt(currentDate);
		claims.setExpiration(expirationDate);
		claims.put("roleId", loginInfoView.getUserRole());
		claims.put("emailAddress", loginInfoView.getEmail());
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date getExpirationDate(Date currentDate) {
		return new Date(currentDate.getTime() + expiration * 1000);
	}

	public boolean validateWebToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			System.out.println("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			System.out.println("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			System.out.println("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			System.out.println("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			System.out.println("JWT claims string is empty.");
		}
		return false;
	}

	public LoginInfoView retrieveUserFromToken(String token) {
		LoginInfoView loginInfoView = null;
			final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			loginInfoView = new LoginInfoView();
			loginInfoView.setUserId(claims.getId());
			loginInfoView.setUserName(claims.getSubject());
			loginInfoView.setEmail((String) claims.get("emailAddress"));
			loginInfoView.setUserRole(claims.get("roleId").toString());
		return loginInfoView;
	}

}
