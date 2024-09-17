package org.payment.gui.model.internals;

import lombok.Builder;
import lombok.Data;

@Data

public class CreditsResponse {

    private String num;

    private String amount;

    private String ccyCred;
}
