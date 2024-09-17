package org.payment.gui.model.response;

import lombok.Data;

import org.payment.gui.model.internals.*;

@Data


public class PaymentMessageResponse {

    private PaymentMessageHeader payMsgInfo;

    private String processingDate;

    private String importDtTm;
    private String createDtTim;
    private String outputDt;
    private CreditsResponse credit;
    private DebitsResponse debit;
    private BranchHeader branch;
    private String action;
    protected NoOfBulks noOfBulks;
    private String multiEyeTrigger;
    private String ackNakOutputDate;
    private String incMtMxMsgInd;
    private String sendingSystem;
}
