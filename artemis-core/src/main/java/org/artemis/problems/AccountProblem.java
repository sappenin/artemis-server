package org.artemis.problems;

import org.artemis.core.AccountId;
import org.zalando.problem.StatusType;

import java.net.URI;
import java.util.Objects;

/**
 * A root exception for all problems relating to Accounts.
 */
public abstract class AccountProblem extends AbstractArtemisProblem {

    protected static final String ACCOUNTS_PATH = "/accounts";

    /**
     * The account-address of the account that threw this exception.
     */
    private final AccountId accountId;

    public AccountProblem(URI type, String title, StatusType status, AccountId accountId) {
        super(type, title, status);
        this.accountId = Objects.requireNonNull(accountId, "accountId must not be null!");
    }

    public AccountProblem(URI type, String title, StatusType status, String detail,
        AccountId accountId) {
        super(type, title, status, detail);
        this.accountId = Objects.requireNonNull(accountId, "accountId must not be null!");
    }

    /**
     * The {@link AccountId} of the account that threw this exception.
     */
    public AccountId getAccountId() {
        return accountId;
    }

}
