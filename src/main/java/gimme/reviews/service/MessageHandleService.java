package gimme.reviews.service;

import com.slack.api.model.event.MessageEvent;
import gimme.reviews.model.Review;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class MessageHandleService {

    private final ReviewService reviewService;

    private final PostMessageService postMessageService;

    @Autowired
    public MessageHandleService(ReviewService reviewService, PostMessageService postMessageService) {
        this.reviewService = reviewService;
        this.postMessageService = postMessageService;
    }

    public void handleEvent(MessageEvent event) throws IOException {
        String url = event.getText();
        //ToDo get validation
        UrlValidator defaultValidator = new UrlValidator();
        if (!defaultValidator.isValid(url)) {
            postMessageService.sendResponseMessage("URL is invalid");
        }
        reviewService.getReviews(url).ifPresentOrElse(
                postMessageService::sendResponseMessage,
                new Runnable() {
                    @Override
                    public void run() {
                        postMessageService.sendResponseMessage("No reviews found");
                    }
                }
        );
        ;
    }
}
