package com.tolulope.payoneer.controller;

import com.tolulope.payoneer.model.email.SendMail;
import com.tolulope.payoneer.model.warehouse.WareHouse;
import com.tolulope.payoneer.service.SendMailService;
import com.tolulope.payoneer.service.WareHouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
public class JobController {

    private final SendMailService sendMailService;
    private final WareHouseService wareHouseService;

    @GetMapping(value = "/sendmail")
    public ResponseEntity<?> sendMail(@RequestBody SendMail sendMail)
    {
        return new ResponseEntity<>(sendMailService.sendMail(sendMail), HttpStatus.OK);
    }

    @PostMapping(value = "/warehouse")
    public ResponseEntity<?> saveToWareHouse(@RequestBody WareHouse wareHouse)
    {
        return new ResponseEntity<>(wareHouseService.saveToWareHouse(wareHouse), HttpStatus.CREATED);
    }
}
