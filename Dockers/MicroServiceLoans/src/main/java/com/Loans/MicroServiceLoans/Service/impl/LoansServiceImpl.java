package com.Loans.MicroServiceLoans.Service.impl;

import com.Loans.MicroServiceLoans.Constants.LoansConstants;
import com.Loans.MicroServiceLoans.DTO.LoansDTO;
import com.Loans.MicroServiceLoans.Entity.Loans;
import com.Loans.MicroServiceLoans.Exception.LoanAlreadyExistException;
import com.Loans.MicroServiceLoans.Exception.ResourceNotFoundException;
import com.Loans.MicroServiceLoans.Mapper.LoansMapper;
import com.Loans.MicroServiceLoans.Repository.LoansRepository;
import com.Loans.MicroServiceLoans.Service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class LoansServiceImpl implements ILoanService {


    public LoansRepository loansRepository;


    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> loan= loansRepository.findByMobileNumber(mobileNumber);

        if(loan.isPresent()){
            throw new LoanAlreadyExistException("Loan Already given to This Customer");
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }


    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }


    /**
     * @param mobileNumber - Input mobile Number
     * @return Loan Details based on a given mobileNumber
     */
    @Override
    public LoansDTO fetchLoan(String mobileNumber) {

        LoansDTO loansDTO = new LoansDTO();

        Loans loan= loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> {
                    return new ResourceNotFoundException("Loan", "MobileNumber", mobileNumber);
                }
        );

        LoansMapper.LoansEntityToDto(loansDTO,loan);

        return loansDTO;
    }

    /**
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateLoan(LoansDTO loansDto) {
        boolean isUpdated = false;

        if(loansDto != null) {
            Loans loan = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Loan", "Loan Number", loansDto.getLoanNumber())
            );

            LoansMapper.LoansDtoToEntity(loansDto, loan);

            loansRepository.save(loan);
            isUpdated = true;
        }

        return isUpdated;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        boolean isUpdated = false;

        if(mobileNumber != null) {
            Loans loan = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                    () -> new ResourceNotFoundException("Loan", "Mobile Number", mobileNumber)
            );

            loansRepository.delete(loan);
            isUpdated = true;
        }

        return isUpdated;
    }
}
