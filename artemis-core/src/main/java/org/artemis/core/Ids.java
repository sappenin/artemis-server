package org.artemis.core;

import org.interledger.core.Wrapped;
import org.interledger.core.Wrapper;

import org.immutables.value.Value;

/**
 * Wrapped immutable classes for providing type-safe identifiers.
 */
public class Ids {

    @Value.Immutable
    @Wrapped
    static abstract class _UserId extends Wrapper<String> {

    }

    @Value.Immutable
    @Wrapped
    static abstract class _AccountId extends Wrapper<String> {

    }

    @Value.Immutable
    @Wrapped
    static abstract class _PaymentEndpointId extends Wrapper<String> {

    }

}
