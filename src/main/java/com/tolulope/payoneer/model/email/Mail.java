package com.tolulope.payoneer.model.email;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Mail {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    public Mail(String email) {
        this.email = email;
    }
}
