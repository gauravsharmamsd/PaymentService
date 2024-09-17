
package org.payment.gui.mapper.response;


import com.equens.bil.core.dto.Message;
import com.equens.bil.core.dto.PaymentMessage;

import org.payment.gui.cmn.Application;
import org.payment.gui.cmn.Channel;
import org.payment.gui.cmn.Constants;
import org.payment.gui.model.internals.File;
import org.payment.gui.model.internals.IndicatorsMssg;
import org.payment.gui.model.internals.MessageHeader;


public class MessageHeaderResponseMapper <T extends Message>{
    protected File getFile(String fileName, Long fileTypeId,
                           String originalFileName, Long fileSizeInBytes) {
        File file = new File();
        file.setName(fileName);
        file.setTypId(fileTypeId);
        file.setOrigName(originalFileName);

        if (null != fileSizeInBytes) {
            file.setSize(fileSizeInBytes);
        }

        return file;
    }

    protected IndicatorsMssg getIndicatorsMssg(Short appInd, Short errInd, Boolean inOut){
        IndicatorsMssg indicator = new IndicatorsMssg();
        indicator.setAppInd(appInd);
        indicator.setErrInd(errInd);

        if (null != inOut && inOut) {
            indicator.setInOut((short) Constants.ONE);
        } else {
            indicator.setInOut((short) Constants.ZERO);
        }

        return indicator;
    }

    /**
     * Map the MessageHeader to be set in PaymentMessageHeader.
     *
     * @param paymentMessageDTO
     *            the PaymentMessage DTO.
     * @return MessageHeader response
     */
    public MessageHeader mapMessageHeader(Message paymentMessageDTO) {
        MessageHeader messageHeader = new MessageHeader();

        if (null != paymentMessageDTO) {

            messageHeader.setId(paymentMessageDTO.getId());

            if (null != paymentMessageDTO.getPriority()) {
                if (paymentMessageDTO.getPriority()) {
                    messageHeader.setPrio(String.valueOf(Constants.ONE));
                } else {
                    messageHeader.setPrio(String.valueOf(Constants.ZERO));
                }
            }

            messageHeader.setFile(getFile(paymentMessageDTO.getFileName(),
                    paymentMessageDTO.getFileTypeId(),
                    paymentMessageDTO.getOriginalFileName(),
                    paymentMessageDTO.getFileSizeInBytes()));

            messageHeader.setMsgState(paymentMessageDTO.getMessageState());

            if(null != paymentMessageDTO.getSubState()) {
                messageHeader.setSubState(paymentMessageDTO.getSubState());
            }

            messageHeader.setInd(getIndicatorsMssg(
                    paymentMessageDTO.getApprovalIndicator(),
                    paymentMessageDTO.getErrorIndicator(),
                    paymentMessageDTO.getInOutIndicator()));

            messageHeader.setEnvHdr(paymentMessageDTO.getEnvelopeHeader());

            if (paymentMessageDTO instanceof PaymentMessage && null != paymentMessageDTO.getApplication()) {

                Application application = new Application();
                application.setId(paymentMessageDTO.getApplication().getId());
                application.setName(paymentMessageDTO.getApplication().getName());
                messageHeader.setAppl(application);
            } else {
                if (null != paymentMessageDTO.getApplication()) {
                    Application application = new Application();
                    application.setId(paymentMessageDTO.getApplication()
                            .getId());
                    application.setName(paymentMessageDTO.getApplication()
                            .getName());
                    messageHeader.setAppl(application);
                }
            }

            if (paymentMessageDTO instanceof PaymentMessage && null != ((PaymentMessage) paymentMessageDTO).getChannelName()) {
                PaymentMessage paymentMessage = (PaymentMessage) paymentMessageDTO;
                Channel channel = new Channel();
                channel.setId(paymentMessage.getChannelID());
                channel.setName(paymentMessage.getChannelName());
                messageHeader.setChannel(channel);
            }
        }



        return messageHeader;
    }

}
