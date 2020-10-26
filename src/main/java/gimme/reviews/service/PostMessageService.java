package gimme.reviews.service;

import gimme.reviews.model.SlackResponse;
import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class PostMessageService {

    final String API_URL = "https://slack.com/api";

    public void sendResponseMessage(String msg)  {
        // create a client
        HttpClient client = HttpClient.newHttpClient();

        SlackResponse slackResponse = new SlackResponse(
                "xoxb-1467349419936-1452029906275-sceI9FzUJPI3ZGwzKBUkTQeq",
                "Well done son!",
                "nothing");

        // create a request
        HttpRequest request = HttpRequest.newBuilder(
                URI.create("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofByteArray(SerializationUtils.serialize(slackResponse)))
                .build();

        // use the client to send the request
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
