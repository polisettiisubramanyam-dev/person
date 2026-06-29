package com.practice.person.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer userId;

    @Column(name="user_name")
    String userName;

    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    ProfileEntity profile;
}
