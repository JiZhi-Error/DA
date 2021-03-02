package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import com.google.android.gms.common.internal.Constants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.jsapi.r.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.k;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.d;
import java.util.Map;

public final class a {
    private boolean Fdd;
    GameWebViewUI JpT;
    private h JpU;
    e JpV;
    h JpW;
    com.tencent.mm.plugin.wepkg.e JpX;
    b JpY;
    private C1994a JpZ;
    k Jqa;
    m Jqb = new m() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final void aM(Bundle bundle) {
            AppMethodBeat.i(80825);
            Log.i("MicroMsg.GameFloatWebView", "closeWindow");
            try {
                a.this.WN.removeView(a.this.iGY);
                a.this.onDestroy();
                AppMethodBeat.o(80825);
            } catch (Exception e2) {
                AppMethodBeat.o(80825);
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final Bundle j(int i2, final Bundle bundle) {
            int init;
            AppMethodBeat.i(80826);
            Log.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(i2)));
            final Bundle bundle2 = new Bundle();
            switch (i2) {
                case 18:
                    bundle2.putString("KPublisherId", h.eam);
                    bundle2.putInt("getA8KeyScene", a.this.gy(h.JrK, h.ehX));
                    break;
                case 37:
                    final String string = bundle.getString("show_kb_placeholder");
                    final int i3 = bundle.getInt("show_kb_max_length");
                    final int i4 = bundle.getInt("show_kb_show_remind_word_count");
                    a.this.JpT.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(80821);
                            a.this.JpT.aG(string, i3, i4);
                            AppMethodBeat.o(80821);
                        }
                    });
                    break;
                case 43:
                    final String string2 = bundle.getString("set_page_title_text");
                    final int gw = com.tencent.mm.plugin.webview.ui.tools.e.gw(bundle.getString("set_page_title_color"), a.this.JpT.getResources().getColor(R.color.bk));
                    a.this.JpT.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass4.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(80823);
                            if (string2 != null) {
                                a.this.JpT.setMMTitle(string2);
                            }
                            a.this.JpT.setMMTitleColor(gw);
                            AppMethodBeat.o(80823);
                        }
                    });
                    break;
                case 53:
                    a.this.JpT.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass4.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(80824);
                            a.this.JpT.bb(bundle);
                            AppMethodBeat.o(80824);
                        }
                    });
                    break;
                case 54:
                    boolean z = bundle.getBoolean("add_shortcut_status");
                    if (a.this.JpW != null) {
                        a.this.JpW.yX(z);
                        break;
                    }
                    break;
                case 79:
                    a.this.JpT.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass4.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(80822);
                            bundle2.putInt("height", a.this.JpT.gfz());
                            AppMethodBeat.o(80822);
                        }
                    });
                    break;
                case f.CTRL_INDEX:
                    CharSequence mMTitle = a.this.JpT.getMMTitle();
                    String currentUrl = getCurrentUrl();
                    bundle2.putString("webview_current_url", currentUrl);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", currentUrl);
                    break;
                case 87:
                    boolean gio = a.this.JpY.gio();
                    String coy = a.this.JpY.coy();
                    Map gip = a.this.JpY.gip();
                    if (gio) {
                        bundle2.putString("result", "not_return");
                        break;
                    } else {
                        bundle2.putString("full_url", Util.nullAsNil(coy));
                        if (gip != null && gip.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            d.lA(MMApplicationContext.getContext());
                            com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
                            for (String str : gip.keySet()) {
                                hsp.setCookie(Util.nullAsNil(coy), str + "=" + ((String) gip.get(str)));
                            }
                            d.hsr();
                            d.sync();
                            Log.i("MicroMsg.GameFloatWebView", "cookies:%s", hsp.getCookie(Util.nullAsNil(coy)));
                            break;
                        } else {
                            bundle2.putInt("set_cookie", 0);
                            break;
                        }
                    }
                    break;
                case PlayerException.EXCEPTION_IN_SEEK /*{ENCODED_INT: 95}*/:
                    a.this.xyK.Jqh.bm(bundle);
                    Log.i("MicroMsg.GameFloatWebView", "set game float page time data");
                    break;
                case 99:
                    int i5 = h.ehX;
                    bundle2.putInt("geta8key_scene", i5);
                    Log.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", Integer.valueOf(i5));
                    break;
                case 101:
                    bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                    com.tencent.mm.br.c.b(a.this.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.eam));
                    break;
                case 252:
                    a.this.xyv.hhB = 1;
                    a.this.xyM.Jra = System.currentTimeMillis();
                    break;
                case 253:
                    a.this.xyM.Jrb = System.currentTimeMillis();
                    break;
                case 5001:
                    if (a.this.JpV.isSDCardAvailable()) {
                        long availableExternalMemorySize2 = SdcardUtil.getAvailableExternalMemorySize2();
                        Log.i("MicroMsg.GameFloatWebView", "availableSize = %d", Long.valueOf(availableExternalMemorySize2));
                        if (availableExternalMemorySize2 < 524288000) {
                            Log.e("MicroMsg.GameFloatWebView", "available size not enough");
                        } else {
                            o oVar = new o(com.tencent.mm.plugin.webview.a.IJo);
                            boolean z2 = true;
                            if (!oVar.exists()) {
                                z2 = oVar.mkdirs();
                                Log.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", aa.z(oVar.her()), Boolean.valueOf(z2));
                            }
                            if (z2) {
                                init = FactoryProxyManager.getPlayManager().init(a.this.mContext, q.k(aa.z(oVar.her()), false));
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    } else {
                        Log.i("MicroMsg.GameFloatWebView", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    String string3 = bundle.getString("webview_video_proxy_cdn_urls");
                    String string4 = bundle.getString("webview_video_proxy_fileId");
                    int i6 = bundle.getInt("webview_video_proxy_file_size");
                    int i7 = bundle.getInt("webview_video_proxy_file_duration");
                    int i8 = bundle.getInt("webview_video_proxy_file_type");
                    int startPlay = FactoryProxyManager.getPlayManager().startPlay(string3, i8, string4, (long) i6, i7);
                    String buildPlayURLMp4 = FactoryProxyManager.getPlayManager().buildPlayURLMp4(startPlay);
                    Log.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", string3, string4, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(startPlay), buildPlayURLMp4);
                    bundle2.putInt("webview_video_proxy_play_data_id", startPlay);
                    bundle2.putString("webview_video_proxy_local_url", buildPlayURLMp4);
                    break;
                case 5003:
                    int i9 = bundle.getInt("webview_video_proxy_play_data_id");
                    Log.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", Integer.valueOf(i9));
                    if (i9 > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(i9);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    int i10 = bundle.getInt("webview_video_proxy_play_data_id");
                    int i11 = bundle.getInt("webview_video_proxy_preload_duration");
                    Log.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", Integer.valueOf(i10), Integer.valueOf(i11));
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(i10, i11));
                    break;
                case TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE:
                    boolean z3 = bundle.getBoolean("clear_webview_cache_clear_cookie", false);
                    Log.i("MicroMsg.GameFloatWebView", "includeCookie = %b", Boolean.valueOf(z3));
                    Intent intent = new Intent();
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent.putExtra("tools_clean_webview_cache_ignore_cookie", z3);
                    com.tencent.mm.cr.d.bJ(intent);
                    break;
                case 90001:
                    String currentUrl2 = getCurrentUrl();
                    String cookie = com.tencent.xweb.c.hsp().getCookie(currentUrl2);
                    Log.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", currentUrl2, cookie);
                    bundle2.putString("cookie", cookie);
                    bundle2.putFloat(Constants.PARAM_DENSITY, com.tencent.mm.cb.a.getDensity(a.this.JpT));
                    break;
                case 90002:
                    l.Jhd.me(bundle.getString("traceid"), bundle.getString(ch.COL_USERNAME));
                    break;
                default:
                    Log.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                    break;
            }
            AppMethodBeat.o(80826);
            return bundle2;
        }
    };
    ViewGroup WN;
    MMWebView iGY;
    Context mContext;
    c xyK = new c() {
        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.webview.ui.tools.game.c
        public final void an(Bundle bundle) {
            AppMethodBeat.i(80818);
            try {
                if (!(a.this.JpV == null || bundle == null)) {
                    a.this.JpV.j(96, bundle);
                }
                AppMethodBeat.o(80818);
            } catch (RemoteException e2) {
                AppMethodBeat.o(80818);
            }
        }
    };
    long xyL;
    g xyM;
    String xyo;
    GameWebPerformanceInfo xyv;

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup, String str) {
        AppMethodBeat.i(80844);
        this.xyv = GameWebPerformanceInfo.Fe(str);
        this.xyv.url = str;
        this.xyv.hhu = (gameWebViewUI.hashCode() & Integer.MAX_VALUE) + "_" + (str.hashCode() & Integer.MAX_VALUE);
        long currentTimeMillis = System.currentTimeMillis();
        this.xyv.startTime = gameWebViewUI.getIntent().getLongExtra("start_time", currentTimeMillis);
        this.xyv.hhF = gameWebViewUI.getIntent().getLongExtra("start_activity_time", currentTimeMillis);
        this.xyv.hhK = currentTimeMillis;
        this.xyv.hhM = currentTimeMillis;
        this.xyM = g.baJ(str);
        this.xyM.startTime = System.currentTimeMillis();
        this.mContext = gameWebViewUI;
        this.JpT = gameWebViewUI;
        this.WN = viewGroup;
        MMWebViewWithJsApi hZ = MMWebViewWithJsApi.a.hZ(this.mContext);
        hZ.setBackgroundResource(17170445);
        hZ.setBackgroundColor(0);
        hZ.setVisibility(4);
        this.JpY = new b(hZ);
        hZ.setWebViewClient(this.JpY);
        this.JpZ = new C1994a(hZ);
        hZ.setWebChromeClient(this.JpZ);
        Log.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", Integer.valueOf(hZ.hashCode()), Integer.valueOf(this.JpY.hashCode()));
        if (hZ.getIsX5Kernel()) {
            hZ.setWebViewClientExtension(new c(this, (byte) 0));
        }
        hZ.getSettings().setJavaScriptEnabled(true);
        hZ.getSettings().hsU();
        hZ.getSettings().setBuiltInZoomControls(false);
        hZ.getSettings().setUseWideViewPort(true);
        hZ.getSettings().setLoadWithOverviewMode(true);
        hZ.getSettings().hsN();
        hZ.getSettings().hsM();
        hZ.getSettings().setGeolocationEnabled(true);
        hZ.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        hZ.getSettings().hsW();
        hZ.getSettings().hsS();
        hZ.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        hZ.getSettings().hsR();
        hZ.getSettings().hsT();
        hZ.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
        com.tencent.xweb.c.hsp().hsq();
        com.tencent.xweb.c.hsp().e(hZ);
        this.iGY = hZ;
        this.JpU = new h(gameWebViewUI.getIntent());
        this.JpX = new com.tencent.mm.plugin.wepkg.e();
        this.JpX.JLI = new com.tencent.mm.plugin.wepkg.event.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wepkg.event.b
            public final void dTT() {
                AppMethodBeat.i(80819);
                Log.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", a.this.xyo);
                if (!(a.this.iGY == null || a.this.iGY.getParent() == null || a.this.JpY == null || Util.isNullOrNil(a.this.xyo))) {
                    a.this.iGY.stopLoading();
                    a.this.iGY.loadUrl(a.this.JpY.coy());
                }
                AppMethodBeat.o(80819);
            }
        };
        this.xyv.hhN = System.currentTimeMillis();
        this.xyM.JqV = System.currentTimeMillis();
        AppMethodBeat.o(80844);
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$a  reason: collision with other inner class name */
    class C1994a extends i {
        C1994a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        @Override // com.tencent.xweb.x
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(80827);
            if (a.this.JpX != null) {
                a.this.JpX.a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(80827);
            return onConsoleMessage;
        }
    }

    class b extends b {
        public b(MMWebView mMWebView) {
            super(mMWebView);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(80828);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (a.this.xyv.hhQ == 0) {
                a.this.xyv.hhQ = currentTimeMillis;
            }
            if (a.this.xyM.JqW == 0) {
                a.this.xyM.JqW = currentTimeMillis;
            }
            a.this.xyK.Jqh.ghf();
            a.this.JpX.bcg(str);
            AppMethodBeat.o(80828);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void f(WebView webView, String str) {
            AppMethodBeat.i(80829);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (a.this.xyv.hhR == 0) {
                a.this.xyv.hhR = currentTimeMillis;
            }
            if (a.this.xyM.JqX == 0) {
                a.this.xyM.JqX = currentTimeMillis;
            }
            if (a.this.xyv.hhL == 0) {
                a.this.xyv.hhL = currentTimeMillis;
                a.this.xyL = currentTimeMillis;
            }
            this.iGY.setVisibility(0);
            a.this.JpX.bch(str);
            a.this.xyK.Jqh.LZ();
            AppMethodBeat.o(80829);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(e eVar, g gVar) {
            a.this.JpV = eVar;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void a(h hVar) {
            AppMethodBeat.i(211311);
            Log.i("MicroMsg.GameFloatWebView", "jsapi ready");
            a.this.JpW = hVar;
            AppMethodBeat.o(211311);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void b(k kVar) {
            AppMethodBeat.i(211312);
            Log.i("MicroMsg.GameFloatWebView", "jsloader ready");
            a.this.Jqa = kVar;
            AppMethodBeat.o(211312);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final boolean baF(String str) {
            AppMethodBeat.i(80832);
            boolean bci = a.this.JpX.bci(str);
            AppMethodBeat.o(80832);
            return bci;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final String getSource() {
            return h.eam;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void azM(String str) {
            AppMethodBeat.i(80833);
            if (a.this.JpX.gkw()) {
                this.iGY.loadUrl(str);
                AppMethodBeat.o(80833);
                return;
            }
            super.azM(str);
            AppMethodBeat.o(80833);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.mm.plugin.webview.ui.tools.game.b
        public final boolean baG(String str) {
            AppMethodBeat.i(80834);
            boolean baG = super.baG(str);
            AppMethodBeat.o(80834);
            return baG;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void baH(String str) {
            AppMethodBeat.i(80835);
            try {
                Log.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", str);
                a.this.WN.removeView(this.iGY);
                AppMethodBeat.o(80835);
            } catch (Exception e2) {
                AppMethodBeat.o(80835);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void ghd() {
            AppMethodBeat.i(80836);
            if (Build.VERSION.SDK_INT >= 11) {
                this.iGY.removeJavascriptInterface("MicroMsg");
                this.iGY.removeJavascriptInterface("JsApi");
            }
            try {
                this.iGY.setWebChromeClient(null);
                this.iGY.setWebViewClient(null);
                this.iGY.setOnTouchListener(null);
                this.iGY.setOnLongClickListener(null);
                this.iGY.setVisibility(8);
                this.iGY.removeAllViews();
                this.iGY.clearView();
            } catch (Exception e2) {
                Log.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", e2.getMessage());
            }
            try {
                this.iGY.destroy();
                AppMethodBeat.o(80836);
            } catch (Exception e3) {
                Log.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", e3.getMessage());
                AppMethodBeat.o(80836);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final m bLB() {
            return a.this.Jqb;
        }

        @Override // com.tencent.xweb.ac
        public final WebResourceResponse c(WebView webView, String str) {
            AppMethodBeat.i(80837);
            WebResourceResponse p = a.this.JpX.p(webView, str);
            if (p != null) {
                AppMethodBeat.o(80837);
                return p;
            }
            WebResourceResponse c2 = super.c(webView, str);
            AppMethodBeat.o(80837);
            return c2;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.xweb.ac
        public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(80838);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                WebResourceResponse a2 = super.a(webView, webResourceRequest);
                AppMethodBeat.o(80838);
                return a2;
            }
            WebResourceResponse p = a.this.JpX.p(webView, webResourceRequest.getUrl().toString());
            if (p != null) {
                AppMethodBeat.o(80838);
                return p;
            }
            WebResourceResponse a3 = super.a(webView, webResourceRequest);
            AppMethodBeat.o(80838);
            return a3;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.xweb.ac
        public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(80839);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                WebResourceResponse a2 = super.a(webView, webResourceRequest);
                AppMethodBeat.o(80839);
                return a2;
            }
            WebResourceResponse p = a.this.JpX.p(webView, webResourceRequest.getUrl().toString());
            if (p != null) {
                AppMethodBeat.o(80839);
                return p;
            }
            WebResourceResponse a3 = super.a(webView, webResourceRequest, bundle);
            AppMethodBeat.o(80839);
            return a3;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k, com.tencent.mm.plugin.webview.ui.tools.game.b
        public final void ghe() {
            AppMethodBeat.i(80840);
            a.this.xyv.hhP = System.currentTimeMillis();
            super.ghe();
            AppMethodBeat.o(80840);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final void av(String str, boolean z) {
            AppMethodBeat.i(80841);
            long currentTimeMillis = System.currentTimeMillis();
            if (a.this.xyv.hhS == 0) {
                a.this.xyv.hhS = currentTimeMillis;
            }
            if (a.this.xyM.JqY == 0) {
                a.this.xyM.JqY = currentTimeMillis;
            }
            super.av(str, z);
            AppMethodBeat.o(80841);
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
        public final boolean bk(Bundle bundle) {
            AppMethodBeat.i(80842);
            long currentTimeMillis = System.currentTimeMillis();
            if (a.this.xyv.hhT == 0) {
                a.this.xyv.hhT = currentTimeMillis;
            }
            if (a.this.xyM.JqZ == 0) {
                a.this.xyM.JqZ = currentTimeMillis;
            }
            boolean bk = super.bk(bundle);
            AppMethodBeat.o(80842);
            return bk;
        }
    }

    class c extends com.tencent.xweb.x5.export.external.extension.proxy.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(80843);
            Object onMiscCallBack = a.this.JpX.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                AppMethodBeat.o(80843);
                return onMiscCallBack;
            }
            Object onMiscCallBack2 = super.onMiscCallBack(str, bundle);
            AppMethodBeat.o(80843);
            return onMiscCallBack2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int gy(String str, int i2) {
        AppMethodBeat.i(80845);
        if (i2 == 0) {
            if (str == null || str.length() <= 0) {
                i2 = 0;
            } else if (this.JpV == null) {
                i2 = 1;
            } else {
                try {
                    if (this.JpV.JE(str)) {
                        i2 = 8;
                    } else {
                        i2 = this.JpV.IT(str) ? 7 : 1;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e2.getMessage());
                    i2 = 1;
                }
            }
        }
        Log.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", Integer.valueOf(i2));
        AppMethodBeat.o(80845);
        return i2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(80846);
        if (!this.Fdd) {
            Log.i("MicroMsg.GameFloatWebView", "onDestroy");
            this.Fdd = true;
            c.a(c.this);
            this.JpX.zE(true);
            if (this.iGY != null) {
                this.iGY.setWebViewClient(null);
                this.iGY.setWebChromeClient(null);
            }
            this.xyv.hhU += System.currentTimeMillis() - this.xyL;
            this.xyv.hhV = System.currentTimeMillis();
            com.tencent.mm.game.report.api.a.hhr.a(this.xyv);
            GameWebPerformanceInfo.Ff(this.xyo);
            g.baM(this.xyo);
        }
        AppMethodBeat.o(80846);
    }
}
