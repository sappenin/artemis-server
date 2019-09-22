package org.interledger.paymentpointers;

import org.artemis.core.PaymentEndpoint;

/**
 * Resolves a PaymentPointer into a URL, and vice versa.
 *
 * @deprecated Will be removed once Quilt contains this resolver.
 */
@Deprecated
public interface PaymentPointerResolver {

    /**
     * Resolve a PaymentPointer to its corresponding URL.
     *
     * @param paymentPointer The payment pointer to resolve.
     *
     * @return An {@link PaymentEndpoint} that corresponds to supplied {@code paymentPointer}.
     */
    PaymentEndpoint resolve(PaymentPointer paymentPointer);

    /**
     * Resolve a Payment Endpoint URL to its corresponding Payment Pointer.
     *
     * @param paymentEndpoint A {@link PaymentEndpoint}.
     *
     * @return A corresponding {@link PaymentPointer}.
     */
    PaymentPointer resolve(PaymentEndpoint paymentEndpoint);

    class DefaultPaymentPointerResolver implements PaymentPointerResolver {

        @Override
        public PaymentEndpoint resolve(PaymentPointer paymentPointer) {
            return null;
        }

        @Override
        public PaymentPointer resolve(PaymentEndpoint paymentEndpoint) {
            return null;
        }
    }
}
