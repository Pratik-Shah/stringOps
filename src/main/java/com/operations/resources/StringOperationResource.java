package com.operations.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class StringOperationResource {

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
            return Response.Status.NOT_ACCEPTABLE.toString();
        }
        else if( str.equals("")){
            return str;
        }

        String reversedString= new StringBuilder(str).reverse().toString();

        return reversedString;
    }

    @GET
    @Timed
    @Path("/reverse/words")
    public String wordsReversalInASentence(@QueryParam("str") String str) {

        if(str==null ){
            return Response.Status.NOT_ACCEPTABLE.toString();
        }
        else if( str.equals("")){
           return str;
        }

        String sentence= new StringBuilder(str).toString();
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder =new StringBuilder();
        for (String word:words) {
            stringBuilder.append(stringReversal(word)).append(' ');
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}