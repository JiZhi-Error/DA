package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "add", "", "canvasId", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "background", "canvasId2VirtualElementIdOrNull", "foreground", "foregroundCount", "get", "remove", "Companion", "Entity", "plugin-appbrand-integration_release"})
public final class a {
    private static final HashMap<String, a> lQN = new HashMap<>();
    public static final C0646a lQO = new C0646a((byte) 0);
    final String appId;
    public final ConcurrentHashMap<Integer, b> cCB = new ConcurrentHashMap<>();

    public static final a ZJ(String str) {
        AppMethodBeat.i(50491);
        a ZJ = C0646a.ZJ(str);
        AppMethodBeat.o(50491);
        return ZJ;
    }

    public a(String str) {
        p.h(str, "appId");
        AppMethodBeat.i(50489);
        this.appId = str;
        h.a(this.appId, new h.c(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.b.a.AnonymousClass1 */
            final /* synthetic */ a lQP;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.lQP = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(50483);
                C0646a aVar = a.lQO;
                C0646a.ZK(this.lQP.appId);
                AppMethodBeat.o(50483);
            }
        });
        AppMethodBeat.o(50489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Entity;", "", "view", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "(Lcom/tencent/magicbrush/ui/MagicBrushView;)V", "foreground", "", "getForeground", "()Z", "setForeground", "(Z)V", "getView", "()Lcom/tencent/magicbrush/ui/MagicBrushView;", "plugin-appbrand-integration_release"})
    public static final class b {
        boolean foreground;
        public final MagicBrushView lQQ;

        public b(MagicBrushView magicBrushView) {
            p.h(magicBrushView, "view");
            AppMethodBeat.i(50486);
            this.lQQ = magicBrushView;
            AppMethodBeat.o(50486);
        }
    }

    public final void a(int i2, MagicBrushView magicBrushView) {
        AppMethodBeat.i(228343);
        p.h(magicBrushView, "view");
        this.cCB.put(Integer.valueOf(i2), new b(magicBrushView));
        AppMethodBeat.o(228343);
    }

    public final void wZ(int i2) {
        AppMethodBeat.i(50487);
        b bVar = this.cCB.get(Integer.valueOf(i2));
        if (bVar != null) {
            bVar.foreground = true;
            AppMethodBeat.o(50487);
            return;
        }
        AppMethodBeat.o(50487);
    }

    public final void xa(int i2) {
        AppMethodBeat.i(228344);
        b bVar = this.cCB.get(Integer.valueOf(i2));
        if (bVar != null) {
            bVar.foreground = false;
            AppMethodBeat.o(228344);
            return;
        }
        AppMethodBeat.o(228344);
    }

    public final int bGc() {
        int i2 = 0;
        AppMethodBeat.i(50488);
        ConcurrentHashMap<Integer, b> concurrentHashMap = this.cCB;
        if (concurrentHashMap.isEmpty()) {
            AppMethodBeat.o(50488);
        } else {
            for (Map.Entry<Integer, b> entry : concurrentHashMap.entrySet()) {
                if (entry.getValue().foreground) {
                    i2++;
                }
            }
            AppMethodBeat.o(50488);
        }
        return i2;
    }

    public final void remove(int i2) {
        AppMethodBeat.i(228345);
        this.cCB.remove(Integer.valueOf(i2));
        AppMethodBeat.o(228345);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager$Companion;", "", "()V", "holder", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/canvas/HTMLCanvasElementManager;", "Lkotlin/collections/HashMap;", "instance", "appId", "release", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.a$a  reason: collision with other inner class name */
    public static final class C0646a {
        private C0646a() {
        }

        public /* synthetic */ C0646a(byte b2) {
            this();
        }

        public static a ZJ(String str) {
            AppMethodBeat.i(50484);
            p.h(str, "appId");
            synchronized (a.lQN) {
                try {
                    a aVar = (a) a.lQN.get(str);
                    if (aVar != null) {
                        return aVar;
                    }
                    a aVar2 = new a(str);
                    a.lQN.put(str, aVar2);
                    AppMethodBeat.o(50484);
                    return aVar2;
                } finally {
                    AppMethodBeat.o(50484);
                }
            }
        }

        public static a ZK(String str) {
            a aVar;
            AppMethodBeat.i(50485);
            p.h(str, "appId");
            synchronized (a.lQN) {
                try {
                    aVar = (a) a.lQN.remove(str);
                } finally {
                    AppMethodBeat.o(50485);
                }
            }
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(50490);
        AppMethodBeat.o(50490);
    }
}
