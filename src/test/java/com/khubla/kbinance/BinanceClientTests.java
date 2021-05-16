package com.khubla.kbinance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.khubla.kbinance.binance.*;
import com.khubla.kbinance.domain.*;

public class BinanceClientTests {
	private final String apipubkey = "6TtVkxOvdGxVpSD1YEXez41GG7h2rSJ6lrwFtk3Ad0wpTiQp9cWipp2YYTbpMc6o";
	private final String apiprivkey = "iphRdijexImimnj1T95QDEu6oeOeIC0CrmCVTcSexITRF5rZZKr7ngsXvvTVyOCY";

	@Test
	public void testAccountInformation() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final AccountInformation accountInformation = binanceClient.accountInformation();
			assertNotNull(accountInformation);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCurrentAveragePriceAndPrice() {
		try {
			/*
			 * get a supported pair
			 */
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
			/*
			 * current average price
			 */
			final CurrentAveragePrice currentAveragePrice = binanceClient.currentAveragePrice(exchangeInformation.symbols.get(0).symbol);
			assertNotNull(currentAveragePrice);
			/*
			 * price
			 */
			final Price price = binanceClient.price(exchangeInformation.symbols.get(0).symbol);
			assertNotNull(price);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testExchangeInformation() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testHistoricalTrades() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
			final RecentTrade[] recentTrades = binanceClient.historicalTrades(exchangeInformation.symbols.get(0).symbol);
			assertNotNull(recentTrades);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOrderBook() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
			final OrderBook orderBook = binanceClient.orderBook(exchangeInformation.symbols.get(0).symbol);
			assertNotNull(orderBook);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRecentTrades() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
			final RecentTrade[] recentTrades = binanceClient.recentTrades(exchangeInformation.symbols.get(0).symbol);
			assertNotNull(recentTrades);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testServerTime() {
		try {
			final BinanceClient binanceClient = new BinanceClient(AbstractBinanceClient.TEST_BASE_ENDPOINT, apipubkey, apiprivkey);
			final ExchangeInformation exchangeInformation = binanceClient.exchangeInformation();
			assertNotNull(exchangeInformation);
			final ServerTime serverTime = binanceClient.serverTime();
			assertNotNull(serverTime);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
