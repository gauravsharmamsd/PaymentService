package org.payment.gui.model.request.internals;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data

public class AmountCred {

    private BigDecimal frm;

    private BigDecimal to;

    private String ccyCred;
}
