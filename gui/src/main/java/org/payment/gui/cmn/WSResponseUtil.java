package org.payment.gui.cmn;





import java.util.Arrays;
import java.util.Objects;


public final class WSResponseUtil {


    public static final int NONE = 0;

    public static final String DONE = "1";
    public static final String NOT_DONE = "0";


    public static GroupHeaderResponse mapGroupHeader(final int maxRecord) {
        if (maxRecord == 0) {
            return createDiagnostic(ErrorCode.DB_NO_RECORDS_FOUND);
        }
        final GroupHeaderResponse headerResponse = createHeaderResponseDone(DONE);
        headerResponse.setDtFcts(createDataFactsMaxRecord(maxRecord));
        return headerResponse;
    }


    public static GroupHeaderResponse mapDiagnostics(
            WSResponseDiagnostic wsDiagResp) {
        GroupHeaderResponse groupHeader = createHeaderResponseDone(DONE);
        groupHeader.setDtFcts(createDataFactsMaxRecord(NONE));
        ResponseDiagnostics headerDiagResp = new ResponseDiagnostics();
        groupHeader.setReturnCodes(headerDiagResp);
        headerDiagResp.getErrMsgCntnt().addAll(
                wsDiagResp.getErrorMessageContentList());
        return groupHeader;
    }

    /**
     * <p>
     * Creates a new instance of {@link GroupHeaderResponse} for a single
     * Diagnostic Response
     *
     * @param code
     *            {@link Code}
     * @param param
     *            optional var-args parameter
     * @return {@link GroupHeaderResponse}
     */
    public static GroupHeaderResponse createDiagnostic(Code code,
                                                       String... param) {
        GroupHeaderResponse groupHeader = createHeaderResponseDone(DONE);
        groupHeader.setDtFcts(createDataFactsMaxRecord(NONE));

        ResponseDiagnostics headerDiagosticResponse = new ResponseDiagnostics();
        headerDiagosticResponse.getErrMsgCntnt().add(
                createErrorMessageContent(code, 1, param));
        groupHeader.setReturnCodes(headerDiagosticResponse);
        return groupHeader;
    }

    /**
     * <p>
     * Creates a new instance of {@link GroupHeader} for a single Diagnostic
     * Response
     *
     * @param code
     *            {@link Code}
     * @param param
     *            optional var-args parameter
     * @return {@link GroupHeaderResponse}
     */
    public static GroupHeader createBIDiagnostic(Code code, String... param) {
        GroupHeader groupHeader = new GroupHeader();

        ResponseDiagnostics headerDiagosticResponse = new ResponseDiagnostics();
        headerDiagosticResponse.getErrMsgCntnt().add(
                createErrorMessageContent(code, 1, param));
        groupHeader.setResponseDiagnostics(headerDiagosticResponse);
        return groupHeader;
    }

    /**
     * <p>
     * Creates a new instance of {@link ResponseDiagnostics} for a single
     * Diagnostic Response
     *
     * @param code
     *            {@link Code}
     * @param param
     *            optional var-args parameter
     * @return {@link GroupHeaderResponse}
     */
    public static ResponseDiagnostics createDiagnosticsOnly(Code code,
                                                            String... param) {
        ResponseDiagnostics headerDiagosticResponse = new ResponseDiagnostics();
        headerDiagosticResponse.getErrMsgCntnt().add(
                createErrorMessageContent(code, 1, param));
        return headerDiagosticResponse;
    }

    /**
     * <p>
     * Creates a new instance of {@link ResponseDiagnostics} for a single
     * Diagnostic Response
     *
     * @return {@link ResponseDiagnostics}
     */
    public static ResponseDiagnostics createSuccessDiagnosticsOnly() {
        ResponseDiagnostics headerDiagosticResponse = new ResponseDiagnostics();
        headerDiagosticResponse.getErrMsgCntnt().add(
                createErrorMessageContent(ErrorCode.SUCCESS.getCode(), 1,
                        Constants.SUCCESS));
        return headerDiagosticResponse;
    }

    /**
     * Creates a new {@link ErrorMessageContent} instance and initializes its
     * error code, count, and param.
     *
     * @param code
     *            {@link Code}
     * @param count
     *            error count number
     * @param param
     *            var-arg of parameters
     * @return {@link ErrorMessageContent}
     */
    public static ErrorMessageContent createErrorMessageContent(Code code,
                                                                int count, String... param) {
        ErrorMessageContent errorMessageContent = new ErrorMessageContent();


        errorMessageContent.setErrCd(code.getCode());
        errorMessageContent.setErrCount(String.valueOf(count));
        if (!Objects.isNull(param) && param.length > Constants.ZERO) {
            errorMessageContent.getParam().addAll(Arrays.asList(param));
        }
        return errorMessageContent;
    }

    /**
     * Overloaded; Creates a new {@link ErrorMessageContent} instance and
     * initializes its error code, count, and param.
     *
     * @param code
     *            {@link String}
     * @param count
     *            error count number
     * @param param
     *            var-arg of parameters
     * @return {@link ErrorMessageContent}
     */
    public static ErrorMessageContent createErrorMessageContent(String code,
                                                                int count, String... param) {
        ErrorMessageContent errorMessageContent = new ErrorMessageContent();


        errorMessageContent.setErrCd(code);
        errorMessageContent.setErrCount(String.valueOf(count));
        if (!Objects.isNull(param) && param.length > Constants.ZERO) {
            errorMessageContent.getParam().addAll(Arrays.asList(param));
        }
        return errorMessageContent;
    }

    /**
     * Creates a new {@link DataFacts} instance and initializes its maxRecord
     *
     * @param maxRecord
     *            count for the {@link DataFacts#setMaxRcrd(String)}
     * @return {@link DataFacts}
     */
    public static DataFacts createDataFactsMaxRecord(int maxRecord) {
        DataFacts dataFacts = new DataFacts();
        dataFacts.setMaxRcrd(String.valueOf(maxRecord));
        return dataFacts;
    }

    /**
     * Creates a new {@link GroupHeaderResponse} instance with {@link #DONE}
     *
     * @param done
     *            set the {@link #DONE}
     * @return {@link GroupHeaderResponse}
     */
    public static GroupHeaderResponse createHeaderResponseDone(String done) {
        GroupHeaderResponse groupHeaderResponse = new GroupHeaderResponse();
        groupHeaderResponse.setDone(done);
        return groupHeaderResponse;
    }

}
