package gimme.reviews.service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import gimme.reviews.model.Review;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PostMessageService {

    private String token = "xoxb-1467349419936-1452029906275-K8JvcSs016XLwskPxkiPP6Rl";

    public void sendResponseMessage(String errorMessage)  {

        Slack slack = Slack.getInstance();

        // Initialize an API Methods client with the given token
        MethodsClient methods = slack.methods(token);

        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#nothing") // Use a channel ID `C1234567` is preferrable
                .text(errorMessage)
                .build();

        try {
            // Get a response as a Java object
            ChatPostMessageResponse response = methods.chatPostMessage(request);
            System.out.println(response.toString());
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
    }

    public void sendResponseMessage(Review review)  {

        Slack slack = Slack.getInstance();

        // Initialize an API Methods client with the given token
        MethodsClient methods = slack.methods(token);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(":fire: Found reviews for given url! ")
                .append("Reviews: ").append(review.getReview()).append(" ")
                .append("Rating: ").append(review.getRating());

        // Build a request object
        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel("#nothing") // Use a channel ID `C1234567` is preferrable
                .text(stringBuilder.toString())
                .build();

        try {
            // Get a response as a Java object
            ChatPostMessageResponse response = methods.chatPostMessage(request);
            System.out.println(response.toString());
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
        }
    }

}
