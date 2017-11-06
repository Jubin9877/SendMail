package com.example.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.mail.send.MailMail;

@SpringBootApplication
public class MailApplication {

  public static void main(String[] args) {
    SpringApplication.run(MailApplication.class, args);
  }
}
