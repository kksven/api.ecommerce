package com.api.ecommerce.api.ecommerce.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WebRestControllerAdviceTest {

    @InjectMocks
    WebRestControllerAdvice controllerAdvice;

    @Test
    public void shouldReturnBadRequestErrorWhenIsMethodArgumentNotValidException() {
        Exception ex = new Exception();

        ResponseEntity<Object> response = controllerAdvice.handleArgumentException(ex);
        ResponseMsg responseMsg = (ResponseMsg) response.getBody();

        assert responseMsg != null;
        assertEquals("Bad arguments", responseMsg.getMessage());
    }

    @Test
    public void shouldReturnInternalServerErrorWhenIsRestClientException() {
        String expected = "Error";
        ResponseEntity<Object> data = controllerAdvice.handleException(new RestClientException(expected));
        String result = ((ResponseMsg) Objects.requireNonNull(data.getBody())).getDetail();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, data.getStatusCode());
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnNotFoundExceptionWhenPriceInformationIsEmpty() {
        String expected = "Price Information not found";
        ResponseEntity<Object> data = controllerAdvice.handleNotFoundException(new CustomNotFoundException(expected));
        String result = ((ResponseMsg) Objects.requireNonNull(data.getBody())).getDetail();

        assertEquals(HttpStatus.NOT_FOUND, data.getStatusCode());
        assertEquals(expected, result);
    }
}
