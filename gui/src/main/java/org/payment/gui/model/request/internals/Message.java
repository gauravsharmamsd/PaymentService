package org.payment.gui.model.request.internals;

import lombok.Data;
import org.payment.gui.cmn.XmlRangeDate;


@Data

public class Message {
    private XmlRangeDate date;
    private String bicMlts;
}
