package ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.entity.NameSurnameAge;
import ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.entity.Person;
import ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final UserRepository userRepository;

    public PersonController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/persons/create")
    public Person createPerson(@RequestBody Person person) {
        return userRepository.save(person);
    }

    @GetMapping("/persons/read")
    public Optional<Person> readPerson(@RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("age") int age) {
        return userRepository.findById(new NameSurnameAge(name, surname, age));
    }

    @PutMapping("/persons/update")
    public Person updatePerson(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("age") int age,
                               @RequestBody Person person) {
        person.setNameSurnameAge(new NameSurnameAge(name, surname, age));
        return userRepository.save(person);
    }

    @GetMapping("/persons/delete")
    public void deletePerson(@RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("age") int age) {
        userRepository.deleteById(new NameSurnameAge(name, surname, age));
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPerson(@RequestParam("city") String cityOfLiving) {
        return userRepository.findByCityOfLiving(cityOfLiving);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPerson(@RequestParam("age") int age) {
        return userRepository.findByNameSurnameAge_AgeIsBeforeOrderByNameSurnameAge_AgeAsc(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getPerson(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return userRepository.findByNameSurnameAge_NameAndNameSurnameAge_Surname(name, surname);
    }
}
