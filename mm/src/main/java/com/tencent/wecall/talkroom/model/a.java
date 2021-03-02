package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public class a {
    private static a Suf = null;
    private f Sug = null;

    public static a hqI() {
        AppMethodBeat.i(62656);
        if (Suf == null) {
            synchronized (a.class) {
                try {
                    if (Suf == null) {
                        Suf = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62656);
                    throw th;
                }
            }
        }
        a aVar = Suf;
        AppMethodBeat.o(62656);
        return aVar;
    }

    public static f hqJ() {
        AppMethodBeat.i(62657);
        a hqI = hqI();
        if (hqI.Sug == null) {
            synchronized (a.class) {
                try {
                    if (hqI.Sug == null) {
                        hqI.Sug = new f();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(62657);
                    throw th;
                }
            }
        }
        f fVar = hqI.Sug;
        AppMethodBeat.o(62657);
        return fVar;
    }

    public static void hqK() {
        AppMethodBeat.i(62658);
        b.d("MicroMsg.Voip", "registerEvents");
        hqJ();
        AppMethodBeat.o(62658);
    }
}
