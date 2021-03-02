package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.jsapi.u.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.WXLivePlayConfig;
import com.tencent.rtmp.WXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tav.core.AssetExtension;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONObject;

public final class b implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener {
    String cEW = "";
    boolean cEZ = false;
    private String cFA = "speaker";
    private float cFB = 1.0f;
    private float cFC = 3.0f;
    private boolean cFD = true;
    private boolean cFE = false;
    private boolean cFF = false;
    private boolean cFG = false;
    private boolean cFH = false;
    private WXLivePlayConfig cFt;
    WXLivePlayer cFu;
    ITXLivePlayListener cFv;
    TXLivePlayer.ITXSnapshotListener cFw;
    int cFx = 0;
    private String cFy = "vertical";
    private String cFz = "fillCrop";
    TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
    private Context mContext;
    Handler mHandler;
    boolean mInited = false;
    private int mMode = 1;
    boolean mMuteAudio = false;
    private boolean mMuteVideo = false;
    private Surface mSurface;
    TXCloudVideoView mVideoView;

    public b(Context context) {
        AppMethodBeat.i(138839);
        this.mContext = context;
        this.cFt = new WXLivePlayConfig();
        this.cFu = new WXLivePlayer(this.mContext);
        this.cFu.enableHardwareDecode(true);
        this.cFu.setConfig(this.cFt);
        this.cFu.setPlayListener(this);
        this.cFu.setAudioVolumeEvaluationListener(this);
        AppMethodBeat.o(138839);
    }

    public final a f(Surface surface) {
        AppMethodBeat.i(177135);
        this.mSurface = surface;
        this.cFu.setSurface(surface);
        a aVar = new a();
        AppMethodBeat.o(177135);
        return aVar;
    }

    public final a bV(int i2, int i3) {
        AppMethodBeat.i(138840);
        this.cFu.setSurfaceSize(i2, i3);
        a aVar = new a();
        AppMethodBeat.o(138840);
        return aVar;
    }

    public final a e(String str, JSONObject jSONObject) {
        String optString;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(138841);
        if (str == null) {
            a aVar = new a(-1, "invalid params");
            AppMethodBeat.o(138841);
            return aVar;
        }
        String str2 = "";
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        }
        Log.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + str + " params = " + str2);
        if (!this.mInited) {
            a aVar2 = new a(-3, "uninited livePlayer");
            AppMethodBeat.o(138841);
            return aVar2;
        }
        if (str.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
            this.cFu.startPlay(this.cEW, this.cFx);
        } else if (str.equalsIgnoreCase("stop")) {
            this.cFu.stopPlay(true);
        } else if (str.equalsIgnoreCase("pause")) {
            this.cFu.pause();
        } else if (str.equalsIgnoreCase("resume")) {
            this.cFu.resume();
        } else if (str.equalsIgnoreCase("mute")) {
            if (!this.mMuteAudio) {
                z = true;
            } else {
                z = false;
            }
            this.mMuteAudio = z;
            this.cFu.muteAudio(this.mMuteAudio);
        } else if (str.equalsIgnoreCase("snapshot")) {
            if (!(jSONObject == null || (optString = jSONObject.optString("quality")) == null || !optString.equalsIgnoreCase("compressed"))) {
                z2 = true;
            }
            a(z2, this.cFw);
        } else {
            a aVar3 = new a(-4, "invalid operate command");
            AppMethodBeat.o(138841);
            return aVar3;
        }
        a aVar4 = new a();
        AppMethodBeat.o(138841);
        return aVar4;
    }

    public final a PX() {
        AppMethodBeat.i(138842);
        if (this.cFu.isPlaying()) {
            a e2 = e("pause", null);
            AppMethodBeat.o(138842);
            return e2;
        }
        a aVar = new a();
        AppMethodBeat.o(138842);
        return aVar;
    }

    public final a PY() {
        AppMethodBeat.i(177136);
        a e2 = e("resume", null);
        AppMethodBeat.o(177136);
        return e2;
    }

    public final void a(final boolean z, final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(138843);
        if (this.cFu != null && this.cFu.isPlaying()) {
            this.cFu.snapshot(new TXLivePlayer.ITXSnapshotListener() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.AnonymousClass1 */

                @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(138838);
                    if (iTXSnapshotListener != null) {
                        if (!z) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else if (bitmap != null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            b.q(bitmap);
                            AppMethodBeat.o(138838);
                            return;
                        } else {
                            iTXSnapshotListener.onSnapshot(bitmap);
                            AppMethodBeat.o(138838);
                            return;
                        }
                    }
                    AppMethodBeat.o(138838);
                }
            });
        }
        AppMethodBeat.o(138843);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public final void onPlayEvent(int i2, Bundle bundle) {
        String str;
        AppMethodBeat.i(138844);
        if (i2 == 2006 || i2 == -2301) {
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.a.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(178812);
                    b.this.e("stop", null);
                    AppMethodBeat.o(178812);
                }
            };
            if (this.mHandler != null) {
                this.mHandler.post(r0);
            }
        }
        if (i2 == 2012) {
            if (!this.cFG) {
                Log.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
                AppMethodBeat.o(138844);
                return;
            } else if (bundle != null) {
                byte[] byteArray = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
                if (byteArray != null && byteArray.length > 0) {
                    try {
                        str = new String(byteArray, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } catch (UnsupportedEncodingException e2) {
                    }
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
                }
                str = "";
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            }
        }
        if (this.cFv != null) {
            this.cFv.onPlayEvent(i2, bundle);
        }
        Log.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + i2 + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.o(138844);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.i(138845);
        if (this.cFv != null) {
            this.cFv.onNetStatus(bundle);
        }
        Log.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO)))));
        AppMethodBeat.o(138845);
    }

    @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
    public final void onAudioVolumeEvaluationNotify(int i2) {
        AppMethodBeat.i(138846);
        if (this.cFF && this.mAudioVolumeListener != null) {
            this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(i2);
        }
        AppMethodBeat.o(138846);
    }

    /* access modifiers changed from: package-private */
    public final int n(Bundle bundle) {
        AppMethodBeat.i(138847);
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            AppMethodBeat.o(138847);
            return 5;
        } else if (this.cEW == null) {
            AppMethodBeat.o(138847);
            return 0;
        } else if (this.cEW == null || ((!this.cEW.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !this.cEW.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) || !this.cEW.contains(".flv"))) {
            AppMethodBeat.o(138847);
            return 0;
        } else {
            AppMethodBeat.o(138847);
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, boolean z) {
        AppMethodBeat.i(138848);
        boolean z2 = this.mMuteAudio;
        if (bundle.keySet().contains("muteAudio")) {
            z2 = bundle.getBoolean("muteAudio");
        } else if (bundle.keySet().contains("muted")) {
            z2 = bundle.getBoolean("muted");
        }
        if (z || z2 != this.mMuteAudio) {
            this.cFu.muteAudio(z2);
        }
        this.mMuteAudio = z2;
        boolean z3 = bundle.getBoolean("muteVideo", this.mMuteVideo);
        if (z || z3 != this.mMuteVideo) {
            this.cFu.muteVideo(z3);
        }
        this.mMuteVideo = z3;
        String string = bundle.getString("orientation", this.cFy);
        if (z || !string.equalsIgnoreCase(this.cFy)) {
            if (string.equalsIgnoreCase(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                this.cFu.setRenderRotation(270);
            } else if (string.equalsIgnoreCase("vertical")) {
                this.cFu.setRenderRotation(0);
            }
        }
        this.cFy = string;
        String string2 = bundle.getString("objectFit", this.cFz);
        if (z || !string2.equalsIgnoreCase(this.cFz)) {
            if (string2.equalsIgnoreCase("fillCrop")) {
                this.cFu.setRenderMode(0);
            } else if (string2.equalsIgnoreCase("contain")) {
                this.cFu.setRenderMode(1);
            }
        }
        this.cFz = string2;
        if (bundle.keySet().contains("soundMode")) {
            String string3 = bundle.getString("soundMode", this.cFA);
            if (!string3.equalsIgnoreCase(this.cFA)) {
                if (string3.equalsIgnoreCase("speaker")) {
                    this.cFu.setAudioRoute(0);
                } else if (string3.equalsIgnoreCase("ear")) {
                    this.cFu.setAudioRoute(1);
                }
            }
            this.cFA = string3;
        }
        String str = null;
        if (bundle.keySet().contains("referrer")) {
            str = bundle.getString("referrer");
            Log.i("TXLivePlayerJSAdapter", "parseAndApplyParams, referrer: ".concat(String.valueOf(str)));
        }
        this.cFB = bundle.getFloat("minCache", this.cFB);
        this.cFC = bundle.getFloat("maxCache", this.cFC);
        this.cFt.setAutoAdjustCacheTime(true);
        this.cFt.setCacheTime(this.cFB);
        this.cFt.setMinAutoAdjustCacheTime(this.cFB);
        this.cFt.setMaxAutoAdjustCacheTime(this.cFC);
        Map<String, String> aaG = d.aaG(str);
        if (aaG != null) {
            this.cFt.setHeaders(aaG);
        }
        this.cFG = bundle.getBoolean("enableRecvMessage", this.cFG);
        this.cFt.setEnableMessage(this.cFG);
        this.cFu.setConfig(this.cFt);
        this.cFE = bundle.getBoolean("needEvent", this.cFE);
        boolean z4 = bundle.getBoolean("needAudioVolume", this.cFF);
        if (z4 != this.cFF) {
            this.cFu.enableAudioVolumeEvaluation(z4 ? 300 : 0);
        }
        this.cFF = z4;
        boolean z5 = bundle.getBoolean("debug", this.cFH);
        if (z5 != this.cFH) {
            this.cFu.showDebugLog(z5);
        }
        this.cFH = z5;
        AppMethodBeat.o(138848);
    }

    static void l(String str, Bundle bundle) {
        AppMethodBeat.i(138849);
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("playUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("objectFit") || str2.equalsIgnoreCase("soundMode")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("playType")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("minCache") || str2.equalsIgnoreCase("maxCache")) {
                str = str + "\n" + str2 + " = " + bundle.getFloat(str2);
            } else if (str2.equalsIgnoreCase(MessengerShareContentUtility.SHARE_BUTTON_HIDE) || str2.equalsIgnoreCase("autoplay") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("muteAudio") || str2.equalsIgnoreCase("muteVideo") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("needAudioVolume") || str2.equalsIgnoreCase("enableRecvMessage") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        Log.i("TXLivePlayerJSAdapter", str);
        AppMethodBeat.o(138849);
    }

    static /* synthetic */ void q(Bitmap bitmap) {
        AppMethodBeat.i(138850);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("TXLivePlayerJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.o(138850);
    }
}
