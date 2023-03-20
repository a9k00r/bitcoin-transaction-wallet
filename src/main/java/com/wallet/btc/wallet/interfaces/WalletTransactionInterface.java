package com.wallet.btc.wallet.interfaces;


import com.wallet.btc.wallet.models.BTCTrxReqDto;
import com.wallet.btc.wallet.common.BaseAPIResponse;
import com.wallet.btc.wallet.models.TrxHistoryReqDto;

import java.util.List;

public interface WalletTransactionInterface {
    BaseAPIResponse createTransaction(BTCTrxReqDto trxReqDto) throws Exception;
    List<BTCTrxReqDto> getWalletTransactionHistories(TrxHistoryReqDto trxHistoryReqDto) throws Exception;

    BaseAPIResponse createWallet();

}
