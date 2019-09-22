package org.artemis.problems;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * The root class for all Problems that this Artemis might emit.
 */
public class AbstractArtemisProblem extends AbstractThrowableProblem {

    // TODO: Make this url configurable? On the one hand this could be configurable by each artemis operator. On the
    //  other hand, it could simply set by us, and then anytime someone encounters this error, the information will be
    //  consistent and hosted by us.
    // Use a sub-domain to avoid accidentally DOSing the root domain.
    public static final String TYPE_PREFIX = "https://errors.artemis.org";

    protected AbstractArtemisProblem() {
        super();
    }

    protected AbstractArtemisProblem(@Nullable URI type) {
        super(type);
    }

    protected AbstractArtemisProblem(@Nullable URI type, @Nullable String title) {
        super(type, title);
    }

    protected AbstractArtemisProblem(@Nullable URI type, @Nullable String title, @Nullable StatusType status) {
        super(type, title, status);
    }

    protected AbstractArtemisProblem(
        @Nullable URI type, @Nullable String title, @Nullable StatusType status, @Nullable String detail) {
        super(type, title, status, detail);
    }

    protected AbstractArtemisProblem(
        @Nullable URI type,
        @Nullable String title, @Nullable StatusType status, @Nullable String detail, @Nullable URI instance) {
        super(type, title, status, detail, instance);
    }

    protected AbstractArtemisProblem(
        @Nullable URI type,
        @Nullable String title,
        @Nullable StatusType status, @Nullable String detail, @Nullable URI instance,
        @Nullable ThrowableProblem cause) {
        super(type, title, status, detail, instance, cause);
    }

    protected AbstractArtemisProblem(
        @Nullable URI type,
        @Nullable String title,
        @Nullable StatusType status,
        @Nullable String detail,
        @Nullable URI instance, @Nullable ThrowableProblem cause, @Nullable Map<String, Object> parameters) {
        super(type, title, status, detail, instance, cause, parameters);
    }
}
