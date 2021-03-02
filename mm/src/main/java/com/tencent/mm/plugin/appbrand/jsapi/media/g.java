package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"})
public final class g extends d<f> {
    public static final int CTRL_INDEX = 36;
    public static final String NAME = "chooseVideo";
    @Deprecated
    public static final a mdx = new a((byte) 0);
    private JsApiChooseVideo mdw;

    static {
        AppMethodBeat.i(50564);
        AppMethodBeat.o(50564);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ int lyo;
        final /* synthetic */ boolean mdA;
        final /* synthetic */ g mdy;
        final /* synthetic */ f mdz;

        b(g gVar, f fVar, int i2, boolean z) {
            this.mdy = gVar;
            this.mdz = fVar;
            this.lyo = i2;
            this.mdA = z;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            final com.tencent.mm.plugin.appbrand.widget.dialog.g gVar;
            AppMethodBeat.i(50560);
            final b bVar = (b) obj;
            if (bVar instanceof b.c) {
                f fVar = this.mdz;
                int i2 = this.lyo;
                g gVar2 = this.mdy;
                StringBuilder sb = new StringBuilder("fail ");
                String str = ((b.c) bVar).message;
                if (str == null) {
                    str = "";
                }
                fVar.i(i2, gVar2.Zf(sb.append(str).toString()));
            } else if (bVar instanceof b.d) {
                if (this.mdz.isRunning()) {
                    if (this.mdA) {
                        gVar = new com.tencent.mm.plugin.appbrand.widget.dialog.g(this.mdz.getContext());
                        gVar.setMessage(this.mdz.getContext().getString(R.string.ji));
                        gVar.setCanceledOnTouchOutside(false);
                        m dialogContainer = this.mdz.getDialogContainer();
                        if (dialogContainer != null) {
                            dialogContainer.b(gVar);
                        }
                    } else {
                        gVar = null;
                    }
                    com.tencent.mm.co.g.ey(((b.d) bVar).mbK.get(0)).j(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass1 */
                        final /* synthetic */ b mdB;

                        {
                            this.mdB = r1;
                        }

                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(50552);
                            o y = y((o) obj);
                            AppMethodBeat.o(50552);
                            return y;
                        }

                        private o y(o oVar) {
                            AppMethodBeat.i(175169);
                            if (!this.mdB.mdz.isRunning()) {
                                com.tencent.mm.vending.g.g.hdx().ej(new Exception("component not running"));
                                AppMethodBeat.o(175169);
                                return null;
                            } else if (this.mdB.mdA) {
                                try {
                                    p.g(oVar, "selected");
                                    o oVar2 = new o(t.aaf(oVar.getAbsolutePath()));
                                    AppMethodBeat.o(175169);
                                    return oVar2;
                                } catch (Exception e2) {
                                    if (WeChatEnvironment.hasDebugger()) {
                                        Exception exc = e2;
                                        AppMethodBeat.o(175169);
                                        throw exc;
                                    }
                                    com.tencent.mm.vending.g.g.hdx().ej(e2);
                                    AppMethodBeat.o(175169);
                                    return null;
                                }
                            } else {
                                AppMethodBeat.o(175169);
                                return oVar;
                            }
                        }
                    }).g(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass2 */
                        final /* synthetic */ b mdB;

                        {
                            this.mdB = r1;
                        }

                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Object obj) {
                            String n;
                            AppMethodBeat.i(50556);
                            o oVar = (o) obj;
                            if (oVar == null) {
                                new kotlin.g.a.a<x>(this) {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass2.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass2 mdD;

                                    {
                                        this.mdD = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(50554);
                                        a unused = g.mdx;
                                        Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "get NULL selected, appId[" + this.mdD.mdB.mdz.getAppId() + "], callbackId[" + this.mdD.mdB.lyo + ']');
                                        com.tencent.mm.vending.g.g.hdx().ej(new Exception("fail:internal error"));
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(50554);
                                        return xVar;
                                    }
                                }.invoke();
                            } else {
                                q fileSystem = this.mdB.mdz.getFileSystem();
                                if (fileSystem != null) {
                                    i<String> iVar = new i<>();
                                    fileSystem.a(oVar, (String) null, false, iVar);
                                    T t = iVar.value;
                                    if (t == null || t.length() == 0) {
                                        n = this.mdB.mdy.Zf("fail create temp file failed");
                                    } else {
                                        g gVar = this.mdB.mdy;
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("tempFilePath", iVar.value);
                                        u.a aVar = u.meK;
                                        String absolutePath = oVar.getAbsolutePath();
                                        p.g(absolutePath, "selected.absolutePath");
                                        u aaq = u.a.aaq(absolutePath);
                                        if (aaq != null) {
                                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Long.valueOf(Math.round(((double) aaq.duration) / 1000.0d)));
                                            hashMap.put("size", Long.valueOf(aaq.size));
                                            hashMap.put("height", Integer.valueOf(aaq.height));
                                            hashMap.put("width", Integer.valueOf(aaq.width));
                                        }
                                        n = gVar.n("ok", hashMap);
                                    }
                                    this.mdB.mdz.i(this.mdB.lyo, n);
                                } else {
                                    new kotlin.g.a.a<x>(this) {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass2.AnonymousClass2 */
                                        final /* synthetic */ AnonymousClass2 mdD;

                                        {
                                            this.mdD = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // kotlin.g.a.a
                                        public final /* synthetic */ x invoke() {
                                            AppMethodBeat.i(50555);
                                            a unused = g.mdx;
                                            Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected NULL fs appId[" + this.mdD.mdB.mdz.getAppId() + "], callbackId[" + this.mdD.mdB.lyo + ']');
                                            this.mdD.mdB.mdz.i(this.mdD.mdB.lyo, this.mdD.mdB.mdy.Zf("fail:internal error"));
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(50555);
                                            return xVar;
                                        }
                                    }.invoke();
                                }
                                o oVar2 = ((b.d) bVar).mbK.get(0);
                                a unused = g.mdx;
                                Log.i("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected source[" + oVar2.getAbsolutePath() + "], selected[" + oVar.getAbsolutePath() + "], appId[" + this.mdB.mdz.getAppId() + "], callbackId[" + this.mdB.lyo + ']');
                                if (g.a((b.d) bVar)) {
                                    s.deleteFile(oVar2.getAbsolutePath());
                                }
                                if (!p.j(oVar.getAbsolutePath(), oVar2.getAbsolutePath())) {
                                    s.deleteFile(oVar.getAbsolutePath());
                                }
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(50556);
                            return xVar;
                        }
                    }).b(new com.tencent.mm.vending.c.a<_Ret, _Var>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass3 */

                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(50557);
                            com.tencent.mm.plugin.appbrand.widget.dialog.g gVar = gVar;
                            if (gVar != null) {
                                gVar.dismiss();
                                x xVar = x.SXb;
                                AppMethodBeat.o(50557);
                                return xVar;
                            }
                            AppMethodBeat.o(50557);
                            return null;
                        }
                    }).a(new d.a<Object>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.g.b.AnonymousClass4 */

                        @Override // com.tencent.mm.vending.g.d.a
                        public final void cn(Object obj) {
                            AppMethodBeat.i(50559);
                            com.tencent.mm.plugin.appbrand.widget.dialog.g gVar = gVar;
                            if (gVar != null) {
                                MMHandlerThread.postToMainThread(new a(gVar));
                                AppMethodBeat.o(50559);
                                return;
                            }
                            AppMethodBeat.o(50559);
                        }

                        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.g$b$4$a */
                        static final class a implements Runnable {
                            final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.dialog.g mdF;

                            a(com.tencent.mm.plugin.appbrand.widget.dialog.g gVar) {
                                this.mdF = gVar;
                            }

                            public final void run() {
                                AppMethodBeat.i(50558);
                                this.mdF.dismiss();
                                AppMethodBeat.o(50558);
                            }
                        }
                    });
                }
            } else if (p.j(bVar, b.a.mbJ)) {
                this.mdz.i(this.lyo, this.mdy.Zf("fail user canceled"));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(50560);
            return xVar;
        }
    }

    public g() {
        AppMethodBeat.i(50563);
        if (!(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_choosevideo_new, 1) > 0)) {
            this.mdw = new JsApiChooseVideo();
        }
        AppMethodBeat.o(50563);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        boolean z = true;
        AppMethodBeat.i(50562);
        if (fVar == null) {
            p.hyc();
        }
        if (jSONObject == null) {
            p.hyc();
        }
        if (this.mdw != null) {
            JsApiChooseVideo jsApiChooseVideo = this.mdw;
            if (jsApiChooseVideo == null) {
                p.hyc();
            }
            jsApiChooseVideo.a(fVar, jSONObject, i2);
            AppMethodBeat.o(50562);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("compressed", true);
        q.d.a aVar = q.d.meE;
        p.h(jSONObject, "json");
        q.b.C0680b bVar = q.b.mev;
        StringBuilder sb = new StringBuilder();
        String name = q.d.ALBUM.name();
        if (name == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(50562);
            throw tVar;
        }
        String lowerCase = name.toLowerCase();
        p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        StringBuilder append = sb.append(lowerCase).append(", ");
        String name2 = q.d.CAMERA.name();
        if (name2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(50562);
            throw tVar2;
        }
        String lowerCase2 = name2.toLowerCase();
        p.g(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int a2 = q.b.C0680b.a(jSONObject, "sourceType", append.append(lowerCase2).toString(), q.d.values());
        q.a.C0679a aVar2 = q.a.meu;
        p.h(jSONObject, "json");
        q.b.C0680b bVar2 = q.b.mev;
        String name3 = q.a.BACK.name();
        if (name3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(50562);
            throw tVar3;
        }
        String lowerCase3 = name3.toLowerCase();
        p.g(lowerCase3, "(this as java.lang.String).toLowerCase()");
        int a3 = q.b.C0680b.a(jSONObject, "camera", lowerCase3, q.a.values());
        int i3 = q.c.mey.cSx;
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optInt <= 0) {
            fVar.i(i2, Zf("fail invalid maxDuration"));
            AppMethodBeat.o(50562);
            return;
        }
        if (optBoolean) {
            z = false;
        }
        c cVar = new c(fVar, a2, a3, i3, z, optInt);
        com.tencent.mm.co.f<_Ret> b2 = com.tencent.mm.co.g.hio().b(new c.e(cVar)).b(new c.f(cVar));
        p.g(b2, "pipelineExt()\n          …ANCELED\n                }");
        b2.g(new b(this, fVar, i2, optBoolean)).a(new c(this, fVar, i2));
        AppMethodBeat.o(50562);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class c<T> implements d.a<Object> {
        final /* synthetic */ int lyo;
        final /* synthetic */ g mdy;
        final /* synthetic */ f mdz;

        c(g gVar, f fVar, int i2) {
            this.mdy = gVar;
            this.mdz = fVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.vending.g.d.a
        public final void cn(Object obj) {
            AppMethodBeat.i(50561);
            if (obj instanceof Exception) {
                String message = ((Exception) obj).getMessage();
                if (message == null) {
                    message = "";
                }
                f fVar = this.mdz;
                int i2 = this.lyo;
                g gVar = this.mdy;
                if (!n.J(message, "fail", false)) {
                    message = "fail ".concat(String.valueOf(message));
                }
                fVar.i(i2, gVar.Zf(message));
                AppMethodBeat.o(50561);
                return;
            }
            a unused = g.mdx;
            Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + obj + ')');
            this.mdz.i(this.lyo, this.mdy.Zf("fail:internal error"));
            AppMethodBeat.o(50561);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ boolean a(b.d dVar) {
        return dVar.from == 2;
    }
}
