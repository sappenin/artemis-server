package org.artemis.problems;

import org.artemis.core.PaymentEndpointId;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.Objects;

/**
 * Thrown if an paymentEndpoint is not found.
 */
public class PaymentEndpointNotFoundProblem extends PaymentEndpointProblem {

    /**
     * Required-args Constructor.
     *
     * @param paymentEndpointId The {@link PaymentEndpointId} that was unable to be found.
     */
    public PaymentEndpointNotFoundProblem(final PaymentEndpointId paymentEndpointId) {
        this(null, paymentEndpointId);
    }

    /**
     * Required-args Constructor.
     *
     * @param detail            A {@link String} containing a more customized error message for internal server logging
     *                          purposes only (i.e., this value will not affect the problem's `detail` message).
     * @param paymentEndpointId The {@link PaymentEndpointId} that was unable to be found.
     */
    public PaymentEndpointNotFoundProblem(final String detail, final PaymentEndpointId paymentEndpointId) {
        super(
            URI.create(TYPE_PREFIX + PAYMENT_ENDPOINTS_PATH + "/not-found"),
            "PaymentEndpoint Not Found (`" + paymentEndpointId + "`)",
            Status.NOT_FOUND,
            detail,
            Objects.requireNonNull(paymentEndpointId)
        );
    }


}
