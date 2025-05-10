package com.vivemedellin.valoracion_comentarios.event.factory;

import com.vivemedellin.valoracion_comentarios.admin.entity.Admin;
import com.vivemedellin.valoracion_comentarios.category.entity.Category;
import com.vivemedellin.valoracion_comentarios.event.entity.Event;
import com.vivemedellin.valoracion_comentarios.organizer.entity.Organizer;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;


@Component
public class EventMockFactory {

    private final Faker faker = new Faker();

    public Event createEvent(Admin admin, Category category, Organizer organizer){
        String[] eventTypes = {"Summit", "Expo", "Conference", "Meetup", "Festival", "Workshop"};
        String[] eventLocations = {faker.location().building(), faker.location().nature(), faker.location().work()};
        var builder = Event.builder();
        builder.admin(admin);
        builder.category(category);
        builder.organizer(organizer);
        int daysToAdd = ThreadLocalRandom.current().nextInt(1, 101);
        builder.date(Instant.now().plus(daysToAdd, ChronoUnit.DAYS));
        builder.title(faker.book().title() + " " + faker.options().option(eventTypes));
        builder.description(faker.lorem().paragraph());
        builder.price(BigDecimal.valueOf(faker.number().randomNumber(3)));
        builder.location(faker.options().option(eventLocations));
        return builder.build();
    }
}
