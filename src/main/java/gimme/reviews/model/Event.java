package gimme.reviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Event {

    private String botId;
    private String channel;
    private String user;
    private String text;

    public Event(
            @JsonProperty("bot_id") String botId,
            @JsonProperty("channel") String channel,
            @JsonProperty("user") String user,
            @JsonProperty("text") String text) {
        this.botId = botId;
        this.channel = channel;
        this.user = user;
        this.text = text;
    }

    public String getBotId() {
        return botId;
    }

    public void setBotId(String botId) {
        this.botId = botId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
