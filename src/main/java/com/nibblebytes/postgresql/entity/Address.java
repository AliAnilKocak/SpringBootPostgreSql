package com.nibblebytes.postgresql.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_user_address")
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum AddressType {
        HOME_ADRESS,
        OFFICE_ADRESS,
        OTHER_ADRESS
    }
}