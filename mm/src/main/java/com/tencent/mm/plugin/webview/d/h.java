package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.xweb.c;
import com.tencent.xweb.z;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements b, c, d, com.tencent.mm.plugin.webview.d.d.a {
    private static final int IRd = (d.oE(19) ? 200 : 20);
    private final LinkedList<n> FoQ = new LinkedList<>();
    public boolean GBl = false;
    public e IKO = null;
    private JSONArray IRA = new JSONArray();
    private List<String> IRB = new LinkedList();
    private MTimerHandler IRC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass31 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(224242);
            h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.a("onBeaconsInRange", h.this.IRz, h.this.IRj, h.this.zpY) + ")", null);
            h.this.IRB.clear();
            h.this.IRz = new JSONObject();
            h.this.IRA = new JSONArray();
            AppMethodBeat.o(224242);
            return false;
        }
    }, false);
    public long IRD = 0;
    private k IRE;
    public MMWebView IRa;
    private Context IRe;
    private final List<String> IRf = new LinkedList();
    private MMHandler IRg = null;
    private boolean IRh = false;
    private g IRi;
    public boolean IRj = false;
    public boolean IRk = false;
    public int IRl;
    private a IRm;
    private Set<String> IRn = null;
    private boolean IRo = false;
    public String IRp;
    private com.tencent.mm.plugin.webview.d.b.a IRq = null;
    private JsapiPermissionWrapper IRr;
    private Bundle IRs;
    private boolean IRt = false;
    public String IRu;
    public String IRv;
    private final List<String> IRw = new LinkedList();
    volatile String IRx = null;
    volatile int IRy = 0;
    private JSONObject IRz = new JSONObject();
    public Map<String, Object> dVU;
    HashMap<String, b> hdu = new HashMap<>();
    public e mHh;
    public String zpY = "";

    public interface a {
        boolean b(n nVar);
    }

    static /* synthetic */ boolean O(String str, Map map) {
        AppMethodBeat.i(224403);
        boolean N = N(str, map);
        AppMethodBeat.o(224403);
        return N;
    }

    static /* synthetic */ String a(h hVar, String str) {
        AppMethodBeat.i(224402);
        String aYk = hVar.aYk(str);
        AppMethodBeat.o(224402);
        return aYk;
    }

    static /* synthetic */ boolean lW(String str, String str2) {
        AppMethodBeat.i(224404);
        boolean lV = lV(str, str2);
        AppMethodBeat.o(224404);
        return lV;
    }

    static {
        AppMethodBeat.i(224405);
        AppMethodBeat.o(224405);
    }

    public h() {
        AppMethodBeat.i(224296);
        AppMethodBeat.o(224296);
    }

    public h(MMWebView mMWebView, g gVar, int i2) {
        AppMethodBeat.i(224297);
        this.IRa = mMWebView;
        this.IRi = gVar;
        this.IRl = i2;
        gaS();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(mMWebView == null ? 0 : mMWebView.hashCode());
        objArr[1] = Integer.valueOf(hashCode());
        Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d", objArr);
        AppMethodBeat.o(224297);
    }

    public h(MMWebView mMWebView, g gVar, int i2, e eVar) {
        AppMethodBeat.i(224298);
        this.IRa = mMWebView;
        this.IRi = gVar;
        this.IRl = i2;
        this.IKO = eVar;
        gaS();
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(mMWebView == null ? 0 : mMWebView.hashCode());
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = eVar;
        Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, jsApiPool: %s", objArr);
        AppMethodBeat.o(224298);
    }

    public h(MMWebView mMWebView, g gVar, int i2, Set<String> set) {
        AppMethodBeat.i(224299);
        this.IRa = mMWebView;
        this.IRi = gVar;
        this.IRl = i2;
        this.IRn = set == null ? new HashSet<>() : set;
        this.IRo = true;
        gaS();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(mMWebView == null ? 0 : mMWebView.hashCode());
        objArr[1] = Integer.valueOf(hashCode());
        Log.i("MicroMsg.JsApiHandler", "Abe-Debug JsApiHandler<init>, webview: %d, this: %d, limitedJsApiListModeEnable = true", objArr);
        AppMethodBeat.o(224299);
    }

    public final void a(a aVar) {
        this.IRm = aVar;
    }

    private void gaS() {
        AppMethodBeat.i(224300);
        this.IRg = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(224212);
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!Util.isNullOrNil(str)) {
                            h.this.IRf.add(str);
                        }
                        h.c(h.this);
                        AppMethodBeat.o(224212);
                        return;
                    case 2:
                        Log.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        break;
                }
                AppMethodBeat.o(224212);
            }
        };
        AppMethodBeat.o(224300);
    }

    public final z getSettings() {
        AppMethodBeat.i(224301);
        z settings = this.IRa.getSettings();
        AppMethodBeat.o(224301);
        return settings;
    }

    public final void b(e eVar) {
        this.mHh = eVar;
    }

    public final int getBinderID() {
        return this.IRl;
    }

    public final void gaT() {
        AppMethodBeat.i(224302);
        if (!this.IRj) {
            this.IRj = true;
            this.zpY = b.eP(this.IRa.getRandomStr()) ? Util.getRandomString(16) : this.IRa.getRandomStr();
            Log.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s, hashCode: %d", this.zpY, Integer.valueOf(hashCode()));
        }
        AppMethodBeat.o(224302);
    }

    public final void gaU() {
        AppMethodBeat.i(224303);
        this.IRj = true;
        this.zpY = Util.getRandomString(16);
        this.IRa.setRandomStr(this.zpY);
        Log.i("MicroMsg.JsApiHandler", "js digest updateDgtVerify randomStr = %s, hashCode: %d", this.zpY, Integer.valueOf(hashCode()));
        AppMethodBeat.o(224303);
    }

    public final String gaV() {
        return this.zpY;
    }

    public final void bG(Map<String, Object> map) {
        this.dVU = map;
    }

    public final void cL(String str, boolean z) {
        AppMethodBeat.i(224304);
        try {
            this.mHh.l(str, z, this.IRl);
            AppMethodBeat.o(224304);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = ".concat(String.valueOf(e2)));
            AppMethodBeat.o(224304);
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public void _sendMessage(String str) {
        AppMethodBeat.i(224305);
        Log.d("MicroMsg.JsApiHandler", "_sendMessage");
        if (this.IRg != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.IRg.sendMessage(obtain);
            AppMethodBeat.o(224305);
            return;
        }
        Log.e("MicroMsg.JsApiHandler", "msgQueueHandler err");
        AppMethodBeat.o(224305);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public boolean _isDgtVerifyEnabled() {
        return this.IRj;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public String _getDgtVerifyRandomStr() {
        AppMethodBeat.i(224308);
        if (!com.tencent.mm.pluginsdk.ui.tools.z.gsL() || this.IRk) {
            String str = this.zpY;
            AppMethodBeat.o(224308);
            return str;
        }
        AppMethodBeat.o(224308);
        return "";
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public void _ready(boolean z) {
        this.GBl = z;
    }

    public final com.tencent.mm.plugin.webview.d.b.a gaW() {
        AppMethodBeat.i(224309);
        if (this.IRq == null) {
            this.IRq = new com.tencent.mm.plugin.webview.d.b.a();
        }
        this.IRq.IQP = this.IRa;
        com.tencent.mm.plugin.webview.d.b.a aVar = this.IRq;
        AppMethodBeat.o(224309);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.webview.d.d.a
    public final boolean aXK(String str) {
        AppMethodBeat.i(224310);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(224310);
            return false;
        }
        boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, "weixin://dispatch_message/");
        AppMethodBeat.o(224310);
        return C;
    }

    @Override // com.tencent.mm.plugin.webview.d.d.a
    public final boolean aXJ(final String str) {
        AppMethodBeat.i(224311);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass12 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(224223);
                Log.i("MicroMsg.JsApiHandler", "handle url %s, re %s", str, str);
                AppMethodBeat.o(224223);
            }
        });
        AppMethodBeat.o(224311);
        return true;
    }

    public final void gaX() {
        AppMethodBeat.i(224312);
        if (this.IRj && com.tencent.mm.pluginsdk.ui.tools.z.gsL()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__event_id", "sys:updateRandomStr");
                jSONObject2.put("randomStr", this.zpY);
                jSONObject.put("__json_message", jSONObject2);
                this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + jSONObject.toString() + ")", new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass44 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(224255);
                        Log.i("MicroMsg.JsApiHandler", "sys:updateRandomStr back %s\t", str);
                        AppMethodBeat.o(224255);
                    }
                });
                AppMethodBeat.o(224312);
                return;
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(224312);
    }

    public final boolean isReady() {
        return this.GBl;
    }

    public final void yV(boolean z) {
        AppMethodBeat.i(224313);
        this.GBl = z;
        Log.i("MicroMsg.JsApiHandler", "js ready %b", Boolean.valueOf(z));
        AppMethodBeat.o(224313);
    }

    public final void yW(boolean z) {
        AppMethodBeat.i(224314);
        this.IRh = z;
        Log.i("MicroMsg.JsApiHandler", "setIsFloating %b", Boolean.valueOf(z));
        AppMethodBeat.o(224314);
    }

    public final void gaY() {
        AppMethodBeat.i(224315);
        Log.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", Boolean.valueOf(this.GBl));
        if (this.IRa != null && this.GBl) {
            this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:attach_runOn3rd_apis", gaZ(), this.IRj, this.zpY) + ")", new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass55 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(224267);
                    Log.i("MicroMsg.JsApiHandler", "sys:attach_runOn3rd_apis back %s\t", str);
                    AppMethodBeat.o(224267);
                }
            });
        }
        AppMethodBeat.o(224315);
    }

    private Map<String, Object> gaZ() {
        AppMethodBeat.i(224316);
        HashMap hashMap = new HashMap();
        JsapiPermissionWrapper gdH = this.IRi.gdH();
        LinkedList linkedList = new LinkedList();
        if (gdH != null) {
            if (gdH.pP(88)) {
                linkedList.add("menu:share:timeline");
            }
            if (gdH.pP(89)) {
                linkedList.add("menu:share:appmessage");
            }
            if (gdH.pP(94)) {
                linkedList.add("menu:share:qq");
            }
            if (gdH.pP(109)) {
                linkedList.add("menu:share:weiboApp");
            }
            if (gdH.pP(com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX)) {
                linkedList.add("menu:share:QZone");
            }
            if (gdH.pP(TbsListener.ErrorCode.RENAME_EXCEPTION)) {
                linkedList.add("sys:record");
            }
            linkedList.add("onVoiceRecordEnd");
            linkedList.add("onVoicePlayBegin");
            linkedList.add("onVoicePlayEnd");
            linkedList.add("onLocalImageUploadProgress");
            linkedList.add("onImageDownloadProgress");
            linkedList.add("onVoiceUploadProgress");
            linkedList.add("onVoiceDownloadProgress");
            linkedList.add("onVideoUploadProgress");
            linkedList.add("onPlayerProcessStateChanged");
            linkedList.add("onMediaFileUploadProgress");
            linkedList.add("menu:setfont");
            linkedList.add("menu:haokan");
            linkedList.add("topbar:click");
            linkedList.add("reportOnLeaveForMP");
            linkedList.add("onMPPageAction");
            linkedList.add("onMPVideoStateChange");
            linkedList.add("onReceiveMPPageData");
            linkedList.add("onMPAdWebviewStateChange");
            linkedList.add("onScreenShot");
            linkedList.add("menu:share:email");
            linkedList.add("wxdownload:state_change");
            linkedList.add("wxdownload:progress_change");
            linkedList.add("hdOnDeviceStateChanged");
            linkedList.add("activity:state_change");
            linkedList.add("onWindowFocusChanged");
            linkedList.add("onVideoPlay");
            linkedList.add("onVideoPause");
            linkedList.add("onVideoEnded");
            linkedList.add("onVideoWaiting");
            linkedList.add("onVideoBufferUpdate");
            linkedList.add("onVideoTimeUpdate");
            linkedList.add("onVideoError");
            linkedList.add("onVideoLoadedMetaData");
            linkedList.add("onEnterFullscreen");
            linkedList.add("onExitFullscreen");
            linkedList.add("onOrientationsChange");
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
            linkedList.add("onMenuClick");
            linkedList.add("onSearchWAWidgetOpenApp");
            linkedList.add("onSearchDataReady");
            linkedList.add("onCurrentLocationReady");
            linkedList.add("onClientNavAction");
            linkedList.add("onNavBarShadowManuallyHidden");
            linkedList.add("onChatSearchDataReady");
            linkedList.add("onGetPoiInfoReturn");
            linkedList.add("onSearchHistoryReady");
            linkedList.add("onSearchWAWidgetOnTapCallback");
            linkedList.add("onSearchImageListReady");
            linkedList.add("onTeachSearchDataReady");
            linkedList.add("onSearchGuideDataReady");
            linkedList.add("onUxOplogDataReady");
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
            linkedList.add("onGetVertSearchEntriesData");
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
            linkedList.add("onMiniProgramData");
            linkedList.add("onBackgroundAudioStateChange");
            linkedList.add("onArticleReadingBtnClicked");
            if (!Util.isNullOrNil((List) null)) {
                linkedList.addAll(null);
            }
            linkedList.add("onReceivePageData");
            linkedList.add("onPageAuthOK");
            linkedList.add("onScrollViewDidScroll");
            linkedList.add("onPublishHaowanEnd");
            linkedList.add("onPublishHaowanProgress");
        }
        hashMap.put("__runOn3rd_apis", new JSONArray((Collection) linkedList));
        AppMethodBeat.o(224316);
        return hashMap;
    }

    private boolean gba() {
        AppMethodBeat.i(224317);
        boolean z = false;
        try {
            z = this.mHh.agw(this.IRl);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e2.getMessage());
        }
        Log.i("MicroMsg.JsApiHandler", "checkIsMsgQueueBusy isBusy = ".concat(String.valueOf(z)));
        AppMethodBeat.o(224317);
        return z;
    }

    private void gbb() {
        AppMethodBeat.i(224318);
        do {
        } while (gbc());
        AppMethodBeat.o(224318);
    }

    private boolean gbc() {
        boolean z;
        AppMethodBeat.i(224319);
        if (Util.isNullOrNil(this.FoQ)) {
            Log.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            AppMethodBeat.o(224319);
            return false;
        }
        try {
            z = this.mHh.agw(this.IRl);
        } catch (Exception e2) {
            Log.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e2.getMessage());
            z = false;
        }
        Log.i("MicroMsg.JsApiHandler", "dealNextMsg isBusy = ".concat(String.valueOf(z)));
        if (z) {
            Log.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            AppMethodBeat.o(224319);
            return false;
        } else if (this.FoQ.size() == 0) {
            Log.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            AppMethodBeat.o(224319);
            return false;
        } else {
            n remove = this.FoQ.remove(0);
            if (remove == null) {
                Log.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                AppMethodBeat.o(224319);
                return true;
            }
            boolean a2 = a(remove, remove.IBv, remove.IRs, remove.IBt);
            AppMethodBeat.o(224319);
            return a2;
        }
    }

    public final void a(JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle) {
        this.IRr = jsapiPermissionWrapper;
        this.IRs = bundle;
        this.IRt = true;
    }

    @Override // com.tencent.mm.plugin.webview.d.d
    public final void a(n nVar, b bVar) {
        AppMethodBeat.i(224320);
        a(nVar, this.IRr, this.IRs, bVar);
        AppMethodBeat.o(224320);
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, Bundle bundle, b bVar) {
        AppMethodBeat.i(224321);
        final n remove = n.a.k("[" + str + "]", false, this.zpY).remove(0);
        if (remove == null || !gba() || this.IRg == null) {
            a(remove, jsapiPermissionWrapper, bundle, bVar);
            AppMethodBeat.o(224321);
            return;
        }
        remove.IRs = bundle;
        remove.IBv = jsapiPermissionWrapper;
        remove.IBt = bVar;
        this.IRg.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass75 */

            public final void run() {
                AppMethodBeat.i(224287);
                h.a(h.this, remove);
                AppMethodBeat.o(224287);
            }
        });
        AppMethodBeat.o(224321);
    }

    /* JADX WARNING: Removed duplicated region for block: B:154:0x052a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(final com.tencent.mm.plugin.webview.d.n r12, com.tencent.mm.protocal.JsapiPermissionWrapper r13, android.os.Bundle r14, com.tencent.mm.plugin.webview.d.b r15) {
        /*
        // Method dump skipped, instructions count: 1421
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.d.h.a(com.tencent.mm.plugin.webview.d.n, com.tencent.mm.protocal.JsapiPermissionWrapper, android.os.Bundle, com.tencent.mm.plugin.webview.d.b):boolean");
    }

    public final Context getContext() {
        AppMethodBeat.i(224323);
        if (this.IRt) {
            if (this.IRe != null) {
                Context context = this.IRe;
                AppMethodBeat.o(224323);
                return context;
            }
            Context context2 = MMApplicationContext.getContext();
            AppMethodBeat.o(224323);
            return context2;
        } else if (this.IRa == null) {
            AppMethodBeat.o(224323);
            return null;
        } else {
            Context activityContextIfHas = this.IRa.getActivityContextIfHas();
            AppMethodBeat.o(224323);
            return activityContextIfHas;
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.d
    public final void eQ(Context context) {
        this.IRe = context;
    }

    public final String aXZ(String str) {
        AppMethodBeat.i(224324);
        Context context = getContext();
        if (context instanceof com.tencent.mm.plugin.webview.core.b) {
            String aXD = ((com.tencent.mm.plugin.webview.core.b) context).aXD(str);
            AppMethodBeat.o(224324);
            return aXD;
        }
        AppMethodBeat.o(224324);
        return "";
    }

    public final void detach() {
        AppMethodBeat.i(224325);
        gbj();
        this.GBl = false;
        this.FoQ.clear();
        this.IRf.clear();
        this.IRg = null;
        AppMethodBeat.o(224325);
    }

    public final void aYa(String str) {
        this.IRu = str;
    }

    public final void aYb(String str) {
        this.IRv = str;
    }

    public final void afL(int i2) {
        AppMethodBeat.i(224326);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            AppMethodBeat.o(224326);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fontSize", String.valueOf(i2));
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:setfont", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224326);
    }

    public final void w(int i2, String str, int i3) {
        AppMethodBeat.i(224327);
        if (!this.GBl) {
            AppMethodBeat.o(224327);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("recommend", Integer.valueOf(i2));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_COMMENT, str);
        hashMap.put("scene", Integer.valueOf(i3));
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:haokan", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224327);
    }

    public final void a(String str, int i2, String str2, int i3, int i4) {
        AppMethodBeat.i(224328);
        if (!this.GBl) {
            AppMethodBeat.o(224328);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        hashMap.put("personal_comment_id", Integer.valueOf(i2));
        if ("praiseComment".equals(str)) {
            hashMap.put("reply_id", Integer.valueOf(i3));
            hashMap.put("is_like", Integer.valueOf(i4));
        } else {
            hashMap.put("replyId", Integer.valueOf(i3));
            hashMap.put(Scopes.OPEN_ID, str2);
        }
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPPageAction", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224328);
    }

    public final void gh(String str, int i2) {
        AppMethodBeat.i(224329);
        if (!this.GBl) {
            AppMethodBeat.o(224329);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("videoVid", str);
        hashMap.put("videoCurrTime", Integer.valueOf(i2));
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "onExitMpVideoFullPage");
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPPageAction", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224329);
    }

    public final void lT(String str, String str2) {
        AppMethodBeat.i(224330);
        if (!this.GBl) {
            AppMethodBeat.o(224330);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("videoVid", str);
        hashMap.put("result", str2);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "onEmbedMpVideoShare");
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPPageAction", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224330);
    }

    public final void gi(String str, int i2) {
        AppMethodBeat.i(224331);
        if (!this.GBl) {
            AppMethodBeat.o(224331);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        hashMap.put("shareFuncFlag", Integer.valueOf(i2));
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPPageAction", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224331);
    }

    public final void P(int i2, int i3, String str) {
        AppMethodBeat.i(224332);
        if (!this.GBl) {
            Log.w("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224332);
            return;
        }
        Log.d("MicroMsg.JsApiHandler", "onMPDotWebviewStateChange");
        HashMap hashMap = new HashMap();
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, "onMPDotWebviewStateChange");
        hashMap.put("id", Integer.valueOf(i2));
        hashMap.put("webviewId", Integer.valueOf(i3));
        hashMap.put("state", str);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPPageAction", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224332);
    }

    public final void j(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(224333);
        if (!this.GBl) {
            AppMethodBeat.o(224333);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("state", str);
        hashMap.put("vid", str2);
        hashMap.put("errMsg", str3);
        hashMap.put("currentTime", str4);
        hashMap.put("playedTotalTime", str5);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPVideoStateChange", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224333);
    }

    public final void aYc(String str) {
        AppMethodBeat.i(224334);
        if (!this.GBl) {
            AppMethodBeat.o(224334);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", str);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onReceiveMPPageData", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224334);
    }

    public final void aYd(String str) {
        AppMethodBeat.i(224335);
        if (!this.GBl) {
            AppMethodBeat.o(224335);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("state", str);
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMPAdWebviewStateChange", hashMap, this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224335);
    }

    public final void c(HashMap<String, String> hashMap, int i2) {
        AppMethodBeat.i(224336);
        Log.i("MicroMsg.JsApiHandler", "onSendToFriend %b", Boolean.valueOf(this.GBl));
        if (!this.GBl) {
            Log.w("MicroMsg.JsApiHandler", "onSendToFriend not ready");
            i(bH(hashMap), "sendAppMessage");
            AppMethodBeat.o(224336);
            return;
        }
        Bundle afU = afU(1);
        if (afU == null || !afU.getBoolean("WebViewShare_reslut", false)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("scene", "friend");
            hashMap2.put("shareScene", Integer.valueOf(i2));
            this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:share:appmessage", hashMap2, this.IRj, this.zpY) + ")", null);
            try {
                this.mHh.an("scene", "friend", this.IRl);
                AppMethodBeat.o(224336);
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e2.getMessage());
                AppMethodBeat.o(224336);
            }
        } else {
            i(afU, "sendAppMessage");
            AppMethodBeat.o(224336);
        }
    }

    public final void d(HashMap<String, String> hashMap, int i2) {
        AppMethodBeat.i(224337);
        Log.i("MicroMsg.JsApiHandler", "onFavorite %b", Boolean.valueOf(this.GBl));
        if (!this.GBl) {
            try {
                this.mHh.an("scene", "favorite", this.IRl);
                i(bH(hashMap), "sendAppMessage");
                AppMethodBeat.o(224337);
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e2.getMessage());
                AppMethodBeat.o(224337);
            }
        } else {
            Bundle afU = afU(1);
            if (afU == null || !afU.getBoolean("WebViewShare_reslut", false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("scene", "favorite");
                hashMap2.put("favScene", Integer.valueOf(i2));
                this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("menu:share:appmessage", hashMap2, this.IRj, this.zpY) + ")", null);
                try {
                    this.mHh.an("scene", "favorite", this.IRl);
                    AppMethodBeat.o(224337);
                } catch (Exception e3) {
                    Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e3.getMessage());
                    AppMethodBeat.o(224337);
                }
            } else {
                try {
                    this.mHh.an("scene", "favorite", this.IRl);
                } catch (Exception e4) {
                    Log.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e4.getMessage());
                }
                i(afU, "sendAppMessage");
                AppMethodBeat.o(224337);
            }
        }
    }

    public final Bundle afU(int i2) {
        AppMethodBeat.i(224338);
        try {
            if (this.IRa == null) {
                AppMethodBeat.o(224338);
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("WebViewShare_type", i2);
            bundle.putInt("WebViewShare_BinderID", this.IRl);
            bundle.putString("WebViewShare_wv_url", this.IRa.getUrl());
            Bundle j2 = this.mHh.j(105, bundle);
            j2.putBoolean("use_update_jsapi_data", true);
            AppMethodBeat.o(224338);
            return j2;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.JsApiHandler", "getShareData err %s", e2.getMessage());
            AppMethodBeat.o(224338);
            return null;
        }
    }

    public final Bundle bH(Map<String, String> map) {
        String title;
        String str;
        AppMethodBeat.i(224339);
        Bundle bundle = new Bundle();
        String url = this.IRa.getUrl();
        if (map != null) {
            String str2 = map.get("share_report_pre_msg_url");
            if (Util.isNullOrNil(str2)) {
                str = url;
            } else {
                str = str2;
            }
            String str3 = map.get("share_report_pre_msg_title");
            if (Util.isNullOrNil(str3)) {
                title = this.IRa.getTitle();
            } else {
                title = str3;
            }
            String str4 = map.get("share_report_pre_msg_desc");
            if (Util.isNullOrNil(str4)) {
                str4 = url;
            }
            bundle.putString("link", str);
            bundle.putString("desc", str4);
            bundle.putString("img_url", Util.nullAsNil(map.get("share_report_pre_msg_icon_url")));
        } else {
            title = this.IRa.getTitle();
            bundle.putString("link", url);
            bundle.putString("desc", url);
            bundle.putString("img_url", "");
        }
        if (!Util.isNullOrNil(title)) {
            url = title;
        } else if (!Util.isNullOrNil(url)) {
            Uri parse = Uri.parse(url);
            if (parse.getHost() != null) {
                url = parse.getHost();
            }
        } else {
            url = MMApplicationContext.getContext().getString(R.string.ize);
        }
        bundle.putString("title", url);
        bundle.putBoolean("use_update_jsapi_data", false);
        AppMethodBeat.o(224339);
        return bundle;
    }

    public final void i(final Bundle bundle, final String str) {
        AppMethodBeat.i(224340);
        if (bundle == null) {
            Log.w("MicroMsg.JsApiHandler", "sendDataWithSetData data is null");
            AppMethodBeat.o(224340);
            return;
        }
        if (this.IRg != null) {
            this.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(224213);
                    n nVar = new n();
                    nVar.params = new HashMap();
                    nVar.params.put("link", bundle.getString("link"));
                    nVar.params.put("title", bundle.getString("title"));
                    nVar.params.put("desc", bundle.getString("desc"));
                    nVar.ISf = new JSONObject();
                    nVar.params.put("img_url", bundle.getString("img_url"));
                    nVar.params.put("use_update_jsapi_data", Boolean.valueOf(bundle.getBoolean("use_update_jsapi_data")));
                    nVar.type = "call";
                    nVar.ISe = "";
                    nVar.mhO = str;
                    h.this.FoQ.add(nVar);
                    h.e(h.this);
                    AppMethodBeat.o(224213);
                }
            });
        }
        AppMethodBeat.o(224340);
    }

    public final void j(Bundle bundle, String str) {
        AppMethodBeat.i(224341);
        if (!this.GBl || bundle == null) {
            Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            AppMethodBeat.o(224341);
            return;
        }
        long j2 = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i2 = bundle.getInt("download_manager_errcode");
        Log.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j2 + ", state = " + str + ", errCode = " + i2);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j2));
        hashMap.put("err_code", Integer.valueOf(i2));
        hashMap.put("state", str);
        final String b2 = n.a.b("wxdownload:state_change", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(224214);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224214);
                } catch (Exception e2) {
                    Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224214);
                }
            }
        });
        AppMethodBeat.o(224341);
    }

    public final void a(String str, long j2, int i2, float f2) {
        AppMethodBeat.i(224342);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            AppMethodBeat.o(224342);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("appid", str);
        hashMap.put("download_id", Long.valueOf(j2));
        hashMap.put("progress", Integer.valueOf(i2));
        hashMap.put("progress_float", Float.valueOf(f2));
        final String b2 = n.a.b("wxdownload:progress_change", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(224215);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224215);
                } catch (Exception e2) {
                    Log.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224215);
                }
            }
        });
        AppMethodBeat.o(224342);
    }

    public final void gj(String str, int i2) {
        AppMethodBeat.i(224343);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
            AppMethodBeat.o(224343);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", str, Integer.valueOf(i2));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.JsApiHandler", "parameter error!!!");
            AppMethodBeat.o(224343);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", str);
        if (i2 == 2) {
            hashMap.put("state", "connected");
        } else if (i2 == 1) {
            hashMap.put("state", "connecting");
        } else {
            hashMap.put("state", "disconnected");
        }
        final String b2 = n.a.b("onWXDeviceStateChange", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(224216);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224216);
                } catch (Exception e2) {
                    Log.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", e2.getMessage());
                    AppMethodBeat.o(224216);
                }
            }
        });
        AppMethodBeat.o(224343);
    }

    public final void aYe(String str) {
        AppMethodBeat.i(224344);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready %s", str);
            AppMethodBeat.o(224344);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = ".concat(String.valueOf(str)));
        HashMap hashMap = new HashMap();
        hashMap.put("state", str);
        final String b2 = n.a.b("activity:state_change", hashMap, this.IRj, this.zpY);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            try {
                this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                AppMethodBeat.o(224344);
            } catch (Exception e2) {
                Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e2.getMessage());
                AppMethodBeat.o(224344);
            }
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(224221);
                    try {
                        h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                        AppMethodBeat.o(224221);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e2.getMessage());
                        AppMethodBeat.o(224221);
                    }
                }
            });
            AppMethodBeat.o(224344);
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(224345);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onWindowFocusChanged fail, not ready %b", Boolean.valueOf(z));
            AppMethodBeat.o(224345);
        } else if (this.IRa == null) {
            AppMethodBeat.o(224345);
        } else {
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            if (bVar == null || bVar.isMpUrl(this.IRa.getUrl())) {
                Log.d("MicroMsg.JsApiHandler", "onWindowFocusChanged, hasFocus = ".concat(String.valueOf(z)));
                HashMap hashMap = new HashMap();
                hashMap.put("hasFocus", Integer.valueOf(z ? 1 : 0));
                final String b2 = n.a.b("onWindowFocusChanged", hashMap, this.IRj, this.zpY);
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(224222);
                        try {
                            h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                            AppMethodBeat.o(224222);
                        } catch (Exception e2) {
                            Log.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e2.getMessage());
                            AppMethodBeat.o(224222);
                        }
                    }
                });
                AppMethodBeat.o(224345);
                return;
            }
            AppMethodBeat.o(224345);
        }
    }

    public final void bI(Map<String, Object> map) {
        AppMethodBeat.i(224346);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
            AppMethodBeat.o(224346);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
        final String b2 = n.a.b("onVoicePlayEnd", map, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(224224);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224224);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224224);
                }
            }
        });
        AppMethodBeat.o(224346);
    }

    public final void bJ(Map<String, Object> map) {
        AppMethodBeat.i(224347);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
            AppMethodBeat.o(224347);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
        final String b2 = n.a.b("onVoiceRecordEnd", map, this.IRj, this.zpY);
        Log.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", b2);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(224225);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224225);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224225);
                }
            }
        });
        AppMethodBeat.o(224347);
    }

    public final void gk(String str, int i2) {
        AppMethodBeat.i(224348);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
            AppMethodBeat.o(224348);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put(ch.COL_LOCALID, str);
        hashMap.put("percent", Integer.valueOf(i2));
        final String b2 = n.a.b("onImageUploadProgress", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass16 */

            public final void run() {
                AppMethodBeat.i(224227);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224227);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224227);
                }
            }
        });
        AppMethodBeat.o(224348);
    }

    public final void gl(String str, int i2) {
        AppMethodBeat.i(224349);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
            AppMethodBeat.o(224349);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put("serverId", str);
        hashMap.put("percent", Integer.valueOf(i2));
        final String b2 = n.a.b("onImageDownloadProgress", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(224228);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224228);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224228);
                }
            }
        });
        AppMethodBeat.o(224349);
    }

    public final void gm(String str, int i2) {
        AppMethodBeat.i(224350);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
            AppMethodBeat.o(224350);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put(ch.COL_LOCALID, str);
        hashMap.put("percent", Integer.valueOf(i2));
        final String b2 = n.a.b("onVoiceUploadProgress", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(224229);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224229);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224229);
                }
            }
        });
        AppMethodBeat.o(224350);
    }

    public final void gn(String str, int i2) {
        AppMethodBeat.i(224351);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
            AppMethodBeat.o(224351);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put("serverId", str);
        hashMap.put("percent", Integer.valueOf(i2));
        final String b2 = n.a.b("onVoiceDownloadProgress", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(224230);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224230);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224230);
                }
            }
        });
        AppMethodBeat.o(224351);
    }

    public final void go(String str, int i2) {
        AppMethodBeat.i(224352);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
            AppMethodBeat.o(224352);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", str, Integer.valueOf(i2));
        HashMap hashMap = new HashMap();
        hashMap.put(ch.COL_LOCALID, str);
        hashMap.put("percent", Integer.valueOf(i2));
        final String b2 = n.a.b("onVideoUploadProgress", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass20 */

            public final void run() {
                AppMethodBeat.i(224231);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224231);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224231);
                }
            }
        });
        AppMethodBeat.o(224352);
    }

    public final void aYf(final String str) {
        AppMethodBeat.i(224353);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onGoProfile fail, not ready");
            AppMethodBeat.o(224353);
            return;
        }
        if (this.IRg != null) {
            this.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass25 */

                public final void run() {
                    AppMethodBeat.i(224236);
                    n nVar = new n();
                    nVar.params = new HashMap();
                    nVar.params.put(ch.COL_USERNAME, str);
                    nVar.ISf = new JSONObject();
                    nVar.type = "call";
                    nVar.ISe = "";
                    nVar.mhO = Scopes.PROFILE;
                    h.this.FoQ.add(nVar);
                    h.e(h.this);
                    AppMethodBeat.o(224236);
                }
            });
        }
        AppMethodBeat.o(224353);
    }

    public final void afV(int i2) {
        AppMethodBeat.i(224354);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224354);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(com.tencent.mm.cb.a.E(MMApplicationContext.getContext(), i2)));
        final String b2 = n.a.b("onGetKeyboardHeight", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass26 */

            public final void run() {
                AppMethodBeat.i(224237);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224237);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224237);
                }
            }
        });
        AppMethodBeat.o(224354);
    }

    public final void yX(boolean z) {
        AppMethodBeat.i(224355);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224355);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        final String b2 = n.a.b("onAddShortcutStatus", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass28 */

            public final void run() {
                AppMethodBeat.i(224239);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224239);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224239);
                }
            }
        });
        AppMethodBeat.o(224355);
    }

    public final void aYg(String str) {
        AppMethodBeat.i(224356);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224356);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("err_msg", str);
        final String b2 = n.a.b("onBeaconMonitoring", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass29 */

            public final void run() {
                AppMethodBeat.i(224240);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224240);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224240);
                }
            }
        });
        AppMethodBeat.o(224356);
    }

    public final void M(final String str, final Map<String, String> map) {
        AppMethodBeat.i(224357);
        Log.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(224357);
            return;
        }
        this.IRx = str;
        if (map == null || map.size() == 0) {
            this.IRy = 0;
        } else {
            this.IRy = 1;
        }
        final String gp = gp(str, this.IRy);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass30 */

            public final void run() {
                AppMethodBeat.i(224241);
                try {
                    if (!(map == null || map.size() == 0)) {
                        com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                        c hsp = c.hsp();
                        for (String str : map.keySet()) {
                            hsp.setCookie(Util.getDomin(str), str + "=" + ((String) map.get(str)));
                        }
                        hsp.setCookie(Util.getDomin(str), "httponly");
                        com.tencent.xweb.d.hsr();
                        com.tencent.xweb.d.sync();
                        Log.i("MicroMsg.JsApiHandler", "cookies:%s", hsp.getCookie(Util.getDomin(str)));
                    }
                    h.this.IRa.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", str), null);
                    h.this.IRa.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (h.this.GBl) {
                        h.this.IRa.evaluateJavascript(gp, null);
                        h.this.IRx = null;
                        h.this.IRy = 0;
                    }
                    AppMethodBeat.o(224241);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224241);
                }
            }
        });
        AppMethodBeat.o(224357);
    }

    /* access modifiers changed from: package-private */
    public final String gp(String str, int i2) {
        AppMethodBeat.i(224358);
        HashMap hashMap = new HashMap(2);
        hashMap.put("url", str);
        hashMap.put("set_cookie", Integer.valueOf(i2));
        String aYh = aYh(n.a.b("onGetA8KeyUrl", hashMap, this.IRj, this.zpY));
        AppMethodBeat.o(224358);
        return aYh;
    }

    public final synchronized void a(String str, int i2, int i3, double d2, double d3, float f2) {
        int i4 = 1;
        synchronized (this) {
            AppMethodBeat.i(224359);
            if (this.IRC.stopped()) {
                this.IRC.startTimer(1000);
            }
            JSONObject jSONObject = new JSONObject();
            if (d2 <= 0.0d || d2 >= 0.5d) {
                i4 = 0;
            }
            try {
                if (!this.IRB.contains(String.valueOf(str) + String.valueOf(i2) + String.valueOf(i3))) {
                    this.IRB.add(String.valueOf(str) + String.valueOf(i2) + String.valueOf(i3));
                    jSONObject.put("uuid", String.valueOf(str));
                    jSONObject.put("major", String.valueOf(i2));
                    jSONObject.put("minor", String.valueOf(i3));
                    jSONObject.put("accuracy", String.valueOf(d2));
                    jSONObject.put("rssi", String.valueOf(d3));
                    jSONObject.put("heading", String.valueOf(f2));
                    jSONObject.put("proximity", String.valueOf(i4));
                    this.IRA.put(jSONObject);
                    this.IRz.put("beacons", this.IRA);
                    this.IRz.put("err_msg", "onBeaconsInRange:ok");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", e2.getMessage());
            }
            n.a.a("onBeaconsInRange", this.IRz, this.IRj, this.zpY);
            AppMethodBeat.o(224359);
        }
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        AppMethodBeat.i(224360);
        if (!Util.isNullOrNil(str)) {
            h(str, str2, map);
        }
        if (z) {
            fWZ();
        }
        AppMethodBeat.o(224360);
    }

    public final void fWZ() {
        AppMethodBeat.i(224361);
        if (this.IRg != null) {
            this.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass32 */

                public final void run() {
                    AppMethodBeat.i(224243);
                    h.e(h.this);
                    AppMethodBeat.o(224243);
                }
            });
        }
        AppMethodBeat.o(224361);
    }

    public final void fWV() {
        AppMethodBeat.i(224362);
        if (this.FoQ != null) {
            this.FoQ.clear();
        }
        AppMethodBeat.o(224362);
    }

    @Override // com.tencent.mm.plugin.webview.d.b
    public final void h(String str, String str2, Map<String, Object> map) {
        AppMethodBeat.i(224363);
        if (str2 == null || str2.length() == 0 || str == null) {
            Log.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = ".concat(String.valueOf(str2)));
            AppMethodBeat.o(224363);
        } else if (this.hdu.containsKey(str)) {
            b bVar = this.hdu.get(str);
            if (bVar != null) {
                bVar.h(str, str2, map);
                this.hdu.remove(str);
            }
            AppMethodBeat.o(224363);
        } else if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "doCallback fail, not ready");
            AppMethodBeat.o(224363);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("err_msg", str2);
            if (map != null && map.size() > 0) {
                Log.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                hashMap.putAll(map);
            }
            final String a2 = n.a.a(str, hashMap, this.IRj, this.zpY);
            Log.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a2);
            if (!(a2 == null || this.IRa == null)) {
                AnonymousClass34 r1 = new Runnable() {
                    /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass34 */

                    public final void run() {
                        AppMethodBeat.i(224245);
                        try {
                            h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a2 + ")", null);
                            AppMethodBeat.o(224245);
                        } catch (Exception e2) {
                            Log.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", e2.getMessage());
                            AppMethodBeat.o(224245);
                        }
                    }
                };
                if (MMHandlerThread.isMainThread()) {
                    r1.run();
                    AppMethodBeat.o(224363);
                    return;
                }
                MMHandlerThread.postToMainThread(r1);
            }
            AppMethodBeat.o(224363);
        }
    }

    public final void bK(Map<String, Object> map) {
        AppMethodBeat.i(224364);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
            AppMethodBeat.o(224364);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
        final String b2 = n.a.b("onSelectContact", map, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass35 */

            public final void run() {
                AppMethodBeat.i(224246);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224246);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224246);
                }
            }
        });
        AppMethodBeat.o(224364);
    }

    public final void j(String str, boolean z, String str2) {
        AppMethodBeat.i(224365);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
            AppMethodBeat.o(224365);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("json", str);
        hashMap.put("newQuery", Boolean.valueOf(z));
        hashMap.put("requestId", str2);
        final String b2 = n.a.b("onSearchDataReady", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass40 */

            public final void run() {
                AppMethodBeat.i(224251);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224251);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224251);
                }
            }
        });
        AppMethodBeat.o(224365);
    }

    public final boolean gbd() {
        AppMethodBeat.i(224366);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, not ready");
            AppMethodBeat.o(224366);
            return false;
        }
        Log.i("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden success, ready");
        final String b2 = n.a.b("onNavBarShadowManuallyHidden", new HashMap(), this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass43 */

            public final void run() {
                AppMethodBeat.i(224254);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224254);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onNavBarShadowManuallyHidden fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224254);
                }
            }
        });
        AppMethodBeat.o(224366);
        return true;
    }

    public final void b(String str, boolean z, String str2, String str3) {
        AppMethodBeat.i(224367);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
            AppMethodBeat.o(224367);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", str);
        hashMap.put("widgetId", str3);
        hashMap.put("hitTest", Boolean.valueOf(z));
        hashMap.put("err_msg", str2);
        final String b2 = n.a.b("onSearchWAWidgetOnTapCallback", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass49 */

            public final void run() {
                AppMethodBeat.i(224260);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224260);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224260);
                }
            }
        });
        AppMethodBeat.o(224367);
    }

    public final void lU(String str, String str2) {
        AppMethodBeat.i(224368);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
            AppMethodBeat.o(224368);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        hashMap.put("data", str2);
        final String b2 = n.a.b("onSearchWAWidgetReloadDataFinish", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass52 */

            public final void run() {
                AppMethodBeat.i(224264);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", new ValueCallback<String>() {
                        /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass52.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // android.webkit.ValueCallback
                        public final /* synthetic */ void onReceiveValue(String str) {
                            AppMethodBeat.i(224263);
                            Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish back %s", str);
                            AppMethodBeat.o(224263);
                        }
                    });
                    AppMethodBeat.o(224264);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224264);
                }
            }
        });
        AppMethodBeat.o(224368);
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i2) {
        AppMethodBeat.i(224369);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
            AppMethodBeat.o(224369);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", str, str2, jSONArray.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        hashMap.put("isCancelButtonClick", Integer.valueOf(i2));
        final String b2 = n.a.b("onSearchInputChange", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass56 */

            public final void run() {
                AppMethodBeat.i(224268);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224268);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224268);
                }
            }
        });
        AppMethodBeat.o(224369);
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        AppMethodBeat.i(224370);
        HashMap hashMap = new HashMap();
        hashMap.put(SearchIntents.EXTRA_QUERY, str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        b("onSearchInputChange", hashMap, null);
        AppMethodBeat.o(224370);
    }

    public final void b(final String str, Map<String, Object> map, JSONObject jSONObject) {
        final String a2;
        AppMethodBeat.i(224371);
        if (!this.GBl || (map == null && jSONObject == null)) {
            Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", str);
            AppMethodBeat.o(224371);
            return;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        Log.i("MicroMsg.JsApiHandler", "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s", objArr);
        if (map != null) {
            a2 = n.a.b(str, map, this.IRj, this.zpY);
        } else {
            a2 = n.a.a(str, jSONObject, this.IRj, this.zpY);
        }
        AnonymousClass57 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass57 */

            public final void run() {
                AppMethodBeat.i(224269);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a2 + ")", null);
                    AppMethodBeat.o(224269);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", str, e2.getMessage());
                    AppMethodBeat.o(224269);
                }
            }
        };
        if (MMHandlerThread.isMainThread()) {
            r1.run();
            AppMethodBeat.o(224371);
            return;
        }
        MMHandlerThread.postToMainThread(r1);
        AppMethodBeat.o(224371);
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i2, Map<String, Object> map) {
        AppMethodBeat.i(224372);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
            AppMethodBeat.o(224372);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", str, str2, jSONArray.toString());
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put(entry.getKey(), new JSONObject(entry.getValue().toString()));
                    } catch (JSONException e2) {
                        try {
                            jSONObject.put(entry.getKey(), new JSONArray(entry.getValue().toString()));
                        } catch (JSONException e3) {
                            try {
                                jSONObject.put(entry.getKey(), entry.getValue());
                            } catch (JSONException e4) {
                                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        try {
            jSONObject.put(SearchIntents.EXTRA_QUERY, str);
            jSONObject.put("custom", str2);
            jSONObject.put("tagList", jSONArray);
            jSONObject.put("isBackButtonClick", i2);
            jSONObject.put("sugId", "");
            jSONObject.put("sugClickType", 0);
        } catch (JSONException e5) {
            Log.printErrStackTrace("MicroMsg.JsApiHandler", e5, "", new Object[0]);
        }
        final String a2 = n.a.a("onSearchInputConfirm", jSONObject, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass58 */

            public final void run() {
                AppMethodBeat.i(224270);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a2 + ")", null);
                    AppMethodBeat.o(224270);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224270);
                }
            }
        });
        AppMethodBeat.o(224372);
    }

    public final void aXm(String str) {
        AppMethodBeat.i(224373);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
            AppMethodBeat.o(224373);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("json", str);
        final String b2 = n.a.b("onSearchSuggestionDataReady", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass59 */

            public final void run() {
                AppMethodBeat.i(224271);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224271);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224271);
                }
            }
        });
        AppMethodBeat.o(224373);
    }

    public final void cQ(int i2, String str) {
        AppMethodBeat.i(224374);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
            AppMethodBeat.o(224374);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(i2));
        hashMap.put("data", str);
        final String b2 = n.a.b("onSearchImageListReady", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass60 */

            public final void run() {
                AppMethodBeat.i(224272);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224272);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224272);
                }
            }
        });
        AppMethodBeat.o(224374);
    }

    public final void a(String str, String str2, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(224375);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, not ready");
            AppMethodBeat.o(224375);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onEmoticonIsChosen success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("md5", str);
        hashMap.put("thumbPath", str2);
        hashMap.put("tab", Integer.valueOf(i2));
        hashMap.put("asyncDownload", Integer.valueOf(i3));
        hashMap.put("emojiUrl", str3);
        hashMap.put("aesKey", str4);
        final String b2 = n.a.b("emoticonIsChosen", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass61 */

            public final void run() {
                AppMethodBeat.i(224273);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224273);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onEmoticonIsChosen fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224273);
                }
            }
        });
        AppMethodBeat.o(224375);
    }

    public final void x(int i2, String str, int i3) {
        AppMethodBeat.i(224376);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
            AppMethodBeat.o(224376);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("requestType", Integer.valueOf(i2));
        hashMap.put("json", str);
        hashMap.put("isCacheData", Integer.valueOf(i3));
        final String b2 = n.a.b("onTeachSearchDataReady", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass62 */

            public final void run() {
                AppMethodBeat.i(224274);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224274);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224274);
                }
            }
        });
        AppMethodBeat.o(224376);
    }

    public final void a(int i2, long j2, String str) {
        AppMethodBeat.i(224377);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, not ready");
            AppMethodBeat.o(224377);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onUxOplogDataReady success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(i2));
        hashMap.put("reqId", Long.valueOf(j2));
        hashMap.put("json", str);
        final String b2 = n.a.b("onUxOplogDataReady", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass64 */

            public final void run() {
                AppMethodBeat.i(224276);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224276);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onUxOplogDataReady fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224276);
                }
            }
        });
        AppMethodBeat.o(224377);
    }

    public final void g(int i2, String str, String str2, String str3, final String str4) {
        AppMethodBeat.i(224378);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "%s fail, not ready", str4);
            AppMethodBeat.o(224378);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "%s success, ready", str4);
        HashMap hashMap = new HashMap();
        hashMap.put("retCode", Integer.valueOf(i2));
        hashMap.put("errMsg", str);
        hashMap.put("json", str2);
        if (!Util.isNullOrNil(str3)) {
            hashMap.put("requestId", str3);
        }
        final String b2 = n.a.b(str4, hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass66 */

            public final void run() {
                AppMethodBeat.i(224278);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224278);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "%s fail, ex = %s", str4, e2.getMessage());
                    AppMethodBeat.o(224278);
                }
            }
        });
        AppMethodBeat.o(224378);
    }

    public final void gq(String str, int i2) {
        AppMethodBeat.i(224379);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
            AppMethodBeat.o(224379);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("snsid", str);
        hashMap.put("status", Integer.valueOf(i2));
        final String b2 = n.a.b("onMusicStatusChanged", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass67 */

            public final void run() {
                AppMethodBeat.i(224279);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224279);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224279);
                }
            }
        });
        AppMethodBeat.o(224379);
    }

    public static String aYh(String str) {
        AppMethodBeat.i(224380);
        String format = String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", Util.nullAsNil(str));
        AppMethodBeat.o(224380);
        return format;
    }

    public final void yY(boolean z) {
        AppMethodBeat.i(224381);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onPageStateChange fail, not ready");
            AppMethodBeat.o(224381);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onPageStateChange success, ready, active = %b", Boolean.valueOf(z));
        HashMap hashMap = new HashMap();
        hashMap.put("active", String.valueOf(z));
        final String aYh = aYh(n.a.b("onPageStateChange", hashMap, this.IRj, this.zpY));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass69 */

            public final void run() {
                AppMethodBeat.i(224281);
                try {
                    h.this.IRa.evaluateJavascript(aYh, null);
                    AppMethodBeat.o(224281);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224281);
                }
            }
        });
        AppMethodBeat.o(224381);
    }

    public final void gbe() {
        AppMethodBeat.i(224382);
        Log.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", Boolean.valueOf(this.GBl));
        if (this.IRa != null && this.GBl) {
            this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_all_hosts", new HashMap(), this.IRj, this.zpY) + ")", null);
        }
        AppMethodBeat.o(224382);
    }

    public final void yZ(boolean z) {
        List<String> list;
        AppMethodBeat.i(224383);
        Log.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", Boolean.valueOf(this.GBl));
        if (!(this.IRa == null || this.mHh == null || !this.GBl)) {
            if (z) {
                this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.IRj, this.zpY) + ")", null);
                AppMethodBeat.o(224383);
                return;
            }
            try {
                list = this.mHh.gej();
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                list = null;
            }
            Uri parse = Uri.parse(this.IRa.getUrl());
            if (parse != null) {
                Log.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (!(list == null || parse == null || !list.contains(parse.getHost()))) {
                this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:get_html_content", new HashMap(), this.IRj, this.zpY) + ")", null);
            }
        }
        AppMethodBeat.o(224383);
    }

    public final void aYi(String str) {
        AppMethodBeat.i(224384);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224384);
        } else if (!com.tencent.mm.pluginsdk.ui.tools.z.bfM(getCurrentUrl())) {
            AppMethodBeat.o(224384);
        } else {
            Log.i("MicroMsg.JsApiHandler", "onMenuClick");
            HashMap hashMap = new HashMap();
            hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, str);
            this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onMenuClick", hashMap, this.IRj, this.zpY) + ")", null);
            AppMethodBeat.o(224384);
        }
    }

    public final void gbf() {
        AppMethodBeat.i(224385);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
            AppMethodBeat.o(224385);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("needShow", Boolean.TRUE);
        final String b2 = n.a.b("showLoading", hashMap, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass71 */

            public final void run() {
                AppMethodBeat.i(224283);
                try {
                    h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                    AppMethodBeat.o(224283);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(224283);
                }
            }
        });
        AppMethodBeat.o(224385);
    }

    public final void aYj(String str) {
        AppMethodBeat.i(224386);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224386);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(224386);
        } else {
            Log.d("MicroMsg.JsApiHandler", "onNetWorkChange");
            HashMap hashMap = new HashMap();
            hashMap.put(DownloadInfo.NETTYPE, str);
            Context context = MMApplicationContext.getContext();
            if (!NetStatusUtil.isConnected(context)) {
                hashMap.put("networkType", "none");
            }
            if (NetStatusUtil.is2G(context)) {
                Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 2g");
                hashMap.put("networkType", "2g");
            }
            if (NetStatusUtil.is3G(context)) {
                Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 3g");
                hashMap.put("networkType", "3g");
            }
            if (NetStatusUtil.is4G(context)) {
                Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 4g");
                hashMap.put("networkType", "4g");
            }
            if (NetStatusUtil.is5G(context)) {
                Log.i("MicroMsg.JsApiHandler", "onNetWorkChange 5g");
                hashMap.put("networkType", "5g");
            }
            if (NetStatusUtil.isWifi(context)) {
                Log.i("MicroMsg.JsApiHandler", "onNetWorkChange wifi");
                hashMap.put("networkType", "wifi");
            }
            if (this.mHh != null) {
                try {
                    int i2 = this.mHh.j(110, new Bundle()).getInt("sim_card_type", 0);
                    int i3 = i2 == 0 ? 0 : i2 == 1 ? 1 : 2;
                    hashMap.put("simType", Integer.valueOf(i3));
                    Log.d("MicroMsg.JsApiHandler", "onNetWorkChange simType=%s", Integer.valueOf(i3));
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "invokeAsResult ex %s", e2.getMessage());
                }
            }
            final String b2 = n.a.b("onNetWorkChange", hashMap, this.IRj, this.zpY);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass73 */

                public final void run() {
                    AppMethodBeat.i(224285);
                    try {
                        h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + b2 + ")", null);
                        AppMethodBeat.o(224285);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e2.getMessage());
                        AppMethodBeat.o(224285);
                    }
                }
            });
            AppMethodBeat.o(224386);
        }
    }

    public final void gbg() {
        AppMethodBeat.i(224387);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
            AppMethodBeat.o(224387);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
        this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("onNavigationBarRightButtonClick", new HashMap(), this.IRj, this.zpY) + ")", null);
        AppMethodBeat.o(224387);
    }

    public final void dispatchEvent(String str, JSONObject jSONObject) {
        AppMethodBeat.i(224388);
        if (!this.GBl) {
            Log.e("MicroMsg.JsApiHandler", "not ready");
            AppMethodBeat.o(224388);
            return;
        }
        final String a2 = n.a.a(str, jSONObject, this.IRj, this.zpY);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass78 */

            public final void run() {
                AppMethodBeat.i(224290);
                try {
                    if (h.this.IRa != null) {
                        h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a2 + ")", null);
                    }
                    AppMethodBeat.o(224290);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiHandler", "eval onMiniProgramData, ex = %s", e2);
                    AppMethodBeat.o(224290);
                }
            }
        });
        AppMethodBeat.o(224388);
    }

    public final long gbh() {
        AppMethodBeat.i(224389);
        Log.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", Long.valueOf(this.IRD));
        long j2 = this.IRD;
        AppMethodBeat.o(224389);
        return j2;
    }

    public final k gbi() {
        AppMethodBeat.i(224390);
        com.tencent.mm.plugin.expansions.a.cMr();
        if (this.IRE == null) {
            this.IRE = new k(this);
        }
        k kVar = this.IRE;
        AppMethodBeat.o(224390);
        return kVar;
    }

    public final void gbj() {
        AppMethodBeat.i(224391);
        if (!this.GBl) {
            AppMethodBeat.o(224391);
            return;
        }
        if (this.IRE != null) {
            this.IRE.clear();
        }
        if (this.mHh != null) {
            try {
                this.mHh.agx(this.IRl);
                AppMethodBeat.o(224391);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "clearSession", new Object[0]);
            }
        }
        AppMethodBeat.o(224391);
    }

    public final String getUsername() {
        AppMethodBeat.i(224392);
        String str = (String) this.dVU.get("srcUsername");
        AppMethodBeat.o(224392);
        return str;
    }

    public final String getCurrentUrl() {
        AppMethodBeat.i(224393);
        if (this.IRa == null) {
            AppMethodBeat.o(224393);
            return "";
        }
        String url = this.IRa.getUrl();
        AppMethodBeat.o(224393);
        return url;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(224394);
        if (MMHandlerThread.isMainThread()) {
            this.IRa.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(224394);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass80 */

            public final void run() {
                AppMethodBeat.i(224292);
                h.this.IRa.evaluateJavascript(str, valueCallback);
                AppMethodBeat.o(224292);
            }
        });
        AppMethodBeat.o(224394);
    }

    private String aYk(String str) {
        AppMethodBeat.i(224395);
        String url = this.IRa.getUrl();
        try {
            String str2 = com.tencent.mm.loader.j.b.aKP() + com.tencent.mm.b.n.fc(url + str);
            Log.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", url, str, str2);
            AppMethodBeat.o(224395);
            return str2;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is ".concat(String.valueOf(url)));
            Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
            AppMethodBeat.o(224395);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093 A[SYNTHETIC, Splitter:B:22:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fb A[SYNTHETIC, Splitter:B:39:0x00fb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean N(java.lang.String r8, java.util.Map<java.lang.String, java.lang.Integer> r9) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.d.h.N(java.lang.String, java.util.Map):boolean");
    }

    private static boolean lV(String str, String str2) {
        AppMethodBeat.i(224397);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.o(224397);
            return false;
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            try {
                oVar.createNewFile();
            } catch (IOException e2) {
                Log.e("MicroMsg.JsApiHandler", "creating file failed, filePath is ".concat(String.valueOf(str)));
                Log.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                AppMethodBeat.o(224397);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.ap(oVar);
            outputStream.write(str2.getBytes());
            outputStream.write(13);
            outputStream.write(10);
            outputStream.flush();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
            }
            Log.d("MicroMsg.JsApiHandler", "writeToFile ok! ".concat(String.valueOf(str)));
            AppMethodBeat.o(224397);
            return true;
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            Log.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e5) {
                    Log.printErrStackTrace("MicroMsg.JsApiHandler", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(224397);
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e6) {
                    Log.printErrStackTrace("MicroMsg.JsApiHandler", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.o(224397);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public void _getAllHosts(final String str) {
        AppMethodBeat.i(224306);
        if (str != null) {
            this.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass81 */

                public final void run() {
                    AppMethodBeat.i(224293);
                    Map T = h.T(str.split(","));
                    String a2 = h.a(h.this, "hosts");
                    if (!h.O(a2, T)) {
                        Log.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (!(h.this.mHh == null || h.this.IRa == null)) {
                        try {
                            h.this.mHh.U(0, h.this.IRa.getUrl(), a2);
                            AppMethodBeat.o(224293);
                            return;
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e2.getMessage());
                            AppMethodBeat.o(224293);
                            return;
                        }
                    }
                    AppMethodBeat.o(224293);
                }
            });
        }
        AppMethodBeat.o(224306);
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public void _getHtmlContent(final String str) {
        AppMethodBeat.i(224307);
        if (str != null) {
            this.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass82 */

                public final void run() {
                    AppMethodBeat.i(224294);
                    String a2 = h.a(h.this, "html");
                    if (!h.lW(a2, str)) {
                        Log.e("MicroMsg.JsApiHandler", "failed to write Html file");
                    } else if (!(h.this.mHh == null || h.this.IRa == null)) {
                        try {
                            h.this.mHh.U(1, h.this.IRa.getUrl(), a2);
                            AppMethodBeat.o(224294);
                            return;
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e2.getMessage());
                            AppMethodBeat.o(224294);
                            return;
                        }
                    }
                    AppMethodBeat.o(224294);
                }
            });
        }
        AppMethodBeat.o(224307);
    }

    static /* synthetic */ void c(h hVar) {
        AppMethodBeat.i(224398);
        if (hVar.IRf.size() <= 0) {
            Log.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            AppMethodBeat.o(224398);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + hVar.FoQ.size());
        List<n> k = n.a.k(hVar.IRf.remove(0), hVar.IRj, hVar.zpY);
        if (!Util.isNullOrNil(k)) {
            hVar.FoQ.addAll(k);
            Log.i("MicroMsg.JsApiHandler", "now msg list size : %d", Integer.valueOf(hVar.FoQ.size()));
        }
        Log.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + hVar.FoQ.size());
        hVar.gbb();
        if (hVar.IRg != null) {
            hVar.IRg.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass65 */

                public final void run() {
                    AppMethodBeat.i(224277);
                    h.c(h.this);
                    AppMethodBeat.o(224277);
                }
            });
        }
        AppMethodBeat.o(224398);
    }

    static /* synthetic */ void a(h hVar, n nVar) {
        AppMethodBeat.i(224399);
        if (nVar != null) {
            if (Util.isEqual("log", nVar.mhO)) {
                hVar.FoQ.add(nVar);
                AppMethodBeat.o(224399);
                return;
            }
            Iterator<n> it = hVar.FoQ.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && Util.isEqual(next.mhO, nVar.mhO)) {
                    Log.i("MicroMsg.JsApiHandler", "addToMsgQueue fail, already has this function %s", nVar.mhO);
                    AppMethodBeat.o(224399);
                    return;
                }
            }
            hVar.FoQ.add(nVar);
        }
        AppMethodBeat.o(224399);
    }

    static /* synthetic */ void e(h hVar) {
        AppMethodBeat.i(224400);
        do {
        } while (hVar.gbc());
        AppMethodBeat.o(224400);
    }

    static /* synthetic */ Map T(String[] strArr) {
        AppMethodBeat.i(224401);
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            AppMethodBeat.o(224401);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < length; i2++) {
            if (hashMap.keySet().contains(strArr[i2])) {
                hashMap.put(strArr[i2], Integer.valueOf(((Integer) hashMap.get(strArr[i2])).intValue() + 1));
            } else {
                hashMap.put(strArr[i2], 1);
            }
        }
        AppMethodBeat.o(224401);
        return hashMap;
    }
}
