package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.l.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.math.BigDecimal;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020 H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020 H\u0002J\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0004J\u0010\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\u0004J\u0006\u00100\u001a\u00020 J \u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bJ\u001e\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020+J\u000e\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020+J\u000e\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\bJ\u0006\u0010B\u001a\u00020 J\u001e\u0010C\u001a\u00020 2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u0018\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0002J\u0006\u0010F\u001a\u00020 J\u0006\u0010G\u001a\u00020 J\u0010\u0010H\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010I\u001a\u00020 2\b\u0010\u000b\u001a\u0004\u0018\u00010JJ\u0010\u0010K\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u0010\u0010L\u001a\u00020 2\b\u0010M\u001a\u0004\u0018\u00010\u001bJ\b\u0010N\u001a\u00020 H\u0002J\b\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020 H\u0002J\b\u0010Q\u001a\u00020 H\u0002J\b\u0010R\u001a\u00020 H\u0002J\b\u0010S\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mEventDataObject", "Lorg/json/JSONObject;", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onPlayerProcessStateChanged", "event", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "what", "extra", "onVideoLoadedMetaData", "width", "height", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "removeFullScreenListener", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "Companion", "plugin-webview_release"})
public final class j {
    public static final a Jyd = new a((byte) 0);
    com.tencent.mm.bo.a Jii;
    f JxW;
    l JxX;
    private JSONObject JxY;
    com.tencent.mm.plugin.webview.ui.tools.video.c JxZ = new b(this);
    private int Jya = -1;
    ContentObserver Jyb;
    BroadcastReceiver Jyc;
    final String TAG = ("MicroMsg.WebViewVideoEventHandler:" + hashCode());
    private int bby;
    private MTimerHandler mAM;
    private int mKu;
    double mLe;

    static {
        AppMethodBeat.i(210719);
        AppMethodBeat.o(210719);
    }

    public j() {
        AppMethodBeat.i(210718);
        AppMethodBeat.o(210718);
    }

    public static final /* synthetic */ void a(j jVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(210723);
        jVar.dispatchEvent(str, jSONObject);
        AppMethodBeat.o(210723);
    }

    public static final /* synthetic */ JSONObject g(j jVar) {
        AppMethodBeat.i(210721);
        JSONObject bKv = jVar.bKv();
        AppMethodBeat.o(210721);
        return bKv;
    }

    public final void m(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(210707);
        if (aVar instanceof f) {
            this.JxW = (f) aVar;
            f fVar = (f) aVar;
            Context context = fVar.JxI.context;
            if (!(context instanceof c)) {
                context = null;
            }
            c cVar = (c) context;
            if (cVar != null) {
                cVar.a(this.JxZ);
            }
            Context context2 = fVar.JxI.context;
            if (this.Jii == null) {
                this.Jii = new com.tencent.mm.bo.a(context2, new d(this));
            }
            if (this.Jyb == null) {
                this.Jyb = new c(this, new Handler());
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                Context applicationContext = context3.getApplicationContext();
                p.g(applicationContext, "MMApplicationContext.get…text().applicationContext");
                ContentResolver contentResolver = applicationContext.getContentResolver();
                Uri uriFor = Settings.System.getUriFor("screen_brightness");
                try {
                    ContentObserver contentObserver = this.Jyb;
                    if (contentObserver == null) {
                        p.hyc();
                    }
                    contentResolver.registerContentObserver(uriFor, false, contentObserver);
                } catch (Throwable th) {
                    Log.printErrStackTrace(this.TAG, th, "initBrightnessObserver", new Object[0]);
                }
            }
            if (this.Jyc == null) {
                this.Jyc = new WebViewVideoEventHandler$initVolumeBroadcastReceiver$1(this);
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                    MMApplicationContext.getContext().registerReceiver(this.Jyc, intentFilter);
                } catch (Throwable th2) {
                    Log.printErrStackTrace(this.TAG, th2, "initBrightnessObserver", new Object[0]);
                }
            }
            com.tencent.mm.bo.a aVar2 = this.Jii;
            if (aVar2 != null) {
                aVar2.enable();
                AppMethodBeat.o(210707);
                return;
            }
        }
        AppMethodBeat.o(210707);
    }

    public final void onVideoWaiting() {
        AppMethodBeat.i(210708);
        try {
            dispatchEvent("onVideoWaiting", bKv());
            AppMethodBeat.o(210708);
        } catch (JSONException e2) {
            Log.e(this.TAG, "OnXWebVideoWaiting fail", e2);
            AppMethodBeat.o(210708);
        }
    }

    public final void gif() {
        AppMethodBeat.i(210709);
        try {
            this.mKu = 0;
            dispatchEvent("onVideoPlay", bKv());
            Log.i(this.TAG, "start video update timer");
            if (this.mAM == null) {
                Log.i(this.TAG, "start video update timer, create new timer");
                this.mAM = new MTimerHandler("VideoUpdateTimer", (MTimerHandler.CallBack) new f(this), true);
            }
            MTimerHandler mTimerHandler = this.mAM;
            if (mTimerHandler != null) {
                mTimerHandler.startTimer(0, 250);
            }
            MMHandlerThread.postToMainThread(new e(this));
            AppMethodBeat.o(210709);
        } catch (JSONException e2) {
            Log.e(this.TAG, "OnXWebVideoPlay fail", e2);
            AppMethodBeat.o(210709);
        }
    }

    public final void aX(long j2) {
        AppMethodBeat.i(210710);
        Log.d(this.TAG, "onVideoPreLoadedMetaData cachedSize=".concat(String.valueOf(j2)));
        h.INSTANCE.idkeyStat(1379, 6, 1, false);
        if (j2 > 0) {
            h.INSTANCE.idkeyStat(1379, 7, 1, false);
        }
        try {
            JSONObject bKv = bKv();
            bKv.put("preloadSize", j2);
            dispatchEvent("onVideoPreLoadedMetaData", bKv);
            AppMethodBeat.o(210710);
        } catch (JSONException e2) {
            Log.e(this.TAG, "onVideoPreLoadedMetaData fail", e2);
            AppMethodBeat.o(210710);
        }
    }

    public final void gig() {
        AppMethodBeat.i(210711);
        try {
            dispatchEvent("onVideoPause", bKv());
        } catch (JSONException e2) {
            Log.e(this.TAG, "OnXWebVideoPause fail", e2);
        }
        bKw();
        bMk();
        AppMethodBeat.o(210711);
    }

    public final void dV(String str) {
        AppMethodBeat.i(210712);
        if (str != null) {
            try {
                this.JxY = new JSONObject(str);
                AppMethodBeat.o(210712);
            } catch (Exception e2) {
                Log.e(this.TAG, "setVideoEventData fail", e2);
                AppMethodBeat.o(210712);
            }
        } else {
            AppMethodBeat.o(210712);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"})
    public static final class b extends com.tencent.mm.plugin.webview.ui.tools.video.c {
        final /* synthetic */ j Jye;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.Jye = jVar;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.video.c
        public final void Na() {
            AppMethodBeat.i(210699);
            try {
                j.a(this.Jye, "onExitFullscreen", j.g(this.Jye));
                AppMethodBeat.o(210699);
            } catch (JSONException e2) {
                Log.e(this.Jye.TAG, "OnXWebVideoError fail", e2);
                AppMethodBeat.o(210699);
            }
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.video.c
        public final void bDq() {
            AppMethodBeat.i(210700);
            try {
                j.a(this.Jye, "onEnterFullscreen", j.g(this.Jye));
                AppMethodBeat.o(210700);
            } catch (JSONException e2) {
                Log.e(this.Jye.TAG, "OnXWebVideoError fail", e2);
                AppMethodBeat.o(210700);
            }
        }
    }

    public final void bbk(String str) {
        AppMethodBeat.i(210713);
        p.h(str, "event");
        Log.i(this.TAG, "onPlayerProcessStateChanged event=".concat(String.valueOf(str)));
        try {
            JSONObject bKv = bKv();
            bKv.put("event", str);
            dispatchEvent("onPlayerProcessStateChanged", bKv);
            AppMethodBeat.o(210713);
        } catch (JSONException e2) {
            Log.e(this.TAG, "onVideoLoadedMetaData fail", e2);
            AppMethodBeat.o(210713);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class f implements MTimerHandler.CallBack {
        final /* synthetic */ j Jye;

        f(j jVar) {
            this.Jye = jVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(210705);
            if (this.Jye.JxX != null) {
                j jVar = this.Jye;
                l lVar = this.Jye.JxX;
                if (lVar == null) {
                    p.hyc();
                }
                j.a(jVar, lVar.getCurrentPosition(), (int) (this.Jye.mLe * 1000.0d));
            }
            AppMethodBeat.o(210705);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void bKw() {
        AppMethodBeat.i(210714);
        Log.i(this.TAG, "stop video update timer");
        MTimerHandler mTimerHandler = this.mAM;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
            AppMethodBeat.o(210714);
            return;
        }
        AppMethodBeat.o(210714);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject bKv() {
        AppMethodBeat.i(210715);
        JSONObject jSONObject = new JSONObject();
        if (this.JxY != null) {
            jSONObject.put("data", this.JxY);
        }
        AppMethodBeat.o(210715);
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void dispatchEvent(String str, JSONObject jSONObject) {
        AppMethodBeat.i(210716);
        f fVar = this.JxW;
        if (fVar != null) {
            jSONObject.put("__timestamp", System.currentTimeMillis());
            String gid = fVar.gid();
            if (!Util.isNullOrNil(gid)) {
                k gbi = fVar.JxI.IQZ.gbi();
                if (gbi != null) {
                    if (gid == null) {
                        p.hyc();
                    }
                    gbi.bi(gid, str, jSONObject.toString());
                    AppMethodBeat.o(210716);
                    return;
                }
                AppMethodBeat.o(210716);
                return;
            }
            fVar.JxI.IQZ.dispatchEvent(str, jSONObject);
            AppMethodBeat.o(210716);
            return;
        }
        AppMethodBeat.o(210716);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ j Jye;

        e(j jVar) {
            this.Jye = jVar;
        }

        public final void run() {
            AppMethodBeat.i(210704);
            if (this.Jye.JxW != null) {
                f fVar = this.Jye.JxW;
                if (fVar == null) {
                    p.hyc();
                }
                if (fVar.JxI.context instanceof Activity) {
                    Log.i(this.Jye.TAG, "startKeepScreenOn");
                    try {
                        f fVar2 = this.Jye.JxW;
                        if (fVar2 == null) {
                            p.hyc();
                        }
                        Context context = fVar2.JxI.context;
                        if (context == null) {
                            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(210704);
                            throw tVar;
                        }
                        ((Activity) context).getWindow().addFlags(128);
                        AppMethodBeat.o(210704);
                        return;
                    } catch (Exception e2) {
                        Log.e(this.Jye.TAG, "startKeepScreenOn exception", e2);
                    }
                }
            }
            AppMethodBeat.o(210704);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ j Jye;

        g(j jVar) {
            this.Jye = jVar;
        }

        public final void run() {
            AppMethodBeat.i(210706);
            if (this.Jye.JxW != null) {
                f fVar = this.Jye.JxW;
                if (fVar == null) {
                    p.hyc();
                }
                if (fVar.JxI.context instanceof Activity) {
                    Log.i(this.Jye.TAG, "startKeepScreenOn");
                    try {
                        f fVar2 = this.Jye.JxW;
                        if (fVar2 == null) {
                            p.hyc();
                        }
                        Context context = fVar2.JxI.context;
                        if (context == null) {
                            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(210706);
                            throw tVar;
                        }
                        ((Activity) context).getWindow().clearFlags(128);
                        AppMethodBeat.o(210706);
                        return;
                    } catch (Exception e2) {
                        Log.e(this.Jye.TAG, "startKeepScreenOn exception", e2);
                    }
                }
            }
            AppMethodBeat.o(210706);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bMk() {
        AppMethodBeat.i(210717);
        MMHandlerThread.postToMainThread(new g(this));
        AppMethodBeat.o(210717);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/orientation/OrientationListenerHelper$Orientation;", "kotlin.jvm.PlatformType", "newOrientation", "onFourOrientationsChange"})
    static final class d implements a.b {
        final /* synthetic */ j Jye;

        d(j jVar) {
            this.Jye = jVar;
        }

        @Override // com.tencent.mm.bo.a.b
        public final void a(a.EnumC0280a aVar, a.EnumC0280a aVar2) {
            int i2;
            int i3;
            AppMethodBeat.i(210702);
            j jVar = this.Jye;
            if (aVar2 == null) {
                AppMethodBeat.o(210702);
                return;
            }
            switch (k.$EnumSwitchMapping$0[aVar2.ordinal()]) {
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = -90;
                    break;
                case 3:
                    i2 = 0;
                    break;
                case 4:
                    i2 = TXLiveConstants.RENDER_ROTATION_180;
                    break;
                default:
                    AppMethodBeat.o(210702);
                    return;
            }
            jVar.bby = i2;
            if (this.Jye.bby == this.Jye.Jya) {
                AppMethodBeat.o(210702);
                return;
            }
            this.Jye.Jya = this.Jye.bby;
            Log.i(this.Jye.TAG, "onOrientationsChange currentOrientation=" + this.Jye.bby);
            try {
                JSONObject g2 = j.g(this.Jye);
                g2.put("newOrientation", this.Jye.bby);
                if (j.h(this.Jye)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                g2.put("sysLock", i3);
                j.a(this.Jye, "onOrientationsChange", g2);
                AppMethodBeat.o(210702);
            } catch (JSONException e2) {
                Log.e(this.Jye.TAG, "OnXWebVideoError fail", e2);
                AppMethodBeat.o(210702);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$initBrightnessObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "plugin-webview_release"})
    public static final class c extends ContentObserver {
        final /* synthetic */ j Jye;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j jVar, Handler handler) {
            super(handler);
            this.Jye = jVar;
        }

        public final void onChange(boolean z) {
            AppMethodBeat.i(210701);
            Log.d(this.Jye.TAG, "initBrightnessObserver onChange selfChange=".concat(String.valueOf(z)));
            try {
                JSONObject g2 = j.g(this.Jye);
                g2.put("selfChange", z);
                j.a(this.Jye, "onBrightnessChange", g2);
                AppMethodBeat.o(210701);
            } catch (JSONException e2) {
                Log.e(this.Jye.TAG, "onBrightnessChange fail  " + e2.getMessage());
                AppMethodBeat.o(210701);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$Companion;", "", "()V", "EXTRA_VOLUME_STREAM_TYPE", "", "VIDEO_TIME_UPDATE_INTERVAL", "", "VOLUME_CHANGED_ACTION", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(j jVar, int i2, int i3) {
        AppMethodBeat.i(210720);
        try {
            if (Math.abs(i2 - jVar.mKu) >= 250) {
                jVar.mKu = i2;
                double doubleValue = new BigDecimal((((double) i2) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
                JSONObject bKv = jVar.bKv();
                bKv.put("position", doubleValue);
                bKv.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) i3) * 1.0d) / 1000.0d);
                jVar.dispatchEvent("onVideoTimeUpdate", bKv);
                AppMethodBeat.o(210720);
                return;
            }
        } catch (JSONException e2) {
            Log.e(jVar.TAG, "OnXWebVideoTimeUpdate fail", e2);
        }
        AppMethodBeat.o(210720);
    }

    public static final /* synthetic */ boolean h(j jVar) {
        AppMethodBeat.i(210722);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        int i2 = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0);
        Log.i(jVar.TAG, "accRotation=".concat(String.valueOf(i2)));
        if (i2 == 0) {
            AppMethodBeat.o(210722);
            return true;
        }
        AppMethodBeat.o(210722);
        return false;
    }
}
