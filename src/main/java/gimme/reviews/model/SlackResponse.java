package gimme.reviews.model;

import java.io.Serializable;

public class SlackResponse implements Serializable {
    public String token;
    public String text;
    public String channel;

    public SlackResponse(String token, String text, String channel) {
        this.token = token;
        this.text = text;
        this.channel = channel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
