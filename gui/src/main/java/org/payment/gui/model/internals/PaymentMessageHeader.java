package org.payment.gui.model.internals;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class PaymentMessageHeader {
    private List<MessageHeader> msgHdr = new ArrayList<>();
    private Long id;
    private String prio;
    private String fileRef;
    private String sender;
    private String receiver;
    private String state;
    private String fragment;
    private IndicatorsPymtMssg indicators;
    private String reproducedFlag;
    private String originalMessageId;
}
