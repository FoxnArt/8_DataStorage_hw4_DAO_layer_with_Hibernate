package ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.entity.NameSurnameAge;
import ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Person, NameSurnameAge> {

    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByNameSurnameAge_AgeIsBeforeOrderByNameSurnameAge_AgeAsc(int age);

    Optional<Person> findByNameSurnameAge_NameAndNameSurnameAge_Surname(String name, String surname);
}
