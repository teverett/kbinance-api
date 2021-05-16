package com.khubla.kbinance.domain;

import java.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class ExchangeSymbol {
	public String symbol;
	public String status;
	public String baseAsset;
	public Double baseAssetPrecision;
	public String quoteAsset;
	public Double quotePrecision;
	public Double quoteAssetPrecision;
	public String[] orderTypes;
	public Boolean icebergAllowed;
	public Boolean ocoAllowed;
	public Boolean isSpotTradingAllowed;
	public Boolean isMarginTradingAllowed;
	public List<ExchangeFilter> filters;
	public String[] permissions;
	public Double baseCommissionPrecision;
	public Double quoteCommissionPrecision;
	public Boolean quoteOrderQtyMarketAllowed;
}
