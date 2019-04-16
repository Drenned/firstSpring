package hello.controller;

import hello.model.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegestrationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/regestration")
    public String regestration(Map<String, Object> model)
    {
        return "regestration";
    }

    @PostMapping("/regestration")
    public String addUser(@RequestParam String name,
                          @RequestParam String password,
                          Map<String, Object> model)
    {
        User userFromDb = userRepository.findUserByName(name);

        if (userFromDb==null)
        {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setActive(true);
            user.setEmail("Что то");
            userRepository.save(user);
            model.put("user", user);
        }
        else
        {
            model.put("message", "Юзер занят");
            return "regestration";
        }
        return "redirect:/login";
    }


}
