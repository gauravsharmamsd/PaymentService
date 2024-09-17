package org.payment.gui.model.request;

import lombok.Data;
import org.payment.gui.cmn.GroupHeaderReq;


@Data

public class PaymentMessageOverviewRequest {

    private GroupHeaderReq grpHdrReq;

    private PaymentMessageRequest pymntMsgReq;
}
