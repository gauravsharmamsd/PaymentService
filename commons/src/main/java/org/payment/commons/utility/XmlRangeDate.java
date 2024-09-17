
package org.payment.commons.utility;


import lombok.AllArgsConstructor;
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
