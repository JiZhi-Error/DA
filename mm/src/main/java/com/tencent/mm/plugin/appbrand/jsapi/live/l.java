package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
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
import org.json.JSONObject;

public final class l implements ITXLivePlayListener, TXLivePlayer.ITXAudioVolumeEvaluationListener {
    boolean cEK = true;
    boolean cEL = true;
    String cEW = "";
    boolean cEZ = false;
    private String cFA = "speaker";
    private float cFB = 1.0f;
    private float cFC = 3.0f;
    private boolean cFD = true;
    boolean cFE = false;
    private boolean cFF = false;
    private boolean cFG = false;
    private boolean cFH = false;
    private WXLivePlayConfig cFt;
    WXLivePlayer cFu;
    ITXLivePlayListener cFv;
    TXLivePlayer.ITXSnapshotListener cFw;
    int cFx = 0;
    private String cFy = "vertical";
    private String cFz = "contain";
    boolean lYb = false;
    TXLivePlayer.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
    private Context mContext;
    boolean mInited = false;
    private int mMode = 1;
    private boolean mMuteAudio = false;
    private boolean mMuteVideo = false;
    TXCloudVideoView mVideoView;

    public l(Context context) {
        AppMethodBeat.i(145906);
        this.mContext = context;
        this.cFt = new WXLivePlayConfig();
        this.cFu = new WXLivePlayer(this.mContext);
        this.cFu.enableHardwareDecode(true);
        this.cFu.setConfig(this.cFt);
        this.cFu.setPlayListener(this);
        this.cFu.setAudioVolumeEvaluationListener(this);
        AppMethodBeat.o(145906);
    }

    public final i k(String str, JSONObject jSONObject) {
        String optString;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(145907);
        if (str == null) {
            i iVar = new i(-1, "invalid params");
            AppMethodBeat.o(145907);
            return iVar;
        }
        String str2 = "";
        if (jSONObject != null) {
            str2 = jSONObject.toString();
        }
        Log.i("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + str + " params = " + str2);
        if (!this.mInited) {
            i iVar2 = new i(-3, "uninited livePlayer");
            AppMethodBeat.o(145907);
            return iVar2;
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
            i iVar3 = new i(-4, "invalid operate command");
            AppMethodBeat.o(145907);
            return iVar3;
        }
        i iVar4 = new i();
        AppMethodBeat.o(145907);
        return iVar4;
    }

    private void a(final boolean z, final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(145908);
        if (this.cFu != null) {
            this.cFu.snapshot(new TXLivePlayer.ITXSnapshotListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.l.AnonymousClass1 */

                @Override // com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(145905);
                    if (iTXSnapshotListener != null) {
                        if (!z) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else if (bitmap != null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            l.T(bitmap);
                            AppMethodBeat.o(145905);
                            return;
                        } else {
                            iTXSnapshotListener.onSnapshot(bitmap);
                            AppMethodBeat.o(145905);
                            return;
                        }
                    }
                    AppMethodBeat.o(145905);
                }
            });
        }
        AppMethodBeat.o(145908);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public final void onPlayEvent(int i2, Bundle bundle) {
        String str;
        AppMethodBeat.i(145909);
        if (i2 == 2006 || i2 == -2301) {
            k("stop", null);
        }
        if (i2 == 2012) {
            if (!this.cFG) {
                Log.i("TXLivePlayerJSAdapter", "onPushEvent: ignore sei message");
                AppMethodBeat.o(145909);
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
        if (this.cFE && this.cFv != null) {
            this.cFv.onPlayEvent(i2, bundle);
        }
        Log.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + i2 + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.o(145909);
    }

    @Override // com.tencent.rtmp.ITXLivePlayListener
    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.i(145910);
        if (this.cFv != null) {
            this.cFv.onNetStatus(bundle);
        }
        Log.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO)))));
        AppMethodBeat.o(145910);
    }

    @Override // com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener
    public final void onAudioVolumeEvaluationNotify(int i2) {
        AppMethodBeat.i(145911);
        if (this.cFF && this.mAudioVolumeListener != null) {
            this.mAudioVolumeListener.onAudioVolumeEvaluationNotify(i2);
        }
        AppMethodBeat.o(145911);
    }

    /* access modifiers changed from: package-private */
    public final int n(Bundle bundle) {
        AppMethodBeat.i(145912);
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            AppMethodBeat.o(145912);
            return 5;
        } else if (this.cEW == null) {
            AppMethodBeat.o(145912);
            return 0;
        } else if (this.cEW == null || ((!this.cEW.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !this.cEW.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) || !this.cEW.contains(".flv"))) {
            AppMethodBeat.o(145912);
            return 0;
        } else {
            AppMethodBeat.o(145912);
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(145913);
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
        this.cFB = bundle.getFloat("minCache", this.cFB);
        this.cFC = bundle.getFloat("maxCache", this.cFC);
        this.cFt.setAutoAdjustCacheTime(true);
        this.cFt.setCacheTime(this.cFB);
        this.cFt.setMinAutoAdjustCacheTime(this.cFB);
        this.cFt.setMaxAutoAdjustCacheTime(this.cFC);
        this.cFG = bundle.getBoolean("enableRecvMessage", this.cFG);
        this.cFt.setEnableMessage(this.cFG);
        this.cFu.setConfig(this.cFt);
        this.cFE = bundle.getBoolean("needEvent", this.cFE);
        this.cEK = bundle.getBoolean("autoPauseIfNavigate", this.cEK);
        this.cEL = bundle.getBoolean("autoPauseIfOpenNative", this.cEL);
        boolean z4 = bundle.getBoolean("needAudioVolume", this.cFF);
        if (z4 != this.cFF) {
            WXLivePlayer wXLivePlayer = this.cFu;
            if (z4) {
                i2 = 300;
            }
            wXLivePlayer.enableAudioVolumeEvaluation(i2);
        }
        this.cFF = z4;
        boolean z5 = bundle.getBoolean("debug", this.cFH);
        if (z5 != this.cFH) {
            this.cFu.showDebugLog(z5);
        }
        this.cFH = z5;
        AppMethodBeat.o(145913);
    }

    static void l(String str, Bundle bundle) {
        AppMethodBeat.i(145914);
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
        AppMethodBeat.o(145914);
    }

    static /* synthetic */ void T(Bitmap bitmap) {
        AppMethodBeat.i(145915);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("TXLivePlayerJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.o(145915);
    }
}
