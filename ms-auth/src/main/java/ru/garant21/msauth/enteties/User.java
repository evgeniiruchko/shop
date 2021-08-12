package ru.garant21.msauth.enteties;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    private String email;

    @Column(name = "birthDay")
    private LocalDateTime birthDay;

    @Column(name = "city")
    private String city;

//    @OneToOne
//    @JoinColumn(name = "favoriteShop")
//    private Shop favoriteShop;

    @Column(name = "favoriteShop")
    private String favoriteShop;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "Users_Id"),
            inverseJoinColumns = @JoinColumn(name = "Roles_id"))
    private Collection<Role> roles;
}