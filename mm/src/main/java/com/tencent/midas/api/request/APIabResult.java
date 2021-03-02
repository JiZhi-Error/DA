package com.tencent.midas.api.request;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APIabResult {
    String mMessage;
    int mResponse;

    public APIabResult(int i2, String str) {
        AppMethodBeat.i(192932);
        this.mResponse = i2;
        if (str == null || str.trim().length() == 0) {
            this.mMessage = getResponseDesc(i2);
            AppMethodBeat.o(192932);
            return;
        }
        this.mMessage = str + " (response: " + getResponseDesc(i2) + ")";
        AppMethodBeat.o(192932);
    }

    public static String getResponseDesc(int i2) {
        return "";
    }

    public int getResponse() {
        return this.mResponse;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean isSuccess() {
        return this.mResponse == 0;
    }

    public boolean isPendig() {
        return this.mResponse == 101;
    }

    public boolean isFailure() {
        AppMethodBeat.i(192933);
        if (!isSuccess()) {
            AppMethodBeat.o(192933);
            return true;
        }
        AppMethodBeat.o(192933);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(192934);
        String str = "IabResult: " + getMessage();
        AppMethodBeat.o(192934);
        return str;
    }
}
