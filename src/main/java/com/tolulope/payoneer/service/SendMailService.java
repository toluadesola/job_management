package com.tolulope.payoneer.service;

import com.tolulope.payoneer.model.email.SendMail;
import org.springframework.stereotype.Service;

@Service
public interface SendMailService {
    String sendMail(SendMail sendMail);
}
