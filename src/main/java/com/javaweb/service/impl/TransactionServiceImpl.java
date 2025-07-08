package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.TransactionResponse;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final TransactionConverter transactionConverter;

    @Override
    public List<TransactionResponse> listTransaction(Long customerId, String code) {
        List<TransactionEntity> transactions = transactionRepository.findByCustomerIdAndCode(customerId, code);
        List<TransactionResponse> result = new ArrayList<>();
        for (TransactionEntity transaction : transactions) {
            TransactionResponse dto = transactionConverter.toResponse(transaction);
            result.add(dto);
        }
        return result;
    }

    @Override
    public TransactionDTO addOrUpdateTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionConverter.toEntity(transactionDTO);
        if (transactionDTO.getId() != null) {
            TransactionEntity oldTransactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
            transactionEntity.setCreatedBy(oldTransactionEntity.getCreatedBy());
            transactionEntity.setCreatedDate(oldTransactionEntity.getCreatedDate());
        }

        transactionRepository.save(transactionEntity);
        return transactionDTO;
    }

    @Override
    public ResponseDTO loadTransactionDetail(Long id) {
        TransactionEntity transactionEntity= transactionRepository.findById(id).get();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(transactionEntity.getTransactionDetail());
        responseDTO.setMessage("success");
        return responseDTO;
    }
}
