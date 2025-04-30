package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import com.vivemedellin.valoracion_comentarios.review.factory.ReviewMockFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CreateReviewHandlerTest {

    @Autowired
    private CreateReviewHandler createReviewHandler;

    @Test
    public void test(){

        var review = ReviewMockFactory.createReview(1L, 5, "Nice event!");

        CreateReviewCommand command = new CreateReviewCommand(review.getRating(), review.getCommentary());
        ReviewDTO result = createReviewHandler.handle(command);

        assertNotNull(result);
        assertEquals(review.getRating(), result.getRating());
        assertEquals(review.getCommentary(), result.getCommentary());

    }
}
