package com.khubla.kbinance.binance;

import com.khubla.kbinance.domain.*;

/*
 *  https://binance-docs.github.io/apidocs/spot/en/#change-log
 */
/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class BinanceClient extends AbstractBinanceClient {
	public BinanceClient(String baseURL, String apipubkey, String apiprivkey) {
		super(baseURL, apipubkey, apiprivkey);
	}

	public AccountInformation accountInformation() throws Exception {
		return doSignedGET("/api/v3/account", new String[] {}, AccountInformation.class);
	}

	public CurrentAveragePrice currentAveragePrice(String pair) throws Exception {
		return doGET("/api/v3/avgPrice", new String[] { "symbol", pair }, CurrentAveragePrice.class);
	}

	public ExchangeInformation exchangeInformation() throws Exception {
		return doGET("/api/v3/exchangeInfo", new String[] {}, ExchangeInformation.class);
	}

	public RecentTrade[] historicalTrades(String symbol) throws Exception {
		return doGET("/api/v3/historicalTrades", new String[] { "symbol", symbol }, RecentTrade[].class);
	}

	public RecentTrade[] klines(String symbol) throws Exception {
		return doGET("/api/v3/historicalTrades", new String[] { "symbol", symbol }, RecentTrade[].class);
	}

	public OrderBook orderBook(String symbol) throws Exception {
		return doGET("/api/v3/depth", new String[] { "symbol", symbol }, OrderBook.class);
	}

	public Price price(String pair) throws Exception {
		return doGET("/api/v3/ticker/price", new String[] { "symbol", pair }, Price.class);
	}

	public RecentTrade[] recentTrades(String symbol) throws Exception {
		return doGET("/api/v3/trades", new String[] { "symbol", symbol }, RecentTrade[].class);
	}

	public ServerTime serverTime() throws Exception {
		return doGET("/api/v3/time", new String[] {}, ServerTime.class);
	}

	public Status status() throws Exception {
		return doGET("/api/v1/system/status", new String[] {}, Status.class);
	}
}
