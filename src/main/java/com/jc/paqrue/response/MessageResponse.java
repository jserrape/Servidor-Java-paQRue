package com.jc.paqrue.response;

/**
 * Type of response with one message associated
 * 
 * @author jserrape
 *
 */
public class MessageResponse extends BaseResponse {

	private static final long serialVersionUID = 4405614853175745810L;

	public MessageResponse(String message) {
		super(message);
	}

}