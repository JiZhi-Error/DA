package com.tencent.mm.plugin.webview.ui.tools.fts.preload;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hs;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.d.i;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0018H\u0002J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask;", "", "biz", "", "url", "", "(ILjava/lang/String;)V", "beginTimestamp", "", "getBeginTimestamp", "()J", "setBeginTimestamp", "(J)V", "getBiz", "()I", "getUrl", "()Ljava/lang/String;", "webSearchPreloadObj", "Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "getWebSearchPreloadObj", "()Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;", "setWebSearchPreloadObj", "(Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadObj;)V", "buildDefaultParams", "", "getRunOn3rdApis", "loadJavaScript", "", "webView", "Lcom/tencent/mm/plugin/websearch/webview/WebSearchWebView;", "reportPreloadCompleted", "", "start", "Builder", "plugin-webview_release"})
public final class e {
    long JpD;
    d JpE;
    final int mrG;
    final String url;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    public static final class b<T> implements ValueCallback<String> {
        final /* synthetic */ e JpG;

        b(e eVar) {
            this.JpG = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(210536);
            long aWA = cl.aWA() - this.JpG.JpD;
            Log.i(c.getTAG(), "load wxjs cost:" + aWA + ' ' + str);
            AppMethodBeat.o(210536);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    public static final class c<T> implements ValueCallback<String> {
        final /* synthetic */ e JpG;

        c(e eVar) {
            this.JpG = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(210537);
            long aWA = cl.aWA() - this.JpG.JpD;
            Log.i(c.getTAG(), "sys:init cost:" + aWA + ' ' + str);
            AppMethodBeat.o(210537);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    public static final class d<T> implements ValueCallback<String> {
        final /* synthetic */ e JpG;

        d(e eVar) {
            this.JpG = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(210538);
            long aWA = cl.aWA() - this.JpG.JpD;
            Log.i(c.getTAG(), "sys:init bridged:" + aWA + ' ' + str);
            AppMethodBeat.o(210538);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.preload.e$e  reason: collision with other inner class name */
    public static final class C1993e<T> implements ValueCallback<String> {
        final /* synthetic */ e JpG;

        C1993e(e eVar) {
            this.JpG = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            long j2;
            AtomicBoolean atomicBoolean;
            AppMethodBeat.i(210539);
            Log.i(c.getTAG(), "sys:attach_runOn3rd_apis cost:" + (cl.aWA() - this.JpG.JpD) + ' ' + str);
            d dVar = this.JpG.JpE;
            if (!(dVar == null || (atomicBoolean = dVar.JpC) == null)) {
                atomicBoolean.set(true);
            }
            e eVar = this.JpG;
            d dVar2 = eVar.JpE;
            if (dVar2 != null) {
                long aWA = cl.aWA() - eVar.JpD;
                hs hsVar = new hs();
                hsVar.qS((long) eVar.mrG);
                hsVar.qT(2);
                hsVar.qU(aWA);
                WebSearchWebView webSearchWebView = dVar2.Gqy;
                if ((webSearchWebView != null ? webSearchWebView.getWebCoreType() : null) == WebView.c.WV_KIND_SYS) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                hsVar.qV(j2);
                hsVar.bfK();
                ar.a(hsVar);
                AppMethodBeat.o(210539);
                return;
            }
            AppMethodBeat.o(210539);
        }
    }

    public e(int i2, String str) {
        p.h(str, "url");
        AppMethodBeat.i(210546);
        this.mrG = i2;
        this.url = str;
        AppMethodBeat.o(210546);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(WebSearchWebView webSearchWebView) {
        String str;
        AppMethodBeat.i(210545);
        Log.i(c.getTAG(), "loadJavaScript");
        try {
            str = Util.convertStreamToString(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Exception e2) {
            Log.printErrStackTrace(c.getTAG(), e2, "", new Object[0]);
            str = null;
        }
        webSearchWebView.evaluateJavascript("javascript:".concat(String.valueOf(str)), new b(this));
        StringBuilder sb = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
        a.C1992a aVar = a.JpF;
        HashMap hashMap = new HashMap();
        hashMap.put("webview_type", "1");
        hashMap.put("init_url", this.url);
        hashMap.put("init_font_size", "1");
        webSearchWebView.evaluateJavascript(sb.append(a.C1992a.R("sys:init", hashMap)).append(")").toString(), new c(this));
        StringBuilder sb2 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
        a.C1992a aVar2 = a.JpF;
        webSearchWebView.evaluateJavascript(sb2.append(a.C1992a.R("sys:bridged", null)).append(")").toString(), new d(this));
        StringBuilder sb3 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
        a.C1992a aVar3 = a.JpF;
        HashMap hashMap2 = new HashMap();
        LinkedList linkedList = new LinkedList();
        linkedList.add("menu:share:timeline");
        linkedList.add("menu:share:appmessage");
        linkedList.add("menu:share:weiboApp");
        linkedList.add("menu:share:QZone");
        linkedList.add("menu:share:qq");
        linkedList.add("onVoiceRecordEnd");
        linkedList.add("onVoicePlayBegin");
        linkedList.add("onVoicePlayEnd");
        linkedList.add("onLocalImageUploadProgress");
        linkedList.add("onImageDownloadProgress");
        linkedList.add("onVoiceUploadProgress");
        linkedList.add("onVoiceDownloadProgress");
        linkedList.add("onVideoUploadProgress");
        linkedList.add("onMediaFileUploadProgress");
        linkedList.add("menu:setfont");
        linkedList.add("menu:share:weibo");
        linkedList.add("menu:share:email");
        linkedList.add("wxdownload:state_change");
        linkedList.add("wxdownload:progress_change");
        linkedList.add("hdOnDeviceStateChanged");
        linkedList.add("activity:state_change");
        linkedList.add("onWXDeviceBluetoothStateChange");
        linkedList.add("onWXDeviceLanStateChange");
        linkedList.add("onWXDeviceBindStateChange");
        linkedList.add("onReceiveDataFromWXDevice");
        linkedList.add("onScanWXDeviceResult");
        linkedList.add("onWXDeviceStateChange");
        linkedList.add("onNfcTouch");
        linkedList.add("onBeaconMonitoring");
        linkedList.add("onBeaconsInRange");
        linkedList.add("menu:custom");
        linkedList.add("onSearchWAWidgetOpenApp");
        linkedList.add("onSearchDataReady");
        linkedList.add("onClientNavAction");
        linkedList.add("onNavBarShadowManuallyHidden");
        linkedList.add("onGetVertSearchEntriesData");
        linkedList.add("onChatSearchDataReady");
        linkedList.add("onSearchHistoryReady");
        linkedList.add("onSearchWAWidgetOnTapCallback");
        linkedList.add("onSearchImageListReady");
        linkedList.add("onTeachSearchDataReady");
        linkedList.add("onSearchGuideDataReady");
        linkedList.add("onSearchInputChange");
        linkedList.add("onSearchInputConfirm");
        linkedList.add("onSearchSuggestionDataReady");
        linkedList.add("onMusicStatusChanged");
        linkedList.add("switchToTabSearch");
        linkedList.add("onVideoPlayerCallback");
        linkedList.add("onSelectContact");
        linkedList.add("onSearchWAWidgetAttrChanged");
        linkedList.add("onSearchWAWidgetReloadData");
        linkedList.add("onSearchWAWidgetReloadDataFinish");
        linkedList.add("onSearchWAWidgetStateChange");
        linkedList.add("onSearchWAWidgetDataPush");
        linkedList.add("emoticonIsChosen");
        linkedList.add("onSimilarEmoticonReady");
        linkedList.add("onSearchWebQueryReady");
        linkedList.add("onPullDownRefresh");
        linkedList.add("onPageStateChange");
        linkedList.add("onGetKeyboardHeight");
        linkedList.add("onGetSmiley");
        linkedList.add("onAddShortcutStatus");
        linkedList.add("onFocusSearchInput");
        linkedList.add("onGetA8KeyUrl");
        linkedList.add("deleteAccountSuccess");
        linkedList.add("onGetMsgProofItems");
        linkedList.add("WNJSHandlerInsert");
        linkedList.add("WNJSHandlerMultiInsert");
        linkedList.add("WNJSHandlerExportData");
        linkedList.add("WNJSHandlerHeaderAndFooterChange");
        linkedList.add("WNJSHandlerEditableChange");
        linkedList.add("WNJSHandlerEditingChange");
        linkedList.add("WNJSHandlerSaveSelectionRange");
        linkedList.add("WNJSHandlerLoadSelectionRange");
        linkedList.add("onCustomGameMenuClicked");
        linkedList.add("showLoading");
        linkedList.add("getSearchEmotionDataCallBack");
        linkedList.add("onNavigationBarRightButtonClick");
        linkedList.add("onSearchActionSheetClick");
        linkedList.add("onGetMatchContactList");
        linkedList.add("onUiInit");
        linkedList.add("onNetWorkChange");
        linkedList.add("onBackgroundAudioStateChange");
        hashMap2.put("__runOn3rd_apis", new JSONArray((Collection) linkedList));
        webSearchWebView.evaluateJavascript(sb3.append(a.C1992a.R("sys:attach_runOn3rd_apis", hashMap2)).append(")").toString(), new C1993e(this));
        AppMethodBeat.o(210545);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder;", "", "()V", "Companion", "plugin-webview_release"})
    public static final class a {
        public static final C1992a JpF = new C1992a((byte) 0);

        static {
            AppMethodBeat.i(210535);
            AppMethodBeat.o(210535);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000bJ$\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/fts/preload/WebSearchPreloadTask$Builder$Companion;", "", "()V", "EVENT_ID", "", "MSG_PARAMS", "MSG_TYPE", "TYPE_EVENT", "convertMapToJSON", "Lorg/json/JSONObject;", "map", "", "eventToString", "eventId", NativeProtocol.WEB_DIALOG_PARAMS, "plugin-webview_release"})
        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.preload.e$a$a  reason: collision with other inner class name */
        public static final class C1992a {
            private C1992a() {
            }

            public /* synthetic */ C1992a(byte b2) {
                this();
            }

            public static String R(String str, Map<String, ? extends Object> map) {
                AppMethodBeat.i(210533);
                p.h(str, "eventId");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("__msg_type", "event");
                    jSONObject.put("__event_id", str);
                    if (map != null) {
                        C1992a aVar = a.JpF;
                        jSONObject.put("__params", be(map));
                    }
                } catch (Exception e2) {
                }
                String jSONObject2 = jSONObject.toString();
                p.g(jSONObject2, "json.toString()");
                AppMethodBeat.o(210533);
                return jSONObject2;
            }

            private static JSONObject be(Map<String, ? extends Object> map) {
                AppMethodBeat.i(210534);
                p.h(map, "map");
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    try {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(210534);
                return jSONObject;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e JpG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar) {
            super(0);
            this.JpG = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210544);
            final WebSearchWebView webSearchWebView = new WebSearchWebView(MMApplicationContext.getContext());
            webSearchWebView.setPreload(true);
            webSearchWebView.a(null, new com.tencent.mm.plugin.websearch.webview.f(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.preload.e.f.AnonymousClass1 */
                final /* synthetic */ f JpH;

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "kotlin.jvm.PlatformType", "onReceiveValue"})
                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.preload.e$f$1$a */
                static final class a<T> implements ValueCallback<String> {
                    public static final a JpI = new a();

                    static {
                        AppMethodBeat.i(210540);
                        AppMethodBeat.o(210540);
                    }

                    a() {
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
                    }
                }

                {
                    this.JpH = r1;
                }

                @Override // com.tencent.xweb.ac
                public final void b(WebView webView, String str) {
                    AppMethodBeat.i(210541);
                    super.b(webView, str);
                    Log.i(c.getTAG(), "onPageFinished ".concat(String.valueOf(str)));
                    this.JpH.JpG.a(webSearchWebView);
                    AppMethodBeat.o(210541);
                }

                @Override // com.tencent.xweb.ac
                public final void b(WebView webView, String str, Bitmap bitmap) {
                    AppMethodBeat.i(210542);
                    p.h(webView, "view");
                    super.b(webView, str, bitmap);
                    Log.i(c.getTAG(), "onPageStarted ".concat(String.valueOf(str)));
                    z.c(webSearchWebView);
                    AppMethodBeat.o(210542);
                }

                @Override // com.tencent.xweb.ac
                public final boolean a(WebView webView, String str) {
                    AppMethodBeat.i(210543);
                    p.h(webView, "view");
                    if (!z.C(str, "weixin://private/setresult/")) {
                        AppMethodBeat.o(210543);
                        return false;
                    }
                    Log.i(c.getTAG(), "handleUrl %s ,view %s", str, webView.toString());
                    webSearchWebView.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", a.JpI);
                    AppMethodBeat.o(210543);
                    return true;
                }
            });
            i iVar = new i();
            webSearchWebView.addJavascriptInterface(iVar, "__wx");
            webSearchWebView.addJavascriptInterface(new a(webSearchWebView.getContext()), "webSearchJSApi");
            d dVar = this.JpG.JpE;
            if (dVar != null) {
                dVar.Gqy = webSearchWebView;
            }
            d dVar2 = this.JpG.JpE;
            if (dVar2 != null) {
                dVar2.IFj = iVar;
            }
            webSearchWebView.loadUrl(this.JpG.url);
            x xVar = x.SXb;
            AppMethodBeat.o(210544);
            return xVar;
        }
    }
}
