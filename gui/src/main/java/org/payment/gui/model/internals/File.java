package org.payment.gui.model.internals;

import lombok.Builder;
import lombok.Data;

@Data

public class File {

    private String name;
    private Long typId;
    private String origName;
    private Long size;
}
