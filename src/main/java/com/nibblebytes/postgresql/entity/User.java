package com.nibblebytes.postgresql.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(value = "User object value",description = "User object description")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user")
    @GeneratedValue(generator = "seq_user", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)

    @ApiModelProperty(value = "User's unique id")
    private Long id;

    @ApiModelProperty(value = "User Name")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "User Surname")
    @Column(name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    private List<Address> addresses;

}