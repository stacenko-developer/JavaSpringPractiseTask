package com.i_sys.practise.data.roles;

import com.i_sys.practise.data.BaseEntity;
import com.i_sys.practise.data.users.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;

@Data
@Entity
@Table(name = "role")
@EnableJpaRepositories
public class Role extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
