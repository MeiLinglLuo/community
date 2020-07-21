package life.majiang.community.controller;


import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("17ee172d255f8b99b3c9");
        accessTokenDTO.setClient_secret("89d891813de25f858be4b88af2ac4c3989ff61b3");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);

        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }


}
