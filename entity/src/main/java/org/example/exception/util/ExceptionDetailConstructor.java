package org.example.exception.util;

import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ExceptionDetailConstructor {

    public static ExceptionDetail construct(WebRequest request, Throwable e) {
        ExceptionDetail ex = new ExceptionDetail();
        ex.setDate(LocalDateTime.now(ZoneId.of("Europe/Moscow")));
        ex.setDetail(e.getMessage());
        ex.setPath(request.getDescription(false));
        ex.setDeveloperMessage(e.getClass().getName());

        return ex;
    }
}
