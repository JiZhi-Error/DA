package com.tencent.mm.plugin.appbrand.dynamic.d.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.b.a.oa;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static Map<String, Map<Integer, e>> lnS;
    private static final Pattern lnT = Pattern.compile("(\\{\"method\":\"drawImage\",\"data\":\\[\"undefined\".*?\\})|(\\{\"method\":\"fillText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})|(\\{\"method\":\"strokeText\",\"data\":[^\\}]*?undefined.[^\\}]*?\\]\\})");

    static {
        AppMethodBeat.i(121361);
        AppMethodBeat.o(121361);
    }

    public static e bH(String str, int i2) {
        HashMap hashMap;
        AppMethodBeat.i(121358);
        if (lnS == null) {
            HashMap hashMap2 = new HashMap();
            lnS = hashMap2;
            hashMap2.put(str, new HashMap());
        }
        Map<Integer, e> map = lnS.get(str);
        if (map == null) {
            HashMap hashMap3 = new HashMap();
            lnS.put(str, hashMap3);
            hashMap = hashMap3;
        } else {
            hashMap = map;
        }
        e eVar = hashMap.get(Integer.valueOf(i2));
        if (eVar == null) {
            switch (i2) {
                case 0:
                    eVar = new d();
                    break;
                case 1:
                    eVar = new b();
                    break;
                case 2:
                    eVar = new c();
                    break;
                default:
                    eVar = new c();
                    break;
            }
            hashMap.put(Integer.valueOf(i2), eVar);
        }
        AppMethodBeat.o(121358);
        return eVar;
    }

    public static void Yz(String str) {
        AppMethodBeat.i(121359);
        if (lnS == null) {
            AppMethodBeat.o(121359);
            return;
        }
        Map<Integer, e> map = lnS.get(str);
        if (map != null) {
            for (e eVar : map.values()) {
                eVar.reset();
            }
            map.clear();
        }
        AppMethodBeat.o(121359);
    }

    public static void dc(final String str, final String str2) {
        AppMethodBeat.i(121360);
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(121360);
            return;
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.a.AnonymousClass1 */

            public final void run() {
                int length;
                z zVar;
                int i2 = 0;
                AppMethodBeat.i(121357);
                Matcher matcher = a.lnT.matcher(str2);
                if (matcher.find()) {
                    Log.i("DrawCanvasMgr", "invalid draw data %s", str2);
                    int start = matcher.start();
                    int end = matcher.end();
                    if (start > 30) {
                        i2 = start - 30;
                    }
                    if (end < str2.length() - 30) {
                        length = end + 30;
                    } else {
                        length = str2.length();
                    }
                    f.bBJ();
                    String str = str;
                    String substring = str2.substring(i2, length);
                    if (!(str == null || str.length() == 0)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("id", str);
                        bundle.putInt("widgetState", 2113);
                        com.tencent.mm.ipcinvoker.h.a(i.bBL().Yn(str), bundle, f.a.class, null);
                    }
                    IPCDynamicPageView YC = com.tencent.mm.plugin.appbrand.dynamic.h.a.bCk().YC(str);
                    if (!(YC == null || YC.lpO == null || (zVar = (z) YC.lpO.LA("onWidgetDrawDataInvalid")) == null)) {
                        zVar.Ly(substring);
                    }
                    oa oaVar = new oa();
                    oaVar.fiO = oaVar.x("WidgetAppid", "", true);
                    oaVar.fiP = oaVar.x("SrcAppid", u.Lv(str), true);
                    oaVar.fiQ = oaVar.x("DrawData", q.encode(substring), true);
                    oaVar.bfK();
                }
                AppMethodBeat.o(121357);
            }
        }, "onDrawFrame");
        AppMethodBeat.o(121360);
    }
}
