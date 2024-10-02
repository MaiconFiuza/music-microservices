package com.fiuza.spotify.sdk.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpClient {


    WebClient clientAuth = WebClient.create("https://accounts.spotify.com/api/");
    WebClient client = WebClient.create("https://api.spotify.com/v1/");

    public Mono<String> performGetRequest(String uri, String authorization) {
        return client.get()
                .uri(uri)
                .header("Authorization", authorization)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Erro 4xx"))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Erro 5xx"))
                )
                .bodyToMono(String.class);

    }


    public Mono<String> performPostRequestLogin(String uri, String clientId, String secret, String grantType) {
        return clientAuth.post()
                .uri(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body(BodyInserters.fromFormData("grant_type", grantType)
                        .with("client_id", clientId)
                        .with("client_secret", secret)
                )
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Erro 4xx"))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Erro 5xx"))
                )
                .bodyToMono(String.class);
    }

    public Mono<String> performPostRequest(String uri, String body) {
        return client.post()
                .uri(uri)
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Erro 4xx"))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        response -> Mono.error(new RuntimeException("Erro 5xx"))
                )
                .bodyToMono(String.class);
    }

}
