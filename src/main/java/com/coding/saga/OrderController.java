package com.coding.saga;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1.0/api")
public class OrderController {
    private final CsvOrderProcessor orderProcessor;

    public OrderController(CsvOrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }


    @PostMapping(path = "/csvorders", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse uploadOrders(@RequestParam MultipartFile file) throws IOException {
        orderProcessor.process(file.getInputStream());
        return new ApiResponse("Order CSV processed successfully", HttpStatus.OK.value());
    }
}