package com.example.mail.send;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailMail {

  @Autowired
  private JavaMailSender mailSender;
  
  public void sendMail() {
    
    MimeMessage message = mailSender.createMimeMessage();
    
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message,true);
      
      helper.setFrom("pateljubin92@gmail.com");
      helper.setTo("pkshah22@yahoo.com");
      helper.setSubject("Send Succesfully");
      helper.setText("Welcome");
      
      FileSystemResource file = new FileSystemResource("E:\\log.txt");
      helper.addAttachment(file.getFilename(), file);
    }
    catch (MessagingException e) {
      throw new MailParseException(e);
    }
    mailSender.send(message);
  }
  
}
