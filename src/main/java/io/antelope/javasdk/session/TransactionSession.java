package io.antelope.javasdk.session;

import io.antelope.javasdk.error.session.TransactionProcessorConstructorInputError;
import io.antelope.javasdk.interfaces.IABIProvider;
import io.antelope.javasdk.interfaces.IRPCProvider;
import io.antelope.javasdk.interfaces.ISerializationProvider;
import io.antelope.javasdk.interfaces.ISignatureProvider;
import io.antelope.javasdk.models.rpcProvider.Transaction;
import org.jetbrains.annotations.NotNull;

/**
 * Transaction Session class has a factory role for creating {@link TransactionProcessor} object from providers instances
 */
public class TransactionSession {

    /**
     * Serialization provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for serialization/deserialization between JSON and Hex for communicate with EOSIO chain
     */
    @NotNull
    private ISerializationProvider serializationProvider;

    /**
     * Rpc provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for communicate with EOSIO chain
     */
    @NotNull
    private IRPCProvider rpcProvider;

    /**
     * ABI Provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for managing ABIs for serialization/deserialization
     */
    @NotNull
    private IABIProvider abiProvider;

    /**
     * Signature provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for managing keys, create signature to make transaction to EOSIO chain
     */
    @NotNull
    private ISignatureProvider signatureProvider;

    /**
     * Initialize TransactionSession object which acts like a factory to create {@link TransactionProcessor} object from providers instances.
     *
     * @param serializationProvider serialization provider.
     * @param rpcProvider Rpc provider.
     * @param abiProvider ABI provider.
     * @param signatureProvider signature provider.
     */
    public TransactionSession(
            @NotNull ISerializationProvider serializationProvider,
            @NotNull IRPCProvider rpcProvider, @NotNull IABIProvider abiProvider,
            @NotNull ISignatureProvider signatureProvider) {
        this.serializationProvider = serializationProvider;
        this.rpcProvider = rpcProvider;
        this.abiProvider = abiProvider;
        this.signatureProvider = signatureProvider;
    }

    /**
     * Create and return a new instance of TransactionProcessor
     *
     * @return new instance of TransactionProcessor
     */
    public TransactionProcessor getTransactionProcessor() {
        return new TransactionProcessor(this.serializationProvider, this.rpcProvider,
                this.abiProvider, this.signatureProvider);
    }

    /**
     * Create and return a new instance of TransactionProcessor with preset transaction
     *
     * @param transaction - preset transaction
     * @return new instance of TransactionProcessor
     * @throws TransactionProcessorConstructorInputError thrown if initializing {@link TransactionProcessor} get error.
     */
    public TransactionProcessor getTransactionProcessor(Transaction transaction) throws TransactionProcessorConstructorInputError {
        return new TransactionProcessor(this.serializationProvider, this.rpcProvider,
                this.abiProvider, this.signatureProvider, transaction);
    }

    //region getters

    /**
     * Get serialization provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for serialization/deserialization between JSON and Hex for communicate with EOSIO chain
     * @return the serialization provider
     */
    @NotNull
    public ISerializationProvider getSerializationProvider() {
        return serializationProvider;
    }

    /**
     * Get rpc provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for communicate with EOSIO chain
     * @return the rpc provider.
     */
    @NotNull
    public IRPCProvider getRpcProvider() {
        return rpcProvider;
    }

    /**
     * Get ABI Provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for managing ABIs for serialization/deserialization
     * @return the rpc provider.
     */
    @NotNull
    public IABIProvider getAbiProvider() {
        return abiProvider;
    }

    /**
     * Get signature provider to be used as a reference on {@link TransactionProcessor} object
     * <br>
     *     Responsible for managing keys, create signature to make transaction to EOSIO chain
     * @return the signature provider.
     */
    @NotNull
    public ISignatureProvider getSignatureProvider() {
        return signatureProvider;
    }
    //endregion
}
