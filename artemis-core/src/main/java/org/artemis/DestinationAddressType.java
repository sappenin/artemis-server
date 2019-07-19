package org.artemis;

/**
 * Defines the type of system that an Artemis record forwards to.
 */
public enum DestinationAddressType {

    /**
     * Allows a balance to accrue in Artemis.
     */
    NONE,

    /**
     * The `destination` is another payment pointer
     */
    PAYMENT_POINTER,

    /**
     * The `destination` is another payment pointer
     */
    SPSP_URL,

    /**
     * The `destination` is an XRPL address
     */
    XRPL_ADDRESS,

    /**
     * The `destination` is an RippleNet address
     */
    //RIPPLENET_ADDRESS

}
