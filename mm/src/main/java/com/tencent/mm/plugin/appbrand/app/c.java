package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J+\u0010\u0018\u001a\u00020\u0006\"\n\b\u0000\u0010\u0019*\u0004\u0018\u00010\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u0002H\u0019H\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0006H\u0016JF\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0016JB\u0010+\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010.\u001a\u00020/2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00100\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/app/AppBrandMixExportLogicServiceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandMixExportLogicService;", "()V", "TAG", "", "appbrandGameOnStartReportCanvasDataEvent", "", "appid", "buildLowVersionUrl", "appId", "cleanupAppBrandFileLogic", "getInfoByQRCodeResult", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "Landroid/util/Pair;", "codeResultStr", "codeType", "", "codeVersion", "getTipNameByDebugType", "type", "keyStepToggleSwitch", "processName", "keepOpenTime", "", "notifyIpcEventToAppBrand", "T", "Landroid/os/Parcelable;", "data", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "onAppBrandFindMoreEntranceExposed", "openWeappFunctionalPageByDeepLink", "context", "Landroid/content/Context;", "sdkReq", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Req;", "appPackageName", "deepLinkUri", "transferBuffer", "preloadEnvForMiniGame", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "preloadEnvForMiniProgram", "preloadEnvForPluginApp", "requestOpenDocumentInAppBrandProcess", "filePath", "fileExt", "showMenu", "", "triggerAppBrandCleanupLogic", "plugin-appbrand-integration_release"})
public final class c implements f {
    public static final c kIc = new c();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class a<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final a kId = new a();

        static {
            AppMethodBeat.i(227956);
            AppMethodBeat.o(227956);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(227955);
            IPCString iPCString2 = iPCString;
            try {
                p bWb = h.bWb();
                g gVar = g.WAGAME;
                String str = iPCString2.value;
                kotlin.g.b.p.g(str, "data.value");
                bWb.a(gVar, z.valueOf(str));
                if (dVar != null) {
                    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                    AppMethodBeat.o(227955);
                    return;
                }
                AppMethodBeat.o(227955);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", e2, "preloadEnvForMiniGame", new Object[0]);
                AppMethodBeat.o(227955);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final b kIe = new b();

        static {
            AppMethodBeat.i(227958);
            AppMethodBeat.o(227958);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(227957);
            IPCString iPCString2 = iPCString;
            try {
                p bWb = h.bWb();
                g gVar = g.WASERVICE;
                String str = iPCString2.value;
                kotlin.g.b.p.g(str, "data.value");
                bWb.a(gVar, z.valueOf(str));
                if (dVar != null) {
                    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                    AppMethodBeat.o(227957);
                    return;
                }
                AppMethodBeat.o(227957);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", e2, "preloadEnvForMiniProgram", new Object[0]);
                AppMethodBeat.o(227957);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.app.c$c  reason: collision with other inner class name */
    static final class C0540c<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final C0540c kIf = new C0540c();

        static {
            AppMethodBeat.i(227960);
            AppMethodBeat.o(227960);
        }

        C0540c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(227959);
            IPCString iPCString2 = iPCString;
            try {
                p bWb = h.bWb();
                String str = iPCString2.value;
                kotlin.g.b.p.g(str, "data.value");
                bWb.e(z.valueOf(str));
                if (dVar != null) {
                    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                    AppMethodBeat.o(227959);
                    return;
                }
                AppMethodBeat.o(227959);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", e2, "preloadEnvForPluginApp", new Object[0]);
                AppMethodBeat.o(227959);
            }
        }
    }

    static {
        AppMethodBeat.i(227972);
        AppMethodBeat.o(227972);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void a(z zVar) {
        AppMethodBeat.i(227961);
        kotlin.g.b.p.h(zVar, "scene");
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(zVar.name()), C0540c.kIf, null);
        AppMethodBeat.o(227961);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void b(z zVar) {
        AppMethodBeat.i(227962);
        kotlin.g.b.p.h(zVar, "scene");
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(zVar.name()), b.kIe, null);
        AppMethodBeat.o(227962);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void c(z zVar) {
        AppMethodBeat.i(227963);
        kotlin.g.b.p.h(zVar, "scene");
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new IPCString(zVar.name()), a.kId, null);
        AppMethodBeat.o(227963);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void bui() {
        AppMethodBeat.i(227964);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227964);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final <T extends Parcelable> void a(String str, T t) {
        AppMethodBeat.i(227965);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227965);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void a(Context context, String str, String str2, String str3, boolean z, String str4) {
        AppMethodBeat.i(227966);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227966);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final String Ur(String str) {
        AppMethodBeat.i(227967);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227967);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final Pair<String, Integer> vN(int i2) {
        AppMethodBeat.i(227968);
        Pair<String, Integer> pair = new Pair<>(e.vO(i2), Integer.valueOf((int) R.drawable.dg));
        AppMethodBeat.o(227968);
        return pair;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void buj() {
        AppMethodBeat.i(227969);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227969);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final void buk() {
        AppMethodBeat.i(227970);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227970);
        throw illegalStateException;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.f
    public final Pair<Integer, String> a(Context context, WXLaunchWxaRedirectingPage.Req req, String str, String str2, String str3) {
        AppMethodBeat.i(227971);
        IllegalStateException illegalStateException = new IllegalStateException("Not support".toString());
        AppMethodBeat.o(227971);
        throw illegalStateException;
    }
}
