package org.payment.commons.utility;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utility Class for Date Formatting and Handling
 * 
 * @author lunam
 */
public class DateUtil {

	/**
	 * This class holds the date/time formats used.
	 */
	public static class FORMATS {

		/**
		 * The date/time format found within the grid displays, such as message overview.<br>
		 * Format: <strong>dd.MM.yyyy hh:mm:ss</strong>
		 */
		public static final String DDMMYYYY_HHMMSS = "dd.MM.yyyy hh:mm:ss";

		/**
		 * The date/time format found within the grid displays, such as message overview.<br>
		 * Format: <strong>dd.MM.yyyy hh-mm-ss</strong>
		 */
		public static final String DDMMYYYY_HHMMSS_HYPHEN = "dd.MM.yyyy hh-mm-ss";

		/**
		 * The shorter format for date/time found within the grid displays, such as bulk overview.<br>
		 * Format: <strong>dd.MM.yyyy</strong>
		 */
		public static final String DDMMYYYY = "dd.MM.yyyy";
	}
	
	/**
	 * This method formats a given date (as XMLGregorianCalendar) with the given format.
	 * 
	 * @param xgc - the date/time to format.
	 * @param dateFormat - the desired format.
	 * @return String - the formatted date in form of string. Returns null if any related exceptions has been encountered.
	 */
	public static String formatDateTime(final XMLGregorianCalendar xgc, final String dateFormat) {
		xgc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);//Note: Added this line to the code to disregard the timezone of the requested date and time
		final Date dateTime = DateUtil.asDate(xgc);
		return formatDateTime(dateTime, dateFormat);
	}

	/**
	 * This method formats a given date/time with the given format.
	 *
	 * @param dateTime
	 *            - the date/time to format.
	 * @param dateFormat
	 *            - the desired format.
	 * @return String - the formatted date in form of string. Returns null if any related exceptions has been encountered.
	 */
	public static String formatDateTime(final Date dateTime, final String dateFormat) {

		String strDate;
		try {
			final SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
			strDate = fmt.format(dateTime);

		} catch (final NullPointerException npe) {
			strDate = null;
		} catch (final IllegalArgumentException iae) {
			strDate = null;
		}

		return strDate;
	}
	
	/**
     * Needed to create XMLGregorianCalendar instances
     */
    private static DatatypeFactory df = null;
    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                "Exception while obtaining DatatypeFactory instance", dce);
        }
    }  

    /**
     * Converts a java.util.Date into an instance of {@link XMLGregorianCalendar}.
     *
     * @param date Instance of java.util.Date or a null reference
     * @return {@link XMLGregorianCalendar} instance whose value is based upon the
     *  value in the date parameter. If the date parameter is null then
     *  this method will simply return null.
     */
    public static XMLGregorianCalendar asXMLGregorianCalendar(Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            XMLGregorianCalendar xmlGreg = df.newXMLGregorianCalendar(gc);
            xmlGreg.setTimezone(DatatypeConstants.FIELD_UNDEFINED);//Note: Added this line to the code to disregard the timezone of the requested date and time
            return xmlGreg;
        }
    }
    
    /**
     * Converts a GregorianCalendar into an instance of {@link XMLGregorianCalendar}.
     *
     * @param date Instance of GregorianCalendar or a null reference
     * @return XMLGregorianCalendar instance whose value is based upon the
     *  value in the date parameter. If the date parameter is null then
     *  this method will simply return null.
     */
    public static XMLGregorianCalendar asXMLGregorianCalendar(GregorianCalendar date) {
        if (date == null) {
            return null;
        } else {
        	   XMLGregorianCalendar xmlGreg = df.newXMLGregorianCalendar(date);
               xmlGreg.setTimezone(DatatypeConstants.FIELD_UNDEFINED);//Note: Added this line to the code to disregard the timezone of the requested date and time
               return xmlGreg;     
        }
    }
    
    /**
     * Converts a String into an instance of {@link XMLGregorianCalendar}.
     *
     * @param date Valid Date or a null reference
     * @return XMLGregorianCalendar instance whose value is based upon the
     *  value in the date parameter. If the date parameter is null then
     *  this method will simply return null.
     */
    public static XMLGregorianCalendar asXMLGregorianCalendar(String date) {
        if (null == date || date.isEmpty()) {
            return null;
        } else {        	
        	XMLGregorianCalendar xmlGreg = df.newXMLGregorianCalendar(date);
        	xmlGreg.setTimezone(DatatypeConstants.FIELD_UNDEFINED);//Note: Added this line to the code to disregard the timezone of the requested date and time
            return xmlGreg; 
        }
    }

	/**
	 * Converts a java.util.Date into an instance of {@link String}.
	 *
	 * @param date Instance of java.util.Date or a null reference, zoneId of ZoneId.
	 * @return {@link String} instance whose value is based upon the
	 *  value in the date parameter. If the date parameter is null then
	 *  this method will simply return null.
	 */
	public static String asZonedDateTimeString(Date date, ZoneId zoneId) {
		if (date == null) {
			return null;
		} else {
			//ZoneId zone = ZoneId.of("Europe/Berlin");
			//final ZoneId zone = ZoneId.systemDefault();
			return date.toInstant().atZone(zoneId).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
	}

	/**
	 * Converts a java.util.Date into an instance of {@link XMLGregorianCalendar}.
	 *
	 * @param date Instance of java.util.Date or a null reference, zoneId of ZoneId.
	 * @return {@link XMLGregorianCalendar} instance whose value is based upon the
	 *  value in the date parameter. If the date parameter is null then
	 *  this method will simply return null.
	 */
	public static XMLGregorianCalendar asZonedDateTimeXMLGregorianCalendar(Date date, ZoneId zoneId) {
		if (date == null) {
			return null;
		} else {
			//ZoneId zone = ZoneId.of("Europe/Berlin");
			//ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
			ZonedDateTime zonedDateTime = date.toInstant().atZone(zoneId);
			GregorianCalendar gc = GregorianCalendar.from(zonedDateTime);
			return df.newXMLGregorianCalendar(gc);
		}
	}

	/**
	 * Converts a java.util.XMLGregorianCalendar into an instance of {@link XMLGregorianCalendar}.
	 *
	 * @param date Instance of java.util.XMLGregorianCalendar or a null reference, zoneId of ZoneId.
	 * @return {@link XMLGregorianCalendar} instance whose value is based upon the
	 *  value in the date parameter. If the date parameter is null then
	 *  this method will simply return null.
	 */
	public static XMLGregorianCalendar asZonedDateTimeXMLGregorianCalendar(XMLGregorianCalendar date, ZoneId zoneId) {
		if (date == null) {
			return null;
		} else {
			ZonedDateTime zonedDateTime = date.toGregorianCalendar().toInstant().atZone(zoneId);
			GregorianCalendar gc = GregorianCalendar.from(zonedDateTime);
			return df.newXMLGregorianCalendar(gc);
		}
	}

    /**
     * Converts an XMLGregorianCalendar to an instance of {@link Date}.
     *
     * @param xgc Instance of XMLGregorianCalendar or a null reference
     * @return java.util.Date instance whose value is based upon the
     *  value in the xgc parameter. If the xgc parameter is null then
     *  this method will simply return null.
     */
    public static Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
        	xgc.setTimezone(DatatypeConstants.FIELD_UNDEFINED);//Note: Added this line to the code to disregard the timezone of the requested date and time
            return xgc.toGregorianCalendar().getTime();
        }
    }
    
    
    /**
     * This method is used to set DATE and TIME passed by GUI.
     * 
     * @param date {@link XMLGregorianCalendar} Date Parameter
     * @param time {@link XMLGregorianCalendar} Time Parameter
     * @return {@link XMLGregorianCalendar} Mapped Date from Front-End Date and Time Parameters
     */
    public static XMLGregorianCalendar setDateAndTime(XMLGregorianCalendar date,XMLGregorianCalendar time){    	
		GregorianCalendar gcDate = new GregorianCalendar();		
		gcDate.set(date.getYear(), date.getMonth() -1, date.getDay(), time.getHour(), time.getMinute(), time.getSecond());
    	return asXMLGregorianCalendar(gcDate);
    }
    
    /**
     * This method is used to set DATE and default TIME passed by GUI.
     * 
     * @param date {@link XMLGregorianCalendar} Date Parameter
     * @return {@link XMLGregorianCalendar} Mapped Date from Front-End Date and Time Parameters
     */
    public static XMLGregorianCalendar setDate(XMLGregorianCalendar date){    	
		GregorianCalendar gcDate = new GregorianCalendar();		
		gcDate.set(date.getYear(), date.getMonth() -1, date.getDay());    	
    	return asXMLGregorianCalendar(gcDate);
    }
    
    /**
     * Converts XMLGregorianCalendar to String.
     * @param date
     * @return String representation or null.
     */
    public static String asString(XMLGregorianCalendar date){
    	String s = null;
    	if(null != date){
    		s = date.toString();
    	}
    	return s;
    }

}
