package org.artemis.services;

import org.artemis.core.AccountId;

import java.math.BigInteger;

public interface AccountBalanceService {

    /**
     * Get the current balance of the account identified by {@code accountId}.
     *
     * @param accountId An {@link AccountId} that uniquely identifies the account to obtain a balance from.
     *
     * @return A {@link BigInteger} representing the current balance of the account identified by {@code accountId}.
     */
    BigInteger getBalance(AccountId accountId);
}
