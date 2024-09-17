package org.payment.gui.cmn;

import lombok.*;

@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupHeaderResponse {
    private String done;
    private DataFacts dtFcts;
    private ResponseDiagnostics returnCodes;
}
