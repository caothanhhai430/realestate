package com.javaweb.Exception;

public class TransactionFailedException extends RuntimeException {
    public TransactionFailedException(){
        super("Transaction is Failed");
    }
    public TransactionFailedException(String message){
        super(message);
    }

}
