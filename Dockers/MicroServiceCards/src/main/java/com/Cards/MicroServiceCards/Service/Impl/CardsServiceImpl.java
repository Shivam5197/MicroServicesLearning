package com.Cards.MicroServiceCards.Service.Impl;

import com.Cards.MicroServiceCards.Constants.CardsConstants;
import com.Cards.MicroServiceCards.DTO.CardsDTO;
import com.Cards.MicroServiceCards.Entity.Cards;
import com.Cards.MicroServiceCards.Exception.CardsAlreadyExistsException;
import com.Cards.MicroServiceCards.Exception.ResourceNotFoundException;
import com.Cards.MicroServiceCards.Mapper.CardsMapper;
import com.Cards.MicroServiceCards.Repository.CardsRepository;
import com.Cards.MicroServiceCards.Service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {


    private CardsRepository cardsRepository;


    /**
     * @param mobileNumber
     */
    @Override
    public void createCard(String mobileNumber) {

        Optional<Cards> optionalCards= cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardsAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }



    /**
     * @param mobileNumber - Mobile Number of the Customer
     * @return the new card details
     */
    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);

        System.out.println("Hello I am trying to save"+newCard.toString());
        return newCard;
    }



    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CardsDTO getCardDetails(String mobileNumber) {

        CardsDTO cardsDTO = new CardsDTO();
       Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Card","Mobile number", mobileNumber)
        );

        CardsMapper.CardsEntityToDTO(cards,cardsDTO);

        return cardsDTO;
    }

    /**
     * @param cardsDTO
     * @return
     */
    @Override
    public boolean updateCardDetails(CardsDTO cardsDTO) {

        boolean isUpdated = false;

        Cards cards = cardsRepository.findByCardNumber(cardsDTO.getCardNumber()).orElseThrow(
                ()-> new ResourceNotFoundException("Card","Card Number", cardsDTO.getCardNumber())
        );

        if (cards != null) {

            CardsMapper.CardsDTOToEntity(cardsDTO, cards);
            System.out.println("Hello I am trying to update"+cardsDTO.toString());
            cardsRepository.save(cards);
            isUpdated = true;
        }

        return isUpdated;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        boolean isUpdated = false;

        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Card","Mobile number", mobileNumber)
        );

        if (cards != null) {
            cardsRepository.delete(cards);
            isUpdated = true;
        }

        return isUpdated;
    }
}
