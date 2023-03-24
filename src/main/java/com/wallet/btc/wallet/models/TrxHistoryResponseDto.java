package com.wallet.btc.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrxHistoryResponseDto {
    List<BTCTrxReqDto> ledgers;
}
