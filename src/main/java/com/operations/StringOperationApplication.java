package com.operations;

import com.operations.resources.StringOperationResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class StringOperationApplication extends Application<StringOperationConfiguration>{

    public static void main(final String[] args) throws Exception {
        new StringOperationApplication().run(args);
    }

    @Override
    public String getName() {
        return "stringOperationApplication";
    }

    @Override
    public void initialize(final Bootstrap<StringOperationConfiguration> bootstrap) {

    }

    @Override
    public void run(final StringOperationConfiguration configuration,
                    final Environment environment) {
        final StringOperationResource resource = new StringOperationResource();
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "GET");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        environment.jersey().register(resource);
    }
}