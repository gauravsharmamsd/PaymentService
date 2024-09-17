package org.payment.gui.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.payment.gui.cmn.GroupHeader;


import java.util.ArrayList;
import java.util.List;
@Data

@Getter
@Setter
public class PaymentMessageOverviewResponse {
    private GroupHeader grpHdr;

    private List<PaymentObject> payObj = new ArrayList<PaymentObject>();


    private String done;

    public void setPaymentObjects(List<PaymentObject> pymntObjList) {
        this.payObj = pymntObjList;
    }
}
