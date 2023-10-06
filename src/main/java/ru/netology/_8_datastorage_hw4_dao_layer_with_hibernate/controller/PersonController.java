package ru.netology._8_datastorage_hw4_dao_layer_with_hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology._8_datastorage_hw4_dao_layer_with_hibernate.entity.Person;
import ru.netology._8_datastorage_hw4_dao_layer_with_hibernate.repository.UserRepository;

import java.util.List;

@RestController
public class PersonController {

    private final UserRepository userRepository;

    public PersonController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/persons/by-city")
        public List<Person> getPerson(@RequestParam("city") String cityOfLiving) {
            return userRepository.getPersonsByCity(cityOfLiving);
        }
}
