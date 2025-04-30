package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDTO;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.factory.ReviewMockFactory;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateReviewHandlerTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ReviewMapper reviewMapper;

    @InjectMocks
    private CreateReviewHandler createReviewHandler;

    @Test
    public void test() {
        // Arrange
        var reviewMock = ReviewMockFactory.createReview(1L, 5, "Nice event!");

        Review reviewEntity = new Review();
        reviewEntity.setRating(reviewMock.getRating());
        reviewEntity.setCommentary(reviewMock.getCommentary());

        when(reviewRepository.save(any(Review.class))).thenReturn(reviewEntity);

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setRating(reviewMock.getRating());
        reviewDTO.setCommentary(reviewMock.getCommentary());

        when(reviewMapper.toDTO(any(Review.class))).thenReturn(reviewDTO);

        // Act
        CreateReviewCommand command = new CreateReviewCommand(reviewMock.getRating(), reviewMock.getCommentary());
        ReviewDTO result = createReviewHandler.handle(command);

        // Assert
        assertNotNull(result);
        assertEquals(reviewMock.getRating(), result.getRating());
        assertEquals(reviewMock.getCommentary(), result.getCommentary());

        verify(reviewRepository).save(any(Review.class));
        verify(reviewMapper).toDTO(any(Review.class));
    }
}
