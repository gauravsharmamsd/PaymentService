package org.payment.gui.service;

import com.equens.bil.core.BilException;
import com.equens.bil.core.dao.cursors.Cursor;
import com.equens.bil.core.dto.PaymentMessage;
import com.equens.bil.core.dto.enums.MessageE;
import com.equens.bil.core.dto.enums.PaymentMessageE;

import com.equens.bil.core.dto.enums.PaymentObjectE;
import com.equens.bil.core.dto.search.PaymentMessageS;
import org.payment.gui.cmn.ErrorMessageContent;
import org.payment.gui.cmn.GroupHeader;
import org.payment.gui.cmn.ResponseDiagnostics;
import org.payment.gui.model.BaseExecutor;
import org.payment.gui.mapper.request.PaymentMessageOverviewRequestSCMapper;
import org.payment.gui.mapper.response.PaymentMessageResponseMapper;
import org.payment.gui.model.response.PaymentObject;
import org.payment.gui.model.request.PaymentMessageOverviewRequest;
import org.payment.gui.model.response.PaymentMessageOverviewResponse;
import org.payment.gui.model.response.PaymentMessageResponse;
import org.springframework.stereotype.Service;

import java.util.*;

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


        paymentMessageOverviewResponse.setGrpHdr(
                GroupHeader.builder()
                        .responseDiagnostics(
                                ResponseDiagnostics.builder()
                                        .errMsgCntnt(Collections.singletonList(
                                                ErrorMessageContent.builder()
                                                        .errCd("0000")
                                                        .errCount("1")
                                                        .build()
                                        ))
                                        .build()
                        )
                        .build()
        );
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
        for (MessageE fieldId : MessageE.values()) {
            requestMap.put(fieldId.getType(), Boolean.TRUE);
        }
        // remove field ID for Message.id; will be fetched by PaymentMessage.id
        requestMap.remove(MessageE.MESSAGE_ID.getType());
        requestMap.remove(MessageE.IN_OUT_INDICATOR.getType());
        requestMap.put(PaymentObjectE.PRIORITY.getType(), Boolean.TRUE);
        requestMap.put(PaymentObjectE.BRANCH.getType(), Boolean.TRUE);
        return requestMap;
    }

    private static PaymentMessageOverviewResponse mock() {
        return null;
    }
}
