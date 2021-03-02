package com.tencent.mm.wallet_core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.e;
import java.util.WeakHashMap;

public final class a {
    private WeakHashMap<Object, Boolean> RuF = new WeakHashMap<>();

    public a() {
        AppMethodBeat.i(72880);
        AppMethodBeat.o(72880);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.wallet_core.f.a$a  reason: collision with other inner class name */
    public static class C2169a {
        static a RuG = new a();

        static {
            AppMethodBeat.i(72879);
            AppMethodBeat.o(72879);
        }
    }

    public static synchronized a hhH() {
        a aVar;
        synchronized (a.class) {
            aVar = C2169a.RuG;
        }
        return aVar;
    }

    public final boolean ew(Object obj) {
        AppMethodBeat.i(72881);
        if (!d.INSTANCE.dH(obj)) {
            AppMethodBeat.o(72881);
            return true;
        } else if (this.RuF.containsKey(obj)) {
            AppMethodBeat.o(72881);
            return false;
        } else {
            this.RuF.put(obj, Boolean.TRUE);
            e.INSTANCE.idkeyStat(715, 0, 1, false);
            if ((b.hhK() || g.isMIUI()) && b.hhI()) {
                com.tencent.mm.plugin.secinforeport.a.d.INSTANCE.Xj(Integer.MIN_VALUE);
            }
            AppMethodBeat.o(72881);
            return false;
        }
    }
}
