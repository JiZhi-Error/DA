package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p implements com.tencent.mm.plugin.sns.b.p {
    private static volatile p DqX = null;

    private p() {
    }

    public static p eWt() {
        AppMethodBeat.i(94916);
        if (DqX == null) {
            synchronized (p.class) {
                try {
                    if (DqX == null) {
                        DqX = new p();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(94916);
                    throw th;
                }
            }
        }
        p pVar = DqX;
        AppMethodBeat.o(94916);
        return pVar;
    }
}
