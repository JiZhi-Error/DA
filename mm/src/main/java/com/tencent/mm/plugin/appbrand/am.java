package com.tencent.mm.plugin.appbrand;

import com.tencent.f.i;
import com.tencent.f.i.h;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/Loader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "loaderId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(ILcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "bindRemoteService", "", "configWC", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "getKey", "run", "Companion", "plugin-appbrand-integration_release"})
final class am implements h {
    @Deprecated
    public static final a kFa = new a((byte) 0);
    private final int kEI;
    private final LaunchParcel kEX;
    private final String kEY;
    com.tencent.mm.plugin.appbrand.api.f kEZ;

    static {
        AppMethodBeat.i(227928);
        AppMethodBeat.o(227928);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "invoke"})
    public static final class c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<BindRemoteServiceData, BindRemoteServiceResult> {
        public static final c kFe = new c();

        static {
            AppMethodBeat.i(227919);
            AppMethodBeat.o(227919);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BindRemoteServiceData bindRemoteServiceData, final com.tencent.mm.ipcinvoker.d<BindRemoteServiceResult> dVar) {
            AppMethodBeat.i(227918);
            BindRemoteServiceData bindRemoteServiceData2 = bindRemoteServiceData;
            if (bindRemoteServiceData2 == null && dVar != null) {
                dVar.bn(new BindRemoteServiceResult(-4));
                x xVar = x.SXb;
            }
            i iVar = com.tencent.f.h.RTc;
            p.g(bindRemoteServiceData2, "data");
            iVar.aV(new at(bindRemoteServiceData2, new com.tencent.mm.plugin.appbrand.api.f() {
                /* class com.tencent.mm.plugin.appbrand.am.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.api.f
                public final void onSuccess() {
                    AppMethodBeat.i(227916);
                    com.tencent.mm.ipcinvoker.d dVar = dVar;
                    if (dVar != null) {
                        dVar.bn(new BindRemoteServiceResult(0));
                        AppMethodBeat.o(227916);
                        return;
                    }
                    AppMethodBeat.o(227916);
                }

                @Override // com.tencent.mm.plugin.appbrand.api.f
                public final void onError(int i2, String str) {
                    AppMethodBeat.i(227917);
                    com.tencent.mm.ipcinvoker.d dVar = dVar;
                    if (dVar != null) {
                        dVar.bn(new BindRemoteServiceResult(i2, str));
                        AppMethodBeat.o(227917);
                        return;
                    }
                    AppMethodBeat.o(227917);
                }
            }));
            AppMethodBeat.o(227918);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "kotlin.jvm.PlatformType", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "result", "", "onResult"})
    static final class e<T extends AppBrandInitConfigLU> implements e.a<AppBrandInitConfigWC> {
        final /* synthetic */ am kFb;

        e(am amVar) {
            this.kFb = amVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.config.AppBrandInitConfigLU, com.tencent.mm.plugin.appbrand.report.AppBrandStatObject, int] */
        @Override // com.tencent.mm.plugin.appbrand.launching.e.a
        public final /* synthetic */ void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2) {
            AppMethodBeat.i(227923);
            AppBrandInitConfigWC appBrandInitConfigWC2 = appBrandInitConfigWC;
            a unused = am.kFa;
            Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-OnPreLaunchResultListener.onResult, result:" + i2 + " config:" + appBrandInitConfigWC2);
            if (appBrandInitConfigWC2 == null) {
                com.tencent.mm.plugin.appbrand.api.f fVar = this.kFb.kEZ;
                if (fVar != null) {
                    f.a.a(fVar, -3);
                    AppMethodBeat.o(227923);
                    return;
                }
                AppMethodBeat.o(227923);
                return;
            }
            this.kFb.kEX.f(appBrandInitConfigWC2);
            com.tencent.mm.plugin.appbrand.launching.c.b(appBrandInitConfigWC2, appBrandStatObject);
            am amVar = this.kFb;
            p.g(appBrandStatObject, "stat");
            am.a(amVar, appBrandInitConfigWC2, appBrandStatObject);
            AppMethodBeat.o(227923);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/Loader$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public am(int i2, LaunchParcel launchParcel, String str, com.tencent.mm.plugin.appbrand.api.f fVar) {
        p.h(launchParcel, "parcel");
        p.h(str, "instanceId");
        AppMethodBeat.i(227927);
        this.kEI = i2;
        this.kEX = launchParcel;
        this.kEY = str;
        this.kEZ = fVar;
        AppMethodBeat.o(227927);
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public final String getKey() {
        AppMethodBeat.i(227925);
        String str = "AppBrandPreRenderColdStartService.Loader-" + this.kEI;
        AppMethodBeat.o(227925);
        return str;
    }

    public final void run() {
        AppMethodBeat.i(227926);
        Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-start, id:" + this.kEI + ", username:" + this.kEX.username + ", appId:" + this.kEX.appId + ", versionType:" + this.kEX.iOo + ", instanceId:" + this.kEY + ", path:" + this.kEX.kHw);
        com.tencent.mm.plugin.appbrand.launching.f fVar = new com.tencent.mm.plugin.appbrand.launching.f(this.kEX, this.kEY, new e(this), new f(this));
        fVar.a(com.tencent.luggage.sdk.launching.b.PRE_RENDER);
        fVar.run();
        AppMethodBeat.o(227926);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "showPrompt"})
    static final class f implements f.a {
        final /* synthetic */ am kFb;

        f(am amVar) {
            this.kFb = amVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.launching.f.a
        public final void bto() {
            AppMethodBeat.i(227924);
            a unused = am.kFa;
            Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "run()-showPrompt, id:" + this.kFb.kEI);
            AppMethodBeat.o(227924);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
    public static final class b implements m {
        final /* synthetic */ am kFb;
        final /* synthetic */ AtomicBoolean kFc;
        final /* synthetic */ String kFd;

        b(am amVar, AtomicBoolean atomicBoolean, String str) {
            this.kFb = amVar;
            this.kFc = atomicBoolean;
            this.kFd = str;
        }

        @Override // com.tencent.mm.ipcinvoker.m
        public final void aye() {
            com.tencent.mm.plugin.appbrand.api.f fVar;
            AppMethodBeat.i(227915);
            a unused = am.kFa;
            Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onRemoteProcess died, id:" + this.kFb.kEI);
            if (!this.kFc.getAndSet(true) && (fVar = this.kFb.kEZ) != null) {
                f.a.a(fVar, -5);
            }
            com.tencent.mm.ipcinvoker.h.a(this.kFd, this);
            AppMethodBeat.o(227915);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/Loader$bindRemoteService$3", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceResult;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "plugin-appbrand-integration_release"})
    public static final class d implements com.tencent.mm.ipcinvoker.e<BindRemoteServiceResult> {
        final /* synthetic */ am kFb;
        final /* synthetic */ AtomicBoolean kFc;

        d(am amVar, AtomicBoolean atomicBoolean) {
            this.kFb = amVar;
            this.kFc = atomicBoolean;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(227920);
            BindRemoteServiceResult bindRemoteServiceResult = (BindRemoteServiceResult) obj;
            if (bindRemoteServiceResult == null) {
                a unused = am.kFa;
                Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onCallback with NULL data, id:" + this.kFb.kEI);
                com.tencent.mm.plugin.appbrand.api.f fVar = this.kFb.kEZ;
                if (fVar != null) {
                    f.a.a(fVar, -4);
                    AppMethodBeat.o(227920);
                    return;
                }
                AppMethodBeat.o(227920);
                return;
            }
            int i2 = bindRemoteServiceResult.errCode;
            String str = bindRemoteServiceResult.errMsg;
            this.kFc.set(true);
            if (i2 == 0) {
                com.tencent.mm.plugin.appbrand.api.f fVar2 = this.kFb.kEZ;
                if (fVar2 != null) {
                    fVar2.onSuccess();
                    AppMethodBeat.o(227920);
                    return;
                }
                AppMethodBeat.o(227920);
                return;
            }
            com.tencent.mm.plugin.appbrand.api.f fVar3 = this.kFb.kEZ;
            if (fVar3 != null) {
                fVar3.onError(i2, str);
                AppMethodBeat.o(227920);
                return;
            }
            AppMethodBeat.o(227920);
        }

        @Override // com.tencent.mm.ipcinvoker.e
        public final void axY() {
            AppMethodBeat.i(227921);
            a unused = am.kFa;
            Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onBridgeNotFound, id:" + this.kFb.kEI);
            com.tencent.mm.plugin.appbrand.api.f fVar = this.kFb.kEZ;
            if (fVar != null) {
                f.a.a(fVar, -4);
                AppMethodBeat.o(227921);
                return;
            }
            AppMethodBeat.o(227921);
        }

        @Override // com.tencent.mm.ipcinvoker.e
        public final void i(Exception exc) {
            AppMethodBeat.i(227922);
            a unused = am.kFa;
            Log.e("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService onCaughtInvokeException, id:" + this.kFb.kEI + ", exception:" + exc);
            com.tencent.mm.plugin.appbrand.api.f fVar = this.kFb.kEZ;
            if (fVar != null) {
                f.a.a(fVar, -4);
                AppMethodBeat.o(227922);
                return;
            }
            AppMethodBeat.o(227922);
        }
    }

    public static final /* synthetic */ void a(am amVar, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(227929);
        Log.i("MicroMsg.AppBrandPreRenderColdStartService.Loader", "bindRemoteService id:" + amVar.kEI + ", appId:" + appBrandInitConfigWC.appId);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String str = Appbrand0IPCService.dkO;
        com.tencent.mm.ipcinvoker.h.b(str, new b(amVar, atomicBoolean, str));
        com.tencent.mm.ipcinvoker.h.a(str, new BindRemoteServiceData(appBrandInitConfigWC, appBrandStatObject, amVar.kEI), c.kFe.getClass(), new d(amVar, atomicBoolean));
        AppMethodBeat.o(227929);
    }
}
