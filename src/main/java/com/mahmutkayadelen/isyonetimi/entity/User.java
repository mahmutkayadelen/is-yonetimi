package com.mahmutkayadelen.isyonetimi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 Created By mahmutlayadelen
 13.12.2020
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uname",length = 100,unique = true)
    private String username;

    @Column(name = "pwd",length = 200)  //user username password bunlar veritbanına özel şeyle olabildiği için böyle yazdık
    private  String password;

    @Column(name = "name_surname",length = 200)
    private String nameSurname;

    @Column(name = "email", length = 100)
    private String email;

    @JoinColumn(name = "assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;


}
