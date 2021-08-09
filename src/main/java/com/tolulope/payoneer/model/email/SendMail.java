package com.tolulope.payoneer.model.email;

import com.tolulope.payoneer.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="mails")
@NoArgsConstructor
@Entity
public class SendMail extends BaseModel {

    private String subject;
    private String text;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(columnDefinition = "email")
    private List<Mail> emails;

    public SendMail(String subject, String text, List<Mail> emails) {
        this.subject = subject;
        this.text = text;
        this.emails = emails;
    }
}
