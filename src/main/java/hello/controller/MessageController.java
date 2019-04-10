package hello.controller;

import hello.repository.MessageRepository;
import hello.user.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class MessageController {

    @Autowired
    MessageRepository messageRepository;


    @PostMapping("addMessages")
    public String addMessages(@RequestParam String text, @RequestParam String tag,
                              Map<String, Object> model)
    {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "messages";
    }

    @GetMapping("/messages")
    public String getAllMessages(Map<String, Object> model)
    {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "messages";
    }
}
