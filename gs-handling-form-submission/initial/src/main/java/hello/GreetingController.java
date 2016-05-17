package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.ModelMap;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    /**
     * @RestController
     * 获取 json 数据
     * @param name
     * @return model
     */
    @RequestMapping("/api/test2.json")
    public @ResponseBody ModelMap greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ModelMap model = new ModelMap();
        System.out.println("hello");
        System.out.println("value " + name);
        model.addAttribute("value", name);
        return model;
    }

    /**
     * @Controller
     * 发送 form 数据
     * @param greeting
     * @return String
     */
    @RequestMapping(value="/api/test.form", method=RequestMethod.POST)
    public @ResponseBody String printForm(Greeting greeting) {
        System.out.println("Hello, greeting form");
        System.out.println(greeting.getContent());
        System.out.println(greeting.getId());
        String result = "id=" + greeting.getId() + "&content=" + greeting.getContent();
        System.out.println(result);
        return result;
    }

    /**
     * @Controller
     * 发送 json 数据
     * @param model
     * @return ModalMap
     */
    @RequestMapping(value="/api/test.json")
    public @ResponseBody ModelMap printJson(@RequestBody ModelMap model) {
        System.out.println("Hello, model");
        System.out.println(model);
        return model;
    }

}
