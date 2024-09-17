package org.payment.gui.model.request.internals;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data

public class AmountDeb {
    private BigDecimal to;

    private BigDecimal frm;

    private String ccyDeb;
}
