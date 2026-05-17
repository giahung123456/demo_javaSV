package com.example.demo.model.dto.response;

import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiDataResponse<T>{
    private Boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;

}
