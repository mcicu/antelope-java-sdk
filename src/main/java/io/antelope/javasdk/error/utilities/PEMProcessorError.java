package io.antelope.javasdk.error.utilities;

import io.antelope.javasdk.error.EosioError;
import org.jetbrains.annotations.NotNull;

/**
 * Error that originates from the {@link io.antelope.javasdk.utilities.PEMProcessor} class.
 */
public class PEMProcessorError extends EosioError {

    public PEMProcessorError() {
    }

    public PEMProcessorError(@NotNull String message) {
        super(message);
    }

    public PEMProcessorError(@NotNull String message,
            @NotNull Exception exception) {
        super(message, exception);
    }

    public PEMProcessorError(@NotNull Exception exception) {
        super(exception);
    }
}
