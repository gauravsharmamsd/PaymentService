package org.payment.gui.mapper.request;

import com.equens.bil.core.dto.search.PaymentMessageS;
import org.payment.gui.model.request.PaymentMessageOverviewRequest;

public class PaymentMessageOverviewRequestSCMapper {
    public PaymentMessageS mapPaymentMessageSearchCriteria(PaymentMessageOverviewRequest paymentMessageOverviewRequest) {
        if (null != paymentMessageOverviewRequest) {
            PaymentMessageS paymentMessageS = new PaymentMessageS();
            paymentMessageS.setId(paymentMessageOverviewRequest.getPymntMsgReq().getPayMsgInfo().getId());
            return paymentMessageS;
        }
        return null;
    }
}
