package ru.netology._8_datastorage_hw4_dao_layer_with_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology._8_datastorage_hw4_dao_layer_with_hibernate.entity.Person;

import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = entityManager.createNativeQuery("SELECT * FROM persons", Person.class).getResultList();
        return personList.stream().filter(x -> city.equals(x.getCity_of_living())).toList();
    }
}
