package com.works.restcontrollers;

import com.works.props.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class UserRestController {

    @PostMapping("/save")
    public Map save(@RequestBody User user) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("user", user);
        return hm;
    }


}
