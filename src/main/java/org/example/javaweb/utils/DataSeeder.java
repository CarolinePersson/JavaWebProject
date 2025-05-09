package org.example.javaweb.utils;

import com.github.javafaker.Faker;
import org.example.javaweb.model.Dog;
import org.example.javaweb.model.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataSeeder {
    @Autowired
    DogRepository dogRepository;

    Faker faker = new Faker();

    public void Seed() throws URISyntaxException {
        if(dogRepository.count() > 0 ){
            return;
        }
        for(int i =0; i < 100; i++) {
            dogRepository.save(RandomDog());
        }
    }

    private Dog RandomDog() throws URISyntaxException {
        Dog dog = new Dog();
        dog.setAge(faker.dog().age());
        dog.setName(faker.dog().name());
        dog.setBreed(faker.dog().breed());
        dog.setGender(faker.dog().gender());
        dog.setPrice(faker.random().nextInt(4,20) * 1000);
        dog.setSize(faker.dog().size());
        dog.setImage("/images/dogs/" + getRandomImage());
        return dog;
    }

    private String getRandomImage() throws URISyntaxException {
        //Get all files in dir
        return "";
    }

    public static <T> T getByRandomClass(Set<T> set) {
        if (set == null || set.isEmpty()) {
            throw new IllegalArgumentException("The Set cannot be empty.");
        }
        int randomIndex = new Random().nextInt(set.size());
        int i = 0;
        for (T element : set) {
            if (i == randomIndex) {
                return element;
            }
            i++;
        }
        throw new IllegalStateException("Something went wrong while picking a random element.");
    }
}
