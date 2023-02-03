package com.rp.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

}
