package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import com.facebook.internal.NativeProtocol;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.h;
import com.tencent.mm.plugin.appbrand.jsapi.z.n;
import com.tencent.mm.plugin.appbrand.jsapi.z.q;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "enableFullScreen", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "getSafeAreaInsets", h.NAME, n.NAME, "handleMsg", "hideKeyBoard", "setOrientation", q.NAME, r.NAME, "plugin-webview_release"})
public final class l extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = 372;
    public static final l Jxn = new l();
    private static final String edq = edq;

    static {
        AppMethodBeat.i(210606);
        AppMethodBeat.o(210606);
    }

    private l() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
        int i2 = 0;
        AppMethodBeat.i(210605);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str = (String) nVar.params.get(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.JsApiHandleDeviceInfo", "handleDeviceInfo action=%s", str);
        if (Util.isNullOrNil(str)) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail action is empty", null);
            AppMethodBeat.o(210605);
            return true;
        } else if (p.j("enableFullScreen", str)) {
            boolean z = Util.getBoolean((String) nVar.params.get("enable"), false);
            if (fVar.context instanceof com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b) {
                if (z) {
                    switch (Util.getInt((String) nVar.params.get("orientation"), 0)) {
                        case -90:
                            i2 = -90;
                            break;
                        case 90:
                            i2 = 90;
                            break;
                    }
                    Context context = fVar.context;
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
                        AppMethodBeat.o(210605);
                        throw tVar;
                    }
                    ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b) context).aB(null, i2);
                } else {
                    Context context2 = fVar.context;
                    if (context2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.video.samelayer.IWebViewUIFullScreen");
                        AppMethodBeat.o(210605);
                        throw tVar2;
                    }
                    ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b) context2).gfl();
                }
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210605);
            return true;
        } else if (p.j("setOrientation", str)) {
            int i3 = Util.getInt((String) nVar.params.get("orientation"), 0);
            boolean z2 = Util.getBoolean((String) nVar.params.get("lock"), true);
            Log.i("MicroMsg.JsApiHandleDeviceInfo", "setOrientation orientation=" + i3 + ", lock=" + z2);
            if (fVar.context instanceof com.tencent.mm.plugin.webview.ui.tools.video.samelayer.b) {
                if (z2) {
                    Context context3 = fVar.context;
                    if (!(context3 instanceof Activity)) {
                        context3 = null;
                    }
                    Activity activity = (Activity) context3;
                    if (activity != null) {
                        switch (i3) {
                            case -90:
                                activity.setRequestedOrientation(8);
                                break;
                            case 90:
                                activity.setRequestedOrientation(0);
                                break;
                            default:
                                activity.setRequestedOrientation(1);
                                break;
                        }
                    }
                } else {
                    Context context4 = fVar.context;
                    if (!(context4 instanceof Activity)) {
                        context4 = null;
                    }
                    Activity activity2 = (Activity) context4;
                    if (activity2 != null) {
                        activity2.setRequestedOrientation(-1);
                    }
                }
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210605);
            return true;
        } else if (p.j(r.NAME, str)) {
            Log.i("MicroMsg.JsApiHandleDeviceInfo", r.NAME);
            float f2 = (float) Util.getDouble((String) nVar.params.get("data"), 0.0d);
            if (f2 < 0.0f || f2 > 1.0f) {
                AppMethodBeat.o(210605);
                return false;
            }
            Context context5 = fVar.context;
            if (!(context5 instanceof Activity)) {
                context5 = null;
            }
            Activity activity3 = (Activity) context5;
            if (activity3 != null) {
                com.tencent.mm.ac.d.h(new f(activity3, f2, fVar, nVar));
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return true;
        } else if (p.j(n.NAME, str)) {
            Context context6 = fVar.context;
            if (!(context6 instanceof Activity)) {
                context6 = null;
            }
            Activity activity4 = (Activity) context6;
            if (activity4 != null) {
                com.tencent.mm.ac.d.h(new c(activity4, fVar, nVar));
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return false;
        } else if (p.j(q.NAME, str)) {
            Log.i("MicroMsg.JsApiHandleDeviceInfo", q.NAME);
            float f3 = (float) Util.getDouble((String) nVar.params.get("data"), 0.0d);
            if (f3 < 0.0f || f3 > 1.0f) {
                AppMethodBeat.o(210605);
                return false;
            }
            Context context7 = fVar.context;
            if (!(context7 instanceof Activity)) {
                context7 = null;
            }
            if (((Activity) context7) != null) {
                com.tencent.mm.ac.d.h(new e(fVar, f3, nVar));
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return true;
        } else if (p.j(h.NAME, str)) {
            Context context8 = fVar.context;
            if (!(context8 instanceof Activity)) {
                context8 = null;
            }
            Activity activity5 = (Activity) context8;
            if (activity5 != null) {
                com.tencent.mm.ac.d.h(new b(activity5, fVar, nVar));
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return false;
        } else if (p.j("getSafeAreaInsets", str)) {
            Context context9 = fVar.context;
            if (!(context9 instanceof Activity)) {
                context9 = null;
            }
            Activity activity6 = (Activity) context9;
            if (activity6 != null) {
                com.tencent.mm.ac.d.h(new a(activity6, fVar, nVar));
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return false;
        } else if (p.j("hideKeyBoard", str)) {
            Context context10 = fVar.context;
            if (!(context10 instanceof WebViewUI)) {
                context10 = null;
            }
            WebViewUI webViewUI = (WebViewUI) context10;
            if (webViewUI != null) {
                com.tencent.mm.ac.d.h(new d(webViewUI, fVar, nVar));
                AppMethodBeat.o(210605);
                return true;
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            AppMethodBeat.o(210605);
            return false;
        } else {
            AppMethodBeat.o(210605);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setScreenBrightness$1$1"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ float Jxr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(com.tencent.mm.plugin.webview.d.f fVar, float f2, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.Jxo = fVar;
            this.Jxr = f2;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210603);
            com.tencent.mm.plugin.appbrand.jsapi.video.l.b(this.Jxo.context, this.Jxr);
            Log.i("MicroMsg.JsApiHandleDeviceInfo", "setScreenBrightness, brightness:" + this.Jxr);
            x xVar = x.SXb;
            AppMethodBeat.o(210603);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getScreenBrightness$1$1"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ Activity vCe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.vCe = activity;
            this.Jxo = fVar;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210600);
            float dV = com.tencent.mm.plugin.appbrand.jsapi.video.l.dV(this.vCe);
            HashMap hashMap = new HashMap();
            hashMap.put("data", Float.valueOf(dV));
            this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":ok", hashMap);
            Log.i("MicroMsg.JsApiHandleDeviceInfo", "getScreenBrightness, currentBrightness=".concat(String.valueOf(dV)));
            x xVar = x.SXb;
            AppMethodBeat.o(210600);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$setVolume$1$1"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ float Jxs;
        final /* synthetic */ Activity vCe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Activity activity, float f2, com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.vCe = activity;
            this.Jxs = f2;
            this.Jxo = fVar;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210604);
            Object systemService = this.vCe.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                AppMethodBeat.o(210604);
                throw tVar;
            }
            AudioManager audioManager = (AudioManager) systemService;
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            com.tencent.mm.compatible.b.a.a(audioManager, 3, (int) (((float) streamMaxVolume) * this.Jxs), 0);
            Log.i("MicroMsg.JsApiHandleDeviceInfo", "setVolume, maxVolume=" + streamMaxVolume + ", volume=" + this.Jxs);
            this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":ok", null);
            x xVar = x.SXb;
            AppMethodBeat.o(210604);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getVolume$1$1"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ Activity vCe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Activity activity, com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.vCe = activity;
            this.Jxo = fVar;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210601);
            Object systemService = this.vCe.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                AppMethodBeat.o(210601);
                throw tVar;
            }
            AudioManager audioManager = (AudioManager) systemService;
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            HashMap hashMap = new HashMap();
            hashMap.put("data", Float.valueOf(((float) streamVolume) / ((float) streamMaxVolume)));
            this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":ok", hashMap);
            Log.i("MicroMsg.JsApiHandleDeviceInfo", "getVolume, maxVolume=" + streamMaxVolume + ", volume=" + streamVolume);
            x xVar = x.SXb;
            AppMethodBeat.o(210601);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$getSafeAreaInsets$1$1"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ Activity vCe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity, com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.vCe = activity;
            this.Jxo = fVar;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210599);
            Rect bl = ao.bl(this.vCe);
            MMWebView mMWebView = this.Jxo.IRa;
            if (mMWebView == null) {
                p.hyc();
            }
            float mMDensity = mMWebView.getMMDensity();
            if (bl == null || mMDensity <= 0.0f) {
                Log.e("MicroMsg.JsApiHandleDeviceInfo", "getSafeAreaInsets fail, rect is null" + (bl == null) + ", density=" + mMDensity);
                this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":fail invalid params", null);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("left", Float.valueOf(((float) bl.left) / mMDensity));
                hashMap.put("top", Float.valueOf(((float) bl.top) / mMDensity));
                hashMap.put("right", Float.valueOf(((float) bl.right) / mMDensity));
                hashMap.put("bottom", Float.valueOf(((float) bl.bottom) / mMDensity));
                this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":ok", hashMap);
                Log.i("MicroMsg.JsApiHandleDeviceInfo", "getSafeAreaInsets, rect=" + bl.toShortString());
            }
            x xVar = x.SXb;
            AppMethodBeat.o(210599);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleDeviceInfo$hideKeyBoard$1$1"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f Jxo;
        final /* synthetic */ com.tencent.mm.plugin.webview.d.n Jxp;
        final /* synthetic */ WebViewUI Jxq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(WebViewUI webViewUI, com.tencent.mm.plugin.webview.d.f fVar, com.tencent.mm.plugin.webview.d.n nVar) {
            super(0);
            this.Jxq = webViewUI;
            this.Jxo = fVar;
            this.Jxp = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210602);
            this.Jxq.fTu();
            this.Jxo.IQZ.h(this.Jxp.ISe, this.Jxp.mhO + ":ok", null);
            x xVar = x.SXb;
            AppMethodBeat.o(210602);
            return xVar;
        }
    }
}
