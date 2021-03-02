package com.tencent.mm.plugin.appbrand.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.b;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<Integer, Object> hno = new HashMap();

    static {
        AppMethodBeat.i(48006);
        AppMethodBeat.o(48006);
    }

    public static void zc(int i2) {
        AppMethodBeat.i(48003);
        if (!hno.containsKey(Integer.valueOf(i2))) {
            AppMethodBeat.o(48003);
            return;
        }
        hno.get(Integer.valueOf(i2));
        AppMethodBeat.o(48003);
    }

    public static void bUc() {
        AppMethodBeat.i(48004);
        hno.clear();
        AppMethodBeat.o(48004);
    }

    public static void bUd() {
        AppMethodBeat.i(48005);
        b.mnM = new b.a() {
            /* class com.tencent.mm.plugin.appbrand.x.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.t.b.a
            public final void xl(int i2) {
                AppMethodBeat.i(48002);
                a.zc(i2);
                AppMethodBeat.o(48002);
            }
        };
        AppMethodBeat.o(48005);
    }
}
