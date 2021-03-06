package com.lake.smartway.jwt.controller;

import com.lake.smartway.jwt.service.SecurityService;
import com.lake.smartway.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/homeController")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SecurityService securityService;

    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject){
        logger.debug("JWT Generate Token");
        String token = securityService.createToken(subject, 1000 * 60 * 60);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", subject);
        map.put("token", token);

        return map;
    }

    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token){
        logger.debug("Check Invalid JWT Token");
        String subject = securityService.getSubejct(token);
        return subject;
    }

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String, String> home(){
        logger.debug("HomeController Message");
        Map<String, String> res = this.userService.getMessage();

        return res;
    }
}
