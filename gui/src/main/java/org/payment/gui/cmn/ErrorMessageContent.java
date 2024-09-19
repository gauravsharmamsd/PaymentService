package org.payment.gui.cmn;



import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMessageContent {
    private String errCount;
    private String errCd;
    private List<String> param = new ArrayList<String>();

}
