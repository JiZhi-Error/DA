package com.tencent.mm.plugin.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void c(g gVar) {
        boolean z;
        boolean a2;
        AppMethodBeat.i(42527);
        if (gVar == null) {
            Log.e("MicroMsg.GameDataUtil", "Null appInfo");
            AppMethodBeat.o(42527);
        } else if (Util.isNullOrNil(gVar.field_appId)) {
            Log.e("MicroMsg.GameDataUtil", "Invalid appId");
            AppMethodBeat.o(42527);
        } else {
            String str = gVar.field_appId;
            g o = h.o(str, true, false);
            if (o == null) {
                o = new g();
                o.field_appId = str;
                z = true;
            } else {
                z = false;
            }
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            if (applicationLanguage.equals(LocaleUtil.CHINA)) {
                o.field_appName = gVar.field_appName;
            } else if (applicationLanguage.equals(LocaleUtil.TAIWAN) || applicationLanguage.equals(LocaleUtil.HONGKONG)) {
                o.field_appName_tw = gVar.field_appName;
            } else {
                o.field_appName_en = gVar.field_appName;
            }
            o.field_appType = gVar.field_appType;
            o.field_packageName = gVar.field_packageName;
            o.Bl(gVar.fmE);
            o.Bo(gVar.fmJ);
            o.mZ(gVar.fmN);
            o.Bp(gVar.fmK);
            o.Bu(gVar.fmQ);
            o.Bv(gVar.fmR);
            o.Bs(gVar.fmO);
            o.Bt(gVar.fmP);
            o.na(gVar.fmT);
            if (!Util.isNullOrNil(gVar.fmH)) {
                o.Bm(gVar.fmH);
            }
            if (z) {
                a2 = a.eAS().r(o);
                a.C1616a.eAZ().aJz(str);
            } else if (o.field_appVersion < gVar.field_appVersion) {
                Log.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", Integer.valueOf(o.field_appVersion), Integer.valueOf(gVar.field_appVersion));
                a2 = com.tencent.mm.plugin.r.a.eAS().a(o, new String[0]);
                a.C1616a.eAZ().aJz(str);
            } else if (a(o, gVar)) {
                Log.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", o.field_appIconUrl, gVar.field_appIconUrl);
                o.field_appIconUrl = gVar.field_appIconUrl;
                a2 = com.tencent.mm.plugin.r.a.eAS().a(o, new String[0]);
                com.tencent.mm.plugin.r.a.eAQ().gD(str, 1);
                com.tencent.mm.plugin.r.a.eAQ().gD(str, 2);
                com.tencent.mm.plugin.r.a.eAQ().gD(str, 3);
                com.tencent.mm.plugin.r.a.eAQ().gD(str, 4);
                com.tencent.mm.plugin.r.a.eAQ().gD(str, 5);
            } else {
                a2 = com.tencent.mm.plugin.r.a.eAS().a(o, new String[0]);
            }
            Log.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", str, Boolean.valueOf(z), Boolean.valueOf(a2));
            AppMethodBeat.o(42527);
        }
    }

    private static boolean a(g gVar, g gVar2) {
        AppMethodBeat.i(42528);
        if (gVar == null || Util.isNullOrNil(gVar.field_appIconUrl)) {
            AppMethodBeat.o(42528);
            return true;
        } else if (gVar2 == null || Util.isNullOrNil(gVar2.field_appIconUrl)) {
            AppMethodBeat.o(42528);
            return false;
        } else if (!gVar.field_appIconUrl.equals(gVar2.field_appIconUrl)) {
            AppMethodBeat.o(42528);
            return true;
        } else {
            AppMethodBeat.o(42528);
            return false;
        }
    }

    public static void aZ(LinkedList<? extends g> linkedList) {
        AppMethodBeat.i(42529);
        if (linkedList == null) {
            Log.e("MicroMsg.GameDataUtil", "Null appInfos");
            AppMethodBeat.o(42529);
            return;
        }
        Iterator<? extends g> it = linkedList.iterator();
        while (it.hasNext()) {
            c((g) it.next());
        }
        AppMethodBeat.o(42529);
    }
}
