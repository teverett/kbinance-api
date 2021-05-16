package com.khubla.kbinance.binance;

import org.glassfish.jersey.client.*;

import com.khubla.kbinance.*;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public abstract class AbstractBinanceClient {
	public static enum SIDE {
		BUY, SELL
	};

	public static enum SymbolStatus {
		PRE_TRADING, TRADING, POST_TRADING, END_OF_DAY, HALT, AUCTION_MATCH, BREAK
	}

	public static enum OrderStatus {
		NEW, PARTIALLY_FILLED, FILLED, CANCELED, PENDING_CANCEL, REJECTED, EXPIRED
	}

	public static enum OrderType {
		LIMIT, MARKET, STOP_LOSS, STOP_LOSS_LIMIT, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER
	}

	public static enum OrderResponseType {
		ACK, RESULT, FULL
	}

	public static enum TimeInForce {
		GTC, IOC, FOK
	}

	/**
	 * api endpoint
	 */
	public static String PROD_BASE_ENDPOINT = "https://api.binance.com";
	public static String TEST_BASE_ENDPOINT = "https://testnet.binance.vision";
	/*
	 * base url
	 */
	private final String baseURL;
	/*
	 * request filter
	 */
	AuthTokenClientRequestFilter authTokenCilentRequestFilter = new AuthTokenClientRequestFilter(Config.getInstance().getApipubkey());

	public AbstractBinanceClient(String baseURL) {
		super();
		this.baseURL = baseURL;
	}

	protected <T> T doGET(String path, String[] parameters, Class<T> clazz) throws Exception {
		final Client client = ClientBuilder.newClient(new ClientConfig().register(authTokenCilentRequestFilter));
		WebTarget webTarget = client.target(baseURL).path(path);
		for (int i = 0; i < parameters.length; i += 2) {
			webTarget = webTarget.queryParam(parameters[i], parameters[i + 1]);
		}
		final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		final Response response = invocationBuilder.get();
		if (response.getStatus() == jakarta.ws.rs.core.Response.Status.OK.getStatusCode()) {
			return response.readEntity(clazz);
		} else {
			throw new Exception(response.readEntity(String.class));
		}
	}

	protected <T> T doSignedGET(String path, String[] parameters, Class<T> clazz) throws Exception {
		final Client client = ClientBuilder.newClient(new ClientConfig().register(authTokenCilentRequestFilter));
		WebTarget webTarget = client.target(baseURL).path(path).queryParam("timestamp", System.currentTimeMillis());
		for (int i = 0; i < parameters.length; i += 2) {
			webTarget = webTarget.queryParam(parameters[i], parameters[i + 1]);
		}
		final String hmac = HMAC256.calcHmacSha256(Config.getInstance().getApiprivkey(), webTarget.getUri().getQuery());
		webTarget = webTarget.queryParam("signature", hmac);
		final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		final Response response = invocationBuilder.get();
		if (response.getStatus() == jakarta.ws.rs.core.Response.Status.OK.getStatusCode()) {
			return response.readEntity(clazz);
		} else {
			throw new Exception(response.readEntity(String.class));
		}
	}
}
