package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class b {
    static String TAG = "MicroMsg.ExptIdMMKV";
    private static b rNJ;
    private String name = null;

    public static b cMz() {
        AppMethodBeat.i(220253);
        if (rNJ == null) {
            rNJ = new b();
        }
        b bVar = rNJ;
        AppMethodBeat.o(220253);
        return bVar;
    }

    private b() {
    }

    public final MultiProcessMMKV aTI() {
        AppMethodBeat.i(220254);
        d.cRY();
        int uin = d.getUin();
        if (uin == 0) {
            Log.e(TAG, "uin err [%d]", Integer.valueOf(uin));
            AppMethodBeat.o(220254);
            return null;
        }
        String str = uin + "_WxExptIdmmkv";
        if (!Util.isEqual(this.name, str)) {
            Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", info(), this.name, str);
            this.name = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.name);
        AppMethodBeat.o(220254);
        return mmkv;
    }

    public final List<aki> cMA() {
        String[] allKeys;
        AppMethodBeat.i(220255);
        LinkedList linkedList = new LinkedList();
        MultiProcessMMKV aTI = aTI();
        if (!(aTI == null || (allKeys = aTI.allKeys()) == null || allKeys.length <= 0)) {
            Log.i(TAG, "mmkv keys length is [%d] ", Integer.valueOf(allKeys.length));
            for (int i2 = 0; i2 < allKeys.length; i2++) {
                aki aki = new aki();
                a HA = com.tencent.mm.plugin.expt.h.b.cRI().HA(Util.getInt(allKeys[i2], 0));
                if (HA != null) {
                    aki.Ltq = HA.sLf;
                    aki.Ltr = HA.adT;
                    aki.Lts = HA.sLg;
                    aki.count = aTI.decodeInt(allKeys[i2]);
                    linkedList.add(aki);
                }
            }
        }
        AppMethodBeat.o(220255);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void cMB() {
        AppMethodBeat.i(220256);
        MultiProcessMMKV aTI = aTI();
        if (aTI == null) {
            AppMethodBeat.o(220256);
        } else {
            aTI.clear().commit();
            AppMethodBeat.o(220256);
        }
    }

    private String info() {
        AppMethodBeat.i(220257);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(220257);
        return sb;
    }
}
