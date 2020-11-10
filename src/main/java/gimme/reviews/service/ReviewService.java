package gimme.reviews.service;

import gimme.reviews.model.Review;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class ReviewService {

    public Optional<Review> getReviews(String url) throws IOException {
        //Supported only yotpo rich snippet
        String pattern = ".y-rich-snippet-script";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(pattern);


        return Optional.of(new Review(1,20));
    }
}
