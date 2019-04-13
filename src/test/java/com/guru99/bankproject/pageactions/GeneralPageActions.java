package com.guru99.bankproject.pageactions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ADMIN
 *
 */
public abstract class GeneralPageActions {

	private final Map <String, Object> values;

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:04:10 PM
	 */
	public GeneralPageActions () {
		this.values = new HashMap <> ();
	}

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:05:35 PM
	 * @param element
	 * @param value
	 * @return instance
	 */
	public GeneralPageActions addInputValue (final String element, final Object value) {
		this.values.put (element, value);
		return this;
	}

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:07:57 PM
	 */
	public abstract void perform ();

	@SuppressWarnings ("unchecked")
	protected <T> T value (final String element) {
		return (T) this.values.get (element);
	}
}
