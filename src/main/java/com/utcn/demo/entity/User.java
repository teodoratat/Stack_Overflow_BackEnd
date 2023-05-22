package com.utcn.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sqm.produce.function.StandardFunctionReturnTypeResolvers;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "f_name")
    private String firstName;
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNr;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;

    ///@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany()
    @JoinColumn(name = "content_id")
    private List<Content> contents = new ArrayList<>();

    public void addContent(Content content) {
        this.contents.add(content);
        content.setUser(this);
    }

    public void removeContent(Content content) {
        this.contents.remove(content);
        content.setUser(null);
    }

}
