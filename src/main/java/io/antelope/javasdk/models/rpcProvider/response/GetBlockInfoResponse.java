package io.antelope.javasdk.models.rpcProvider.response;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import io.antelope.javasdk.models.rpcProvider.request.GetBlockRequest;

/**
 * The response of getBlockInfo() RPC call {@link io.antelope.javasdk.interfaces.IRPCProvider#getBlockInfo(GetBlockInfoRequest)}
 */
public class GetBlockInfoResponse {

    /**
     * The timestamp for the block from blockchain.
     * <br>
     *     Format: Date/time string in the format YYYY-MM-DDTHH:MM:SS.sss
     */
    @SerializedName("timestamp")
    private String timestamp;

    /**
     * The block producer name.
     */
    @SerializedName("producer")
    private String producer;

    @SerializedName("confirmed")
    private BigInteger confirmed;

    @SerializedName("previous")
    private String previous;

    @SerializedName("transaction_mroot")
    private String transactionMroot;

    @SerializedName("action_mroot")
    private String actionMroot;

    @SerializedName("schedule_version")
    private BigInteger  scheduleVersion;

    @SerializedName("producer_signature")
    private String producerSignature;

    /**
     * The block id
     */
    @SerializedName("id")
    private String id;

    /**
     * The block number. This is used to construct the refBlockNum of
     * {@link io.antelope.javasdk.models.rpcProvider.Transaction}.
     */
    @SerializedName("block_num")
    private BigInteger  blockNum;

    /**
     * The reference block prefix. This is used to construct refBlockPrefix of
     * {@link io.antelope.javasdk.models.rpcProvider.Transaction}.
     */
    @SerializedName("ref_block_prefix")
    private BigInteger  refBlockPrefix;

    /**
     * Gets the timestamp for the block from the blockchain.
     * <br>
     *      Format: Date/time string in the format YYYY-MM-DDTHH:MM:SS.sss.
     *
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Gets the block producer name.
     *
     * @return block producer name
     */
    public String getProducer() {
        return producer;
    }

    public BigInteger getConfirmed() {
        return confirmed;
    }

    public String getPrevious() {
        return previous;
    }

    public String getTransactionMroot() {
        return transactionMroot;
    }

    public String getActionMroot() {
        return actionMroot;
    }

    public BigInteger  getScheduleVersion() {
        return scheduleVersion;
    }

    public String getProducerSignature() {
        return producerSignature;
    }

    /**
     * Gets the block id.
     *
     * @return the block id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the block number. Which is used to construct refBlockNum field of
     * {@link io.antelope.javasdk.models.rpcProvider.Transaction}
     *
     * @return the block number.
     */
    public BigInteger  getBlockNum() {
        return blockNum;
    }

    /**
     * Gets reference block prefix. This is used for refBlockPrefix field of
     * {@link io.antelope.javasdk.models.rpcProvider.Transaction}.
     *
     * @return the ref block prefix
     */
    public BigInteger  getRefBlockPrefix() {
        return refBlockPrefix;
    }
}

