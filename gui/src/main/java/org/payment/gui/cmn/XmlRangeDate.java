
package org.payment.gui.cmn;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.datatype.XMLGregorianCalendar;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class XmlRangeDate {

    private XMLGregorianCalendar to;

    private XMLGregorianCalendar frm;

}
