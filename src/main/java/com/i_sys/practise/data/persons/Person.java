package com.i_sys.practise.data.persons;

import com.i_sys.practise.data.BaseEntity;
import com.i_sys.practise.data.autos.Auto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "person")
@EnableJpaRepositories
public class Person extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos = new ArrayList<>();

    public Person(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Person() {

    }
}
