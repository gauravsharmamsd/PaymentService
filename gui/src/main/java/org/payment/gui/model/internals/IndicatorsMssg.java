package org.payment.gui.model.internals;

import lombok.Builder;
import lombok.Data;

@Data

public class IndicatorsMssg {
    private Short inOut;
    private Short errInd;
    private Short appInd;
}
