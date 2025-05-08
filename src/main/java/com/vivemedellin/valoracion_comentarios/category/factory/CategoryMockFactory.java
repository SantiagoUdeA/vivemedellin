package com.vivemedellin.valoracion_comentarios.category.factory;

import com.vivemedellin.valoracion_comentarios.category.entity.Category;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMockFactory {

    private final Faker faker = new Faker();

    public List<Category> createMocks(){
        var mocks = new ArrayList<Category>();
        String [] names = {
                "Concerts", "Technology", "Art", "Sports", "Cinema",
                "Gastronomy", "Fashion", "Literature", "Business", "Health"
        };
        for (String name : names) {
            var category = new Category();
            category.setName(name);
            category.setDescription(faker.lorem().paragraph());
            mocks.add(category);
        }
        return mocks;
    }
}
