package com.practice.person.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="profile")
public class ProfileEntity {

    @Id
    @Column(name="profile_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name="address")
    String address;

    @Column(name="phone_number")
    Long phoneNumber;

    @JoinColumn(name="user_id")
    @OneToOne
    @JsonIgnore
    UserEntity user;
}
