package io.antelope.javasdk.models;

import java.util.ArrayList;
import io.antelope.javasdk.models.signatureProvider.BinaryAbi;
import io.antelope.javasdk.models.signatureProvider.EosioTransactionSignatureRequest;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class EosioTransactionSignatureRequestTest {
    EosioTransactionSignatureRequest request;

    public void setup() {
        this.setup(null);
    }

    public void setup(String contextFreeData) {
        if (contextFreeData == null) {
            request = new EosioTransactionSignatureRequest("", new ArrayList<String>(), "", new ArrayList<BinaryAbi>(), false);
        } else {
            request = new EosioTransactionSignatureRequest("", new ArrayList<String>(), "", new ArrayList<BinaryAbi>(), false, contextFreeData);
        }
    }

    @Test
    public void testCreateWithoutContextFreeDataSetsTo32Zeros() {
        this.setup();

        assertEquals(request.getSerializedContextFreeData(), Hex.toHexString(new byte[32]));
    }

    @Test
    public void testCreateWithContextFreeDataSetsParameter() {
        String serializedContextFreeData = "6595140530fcbd94469196e5e6d73af65693910df8fcf5d3088c3616bff5ee9f";
        this.setup(serializedContextFreeData);

        assertEquals(request.getSerializedContextFreeData(), serializedContextFreeData);
    }

    @Test
    public void testSetSerializedContextFreeDataWithEmptyStringSetsTo32Zeros() {
        String serializedContextFreeData = Hex.toHexString(new byte[32]);
        this.setup();

        request.setSerializedContextFreeData("");

        assertEquals(request.getSerializedContextFreeData(), serializedContextFreeData);
    }

    @Test
    public void testSetSerializedContextFreeDataWithDataReturnsData() {
        String serializedContextFreeData = "6595140530fcbd94469196e5e6d73af65693910df8fcf5d3088c3616bff5ee9f";
        this.setup();

        request.setSerializedContextFreeData(serializedContextFreeData);

        assertEquals(request.getSerializedContextFreeData(), serializedContextFreeData);
    }
}
