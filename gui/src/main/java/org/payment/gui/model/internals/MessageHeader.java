package org.payment.gui.model.internals;

import lombok.Data;
import org.payment.gui.cmn.Application;
import org.payment.gui.cmn.Channel;


@Data

public class MessageHeader {
    private Long id;
    private String prio;
    private File file;
    private Long msgState;
    private Long subState;
    private IndicatorsMssg ind;
    private String envHdr;
    private Application appl;
    private Channel channel;
    private String msgPartitionKey;
}
