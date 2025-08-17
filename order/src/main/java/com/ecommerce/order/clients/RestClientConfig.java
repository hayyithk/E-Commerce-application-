package com.ecommerce.order.clients;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.propagation.Propagator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

//    This helps collect metrics and trace data.
    @Autowired(required = false)
    private ObservationRegistry observationRegistry;

//    tracer which captures the span and trace ID.
    @Autowired(required = false)
    private Tracer tracer;

//propagator which will ensure that or which injects the trace context headers into outgoing HTTP request.
    @Autowired(required = false)
    private Propagator propagator;

    @Bean
    @LoadBalanced
    public RestClient.Builder restClientBuilder(){
        RestClient.Builder builder = RestClient.builder();

        if(observationRegistry != null){
            builder.requestInterceptor(createTracingInterceptor());
        }
        return builder;
    }

    private ClientHttpRequestInterceptor createTracingInterceptor() {

        return ((request, body, execution) -> {
            if(tracer != null && propagator != null && tracer.currentSpan() != null){
                propagator.inject(tracer.currentTraceContext().context(),
                        request.getHeaders(),
                        (carrier, key, value) -> carrier.add(key, value));
            }
            return execution.execute(request, body);
        }
        );
    }


}
