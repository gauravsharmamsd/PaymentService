package org.payment.gui.mapper.response;

import java.util.ArrayList;
import java.util.List;

import com.equens.bil.core.dto.PaymentMessage;
import org.payment.gui.cmn.Constants;
import org.payment.gui.model.internals.IndicatorsPymtMssg;
import org.payment.gui.model.internals.MessageHeader;
import org.payment.gui.model.internals.PaymentMessageHeader;


/**
 * This is a javadoc comment
 * @desc This class is used for PaymentMessageHeaderResponseMapper operations.
 */
public class PaymentMessageHeaderResponseMapper {

    /**
     * @param paymentMessageDTO
     * @method mapPaymentMessageHeader
     * @return PaymentMessageHeader
     * @desc This method is used for mapPaymentMessageHeader operations.
     */
    public PaymentMessageHeader mapPaymentMessageHeader(PaymentMessage paymentMessageDTO) {
        PaymentMessageHeader paymentMessageHeader = new PaymentMessageHeader();
        MessageHeaderResponseMapper<PaymentMessage> messageHeaderMapper = new MessageHeaderResponseMapper<>();

        // Set the MessageHeader
        List<MessageHeader> messageHeader = new ArrayList<>();

        // Note: Front end guys are only expecting one message header
        if (null != paymentMessageDTO) {
            messageHeader.add(messageHeaderMapper.mapMessageHeader(paymentMessageDTO));

            for (MessageHeader msgHdr : messageHeader) {
                paymentMessageHeader.getMsgHdr().add(msgHdr);
            }

            if (null != paymentMessageDTO.getId()) {
                paymentMessageHeader.setId(paymentMessageDTO.getId());
            }

            if (null != paymentMessageDTO.getPriority()) {
                paymentMessageHeader.setPrio(convertBooleanToInt(paymentMessageDTO.getPriority()).toString());
            }

            if (null != paymentMessageDTO.getFileReference()) {
                paymentMessageHeader.setFileRef(paymentMessageDTO.getFileReference());
            }

            if (null != paymentMessageDTO.getSender()) {
                paymentMessageHeader.setSender(paymentMessageDTO.getSender());
            }

            if (null != paymentMessageDTO.getReceiver()) {
                paymentMessageHeader.setReceiver(paymentMessageDTO.getReceiver());
            }

            if (null != paymentMessageDTO.getMessageState()) {
                paymentMessageHeader.setState(paymentMessageDTO.getMessageState().toString());
            }

            if (null != paymentMessageDTO.getPaymentFileFragment()) {
                paymentMessageHeader.setFragment(paymentMessageDTO.getPaymentFileFragment());
            }

            IndicatorsPymtMssg indicators = new IndicatorsPymtMssg();
            if (null != paymentMessageDTO.getApprovalIndicator()) {
                indicators.setApp(paymentMessageDTO.getApprovalIndicator().toString());
            }

            if (null != paymentMessageDTO.getErrorIndicator()) {
                indicators.setErr(paymentMessageDTO.getErrorIndicator().toString());
            }

            paymentMessageHeader.setIndicators(indicators);

            // Channel is no longer used for in the PaymentMessageResponse. Instead,
            // Application is used to hold the channel Id.

			/*Channel channel = new Channel();

			if (null != paymentMessageDTO.getChannelID() && null != paymentMessageDTO.getApplication() && null != paymentMessageDTO.getApplication().getId()) {
				channel.setId(paymentMessageDTO.getApplication().getId());
			}

			if (null != paymentMessageDTO.getChannelName() && null != paymentMessageDTO.getApplication() && null != paymentMessageDTO.getApplication().getName()) {
				channel.setName(paymentMessageDTO.getApplication().getName());
			}*/

            //paymentMessageHeader.setChannel(channel);

            if (null != paymentMessageDTO.getReproducedFlag()) {
                paymentMessageHeader.setReproducedFlag(String
                        .valueOf(convertBooleanToInt(paymentMessageDTO
                                .getReproducedFlag())));
            }

            if (null != paymentMessageDTO.getOriginalMessageId()) {
                paymentMessageHeader.setOriginalMessageId(paymentMessageDTO.getOriginalMessageId().toString());
            }
        }

        return paymentMessageHeader;
    }

    /**
     * Convert boolean value to Integer.
     *
     * @param bool
     *            boolean value
     * @return Integer value
     */
    private static Integer convertBooleanToInt(Boolean bool) {
        if (bool) {
            return Constants.ONE;
        } else {
            return Constants.ZERO;
        }
    }
}
