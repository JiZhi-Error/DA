package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzf;
import java.util.HashSet;
import java.util.Set;

public class l {
    private static volatile l kUF;
    private final Set<Object> kUG = new HashSet();
    private volatile bzf kUH = null;
    private final Object mLock = new Object();

    public l() {
        AppMethodBeat.i(44498);
        AppMethodBeat.o(44498);
    }

    public static l bxU() {
        AppMethodBeat.i(44499);
        if (kUF == null) {
            synchronized (l.class) {
                try {
                    if (kUF == null) {
                        kUF = new l();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(44499);
                    throw th;
                }
            }
        }
        l lVar = kUF;
        AppMethodBeat.o(44499);
        return lVar;
    }

    public enum a {
        FORCE_OFF(0),
        FORCE_ON(1);
        
        int cND;

        public static a valueOf(String str) {
            AppMethodBeat.i(44491);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44491);
            return aVar;
        }

        static {
            AppMethodBeat.i(44493);
            AppMethodBeat.o(44493);
        }

        private a(int i2) {
            this.cND = i2;
        }

        public static a vV(int i2) {
            AppMethodBeat.i(44492);
            a[] values = values();
            for (a aVar : values) {
                if (aVar.cND == i2) {
                    AppMethodBeat.o(44492);
                    return aVar;
                }
            }
            AppMethodBeat.o(44492);
            return null;
        }
    }
}
