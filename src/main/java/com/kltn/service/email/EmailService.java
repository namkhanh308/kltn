package com.kltn.service.email;


import com.kltn.enttities.email.MailObject;

public interface EmailService {
    void sendSimpleMessage(MailObject mail);

}
