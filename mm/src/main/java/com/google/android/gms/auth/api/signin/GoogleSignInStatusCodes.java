package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    public static final int SIGN_IN_CANCELLED = 12501;
    public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
    public static final int SIGN_IN_FAILED = 12500;

    private GoogleSignInStatusCodes() {
    }

    public static String getStatusCodeString(int i2) {
        AppMethodBeat.i(88292);
        switch (i2) {
            case SIGN_IN_FAILED /*{ENCODED_INT: 12500}*/:
                AppMethodBeat.o(88292);
                return "A non-recoverable sign in failure occurred";
            case SIGN_IN_CANCELLED /*{ENCODED_INT: 12501}*/:
                AppMethodBeat.o(88292);
                return "Sign in action cancelled";
            case SIGN_IN_CURRENTLY_IN_PROGRESS /*{ENCODED_INT: 12502}*/:
                AppMethodBeat.o(88292);
                return "Sign-in in progress";
            default:
                String statusCodeString = CommonStatusCodes.getStatusCodeString(i2);
                AppMethodBeat.o(88292);
                return statusCodeString;
        }
    }
}
