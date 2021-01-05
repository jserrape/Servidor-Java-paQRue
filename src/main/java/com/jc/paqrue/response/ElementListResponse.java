package com.jc.paqrue.response;

import java.util.List;

/**
 * Response with a list of objects
 * 
 * @author jserrape
 *
 */
public class ElementListResponse extends BaseResponse {

	private static final long serialVersionUID = 6218092048807782342L;

	private final List<?> elementList;

	/**
	 * Constructor with the list
	 * 
	 * @param elementList List of elements
	 * @param message     Message to the user
	 */
	public ElementListResponse(List<?> elementList, String message) {
		super(message);
		this.elementList = elementList;
	}

	/**
	 * Get the list
	 * 
	 * @return The list of elements
	 */
	public List<?> getElementList() {
		return elementList;
	}

}
