package hello.controller;

import hello.repository.UserRepository;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> map) {
        return "greeting";
    }

    @PostMapping("addUser")
    public String addUser(@RequestParam String name,
                                        @RequestParam String email,
                                        Map<String, Object> model)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        model.put("user", user);
        Iterable<User> users=userRepository.findAll();
        model.put("users",users);
        return "main";
    }

    @GetMapping("/all")
    public
    String getAllUser(Map<String,Object> model)
    {
        Iterable<User> users=userRepository.findAll();
        model.put("users",users);
        return "all";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model)
    {
        Iterable<User> users=userRepository.findAll();
        model.put("users",users);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model)
    {
        Iterable<User> users;
        if(filter!=null && !filter.isEmpty())
        {
            users = userRepository.findByName(filter);
        }
        else
        {
            users = userRepository.findAll();
        }
        model.put("users",users);
        return "main";
    }

}