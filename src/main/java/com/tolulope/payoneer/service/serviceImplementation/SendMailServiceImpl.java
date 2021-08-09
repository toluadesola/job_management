package com.tolulope.payoneer.service.serviceImplementation;

import com.tolulope.payoneer.model.Status;
import com.tolulope.payoneer.model.email.Mail;
import com.tolulope.payoneer.model.email.SendMail;
import com.tolulope.payoneer.repository.SendMailRepository;
import com.tolulope.payoneer.service.SendMailService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class SendMailServiceImpl implements SendMailService {

    private final JavaMailSender javaMailSender;
    private final Environment env;
    private final SendMailRepository sendMailRepository;

    @Override
    public String sendMail(SendMail sendMail)
    {
        Status status;
        try{
            status = Status.QUEUED;
            for(int i = 0; i < sendMail.getEmails().size(); i++){
                status = Status.RUNNING;
                sendEmail(sendMail, sendMail.getEmails().get(i));
            }
            status = Status.SUCCESS;
        } catch (Exception e){
            status = Status.FAILED;
        }
        if(status==Status.SUCCESS){
            sendMailRepository.save(new SendMail(
                    sendMail.getSubject(),
                    sendMail.getText(),
                    sendMail.getEmails()));
        }
        return "Job Done";
    }

    private void sendEmail(SendMail sendMail, Mail receiver){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(Objects.requireNonNull(env.getProperty("spring.mail.username")));
        simpleMailMessage.setTo(receiver.getEmail().trim());
        simpleMailMessage.setSubject(sendMail.getSubject());
        simpleMailMessage.setText("\n"+
                sendMail.getText() + "\n" );
        javaMailSender.send(simpleMailMessage);
    }
}
