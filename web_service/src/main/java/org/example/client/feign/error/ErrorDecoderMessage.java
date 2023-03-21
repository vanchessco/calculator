package org.example.client.feign.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.example.exception.calculator.CalculatorException;
import org.example.exception.util.ExceptionDetail;

import java.io.IOException;
import java.io.InputStream;

/**
 * Исп для извлечения данных об ошибке, пробрасываемой из rest сервиса, из FeignException
 */
public class ErrorDecoderMessage implements feign.codec.ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionDetail message = null;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            message = mapper.readValue(bodyIs, ExceptionDetail.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        if (response.status() == 400) {
            return new CalculatorException(message.getDetail());
        }
        return errorDecoder.decode(methodKey, response);
    }
}
