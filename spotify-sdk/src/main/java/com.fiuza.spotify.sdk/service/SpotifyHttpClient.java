package com.fiuza.spotify.sdk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiuza.spotify.sdk.entities.CreateApiResponse;
import com.fiuza.spotify.sdk.entities.SpotifyArtist;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SpotifyHttpClient {

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private ObjectMapper objectMapper;

    private Dotenv dotenv = Dotenv.load();

    public CreateApiResponse authOptions()  {
        try {
            String clientId = dotenv.get("CLIENT_ID");
            String secret = dotenv.get("SECRET");
            String grantType = "client_credentials";
            String uri = "token";


            Mono<String> result = httpClient.performPostRequestLogin(uri,clientId,secret, grantType);

            return result
                    .map(json -> {
                        try {
                            return objectMapper.readValue(json, CreateApiResponse.class);
                        } catch (Exception e) {
                            throw new RuntimeException("Erro ao converter JSON", e);
                        }
                    })
                    .block();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public SpotifyArtist getArtist(String name, String authorization) {
        try {
            String formattedAuthorization = "Bearer "+authorization;
            String composedUrl = "https://api.spotify.com/v1/search?q="+name+"&type=artist";

            Mono<String> result = httpClient.performGetRequest(composedUrl, formattedAuthorization);

            return result
                    .map(json -> {
                        try {
                            return objectMapper.readValue(json, SpotifyArtist.class);
                        } catch (Exception e) {
                            throw new RuntimeException("Erro ao converter JSON", e);
                        }
                    })
                    .block();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}
