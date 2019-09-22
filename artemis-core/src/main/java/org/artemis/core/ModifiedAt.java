package org.artemis.core;

import java.time.Instant;

public interface ModifiedAt {

    /**
     * The date/time this Account was last modified.
     *
     * @return An {@link Instant}.
     */
    default Instant modifiedAt() {
        return Instant.now();
    }
}
