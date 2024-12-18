package com.Cards.MicroServiceCards.Mapper;

import com.Cards.MicroServiceCards.DTO.CardsDTO;
import com.Cards.MicroServiceCards.Entity.Cards;

public class CardsMapper {


    public static CardsDTO CardsEntityToDTO(Cards cards, CardsDTO cardsDTO){


        cardsDTO.setCardNumber(cards.getCardNumber());
        cardsDTO.setCardType(cards.getCardType());
        cardsDTO.setMobileNumber(cards.getMobileNumber());
        cardsDTO.setTotalLimit(cards.getTotalLimit());
        cardsDTO.setAmountUsed(cards.getAmountUsed());
        cardsDTO.setAvailableAmount(cards.getAvailableAmount());

        return cardsDTO;
    }


    public static Cards CardsDTOToEntity( CardsDTO cardsDTO, Cards cards){

System.out.println("Hello I am trying to update"+cardsDTO.toString());
        cards.setCardNumber(cardsDTO.getCardNumber());
        cards.setCardType(cardsDTO.getCardType());
        cards.setMobileNumber(cardsDTO.getMobileNumber());
        cards.setTotalLimit(cardsDTO.getTotalLimit());
        cards.setAmountUsed(cardsDTO.getAmountUsed());
        cards.setAvailableAmount(cardsDTO.getAvailableAmount());

        return cards;
    }

}
