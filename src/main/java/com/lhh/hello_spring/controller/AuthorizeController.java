package com.lhh.hello_spring.controller;

import com.lhh.hello_spring.dto.AccessTokenDTO;
import com.lhh.hello_spring.dto.GithubUser;
import com.lhh.hello_spring.provider.GithudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithudProvider githudProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("dd48594715f07aa9a49b");
        accessTokenDTO.setClient_secret("3710c6be1f7622986d6f336766b7922b6a2d7f3f");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:9527/callback");
        accessTokenDTO.setState(state);
        String accessToken = githudProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githudProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
