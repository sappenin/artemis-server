package org.artemis;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

/**
 * @deprecated remove if unused.
 */
@Deprecated
@Immutable
@JsonSerialize(as = ImmutableArtemisPaymentPointer.class)
@JsonDeserialize(as = ImmutableArtemisPaymentPointer.class)
public interface ArtemisPaymentPointer {

//    /**
//     * The value of
//     *
//     * @return
//     */
//    @JsonProperty("value")
//    String in();

//    /**
//     * Currency code or other asset identifier that will be used to select the correct rate for this account.
//     */
//    @JsonProperty("asset_code")
//    String assetCode();
//
//    /**
//     * Interledger amounts are integers, but most currencies are typically represented as # fractional units, e.g.
//     * cents. This property defines how many Interledger units make up one regular unit. For dollars, this would usually
//     * be set to 9, so that Interledger amounts are expressed in nano-dollars.
//     *
//     * @return
//     */
//    @JsonProperty("asset_scale")
//    int assetScale();

//    /**
//     * A 64-bit unsigned integer, but as a String to placate JSON.
//     *
//     * @return
//     */
//    @JsonProperty("balance")
//    @Default
//    default UnsignedLong balance() {
//        return UnsignedLong.ZERO;
//    }

//    @Value.Check
//    default ArtemisPaymentPointer normalize() {
//        // PaymentPointers can only be ASCII
//        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(this.in()));
//
//        // If the destination address is a PaymentPointer, then it can only be ASCII too...
//        if (this.destinationType() == DestinationAddressType.PAYMENT_POINTER) {
//            Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(this.destinationAddress()));
//        }
//
//        // Artemis only supports lower-case Payment Pointers...
//        return ImmutableArtemisPaymentPointer.copyOf(this).withIn(this.in().toLowerCase(Locale.ENGLISH));
//    }
}
