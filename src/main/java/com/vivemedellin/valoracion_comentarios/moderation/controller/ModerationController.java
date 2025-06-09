package com.vivemedellin.valoracion_comentarios.moderation.controller;

import com.vivemedellin.valoracion_comentarios.moderation.dto.UpdateReviewModerationDto;
import com.vivemedellin.valoracion_comentarios.moderation.service.ModerationService;
import com.vivemedellin.valoracion_comentarios.review.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
public class ModerationController {

    private final ModerationService moderationService;

    @Autowired
    public ModerationController(ModerationService moderationService) {
        this.moderationService = moderationService;
    }

    @PreAuthorize("hasRole('admin')")
    @MutationMapping
    public ReviewDto updateReviewModeration(@Argument("input") UpdateReviewModerationDto updateReviewModerationDto){
        return moderationService.updateReview(updateReviewModerationDto);
    }

    @PreAuthorize("hasRole('admin')")
    @MutationMapping
    public ReviewDto deleteReviewModeration(@Argument("reviewId") Long reviewId){
        return moderationService.deleteReview(reviewId);
    }

}
