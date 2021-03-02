package com.tencent.mm.rabbiteye.detective;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.a;
import com.tencent.mm.rabbiteye.a.b;

public class AnrDetective extends a {
    private static volatile AnrDetective NAN = new AnrDetective();
    private static a.b NAO;
    public static a.C2040a NAP;

    static {
        AppMethodBeat.i(186290);
        AppMethodBeat.o(186290);
    }

    private AnrDetective() {
    }

    public static synchronized AnrDetective a(a.b bVar, a.C2040a aVar) {
        AnrDetective anrDetective;
        synchronized (AnrDetective.class) {
            NAO = bVar;
            NAP = aVar;
            anrDetective = NAN;
        }
        return anrDetective;
    }

    public static void a() {
        com.tencent.mm.rabbiteye.a.a aVar = com.tencent.mm.rabbiteye.a.a.INSTANCE;
        if (!aVar.f1541e) {
            aVar.f1541e = true;
        }
    }

    private static native void nativceProduceNativeCrash();

    public static native void nativeInitAnr(String str);

    @Keep
    private static void onANRDumped(int i2, String str) {
        AppMethodBeat.i(186289);
        NAO.gf(b.gut());
        AppMethodBeat.o(186289);
    }
}
