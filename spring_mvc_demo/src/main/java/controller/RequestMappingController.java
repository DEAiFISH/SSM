package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.DocFlavor;

@Controller
@RequestMapping({"/test"})
public class RequestMappingController {

    @RequestMapping({"/hello","/234"})
    public String hello(){
        return "success";
    }

    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id = " + id);
        return "success";
    }
}
