package com.vivemedellin.valoracion_comentarios.review.application.commands.create_review;

import com.vivemedellin.valoracion_comentarios.event.dto.EventDTO;
import com.vivemedellin.valoracion_comentarios.event.mapper.EventMapper;
import com.vivemedellin.valoracion_comentarios.event.repository.EventRepository;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import com.vivemedellin.valoracion_comentarios.review.entity.Review;
import com.vivemedellin.valoracion_comentarios.review.exceptions.UserAlreadyReviewedException;
import com.vivemedellin.valoracion_comentarios.review.mapper.ReviewMapper;
import com.vivemedellin.valoracion_comentarios.review.repository.ReviewRepository;
import com.vivemedellin.valoracion_comentarios.user.dto.UserDto;
import com.vivemedellin.valoracion_comentarios.user.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateReviewHandler {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserMapper userMapper;
    private final EventMapper eventMapper;

    @Autowired
    public CreateReviewHandler(
            ReviewRepository reviewRepository,
            ReviewMapper reviewMapper,
            UserMapper userMapper,
            EventMapper eventMapper
    ) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
        this.userMapper = userMapper;
        this.eventMapper = eventMapper;
    }

    @Transactional
    public ReviewDto handle(@Valid CreateReviewCommand command) {
        // Throws if user has already reviewed
        if (reviewRepository.findByEventIdAndUserId(command.getEventId(), command.getUserId()).isPresent()) {
            throw new UserAlreadyReviewedException();
        }

        var reviewBuilder = Review.builder();
        var eventDto = new EventDTO();
        var userDto = new UserDto();

        eventDto.setId(command.getEventId());
        userDto.setId(command.getUserId());

        reviewBuilder.rating(command.getRating());
        reviewBuilder.comment(command.getComment());

        reviewBuilder.event(eventMapper.toEntity(eventDto));
        reviewBuilder.user(userMapper.toEntity(userDto));

        var saved = reviewRepository.save(reviewBuilder.build());
        return reviewMapper.toDTO(saved);
    }

}
