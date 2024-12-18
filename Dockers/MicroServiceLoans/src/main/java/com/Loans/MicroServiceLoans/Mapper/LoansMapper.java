package com.Loans.MicroServiceLoans.Mapper;

import com.Loans.MicroServiceLoans.DTO.LoansDTO;
import com.Loans.MicroServiceLoans.Entity.Loans;

public class LoansMapper {


    public static LoansDTO LoansEntityToDto(LoansDTO loansDTO, Loans loans){

        loansDTO.setLoanType(loans.getLoanType());
        loansDTO.setLoanNumber(loans.getLoanNumber());
        loansDTO.setMobileNumber(loans.getMobileNumber());
        loansDTO.setTotalLoan(loans.getTotalLoan());
        loansDTO.setAmountPaid(loans.getAmountPaid());
        loansDTO.setOutstandingAmount(loans.getOutstandingAmount());

        return loansDTO;
    }


    public static Loans LoansDtoToEntity(LoansDTO loansDto, Loans loans){

        loans.setLoanType(loansDto.getLoanType());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());

        return loans;
    }



}
