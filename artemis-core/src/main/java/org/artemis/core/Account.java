package org.artemis.core;

/**
 * A store of value owned by a single User, denominated in a single fungible asset type.
 */
public interface Account extends CreatedAt, ModifiedAt {

    /**
     * The public-facing identifier of this {@link Account}.
     *
     * @return A {@link AccountId}.
     */
    AccountId accountId();

    /**
     * A human-readable description of this account.
     */
    default String getDescription() {
        return "";
    }
    
    /**
     * Currency code or other asset identifier that will be used to select the correct rate for this account.
     */
    String getAssetCode();

    /**
     * Interledger amounts are integers, but most currencies are typically represented as # fractional units, e.g.
     * cents. This property defines how many Interledger units make # up one regular unit. For dollars, this would
     * usually be set to 9, so that Interledger # amounts are expressed in nano-dollars.
     *
     * @return an int representing this account's asset scale.
     */
    int getAssetScale();

}
