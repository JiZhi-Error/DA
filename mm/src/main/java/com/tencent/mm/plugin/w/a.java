package com.tencent.mm.plugin.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.g;
import java.util.List;

public final class a implements b, c {
    private static a Ciz;

    private a() {
    }

    @Override // com.tencent.mm.kernel.api.b
    public final List<String> aAo() {
        return null;
    }

    public static synchronized a eMS() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(90773);
            if (Ciz == null) {
                Ciz = new a();
            }
            aVar = Ciz;
            AppMethodBeat.o(90773);
        }
        return aVar;
    }

    public static String eMT() {
        AppMethodBeat.i(90774);
        String str = g.aAh().hqG + "remark/";
        AppMethodBeat.o(90774);
        return str;
    }
}
