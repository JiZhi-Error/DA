package com.tencent.mm.plugin.ac;

import android.content.Context;
import android.webkit.ValueCallback;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ab.m;
import com.tencent.mm.plugin.ac.f;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003PQRB\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010$\u001a\u00020%2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%\u0018\u00010'JF\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010,\u001a\u00020\u00062\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u0010$\u001a\u0004\u0018\u000101H\u0014J(\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000105H\u0016J\u0018\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0004J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020.2\u0006\u0010,\u001a\u00020\u0006H$J\b\u0010;\u001a\u00020\u0006H\u0016J@\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0010\u0010?\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@2\u0014\u0010B\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020%0'H\u0004J\u0016\u0010C\u001a\u00020%2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006J@\u0010E\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010F\u001a\u00020G2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%\u0018\u00010'H\u0014J,\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\u00062\b\u0010J\u001a\u0004\u0018\u00010\u0006H\u0004J\u0018\u0010K\u001a\u00020%2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006H$JR\u0010L\u001a\u00020%*\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010M\u001a\u00020G2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010+\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u00062\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%\u0018\u00010'H\u0004R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u00078DX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u000f8TX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001e\u0010\u0011R\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006S"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "()V", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "meta", "Lcom/tencent/mm/json/JSONObject;", "getMeta", "()Lcom/tencent/mm/json/JSONObject;", "meta$delegate", "Lkotlin/Lazy;", "nativeContextJs", "kotlin.jvm.PlatformType", "getNativeContextJs", "()Ljava/lang/String;", "nativeContextJs$delegate", "version", "getVersion", "()I", "version$delegate", "vmConfig", "getVmConfig", "vmConfig$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "config", "", "cb", "Lkotlin/Function1;", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "type", "clientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "dispatch", "eventType", "event", "Landroid/webkit/ValueCallback;", "getCacheCategory", "appId", "path", "getClientConfig", "getClientInfo", "getEngineName", "invoke", "target", "func", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "callback", "message", "targetOrigin", "onConfigClientInject", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "onError", "contextId", "stackTrace", "onTransferMessage", "setup", "clientReporter", "cache", "", "ClientInfo", "Companion", "ReadPkgResult", "webview-sdk_release"})
public abstract class c extends x implements com.tencent.mm.plugin.ab.c {
    private static final String IBT;
    public static final b IBU = new b((byte) 0);
    private static final String TAG = TAG;
    private final kotlin.f IAm = kotlin.g.ah(new i(this));
    private final HashMap<String, Integer> IBO = new HashMap<>();
    private final kotlin.f IBP = kotlin.g.ah(new e(this));
    private final kotlin.f IBQ = kotlin.g.ah(new h(this));
    private final HashMap<String, Integer> IBR = new HashMap<>();
    private final kotlin.f IBS = kotlin.g.ah(f.ICj);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "(Ljava/lang/String;I)V", "UseDebugPkg", "UsePreviewPkg", "UseResPkg", "UseAssetsPkg", "FallbackAssetsPkg", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.ac.c$c  reason: collision with other inner class name */
    public enum EnumC0515c {
        UseDebugPkg,
        UsePreviewPkg,
        UseResPkg,
        UseAssetsPkg,
        FallbackAssetsPkg;

        static {
            AppMethodBeat.i(224886);
            AppMethodBeat.o(224886);
        }

        public static EnumC0515c valueOf(String str) {
            AppMethodBeat.i(224888);
            EnumC0515c cVar = (EnumC0515c) Enum.valueOf(EnumC0515c.class, str);
            AppMethodBeat.o(224888);
            return cVar;
        }
    }

    /* access modifiers changed from: protected */
    public abstract a aWx(String str);

    /* access modifiers changed from: protected */
    public com.tencent.mm.ab.i fWB() {
        return (com.tencent.mm.ab.i) this.IAm.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract g fWy();

    public abstract p fWz();

    public final com.tencent.mm.ab.i fXe() {
        return (com.tencent.mm.ab.i) this.IBP.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract void ly(String str, String str2);

    @Override // com.tencent.mm.plugin.appbrand.m.x, com.tencent.mm.plugin.appbrand.m.a
    public final IJSRuntime g(IJSRuntime.Config config) {
        byte[] bArr;
        if (config == null) {
            config = new IJSRuntime.Config();
        }
        config.dpr = fXf() + '#';
        Log.d(TAG, "createJSRuntime " + config.dpr);
        o oVar = new o(com.tencent.mm.loader.j.b.aKB() + "webservice/codecache");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        config.dpj = oVar.getPath();
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_j2v8_disable_snapshot, false)) {
            Log.d(TAG, "use code cache");
            if (q.is64BitRuntime()) {
                bArr = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot64.bin");
            } else {
                bArr = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot.bin");
            }
        } else {
            bArr = null;
        }
        config.dpk = bArr;
        return super.g(config);
    }

    public String fXf() {
        String simpleName = getClass().getSimpleName();
        kotlin.g.b.p.g(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    protected static String lB(String str, String str2) {
        kotlin.g.b.p.h(str, "appId");
        kotlin.g.b.p.h(str2, "path");
        return str + ':' + URLEncoder.encode(str2);
    }

    private static /* synthetic */ void a(c cVar, com.tencent.mm.ab.i iVar, com.tencent.mm.plugin.appbrand.m.g gVar, f fVar, boolean z, String str, String str2, int i2) {
        boolean z2;
        String str3;
        String str4;
        if ((i2 & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i2 & 8) != 0) {
            str3 = iVar.getString("name");
            kotlin.g.b.p.g(str3, "getString(\"name\")");
        } else {
            str3 = str;
        }
        if ((i2 & 16) != 0) {
            str4 = "wxfedb0854e2b1820d";
        } else {
            str4 = str2;
        }
        cVar.a(iVar, gVar, fVar, z2, str3, str4, (kotlin.g.a.b<? super String, kotlin.x>) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: kotlin.g.a.b<? super java.lang.String, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.tencent.mm.ab.i iVar, com.tencent.mm.plugin.appbrand.m.g gVar, f fVar, boolean z, String str, String str2, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        e eVar;
        e eVar2;
        com.tencent.mm.ab.f FH;
        Integer num;
        kotlin.g.b.p.h(iVar, "$this$setup");
        kotlin.g.b.p.h(gVar, "context");
        kotlin.g.b.p.h(fVar, "clientReporter");
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "appId");
        String str3 = str + " :" + gVar.bMC();
        try {
            gVar.setJsExceptionHandler(new g(gVar, this, str3, fVar, str2, str));
            new com.tencent.mm.plugin.ab.h(str3).f(gVar);
            try {
                if (iVar.has("dependencies") && (FH = iVar.FH("dependencies")) != null) {
                    int length = FH.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = FH.getString(i2);
                        if (this.IBO.containsKey(string)) {
                            num = this.IBO.get(string);
                        } else if (this.IBR.containsKey(string)) {
                            num = this.IBR.get(string);
                        } else {
                            num = null;
                        }
                        if (num != null) {
                            kotlin.g.b.p.g(num, "id");
                            xX(num.intValue()).b(gVar, string);
                            Log.d(TAG, "shareObject " + string + " to " + str3);
                        }
                    }
                }
                try {
                    String string2 = iVar.getString("path");
                    if (BuildInfo.DEBUG) {
                        p fWz = fWz();
                        kotlin.g.b.p.g(string2, "path");
                        String a2 = b.a(fWz, string2);
                        if (bVar != 0) {
                            eVar2 = new e(bVar);
                        } else {
                            eVar2 = bVar;
                        }
                        gVar.evaluateJavascript(a2, eVar2);
                    } else {
                        URL url = new URL("https://ws/lib".concat(String.valueOf(string2)));
                        kotlin.g.b.p.g(string2, "path");
                        String lB = lB("base", string2);
                        String valueOf = String.valueOf(((Number) this.IBQ.getValue()).intValue());
                        String a3 = b.a(fWz(), string2);
                        if (bVar != 0) {
                            eVar = new e(bVar);
                        } else {
                            eVar = bVar;
                        }
                        gVar.a(url, lB, valueOf, 0, a3, eVar);
                    }
                    if (z) {
                        String string3 = iVar.getString("name");
                        kotlin.g.b.p.g(string3, "getString(\"name\")");
                        this.IBO.put(string3, Integer.valueOf(gVar.bMC()));
                    }
                    Log.i(TAG, "client setup succ " + str3 + " from " + string2);
                } catch (Exception e2) {
                    fVar.a(new f.e());
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.ba(str2, str, e2.getMessage());
                    Log.printErrStackTrace(TAG, e2, "context setup inject script ".concat(String.valueOf(str3)), new Object[0]);
                    throw e2;
                }
            } catch (Exception e3) {
                fVar.a(new f.a());
                com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.ba(str2, str, e3.getMessage());
                Log.printErrStackTrace(TAG, e3, "context setup dependencies ".concat(String.valueOf(str3)), new Object[0]);
                throw e3;
            }
        } catch (Exception e4) {
            fVar.a(new f.c());
            Log.printErrStackTrace(TAG, e4, "context setup jsapi ".concat(String.valueOf(str3)), new Object[0]);
            com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.ba(str2, str, e4.getMessage());
            throw e4;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$1"})
    public static final class g implements com.tencent.mm.plugin.appbrand.m.h {
        final /* synthetic */ c ICh;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.m.g ICk;
        final /* synthetic */ String ICl;
        final /* synthetic */ f ICm;
        final /* synthetic */ String mjs;
        final /* synthetic */ String nwh;

        g(com.tencent.mm.plugin.appbrand.m.g gVar, c cVar, String str, f fVar, String str2, String str3) {
            this.ICk = gVar;
            this.ICh = cVar;
            this.ICl = str;
            this.ICm = fVar;
            this.nwh = str2;
            this.mjs = str3;
        }

        @Override // com.tencent.mm.plugin.appbrand.m.h
        public final void u(String str, String str2) {
            g.b bVar;
            AppMethodBeat.i(224895);
            Log.e(c.TAG, "JsException[" + this.ICl + "]:" + str + '\n' + str2);
            this.ICm.a(new f.d());
            g fWy = this.ICh.fWy();
            switch (d.$EnumSwitchMapping$0[this.ICm.ICn.ordinal()]) {
                case 1:
                    g.l lVar = new g.l();
                    com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.ba(this.nwh, this.mjs, str + '\t' + str2);
                    bVar = lVar;
                    break;
                case 2:
                    g.f fVar = new g.f();
                    com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.ba(this.nwh, this.mjs, str + '\t' + str2);
                    bVar = fVar;
                    break;
                case 3:
                    g.b bVar2 = new g.b();
                    com.tencent.mm.plugin.webcanvas.l lVar4 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.ba(this.nwh, this.mjs, str + '\t' + str2);
                    bVar = bVar2;
                    break;
                default:
                    bVar = new g.b();
                    break;
            }
            fWy.a(bVar);
            c cVar = this.ICh;
            int bMC = this.ICk.bMC();
            String str3 = this.mjs;
            kotlin.g.b.p.h(str3, "name");
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
            iVar.U("id", bMC);
            iVar.h("name", str3);
            iVar.h("message", str);
            iVar.h("stackTrace", str2);
            String iVar2 = iVar.toString();
            kotlin.g.b.p.g(iVar2, "err.toString()");
            c.a.a(cVar, "error", iVar2, null, 4);
            AppMethodBeat.o(224895);
        }
    }

    @Override // com.tencent.mm.plugin.ab.c
    public final void b(String str, String str2, ValueCallback<String> valueCallback) {
        kotlin.g.b.p.h(str, "eventType");
        kotlin.g.b.p.h(str2, "event");
        if (kotlin.g.b.p.j(str, "")) {
            Log.i(TAG, "skip dispath");
            return;
        }
        evaluateJavascript("dispatchEvent('" + str + "', " + str2 + ')', valueCallback);
        if (!n.J(str, "touch", false) && (!kotlin.g.b.p.j(str, "scroll")) && (!kotlin.g.b.p.j(str, "message"))) {
            Log.d(TAG, "dispatch: " + str + ", " + str2);
        }
    }

    public final void lC(String str, String str2) {
        kotlin.g.b.p.h(str, "message");
        kotlin.g.b.p.h(str2, "targetOrigin");
        c.a.a(this, "message", "{ target:'" + str2 + "', data: " + str + " }", null, 4);
    }

    public final void P(kotlin.g.a.b<? super String, kotlin.x> bVar) {
        fWy().a(new g.i());
        com.tencent.mm.ab.i fWB = fWB();
        try {
            fWy().a(new g.m());
            com.tencent.mm.plugin.ab.l lVar = new com.tencent.mm.plugin.ab.l(new d(this, bVar));
            com.tencent.mm.plugin.appbrand.m.g bMD = bMD();
            kotlin.g.b.p.g(bMD, "mainJsContext");
            lVar.f(bMD);
            bMD().evaluateJavascript((String) this.IBS.getValue(), null);
            com.tencent.mm.ab.i FJ = fWB.FJ("main");
            com.tencent.mm.plugin.appbrand.m.g bMD2 = bMD();
            kotlin.g.b.p.g(bMD2, "mainJsContext");
            f fVar = new f(FJ.optLong("idKey", 0), f.j.Main);
            String optString = FJ.optString("name");
            kotlin.g.b.p.g(optString, "optString(\"name\")");
            a(FJ, bMD2, fVar, true, optString, "wxfedb0854e2b1820d", bVar);
            fWy().a(new g.n());
            if (fWB.has("engine")) {
                try {
                    fWy().a(new g.C0517g());
                    com.tencent.mm.ab.f FH = fWB.FH("engine");
                    if (FH != null) {
                        int length = FH.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            com.tencent.mm.ab.i pY = FH.pY(i2);
                            String string = pY.getString("name");
                            HashMap<String, Integer> hashMap = this.IBR;
                            kotlin.g.b.p.g(string, "engineName");
                            com.tencent.mm.plugin.appbrand.m.g bME = bME();
                            kotlin.g.b.p.g(pY, "engineObject");
                            kotlin.g.b.p.g(bME, "context");
                            a(this, pY, bME, new f(pY.getLong("idKey"), f.j.Engine), true, null, null, 56);
                            Log.i(TAG, "start engine " + string + '#' + bME.bMC());
                            hashMap.put(string, Integer.valueOf(bME.bMC()));
                        }
                    }
                    fWy().a(new g.h());
                } catch (Exception e2) {
                    fWy().a(new g.e());
                    Log.printErrStackTrace(TAG, e2, "config engineContext err", new Object[0]);
                    com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.ba("wxfedb0854e2b1820d", "engine", e2.getMessage());
                    return;
                }
            }
            fWy().a(new g.j());
        } catch (Exception e3) {
            fWy().a(new g.k());
            Log.printErrStackTrace(TAG, e3, "config mainContext err", new Object[0]);
            com.tencent.mm.plugin.webcanvas.l lVar3 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.ba("wxfedb0854e2b1820d", "main", e3.getMessage());
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$1", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
    public static final class d implements m {
        final /* synthetic */ c ICh;
        final /* synthetic */ kotlin.g.a.b ICi;

        d(c cVar, kotlin.g.a.b bVar) {
            this.ICh = cVar;
            this.ICi = bVar;
        }

        @Override // com.tencent.mm.plugin.ab.m
        public final void postMessage(String str, String str2) {
            AppMethodBeat.i(224890);
            kotlin.g.b.p.h(str, "message");
            kotlin.g.b.p.h(str2, "targetOrigin");
            this.ICh.ly(str, str2);
            AppMethodBeat.o(224890);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "", "appId", "", "idKey", "", "(Ljava/lang/String;J)V", "getAppId", "()Ljava/lang/String;", "getIdKey", "()J", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "webview-sdk_release"})
    public static final class a {
        final long IBV;
        final String appId;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
            if (r5.IBV == r6.IBV) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 224871(0x36e67, float:3.15111E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0020
                boolean r0 = r6 instanceof com.tencent.mm.plugin.ac.c.a
                if (r0 == 0) goto L_0x0025
                com.tencent.mm.plugin.ac.c$a r6 = (com.tencent.mm.plugin.ac.c.a) r6
                java.lang.String r0 = r5.appId
                java.lang.String r1 = r6.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0025
                long r0 = r5.IBV
                long r2 = r6.IBV
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0024:
                return r0
            L_0x0025:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0024
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ac.c.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(224870);
            String str = this.appId;
            int hashCode = str != null ? str.hashCode() : 0;
            long j2 = this.IBV;
            int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
            AppMethodBeat.o(224870);
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(224869);
            String str = "ClientInfo(appId=" + this.appId + ", idKey=" + this.IBV + ")";
            AppMethodBeat.o(224869);
            return str;
        }

        public a(String str, long j2) {
            kotlin.g.b.p.h(str, "appId");
            AppMethodBeat.i(224868);
            this.appId = str;
            this.IBV = j2;
            AppMethodBeat.o(224868);
        }
    }

    public com.tencent.mm.ab.i aWQ(String str) {
        kotlin.g.b.p.h(str, "type");
        com.tencent.mm.ab.i FJ = fWB().FJ("client");
        kotlin.g.b.p.g(FJ, "vmConfig.getJSONObject(\"client\")");
        return FJ;
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2, com.tencent.mm.plugin.appbrand.m.g gVar, f fVar, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "type");
        kotlin.g.b.p.h(gVar, "context");
        kotlin.g.b.p.h(fVar, "contextReporter");
    }

    public static /* synthetic */ void a(c cVar, com.tencent.mm.plugin.appbrand.m.g gVar, String str, String str2, kotlin.g.a.b bVar, a aVar, int i2) {
        a aVar2 = null;
        String str3 = (i2 & 4) != 0 ? "unspecified" : str2;
        kotlin.g.a.b bVar2 = (i2 & 8) != 0 ? null : bVar;
        if ((i2 & 16) == 0) {
            aVar2 = aVar;
        }
        cVar.a(gVar, str, str3, bVar2, aVar2);
    }

    public void a(com.tencent.mm.plugin.appbrand.m.g gVar, String str, String str2, kotlin.g.a.b<? super String, kotlin.x> bVar, a aVar) {
        kotlin.g.b.p.h(gVar, "context");
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "type");
        if (aVar == null) {
            try {
                aVar = aWx(str2);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "configClient getClientInfo err", new Object[0]);
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.ba("ClientInfo", str, e2.getMessage());
                return;
            }
        }
        f fVar = new f(aVar.IBV, f.j.Client);
        try {
            fWy().a(new g.c());
            com.tencent.mm.ab.i aWQ = aWQ(str2);
            fVar.a(new f.g());
            a(this, aWQ, gVar, fVar, false, str, aVar.appId, 36);
            a(str, str2, gVar, fVar, bVar);
            fVar.a(new f.h());
            fWy().a(new g.d());
        } catch (Exception e3) {
            fWy().a(new g.a());
            fVar.a(new f.b());
            com.tencent.mm.plugin.webcanvas.l lVar2 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.ba(aVar.appId, str, e3.getMessage());
            Log.printErrStackTrace(TAG, e3, "configClient engineContext err", new Object[0]);
        }
    }

    public final void a(String str, String str2, List<? extends Object> list, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        String str3;
        kotlin.g.b.p.h(str, "target");
        kotlin.g.b.p.h(str2, "func");
        kotlin.g.b.p.h(bVar, "callback");
        StringBuilder append = new StringBuilder("invokeMethod('").append(str2).append("', { target: '").append(str).append("', data: { params: ");
        if (list == null || (str3 = j.a(list, ",", "[", "]", 0, (CharSequence) null, b.C0514c.ICa, 24)) == null) {
            str3 = "[]";
        }
        evaluateJavascript(append.append(str3).append("}})").toString(), new e(bVar));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\\\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00102\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00192 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u001c0\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0013H\u0007J\u0012\u0010\u001e\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004J\u0012\u0010 \u001a\u00020\u0004*\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0004J\u0014\u0010!\u001a\u00020\u0004*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00020\f*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion;", "", "()V", "DEBUG_PATH", "", "TAG", "meta", "Lcom/tencent/mm/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getMeta", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "version", "", "getVersion", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "getDebugInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "file", "isPreview", "", "resPath", "appId", "readPkg", "pkgInfo", "validResPkg", "Lkotlin/Function3;", "callback", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ReadPkgResult;", "", "hasAssets", "readFile", "path", "safeReadFile", "toJsonString", "", "ReadPkgInfo", "webview-sdk_release"})
    public static final class b {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"readResPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "assetsVersion", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.ac.c$b$b  reason: collision with other inner class name */
        static final class C0513b extends kotlin.g.b.q implements kotlin.g.a.b<Integer, p> {
            final /* synthetic */ a IBY;
            final /* synthetic */ kotlin.g.a.q IBZ;
            final /* synthetic */ kotlin.g.a.q pDc;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0513b(a aVar, kotlin.g.a.q qVar, kotlin.g.a.q qVar2) {
                super(1);
                this.IBY = aVar;
                this.IBZ = qVar;
                this.pDc = qVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ p invoke(Integer num) {
                AppMethodBeat.i(224876);
                p afm = afm(num.intValue());
                AppMethodBeat.o(224876);
                return afm;
            }

            public final p afm(int i2) {
                AppMethodBeat.i(224877);
                if (s.YS(this.IBY.cHM)) {
                    WxaPkg wxaPkg = new WxaPkg(this.IBY.cHM);
                    wxaPkg.bvf();
                    b bVar = c.IBU;
                    int a2 = b.a(wxaPkg);
                    Log.i(c.TAG, "#readPkg " + this.IBY.appId + " resVersion = " + a2 + " assetsVersion=" + i2);
                    if (((Boolean) this.IBZ.d(Integer.valueOf(i2), Integer.valueOf(a2), wxaPkg)).booleanValue()) {
                        Log.i(c.TAG, "#readPkg " + this.IBY.appId + " use res");
                        int aWK = com.tencent.mm.plugin.webcanvas.m.IAG.aWK(this.IBY.appId);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20781, this.IBY.appId, Integer.valueOf(aWK), Integer.valueOf(a2), 3, "");
                        this.pDc.d(EnumC0515c.UseResPkg, Integer.valueOf(a2), "");
                        AppMethodBeat.o(224877);
                        return wxaPkg;
                    }
                }
                AppMethodBeat.o(224877);
                return null;
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static String a(p pVar, String str) {
            Throwable th;
            Throwable th2 = null;
            AppMethodBeat.i(224880);
            kotlin.g.b.p.h(pVar, "$this$readFile");
            kotlin.g.b.p.h(str, "path");
            InputStream UR = pVar.UR(str);
            try {
                InputStream inputStream = UR;
                kotlin.g.b.p.g(inputStream, LocaleUtil.ITALIAN);
                String str2 = new String(kotlin.f.a.U(inputStream), kotlin.n.d.UTF_8);
                kotlin.f.b.a(UR, null);
                AppMethodBeat.o(224880);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(UR, th2);
                AppMethodBeat.o(224880);
                throw th;
            }
        }

        public static String b(p pVar, String str) {
            Throwable th;
            Throwable th2 = null;
            AppMethodBeat.i(224881);
            kotlin.g.b.p.h(pVar, "$this$safeReadFile");
            kotlin.g.b.p.h(str, "path");
            InputStream UR = pVar.UR(str);
            try {
                InputStream inputStream = UR;
                String str2 = inputStream != null ? new String(kotlin.f.a.U(inputStream), kotlin.n.d.UTF_8) : "";
                kotlin.f.b.a(UR, null);
                AppMethodBeat.o(224881);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(UR, th2);
                AppMethodBeat.o(224881);
                throw th;
            }
        }

        public static com.tencent.mm.ab.i b(p pVar) {
            AppMethodBeat.i(224882);
            kotlin.g.b.p.h(pVar, "$this$meta");
            b bVar = c.IBU;
            com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(a(pVar, "/meta.json"));
            AppMethodBeat.o(224882);
            return iVar;
        }

        public static int a(p pVar) {
            AppMethodBeat.i(224883);
            kotlin.g.b.p.h(pVar, "$this$version");
            b bVar = c.IBU;
            int optInt = b(pVar).optInt("version");
            AppMethodBeat.o(224883);
            return optInt;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$Companion$ReadPkgInfo;", "", "isDebugger", "", "isPreview", "resPath", "", "assetsPath", "appId", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAssetsPath", "()Z", "getResPath", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "webview-sdk_release"})
        public static final class a {
            final boolean IBW;
            final String IBX;
            final String appId;
            public final String cHM;
            final boolean isPreview;

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
                if (kotlin.g.b.p.j(r3.appId, r4.appId) != false) goto L_0x0038;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 224875(0x36e6b, float:3.15117E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0038
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.ac.c.b.a
                    if (r0 == 0) goto L_0x003d
                    com.tencent.mm.plugin.ac.c$b$a r4 = (com.tencent.mm.plugin.ac.c.b.a) r4
                    boolean r0 = r3.IBW
                    boolean r1 = r4.IBW
                    if (r0 != r1) goto L_0x003d
                    boolean r0 = r3.isPreview
                    boolean r1 = r4.isPreview
                    if (r0 != r1) goto L_0x003d
                    java.lang.String r0 = r3.cHM
                    java.lang.String r1 = r4.cHM
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003d
                    java.lang.String r0 = r3.IBX
                    java.lang.String r1 = r4.IBX
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003d
                    java.lang.String r0 = r3.appId
                    java.lang.String r1 = r4.appId
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x003d
                L_0x0038:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x003c:
                    return r0
                L_0x003d:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x003c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ac.c.b.a.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 1;
                int i3 = 0;
                AppMethodBeat.i(224874);
                boolean z = this.IBW;
                if (z) {
                    z = true;
                }
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                int i6 = z ? 1 : 0;
                int i7 = i4 * 31;
                boolean z2 = this.isPreview;
                if (!z2) {
                    i2 = z2 ? 1 : 0;
                }
                int i8 = (i7 + i2) * 31;
                String str = this.cHM;
                int hashCode = ((str != null ? str.hashCode() : 0) + i8) * 31;
                String str2 = this.IBX;
                int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
                String str3 = this.appId;
                if (str3 != null) {
                    i3 = str3.hashCode();
                }
                int i9 = hashCode2 + i3;
                AppMethodBeat.o(224874);
                return i9;
            }

            public final String toString() {
                AppMethodBeat.i(224873);
                String str = "ReadPkgInfo(isDebugger=" + this.IBW + ", isPreview=" + this.isPreview + ", resPath=" + this.cHM + ", assetsPath=" + this.IBX + ", appId=" + this.appId + ")";
                AppMethodBeat.o(224873);
                return str;
            }

            public a(boolean z, boolean z2, String str, String str2, String str3) {
                kotlin.g.b.p.h(str2, "assetsPath");
                kotlin.g.b.p.h(str3, "appId");
                AppMethodBeat.i(224872);
                this.IBW = z;
                this.isPreview = z2;
                this.cHM = str;
                this.IBX = str2;
                this.appId = str3;
                AppMethodBeat.o(224872);
            }
        }

        public static a a(String str, boolean z, String str2, String str3) {
            AppMethodBeat.i(224884);
            kotlin.g.b.p.h(str, "file");
            kotlin.g.b.p.h(str3, "appId");
            String str4 = c.IBT + '/' + str;
            String concat = "jsapi/".concat(String.valueOf(str));
            if ((BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) && s.YS(str4)) {
                a aVar = new a(true, z, str4, concat, str3);
                AppMethodBeat.o(224884);
                return aVar;
            }
            a aVar2 = new a(false, z, str2, concat, str3);
            AppMethodBeat.o(224884);
            return aVar2;
        }

        public static p a(a aVar, kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean> qVar, kotlin.g.a.q<? super EnumC0515c, ? super Integer, ? super String, kotlin.x> qVar2, boolean z) {
            int i2;
            AppMethodBeat.i(224885);
            kotlin.g.b.p.h(aVar, "pkgInfo");
            kotlin.g.b.p.h(qVar, "validResPkg");
            kotlin.g.b.p.h(qVar2, "callback");
            C0513b bVar = new C0513b(aVar, qVar, qVar2);
            if (aVar.IBW && s.YS(aVar.cHM)) {
                WxaPkg wxaPkg = new WxaPkg(aVar.cHM);
                wxaPkg.bvf();
                b bVar2 = c.IBU;
                int a2 = a(wxaPkg);
                Log.i(c.TAG, "#readPkg " + aVar.appId + " use " + (aVar.isPreview ? "preview" : "debug"));
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[5];
                objArr[0] = aVar.appId;
                objArr[1] = 0;
                objArr[2] = Integer.valueOf(a2);
                if (aVar.isPreview) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = "";
                hVar.a(20781, objArr);
                qVar2.d(aVar.isPreview ? EnumC0515c.UsePreviewPkg : EnumC0515c.UseDebugPkg, Integer.valueOf(a2), "");
                AppMethodBeat.o(224885);
                return wxaPkg;
            } else if (!z) {
                try {
                    p afm = bVar.afm(0);
                    if (afm == null) {
                        kotlin.g.b.p.hyc();
                    }
                    AppMethodBeat.o(224885);
                    return afm;
                } catch (Exception e2) {
                    Log.i(c.TAG, "#readPkg " + aVar.appId + "  fail " + e2.getMessage());
                    Exception exc = e2;
                    AppMethodBeat.o(224885);
                    throw exc;
                }
            } else {
                com.tencent.mm.plugin.appbrand.appcache.f fVar = new com.tencent.mm.plugin.appbrand.appcache.f(MMApplicationContext.getContext(), aVar.IBX);
                fVar.bvf();
                int i3 = 0;
                try {
                    b bVar3 = c.IBU;
                    i3 = a(fVar);
                    p afm2 = bVar.afm(i3);
                    if (afm2 != null) {
                        AppMethodBeat.o(224885);
                        return afm2;
                    }
                } catch (Exception e3) {
                    Log.e(c.TAG, "#readPkg " + aVar.cHM + " handle error: " + aVar.appId + ' ' + e3.getMessage() + " version:" + 0);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20781, aVar.appId, 0, 0, 2, e3.getMessage());
                    qVar2.d(EnumC0515c.FallbackAssetsPkg, 0, e3.getMessage());
                }
                Log.i(c.TAG, "#readPkg " + aVar.appId + " use assert version:" + i3);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(20781, aVar.appId, 0, Integer.valueOf(i3), 2, "");
                qVar2.d(EnumC0515c.UseAssetsPkg, Integer.valueOf(i3), "");
                AppMethodBeat.o(224885);
                return fVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.ac.c$b$c  reason: collision with other inner class name */
        static final class C0514c extends kotlin.g.b.q implements kotlin.g.a.b<Object, CharSequence> {
            public static final C0514c ICa = new C0514c();

            static {
                AppMethodBeat.i(224879);
                AppMethodBeat.o(224879);
            }

            C0514c() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.b
            public final /* synthetic */ CharSequence invoke(Object obj) {
                AppMethodBeat.i(224878);
                if (obj instanceof String) {
                    String str = "'" + obj + '\'';
                    AppMethodBeat.o(224878);
                    return str;
                } else if (obj instanceof Number) {
                    String obj2 = obj.toString();
                    AppMethodBeat.o(224878);
                    return obj2;
                } else {
                    AppMethodBeat.o(224878);
                    return r0;
                }
            }
        }
    }

    static {
        String str = com.tencent.mm.loader.j.b.aKJ() + "jsengine/pkg";
        Log.i("DEBUG_PATH", "WebCanvas debug path = ".concat(String.valueOf(str)));
        IBT = str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.ab.i> {
        final /* synthetic */ c ICh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar) {
            super(0);
            this.ICh = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.ab.i invoke() {
            AppMethodBeat.i(224891);
            b bVar = c.IBU;
            com.tencent.mm.ab.i b2 = b.b(this.ICh.fWz());
            AppMethodBeat.o(224891);
            return b2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.ab.i> {
        final /* synthetic */ c ICh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(c cVar) {
            super(0);
            this.ICh = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.ab.i invoke() {
            AppMethodBeat.i(224897);
            com.tencent.mm.ab.i FJ = this.ICh.fXe().FJ("logic");
            AppMethodBeat.o(224897);
            return FJ;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ c ICh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar) {
            super(0);
            this.ICh = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(224896);
            b bVar = c.IBU;
            Integer valueOf = Integer.valueOf(b.a(this.ICh.fWz()));
            AppMethodBeat.o(224896);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        public static final f ICj = new f();

        static {
            AppMethodBeat.i(224893);
            AppMethodBeat.o(224893);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(224892);
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            String convertStreamToString = Util.convertStreamToString(context.getAssets().open("jsapi/context.js"));
            AppMethodBeat.o(224892);
            return convertStreamToString;
        }
    }
}
