package com.operations.resources;

import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;


public class TestStringOperationResource {

    private StringOperationResource resource;

    @Before
    public void setupResource() {
        resource = new StringOperationResource();
    }

    @Test
    public void testPingReturnsPlainTextOKAsResponse() {
        // Expected results
        String expectedResponse = "OK";

        //Run the required method
        String result = resource.sayOk();

        // Compare result
        assertEquals(expectedResponse,result);
    }

    @Test
    public void testReverseStringWithValidStringAndValidResponse() {

        // Preparing Input
        String queryString = "string";

        // Expected results
        String expectedResponse = "gnirts";

        //Run the required method
        String result = resource.stringReversal(queryString);

        // Compare result
        assertEquals(expectedResponse,result);
    }

    @Test
    public void testReverseStringWithNullStringShouldReturnNotAcceptable() {
       // Preparing Input
        String queryString = null;

        // Expected results
        String expectedResponse = Response.Status.NOT_ACCEPTABLE.toString();


        //Run the required method
        String result = resource.stringReversal(queryString);

        // Compare result
        assertEquals(expectedResponse,result);
    }

    @Test
    public void testWordsReversalInASentenceWithValidStringAndValidResponse() {

        // Preparing Input
        String queryString = "the quick brown fox jumps over the lazy dog, and the dog did nothing.";

        // Expected results
        String expectedResponse = "eht kciuq nworb xof spmuj revo eht yzal ,god dna eht god did .gnihton";

        //Run the required method
        String result = resource.wordsReversalInASentence(queryString);

        // Compare result
        assertEquals(expectedResponse,result);
    }


    @Test
    public void testWordsReversalInASentenceWithNullStringShouldReturnNotAcceptable() {
       // Preparing Input
        String queryString = null;

        // Expected results
        String expectedResponse = Response.Status.NOT_ACCEPTABLE.toString();

        //Run the required method
        String result = resource.wordsReversalInASentence(queryString);

        // Compare result
        assertEquals(expectedResponse,result);
    }

}