package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.appbrand.jsapi.z.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.k.j;
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.media.d;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.xweb.WebView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0004H\u0002J\u0018\u00103\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0012\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleMPPageAction;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "localData", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getLocalData", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "localData$delegate", "Lkotlin/Lazy;", "host", "getHost", "(Ljava/lang/String;)Ljava/lang/String;", "checkParams", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "doFavorite", "enterEmbedMpVideo", "fillMpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getDensity", "", "getEnterTime", "getFuncFlag", "getNavigationBarHeight", "handleMsg", "hasActivity", "hideNavShadow", "insertVideoNativeView", "longPressEmbedMpVideo", "reportByLeaveForMPGateway", "sendMPPageData", o.NAME, "shareEmbedMpVideo", "showActionSheet", "showMenu", "showNavShadow", "stringToBitmap", "Landroid/graphics/Bitmap;", "string", "syncReadState", "wxConfig", "plugin-webview_release"})
public final class m extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    public static final m Jxt = new m();
    private static final String edq = edq;
    private static final f pCD = g.ah(a.Jxu);

    private static MMKVSlotManager gia() {
        AppMethodBeat.i(210615);
        MMKVSlotManager mMKVSlotManager = (MMKVSlotManager) pCD.getValue();
        AppMethodBeat.o(210615);
        return mMKVSlotManager;
    }

    static {
        AppMethodBeat.i(82690);
        AppMethodBeat.o(82690);
    }

    private m() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    private static String getHost(String str) {
        String str2;
        AppMethodBeat.i(210616);
        p.h(str, "$this$host");
        try {
            Uri parse = Uri.parse(str);
            p.g(parse, "Uri.parse(this)");
            str2 = parse.getHost();
            if (str2 == null) {
                str2 = "unknow";
            }
        } catch (Exception e2) {
            str2 = "unknow";
        }
        AppMethodBeat.o(210616);
        return str2;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        String str;
        long j2;
        String str2;
        com.tencent.mm.plugin.webview.ui.tools.multitask.a gff;
        int i2;
        AppMethodBeat.i(210617);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str3 = (String) nVar.params.get(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.JsApiHandleMPPageAction", "handleMPPageAction action=%s", str3);
        if (Util.isNullOrNil(str3)) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail action is empty", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("enterEmbedMpVideo", str3)) {
            if (!d(fVar, nVar)) {
                AppMethodBeat.o(210617);
                return true;
            }
            y e2 = e(fVar, nVar);
            Context context = fVar.context;
            if (context instanceof WebViewUI) {
                float d2 = d(fVar);
                int eu = au.eu(fVar.context);
                int statusBarHeight = au.getStatusBarHeight(fVar.context);
                e2.iAJ = Util.getFloat((String) nVar.params.get("videoCurrTime"), 0.0f);
                e2.iAL = (int) (Util.getFloat((String) nVar.params.get("playerX"), 0.0f) * d2);
                e2.iAM = (int) ((Util.getFloat((String) nVar.params.get("playerY"), 0.0f) * d2) + ((float) eu) + ((float) statusBarHeight));
                e2.iAN = (int) (Util.getFloat((String) nVar.params.get("playerWidth"), 0.0f) * d2);
                e2.iAO = (int) (Util.getFloat((String) nVar.params.get("playerHeight"), 0.0f) * d2);
                ((WebViewUI) context).gfi().a(e2);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("shareEmbedMpVideo", str3)) {
            if (!d(fVar, nVar)) {
                AppMethodBeat.o(210617);
                return true;
            }
            y e3 = e(fVar, nVar);
            if (fVar.context instanceof WebViewUI) {
                Context context2 = fVar.context;
                if (context2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                    AppMethodBeat.o(210617);
                    throw tVar;
                }
                e3.iAP = ((WebViewUI) context2).Jjb;
                Log.i("MicroMsg.JsApiHandleMPPageAction", "shareEmbedMpVideo bizUsrName=" + e3.dHc + ", mpUrl=" + e3.KOe + ", videoUrl=" + e3.videoUrl + ", width=" + e3.width + ", height=" + e3.height + ", videoDuration=" + e3.videoDuration);
            }
            if (z.gsM()) {
                com.tencent.mm.plugin.webview.ui.tools.media.g gVar = com.tencent.mm.plugin.webview.ui.tools.media.g.JwF;
                com.tencent.mm.plugin.webview.ui.tools.media.g.a(fVar.context, e3, 2);
            } else {
                Context context3 = fVar.context;
                if (context3 instanceof WebViewUI) {
                    ((WebViewUI) context3).JjJ.iwi = e3;
                    d dVar = d.Jwx;
                    d.a(context3, e3.iAo, "", e3.title, e3.KOe, 2);
                } else {
                    Log.e("MicroMsg.JsApiHandleMPPageAction", "not in WebViewUI now!");
                }
            }
            h.INSTANCE.a(18589, 14, 3);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("longPressEmbedMpVideo", str3)) {
            if (!d(fVar, nVar)) {
                AppMethodBeat.o(210617);
                return true;
            }
            y e4 = e(fVar, nVar);
            if (fVar.context instanceof WebViewUI) {
                Context context4 = fVar.context;
                if (context4 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                    AppMethodBeat.o(210617);
                    throw tVar2;
                }
                e4.iAP = ((WebViewUI) context4).Jjb;
            }
            com.tencent.mm.plugin.webview.ui.tools.media.g gVar2 = com.tencent.mm.plugin.webview.ui.tools.media.g.JwF;
            com.tencent.mm.plugin.webview.ui.tools.media.g.a(fVar.context, e4, 1);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("insertVideoNativeView", str3)) {
            if (fVar.context instanceof com.tencent.mm.plugin.webview.h.a.a) {
                Context context5 = fVar.context;
                if (context5 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.api.IBizVideoPage");
                    AppMethodBeat.o(210617);
                    throw tVar3;
                }
                ((com.tencent.mm.plugin.webview.h.a.a) context5).ac(nVar.params);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("wxConfig", str3)) {
            boolean c2 = c(fVar, nVar);
            AppMethodBeat.o(210617);
            return c2;
        } else if (p.j("getFuncFlag", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context6 = fVar.context;
            if (context6 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar4;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("shareFuncFlag", Integer.valueOf(((WebViewUI) context6).geT()));
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("sendMPPageData", str3)) {
            Bundle bundle = new Bundle();
            bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "sendMPPageData");
            Object obj = nVar.params.get("data");
            if (obj == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210617);
                throw tVar5;
            }
            bundle.putString("data", (String) obj);
            Object obj2 = nVar.params.get("sendTo");
            if (obj2 == null) {
                t tVar6 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210617);
                throw tVar6;
            }
            bundle.putString("sendTo", (String) obj2);
            if (nVar.params.containsKey("webviewId")) {
                Object obj3 = nVar.params.get("webviewId");
                if (obj3 == null) {
                    t tVar7 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(210617);
                    throw tVar7;
                }
                i2 = Util.getInt((String) obj3, 0);
            } else {
                i2 = 0;
            }
            bundle.putInt("webviewId", i2);
            if (fVar.context instanceof com.tencent.mm.plugin.webview.h.a.a) {
                Context context7 = fVar.context;
                if (context7 == null) {
                    t tVar8 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.preload.api.IBizVideoPage");
                    AppMethodBeat.o(210617);
                    throw tVar8;
                }
                ((com.tencent.mm.plugin.webview.h.a.a) context7).aa(bundle);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("hasActivity", str3)) {
            if (fVar.context instanceof Activity) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            } else {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
            }
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("showMenu", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context8 = fVar.context;
            if (context8 == null) {
                t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar9;
            }
            ((WebViewUI) context8).Mf(Util.getLong((String) nVar.params.get("forbidFlag"), 0));
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("doFavorite", str3)) {
            fVar.IQZ.cL("sendAppMessage", false);
            fVar.IQZ.d(null, 1);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("showNavShadow", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context9 = fVar.context;
            if (context9 == null) {
                t tVar10 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar10;
            }
            WebViewUI webViewUI = (WebViewUI) context9;
            String str4 = (String) nVar.params.get("color");
            float f2 = Util.getFloat((String) nVar.params.get("alpha"), 0.0f);
            if (f2 <= 0.0f || f2 > 1.0f) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail alpha value is invalid", null);
                AppMethodBeat.o(210617);
                return true;
            }
            int gw = e.gw(str4, 0);
            Window window = webViewUI.getWindow();
            p.g(window, "ui.window");
            View decorView = window.getDecorView();
            p.g(decorView, "ui.window.decorView");
            if ((decorView instanceof ViewGroup) && decorView.findViewById(R.id.jl2) == null) {
                View view = new View(webViewUI);
                view.setBackgroundColor(gw);
                view.setAlpha(f2);
                view.setId(R.id.jl2);
                view.setOnClickListener(c.Jxx);
                com.tencent.mm.plugin.bizui.a.a aVar = com.tencent.mm.plugin.bizui.a.a.pfC;
                int j3 = com.tencent.mm.plugin.bizui.a.a.j(decorView, fVar.IRa);
                Log.i("MicroMsg.JsApiHandleMPPageAction", "showNavShadow shadowHeight=".concat(String.valueOf(j3)));
                ((ViewGroup) decorView).addView(view, new FrameLayout.LayoutParams(-1, j3));
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("hideNavShadow", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context10 = fVar.context;
            if (context10 == null) {
                t tVar11 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar11;
            }
            Window window2 = ((WebViewUI) context10).getWindow();
            p.g(window2, "ui.window");
            View decorView2 = window2.getDecorView();
            p.g(decorView2, "ui.window.decorView");
            View findViewById = decorView2.findViewById(R.id.jl2);
            if (findViewById != null && (decorView2 instanceof ViewGroup)) {
                ((ViewGroup) decorView2).removeView(findViewById);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("syncReadState", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context11 = fVar.context;
            if (context11 == null) {
                t tVar12 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar12;
            }
            WebViewUI webViewUI2 = (WebViewUI) context11;
            int i3 = Util.getInt((String) nVar.params.get("state"), 0);
            Log.i("MicroMsg.JsApiHandleMPPageAction", "handleMPPageAction syncReadState state=".concat(String.valueOf(i3)));
            if (!(webViewUI2 == null || (gff = webViewUI2.gff()) == null)) {
                gff.ahe(i3);
            }
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("setLocalData", str3)) {
            Object obj4 = nVar.params.get("url");
            if (obj4 == null) {
                t tVar13 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210617);
                throw tVar13;
            }
            ((MultiProcessMMKV) gia().getSlot()).encode(getHost((String) obj4) + ':' + ((String) nVar.params.get("key")), (String) nVar.params.get("data"));
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("getLocalData", str3)) {
            Object obj5 = nVar.params.get("url");
            if (obj5 == null) {
                t tVar14 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(210617);
                throw tVar14;
            }
            String decodeString = ((MultiProcessMMKV) gia().getSlot()).decodeString(getHost((String) obj5) + ':' + ((String) nVar.params.get("key")));
            if (decodeString == null) {
                str2 = "";
            } else {
                str2 = decodeString;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("data", str2);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap2);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("reportByLeaveForMPGateway", str3)) {
            boolean f3 = f(fVar, nVar);
            AppMethodBeat.o(210617);
            return f3;
        } else if (p.j("getEnterTime", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context12 = fVar.context;
            if (context12 == null) {
                t tVar15 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar15;
            }
            WebViewUI webViewUI3 = (WebViewUI) context12;
            HashMap hashMap3 = new HashMap();
            j gfc = webViewUI3.gfc();
            hashMap3.put("clickTimeMs", gfc != null ? Long.valueOf(gfc.JBP) : 0L);
            j gfc2 = webViewUI3.gfc();
            if (gfc2 != null) {
                j2 = Long.valueOf(gfc2.createTime);
            } else {
                j2 = 0L;
            }
            hashMap3.put("enterTimeMs", j2);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap3);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("getNavigationBarHeight", str3)) {
            if (!(fVar.context instanceof WebViewUI)) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail", null);
                AppMethodBeat.o(210617);
                return true;
            }
            Context context13 = fVar.context;
            if (context13 == null) {
                t tVar16 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                AppMethodBeat.o(210617);
                throw tVar16;
            }
            int aD = au.aD((WebViewUI) context13);
            Log.i("MicroMsg.JsApiHandleMPPageAction", "handleMPPageAction navBarHeight=".concat(String.valueOf(aD)));
            HashMap hashMap4 = new HashMap();
            hashMap4.put("height", Float.valueOf(((float) aD) / d(fVar)));
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", hashMap4);
            AppMethodBeat.o(210617);
            return true;
        } else if (p.j("showActionSheet", str3)) {
            boolean g2 = g(fVar, nVar);
            AppMethodBeat.o(210617);
            return g2;
        } else if (p.j(o.NAME, str3)) {
            Object obj6 = nVar.params.get("text");
            if (!(obj6 instanceof String)) {
                obj6 = null;
            }
            String str5 = (String) obj6;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            ClipboardHelper.setText(fVar.context, "text", str);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
            AppMethodBeat.o(210617);
            return true;
        } else {
            AppMethodBeat.o(210617);
            return false;
        }
    }

    private static boolean c(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        AppMethodBeat.i(210619);
        String str = (String) nVar.params.get("appid");
        String str2 = (String) nVar.params.get("webComptList");
        Log.i("MicroMsg.JsApiHandleMPPageAction", "wxConfig webComptList=" + str2 + ", appId=" + str);
        try {
            JSONArray jSONArray = new JSONArray(str2);
            String str3 = (String) nVar.params.get("url");
            if (str3 == null) {
                fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail invalid params", null);
                AppMethodBeat.o(210619);
            } else {
                com.tencent.mm.plugin.webview.l.f fVar2 = com.tencent.mm.plugin.webview.l.f.JEG;
                LinkedList<cel> c2 = com.tencent.mm.plugin.webview.l.f.c(str3, jSONArray);
                if (Util.isNullOrNil(c2)) {
                    fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail webComptList is null", null);
                    AppMethodBeat.o(210619);
                } else {
                    k gbi = fVar.IQZ.gbi();
                    if (gbi != null) {
                        String nullAs = Util.nullAs(str, "");
                        p.g(nullAs, "Util.nullAs(appId, \"\")");
                        gbi.c(nullAs, str3, c2);
                    }
                    fVar.IQZ.h(nVar.ISe, nVar.mhO + ":ok", null);
                    AppMethodBeat.o(210619);
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiHandleMPPageAction", "wxConfig ex " + e2.getMessage());
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail ex " + e2 + ".message", null);
            AppMethodBeat.o(210619);
        }
        return true;
    }

    private static boolean d(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        AppMethodBeat.i(210620);
        if (Util.isNullOrNil((String) nVar.params.get("mpUrl"))) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail, mpUrl is null", null);
            AppMethodBeat.o(210620);
            return false;
        } else if (Util.isNullOrNil((String) nVar.params.get("bizUsrName"))) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail, bizUsrName is null", null);
            AppMethodBeat.o(210620);
            return false;
        } else if (Util.isNullOrNil((String) nVar.params.get("videoUrl"))) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail, videoUrl is null", null);
            AppMethodBeat.o(210620);
            return false;
        } else if (Util.isNullOrNil((String) nVar.params.get("videoVid"))) {
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":fail, videoVid is null", null);
            AppMethodBeat.o(210620);
            return false;
        } else {
            AppMethodBeat.o(210620);
            return true;
        }
    }

    private static y e(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        int i2;
        int i3;
        boolean z;
        Bitmap bbf;
        AppMethodBeat.i(210621);
        String str = (String) nVar.params.get("mpUrl");
        String str2 = (String) nVar.params.get("bizUsrName");
        String str3 = (String) nVar.params.get("videoUrl");
        String str4 = (String) nVar.params.get("videoTitle");
        String str5 = (String) nVar.params.get("videoVid");
        String str6 = (String) nVar.params.get("bizNickName");
        Object obj = nVar.params.get("videoThumbUrl");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210621);
            throw tVar;
        }
        String str7 = (String) obj;
        String str8 = (String) nVar.params.get("videoThumbData");
        String str9 = (String) nVar.params.get("headImgUrl");
        float f2 = Util.getFloat((String) nVar.params.get("videoDuration"), 0.0f);
        int i4 = Util.getInt((String) nVar.params.get("videoWidth"), 0);
        int i5 = Util.getInt((String) nVar.params.get("videoHeight"), 0);
        if (str8 == null || (bbf = bbf(str8)) == null || bbf.isRecycled()) {
            i2 = i5;
            i3 = i4;
        } else {
            i3 = bbf.getWidth();
            int height = bbf.getHeight();
            try {
                MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MpShareVideoImage", 2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bbf.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                mmkv.encode(str5, byteArrayOutputStream.toByteArray());
                i2 = height;
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiHandleMPPageAction", e2.getMessage());
                i2 = height;
            }
        }
        y yVar = new y();
        yVar.dHc = str2;
        yVar.iAg = str6;
        yVar.KOe = str;
        yVar.videoUrl = str3;
        yVar.KOf = str5;
        yVar.title = str4;
        yVar.iAo = str7;
        yVar.width = i3;
        yVar.height = i2;
        yVar.videoDuration = (int) f2;
        yVar.iAR = str9;
        yVar.url = e.p.Ozp;
        if (Util.getInt((String) nVar.params.get("forbidForward"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        yVar.iAS = z;
        Context context = fVar.context;
        if (context instanceof WebViewUI) {
            yVar.iAh = ((WebViewUI) context).getIntent().getStringExtra("prePublishId");
            yVar.ehR = ((WebViewUI) context).getIntent().getStringExtra("preChatName");
            yVar.ehQ = ((WebViewUI) context).getIntent().getStringExtra("preUsername");
        }
        AppMethodBeat.o(210621);
        return yVar;
    }

    private static Bitmap bbf(String str) {
        Bitmap bitmap;
        AppMethodBeat.i(82689);
        try {
            bitmap = BitmapUtil.decodeByteArray(Base64.decode(kotlin.n.n.a(str, new String[]{","}).get(1), 2));
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiHandleMPPageAction", "stringToBitmap fail " + e2.getMessage());
            bitmap = null;
        }
        AppMethodBeat.o(82689);
        return bitmap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        public static final c Jxx = new c();

        static {
            AppMethodBeat.i(210614);
            AppMethodBeat.o(210614);
        }

        c() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210613);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleMPPageAction$showNavShadow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.JsApiHandleMPPageAction", "click");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiHandleMPPageAction$showNavShadow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210613);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean f(com.tencent.mm.plugin.webview.d.f r9, com.tencent.mm.plugin.webview.d.n r10) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.newjsapi.m.f(com.tencent.mm.plugin.webview.d.f, com.tencent.mm.plugin.webview.d.n):boolean");
    }

    private static boolean g(com.tencent.mm.plugin.webview.d.f fVar, n nVar) {
        AppMethodBeat.i(210623);
        Object obj = nVar.params.get(MessengerShareContentUtility.BUTTONS);
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            fVar.IQZ.h(nVar.ISe, "handleMPPageAction:fail params invalid", null);
            AppMethodBeat.o(210623);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    arrayList.add(new Pair(optJSONObject.optString("id"), optJSONObject.optString("label")));
                }
                com.tencent.f.h.RTc.aV(new b(fVar, arrayList, nVar));
            } catch (Exception e2) {
            }
            AppMethodBeat.o(210623);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.webview.d.f CDE;
        final /* synthetic */ ArrayList Jxv;
        final /* synthetic */ n pGr;

        b(com.tencent.mm.plugin.webview.d.f fVar, ArrayList arrayList, n nVar) {
            this.CDE = fVar;
            this.Jxv = arrayList;
            this.pGr = nVar;
        }

        public final void run() {
            AppMethodBeat.i(210612);
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.CDE.context, 1, false);
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.newjsapi.m.b.AnonymousClass1 */
                final /* synthetic */ b Jxw;

                {
                    this.Jxw = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(210609);
                    mVar.clear();
                    int size = this.Jxw.Jxv.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        mVar.d(i2, (CharSequence) ((Pair) this.Jxw.Jxv.get(i2)).second);
                    }
                    AppMethodBeat.o(210609);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.newjsapi.m.b.AnonymousClass2 */
                final /* synthetic */ b Jxw;

                {
                    this.Jxw = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(210610);
                    if (i2 >= this.Jxw.Jxv.size()) {
                        this.Jxw.CDE.IQZ.h(this.Jxw.pGr.ISe, this.Jxw.pGr.mhO + ":fail", null);
                        AppMethodBeat.o(210610);
                        return;
                    }
                    String str = (String) ((Pair) this.Jxw.Jxv.get(i2)).first;
                    HashMap hashMap = new HashMap();
                    p.g(str, "menuId");
                    hashMap.put("id", str);
                    this.Jxw.CDE.IQZ.h(this.Jxw.pGr.ISe, this.Jxw.pGr.mhO + ":ok", hashMap);
                    AppMethodBeat.o(210610);
                }
            });
            eVar.a(new e.a(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.newjsapi.m.b.AnonymousClass3 */
                final /* synthetic */ b Jxw;

                {
                    this.Jxw = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.e.a
                public final void onClick() {
                    AppMethodBeat.i(210611);
                    this.Jxw.CDE.IQZ.h(this.Jxw.pGr.ISe, this.Jxw.pGr.mhO + ":canceled", null);
                    AppMethodBeat.o(210611);
                }
            });
            eVar.dGm();
            AppMethodBeat.o(210612);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MMKVSlotManager> {
        public static final a Jxu = new a();

        static {
            AppMethodBeat.i(210608);
            AppMethodBeat.o(210608);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMKVSlotManager invoke() {
            AppMethodBeat.i(210607);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("PrefechLocalData");
            p.g(mmkv, "MultiProcessMMKV.getMMKV(\"PrefechLocalData\")");
            MMKVSlotManager mMKVSlotManager = new MMKVSlotManager(mmkv, 2592000);
            AppMethodBeat.o(210607);
            return mMKVSlotManager;
        }
    }

    private static float d(com.tencent.mm.plugin.webview.d.f fVar) {
        float f2;
        AppMethodBeat.i(210618);
        Context context = fVar.context;
        if (context instanceof WebViewUI) {
            float gvp = com.tencent.mm.cc.a.gvp();
            if (((WebViewUI) context).gfW() != null) {
                MMWebView gfW = ((WebViewUI) context).gfW();
                p.g(gfW, "ui.viewWV");
                if (gfW.getWebCoreType() == WebView.c.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
                    MMWebView gfW2 = ((WebViewUI) context).gfW();
                    p.g(gfW2, "ui.viewWV");
                    Resources resources = gfW2.getResources();
                    p.g(resources, "ui.viewWV.resources");
                    f2 = resources.getDisplayMetrics().density;
                    AppMethodBeat.o(210618);
                    return f2;
                }
            }
            f2 = gvp;
            AppMethodBeat.o(210618);
            return f2;
        }
        float gvp2 = com.tencent.mm.cc.a.gvp();
        AppMethodBeat.o(210618);
        return gvp2;
    }
}
