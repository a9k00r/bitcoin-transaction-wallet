package com.wallet.btc.wallet.controllers;

import com.wallet.btc.wallet.constants.Endpoints;
import com.wallet.btc.wallet.models.BTCTrxReqDto;
import com.wallet.btc.wallet.interfaces.WalletTransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wallet.btc.wallet.common.BaseAPIResponse;
import com.wallet.btc.wallet.models.TrxHistoryReqDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BTCController {
    @Autowired
    private WalletTransactionInterface btcWalletTransactionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = Endpoints.BASE_ENDPOINT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseAPIResponse> createWallet(HttpServletRequest servletRequest) {
        BaseAPIResponse response = btcWalletTransactionService.createWallet();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = Endpoints.CREATE_BTC_TRANSACTION, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseAPIResponse> addTransaction(HttpServletRequest servletRequest,
                                                          @Valid @RequestBody BTCTrxReqDto trxReqDto) throws Exception {
        BaseAPIResponse response = btcWalletTransactionService.createTransaction(trxReqDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = Endpoints.HISTORY_BTC_TRANSACTION, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BTCTrxReqDto>> getLedgerHistories(HttpServletRequest servletRequest,
                                                                @Valid @RequestBody TrxHistoryReqDto trxHistoryReqDto) throws Exception {

        List<BTCTrxReqDto> response = btcWalletTransactionService.getWalletTransactionHistories(trxHistoryReqDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}