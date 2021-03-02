package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransferStatusCodes extends CommonStatusCodes {
    public static final int CHALLENGE_NOT_ALLOWED = 20503;
    public static final int INVALID_REQUEST = 20502;
    public static final int NOT_ALLOWED_SECURITY = 20500;
    public static final int NO_DATA_AVAILABLE = 20501;
    public static final int SESSION_INACTIVE = 20504;

    private AccountTransferStatusCodes() {
    }

    public static String getStatusCodeString(int i2) {
        AppMethodBeat.i(10648);
        switch (i2) {
            case NOT_ALLOWED_SECURITY /*{ENCODED_INT: 20500}*/:
                AppMethodBeat.o(10648);
                return "NOT_ALLOWED_SECURITY";
            case NO_DATA_AVAILABLE /*{ENCODED_INT: 20501}*/:
                AppMethodBeat.o(10648);
                return "NO_DATA_AVAILABLE";
            case INVALID_REQUEST /*{ENCODED_INT: 20502}*/:
                AppMethodBeat.o(10648);
                return "INVALID_REQUEST";
            case CHALLENGE_NOT_ALLOWED /*{ENCODED_INT: 20503}*/:
                AppMethodBeat.o(10648);
                return "CHALLENGE_NOT_ALLOWED";
            case SESSION_INACTIVE /*{ENCODED_INT: 20504}*/:
                AppMethodBeat.o(10648);
                return "SESSION_INACTIVE";
            default:
                String statusCodeString = CommonStatusCodes.getStatusCodeString(i2);
                AppMethodBeat.o(10648);
                return statusCodeString;
        }
    }
}
