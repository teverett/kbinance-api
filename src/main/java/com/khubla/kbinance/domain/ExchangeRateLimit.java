package com.khubla.kbinance.domain;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class ExchangeRateLimit {
	public String interval;
	public Integer intervalNum;
	public Integer limit;
	public String rateLimitType;
}
