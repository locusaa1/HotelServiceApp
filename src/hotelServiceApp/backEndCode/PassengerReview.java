package hotelServiceApp.backEndCode;

import java.time.LocalDate;
import java.util.UUID;

public class PassengerReview {

    private UUID id;
    private LocalDate reviewDate;
    private String review;

    public PassengerReview() {

        this.id = UUID.randomUUID();
    }

    public PassengerReview(LocalDate reviewDate, String review) {

        this.id = UUID.randomUUID();
        this.reviewDate = reviewDate;
        this.review = review;
    }

    public LocalDate getReviewDate() {

        return this.reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {

        this.reviewDate = reviewDate;
    }

    public String getReview() {

        return this.review;
    }

    public void setReview(String review) {

        this.review = review;
    }


}
