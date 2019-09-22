package org.artemis.core;

import java.time.Instant;

public interface CreatedAt {

    /**
     * The date/time this Account was created.
     *
     * @return An {@link Instant}.
     */
    default Instant createdAt() {
        return Instant.now();
    }

}
