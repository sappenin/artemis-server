package org.artemis.services;

import org.interledger.core.InterledgerAddress;
import org.interledger.link.Link;

/**
 * Artemis always obtains its ILP Address from its parent ILP uplink using IL-DCP.
 *
 * @see "https://github.com/interledger/rfcs/blob/master/0031-dynamic-configuration-protocol/0031-dynamic-configuration-protocol.md"
 */
public interface ArtemisIldcpService {

    /**
     * Accessor for this server's primary ILP address.
     *
     * @return An {@link InterledgerAddress} that is supplied by the upstream parent link, or {@link Link#SELF} if
     *     IL-DCP has not yet been performed.
     */
    default InterledgerAddress artemisInterledgerAddress() {
        return Link.SELF;
    }

}
