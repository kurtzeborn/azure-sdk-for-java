// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.implementation.util;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Code snippets for {@link FluxUtil}
 */
public class FluxUtilJavaDocCodeSnippets {

    /**
     * Code snippet for using {@link FluxUtil} with single item response
     */
    public void codeSnippetForCallWithSingleResponse() {
        // BEGIN: com.azure.core.implementation.util.fluxutil.withcontext
        String prefix = "Hello, ";
        Mono<String> response = FluxUtil
            .withContext(context -> serviceCallReturnsSingle(prefix, context));
        // END: com.azure.core.implementation.util.fluxutil.withcontext
    }

    /**
     * Code snippet for using {@link FluxUtil} with collection response
     */
    public void codeSnippetForCallWithCollectionResponse() {
        // BEGIN: com.azure.core.implementation.util.fluxutil.fluxcontext
        String prefix = "Hello, ";
        Flux<String> response = FluxUtil
            .fluxContext(context -> serviceCallReturnsCollection(prefix, context));
        // END: com.azure.core.implementation.util.fluxutil.fluxcontext
    }

    /**
     * Implementation not provided
     * @param prefix The prefix
     * @param context Azure context
     * @return {@link Flux#empty() empty} response
     */
    private Flux<String> serviceCallReturnsCollection(String prefix, Context context) {
        return Flux.empty();
    }

    /**
     * Implementation not provided
     * @param prefix The prefix
     * @param context Azure context
     * @return {@link Mono#empty() empty} response
     */
    private Mono<String> serviceCallReturnsSingle(String prefix, Context context) {
        return Mono.empty();
    }

    /**
     * Implementation not provided
     * @param value The value
     * @return A {@link Mono} containing a {@link Response} containing a {@link Response#value() value}.
     */
    private <T> Mono<Response<T>> getMonoRestResponse(T value) {
        Response<T> response = new Response<T>() {
            @Override
            public int statusCode() {
                return 200;
            }

            @Override
            public HttpHeaders headers() {
                return null;
            }

            @Override
            public HttpRequest request() {
                return null;
            }

            @Override
            public T value() {
                return value;
            }
        };
        return Mono.just(response);
    }
}
