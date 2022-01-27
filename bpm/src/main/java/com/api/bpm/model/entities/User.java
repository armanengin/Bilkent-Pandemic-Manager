package com.api.bpm.model.entities;

import com.api.bpm.model.enums.COVID_STATUS;
import com.api.bpm.model.enums.COVID_TEST_RESULT;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    //properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotEmpty
    @Size(min = 8, message = "Password should have at least 8 characters!")
    private String password;


    @Size(min = 2, message = "User name should have at least 2 characters!")
    private String name;


    @Size(min = 2, message = "Surname should have at least 2 characters!")
    private String surname;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private Long bilkentId;

    private COVID_STATUS covidStatus;

    @OneToOne
    @JoinColumn(name = "abroadVaccineCard_id", referencedColumnName = "id")
    private AbroadVaccineCard abroadVaccineCard;

    @OneToOne
    @JoinColumn(name = "baseVaccineCard_id", referencedColumnName = "id")
    private BaseVaccineCard baseVaccineCard;

    @OneToMany
    @JoinColumn(name = "hesCode_id", referencedColumnName = "id")
    private List<HesCode> hesCodes;

    @OneToMany
    private List<CourseInfo> courseInfos;

    @Transient
    private List<COVID_TEST_RESULT> pastTestResults;

    @OneToOne
    private Quarantine quarantine;

    public User(String username, String email, String password, String name, String surname, Long bilkentId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.bilkentId = bilkentId;
    }
}
