package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.n.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.u;
import java.util.HashMap;
import java.util.Map;

public final class s {
    private static boolean GYM = false;
    private static DialogInterface.OnClickListener GYN = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.voip.model.s.AnonymousClass1 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(235663);
            s.access$000();
            AppMethodBeat.o(235663);
        }
    };

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(115099);
        fHt();
        AppMethodBeat.o(115099);
    }

    public static long c(String str, String str2, int i2, int i3, String str3) {
        AppMethodBeat.i(115090);
        long a2 = a(str, str2, i2, i3, str3, false);
        AppMethodBeat.o(115090);
        return a2;
    }

    public static long a(String str, String str2, int i2, int i3, String str3, boolean z) {
        AppMethodBeat.i(115091);
        ca caVar = new ca();
        caVar.setCreateTime(bp.Kw(str));
        caVar.nv(i2);
        caVar.setType(50);
        caVar.Cy(str);
        caVar.BB(str3);
        caVar.setContent(str2);
        caVar.setStatus(i3);
        if (z) {
            caVar.gDH();
        }
        long aC = ((l) g.af(l.class)).eiy().aC(caVar);
        if (aC < 0) {
            Log.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        Log.d("MicroMsg.VoipPluginManager", "inset voip  msgId ".concat(String.valueOf(aC)));
        AppMethodBeat.o(115091);
        return aC;
    }

    public static void fHr() {
        AppMethodBeat.i(115092);
        g.aAh().azQ().set(20480, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(115092);
    }

    public static boolean fHs() {
        AppMethodBeat.i(115093);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Long) g.aAh().azQ().get(20480, (Object) -1)).longValue();
            if (longValue < 0) {
                AppMethodBeat.o(115093);
                return false;
            }
            long j2 = currentTimeMillis - longValue;
            Log.d("MicroMsg.VoipPluginManager", "diff is".concat(String.valueOf(j2)));
            if (j2 < 21600000) {
                AppMethodBeat.o(115093);
                return true;
            }
            AppMethodBeat.o(115093);
            return false;
        } catch (Exception e2) {
        }
    }

    static {
        AppMethodBeat.i(115100);
        AppMethodBeat.o(115100);
    }

    public static void bH(Context context, String str) {
        AppMethodBeat.i(115094);
        new String[1][0] = context.getResources().getString(R.string.i12);
        GYM = false;
        try {
            if (((l) g.af(l.class)).eiy().aEz(str) != null) {
                GYM = m.fKF();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.o(115094);
            return;
        }
        int aYS = g.azz().aYS();
        Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(aYS)));
        if (aYS != 4 && aYS != 6) {
            h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(c.fFg().GYS.GSZ.fGu()), 4, 0);
            com.tencent.mm.ui.base.h.a(context, (int) R.string.i3o, (int) R.string.i3s, GYN);
            AppMethodBeat.o(115094);
        } else if (!GYM) {
            try {
                Map<String, i.a> aUx = i.a.aUx((String) g.aAh().azQ().get(77829, (Object) null));
                if (aUx != null) {
                    if (aUx != null && aUx.size() > 0) {
                        if (aUx.containsKey(str)) {
                            i.a aVar = aUx.get(str);
                            aVar.hitCount++;
                            aUx.put(str, aVar);
                        } else {
                            i.a aVar2 = new i.a();
                            aVar2.hitCount++;
                            aUx.put(str, aVar2);
                        }
                    }
                    g.aAh().azQ().set(77829, i.a.aV(aUx));
                    for (Map.Entry<String, i.a> entry : aUx.entrySet()) {
                        i.a value = entry.getValue();
                        Log.d("MicroMsg.VoipPluginManager", "val1 " + value.hitCount + " " + value.jgU + "name " + entry.getKey());
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    i.a aVar3 = new i.a();
                    aVar3.hitCount++;
                    hashMap.put(str, aVar3);
                    g.aAh().azQ().set(77829, i.a.aV(hashMap));
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        i.a aVar4 = (i.a) entry2.getValue();
                        Log.d("MicroMsg.VoipPluginManager", "val2 " + aVar4.hitCount + " " + aVar4.jgU + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.VoipPluginManager", e3, "", new Object[0]);
            }
            InviteRemindDialog.o(context, str, 0);
            fHt();
            AppMethodBeat.o(115094);
        } else if (NetStatusUtil.isWifi(context) || fHs()) {
            c.fFg().bM(context, str);
            AppMethodBeat.o(115094);
        } else {
            c.fFg().bM(context, str);
            AppMethodBeat.o(115094);
        }
    }

    private static void fHt() {
        AppMethodBeat.i(115095);
        zj zjVar = new zj();
        zjVar.efx.dKy = 8;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(115095);
    }

    public static void bI(Context context, String str) {
        AppMethodBeat.i(115096);
        com.tencent.mm.n.h.aqK();
        boolean z = d.aqw() == 2;
        com.tencent.mm.br.c.gsX();
        if (!z) {
            Log.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", Boolean.FALSE, Boolean.FALSE);
        }
        GYM = false;
        try {
            if (((l) g.af(l.class)).eiy().aEz(str) != null) {
                GYM = m.fKF();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
        }
        bK(context, str);
        AppMethodBeat.o(115096);
    }

    public static void bJ(Context context, String str) {
        AppMethodBeat.i(115097);
        GYM = false;
        try {
            if (((l) g.af(l.class)).eiy().aEz(str) != null) {
                GYM = m.fKF();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
        }
        bK(context, str);
        AppMethodBeat.o(115097);
    }

    private static void bK(Context context, String str) {
        AppMethodBeat.i(115098);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.VoipPluginManager", "talker is null");
            AppMethodBeat.o(115098);
            return;
        }
        int aYS = g.azz().aYS();
        Log.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus ".concat(String.valueOf(aYS)));
        if (aYS != 4 && aYS != 6) {
            h.INSTANCE.a(11518, true, true, Integer.valueOf(c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(c.fFg().GYS.GSZ.fGu()), 4, 0);
            com.tencent.mm.ui.base.h.a(context, (int) R.string.i3o, (int) R.string.i3s, GYN);
            AppMethodBeat.o(115098);
        } else if (!GYM) {
            try {
                Map<String, i.a> aUx = i.a.aUx((String) g.aAh().azQ().get(77829, (Object) null));
                if (aUx != null) {
                    if (aUx != null && aUx.size() > 0) {
                        if (aUx.containsKey(str)) {
                            i.a aVar = aUx.get(str);
                            aVar.hitCount++;
                            aUx.put(str, aVar);
                        } else {
                            i.a aVar2 = new i.a();
                            aVar2.hitCount++;
                            aUx.put(str, aVar2);
                        }
                    }
                    g.aAh().azQ().set(77829, i.a.aV(aUx));
                    for (Map.Entry<String, i.a> entry : aUx.entrySet()) {
                        i.a value = entry.getValue();
                        Log.d("MicroMsg.VoipPluginManager", "val1 " + value.hitCount + " " + value.jgU + "name " + entry.getKey());
                    }
                } else {
                    HashMap hashMap = new HashMap();
                    i.a aVar3 = new i.a();
                    aVar3.hitCount++;
                    hashMap.put(str, aVar3);
                    g.aAh().azQ().set(77829, i.a.aV(hashMap));
                    for (Map.Entry entry2 : hashMap.entrySet()) {
                        i.a aVar4 = (i.a) entry2.getValue();
                        Log.d("MicroMsg.VoipPluginManager", "val2 " + aVar4.hitCount + " " + aVar4.jgU + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.o(context, str, 1);
            fHt();
            AppMethodBeat.o(115098);
        } else if (NetStatusUtil.isWifi(context) || fHs()) {
            c.fFg().bL(context, str);
            AppMethodBeat.o(115098);
        } else {
            c.fFg().bL(context, str);
            AppMethodBeat.o(115098);
        }
    }

    public static void hA(Context context) {
        boolean z;
        AppMethodBeat.i(235664);
        if (!NetStatusUtil.isWifi(context)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            u.cF(context, context.getResources().getText(R.string.i1j).toString());
        }
        AppMethodBeat.o(235664);
    }
}
