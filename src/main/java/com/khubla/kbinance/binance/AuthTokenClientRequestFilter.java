package com.khubla.kbinance.binance;

import java.io.*;

import jakarta.ws.rs.client.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class AuthTokenClientRequestFilter implements ClientRequestFilter {
	private final String token;

	public AuthTokenClientRequestFilter(String token) {
		super();
		this.token = token;
	}

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("X-MBX-APIKEY", token);
	}
}
