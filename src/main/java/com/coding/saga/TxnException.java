package com.coding.saga;

public class TxnException extends Exception {
    public TxnException(String message) {
        super(message);
    }
}