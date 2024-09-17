package org.payment.gui.model;

import com.equens.bil.core.BilException;
import com.equens.bil.core.dao.DAOFactory;
import org.payment.gui.cmn.BasePathUtil;


import java.util.Map;

public class BaseExecutor {
    protected DAOFactory getDAOFactory() throws BilException {
        return DAOFactory.getInstance(getProperties());
    }
    protected java.util.Properties getProperties() {
        java.util.Properties props = new java.util.Properties();
        Map<String, String> propertiesMap = BasePathUtil.getPropertyMap(BasePathUtil.getDAOPropertyFilePath());
        for (Map.Entry<String, String> entry : propertiesMap.entrySet()) {
            props.setProperty(entry.getKey(), entry.getValue());
        }
        return props;
    }
}
