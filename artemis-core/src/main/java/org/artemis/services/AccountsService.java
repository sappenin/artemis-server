package org.artemis.services;

import org.artemis.core.Account;
import org.artemis.core.PaymentEndpointId;

public interface AccountsService {

    /**
     * Find the Payment Endpoint for the specified {@code spspPath}.
     *
     * @param paymentEndpointId The {@link PaymentEndpointId} of the endpoint to obtain account information for.
     *
     * @return A {@link Account}, if it exists.
     *
     * @throws AccountNotFoundProblem if no Account is found with the supplied {@code paymentEndpointId}.
     */
    Account getAccountForPaymentEndpoint(PaymentEndpointId paymentEndpointId);
}
