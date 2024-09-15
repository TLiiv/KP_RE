package dev.tliiv.real_estate.init;

import dev.tliiv.real_estate.Residency;
import dev.tliiv.real_estate.ResidencyRepository;
import dev.tliiv.real_estate.User;
import dev.tliiv.real_estate.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResidencyRepository residencyRepository;

    @Override
    public void run(String... args) throws Exception {
        Residency residency = new Residency(
                new ObjectId(),
                "Beautiful House",
                "A lovely house in the city center",
                1000,
                "123 Main Street",
                "New York",
                "USA",
                "house.jpg",
                null,
                "user@example.com",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        // Save Residency (this will create the "residences" collection if it doesn't exist)
        residencyRepository.save(residency);

        // Create a User with the Residency ID
        User user = new User(
                new ObjectId(),
                "John Doe",
                "john.doe@example.com",
                "profile.jpg",
                Arrays.asList(),
                Arrays.asList(residency.getId()), // Add the residency's ID to the favorite list
                Arrays.asList(residency.getId())  // Add the residency's ID to the owned list
        );

        // Save User (this will create the "users" collection if it doesn't exist)
        userRepository.save(user);
    }
}
