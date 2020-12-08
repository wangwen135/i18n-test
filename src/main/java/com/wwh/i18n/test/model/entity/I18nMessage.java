package com.wwh.i18n.test.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "i18n_message")
public class I18nMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "id", nullable = false)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "zh_CN")
    private String zh_CN;

    @Column(name = "en_US")
    private String en_US;

    @Column(name = "fr_CA")
    private String fr_CA;

    @Column(name = "ru_RU")
    private String ru_RU;


}
