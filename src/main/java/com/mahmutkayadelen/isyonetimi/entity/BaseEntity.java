package com.mahmutkayadelen.isyonetimi.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/*
Created By mahmutlayadelen
13.12.2020
*/

@Data  //Getter setter oluyor. clasın başına @Getter Setter koyabiliriz veya değişkenlere atabiliriz
@MappedSuperclass  //diğer entityler alsın diye bunu ekledim
public  abstract class BaseEntity implements Serializable {
    //bütün tablolarda bu alanalr olsun diye bu entity oluşturuyoruz. entitlerime ectends edeceğim.

   @Column(name = "created_at")
   @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by",length = 100)
    private String createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by",length = 100)
    private String updatedBy;
    @Column(name = "status")
    private Boolean status;
}
