package gimme.reviews.controller;

import gimme.reviews.model.Event;
import gimme.reviews.model.SlackMessage;
import gimme.reviews.service.PostMessageService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableWebMvc
public class SlackController {

    final String URL_VERIFICATION = "url_verification";

    @RequestMapping(path = "/slack", method = RequestMethod.POST)
    public Map<String, String> getMessage(@RequestBody SlackMessage slackMessage) {
        Map<String, String> response = new HashMap<>();

        if (slackMessage.getType().equals(URL_VERIFICATION)) {
            String challenge = slackMessage.getChallenge();
            response.put("challenge", challenge);
        }

        //ToDo handle verification through signing token
        //https://medium.com/slack-developer-blog/tutorial-developing-an-action-able-app-4d5455d585b6#4744

        Event event = slackMessage.getEvent();

        PostMessageService postMessageService = new PostMessageService();
        postMessageService.sendResponseMessage("smth");

        System.out.println(slackMessage.toString());
        return response;
    }

}
