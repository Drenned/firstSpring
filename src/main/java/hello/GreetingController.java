package hello;

import hello.repository.UserRepository;
import hello.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> map) {
        map.put("name", name);
        return "greeting";
    }

    @GetMapping("/add")
    public String addUser(@RequestParam String name,
                                        @RequestParam String email,
                                        Map<String, Object> model)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        model.put("user", user);
        return "Saved";
    }

    @GetMapping("/all")
    public
    String getAllUser(Map<String,Object> model)
    {
        Iterable<User> users=userRepository.findAll();
        model.put("users",users);
        return "all";
    }

    @GetMapping
    public String main(Map<String, Object> map)
    {
        return "index";
    }

}