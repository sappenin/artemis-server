package org.artemis.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.primitives.UnsignedLong;
import org.immutables.value.Value.Default;

/**
 * Information required to forward value from an Artemis-hosted account onward.
 */
public interface ForwardingInfo {

    /**
     * The amount at which a payout to the forwarding address (when it's online) will be triggered.
     *
     * @return
     */
    @JsonProperty("forwarding_threshold")
    @Default
    default UnsignedLong threshold() {
        return UnsignedLong.valueOf(100L);
    }

    /**
     * The forwarding address that any payments should be auto-forwarded to.
     *
     * @return A {@link String} containing the address to forward incoming value to.
     */
    @JsonProperty("forwarding_address")
    String forwardingAddress();

    /**
     * The type of the forwarding address.
     *
     * @return A {@link ForwardingAddressType} of the forwarding/forwarding address.
     */
    @JsonProperty("forwarding_address_type")
    ForwardingAddressType forwardingType();
}
