package com.study.entity;

import com.study.config.AdressType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "personal_adress")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name = "sq_personal_adress", initialValue = 1)
    @GeneratedValue(generator = "sq_personal_adress", strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String adress;

    @Column
    private Boolean status;

    @Enumerated
    private AdressType adressType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_useradress")
    private User user;
}
