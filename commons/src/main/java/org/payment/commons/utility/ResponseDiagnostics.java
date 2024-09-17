package org.payment.commons.utility;

import lombok.*;


import java.util.ArrayList;
import java.util.List;
@Data

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ResponseDiagnostics {
    private List<ErrorMessageContent> errMsgCntnt = new ArrayList<ErrorMessageContent>();
}
