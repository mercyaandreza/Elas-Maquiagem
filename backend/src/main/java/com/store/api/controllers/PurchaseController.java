package com.store.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PurchaseController {
	
	 @Autowired
	 private JavaMailSender mailSender;
	 //email
	    @RequestMapping(path = "/send", method = RequestMethod.GET)
	    public String sendMail() {
	    	SimpleMailMessage message = new SimpleMailMessage();
	        message.setSubject("Pedido de Fulana");
	        message.setText("1 batom vermelho R$ 10.00");
	        message.setTo("elasmaquiagem@gmail.com");

	        try {
	            mailSender.send(message);
	            return "Pedido de reserva enviado com sucesso!";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Erro ao enviar email.";
	        }
	    }
}
