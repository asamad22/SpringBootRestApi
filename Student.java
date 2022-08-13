package com.bd.dipti.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.naming.factory.SendMailFactory;

import javax.persistence.*;

@Entity
@Table(name ="students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false,length = 40, unique = true)
    private String email;

}
