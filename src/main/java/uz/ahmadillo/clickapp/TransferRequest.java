package uz.ahmadillo.clickapp;

import lombok.Data;
@Data
public class TransferRequest {
    private Long sourceCardId;
    private Long destinationCardId;
    private double amount;

}

