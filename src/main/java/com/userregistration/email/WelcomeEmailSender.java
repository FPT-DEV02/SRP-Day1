package com.userregistration.email;

import com.userregistration.model.User;

public interface WelcomeEmailSender {
    void sendWelcomeEmail(User user);
}
