package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/test"})
public class RequestMappingController {

    @RequestMapping({"/hello","/234"})
    public String hello(){
        return "success";
    }
}
