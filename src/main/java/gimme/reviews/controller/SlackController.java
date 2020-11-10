package gimme.reviews.controller;

import com.slack.api.model.event.MessageEvent;
import gimme.reviews.model.Review;
import gimme.reviews.model.SlackMessage;
import gimme.reviews.service.MessageHandleService;
import gimme.reviews.service.PostMessageService;
import gimme.reviews.service.ReviewService;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@EnableWebMvc
public class SlackController {

    private final MessageHandleService messageHandleService;

    final String URL_VERIFICATION = "url_verification";

    @Autowired
    public SlackController(MessageHandleService messageHandleService) {
        this.messageHandleService = messageHandleService;
    }

    @RequestMapping(path = "/slack", method = RequestMethod.POST)
    public Map<String, String> getMessage(@RequestBody SlackMessage slackMessage) {
        Map<String, String> response = new HashMap<>();
        System.out.println(slackMessage.toString());
        // TODO: Figure out Spring authentication middleware
        if (slackMessage.getType().equals(URL_VERIFICATION)) {
            String challenge = slackMessage.getChallenge();
            response.put("challenge", challenge);
            return response;
        }

        //ToDo handle verification through signing token
        //https://medium.com/slack-developer-blog/tutorial-developing-an-action-able-app-4d5455d585b6#4744


        //TODO: Optionals or Else return
        Optional.of(slackMessage.getEvent())
                .ifPresentOrElse(event -> {
                            try {
                                messageHandleService.handleEvent(event);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        },
                        new Runnable() {
                            @Override
                            public void run() {
                                response.put("error", "No event found");
                            }
                        });

        return response;
    }

}
