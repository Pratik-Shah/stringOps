package com.operations.resources;

import com.codahale.metrics.annotation.Timed;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class StringOperationResource {

    private static final Log logger = LogFactory.getLog(StringOperationResource.class);

    public StringOperationResource() {
    }

    @GET
    @Timed
    @Path("/ping")
    public String sayOk() {
        return "OK";
    }

    @GET
    @Timed
    @Path("/reverse/string")
    public String stringReversal(@QueryParam("str") String str) {

        if(str==null ){
            logger.error("Null String provided.");
            return Response.Status.NOT_ACCEPTABLE.toString();
        }
        else if( str.equals("")){
            logger.info("Blank String provided.");
            return str;
        }

        String reversedString= new StringBuilder(str).reverse().toString();
        logger.info("Reversed string : "+ reversedString +" for the orginal string : " +str);

        return reversedString;
    }

    @GET
    @Timed
    @Path("/reverse/words")
    public String wordsReversalInASentence(@QueryParam("str") String str) {

        if(str==null ){
            logger.error("Null String provided.");
            return Response.Status.NOT_ACCEPTABLE.toString();
        }
        else if( str.equals("")){
            logger.info("Blank String provided.");
           return str;
        }

        String sentence= new StringBuilder(str).toString();
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder =new StringBuilder();
        String reversedString;
        for (String word:words) {
            stringBuilder.append(stringReversal(word)).append(' ');
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        reversedString= stringBuilder.toString();
        logger.info("Reversed string of words: "+ reversedString +" for the orginal sentence : " +str);

        return reversedString;
    }
}