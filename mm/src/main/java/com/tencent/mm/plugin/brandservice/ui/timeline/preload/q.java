package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.k;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u0012\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0002\u0010\u0017J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "PROPTYPE", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Resettable;", "manager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function0;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;Lkotlin/jvm/functions/Function0;)V", "getInit", "()Lkotlin/jvm/functions/Function0;", "lazyHolder", "Lkotlin/Lazy;", "getLazyHolder", "()Lkotlin/Lazy;", "setLazyHolder", "(Lkotlin/Lazy;)V", "getManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "makeInitBlock", "reset", "", "plugin-brandservice_release"})
public final class q<PROPTYPE> implements p {
    private volatile f<? extends PROPTYPE> pDp = com();
    final r pDq;
    final kotlin.g.a.a<PROPTYPE> pDr;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.a<? extends PROPTYPE> */
    /* JADX WARN: Multi-variable type inference failed */
    public q(r rVar, kotlin.g.a.a<? extends PROPTYPE> aVar) {
        p.h(rVar, "manager");
        p.h(aVar, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        AppMethodBeat.i(6730);
        this.pDq = rVar;
        this.pDr = aVar;
        AppMethodBeat.o(6730);
    }

    public final PROPTYPE a(k<?> kVar) {
        AppMethodBeat.i(6727);
        p.h(kVar, "property");
        PROPTYPE proptype = (PROPTYPE) this.pDp.getValue();
        AppMethodBeat.o(6727);
        return proptype;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.p
    public final void reset() {
        AppMethodBeat.i(6728);
        this.pDp = com();
        AppMethodBeat.o(6728);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "PROPTYPE", "invoke", "()Ljava/lang/Object;"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<PROPTYPE> {
        final /* synthetic */ q pDs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(0);
            this.pDs = qVar;
        }

        @Override // kotlin.g.a.a
        public final PROPTYPE invoke() {
            AppMethodBeat.i(6726);
            r rVar = this.pDs.pDq;
            q qVar = this.pDs;
            p.h(qVar, "managed");
            synchronized (rVar.pDt) {
                try {
                    rVar.pDt.add(qVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(6726);
                    throw th;
                }
            }
            PROPTYPE invoke = this.pDs.pDr.invoke();
            AppMethodBeat.o(6726);
            return invoke;
        }
    }

    private f<PROPTYPE> com() {
        AppMethodBeat.i(6729);
        f<PROPTYPE> ah = g.ah(new a(this));
        AppMethodBeat.o(6729);
        return ah;
    }
}
