package org.payment.gui.cmn;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ResponseDiagnostics {
    private List<ErrorMessageContent> errMsgCntnt = new ArrayList<ErrorMessageContent>();
}
