package io.antelope.javasdk.models.rpcProvider.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import io.antelope.javasdk.models.rpcProvider.request.GetRequiredKeysRequest;

/**
 * The response of getRequiredKeys() RPC call {@link io.antelope.javasdk.interfaces.IRPCProvider#getRequiredKeys(GetRequiredKeysRequest)}
 */
public class GetRequiredKeysResponse {

    /**
     * The required public EOSIO keys to sign the transaction. It gets assigned to {@link
     * io.antelope.javasdk.models.signatureProvider.EosioTransactionSignatureRequest#setSigningPublicKeys(List)},
     * which is passed to a Signature Provider to sign a transaction.
     */
    @SerializedName("required_keys")
    private List<String> requiredKeys;

    /**
     * Gets the required public EOSIO keys to sign the transaction. It gets assigned to {@link
     * io.antelope.javasdk.models.signatureProvider.EosioTransactionSignatureRequest#setSigningPublicKeys(List)},
     * which is passed to a Signature Provider to sign a transaction.
     * @return The required public EOSIO keys.
     */
    public List<String> getRequiredKeys() {
        return requiredKeys;
    }
}
