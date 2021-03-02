package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.live.d;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.a;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.b;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.e;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.l;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.m;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.n;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static volatile Set<String> nxj;

    static {
        AppMethodBeat.i(147598);
        HashSet hashSet = new HashSet();
        nxj = hashSet;
        hashSet.add(com.tencent.mm.plugin.appbrand.jsapi.live.c.NAME);
        nxj.add(d.NAME);
        nxj.add(f.NAME);
        nxj.add(com.tencent.mm.plugin.appbrand.jsapi.ag.c.b.a.c.NAME);
        Collections.addAll(nxj, com.tencent.mm.plugin.appbrand.jsapi.openvoice.c.NAME, a.NAME, m.NAME, n.NAME, l.NAME, com.tencent.mm.plugin.appbrand.jsapi.openvoice.f.NAME, b.NAME, e.NAME, com.tencent.mm.plugin.appbrand.jsapi.openvoice.d.NAME);
        AppMethodBeat.o(147598);
    }

    public static void aem(String str) {
        AppMethodBeat.i(169512);
        nxj.add(str);
        AppMethodBeat.o(169512);
    }

    static int e(com.tencent.mm.plugin.appbrand.jsapi.f fVar, String str, String str2) {
        boolean contains;
        int i2 = Integer.MIN_VALUE;
        AppMethodBeat.i(147597);
        if (fVar instanceof ac) {
            contains = true;
        } else {
            contains = nxj.contains(str);
        }
        if (!contains) {
            AppMethodBeat.o(147597);
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(147597);
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.has("permissionBytes")) {
                    AppMethodBeat.o(147597);
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("permissionBytes");
                    if (jSONArray.length() < 3) {
                        Log.w("MicroMsg.AppRuntimeApiPermissionController", "permissionBytes length:%d invalid", Integer.valueOf(jSONArray.length()));
                        AppMethodBeat.o(147597);
                    } else {
                        if (fVar instanceof s) {
                            switch (((s) fVar).getRuntime().kAH.kQM.bwY()) {
                                case SUSPEND:
                                    i2 = jSONArray.optInt(2, Integer.MIN_VALUE);
                                    break;
                                case DESTROYED:
                                case BACKGROUND:
                                    i2 = jSONArray.optInt(1, Integer.MIN_VALUE);
                                    break;
                                default:
                                    i2 = jSONArray.optInt(0, Integer.MIN_VALUE);
                                    break;
                            }
                        } else {
                            i2 = jSONArray.optInt(0, Integer.MIN_VALUE);
                        }
                        Log.i("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy api:%s checkRet:%d", str, Integer.valueOf(i2));
                        AppMethodBeat.o(147597);
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.AppRuntimeApiPermissionController", "checkWithSkipStrategy exp:%s", e2.getMessage());
                AppMethodBeat.o(147597);
            }
        }
        return i2;
    }
}
