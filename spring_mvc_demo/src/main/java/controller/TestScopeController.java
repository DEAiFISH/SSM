package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域共享数据
         * View：实现逻辑视图实现页面的跳转
         */
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //向请求域共享数据
        modelAndView.addObject("testRequestScope", "hello,ModelAndView");
        //设置实现逻辑视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,Model");

        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");

        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello,Map");

        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {

        session.setAttribute("testSessionScope", "hello,Session");

        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {

        ServletContext servletContext = session.getServletContext();

        servletContext.setAttribute("testApplicationScope", "hello,Application");

        return "success";
    }
}
