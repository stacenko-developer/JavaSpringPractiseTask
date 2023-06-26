package com.i_sys.practise.data.autos;

import com.i_sys.practise.data.BaseEntity;
import com.i_sys.practise.data.persons.Person;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auto")
public class Auto extends BaseEntity {

    @Column(name = "production_year", nullable = false)
    private int productionYear;

    @Column(name = "engine_power", nullable = false)
    private int enginePower;

    @Column(name = "engine_capacity", nullable = false)
    private int engineCapacity;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Auto(int productionYear, int enginePower, int engineCapacity, Person person) {
        this.productionYear = productionYear;
        this.enginePower = enginePower;
        this.engineCapacity = engineCapacity;
        this.person = person;
    }

    public Auto() {

    }
}
