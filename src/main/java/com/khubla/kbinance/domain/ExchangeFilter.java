package com.khubla.kbinance.domain;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class ExchangeFilter {
	public String filterType;
	public Double maxPrice;
	public Double minPrice;
	public Double tickSize;
	public Double multiplierUp;
	public Double multiplierDown;
	public Double avgPriceMins;
	public Double minQty;
	public Double maxQty;
	public Double stepSize;
	public Double multiplierDecimal;
	public Double minNotional;
	public Boolean applyToMarket;
	public Double limit;
	public Integer maxNumOrders;
	public Integer maxNumAlgoOrders;
	public Integer maxNumIcebergOrders;
}
