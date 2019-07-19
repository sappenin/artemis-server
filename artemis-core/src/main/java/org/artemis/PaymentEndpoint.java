package org.artemis;

import org.immutables.value.Value.Immutable;

/**
 * <p>A restricted-profile `https://` URL that can be resolved to provide information useful for describing a payment
 * endpoint.</p>
 *
 * <p>Note that this URL is a restricted profile of the data allowed in a full https URL. Whereas the nomarl URL syntax
 * supports an `authority`, the payment pointer syntax only supports a host which excludes the `userinfo` and `port`.
 * The payment pointer syntax also excludes the query and fragment parts that are allowed in the URL syntax.</p>
 */

// TODO: DELETE ME?
public interface PaymentEndpoint {

    @Immutable
    class AbstractPaymentEndpoint implements PaymentEndpoint {

//        @Check
//        private void validate() {
//
//        }
    }

}
