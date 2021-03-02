package com.tencent.mm.plugin.appbrand.networking;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/networking/INetworkService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "mRuntime", "getMRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "l", "notifyNetworkStateChanged", "onRegister", "onUnregister", "removeListener", "luggage-wxa-app_release"})
public class g implements b, d {
    final AppBrandRuntime kEc;
    @TargetApi(21)
    private final ConcurrentLinkedDeque<e> njD = new ConcurrentLinkedDeque<>();

    public g(AppBrandRuntime appBrandRuntime) {
        p.h(appBrandRuntime, "rt");
        AppMethodBeat.i(135591);
        this.kEc = appBrandRuntime;
        AppMethodBeat.o(135591);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onNetworkStateChanged"})
    public static final class a implements e {
        final /* synthetic */ g njE;

        a(g gVar) {
            this.njE = gVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.networking.e
        public final void bIS() {
            AppMethodBeat.i(135586);
            com.tencent.mm.plugin.appbrand.jsapi.z.a.m(this.njE.kEc.NY());
            AppMethodBeat.o(135586);
        }
    }

    @Override // com.tencent.mm.kernel.c.b
    public void aBc() {
        AppMethodBeat.i(135587);
        a(new a(this));
        AppMethodBeat.o(135587);
    }

    @Override // com.tencent.mm.kernel.c.b
    public void aBd() {
        AppMethodBeat.i(135588);
        this.njD.clear();
        AppMethodBeat.o(135588);
    }

    public final void bPO() {
        AppMethodBeat.i(135589);
        s NY = this.kEc.NY();
        if (NY != null) {
            if (NY.isRunning()) {
                Iterator<e> it = this.njD.iterator();
                while (it.hasNext()) {
                    it.next().bIS();
                }
            }
            AppMethodBeat.o(135589);
            return;
        }
        AppMethodBeat.o(135589);
    }

    @Override // com.tencent.mm.plugin.appbrand.networking.d
    public final void a(e eVar) {
        AppMethodBeat.i(135590);
        this.njD.add(eVar);
        AppMethodBeat.o(135590);
    }
}
