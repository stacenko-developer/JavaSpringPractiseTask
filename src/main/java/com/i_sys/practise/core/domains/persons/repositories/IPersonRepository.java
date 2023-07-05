package com.i_sys.practise.core.domains.persons.repositories;

import com.i_sys.practise.data.persons.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IPersonRepository extends JpaRepository<Person, UUID> {

}
