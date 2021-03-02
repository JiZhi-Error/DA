package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;

public final class b {
    public static String apk(String str) {
        AppMethodBeat.i(121960);
        cyi cNX = cNX();
        if (cNX == null || cNX.MDh.isEmpty()) {
            AppMethodBeat.o(121960);
            return null;
        }
        Iterator<cgh> it = cNX.MDh.iterator();
        cgh cgh = null;
        while (it.hasNext()) {
            cgh next = it.next();
            if (next == null || !str.equals(next.key)) {
                next = cgh;
            }
            cgh = next;
        }
        if (cgh == null) {
            AppMethodBeat.o(121960);
            return null;
        }
        String str2 = cgh.value;
        AppMethodBeat.o(121960);
        return str2;
    }

    public static void go(String str, String str2) {
        cyi cyi;
        AppMethodBeat.i(121961);
        cyi cNX = cNX();
        if (cNX == null) {
            cyi = new cyi();
        } else {
            cyi = cNX;
        }
        Iterator<cgh> it = cyi.MDh.iterator();
        while (true) {
            if (it.hasNext()) {
                cgh next = it.next();
                if (next != null && str.equals(next.key)) {
                    cyi.MDh.remove(next);
                    break;
                }
            } else {
                break;
            }
        }
        cgh cgh = new cgh();
        cgh.key = str;
        cgh.value = str2;
        cyi.MDh.add(cgh);
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", cyi.toByteArray());
            AppMethodBeat.o(121961);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", e2, "ActivityBundleDao writeBack", new Object[0]);
            AppMethodBeat.o(121961);
        }
    }

    private static cyi cNX() {
        AppMethodBeat.i(121962);
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121962);
            return null;
        }
        cyi cyi = new cyi();
        try {
            cyi.parseFrom(bytes);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", e2, "ActivityBundleDao _doRead parse", new Object[0]);
            cyi = null;
        }
        AppMethodBeat.o(121962);
        return cyi;
    }
}
