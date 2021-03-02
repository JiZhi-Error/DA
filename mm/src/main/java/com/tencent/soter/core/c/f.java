package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f {
    public int errCode;
    public String errMsg;

    public f(int i2, String str) {
        this(i2);
        AppMethodBeat.i(88660);
        if (!g.isNullOrNil(str)) {
            this.errMsg = str;
        }
        AppMethodBeat.o(88660);
    }

    public f(int i2) {
        AppMethodBeat.i(88661);
        this.errCode = i2;
        switch (this.errCode) {
            case 0:
                this.errMsg = "ok";
                AppMethodBeat.o(88661);
                return;
            case 1:
            default:
                this.errMsg = "errmsg not specified";
                AppMethodBeat.o(88661);
                return;
            case 2:
                this.errMsg = "device not support soter";
                AppMethodBeat.o(88661);
                return;
        }
    }

    public final boolean isSuccess() {
        return this.errCode == 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).errCode == this.errCode;
    }

    public String toString() {
        AppMethodBeat.i(88662);
        String str = "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
        AppMethodBeat.o(88662);
        return str;
    }
}
