package com.coding.saga;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvOrderProcessor {
    private final OrderService orderSvc;

    public CsvOrderProcessor(OrderService orderSvc) {
        this.orderSvc = orderSvc;
    }


    public void process(InputStream is) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
            List<RawOrder> orders = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length != 3) {
                    throw new RuntimeException("Expected only 3 columns in csv file");
                }
                orders.add(new RawOrder(values[0], values[1], values[2]));
            }

            for (var orderData : orders) {
                try {
                    orderSvc.add(orderData);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            throw ex;
        }
    }
}