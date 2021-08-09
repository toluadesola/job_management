package com.tolulope.payoneer.repository;

import com.tolulope.payoneer.model.email.SendMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendMailRepository extends JpaRepository<SendMail, Long> {
}
