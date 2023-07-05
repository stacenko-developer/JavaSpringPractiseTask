package com.i_sys.practise.data.users;

import com.i_sys.practise.data.BaseEntity;
import com.i_sys.practise.data.roles.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@EnableJpaRepositories
public class User extends BaseEntity {

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public User(String login, String password, List<Role> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public User() {

    }
}
