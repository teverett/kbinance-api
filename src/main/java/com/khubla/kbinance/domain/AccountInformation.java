package com.khubla.kbinance.domain;

import java.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
public class AccountInformation {
	public Double makerCommission;
	public Double takerCommission;
	public Double buyerCommission;
	public Double sellerCommission;
	public Boolean canTrade;
	public Boolean canWithdraw;
	public Boolean canDeposit;
	public Long updateTime;
	public String accountType;
	public String[] permissions;
	public List<AccountBalance> balances;
}
