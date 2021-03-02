package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.g;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ay;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "saveSplashScreenshot";
    public static final a lUr = new a((byte) 0);

    static {
        AppMethodBeat.i(228418);
        AppMethodBeat.o(228418);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "bmp", "Landroid/graphics/Bitmap;", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ q kAi;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lUh;
        final /* synthetic */ e lUs;
        final /* synthetic */ int lyo;

        c(e eVar, q qVar, com.tencent.mm.plugin.appbrand.service.c cVar, int i2) {
            this.lUs = eVar;
            this.kAi = qVar;
            this.lUh = cVar;
            this.lyo = i2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "info", "Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfo;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
        static final class b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<com.tencent.mm.plugin.appbrand.ui.c.a.a, IPCVoid> {
            public static final b lUv = new b();

            static {
                AppMethodBeat.i(228414);
                AppMethodBeat.o(228414);
            }

            b() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(com.tencent.mm.plugin.appbrand.ui.c.a.a aVar, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
                AppMethodBeat.i(228413);
                com.tencent.mm.plugin.appbrand.ui.c.a.a aVar2 = aVar;
                com.tencent.mm.plugin.appbrand.ui.c.a.b bVar = (com.tencent.mm.plugin.appbrand.ui.c.a.b) n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class);
                if (!(bVar == null || aVar2 == null)) {
                    bVar.a(aVar2.field_appId, aVar2.field_versionType, aVar2.field_appVersion, aVar2.field_isDarkMode, aVar2.field_screenshotFilePath);
                }
                if (dVar != null) {
                    com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                    AppMethodBeat.o(228413);
                    return;
                }
                AppMethodBeat.o(228413);
            }
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(228415);
            Bitmap bitmap = (Bitmap) obj;
            b.a aVar = com.tencent.mm.plugin.appbrand.ui.c.a.b.ogd;
            AppBrandInitConfigWC bsC = this.kAi.bsC();
            p.g(bsC, "runtime.initConfig");
            p.h(bsC, "config");
            String str = bsC.appId + '_' + bsC.bzS() + '_' + bsC.appVersion + '_' + (ao.isDarkMode() ? "dark" : "normal") + '_' + Util.nowMilliSecond() + ".png";
            String str2 = bsC.appId;
            p.g(str2, "config.appId");
            o oVar = new o(b.a.afz(str2), str);
            o heq = oVar.heq();
            if (heq != null) {
                heq.mkdirs();
            }
            String oVar2 = oVar.toString();
            p.g(oVar2, "VFSFile(generateDir(conf…le?.mkdirs() }.toString()");
            if (bitmap == null) {
                p.hyc();
            }
            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.PNG, oVar2, true);
            Log.i("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", "saveBitmap ok, appId=" + this.lUh.getAppId() + ", path=" + oVar2);
            com.tencent.mm.plugin.appbrand.ui.c.a.a aVar2 = new com.tencent.mm.plugin.appbrand.ui.c.a.a();
            aVar2.field_appId = this.kAi.getAppId();
            aVar2.field_versionType = this.kAi.brf();
            aVar2.field_appVersion = this.kAi.OJ();
            aVar2.field_isDarkMode = ao.isDarkMode();
            aVar2.field_screenshotFilePath = oVar2;
            com.tencent.mm.ipcinvoker.wx_extension.b.a.a(aVar2, b.lUv, new a(oVar2, this, bitmap));
            x xVar = x.SXb;
            AppMethodBeat.o(228415);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback", "com/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$invoke$2$1$2"})
        static final class a<T> implements com.tencent.mm.ipcinvoker.d<IPCVoid> {
            final /* synthetic */ String lCM;
            final /* synthetic */ c lUt;
            final /* synthetic */ Bitmap lUu;

            a(String str, c cVar, Bitmap bitmap) {
                this.lCM = str;
                this.lUt = cVar;
                this.lUu = bitmap;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCVoid iPCVoid) {
                AppMethodBeat.i(228412);
                this.lUt.lUh.i(this.lUt.lyo, this.lUt.lUs.Zf("ok"));
                Log.i("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", "invokeMM ok, appId=" + this.lUt.lUh.getAppId() + ", path=" + this.lCM);
                AppMethodBeat.o(228412);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "checkCanInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "data", "Lorg/json/JSONObject;", "callbackId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean a(com.tencent.mm.plugin.appbrand.service.c cVar) {
            AppMethodBeat.i(228410);
            p.h(cVar, "env");
            b.a aVar = com.tencent.mm.plugin.appbrand.ui.c.a.b.ogd;
            if (b.a.bZg()) {
                q runtime = cVar.getRuntime();
                p.g(runtime, "env.runtime");
                if (runtime.bsC().ldN) {
                    AppMethodBeat.o(228410);
                    return true;
                }
            }
            AppMethodBeat.o(228410);
            return false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        q runtime;
        AppMethodBeat.i(228417);
        com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        if (cVar2 == null || (runtime = cVar2.getRuntime()) == null) {
            new d(this, cVar2, i2).invoke();
            AppMethodBeat.o(228417);
        } else if (!a.a(cVar2)) {
            cVar2.i(i2, Zf("fail:not supported"));
            AppMethodBeat.o(228417);
        } else if (runtime.brK() != null) {
            cVar2.i(i2, Zf("fail: not ready for screenshot"));
            AppMethodBeat.o(228417);
        } else {
            com.tencent.mm.plugin.appbrand.p.Un(cVar2.getAppId()).kDd = true;
            g.hio().a(runtime).b(new b(this, runtime, cVar2, i2)).i(new c(this, runtime, cVar2, i2)).hdy();
            AppMethodBeat.o(228417);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lUh;
        final /* synthetic */ e lUs;
        final /* synthetic */ int lyo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar, com.tencent.mm.plugin.appbrand.service.c cVar, int i2) {
            super(0);
            this.lUs = eVar;
            this.lUh = cVar;
            this.lyo = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(228416);
            com.tencent.mm.plugin.appbrand.service.c cVar = this.lUh;
            if (cVar != null) {
                cVar.i(this.lyo, this.lUs.Zf("fail:internal error"));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(228416);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ q kAi;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.service.c lUh;
        final /* synthetic */ e lUs;
        final /* synthetic */ int lyo;

        b(e eVar, q qVar, com.tencent.mm.plugin.appbrand.service.c cVar, int i2) {
            this.lUs = eVar;
            this.kAi = qVar;
            this.lUh = cVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(228411);
            Bitmap F = ay.F(this.kAi);
            if (F == null || F.isRecycled()) {
                com.tencent.mm.vending.g.g.hdx().ej(null);
                Log.e("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", "save failed, appId=" + this.lUh.getAppId());
                this.lUh.i(this.lyo, this.lUs.Zf("fail"));
            }
            AppMethodBeat.o(228411);
            return F;
        }
    }
}
