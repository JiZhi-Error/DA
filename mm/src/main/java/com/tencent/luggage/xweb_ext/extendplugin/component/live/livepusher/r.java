package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.jsapi.live.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.WXLivePushConfig;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r implements ITXLivePushListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.OnBGMNotify {
    private static m.b cIH = m.b.cGS;
    private boolean cFE = false;
    private boolean cFF = false;
    private boolean cFH = false;
    private String cFy = "vertical";
    private WXLivePushConfig cHU;
    final WXLivePusher cHV;
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
    private final m cIE = cIH.Qh();
    private boolean cIF = false;
    private boolean cIG = false;
    boolean cIa = false;
    boolean cIb = false;
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
    Handler mHandler;
    boolean mInited = false;
    private int mMode = 1;
    private boolean mMute = false;
    Surface mSurface;
    private int mVideoHeight = 640;
    TXCloudVideoView mVideoView;
    private int mVideoWidth = 368;
    private float mWatermarkWidth = 0.1f;

    static /* synthetic */ void a(r rVar, int i2, String str) {
        AppMethodBeat.i(138918);
        rVar.k(i2, str);
        AppMethodBeat.o(138918);
    }

    public static void a(m.b bVar) {
        cIH = bVar;
    }

    public r(Context context) {
        AppMethodBeat.i(138900);
        this.mContext = context;
        this.cHU = new WXLivePushConfig();
        this.cHV = new WXLivePusher(context);
        this.cHV.setConfig(this.cHU);
        this.cHV.setPushListener(this);
        this.cHV.setBGMNofify(this);
        this.cHV.setAudioVolumeEvaluationListener(this);
        AppMethodBeat.o(138900);
    }

    public final void ib(final int i2) {
        AppMethodBeat.i(138901);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138898);
                r.this.cHv = i2;
                Log.i("TXLivePusherJSAdapter", "notifyOrientationChanged, angle:" + i2 + ", orientation:" + r.this.cFy);
                r.a(r.this, i2, r.this.cFy);
                AppMethodBeat.o(138898);
            }
        });
        AppMethodBeat.o(138901);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0036, code lost:
        if (r10.equals(com.facebook.share.internal.MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL) == false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(int r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r.k(int, java.lang.String):void");
    }

    public final a o(Bundle bundle) {
        AppMethodBeat.i(138903);
        if (bundle == null) {
            a aVar = new a(-1, "invalid params");
            AppMethodBeat.o(138903);
            return aVar;
        }
        l(h.NAME, bundle);
        if (!this.mInited) {
            a aVar2 = new a(-3, "uninited livePusher");
            AppMethodBeat.o(138903);
            return aVar2;
        }
        a(bundle, false);
        String string = bundle.getString("pushUrl", this.cHX);
        if (string != null && !string.isEmpty() && this.cHX != null && !this.cHX.equalsIgnoreCase(string) && this.cHV.isPushing()) {
            Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
            stopPreview();
            this.cHV.stopAudioRecord();
            this.cHV.stopPusher();
        }
        this.cHX = string;
        this.cHV.setPusherUrl(this.cHX);
        this.cIh = bundle.getBoolean("autopush", this.cIh);
        if (this.cIh && this.cHX != null && !this.cHX.isEmpty() && !this.cHV.isPushing()) {
            Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
            ca(this.cIm);
            cb(this.cIn);
            if (this.cIm && this.mSurface != null) {
                this.cHV.setSurface(this.mSurface);
            }
            this.cHV.startPusher(this.cHX);
        }
        a aVar3 = new a();
        AppMethodBeat.o(138903);
        return aVar3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02f0, code lost:
        if (r0 != null) goto L_0x02f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03de, code lost:
        if (r0 != false) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x049e, code lost:
        if (r0 != false) goto L_0x04a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.luggage.xweb_ext.extendplugin.component.live.a f(java.lang.String r14, org.json.JSONObject r15) {
        /*
        // Method dump skipped, instructions count: 2042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r.f(java.lang.String, org.json.JSONObject):com.tencent.luggage.xweb_ext.extendplugin.component.live.a");
    }

    /* access modifiers changed from: package-private */
    public final void ca(boolean z) {
        AppMethodBeat.i(138905);
        if (!this.cHY && z) {
            if (this.mVideoView != null) {
                this.mVideoView.setVisibility(0);
            }
            if (this.mSurface != null) {
                this.cHV.setSurface(this.mSurface);
            }
            this.cHV.startCameraPreview(this.mVideoView);
            this.cHY = true;
        }
        AppMethodBeat.o(138905);
    }

    private void stopPreview() {
        AppMethodBeat.i(138906);
        this.cHV.stopCameraPreview(true);
        this.cHY = false;
        AppMethodBeat.o(138906);
    }

    /* access modifiers changed from: package-private */
    public final void cb(boolean z) {
        AppMethodBeat.i(138907);
        if (z) {
            this.cHV.startAudioRecord();
        }
        AppMethodBeat.o(138907);
    }

    public final a Qj() {
        AppMethodBeat.i(138908);
        if (!this.mInited) {
            a aVar = new a(-3, "uninited livePusher");
            AppMethodBeat.o(138908);
            return aVar;
        }
        synchronized (this) {
            try {
                this.cHV.stopBGM();
                stopPreview();
                this.cHV.stopAudioRecord();
                this.cHV.stopPusher();
                this.cHV.setPushListener(null);
            } catch (Throwable th) {
                AppMethodBeat.o(138908);
                throw th;
            }
        }
        this.mInited = false;
        a aVar2 = new a();
        AppMethodBeat.o(138908);
        return aVar2;
    }

    public final a bV(int i2, int i3) {
        AppMethodBeat.i(138909);
        this.cHV.setSurfaceSize(i2, i3);
        a aVar = new a();
        AppMethodBeat.o(138909);
        return aVar;
    }

    public final a cc(boolean z) {
        AppMethodBeat.i(138910);
        this.cIa = this.cHV.isPushing();
        if (!this.cIa) {
            a aVar = new a();
            AppMethodBeat.o(138910);
            return aVar;
        } else if (z) {
            this.cIb = z;
            a f2 = f("stop", null);
            AppMethodBeat.o(138910);
            return f2;
        } else {
            a f3 = f("pause", null);
            AppMethodBeat.o(138910);
            return f3;
        }
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public final void onPushEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(138911);
        if (i2 == -1307 || i2 == -1313) {
            AnonymousClass3 r0 = new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.r.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(178840);
                    r.this.f("stop", null);
                    AppMethodBeat.o(178840);
                }
            };
            if (this.mHandler != null) {
                this.mHandler.post(r0);
            }
        } else if (i2 == 1003 && this.cIu) {
            this.cHV.turnOnFlashLight(this.cIu);
        }
        if (this.cHW != null) {
            this.cHW.onPushEvent(i2, bundle);
        }
        Log.i("TXLivePusherJSAdapter", "onPushEvent: event = " + i2 + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.o(138911);
    }

    @Override // com.tencent.rtmp.ITXLivePushListener
    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.i(138912);
        if (this.cHW != null) {
            this.cHW.onNetStatus(bundle);
        }
        Log.i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", "CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + APLogFileUtil.SEPARATOR_LOG + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO)))));
        AppMethodBeat.o(138912);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMStart() {
        AppMethodBeat.i(138913);
        this.cIf = true;
        if (this.cIv && this.cId != null) {
            this.cId.onBGMStart();
        }
        AppMethodBeat.o(138913);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMProgress(long j2, long j3) {
        AppMethodBeat.i(138914);
        if (this.cIv && this.cId != null) {
            this.cId.onBGMProgress(j2, j3);
        }
        AppMethodBeat.o(138914);
    }

    @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
    public final void onBGMComplete(int i2) {
        AppMethodBeat.i(138915);
        this.cIf = false;
        if (this.cIv && this.cId != null) {
            this.cId.onBGMComplete(i2);
        }
        AppMethodBeat.o(138915);
    }

    @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
    public final void onAudioVolumeEvaluationNotify(int i2) {
        AppMethodBeat.i(178841);
        if (this.cFF && this.cIe != null) {
            this.cIe.onAudioVolumeEvaluationNotify(i2);
        }
        AppMethodBeat.o(178841);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle, boolean z) {
        int i2;
        int i3;
        boolean z2;
        AppMethodBeat.i(138916);
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
            if (i4 == 6) {
                this.cHU.setPauseFlag(1);
            } else {
                this.cHU.setPauseFlag(3);
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
                    ca(true);
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
            this.cIG = bundle.getBoolean("customEffect", this.cIG);
            if (Qk()) {
                Log.i("TXLivePusherJSAdapter", "parseAndApplyParams, useCustomEffect");
                p(bundle);
                q(bundle);
                r(bundle);
                s(bundle);
            }
            AppMethodBeat.o(138916);
            return;
        }
        AppMethodBeat.o(138916);
    }

    static void l(String str, Bundle bundle) {
        AppMethodBeat.i(138917);
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
        AppMethodBeat.o(138917);
    }

    private boolean Qk() {
        AppMethodBeat.i(215656);
        if (!this.cIG || !this.cIE.isEnabled()) {
            AppMethodBeat.o(215656);
            return false;
        }
        AppMethodBeat.o(215656);
        return true;
    }

    private void p(Bundle bundle) {
        AppMethodBeat.i(215657);
        a(bundle, "skinWhiteness", l.a.SKIN_BRIGHT);
        AppMethodBeat.o(215657);
    }

    private void q(Bundle bundle) {
        AppMethodBeat.i(215658);
        a(bundle, "skinSmoothness", l.a.SKIN_SMOOTH);
        AppMethodBeat.o(215658);
    }

    private void r(Bundle bundle) {
        AppMethodBeat.i(215659);
        a(bundle, "faceThinness", l.a.FACE_THIN);
        AppMethodBeat.o(215659);
    }

    private void s(Bundle bundle) {
        AppMethodBeat.i(215660);
        a(bundle, "eyeBigness", l.a.EYE_BIGGER);
        AppMethodBeat.o(215660);
    }

    private boolean m(JSONObject jSONObject) {
        int length;
        AppMethodBeat.i(215661);
        if (!Qk()) {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, useCustomEffect is false");
            AppMethodBeat.o(215661);
            return false;
        }
        l.c o = o(jSONObject);
        if (o == null) {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType is null");
            AppMethodBeat.o(215661);
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("stickers");
        if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
            Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickersJsonArr is empty");
            AppMethodBeat.o(215661);
            return false;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerJsonObj(%d) is null", Integer.valueOf(i2));
                AppMethodBeat.o(215661);
                return false;
            }
            try {
                String string = optJSONObject.getString("title");
                int i3 = optJSONObject.getInt("len");
                String string2 = optJSONObject.getString("path");
                if (Util.isNullOrNil(string2)) {
                    Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, resDirPath is empty", Integer.valueOf(i2));
                    AppMethodBeat.o(215661);
                    return false;
                }
                String optString = optJSONObject.optString("md5", "");
                StickerItemInfo.a aVar = null;
                if (l.c.STICKER_2D == o || l.c.STICKER_FRONT == o) {
                    JSONArray jSONArray = optJSONObject.getJSONArray("pos");
                    if (4 != jSONArray.length()) {
                        Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, length of posJsonArr is not 4", Integer.valueOf(i2));
                        AppMethodBeat.o(215661);
                        return false;
                    }
                    aVar = new StickerItemInfo.a(jSONArray.getDouble(0), jSONArray.getDouble(1), jSONArray.getDouble(2), jSONArray.getDouble(3));
                }
                StickerItemInfo.StickerBackType stickerBackType = StickerItemInfo.StickerBackType.BACKGROUND;
                if (l.c.STICKER_BACK == o && (stickerBackType = StickerItemInfo.StickerBackType.from(optJSONObject.getInt("segtype"))) == null) {
                    Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, type is null", Integer.valueOf(i2));
                    AppMethodBeat.o(215661);
                    return false;
                }
                int optInt = optJSONObject.optInt("active", StickerItemInfo.TriggerAction.DEFAULT_ACTION_LOOP.getJsonVal());
                StickerItemInfo.TriggerAction from = StickerItemInfo.TriggerAction.from(optInt);
                if (from == null) {
                    Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, actionInt: %d, action is null", Integer.valueOf(i2), Integer.valueOf(optInt));
                    AppMethodBeat.o(215661);
                    return false;
                }
                arrayList.add(new StickerItemInfo(optJSONObject.optInt("id", i2), string, i3, from, string2, optString, aVar, stickerBackType));
            } catch (Exception e2) {
                Log.w("TXLivePusherJSAdapter", "applyStickerWorkaround, i: %d, convert fail since %s", Integer.valueOf(i2), e2);
                AppMethodBeat.o(215661);
                return false;
            }
        }
        Ql();
        Log.d("TXLivePusherJSAdapter", "applyStickerWorkaround, stickerType: %s", o);
        boolean a2 = this.cIE.a(o, arrayList);
        AppMethodBeat.o(215661);
        return a2;
    }

    private static float a(JSONObject jSONObject, String str) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        AppMethodBeat.i(215662);
        float optDouble = (float) jSONObject.optDouble(str, 1.0d);
        if (optDouble < 0.0f) {
            Log.i("TXLivePusherJSAdapter", "parseAlpha, alpha(%f) is illegal", Float.valueOf(optDouble));
        } else {
            f3 = optDouble;
        }
        if (f3 > 1.0f) {
            Log.i("TXLivePusherJSAdapter", "parseAlpha, alpha(%f)  is illegal", Float.valueOf(f3));
        } else {
            f2 = f3;
        }
        AppMethodBeat.o(215662);
        return f2;
    }

    private static n.a n(JSONObject jSONObject) {
        AppMethodBeat.i(215663);
        String optString = jSONObject.optString("color");
        if (Util.isNullOrNil(optString)) {
            Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is empty");
            AppMethodBeat.o(215663);
            return null;
        }
        try {
            int parseColor = Color.parseColor(optString);
            n.a aVar = new n.a(Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
            AppMethodBeat.o(215663);
            return aVar;
        } catch (Exception e2) {
            Log.w("TXLivePusherJSAdapter", "parseColor, colorStr is illegal");
            AppMethodBeat.o(215663);
            return null;
        }
    }

    private void a(Bundle bundle, String str, l.a aVar) {
        float f2 = 0.0f;
        AppMethodBeat.i(215664);
        if (!bundle.containsKey(str)) {
            Log.d("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, %s is not exist in params", str);
            AppMethodBeat.o(215664);
            return;
        }
        float f3 = bundle.getFloat(str, 0.0f);
        if (f3 < 0.0f) {
            Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", Float.valueOf(f3), str);
        } else {
            f2 = f3;
        }
        if (f2 > 1.0f) {
            Log.i("TXLivePusherJSAdapter", "applyFaceBeautyIfNeed, rate(%f) of %s is illegal", Float.valueOf(f2), str);
            f2 = 1.0f;
        }
        Ql();
        Log.d("TXLivePusherJSAdapter", "applyFaceBeauty, faceBeautyType: %s, rate: %f", aVar, Float.valueOf(f2));
        this.cIE.a(aVar, f2);
        AppMethodBeat.o(215664);
    }

    private static l.c o(JSONObject jSONObject) {
        AppMethodBeat.i(215665);
        String optString = jSONObject.optString("stickerType", null);
        if (Util.isNullOrNil(optString)) {
            Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr is empty");
            AppMethodBeat.o(215665);
            return null;
        } else if (optString.equalsIgnoreCase("back")) {
            l.c cVar = l.c.STICKER_BACK;
            AppMethodBeat.o(215665);
            return cVar;
        } else if (optString.equalsIgnoreCase("front")) {
            l.c cVar2 = l.c.STICKER_FRONT;
            AppMethodBeat.o(215665);
            return cVar2;
        } else if (optString.equalsIgnoreCase("2d")) {
            l.c cVar3 = l.c.STICKER_2D;
            AppMethodBeat.o(215665);
            return cVar3;
        } else {
            Log.w("TXLivePusherJSAdapter", "parseStickerType, stickerTypeStr: ".concat(String.valueOf(optString)));
            AppMethodBeat.o(215665);
            return null;
        }
    }

    private static l.b p(JSONObject jSONObject) {
        AppMethodBeat.i(215666);
        String optString = jSONObject.optString("makeupType", null);
        if (Util.isNullOrNil(optString)) {
            Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr is empty");
            AppMethodBeat.o(215666);
            return null;
        } else if (optString.equalsIgnoreCase("lipStick")) {
            l.b bVar = l.b.MAKEUP_LIP_STICK;
            AppMethodBeat.o(215666);
            return bVar;
        } else if (optString.equalsIgnoreCase("eyeShadow")) {
            l.b bVar2 = l.b.MAKEUP_EYE_SHADOW;
            AppMethodBeat.o(215666);
            return bVar2;
        } else if (optString.equalsIgnoreCase("blusherStick")) {
            l.b bVar3 = l.b.MAKEUP_BLUSHER_STICK;
            AppMethodBeat.o(215666);
            return bVar3;
        } else if (optString.equalsIgnoreCase("faceContour")) {
            l.b bVar4 = l.b.MAKEUP_FACE_CONTOUR;
            AppMethodBeat.o(215666);
            return bVar4;
        } else if (optString.equalsIgnoreCase("eyeBrow")) {
            l.b bVar5 = l.b.MAKEUP_EYE_BROW;
            AppMethodBeat.o(215666);
            return bVar5;
        } else {
            Log.w("TXLivePusherJSAdapter", "parseMakeupType, makeupTypeStr: ".concat(String.valueOf(optString)));
            AppMethodBeat.o(215666);
            return null;
        }
    }

    private void Ql() {
        AppMethodBeat.i(215667);
        if (!this.cIF) {
            Log.d("TXLivePusherJSAdapter", "applyWeEffect");
            this.cHU.setCustomModeType(256);
            this.cHV.setConfig(this.cHU);
            this.cHV.setVideoProcessListener(this.cIE);
            this.cIF = true;
        }
        AppMethodBeat.o(215667);
    }

    static /* synthetic */ void r(Bitmap bitmap) {
        AppMethodBeat.i(138919);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i("TXLivePusherJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.o(138919);
    }
}
