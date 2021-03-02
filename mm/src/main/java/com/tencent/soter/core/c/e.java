package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    private static volatile e RPK = null;
    public String RPL = b.RPI;

    public static e hls() {
        e eVar;
        AppMethodBeat.i(88659);
        if (RPK == null) {
            synchronized (e.class) {
                try {
                    if (RPK == null) {
                        RPK = new e();
                    }
                    eVar = RPK;
                } finally {
                    AppMethodBeat.o(88659);
                }
            }
            return eVar;
        }
        e eVar2 = RPK;
        AppMethodBeat.o(88659);
        return eVar2;
    }
}
