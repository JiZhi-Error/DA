package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;

public final class e {
    public static void N(String str, String str2, int i2) {
        Fragment apm;
        AppMethodBeat.i(121983);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(121983);
            return;
        }
        String str3 = null;
        if (TextUtils.isEmpty(str2) && b.aoz(str) && (apm = h.apm(str)) != null) {
            str3 = apm.getClass().getCanonicalName();
        }
        if (str3 == null) {
            str3 = "NULL";
        }
        go(String.valueOf(i2), str + "|" + (!str3.equals("NULL")) + "|" + str3);
        AppMethodBeat.o(121983);
    }

    public static String GR(int i2) {
        String str;
        AppMethodBeat.i(121984);
        cyi cNX = cNX();
        if (cNX == null) {
            AppMethodBeat.o(121984);
            return null;
        }
        String valueOf = String.valueOf(i2);
        Iterator<cgh> it = cNX.MDh.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            cgh next = it.next();
            if (next != null && valueOf.equals(next.key)) {
                str = next.value;
                break;
            }
        }
        if (str == null || str.equals("")) {
            AppMethodBeat.o(121984);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            AppMethodBeat.o(121984);
            return null;
        }
        String str2 = split[0];
        AppMethodBeat.o(121984);
        return str2;
    }

    public static d<String, Boolean, String> GS(int i2) {
        String str;
        AppMethodBeat.i(121985);
        cyi cNX = cNX();
        if (cNX == null) {
            AppMethodBeat.o(121985);
            return null;
        }
        String valueOf = String.valueOf(i2);
        Iterator<cgh> it = cNX.MDh.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            cgh next = it.next();
            if (next != null && valueOf.equals(next.key)) {
                str = next.value;
                break;
            }
        }
        if (str == null || str.equals("")) {
            AppMethodBeat.o(121985);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            AppMethodBeat.o(121985);
            return null;
        }
        d<String, Boolean, String> i3 = a.i(split[0], Boolean.valueOf(split[1]), split[2]);
        AppMethodBeat.o(121985);
        return i3;
    }

    private static void go(String str, String str2) {
        cyi cyi;
        AppMethodBeat.i(121986);
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
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_page_se_dao", cyi.toByteArray());
            AppMethodBeat.o(121986);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", e2, "PageStateDao writeBack", new Object[0]);
            AppMethodBeat.o(121986);
        }
    }

    private static cyi cNX() {
        AppMethodBeat.i(121987);
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_page_se_dao");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121987);
            return null;
        }
        cyi cyi = new cyi();
        try {
            cyi.parseFrom(bytes);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", e2, "PageStateDao _doRead parse", new Object[0]);
            cyi = null;
        }
        AppMethodBeat.o(121987);
        return cyi;
    }
}
