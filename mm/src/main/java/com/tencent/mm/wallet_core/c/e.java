package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public int Rtu;
    public int errCode;
    public String errMsg;
    public int errType;

    public e(int i2, int i3, String str) {
        AppMethodBeat.i(72742);
        this.Rtu = 0;
        f(i2, i3, str, 0);
        AppMethodBeat.o(72742);
    }

    public final void f(int i2, int i3, String str, int i4) {
        this.errType = i2;
        this.errCode = i3;
        this.errMsg = str;
        this.Rtu = i4;
    }

    public e() {
        this.Rtu = 0;
        this.errType = 0;
        this.errCode = 0;
        this.errMsg = "";
        this.Rtu = 0;
    }
}
