package com.tencent.mm.plugin.appbrand.t;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;

public enum b implements c.a.AbstractC0689a {
    INSTANCE;

    public static b valueOf(String str) {
        AppMethodBeat.i(240914);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(240914);
        return bVar;
    }

    static {
        AppMethodBeat.i(240916);
        AppMethodBeat.o(240916);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a.AbstractC0689a
    public final c a(String str, Activity activity, f fVar) {
        AppMethodBeat.i(240915);
        a aVar = new a(str, activity, fVar);
        AppMethodBeat.o(240915);
        return aVar;
    }
}
