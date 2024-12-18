package com.Cards.MicroServiceCards.Service;


import com.Cards.MicroServiceCards.DTO.CardsDTO;

public interface ICardsService {

        void createCard(String mobileNumber);

        CardsDTO getCardDetails(String mobileNumber);

        boolean updateCardDetails(CardsDTO cardsDTO);

        boolean deleteCard(String mobileNumber);


}
