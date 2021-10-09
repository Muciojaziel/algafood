package com.algaworks.algafood.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

@Component
public class TesteHttpUtilService {
    public ResponseEntity<?> testar(){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://demo1888046.mockable.io/"))
                .build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, bodyHandler);
        future.thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        return ResponseEntity.ok().body(future);
    }
}
