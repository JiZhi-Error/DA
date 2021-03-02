package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c {
    private int gsh = 0;
    public int gsi;

    public final void uD(int i2) {
        this.gsh |= i2;
    }

    /* access modifiers changed from: package-private */
    public final void uE(int i2) {
        AppMethodBeat.i(151324);
        this.gsh &= i2 ^ -1;
        if (this.gsh == 0) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.gsi);
            this.gsi = 0;
        }
        AppMethodBeat.o(151324);
    }
}
