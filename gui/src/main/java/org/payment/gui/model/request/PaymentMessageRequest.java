package org.payment.gui.model.request;


import lombok.Data;

import org.payment.gui.cmn.Application;
import org.payment.gui.cmn.Channel;
import org.payment.gui.model.internals.BranchHeader;
import org.payment.gui.model.internals.PaymentMessageHeader;

import org.payment.gui.model.request.internals.*;

import java.util.ArrayList;
import java.util.List;

@Data

public class PaymentMessageRequest {
    private PaymentMessageHeader payMsgInfo;
    private ProcessingDate processingDate;
    private ImportDateTime importDtTm;
    private CreationDateTime createDtTim;
    private OutputDate outputDt;
    private Credits credit;
    private Debits debit;
    private FileSizeInBytes size;
    private MultiSearchMssg multiSearch;
    private List<Application> appl = new ArrayList<>();
    protected List<Channel> channel;
    private List<Long> fileTypeId = new ArrayList<>();
    private List<BranchHeader> branch = new ArrayList<>();
    private List<Long> channelIDs = new ArrayList<>();
    private List<String> sendingSystem = new ArrayList<>();
}
