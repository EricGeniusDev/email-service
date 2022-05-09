package com.example.emailservice.controller;

import com.example.emailservice.dto.EmailDTO;
import com.example.emailservice.constants.RabbitMqConstants;
import com.example.emailservice.service.MensageriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private MensageriaService mensageriaService;

    @PostMapping
    public ResponseEntity<EmailDTO> sendMEssage(@RequestBody EmailDTO emaildto){
        mensageriaService.salvarMensagem(RabbitMqConstants.EMAIL,emaildto);
        return ResponseEntity.status(HttpStatus.CREATED).body(emaildto);
    }
}
