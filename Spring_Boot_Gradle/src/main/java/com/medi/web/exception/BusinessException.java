package com.medi.web.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 7176015949982203107L;

	private String errorResponseCode;
	private String errorResponseMessage;

	public BusinessException() {
		super();
	}

	
	/**
	 * @param errorResponseCode
	 * @param errorResponseMessage
	 */
	public BusinessException(String errorResponseCode, String errorResponseMessage) {
		super();
		this.errorResponseCode = errorResponseCode;
		this.errorResponseMessage = errorResponseMessage;
	}

	/**
	 * @return the errorResponseCode
	 */
	public String getErrorResponseCode() {
		return errorResponseCode;
	}

	/**
	 * @param errorResponseCode
	 *            the errorResponseCode to set
	 */
	public void setErrorResponseCode(String errorResponseCode) {
		this.errorResponseCode = errorResponseCode;
	}

	/**
	 * @return the errorResponseMessage
	 */
	public String getErrorResponseMessage() {
		return errorResponseMessage;
	}

	/**
	 * @param errorResponseMessage
	 *            the errorResponseMessage to set
	 */
	public void setErrorResponseMessage(String errorResponseMessage) {
		this.errorResponseMessage = errorResponseMessage;
	}

}
