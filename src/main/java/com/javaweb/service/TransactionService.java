package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.TransactionResponse;
import com.javaweb.model.response.TransactionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TransactionService {
    List<TransactionResponse> listTransaction(Long customerId , String code);
    TransactionDTO addOrUpdateTransaction(TransactionDTO transactionDTO);
    ResponseDTO loadTransactionDetail(Long id);
}
