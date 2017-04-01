package com.operations.api;


import com.operations.resources.StringOperationResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class TestStringOperationResourceEndpoint {
    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new StringOperationResource())
            .build();

    @Test
    public void testPingReturnsPlainTextOKAsResponse() throws IOException {

        // Expected results
        String expected = "OK";

        //Run the required method
        Response actual = resources.client().target("/ping")
                .request().get();

        // Compare result
        assertEquals(expected,actual.readEntity(String.class));
    }

    @Test
    public void testReverseStringWithValidStringAndValidResponse() {

        // Preparing Input
        final String requestURI = "/reverse/string?str=string";

        // Expected results
        String expectedResponse = "gnirts";

        //Run the required method
        Response response = resources.client().target(requestURI).request().get();
        String actual = response.readEntity(String.class);

        // Compare result
        assertEquals(expectedResponse,actual);
    }

    @Test
    public void testReverseStringWithNullStringShouldReturnNotAcceptable() {

        // Preparing Input
        final String requestURI = "/reverse/string?";

        // Expected results
        String expectedResponse = Response.Status.NOT_ACCEPTABLE.toString();

        //Run the required method
        Response response = resources.client().target(requestURI).request().get();
        String actual = response.readEntity(String.class);

        // Compare result
        assertEquals(expectedResponse,actual);
    }

    @Test
    public void testWordsReversalInASentenceWithValidStringAndValidResponse() {

        // Preparing Input
        final String requestURI = "/reverse/words?str=the%20quick%20brown%20fox%20jumps%20over%20the%20lazy%20dog,%20and%20the%20dog%20did%20nothing.";

        // Expected results
        String expectedResponse = "eht kciuq nworb xof spmuj revo eht yzal ,god dna eht god did .gnihton";

        //Run the required method
        Response response = resources.client().target(requestURI).request().get();
        String actual = response.readEntity(String.class);

        // Compare result
        assertEquals(expectedResponse,actual);
    }

    @Test
    public void testWordsReversalInASentenceWithNullStringShouldReturnNotAcceptable() {

        // Preparing Input
        final String requestURI = "/reverse/words?";

        // Expected results
        String expectedResponse = Response.Status.NOT_ACCEPTABLE.toString();

        //Run the required method
        Response response = resources.client().target(requestURI).request().get();
        String actual = response.readEntity(String.class);

        // Compare result
        assertEquals(expectedResponse,actual);
    }
}