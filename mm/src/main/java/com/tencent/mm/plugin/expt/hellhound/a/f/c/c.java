package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static long cQm() {
        AppMethodBeat.i(122130);
        cbo cQs = cQs();
        if (cQs == null) {
            cQs = new cbo();
        }
        long j2 = cQs.his;
        cQs.his = 1 + j2;
        c(cQs);
        AppMethodBeat.o(122130);
        return j2;
    }

    public static void cQn() {
        AppMethodBeat.i(122131);
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(122131);
            return;
        }
        cQs.his = 0;
        c(cQs);
        AppMethodBeat.o(122131);
    }

    public static void l(cyl cyl) {
        cbo cbo;
        cyl last;
        AppMethodBeat.i(122132);
        cbo cQs = cQs();
        if (cQs == null) {
            cbo = new cbo();
        } else {
            cbo = cQs;
        }
        b.i(cyl);
        if (!(cbo.Mhr.isEmpty() || (last = cbo.Mhr.getLast()) == null || last.iOu == 1)) {
            String aqn = b.aqn(last.sessionId);
            String aqn2 = b.aqn(cyl.sessionId);
            if (aqn != null && aqn.equals(aqn2)) {
                last.iOu = 1;
                last.endTime = System.currentTimeMillis();
                Log.i("HABBYGE-MALI.HellSessionDao", "onSessionClose-addSession: %s", last.sessionId);
            }
        }
        cbo.Mhr.addLast(cyl);
        cbo.Mhs = cbo.Mhr.size() - 1;
        if (!b.aqt(cyl.sessionId)) {
            cbo.Mhw = true;
        }
        Log.i("HABBYGE-MALI.HellSessionDao", "addSession: %s, %b", cyl.sessionId, Boolean.valueOf(cbo.Mhw));
        c(cbo);
        AppMethodBeat.o(122132);
    }

    public static void m(cyl cyl) {
        AppMethodBeat.i(122133);
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(122133);
        } else if (!d(cQs)) {
            AppMethodBeat.o(122133);
        } else {
            b.i(cyl);
            cQs.Mhr.set(cQs.Mhs, cyl);
            Log.i("HABBYGE-MALI.HellSessionDao", "updateCurSession, newSession: %s, %s, %d", cyl.sessionId, cyl.MDn, Integer.valueOf(cyl.MDo));
            if (!b.aqt(cyl.sessionId)) {
                cQs.Mhw = true;
            }
            c(cQs);
            AppMethodBeat.o(122133);
        }
    }

    public static cyl cQo() {
        AppMethodBeat.i(122134);
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(122134);
            return null;
        } else if (d(cQs)) {
            cyl cyl = cQs.Mhr.get(cQs.Mhs);
            AppMethodBeat.o(122134);
            return cyl;
        } else {
            AppMethodBeat.o(122134);
            return null;
        }
    }

    public static void b(cbo cbo) {
        AppMethodBeat.i(122135);
        if (cbo == null) {
            AppMethodBeat.o(122135);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, setHellSession");
        c(cbo);
        AppMethodBeat.o(122135);
    }

    public static void n(cyl cyl) {
        AppMethodBeat.i(122136);
        if (cyl == null) {
            AppMethodBeat.o(122136);
            return;
        }
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(122136);
        } else if (!d(cQs)) {
            AppMethodBeat.o(122136);
        } else {
            Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, updateSessionOnClose");
            cQs.Mhr.set(cQs.Mhs, cyl);
            cQs.Mhs = -1;
            c(cQs);
            AppMethodBeat.o(122136);
        }
    }

    public static cyl cQp() {
        AppMethodBeat.i(122137);
        cbo cQs = cQs();
        if (cQs == null || cQs.Mhr.isEmpty()) {
            AppMethodBeat.o(122137);
            return null;
        } else if (d(cQs)) {
            cyl cyl = cQs.Mhr.get(cQs.Mhs);
            AppMethodBeat.o(122137);
            return cyl;
        } else {
            cyl last = cQs.Mhr.getLast();
            AppMethodBeat.o(122137);
            return last;
        }
    }

    public static cyl cQq() {
        AppMethodBeat.i(122138);
        cbo cQs = cQs();
        if (cQs == null || cQs.Mhr.isEmpty()) {
            AppMethodBeat.o(122138);
            return null;
        }
        Log.i("HABBYGE-MALI.HellSessionDao", "getLastSession, hellSession: %s", Integer.valueOf(cQs.Mhs));
        if (!d(cQs)) {
            AppMethodBeat.o(122138);
            return null;
        } else if (cQs.Mhs - 1 < 0) {
            AppMethodBeat.o(122138);
            return null;
        } else {
            cyl cyl = cQs.Mhr.get(cQs.Mhs - 1);
            AppMethodBeat.o(122138);
            return cyl;
        }
    }

    public static cyl aqG(String str) {
        AppMethodBeat.i(220563);
        if (str == null) {
            AppMethodBeat.o(220563);
            return null;
        }
        cbo cQs = cQs();
        if (cQs == null || cQs.Mhr.isEmpty()) {
            AppMethodBeat.o(220563);
            return null;
        }
        for (int size = cQs.Mhr.size() - 1; size >= 0; size--) {
            cyl cyl = cQs.Mhr.get(size);
            if (cyl != null && str.equals(cyl.sessionId) && size - 1 >= 0) {
                cyl cyl2 = cQs.Mhr.get(size - 1);
                AppMethodBeat.o(220563);
                return cyl2;
            }
        }
        AppMethodBeat.o(220563);
        return null;
    }

    public static void a(cyh cyh) {
        AppMethodBeat.i(185586);
        cbo cQs = cQs();
        if (cQs == null) {
            cQs = new cbo();
        }
        cQs.Mht.addLast(cyh);
        cQs.Mhu = cQs.Mht.size() - 1;
        cQs.Mhw = false;
        c(cQs);
        AppMethodBeat.o(185586);
    }

    public static void b(cyh cyh) {
        AppMethodBeat.i(122140);
        if (cyh == null) {
            AppMethodBeat.o(122140);
            return;
        }
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(122140);
        } else if (!e(cQs)) {
            AppMethodBeat.o(122140);
        } else {
            cQs.Mht.set(cQs.Mhu, cyh);
            c(cQs);
            AppMethodBeat.o(122140);
        }
    }

    public static cyh cQr() {
        AppMethodBeat.i(185587);
        cbo cQs = cQs();
        if (cQs == null) {
            AppMethodBeat.o(185587);
            return null;
        } else if (e(cQs)) {
            cyh cyh = cQs.Mht.get(cQs.Mhu);
            AppMethodBeat.o(185587);
            return cyh;
        } else {
            AppMethodBeat.o(185587);
            return null;
        }
    }

    public static void aqH(String str) {
        AppMethodBeat.i(122142);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(122142);
            return;
        }
        Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, clearCurSession: %s", str);
        cbo cQs = cQs();
        if (cQs == null || cQs.Mhr.isEmpty()) {
            AppMethodBeat.o(122142);
            return;
        }
        int size = cQs.Mhr.size();
        Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s, %d", str, Integer.valueOf(size));
        for (int i2 = size - 1; i2 >= 0; i2--) {
            cyl cyl = cQs.Mhr.get(i2);
            if (cyl != null) {
                Log.i("HABBYGE-MALI.HellSessionDao", "clearCurSession, length: %s", cyl.sessionId);
                if (str.equals(cyl.sessionId)) {
                    cQs.Mhr.remove(i2);
                    cQs.Mhs = cQs.Mhr.size() - 1;
                    c(cQs);
                    AppMethodBeat.o(122142);
                    return;
                }
            }
        }
        AppMethodBeat.o(122142);
    }

    private static void c(cbo cbo) {
        AppMethodBeat.i(122144);
        if (cbo == null) {
            AppMethodBeat.o(122144);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", cbo.toByteArray());
            AppMethodBeat.o(122144);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", e2, "HellSessionDao._writeBack: %s", e2.getMessage());
            AppMethodBeat.o(122144);
        }
    }

    public static cbo cQs() {
        AppMethodBeat.i(122145);
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_sessions");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(122145);
            return null;
        }
        cbo cbo = new cbo();
        try {
            cbo.parseFrom(bytes);
            AppMethodBeat.o(122145);
            return cbo;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionDao", e2, "HellSessionDao._read", new Object[0]);
            AppMethodBeat.o(122145);
            return null;
        }
    }

    public static void reset() {
        AppMethodBeat.i(122146);
        Log.i("HABBYGE-MALI.HellSessionDao", "HellSessionDao, reset");
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_sessions", new byte[0]);
        AppMethodBeat.o(122146);
    }

    private static boolean d(cbo cbo) {
        AppMethodBeat.i(122147);
        if (cbo == null) {
            AppMethodBeat.o(122147);
            return false;
        } else if (cbo.Mhs < 0 || cbo.Mhs >= cbo.Mhr.size()) {
            AppMethodBeat.o(122147);
            return false;
        } else {
            AppMethodBeat.o(122147);
            return true;
        }
    }

    private static boolean e(cbo cbo) {
        AppMethodBeat.i(122148);
        if (cbo == null) {
            AppMethodBeat.o(122148);
            return false;
        } else if (cbo.Mhu < 0 || cbo.Mhu >= cbo.Mht.size()) {
            AppMethodBeat.o(122148);
            return false;
        } else {
            AppMethodBeat.o(122148);
            return true;
        }
    }

    public static cyl a(cyl cyl, String str, long j2) {
        AppMethodBeat.i(122149);
        cyl cyl2 = new cyl();
        cyl2.sessionId = str;
        cyl2.MDn = cyl.MDn;
        cyl2.MDq = cyl.MDq;
        cyl2.MDr = false;
        cyl2.iOu = 0;
        cyl2.MDo = cyl.MDo;
        cyl2.userName = cyl.userName;
        cyl2.MDp = cyl.MDp;
        cyl2.MDq = cyl.MDq;
        cyl2.seq = cQm();
        cyl2.startTime = j2;
        cyl2.MDs = cyl.MDs;
        AppMethodBeat.o(122149);
        return cyl2;
    }
}
