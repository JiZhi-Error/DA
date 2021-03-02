package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public final class m implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify {
    private boolean cFE = false;
    private boolean cFF = false;
    private boolean cFH = false;
    private String cFy = "vertical";
    private WXLivePushConfig cHU;
    WXLivePusher cHV;
    ITXLivePushListener cHW;
    String cHX;
    private boolean cHY = false;
    private String cHZ = "front";
    private String cHp = "";
    private int cHv = 0;
    private String cIA = "";
    private boolean cIB = false;
    private String cIC = "auto";
    private int cID = 0;
    private boolean cIa = false;
    private boolean cIb = false;
    TXLivePusher.ITXSnapshotListener cIc;
    TXLivePusher.OnBGMNotify cId;
    TXLivePusher.ITXAudioVolumeEvaluationListener cIe;
    private boolean cIf = false;
    private boolean cIg = false;
    boolean cIh = false;
    private int cIi = 2;
    private int cIj = -1;
    private int cIk = -1;
    private int cIl = 0;
    boolean cIm = true;
    boolean cIn = true;
    private String cIo = "high";
    private int cIp = 5;
    private int cIq = 3;
    private String cIr = "smooth";
    private String cIs = "";
    private boolean cIt = false;
    private boolean cIu = false;
    private boolean cIv = false;
    private boolean cIw = false;
    private String cIx = "auto";
    private float cIy = 0.0f;
    private float cIz = 0.0f;
    private Context mContext;
    private boolean mEnableAgc = false;
    private boolean mEnableAns = false;
    private boolean mEnableZoom = true;
    private boolean mFrontCamera = true;
    private Handler mHandler;
    boolean mInited = false;
    private int mMode = 1;
    private boolean mMute = false;
    private int mVideoHeight = 640;
    TXCloudVideoView mVideoView;
    private int mVideoWidth = 368;
    private float mWatermarkWidth = 0.1f;

    static /* synthetic */ void a(m mVar, int i2, String str) {
        AppMethodBeat.i(145935);
        mVar.k(i2, str);
        AppMethodBeat.o(145935);
    }

    public m(Context context) {
        AppMethodBeat.i(145918);
        this.mContext = context;
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.cHU = new WXLivePushConfig();
        this.cHV = new WXLivePusher(context);
        this.cHV.setConfig(this.cHU);
        this.cHV.setPushListener(this);
        this.cHV.setBGMNofify(this);
        this.cHV.setAudioVolumeEvaluationListener(this);
        AppMethodBeat.o(145918);
    }

    public final void ib(final int i2) {
        AppMethodBeat.i(145919);
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.m.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(145916);
                m.this.cHv = i2;
                Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + i2 + ", orientation:" + m.this.cFy);
                m.a(m.this, i2, m.this.cFy);
                AppMethodBeat.o(145916);
            }
        });
        AppMethodBeat.o(145919);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        if (r10.equals(com.facebook.share.internal.MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL) == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(int r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.live.m.k(int, java.lang.String):void");
    }

    public final i l(String str, JSONObject jSONObject) {
        double d2;
        String str2;
        String optString;
        boolean z;
        boolean z2 = true;
        double d3 = 1.0d;
        int i2 = 0;
        r2 = false;
        r2 = false;
        boolean z3 = false;
        int i3 = 0;
        AppMethodBeat.i(145921);
        if (str == null) {
            i iVar = new i(-1, "invalid params");
            AppMethodBeat.o(145921);
            return iVar;
        } else if (!this.mInited) {
            i iVar2 = new i(-3, "uninited livePusher");
            AppMethodBeat.o(145921);
            return iVar2;
        } else {
            String str3 = "";
            if (jSONObject != null) {
                str3 = jSONObject.toString();
            }
            Log.i("TXLivePusherJSAdapter", "operateLivePusher: type = " + str + " params = " + str3);
            if (str.equalsIgnoreCase("start")) {
                if (this.cHX != null && !this.cHX.isEmpty() && !this.cHV.isPushing()) {
                    ca(this.cIm);
                    cb(this.cIn);
                    this.cHV.startPusher(this.cHX);
                }
            } else if (str.equalsIgnoreCase("stop")) {
                this.cIu = false;
                this.cHV.stopBGM();
                stopPreview();
                this.cHV.stopAudioRecord();
                this.cHV.stopPusher();
            } else if (str.equalsIgnoreCase("pause")) {
                if (this.cIu && this.cHV.isPushing()) {
                    this.cHV.turnOnFlashLight(false);
                }
                this.cHV.pausePusher();
                this.cIg = this.cIf;
                if (this.cIg) {
                    l("pauseBGM", (JSONObject) null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                this.cHV.resumePusher();
                if (this.cIg) {
                    l("resumeBGM", (JSONObject) null);
                }
            } else if (str.equalsIgnoreCase("startPreview")) {
                if (this.cHV.isPushing()) {
                    Log.i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
                } else {
                    stopPreview();
                    ca(this.cIm);
                }
            } else if (str.equalsIgnoreCase("stopPreview")) {
                if (this.cHV.isPushing()) {
                    Log.i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
                } else {
                    stopPreview();
                }
            } else if (str.equalsIgnoreCase("switchCamera")) {
                if (!this.mFrontCamera) {
                    z = true;
                } else {
                    z = false;
                }
                this.mFrontCamera = z;
                this.cHU.setFrontCamera(this.mFrontCamera);
                this.cHV.switchCamera();
            } else if (str.equalsIgnoreCase("snapshot")) {
                if (!(jSONObject == null || (optString = jSONObject.optString("quality")) == null || !optString.equalsIgnoreCase("compressed"))) {
                    z3 = true;
                }
                a(z3, this.cIc);
            } else if (str.equalsIgnoreCase("toggleTorch")) {
                if (this.cHV.isPushing()) {
                    if (this.cIu) {
                        z2 = false;
                    }
                    boolean turnOnFlashLight = this.cHV.turnOnFlashLight(z2);
                    if (!turnOnFlashLight) {
                        z2 = this.cIu;
                    }
                    this.cIu = z2;
                    if (!turnOnFlashLight) {
                        i3 = -2;
                    }
                    if (turnOnFlashLight) {
                        str2 = "Success";
                    } else {
                        str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
                    }
                    i iVar3 = new i(i3, str2);
                    AppMethodBeat.o(145921);
                    return iVar3;
                }
                i iVar4 = new i(-2, "fail");
                AppMethodBeat.o(145921);
                return iVar4;
            } else if (str.equalsIgnoreCase("playBGM")) {
                String str4 = "";
                if (jSONObject != null) {
                    str4 = jSONObject.optString("BGMFilePath", "");
                }
                Log.i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(str4)));
                if (str4 == null || str4.length() <= 0) {
                    i iVar5 = new i(-2, "fail");
                    AppMethodBeat.o(145921);
                    return iVar5;
                }
                this.cHV.playBGM(str4);
            } else if (str.equalsIgnoreCase("stopBGM")) {
                this.cHV.stopBGM();
                this.cIf = false;
            } else if (str.equalsIgnoreCase("pauseBGM")) {
                this.cHV.pauseBGM();
                this.cIf = false;
            } else if (str.equalsIgnoreCase("resumeBGM")) {
                this.cHV.resumeBGM();
                this.cIf = true;
            } else if (str.equalsIgnoreCase("setBGMVolume")) {
                if (jSONObject != null) {
                    d2 = jSONObject.optDouble("volume", 1.0d);
                } else {
                    d2 = 1.0d;
                }
                this.cHV.setBGMVolume((float) d2);
            } else if (str.equalsIgnoreCase("setMICVolume")) {
                if (jSONObject != null) {
                    d3 = jSONObject.optDouble("volume", 1.0d);
                }
                this.cHV.setMicVolume((float) d3);
            } else if (str.equalsIgnoreCase("sendMessage")) {
                String str5 = null;
                if (jSONObject != null) {
                    str5 = jSONObject.optString("msg");
                }
                if (str5 != null) {
                    boolean sendMessageEx = this.cHV.sendMessageEx(str5.getBytes());
                    if (!sendMessageEx) {
                        i2 = -2;
                    }
                    i iVar6 = new i(i2, sendMessageEx ? "Success" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
                    AppMethodBeat.o(145921);
                    return iVar6;
                }
                i iVar7 = new i(-2, "fail");
                AppMethodBeat.o(145921);
                return iVar7;
            } else {
                i iVar8 = new i(-4, "invalid operate command");
                AppMethodBeat.o(145921);
                return iVar8;
            }
            i iVar9 = new i();
            AppMethodBeat.o(145921);
            return iVar9;
        }
    }

    /* access modifiers changed from: package-private */
    public final void ca(boolean z) {
        AppMethodBeat.i(145922);
        if (!this.cHY && z) {
            this.mVideoView.setVisibility(0);
            this.cHV.startCameraPreview(this.mVideoView);
            this.cHY = true;
        }
        AppMethodBeat.o(145922);
    }

    /* access modifiers changed from: package-private */
    public final void stopPreview() {
        AppMethodBeat.i(145923);
        this.cHV.stopCameraPreview(true);
        this.cHY = false;
        AppMethodBeat.o(145923);
    }

    /* access modifiers changed from: package-private */
    public final void cb(boolean z) {
        AppMethodBeat.i(145924);
        if (z) {
            this.cHV.startAudioRecord();
        }
        AppMethodBeat.o(145924);
    }

    public final i hu(boolean z) {
        AppMethodBeat.i(145925);
        this.cIa = this.cHV.isPushing();
        if (!this.cIa) {
            i iVar = new i();
            AppMethodBeat.o(145925);
            return iVar;
        } else if (z) {
            this.cIb = z;
            if (this.cFE && this.cHW != null) {
                this.cHW.onPushEvent(5000, new Bundle());
            }
            i l = l("stop", (JSONObject) null);
            AppMethodBeat.o(145925);
            return l;
        } else {
            i l2 = l("pause", (JSONObject) null);
            AppMethodBeat.o(145925);
            return l2;
        }
    }

    public final i bGO() {
        AppMethodBeat.i(145926);
        if (!this.cIa) {
            i iVar = new i();
            AppMethodBeat.o(145926);
            return iVar;
        } else if (this.cIb) {
            i l = l("start", (JSONObject) null);
            AppMethodBeat.o(145926);
            return l;
        } else {
            i l2 = l("resume", (JSONObject) null);
            AppMethodBeat.o(145926);
            return l2;
        }
    }

    private void a(final boolean z, final TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(145927);
        if (this.cHV != null && this.cHV.isPushing()) {
            this.cHV.snapshot(new TXLivePusher.ITXSnapshotListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.m.AnonymousClass2 */

                @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(145917);
                    if (iTXSnapshotListener != null) {
                        if (!z) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else if (bitmap != null) {
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            m.U(bitmap);
                            AppMethodBeat.o(145917);
                            return;
                        } else {
                            iTXSnapshotListener.onSnapshot(bitmap);
                            AppMethodBeat.o(145917);
                            return;
                        }
                    }
                    AppMethodBeat.o(145917);
                }
            });
        }
        AppMethodBeat.o(145927);
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public final void onPushEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(145928);
        if (i2 == -1307 || i2 == -1313) {
            l("stop", (JSONObject) null);
        } else if (i2 == 1003 && this.cIu) {
            this.cHV.turnOnFlashLight(this.cIu);
        }
        if (this.cFE && this.cHW != null) {
            this.cHW.onPushEvent(i2, bundle);
        }
        Log.i("TXLivePusherJSAdapter", "onPushEvent: event = " + i2 + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.o(145928);
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.i(145929);
        if (this.cHW != null) {
            this.cHW.onNetStatus(bundle);
        }
        Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO)))));
        AppMethodBeat.o(145929);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMStart() {
        AppMethodBeat.i(145930);
        this.cIf = true;
        if (this.cIv && this.cId != null) {
            this.cId.onBGMStart();
        }
        AppMethodBeat.o(145930);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMProgress(long j2, long j3) {
        AppMethodBeat.i(145931);
        if (this.cIv && this.cId != null) {
            this.cId.onBGMProgress(j2, j3);
        }
        AppMethodBeat.o(145931);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMComplete(int i2) {
        AppMethodBeat.i(145932);
        this.cIf = false;
        if (this.cIv && this.cId != null) {
            this.cId.onBGMComplete(i2);
        }
        AppMethodBeat.o(145932);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
    public final void onAudioVolumeEvaluationNotify(int i2) {
        AppMethodBeat.i(182556);
        if (this.cFF && this.cIe != null) {
            this.cIe.onAudioVolumeEvaluationNotify(i2);
        }
        AppMethodBeat.o(182556);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, boolean z) {
        int i2;
        int i3;
        boolean z2;
        AppMethodBeat.i(145933);
        if (z || bundle.keySet().size() != 0) {
            int i4 = bundle.getInt("mode", this.mMode);
            if (z || i4 != this.mMode) {
                switch (i4) {
                    case 1:
                        this.cHV.setVideoQuality(1, true, false);
                        this.cHU.setVideoEncodeGop(5);
                        break;
                    case 2:
                        this.cHV.setVideoQuality(2, true, false);
                        this.cHU.setVideoEncodeGop(5);
                        break;
                    case 3:
                        this.cHV.setVideoQuality(3, true, false);
                        this.cHU.setVideoEncodeGop(5);
                        break;
                    case 4:
                        this.cHV.setVideoQuality(4, true, false);
                        break;
                    case 5:
                        this.cHV.setVideoQuality(5, true, false);
                        break;
                    case 6:
                        this.cHV.setVideoQuality(6, false, false);
                        break;
                    case 7:
                        this.cHV.setVideoQuality(7, true, false);
                        this.cHU.setVideoEncodeGop(5);
                        break;
                }
            }
            int i5 = this.cIj;
            int i6 = this.cIk;
            int i7 = bundle.getInt("minBitrate", -1);
            int i8 = bundle.getInt("maxBitrate", -1);
            if (i7 > i8) {
                Log.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i7 + " max = " + i8);
                i2 = i7;
                i3 = i8;
            } else {
                i2 = i8;
                i3 = i7;
            }
            if (!(i3 == -1 || i2 == -1)) {
                if (i3 < 200) {
                    i3 = 200;
                }
                if (i2 > 5000) {
                    i2 = 5000;
                }
                if (i3 <= i2) {
                    i6 = i2;
                    i5 = i3;
                }
                if (!(i5 == -1 || i6 == -1 || i5 > i6)) {
                    this.cHU.setMinVideoBitrate(i5);
                    this.cHU.setMaxVideoBitrate(i6);
                }
            }
            int i9 = bundle.getInt("aspect", this.cIi);
            int i10 = bundle.getInt("videoWidth", this.mVideoWidth);
            int i11 = bundle.getInt("videoHeight", this.mVideoHeight);
            String string = bundle.getString("audioQuality", this.cIo);
            if (i4 == 6) {
                if (i9 == 1) {
                    this.cHU.setVideoResolution(13);
                } else if (i9 == 2) {
                    this.cHU.setVideoResolution(0);
                }
                if (i10 > 0 && i10 <= 1920 && i11 > 0 && i11 <= 1920) {
                    this.cHU.setVideoResolution(i10, i11);
                }
                if (string.equalsIgnoreCase("low")) {
                    this.cHU.setAudioSampleRate(16000);
                } else if (string.equalsIgnoreCase("high")) {
                    this.cHU.setAudioSampleRate(48000);
                }
            }
            int i12 = bundle.getInt("focusMode", this.cIl);
            this.cHU.setTouchFocus(i12 != 0);
            boolean z3 = this.mFrontCamera;
            if (bundle.keySet().contains("devicePosition")) {
                this.cHZ = bundle.getString("devicePosition", this.cHZ);
                if (this.cHZ.equalsIgnoreCase("back")) {
                    z3 = false;
                }
                this.cHU.setFrontCamera(z3);
            }
            String string2 = bundle.getString("orientation", this.cFy);
            if (!string2.equalsIgnoreCase(this.cFy)) {
                if (string2.equalsIgnoreCase(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                    k(this.cHv, string2);
                    this.cHV.setRenderRotation(90);
                } else if (string2.equalsIgnoreCase("vertical")) {
                    k(this.cHv, string2);
                    this.cHV.setRenderRotation(0);
                }
            }
            String string3 = bundle.getString("localMirror", this.cIx);
            if (!string3.equalsIgnoreCase(this.cIx)) {
                if (string3.equalsIgnoreCase("auto")) {
                    this.cHU.setLocalVideoMirrorType(0);
                } else if (string3.equalsIgnoreCase("enable")) {
                    this.cHU.setLocalVideoMirrorType(1);
                } else if (string3.equalsIgnoreCase("disable")) {
                    this.cHU.setLocalVideoMirrorType(2);
                }
            }
            String string4 = bundle.getString("backgroundImage", this.cIs);
            Bitmap decodeFile = BitmapFactory.decodeFile(string4);
            if (decodeFile != null) {
                this.cHU.setPauseImg(decodeFile);
            }
            boolean z4 = bundle.getBoolean("backgroundMute", this.cIt);
            if (z4) {
                this.cHU.setPauseFlag(3);
            } else {
                this.cHU.setPauseFlag(1);
            }
            boolean z5 = bundle.getBoolean("zoom", this.mEnableZoom);
            this.cHU.setEnableZoom(z5);
            float f2 = bundle.getFloat("watermarkLeft", this.cIy);
            float f3 = bundle.getFloat("watermarkTop", this.cIz);
            float f4 = bundle.getFloat("watermarkWidth", this.mWatermarkWidth);
            String string5 = bundle.getString("watermarkImage", this.cIA);
            Bitmap decodeFile2 = BitmapFactory.decodeFile(string5);
            if (decodeFile2 != null) {
                this.cHU.setWatermark(decodeFile2, f2, f3, f4);
            } else if (this.cHV.isPushing() && bundle.keySet().contains("watermarkImage")) {
                this.cHU.setWatermark(decodeFile2, f2, f3, f4);
            }
            boolean z6 = bundle.getBoolean("enableAGC", this.mEnableAgc);
            this.cHU.enableAGC(z6);
            boolean z7 = bundle.getBoolean("enableANS", this.mEnableAns);
            this.cHU.enableANS(z7);
            boolean z8 = bundle.getBoolean("enableEarMonitor", this.cIB);
            this.cHU.enableAudioEarMonitoring(z8);
            String string6 = bundle.getString("audioVolumeType", this.cIC);
            if (string6.equalsIgnoreCase("voicecall")) {
                this.cHU.setVolumeType(2);
            } else if (string6.equalsIgnoreCase("media")) {
                this.cHU.setVolumeType(1);
            } else {
                this.cHU.setVolumeType(0);
            }
            boolean z9 = bundle.getBoolean("enableCamera", this.cIm);
            this.cHU.enablePureAudioPush(!z9);
            boolean z10 = false;
            if (!(i9 == this.cIi && i5 == this.cIj && i6 == this.cIk && i12 == this.cIl && z3 == this.mFrontCamera && z4 == this.cIt && z5 == this.mEnableZoom && z6 == this.mEnableAgc && z7 == this.mEnableAns && z8 == this.cIB && z9 == this.cIm && i10 == this.mVideoWidth && i11 == this.mVideoHeight && f2 == this.cIy && f3 == this.cIz && f4 == this.mWatermarkWidth && string3.equalsIgnoreCase(this.cIx) && string6.equalsIgnoreCase(this.cIC) && string4.equalsIgnoreCase(this.cIs) && string2.equalsIgnoreCase(this.cFy) && string.equalsIgnoreCase(this.cIo) && string5.equalsIgnoreCase(this.cIA))) {
                z10 = true;
            }
            if (z || z10) {
                this.cHV.setConfig(this.cHU);
            }
            if (z9 != this.cIm) {
                if (z9) {
                    stopPreview();
                    ca(z9);
                } else {
                    stopPreview();
                }
            }
            if (bundle.keySet().contains("enableMic")) {
                boolean z11 = bundle.getBoolean("enableMic", this.cIn);
                if (z11 != this.cIn) {
                    if (z11) {
                        this.cHV.stopAudioRecord();
                        cb(true);
                    } else {
                        this.cHV.stopAudioRecord();
                    }
                }
                if (z || z11 != this.cIn) {
                    this.cHV.setMute(!z11);
                }
                this.cIn = z11;
                if (!z11) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.mMute = z2;
            } else if (bundle.keySet().contains("muted")) {
                boolean z12 = bundle.getBoolean("muted", this.mMute);
                if (z || z12 != this.mMute) {
                    this.cHV.setMute(z12);
                }
                this.mMute = z12;
            }
            this.mMode = i4;
            this.cIi = i9;
            this.cIl = i12;
            this.cIm = z9;
            this.mEnableAgc = z6;
            this.mEnableAns = z7;
            this.cIB = z8;
            this.cIx = string3;
            this.cIC = string6;
            this.mVideoWidth = i10;
            this.mVideoHeight = i11;
            this.mFrontCamera = z3;
            this.cFy = string2;
            this.cIt = z4;
            this.cIs = string4;
            this.cIj = i5;
            this.cIk = i6;
            this.cIo = string;
            this.mEnableZoom = z5;
            this.cIy = f2;
            this.cIz = f3;
            this.mWatermarkWidth = f4;
            this.cIA = string5;
            this.cFE = bundle.getBoolean("needEvent", this.cFE);
            this.cIv = bundle.getBoolean("needBGMEvent", this.cIv);
            boolean z13 = this.cIw;
            if (bundle.keySet().contains("remoteMirror")) {
                z13 = bundle.getBoolean("remoteMirror");
            } else if (bundle.keySet().contains("mirror")) {
                z13 = bundle.getBoolean("mirror");
            }
            if (z13 != this.cIw) {
                this.cHV.setMirror(z13);
            }
            this.cIw = z13;
            int i13 = bundle.getInt("beauty", this.cIp);
            int i14 = bundle.getInt("whiteness", this.cIq);
            String string7 = bundle.getString("beautyStyle", this.cIr);
            if (z || i13 != this.cIp || i14 != this.cIq || !string7.equalsIgnoreCase(this.cIr)) {
                if (string7.equalsIgnoreCase("nature")) {
                    this.cHV.setBeautyFilter(1, i13, i14, 2);
                } else {
                    this.cHV.setBeautyFilter(0, i13, i14, 2);
                }
            }
            this.cIp = i13;
            this.cIq = i14;
            this.cIr = string7;
            String string8 = bundle.getString("filterImage", this.cHp);
            if (!string8.equalsIgnoreCase(this.cHp)) {
                this.cHV.setFilter(BitmapFactory.decodeFile(string8));
            }
            this.cHp = string8;
            int i15 = bundle.getInt("audioReverbType", this.cID);
            if (i15 != this.cID) {
                this.cHV.setReverb(i15);
            }
            this.cID = i15;
            boolean z14 = bundle.getBoolean("needAudioVolume", this.cFF);
            if (z14 != this.cFF) {
                this.cHV.enableAudioVolumeEvaluation(z14 ? 300 : 0);
            }
            this.cFF = z14;
            boolean z15 = bundle.getBoolean("debug", this.cFH);
            if (z || z15 != this.cFH) {
                this.cHV.showDebugLog(z15);
            }
            this.cFH = z15;
            AppMethodBeat.o(145933);
            return;
        }
        AppMethodBeat.o(145933);
    }

    static void l(String str, Bundle bundle) {
        AppMethodBeat.i(145934);
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("pushUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("backgroundImage") || str2.equalsIgnoreCase("audioQuality") || str2.equalsIgnoreCase("watermarkImage") || str2.equalsIgnoreCase("audioVolumeType") || str2.equalsIgnoreCase("localMirror") || str2.equalsIgnoreCase("devicePosition") || str2.equalsIgnoreCase("beautyStyle") || str2.equalsIgnoreCase("filterImage")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("focusMode") || str2.equalsIgnoreCase("beauty") || str2.equalsIgnoreCase("whiteness") || str2.equalsIgnoreCase("aspect") || str2.equalsIgnoreCase("videoWidth") || str2.equalsIgnoreCase("videoHeight") || str2.equalsIgnoreCase("audioReverbType") || str2.equalsIgnoreCase("minBitrate") || str2.equalsIgnoreCase("maxBitrate")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase(MessengerShareContentUtility.SHARE_BUTTON_HIDE) || str2.equalsIgnoreCase("autopush") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("enableCamera") || str2.equalsIgnoreCase("enableMic") || str2.equalsIgnoreCase("enableAGC") || str2.equalsIgnoreCase("enableANS") || str2.equalsIgnoreCase("enableEarMonitor") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("zoom") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("needBGMEvent") || str2.equalsIgnoreCase("debug") || str2.equalsIgnoreCase("mirror") || str2.equalsIgnoreCase("remoteMirror") || str2.equalsIgnoreCase("needAudioVolume")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            } else if (str2.equalsIgnoreCase("watermarkLeft") || str2.equalsIgnoreCase("watermarkTop") || str2.equalsIgnoreCase("watermarkWidth")) {
                str = str + "\n" + str2 + " = " + bundle.getFloat(str2);
            }
        }
        Log.i("TXLivePusherJSAdapter", str);
        AppMethodBeat.o(145934);
    }

    static /* synthetic */ void U(Bitmap bitmap) {
        AppMethodBeat.i(145936);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("TXLivePusherJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.o(145936);
    }
}
