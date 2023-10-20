

package io.antelope.javasdk;

import io.antelope.javasdk.error.EosioError;
import io.antelope.javasdk.error.serializationProvider.SerializationProviderError;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class EosioErrorTest {

    @Test
    public void errroMessage() {
        EosioError err = new EosioError("Parsing Error!");
        String description = err.getLocalizedMessage();
        assertEquals("Parsing Error!", description);

        Exception origError = new IOException("File Not Found");
        EosioError err2 = new EosioError(
                "Could not find resource.",
                origError);
        assertEquals("Could not find resource.", err2.getLocalizedMessage());

        assertEquals("File Not Found", err2.getCause().getMessage());
    }

    @Test
    public void asJsonString() {
        String jsonResult = "{\n" +
                "  \"errorType\": \"EosioError\",\n" +
                "  \"errorInfo\": {\n" +
                "    \"errorCode\": \"SerializationProviderError\",\n" +
                "    \"reason\": \"Serialization Provider Failure\"\n" +
                "  }\n" +
                "}";
        SerializationProviderError err2 = new SerializationProviderError("Serialization Provider Failure");
        String errJsonString = err2.asJsonString();
        assertEquals(jsonResult, errJsonString);
    }

}
