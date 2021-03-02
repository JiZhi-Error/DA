package com.tencent.mm.plugin.websearch.widget.c.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static List<a> IIr;

    static {
        AppMethodBeat.i(116659);
        ArrayList arrayList = new ArrayList();
        IIr = arrayList;
        arrayList.add(new c());
        IIr.add(new d());
        AppMethodBeat.o(116659);
    }

    public static boolean a(String str, n nVar, String str2, WidgetData widgetData) {
        AppMethodBeat.i(116658);
        Log.i("OpenAppHandler", "handle url %s", str);
        for (a aVar : IIr) {
            if (aVar != null && aVar.aXt(str)) {
                if (!aVar.Mb(widgetData.IFG.IFN)) {
                    c.d(widgetData.IFG.iIA, "openApp", str);
                    nVar.j(str2, str, "", -1);
                    AppMethodBeat.o(116658);
                    return true;
                } else if (aVar.aXu(str)) {
                    if (aVar instanceof d) {
                        fr frVar = new fr();
                        frVar.eGU = 2;
                        fr sF = frVar.sI(str).sH(widgetData.query).agD().sF(widgetData.IFG.hes);
                        sF.eGX = (long) widgetData.IFG.serviceType;
                        sF.sG(widgetData.dWw).bfK();
                    } else if (aVar instanceof c) {
                        fr frVar2 = new fr();
                        frVar2.eGU = 3;
                        fr sF2 = frVar2.sI(str).sH(widgetData.query).agD().sF(widgetData.IFG.hes);
                        sF2.eGX = (long) widgetData.IFG.serviceType;
                        sF2.sG(widgetData.dWw).bfK();
                    }
                    AppMethodBeat.o(116658);
                    return true;
                }
            }
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("open_target_weapp://")) {
            if (c.ak(widgetData.IFG.IFN, 2)) {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("path");
                String queryParameter2 = parse.getQueryParameter("origin_id");
                String queryParameter3 = parse.getQueryParameter("debug_mode");
                nVar.j(str2, queryParameter, queryParameter2 + "@app", !TextUtils.isEmpty(queryParameter3) ? Util.safeParseInt(queryParameter3) : -1);
                AppMethodBeat.o(116658);
                return false;
            }
            c.d(widgetData.IFG.iIA, "openApp", str);
        }
        nVar.j(str2, str, "", -1);
        AppMethodBeat.o(116658);
        return false;
    }
}
