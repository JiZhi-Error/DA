package com.tencent.liteav.basic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class d extends IOException {
    private static final long serialVersionUID = 2723743254380545567L;
    private final int mErrorCode;
    private final String mErrorMessage;

    public d(int i2) {
        this(i2, null);
    }

    public d(int i2, String str) {
        this.mErrorCode = i2;
        this.mErrorMessage = str;
    }

    public String getMessage() {
        AppMethodBeat.i(222188);
        if (this.mErrorMessage != null) {
            String str = "EGL error code: " + this.mErrorCode + this.mErrorMessage;
            AppMethodBeat.o(222188);
            return str;
        }
        String str2 = "EGL error code: " + this.mErrorCode;
        AppMethodBeat.o(222188);
        return str2;
    }
}
