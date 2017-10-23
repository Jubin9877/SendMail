package com.example.mail.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MailResource {
  
  @Autowired
  public MailMail mailMail;
  
  @GetMapping("/send")
  public void mailsend() {
    mailMail.sendMail();
  }

}
