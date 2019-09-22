package org.artemis.services;

import org.artemis.core.AccountId;
import org.artemis.core.PaymentEndpoint;
import org.artemis.problems.PaymentEndpointNotFoundProblem;

import java.util.Collection;

/**
 * Defines operations for payment endpoints.
 */
public interface PaymentEndpointsService {

    /**
     * Obtain all payment endpoints for the specified Account.
     *
     * @param accountId An {@link AccountId} that uniquely identifies the account to return endpoints for.
     *
     * @return A {@lin Collection} of type {@link PaymentEndpoint}.
     */
    Collection<PaymentEndpoint> getEndpointsForAccount(AccountId accountId);

    /**
     * Find the Payment Endpoint for the specified {@code spspPath}.
     *
     * @param spspPath The SPSP path that was queried (maps to the Payment pointer's `path-abempty` field in the
     *                 PaymentPointer ABNF.
     *
     * @return A {@link PaymentEndpoint}, if it exists.
     *
     * @throws PaymentEndpointNotFoundProblem if no Payment Endpoint is found with the supplied {@code spspPath}.
     */
    PaymentEndpoint getEndpointBySpspPath(String spspPath);

    // getPaymentEndpoint(paymentEndpointId)
    // createPaymentEndpoint()
    // disablePaymentEndpoint(paymentEndpointId)
    // deletePaymentEndpoint(paymentEndpointId)
    // updatePaymentEndpoint(paymentEndpointId)

}
