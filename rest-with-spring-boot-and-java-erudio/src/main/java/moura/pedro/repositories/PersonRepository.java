package moura.pedro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moura.pedro.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}
