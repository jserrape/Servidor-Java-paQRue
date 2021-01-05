package com.jc.paqrue.response;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Response to the user
 * 
 * @author jserrape
 *
 */
public abstract class BaseResponse implements Serializable {

	private static final long serialVersionUID = -8344952364380730464L;

	private final String message;
	private final String systemTime;

	/**
	 * Constructor of the response
	 * 
	 * @param message Message to the user
	 */
	public BaseResponse(String message) {
		this.message = message;
		this.systemTime = LocalDateTime.now().toString();
	}

	/**
	 * Get the time of creation of the response
	 * 
	 * @return Time of creation of the response
	 */
	public String getSystemTime() {
		return systemTime;
	}

	/**
	 * Get the message content
	 * 
	 * @return Message content
	 */
	public String getMessage() {
		return message;
	}
}