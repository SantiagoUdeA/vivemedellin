package com.vivemedellin.valoracion_comentarios.organizer.factory;


import com.vivemedellin.valoracion_comentarios.organizer.entity.Organizer;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMockFactory {

    private final Faker faker = new Faker();

    public Organizer createMock(){
        var builder = Organizer.builder();
        builder.email(faker.internet().emailAddress());
        builder.firstName(faker.name().firstName());
        builder.lastName(faker.name().lastName());
        return builder.build();
    }
}
