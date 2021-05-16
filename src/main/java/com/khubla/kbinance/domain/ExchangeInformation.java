package com.khubla.kbinance.domain;

import java.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class ExchangeInformation {
	public List<ExchangeFilter> exchangeFilters;
	public List<ExchangeRateLimit> rateLimits;
	public Long serverTime;
	public List<ExchangeSymbol> symbols;
	public String timezone;
}
