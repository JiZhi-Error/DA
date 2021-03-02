package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    String mMessage;
    public int mResponse;

    public c(int i2, String str) {
        AppMethodBeat.i(64601);
        this.mResponse = i2;
        if (str == null || str.trim().length() == 0) {
            this.mMessage = b.getResponseDesc(i2);
            AppMethodBeat.o(64601);
            return;
        }
        this.mMessage = str + " (response: " + b.getResponseDesc(i2) + ")";
        AppMethodBeat.o(64601);
    }

    public final int getResponse() {
        switch (this.mResponse) {
            case -2001:
            case -1004:
                return 3;
            case -1009:
            case -1002:
            case -1001:
            case -1000:
            case 2:
            case 3:
            case 4:
            case 6:
                return 5;
            case 0:
                return 0;
            case 1:
                return 1;
            case 5:
                return 6;
            case 7:
                return 100000002;
            case 8:
                return 106;
            default:
                return this.mResponse;
        }
    }

    public final boolean isSuccess() {
        return this.mResponse == 0;
    }

    public final String toString() {
        AppMethodBeat.i(64602);
        String str = "IapResult: " + this.mMessage;
        AppMethodBeat.o(64602);
        return str;
    }
}
