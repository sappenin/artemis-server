package org.artemis.core;

/**
 * The types of system that Artemis can forward to.
 */
public enum ForwardingAddressType {

    /**
     * The `destination` is another payment pointer.
     *
     * @see "https://github.com/interledger/rfcs/blob/master/0026-payment-pointers/0026-payment-pointers.md"
     */
    PAYMENT_POINTER,

    /**
     * The `destination` is an SPSP URL.
     *
     * @see "https://github.com/interledger/rfcs/tree/master/0009-simple-payment-setup-protocol"
     */
    SPSP_URL,

    /**
     * The `destination` is an XRPL address.
     *
     * @see "https://xprl.org"
     */
    XRPL_ADDRESS,

    // Future?
    // Bitcoin Address
    // Ether Address
    // Stellar Address
    // RippleNet Address

}
