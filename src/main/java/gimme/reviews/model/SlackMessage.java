package gimme.reviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;

public class SlackMessage {

    private String token;
    private String challenge;
    private String type;
    private Event event;

    public SlackMessage(
            @JsonProperty("token") String token,
            @JsonProperty("challenge") String challenge,
            @JsonProperty("event") @JsonSetter(nulls = Nulls.SKIP) Event event,
            @JsonProperty("type") String type) {
        this.token = token;
        this.challenge = challenge;
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getToken() {
        return token;
    }

    public String getChallenge() {
        return challenge;
    }

    public String getType() {
        return type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "SlackMessage { \n" +
                "   type: " + this.type + "\n" +
                "   challenge: " + this.challenge + "\n" +
                "   token: " + this.token + "\n" +
                "}";
    }
}
