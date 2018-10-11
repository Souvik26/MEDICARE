package com.medi.web.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medi.web.model.UserInfo;

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

	public String generateWebToken(UserInfo userInfo) {
		final Clock clock = DefaultClock.INSTANCE;
		final Date currentDate = clock.now();
		final Date expirationDate = getExpirationDate(currentDate);
		final Claims claims = Jwts.claims().setSubject(userInfo.getUserName());
		claims.setId(String.valueOf(userInfo.getUserId()));
		claims.setIssuedAt(currentDate);
		claims.setExpiration(expirationDate);
		claims.put("roleId", userInfo.getRoleId());
		claims.put("emailAddress", userInfo.getEmail());
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

	public UserInfo retrieveUserFromToken(String token) {
		UserInfo userInfo = null;
		try {
			final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			userInfo = new UserInfo();
			userInfo.setUserId(claims.getId());
			userInfo.setUserName(claims.getSubject());
			userInfo.setEmail((String) claims.get("emailAddress"));
			userInfo.setRoleId(claims.get("roleId").toString());
		} catch (Exception ex) {
			System.out.println("Exception caught");
		}
		return userInfo;
	}

}
