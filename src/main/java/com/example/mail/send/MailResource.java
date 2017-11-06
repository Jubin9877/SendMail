package com.example.mail.send;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;

@RestController
@RequestMapping("/api")
public class MailResource {
  
  @Autowired
  public MailMail mailMail;
  
  @GetMapping("/send/{name}")
  public void mailsend(@PathVariable String name) throws IOException, TemplateException {
    mailMail.sendMail(name);
  }

}
