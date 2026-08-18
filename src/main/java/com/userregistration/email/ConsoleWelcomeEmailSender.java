package com.userregistration.email;

import com.userregistration.model.User;

public class ConsoleWelcomeEmailSender implements WelcomeEmailSender {
    @Override
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email to " + user.getEmail());
    }
}
