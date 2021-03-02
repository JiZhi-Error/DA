package com.tencent.liteav.trtc.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.dynamite.ProviderConstants;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXCSoundEffectPlayer;
import com.tencent.liteav.audio.b;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.h;
import com.tencent.liteav.o;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.videoencoder.b;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCSubCloud;
import com.tencent.wxmm.v2helper;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.XWalkCoreWrapper;

public class TRTCCloudImpl extends TRTCCloud implements SurfaceHolder.Callback, TXCRenderAndDec.b, b, c, d, e, f, com.tencent.liteav.basic.b.b, d.a, o, a.AbstractC0160a {
    private static final int DEFAULT_FPS_FOR_SCREEN_CAPTURE = 10;
    private static final int DEFAULT_GOP_FOR_SCREEN_CAPTURE = 3;
    private static final String KEY_CONFIG_ADJUST_RESOLUTION = "config_adjust_resolution";
    private static final String KEY_CONFIG_FPS = "config_fps";
    private static final String KEY_CONFIG_GOP = "config_gop";
    private static final int MIN_VOLUME_EVALUATION_INTERVAL_MS = 100;
    private static final int RECV_MODE_AUTO_AUDIO_ONLY = 2;
    private static final int RECV_MODE_AUTO_AUDIO_VIDEO = 1;
    private static final int RECV_MODE_AUTO_VIDEO_ONLY = 3;
    private static final int RECV_MODE_MANUAL = 4;
    private static final int RECV_MODE_UNKNOWN = 0;
    protected static final int ROOM_STATE_ENTRING = 1;
    private static final int ROOM_STATE_IN = 2;
    protected static final int ROOM_STATE_OUT = 0;
    private static final int STATE_INTERVAL = 2000;
    private static final String TAG = "TRTCCloudImpl";
    private static TRTCCloudImpl sInstance = null;
    public int mAppScene;
    private int mAudioCaptureVolume;
    public TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private int mAudioPlayoutVolume;
    public int mAudioVolumeEvalInterval;
    private TRTCCloud.BGMNotify mBGMNotify;
    private int mBackground;
    private com.tencent.liteav.basic.b.a mCallback;
    public com.tencent.liteav.d mCaptureAndEnc;
    private long mCaptureFrameCount;
    private int mCodecType;
    protected g mConfig;
    public Context mContext;
    private int mCurrentOrientation;
    public HashMap<Integer, TRTCCloudImpl> mCurrentPublishClouds;
    public int mCurrentRole;
    private boolean mCustomRemoteRender;
    private TRTCCustomTextureUtil mCustomVideoUtil;
    protected int mDebugType;
    private Display mDisplay;
    private boolean mEnableCustomAudioCapture;
    protected boolean mEnableEosMode;
    private boolean mEnableHighQualityEncode;
    private boolean mEnableHighQualityEncodeFromServer;
    private boolean mEnableSmallStream;
    private boolean mEnableSoftAEC;
    private boolean mEnableSoftAGC;
    private boolean mEnableSoftANS;
    private View mFloatingWindow;
    private int mFramework;
    private boolean mIsAudioCapturing;
    public boolean mIsExitOldRoom;
    private AtomicBoolean mIsSDKThreadAlive;
    private long mLastCaptureCalculateTS;
    private long mLastCaptureFrameCount;
    private long mLastLogCustomCmdMsgTs;
    private long mLastLogSEIMsgTs;
    private long mLastSendMsgTimeMs;
    public long mLastStateTimeMs;
    private final Bundle mLatestParamsOfBigEncoder;
    private final Bundle mLatestParamsOfSmallEncoder;
    private Handler mListenerHandler;
    private com.tencent.liteav.basic.util.e mMainHandler;
    public Object mNativeLock;
    public long mNativeRtcContext;
    private int mNetType;
    private DisplayOrientationDetector mOrientationEventListener;
    private boolean mOverrideFPSFromUser;
    public int mPerformanceMode;
    public int mPriorStreamType;
    private int mQosMode;
    private int mQosPreference;
    private long mRecvCustomCmdMsgCountInPeriod;
    public int mRecvMode;
    private long mRecvSEIMsgCountInPeriod;
    protected HashMap<String, RenderListenerAdapter> mRenderListenerMap;
    public TRTCRoomInfo mRoomInfo;
    public int mRoomState;
    public Handler mSDKHandler;
    private int mSendMsgCount;
    private int mSendMsgSize;
    private int mSensorMode;
    private final TRTCCloudDef.TRTCVideoEncParam mSmallEncParam;
    private int mSoftAECLevel;
    private int mSoftAGCLevel;
    private int mSoftANSLevel;
    private StatusTask mStatusNotifyTask;
    private Set<Integer> mStreamTypes;
    public ArrayList<WeakReference<TRTCCloudImpl>> mSubClouds;
    public TRTCCloudListener mTRTCListener;
    public int mTargetRole;
    private int mVideoRenderMirror;
    private TRTCVideoServerConfig mVideoServerConfig;
    private VideoSourceType mVideoSourceType;
    private VolumeLevelNotifyTask mVolumeLevelNotifyTask;
    final TXAudioEffectManager.TXVoiceReverbType[] reverbTypes;
    final TXAudioEffectManager.TXVoiceChangerType[] voiceChangerTypes;

    private native int nativeCancelDownStream(long j2, long j3, int i2, boolean z);

    private native void nativeChangeRole(long j2, int i2);

    private native int nativeConnectOtherRoom(long j2, String str);

    private native int nativeDisconnectOtherRoom(long j2);

    private native void nativeEnableBlackStream(long j2, boolean z);

    private native void nativeEnableSmallStream(long j2, boolean z);

    private native void nativeMuteUpstream(long j2, int i2, boolean z);

    private native void nativePushVideo(long j2, int i2, int i3, int i4, byte[] bArr, long j3, long j4, long j5, long j6, long j7);

    private native void nativeReenterRoom(long j2, int i2);

    private native int nativeRemoveUpstream(long j2, int i2);

    private native int nativeRequestDownStream(long j2, long j3, int i2, boolean z);

    private native void nativeRequestKeyFrame(long j2, long j3, int i2);

    private native void nativeSendCustomCmdMsg(long j2, int i2, String str, boolean z, boolean z2);

    private native void nativeSendJsonCmd(long j2, String str, String str2);

    private native void nativeSendSEIMsg(long j2, byte[] bArr, int i2);

    private native void nativeSetAudioEncodeConfiguration(long j2, int i2, int i3, int i4, int i5);

    private native void nativeSetDataReportDeviceInfo(String str, String str2, int i2);

    private native boolean nativeSetSEIPayloadType(long j2, int i2);

    private native void nativeSetVideoEncoderConfiguration(long j2, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8);

    private native void nativeSetVideoQuality(long j2, int i2, int i3);

    private native void nativeStartPublishCDNStream(long j2, TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam);

    private native void nativeStartPublishing(long j2, String str, int i2);

    private native void nativeStartSpeedTest(long j2, int i2, String str, String str2);

    private native void nativeStopPublishCDNStream(long j2);

    private native void nativeStopPublishing(long j2);

    private native void nativeStopSpeedTest(long j2);

    private native void nativeUpdatePrivateMapKey(long j2, String str);

    public native int nativeAddUpstream(long j2, int i2);

    public native long nativeCreateContext(int i2, int i3, int i4);

    public native void nativeDestroyContext(long j2);

    public native int nativeEnterRoom(long j2, long j3, String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, String str4, String str5, int i7, String str6, String str7, int i8);

    /* access modifiers changed from: protected */
    public native int nativeExitRoom(long j2);

    /* access modifiers changed from: protected */
    public native void nativeFlushC2SVideoCodecConfig(long j2, int i2);

    public native void nativeInit(long j2, int i2, String str, String str2, byte[] bArr);

    /* access modifiers changed from: protected */
    public native void nativeSetMixTranscodingConfig(long j2, TRTCTranscodingConfigInner tRTCTranscodingConfigInner);

    public native int nativeSetPriorRemoteVideoStreamType(long j2, int i2);

    static /* synthetic */ void access$1000(TRTCCloudImpl tRTCCloudImpl, String str, String str2, int i2) {
        AppMethodBeat.i(259893);
        tRTCCloudImpl.nativeSetDataReportDeviceInfo(str, str2, i2);
        AppMethodBeat.o(259893);
    }

    static /* synthetic */ void access$1300(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259894);
        tRTCCloudImpl.addUpStreamType(i2);
        AppMethodBeat.o(259894);
    }

    static /* synthetic */ int access$1700(TRTCCloudImpl tRTCCloudImpl, long j2, String str) {
        AppMethodBeat.i(259895);
        int nativeConnectOtherRoom = tRTCCloudImpl.nativeConnectOtherRoom(j2, str);
        AppMethodBeat.o(259895);
        return nativeConnectOtherRoom;
    }

    static /* synthetic */ int access$1800(TRTCCloudImpl tRTCCloudImpl, long j2) {
        AppMethodBeat.i(259896);
        int nativeDisconnectOtherRoom = tRTCCloudImpl.nativeDisconnectOtherRoom(j2);
        AppMethodBeat.o(259896);
        return nativeDisconnectOtherRoom;
    }

    static /* synthetic */ void access$1900(TRTCCloudImpl tRTCCloudImpl, long j2, int i2) {
        AppMethodBeat.i(259897);
        tRTCCloudImpl.nativeChangeRole(j2, i2);
        AppMethodBeat.o(259897);
    }

    static /* synthetic */ void access$2100(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259898);
        tRTCCloudImpl.updateOrientation();
        AppMethodBeat.o(259898);
    }

    static /* synthetic */ void access$2200(TRTCCloudImpl tRTCCloudImpl, Runnable runnable) {
        AppMethodBeat.i(259899);
        tRTCCloudImpl.runOnMainThreadAndWaitDone(runnable);
        AppMethodBeat.o(259899);
    }

    static /* synthetic */ TRTCRoomInfo.UserInfo access$2300(TRTCCloudImpl tRTCCloudImpl, String str) {
        AppMethodBeat.i(259900);
        TRTCRoomInfo.UserInfo createUserInfo = tRTCCloudImpl.createUserInfo(str);
        AppMethodBeat.o(259900);
        return createUserInfo;
    }

    static /* synthetic */ void access$2400(TRTCCloudImpl tRTCCloudImpl, String str, int i2, int i3, String str2) {
        AppMethodBeat.i(259901);
        tRTCCloudImpl.notifyLogByUserId(str, i2, i3, str2);
        AppMethodBeat.o(259901);
    }

    static /* synthetic */ void access$2500(TRTCCloudImpl tRTCCloudImpl, TXCRenderAndDec tXCRenderAndDec, int i2) {
        AppMethodBeat.i(259902);
        tRTCCloudImpl.startRemoteRender(tXCRenderAndDec, i2);
        AppMethodBeat.o(259902);
    }

    static /* synthetic */ int access$2600(TRTCCloudImpl tRTCCloudImpl, long j2, long j3, int i2, boolean z) {
        AppMethodBeat.i(222520);
        int nativeRequestDownStream = tRTCCloudImpl.nativeRequestDownStream(j2, j3, i2, z);
        AppMethodBeat.o(222520);
        return nativeRequestDownStream;
    }

    static /* synthetic */ int access$2700(TRTCCloudImpl tRTCCloudImpl, long j2, long j3, int i2, boolean z) {
        AppMethodBeat.i(259903);
        int nativeCancelDownStream = tRTCCloudImpl.nativeCancelDownStream(j2, j3, i2, z);
        AppMethodBeat.o(259903);
        return nativeCancelDownStream;
    }

    static /* synthetic */ void access$2800(TRTCCloudImpl tRTCCloudImpl, TRTCRoomInfo.UserInfo userInfo, Boolean bool) {
        AppMethodBeat.i(259904);
        tRTCCloudImpl.stopRemoteMainRender(userInfo, bool);
        AppMethodBeat.o(259904);
    }

    static /* synthetic */ void access$2900(TRTCCloudImpl tRTCCloudImpl, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(259905);
        tRTCCloudImpl.stopRemoteSubRender(userInfo);
        AppMethodBeat.o(259905);
    }

    static /* synthetic */ void access$3000(TRTCCloudImpl tRTCCloudImpl, String str) {
        AppMethodBeat.i(259906);
        tRTCCloudImpl.notifyCaptureStarted(str);
        AppMethodBeat.o(259906);
    }

    static /* synthetic */ void access$3300(TRTCCloudImpl tRTCCloudImpl, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        AppMethodBeat.i(259907);
        tRTCCloudImpl.setVideoEncoderParamInternal(tRTCVideoEncParam);
        AppMethodBeat.o(259907);
    }

    static /* synthetic */ void access$3400(TRTCCloudImpl tRTCCloudImpl, boolean z, int i2, int i3, int i4, int i5, boolean z2, int i6) {
        AppMethodBeat.i(259908);
        tRTCCloudImpl.updateBigStreamEncoder(z, i2, i3, i4, i5, z2, i6);
        AppMethodBeat.o(259908);
    }

    static /* synthetic */ g.a access$3500(TRTCCloudImpl tRTCCloudImpl, int i2, int i3) {
        AppMethodBeat.i(259909);
        g.a sizeByResolution = tRTCCloudImpl.getSizeByResolution(i2, i3);
        AppMethodBeat.o(259909);
        return sizeByResolution;
    }

    static /* synthetic */ void access$3600(TRTCCloudImpl tRTCCloudImpl, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(259910);
        tRTCCloudImpl.updateSmallStreamEncoder(i2, i3, i4, i5, i6);
        AppMethodBeat.o(259910);
    }

    static /* synthetic */ void access$3700(TRTCCloudImpl tRTCCloudImpl, View view) {
        AppMethodBeat.i(259911);
        tRTCCloudImpl.showFloatingWindow(view);
        AppMethodBeat.o(259911);
    }

    static /* synthetic */ void access$3800(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(16009);
        tRTCCloudImpl.hideFloatingWindow();
        AppMethodBeat.o(16009);
    }

    static /* synthetic */ void access$4100(TRTCCloudImpl tRTCCloudImpl, int i2, boolean z) {
        AppMethodBeat.i(259912);
        tRTCCloudImpl.muteUpstream(i2, z);
        AppMethodBeat.o(259912);
    }

    static /* synthetic */ void access$4200(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259913);
        tRTCCloudImpl.removeUpStreamType(i2);
        AppMethodBeat.o(259913);
    }

    static /* synthetic */ void access$4400(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259914);
        tRTCCloudImpl.setQoSParams();
        AppMethodBeat.o(259914);
    }

    static /* synthetic */ void access$4700(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259915);
        tRTCCloudImpl.setAudioEncodeConfiguration();
        AppMethodBeat.o(259915);
    }

    static /* synthetic */ void access$500(TRTCCloudImpl tRTCCloudImpl, int i2, int i3) {
        AppMethodBeat.i(259890);
        tRTCCloudImpl.setVideoQuality(i2, i3);
        AppMethodBeat.o(259890);
    }

    static /* synthetic */ void access$5100(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222534);
        tRTCCloudImpl.setLocalAudioMuteMode(jSONObject);
        AppMethodBeat.o(222534);
    }

    static /* synthetic */ void access$5200(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222535);
        tRTCCloudImpl.setVideoEncoderParamEx(jSONObject);
        AppMethodBeat.o(222535);
    }

    static /* synthetic */ void access$5300(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222536);
        tRTCCloudImpl.setAudioSampleRate(jSONObject);
        AppMethodBeat.o(222536);
    }

    static /* synthetic */ void access$5400(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222537);
        tRTCCloudImpl.enableAudioAGC(jSONObject);
        AppMethodBeat.o(222537);
    }

    static /* synthetic */ void access$5500(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222538);
        tRTCCloudImpl.enableAudioAEC(jSONObject);
        AppMethodBeat.o(222538);
    }

    static /* synthetic */ void access$5600(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222539);
        tRTCCloudImpl.enableAudioANS(jSONObject);
        AppMethodBeat.o(222539);
    }

    static /* synthetic */ void access$5700(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222540);
        tRTCCloudImpl.setCustomRenderMode(jSONObject);
        AppMethodBeat.o(222540);
    }

    static /* synthetic */ void access$5800(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222541);
        tRTCCloudImpl.setMediaCodecConfig(jSONObject);
        AppMethodBeat.o(222541);
    }

    static /* synthetic */ void access$5900(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(222542);
        tRTCCloudImpl.setFramework(jSONObject);
        AppMethodBeat.o(222542);
    }

    static /* synthetic */ void access$600(TRTCCloudImpl tRTCCloudImpl, int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        AppMethodBeat.i(259891);
        tRTCCloudImpl.setVideoEncConfig(i2, i3, i4, i5, i6, z, i7);
        AppMethodBeat.o(259891);
    }

    static /* synthetic */ void access$6000(TRTCCloudImpl tRTCCloudImpl, JSONObject jSONObject) {
        AppMethodBeat.i(259916);
        tRTCCloudImpl.forceCallbackMixedPlayAudioFrame(jSONObject);
        AppMethodBeat.o(259916);
    }

    static /* synthetic */ com.tencent.liteav.basic.a.b access$6400(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259917);
        com.tencent.liteav.basic.a.b pixelFormat = tRTCCloudImpl.getPixelFormat(i2);
        AppMethodBeat.o(259917);
        return pixelFormat;
    }

    static /* synthetic */ void access$6600(TRTCCloudImpl tRTCCloudImpl, long j2, int i2, String str, String str2) {
        AppMethodBeat.i(259918);
        tRTCCloudImpl.nativeStartSpeedTest(j2, i2, str, str2);
        AppMethodBeat.o(259918);
    }

    static /* synthetic */ void access$6700(TRTCCloudImpl tRTCCloudImpl, long j2) {
        AppMethodBeat.i(222548);
        tRTCCloudImpl.nativeStopSpeedTest(j2);
        AppMethodBeat.o(222548);
    }

    static /* synthetic */ void access$6800(TRTCCloudImpl tRTCCloudImpl, long j2, TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        AppMethodBeat.i(259919);
        tRTCCloudImpl.nativeStartPublishCDNStream(j2, tRTCPublishCDNParam);
        AppMethodBeat.o(259919);
    }

    static /* synthetic */ void access$6900(TRTCCloudImpl tRTCCloudImpl, long j2) {
        AppMethodBeat.i(259920);
        tRTCCloudImpl.nativeStopPublishing(j2);
        AppMethodBeat.o(259920);
    }

    static /* synthetic */ void access$7000(TRTCCloudImpl tRTCCloudImpl, long j2) {
        AppMethodBeat.i(259921);
        tRTCCloudImpl.nativeStopPublishCDNStream(j2);
        AppMethodBeat.o(259921);
    }

    static /* synthetic */ void access$7100(TRTCCloudImpl tRTCCloudImpl, long j2, String str, int i2) {
        AppMethodBeat.i(259922);
        tRTCCloudImpl.nativeStartPublishing(j2, str, i2);
        AppMethodBeat.o(259922);
    }

    static /* synthetic */ void access$7200(TRTCCloudImpl tRTCCloudImpl, long j2, int i2, String str, boolean z, boolean z2) {
        AppMethodBeat.i(259923);
        tRTCCloudImpl.nativeSendCustomCmdMsg(j2, i2, str, z, z2);
        AppMethodBeat.o(259923);
    }

    static /* synthetic */ void access$7300(TRTCCloudImpl tRTCCloudImpl, long j2, byte[] bArr, int i2) {
        AppMethodBeat.i(259924);
        tRTCCloudImpl.nativeSendSEIMsg(j2, bArr, i2);
        AppMethodBeat.o(259924);
    }

    static /* synthetic */ void access$7400(TRTCCloudImpl tRTCCloudImpl, String str, int i2, Bundle bundle) {
        AppMethodBeat.i(259925);
        tRTCCloudImpl.notifyEventByUserId(str, i2, bundle);
        AppMethodBeat.o(259925);
    }

    static /* synthetic */ void access$7500(TRTCCloudImpl tRTCCloudImpl, long j2, long j3, int i2) {
        AppMethodBeat.i(259926);
        tRTCCloudImpl.nativeRequestKeyFrame(j2, j3, i2);
        AppMethodBeat.o(259926);
    }

    static /* synthetic */ void access$7600(TRTCCloudImpl tRTCCloudImpl, String str, int i2, String str2) {
        AppMethodBeat.i(259927);
        tRTCCloudImpl.notifyEvent(str, i2, str2);
        AppMethodBeat.o(259927);
    }

    static /* synthetic */ void access$7700(TRTCCloudImpl tRTCCloudImpl, Runnable runnable, int i2) {
        AppMethodBeat.i(259928);
        tRTCCloudImpl.runOnSDKThread(runnable, i2);
        AppMethodBeat.o(259928);
    }

    static /* synthetic */ void access$7800(TRTCCloudImpl tRTCCloudImpl, int i2, String str) {
        AppMethodBeat.i(259929);
        tRTCCloudImpl.onExitRoom(i2, str);
        AppMethodBeat.o(259929);
    }

    static /* synthetic */ TXCRenderAndDec access$7900(TRTCCloudImpl tRTCCloudImpl, long j2, int i2) {
        AppMethodBeat.i(259930);
        TXCRenderAndDec createRender = tRTCCloudImpl.createRender(j2, i2);
        AppMethodBeat.o(259930);
        return createRender;
    }

    static /* synthetic */ void access$8000(TRTCCloudImpl tRTCCloudImpl, String str, int i2, String str2) {
        AppMethodBeat.i(259931);
        tRTCCloudImpl.appendDashboardLog(str, i2, str2);
        AppMethodBeat.o(259931);
    }

    static /* synthetic */ long access$8108(TRTCCloudImpl tRTCCloudImpl) {
        long j2 = tRTCCloudImpl.mRecvSEIMsgCountInPeriod;
        tRTCCloudImpl.mRecvSEIMsgCountInPeriod = 1 + j2;
        return j2;
    }

    static /* synthetic */ void access$8300(TRTCCloudImpl tRTCCloudImpl, TXCRenderAndDec tXCRenderAndDec, h hVar) {
        AppMethodBeat.i(259932);
        tRTCCloudImpl.applyRenderPlayStrategy(tXCRenderAndDec, hVar);
        AppMethodBeat.o(259932);
    }

    static /* synthetic */ int access$8400(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259933);
        int translateStreamType = tRTCCloudImpl.translateStreamType(i2);
        AppMethodBeat.o(259933);
        return translateStreamType;
    }

    static /* synthetic */ void access$8600(TRTCCloudImpl tRTCCloudImpl, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(259934);
        tRTCCloudImpl.appendDashboardLog(str, i2, str2, str3);
        AppMethodBeat.o(259934);
    }

    static /* synthetic */ Pair access$8700(TRTCCloudImpl tRTCCloudImpl, Bundle bundle) {
        AppMethodBeat.i(259935);
        Pair<Integer, String> encoderTypeAndMsg = tRTCCloudImpl.getEncoderTypeAndMsg(bundle);
        AppMethodBeat.o(259935);
        return encoderTypeAndMsg;
    }

    static /* synthetic */ void access$8900(TRTCCloudImpl tRTCCloudImpl, long j2, int i2) {
        AppMethodBeat.i(259936);
        tRTCCloudImpl.nativeReenterRoom(j2, i2);
        AppMethodBeat.o(259936);
    }

    static /* synthetic */ void access$900(TRTCCloudImpl tRTCCloudImpl, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8) {
        AppMethodBeat.i(259892);
        tRTCCloudImpl.setVideoEncoderConfiguration(i2, i3, i4, i5, i6, i7, z, i8);
        AppMethodBeat.o(259892);
    }

    static /* synthetic */ void access$9100(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259937);
        tRTCCloudImpl.checkRTCState();
        AppMethodBeat.o(259937);
    }

    static /* synthetic */ void access$9200(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259938);
        tRTCCloudImpl.collectCustomCaptureFps();
        AppMethodBeat.o(259938);
    }

    static /* synthetic */ void access$9300(TRTCCloudImpl tRTCCloudImpl, TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo, TRTCStatistics tRTCStatistics, ArrayList arrayList) {
        AppMethodBeat.i(259939);
        tRTCCloudImpl.addRemoteStatistics(tXCRenderAndDec, userInfo, tRTCStatistics, arrayList);
        AppMethodBeat.o(259939);
    }

    static /* synthetic */ void access$9400(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259940);
        tRTCCloudImpl.checkRenderRotation(i2);
        AppMethodBeat.o(259940);
    }

    static /* synthetic */ void access$9500(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259941);
        tRTCCloudImpl.checkVideoEncRotation(i2);
        AppMethodBeat.o(259941);
    }

    static /* synthetic */ int access$9600(TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(259942);
        int displayRotation = tRTCCloudImpl.getDisplayRotation();
        AppMethodBeat.o(259942);
        return displayRotation;
    }

    static /* synthetic */ void access$9700(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(259943);
        tRTCCloudImpl.setOrientation(i2);
        AppMethodBeat.o(259943);
    }

    static {
        AppMethodBeat.i(16059);
        com.tencent.liteav.basic.util.f.f();
        AppMethodBeat.o(16059);
    }

    public static TRTCCloud sharedInstance(Context context) {
        TRTCCloudImpl tRTCCloudImpl;
        AppMethodBeat.i(15779);
        synchronized (TRTCCloudImpl.class) {
            try {
                if (sInstance == null) {
                    sInstance = new TRTCCloudImpl(context);
                }
                tRTCCloudImpl = sInstance;
            } finally {
                AppMethodBeat.o(15779);
            }
        }
        return tRTCCloudImpl;
    }

    public static void destroySharedInstance() {
        AppMethodBeat.i(15780);
        synchronized (TRTCCloudImpl.class) {
            try {
                if (sInstance != null) {
                    TXCLog.i(TAG, "trtc_api destroy instance self:" + sInstance.hashCode());
                    sInstance.destroy();
                    sInstance = null;
                }
            } finally {
                AppMethodBeat.o(15780);
            }
        }
    }

    protected TRTCCloudImpl(Context context) {
        AppMethodBeat.i(15781);
        this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[]{TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7};
        this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[]{TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11};
        this.mNativeLock = new Object();
        this.mAudioFrameListener = null;
        this.mPriorStreamType = 2;
        this.mEnableSmallStream = false;
        this.mVideoRenderMirror = 0;
        this.mCustomRemoteRender = false;
        this.mEnableHighQualityEncode = false;
        this.mEnableHighQualityEncodeFromServer = false;
        this.mAudioVolumeEvalInterval = 0;
        this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        this.mQosMode = 1;
        this.mEnableEosMode = false;
        this.mCodecType = 2;
        this.mEnableSoftAEC = true;
        this.mEnableSoftANS = false;
        this.mEnableSoftAGC = false;
        this.mSoftAECLevel = 100;
        this.mSoftANSLevel = 100;
        this.mSoftAGCLevel = 100;
        this.mAudioCaptureVolume = 100;
        this.mAudioPlayoutVolume = 100;
        this.mCustomVideoUtil = null;
        this.mEnableCustomAudioCapture = false;
        this.mCurrentRole = 20;
        this.mTargetRole = 20;
        this.mLastCaptureCalculateTS = 0;
        this.mCaptureFrameCount = 0;
        this.mLastCaptureFrameCount = 0;
        this.mPerformanceMode = 0;
        this.mCurrentOrientation = -1;
        this.mFloatingWindow = null;
        this.mOverrideFPSFromUser = false;
        this.mLatestParamsOfBigEncoder = new Bundle();
        this.mLatestParamsOfSmallEncoder = new Bundle();
        this.mFramework = 1;
        this.mCallback = new com.tencent.liteav.basic.b.a() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass1 */

            @Override // com.tencent.liteav.basic.b.a
            public void onEvent(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222393);
                TXCLog.i(TRTCCloudImpl.TAG, "onEvent => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EVT_USERID", str);
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2 + (str3 != null ? str3 : ""));
                    }
                    TRTCCloudImpl.this.onNotifyEvent(i2, bundle);
                }
                Monitor.a(2, i2, str2, str3, 0, 0);
                AppMethodBeat.o(222393);
            }

            @Override // com.tencent.liteav.basic.b.a
            public void onError(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222394);
                TXCLog.e(TRTCCloudImpl.TAG, "onError => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EVT_USERID", str);
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2 + (str3 != null ? str3 : ""));
                    }
                    TRTCCloudImpl.this.onNotifyEvent(i2, bundle);
                }
                Monitor.a(3, i2, str2, str3, 0, 0);
                AppMethodBeat.o(222394);
            }
        };
        this.mSubClouds = new ArrayList<>();
        this.mCurrentPublishClouds = new HashMap<>();
        this.mVolumeLevelNotifyTask = null;
        this.mDebugType = 0;
        this.mStatusNotifyTask = null;
        this.mNetType = -1;
        this.mBackground = -1;
        init(context, null);
        TXCCommonUtil.setAppContext(this.mContext);
        TXCLog.init();
        TRTCAudioServerConfig loadFromSharedPreferences = TRTCAudioServerConfig.loadFromSharedPreferences(context);
        TXCLog.i(TAG, "audio config from shared preference: %s", loadFromSharedPreferences);
        TXCAudioEngine.CreateInstanceWithoutInitDevice(this.mContext, TXCAudioEngine.buildTRAEConfig(context, Boolean.valueOf(loadFromSharedPreferences.enableOpenSL), loadFromSharedPreferences.isLowLatencySampleRateSupported, loadFromSharedPreferences.lowLatencySampleRateBlockTime));
        TXCAudioEngine.getInstance().clean();
        TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
        TXCAudioEngine.getInstance().addEventCallback(new WeakReference<>(this.mCallback));
        TXCAudioEngine.getInstance().enableAutoRestartDevice(loadFromSharedPreferences.enableAutoRestartDevice);
        TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(loadFromSharedPreferences.maxSelectedPlayStreams);
        TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(true);
        this.mCaptureAndEnc = new com.tencent.liteav.d(context);
        this.mCaptureAndEnc.j(2);
        this.mCaptureAndEnc.a(this.mConfig);
        this.mCaptureAndEnc.i(true);
        this.mCaptureAndEnc.g(true);
        this.mCaptureAndEnc.a((com.tencent.liteav.basic.b.b) this);
        this.mCaptureAndEnc.a((d.a) this);
        this.mCaptureAndEnc.setID("18446744073709551615");
        this.mCaptureAndEnc.h(true);
        TXCKeyPointReportProxy.a(this.mContext);
        apiLog("reset audio volume");
        setAudioCaptureVolume(100);
        setAudioPlayoutVolume(100);
        TXCSoundEffectPlayer.getInstance().setSoundEffectListener(this);
        AppMethodBeat.o(15781);
    }

    protected TRTCCloudImpl(Context context, Handler handler) {
        AppMethodBeat.i(222451);
        this.reverbTypes = new TXAudioEffectManager.TXVoiceReverbType[]{TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7};
        this.voiceChangerTypes = new TXAudioEffectManager.TXVoiceChangerType[]{TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11};
        this.mNativeLock = new Object();
        this.mAudioFrameListener = null;
        this.mPriorStreamType = 2;
        this.mEnableSmallStream = false;
        this.mVideoRenderMirror = 0;
        this.mCustomRemoteRender = false;
        this.mEnableHighQualityEncode = false;
        this.mEnableHighQualityEncodeFromServer = false;
        this.mAudioVolumeEvalInterval = 0;
        this.mSmallEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        this.mQosMode = 1;
        this.mEnableEosMode = false;
        this.mCodecType = 2;
        this.mEnableSoftAEC = true;
        this.mEnableSoftANS = false;
        this.mEnableSoftAGC = false;
        this.mSoftAECLevel = 100;
        this.mSoftANSLevel = 100;
        this.mSoftAGCLevel = 100;
        this.mAudioCaptureVolume = 100;
        this.mAudioPlayoutVolume = 100;
        this.mCustomVideoUtil = null;
        this.mEnableCustomAudioCapture = false;
        this.mCurrentRole = 20;
        this.mTargetRole = 20;
        this.mLastCaptureCalculateTS = 0;
        this.mCaptureFrameCount = 0;
        this.mLastCaptureFrameCount = 0;
        this.mPerformanceMode = 0;
        this.mCurrentOrientation = -1;
        this.mFloatingWindow = null;
        this.mOverrideFPSFromUser = false;
        this.mLatestParamsOfBigEncoder = new Bundle();
        this.mLatestParamsOfSmallEncoder = new Bundle();
        this.mFramework = 1;
        this.mCallback = new com.tencent.liteav.basic.b.a() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass1 */

            @Override // com.tencent.liteav.basic.b.a
            public void onEvent(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222393);
                TXCLog.i(TRTCCloudImpl.TAG, "onEvent => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EVT_USERID", str);
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2 + (str3 != null ? str3 : ""));
                    }
                    TRTCCloudImpl.this.onNotifyEvent(i2, bundle);
                }
                Monitor.a(2, i2, str2, str3, 0, 0);
                AppMethodBeat.o(222393);
            }

            @Override // com.tencent.liteav.basic.b.a
            public void onError(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222394);
                TXCLog.e(TRTCCloudImpl.TAG, "onError => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("EVT_USERID", str);
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str2 + (str3 != null ? str3 : ""));
                    }
                    TRTCCloudImpl.this.onNotifyEvent(i2, bundle);
                }
                Monitor.a(3, i2, str2, str3, 0, 0);
                AppMethodBeat.o(222394);
            }
        };
        this.mSubClouds = new ArrayList<>();
        this.mCurrentPublishClouds = new HashMap<>();
        this.mVolumeLevelNotifyTask = null;
        this.mDebugType = 0;
        this.mStatusNotifyTask = null;
        this.mNetType = -1;
        this.mBackground = -1;
        init(context, handler);
        this.mCurrentRole = 21;
        this.mTargetRole = 21;
        AppMethodBeat.o(222451);
    }

    private void init(Context context, Handler handler) {
        int i2;
        int i3;
        AppMethodBeat.i(222452);
        this.mCurrentPublishClouds.put(2, this);
        this.mCurrentPublishClouds.put(3, this);
        this.mCurrentPublishClouds.put(7, this);
        this.mCurrentPublishClouds.put(1, this);
        this.mContext = context.getApplicationContext();
        this.mConfig = new g();
        this.mConfig.k = com.tencent.liteav.basic.a.c.RESOLUTION_TYPE_640_360;
        this.mConfig.X = 90;
        this.mConfig.f786j = 0;
        this.mConfig.P = true;
        this.mConfig.f784h = 15;
        this.mConfig.K = false;
        this.mConfig.T = false;
        this.mConfig.U = false;
        this.mConfig.f777a = 368;
        this.mConfig.f778b = 640;
        this.mConfig.f779c = 750;
        this.mConfig.f781e = 0;
        this.mConfig.W = false;
        this.mRoomInfo = new TRTCRoomInfo();
        this.mRoomInfo.bigEncSize.f788a = 368;
        this.mRoomInfo.bigEncSize.f789b = 640;
        this.mMainHandler = new com.tencent.liteav.basic.util.e(context.getMainLooper());
        this.mListenerHandler = new Handler(context.getMainLooper());
        this.mIsSDKThreadAlive = new AtomicBoolean(true);
        if (handler != null) {
            this.mSDKHandler = handler;
        } else {
            HandlerThread handlerThread = new HandlerThread("TRTCCloudApi");
            handlerThread.start();
            this.mSDKHandler = new Handler(handlerThread.getLooper());
        }
        this.mStatusNotifyTask = new StatusTask(this);
        this.mLastSendMsgTimeMs = 0;
        this.mSendMsgCount = 0;
        this.mSendMsgSize = 0;
        this.mSensorMode = 2;
        this.mAppScene = 0;
        this.mQosPreference = 2;
        this.mQosMode = 1;
        this.mOrientationEventListener = new DisplayOrientationDetector(this.mContext, this);
        this.mDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.mRenderListenerMap = new HashMap<>();
        this.mStreamTypes = new HashSet();
        synchronized (this.mNativeLock) {
            try {
                int[] sDKVersion = TXCCommonUtil.getSDKVersion();
                int i4 = sDKVersion.length > 0 ? sDKVersion[0] : 0;
                if (sDKVersion.length >= 2) {
                    i2 = sDKVersion[1];
                } else {
                    i2 = 0;
                }
                if (sDKVersion.length >= 3) {
                    i3 = sDKVersion[2];
                } else {
                    i3 = 0;
                }
                this.mNativeRtcContext = nativeCreateContext(i4, i2, i3);
            } catch (Throwable th) {
                AppMethodBeat.o(222452);
                throw th;
            }
        }
        apiLog("trtc cloud create");
        this.mRoomState = 0;
        this.mVideoSourceType = VideoSourceType.NONE;
        this.mIsAudioCapturing = false;
        this.mCurrentRole = 20;
        this.mTargetRole = 20;
        this.mRecvMode = 1;
        this.mLatestParamsOfBigEncoder.putInt(KEY_CONFIG_GOP, this.mConfig.f785i);
        this.mLatestParamsOfSmallEncoder.putInt(KEY_CONFIG_GOP, this.mConfig.f785i);
        identifyTRTCFrameworkType();
        this.mVideoServerConfig = TRTCVideoServerConfig.loadFromSharedPreferences(context);
        AppMethodBeat.o(222452);
    }

    public void destroy() {
        AppMethodBeat.i(15782);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(15668);
                TXCAudioEngineJNI.nativeSetAudioPlayoutTunnelEnabled(false);
                synchronized (TRTCCloudImpl.this.mNativeLock) {
                    try {
                        if (TRTCCloudImpl.this.mNativeRtcContext != 0) {
                            TRTCCloudImpl.this.apiLog("destroy context");
                            TRTCCloudImpl.this.nativeDestroyContext(TRTCCloudImpl.this.mNativeRtcContext);
                        }
                        TRTCCloudImpl.this.mNativeRtcContext = 0;
                    } finally {
                        AppMethodBeat.o(15668);
                    }
                }
                TRTCCloudImpl.this.mTRTCListener = null;
                TRTCCloudImpl.this.mAudioFrameListener = null;
                TRTCCloudImpl.this.setAudioCaptureVolume(100);
                TRTCCloudImpl.this.setAudioPlayoutVolume(100);
                TXCSoundEffectPlayer.getInstance().setSoundEffectListener(null);
                TXCAudioEngine.getInstance().clean();
                TXCAudioEngine.getInstance().UnInitAudioDevice();
                synchronized (TRTCCloudImpl.this.mCurrentPublishClouds) {
                    try {
                        TRTCCloudImpl.this.mCurrentPublishClouds.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator<WeakReference<TRTCCloudImpl>> it = TRTCCloudImpl.this.mSubClouds.iterator();
                while (it.hasNext()) {
                    TRTCCloudImpl tRTCCloudImpl = it.next().get();
                    if (tRTCCloudImpl != null) {
                        tRTCCloudImpl.destroy();
                    }
                }
                TRTCCloudImpl.this.mSubClouds.clear();
                TRTCCloudImpl.this.mIsSDKThreadAlive.set(false);
                try {
                    if (TRTCCloudImpl.this.mSDKHandler != null) {
                        TRTCCloudImpl.this.mSDKHandler.getLooper().quit();
                    }
                } catch (Exception e2) {
                    TXCLog.e(TRTCCloudImpl.TAG, "(" + TRTCCloudImpl.this.hashCode() + ") error occur when quit looper.", e2);
                } catch (Error e3) {
                    TXCLog.e(TRTCCloudImpl.TAG, "(" + TRTCCloudImpl.this.hashCode() + ") error occur when quit looper.");
                }
                TRTCCloudImpl.this.apiLog("destroy instance finish.");
                AppMethodBeat.o(15668);
            }
        });
        AppMethodBeat.o(15782);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListener(final TRTCCloudListener tRTCCloudListener) {
        AppMethodBeat.i(15783);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(15634);
                TRTCCloudImpl.this.apiLog("setListener " + tRTCCloudListener);
                TRTCCloudImpl.this.mTRTCListener = tRTCCloudListener;
                AppMethodBeat.o(15634);
            }
        });
        AppMethodBeat.o(15783);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setListenerHandler(Handler handler) {
        AppMethodBeat.i(15784);
        apiLog("setListenerHandler ".concat(String.valueOf(handler)));
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(15578);
                Iterator<WeakReference<TRTCCloudImpl>> it = TRTCCloudImpl.this.mSubClouds.iterator();
                while (it.hasNext()) {
                    TRTCCloudImpl tRTCCloudImpl = it.next().get();
                    if (tRTCCloudImpl != null) {
                        tRTCCloudImpl.setListenerHandler(TRTCCloudImpl.this.mListenerHandler);
                    } else {
                        it.remove();
                    }
                }
                AppMethodBeat.o(15578);
            }
        });
        AppMethodBeat.o(15784);
    }

    /* access modifiers changed from: package-private */
    public void extractBizInfo(JSONObject jSONObject, String str, StringBuilder sb) {
        AppMethodBeat.i(222453);
        if (str.equals("strGroupId")) {
            sb.append(jSONObject.optString("strGroupId").toString());
            jSONObject.remove("strGroupId");
            jSONObject.remove("Role");
        }
        apiLog("extractBizInfo: key" + str + " value:" + sb.toString());
        AppMethodBeat.o(222453);
    }

    private void identifyTRTCFrameworkType() {
        StackTraceElement[] stackTrace;
        AppMethodBeat.i(222454);
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (className.contains("TRTCMeetingImpl") || className.contains("TRTCLiveRoomImpl") || className.contains("TRTCAudioCallImpl") || className.contains("TRTCVideoCallImpl") || className.contains("TRTCVoiceRoomImpl") || className.contains("TRTCAVCallImpl")) {
                    TXCLog.i(TAG, "identifyTRTCFrameworkType callName:".concat(String.valueOf(className)));
                    this.mFramework = 5;
                    AppMethodBeat.o(222454);
                    return;
                } else if (className.contains("WXTRTCCloud")) {
                    TXCLog.i(TAG, "identifyTRTCFrameworkType callName:".concat(String.valueOf(className)));
                    this.mFramework = 3;
                    AppMethodBeat.o(222454);
                    return;
                }
            }
            AppMethodBeat.o(222454);
        } catch (Exception e2) {
            TXCLog.e(TAG, "identifyTRTCFrameworkType catch exception:" + e2.getCause());
            AppMethodBeat.o(222454);
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, final int i2) {
        String str;
        String str2;
        AppMethodBeat.i(15785);
        if (tRTCParams == null) {
            apiLog("enter room, param nil!");
            onEnterRoom(TXLiteAVCode.ERR_ENTER_ROOM_PARAM_NULL, "enter room param null");
            AppMethodBeat.o(15785);
            return;
        }
        final TRTCCloudDef.TRTCParams tRTCParams2 = new TRTCCloudDef.TRTCParams(tRTCParams);
        if (tRTCParams2.sdkAppId == 0 || TextUtils.isEmpty(tRTCParams2.userId) || TextUtils.isEmpty(tRTCParams2.userSig)) {
            apiLog("enterRoom param invalid:".concat(String.valueOf(tRTCParams2)));
            if (tRTCParams2.sdkAppId == 0) {
                onEnterRoom(TXLiteAVCode.ERR_SDK_APPID_INVALID, "enter room sdkAppId invalid.");
            }
            if (TextUtils.isEmpty(tRTCParams2.userSig)) {
                onEnterRoom(TXLiteAVCode.ERR_USER_SIG_INVALID, "enter room userSig invalid.");
            }
            if (TextUtils.isEmpty(tRTCParams2.userId)) {
                onEnterRoom(TXLiteAVCode.ERR_USER_ID_INVALID, "enter room userId invalid.");
            }
            AppMethodBeat.o(15785);
            return;
        }
        final long j2 = Util.MAX_32BIT_VALUE & ((long) tRTCParams2.roomId);
        if (j2 == 0) {
            apiLog("enter room, room id " + j2 + " error");
            onEnterRoom(TXLiteAVCode.ERR_ROOM_ID_INVALID, "room id invalid.");
            AppMethodBeat.o(15785);
            return;
        }
        final String str3 = "";
        final String str4 = tRTCParams2.businessInfo;
        if (tRTCParams2.roomId == -1 && !TextUtils.isEmpty(str4)) {
            try {
                JSONObject jSONObject = new JSONObject(str4);
                StringBuilder sb = new StringBuilder("");
                extractBizInfo(jSONObject, "strGroupId", sb);
                str = sb.toString();
                str2 = "";
                if (jSONObject.length() != 0) {
                    str2 = jSONObject.toString();
                }
            } catch (Exception e2) {
                apiLog("enter room, room id error, busInfo " + tRTCParams2.businessInfo);
                str = "";
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                onEnterRoom(TXLiteAVCode.ERR_ROOM_ID_INVALID, "room id invalid.");
                AppMethodBeat.o(15785);
                return;
            }
            str4 = str2;
            str3 = str;
        }
        TXCKeyPointReportProxy.a((int) CdnLogic.kMediaLittleAppPacket);
        final int i3 = tRTCParams2.role;
        final long currentTimeMillis = System.currentTimeMillis();
        this.mEnableHighQualityEncodeFromServer = false;
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass5 */

            public void run() {
                int i2;
                AppMethodBeat.i(222420);
                Monitor.a(tRTCParams2.userId, tRTCParams2.sdkAppId, TextUtils.isEmpty(str3) ? new StringBuilder().append(j2).toString() : str3);
                if (TRTCCloudImpl.this.mRoomState != 0) {
                    if ((TextUtils.isEmpty(str3) || !str3.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.strRoomId)) && TRTCCloudImpl.this.mRoomInfo.roomId != j2) {
                        TRTCCloudImpl.this.apiLog(String.format("enter another room[%d] when in room[%d], exit the old room!!!", Long.valueOf(j2), Long.valueOf(TRTCCloudImpl.this.mRoomInfo.roomId)));
                        TRTCCloudImpl.this.mIsExitOldRoom = true;
                        TRTCCloudImpl.this.exitRoom();
                    } else {
                        TRTCCloudImpl.this.apiLog(String.format("enter the same room[%d] again!!!", Long.valueOf(j2)));
                        TRTCCloudImpl.this.mRoomInfo.enterTime = currentTimeMillis;
                        TRTCCloudImpl.this.onEnterRoom(0, "enter the same room.");
                        AppMethodBeat.o(222420);
                        return;
                    }
                }
                TRTCCloudImpl.this.apiLog("========================================================================================================");
                TRTCCloudImpl.this.apiLog("========================================================================================================");
                TRTCCloudImpl.this.apiLog(String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", TXCCommonUtil.getSDKVersionStr(), com.tencent.liteav.basic.util.f.c(), com.tencent.liteav.basic.util.f.d()));
                TRTCCloudImpl.this.apiLog("========================================================================================================");
                TRTCCloudImpl.this.apiLog("========================================================================================================");
                TRTCCloudImpl.this.apiLog(String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d, bizinfo:%s", Long.valueOf(j2), str3, tRTCParams2.userId, Integer.valueOf(tRTCParams2.sdkAppId), Integer.valueOf(i2), str4));
                String str = "enterRoom self:" + TRTCCloudImpl.this.hashCode();
                int i3 = i2;
                String str2 = "VideoCall";
                int i4 = 2;
                switch (i2) {
                    case 0:
                        str2 = "VideoCall";
                        i4 = 1;
                        i2 = i3;
                        break;
                    case 1:
                        str2 = "Live";
                        i4 = 2;
                        i2 = i3;
                        break;
                    case 2:
                        str2 = "AudioCall";
                        i4 = 1;
                        i2 = 0;
                        break;
                    case 3:
                        str2 = "VoiceChatRoom";
                        i4 = 2;
                        i2 = 1;
                        break;
                    default:
                        TXCLog.w(TRTCCloudImpl.TAG, "enter room scene:%u error! default to VideoCall! " + i2 + " self:" + TRTCCloudImpl.this.hashCode());
                        i2 = 0;
                        break;
                }
                TXCAudioEngine.getInstance().setAudioQuality(i4, 1);
                Object[] objArr = new Object[4];
                objArr[0] = str4;
                objArr[1] = str2;
                objArr[2] = i3 == 20 ? "Anchor" : "Audience";
                objArr[3] = tRTCParams2.streamId;
                Monitor.a(1, str, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", objArr), 0);
                if (TRTCCloudImpl.this.mAudioFrameListener != null) {
                    TXCAudioEngine.setPlayoutDataListener(this);
                }
                TXCEventRecorderProxy.a("18446744073709551615", 5001, j2, -1, "", 0);
                TXCStatus.a("18446744073709551615", (int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, com.tencent.liteav.basic.util.f.c());
                TRTCCloudImpl.this.mRoomState = 1;
                if (TRTCCloudImpl.this.mNativeRtcContext == 0) {
                    int[] sDKVersion = TXCCommonUtil.getSDKVersion();
                    TRTCCloudImpl.this.mNativeRtcContext = TRTCCloudImpl.this.nativeCreateContext(sDKVersion.length > 0 ? sDKVersion[0] : 0, sDKVersion.length >= 2 ? sDKVersion[1] : 0, sDKVersion.length >= 3 ? sDKVersion[2] : 0);
                }
                TRTCCloudImpl.this.updateAppScene(i2);
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                boolean z = true;
                int i5 = 1;
                if (!(i2 == 0 && TRTCCloudImpl.this.mCodecType == 2)) {
                    z = false;
                    i5 = 0;
                }
                TRTCCloudImpl.this.mCaptureAndEnc.g(z);
                TRTCCloudImpl.access$500(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
                TRTCCloudImpl.access$600(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.bigEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.bigEncSize.f789b, TRTCCloudImpl.this.mConfig.f784h, TRTCCloudImpl.this.mConfig.f779c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.f781e);
                if (TRTCCloudImpl.this.mEnableSmallStream) {
                    TRTCCloudImpl.access$600(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
                } else {
                    TRTCCloudImpl.access$900(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
                }
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.f785i);
                String d2 = com.tencent.liteav.basic.util.f.d();
                String c2 = com.tencent.liteav.basic.util.f.c();
                TRTCCloudImpl.access$1000(TRTCCloudImpl.this, c2, d2, tRTCParams2.sdkAppId);
                TXCKeyPointReportProxy.a aVar = new TXCKeyPointReportProxy.a();
                aVar.f415d = i2;
                aVar.f416e = c2;
                aVar.f417f = d2;
                aVar.f419h = TRTCCloudImpl.this.mContext != null ? TRTCCloudImpl.this.mContext.getPackageName() : "";
                aVar.f413b = tRTCParams2.sdkAppId;
                aVar.f418g = TXCCommonUtil.getSDKVersionStr();
                aVar.f414c = TRTCCloudImpl.this.mFramework;
                TXCKeyPointReportProxy.a(aVar);
                TRTCCloudImpl.this.nativeSetPriorRemoteVideoStreamType(TRTCCloudImpl.this.mNativeRtcContext, TRTCCloudImpl.this.mPriorStreamType);
                TRTCCloudImpl.this.nativeInit(TRTCCloudImpl.this.mNativeRtcContext, tRTCParams2.sdkAppId, tRTCParams2.userId, tRTCParams2.userSig, TRTCCloudImpl.this.mRoomInfo.getToken(TRTCCloudImpl.this.mContext));
                for (Integer num : TRTCCloudImpl.this.mStreamTypes) {
                    TRTCCloudImpl.access$1300(TRTCCloudImpl.this, num.intValue());
                }
                TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
                TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
                String str3 = tRTCParams2.privateMapKey != null ? tRTCParams2.privateMapKey : "";
                String str4 = str3 != null ? str3 : "";
                TRTCCloudImpl.this.nativeEnterRoom(TRTCCloudImpl.this.mNativeRtcContext, j2, str4 != null ? str4 : "", str3, str4, i3, 255, i5, i2, TRTCCloudImpl.this.mPerformanceMode, com.tencent.liteav.basic.util.f.c(), com.tencent.liteav.basic.util.f.d(), TRTCCloudImpl.this.mRecvMode, tRTCParams2.userDefineRecordId != null ? tRTCParams2.userDefineRecordId : "", tRTCParams2.streamId != null ? tRTCParams2.streamId : "", TRTCCloudHevcUtil.getEnterRoomCodecSupportValue());
                TRTCCloudImpl.this.mCurrentRole = i3;
                TRTCCloudImpl.this.mTargetRole = i3;
                if (TRTCCloudImpl.this.mCurrentRole == 21 && (TRTCCloudImpl.this.mEnableCustomAudioCapture || TRTCCloudImpl.this.mIsAudioCapturing || TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE)) {
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222421);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            if (tRTCCloudListener == null) {
                                AppMethodBeat.o(222421);
                                return;
                            }
                            tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore upstream for audience", null);
                            AppMethodBeat.o(222421);
                        }
                    });
                    TRTCCloudImpl.this.apiLog("ignore upstream for audience, when enter room!!");
                }
                TRTCCloudImpl.this.mCaptureAndEnc.e();
                TRTCCloudImpl.this.startCollectStatus();
                TRTCCloudImpl.this.mLastStateTimeMs = 0;
                TRTCCloudImpl.this.mRoomInfo.init(j2, tRTCParams2.userId);
                TRTCCloudImpl.this.mRoomInfo.strRoomId = str4;
                TRTCCloudImpl.this.mRoomInfo.sdkAppId = tRTCParams2.sdkAppId;
                TRTCCloudImpl.this.mRoomInfo.userSig = tRTCParams2.userSig;
                TRTCCloudImpl.this.mRoomInfo.privateMapKey = str3;
                TRTCCloudImpl.this.mRoomInfo.enterTime = currentTimeMillis;
                TXCEventRecorderProxy.a("18446744073709551615", WearableStatusCodes.UNKNOWN_CAPABILITY, (long) TRTCCloudImpl.this.mConfig.f777a, (long) TRTCCloudImpl.this.mConfig.f778b, "", 2);
                TXCEventRecorderProxy.a("18446744073709551615", WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED, (long) TRTCCloudImpl.this.mConfig.f784h, -1, "", 2);
                TXCEventRecorderProxy.a("18446744073709551615", 4009, (long) TRTCCloudImpl.this.mConfig.f779c, -1, "", 2);
                AppMethodBeat.o(222420);
            }
        });
        AppMethodBeat.o(15785);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        AppMethodBeat.i(15786);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass6 */

            public void run() {
                AppMethodBeat.i(15775);
                TRTCCloudImpl.this.exitRoomInternal(true, "call from api");
                AppMethodBeat.o(15775);
            }
        });
        AppMethodBeat.o(15786);
    }

    /* access modifiers changed from: protected */
    public void exitRoomInternal(boolean z, String str) {
        AppMethodBeat.i(222455);
        this.mEnableHighQualityEncodeFromServer = false;
        String format = String.format(Locale.ENGLISH, "exitRoom %s, self: %d, reason: %s", Long.valueOf(this.mRoomInfo.getRoomId()), Integer.valueOf(hashCode()), str);
        apiLog(format);
        Monitor.a(1, format, "", 0);
        if (this.mRoomState == 0) {
            Monitor.a();
            apiLog("exitRoom ignore when no in room.");
            AppMethodBeat.o(222455);
            return;
        }
        this.mRoomState = 0;
        this.mCaptureAndEnc.f();
        TXCSoundEffectPlayer.getInstance().stopAllEffect();
        stopCollectStatus();
        startVolumeLevelCal(false);
        this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass7 */

            @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
            public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                AppMethodBeat.i(222577);
                TRTCCloudImpl.this.stopRemoteRender(userInfo);
                TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(userInfo.tinyID));
                if (userInfo.mainRender.render != null) {
                    userInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.UNKNOWN);
                }
                if (userInfo.subRender.render != null) {
                    userInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.UNKNOWN);
                }
                AppMethodBeat.o(222577);
            }
        });
        TXCAudioEngine.getInstance();
        TXCAudioEngine.setPlayoutDataListener(null);
        enableVideoStream(false);
        enableAudioStream(false);
        if (z) {
            nativeExitRoom(this.mNativeRtcContext);
        }
        enableAudioEarMonitoring(false);
        stopLocalAudio();
        stopBGM();
        TXCKeyPointReportProxy.a(31004);
        stopLocalPreview();
        stopScreenCapture();
        TXCKeyPointReportProxy.b(31004, 0);
        this.mConfig.A = null;
        this.mConfig.C = 10;
        this.mRoomInfo.clear();
        this.mRenderListenerMap.clear();
        this.mVideoSourceType = VideoSourceType.NONE;
        this.mEnableSmallStream = false;
        this.mEnableEosMode = false;
        this.mCodecType = 2;
        this.mEnableSoftAEC = true;
        this.mEnableSoftANS = false;
        this.mEnableSoftAGC = false;
        this.mCaptureAndEnc.a(false);
        TXCAudioEngine.getInstance().muteLocalAudio(false);
        TXCAudioEngine.getInstance().clean();
        enableCustomAudioCapture(false);
        this.mEnableCustomAudioCapture = false;
        synchronized (this) {
            try {
                if (this.mCustomVideoUtil != null) {
                    this.mCustomVideoUtil.release();
                    this.mCustomVideoUtil = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(222455);
                throw th;
            }
        }
        this.mCaptureAndEnc.a((o) null, 0);
        stopAudioRecording();
        TXCSoundEffectPlayer.getInstance().clearCache();
        Monitor.a();
        AppMethodBeat.o(222455);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void ConnectOtherRoom(final String str) {
        AppMethodBeat.i(15788);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass8 */

            public void run() {
                AppMethodBeat.i(15710);
                TRTCCloudImpl.this.apiLog("ConnectOtherRoom " + str);
                Monitor.a(1, String.format("ConnectOtherRoom param:%s", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.access$1700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, str);
                AppMethodBeat.o(15710);
            }
        });
        AppMethodBeat.o(15788);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void DisconnectOtherRoom() {
        AppMethodBeat.i(15789);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass9 */

            public void run() {
                AppMethodBeat.i(15681);
                TRTCCloudImpl.this.apiLog("DisconnectOtherRoom");
                Monitor.a(1, "DisconnectOtherRoom self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.access$1800(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
                AppMethodBeat.o(15681);
            }
        });
        AppMethodBeat.o(15789);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDefaultStreamRecvMode(final boolean z, final boolean z2) {
        AppMethodBeat.i(15790);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass10 */

            public void run() {
                AppMethodBeat.i(15709);
                TRTCCloudImpl.this.mRecvMode = 0;
                if (z && z2) {
                    TRTCCloudImpl.this.mRecvMode = 1;
                } else if (z) {
                    TRTCCloudImpl.this.mRecvMode = 2;
                } else if (z2) {
                    TRTCCloudImpl.this.mRecvMode = 3;
                } else {
                    TRTCCloudImpl.this.mRecvMode = 4;
                }
                String str = String.format("setDefaultStreamRecvMode audio:%b, video:%b", Boolean.valueOf(z), Boolean.valueOf(z2)) + " self:" + TRTCCloudImpl.this.hashCode();
                TRTCCloudImpl.this.apiLog(str);
                Monitor.a(1, str, "", 0);
                AppMethodBeat.o(15709);
            }
        });
        AppMethodBeat.o(15790);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchRole(final int i2) {
        AppMethodBeat.i(15791);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass11 */

            public void run() {
                AppMethodBeat.i(15691);
                TRTCCloudImpl.this.apiLog("switchRole:" + i2);
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                objArr[0] = i2 == 20 ? "Anchor" : "Audience";
                Monitor.a(1, sb.append(String.format("switchRole:%s", objArr)).append(" self:").append(TRTCCloudImpl.this.hashCode()).toString(), "", 0);
                TRTCCloudImpl.this.mTargetRole = i2;
                TRTCCloudImpl.access$1900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, i2);
                AppMethodBeat.o(15691);
            }
        });
        AppMethodBeat.o(15791);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TRTCCloud createSubCloud() {
        AppMethodBeat.i(222456);
        final TRTCSubCloud tRTCSubCloud = new TRTCSubCloud(this.mContext, new WeakReference(this), this.mSDKHandler);
        tRTCSubCloud.setListenerHandler(this.mListenerHandler);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass12 */

            public void run() {
                AppMethodBeat.i(15564);
                TRTCCloudImpl.this.mSubClouds.add(new WeakReference<>(tRTCSubCloud));
                AppMethodBeat.o(15564);
            }
        });
        AppMethodBeat.o(222456);
        return tRTCSubCloud;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void destroySubCloud(final TRTCCloud tRTCCloud) {
        AppMethodBeat.i(222457);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass13 */

            public void run() {
                AppMethodBeat.i(15698);
                Iterator<WeakReference<TRTCCloudImpl>> it = TRTCCloudImpl.this.mSubClouds.iterator();
                while (it.hasNext()) {
                    TRTCCloudImpl tRTCCloudImpl = it.next().get();
                    if (tRTCCloudImpl != null && tRTCCloudImpl == tRTCCloud) {
                        tRTCCloudImpl.destroy();
                        it.remove();
                        AppMethodBeat.o(15698);
                        return;
                    }
                }
                AppMethodBeat.o(15698);
            }
        });
        AppMethodBeat.o(222457);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalPreview(final boolean z, final TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(15792);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass14 */

            public void run() {
                boolean z;
                boolean z2;
                final SurfaceView surfaceView;
                AppMethodBeat.i(15702);
                boolean z3 = TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE;
                if (z3) {
                    TRTCCloudImpl.this.apiLog("startLocalPreview just reset view when is started");
                }
                if (TRTCCloudImpl.this.mCurrentRole == 21) {
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass14.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(15646);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            if (tRTCCloudListener == null) {
                                AppMethodBeat.o(15646);
                                return;
                            }
                            tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore start local preview,for role audience", null);
                            AppMethodBeat.o(15646);
                        }
                    });
                    TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
                }
                String str = "startLocalPreview front:" + z + ", view:" + (tXCloudVideoView != null ? Integer.valueOf(tXCloudVideoView.hashCode()) : "") + " " + TRTCCloudImpl.this.hashCode();
                TRTCCloudImpl.this.apiLog(str);
                Monitor.a(1, str, "", 0);
                TRTCCloudImpl.this.mRoomInfo.localView = tXCloudVideoView;
                TRTCCloudImpl.this.mConfig.m = z;
                g gVar = TRTCCloudImpl.this.mConfig;
                if (TRTCCloudImpl.this.mPerformanceMode == 0) {
                    z = true;
                } else {
                    z = false;
                }
                gVar.W = z;
                g gVar2 = TRTCCloudImpl.this.mConfig;
                if (TRTCCloudImpl.this.mPerformanceMode == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                gVar2.U = z2;
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                TXCKeyPointReportProxy.a(40046, 1, 2);
                TRTCCloudImpl.this.mOrientationEventListener.enable();
                TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                TRTCCloudImpl.this.enableVideoStream(true);
                if (tXCloudVideoView != null) {
                    surfaceView = tXCloudVideoView.getSurfaceView();
                } else {
                    surfaceView = null;
                }
                if (surfaceView != null) {
                    if (z3 || TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE) {
                        TRTCCloudImpl.this.apiLog("startLocalPreview with surface view when is started");
                    } else {
                        TRTCCloudImpl.this.mVideoSourceType = VideoSourceType.CAMERA;
                        TRTCCloudImpl.this.mCaptureAndEnc.a((TXCloudVideoView) null);
                    }
                } else if (z3 || TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE) {
                    TRTCCloudImpl.this.apiLog("startLocalPreview with view view when is started");
                } else {
                    TRTCCloudImpl.this.mVideoSourceType = VideoSourceType.CAMERA;
                    TRTCCloudImpl.this.mCaptureAndEnc.a(tXCloudVideoView);
                }
                final Surface[] surfaceArr = new Surface[1];
                final com.tencent.liteav.basic.util.d dVar = new com.tencent.liteav.basic.util.d();
                TRTCCloudImpl.access$2200(TRTCCloudImpl.this, new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass14.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(222571);
                        if (surfaceView != null) {
                            SurfaceHolder holder = surfaceView.getHolder();
                            holder.removeCallback(TRTCCloudImpl.this);
                            holder.addCallback(TRTCCloudImpl.this);
                            if (holder.getSurface().isValid()) {
                                TRTCCloudImpl.this.apiLog("startLocalPreview with valid surface " + holder.getSurface() + " width " + surfaceView.getWidth() + ", height " + surfaceView.getHeight());
                                surfaceArr[0] = holder.getSurface();
                                dVar.f460a = surfaceView.getWidth();
                                dVar.f461b = surfaceView.getHeight();
                            } else {
                                TRTCCloudImpl.this.apiLog("startLocalPreview with surfaceView add callback");
                            }
                        }
                        if (tXCloudVideoView != null) {
                            tXCloudVideoView.showVideoDebugLog(TRTCCloudImpl.this.mDebugType);
                            if (TRTCCloudImpl.this.mRoomInfo.debugMargin != null) {
                                tXCloudVideoView.setLogMarginRatio(TRTCCloudImpl.this.mRoomInfo.debugMargin.leftMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.rightMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.topMargin, TRTCCloudImpl.this.mRoomInfo.debugMargin.bottomMargin);
                            }
                        }
                        AppMethodBeat.o(222571);
                    }
                });
                if (surfaceArr[0] != null) {
                    TRTCCloudImpl.this.mCaptureAndEnc.a(surfaceArr[0]);
                    TRTCCloudImpl.this.mCaptureAndEnc.a(dVar.f460a, dVar.f461b);
                }
                AppMethodBeat.o(15702);
            }
        });
        AppMethodBeat.o(15792);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalPreview() {
        AppMethodBeat.i(15793);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass15 */

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0048, code lost:
                r0 = r5.this$0.mRoomInfo.localView.getSurfaceView();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                // Method dump skipped, instructions count: 126
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass15.run():void");
            }
        });
        AppMethodBeat.o(15793);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startRemoteView(final String str, final TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(15794);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass16 */

            public void run() {
                AppMethodBeat.i(15639);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("startRemoteView user is not exist save view" + str);
                    TRTCRoomInfo.UserInfo access$2300 = TRTCCloudImpl.access$2300(TRTCCloudImpl.this, str);
                    access$2300.mainRender.view = tXCloudVideoView;
                    TRTCCloudImpl.this.mRoomInfo.addUserInfo(str, access$2300);
                    Monitor.a(1, String.format("Remote-startRemoteView userID:%s (save view before user enter)", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    AppMethodBeat.o(15639);
                } else if (tXCloudVideoView == null || !tXCloudVideoView.equals(user.mainRender.view)) {
                    boolean z = user.mainRender.view != null;
                    user.mainRender.view = tXCloudVideoView;
                    if (user.mainRender.tinyID == 0) {
                        TRTCCloudImpl.this.apiLog("startRemoteView user tinyID is 0, ignore " + str);
                        AppMethodBeat.o(15639);
                        return;
                    }
                    TRTCCloudImpl.this.setRenderView(str, user.mainRender, tXCloudVideoView, user.debugMargin);
                    StringBuilder sb = new StringBuilder();
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = Long.valueOf(user.tinyID);
                    objArr[2] = Integer.valueOf(user.streamType);
                    objArr[3] = Integer.valueOf(tXCloudVideoView != null ? tXCloudVideoView.hashCode() : 0);
                    String sb2 = sb.append(String.format("Remote-startRemoteView userID:%s tinyID:%d streamType:%d view:%d", objArr)).append(" self:").append(TRTCCloudImpl.this.hashCode()).toString();
                    TRTCCloudImpl.this.apiLog(sb2);
                    Monitor.a(1, sb2, "", 0);
                    TRTCCloudImpl.access$2400(TRTCCloudImpl.this, String.valueOf(user.tinyID), user.streamType, 0, "Start watching " + str);
                    if (!z || !user.mainRender.render.isRendering()) {
                        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, user.mainRender.render, user.streamType);
                    }
                    TXCKeyPointReportProxy.a(String.valueOf(user.tinyID), 40021, 0, user.streamType);
                    if (!user.mainRender.muteVideo) {
                        TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, user.streamType, true);
                    } else {
                        TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, user.streamType, true);
                    }
                    TXCEventRecorderProxy.a(String.valueOf(user.tinyID), 4015, 1, -1, "", 0);
                    AppMethodBeat.o(15639);
                } else {
                    TRTCCloudImpl.this.apiLog("startRemoteView user view is the same, ignore " + str);
                    AppMethodBeat.o(15639);
                }
            }
        });
        AppMethodBeat.o(15794);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopRemoteView(final String str) {
        AppMethodBeat.i(15795);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass17 */

            public void run() {
                AppMethodBeat.i(15612);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("stopRemoteRender user is not exist " + str);
                    AppMethodBeat.o(15612);
                    return;
                }
                TRTCCloudImpl.this.apiLog(String.format("stopRemoteView userID:%s tinyID:%d streamType:%d", str, Long.valueOf(user.tinyID), Integer.valueOf(user.streamType)));
                Monitor.a(1, String.format("stopRemoteView userID:%s", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXCEventRecorderProxy.a(String.valueOf(user.tinyID), 4015, 0, -1, "", 0);
                TRTCCloudImpl.access$2800(TRTCCloudImpl.this, user, Boolean.FALSE);
                final TXCloudVideoView tXCloudVideoView = user.mainRender.view;
                TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass17.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222405);
                        if (tXCloudVideoView != null) {
                            tXCloudVideoView.removeVideoView();
                        }
                        AppMethodBeat.o(222405);
                    }
                });
                user.mainRender.view = null;
                AppMethodBeat.o(15612);
            }
        });
        AppMethodBeat.o(15795);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startRemoteSubStreamView(final String str, final TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(15796);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass18 */

            public void run() {
                AppMethodBeat.i(15585);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user is not exist save view" + str);
                    TRTCRoomInfo.UserInfo access$2300 = TRTCCloudImpl.access$2300(TRTCCloudImpl.this, str);
                    access$2300.subRender.view = tXCloudVideoView;
                    TRTCCloudImpl.this.mRoomInfo.addUserInfo(str, access$2300);
                    AppMethodBeat.o(15585);
                } else if (tXCloudVideoView == null || !tXCloudVideoView.equals(user.subRender.view)) {
                    boolean z = user.subRender.view != null;
                    user.subRender.view = tXCloudVideoView;
                    if (user.subRender.tinyID == 0) {
                        TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user tinyID is 0, ignore " + str);
                        AppMethodBeat.o(15585);
                        return;
                    }
                    TRTCCloudImpl.this.setRenderView(str, user.subRender, tXCloudVideoView, user.debugMargin);
                    TRTCCloudImpl tRTCCloudImpl = TRTCCloudImpl.this;
                    Object[] objArr = new Object[4];
                    objArr[0] = str;
                    objArr[1] = Long.valueOf(user.tinyID);
                    objArr[2] = 7;
                    objArr[3] = Integer.valueOf(tXCloudVideoView != null ? tXCloudVideoView.hashCode() : 0);
                    tRTCCloudImpl.apiLog(String.format("startRemoteSubStreamView userID:%s tinyID:%d streamType:%d view:%d", objArr));
                    Monitor.a(1, String.format("startRemoteSubStreamView userID:%s", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    TRTCCloudImpl.access$2400(TRTCCloudImpl.this, String.valueOf(user.tinyID), 7, 0, "Start watching " + str);
                    TXCKeyPointReportProxy.a(String.valueOf(user.tinyID), 40021, 0, 7);
                    if (!z || !user.subRender.render.isRendering()) {
                        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, user.subRender.render, 7);
                    }
                    if (!user.subRender.muteVideo) {
                        TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, 7, true);
                    }
                    AppMethodBeat.o(15585);
                } else {
                    TRTCCloudImpl.this.apiLog("startRemoteSubStreamView user view is the same, ignore " + str);
                    AppMethodBeat.o(15585);
                }
            }
        });
        AppMethodBeat.o(15796);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopRemoteSubStreamView(final String str) {
        AppMethodBeat.i(15797);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass19 */

            public void run() {
                AppMethodBeat.i(15683);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("stopRemoteSubStreamView user is not exist " + str);
                    AppMethodBeat.o(15683);
                    return;
                }
                TRTCCloudImpl.this.apiLog(String.format("stopRemoteSubStreamView userID:%s tinyID:%d streamType:%d", str, Long.valueOf(user.tinyID), Integer.valueOf(user.streamType)));
                Monitor.a(1, String.format("stopRemoteSubStreamView userID:%s", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.access$2900(TRTCCloudImpl.this, user);
                final TXCloudVideoView tXCloudVideoView = user.subRender.view;
                TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass19.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222423);
                        if (tXCloudVideoView != null) {
                            tXCloudVideoView.removeVideoView();
                        }
                        AppMethodBeat.o(222423);
                    }
                });
                user.subRender.view = null;
                AppMethodBeat.o(15683);
            }
        });
        AppMethodBeat.o(15797);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteSubStreamViewFillMode(final String str, final int i2) {
        AppMethodBeat.i(15798);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass20 */

            public void run() {
                AppMethodBeat.i(15712);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                TRTCCloudImpl.this.apiLog("setSubStreamRemoteViewFillMode->userId: " + str + ", fillMode: " + i2);
                if (!(user == null || user.subRender.render == null)) {
                    user.subRender.render.setRenderMode(i2);
                }
                AppMethodBeat.o(15712);
            }
        });
        AppMethodBeat.o(15798);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteSubStreamViewRotation(final String str, final int i2) {
        AppMethodBeat.i(182309);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass21 */

            public void run() {
                AppMethodBeat.i(15617);
                TRTCCloudImpl.this.apiLog("setRemoteSubStreamViewRotation->userId: " + str + ", rotation: " + i2);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (!(user == null || user.subRender.render == null)) {
                    user.subRender.render.setRenderRotation(i2 * 90);
                }
                AppMethodBeat.o(15617);
            }
        });
        AppMethodBeat.o(182309);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAllRemoteView() {
        AppMethodBeat.i(15799);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass22 */

            public void run() {
                AppMethodBeat.i(15587);
                TRTCCloudImpl.this.apiLog("stopAllRemoteView");
                Monitor.a(1, "stopAllRemoteView self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass22.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(182412);
                        TRTCCloudImpl.access$2800(TRTCCloudImpl.this, userInfo, Boolean.TRUE);
                        TRTCCloudImpl.access$2900(TRTCCloudImpl.this, userInfo);
                        userInfo.mainRender.view = null;
                        userInfo.subRender.view = null;
                        AppMethodBeat.o(182412);
                    }
                });
                AppMethodBeat.o(15587);
            }
        });
        AppMethodBeat.o(15799);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void snapshotVideo(final String str, final int i2, final TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        AppMethodBeat.i(182310);
        apiLog(String.format("snapshotVideo user:%s streamType:%d", str, Integer.valueOf(i2)));
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23 */

            public void run() {
                AppMethodBeat.i(15556);
                if (str == null) {
                    TRTCCloudImpl.this.apiLog("snapshotLocalView");
                    TRTCCloudImpl.this.mCaptureAndEnc.a(new com.tencent.liteav.basic.c.o() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23.AnonymousClass1 */

                        @Override // com.tencent.liteav.basic.c.o
                        public void onTakePhotoComplete(final Bitmap bitmap) {
                            AppMethodBeat.i(222402);
                            TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(222445);
                                    if (tRTCSnapshotListener != null) {
                                        tRTCSnapshotListener.onSnapshotComplete(bitmap);
                                    }
                                    AppMethodBeat.o(222445);
                                }
                            });
                            AppMethodBeat.o(222402);
                        }
                    });
                    AppMethodBeat.o(15556);
                    return;
                }
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                com.tencent.liteav.renderer.e eVar = null;
                if (i2 == 2) {
                    if (!(user == null || user.mainRender == null || user.mainRender.render == null)) {
                        TRTCCloudImpl.this.apiLog("snapshotRemoteSubStreamView->userId: " + str);
                        eVar = user.subRender.render.getVideoRender();
                    }
                } else if (!(user == null || user.mainRender == null || user.mainRender.render == null)) {
                    TRTCCloudImpl.this.apiLog("snapshotRemoteView->userId: " + str);
                    eVar = user.mainRender.render.getVideoRender();
                }
                if (eVar != null) {
                    eVar.a(new com.tencent.liteav.basic.c.o() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23.AnonymousClass2 */

                        @Override // com.tencent.liteav.basic.c.o
                        public void onTakePhotoComplete(final Bitmap bitmap) {
                            AppMethodBeat.i(222573);
                            TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23.AnonymousClass2.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(222395);
                                    if (tRTCSnapshotListener != null) {
                                        tRTCSnapshotListener.onSnapshotComplete(bitmap);
                                    }
                                    AppMethodBeat.o(222395);
                                }
                            });
                            AppMethodBeat.o(222573);
                        }
                    });
                    AppMethodBeat.o(15556);
                    return;
                }
                TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass23.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(222585);
                        if (tRTCSnapshotListener != null) {
                            tRTCSnapshotListener.onSnapshotComplete(null);
                        }
                        AppMethodBeat.o(222585);
                    }
                });
                AppMethodBeat.o(15556);
            }
        });
        AppMethodBeat.o(182310);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startScreenCapture(final TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        AppMethodBeat.i(222458);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass24 */

            public void run() {
                AppMethodBeat.i(15671);
                if (TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE) {
                    TRTCCloudImpl.access$3000(TRTCCloudImpl.this, "Has started capturing, ignore startScreenCapture");
                    AppMethodBeat.o(15671);
                    return;
                }
                TRTCCloudImpl.this.mVideoSourceType = VideoSourceType.SCREEN;
                TRTCCloudImpl.this.mSensorMode = 0;
                TRTCCloudImpl.this.mOrientationEventListener.disable();
                if (tRTCVideoEncParam != null) {
                    TRTCCloudImpl.this.mOverrideFPSFromUser = false;
                    TRTCCloudImpl.access$3300(TRTCCloudImpl.this, tRTCVideoEncParam);
                } else {
                    TRTCCloudImpl.this.mOverrideFPSFromUser = true;
                }
                if (TRTCCloudImpl.this.mCurrentRole == 21) {
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass24.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222582);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            if (tRTCCloudListener == null) {
                                AppMethodBeat.o(222582);
                                return;
                            }
                            tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore start local preview,for role audience", null);
                            AppMethodBeat.o(222582);
                        }
                    });
                    TRTCCloudImpl.this.apiLog("ignore startLocalPreview for audience");
                }
                String str = "start screen capture self:" + TRTCCloudImpl.this.hashCode();
                TRTCCloudImpl.this.apiLog(str);
                Monitor.a(1, str, "", 0);
                TRTCCloudImpl.this.mCaptureAndEnc.a(0);
                if (TRTCCloudImpl.this.mConfig.l == 1 || TRTCCloudImpl.this.mConfig.l == 3) {
                    TRTCCloudImpl.access$3400(TRTCCloudImpl.this, true, TRTCCloudImpl.this.mConfig.f777a, TRTCCloudImpl.this.mConfig.f778b, TRTCCloudImpl.this.mConfig.f784h, TRTCCloudImpl.this.mConfig.f779c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.f781e);
                } else {
                    TRTCCloudImpl.access$3400(TRTCCloudImpl.this, false, TRTCCloudImpl.this.mConfig.f778b, TRTCCloudImpl.this.mConfig.f777a, TRTCCloudImpl.this.mConfig.f784h, TRTCCloudImpl.this.mConfig.f779c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.f781e);
                }
                g.a access$3500 = TRTCCloudImpl.access$3500(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
                TRTCCloudImpl.access$3600(TRTCCloudImpl.this, access$3500.f788a, access$3500.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
                TRTCCloudImpl.this.mRoomInfo.localView = null;
                TRTCCloudImpl.this.enableVideoStream(true);
                TXCKeyPointReportProxy.a(40046, 1, 7);
                TRTCCloudImpl.this.mCaptureAndEnc.a((a.AbstractC0160a) TRTCCloudImpl.this);
                TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass24.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(222408);
                        if (tRTCScreenShareParams != null) {
                            TRTCCloudImpl.access$3700(TRTCCloudImpl.this, tRTCScreenShareParams.floatingView);
                        }
                        AppMethodBeat.o(222408);
                    }
                });
                AppMethodBeat.o(15671);
            }
        });
        AppMethodBeat.o(222458);
    }

    private void showFloatingWindow(View view) {
        AppMethodBeat.i(222459);
        if (view == null) {
            AppMethodBeat.o(222459);
        } else if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(view.getContext())) {
            this.mFloatingWindow = view;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            int i2 = 2005;
            if (Build.VERSION.SDK_INT >= 26) {
                i2 = 2038;
            } else if (Build.VERSION.SDK_INT > 24) {
                i2 = 2002;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i2);
            layoutParams.flags = 8;
            layoutParams.flags |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            windowManager.addView(view, layoutParams);
            AppMethodBeat.o(222459);
        } else {
            TXCLog.e(TAG, "can't show floating window for no drawing overlay permission");
            AppMethodBeat.o(222459);
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopScreenCapture() {
        AppMethodBeat.i(222460);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass25 */

            public void run() {
                AppMethodBeat.i(15643);
                if (TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.SCREEN) {
                    TRTCCloudImpl.this.apiLog("stopScreenCapture been ignored for Screen capture is not started");
                    AppMethodBeat.o(15643);
                    return;
                }
                TRTCCloudImpl.this.mVideoSourceType = VideoSourceType.NONE;
                String str = "stopScreenCapture self:" + TRTCCloudImpl.this.hashCode();
                TRTCCloudImpl.this.apiLog(str);
                Monitor.a(1, str, "", 0);
                TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass25.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222441);
                        TRTCCloudImpl.access$3800(TRTCCloudImpl.this);
                        AppMethodBeat.o(222441);
                    }
                });
                TRTCCloudImpl.this.mCaptureAndEnc.l();
                TRTCCloudImpl.this.mRoomInfo.localView = null;
                TRTCCloudImpl.this.enableVideoStream(false);
                TXCKeyPointReportProxy.a(40046, 0, 7);
                TRTCCloudImpl.this.mConfig.f784h = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt(TRTCCloudImpl.KEY_CONFIG_FPS, TRTCCloudImpl.this.mConfig.f784h);
                TRTCCloudImpl.this.mConfig.f785i = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getInt(TRTCCloudImpl.KEY_CONFIG_GOP, TRTCCloudImpl.this.mConfig.f785i);
                TRTCCloudImpl.this.mConfig.p = TRTCCloudImpl.this.mLatestParamsOfBigEncoder.getBoolean(TRTCCloudImpl.KEY_CONFIG_ADJUST_RESOLUTION, TRTCCloudImpl.this.mConfig.p);
                TRTCCloudImpl.this.mSmallEncParam.videoFps = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getInt(TRTCCloudImpl.KEY_CONFIG_FPS, TRTCCloudImpl.this.mSmallEncParam.videoFps);
                TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes = TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.getBoolean(TRTCCloudImpl.KEY_CONFIG_ADJUST_RESOLUTION, TRTCCloudImpl.this.mSmallEncParam.enableAdjustRes);
                TXCLog.i(TRTCCloudImpl.TAG, String.format(Locale.ENGLISH, "restore big encoder's fps: %d, gop: %d, small encoder's fps: %d", Integer.valueOf(TRTCCloudImpl.this.mConfig.f784h), Integer.valueOf(TRTCCloudImpl.this.mConfig.f785i), Integer.valueOf(TRTCCloudImpl.this.mSmallEncParam.videoFps)));
                AppMethodBeat.o(15643);
            }
        });
        AppMethodBeat.o(222460);
    }

    private void hideFloatingWindow() {
        AppMethodBeat.i(222461);
        if (this.mFloatingWindow == null) {
            AppMethodBeat.o(222461);
            return;
        }
        ((WindowManager) this.mFloatingWindow.getContext().getSystemService("window")).removeViewImmediate(this.mFloatingWindow);
        this.mFloatingWindow = null;
        AppMethodBeat.o(222461);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseScreenCapture() {
        AppMethodBeat.i(222462);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass26 */

            public void run() {
                AppMethodBeat.i(15656);
                if (TRTCCloudImpl.this.mVideoSourceType == VideoSourceType.SCREEN) {
                    TRTCCloudImpl.this.apiLog("pause screen capture");
                    Monitor.a(1, "pause screen capture self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    TRTCCloudImpl.this.mCaptureAndEnc.g();
                }
                AppMethodBeat.o(15656);
            }
        });
        AppMethodBeat.o(222462);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeScreenCapture() {
        AppMethodBeat.i(222463);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass27 */

            public void run() {
                AppMethodBeat.i(15751);
                if (TRTCCloudImpl.this.mVideoSourceType == VideoSourceType.SCREEN) {
                    TRTCCloudImpl.this.apiLog("resume screen capture");
                    Monitor.a(1, "resume screen capture self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    TRTCCloudImpl.this.mCaptureAndEnc.h();
                }
                AppMethodBeat.o(15751);
            }
        });
        AppMethodBeat.o(222463);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalVideo(final boolean z) {
        AppMethodBeat.i(15800);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass28 */

            public void run() {
                AppMethodBeat.i(15580);
                TRTCCloudImpl.this.apiLog("muteLocalVideo " + z + ", " + TRTCCloudImpl.this.mConfig.A);
                Monitor.a(1, String.format("muteLocalVideo mute:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXCEventRecorderProxy.a("18446744073709551615", WearableStatusCodes.DUPLICATE_CAPABILITY, z ? 1 : 0, -1, "", 2);
                TRTCCloudImpl.this.muteLocalVideo(z, TRTCCloudImpl.this);
                AppMethodBeat.o(15580);
            }
        });
        AppMethodBeat.o(15800);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoMuteImage(final Bitmap bitmap, final int i2) {
        AppMethodBeat.i(222464);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass29 */

            public void run() {
                int i2 = 20;
                AppMethodBeat.i(15583);
                TRTCCloudImpl.this.apiLog("setVideoMuteImage " + bitmap + ", " + i2);
                int i3 = i2;
                if (i3 <= 20) {
                    if (i3 < 5) {
                        i2 = 5;
                    } else {
                        i2 = i3;
                    }
                }
                TRTCCloudImpl.this.mConfig.A = bitmap;
                TRTCCloudImpl.this.mConfig.C = i2;
                TRTCCloudImpl.this.mConfig.B = -1;
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                AppMethodBeat.o(15583);
            }
        });
        AppMethodBeat.o(222464);
    }

    public void muteLocalVideo(final boolean z, final TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(222465);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass30 */

            public void run() {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(15627);
                TRTCCloudImpl tRTCCloudImpl = TRTCCloudImpl.this.mCurrentPublishClouds.get(2);
                if (!z) {
                    if (tRTCCloudImpl != tRTCCloudImpl) {
                        TRTCCloudImpl.this.enableVideoStream(false);
                        synchronized (TRTCCloudImpl.this.mCurrentPublishClouds) {
                            try {
                                TRTCCloudImpl.this.mCurrentPublishClouds.put(2, tRTCCloudImpl);
                                TRTCCloudImpl.this.mCurrentPublishClouds.put(3, tRTCCloudImpl);
                                TRTCCloudImpl.this.mCurrentPublishClouds.put(7, tRTCCloudImpl);
                            } catch (Throwable th) {
                                AppMethodBeat.o(15627);
                                throw th;
                            }
                        }
                        TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
                        TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
                        TRTCCloudImpl.access$500(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
                        TRTCCloudImpl.access$600(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.bigEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.bigEncSize.f789b, TRTCCloudImpl.this.mConfig.f784h, TRTCCloudImpl.this.mConfig.f779c, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mConfig.f781e);
                        if (TRTCCloudImpl.this.mEnableSmallStream) {
                            TRTCCloudImpl.access$600(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, TRTCCloudImpl.this.mConfig.p, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
                            z = true;
                        } else {
                            TRTCCloudImpl.access$900(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    TRTCCloudImpl.this.mCaptureAndEnc.h();
                    TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = z;
                    TRTCCloudImpl tRTCCloudImpl2 = TRTCCloudImpl.this;
                    if (z) {
                        z2 = false;
                    }
                    tRTCCloudImpl2.enableVideoStream(z2);
                    TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
                    TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 2, z);
                    if (z) {
                        TRTCCloudImpl.this.mCaptureAndEnc.k(2);
                        TRTCCloudImpl.this.mCaptureAndEnc.k(3);
                    }
                    AppMethodBeat.o(15627);
                    return;
                }
                if (tRTCCloudImpl == tRTCCloudImpl) {
                    TRTCCloudImpl.this.mRoomInfo.muteLocalVideo = z;
                    TRTCCloudImpl.this.enableNetworkBlackStream(TRTCCloudImpl.this.mCaptureAndEnc.i());
                    if (TRTCCloudImpl.this.mConfig.A != null) {
                        TRTCCloudImpl.this.mCaptureAndEnc.g();
                        AppMethodBeat.o(15627);
                        return;
                    }
                    TRTCCloudImpl tRTCCloudImpl3 = TRTCCloudImpl.this;
                    if (z) {
                        z2 = false;
                    }
                    tRTCCloudImpl3.enableVideoStream(z2);
                    TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 2, z);
                }
                AppMethodBeat.o(15627);
            }
        });
        AppMethodBeat.o(222465);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteVideoStream(final String str, final boolean z) {
        AppMethodBeat.i(15801);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass31 */

            public void run() {
                AppMethodBeat.i(16060);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + str + " no exist.");
                    TRTCRoomInfo.UserInfo access$2300 = TRTCCloudImpl.access$2300(TRTCCloudImpl.this, str);
                    access$2300.mainRender.muteVideo = z;
                    TRTCCloudImpl.this.mRoomInfo.addUserInfo(str, access$2300);
                    AppMethodBeat.o(16060);
                    return;
                }
                user.mainRender.muteVideo = z;
                TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + str + ", mute:" + z);
                Monitor.a(1, String.format("muteRemoteVideoStream userId:%s mute:%b self:" + TRTCCloudImpl.this.hashCode(), str, Boolean.valueOf(z)), "", 0);
                if (user.tinyID == 0) {
                    AppMethodBeat.o(16060);
                    return;
                }
                if (user.mainRender.render != null) {
                    user.mainRender.render.muteVideo(z);
                }
                if (z) {
                    TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, 2, true);
                    TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, 3, true);
                    TXCEventRecorderProxy.a(String.valueOf(user.tinyID), 4014, 1, -1, "", 0);
                    AppMethodBeat.o(16060);
                    return;
                }
                TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, user.streamType, true);
                TXCEventRecorderProxy.a(String.valueOf(user.tinyID), 4014, 0, -1, "", 0);
                AppMethodBeat.o(16060);
            }
        });
        AppMethodBeat.o(15801);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteVideoStreams(final boolean z) {
        AppMethodBeat.i(15802);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass32 */

            public void run() {
                AppMethodBeat.i(15721);
                TRTCCloudImpl.this.apiLog("muteAllRemoteVideoStreams mute " + z);
                Monitor.a(1, String.format("muteAllRemoteVideoStreams mute:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.this.mRoomInfo.muteRemoteVideo = z;
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass32.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222416);
                        userInfo.mainRender.muteVideo = z;
                        TRTCCloudImpl.this.apiLog("muteRemoteVideoStream " + userInfo.userID + ", mute " + z);
                        if (userInfo.mainRender.render != null) {
                            userInfo.mainRender.render.muteVideo(z);
                        }
                        if (z) {
                            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 2, true);
                            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 3, true);
                            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 7, true);
                            AppMethodBeat.o(222416);
                            return;
                        }
                        if (userInfo.mainRender.render != null && userInfo.mainRender.render.isRendering()) {
                            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, userInfo.streamType, true);
                        }
                        if (userInfo.subRender.render != null && userInfo.subRender.render.isRendering()) {
                            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 7, true);
                        }
                        AppMethodBeat.o(222416);
                    }
                });
                AppMethodBeat.o(15721);
            }
        });
        AppMethodBeat.o(15802);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderParam(final TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        AppMethodBeat.i(15803);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass33 */

            public void run() {
                AppMethodBeat.i(15748);
                TRTCCloudImpl.access$3300(TRTCCloudImpl.this, tRTCVideoEncParam);
                AppMethodBeat.o(15748);
            }
        });
        AppMethodBeat.o(15803);
    }

    private void setVideoEncoderParamInternal(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        AppMethodBeat.i(222466);
        if (tRTCVideoEncParam != null) {
            this.mLatestParamsOfBigEncoder.putInt(KEY_CONFIG_FPS, tRTCVideoEncParam.videoFps);
            this.mLatestParamsOfBigEncoder.putBoolean(KEY_CONFIG_ADJUST_RESOLUTION, tRTCVideoEncParam.enableAdjustRes);
            g.a sizeByResolution = getSizeByResolution(tRTCVideoEncParam.videoResolution, tRTCVideoEncParam.videoResolutionMode);
            updateBigStreamEncoder(tRTCVideoEncParam.videoResolutionMode == 1, sizeByResolution.f788a, sizeByResolution.f789b, tRTCVideoEncParam.videoFps, tRTCVideoEncParam.videoBitrate, tRTCVideoEncParam.enableAdjustRes, tRTCVideoEncParam.minVideoBitrate);
            apiLog("vsize setVideoEncoderParam->width:" + this.mRoomInfo.bigEncSize.f788a + ", height:" + this.mRoomInfo.bigEncSize.f789b + ", fps:" + tRTCVideoEncParam.videoFps + ", bitrate:" + tRTCVideoEncParam.videoBitrate + ", mode:" + tRTCVideoEncParam.videoResolutionMode + " minVideoBitrate:" + tRTCVideoEncParam.minVideoBitrate);
            Monitor.a(1, String.format("setVideoEncoderParam width:%d, height:%d, fps:%d, bitrate:%d, mode:%d, minBitrate:%d", Integer.valueOf(this.mRoomInfo.bigEncSize.f788a), Integer.valueOf(this.mRoomInfo.bigEncSize.f789b), Integer.valueOf(tRTCVideoEncParam.videoFps), Integer.valueOf(tRTCVideoEncParam.videoBitrate), Integer.valueOf(tRTCVideoEncParam.videoResolutionMode), Integer.valueOf(tRTCVideoEncParam.minVideoBitrate)) + " self:" + hashCode(), "", 0);
            updateOrientation();
            TXCEventRecorderProxy.a("18446744073709551615", WearableStatusCodes.UNKNOWN_CAPABILITY, (long) this.mRoomInfo.bigEncSize.f788a, (long) this.mRoomInfo.bigEncSize.f789b, "", 2);
            TXCEventRecorderProxy.a("18446744073709551615", WearableStatusCodes.WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED, (long) tRTCVideoEncParam.videoFps, -1, "", 2);
            TXCEventRecorderProxy.a("18446744073709551615", 4009, (long) tRTCVideoEncParam.videoBitrate, -1, "", 2);
            AppMethodBeat.o(222466);
            return;
        }
        apiLog("setVideoEncoderParam param is null");
        AppMethodBeat.o(222466);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setNetworkQosParam(final TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        AppMethodBeat.i(15804);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass34 */

            public void run() {
                AppMethodBeat.i(15753);
                if (tRTCNetworkQosParam != null) {
                    TRTCCloudImpl.this.apiLog("setNetworkQosParam");
                    TRTCCloudImpl.this.mQosPreference = tRTCNetworkQosParam.preference;
                    TRTCCloudImpl.this.mQosMode = tRTCNetworkQosParam.controlMode;
                    TRTCCloudImpl.access$500(TRTCCloudImpl.this, TRTCCloudImpl.this.mQosMode, TRTCCloudImpl.this.mQosPreference);
                    AppMethodBeat.o(15753);
                    return;
                }
                TRTCCloudImpl.this.apiLog("setNetworkQosParam param is null");
                AppMethodBeat.o(15753);
            }
        });
        AppMethodBeat.o(15804);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalViewFillMode(final int i2) {
        AppMethodBeat.i(15805);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass35 */

            public void run() {
                AppMethodBeat.i(15625);
                TRTCCloudImpl.this.apiLog("setLocalViewFillMode " + i2);
                TRTCCloudImpl.this.mCaptureAndEnc.f(i2);
                AppMethodBeat.o(15625);
            }
        });
        AppMethodBeat.o(15805);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteViewFillMode(final String str, final int i2) {
        AppMethodBeat.i(15806);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass36 */

            public void run() {
                AppMethodBeat.i(15601);
                TRTCCloudImpl.this.apiLog("setRemoteViewFillMode " + str + ", " + i2);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (!(user == null || user.mainRender.render == null)) {
                    user.mainRender.render.setRenderMode(i2);
                }
                AppMethodBeat.o(15601);
            }
        });
        AppMethodBeat.o(15806);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalViewRotation(final int i2) {
        AppMethodBeat.i(15807);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass37 */

            public void run() {
                AppMethodBeat.i(15663);
                TRTCCloudImpl.this.apiLog("vrotation setLocalViewRotation " + i2);
                TRTCCloudImpl.this.mRoomInfo.localRenderRotation = i2 * 90;
                TRTCCloudImpl.this.mCaptureAndEnc.g(i2 * 90);
                TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                AppMethodBeat.o(15663);
            }
        });
        AppMethodBeat.o(15807);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteViewRotation(final String str, final int i2) {
        AppMethodBeat.i(15808);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass38 */

            public void run() {
                AppMethodBeat.i(15726);
                TRTCCloudImpl.this.apiLog("vrotation setRemoteViewRotation " + str + ", " + i2);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (!(user == null || user.mainRender.render == null)) {
                    user.mainRender.render.setRenderRotation(i2 * 90);
                }
                AppMethodBeat.o(15726);
            }
        });
        AppMethodBeat.o(15808);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderRotation(final int i2) {
        AppMethodBeat.i(15809);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass39 */

            public void run() {
                AppMethodBeat.i(15632);
                TRTCCloudImpl.this.apiLog("vrotation setVideoEncoderRotation " + i2 + ", g sensor mode " + TRTCCloudImpl.this.mSensorMode);
                if (TRTCCloudImpl.this.mSensorMode == 0) {
                    TRTCCloudImpl.this.mCaptureAndEnc.a(i2 * 90);
                }
                AppMethodBeat.o(15632);
            }
        });
        AppMethodBeat.o(15809);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setGSensorMode(final int i2) {
        AppMethodBeat.i(15810);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass40 */

            public void run() {
                AppMethodBeat.i(15771);
                if (TRTCCloudImpl.this.mVideoSourceType == VideoSourceType.SCREEN) {
                    TRTCCloudImpl.this.apiLog("setGSensorMode has been ignored for screen capturing");
                    AppMethodBeat.o(15771);
                    return;
                }
                TRTCCloudImpl.this.mSensorMode = i2;
                TRTCCloudImpl.this.apiLog("vrotation setGSensorMode " + i2);
                AppMethodBeat.o(15771);
            }
        });
        AppMethodBeat.o(15810);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int enableEncSmallVideoStream(final boolean z, final TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        AppMethodBeat.i(15811);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass41 */

            public void run() {
                boolean z;
                AppMethodBeat.i(15773);
                TRTCCloudImpl.this.apiLog("enableEncSmallVideoStream " + z);
                TRTCCloudImpl.this.mEnableSmallStream = z;
                TRTCCloudImpl.this.enableNetworkSmallStream(TRTCCloudImpl.this.mEnableSmallStream);
                if (tRTCVideoEncParam != null) {
                    TRTCCloudImpl.this.mSmallEncParam.videoBitrate = tRTCVideoEncParam.videoBitrate;
                    TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate = tRTCVideoEncParam.minVideoBitrate;
                    TRTCCloudImpl.this.mSmallEncParam.videoFps = tRTCVideoEncParam.videoFps;
                    TRTCCloudImpl.this.mSmallEncParam.videoResolution = tRTCVideoEncParam.videoResolution;
                    TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode = tRTCVideoEncParam.videoResolutionMode;
                    TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.putInt(TRTCCloudImpl.KEY_CONFIG_FPS, tRTCVideoEncParam.videoFps);
                    TRTCCloudImpl.this.mLatestParamsOfSmallEncoder.putBoolean(TRTCCloudImpl.KEY_CONFIG_ADJUST_RESOLUTION, tRTCVideoEncParam.enableAdjustRes);
                }
                boolean z2 = TRTCCloudImpl.this.mConfig.p;
                int i2 = TRTCCloudImpl.this.mConfig.f785i;
                if (TRTCCloudImpl.this.mVideoSourceType == VideoSourceType.SCREEN) {
                    if (TRTCCloudImpl.this.mOverrideFPSFromUser) {
                        TRTCCloudImpl.this.mSmallEncParam.videoFps = 10;
                    }
                    i2 = 3;
                    z = false;
                } else {
                    z = z2;
                }
                TRTCCloudImpl.this.mRoomInfo.smallEncSize = TRTCCloudImpl.access$3500(TRTCCloudImpl.this, TRTCCloudImpl.this.mSmallEncParam.videoResolution, TRTCCloudImpl.this.mSmallEncParam.videoResolutionMode);
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mEnableSmallStream, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, i2);
                if (TRTCCloudImpl.this.mEnableSmallStream) {
                    TRTCCloudImpl.access$600(TRTCCloudImpl.this, 3, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f788a, TRTCCloudImpl.this.mRoomInfo.smallEncSize.f789b, TRTCCloudImpl.this.mSmallEncParam.videoFps, TRTCCloudImpl.this.mSmallEncParam.videoBitrate, z, TRTCCloudImpl.this.mSmallEncParam.minVideoBitrate);
                    TRTCCloudImpl.access$1300(TRTCCloudImpl.this, 3);
                    AppMethodBeat.o(15773);
                    return;
                }
                TRTCCloudImpl.access$900(TRTCCloudImpl.this, 3, 0, 0, 0, 0, 0, TRTCCloudImpl.this.mConfig.p, 0);
                TRTCCloudImpl.access$4200(TRTCCloudImpl.this, 3);
                AppMethodBeat.o(15773);
            }
        });
        AppMethodBeat.o(15811);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setPriorRemoteVideoStreamType(final int i2) {
        AppMethodBeat.i(15812);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass42 */

            public void run() {
                AppMethodBeat.i(15582);
                if (i2 == 0 || i2 != 1) {
                    TRTCCloudImpl.this.mPriorStreamType = 2;
                } else {
                    TRTCCloudImpl.this.mPriorStreamType = 3;
                }
                TRTCCloudImpl.this.apiLog("setPriorRemoteVideoStreamType " + TRTCCloudImpl.this.mPriorStreamType);
                AppMethodBeat.o(15582);
            }
        });
        AppMethodBeat.o(15812);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setLocalViewMirror(final int i2) {
        AppMethodBeat.i(15813);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass43 */

            public void run() {
                AppMethodBeat.i(170190);
                TRTCCloudImpl.this.mVideoRenderMirror = i2;
                TRTCCloudImpl.this.apiLog("setLocalViewMirror " + i2);
                TRTCCloudImpl.this.mCaptureAndEnc.b(i2);
                TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                AppMethodBeat.o(170190);
            }
        });
        AppMethodBeat.o(15813);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setVideoEncoderMirror(final boolean z) {
        AppMethodBeat.i(15814);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass44 */

            public void run() {
                AppMethodBeat.i(15682);
                TRTCCloudImpl.this.apiLog("setVideoEncoderMirror " + z);
                TRTCCloudImpl.this.mConfig.S = z;
                TRTCCloudImpl.this.mCaptureAndEnc.f(z);
                TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                AppMethodBeat.o(15682);
            }
        });
        AppMethodBeat.o(15814);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioQuality(final int i2) {
        AppMethodBeat.i(222467);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass45 */

            public void run() {
                AppMethodBeat.i(15730);
                TRTCCloudImpl.this.apiLog("setAudioQuality " + i2);
                TXCAudioEngine.getInstance().setAudioQuality(i2, 2);
                AppMethodBeat.o(15730);
            }
        });
        AppMethodBeat.o(222467);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startLocalAudio() {
        AppMethodBeat.i(15815);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass46 */

            public void run() {
                AppMethodBeat.i(15607);
                if (TRTCCloudImpl.this.mEnableCustomAudioCapture) {
                    TRTCCloudImpl.this.apiLog("startLocalAudio when enable custom audio capturing, ignore!!!");
                    AppMethodBeat.o(15607);
                } else if (TRTCCloudImpl.this.mIsAudioCapturing) {
                    TRTCCloudImpl.this.apiLog("startLocalAudio when capturing audio, ignore!!!");
                    AppMethodBeat.o(15607);
                } else {
                    if (TRTCCloudImpl.this.mCurrentRole == 21) {
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass46.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(182299);
                                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                                if (tRTCCloudListener == null) {
                                    AppMethodBeat.o(182299);
                                    return;
                                }
                                tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore start local audio,for role audience", null);
                                AppMethodBeat.o(182299);
                            }
                        });
                        TRTCCloudImpl.this.apiLog("ignore startLocalAudio,for role audience");
                    }
                    TRTCCloudImpl.this.apiLog("startLocalAudio");
                    Monitor.a(1, "startLocalAudio self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    TXCEventRecorderProxy.a("18446744073709551615", 3001, 0, -1, "", 0);
                    TRTCCloudImpl.this.mIsAudioCapturing = true;
                    TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                    TRTCCloudImpl.access$4400(TRTCCloudImpl.this);
                    TXCAudioEngine.getInstance().enableCaptureEOSMode(TRTCCloudImpl.this.mEnableEosMode);
                    TXCAudioEngine.getInstance().enableSoftAEC(TRTCCloudImpl.this.mEnableSoftAEC, TRTCCloudImpl.this.mSoftAECLevel);
                    TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
                    TXCAudioEngine.getInstance().startLocalAudio(11, false);
                    TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
                    TXCAudioEngine.getInstance().muteLocalAudio(TRTCCloudImpl.this.mRoomInfo.muteLocalAudio);
                    TXCEventRecorderProxy.a("18446744073709551615", 3003, 11, -1, "", 0);
                    TRTCCloudImpl.this.enableAudioStream(true);
                    TXCKeyPointReportProxy.a(40050, 1, 1);
                    AppMethodBeat.o(15607);
                }
            }
        });
        AppMethodBeat.o(15815);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopLocalAudio() {
        AppMethodBeat.i(15816);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass47 */

            public void run() {
                AppMethodBeat.i(15703);
                if (!TRTCCloudImpl.this.mIsAudioCapturing) {
                    TRTCCloudImpl.this.apiLog("stopLocalAudio when no capturing audio, ignore!!!");
                    AppMethodBeat.o(15703);
                    return;
                }
                TRTCCloudImpl.this.apiLog("stopLocalAudio");
                Monitor.a(1, "stopLocalAudio self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXCEventRecorderProxy.a("18446744073709551615", 3001, 2, -1, "", 0);
                TRTCCloudImpl.this.mIsAudioCapturing = false;
                TXCAudioEngine.getInstance().stopLocalAudio();
                TRTCCloudImpl.this.enableAudioStream(false);
                TXCKeyPointReportProxy.a(40050, 0, 1);
                AppMethodBeat.o(15703);
            }
        });
        AppMethodBeat.o(15816);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoStreamType(final String str, final int i2) {
        AppMethodBeat.i(15817);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass48 */

            public void run() {
                AppMethodBeat.i(15624);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    AppMethodBeat.o(15624);
                    return;
                }
                int i2 = 2;
                if (i2 == 1) {
                    i2 = 3;
                }
                if (user.streamType == i2) {
                    AppMethodBeat.o(15624);
                    return;
                }
                user.streamType = i2;
                TRTCCloudImpl.this.apiLog("setRemoteVideoStreamType " + str + ", " + i2 + ", " + user.tinyID);
                TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, i2, false);
                AppMethodBeat.o(15624);
            }
        });
        AppMethodBeat.o(15817);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioRoute(final int i2) {
        AppMethodBeat.i(15818);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass49 */

            public void run() {
                AppMethodBeat.i(15697);
                TRTCCloudImpl.this.apiLog("setAudioRoute " + i2);
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                objArr[0] = i2 == 0 ? "Speaker" : "Earpiece";
                Monitor.a(1, sb.append(String.format("setAudioRoute route:%s", objArr)).append(" self:").append(TRTCCloudImpl.this.hashCode()).toString(), "", 0);
                TXCAudioEngine.setAudioRoute(i2);
                AppMethodBeat.o(15697);
            }
        });
        AppMethodBeat.o(15818);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteLocalAudio(final boolean z) {
        AppMethodBeat.i(15819);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass50 */

            public void run() {
                AppMethodBeat.i(15724);
                TRTCCloudImpl.this.apiLog("muteLocalAudio " + z);
                Monitor.a(1, String.format("muteLocalAudio mute:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.this.muteLocalAudio(z, TRTCCloudImpl.this);
                if (z) {
                    TXCEventRecorderProxy.a("18446744073709551615", 3001, 1, -1, "", 0);
                    AppMethodBeat.o(15724);
                    return;
                }
                TXCEventRecorderProxy.a("18446744073709551615", 3001, 3, -1, "", 0);
                AppMethodBeat.o(15724);
            }
        });
        AppMethodBeat.o(15819);
    }

    public void muteLocalAudio(final boolean z, final TRTCCloudImpl tRTCCloudImpl) {
        AppMethodBeat.i(222468);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass51 */

            public void run() {
                AppMethodBeat.i(15750);
                TRTCCloudImpl tRTCCloudImpl = TRTCCloudImpl.this.mCurrentPublishClouds.get(1);
                if (!z) {
                    if (tRTCCloudImpl != tRTCCloudImpl) {
                        TRTCCloudImpl.this.enableAudioStream(false);
                        synchronized (TRTCCloudImpl.this.mCurrentPublishClouds) {
                            try {
                                TRTCCloudImpl.this.mCurrentPublishClouds.put(1, tRTCCloudImpl);
                            } catch (Throwable th) {
                                AppMethodBeat.o(15750);
                                throw th;
                            }
                        }
                        TRTCCloudImpl.access$4700(TRTCCloudImpl.this);
                    }
                    TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = z;
                    TXCAudioEngine.getInstance().muteLocalAudio(z);
                    TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 1, z);
                    TRTCCloudImpl.this.enableAudioStream(true);
                    AppMethodBeat.o(15750);
                    return;
                }
                if (tRTCCloudImpl == tRTCCloudImpl) {
                    TRTCCloudImpl.this.mRoomInfo.muteLocalAudio = z;
                    TXCAudioEngine.getInstance().muteLocalAudio(z);
                    TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 1, z);
                }
                AppMethodBeat.o(15750);
            }
        });
        AppMethodBeat.o(222468);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteRemoteAudio(final String str, final boolean z) {
        AppMethodBeat.i(15820);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass52 */

            public void run() {
                AppMethodBeat.i(15568);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user == null) {
                    TRTCCloudImpl.this.apiLog("muteRemoteAudio " + str + " no exist.");
                    TRTCRoomInfo.UserInfo access$2300 = TRTCCloudImpl.access$2300(TRTCCloudImpl.this, str);
                    access$2300.mainRender.muteAudio = z;
                    TRTCCloudImpl.this.mRoomInfo.addUserInfo(str, access$2300);
                    AppMethodBeat.o(15568);
                    return;
                }
                user.mainRender.muteAudio = z;
                TRTCCloudImpl.this.apiLog("muteRemoteAudio " + str + ", " + z);
                Monitor.a(1, String.format("muteRemoteAudio userId:%s mute:%b", str, Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                if (user.tinyID == 0) {
                    AppMethodBeat.o(15568);
                    return;
                }
                TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(user.tinyID), z);
                if (z) {
                    TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, 1, true);
                    AppMethodBeat.o(15568);
                    return;
                }
                TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, user.tinyID, 1, true);
                AppMethodBeat.o(15568);
            }
        });
        AppMethodBeat.o(15820);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void muteAllRemoteAudio(final boolean z) {
        AppMethodBeat.i(15821);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass53 */

            public void run() {
                AppMethodBeat.i(15778);
                TRTCCloudImpl.this.apiLog("muteAllRemoteAudio " + z);
                Monitor.a(1, String.format("muteAllRemoteAudio mute:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudImpl.this.mRoomInfo.muteRemoteAudio = z;
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass53.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222447);
                        userInfo.mainRender.muteAudio = z;
                        TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(userInfo.tinyID), z);
                        if (z) {
                            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 1, true);
                            AppMethodBeat.o(222447);
                            return;
                        }
                        TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 1, true);
                        AppMethodBeat.o(222447);
                    }
                });
                AppMethodBeat.o(15778);
            }
        });
        AppMethodBeat.o(15821);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setRemoteAudioVolume(final String str, final int i2) {
        AppMethodBeat.i(15822);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass54 */

            public void run() {
                int i2 = 100;
                AppMethodBeat.i(15670);
                int i3 = i2;
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 <= 100) {
                    i2 = i3;
                }
                TRTCCloudImpl.this.apiLog("setRemoteAudioVolume: userId = " + str + " volume = " + i2);
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user != null) {
                    TXCAudioEngine.getInstance().setRemotePlayoutVolume(String.valueOf(user.tinyID), i2);
                }
                AppMethodBeat.o(15670);
            }
        });
        AppMethodBeat.o(15822);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioCaptureVolume(int i2) {
        int i3;
        int i4 = 100;
        AppMethodBeat.i(182311);
        if (i2 < 0) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (i3 <= 100) {
            i4 = i3;
        }
        this.mAudioCaptureVolume = i4;
        apiLog("setAudioCaptureVolume:  volume=" + this.mAudioCaptureVolume);
        TXAudioEffectManagerImpl.getInstance().setVoiceCaptureVolume(i4);
        AppMethodBeat.o(182311);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioCaptureVolume() {
        return this.mAudioCaptureVolume;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioPlayoutVolume(int i2) {
        int i3;
        int i4 = 100;
        AppMethodBeat.i(182312);
        if (i2 < 0) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (i3 <= 100) {
            i4 = i3;
        }
        this.mAudioPlayoutVolume = i4;
        apiLog("setAudioPlayoutVolume:  volume=" + this.mAudioPlayoutVolume);
        TXAudioEffectManagerImpl.getInstance().setAudioPlayoutVolume(i4);
        AppMethodBeat.o(182312);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getAudioPlayoutVolume() {
        return this.mAudioPlayoutVolume;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setSystemVolumeType(final int i2) {
        AppMethodBeat.i(15823);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass55 */

            public void run() {
                AppMethodBeat.i(15574);
                Monitor.a(1, String.format("setSystemVolumeType type:%d,  auto(0),media(1),VOIP(2)", Integer.valueOf(i2)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                if (i2 == 0 || 1 == i2 || 2 == i2) {
                    TXCAudioEngine.getInstance();
                    TXCAudioEngine.setSystemVolumeType(i2);
                }
                AppMethodBeat.o(15574);
            }
        });
        AppMethodBeat.o(15823);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableAudioEarMonitoring(final boolean z) {
        AppMethodBeat.i(15824);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass56 */

            public void run() {
                AppMethodBeat.i(15572);
                Monitor.a(1, String.format("enableAudioEarMonitoring enable:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TXAudioEffectManagerImpl.getInstance().enableVoiceEarMonitor(z);
                AppMethodBeat.o(15572);
            }
        });
        AppMethodBeat.o(15824);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(15825);
        if (surfaceHolder.getSurface().isValid()) {
            apiLog("startLocalPreview surfaceCreated " + surfaceHolder.getSurface());
            this.mCaptureAndEnc.a(surfaceHolder.getSurface());
        }
        AppMethodBeat.o(15825);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        AppMethodBeat.i(15826);
        apiLog("startLocalPreview surfaceChanged " + surfaceHolder.getSurface() + " width " + i3 + ", height " + i4);
        this.mCaptureAndEnc.a(i3, i4);
        AppMethodBeat.o(15826);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(15827);
        apiLog("startLocalPreview surfaceDestroyed " + surfaceHolder.getSurface());
        this.mCaptureAndEnc.a((Surface) null);
        AppMethodBeat.o(15827);
    }

    @Override // com.tencent.liteav.screencapture.a.AbstractC0160a
    public void onScreenCaptureStarted() {
        AppMethodBeat.i(222469);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass57 */

            public void run() {
                AppMethodBeat.i(15752);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onScreenCaptureStarted();
                }
                AppMethodBeat.o(15752);
            }
        });
        AppMethodBeat.o(222469);
    }

    @Override // com.tencent.liteav.screencapture.a.AbstractC0160a
    public void onScreenCaptureResumed() {
        AppMethodBeat.i(222470);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass58 */

            public void run() {
                AppMethodBeat.i(15661);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onScreenCaptureResumed();
                }
                AppMethodBeat.o(15661);
            }
        });
        AppMethodBeat.o(222470);
    }

    @Override // com.tencent.liteav.screencapture.a.AbstractC0160a
    public void onScreenCapturePaused() {
        AppMethodBeat.i(222471);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass59 */

            public void run() {
                AppMethodBeat.i(15687);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onScreenCapturePaused();
                }
                AppMethodBeat.o(15687);
            }
        });
        AppMethodBeat.o(222471);
    }

    @Override // com.tencent.liteav.screencapture.a.AbstractC0160a
    public void onScreenCaptureStopped(final int i2) {
        AppMethodBeat.i(222472);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass60 */

            public void run() {
                AppMethodBeat.i(15652);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onScreenCaptureStopped(i2);
                }
                AppMethodBeat.o(15652);
            }
        });
        AppMethodBeat.o(222472);
    }

    /* access modifiers changed from: package-private */
    public static class VolumeLevelNotifyTask implements Runnable {
        private WeakReference<TRTCCloudImpl> mWeakTRTCEngine;

        VolumeLevelNotifyTask(TRTCCloudImpl tRTCCloudImpl) {
            AppMethodBeat.i(15716);
            this.mWeakTRTCEngine = new WeakReference<>(tRTCCloudImpl);
            AppMethodBeat.o(15716);
        }

        public void run() {
            TRTCCloudImpl tRTCCloudImpl;
            AppMethodBeat.i(15717);
            if (this.mWeakTRTCEngine != null) {
                tRTCCloudImpl = this.mWeakTRTCEngine.get();
            } else {
                tRTCCloudImpl = null;
            }
            if (tRTCCloudImpl != null) {
                final ArrayList arrayList = new ArrayList();
                int i2 = 0;
                if (tRTCCloudImpl.mCaptureAndEnc != null) {
                    i2 = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
                }
                if (i2 > 0) {
                    TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                    tRTCVolumeInfo.userId = tRTCCloudImpl.mRoomInfo.userId;
                    tRTCVolumeInfo.volume = i2;
                    arrayList.add(tRTCVolumeInfo);
                }
                tRTCCloudImpl.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.VolumeLevelNotifyTask.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(15693);
                        int remotePlayoutVolumeLevel = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(userInfo.tinyID));
                        if (remotePlayoutVolumeLevel > 0) {
                            TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                            tRTCVolumeInfo.userId = userInfo.userID;
                            tRTCVolumeInfo.volume = remotePlayoutVolumeLevel;
                            arrayList.add(tRTCVolumeInfo);
                        }
                        AppMethodBeat.o(15693);
                    }
                });
                final int mixingPlayoutVolumeLevel = TXCAudioEngine.getMixingPlayoutVolumeLevel();
                final TRTCCloudListener tRTCCloudListener = tRTCCloudImpl.mTRTCListener;
                tRTCCloudImpl.runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.VolumeLevelNotifyTask.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(15558);
                        if (tRTCCloudListener != null) {
                            tRTCCloudListener.onUserVoiceVolume(arrayList, mixingPlayoutVolumeLevel);
                        }
                        AppMethodBeat.o(15558);
                    }
                });
                if (tRTCCloudImpl.mAudioVolumeEvalInterval > 0) {
                    tRTCCloudImpl.mSDKHandler.postDelayed(tRTCCloudImpl.mVolumeLevelNotifyTask, (long) tRTCCloudImpl.mAudioVolumeEvalInterval);
                }
            }
            AppMethodBeat.o(15717);
        }
    }

    /* access modifiers changed from: protected */
    public void startVolumeLevelCal(boolean z) {
        AppMethodBeat.i(15828);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(z, this.mAudioVolumeEvalInterval);
        if (!z) {
            this.mVolumeLevelNotifyTask = null;
            this.mAudioVolumeEvalInterval = 0;
        } else if (this.mVolumeLevelNotifyTask == null) {
            this.mVolumeLevelNotifyTask = new VolumeLevelNotifyTask(this);
            this.mSDKHandler.postDelayed(this.mVolumeLevelNotifyTask, (long) this.mAudioVolumeEvalInterval);
            AppMethodBeat.o(15828);
            return;
        }
        AppMethodBeat.o(15828);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableAudioVolumeEvaluation(final int i2) {
        AppMethodBeat.i(15829);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass61 */

            public void run() {
                int i2 = 100;
                AppMethodBeat.i(15688);
                if (i2 <= 0) {
                    i2 = 0;
                } else if (i2 >= 100) {
                    i2 = i2;
                }
                if (i2 == TRTCCloudImpl.this.mAudioVolumeEvalInterval) {
                    AppMethodBeat.o(15688);
                    return;
                }
                TRTCCloudImpl.this.apiLog("enableAudioVolumeEvaluation ".concat(String.valueOf(i2)));
                TRTCCloudImpl.this.mAudioVolumeEvalInterval = i2;
                if (TRTCCloudImpl.this.mAudioVolumeEvalInterval > 0) {
                    TRTCCloudImpl.this.startVolumeLevelCal(true);
                    AppMethodBeat.o(15688);
                    return;
                }
                TRTCCloudImpl.this.startVolumeLevelCal(false);
                AppMethodBeat.o(15688);
            }
        });
        AppMethodBeat.o(15829);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        AppMethodBeat.i(15830);
        if (TextUtils.isEmpty(tRTCAudioRecordingParams.filePath)) {
            apiLog("startLocalAudioRecord error:" + tRTCAudioRecordingParams.filePath);
            AppMethodBeat.o(15830);
            return -1;
        }
        apiLog("startLocalAudioRecord:" + tRTCAudioRecordingParams.filePath);
        TXCAudioEngine.getInstance().setAudioDumpingListener(new TXCAudioEngineJNI.a() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass62 */

            @Override // com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a
            public void onLocalAudioWriteFailed() {
                AppMethodBeat.i(222406);
                TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass62.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222399);
                        TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                        if (tRTCCloudListener == null) {
                            AppMethodBeat.o(222399);
                            return;
                        }
                        TRTCCloudImpl.this.apiLog("startLocalAudioRecord onWarning:7001");
                        tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL, "write file failed when recording audio.", null);
                        AppMethodBeat.o(222399);
                    }
                });
                AppMethodBeat.o(222406);
            }
        });
        int startLocalAudioDumping = TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, tRTCAudioRecordingParams.filePath);
        AppMethodBeat.o(15830);
        return startLocalAudioDumping;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAudioRecording() {
        AppMethodBeat.i(15831);
        TXCAudioEngine.getInstance().stopLocalAudioDumping();
        AppMethodBeat.o(15831);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void switchCamera() {
        AppMethodBeat.i(15832);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass63 */

            public void run() {
                AppMethodBeat.i(15772);
                TRTCCloudImpl.this.mConfig.m = !TRTCCloudImpl.this.mConfig.m;
                TRTCCloudImpl.this.mCaptureAndEnc.k();
                TRTCCloudImpl.this.apiLog("switchCamera " + TRTCCloudImpl.this.mConfig.m);
                TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                AppMethodBeat.o(15772);
            }
        });
        AppMethodBeat.o(15832);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean isCameraZoomSupported() {
        AppMethodBeat.i(15833);
        boolean m = this.mCaptureAndEnc.m();
        AppMethodBeat.o(15833);
        return m;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setZoom(final int i2) {
        AppMethodBeat.i(15834);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass64 */

            public void run() {
                AppMethodBeat.i(15561);
                TRTCCloudImpl.this.apiLog("setZoom " + i2);
                TRTCCloudImpl.this.mCaptureAndEnc.i(i2);
                AppMethodBeat.o(15561);
            }
        });
        AppMethodBeat.o(15834);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean isCameraTorchSupported() {
        AppMethodBeat.i(15835);
        boolean n = this.mCaptureAndEnc.n();
        AppMethodBeat.o(15835);
        return n;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean enableTorch(boolean z) {
        AppMethodBeat.i(15836);
        apiLog("enableTorch ".concat(String.valueOf(z)));
        boolean e2 = this.mCaptureAndEnc.e(z);
        AppMethodBeat.o(15836);
        return e2;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean isCameraFocusPositionInPreviewSupported() {
        AppMethodBeat.i(15837);
        boolean o = this.mCaptureAndEnc.o();
        AppMethodBeat.o(15837);
        return o;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFocusPosition(final int i2, final int i3) {
        AppMethodBeat.i(15838);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass65 */

            public void run() {
                AppMethodBeat.i(15695);
                TRTCCloudImpl.this.mCaptureAndEnc.b(i2, i3);
                AppMethodBeat.o(15695);
            }
        });
        AppMethodBeat.o(15838);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean isCameraAutoFocusFaceModeSupported() {
        AppMethodBeat.i(15839);
        boolean p = this.mCaptureAndEnc.p();
        AppMethodBeat.o(15839);
        return p;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXBeautyManager getBeautyManager() {
        AppMethodBeat.i(15840);
        if (this.mCaptureAndEnc == null) {
            this.mCaptureAndEnc = new com.tencent.liteav.d(this.mContext);
        }
        TXBeautyManager b2 = this.mCaptureAndEnc.b();
        AppMethodBeat.o(15840);
        return b2;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setBeautyStyle(final int i2, final int i3, final int i4, final int i5) {
        AppMethodBeat.i(15841);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass66 */

            public void run() {
                AppMethodBeat.i(15747);
                TRTCCloudImpl.this.getBeautyManager().setBeautyStyle(i2);
                TRTCCloudImpl.this.getBeautyManager().setBeautyLevel(i3);
                TRTCCloudImpl.this.getBeautyManager().setWhitenessLevel(i4);
                TRTCCloudImpl.this.getBeautyManager().setRuddyLevel(i5);
                AppMethodBeat.o(15747);
            }
        });
        AppMethodBeat.o(15841);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFilter(final Bitmap bitmap) {
        AppMethodBeat.i(15842);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass67 */

            public void run() {
                AppMethodBeat.i(15770);
                TRTCCloudImpl.this.apiLog("setFilter");
                TRTCCloudImpl.this.getBeautyManager().setFilter(bitmap);
                AppMethodBeat.o(15770);
            }
        });
        AppMethodBeat.o(15842);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFilterConcentration(final float f2) {
        AppMethodBeat.i(15843);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass68 */

            public void run() {
                AppMethodBeat.i(15586);
                TRTCCloudImpl.this.apiLog("setFilterStrength: " + f2);
                TRTCCloudImpl.this.getBeautyManager().setFilterStrength(f2);
                AppMethodBeat.o(15586);
            }
        });
        AppMethodBeat.o(15843);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void selectMotionTmpl(final String str) {
        AppMethodBeat.i(15844);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass69 */

            public void run() {
                AppMethodBeat.i(15761);
                TRTCCloudImpl.this.apiLog("selectMotionTmpl " + str);
                TRTCCloudImpl.this.getBeautyManager().setMotionTmpl(str);
                AppMethodBeat.o(15761);
            }
        });
        AppMethodBeat.o(15844);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMotionMute(final boolean z) {
        AppMethodBeat.i(15845);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass70 */

            public void run() {
                AppMethodBeat.i(15609);
                TRTCCloudImpl.this.apiLog("setMotionMute " + z);
                TRTCCloudImpl.this.getBeautyManager().setMotionMute(z);
                AppMethodBeat.o(15609);
            }
        });
        AppMethodBeat.o(15845);
    }

    @Override // com.tencent.trtc.TRTCCloud
    @TargetApi(18)
    public boolean setGreenScreenFile(final String str) {
        AppMethodBeat.i(15846);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass71 */

            public void run() {
                AppMethodBeat.i(15701);
                TRTCCloudImpl.this.apiLog("setGreenScreenFile " + str);
                TRTCCloudImpl.this.getBeautyManager().setGreenScreenFile(str);
                AppMethodBeat.o(15701);
            }
        });
        AppMethodBeat.o(15846);
        return true;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setEyeScaleLevel(final int i2) {
        AppMethodBeat.i(15847);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass72 */

            public void run() {
                AppMethodBeat.i(15573);
                TRTCCloudImpl.this.apiLog("setEyeScaleLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setEyeScaleLevel(i2);
                AppMethodBeat.o(15573);
            }
        });
        AppMethodBeat.o(15847);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFaceSlimLevel(final int i2) {
        AppMethodBeat.i(15848);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass73 */

            public void run() {
                AppMethodBeat.i(15559);
                TRTCCloudImpl.this.apiLog("setFaceSlimLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setFaceSlimLevel(i2);
                AppMethodBeat.o(15559);
            }
        });
        AppMethodBeat.o(15848);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFaceVLevel(final int i2) {
        AppMethodBeat.i(15849);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass74 */

            public void run() {
                AppMethodBeat.i(15685);
                TRTCCloudImpl.this.apiLog("setFaceVLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setFaceVLevel(i2);
                AppMethodBeat.o(15685);
            }
        });
        AppMethodBeat.o(15849);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setFaceShortLevel(final int i2) {
        AppMethodBeat.i(15850);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass75 */

            public void run() {
                AppMethodBeat.i(15756);
                TRTCCloudImpl.this.apiLog("setFaceShortLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setFaceShortLevel(i2);
                AppMethodBeat.o(15756);
            }
        });
        AppMethodBeat.o(15850);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setChinLevel(final int i2) {
        AppMethodBeat.i(15851);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass76 */

            public void run() {
                AppMethodBeat.i(15678);
                TRTCCloudImpl.this.apiLog("setChinLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setChinLevel(i2);
                AppMethodBeat.o(15678);
            }
        });
        AppMethodBeat.o(15851);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setNoseSlimLevel(final int i2) {
        AppMethodBeat.i(15852);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass77 */

            public void run() {
                AppMethodBeat.i(15649);
                TRTCCloudImpl.this.apiLog("setNoseSlimLevel " + i2);
                TRTCCloudImpl.this.getBeautyManager().setNoseSlimLevel(i2);
                AppMethodBeat.o(15649);
            }
        });
        AppMethodBeat.o(15852);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setWatermark(final Bitmap bitmap, final int i2, final float f2, final float f3, final float f4) {
        AppMethodBeat.i(15853);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass78 */

            public void run() {
                AppMethodBeat.i(15660);
                TRTCCloudImpl.this.apiLog("addWatermark stream:" + i2);
                if (i2 != 2) {
                    TRTCCloudImpl.this.mConfig.E = bitmap;
                    TRTCCloudImpl.this.mConfig.H = f2;
                    TRTCCloudImpl.this.mConfig.I = f3;
                    TRTCCloudImpl.this.mConfig.J = f4;
                    TRTCCloudImpl.this.mCaptureAndEnc.a(bitmap, f2, f3, f4);
                }
                AppMethodBeat.o(15660);
            }
        });
        AppMethodBeat.o(15853);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomVideoCapture(final boolean z) {
        AppMethodBeat.i(15854);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass79 */

            public void run() {
                int i2;
                AppMethodBeat.i(15644);
                if (z && TRTCCloudImpl.this.mVideoSourceType != VideoSourceType.NONE) {
                    TRTCCloudImpl.access$3000(TRTCCloudImpl.this, "Has started capturing, ignore enableCustomVideoCapture");
                    AppMethodBeat.o(15644);
                } else if (z || TRTCCloudImpl.this.mVideoSourceType == VideoSourceType.CUSTOM) {
                    TRTCCloudImpl.this.mVideoSourceType = z ? VideoSourceType.CUSTOM : VideoSourceType.NONE;
                    if (z) {
                        TRTCCloudImpl.this.mConfig.R |= 2;
                        TRTCCloudImpl.this.mLastCaptureCalculateTS = 0;
                        if (TRTCCloudImpl.this.mCurrentRole == 21) {
                            TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass79.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(222426);
                                    TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                                    if (tRTCCloudListener == null) {
                                        AppMethodBeat.o(222426);
                                        return;
                                    }
                                    tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore send custom video,for role audience", null);
                                    AppMethodBeat.o(222426);
                                }
                            });
                            TRTCCloudImpl.this.apiLog("ignore enableCustomVideoCapture,for role audience");
                        }
                    } else {
                        TRTCCloudImpl.this.mConfig.R &= -3;
                        synchronized (this) {
                            try {
                                if (TRTCCloudImpl.this.mCustomVideoUtil != null) {
                                    TRTCCloudImpl.this.mCustomVideoUtil.release();
                                    TRTCCloudImpl.this.mCustomVideoUtil = null;
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(15644);
                                throw th;
                            }
                        }
                    }
                    TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                    TRTCCloudImpl.this.apiLog("enableCustomVideoCapture " + z);
                    Monitor.a(1, String.format("enableCustomVideoCapture:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                    TRTCCloudImpl.this.enableVideoStream(z);
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    TXCKeyPointReportProxy.a(40046, i2, 2);
                    AppMethodBeat.o(15644);
                } else {
                    AppMethodBeat.o(15644);
                }
            }
        });
        AppMethodBeat.o(15854);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        AppMethodBeat.i(15855);
        if (tRTCVideoFrame == null) {
            apiLog("sendCustomVideoData parameter is null");
            AppMethodBeat.o(15855);
        } else if (tRTCVideoFrame.pixelFormat != 1 && tRTCVideoFrame.pixelFormat != 4 && tRTCVideoFrame.pixelFormat != 2) {
            apiLog("sendCustomVideoData parameter error unsupported pixel format " + tRTCVideoFrame.pixelFormat);
            AppMethodBeat.o(15855);
        } else if (tRTCVideoFrame.bufferType != 2 && tRTCVideoFrame.texture == null) {
            apiLog("sendCustomVideoData parameter error unsupported buffer type " + tRTCVideoFrame.bufferType);
            AppMethodBeat.o(15855);
        } else if (this.mVideoSourceType == VideoSourceType.CUSTOM && this.mRoomState == 2 && !this.mRoomInfo.muteLocalVideo) {
            synchronized (this) {
                try {
                    if (this.mCustomVideoUtil == null) {
                        this.mCustomVideoUtil = new TRTCCustomTextureUtil(this.mCaptureAndEnc);
                    }
                    if (this.mCustomVideoUtil != null) {
                        this.mCustomVideoUtil.sendCustomTexture(tRTCVideoFrame);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(15855);
                    throw th;
                }
            }
            if (this.mLastCaptureCalculateTS == 0) {
                this.mLastCaptureCalculateTS = System.currentTimeMillis();
                this.mLastCaptureFrameCount = 0;
                this.mCaptureFrameCount = 0;
                AppMethodBeat.o(15855);
                return;
            }
            this.mCaptureFrameCount++;
            AppMethodBeat.o(15855);
        } else {
            AppMethodBeat.o(15855);
        }
    }

    public void setSEIPayloadType(JSONObject jSONObject) {
        AppMethodBeat.i(15856);
        if (jSONObject == null || !jSONObject.has("payloadType")) {
            apiLog("callExperimentalAPI[lack parameter or illegal type]: payloadType");
            AppMethodBeat.o(15856);
            return;
        }
        int i2 = jSONObject.getInt("payloadType");
        if (i2 != 5 && i2 != 243) {
            apiLog("callExperimentalAPI[invalid param]: payloadType[" + i2 + "]");
            AppMethodBeat.o(15856);
        } else if (nativeSetSEIPayloadType(this.mNativeRtcContext, i2)) {
            apiLog("callExperimentalAPI[succeeded]: setSEIPayloadType (" + i2 + ")");
            AppMethodBeat.o(15856);
        } else {
            apiLog("callExperimentalAPI[failed]: setSEIPayloadType (" + i2 + ")");
            AppMethodBeat.o(15856);
        }
    }

    private void updateBigStreamEncoder(boolean z, int i2, int i3, int i4, int i5, boolean z2, int i6) {
        AppMethodBeat.i(222473);
        if (i2 > 0 && i3 > 0) {
            this.mRoomInfo.bigEncSize.f788a = i2;
            this.mRoomInfo.bigEncSize.f789b = i3;
            if (this.mVideoSourceType == VideoSourceType.SCREEN) {
                this.mConfig.l = 1;
                this.mConfig.f777a = this.mRoomInfo.bigEncSize.f788a;
                this.mConfig.f778b = this.mRoomInfo.bigEncSize.f789b;
            } else if (z) {
                this.mConfig.l = 1;
                this.mConfig.f777a = this.mRoomInfo.bigEncSize.f788a;
                this.mConfig.f778b = this.mRoomInfo.bigEncSize.f789b;
            } else {
                this.mConfig.l = 0;
                this.mConfig.f777a = this.mRoomInfo.bigEncSize.f789b;
                this.mConfig.f778b = this.mRoomInfo.bigEncSize.f788a;
            }
            this.mConfig.k = com.tencent.liteav.basic.a.c.RESOLUTION_TYPE_INVALID;
        }
        if (i4 > 0) {
            if (i4 > 30) {
                apiLog("setVideoEncoderParam fps > 30, limit fps to 30");
                this.mConfig.f784h = 30;
            } else {
                this.mConfig.f784h = i4;
            }
        }
        if (i5 > 0) {
            this.mConfig.f779c = i5;
        }
        if (i6 >= 0) {
            this.mConfig.f781e = i6;
        }
        if (this.mVideoSourceType == VideoSourceType.SCREEN) {
            this.mConfig.f785i = 3;
            this.mConfig.p = false;
            if (this.mOverrideFPSFromUser) {
                this.mConfig.f784h = 10;
            }
        } else {
            this.mConfig.p = z2;
        }
        setVideoEncConfig(2, this.mRoomInfo.bigEncSize.f788a, this.mRoomInfo.bigEncSize.f789b, this.mConfig.f784h, this.mConfig.f779c, this.mConfig.p, this.mConfig.f781e);
        if (this.mCodecType == 2 && this.mConfig.f777a * this.mConfig.f778b >= 518400) {
            this.mConfig.f786j = 1;
        }
        this.mCaptureAndEnc.e(this.mConfig.f784h);
        this.mCaptureAndEnc.a(this.mConfig);
        AppMethodBeat.o(222473);
    }

    private void updateSmallStreamEncoder(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(222474);
        if (i2 > 0 && i3 > 0) {
            this.mRoomInfo.smallEncSize.f788a = i2;
            this.mRoomInfo.smallEncSize.f789b = i3;
        }
        if (i4 > 0) {
            if (i4 > 20) {
                apiLog("setVideoSmallEncoderParam fps > 20, limit fps to 20");
                this.mSmallEncParam.videoFps = 20;
            } else {
                this.mSmallEncParam.videoFps = i4;
            }
        }
        if (i5 > 0) {
            this.mSmallEncParam.videoBitrate = i5;
        }
        if (i6 >= 0) {
            this.mSmallEncParam.minVideoBitrate = i6;
        }
        int i7 = this.mConfig.f785i;
        if (this.mVideoSourceType == VideoSourceType.SCREEN) {
            this.mSmallEncParam.enableAdjustRes = false;
            if (this.mOverrideFPSFromUser) {
                this.mSmallEncParam.videoFps = 10;
            }
            i7 = 3;
        }
        this.mCaptureAndEnc.a(this.mEnableSmallStream, this.mRoomInfo.smallEncSize.f788a, this.mRoomInfo.smallEncSize.f789b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, i7);
        setVideoEncConfig(3, this.mRoomInfo.smallEncSize.f788a, this.mRoomInfo.smallEncSize.f789b, this.mSmallEncParam.videoFps, this.mSmallEncParam.videoBitrate, this.mConfig.p, this.mSmallEncParam.minVideoBitrate);
        AppMethodBeat.o(222474);
    }

    private void setVideoEncoderParamEx(JSONObject jSONObject) {
        JSONObject optJSONObject;
        boolean z = true;
        AppMethodBeat.i(15859);
        if (jSONObject == null) {
            apiLog("callExperimentalAPI[lack parameter or illegal type]: codecType");
            AppMethodBeat.o(15859);
            return;
        }
        int optInt = jSONObject.optInt("codecType", -1);
        if (optInt != -1) {
            this.mCodecType = optInt;
            if (this.mCodecType == 0 && (optJSONObject = jSONObject.optJSONObject("softwareCodecParams")) != null) {
                this.mConfig.P = optJSONObject.optInt("enableRealTime") != 0;
                this.mConfig.n = optJSONObject.optInt(Scopes.PROFILE);
            }
        }
        int optInt2 = jSONObject.optInt("videoWidth", 0);
        int optInt3 = jSONObject.optInt("videoHeight", 0);
        int optInt4 = jSONObject.optInt("videoFps", 0);
        int optInt5 = jSONObject.optInt("videoBitrate", 0);
        int optInt6 = jSONObject.optInt("minVideoBitrate", 0);
        int optInt7 = jSONObject.optInt("rcMethod", 0);
        if (optInt2 > 0 && optInt3 > 0) {
            if (optInt2 > 1920) {
                optInt3 = (optInt3 * 1920) / 1920;
                optInt2 = 1920;
            }
            if (optInt3 > 1920) {
                optInt2 = (optInt2 * 1920) / 1920;
                optInt3 = 1920;
            }
            if (optInt2 < 90) {
                optInt3 = (optInt3 * 90) / 90;
                optInt2 = 90;
            }
            if (optInt3 < 90) {
                optInt2 = (optInt2 * 90) / 90;
                optInt3 = 90;
            }
            int i2 = ((optInt2 + 15) / 16) * 16;
            int i3 = ((optInt3 + 15) / 16) * 16;
            int optInt8 = jSONObject.optInt("streamType", 0);
            if (optInt8 == 0) {
                this.mLatestParamsOfBigEncoder.putInt(KEY_CONFIG_FPS, optInt4);
                if (i2 > i3) {
                    z = false;
                }
                updateBigStreamEncoder(z, i2, i3, optInt4, optInt5, this.mConfig.p, optInt6);
                this.mCaptureAndEnc.n(optInt7);
            } else if (optInt8 == 1) {
                this.mLatestParamsOfSmallEncoder.putInt(KEY_CONFIG_FPS, optInt4);
                updateSmallStreamEncoder(i2, i3, optInt4, optInt5, optInt6);
            }
            apiLog("vsize setVideoEncoderParamEx->width:" + this.mRoomInfo.bigEncSize.f788a + ", height:" + this.mRoomInfo.bigEncSize.f789b + ", fps:" + optInt4 + ", bitrate:" + optInt5 + ", stream:" + optInt8);
            updateOrientation();
        }
        AppMethodBeat.o(15859);
    }

    private void setLocalAudioMuteMode(JSONObject jSONObject) {
        AppMethodBeat.i(15860);
        if (jSONObject == null || !jSONObject.has("mode")) {
            apiLog("setLocalAudioMuteMode[lack parameter or illegal type]: mode");
        }
        if (jSONObject.getInt("mode") == 0) {
            this.mEnableEosMode = false;
        } else {
            this.mEnableEosMode = true;
        }
        TXCAudioEngine.getInstance().enableCaptureEOSMode(this.mEnableEosMode);
        AppMethodBeat.o(15860);
    }

    private void setAudioSampleRate(JSONObject jSONObject) {
        AppMethodBeat.i(15861);
        if (jSONObject == null || !jSONObject.has("sampleRate")) {
            apiLog("setAudioSampleRate[lack parameter or illegal type]: sampleRate");
            AppMethodBeat.o(15861);
            return;
        }
        int i2 = jSONObject.getInt("sampleRate");
        if (this.mEnableCustomAudioCapture || this.mIsAudioCapturing) {
            apiLog("setAudioSampleRate[illegal state]");
            AppMethodBeat.o(15861);
        } else if (16000 == i2 || 48000 == i2) {
            TXCAudioEngine.getInstance().setEncoderSampleRate(i2);
            AppMethodBeat.o(15861);
        } else {
            apiLog("muteRemoteAudioInSpeaker[illegal sampleRate]: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(15861);
        }
    }

    private void enableAudioAGC(JSONObject jSONObject) {
        AppMethodBeat.i(15862);
        if (jSONObject == null || !jSONObject.has("enable")) {
            apiLog("enableAudioAGC[lack parameter or illegal type]: enable");
        }
        if (jSONObject.getInt("enable") == 0) {
            this.mEnableSoftAGC = false;
        } else {
            this.mEnableSoftAGC = true;
        }
        if (jSONObject.has("level")) {
            this.mSoftAGCLevel = jSONObject.getInt("level");
        } else {
            this.mSoftAGCLevel = 100;
        }
        TXCAudioEngine.getInstance().enableSoftAGC(this.mEnableSoftAGC, this.mSoftAGCLevel);
        AppMethodBeat.o(15862);
    }

    private void enableAudioAEC(JSONObject jSONObject) {
        AppMethodBeat.i(15863);
        if (jSONObject == null || !jSONObject.has("enable")) {
            apiLog("enableAudioAEC[lack parameter or illegal type]: enable");
        }
        if (jSONObject.getInt("enable") == 0) {
            this.mEnableSoftAEC = false;
        } else {
            this.mEnableSoftAEC = true;
        }
        if (jSONObject.has("level")) {
            this.mSoftAECLevel = jSONObject.getInt("level");
        } else {
            this.mSoftAECLevel = 100;
        }
        TXCAudioEngine.getInstance().enableSoftAEC(this.mEnableSoftAEC, this.mSoftAECLevel);
        AppMethodBeat.o(15863);
    }

    private void enableAudioANS(JSONObject jSONObject) {
        AppMethodBeat.i(15864);
        if (jSONObject == null || !jSONObject.has("enable")) {
            apiLog("enableAudioANS[lack parameter or illegal type]: enable");
        }
        if (jSONObject.getInt("enable") == 0) {
            this.mEnableSoftANS = false;
        } else {
            this.mEnableSoftANS = true;
        }
        if (jSONObject.has("level")) {
            this.mSoftANSLevel = jSONObject.getInt("level");
        } else {
            this.mSoftANSLevel = 100;
        }
        TXCAudioEngine.getInstance().enableSoftANS(this.mEnableSoftANS, this.mSoftANSLevel);
        AppMethodBeat.o(15864);
    }

    public void setPerformanceMode(JSONObject jSONObject) {
        AppMethodBeat.i(15865);
        if (jSONObject == null) {
            apiLog("setPerformanceMode[lack parameter]");
            AppMethodBeat.o(15865);
        } else if (!jSONObject.has("mode")) {
            apiLog("setPerformanceMode[lack parameter]: mode");
            AppMethodBeat.o(15865);
        } else if (jSONObject.getInt("mode") == 1) {
            this.mPerformanceMode = 1;
            this.mCaptureAndEnc.b().enableSharpnessEnhancement(false);
            AppMethodBeat.o(15865);
        } else {
            this.mPerformanceMode = 0;
            AppMethodBeat.o(15865);
        }
    }

    public void muteRemoteAudioInSpeaker(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(15866);
        if (jSONObject == null) {
            apiLog("muteRemoteAudioInSpeaker[lack parameter]");
            AppMethodBeat.o(15866);
        } else if (!jSONObject.has("userID")) {
            apiLog("muteRemoteAudioInSpeaker[lack parameter]: userID");
            AppMethodBeat.o(15866);
        } else {
            String string = jSONObject.getString("userID");
            if (string == null) {
                apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
                AppMethodBeat.o(15866);
            } else if (!jSONObject.has("mute")) {
                apiLog("muteRemoteAudioInSpeaker[lack parameter]: mute");
                AppMethodBeat.o(15866);
            } else {
                int i2 = jSONObject.getInt("mute");
                TRTCRoomInfo.UserInfo user = this.mRoomInfo.getUser(string);
                if (user == null) {
                    apiLog("muteRemoteAudioInSpeaker " + string + " no exist, create one.");
                    TRTCRoomInfo.UserInfo createUserInfo = createUserInfo(string);
                    if (i2 != 1) {
                        z = false;
                    }
                    createUserInfo.muteAudioInSpeaker = z;
                    this.mRoomInfo.addUserInfo(string, createUserInfo);
                    AppMethodBeat.o(15866);
                } else if (user != null) {
                    TXCAudioEngine instance = TXCAudioEngine.getInstance();
                    String valueOf = String.valueOf(user.tinyID);
                    if (i2 != 1) {
                        z = false;
                    }
                    instance.muteRemoteAudioInSpeaker(valueOf, z);
                    AppMethodBeat.o(15866);
                } else {
                    apiLog("muteRemoteAudioInSpeaker[illegal type]: userID");
                    AppMethodBeat.o(15866);
                }
            }
        }
    }

    private void setCustomRenderMode(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(182314);
        if (jSONObject == null) {
            apiLog("setCustomRenderMode param is null");
            AppMethodBeat.o(182314);
        } else if (!jSONObject.has("mode")) {
            apiLog("setCustomRenderMode[lack parameter]: mode");
            AppMethodBeat.o(182314);
        } else {
            int optInt = jSONObject.optInt("mode", 0);
            TRTCRoomInfo tRTCRoomInfo = this.mRoomInfo;
            if (optInt != 1) {
                z = false;
            }
            tRTCRoomInfo.enableCustomPreprocessor = z;
            this.mCaptureAndEnc.a(this.mRoomInfo.enableCustomPreprocessor);
            AppMethodBeat.o(182314);
        }
    }

    private void setMediaCodecConfig(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i2;
        JSONArray jSONArray2 = null;
        boolean z = false;
        AppMethodBeat.i(182315);
        if (jSONObject == null) {
            apiLog("setMediaCodecConfig param is null");
            AppMethodBeat.o(182315);
            return;
        }
        if (jSONObject.has("encProperties")) {
            jSONArray = jSONObject.getJSONArray("encProperties");
        } else {
            jSONArray = null;
        }
        this.mConfig.Y = jSONArray;
        this.mCaptureAndEnc.a(this.mConfig);
        if (jSONObject.has("decProperties")) {
            jSONArray2 = jSONObject.getJSONArray("decProperties");
        }
        this.mRoomInfo.decProperties = jSONArray2;
        if (jSONObject.has("restartDecoder")) {
            i2 = jSONObject.getInt("restartDecoder");
        } else {
            i2 = 0;
        }
        TRTCRoomInfo tRTCRoomInfo = this.mRoomInfo;
        if (i2 != 0) {
            z = true;
        }
        tRTCRoomInfo.enableRestartDecoder = z;
        AppMethodBeat.o(182315);
    }

    private void setFramework(JSONObject jSONObject) {
        AppMethodBeat.i(222475);
        if (jSONObject == null) {
            apiLog("setFramework[lack parameter]");
            AppMethodBeat.o(222475);
        } else if (!jSONObject.has("framework")) {
            apiLog("setFramework[lack parameter]: framework");
            AppMethodBeat.o(222475);
        } else {
            this.mFramework = jSONObject.getInt("framework");
            AppMethodBeat.o(222475);
        }
    }

    private void forceCallbackMixedPlayAudioFrame(JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(222476);
        if (jSONObject == null) {
            apiLog("forceCallbackMixedPlayAudioFrame param is null");
            AppMethodBeat.o(222476);
        } else if (!jSONObject.has("enable")) {
            apiLog("forceCallbackMixedPlayAudioFrame[lack parameter]: enable");
            AppMethodBeat.o(222476);
        } else {
            int optInt = jSONObject.optInt("enable", 0);
            TXCAudioEngine instance = TXCAudioEngine.getInstance();
            if (optInt != 0) {
                z = true;
            }
            instance.forceCallbackMixedPlayAudioFrame(z);
            AppMethodBeat.o(222476);
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void callExperimentalAPI(final String str) {
        AppMethodBeat.i(15867);
        if (str != null) {
            apiLog("callExperimentalAPI  " + str + ", roomid = " + (this.mRoomInfo.roomId != -1 ? Long.valueOf(this.mRoomInfo.roomId) : this.mRoomInfo.strRoomId));
            Monitor.a(1, String.format("callExperimentalAPI:%s", str) + " self:" + hashCode(), "", 0);
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass80 */

            public void run() {
                boolean z = true;
                AppMethodBeat.i(15700);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has(ProviderConstants.API_PATH)) {
                        TRTCCloudImpl.this.apiLog("callExperimentalAPI[lack api or illegal type]: " + str);
                        AppMethodBeat.o(15700);
                        return;
                    }
                    String string = jSONObject.getString(ProviderConstants.API_PATH);
                    JSONObject jSONObject2 = null;
                    if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                        jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                    }
                    if (string.equals("setSEIPayloadType")) {
                        TRTCCloudImpl.this.setSEIPayloadType(jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setLocalAudioMuteMode")) {
                        TRTCCloudImpl.access$5100(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setVideoEncodeParamEx")) {
                        TRTCCloudImpl.access$5200(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setAudioSampleRate")) {
                        TRTCCloudImpl.access$5300(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("muteRemoteAudioInSpeaker")) {
                        TRTCCloudImpl.this.muteRemoteAudioInSpeaker(jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("enableAudioAGC")) {
                        TRTCCloudImpl.access$5400(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("enableAudioAEC")) {
                        TRTCCloudImpl.access$5500(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("enableAudioANS")) {
                        TRTCCloudImpl.access$5600(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setPerformanceMode")) {
                        TRTCCloudImpl.this.setPerformanceMode(jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setCustomRenderMode")) {
                        TRTCCloudImpl.access$5700(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setMediaCodecConfig")) {
                        TRTCCloudImpl.access$5800(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("sendJsonCMD")) {
                        TRTCCloudImpl.this.sendJsonCmd(jSONObject2, str);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("updatePrivateMapKey")) {
                        TRTCCloudImpl.this.updatePrivateMapKey(jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("setFramework")) {
                        TRTCCloudImpl.access$5900(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else if (string.equals("forceCallbackMixedPlayAudioFrame")) {
                        TRTCCloudImpl.access$6000(TRTCCloudImpl.this, jSONObject2);
                        AppMethodBeat.o(15700);
                    } else {
                        if (!string.equals("enableHevcEncode")) {
                            TRTCCloudImpl.this.apiLog("callExperimentalAPI[illegal api]: ".concat(String.valueOf(string)));
                        } else if (jSONObject2.has("enable")) {
                            int i2 = jSONObject2.getInt("enable");
                            TXCLog.i(TRTCCloudImpl.TAG, "enableHevcEncode set = " + i2 + " ,mRoomState=" + TRTCCloudImpl.this.mRoomState);
                            TRTCCloudImpl.this.mEnableHighQualityEncode = i2 != 0;
                            if (TRTCCloudImpl.this.mCaptureAndEnc != null) {
                                com.tencent.liteav.d dVar = TRTCCloudImpl.this.mCaptureAndEnc;
                                if (!TRTCCloudImpl.this.mEnableHighQualityEncode || !TRTCCloudImpl.this.mEnableHighQualityEncodeFromServer || !TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode()) {
                                    z = false;
                                }
                                dVar.j(z);
                            }
                            AppMethodBeat.o(15700);
                            return;
                        }
                        AppMethodBeat.o(15700);
                    }
                } catch (Exception e2) {
                    TRTCCloudImpl.this.apiLog("callExperimentalAPI[failed]: " + str + " " + e2.getMessage());
                    AppMethodBeat.o(15700);
                }
            }
        });
        AppMethodBeat.o(15867);
    }

    public void updatePrivateMapKey(JSONObject jSONObject) {
        AppMethodBeat.i(182316);
        if (jSONObject == null) {
            apiLog("callExperimentalAPI[update private map key fail, params is null");
            AppMethodBeat.o(182316);
            return;
        }
        String string = jSONObject.getString("privateMapKey");
        if (!TextUtils.isEmpty(string)) {
            nativeUpdatePrivateMapKey(this.mNativeRtcContext, string);
            AppMethodBeat.o(182316);
            return;
        }
        apiLog("callExperimentalAPI[update private map key fail, key is empty");
        AppMethodBeat.o(182316);
    }

    public void sendJsonCmd(JSONObject jSONObject, String str) {
        AppMethodBeat.i(15868);
        if (jSONObject == null || !jSONObject.has("jsonParam") || !(jSONObject.get("jsonParam") instanceof JSONObject)) {
            apiLog("callExperimentalAPI[lack parameter or illegal type]: sendJsonCMD");
            AppMethodBeat.o(15868);
            return;
        }
        nativeSendJsonCmd(this.mNativeRtcContext, jSONObject.getJSONObject("jsonParam").toString(), str);
        AppMethodBeat.o(15868);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setLocalVideoRenderListener(final int i2, final int i3, final TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        AppMethodBeat.i(15869);
        if (i2 != 1 && i2 != 4 && i2 != 2) {
            apiLog("setLocalVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(i2)));
            AppMethodBeat.o(15869);
            return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
        } else if (i3 == 1 || i3 == 2 || i3 == 3) {
            runOnSDKThread(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass81 */

                public void run() {
                    AppMethodBeat.i(15777);
                    TRTCCloudImpl.this.apiLog(String.format("setLocalVideoRenderListener pixelFormat:%d bufferType:%d", Integer.valueOf(i2), Integer.valueOf(i3)));
                    TRTCCloudImpl.this.mRoomInfo.localPixelFormat = i2;
                    TRTCCloudImpl.this.mRoomInfo.localBufferType = i3;
                    TRTCCloudImpl.this.mRoomInfo.localListener = tRTCVideoRenderListener;
                    if (tRTCVideoRenderListener == null) {
                        TRTCCloudImpl.this.mCaptureAndEnc.a((o) null, i2);
                        AppMethodBeat.o(15777);
                        return;
                    }
                    TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this, i2);
                    AppMethodBeat.o(15777);
                }
            });
            AppMethodBeat.o(15869);
            return 0;
        } else {
            apiLog("setLocalVideoRenderListener unsupported bufferType : ".concat(String.valueOf(i3)));
            AppMethodBeat.o(15869);
            return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setRemoteVideoRenderListener(final String str, final int i2, final int i3, final TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        AppMethodBeat.i(15870);
        if (i2 != 1 && i2 != 4 && i2 != 2) {
            apiLog("setLocalVideoRenderListener unsupported pixelFormat : ".concat(String.valueOf(i2)));
            AppMethodBeat.o(15870);
            return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
        } else if (i3 == 1 || i3 == 2 || i3 == 3) {
            runOnSDKThread(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass82 */

                public void run() {
                    AppMethodBeat.i(15579);
                    TRTCCloudImpl.this.apiLog(String.format("setRemoteVideoRenderListener userid:%s pixelFormat:%d bufferType:%d", str, Integer.valueOf(i2), Integer.valueOf(i3)));
                    if (tRTCVideoRenderListener == null) {
                        TRTCCloudImpl.this.mRenderListenerMap.remove(str);
                    } else {
                        RenderListenerAdapter renderListenerAdapter = new RenderListenerAdapter();
                        renderListenerAdapter.bufferType = i3;
                        renderListenerAdapter.pixelFormat = i2;
                        renderListenerAdapter.listener = tRTCVideoRenderListener;
                        TRTCCloudImpl.this.mRenderListenerMap.put(str, renderListenerAdapter);
                        TRTCCloudImpl.this.mCustomRemoteRender = true;
                    }
                    TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass82.AnonymousClass1 */

                        @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                        public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                            AppMethodBeat.i(222432);
                            if (str.equalsIgnoreCase(str)) {
                                RenderListenerAdapter renderListenerAdapter = TRTCCloudImpl.this.mRenderListenerMap.get(str);
                                if (renderListenerAdapter != null) {
                                    renderListenerAdapter.strTinyID = String.valueOf(userInfo.tinyID);
                                }
                                TRTCCloudImpl tRTCCloudImpl = tRTCVideoRenderListener != null ? TRTCCloudImpl.this : null;
                                if (userInfo.mainRender.render != null) {
                                    userInfo.mainRender.render.setVideoFrameListener(tRTCCloudImpl, TRTCCloudImpl.access$6400(TRTCCloudImpl.this, renderListenerAdapter.pixelFormat));
                                }
                                if (userInfo.subRender.render != null) {
                                    userInfo.subRender.render.setVideoFrameListener(tRTCCloudImpl, TRTCCloudImpl.access$6400(TRTCCloudImpl.this, renderListenerAdapter.pixelFormat));
                                }
                            }
                            AppMethodBeat.o(222432);
                        }
                    });
                    AppMethodBeat.o(15579);
                }
            });
            AppMethodBeat.o(15870);
            return 0;
        } else {
            apiLog("setLocalVideoRenderListener unsupported bufferType : ".concat(String.valueOf(i3)));
            AppMethodBeat.o(15870);
            return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
        }
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void enableCustomAudioCapture(final boolean z) {
        AppMethodBeat.i(15871);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass83 */

            public void run() {
                int i2 = 0;
                AppMethodBeat.i(15657);
                if (TRTCCloudImpl.this.mEnableCustomAudioCapture == z) {
                    AppMethodBeat.o(15657);
                    return;
                }
                TRTCCloudImpl.this.mEnableCustomAudioCapture = z;
                if (z) {
                    TRTCCloudImpl.this.mConfig.R |= 1;
                    if (TRTCCloudImpl.this.mCurrentRole == 21) {
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass83.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(15714);
                                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                                if (tRTCCloudListener == null) {
                                    AppMethodBeat.o(15714);
                                    return;
                                }
                                tRTCCloudListener.onWarning(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, "ignore send custom audio,for role audience", null);
                                AppMethodBeat.o(15714);
                            }
                        });
                        TRTCCloudImpl.this.apiLog("ignore enableCustomAudioCapture,for role audience");
                    }
                } else {
                    TRTCCloudImpl.this.mConfig.R &= -2;
                }
                TRTCCloudImpl.this.mCaptureAndEnc.a(TRTCCloudImpl.this.mConfig);
                TRTCCloudImpl.this.apiLog("enableCustomAudioCapture " + z);
                Monitor.a(1, String.format("enableCustomAudioCapture:%b", Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                if (!TRTCCloudImpl.this.mIsAudioCapturing) {
                    TRTCCloudImpl.this.enableAudioStream(z);
                }
                if (z) {
                    TRTCCloudImpl.access$4400(TRTCCloudImpl.this);
                    TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
                    TXCAudioEngine.getInstance().startLocalAudio(11, true);
                    TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
                    TXCEventRecorderProxy.a("18446744073709551615", 3003, 11, -1, "", 0);
                } else {
                    TXCAudioEngine.getInstance().stopLocalAudio();
                }
                if (z) {
                    i2 = 1;
                }
                TXCKeyPointReportProxy.a(40050, i2, 1);
                AppMethodBeat.o(15657);
            }
        });
        AppMethodBeat.o(15871);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        AppMethodBeat.i(15872);
        if (tRTCAudioFrame == null) {
            apiLog("sendCustomAudioData parameter is null");
            AppMethodBeat.o(15872);
            return;
        }
        final com.tencent.liteav.basic.structs.a aVar = new com.tencent.liteav.basic.structs.a();
        aVar.f425f = new byte[tRTCAudioFrame.data.length];
        System.arraycopy(tRTCAudioFrame.data, 0, aVar.f425f, 0, tRTCAudioFrame.data.length);
        aVar.f420a = tRTCAudioFrame.sampleRate;
        aVar.f421b = tRTCAudioFrame.channel;
        aVar.f422c = 16;
        if (0 == tRTCAudioFrame.timestamp) {
            aVar.f424e = TXCTimeUtil.generatePtsMS();
        } else {
            aVar.f424e = tRTCAudioFrame.timestamp;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass84 */

            public void run() {
                AppMethodBeat.i(15723);
                if (!TRTCCloudImpl.this.mEnableCustomAudioCapture) {
                    TRTCCloudImpl.this.apiLog("sendCustomAudioData when mEnableCustomAudioCapture is false");
                    AppMethodBeat.o(15723);
                    return;
                }
                TXCAudioEngine.getInstance().sendCustomPCMData(aVar);
                AppMethodBeat.o(15723);
            }
        });
        AppMethodBeat.o(15872);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void playBGM(final String str, final TRTCCloud.BGMNotify bGMNotify) {
        AppMethodBeat.i(15873);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass85 */

            public void run() {
                AppMethodBeat.i(15684);
                TRTCCloudImpl.this.apiLog("playBGM");
                TRTCCloudImpl.this.mBGMNotify = bGMNotify;
                if (TRTCCloudImpl.this.mBGMNotify != null) {
                    TXCLiveBGMPlayer.getInstance().setOnPlayListener(TRTCCloudImpl.this);
                } else {
                    TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
                }
                TXCLiveBGMPlayer.getInstance().startPlay(str);
                AppMethodBeat.o(15684);
            }
        });
        AppMethodBeat.o(15873);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopBGM() {
        AppMethodBeat.i(15874);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass86 */

            public void run() {
                AppMethodBeat.i(15570);
                TRTCCloudImpl.this.apiLog("stopBGM");
                TXCLiveBGMPlayer.getInstance().stopPlay();
                TRTCCloudImpl.this.mBGMNotify = null;
                AppMethodBeat.o(15570);
            }
        });
        AppMethodBeat.o(15874);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseBGM() {
        AppMethodBeat.i(15875);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass87 */

            public void run() {
                AppMethodBeat.i(15669);
                TRTCCloudImpl.this.apiLog("pauseBGM");
                TXCLiveBGMPlayer.getInstance().pause();
                AppMethodBeat.o(15669);
            }
        });
        AppMethodBeat.o(15875);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeBGM() {
        AppMethodBeat.i(15876);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass88 */

            public void run() {
                AppMethodBeat.i(15614);
                TRTCCloudImpl.this.apiLog("resumeBGM");
                TXCLiveBGMPlayer.getInstance().resume();
                AppMethodBeat.o(15614);
            }
        });
        AppMethodBeat.o(15876);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int getBGMDuration(String str) {
        AppMethodBeat.i(15877);
        int bGMDuration = TXCLiveBGMPlayer.getInstance().getBGMDuration(str);
        AppMethodBeat.o(15877);
        return bGMDuration;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public int setBGMPosition(final int i2) {
        AppMethodBeat.i(15878);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass89 */

            public void run() {
                AppMethodBeat.i(15560);
                TRTCCloudImpl.this.apiLog("setBGMPosition " + i2);
                TXCLiveBGMPlayer.getInstance().setBGMPosition(i2);
                AppMethodBeat.o(15560);
            }
        });
        AppMethodBeat.o(15878);
        return 0;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMicVolumeOnMixing(final int i2) {
        AppMethodBeat.i(15879);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass90 */

            public void run() {
                AppMethodBeat.i(15621);
                TRTCCloudImpl.this.apiLog("setMicVolume " + i2);
                TXCAudioEngine.getInstance().setSoftwareCaptureVolume(((float) i2) / 100.0f);
                AppMethodBeat.o(15621);
            }
        });
        AppMethodBeat.o(15879);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setBGMVolume(final int i2) {
        AppMethodBeat.i(15880);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass91 */

            public void run() {
                AppMethodBeat.i(15651);
                TRTCCloudImpl.this.apiLog("setBGMVolume " + i2);
                TXCLiveBGMPlayer.getInstance().setVolume(((float) i2) / 100.0f);
                AppMethodBeat.o(15651);
            }
        });
        AppMethodBeat.o(15880);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setBGMPlayoutVolume(final int i2) {
        AppMethodBeat.i(182317);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass92 */

            public void run() {
                AppMethodBeat.i(15690);
                float f2 = ((float) i2) / 100.0f;
                TRTCCloudImpl.this.apiLog("setBGMPlayoutVolume:" + i2 + " fVolume:" + f2);
                TXCLiveBGMPlayer.getInstance().setPlayoutVolume(f2);
                AppMethodBeat.o(15690);
            }
        });
        AppMethodBeat.o(182317);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setBGMPublishVolume(final int i2) {
        AppMethodBeat.i(182318);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass93 */

            public void run() {
                AppMethodBeat.i(16061);
                TRTCCloudImpl.this.apiLog("setBGMPublishVolume " + i2);
                TXCLiveBGMPlayer.getInstance().setPublishVolume(((float) i2) / 100.0f);
                AppMethodBeat.o(16061);
            }
        });
        AppMethodBeat.o(182318);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setReverbType(final int i2) {
        AppMethodBeat.i(15881);
        if (i2 < 0 || i2 > 7) {
            TXCLog.e(TAG, "reverbType not support :".concat(String.valueOf(i2)));
            AppMethodBeat.o(15881);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass94 */

            public void run() {
                AppMethodBeat.i(15719);
                TRTCCloudImpl.this.apiLog("setLocalViewFillMode");
                TXAudioEffectManagerImpl.getInstance().setVoiceReverbType(TRTCCloudImpl.this.reverbTypes[i2]);
                AppMethodBeat.o(15719);
            }
        });
        AppMethodBeat.o(15881);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean setVoiceChangerType(final int i2) {
        AppMethodBeat.i(15882);
        if (i2 < 0 || i2 > 11) {
            TXCLog.e(TAG, "voiceChangerType not support :".concat(String.valueOf(i2)));
            AppMethodBeat.o(15882);
            return false;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass95 */

            public void run() {
                AppMethodBeat.i(15725);
                TXAudioEffectManagerImpl.getInstance().setVoiceChangerType(TRTCCloudImpl.this.voiceChangerTypes[i2]);
                AppMethodBeat.o(15725);
            }
        });
        AppMethodBeat.o(15882);
        return true;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public TXAudioEffectManager getAudioEffectManager() {
        AppMethodBeat.i(222477);
        TXAudioEffectManagerImpl autoCacheHolder = TXAudioEffectManagerImpl.getAutoCacheHolder();
        AppMethodBeat.o(222477);
        return autoCacheHolder;
    }

    @Override // com.tencent.liteav.audio.b
    public void onEffectPlayFinish(final int i2) {
        AppMethodBeat.i(15883);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass96 */

            public void run() {
                AppMethodBeat.i(15758);
                TRTCCloudImpl.this.apiLog("onEffectPlayFinish -> effectId = " + i2);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onAudioEffectFinished(i2, 0);
                }
                AppMethodBeat.o(15758);
            }
        });
        AppMethodBeat.o(15883);
    }

    @Override // com.tencent.liteav.audio.b
    public void onEffectPlayStart(final int i2, final int i3) {
        AppMethodBeat.i(222478);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass97 */

            public void run() {
                AppMethodBeat.i(15567);
                TRTCCloudImpl.this.apiLog("onEffectPlayStart -> effectId = " + i2 + " code = " + i3);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null && i3 < 0) {
                    tRTCCloudListener.onAudioEffectFinished(i2, i3);
                }
                AppMethodBeat.o(15567);
            }
        });
        AppMethodBeat.o(222478);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void playAudioEffect(final TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
        AppMethodBeat.i(15885);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass98 */

            public void run() {
                AppMethodBeat.i(15704);
                TRTCCloudImpl.this.apiLog("playAudioEffect -> effectId = " + tRTCAudioEffectParam.effectId + " path = " + tRTCAudioEffectParam.path + " publish = " + tRTCAudioEffectParam.publish + " loopCount = " + tRTCAudioEffectParam.loopCount);
                TXCSoundEffectPlayer.getInstance().playEffectWithId(tRTCAudioEffectParam.effectId, tRTCAudioEffectParam.path, tRTCAudioEffectParam.publish, tRTCAudioEffectParam.loopCount);
                AppMethodBeat.o(15704);
            }
        });
        AppMethodBeat.o(15885);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioEffectVolume(final int i2, final int i3) {
        AppMethodBeat.i(15886);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass99 */

            public void run() {
                AppMethodBeat.i(15577);
                TRTCCloudImpl.this.apiLog("setAudioEffectVolume -> effectId = " + i2 + " volume = " + i3);
                TXCSoundEffectPlayer.getInstance().setVolumeOfEffect(i2, ((float) i3) / 100.0f);
                AppMethodBeat.o(15577);
            }
        });
        AppMethodBeat.o(15886);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAudioEffect(final int i2) {
        AppMethodBeat.i(15887);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass100 */

            public void run() {
                AppMethodBeat.i(15699);
                TRTCCloudImpl.this.apiLog("stopAudioEffect -> effectId = " + i2);
                TXCSoundEffectPlayer.getInstance().stopEffectWithId(i2);
                AppMethodBeat.o(15699);
            }
        });
        AppMethodBeat.o(15887);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopAllAudioEffects() {
        AppMethodBeat.i(15888);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass101 */

            public void run() {
                AppMethodBeat.i(15571);
                TRTCCloudImpl.this.apiLog("stopAllAudioEffects");
                TXCSoundEffectPlayer.getInstance().stopAllEffect();
                AppMethodBeat.o(15571);
            }
        });
        AppMethodBeat.o(15888);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAllAudioEffectsVolume(final int i2) {
        AppMethodBeat.i(15889);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass102 */

            public void run() {
                AppMethodBeat.i(15633);
                TRTCCloudImpl.this.apiLog("setAllAudioEffectsVolume volume = " + i2);
                TXCSoundEffectPlayer.getInstance().setEffectsVolume(((float) i2) / 100.0f);
                AppMethodBeat.o(15633);
            }
        });
        AppMethodBeat.o(15889);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void pauseAudioEffect(final int i2) {
        AppMethodBeat.i(182319);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass103 */

            public void run() {
                AppMethodBeat.i(15708);
                TRTCCloudImpl.this.apiLog("pauseAudioEffect -> effectId = " + i2);
                TXCSoundEffectPlayer.getInstance().pauseEffectWithId(i2);
                AppMethodBeat.o(15708);
            }
        });
        AppMethodBeat.o(182319);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void resumeAudioEffect(final int i2) {
        AppMethodBeat.i(182320);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass104 */

            public void run() {
                AppMethodBeat.i(15610);
                TRTCCloudImpl.this.apiLog("resumeAudioEffect -> effectId = " + i2);
                TXCSoundEffectPlayer.getInstance().resumeEffectWithId(i2);
                AppMethodBeat.o(15610);
            }
        });
        AppMethodBeat.o(182320);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void showDebugView(final int i2) {
        AppMethodBeat.i(15890);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass105 */

            public void run() {
                AppMethodBeat.i(15642);
                TRTCCloudImpl.this.apiLog("showDebugView " + i2);
                TRTCCloudImpl.this.mDebugType = i2;
                final TXCloudVideoView tXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
                if (tXCloudVideoView != null) {
                    TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass105.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222411);
                            tXCloudVideoView.showVideoDebugLog(i2);
                            AppMethodBeat.o(222411);
                        }
                    });
                }
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass105.AnonymousClass2 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222440);
                        final TXCloudVideoView tXCloudVideoView = userInfo.mainRender.view;
                        final TXCloudVideoView tXCloudVideoView2 = userInfo.subRender.view;
                        if (!(tXCloudVideoView == null && tXCloudVideoView2 == null)) {
                            TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass105.AnonymousClass2.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(222583);
                                    if (tXCloudVideoView != null) {
                                        tXCloudVideoView.showVideoDebugLog(i2);
                                    }
                                    if (tXCloudVideoView2 != null) {
                                        tXCloudVideoView2.showVideoDebugLog(i2);
                                    }
                                    AppMethodBeat.o(222583);
                                }
                            });
                        }
                        AppMethodBeat.o(222440);
                    }
                });
                AppMethodBeat.o(15642);
            }
        });
        AppMethodBeat.o(15890);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setDebugViewMargin(final String str, final TRTCCloud.TRTCViewMargin tRTCViewMargin) {
        AppMethodBeat.i(15891);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(15891);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass106 */

            public void run() {
                AppMethodBeat.i(15608);
                TRTCCloudImpl.this.apiLog("setDebugViewMargin");
                final TXCloudVideoView tXCloudVideoView = TRTCCloudImpl.this.mRoomInfo.localView;
                if (tXCloudVideoView != null && str.equalsIgnoreCase(tXCloudVideoView.getUserId())) {
                    TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass106.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222413);
                            tXCloudVideoView.setLogMarginRatio(tRTCViewMargin.leftMargin, tRTCViewMargin.rightMargin, tRTCViewMargin.topMargin, tRTCViewMargin.bottomMargin);
                            AppMethodBeat.o(222413);
                        }
                    });
                }
                TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                if (user != null) {
                    user.debugMargin = tRTCViewMargin;
                    final TXCloudVideoView tXCloudVideoView2 = user.mainRender.view;
                    final TXCloudVideoView tXCloudVideoView3 = user.subRender.view;
                    if (!(tXCloudVideoView2 == null && tXCloudVideoView3 == null)) {
                        TRTCCloudImpl.this.runOnMainThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass106.AnonymousClass2 */

                            public void run() {
                                AppMethodBeat.i(222409);
                                if (tXCloudVideoView2 != null) {
                                    tXCloudVideoView2.setLogMarginRatio(tRTCViewMargin.leftMargin, tRTCViewMargin.rightMargin, tRTCViewMargin.topMargin, tRTCViewMargin.bottomMargin);
                                }
                                if (tXCloudVideoView3 != null) {
                                    tXCloudVideoView3.setLogMarginRatio(tRTCViewMargin.leftMargin, tRTCViewMargin.rightMargin, tRTCViewMargin.topMargin, tRTCViewMargin.bottomMargin);
                                }
                                AppMethodBeat.o(222409);
                            }
                        });
                    }
                }
                AppMethodBeat.o(15608);
            }
        });
        AppMethodBeat.o(15891);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startSpeedTest(final int i2, final String str, final String str2) {
        AppMethodBeat.i(15892);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            TXCLog.e(TAG, "startSpeedTest failed with invalid params. userId = " + str + ", userSig = " + str2 + " self:" + hashCode());
            AppMethodBeat.o(15892);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass107 */

            public void run() {
                AppMethodBeat.i(15615);
                TRTCCloudImpl.this.apiLog("startSpeedTest");
                TRTCCloudImpl.access$6600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, i2, str, str2);
                AppMethodBeat.o(15615);
            }
        });
        AppMethodBeat.o(15892);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopSpeedTest() {
        AppMethodBeat.i(15893);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass108 */

            public void run() {
                AppMethodBeat.i(15581);
                TRTCCloudImpl.this.apiLog("stopSpeedTest");
                TRTCCloudImpl.access$6700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
                AppMethodBeat.o(15581);
            }
        });
        AppMethodBeat.o(15893);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishCDNStream(final TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        AppMethodBeat.i(15894);
        if (tRTCPublishCDNParam == null) {
            apiLog("startPublishCDNStream param is null");
            AppMethodBeat.o(15894);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass109 */

            public void run() {
                AppMethodBeat.i(15705);
                TRTCCloudImpl.this.apiLog("startPublishCDNStream");
                TRTCCloudImpl.access$6800(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, tRTCPublishCDNParam);
                AppMethodBeat.o(15705);
            }
        });
        AppMethodBeat.o(15894);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishing() {
        AppMethodBeat.i(182321);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass110 */

            public void run() {
                AppMethodBeat.i(15696);
                TRTCCloudImpl.this.apiLog("stopPublishing");
                TRTCCloudImpl.access$6900(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
                AppMethodBeat.o(15696);
            }
        });
        AppMethodBeat.o(182321);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void stopPublishCDNStream() {
        AppMethodBeat.i(15895);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass111 */

            public void run() {
                AppMethodBeat.i(15760);
                TRTCCloudImpl.this.apiLog("stopPublishCDNStream");
                TRTCCloudImpl.access$7000(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext);
                AppMethodBeat.o(15760);
            }
        });
        AppMethodBeat.o(15895);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void startPublishing(final String str, final int i2) {
        AppMethodBeat.i(182322);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass112 */

            public void run() {
                int i2 = 2;
                AppMethodBeat.i(15655);
                TRTCCloudImpl.this.apiLog("startPublishing streamId:" + str + ", streamType:" + i2);
                if (i2 == 2) {
                    i2 = 7;
                }
                TRTCCloudImpl.access$7100(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, str, i2);
                AppMethodBeat.o(15655);
            }
        });
        AppMethodBeat.o(182322);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setMixTranscodingConfig(final TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        AppMethodBeat.i(15896);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass113 */

            public void run() {
                AppMethodBeat.i(15757);
                TRTCCloudImpl.this.apiLog("setMixTranscodingConfig " + tRTCTranscodingConfig);
                if (tRTCTranscodingConfig == null) {
                    Monitor.a(1, "cancelLiveMixTranscoding self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                }
                if (tRTCTranscodingConfig != null) {
                    TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, new TRTCTranscodingConfigInner(tRTCTranscodingConfig));
                    AppMethodBeat.o(15757);
                    return;
                }
                TRTCCloudImpl.this.nativeSetMixTranscodingConfig(TRTCCloudImpl.this.mNativeRtcContext, null);
                AppMethodBeat.o(15757);
            }
        });
        AppMethodBeat.o(15896);
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendCustomCmdMsg(final int i2, byte[] bArr, final boolean z, final boolean z2) {
        final String str;
        AppMethodBeat.i(15897);
        if (bArr == null) {
            AppMethodBeat.o(15897);
            return false;
        }
        try {
            str = new String(bArr, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            TXCLog.e(TAG, "invalid message data", e2);
            str = null;
        }
        if (this.mCurrentRole == 21) {
            apiLog("ignore send custom cmd msg for audience");
            AppMethodBeat.o(15897);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastSendMsgTimeMs == 0) {
            this.mLastSendMsgTimeMs = currentTimeMillis;
        }
        boolean z3 = false;
        if (currentTimeMillis - this.mLastSendMsgTimeMs >= 1000) {
            z3 = true;
            this.mLastSendMsgTimeMs = currentTimeMillis;
            this.mSendMsgCount = 1;
            this.mSendMsgSize = str.length();
        } else if (this.mSendMsgCount >= 30 || this.mSendMsgSize >= 8192) {
            TXCLog.e(TAG, "send msg too more self:" + hashCode());
        } else {
            z3 = true;
            this.mSendMsgCount++;
            this.mSendMsgSize += str.length();
        }
        if (z3) {
            runOnSDKThread(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass114 */

                public void run() {
                    AppMethodBeat.i(15563);
                    TRTCCloudImpl.access$7200(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, i2, str, z, z2);
                    AppMethodBeat.o(15563);
                }
            });
        }
        AppMethodBeat.o(15897);
        return z3;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public boolean sendSEIMsg(final byte[] bArr, final int i2) {
        boolean z = false;
        AppMethodBeat.i(15898);
        if (bArr == null) {
            AppMethodBeat.o(15898);
        } else if (this.mCurrentRole == 21) {
            apiLog("ignore send sei msg for audience");
            AppMethodBeat.o(15898);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastSendMsgTimeMs == 0) {
                this.mLastSendMsgTimeMs = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastSendMsgTimeMs >= 1000) {
                this.mLastSendMsgTimeMs = currentTimeMillis;
                this.mSendMsgCount = 1;
                this.mSendMsgSize = bArr.length;
                z = true;
            } else if (this.mSendMsgCount >= 30 || this.mSendMsgSize >= 8192) {
                TXCLog.e(TAG, "send msg too more self:" + hashCode());
            } else {
                this.mSendMsgCount++;
                this.mSendMsgSize += bArr.length;
                z = true;
            }
            if (z) {
                runOnSDKThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass115 */

                    public void run() {
                        AppMethodBeat.i(15774);
                        if (!TRTCCloudImpl.this.mEnableHighQualityEncodeFromServer || !TRTCCloudImpl.this.mEnableHighQualityEncode || !TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode()) {
                            TRTCCloudImpl.access$7300(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, bArr, i2);
                        }
                        AppMethodBeat.o(15774);
                    }
                });
            }
            AppMethodBeat.o(15898);
        }
        return z;
    }

    @Override // com.tencent.trtc.TRTCCloud
    public void setAudioFrameListener(final TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        AppMethodBeat.i(15899);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass116 */

            public void run() {
                AppMethodBeat.i(15557);
                TRTCCloudImpl.this.apiLog("setAudioFrameListener " + tRTCAudioFrameListener);
                TRTCCloudImpl.this.mAudioFrameListener = tRTCAudioFrameListener;
                if (TRTCCloudImpl.this.mAudioFrameListener == null) {
                    TXCAudioEngine.setPlayoutDataListener(null);
                    TXCAudioEngine.getInstance().setAudioCaptureDataListener(null);
                    TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass116.AnonymousClass1 */

                        @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                        public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                            AppMethodBeat.i(222434);
                            TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(userInfo.tinyID), null);
                            AppMethodBeat.o(222434);
                        }
                    });
                    AppMethodBeat.o(15557);
                    return;
                }
                TXCAudioEngine.setPlayoutDataListener(this);
                TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass116.AnonymousClass2 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222424);
                        TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(userInfo.tinyID), this);
                        AppMethodBeat.o(222424);
                    }
                });
                AppMethodBeat.o(15557);
            }
        });
        AppMethodBeat.o(15899);
    }

    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(15900);
        super.finalize();
        try {
            destroy();
            AppMethodBeat.o(15900);
        } catch (Exception e2) {
            AppMethodBeat.o(15900);
        } catch (Error e3) {
            AppMethodBeat.o(15900);
        }
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(final int i2, final Bundle bundle) {
        AppMethodBeat.i(15901);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass117 */

            public void run() {
                AppMethodBeat.i(15620);
                if (bundle == null) {
                    AppMethodBeat.o(15620);
                    return;
                }
                String string = bundle.getString("EVT_USERID", "");
                if (TextUtils.isEmpty(string) || string.equalsIgnoreCase("18446744073709551615") || string.equalsIgnoreCase(TRTCCloudImpl.this.mRoomInfo.getTinyId())) {
                    TRTCCloudImpl.this.notifyEvent(TRTCCloudImpl.this.mRoomInfo.getUserId(), i2, bundle);
                    AppMethodBeat.o(15620);
                    return;
                }
                TRTCCloudImpl.access$7400(TRTCCloudImpl.this, string, i2, bundle);
                AppMethodBeat.o(15620);
            }
        });
        AppMethodBeat.o(15901);
    }

    @Override // com.tencent.liteav.d.a
    public void onEncVideo(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(15902);
        if (tXSNALPacket == null) {
            AppMethodBeat.o(15902);
            return;
        }
        synchronized (this.mNativeLock) {
            try {
                pushVideoFrame(tXSNALPacket);
            } finally {
                AppMethodBeat.o(15902);
            }
        }
    }

    @Override // com.tencent.liteav.d.a
    public void onEncVideoFormat(MediaFormat mediaFormat) {
    }

    @Override // com.tencent.liteav.d.a
    public void onBackgroudPushStop() {
    }

    @Override // com.tencent.liteav.TXCRenderAndDec.b
    public void onRequestKeyFrame(final String str, final int i2) {
        AppMethodBeat.i(15903);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(15903);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass118 */

            public void run() {
                AppMethodBeat.i(15611);
                TRTCCloudImpl.access$7500(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, Long.valueOf(str).longValue(), i2);
                AppMethodBeat.o(15611);
            }
        });
        AppMethodBeat.o(15903);
    }

    @Override // com.tencent.liteav.audio.d
    public void onAudioPlayPcmData(final String str, final byte[] bArr, final long j2, final int i2, final int i3) {
        AppMethodBeat.i(15904);
        if (str == null) {
            TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
            if (tRTCAudioFrameListener != null) {
                TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
                tRTCAudioFrame.data = bArr;
                tRTCAudioFrame.timestamp = j2;
                tRTCAudioFrame.sampleRate = i2;
                tRTCAudioFrame.channel = i3;
                tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
            }
            AppMethodBeat.o(15904);
            return;
        }
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass119 */

            public void run() {
                AppMethodBeat.i(15565);
                TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = TRTCCloudImpl.this.mAudioFrameListener;
                if (tRTCAudioFrameListener != null) {
                    TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
                    tRTCAudioFrame.data = bArr;
                    tRTCAudioFrame.timestamp = j2;
                    tRTCAudioFrame.sampleRate = i2;
                    tRTCAudioFrame.channel = i3;
                    try {
                        tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(Long.valueOf(str).longValue()));
                        AppMethodBeat.o(15565);
                        return;
                    } catch (Exception e2) {
                        TXCLog.e(TRTCCloudImpl.TAG, "onPlayAudioFrame failed." + e2.getMessage());
                    }
                }
                AppMethodBeat.o(15565);
            }
        });
        AppMethodBeat.o(15904);
    }

    public void onAudioJitterBufferError(String str, int i2, String str2) {
    }

    @Override // com.tencent.liteav.audio.c
    public void onAudioJitterBufferNotify(final String str, final int i2, final String str2) {
        AppMethodBeat.i(15905);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass120 */

            public void run() {
                AppMethodBeat.i(15628);
                Bundle bundle = new Bundle();
                bundle.putLong("EVT_ID", (long) i2);
                bundle.putLong("EVT_TIME", System.currentTimeMillis());
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str2);
                TRTCCloudImpl.access$7400(TRTCCloudImpl.this, str, i2, bundle);
                AppMethodBeat.o(15628);
            }
        });
        AppMethodBeat.o(15905);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(222479);
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = j2;
            tRTCAudioFrame.sampleRate = i2;
            tRTCAudioFrame.channel = i3;
            tRTCAudioFrameListener.onCapturedRawAudioFrame(tRTCAudioFrame);
        }
        AppMethodBeat.o(222479);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(15906);
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = j2;
            tRTCAudioFrame.sampleRate = i2;
            tRTCAudioFrame.channel = i3;
            tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        }
        AppMethodBeat.o(15906);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordEncData(byte[] bArr, long j2, int i2, int i3, int i4) {
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordError(int i2, String str) {
        AppMethodBeat.i(15907);
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", "18446744073709551615");
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        TXCLog.e(TAG, "onRecordError code = " + i2 + ":" + str + " self:" + hashCode());
        if (i2 == -1) {
            bundle.putInt("EVT_ID", -1302);
            onNotifyEvent(-1302, bundle);
        }
        if (i2 == -6) {
            bundle.putInt("EVT_ID", TXLiteAVCode.EVT_MIC_START_SUCC);
            onNotifyEvent(TXLiteAVCode.EVT_MIC_START_SUCC, bundle);
        }
        if (i2 == -7) {
            bundle.putInt("EVT_ID", TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
            onNotifyEvent(TXLiteAVCode.EVT_MIC_RELEASE_SUCC, bundle);
        }
        AppMethodBeat.o(15907);
    }

    @Override // com.tencent.liteav.o
    public void onRenderVideoFrame(String str, int i2, TXSVideoFrame tXSVideoFrame) {
        String str2;
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        AppMethodBeat.i(15908);
        if (tXSVideoFrame == null) {
            AppMethodBeat.o(15908);
            return;
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        tRTCVideoFrame.width = tXSVideoFrame.width;
        tRTCVideoFrame.height = tXSVideoFrame.height;
        tRTCVideoFrame.rotation = tXSVideoFrame.rotation;
        tRTCVideoFrame.timestamp = tXSVideoFrame.pts;
        int translateStreamType = translateStreamType(i2);
        boolean z = TextUtils.isEmpty(str) || str.equalsIgnoreCase("18446744073709551615") || str.equalsIgnoreCase(this.mRoomInfo.getTinyId());
        if (!z) {
            Iterator<Map.Entry<String, RenderListenerAdapter>> it = this.mRenderListenerMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    tRTCVideoRenderListener = null;
                    break;
                }
                Map.Entry<String, RenderListenerAdapter> next = it.next();
                RenderListenerAdapter value = next.getValue();
                if (value != null && str.equalsIgnoreCase(next.getValue().strTinyID)) {
                    tRTCVideoFrame.pixelFormat = value.pixelFormat;
                    tRTCVideoFrame.bufferType = value.bufferType;
                    TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener2 = value.listener;
                    str2 = next.getKey();
                    tRTCVideoRenderListener = tRTCVideoRenderListener2;
                    break;
                }
            }
        } else {
            String userId = this.mRoomInfo.getUserId();
            tRTCVideoFrame.pixelFormat = this.mRoomInfo.localPixelFormat;
            tRTCVideoFrame.bufferType = this.mRoomInfo.localBufferType;
            str2 = userId;
            tRTCVideoRenderListener = this.mRoomInfo.localListener;
        }
        if (tRTCVideoRenderListener != null) {
            if (tRTCVideoFrame.bufferType == 1) {
                if (tXSVideoFrame.buffer == null) {
                    tXSVideoFrame.loadYUVBufferFromGL();
                }
                tRTCVideoFrame.buffer = tXSVideoFrame.buffer;
            } else if (tRTCVideoFrame.bufferType == 2) {
                tRTCVideoFrame.data = tXSVideoFrame.data;
                if (tRTCVideoFrame.data == null) {
                    tRTCVideoFrame.data = new byte[(((tXSVideoFrame.width * tXSVideoFrame.height) * 3) / 2)];
                    tXSVideoFrame.loadYUVArray(tRTCVideoFrame.data);
                }
            } else if (tRTCVideoFrame.bufferType == 3) {
                if (tXSVideoFrame.eglContext == null) {
                    AppMethodBeat.o(15908);
                    return;
                }
                tRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
                tRTCVideoFrame.texture.textureId = tXSVideoFrame.textureId;
                if (tXSVideoFrame.eglContext instanceof EGLContext) {
                    tRTCVideoFrame.texture.eglContext10 = (EGLContext) tXSVideoFrame.eglContext;
                } else if (tXSVideoFrame.eglContext instanceof android.opengl.EGLContext) {
                    tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) tXSVideoFrame.eglContext;
                }
            }
            tRTCVideoRenderListener.onRenderVideoFrame(str2, translateStreamType, tRTCVideoFrame);
            if (this.mRoomInfo.enableCustomPreprocessor && z) {
                if (tRTCVideoFrame.bufferType == 2) {
                    tXSVideoFrame.data = tRTCVideoFrame.data;
                    AppMethodBeat.o(15908);
                    return;
                } else if (tRTCVideoFrame.bufferType == 3) {
                    tXSVideoFrame.textureId = tRTCVideoFrame.texture.textureId;
                }
            }
        }
        AppMethodBeat.o(15908);
    }

    @Override // com.tencent.liteav.audio.f
    public void onPlayStart() {
        AppMethodBeat.i(15909);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass121 */

            public void run() {
                AppMethodBeat.i(15767);
                TRTCCloud.BGMNotify bGMNotify = TRTCCloudImpl.this.mBGMNotify;
                if (bGMNotify != null) {
                    bGMNotify.onBGMStart(0);
                }
                AppMethodBeat.o(15767);
            }
        });
        AppMethodBeat.o(15909);
    }

    @Override // com.tencent.liteav.audio.f
    public void onPlayEnd(final int i2) {
        AppMethodBeat.i(15910);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass122 */

            public void run() {
                AppMethodBeat.i(15706);
                TRTCCloud.BGMNotify bGMNotify = TRTCCloudImpl.this.mBGMNotify;
                if (bGMNotify != null) {
                    bGMNotify.onBGMComplete(i2);
                }
                AppMethodBeat.o(15706);
            }
        });
        AppMethodBeat.o(15910);
    }

    @Override // com.tencent.liteav.audio.f
    public void onPlayProgress(final long j2, final long j3) {
        AppMethodBeat.i(15911);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass123 */

            public void run() {
                AppMethodBeat.i(15648);
                TRTCCloud.BGMNotify bGMNotify = TRTCCloudImpl.this.mBGMNotify;
                if (bGMNotify != null) {
                    bGMNotify.onBGMProgress(j2, j3);
                }
                AppMethodBeat.o(15648);
            }
        });
        AppMethodBeat.o(15911);
    }

    private void onRequestToken(int i2, String str, final long j2, final byte[] bArr) {
        AppMethodBeat.i(15912);
        apiLog("onRequestToken " + j2 + "," + i2 + ", " + str);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass124 */

            public void run() {
                AppMethodBeat.i(15619);
                TRTCCloudImpl.this.mRoomInfo.setTinyId(String.valueOf(j2));
                TRTCCloudImpl.this.mRoomInfo.setToken(TRTCCloudImpl.this.mContext, bArr);
                AppMethodBeat.o(15619);
            }
        });
        AppMethodBeat.o(15912);
    }

    private void onRequestAccIP(int i2, String str, boolean z) {
        AppMethodBeat.i(15913);
        apiLog("onRequestAccIP err:" + i2 + " " + str + " isAcc:" + z);
        if (i2 == 0) {
            String str2 = z ? "connect ACC" : "connect PROXY";
            Bundle bundle = new Bundle();
            bundle.putLong("EVT_ID", (long) i2);
            bundle.putLong("EVT_TIME", System.currentTimeMillis());
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str2);
            bundle.putInt("EVT_STREAM_TYPE", 2);
            notifyEvent(this.mRoomInfo.getUserId(), i2, bundle);
        }
        AppMethodBeat.o(15913);
    }

    /* access modifiers changed from: protected */
    public void onEnterRoom(final int i2, final String str) {
        AppMethodBeat.i(15914);
        apiLog("onEnterRoom " + i2 + ", " + str);
        Monitor.a(1, String.format("onEnterRoom err:%d msg:%s", Integer.valueOf(i2), str) + " self:" + hashCode(), "", 0);
        if (i2 == 0) {
            TXCEventRecorderProxy.a("18446744073709551615", 5003, 1, -1, "", 0);
        } else {
            TXCEventRecorderProxy.a("18446744073709551615", 5003, 0, -1, "", 0);
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass125 */

            public void run() {
                AppMethodBeat.i(15647);
                if (i2 == 0) {
                    TRTCCloudImpl.this.mRoomState = 2;
                    TRTCCloudImpl.this.mRoomInfo.networkStatus = 3;
                    if (TRTCCloudImpl.this.mRoomInfo.muteLocalVideo) {
                        TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 2, TRTCCloudImpl.this.mRoomInfo.muteLocalVideo);
                    }
                    if (TRTCCloudImpl.this.mRoomInfo.muteLocalAudio) {
                        TRTCCloudImpl.access$4100(TRTCCloudImpl.this, 1, TRTCCloudImpl.this.mRoomInfo.muteLocalAudio);
                    }
                    TRTCCloudImpl.access$7600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "Enter room success");
                    AppMethodBeat.o(15647);
                    return;
                }
                TRTCCloudImpl.this.exitRoomInternal(false, "enter room failed");
                TRTCCloudImpl.access$7600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), i2, "Enter room fail " + str);
                switch (i2) {
                    case TXLiteAVCode.ERR_USER_SIG_INVALID:
                    case TXLiteAVCode.ERR_USER_ID_INVALID:
                    case TXLiteAVCode.ERR_ROOM_ID_INVALID:
                    case TXLiteAVCode.ERR_SDK_APPID_INVALID:
                    case TXLiteAVCode.ERR_ENTER_ROOM_PARAM_NULL:
                        TXCKeyPointReportProxy.b(i2);
                        break;
                }
                AppMethodBeat.o(15647);
            }
        });
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass126 */

            public void run() {
                AppMethodBeat.i(170203);
                TXCKeyPointReportProxy.b(CdnLogic.kMediaLittleAppPacket, i2);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                long roomElapsed = TRTCCloudImpl.this.mRoomInfo.getRoomElapsed();
                if (tRTCCloudListener != null) {
                    if (i2 == 0) {
                        tRTCCloudListener.onEnterRoom(roomElapsed);
                        AppMethodBeat.o(170203);
                        return;
                    }
                    tRTCCloudListener.onEnterRoom((long) i2);
                }
                AppMethodBeat.o(170203);
            }
        });
        AppMethodBeat.o(15914);
    }

    private void onExitRoom(final int i2, String str) {
        AppMethodBeat.i(15915);
        apiLog("onExitRoom " + i2 + ", " + str);
        Monitor.a(1, String.format("onExitRoom err:%d msg:%s", Integer.valueOf(i2), str) + " self:" + hashCode(), "", 0);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass127 */

            public void run() {
                AppMethodBeat.i(15605);
                if (TRTCCloudImpl.this.mIsExitOldRoom) {
                    TRTCCloudImpl.this.mIsExitOldRoom = false;
                    TRTCCloudImpl.this.apiLog("exit no current room, ignore onExitRoom.");
                    AppMethodBeat.o(15605);
                } else if (TRTCCloudImpl.this.mRoomInfo.isMicStard()) {
                    TRTCCloudImpl.this.mRoomInfo.setRoomExit(true, i2);
                    TRTCCloudImpl.this.apiLog("onExitRoom delay 2s when mic is not release.");
                    TRTCCloudImpl.access$7700(TRTCCloudImpl.this, new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass127.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(15686);
                            if (TRTCCloudImpl.this.mRoomInfo.isRoomExit()) {
                                TRTCCloudImpl.this.apiLog("force onExitRoom after 2s");
                                final int roomExitCode = TRTCCloudImpl.this.mRoomInfo.getRoomExitCode();
                                TRTCCloudImpl.this.mRoomInfo.setRoomExit(false, 0);
                                TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass127.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        AppMethodBeat.i(222422);
                                        TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                                        if (tRTCCloudListener != null) {
                                            tRTCCloudListener.onExitRoom(roomExitCode);
                                        }
                                        AppMethodBeat.o(222422);
                                    }
                                });
                            }
                            AppMethodBeat.o(15686);
                        }
                    }, 2000);
                    AppMethodBeat.o(15605);
                } else {
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass127.AnonymousClass2 */

                        public void run() {
                            AppMethodBeat.i(222438);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            if (tRTCCloudListener != null) {
                                tRTCCloudListener.onExitRoom(i2);
                            }
                            AppMethodBeat.o(222438);
                        }
                    });
                    AppMethodBeat.o(15605);
                }
            }
        });
        AppMethodBeat.o(15915);
    }

    private void onKickOut(final int i2, final String str) {
        AppMethodBeat.i(15916);
        apiLog("onKickOut " + i2 + ", " + str);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass128 */

            public void run() {
                AppMethodBeat.i(15759);
                TRTCCloudImpl.this.exitRoomInternal(false, "onKickOut " + str);
                TRTCCloudImpl.access$7800(TRTCCloudImpl.this, i2, str);
                AppMethodBeat.o(15759);
            }
        });
        AppMethodBeat.o(15916);
    }

    private void onConnectOtherRoom(final String str, final int i2, final String str2) {
        AppMethodBeat.i(15917);
        apiLog("onConnectOtherRoom " + str + ", " + i2 + ", " + str2);
        Monitor.a(1, String.format("onConnectOtherRoom userId:%s err:%d, msg:%s", str, Integer.valueOf(i2), str2) + " self:" + hashCode(), "", 0);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass129 */

            public void run() {
                AppMethodBeat.i(15635);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    TRTCCloudImpl.this.mTRTCListener.onConnectOtherRoom(str, i2, str2);
                }
                AppMethodBeat.o(15635);
            }
        });
        AppMethodBeat.o(15917);
    }

    private void onDisConnectOtherRoom(final int i2, final String str) {
        AppMethodBeat.i(15918);
        apiLog("onDisConnectOtherRoom " + i2 + ", " + str);
        Monitor.a(1, String.format("onDisConnectOtherRoom err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + hashCode(), "", 0);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass130 */

            public void run() {
                AppMethodBeat.i(15673);
                if (TRTCCloudImpl.this.mTRTCListener != null) {
                    TRTCCloudImpl.this.mTRTCListener.onDisConnectOtherRoom(i2, str);
                }
                AppMethodBeat.o(15673);
            }
        });
        AppMethodBeat.o(15918);
    }

    private void onCallExperimentalAPI(int i2, String str) {
        AppMethodBeat.i(15919);
        apiLog("onCallExperimentalAPI " + i2 + ", " + str);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass131 */

            public void run() {
                AppMethodBeat.i(15763);
                AppMethodBeat.o(15763);
            }
        });
        AppMethodBeat.o(15919);
    }

    private void onRequestDownStream(final int i2, final String str, final long j2, final int i3) {
        AppMethodBeat.i(15920);
        if (i2 != 0) {
            runOnListenerThread(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass132 */

                public void run() {
                    AppMethodBeat.i(15720);
                    TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                    if (tRTCCloudListener != null) {
                        tRTCCloudListener.onError(i2, str, null);
                    }
                    AppMethodBeat.o(15720);
                }
            });
            AppMethodBeat.o(15920);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass133 */

            public void run() {
                AppMethodBeat.i(15676);
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass133.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(170197);
                        if (i3 != 1 && j2 == userInfo.tinyID) {
                            TRTCCloudImpl.this.apiLog("onRequestDownStream " + userInfo.tinyID + ", " + userInfo.userID + ", " + i3);
                            if (i3 == 7) {
                                if (!(userInfo.subRender.render == null || userInfo.subRender.render.getStreamType() == i3)) {
                                    userInfo.subRender.render.stopVideo();
                                    userInfo.subRender.render.setStreamType(i3);
                                    userInfo.subRender.render.startVideo();
                                    AppMethodBeat.o(170197);
                                    return;
                                }
                            } else if (!(userInfo.mainRender.render == null || userInfo.mainRender.render.getStreamType() == i3)) {
                                userInfo.mainRender.render.stopVideo();
                                userInfo.mainRender.render.setStreamType(i3);
                                userInfo.mainRender.render.startVideo();
                                TXCKeyPointReportProxy.a(String.valueOf(userInfo.tinyID), 40038, 0, i3);
                            }
                        }
                        AppMethodBeat.o(170197);
                    }
                });
                AppMethodBeat.o(15676);
            }
        });
        AppMethodBeat.o(15920);
    }

    private TXCRenderAndDec createRender(long j2, int i2) {
        boolean z = true;
        AppMethodBeat.i(15921);
        TXCRenderAndDec tXCRenderAndDec = new TXCRenderAndDec(this.mContext);
        tXCRenderAndDec.setID(String.valueOf(j2));
        tXCRenderAndDec.setVideoRender(new com.tencent.liteav.renderer.a());
        tXCRenderAndDec.setStreamType(i2);
        tXCRenderAndDec.setNotifyListener(this);
        tXCRenderAndDec.setRenderAndDecDelegate(this);
        tXCRenderAndDec.setRenderMode(0);
        if (this.mPerformanceMode == 1) {
            z = false;
        }
        tXCRenderAndDec.enableDecoderChange(z);
        tXCRenderAndDec.enableRestartDecoder(this.mRoomInfo.enableRestartDecoder);
        tXCRenderAndDec.enableLimitDecCache(this.mVideoServerConfig.enableHWVUI);
        applyRenderConfig(tXCRenderAndDec);
        AppMethodBeat.o(15921);
        return tXCRenderAndDec;
    }

    /* access modifiers changed from: protected */
    public void onAVMemberEnter(final long j2, final String str, final int i2, final int i3) {
        AppMethodBeat.i(15922);
        final WeakReference weakReference = new WeakReference(this);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass134 */

            public void run() {
                TRTCRoomInfo.UserInfo userInfo;
                AppMethodBeat.i(15640);
                if (TRTCCloudImpl.this.mRoomState == 0) {
                    TRTCCloudImpl.this.apiLog("ignore onAVMemberEnter when out room.");
                    AppMethodBeat.o(15640);
                } else if (((TRTCCloudImpl) weakReference.get()) == null) {
                    AppMethodBeat.o(15640);
                } else {
                    TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                    if (user != null) {
                        TRTCCloudImpl.this.apiLog(" user " + str + "enter room when user is in room " + j2);
                    }
                    String valueOf = String.valueOf(j2);
                    if (user == null) {
                        userInfo = TRTCCloudImpl.access$2300(TRTCCloudImpl.this, str);
                    } else {
                        userInfo = user;
                    }
                    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(valueOf, TRTCCloudImpl.this);
                    if (TRTCCloudImpl.this.mAudioFrameListener != null) {
                        TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(valueOf, TRTCCloudImpl.this);
                    }
                    TXCAudioEngine.getInstance().startRemoteAudio(valueOf, true);
                    TXCAudioEngine.getInstance().muteRemoteAudio(valueOf, userInfo.mainRender.muteAudio);
                    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(valueOf, userInfo.muteAudioInSpeaker);
                    if (userInfo.mainRender.muteAudio) {
                        TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, j2, 1, true);
                    }
                    TXCRenderAndDec access$7900 = TRTCCloudImpl.access$7900(TRTCCloudImpl.this, j2, TRTCCloudImpl.this.mPriorStreamType);
                    RenderListenerAdapter renderListenerAdapter = TRTCCloudImpl.this.mRenderListenerMap.get(str);
                    if (renderListenerAdapter != null) {
                        renderListenerAdapter.strTinyID = valueOf;
                        if (renderListenerAdapter.listener != null) {
                            access$7900.setVideoFrameListener(TRTCCloudImpl.this, TRTCCloudImpl.access$6400(TRTCCloudImpl.this, renderListenerAdapter.pixelFormat));
                        }
                    }
                    userInfo.tinyID = j2;
                    userInfo.userID = str;
                    userInfo.terminalType = i2;
                    userInfo.streamState = i3;
                    userInfo.mainRender.render = access$7900;
                    userInfo.mainRender.tinyID = j2;
                    userInfo.streamType = TRTCCloudImpl.this.mPriorStreamType;
                    if (userInfo.mainRender.view != null) {
                        TRTCCloudImpl.this.setRenderView(str, userInfo.mainRender, userInfo.mainRender.view, userInfo.debugMargin);
                        TRTCCloudImpl.this.apiLog(String.format("startRemoteView when user enter userID:%s tinyID:%d streamType:%d", str, Long.valueOf(userInfo.tinyID), Integer.valueOf(userInfo.streamType)));
                        TRTCCloudImpl.access$2400(TRTCCloudImpl.this, String.valueOf(userInfo.tinyID), userInfo.streamType, 0, "Start watching " + str);
                        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, userInfo.mainRender.render, userInfo.streamType);
                        TXCKeyPointReportProxy.a(String.valueOf(userInfo.tinyID), 40021, 0, userInfo.streamType);
                        if (!userInfo.mainRender.muteVideo) {
                            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, userInfo.streamType, true);
                        } else {
                            TRTCCloudImpl.access$2700(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, userInfo.streamType, true);
                        }
                    }
                    userInfo.subRender.render = TRTCCloudImpl.access$7900(TRTCCloudImpl.this, j2, 7);
                    userInfo.subRender.tinyID = j2;
                    userInfo.subRender.muteVideo = TRTCCloudImpl.this.mRoomInfo.muteRemoteVideo;
                    if (userInfo.subRender.view != null) {
                        TRTCCloudImpl.this.setRenderView(str, userInfo.subRender, userInfo.subRender.view, userInfo.debugMargin);
                        TRTCCloudImpl.this.apiLog(String.format("onUserScreenAvailable when user enter userID:%s tinyID:%d streamType:%d", str, Long.valueOf(userInfo.tinyID), 7));
                        Monitor.a(1, String.format("startRemoteSubStreamView userID:%s", str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                        TRTCCloudImpl.access$2400(TRTCCloudImpl.this, String.valueOf(userInfo.tinyID), 7, 0, "Start watching " + str);
                        TRTCCloudImpl.access$2500(TRTCCloudImpl.this, userInfo.subRender.render, 7);
                        TXCKeyPointReportProxy.a(String.valueOf(userInfo.tinyID), 40021, 0, 7);
                        if (!userInfo.subRender.muteVideo) {
                            TRTCCloudImpl.access$2600(TRTCCloudImpl.this, TRTCCloudImpl.this.mNativeRtcContext, userInfo.tinyID, 7, true);
                        }
                    }
                    TRTCCloudImpl.this.mRoomInfo.addUserInfo(str, userInfo);
                    TRTCCloudImpl.this.apiLog("onAVMemberEnter " + j2 + ", " + str + ", " + i3);
                    final TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass134.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222444);
                            if (tRTCCloudListener != null) {
                                tRTCCloudListener.onUserEnter(str);
                            }
                            AppMethodBeat.o(222444);
                        }
                    });
                    final boolean z = TRTCRoomInfo.hasAudio(i3) && !TRTCRoomInfo.isMuteAudio(i3);
                    if (z) {
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass134.AnonymousClass2 */

                            public void run() {
                                AppMethodBeat.i(222415);
                                if (tRTCCloudListener != null) {
                                    tRTCCloudListener.onUserAudioAvailable(str, z);
                                }
                                Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                AppMethodBeat.o(222415);
                            }
                        });
                        TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[true]", str));
                    }
                    final boolean z2 = (TRTCRoomInfo.hasMainVideo(i3) || TRTCRoomInfo.hasSmallVideo(i3)) && !TRTCRoomInfo.isMuteMainVideo(i3);
                    if (z2 && TRTCCloudImpl.this.mRoomInfo.hasRecvFirstIFrame(j2)) {
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass134.AnonymousClass3 */

                            public void run() {
                                AppMethodBeat.i(222446);
                                TXCLog.i(TRTCCloudImpl.TAG, "notify onUserVideoAvailable:" + j2 + " [" + z2 + "] by bit state. self:" + TRTCCloudImpl.this.hashCode());
                                if (tRTCCloudListener != null) {
                                    tRTCCloudListener.onUserVideoAvailable(str, z2);
                                }
                                Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z2)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                AppMethodBeat.o(222446);
                            }
                        });
                        TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[true]", str));
                    }
                    final boolean z3 = TRTCRoomInfo.hasSubVideo(i3) && !TRTCRoomInfo.isMuteSubVideo(i3);
                    if (z3) {
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass134.AnonymousClass4 */

                            public void run() {
                                AppMethodBeat.i(222572);
                                if (tRTCCloudListener != null) {
                                    tRTCCloudListener.onUserSubStreamAvailable(str, z3);
                                }
                                Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z3)) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                AppMethodBeat.o(222572);
                            }
                        });
                        TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subvideo Available[true]", str));
                    }
                    TRTCCloudImpl.access$7600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]enter room", str));
                    AppMethodBeat.o(15640);
                }
            }
        });
        AppMethodBeat.o(15922);
    }

    /* access modifiers changed from: protected */
    public void onAVMemberExit(final long j2, final String str, int i2, final int i3) {
        AppMethodBeat.i(15923);
        final WeakReference weakReference = new WeakReference(this);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass135 */

            public void run() {
                AppMethodBeat.i(15769);
                if (TRTCCloudImpl.this.mRoomState == 0) {
                    TRTCCloudImpl.this.apiLog("ignore onAVMemberExit when out room.");
                    AppMethodBeat.o(15769);
                } else if (((TRTCCloudImpl) weakReference.get()) == null) {
                    AppMethodBeat.o(15769);
                } else {
                    TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                    if (user != null) {
                        TRTCCloudImpl.this.stopRemoteRender(user);
                        TRTCCloudImpl.this.mRoomInfo.removeRenderInfo(user.userID);
                    } else {
                        TRTCCloudImpl.this.apiLog("user " + str + " exit room when user is not in room " + j2);
                    }
                    TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(j2));
                    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(j2), null);
                    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(String.valueOf(j2), null);
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass135.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(182393);
                            TRTCCloudImpl.this.apiLog("onAVMemberExit " + j2 + ", " + str + ", " + i3);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            if (tRTCCloudListener != null) {
                                if (TRTCRoomInfo.hasAudio(i3) && !TRTCRoomInfo.isMuteAudio(i3)) {
                                    tRTCCloudListener.onUserAudioAvailable(str, false);
                                    TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", str, Boolean.FALSE));
                                    Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", str, Boolean.FALSE) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                }
                                if ((TRTCRoomInfo.hasMainVideo(i3) || TRTCRoomInfo.hasSmallVideo(i3)) && !TRTCRoomInfo.isMuteMainVideo(i3)) {
                                    tRTCCloudListener.onUserVideoAvailable(str, false);
                                    TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", str, Boolean.FALSE));
                                    Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", str, Boolean.FALSE) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                }
                                if (TRTCRoomInfo.hasSubVideo(i3) && !TRTCRoomInfo.isMuteSubVideo(i3)) {
                                    tRTCCloudListener.onUserSubStreamAvailable(str, false);
                                    TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", str, Boolean.FALSE));
                                    Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", str, Boolean.FALSE) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                }
                                tRTCCloudListener.onUserExit(str, 0);
                            }
                            AppMethodBeat.o(182393);
                        }
                    });
                    AppMethodBeat.o(15769);
                }
            }
        });
        notifyEvent(this.mRoomInfo.getUserId(), 0, String.format("[%s]leave room", str));
        AppMethodBeat.o(15923);
    }

    private void onAVMemberChange(final long j2, final String str, int i2, final int i3, final int i4) {
        AppMethodBeat.i(15924);
        final WeakReference weakReference = new WeakReference(this);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass136 */

            public void run() {
                AppMethodBeat.i(170215);
                if (TRTCCloudImpl.this.mRoomState == 0) {
                    TRTCCloudImpl.this.apiLog("ignore onAVMemberChange when out room");
                    AppMethodBeat.o(170215);
                } else if (((TRTCCloudImpl) weakReference.get()) == null) {
                    AppMethodBeat.o(170215);
                } else {
                    TRTCCloudImpl.this.apiLog("onAVMemberChange " + j2 + ", " + str + ", old state:" + i4 + ", new state:" + i3);
                    TRTCRoomInfo.UserInfo user = TRTCCloudImpl.this.mRoomInfo.getUser(str);
                    if (user != null) {
                        user.streamState = i3;
                        TRTCCloudImpl.this.checkUserState(str, j2, i3, i4);
                    }
                    AppMethodBeat.o(170215);
                }
            }
        });
        AppMethodBeat.o(15924);
    }

    private void onWholeMemberEnter(long j2, final String str) {
        AppMethodBeat.i(15925);
        final WeakReference weakReference = new WeakReference(this);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass137 */

            public void run() {
                AppMethodBeat.i(15618);
                if (((TRTCCloudImpl) weakReference.get()) == null) {
                    AppMethodBeat.o(15618);
                    return;
                }
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onRemoteUserEnterRoom(str);
                }
                AppMethodBeat.o(15618);
            }
        });
        AppMethodBeat.o(15925);
    }

    private void onWholeMemberExit(long j2, final String str, final int i2) {
        AppMethodBeat.i(15926);
        final WeakReference weakReference = new WeakReference(this);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass138 */

            public void run() {
                AppMethodBeat.i(15692);
                if (((TRTCCloudImpl) weakReference.get()) == null) {
                    AppMethodBeat.o(15692);
                    return;
                }
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onRemoteUserLeaveRoom(str, i2);
                }
                AppMethodBeat.o(15692);
            }
        });
        AppMethodBeat.o(15926);
    }

    private void onNotify(long j2, int i2, int i3, String str) {
        AppMethodBeat.i(15927);
        apiLog(j2 + " event " + i3 + ", " + str);
        String valueOf = String.valueOf(j2);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_ID", (long) i3);
        bundle.putLong("EVT_TIME", System.currentTimeMillis());
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putInt("EVT_STREAM_TYPE", i2);
        if (TextUtils.isEmpty(valueOf) || j2 == 0 || valueOf.equalsIgnoreCase("18446744073709551615") || valueOf.equalsIgnoreCase(this.mRoomInfo.getTinyId())) {
            notifyEvent(this.mRoomInfo.getUserId(), i3, bundle);
            AppMethodBeat.o(15927);
            return;
        }
        notifyLogByUserId(String.valueOf(j2), i2, i3, str);
        AppMethodBeat.o(15927);
    }

    public void onAudioQosChanged(int i2, int i3, int i4) {
        AppMethodBeat.i(15928);
        onAudioQosChanged(this, i2, i3, i4);
        AppMethodBeat.o(15928);
    }

    public void onAudioQosChanged(TRTCCloudImpl tRTCCloudImpl, final int i2, final int i3, final int i4) {
        AppMethodBeat.i(222480);
        if (!isPublishingInCloud(tRTCCloudImpl, 1)) {
            AppMethodBeat.o(222480);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass139 */

            public void run() {
                AppMethodBeat.i(15650);
                TXCAudioEngine.getInstance().setAudioEncoderParam(i2, i3);
                TXCAudioEngine.getInstance().setEncoderFECPercent((float) i4);
                AppMethodBeat.o(15650);
            }
        });
        AppMethodBeat.o(222480);
    }

    public void onVideoQosChanged(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(259886);
        onVideoQosChanged(this, i2, i3, i4, i5, i6, i7, i8, i9);
        AppMethodBeat.o(259886);
    }

    public void onVideoQosChanged(TRTCCloudImpl tRTCCloudImpl, final int i2, final int i3, final int i4, final int i5, final int i6, final int i7, final int i8, final int i9) {
        AppMethodBeat.i(259887);
        if (!isPublishingInCloud(tRTCCloudImpl, i2)) {
            AppMethodBeat.o(259887);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass140 */

            public void run() {
                int i2 = 0;
                AppMethodBeat.i(15626);
                TRTCCloudImpl.this.mCaptureAndEnc.a(i2, i3, i4, i5, i6, i7, i8, i9 == 1);
                if (i2 == 2) {
                    if (i3 <= i4) {
                        i2 = 1;
                    }
                    if (!(TRTCCloudImpl.this.mConfig.l == i2 || i3 == i4)) {
                        TRTCCloudImpl.this.mConfig.l = i2;
                        TRTCCloudImpl.access$2100(TRTCCloudImpl.this);
                    }
                }
                AppMethodBeat.o(15626);
            }
        });
        AppMethodBeat.o(259887);
    }

    public void onIdrFpsChanged(int i2) {
        AppMethodBeat.i(15930);
        onIdrFpsChanged(this, i2);
        AppMethodBeat.o(15930);
    }

    public void onIdrFpsChanged(TRTCCloudImpl tRTCCloudImpl, final int i2) {
        AppMethodBeat.i(222482);
        if (!isPublishingInCloud(tRTCCloudImpl, 2)) {
            AppMethodBeat.o(222482);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass141 */

            public void run() {
                AppMethodBeat.i(15575);
                TRTCCloudImpl.this.mCaptureAndEnc.c(i2);
                AppMethodBeat.o(15575);
            }
        });
        AppMethodBeat.o(222482);
    }

    private void onVideoBlockThresholdChanged(final int i2) {
        AppMethodBeat.i(222483);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass142 */

            public void run() {
                AppMethodBeat.i(15569);
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass142.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(182307);
                        if (userInfo.mainRender.render != null) {
                            userInfo.mainRender.render.setBlockInterval(i2);
                        }
                        if (userInfo.subRender.render != null) {
                            userInfo.subRender.render.setBlockInterval(i2);
                        }
                        AppMethodBeat.o(182307);
                    }
                });
                AppMethodBeat.o(15569);
            }
        });
        AppMethodBeat.o(222483);
    }

    private void onConnectionLost() {
        AppMethodBeat.i(15932);
        this.mRoomInfo.networkStatus = 1;
        notifyEvent(this.mRoomInfo.getUserId(), 0, "Network anomaly.");
        Monitor.a(1, "onConnectionLost self:" + hashCode(), "", 0);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass143 */

            public void run() {
                AppMethodBeat.i(15722);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onConnectionLost();
                }
                AppMethodBeat.o(15722);
            }
        });
        AppMethodBeat.o(15932);
    }

    private void onTryToReconnect() {
        AppMethodBeat.i(15933);
        this.mRoomInfo.networkStatus = 2;
        notifyEvent(this.mRoomInfo.getUserId(), 0, "Retry enter room.");
        Monitor.a(1, "onTryToReconnect self:" + hashCode(), "", 0);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass144 */

            public void run() {
                AppMethodBeat.i(170201);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onTryToReconnect();
                }
                AppMethodBeat.o(170201);
            }
        });
        AppMethodBeat.o(15933);
    }

    private void onConnectionRecovery() {
        AppMethodBeat.i(15934);
        this.mRoomInfo.networkStatus = 3;
        notifyEvent(this.mRoomInfo.getUserId(), 0, "Network recovered. Successfully re-enter room");
        Monitor.a(1, "onConnectionRecovery self:" + hashCode(), "", 0);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass145 */

            public void run() {
                AppMethodBeat.i(182303);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onConnectionRecovery();
                }
                AppMethodBeat.o(182303);
            }
        });
        AppMethodBeat.o(15934);
    }

    private void onSendCustomCmdMsgResult(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(15935);
        AppMethodBeat.o(15935);
    }

    private void onRecvCustomCmdMsg(final String str, long j2, final int i2, final int i3, final String str2, final boolean z, final int i4, long j3) {
        AppMethodBeat.i(15936);
        long currentTimeMillis = System.currentTimeMillis();
        this.mRecvCustomCmdMsgCountInPeriod++;
        if (currentTimeMillis - this.mLastLogCustomCmdMsgTs > 10000) {
            TXCLog.i(TAG, "onRecvMsg. tinyId=" + j2 + ", streamId = " + i2 + ", msg = " + str2 + ", recvTime = " + j3 + ", recvCustomMsgCountInPeriod = " + this.mRecvCustomCmdMsgCountInPeriod + " self:" + hashCode());
            this.mLastLogCustomCmdMsgTs = currentTimeMillis;
            this.mRecvCustomCmdMsgCountInPeriod = 0;
        }
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass146 */

            public void run() {
                AppMethodBeat.i(15675);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    try {
                        tRTCCloudListener.onRecvCustomCmdMsg(str, i2, i3, str2.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    } catch (UnsupportedEncodingException e2) {
                        TXCLog.e(TRTCCloudImpl.TAG, "onRecvCustomCmdMsg failed.", e2);
                    }
                    if (z && i4 > 0) {
                        tRTCCloudListener.onMissCustomCmdMsg(str, i2, -1, i4);
                    }
                }
                AppMethodBeat.o(15675);
            }
        });
        AppMethodBeat.o(15936);
    }

    private void onRecvSEIMsg(final long j2, final byte[] bArr) {
        AppMethodBeat.i(15937);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass147 */

            public void run() {
                AppMethodBeat.i(15654);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    try {
                        String userIdByTinyId = TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(j2);
                        if (userIdByTinyId != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            TRTCCloudImpl.access$8108(TRTCCloudImpl.this);
                            if (currentTimeMillis - TRTCCloudImpl.this.mLastLogSEIMsgTs > 10000) {
                                TXCLog.i(TRTCCloudImpl.TAG, "onRecvSEIMsg. userId=" + userIdByTinyId + ", message = " + new String(bArr) + ", recvSEIMsgCountInPeriod = " + TRTCCloudImpl.this.mRecvSEIMsgCountInPeriod + " self:" + TRTCCloudImpl.this.hashCode());
                                TRTCCloudImpl.this.mLastLogSEIMsgTs = currentTimeMillis;
                                TRTCCloudImpl.this.mRecvSEIMsgCountInPeriod = 0;
                            }
                            tRTCCloudListener.onRecvSEIMsg(userIdByTinyId, bArr);
                            AppMethodBeat.o(15654);
                            return;
                        }
                        TXCLog.i(TRTCCloudImpl.TAG, "onRecvSEIMsg Error, user id is null for tinyId=" + j2 + " self:" + TRTCCloudImpl.this.hashCode());
                        AppMethodBeat.o(15654);
                        return;
                    } catch (Exception e2) {
                        TXCLog.e(TRTCCloudImpl.TAG, "onRecvSEIMsg failed.", e2);
                    }
                }
                AppMethodBeat.o(15654);
            }
        });
        AppMethodBeat.o(15937);
    }

    private void onSpeedTest(final String str, final int i2, final float f2, final float f3, final int i3, final int i4) {
        AppMethodBeat.i(15938);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass148 */

            public void run() {
                AppMethodBeat.i(170195);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult = new TRTCCloudDef.TRTCSpeedTestResult();
                    tRTCSpeedTestResult.ip = str;
                    tRTCSpeedTestResult.rtt = i2;
                    tRTCSpeedTestResult.upLostRate = f2;
                    tRTCSpeedTestResult.downLostRate = f3;
                    if (f2 >= f3) {
                        tRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(i2, (int) (f2 * 100.0f));
                    } else {
                        tRTCSpeedTestResult.quality = TRTCCloudImpl.this.getNetworkQuality(i2, (int) (f3 * 100.0f));
                    }
                    tRTCCloudListener.onSpeedTest(tRTCSpeedTestResult, i3, i4);
                    TRTCCloudImpl.this.apiLog(String.format("SpeedTest progress %d/%d, result: %s", Integer.valueOf(i3), Integer.valueOf(i4), tRTCSpeedTestResult.toString()));
                }
                AppMethodBeat.o(170195);
            }
        });
        AppMethodBeat.o(15938);
    }

    public void onVideoConfigChanged(int i2, boolean z) {
        AppMethodBeat.i(15939);
        onVideoConfigChanged(this, i2, z);
        AppMethodBeat.o(15939);
    }

    public void onVideoConfigChanged(TRTCCloudImpl tRTCCloudImpl, final int i2, final boolean z) {
        AppMethodBeat.i(222484);
        if (!isPublishingInCloud(tRTCCloudImpl, i2)) {
            AppMethodBeat.o(222484);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass149 */

            public void run() {
                AppMethodBeat.i(182408);
                if (i2 == 2) {
                    TRTCCloudImpl.this.mCaptureAndEnc.g(z);
                }
                AppMethodBeat.o(182408);
            }
        });
        AppMethodBeat.o(222484);
    }

    private void onRecvFirstAudio(long j2) {
        AppMethodBeat.i(15940);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass150 */

            public void run() {
                AppMethodBeat.i(182415);
                AppMethodBeat.o(182415);
            }
        });
        AppMethodBeat.o(15940);
    }

    private void onRecvFirstVideo(final long j2, int i2) {
        AppMethodBeat.i(15941);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass151 */

            public void run() {
                AppMethodBeat.i(182399);
                int recvFirstIFrame = TRTCCloudImpl.this.mRoomInfo.recvFirstIFrame(j2);
                TRTCRoomInfo.UserInfo userInfo = null;
                try {
                    String userIdByTinyId = TRTCCloudImpl.this.mRoomInfo.getUserIdByTinyId(j2);
                    if (userIdByTinyId != null) {
                        userInfo = TRTCCloudImpl.this.mRoomInfo.getUser(userIdByTinyId);
                    }
                } catch (Exception e2) {
                    TXCLog.e(TRTCCloudImpl.TAG, "get user info failed.", e2);
                }
                TRTCCloudImpl.this.apiLog("onRecvFirstVideo " + j2 + ", " + recvFirstIFrame);
                if (userInfo == null || recvFirstIFrame > 1) {
                    AppMethodBeat.o(182399);
                    return;
                }
                final String str = userInfo.userID;
                if ((TRTCRoomInfo.hasMainVideo(userInfo.streamState) || TRTCRoomInfo.hasSmallVideo(userInfo.streamState)) && !TRTCRoomInfo.isMuteMainVideo(userInfo.streamState)) {
                    TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                        /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass151.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(222410);
                            TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                            TXCLog.i(TRTCCloudImpl.TAG, "notify onUserVideoAvailable:" + j2 + " [true] by IDR. self:" + TRTCCloudImpl.this.hashCode());
                            if (tRTCCloudListener != null) {
                                tRTCCloudListener.onUserVideoAvailable(str, true);
                                TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", str, Boolean.TRUE));
                            }
                            AppMethodBeat.o(222410);
                        }
                    });
                }
                AppMethodBeat.o(182399);
            }
        });
        AppMethodBeat.o(15941);
    }

    private void onStartPublishing(final int i2, final String str) {
        AppMethodBeat.i(182323);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass152 */

            public void run() {
                AppMethodBeat.i(182291);
                TRTCCloudImpl.this.apiLog("onStartPublishing " + i2 + ", " + str);
                Monitor.a(1, String.format("onStartPublishing err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStartPublishing(i2, str);
                }
                AppMethodBeat.o(182291);
            }
        });
        AppMethodBeat.o(182323);
    }

    private void onStopPublishing(final int i2, final String str) {
        AppMethodBeat.i(182324);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass153 */

            public void run() {
                AppMethodBeat.i(182390);
                TRTCCloudImpl.this.apiLog("onStopPublishing " + i2 + ", " + str);
                Monitor.a(1, String.format("onStopPublishing err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStopPublishing(i2, str);
                }
                AppMethodBeat.o(182390);
            }
        });
        AppMethodBeat.o(182324);
    }

    private void onStreamPublished(final int i2, final String str) {
        AppMethodBeat.i(15942);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass154 */

            public void run() {
                AppMethodBeat.i(222400);
                TRTCCloudImpl.this.apiLog("onStreamPublished " + i2 + ", " + str);
                Monitor.a(1, String.format("onStreamPublished err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStartPublishCDNStream(i2, str);
                }
                AppMethodBeat.o(222400);
            }
        });
        AppMethodBeat.o(15942);
    }

    private void onStreamUnpublished(final int i2, final String str) {
        AppMethodBeat.i(15943);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass155 */

            public void run() {
                AppMethodBeat.i(222570);
                TRTCCloudImpl.this.apiLog("onStreamUnpublished " + i2 + ", " + str);
                Monitor.a(1, String.format("onStreamUnpublished err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStopPublishCDNStream(i2, str);
                }
                AppMethodBeat.o(222570);
            }
        });
        AppMethodBeat.o(15943);
    }

    private void onTranscodingUpdated(final int i2, final String str) {
        AppMethodBeat.i(15944);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass156 */

            public void run() {
                AppMethodBeat.i(182407);
                TRTCCloudImpl.this.apiLog("onTranscodingUpdated " + i2 + ", " + str);
                Monitor.a(1, String.format("onTranscodingUpdated err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSetMixTranscodingConfig(i2, str);
                }
                AppMethodBeat.o(182407);
            }
        });
        AppMethodBeat.o(15944);
    }

    /* access modifiers changed from: protected */
    public void onCancelTranscoding(final int i2, final String str) {
        AppMethodBeat.i(15945);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass157 */

            public void run() {
                AppMethodBeat.i(182404);
                Monitor.a(1, String.format("onCancelTranscoding err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSetMixTranscodingConfig(i2, str);
                }
                AppMethodBeat.o(182404);
            }
        });
        AppMethodBeat.o(15945);
    }

    private void onChangeRole(final int i2, final String str) {
        AppMethodBeat.i(15946);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass158 */

            public void run() {
                AppMethodBeat.i(222439);
                if (i2 == 0) {
                    TRTCCloudImpl.this.mCurrentRole = TRTCCloudImpl.this.mTargetRole;
                } else {
                    TRTCCloudImpl.this.mCurrentRole = 21;
                    TRTCCloudImpl.this.mTargetRole = 21;
                }
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSwitchRole(i2, str);
                }
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass158.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222392);
                        if (userInfo.mainRender.render != null) {
                            TRTCCloudImpl.access$8300(TRTCCloudImpl.this, userInfo.mainRender.render, userInfo.mainRender.render.getConfig());
                        }
                        AppMethodBeat.o(222392);
                    }
                });
                TRTCCloudImpl.access$7600(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onChangeRole:" + i2);
                Monitor.a(1, String.format("onChangeRole err:%d, msg:%s", Integer.valueOf(i2), str) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                AppMethodBeat.o(222439);
            }
        });
        AppMethodBeat.o(15946);
    }

    /* access modifiers changed from: protected */
    public void onSendFirstLocalVideoFrame(final int i2) {
        AppMethodBeat.i(15947);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass159 */

            public void run() {
                AppMethodBeat.i(222448);
                TRTCCloudImpl.this.apiLog("onSendFirstLocalVideoFrame " + i2);
                int access$8400 = TRTCCloudImpl.access$8400(TRTCCloudImpl.this, i2);
                TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalVideoFrame:".concat(String.valueOf(access$8400)));
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSendFirstLocalVideoFrame(access$8400);
                }
                AppMethodBeat.o(222448);
            }
        });
        AppMethodBeat.o(15947);
    }

    /* access modifiers changed from: protected */
    public void onSendFirstLocalAudioFrame() {
        AppMethodBeat.i(15948);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass160 */

            public void run() {
                AppMethodBeat.i(222407);
                TRTCCloudImpl.this.apiLog("onSendFirstLocalAudioFrame");
                TRTCCloudImpl.access$8000(TRTCCloudImpl.this, TRTCCloudImpl.this.mRoomInfo.getUserId(), 0, "onSendFirstLocalAudioFrame");
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onSendFirstLocalAudioFrame();
                }
                AppMethodBeat.o(222407);
            }
        });
        AppMethodBeat.o(15948);
    }

    private static TRTCVideoServerConfig createVideoServerConfigFromNative() {
        AppMethodBeat.i(222485);
        TRTCVideoServerConfig tRTCVideoServerConfig = new TRTCVideoServerConfig();
        AppMethodBeat.o(222485);
        return tRTCVideoServerConfig;
    }

    private void onRecvVideoServerConfig(final TRTCVideoServerConfig tRTCVideoServerConfig) {
        AppMethodBeat.i(222486);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass161 */

            public void run() {
                AppMethodBeat.i(222403);
                TRTCCloudImpl.this.apiLog("onRecvVideoServerConfig " + tRTCVideoServerConfig);
                TRTCCloudImpl.this.mVideoServerConfig = tRTCVideoServerConfig;
                TRTCVideoServerConfig.saveToSharedPreferences(TRTCCloudImpl.this.mContext, tRTCVideoServerConfig);
                TRTCCloudImpl.this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass161.AnonymousClass1 */

                    @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
                    public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                        AppMethodBeat.i(222584);
                        TXCRenderAndDec tXCRenderAndDec = userInfo.mainRender.render;
                        if (tXCRenderAndDec != null) {
                            tXCRenderAndDec.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
                        }
                        TXCRenderAndDec tXCRenderAndDec2 = userInfo.subRender.render;
                        if (tXCRenderAndDec2 != null) {
                            tXCRenderAndDec2.enableLimitDecCache(TRTCCloudImpl.this.mVideoServerConfig.enableHWVUI);
                        }
                        AppMethodBeat.o(222584);
                    }
                });
                AppMethodBeat.o(222403);
            }
        });
        AppMethodBeat.o(222486);
    }

    private static TRTCAudioServerConfig createAudioServerConfigFromNative() {
        AppMethodBeat.i(222487);
        TRTCAudioServerConfig tRTCAudioServerConfig = new TRTCAudioServerConfig();
        AppMethodBeat.o(222487);
        return tRTCAudioServerConfig;
    }

    private void onRecvAudioServerConfig(TRTCAudioServerConfig tRTCAudioServerConfig) {
        AppMethodBeat.i(222488);
        TXCLog.i(TAG, "on receive audio config: [%s]", tRTCAudioServerConfig);
        TRTCAudioServerConfig.saveToSharedPreferences(this.mContext, tRTCAudioServerConfig);
        TXCAudioEngine.getInstance().enableAutoRestartDevice(tRTCAudioServerConfig.enableAutoRestartDevice);
        TXCAudioEngine.getInstance().setMaxSelectedPlayStreams(tRTCAudioServerConfig.maxSelectedPlayStreams);
        AppMethodBeat.o(222488);
    }

    private void onRecvEnterRoomVideoConfig(final boolean z) {
        AppMethodBeat.i(259888);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass162 */

            public void run() {
                AppMethodBeat.i(222418);
                TRTCCloudImpl.this.mEnableHighQualityEncodeFromServer = z;
                if (TRTCCloudImpl.this.mCaptureAndEnc != null) {
                    TXCLog.i(TRTCCloudImpl.TAG, "codecability onRecvEnterRoomVideoConfig: " + z + " mEnableHighQualityEncode= " + TRTCCloudImpl.this.mEnableHighQualityEncode + " TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode()=" + TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode());
                    TRTCCloudImpl.this.mCaptureAndEnc.j(TRTCCloudImpl.this.mEnableHighQualityEncodeFromServer && TRTCCloudImpl.this.mEnableHighQualityEncode && TRTCCloudHevcUtil.isLifeCycleEnableHevcEncode());
                }
                AppMethodBeat.o(222418);
            }
        });
        AppMethodBeat.o(259888);
    }

    private void setQoSParams() {
        AppMethodBeat.i(222489);
        TXCAudioEncoderConfig audioEncoderConfig = TXCAudioEngine.getInstance().getAudioEncoderConfig();
        TXCLog.i("", "setQoSParams:" + audioEncoderConfig.sampleRate + " " + audioEncoderConfig.channels + " " + audioEncoderConfig.minBitrate + " " + audioEncoderConfig.maxBitrate);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(1);
        if (tRTCCloudImpl != null) {
            nativeSetAudioEncodeConfiguration(tRTCCloudImpl.getNetworkContext(), audioEncoderConfig.minBitrate, audioEncoderConfig.maxBitrate, audioEncoderConfig.sampleRate, audioEncoderConfig.channels);
        }
        AppMethodBeat.o(222489);
    }

    /* access modifiers changed from: protected */
    public void runOnMainThread(Runnable runnable) {
        AppMethodBeat.i(15949);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mMainHandler.post(runnable);
            AppMethodBeat.o(15949);
            return;
        }
        runnable.run();
        AppMethodBeat.o(15949);
    }

    private void runOnMainThreadAndWaitDone(Runnable runnable) {
        AppMethodBeat.i(222490);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mMainHandler.a(runnable);
            AppMethodBeat.o(222490);
            return;
        }
        runnable.run();
        AppMethodBeat.o(222490);
    }

    public void runOnListenerThread(Runnable runnable) {
        AppMethodBeat.i(15950);
        Handler handler = this.mListenerHandler;
        if (handler == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.mMainHandler.post(runnable);
                AppMethodBeat.o(15950);
                return;
            }
            runnable.run();
            AppMethodBeat.o(15950);
        } else if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
            AppMethodBeat.o(15950);
        } else {
            runnable.run();
            AppMethodBeat.o(15950);
        }
    }

    private void runOnListenerThread(Runnable runnable, int i2) {
        AppMethodBeat.i(15951);
        Handler handler = this.mListenerHandler;
        if (handler == null) {
            this.mMainHandler.postDelayed(runnable, (long) i2);
            AppMethodBeat.o(15951);
            return;
        }
        handler.postDelayed(runnable, (long) i2);
        AppMethodBeat.o(15951);
    }

    private void runOnSDKThread(Runnable runnable, int i2) {
        AppMethodBeat.i(15952);
        if (this.mSDKHandler != null) {
            this.mSDKHandler.postDelayed(runnable, (long) i2);
        }
        AppMethodBeat.o(15952);
    }

    public void runOnSDKThread(Runnable runnable) {
        AppMethodBeat.i(15953);
        if (this.mSDKHandler == null || !this.mIsSDKThreadAlive.get()) {
            TXCLog.e(TAG, "(" + hashCode() + ")trtc_api sdk thread is dead, ignore task.");
            AppMethodBeat.o(15953);
        } else if (Looper.myLooper() != this.mSDKHandler.getLooper()) {
            try {
                this.mSDKHandler.post(runnable);
                AppMethodBeat.o(15953);
            } catch (Exception e2) {
                TXCLog.e(TAG, "(" + hashCode() + ")trtc_api run on sdk fail. alive:" + this.mIsSDKThreadAlive.get(), e2);
                AppMethodBeat.o(15953);
            }
        } else {
            runnable.run();
            AppMethodBeat.o(15953);
        }
    }

    public void updateAppScene(int i2) {
        AppMethodBeat.i(15954);
        this.mAppScene = i2;
        if (!(this.mAppScene == 0 || this.mAppScene == 1)) {
            this.mAppScene = 0;
        }
        if (this.mConfig.f777a * this.mConfig.f778b >= 518400) {
            this.mAppScene = 1;
        }
        updateEncType();
        apiLog(String.format("update appScene[%d] for video enc[%d] source scene[%d]", Integer.valueOf(this.mAppScene), Integer.valueOf(this.mConfig.f786j), Integer.valueOf(i2)));
        AppMethodBeat.o(15954);
    }

    private void updateEncType() {
        if (this.mCodecType == 0 || this.mCodecType == 1) {
            this.mConfig.f786j = this.mCodecType;
        } else if (this.mAppScene == 1) {
            this.mConfig.f786j = 1;
        }
    }

    private void setVideoEncConfig(int i2, int i3, int i4, int i5, int i6, boolean z, int i7) {
        AppMethodBeat.i(222491);
        if (this.mRoomState == 0) {
            apiLog("setVideoEncConfig ignore when no in room");
            AppMethodBeat.o(222491);
        } else if (this.mCodecType != 2) {
            setVideoEncoderConfiguration(i2, i3, i4, i5, i6, 1, z, i7);
            AppMethodBeat.o(222491);
        } else {
            setVideoEncoderConfiguration(i2, i3, i4, i5, i6, this.mAppScene, z, i7);
            AppMethodBeat.o(222491);
        }
    }

    /* access modifiers changed from: protected */
    public void setRenderView(final String str, final TRTCRoomInfo.RenderInfo renderInfo, final TXCloudVideoView tXCloudVideoView, final TRTCCloud.TRTCViewMargin tRTCViewMargin) {
        AppMethodBeat.i(15956);
        if (renderInfo == null || renderInfo.render == null || renderInfo.render.getVideoRender() == null) {
            AppMethodBeat.o(15956);
            return;
        }
        final com.tencent.liteav.renderer.e videoRender = renderInfo.render.getVideoRender();
        if (tXCloudVideoView == null) {
            videoRender.c((Object) null);
            AppMethodBeat.o(15956);
            return;
        }
        runOnMainThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass163 */

            public void run() {
                AppMethodBeat.i(222427);
                SurfaceView surfaceView = tXCloudVideoView.getSurfaceView();
                if (surfaceView != null) {
                    surfaceView.setVisibility(0);
                    SurfaceHolder holder = surfaceView.getHolder();
                    holder.removeCallback(renderInfo);
                    holder.addCallback(renderInfo);
                    if (holder.getSurface().isValid()) {
                        TRTCCloudImpl.this.apiLog(String.format(Locale.ENGLISH, "startRemoteView with valid surface %s, width: %d, height: %d", holder.getSurface(), Integer.valueOf(surfaceView.getWidth()), Integer.valueOf(surfaceView.getHeight())));
                        videoRender.a(holder.getSurface());
                        videoRender.c(surfaceView.getWidth(), surfaceView.getHeight());
                        AppMethodBeat.o(222427);
                        return;
                    }
                    TRTCCloudImpl.this.apiLog("startRemoteView with surfaceView add callback " + renderInfo);
                    AppMethodBeat.o(222427);
                    return;
                }
                TextureView textureView = new TextureView(tXCloudVideoView.getContext());
                tXCloudVideoView.addVideoView(textureView);
                tXCloudVideoView.setVisibility(0);
                tXCloudVideoView.setUserId(str);
                tXCloudVideoView.showVideoDebugLog(TRTCCloudImpl.this.mDebugType);
                if (tRTCViewMargin != null) {
                    tXCloudVideoView.setLogMarginRatio(tRTCViewMargin.leftMargin, tRTCViewMargin.rightMargin, tRTCViewMargin.topMargin, tRTCViewMargin.bottomMargin);
                }
                videoRender.a(textureView);
                AppMethodBeat.o(222427);
            }
        });
        AppMethodBeat.o(15956);
    }

    private void startRemoteRender(TXCRenderAndDec tXCRenderAndDec, int i2) {
        AppMethodBeat.i(15957);
        tXCRenderAndDec.stopVideo();
        tXCRenderAndDec.setStreamType(i2);
        tXCRenderAndDec.startVideo();
        AppMethodBeat.o(15957);
    }

    private void stopRemoteSubRender(TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(15958);
        if (userInfo == null) {
            AppMethodBeat.o(15958);
            return;
        }
        apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", userInfo.userID, Long.valueOf(userInfo.tinyID), 7));
        nativeCancelDownStream(this.mNativeRtcContext, userInfo.tinyID, 7, false);
        if (userInfo.subRender.render != null) {
            userInfo.subRender.render.stopVideo();
        }
        AppMethodBeat.o(15958);
    }

    private void stopRemoteMainRender(TRTCRoomInfo.UserInfo userInfo, Boolean bool) {
        AppMethodBeat.i(15959);
        if (userInfo == null) {
            AppMethodBeat.o(15959);
            return;
        }
        apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", userInfo.userID, Long.valueOf(userInfo.tinyID), Integer.valueOf(userInfo.streamType)));
        nativeCancelDownStream(this.mNativeRtcContext, userInfo.tinyID, 2, bool.booleanValue());
        nativeCancelDownStream(this.mNativeRtcContext, userInfo.tinyID, 3, bool.booleanValue());
        if (userInfo.mainRender.render != null) {
            userInfo.mainRender.render.stopVideo();
        }
        AppMethodBeat.o(15959);
    }

    public void stopRemoteRender(TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(15960);
        if (userInfo == null) {
            AppMethodBeat.o(15960);
            return;
        }
        apiLog(String.format("stopRemoteRender userID:%s tinyID:%d streamType:%d", userInfo.userID, Long.valueOf(userInfo.tinyID), Integer.valueOf(userInfo.streamType)));
        TXCAudioEngine.getInstance().stopRemoteAudio(String.valueOf(userInfo.tinyID));
        final TXCloudVideoView tXCloudVideoView = userInfo.mainRender.view;
        final TXCloudVideoView tXCloudVideoView2 = userInfo.subRender.view;
        if (userInfo.mainRender.render != null) {
            userInfo.mainRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.UNKNOWN);
            userInfo.mainRender.render.stop();
            if (tXCloudVideoView == null && userInfo.mainRender.render.getVideoRender() != null) {
                userInfo.mainRender.render.getVideoRender().e();
            }
        }
        if (userInfo.subRender.render != null) {
            userInfo.subRender.render.setVideoFrameListener(null, com.tencent.liteav.basic.a.b.UNKNOWN);
            userInfo.subRender.render.stop();
            if (tXCloudVideoView2 == null && userInfo.subRender.render.getVideoRender() != null) {
                userInfo.subRender.render.getVideoRender().e();
            }
        }
        userInfo.mainRender.stop();
        userInfo.subRender.stop();
        runOnMainThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass164 */

            public void run() {
                AppMethodBeat.i(259883);
                if (tXCloudVideoView != null) {
                    tXCloudVideoView.removeVideoView();
                }
                if (tXCloudVideoView2 != null) {
                    tXCloudVideoView2.removeVideoView();
                }
                AppMethodBeat.o(259883);
            }
        });
        AppMethodBeat.o(15960);
    }

    /* access modifiers changed from: protected */
    public void enableVideoStream(boolean z) {
        AppMethodBeat.i(15961);
        if (!z) {
            if (!this.mCaptureAndEnc.i()) {
                removeUpStreamType(2);
            }
            removeUpStreamType(3);
        } else if (!this.mRoomInfo.muteLocalVideo) {
            addUpStreamType(2);
            if (this.mEnableSmallStream) {
                addUpStreamType(3);
                AppMethodBeat.o(15961);
                return;
            }
        }
        AppMethodBeat.o(15961);
    }

    /* access modifiers changed from: protected */
    public void enableAudioStream(boolean z) {
        AppMethodBeat.i(15962);
        if (z) {
            addUpStreamType(1);
            AppMethodBeat.o(15962);
            return;
        }
        removeUpStreamType(1);
        AppMethodBeat.o(15962);
    }

    private void applyRenderConfig(TXCRenderAndDec tXCRenderAndDec) {
        AppMethodBeat.i(15963);
        h hVar = new h();
        hVar.f797h = false;
        if (this.mAppScene == 1) {
            hVar.f797h = true;
        }
        int c2 = TXCStatus.c("18446744073709551615", 17020);
        if (c2 == 0) {
            c2 = 600;
        }
        hVar.f793d = c2;
        hVar.r = this.mRoomInfo.decProperties;
        applyRenderPlayStrategy(tXCRenderAndDec, hVar);
        AppMethodBeat.o(15963);
    }

    private void applyRenderPlayStrategy(TXCRenderAndDec tXCRenderAndDec, h hVar) {
        AppMethodBeat.i(222492);
        hVar.f796g = true;
        if (this.mCurrentRole == 20) {
            hVar.f790a = com.tencent.liteav.basic.a.a.f198a;
            hVar.f792c = com.tencent.liteav.basic.a.a.f199b;
            hVar.f791b = com.tencent.liteav.basic.a.a.f200c;
        } else if (this.mCurrentRole == 21) {
            hVar.f790a = com.tencent.liteav.basic.a.a.f201d;
            hVar.f792c = com.tencent.liteav.basic.a.a.f202e;
            hVar.f791b = com.tencent.liteav.basic.a.a.f203f;
        }
        tXCRenderAndDec.setConfig(hVar);
        AppMethodBeat.o(222492);
    }

    private void notifyLogByUserId(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(15965);
        if (str == null || str2 == null) {
            AppMethodBeat.o(15965);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_ID", (long) i3);
        bundle.putLong("EVT_TIME", System.currentTimeMillis());
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str2);
        bundle.putInt("EVT_STREAM_TYPE", i2);
        notifyEventByUserId(str, i3, bundle);
        AppMethodBeat.o(15965);
    }

    private void notifyEventByUserId(final String str, final int i2, final Bundle bundle) {
        AppMethodBeat.i(15966);
        if (str == null || bundle == null) {
            AppMethodBeat.o(15966);
            return;
        }
        this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass165 */

            @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
            public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                AppMethodBeat.i(259879);
                if (str.equalsIgnoreCase(String.valueOf(userInfo.tinyID))) {
                    TRTCCloudImpl.this.notifyEvent(userInfo.userID, i2, bundle);
                }
                AppMethodBeat.o(259879);
            }
        });
        AppMethodBeat.o(15966);
    }

    private void appendDashboardLog(String str, int i2, String str2) {
        AppMethodBeat.i(15967);
        appendDashboardLog(str, i2, str2, "");
        AppMethodBeat.o(15967);
    }

    private void appendDashboardLog(String str, int i2, final String str2, String str3) {
        AppMethodBeat.i(15968);
        apiLog(str3 + str2);
        final TXCloudVideoView tXCloudVideoView = null;
        if (TextUtils.isEmpty(str) || (this.mRoomInfo.userId != null && str.equalsIgnoreCase(this.mRoomInfo.userId))) {
            tXCloudVideoView = this.mRoomInfo.localView;
        } else {
            TRTCRoomInfo.UserInfo user = this.mRoomInfo.getUser(str);
            if (user != null) {
                if (i2 == 7) {
                    tXCloudVideoView = user.subRender.view;
                } else {
                    tXCloudVideoView = user.mainRender.view;
                }
            }
        }
        runOnMainThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass166 */

            public void run() {
                AppMethodBeat.i(222428);
                if (tXCloudVideoView != null) {
                    tXCloudVideoView.appendEventInfo(str2);
                }
                AppMethodBeat.o(222428);
            }
        });
        AppMethodBeat.o(15968);
    }

    private Pair<Integer, String> getEncoderTypeAndMsg(Bundle bundle) {
        AppMethodBeat.i(259889);
        String str = "";
        int i2 = bundle.getInt("EVT_PARAM1", 0);
        if (i2 == b.a.HW_ENCODER_264.a() || i2 == b.a.SOFT_ENCODER_264.a()) {
            str = String.format(Locale.getDefault(), "Current encode type is %s encoder", "H264");
            i2 = 0;
        } else if (i2 == b.a.HW_ENCODER_HEVC.a() || i2 == b.a.SOFT_ENCODER_HEVC.a()) {
            str = String.format(Locale.getDefault(), "Current encode type is %s encoder", "H265");
            i2 = 1;
        }
        Pair<Integer, String> pair = new Pair<>(Integer.valueOf(i2), str);
        AppMethodBeat.o(259889);
        return pair;
    }

    /* access modifiers changed from: protected */
    public void notifyEvent(final String str, final int i2, final Bundle bundle) {
        AppMethodBeat.i(15969);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass167 */

            public void run() {
                AppMethodBeat.i(222398);
                TRTCCloudImpl.access$8600(TRTCCloudImpl.this, str, bundle.getInt("EVT_STREAM_TYPE", 2), bundle.getString(TXLiveConstants.EVT_DESCRIPTION, ""), String.format("event %d, ", Integer.valueOf(i2)));
                if (i2 == 2029) {
                    TRTCCloudImpl.this.apiLog("release mic~");
                    if (TRTCCloudImpl.this.mRoomInfo.isRoomExit()) {
                        TRTCCloudImpl.this.apiLog("onExitRoom when mic release.");
                        final int roomExitCode = TRTCCloudImpl.this.mRoomInfo.getRoomExitCode();
                        TRTCCloudImpl.this.mRoomInfo.setRoomExit(false, 0);
                        TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass167.AnonymousClass1 */

                            public void run() {
                                AppMethodBeat.i(259881);
                                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                                if (tRTCCloudListener != null) {
                                    tRTCCloudListener.onExitRoom(roomExitCode);
                                }
                                AppMethodBeat.o(259881);
                            }
                        });
                    } else {
                        TRTCCloudImpl.this.mRoomInfo.micStart(false);
                    }
                } else if (i2 == 2027) {
                    TRTCCloudImpl.this.apiLog(String.format("onMicDidReady~", new Object[0]));
                    TRTCCloudImpl.this.mRoomInfo.micStart(true);
                } else if (i2 == -2304) {
                    TXCLog.i(TRTCCloudImpl.TAG, "codecability eventCode = ERR_HEVC_DECODE_FAIL");
                    TRTCCloudImpl.this.mEnableHighQualityEncode = false;
                    if (!com.tencent.liteav.basic.a.a()) {
                        TRTCCloudHevcUtil.setLifeCycleEnableHevcDecode(false);
                    }
                    TRTCCloudImpl.this.mCaptureAndEnc.j(false);
                    TRTCCloudImpl.this.nativeFlushC2SVideoCodecConfig(TRTCCloudImpl.this.mNativeRtcContext, 3);
                    AppMethodBeat.o(222398);
                    return;
                } else if (i2 == -2310 || i2 == -2311) {
                    TXCLog.i(TRTCCloudImpl.TAG, "codecability eventCode: " + i2);
                    TRTCCloudImpl.this.mEnableHighQualityEncode = false;
                    TRTCCloudHevcUtil.setLifeCycleEnableHevcEncode(false);
                    TRTCCloudImpl.this.nativeFlushC2SVideoCodecConfig(TRTCCloudImpl.this.mNativeRtcContext, TRTCCloudHevcUtil.getHevcDecoderValue() | 3);
                    AppMethodBeat.o(222398);
                    return;
                } else if (i2 == 1008) {
                    Pair access$8700 = TRTCCloudImpl.access$8700(TRTCCloudImpl.this, bundle);
                    TXCEventRecorderProxy.a("18446744073709551615", 4016, (long) ((Integer) access$8700.first).intValue(), -1, (String) access$8700.second, bundle.getInt("EVT_STREAM_TYPE", 0));
                }
                final int access$8400 = TRTCCloudImpl.access$8400(TRTCCloudImpl.this, bundle.getInt("EVT_STREAM_TYPE", 2));
                TRTCCloudImpl.this.runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass167.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(259884);
                        TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                        if (tRTCCloudListener == null) {
                            AppMethodBeat.o(259884);
                        } else if (i2 == 2003) {
                            if (str == null || !str.equals(TRTCCloudImpl.this.mRoomInfo.getUserId())) {
                                TRTCCloudImpl.this.apiLog("onFirstVideoFrame " + str);
                                tRTCCloudListener.onFirstVideoFrame(str, access$8400, bundle.getInt("EVT_PARAM1"), bundle.getInt("EVT_PARAM2"));
                                AppMethodBeat.o(259884);
                                return;
                            }
                            TRTCCloudImpl.this.apiLog("onFirstVideoFrame local.");
                            tRTCCloudListener.onFirstVideoFrame(null, access$8400, bundle.getInt("EVT_PARAM1"), bundle.getInt("EVT_PARAM2"));
                            AppMethodBeat.o(259884);
                        } else if (i2 == 2026) {
                            TRTCCloudImpl.this.apiLog("onFirstAudioFrame " + str);
                            tRTCCloudListener.onFirstAudioFrame(str);
                            AppMethodBeat.o(259884);
                        } else if (i2 == 1003) {
                            tRTCCloudListener.onCameraDidReady();
                            Monitor.a(1, "onCameraDidReady self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                            AppMethodBeat.o(259884);
                        } else if (i2 == 2027) {
                            tRTCCloudListener.onMicDidReady();
                            Monitor.a(1, "onMicDidReady self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                            AppMethodBeat.o(259884);
                        } else if (i2 == 1008) {
                            Bundle bundle = new Bundle();
                            Pair access$8700 = TRTCCloudImpl.access$8700(TRTCCloudImpl.this, bundle);
                            bundle.putInt("type", ((Integer) access$8700.first).intValue());
                            tRTCCloudListener.onWarning(1104, (String) access$8700.second, bundle);
                            AppMethodBeat.o(259884);
                        } else {
                            if (i2 < 0) {
                                tRTCCloudListener.onError(i2, bundle.getString(TXLiveConstants.EVT_DESCRIPTION, ""), bundle);
                                Monitor.a(3, String.format("onError event:%d, msg:%s", Integer.valueOf(i2), bundle) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                            } else {
                                if ((i2 > 1100 && i2 < 1110) || ((i2 > 1200 && i2 < 1206) || ((i2 > 2100 && i2 < 2110) || ((i2 > 3001 && i2 < 3011) || (i2 > 5100 && i2 < 5104))))) {
                                    tRTCCloudListener.onWarning(i2, bundle.getString(TXLiveConstants.EVT_DESCRIPTION, ""), bundle);
                                    if (i2 != 2105) {
                                        Monitor.a(1, String.format("onWarning event:%d, msg:%s", Integer.valueOf(i2), bundle) + " self:" + TRTCCloudImpl.this.hashCode(), "", 0);
                                    }
                                    switch (i2) {
                                        case 1103:
                                        case 1109:
                                        case 2101:
                                        case 2102:
                                        case 2106:
                                        case TXLiteAVCode.WARNING_SW_DECODER_START_FAIL:
                                            break;
                                    }
                                }
                                AppMethodBeat.o(259884);
                            }
                            TXCKeyPointReportProxy.b(i2);
                            AppMethodBeat.o(259884);
                        }
                    }
                });
                AppMethodBeat.o(222398);
            }
        });
        AppMethodBeat.o(15969);
    }

    private void notifyEvent(String str, int i2, String str2) {
        AppMethodBeat.i(15970);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_ID", (long) i2);
        bundle.putLong("EVT_TIME", System.currentTimeMillis());
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str2);
        notifyEvent(str, i2, bundle);
        AppMethodBeat.o(15970);
    }

    public void apiLog(String str) {
        AppMethodBeat.i(15971);
        TXCLog.i(TAG, "(" + hashCode() + ")trtc_api " + str);
        AppMethodBeat.o(15971);
    }

    private TRTCRoomInfo.UserInfo createUserInfo(String str) {
        AppMethodBeat.i(15972);
        TRTCRoomInfo.UserInfo userInfo = new TRTCRoomInfo.UserInfo(0, str, 0, 0);
        userInfo.mainRender.muteVideo = this.mRoomInfo.muteRemoteVideo;
        userInfo.mainRender.muteAudio = this.mRoomInfo.muteRemoteAudio;
        AppMethodBeat.o(15972);
        return userInfo;
    }

    private g.a getSizeByResolution(int i2, int i3) {
        int i4 = 640;
        int i5 = 368;
        AppMethodBeat.i(222493);
        switch (i2) {
            case 1:
                i5 = 128;
                i4 = 128;
                break;
            case 3:
                i5 = 160;
                i4 = 160;
                break;
            case 5:
                i5 = 272;
                i4 = 272;
                break;
            case 7:
                i5 = 480;
                i4 = 480;
                break;
            case 50:
                i5 = 128;
                i4 = 176;
                break;
            case 52:
                i5 = 192;
                i4 = 256;
                break;
            case 54:
                i5 = TbsListener.ErrorCode.EXCEED_INCR_UPDATE;
                i4 = 288;
                break;
            case 56:
                i5 = 240;
                i4 = 320;
                break;
            case 58:
                i5 = 304;
                i4 = 400;
                break;
            case 60:
                i4 = 480;
                break;
            case 62:
                i5 = 480;
                break;
            case 64:
                i5 = TAVExporter.VIDEO_EXPORT_WIDTH;
                i4 = 960;
                break;
            case 100:
                i5 = 96;
                i4 = 176;
                break;
            case 102:
                i5 = 144;
                i4 = 256;
                break;
            case 104:
                i5 = 192;
                i4 = 336;
                break;
            case 106:
                i5 = 272;
                i4 = 480;
                break;
            case 110:
                i5 = 544;
                i4 = 960;
                break;
            case 112:
                i5 = TAVExporter.VIDEO_EXPORT_WIDTH;
                i4 = 1280;
                break;
            case 114:
                i5 = 1088;
                i4 = 1920;
                break;
        }
        g.a aVar = new g.a();
        if (i3 == 1) {
            aVar.f788a = i5;
            aVar.f789b = i4;
        } else {
            aVar.f788a = i4;
            aVar.f789b = i5;
        }
        AppMethodBeat.o(222493);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void checkUserState(final String str, long j2, int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(15974);
        final TRTCCloudListener tRTCCloudListener = this.mTRTCListener;
        if (tRTCCloudListener != null && !TextUtils.isEmpty(str)) {
            final boolean z6 = TRTCRoomInfo.hasAudio(i2) && !TRTCRoomInfo.isMuteAudio(i2);
            if (!TRTCRoomInfo.hasAudio(i3) || TRTCRoomInfo.isMuteAudio(i3)) {
                z = false;
            } else {
                z = true;
            }
            if (z != z6) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass168 */

                    public void run() {
                        AppMethodBeat.i(222414);
                        tRTCCloudListener.onUserAudioAvailable(str, z6);
                        AppMethodBeat.o(222414);
                    }
                });
                appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", str, Boolean.valueOf(z6)));
                Monitor.a(2, String.format("onUserAudioAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z6)) + " self:" + hashCode(), "", 0);
            }
            final boolean z7 = (TRTCRoomInfo.hasMainVideo(i2) || TRTCRoomInfo.hasSmallVideo(i2)) && !TRTCRoomInfo.isMuteMainVideo(i2);
            if ((TRTCRoomInfo.hasMainVideo(i3) || TRTCRoomInfo.hasSmallVideo(i3)) && !TRTCRoomInfo.isMuteMainVideo(i3)) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z8 = z3 != z7;
            if (this.mRecvMode == 3 || this.mRecvMode == 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z8 && (this.mRoomInfo.hasRecvFirstIFrame(j2) || z4)) {
                runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass169 */

                    public void run() {
                        AppMethodBeat.i(222412);
                        tRTCCloudListener.onUserVideoAvailable(str, z7);
                        AppMethodBeat.o(222412);
                    }
                });
                appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", str, Boolean.valueOf(z7)));
                Monitor.a(2, String.format("onUserVideoAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z7)) + " self:" + hashCode(), "", 0);
            }
            final boolean z9 = TRTCRoomInfo.hasSubVideo(i2) && !TRTCRoomInfo.isMuteSubVideo(i2);
            if (!TRTCRoomInfo.hasSubVideo(i3) || TRTCRoomInfo.isMuteSubVideo(i3)) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 != z9) {
                runOnListenerThread(new Runnable() {
                    /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass170 */

                    public void run() {
                        AppMethodBeat.i(222443);
                        tRTCCloudListener.onUserSubStreamAvailable(str, z9);
                        AppMethodBeat.o(222443);
                    }
                });
                appendDashboardLog(this.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", str, Boolean.valueOf(z9)));
                Monitor.a(2, String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", str, Boolean.valueOf(z9)) + " self:" + hashCode(), "", 0);
            }
        }
        AppMethodBeat.o(15974);
    }

    /* access modifiers changed from: package-private */
    public static class StatusTask implements Runnable {
        private WeakReference<TRTCCloudImpl> mTRTCEngine;

        StatusTask(TRTCCloudImpl tRTCCloudImpl) {
            AppMethodBeat.i(15727);
            this.mTRTCEngine = new WeakReference<>(tRTCCloudImpl);
            AppMethodBeat.o(15727);
        }

        public void run() {
            int i2;
            AppMethodBeat.i(15728);
            TRTCCloudImpl tRTCCloudImpl = this.mTRTCEngine.get();
            if (tRTCCloudImpl == null) {
                AppMethodBeat.o(15728);
                return;
            }
            int e2 = com.tencent.liteav.basic.util.f.e(tRTCCloudImpl.mContext);
            int[] a2 = com.tencent.liteav.basic.util.f.a();
            TXCStatus.a("18446744073709551615", 11006, Integer.valueOf(e2));
            TXCStatus.a("18446744073709551615", 11001, Integer.valueOf(a2[0] / 10));
            TXCStatus.a("18446744073709551615", (int) ErrorCode.ERROR_OUTOF_MEMORY, Integer.valueOf(a2[1] / 10));
            TXCStatus.a("18446744073709551615", 11003, Integer.valueOf(com.tencent.liteav.basic.util.f.b() * 1024));
            if (com.tencent.liteav.basic.util.f.a(tRTCCloudImpl.mContext)) {
                TXCStatus.a("18446744073709551615", 11004, (Object) 1);
                i2 = 1;
            } else {
                TXCStatus.a("18446744073709551615", 11004, (Object) 0);
                i2 = 0;
            }
            if (tRTCCloudImpl.mNetType != e2) {
                if (tRTCCloudImpl.mNetType >= 0 && e2 > 0) {
                    TRTCCloudImpl.access$8900(tRTCCloudImpl, tRTCCloudImpl.mNativeRtcContext, 100);
                }
                TXCEventRecorderProxy.a("18446744073709551615", 1003, e2 == 0 ? 0 : (long) e2, -1, "", 0);
                Monitor.a(2, String.format("network switch from:%d to %d", Integer.valueOf(tRTCCloudImpl.mNetType), Integer.valueOf(e2)) + " self:" + tRTCCloudImpl.hashCode(), "1:wifi/2:4G/3:3G/4:2G/5:Cable", 0);
                tRTCCloudImpl.mNetType = e2;
                TXCKeyPointReportProxy.a(40039, e2, 0);
            }
            if (tRTCCloudImpl.mBackground != i2) {
                TXCEventRecorderProxy.a("18446744073709551615", 2001, (long) i2, -1, "", 0);
                tRTCCloudImpl.mBackground = i2;
                if (i2 == 0) {
                    Monitor.a(1, "onAppDidBecomeActive self:" + tRTCCloudImpl.hashCode(), "", 0);
                } else {
                    Monitor.a(1, "onAppEnterBackground self:" + tRTCCloudImpl.hashCode(), "", 0);
                }
                TXCKeyPointReportProxy.c(XWalkCoreWrapper.INVOKE_NOTITY_FUNCTION_ID_IDKEY, i2);
            }
            TXCKeyPointReportProxy.a(a2[0] / 10, a2[1] / 10);
            TXCKeyPointReportProxy.a();
            TRTCCloudImpl.access$9100(tRTCCloudImpl);
            tRTCCloudImpl.checkDashBoard();
            TRTCCloudImpl.access$9200(tRTCCloudImpl);
            tRTCCloudImpl.startCollectStatus();
            if (tRTCCloudImpl.mSensorMode != 0) {
                tRTCCloudImpl.mOrientationEventListener.checkOrientation();
            }
            AppMethodBeat.o(15728);
        }
    }

    private void collectCustomCaptureFps() {
        AppMethodBeat.i(15975);
        if (this.mVideoSourceType == VideoSourceType.CUSTOM) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - this.mLastCaptureCalculateTS;
            if (j2 >= 1000) {
                double d2 = (((double) (this.mCaptureFrameCount - this.mLastCaptureFrameCount)) * 1000.0d) / ((double) j2);
                this.mLastCaptureFrameCount = this.mCaptureFrameCount;
                this.mLastCaptureCalculateTS = currentTimeMillis;
                TXCStatus.a("18446744073709551615", 1001, 2, Double.valueOf(d2));
            }
        }
        AppMethodBeat.o(15975);
    }

    public void checkRemoteDashBoard(final TXCloudVideoView tXCloudVideoView, TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(15976);
        if (!(tXCloudVideoView == null || tXCRenderAndDec == null || !tXCRenderAndDec.isRendering())) {
            final CharSequence downloadStreamInfo = getDownloadStreamInfo(tXCRenderAndDec, userInfo);
            TXCLog.i(TAG, "[STATUS]" + downloadStreamInfo.toString().replace("\n", "") + " self:" + hashCode());
            runOnMainThread(new Runnable() {
                /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass171 */

                public void run() {
                    AppMethodBeat.i(222401);
                    tXCloudVideoView.setDashBoardStatusInfo(downloadStreamInfo);
                    AppMethodBeat.o(222401);
                }
            });
        }
        AppMethodBeat.o(15976);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r8.mRoomInfo.localView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkDashBoard() {
        /*
            r8 = this;
            r7 = 15977(0x3e69, float:2.2389E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            int r0 = r8.mDebugType
            if (r0 == 0) goto L_0x004e
            com.tencent.liteav.trtc.impl.TRTCRoomInfo r0 = r8.mRoomInfo
            com.tencent.rtmp.ui.TXCloudVideoView r0 = r0.localView
            if (r0 == 0) goto L_0x004e
            java.lang.CharSequence r1 = r8.getUploadStreamInfo()
            java.lang.String r2 = "TRTCCloudImpl"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "[STATUS]"
            r3.<init>(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r5 = "\n"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.replace(r5, r6)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = " self:"
            java.lang.StringBuilder r3 = r3.append(r4)
            int r4 = r8.hashCode()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.tencent.liteav.basic.log.TXCLog.i(r2, r3)
            com.tencent.liteav.trtc.impl.TRTCCloudImpl$172 r2 = new com.tencent.liteav.trtc.impl.TRTCCloudImpl$172
            r2.<init>(r0, r1)
            r8.runOnMainThread(r2)
        L_0x004e:
            com.tencent.liteav.trtc.impl.TRTCRoomInfo r0 = r8.mRoomInfo
            com.tencent.liteav.trtc.impl.TRTCCloudImpl$173 r1 = new com.tencent.liteav.trtc.impl.TRTCCloudImpl$173
            r1.<init>()
            r0.forEachUser(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.impl.TRTCCloudImpl.checkDashBoard():void");
    }

    public int getNetworkQuality(int i2, int i3) {
        AppMethodBeat.i(15978);
        if (!com.tencent.liteav.basic.util.f.d(this.mContext)) {
            AppMethodBeat.o(15978);
            return 6;
        } else if (i3 > 50 || i2 > 500) {
            AppMethodBeat.o(15978);
            return 5;
        } else if (i3 > 30 || i2 > 350) {
            AppMethodBeat.o(15978);
            return 4;
        } else if (i3 > 20 || i2 > 200) {
            AppMethodBeat.o(15978);
            return 3;
        } else if (i3 > 10 || i2 > 100) {
            AppMethodBeat.o(15978);
            return 2;
        } else if (i3 >= 0 || i2 >= 0) {
            AppMethodBeat.o(15978);
            return 1;
        } else {
            AppMethodBeat.o(15978);
            return 0;
        }
    }

    private int translateStreamType(int i2) {
        switch (i2) {
            case 2:
            case 4:
            case 5:
            case 6:
            default:
                return 0;
            case 3:
                return 1;
            case 7:
                return 2;
        }
    }

    private com.tencent.liteav.basic.a.b getPixelFormat(int i2) {
        switch (i2) {
            case 1:
                return com.tencent.liteav.basic.a.b.I420;
            case 2:
                return com.tencent.liteav.basic.a.b.TEXTURE_2D;
            case 3:
                return com.tencent.liteav.basic.a.b.TEXTURE_EXTERNAL_OES;
            case 4:
                return com.tencent.liteav.basic.a.b.NV21;
            default:
                return com.tencent.liteav.basic.a.b.UNKNOWN;
        }
    }

    private TRTCStatistics.TRTCRemoteStatistics getRemoteStatistics(TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(15979);
        String valueOf = String.valueOf(userInfo.tinyID);
        int streamType = tXCRenderAndDec.getStreamType();
        int c2 = TXCStatus.c(valueOf, 5003, streamType);
        int c3 = TXCStatus.c(valueOf, 17011, streamType);
        int c4 = TXCStatus.c(valueOf, 18014);
        TRTCStatistics.TRTCRemoteStatistics tRTCRemoteStatistics = new TRTCStatistics.TRTCRemoteStatistics();
        tRTCRemoteStatistics.userId = userInfo.userID;
        if (c4 <= c3) {
            c4 = c3;
        }
        tRTCRemoteStatistics.finalLoss = c4;
        tRTCRemoteStatistics.width = c2 >> 16;
        tRTCRemoteStatistics.height = 65535 & c2;
        tRTCRemoteStatistics.frameRate = (int) (TXCStatus.d(valueOf, 6002, streamType) + 0.5d);
        tRTCRemoteStatistics.videoBitrate = TXCStatus.c(valueOf, 17002, streamType);
        tRTCRemoteStatistics.audioSampleRate = TXCStatus.c(valueOf, 18003);
        tRTCRemoteStatistics.audioBitrate = TXCStatus.c(valueOf, 18002);
        tRTCRemoteStatistics.jitterBufferDelay = TXCStatus.c(valueOf, 2007);
        tRTCRemoteStatistics.streamType = translateStreamType(streamType);
        AppMethodBeat.o(15979);
        return tRTCRemoteStatistics;
    }

    private TRTCStatistics.TRTCLocalStatistics getLocalStatistics(int i2) {
        AppMethodBeat.i(15980);
        int c2 = TXCStatus.c("18446744073709551615", WearableStatusCodes.DATA_ITEM_TOO_LARGE, i2);
        TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics = new TRTCStatistics.TRTCLocalStatistics();
        tRTCLocalStatistics.width = c2 >> 16;
        tRTCLocalStatistics.height = c2 & 65535;
        tRTCLocalStatistics.frameRate = (int) (TXCStatus.d("18446744073709551615", 4001, i2) + 0.5d);
        tRTCLocalStatistics.videoBitrate = TXCStatus.c("18446744073709551615", 13002, i2);
        tRTCLocalStatistics.audioSampleRate = TXCStatus.c("18446744073709551615", 14003);
        tRTCLocalStatistics.audioBitrate = TXCStatus.c("18446744073709551615", 14002);
        tRTCLocalStatistics.streamType = translateStreamType(i2);
        AppMethodBeat.o(15980);
        return tRTCLocalStatistics;
    }

    private void addRemoteStatistics(TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo, TRTCStatistics tRTCStatistics, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
        AppMethodBeat.i(15981);
        TRTCStatistics.TRTCRemoteStatistics remoteStatistics = getRemoteStatistics(tXCRenderAndDec, userInfo);
        tRTCStatistics.remoteArray.add(remoteStatistics);
        tRTCStatistics.downLoss = TXCStatus.c(String.valueOf(userInfo.tinyID), 16002);
        TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
        tRTCQuality.userId = userInfo.userID;
        tRTCQuality.quality = getNetworkQuality(tRTCStatistics.rtt, remoteStatistics.finalLoss);
        arrayList.add(tRTCQuality);
        AppMethodBeat.o(15981);
    }

    private void checkRTCState() {
        AppMethodBeat.i(15982);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mLastStateTimeMs + 2000) {
            AppMethodBeat.o(15982);
            return;
        }
        this.mLastStateTimeMs = currentTimeMillis;
        int[] a2 = com.tencent.liteav.basic.util.f.a();
        final ArrayList arrayList = new ArrayList();
        final TRTCStatistics tRTCStatistics = new TRTCStatistics();
        tRTCStatistics.appCpu = a2[0] / 10;
        tRTCStatistics.systemCpu = a2[1] / 10;
        tRTCStatistics.rtt = TXCStatus.c("18446744073709551615", 12002);
        tRTCStatistics.sendBytes = TXCStatus.a("18446744073709551615", 12004);
        tRTCStatistics.receiveBytes = TXCStatus.a("18446744073709551615", 16004);
        tRTCStatistics.upLoss = TXCStatus.c("18446744073709551615", 12003);
        tRTCStatistics.localArray = new ArrayList<>();
        tRTCStatistics.remoteArray = new ArrayList<>();
        tRTCStatistics.localArray.add(getLocalStatistics(2));
        if (this.mEnableSmallStream) {
            tRTCStatistics.localArray.add(getLocalStatistics(3));
        }
        this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass174 */

            @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
            public void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                AppMethodBeat.i(259882);
                if (userInfo.mainRender.render != null) {
                    TRTCCloudImpl.access$9300(TRTCCloudImpl.this, userInfo.mainRender.render, userInfo, tRTCStatistics, arrayList);
                }
                if (userInfo.subRender.render != null && userInfo.subRender.render.isRendering()) {
                    TRTCCloudImpl.access$9300(TRTCCloudImpl.this, userInfo.subRender.render, userInfo, tRTCStatistics, arrayList);
                }
                AppMethodBeat.o(259882);
            }
        });
        final TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
        tRTCQuality.userId = this.mRoomInfo.getUserId();
        tRTCQuality.quality = TXCStatus.c("18446744073709551615", 12005);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass175 */

            public void run() {
                AppMethodBeat.i(222404);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener != null) {
                    tRTCCloudListener.onStatistics(tRTCStatistics);
                    tRTCCloudListener.onNetworkQuality(tRTCQuality, arrayList);
                }
                AppMethodBeat.o(222404);
            }
        });
        AppMethodBeat.o(15982);
    }

    public void startCollectStatus() {
        AppMethodBeat.i(15983);
        if (this.mSDKHandler != null) {
            this.mSDKHandler.postDelayed(this.mStatusNotifyTask, 1000);
        }
        AppMethodBeat.o(15983);
    }

    /* access modifiers changed from: protected */
    public void stopCollectStatus() {
        AppMethodBeat.i(15984);
        if (this.mSDKHandler != null) {
            this.mSDKHandler.removeCallbacks(this.mStatusNotifyTask);
        }
        AppMethodBeat.o(15984);
    }

    /* access modifiers changed from: protected */
    public CharSequence getUploadStreamInfo() {
        AppMethodBeat.i(15985);
        int[] a2 = com.tencent.liteav.basic.util.f.a();
        int c2 = TXCStatus.c("18446744073709551615", WearableStatusCodes.DATA_ITEM_TOO_LARGE, 2);
        String b2 = TXCStatus.b("18446744073709551615", 10001);
        String str = String.format("LOCAL: [%s] RTT:%dms\n", this.mRoomInfo.getUserId(), Integer.valueOf(TXCStatus.c("18446744073709551615", 12002))) + String.format(Locale.CHINA, "SEND:% 5dkbps LOSS:%d-%d-%d-%d|%d-%d-%d-%d|%d%%\n", Integer.valueOf(TXCStatus.c("18446744073709551615", 12001)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13011, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13012, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13013, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14011)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14012)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14013)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14010)), Integer.valueOf(TXCStatus.c("18446744073709551615", 12003))) + String.format(Locale.CHINA, "BIT:%d|%d|%dkbps RES:%dx%d FPS:%d-%d\n", Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13002, 3)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14002)), Integer.valueOf(c2 >> 16), Integer.valueOf(c2 & 65535), Integer.valueOf((int) TXCStatus.d("18446744073709551615", 4001, 2)), Integer.valueOf((int) TXCStatus.d("18446744073709551615", 13014, 2))) + String.format(Locale.CHINA, "FEC:%d%%|%d%%  ARQ:%d|%dkbps  RPS:%d\n", Integer.valueOf(TXCStatus.c("18446744073709551615", 13004, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14006)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13008, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 14008)), Integer.valueOf(TXCStatus.c("18446744073709551615", 13007, 2))) + String.format(Locale.CHINA, "CPU:%d%%|%d%%    QOS:%s|%dkbps|%d-%d\n", Integer.valueOf(a2[0] / 10), Integer.valueOf(a2[1] / 10), getQosValue(TXCStatus.c("18446744073709551615", 15009, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15002, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15010, 2)), Integer.valueOf(TXCStatus.c("18446744073709551615", 15005, 2))) + String.format(Locale.CHINA, "SVR:%s", b2);
        AppMethodBeat.o(15985);
        return str;
    }

    private CharSequence getDownloadStreamInfo(TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(15986);
        String valueOf = String.valueOf(userInfo.tinyID);
        int[] a2 = com.tencent.liteav.basic.util.f.a();
        int streamType = tXCRenderAndDec.getStreamType();
        long a3 = TXCStatus.a(valueOf, 17014, streamType);
        int c2 = TXCStatus.c(valueOf, 5003, streamType);
        String str = String.format("REMOTE: [%s]%s RTT:%dms\n", userInfo.userID, streamType == 3 ? "S" : streamType == 7 ? "Sub" : streamType == 1 ? "A" : "B", Integer.valueOf(TXCStatus.c("18446744073709551615", 12002))) + String.format(Locale.CHINA, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", Integer.valueOf(TXCStatus.c(valueOf, 17001, streamType) + TXCStatus.c(valueOf, 18001)), Integer.valueOf(TXCStatus.c(valueOf, 17010, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17005, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17011, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 18013)), Integer.valueOf(TXCStatus.c(valueOf, 18007)), Integer.valueOf(TXCStatus.c(valueOf, 18014)), Integer.valueOf(TXCStatus.c(valueOf, 16002))) + String.format(Locale.CHINA, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", Integer.valueOf(TXCStatus.c(valueOf, 17002, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 18002)), Integer.valueOf(c2 >> 16), Integer.valueOf(c2 & 65535), Integer.valueOf((int) TXCStatus.d(valueOf, 6002, streamType)), Integer.valueOf((int) TXCStatus.d(valueOf, 17003, streamType))) + String.format(Locale.CHINA, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", Integer.valueOf(TXCStatus.c(valueOf, 17007, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17005, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17006, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 18009)), Integer.valueOf(TXCStatus.c(valueOf, 18007)), Integer.valueOf(TXCStatus.c(valueOf, 18008)), Integer.valueOf(TXCStatus.c(valueOf, 17009, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17008, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 18012)), Integer.valueOf(TXCStatus.c(valueOf, 18010))) + String.format(Locale.CHINA, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", Integer.valueOf(a2[0] / 10), Integer.valueOf(a2[1] / 10), Integer.valueOf(TXCStatus.c(valueOf, 17012, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 17013, streamType)), Long.valueOf(a3)) + String.format(Locale.CHINA, "Jitter: %d,%d|%d,%d|%d   ADROP: %d\n", Integer.valueOf(TXCStatus.c(valueOf, 2007)), Integer.valueOf(TXCStatus.c(valueOf, 6010, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 6011, streamType)), Integer.valueOf(TXCStatus.c(valueOf, 6012, streamType)), Integer.valueOf(TXCStatus.c(valueOf, TXLiteAVCode.EVT_HW_DECODER_START_SUCC)), Integer.valueOf(TXCStatus.c(valueOf, 18015))) + String.format(Locale.CHINA, "QUALITY: %d   LEN: %d\n", Integer.valueOf(TXCStatus.c(valueOf, 18023)), Integer.valueOf(TXCStatus.c(valueOf, 18016)));
        SpannableString spannableString = new SpannableString(str);
        int lastIndexOf = str.lastIndexOf("DECERR:");
        if (-1 != lastIndexOf && a3 > 0) {
            spannableString.setSpan(new ForegroundColorSpan(-65536), lastIndexOf + 7, str.length(), 33);
        }
        AppMethodBeat.o(15986);
        return spannableString;
    }

    private String getQosValue(int i2) {
        switch (i2) {
            case 0:
                return "HOLD";
            case 1:
                return "UP";
            case 2:
                return "DOWN";
            default:
                return "ERR";
        }
    }

    private int getDisplayRotation() {
        int i2 = 0;
        AppMethodBeat.i(15987);
        switch (this.mDisplay.getRotation()) {
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = TXLiveConstants.RENDER_ROTATION_180;
                break;
            case 3:
                i2 = 270;
                break;
        }
        AppMethodBeat.o(15987);
        return i2;
    }

    private void updateOrientation() {
        AppMethodBeat.i(15988);
        if (this.mVideoSourceType == VideoSourceType.CUSTOM || this.mVideoSourceType == VideoSourceType.SCREEN) {
            AppMethodBeat.o(15988);
            return;
        }
        if (this.mCurrentOrientation == -1) {
            if (this.mDisplay.getRotation() == 1) {
                this.mCurrentOrientation = 0;
            } else {
                this.mCurrentOrientation = 1;
            }
        }
        setOrientation(this.mCurrentOrientation);
        AppMethodBeat.o(15988);
    }

    private void checkRenderRotation(int i2) {
        int i3;
        AppMethodBeat.i(15989);
        int displayRotation = getDisplayRotation();
        int i4 = ((360 - displayRotation) - ((this.mConfig.l - 1) * 90)) % v2helper.VOIP_ENC_HEIGHT_LV1;
        boolean z = (i2 % 2 == displayRotation % 2 && this.mConfig.l == 1) || (i2 % 2 != displayRotation % 2 && this.mConfig.l == 0);
        if (this.mVideoRenderMirror == 1) {
            if (!this.mConfig.m && z) {
                i3 = i4 + TXLiveConstants.RENDER_ROTATION_180;
            }
            i3 = i4;
        } else {
            if (this.mVideoRenderMirror == 2 && this.mConfig.m && z) {
                i3 = i4 + TXLiveConstants.RENDER_ROTATION_180;
            }
            i3 = i4;
        }
        TXCLog.d(TAG, String.format("vrotation rotation-change %d-%d-%d ======= renderRotation %d-%d", Integer.valueOf(i2), Integer.valueOf(this.mConfig.l), Integer.valueOf(displayRotation), Integer.valueOf(i3), Integer.valueOf(this.mRoomInfo.localRenderRotation)) + " self:" + hashCode());
        this.mCaptureAndEnc.g((i3 + this.mRoomInfo.localRenderRotation) % v2helper.VOIP_ENC_HEIGHT_LV1);
        AppMethodBeat.o(15989);
    }

    private void checkVideoEncRotation(int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(15990);
        if (this.mConfig.l == 1) {
            i3 = 0;
        } else if ((!this.mConfig.S || !this.mConfig.m) && (this.mConfig.S || this.mConfig.m)) {
            i3 = 270;
        } else {
            i3 = 90;
        }
        switch (i2) {
            case 0:
                i4 = (i3 + 90) % v2helper.VOIP_ENC_HEIGHT_LV1;
                if (!this.mConfig.m) {
                    i4 = (i4 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
                }
                if (this.mConfig.S) {
                    i4 = (i4 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    break;
                }
                break;
            case 1:
                i4 = (i3 + 0) % v2helper.VOIP_ENC_HEIGHT_LV1;
                break;
            case 2:
                i4 = (i3 + 270) % v2helper.VOIP_ENC_HEIGHT_LV1;
                if (!this.mConfig.m) {
                    i4 = (i4 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
                }
                if (this.mConfig.S) {
                    i4 = (i4 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    break;
                }
                break;
            case 3:
                i4 = (i3 + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
                break;
            default:
                i4 = 0;
                break;
        }
        TXCLog.d(TAG, String.format("vrotation rotation-change %d-%d ======= encRotation %d", Integer.valueOf(i2), Integer.valueOf(this.mConfig.l), Integer.valueOf(i4)) + " self:" + hashCode());
        this.mCurrentOrientation = i2;
        this.mCaptureAndEnc.a(i4);
        AppMethodBeat.o(15990);
    }

    private void setOrientation(final int i2) {
        AppMethodBeat.i(15991);
        if (i2 == -1) {
            AppMethodBeat.o(15991);
            return;
        }
        runOnSDKThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass176 */

            public void run() {
                AppMethodBeat.i(222433);
                TRTCCloudImpl.access$9400(TRTCCloudImpl.this, i2);
                if (TRTCCloudImpl.this.mSensorMode != 0) {
                    TRTCCloudImpl.access$9500(TRTCCloudImpl.this, i2);
                }
                AppMethodBeat.o(222433);
            }
        });
        AppMethodBeat.o(15991);
    }

    private void addUpStreamType(int i2) {
        AppMethodBeat.i(222494);
        if (!this.mStreamTypes.contains(Integer.valueOf(i2))) {
            this.mStreamTypes.add(Integer.valueOf(i2));
        }
        addUpstream(i2);
        AppMethodBeat.o(222494);
    }

    private void removeUpStreamType(int i2) {
        AppMethodBeat.i(222495);
        if (this.mStreamTypes.contains(Integer.valueOf(i2))) {
            this.mStreamTypes.remove(Integer.valueOf(i2));
        }
        removeUpstream(i2);
        AppMethodBeat.o(222495);
    }

    private void setVideoEncoderConfiguration(int i2, int i3, int i4, int i5, int i6, int i7, boolean z, int i8) {
        AppMethodBeat.i(222496);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(Integer.valueOf(i2));
        if (tRTCCloudImpl != null) {
            nativeSetVideoEncoderConfiguration(tRTCCloudImpl.getNetworkContext(), i2, i3, i4, i5, i6, i7, z, i8);
        }
        AppMethodBeat.o(222496);
    }

    private void setVideoQuality(int i2, int i3) {
        AppMethodBeat.i(222497);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(2);
        if (tRTCCloudImpl != null) {
            nativeSetVideoQuality(tRTCCloudImpl.getNetworkContext(), i2, i3);
        }
        AppMethodBeat.o(222497);
    }

    private void muteUpstream(int i2, boolean z) {
        AppMethodBeat.i(222498);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(Integer.valueOf(i2));
        if (tRTCCloudImpl != null) {
            nativeMuteUpstream(tRTCCloudImpl.getNetworkContext(), i2, z);
        }
        AppMethodBeat.o(222498);
    }

    private void addUpstream(int i2) {
        AppMethodBeat.i(222499);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(Integer.valueOf(i2));
        if (tRTCCloudImpl != null) {
            nativeAddUpstream(tRTCCloudImpl.getNetworkContext(), i2);
        }
        AppMethodBeat.o(222499);
    }

    private void removeUpstream(int i2) {
        AppMethodBeat.i(222500);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(Integer.valueOf(i2));
        if (tRTCCloudImpl != null) {
            nativeRemoveUpstream(tRTCCloudImpl.getNetworkContext(), i2);
        }
        AppMethodBeat.o(222500);
    }

    private void setAudioEncodeConfiguration() {
        AppMethodBeat.i(222501);
        setQoSParams();
        AppMethodBeat.o(222501);
    }

    public void enableNetworkBlackStream(boolean z) {
        AppMethodBeat.i(222502);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(2);
        if (tRTCCloudImpl != null) {
            nativeEnableBlackStream(tRTCCloudImpl.getNetworkContext(), z);
        }
        AppMethodBeat.o(222502);
    }

    public void enableNetworkSmallStream(boolean z) {
        AppMethodBeat.i(222503);
        TRTCCloudImpl tRTCCloudImpl = this.mCurrentPublishClouds.get(2);
        if (tRTCCloudImpl != null) {
            nativeEnableSmallStream(tRTCCloudImpl.getNetworkContext(), z);
        }
        AppMethodBeat.o(222503);
    }

    private void pushVideoFrame(TXSNALPacket tXSNALPacket) {
        TRTCCloudImpl tRTCCloudImpl;
        AppMethodBeat.i(222504);
        synchronized (this.mCurrentPublishClouds) {
            try {
                tRTCCloudImpl = this.mCurrentPublishClouds.get(Integer.valueOf(tXSNALPacket.streamType));
            } finally {
                AppMethodBeat.o(222504);
            }
        }
        if (tRTCCloudImpl != null) {
            nativePushVideo(tRTCCloudImpl.getNetworkContext(), tXSNALPacket.streamType, tXSNALPacket.codecId == 1 ? 14 : 1, tXSNALPacket.nalType, tXSNALPacket.nalData, tXSNALPacket.gopIndex, tXSNALPacket.gopFrameIndex, tXSNALPacket.refFremeIndex, tXSNALPacket.pts, tXSNALPacket.dts);
        }
    }

    public long getNetworkContext() {
        return this.mNativeRtcContext;
    }

    public boolean isPublishingInCloud(TRTCCloudImpl tRTCCloudImpl, int i2) {
        AppMethodBeat.i(222505);
        synchronized (this.mCurrentPublishClouds) {
            try {
                if (this.mCurrentPublishClouds.get(Integer.valueOf(i2)) == tRTCCloudImpl) {
                    return true;
                }
                AppMethodBeat.o(222505);
                return false;
            } finally {
                AppMethodBeat.o(222505);
            }
        }
    }

    private void notifyCaptureStarted(final String str) {
        AppMethodBeat.i(222506);
        runOnListenerThread(new Runnable() {
            /* class com.tencent.liteav.trtc.impl.TRTCCloudImpl.AnonymousClass177 */

            public void run() {
                AppMethodBeat.i(259880);
                TRTCCloudListener tRTCCloudListener = TRTCCloudImpl.this.mTRTCListener;
                if (tRTCCloudListener == null) {
                    AppMethodBeat.o(259880);
                    return;
                }
                tRTCCloudListener.onWarning(4000, str, null);
                AppMethodBeat.o(259880);
            }
        });
        apiLog(str);
        AppMethodBeat.o(222506);
    }

    /* access modifiers changed from: package-private */
    public static class DisplayOrientationDetector extends OrientationEventListener {
        public int mCurOrientation = -1;
        private int mCurrentDisplayRotation = 0;
        private WeakReference<TRTCCloudImpl> mTRTCEngine;

        DisplayOrientationDetector(Context context, TRTCCloudImpl tRTCCloudImpl) {
            super(context);
            AppMethodBeat.i(15602);
            this.mTRTCEngine = new WeakReference<>(tRTCCloudImpl);
            AppMethodBeat.o(15602);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onOrientationChanged(int r6) {
            /*
            // Method dump skipped, instructions count: 143
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.impl.TRTCCloudImpl.DisplayOrientationDetector.onOrientationChanged(int):void");
        }

        public void checkOrientation() {
            int access$9600;
            AppMethodBeat.i(15604);
            TRTCCloudImpl tRTCCloudImpl = this.mTRTCEngine.get();
            if (!(tRTCCloudImpl == null || this.mCurrentDisplayRotation == (access$9600 = TRTCCloudImpl.access$9600(tRTCCloudImpl)))) {
                this.mCurrentDisplayRotation = access$9600;
                TRTCCloudImpl.access$9700(tRTCCloudImpl, this.mCurOrientation);
            }
            AppMethodBeat.o(15604);
        }
    }

    /* access modifiers changed from: package-private */
    public static class RenderListenerAdapter {
        public int bufferType;
        public TRTCCloudListener.TRTCVideoRenderListener listener;
        public int pixelFormat;
        public String strTinyID;

        RenderListenerAdapter() {
        }
    }

    /* access modifiers changed from: package-private */
    public enum VideoSourceType {
        NONE,
        CAMERA,
        SCREEN,
        CUSTOM;

        public static VideoSourceType valueOf(String str) {
            AppMethodBeat.i(222430);
            VideoSourceType videoSourceType = (VideoSourceType) Enum.valueOf(VideoSourceType.class, str);
            AppMethodBeat.o(222430);
            return videoSourceType;
        }

        static {
            AppMethodBeat.i(222431);
            AppMethodBeat.o(222431);
        }
    }
}
