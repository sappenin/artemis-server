package org.artemis.core;

/**
 * Represents an account owner in Artemis.
 */
public interface User {

    /**
     * The public-facing identifier of this {@link User}.
     *
     * @return A {@link UserId}.
     */
    UserId userId();
}
