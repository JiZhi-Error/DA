package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.webview.d.i;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ao {
    int IFb;
    AtomicBoolean IFc = new AtomicBoolean(false);
    List<ap> IFd = new LinkedList();
    long IFe;
    String TAG = "MicroMsg.WebSearch.WebSearchPreloadMgr";

    public ao(int i2) {
        AppMethodBeat.i(117750);
        this.IFb = i2;
        this.TAG += "_" + i2;
        AppMethodBeat.o(117750);
    }

    public final void aXi(final String str) {
        AppMethodBeat.i(117751);
        if (!MMApplicationContext.isToolsMpProcess()) {
            Log.i(this.TAG, "preload please call from toolsmp proc");
            AppMethodBeat.o(117751);
        } else if (this.IFc.get()) {
            Log.i(this.TAG, "preloading webview %s", Integer.valueOf(this.IFb));
            AppMethodBeat.o(117751);
        } else if (this.IFd.size() > 0) {
            Log.i(this.TAG, "already preload webview %s", Integer.valueOf(this.IFb));
            AppMethodBeat.o(117751);
        } else {
            this.IFc.set(true);
            Log.i(this.TAG, "start to preload webview %d", Integer.valueOf(this.IFb));
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass1 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(117739);
                    ao aoVar = ao.this;
                    String str = str;
                    Log.i(aoVar.TAG, "real start preloadWebView cached webview preloadBiz %d", Integer.valueOf(aoVar.IFb));
                    aoVar.IFe = System.currentTimeMillis();
                    MMWebView kL = MMWebView.a.kL(MMApplicationContext.getContext());
                    Log.i(aoVar.TAG, "Create MMWebView %s", kL.getWebCoreType());
                    kL.setPreload(true);
                    kL.setRandomStr(Util.getRandomString(16));
                    kL.getSettings().setJavaScriptEnabled(true);
                    kL.getSettings().setPluginsEnabled(true);
                    kL.getSettings().hsU();
                    kL.getSettings().setBuiltInZoomControls(false);
                    kL.getSettings().setUseWideViewPort(true);
                    kL.getSettings().setLoadWithOverviewMode(true);
                    kL.getSettings().hsN();
                    kL.getSettings().hsM();
                    kL.getSettings().setGeolocationEnabled(true);
                    kL.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    kL.getSettings().hsW();
                    kL.getSettings().hsS();
                    kL.getSettings().setAppCachePath(kL.getContext().getDir("webviewcache", 0).getAbsolutePath());
                    kL.getSettings().hsR();
                    kL.getSettings().hsT();
                    kL.getSettings().setDatabasePath(b.aKA() + "databases/");
                    c.hsp().hsq();
                    c.hsp().e(kL);
                    kL.getSettings().setUserAgentString(z.cr(kL.getContext(), kL.getSettings().getUserAgentString()));
                    i iVar = new i();
                    kL.addJavascriptInterface(iVar, "__wx");
                    kL.loadUrl(str);
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("sessionId");
                    String queryParameter2 = parse.getQueryParameter("subSessionId");
                    try {
                        i2 = Integer.valueOf(parse.getQueryParameter("scene")).intValue();
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    kL.setWebViewClient(new ac(kL, new ap(kL, queryParameter, queryParameter2, iVar, i2)) {
                        /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass2 */
                        final /* synthetic */ MMWebView IFg;
                        final /* synthetic */ ap IFh;

                        {
                            this.IFg = r2;
                            this.IFh = r3;
                        }

                        @Override // com.tencent.xweb.ac
                        public final void b(WebView webView, String str) {
                            AppMethodBeat.i(117740);
                            Log.i(ao.this.TAG, "onPageFinished, view %s", webView.toString());
                            ao.this.a(this.IFg, this.IFh);
                            AppMethodBeat.o(117740);
                        }

                        @Override // com.tencent.xweb.ac
                        public final void b(WebView webView, String str, Bitmap bitmap) {
                            AppMethodBeat.i(117741);
                            super.b(webView, str, bitmap);
                            Log.i(ao.this.TAG, "onPageStarted, view %s", webView.toString());
                            z.c(this.IFg);
                            AppMethodBeat.o(117741);
                        }

                        @Override // com.tencent.xweb.ac
                        public final boolean a(WebView webView, String str) {
                            AppMethodBeat.i(117742);
                            if (!z.C(str, "weixin://private/setresult/")) {
                                AppMethodBeat.o(117742);
                                return false;
                            }
                            Log.i(ao.this.TAG, "handleUrl %s ,view %s", str, webView.toString());
                            this.IFg.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
                            AppMethodBeat.o(117742);
                            return true;
                        }
                    });
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(15005, Integer.valueOf(aoVar.IFb), 1, 0);
                    AppMethodBeat.o(117739);
                }
            });
            AppMethodBeat.o(117751);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(final MMWebView mMWebView, final ap apVar) {
        String str;
        AppMethodBeat.i(187862);
        Log.i(this.TAG, "begin jsapi init,wv %s", mMWebView.toString());
        try {
            str = Util.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            str = null;
        }
        if (str == null) {
            Log.e(this.TAG, "loadJavaScript fail, jsContent is null");
            AppMethodBeat.o(187862);
            return false;
        } else if (mMWebView == null) {
            Log.e(this.TAG, "loadJavaScript, viewWV is null");
            AppMethodBeat.o(187862);
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:".concat(String.valueOf(str)), new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(117743);
                    Log.i(ao.this.TAG, "loadJavaScript, jsContent evaluateJavascript cb, ret = %s, view %s", str, mMWebView.toString());
                    AppMethodBeat.o(117743);
                }
            });
            StringBuilder sb = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            HashMap hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(sb.append(a.i("event", "sys:init", hashMap)).append(")").toString(), new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(117744);
                    Log.i(ao.this.TAG, "loadJS, sys:init callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.o(117744);
                }
            });
            StringBuilder sb2 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(sb2.append(a.i("event", "sys:bridged", null)).append(")").toString(), new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass5 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(117745);
                    Log.i(ao.this.TAG, "loadJS, sys:bridged callback %s,view %s", str, mMWebView.toString());
                    AppMethodBeat.o(117745);
                }
            });
            StringBuilder sb3 = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
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
            linkedList.add("onCurrentLocationReady");
            linkedList.add("onClientNavAction");
            linkedList.add("onNavBarShadowManuallyHidden");
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
            linkedList.add("onGetVertSearchEntriesData");
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
            if (!Util.isNullOrNil((List) null)) {
                linkedList.addAll(null);
            }
            hashMap2.put("__runOn3rd_apis", new JSONArray((Collection) linkedList));
            mMWebView.getRandomStr();
            mMWebView.evaluateJavascript(sb3.append(a.i("event", "sys:attach_runOn3rd_apis", hashMap2)).append(")").toString(), new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.websearch.api.ao.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(117746);
                    Log.i(ao.this.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s preloadBiz:%d", str, mMWebView.toString(), Integer.valueOf(ao.this.IFb));
                    long currentTimeMillis = System.currentTimeMillis() - ao.this.IFe;
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    au.fYB();
                    hVar.a(15005, Integer.valueOf(ao.this.IFb), 2, Long.valueOf(currentTimeMillis), 2);
                    ao.this.IFd.add(apVar);
                    ao.this.IFc.set(false);
                    Log.i(ao.this.TAG, "preload webview done, cost: %s scene:%s coreType:%s", Long.valueOf(currentTimeMillis), Integer.valueOf(apVar.scene), apVar.webView.getWebCoreType());
                    AppMethodBeat.o(117746);
                }
            });
            Log.i(this.TAG, "jsapi init done");
            AppMethodBeat.o(187862);
            return true;
        }
    }

    public static class a {
        static String i(String str, String str2, Map<String, Object> map) {
            AppMethodBeat.i(117748);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__msg_type", str);
                if (str.equals("event")) {
                    jSONObject.put("__event_id", str2);
                }
                jSONObject.put("__params", be(map));
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(117748);
                return jSONObject2;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e2.getMessage());
                AppMethodBeat.o(117748);
                return null;
            }
        }

        private static JSONObject be(Map<String, Object> map) {
            AppMethodBeat.i(117749);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.o(117749);
                return jSONObject;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (String str : map.keySet()) {
                    if (str != null) {
                        jSONObject2.put(str, map.get(str));
                    }
                }
                AppMethodBeat.o(117749);
                return jSONObject2;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e2.getMessage());
                AppMethodBeat.o(117749);
                return null;
            }
        }
    }
}
