package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC;", "", "()V", "connect", "", "waitFor", "block", "Lkotlin/Function0;", "IPCInvokerConnector", "plugin-appbrand-integration_release"})
public final class b {
    public static final b lwB = new b();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.b$b  reason: collision with other inner class name */
    public static final class C0591b extends q implements kotlin.g.a.a<x> {
        public static final C0591b lwC = new C0591b();

        static {
            AppMethodBeat.i(228215);
            AppMethodBeat.o(228215);
        }

        C0591b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    static {
        AppMethodBeat.i(228221);
        AppMethodBeat.o(228221);
    }

    private b() {
    }

    public static final void connect() {
        AppMethodBeat.i(228219);
        w(C0591b.lwC);
        AppMethodBeat.o(228219);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ kotlin.g.a.a hvp;

        e(kotlin.g.a.a aVar) {
            this.hvp = aVar;
        }

        public final void run() {
            AppMethodBeat.i(228218);
            this.hvp.invoke();
            AppMethodBeat.o(228218);
        }
    }

    public static final void w(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(228220);
        p.h(aVar, "block");
        k kVar = new k(new e(aVar), 2);
        AppBrandMainProcessService.Y(new c(kVar));
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class, new d(kVar));
        AppMethodBeat.o(228220);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ k lwD;

        c(k kVar) {
            this.lwD = kVar;
        }

        public final void run() {
            AppMethodBeat.i(228216);
            this.lwD.countDown();
            AppMethodBeat.o(228216);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    public static final class d<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ k lwD;

        d(k kVar) {
            this.lwD = kVar;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(228217);
            this.lwD.countDown();
            AppMethodBeat.o(228217);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC$IPCInvokerConnector;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(228214);
            if (dVar != null) {
                dVar.bn(IPCVoid.hnE);
                AppMethodBeat.o(228214);
                return;
            }
            AppMethodBeat.o(228214);
        }
    }
}
