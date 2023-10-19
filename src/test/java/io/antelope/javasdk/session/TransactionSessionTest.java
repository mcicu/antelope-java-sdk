package io.antelope.javasdk.session;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import io.antelope.javasdk.interfaces.IABIProvider;
import io.antelope.javasdk.interfaces.IRPCProvider;
import io.antelope.javasdk.interfaces.ISerializationProvider;
import io.antelope.javasdk.interfaces.ISignatureProvider;
import org.junit.Before;
import org.junit.Test;

public class TransactionSessionTest {

    private TransactionSession session;

    @Before
    public void setUpTransactionSession() {
        this.session = new TransactionSession(
                mock(ISerializationProvider.class),
                mock(IRPCProvider.class),
                mock(IABIProvider.class),
                mock(ISignatureProvider.class));
    }

    @Test
    public void getTransactionProcessor() {
        TransactionProcessor processor = this.session.getTransactionProcessor();
        assertNotNull(processor);
    }

    @Test
    public void getSerializationProvider() {
        assertNotNull(this.session.getSerializationProvider());
    }

    @Test
    public void getRpcProvider() {
        assertNotNull(this.session.getRpcProvider());
    }

    @Test
    public void getAbiProvider() {
        assertNotNull(this.session.getAbiProvider());
    }

    @Test
    public void getSignatureProvider() {
        assertNotNull(this.session.getSignatureProvider());
    }
}
