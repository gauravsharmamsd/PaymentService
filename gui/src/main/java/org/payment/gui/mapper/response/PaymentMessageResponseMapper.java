package org.payment.gui.mapper.response;

import com.equens.bil.core.dto.PaymentMessage;

import org.payment.gui.cmn.DateUtil;
import org.payment.gui.model.internals.CreditsResponse;
import org.payment.gui.model.internals.DebitsResponse;
import org.payment.gui.model.internals.NoOfBulks;
import org.payment.gui.model.response.PaymentMessageResponse;

import java.util.Objects;

public class PaymentMessageResponseMapper {
    public PaymentMessageResponse mapPaymentMessageResponseCursor(
            PaymentMessage paymentMessageDTO) {

        // Set PaymentMessage Response
        PaymentMessageResponse paymentMsgResp = new PaymentMessageResponse();

        if (!Objects.isNull(paymentMessageDTO)) {

            BranchTranslator bTr = new BranchTranslator();
            paymentMsgResp.setBranch(bTr.toBranchHeaderResponse(paymentMessageDTO.getBranch()));

            //TODO: Add action mapping when it becomes available in bilcore jar. 

            if (!Objects.isNull(paymentMessageDTO.getProcessingDate())) {
                paymentMsgResp.setProcessingDate(DateUtil.asString(DateUtil
                        .asXMLGregorianCalendar(paymentMessageDTO
                                .getProcessingDate())));
            }

            if (!Objects.isNull(paymentMessageDTO.getIncMtMxMsgInd())) {
                paymentMsgResp.setIncMtMxMsgInd(paymentMessageDTO.getIncMtMxMsgInd());
            }


            if(!Objects.isNull(paymentMessageDTO.getNumberOfBulkCredit()) || !Objects.isNull(paymentMessageDTO.getNumberOfBulkDebit())){
                NoOfBulks noOfBulks = new NoOfBulks();
                noOfBulks.setCredit(String.valueOf(paymentMessageDTO.getNumberOfBulkCredit()));
                noOfBulks.setDebit(String.valueOf(paymentMessageDTO.getNumberOfBulkDebit()));

                paymentMsgResp.setNoOfBulks(noOfBulks);
            }

            if (!Objects.isNull(paymentMessageDTO
                    .getCreationDateTime())) {
                paymentMsgResp.setCreateDtTim(DateUtil.asString(DateUtil
                        .asXMLGregorianCalendar(paymentMessageDTO
                                .getCreationDateTime())));
            }

            if (!Objects.isNull(paymentMessageDTO.getImportDateTime())) {

                paymentMsgResp.setImportDtTm(DateUtil.asString(DateUtil
                        .asXMLGregorianCalendar(paymentMessageDTO
                                .getImportDateTime())));
            }

            if (!Objects.isNull(paymentMessageDTO.getOutputDate())) {
                paymentMsgResp.setOutputDt(DateUtil.asString(DateUtil
                        .asXMLGregorianCalendar(paymentMessageDTO
                                .getOutputDate())));
            }

            // Set the Credits
            CreditsResponse credits = new CreditsResponse();
            if (!Objects.isNull(paymentMessageDTO
                    .getAmountOfCredits())) {
                credits.setAmount(String.valueOf(paymentMessageDTO.getAmountOfCredits()));
            }

            if (!Objects.isNull(paymentMessageDTO
                    .getNumberOfCredits())) {
                credits.setNum(String.valueOf(paymentMessageDTO.getNumberOfCredits()));
            }

            paymentMsgResp.setCredit(credits);

            // Set the Debits
            DebitsResponse debits = new DebitsResponse();

            if (!Objects.isNull(paymentMessageDTO.getAmountOfDebits())) {
                debits.setAmount(String.valueOf(paymentMessageDTO.getAmountOfDebits()));
            }

            if (!Objects.isNull(paymentMessageDTO.getNumberOfDebits())) {
                debits.setNum(String.valueOf(paymentMessageDTO.getNumberOfDebits()));
            }

            if(null != paymentMessageDTO.getActions()){
                paymentMsgResp.setAction(paymentMessageDTO.getActions());
            }

            paymentMsgResp.setDebit(debits);

            if(null != paymentMessageDTO.getMultiEyeTrigger()){
                paymentMsgResp.setMultiEyeTrigger(paymentMessageDTO.getMultiEyeTrigger().name());
            }

            if(null != paymentMessageDTO.getAcknakOutputDate()){
                paymentMsgResp.setAckNakOutputDate(DateUtil.asString(DateUtil
                        .asXMLGregorianCalendar(paymentMessageDTO
                                .getAcknakOutputDate())));
            }

            if(null != paymentMessageDTO.getSendingSystem()){
                paymentMsgResp.setSendingSystem(paymentMessageDTO.getSendingSystem());
            }






            PaymentMessageHeaderResponseMapper paymentMessageHeaderResponseMapper = new PaymentMessageHeaderResponseMapper();
            paymentMsgResp.setPayMsgInfo(paymentMessageHeaderResponseMapper.mapPaymentMessageHeader(paymentMessageDTO));

        }

        return paymentMsgResp;
    }

}
