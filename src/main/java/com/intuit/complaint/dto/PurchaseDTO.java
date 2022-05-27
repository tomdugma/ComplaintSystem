package com.intuit.complaint.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseDTO {

    private UUID id;
    private UUID userId;
    private UUID productId;
    private String productName;
    private BigDecimal pricePaidAmount;
    private String priceCurrency;
    private BigDecimal discountPercent;
    private UUID merchantId;
    private String purchaseDate;


}
