package com.fastcampus.board.service;


import com.fastcampus.board.dto.UserRequest;
import com.fastcampus.board.dto.UserResponse;
import org.junit.runner.Request;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Service
public class RestTemplateService {

    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name", "Daeyong")
                .encode()
                .build()
                .toUri();
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> result;
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse post() {


        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"Navidaeyong")
                .toUri();

        System.out.println(uri);

        UserRequest req = new UserRequest();
        req.setName("steve");
        req.setAge(10);


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

  }

      public UserResponse exchange(){

          URI uri = UriComponentsBuilder
                  .fromUriString("http://localhost:9090")
                  .path("/api/server/user/{userId}/name/{userName}")
                  .encode()
                  .build()
                  .expand(100,"Navidaeyong")
                  .toUri();

          System.out.println(uri);

          UserRequest req = new UserRequest();
          req.setName("steve");
          req.setAge(10);

          RequestEntity<UserRequest> requestEntity = RequestEntity
                  .post(uri)
                  .contentType(MediaType.APPLICATION_JSON)
                  .header("x-authorization","adcd")
                  .header("custom-header","ffff")
                  .body(req);


          RestTemplate restTemplate = new RestTemplate();
          ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity,UserResponse.class);


         return response.getBody();

      }
}