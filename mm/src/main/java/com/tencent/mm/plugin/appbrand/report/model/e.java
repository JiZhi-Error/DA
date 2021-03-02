package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public enum e {
    INSTANCE;
    
    public Map<String, a> nIC = new HashMap();

    private e(String str) {
        AppMethodBeat.i(48116);
        AppMethodBeat.o(48116);
    }

    public static e valueOf(String str) {
        AppMethodBeat.i(48115);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(48115);
        return eVar;
    }

    static {
        AppMethodBeat.i(48117);
        AppMethodBeat.o(48117);
    }

    public final void ch(String str, int i2) {
        long j2 = 0;
        int i3 = 1;
        AppMethodBeat.i(227383);
        boolean afi = h.bWb().afi(str);
        a aVar = this.nIC.get(str);
        if (aVar == null) {
            aVar = new a((byte) 0);
            aVar.nIF = 1;
            this.nIC.put(str, aVar);
        } else {
            aVar.nIF++;
        }
        if (aVar.nIE > 0) {
            j2 = Util.nowMilliSecond() - aVar.nIE;
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[6];
        objArr[0] = 1;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i2);
        if (!afi) {
            i3 = 0;
        }
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Long.valueOf(aVar.nIF);
        objArr[5] = Long.valueOf(j2);
        hVar.a(16064, objArr);
        AppMethodBeat.o(227383);
    }

    public static final class a {
        public long nIE;
        long nIF;

        private a() {
            this.nIE = -1;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
