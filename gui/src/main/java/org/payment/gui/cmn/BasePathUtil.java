package org.payment.gui.cmn;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class BasePathUtil {
	private static final Logger LOG = LogManager.getLogger(BasePathUtil.class);

	public static String getBasePath() {
		String basePath = System.getProperty("equens.bil.param.base_path");
		if (null == basePath) {
			throw new RuntimeException(
					"System property \"equens.bil.param.base_path\" not set!");
		}
		return basePath;
	}

	public static String getAppPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP;
		} else {
			path = basePath + File.separator + Constants.BASE_PATH_APP;
		}
		return path;
	}

	public static String getBILGUIPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP_BILGUI;
		} else {
			path = basePath + File.separator + Constants.BASE_PATH_APP_BILGUI;
		}
		return path;
	}

	public static String getBILWSAPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP_BILWSA;
		} else {
			path = basePath + File.separator + Constants.BASE_PATH_APP_BILWSA;
		}
		return path;
	}

	public static String getLog4jPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP_BILWSA_LOG4J;
		} else {
			path = basePath + File.separator
					+ Constants.BASE_PATH_APP_BILWSA_LOG4J;
		}
		return path;
	}

	public static String getDbPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP_BILWSA_DB;
		} else {
			path = basePath + File.separator
					+ Constants.BASE_PATH_APP_BILWSA_DB;
		}
		return path;
	}

	public static String getProviderPath() {
		String basePath = getBasePath();
		String path = null;
		if (basePath.endsWith(File.separator)) {
			path = basePath + Constants.BASE_PATH_APP_BILWSA_PROVIDER;
		} else {
			path = basePath + File.separator
					+ Constants.BASE_PATH_APP_BILWSA_PROVIDER;
		}
		return path;
	}

	public static String getBILGUIIPPropertyFilePath() {
		return getBILGUIPath() + File.separator + "BILGUI_IP.properties";
	}

	public static String getLog4jConfigurationFilePath() {
		return getLog4jPath() + File.separator + "log4j2.xml";
	}

	public static String getDAOPropertyFilePath() {
		return getDbPath() + File.separator + "Dao.properties";
	}

	public static String getLDAPPropertyFilePath() {
		return getProviderPath() + File.separator + "Ldap.properties";
	}

	public static String getBILCOREFilePath() {
		return getProviderPath() + File.separator + "BILCORE.properties";
	}
	
	public static String getExternalWSTenantID() {
		String extTenantID = System.getProperty("equens.zvs.tenant.id");
		if (null == extTenantID) {
			throw new RuntimeException(
					"System property \"equens.zvs.tenant.id\" not set!");
		}		
		return extTenantID;
	}

	public static Map getPropertyMap(String filePath) {
		Properties props = new Properties();
		FileInputStream in = null;
		try {
			LOG.info("[9509 GET PROPERTIES] : " + filePath);

			in = new FileInputStream(filePath);
			props.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Properties not properly initialized", e);
		}
		return props;
	}
}
