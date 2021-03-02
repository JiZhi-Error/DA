package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public enum b {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);
    
    public final int iOo;

    public static b valueOf(String str) {
        AppMethodBeat.i(147174);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(147174);
        return bVar;
    }

    static {
        AppMethodBeat.i(147177);
        AppMethodBeat.o(147177);
    }

    private b(int i2) {
        this.iOo = i2;
    }

    public static b a(String str, b bVar) {
        AppMethodBeat.i(147175);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(147175);
            return bVar;
        }
        b[] values = values();
        for (b bVar2 : values) {
            if (bVar2.name().toLowerCase().equals(str)) {
                AppMethodBeat.o(147175);
                return bVar2;
            }
        }
        AppMethodBeat.o(147175);
        return bVar;
    }

    public static b xj(int i2) {
        AppMethodBeat.i(147176);
        b[] values = values();
        for (b bVar : values) {
            if (bVar.iOo == i2) {
                AppMethodBeat.o(147176);
                return bVar;
            }
        }
        b bVar2 = RELEASE;
        AppMethodBeat.o(147176);
        return bVar2;
    }
}
