package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.appbrand.networking.d;
import com.tencent.mm.plugin.appbrand.networking.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", f.NAME, "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"})
public final class g extends f implements e {
    @Deprecated
    public static final a mtW = new a((byte) 0);
    private final AtomicReference<f.c> mtT = new AtomicReference<>(null);
    private final AtomicBoolean mtU = new AtomicBoolean(false);
    private final AtomicBoolean mtV = new AtomicBoolean(false);

    static {
        AppMethodBeat.i(135580);
        AppMethodBeat.o(135580);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa$Companion;", "", "()V", "TAG", "", "luggage-wxa-app_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public g() {
        AppMethodBeat.i(135579);
        AppMethodBeat.o(135579);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.f
    public final f.c D(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
        f.c cVar;
        d dVar;
        AppMethodBeat.i(135577);
        p.h(fVar, "component");
        if (!this.mtU.getAndSet(true) && (dVar = (d) fVar.M(d.class)) != null) {
            dVar.a(this);
            this.mtV.set(true);
        }
        if (this.mtV.get()) {
            cVar = this.mtT.get();
            if (cVar == null) {
                f.c D = super.D(fVar);
                this.mtT.set(D);
                p.g(D, "super.getNetworkType(com…mCached.set(fromSystem) }");
                AppMethodBeat.o(135577);
                return D;
            }
        } else {
            cVar = super.D(fVar);
            p.g(cVar, "super.getNetworkType(component)");
        }
        AppMethodBeat.o(135577);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.e
    public final void bIS() {
        AppMethodBeat.i(135578);
        this.mtT.set(null);
        AppMethodBeat.o(135578);
    }
}
