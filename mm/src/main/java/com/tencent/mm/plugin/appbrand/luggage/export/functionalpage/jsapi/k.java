package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import java.util.HashMap;
import java.util.Map;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiPool;", "", "()V", "getPagePool", "", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "getServicePool", "plugin-appbrand-integration_release"})
public final class k {
    public static final k nbF = new k();

    static {
        AppMethodBeat.i(228921);
        AppMethodBeat.o(228921);
    }

    private k() {
    }

    public static final Map<String, p> bOL() {
        AppMethodBeat.i(228919);
        HashMap hashMap = new HashMap(t.bEk());
        for (p pVar : j.listOf((Object[]) new p[]{new h(), new i(), new j(), new l()})) {
            hashMap.put(pVar.getName(), pVar);
        }
        HashMap hashMap2 = hashMap;
        AppMethodBeat.o(228919);
        return hashMap2;
    }

    public static final Map<String, p> bOM() {
        AppMethodBeat.i(228920);
        HashMap hashMap = new HashMap(t.bEl());
        for (p pVar : j.listOf((Object[]) new p[]{new h(), new i(), new j(), new l()})) {
            hashMap.put(pVar.getName(), pVar);
        }
        HashMap hashMap2 = hashMap;
        AppMethodBeat.o(228920);
        return hashMap2;
    }
}
