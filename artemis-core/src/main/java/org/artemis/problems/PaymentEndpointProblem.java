package org.artemis.problems;

import org.artemis.core.PaymentEndpointId;
import org.zalando.problem.StatusType;

import java.net.URI;
import java.util.Objects;

/**
 * A root exception for all problems relating to Payment Endpoints.
 */
public abstract class PaymentEndpointProblem extends AbstractArtemisProblem {

    protected static final String PAYMENT_ENDPOINTS_PATH = "/payment_endpoints";

    /**
     * The paymentEndpoint-address of the paymentEndpoint that threw this exception.
     */
    private final PaymentEndpointId paymentEndpointId;

    public PaymentEndpointProblem(URI type, String title, StatusType status, PaymentEndpointId paymentEndpointId) {
        super(type, title, status);
        this.paymentEndpointId = Objects.requireNonNull(paymentEndpointId, "paymentEndpointId must not be null!");
    }

    public PaymentEndpointProblem(URI type, String title, StatusType status, String detail,
        PaymentEndpointId paymentEndpointId) {
        super(type, title, status, detail);
        this.paymentEndpointId = Objects.requireNonNull(paymentEndpointId, "paymentEndpointId must not be null!");
    }

    /**
     * The {@link PaymentEndpointId} of the paymentEndpoint that threw this exception.
     */
    public PaymentEndpointId getPaymentEndpointId() {
        return paymentEndpointId;
    }

}
