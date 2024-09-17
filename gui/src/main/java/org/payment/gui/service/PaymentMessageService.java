package org.payment.gui.service;

import com.equens.bil.core.BilException;
import com.equens.bil.core.dao.cursors.Cursor;
import com.equens.bil.core.dto.PaymentMessage;
import com.equens.bil.core.dto.enums.PaymentMessageE;

import com.equens.bil.core.dto.search.PaymentMessageS;
import org.payment.gui.model.BaseExecutor;
import org.payment.gui.mapper.request.PaymentMessageOverviewRequestSCMapper;
import org.payment.gui.mapper.response.PaymentMessageResponseMapper;
import org.payment.gui.model.response.PaymentObject;
import org.payment.gui.model.request.PaymentMessageOverviewRequest;
import org.payment.gui.model.response.PaymentMessageOverviewResponse;
import org.payment.gui.model.response.PaymentMessageResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentMessageService extends BaseExecutor {


    public PaymentMessageOverviewResponse getPaymentMessagesOverview(PaymentMessageOverviewRequest paymentMessageOverviewRequest) throws BilException {

        Map<Integer, Boolean> requestMap = requestedLDMs();
        PaymentMessageS paymentMessageS = translateRequest(paymentMessageOverviewRequest);
        int maxnum = paymentMessageOverviewRequest.getGrpHdrReq().getMaxNum() + 1;

        //actual call to get the payment message
        Cursor<PaymentMessage> paymentMessageOverview = getDAOFactory().getPaymentMessageOverview()
                .getPaymentMessageOverview(paymentMessageS,
                        maxnum, requestMap, null);


        //iterate over the result and map it to the response object
        List<PaymentObject> pymntObjList = itereateResultFromCursor(paymentMessageOverview);


        PaymentMessageOverviewResponse paymentMessageOverviewResponse = new PaymentMessageOverviewResponse();
        paymentMessageOverviewResponse.setPaymentObjects(pymntObjList);
        return paymentMessageOverviewResponse;


    }

    private static PaymentMessageS translateRequest(PaymentMessageOverviewRequest paymentMessageOverviewRequest) {
        PaymentMessageOverviewRequestSCMapper reqMapper = new PaymentMessageOverviewRequestSCMapper();
        PaymentMessageS paymentMessageS = reqMapper.mapPaymentMessageSearchCriteria(paymentMessageOverviewRequest);
        return paymentMessageS;
    }

    private static List<PaymentObject> itereateResultFromCursor(Cursor<PaymentMessage> paymentMessageOverview) throws BilException {
        PaymentMessage next = paymentMessageOverview.getNext();
        List<PaymentObject> pymntObjList = new ArrayList<>();
        while (next != null) {
            PaymentMessageResponseMapper pmtMsgRespMapper = new PaymentMessageResponseMapper();
            PaymentMessageResponse pymntMsgResp = pmtMsgRespMapper
                    .mapPaymentMessageResponseCursor(next);

            PaymentObject pymntObj = new PaymentObject();

            pymntObj.setPaymentMessage(pymntMsgResp);

            pymntObjList.add(pymntObj);

            next = paymentMessageOverview.getNext();

        }
        return pymntObjList;
    }

    private static Map<Integer, Boolean> requestedLDMs() {
        Map<Integer, Boolean> requestMap = new HashMap<>();

        PaymentMessageE[] values = PaymentMessageE.values();
        for (PaymentMessageE value : values) {
            requestMap.put(value.getType(), Boolean.TRUE);
        }

        return requestMap;
    }

    private static PaymentMessageOverviewResponse mock() {
        return null;
    }
}
