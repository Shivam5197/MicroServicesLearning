package com.Cards.MicroServiceCards.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cards extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  cardId;


    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private Integer  totalLimit;
    private Integer  amountUsed;
    private Integer  availableAmount;



//      `card_id` int NOT NULL AUTO_INCREMENT,
//  `mobile_number` varchar(15) NOT NULL,
//  `card_number` varchar(100) NOT NULL,
//  `card_type` varchar(100) NOT NULL,
//  `total_limit` int NOT NULL,
//            `amount_used` int NOT NULL,
//            `available_amount` int NOT NULL,
//            `created_at` date NOT NULL,
//            `created_by` varchar(20) NOT NULL,
//  `updated_at` date DEFAULT NULL,
//            `updated_by` varchar(20) DEFAULT NULL,
//    PRIMARY KEY (`card_id`)

}
