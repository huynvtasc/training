package org.huynv.projectionstoreprocedure.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GreetingController {
    MessageSource messageSource;

    @GetMapping("/{username}")
    public String greet(@PathVariable("username") String username,
                        @RequestHeader(name = "Accept-Language", required = false) Locale locale)
    {
        String greetingMessage = messageSource
                .getMessage("greeting.message", new Object[]{username, username, username}, locale);

        return String.format("Locale: %s, Message: %s", locale, greetingMessage);
    }
}
