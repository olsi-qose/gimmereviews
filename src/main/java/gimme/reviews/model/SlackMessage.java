package gimme.reviews.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.slack.api.model.event.MessageEvent;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SlackMessage {

    private final String token;
    private final String challenge;
    private final String type;
    private final MessageEvent event;

    @JsonCreator
    public SlackMessage(
            @JsonProperty("token") String token,
            @JsonProperty("challenge") String challenge,
            @JsonProperty("event")
            @JsonSetter(nulls = Nulls.SKIP) MessageEvent event,
            @JsonProperty("type") String type) {
        this.token = token;
        this.challenge = challenge;
        this.type = type;
        this.event = event;
    }

    public MessageEvent getEvent() {
        return event;
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

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
