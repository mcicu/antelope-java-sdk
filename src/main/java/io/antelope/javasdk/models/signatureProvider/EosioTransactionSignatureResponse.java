package io.antelope.javasdk.models.signatureProvider;

import java.util.List;
import io.antelope.javasdk.error.signatureProvider.SignatureProviderError;
import io.antelope.javasdk.models.rpcProvider.ContextFreeData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The response object returned from the SignatureProvider after the transaction has been signed.
 */
public class EosioTransactionSignatureResponse {

    /**
     * The serialized (Hex) version of {@link io.antelope.javasdk.models.rpcProvider.Transaction}.
     * <br>
     * It is the result of {@link io.antelope.javasdk.interfaces.ISerializationProvider#serializeTransaction(String)}
     * <br>
     * The transaction could have been modified by the signature provider.
     * <br>
     * If signature provider modifies the serialized transaction returned in the response {@link
     * EosioTransactionSignatureResponse#getSerializedTransaction()} but {@link
     * EosioTransactionSignatureRequest#isModifiable()} is false then {@link
     * io.antelope.javasdk.error.session.TransactionGetSignatureNotAllowModifyTransactionError} will
     * be thrown
     */
    @NotNull
    private String serializedTransaction;

    /**
     * The serialized (Hex) version of {@link io.antelope.javasdk.models.rpcProvider.ContextFreeData}.
     * <br>
     * It is the result of {@link ContextFreeData#getSerialized()}
     */
    @NotNull
    private String serializedContextFreeData;

    /**
     * The signatures that are signed by private keys of {@link EosioTransactionSignatureRequest#getSigningPublicKeys()}
     */
    @NotNull
    private List<String> signatures;

    /**
     * The error that occurred during signing.
     */
    @Nullable
    private SignatureProviderError error;

    public EosioTransactionSignatureResponse(@NotNull String serializedTransaction, @NotNull String serializedContextFreeData,
            @NotNull List<String> signatures, @Nullable SignatureProviderError error) {
        this.serializedTransaction = serializedTransaction;
        this.serializedContextFreeData = serializedContextFreeData;
        this.signatures = signatures;
        this.error = error;
    }

    public EosioTransactionSignatureResponse(@NotNull String serializedTransaction,
            @NotNull List<String> signatures, @Nullable SignatureProviderError error) {
        this(serializedTransaction, "", signatures, error);
    }

    /**
     * Gets the serialized transaction.
     *
     * @return the serialize transaction
     */
    @NotNull
    public String getSerializedTransaction() {
        return serializedTransaction;
    }

    /**
     * Gets signatures.
     *
     * @return the signatures
     */
    @NotNull
    public List<String> getSignatures() {
        return signatures;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    @Nullable
    public SignatureProviderError getError() {
        return error;
    }

    /**
     * Gets serialized context free data.
     *
     * @return the serialized context free data
     */
    @NotNull
    public String getSerializedContextFreeData() { return serializedContextFreeData; }
}
