package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q {
    ;
    
    private static volatile bza kUT;
    private static final Set<Object> kUU = Collections.newSetFromMap(new ConcurrentHashMap());

    static {
        AppMethodBeat.i(44546);
        AppMethodBeat.o(44546);
    }

    public static q valueOf(String str) {
        AppMethodBeat.i(44536);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(44536);
        return qVar;
    }

    public static boolean bxV() {
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean bxW() {
        AppMethodBeat.i(44539);
        switch (bxX()) {
            case FORCE_OFF:
                AppMethodBeat.o(44539);
                return false;
            case FORCE_ON:
                AppMethodBeat.o(44539);
                return true;
            case DYNAMIC_THRESHOLD:
                if (bxY()) {
                    AppMethodBeat.o(44539);
                    return true;
                } else if (kUT != null) {
                    if (kUT.oKX >= kUT.Mez) {
                        AppMethodBeat.o(44539);
                        return true;
                    }
                    AppMethodBeat.o(44539);
                    return false;
                }
                break;
        }
        AppMethodBeat.o(44539);
        return false;
    }

    static a bxX() {
        AppMethodBeat.i(44541);
        if (!g.aAc()) {
            a aVar = a.FORCE_OFF;
            AppMethodBeat.o(44541);
            return aVar;
        }
        c Fu = d.aXu().Fu("100215");
        if (Fu.isValid()) {
            int i2 = Util.getInt(Fu.gzz().get("isOpenNewNearEntry"), 0);
            a[] values = a.values();
            for (a aVar2 : values) {
                if (aVar2.value == i2) {
                    AppMethodBeat.o(44541);
                    return aVar2;
                }
            }
        }
        a aVar3 = a.FORCE_ON;
        AppMethodBeat.o(44541);
        return aVar3;
    }

    /* access modifiers changed from: package-private */
    public enum a {
        FORCE_OFF(0),
        FORCE_ON(1),
        DYNAMIC_THRESHOLD(2);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(44533);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(44533);
            return aVar;
        }

        static {
            AppMethodBeat.i(44534);
            AppMethodBeat.o(44534);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    static boolean bxY() {
        AppMethodBeat.i(44542);
        boolean z = g.aAh().azQ().getBoolean(ar.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, false);
        AppMethodBeat.o(44542);
        return z;
    }

    static void bxZ() {
        AppMethodBeat.i(44543);
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_ENTRANCE_HAS_SEEN_NEARBY_SHOWCASE_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(44543);
    }

    public static bza bya() {
        return kUT;
    }

    public static void clearData() {
        kUT = null;
    }
}
