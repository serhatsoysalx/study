package com.study.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "sq_id", allocationSize = 1)
    @GeneratedValue(generator = "sq_id", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "name")
    @NonNull
    private String name;

    @Column(length = 50, name = "surname")
    @NonNull
    private String surname;

    @Column(length = 50, name = "username")
    @NonNull
    private String username;

    @OneToMany
    @JoinColumn(name = "fk_useradress")
    private List<Adress> adress;
}
