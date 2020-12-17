package com.mahmutkayadelen.isyonetimi.entity;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
        Created By mahmutlayadelen
        13.12.2020
 */
@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)  //Cardinal  yaparsak numarası alır bu defa araya birşey eklese biri sıra sıkıntısı olur.
    private IssueStatus issueStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //optinal true: zorunlu değil gibi Fetch ise join olup getirsin demek oluyor. lazy herzaman gelmez sadece get set çağırdığımızda gelir. eager seçsek herzaman gelir.
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY) //optinal true: zorunlu değil gibi Fetch ise join olup getirsin demek oluyor. lazy herzaman gelmez sadece get set çağırdığımızda gelir. eager seçsek herzaman gelir.
    private Project project;
}
