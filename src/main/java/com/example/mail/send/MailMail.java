package com.example.mail.send;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import freemarker.template.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailMail {

  @Autowired
  private JavaMailSender mailSender;
  
  @Autowired
  private Configuration freemarkerConfig;
  
  @Autowired
  private JavaMailSender emailSender;
  
  public void sendMail(String name1) throws IOException, TemplateException {
    
    MimeMessage message = mailSender.createMimeMessage();
    
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message,true);
      
      Map model = new HashMap();
      model.put("name", name1);
      
      Template t = freemarkerConfig.getTemplate("email-template.ftl");
      String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
      
      helper.setFrom("pateljubin92@gmail.com");
      helper.setTo("pkshah22@yahoo.com");
      helper.setSubject("Send Succesfully");
      helper.setText(html, true);
     
      
      FileSystemResource file = new FileSystemResource("E:\\log.txt");
      helper.addAttachment(file.getFilename(), file);
    }
    catch (MessagingException e) {
      throw new MailParseException(e);
    }
    mailSender.send(message);
  }

  
}
