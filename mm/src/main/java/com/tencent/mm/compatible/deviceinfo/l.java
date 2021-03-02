package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import java.util.Map;

public final class l {
    private static l gHP = null;
    private String filePath = "";
    private boolean gHN = false;
    boolean gHO = false;
    private Map<Integer, Object> values;

    public static synchronized l aol() {
        l lVar;
        synchronized (l.class) {
            AppMethodBeat.i(155656);
            if (gHP == null) {
                gHP = new l(b.aKB() + "CompatibleInfo.cfg");
            }
            lVar = gHP;
            AppMethodBeat.o(155656);
        }
        return lVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095 A[SYNTHETIC, Splitter:B:29:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[SYNTHETIC, Splitter:B:32:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd A[SYNTHETIC, Splitter:B:41:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2 A[SYNTHETIC, Splitter:B:44:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private l(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.deviceinfo.l.<init>(java.lang.String):void");
    }

    public final synchronized void set(int i2, Object obj) {
        AppMethodBeat.i(155658);
        this.values.put(Integer.valueOf(i2), obj);
        if (!this.gHN) {
            aom();
        }
        AppMethodBeat.o(155658);
    }

    public final Object get(int i2) {
        AppMethodBeat.i(155659);
        Object obj = this.values.get(Integer.valueOf(i2));
        AppMethodBeat.o(155659);
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC, Splitter:B:32:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC, Splitter:B:35:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009e A[SYNTHETIC, Splitter:B:45:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3 A[SYNTHETIC, Splitter:B:48:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void aom() {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.deviceinfo.l.aom():void");
    }
}
