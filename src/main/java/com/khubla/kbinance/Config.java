package com.khubla.kbinance;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.builder.*;
import org.apache.commons.configuration2.builder.fluent.*;
import org.apache.commons.configuration2.convert.*;
import org.apache.logging.log4j.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class Config {
	/**
	 * singleton
	 */
	private static Config instance;
	/**
	 * filename
	 */
	public static String propertiesFile = "kbinance.properties";
	/**
	 * logger
	 */
	private static final Logger logger = LogManager.getLogger(Config.class);

	/**
	 * singleton getter
	 */
	public static Config getInstance() {
		if (null == instance) {
			instance = new Config();
			try {
				instance.load(propertiesFile);
			} catch (final Exception e) {
				logger.error(e);
			}
		}
		return instance;
	}

	/**
	 * apipubkey
	 */
	private String apipubkey;
	/**
	 * apiprivkey
	 */
	private String apiprivkey;

	public String getApiprivkey() {
		return apiprivkey;
	}

	public String getApipubkey() {
		return apipubkey;
	}

	private void load(String propertiesFile) throws Exception {
		try {
			final Parameters params = new Parameters();
			final FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
					.configure(params.properties().setFileName(propertiesFile).setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
			/*
			 * get config
			 */
			final Configuration configuration = builder.getConfiguration();
			/*
			 * parameters
			 */
			apipubkey = configuration.get(String.class, "apipubkey").trim();
			apiprivkey = configuration.get(String.class, "apiprivkey").trim();
		} catch (final Exception e) {
			logger.error(e);
			throw e;
		}
	}

	public void setApiprivkey(String apiprivkey) {
		this.apiprivkey = apiprivkey;
	}

	public void setApipubkey(String apipubkey) {
		this.apipubkey = apipubkey;
	}
}
