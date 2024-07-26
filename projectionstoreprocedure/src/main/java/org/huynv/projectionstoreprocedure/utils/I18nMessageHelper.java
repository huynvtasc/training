package org.huynv.projectionstoreprocedure.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class I18nMessageHelper {
    private static final String UNKNOWN_ERROR = "Unknown error";
    private static final String UNKNOWN_MESSAGE = "Unknown massage";

    MessageSource messageSource;

    public String getErrorMessage(String messageKey, Object...args) {
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageKey, args, locale, UNKNOWN_ERROR);
    }

    public String getMessage(String messageKey, Object...args) {
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageKey, args, locale, UNKNOWN_MESSAGE);
    }

    public String getMessage(String messageKey, Object[] args, Locale locale, String defaultMsg) {
        try {
            return messageSource.getMessage(messageKey, args, locale);
        } catch (Exception ex) {
            log.error("Can not find message: {}", ex.getMessage());
            return defaultMsg;
        }
    }
}
