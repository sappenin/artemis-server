package org.artemis;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import org.immutables.value.Value;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

import java.util.Locale;

@Immutable
@JsonSerialize(as = ImmutablePointer.class)
@JsonDeserialize(as = ImmutablePointer.class)
public interface Pointer {

    /**
     * The value of
     *
     * @return
     */
    @JsonProperty("in")
    String in();

    @JsonProperty("type")
    DestinationAddressType destinationType();

    /**
     * Can be another payment pointer, or an XRP address or whatever.
     *
     * @return
     */
    @JsonProperty("to")
    String destinationAddress();

    /**
     * Currency code or other asset identifier that will be used to select the correct rate for this account.
     */
    @JsonProperty("asset_code")
    String assetCode();

    /**
     * Interledger amounts are integers, but most currencies are typically represented as # fractional units, e.g.
     * cents. This property defines how many Interledger units make # up one regular unit. For dollars, this would
     * usually be set to 9, so that Interledger # amounts are expressed in nano-dollars.
     *
     * @return
     */
    @JsonProperty("asset_scale")
    int assetScale();

    /**
     * A 64-bit unsigned integer, but as a String to placate JSON.
     *
     * @return
     */
    @JsonProperty("balance")
    @Default
    default String balance() {
        return "0";
    }

    /**
     * The amount to trigger a payout to the destination address.
     *
     * @return
     */
    @JsonProperty("threshold")
    @Default
    default String threshold() {
        return "100";
    }

    @Value.Check
    default Pointer normalize() {
        // PaymentPointers can only be ASCII
        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(this.in()));

        // If the destination address is a PaymentPointer, then it can only be ASCII too...
        if (this.destinationType() == DestinationAddressType.PAYMENT_POINTER) {
            Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(this.destinationAddress()));
        }

        // Artemis only supports lower-case Payment Pointers...
        return ImmutablePointer.copyOf(this).withIn(this.in().toLowerCase(Locale.ENGLISH));
    }
}
