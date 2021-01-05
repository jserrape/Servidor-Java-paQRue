package com.jc.paqrue.response;

/**
 * Type of response with one object associated
 * 
 * @author jserrape
 *
 */
public class ElementResponse extends BaseResponse {

	private static final long serialVersionUID = -2665476248431375282L;

	private final Object element;

	public ElementResponse(Object element, String message) {
		super(message);
		this.element = element;
	}

	public Object getElement() {
		return element;
	}
}