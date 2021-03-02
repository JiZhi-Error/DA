package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ReturnCopyUrlWatcherRegister;", "", "()V", "watchers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "Lkotlin/collections/HashSet;", "notify", "", "type", "url", "", "register", "delayUnregisterAutomaticallyInMs", "", "watcher", "unregister", "luggage-wechat-full-sdk_release"})
public final class da {
    private static final Map<ad, HashSet<ah>> lCH = new LinkedHashMap();
    public static final da lCI = new da();

    static {
        AppMethodBeat.i(230067);
        AppMethodBeat.o(230067);
    }

    private da() {
    }

    public static void a(ad adVar, ah ahVar) {
        AppMethodBeat.i(230064);
        p.h(adVar, "type");
        p.h(ahVar, "watcher");
        synchronized (lCH) {
            try {
                Map<ad, HashSet<ah>> map = lCH;
                HashSet<ah> hashSet = map.get(adVar);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    map.put(adVar, hashSet);
                }
                hashSet.add(ahVar);
            } catch (Throwable th) {
                AppMethodBeat.o(230064);
                throw th;
            }
        }
        a aVar = new a(adVar, ahVar);
        p.h(aVar, "block");
        MMHandlerThread.postToMainThreadDelayed(new d(aVar), 10000);
        AppMethodBeat.o(230064);
    }

    public static void b(ad adVar, ah ahVar) {
        AppMethodBeat.i(230065);
        p.h(adVar, "type");
        p.h(ahVar, "watcher");
        synchronized (lCH) {
            try {
                HashSet<ah> hashSet = lCH.get(adVar);
                if (hashSet != null) {
                    Boolean.valueOf(hashSet.remove(ahVar));
                }
            } finally {
                AppMethodBeat.o(230065);
            }
        }
    }

    public static void a(ad adVar, String str) {
        HashSet<ah> hashSet;
        AppMethodBeat.i(230066);
        p.h(adVar, "type");
        p.h(str, "url");
        synchronized (lCH) {
            try {
                hashSet = new HashSet();
                Map<ad, HashSet<ah>> map = lCH;
                HashSet<ah> hashSet2 = map.get(adVar);
                if (hashSet2 == null) {
                    hashSet2 = new HashSet<>();
                    map.put(adVar, hashSet2);
                }
                hashSet.addAll(hashSet2);
            } finally {
                AppMethodBeat.o(230066);
            }
        }
        for (ah ahVar : hashSet) {
            ahVar.Zi(str);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ad lCJ;
        final /* synthetic */ ah lCK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ad adVar, ah ahVar) {
            super(0);
            this.lCJ = adVar;
            this.lCK = ahVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230063);
            da daVar = da.lCI;
            da.b(this.lCJ, this.lCK);
            x xVar = x.SXb;
            AppMethodBeat.o(230063);
            return xVar;
        }
    }
}
