package com.lhh.hello_spring.controller;

import com.lhh.hello_spring.dto.AccessTokenDTO;
import com.lhh.hello_spring.dto.GithubUser;
import com.lhh.hello_spring.provider.GithudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithudProvider githudProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private  String clientSecret;
    @Value("${github.redirect.url}")
    private  String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githudProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githudProvider.getUser(accessToken);
        System.out.println(user.getName());
        if(user != null){
            //登录成功 写cookie 和session
            request.getSession().setAttribute("user",user);

            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }

    }
}
