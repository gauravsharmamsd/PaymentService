package org.payment.commons.utility;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WSResponseDiagnostic {
	
	private List<ErrorMessageContent> errorMesageContent;

	public WSResponseDiagnostic() {

		errorMesageContent = new ArrayList<ErrorMessageContent>();
	}
	

	public WSResponseDiagnostic(String errorCode, String... param) {
		this();
		addErrorMessageContent(errorCode, param);
	}
	

	public void addErrorMessageContent(String errorCode, String... param) {
		ErrorMessageContent errorMessageContent = new ErrorMessageContent();
		errorMessageContent.setErrCount(String.valueOf(getErrMsgCntntCount() + 1));
		errorMessageContent.setErrCd(errorCode);
		errorMessageContent.getParam().addAll(Arrays.asList(param));
		errorMesageContent.add(errorMessageContent);
	}

	/**
	 * @return The current count or size of {@link com.equens.gui.service.response.common.ResponseDiagnostics#getErrMsgCntnt()}
	 */
	public int getErrMsgCntntCount() {
		return this.errorMesageContent.size();
	}
	

	public List<ErrorMessageContent> getErrorMessageContentList() {
		return this.errorMesageContent;
	}
	
}
