package org.artemis.core;

import org.interledger.core.InterledgerAddress;

import org.immutables.value.Value.Immutable;

import java.util.Optional;

/**
 * <p>Defines how payments can be received by Artemis.</p>
 */
@Immutable
public interface PaymentEndpoint extends CreatedAt, ModifiedAt {

    /**
     * The public-facing identifier of this {@link PaymentEndpoint}.
     *
     * @return A {@link PaymentEndpointId}.
     */
    PaymentEndpointId paymentEndpointId();

    /**
     * A unique identifier of this payment endpoint that can be appended to an Artemis ILP address in order to allow
     * payment endpoints to receive funds.
     *
     * @return An {@link String}.
     */
    String interledgerAddressSuffix();

    /**
     * The user-facing identifier for this payment endpoints. E.g., "bob" would correlate to `https://{host}/bob`.
     * "/spsp/bob" would correlate to `https://{host}/spsp/bob`. Note that this value is not directly appended to the
     * endpoint's ILP address because characters that are allowed in a URL are not necessarily allowed in an {@link
     * InterledgerAddress}.
     *
     * @return
     */
    String spspPath();

    /**
     * Optionally-present information required to forward a payment. If no forwarding information is present, then
     * payments to this endpoint are not forwarded, but instead accrue inside of Artemis.
     *
     * @return An optionally-present {@link ForwardingInfo}.
     */
    Optional<ForwardingInfo> forwardingInfo();

}
