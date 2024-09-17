package org.payment.gui.model.response;

import lombok.*;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentObject {

    private PaymentMessageResponse paymentMessageResponse;


    public void setPaymentMessage(PaymentMessageResponse pymntMsgResp) {
        this.paymentMessageResponse = pymntMsgResp;
    }
}
