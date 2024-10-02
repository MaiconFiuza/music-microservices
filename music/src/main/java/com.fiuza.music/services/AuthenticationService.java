package com.fiuza.music.services;

import com.fiuza.music.dtos.AuthenticationTokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "authentication", url = "http://localhost:8082/")
public interface AuthenticationService {

    @GetMapping("/authentication")
    AuthenticationTokenDTO getAuthenticationToken();
}
