package org.interledger.paymentpointers;


import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import org.immutables.value.Value.Check;
import org.immutables.value.Value.Default;
import org.immutables.value.Value.Immutable;

/**
 * A standardized identifier for payment accounts.
 *
 * @see "https://github.com/interledger/rfcs/blob/master/0026-payment-pointers/0026-payment-pointers.md"
 * @deprecated This definition will eventually be relocated into the Quilt project at https://github
 *     .com/hyperledger/quilt.
 */
@Deprecated
public interface PaymentPointer {

//    static Builder builder() {
//        return ImmutablePaymentPointer.builder();
//    }

    /**
     * A host as defined by RFC-3986, which is generally (though not always) a registered name intended for lookup in
     * the DNS.
     *
     * @return A {@link String} containing the `host` portion of this Payment Pointer.
     *
     * @see "https://tools.ietf.org/html/rfc3986#page-18
     */
    String host();

    /**
     * An optional path as defined by RFC-3986.
     *
     * @return A {@link String} containing the `path` portion of this Payment Pointer.
     *
     * @see "https://tools.ietf.org/html/rfc3986#page-22
     */
    String path();

    @Immutable
    abstract class AbstractPaymentPointer implements PaymentPointer {

        private static final String WELL_KNOWN = "/.well-known/pay";

        @Default
        public String path() {
            return WELL_KNOWN;
        }

        @Override
        public String toString() {
            return "$" + host() + path();
        }

        @Check
        public AbstractPaymentPointer validate() {
            // Normalize acceptable input.
            if (path().equals("/")) {
                return ImmutablePaymentPointer.builder().from(this)
                    .path(WELL_KNOWN)
                    .build();
            }
            Preconditions.checkState(path().startsWith("/"), "path must start with a forward-slash");
            Preconditions.checkState(
                CharMatcher.ascii().matchesAllOf(toString()), "PaymentPointers may only contain ASCII characters"
            );

            return this;
        }
    }

}
