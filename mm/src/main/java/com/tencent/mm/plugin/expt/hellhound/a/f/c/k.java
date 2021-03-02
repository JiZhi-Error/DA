package com.tencent.mm.plugin.expt.hellhound.a.f.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;

public final class k {
    public static void k(Map<Long, dvi> map, String str) {
        AppMethodBeat.i(177390);
        if (TextUtils.isEmpty(str) || map.isEmpty()) {
            AppMethodBeat.o(177390);
            return;
        }
        dvj dvj = new dvj();
        for (Map.Entry<Long, dvi> entry : map.entrySet()) {
            dvi value = entry.getValue();
            if (value.dRM.equals(str) && value.index > 0) {
                dvj.MWq.addLast(value);
            }
        }
        if (dvj.MWq.isEmpty()) {
            AppMethodBeat.o(177390);
            return;
        }
        a(dvj, "mmkv_key_hellSPMatchinghe_");
        AppMethodBeat.o(177390);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.protobuf.cbm r12) {
        /*
        // Method dump skipped, instructions count: 471
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a(com.tencent.mm.protocal.protobuf.cbm):void");
    }

    public static void a(erd erd, String str) {
        AppMethodBeat.i(220564);
        if (erd == null || str == null) {
            AppMethodBeat.o(220564);
            return;
        }
        a(erd, str, aqP("mmkv_key_hellSPMatchSuche_"), false);
        a(erd, str, aqP("mmkv_key_hellSPMatchinghe_"), true);
        AppMethodBeat.o(220564);
    }

    private static void a(erd erd, String str, dvj dvj, boolean z) {
        cbm last;
        String aoE;
        AppMethodBeat.i(220565);
        if (dvj == null || dvj.MWq.isEmpty()) {
            AppMethodBeat.o(220565);
            return;
        }
        String aoE2 = b.aoE(str);
        Iterator<dvi> it = dvj.MWq.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            dvi next = it.next();
            if (!(next == null || next.MWp.isEmpty() || (last = next.MWp.getLast()) == null || (aoE = b.aoE(last.dMl)) == null || !aoE.equals(aoE2))) {
                last.LPH.add(erd);
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                a(dvj, "mmkv_key_hellSPMatchinghe_");
                AppMethodBeat.o(220565);
                return;
            }
            a(dvj, "mmkv_key_hellSPMatchSuche_");
        }
        AppMethodBeat.o(220565);
    }

    public static void cQB() {
        AppMethodBeat.i(177392);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(177392);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hellSPMatchinghe_".concat(String.valueOf(uin)), new byte[0]);
            AppMethodBeat.o(177392);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", e2, "SessionPageMatchingCache.reset: %s", e2.getMessage());
            AppMethodBeat.o(177392);
        }
    }

    public static void cQC() {
        AppMethodBeat.i(177393);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(177393);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hellSPMatchSuche_".concat(String.valueOf(uin)), new byte[0]);
            AppMethodBeat.o(177393);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", e2, "SessionPageMatchingCache.reset: %s", e2.getMessage());
            AppMethodBeat.o(177393);
        }
    }

    private static void a(dvj dvj, String str) {
        AppMethodBeat.i(177394);
        if (dvj == null) {
            AppMethodBeat.o(177394);
            return;
        }
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(177394);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o(str + uin, dvj.toByteArray());
            AppMethodBeat.o(177394);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", e2, "SessionPageMatchingCache.write: %s", e2.getMessage());
            AppMethodBeat.o(177394);
        }
    }

    public static dvj aqP(String str) {
        AppMethodBeat.i(177395);
        int uin = b.getUin();
        if (uin == 0) {
            AppMethodBeat.o(177395);
            return null;
        }
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes(str + uin);
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(177395);
            return null;
        }
        dvj dvj = new dvj();
        try {
            dvj.parseFrom(bytes);
            AppMethodBeat.o(177395);
            return dvj;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.SessionPageMatchingCache", e2, "SessionPageMatchingCache.read: %s", e2.getMessage());
            AppMethodBeat.o(177395);
            return null;
        }
    }
}
