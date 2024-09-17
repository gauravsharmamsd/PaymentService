package org.payment.gui.cmn;

import java.io.File;
import java.math.BigDecimal;

public class Constants {

	public static final String DONE = "1";
	public static final String NOT_DONE = "0";
	public static final int ZERO_RESULT = 0;
	public static final String NULL_RESPONSE = "Response from DAO is null/Empty.";
	public static final String INVALID_REQUEST = "Request is null.";
	public static final String INVALID_OBJECT = "Null Object";
	public static final String UNDERSCORE = "_";
	public static final String CODETABLE_REFID = "CT_";
	public static final String SUCCESS = "SUCCESS";


	public static final int ONE = 1;
	public static final int ZERO = 0;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int EIGHT = 8;
	public static final int EITHER_FLAG = 2;
	public static final int NEGATIVE_ONE = -1;
	public static final int DETAILS_MAXNUM = 100;

	public static final short ZERO_SHORT = 0;
	public static final short ONE_SHORT = 1;

	public static final Integer RTRX_MIN_RESULT = 100;

	public static final BigDecimal TASK_CANCELLED = BigDecimal.valueOf(1);

	public static final String UTILITY_DELIMITER = "|";

	public static final String ESCAPED_UTILITY_DELIMITER = "\\|";
	
	public static final String SEMI_COLON_DELIMITER = ";";

	public static final String COMMA_DELIMITER = ",";

	public static final double BILWSA_VERSION_P1A1 = 1.0;
	public static final double BILWSA_VERSION_P1A2 = 1.0;

	public static final String FALSE_NUM_VALUE = "0";
	public static final String TRUE_NUM_VALUE = "1";

	public static final String FALSE_STRING_VALUE = "false";
	public static final String TRUE_STRING_VALUE = "true";

	public static final int DO_BACKGROUND_REPORT_ACCEPTED = 1;

	public static final int DO_BACKGROUND_REPORT_NOT_ACCEPTED = 0;
	
	public static final String DEFAULT_TIME = "9999-12-31T00:00:00.0+00:00";

	/**
	 * The String representation for screen Search Message.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_MESSAGE_IN = "Search Message - IN";

	/**
	 * The String representation for screen Search Message.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_MESSAGE_OUT = "Search Message - OUT";

	/**
	 * The String representation for screen Search Bulk.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_BULK_IN = "Search Bulk - IN";

	/**
	 * The String representation for screen Search Bulk.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_BULK_OUT = "Search Bulk - OUT";

	/**
	 * The String representation for screen Search Transaction.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_TRANSACTION = "Search Transaction";

	/**
	 * The String representation for screen Search Booking.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_BOOKING = "Search Booking";

	/**
	 * The String representation for screen Search Log.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_LOG = "Search Log Entries";

	/**
	 * The String representation for screen Search Embargo Check.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_EMBARGO_CHECK = "Search Embargo Check";

	/**
	 * The String representation for screen Search Limit Check.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_LIMIT_CHECK = "Search Limit Check";

	/**
	 * The String representation for screen Search Limit Check.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_EVENT = "Search Event";

	/**
	 * The String representation for screen Search AckNak.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_ACKNAK = "Search AckNak";
	
	/**
	 * The String representation for screen Search Matching Advice.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_MATCHING_ADVICE = "Search Matching Advice";
	
	/**
	 * The String representation for screen Search Matching Advice MT910.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_MATCHING_ADVICE_MT910 = "Search Matching Advice MT910";

	/**
	 * The String representation for screen Search Matching Advice Accompanying Note.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_MATCHING_ADVICE_ACCOMPANYING_NOTE = "Search Matching Advice Accompanying Note";	
	/**
	 * The String representation for screen Search Account Position.
	 */
	public static final String DO_BACKGROUND_REPORT_SEARCH_ACCOUNT_POSITION = "Search Account Position";
	
	/**
	 * Prepend for Code Tables Id.
	 */
	public static final String CODE_TABLE_PREPEND = "CT_";

	/**
	 * Logging comment for Webservice invocation.
	 */
	public static final String LOG_WEBSERVICE_INVOKE = " Webservice Invoked";
	
	/**
	 * Logging comment for Webservice returned an Error.
	 */
	public static final String LOG_WEBSERVICE_RETURNED_ERROR = " Webservice Invocation returned an Error";
	
	/**
	 * Logging comment for Webservice returned Success.
	 */
	public static final String LOG_WEBSERVICE_RETURNED_SUCCESS = " Webservice Invocation returned Success";
	
	/**
	 * Logging comment Database access
	 */
	public static final String LOG_DB_ACCESS = " Accessing Database";
	
	/**
	 * Logging comment Database Error Returned
	 */
	public static final String LOG_DB_ACCESS_RETURNED_ERROR = " Database Access returned an Error";
	
	/**
	 * Loggine comment Database Access Success
	 */
	public static final String LOG_DB_ACCESS_RETURNED_SUCCESS = " Database Access retuned Success";
	
	/**
	 * Logging comment for Caching startup
	 */
	public static final String LOG_CACHING_NOT_DONE = " Starting Caching";
	
	/**
	 * Logging comment for Caching Failed
	 */
	public static final String LOG_CACHING_ERROR = " Caching Failed";
	
	/**
	 * Logging comment for Caching Success
	 */
	public static final String LOG_CACHING_SUCCESS = " Caching Success";
	
	/**
	 * Logging comment for Controlled Error
	 */
	public static final String LOG_CONTROLLED_ERROR = " Encountered a Controlled Error";
	
	/**
	 * Logging comment for Unexpected Error
	 */
	public static final String LOG_UNEXPECTED_ERROR = " Encountered an Unexpected Error";
	
	/**
	 * Properties directory for log4j
	 */
	public static final String PROPERTIES_DIR = "/Parameter/BILWSA/log4j/log4j2.xml";
	
	/**
	 * Properties directory for log4j
	 */
	public static final String PROPERTIES_HOUSEKEEPING_DIR = "/Parameter/BILWSA/log4j/HouseKeeping/log4j2.xml";
	
	/**
	 * Key for the system configuration for logging.
	 */
	public static final String KEY_SYS_CONFIGFILE = "log4j.configurationFile";

	/**
	 * JBoss home directory.
	 */
	public static final String JBOSS_HOME = "JBOSS_HOME";
	
	/**
	 * Alternative for JBOSS_HOME
	 */
	public static final String ALT_JBOSS_DIR = "jboss.home.dir";
	
	/**
	 * Key of the System Properties for the log root directory.
	 */
	public static final String KEY_SYS_LOGROOT = "logRoot";
	
	/**
	 * Key of the System Properties for the log path with tenant id value.
	 */
	public static final String KEY_SYS_TENANT_ID = "logTenantId";
	
	/**
	 * Key of ThreadContext value SERVER_TYPE. Varies depending on Server SOAPLogInfoHandler
	 */
	public static final String KEY_TC_SERVER_TYPE = "SERVER_TYPE";
	
	/**
	 * Log Path Value if we are in BILWSA server based on ThreadContext
	 */
	public static final String VAL_TC_BILWSA = "WSALogBil";
	
	/**
	 * Log Path Value if we are in BILGUI server based on ThreadContext
	 */
	public static final String VAL_TC_BILGUI = "GUILogBil";
	
	/**
	 * Key of dynamic System properties for server log path.  
	 */
	public static final String KEY_SYS_SERVER_LOG_PATH = "logServerPath";
	
	/**
	 * Key of Cross level column id for IN 
	 */
	public static final String CROSS_LEVEL_COLUMN_PREFIX_IN = "in";
	
	/**
	 * Key of Cross level column id for OUT 
	 */
	public static final String CROSS_LEVEL_COLUMN_PREFIX_OUT = "out";
	/**
	 * Key of Cross level column id for OUT 
	 */
	public static final String CROSS_LEVEL_COLUMN_PREFIX_OVERVIEW = "OVERVIEW";
	
	/**
	 * Key of Cross level column id for OUT 
	 */
	public static final String CROSS_LEVEL_COLUMN_PREFIX_NON_PAYMENT = "-req";
	
	/**
	 * Base path for new parameter location 
	 */
	public static final String BASE_PATH_APP = "App";
	
	/**
	 * Path for BILGUI parameter location
	 */
	public static final String BASE_PATH_APP_BILGUI = "App" + File.separator
			+ "BILGUI";
	
	/**
	 * Path for BILWSA parameter location
	 */
	public static final String BASE_PATH_APP_BILWSA = "App" + File.separator
			+ "BILWSA";
	
	/**
	 * Path for LOG4J parameter location
	 */
	public static final String BASE_PATH_APP_BILWSA_LOG4J = "App"
			+ File.separator + "BILWSA" + File.separator + "log4j";
	
	/**
	 * Path for DB parameter location
	 */
	public static final String BASE_PATH_APP_BILWSA_DB = "App" + File.separator
			+ "BILWSA" + File.separator + "Db";
	
	/**
	 * Path for Provider parameter location
	 */
	public static final String BASE_PATH_APP_BILWSA_PROVIDER = "App"
			+ File.separator + "BILWSA" + File.separator + "Provider";
	//SLA
	public static final String CSM_TRANSACTIONSSERVICE_GETTRANSACTIONDETAILS = "CSM_TRANSACTIONSSERVICE.GETTRANSACTIONDETAILS";
	public static final String CSM_TRANSACTIONSSERVICE_SEARCHTRANSACTION = "CSM_TRANSACTIONSSERVICE.SEARCHTRANSACTION";
	
	public static final String CSM_LIQUIDITY_MONITORINGSERVICE_GETPARTICIPANTBALANCE = "CSM_LIQUIDITY_MONITORINGSERVICE.GETPARTICIPANTBALANCE";
	public static final String CSM_LIQUIDITY_MONITORINGSERVICE_GETRECONCILIATIONSUMMARY = "CSM_LIQUIDITY_MONITORINGSERVICE.GETRECONCILIATIONSUMMARY";
	
	public static final String BOTRANSACTIONSERVICE_SEARCHTRANSACTION = "BOTRANSACTIONSERVICE.SEARCHTRANSACTION";
	public static final String BOTRANSACTIONSERVICE_GETTRANSACTIONDETAILS = "BOTRANSACTIONSERVICE.GETTRANSACTIONDETAILS";
	public static final String BOTRANSACTIONSERVICE_AMENDTRANSACTION = "BOTRANSACTIONSERVICE.AMENDTRANSACTION";
	public static final String BOTRANSACTIONSERVICE_CANCELTRANSACTION = "BOTRANSACTIONSERVICE.CANCELTRANSACTION";
	public static final String BOTRANSACTIONSERVICE_DELETETRANSACTION = "BOTRANSACTIONSERVICE.DELETETRANSACTION";
	public static final String BOBULKSERVICE_DELETEBULK = "BOBULKSERVICE.DELETEBULK";
	public static final String BOBULKSERVICE_GETTRANSACTIONFROMBULK = "BOBULKSERVICE.GETTRANSACTIONFROMBULK";
	public static final String BOBULKSERVICE_SEARCHBULK = "BOBULKSERVICE.SEARCHBULK";
	public static final String BOBULKSERVICE_GETBULKDETAILS = "BOBULKSERVICE.GETBULKDETAILS";
	public static final String BOBULKSERVICE_AMENDBULK = "BOBULKSERVICE.AMENDBULK";
	public static final String BOBULKSERVICE_CANCELBULK = "BOBULKSERVICE.CANCELBULK";
	public static final String BOBULKSERVICE_APPROVEBULK = "BOBULKSERVICE.APPROVEBULK";
	public static final String CSMLIQUIDITYFORECASTSERVICE_GETPARTICIPANTFORECAST = "CSMLIQUIDITYFORECASTSERVICE.GETPARTICIPANTFORECAS";
	
	/**
	 * This class holds Logging constants.
	 */
	public static final class LOGGING_IDENTIFIERS {
		/**
		 * The Logging constans for DEBUG.
		 */
		public static final String LOG_DEBUG = "webservices_debug";

		/**
		 * The Logging constans for INFO.
		 */
		public static final String LOG_INFO = "webservices_info";

		/**
		 * The Logging constans for ERROR.
		 */
		public static final String LOG_ERROR = "webservices_error";

		public static final String ES_EXCEPTION = "elastic_search_exception";
	}
	
	/**
	 * External web service response codes
	 */
	public static final String OK = "OK";
	public static final String NOK = "NOK";
	
	public static final String SESSION_CACHE = "sessionCache";
	public static final String ALL = "ALL";
	public static final String LDAP_ALL = "<ALL>";
	public static final String ROOT = "Root";
	public static final int LOGIN_SUCCESS = 7000;
	
	public static final String BILCORE00001 = "BILCORE00001";
	public static final String BILCORE00002 = "BILCORE00002";
	
	/**
	 * Key of Cross level column id for Cross column payment msg req
	 */
	public static final String CROSS_LEVEL_COLUMN_PREFIX_PAYMENT_MSG_REQ = "pymsg-req";

}
