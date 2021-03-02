package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.WXTRTCCloud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXLivePusher extends TXLivePusher {
    private static final String RTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
    private static final String RTC_ADDRESS2 = "room://rtc.tencent.com";
    private static final String RTMP_PROXY_ADDRESS = "room://cloud.tencent.com";
    private static final String TAG = "WXLivePusher";
    private int mAppScene;
    private int mAudioVolumeEvaluationInterval;
    private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeEvaluationListener;
    private boolean mAutoRecvAudio;
    private boolean mAutoRecvVideo;
    private WeakReference<TXLivePusher.OnBGMNotify> mBGMNotify;
    private boolean mEnterRoom;
    private boolean mIsRtmpProxy;
    private boolean mIsTRTC;
    private HashMap<String, String> mMapMainStream;
    private HashMap<String, String> mMapSubStream;
    private boolean mNeedCheckRole;
    private WXLivePushConfig mPushConfig;
    private WeakReference<ITXLivePushListener> mPushListener;
    private boolean mStartAudio;
    private boolean mStartPreview;
    private WXTRTCCloud mTRTCCloud;
    private TRTCCloudListener mTRTCCloudListener;
    private TRTCCloudDef.TRTCParams mTRTCParams;
    private TXCloudVideoView mVideoView;

    static /* synthetic */ void access$700(WXLivePusher wXLivePusher, boolean z, String str, String str2) {
        AppMethodBeat.i(170221);
        wXLivePusher.notifyMainStreamChange(z, str, str2);
        AppMethodBeat.o(170221);
    }

    static /* synthetic */ void access$800(WXLivePusher wXLivePusher, boolean z, String str, String str2) {
        AppMethodBeat.i(170222);
        wXLivePusher.notifySubStreamChange(z, str, str2);
        AppMethodBeat.o(170222);
    }

    public WXLivePusher(Context context) {
        super(context);
        AppMethodBeat.i(13945);
        this.mTRTCCloud = null;
        this.mTRTCParams = null;
        this.mAppScene = 0;
        this.mIsTRTC = false;
        this.mStartPreview = false;
        this.mStartAudio = false;
        this.mEnterRoom = false;
        this.mNeedCheckRole = false;
        this.mIsRtmpProxy = false;
        this.mAutoRecvAudio = true;
        this.mAutoRecvVideo = true;
        this.mPushListener = null;
        this.mVideoView = null;
        this.mBGMNotify = null;
        this.mPushConfig = new WXLivePushConfig();
        this.mMapMainStream = new HashMap<>();
        this.mMapSubStream = new HashMap<>();
        this.mAudioVolumeEvaluationListener = null;
        this.mAudioVolumeEvaluationInterval = 0;
        this.mTRTCCloudListener = new TRTCCloudListener() {
            /* class com.tencent.rtmp.WXLivePusher.AnonymousClass4 */

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onError(int i2, String str, Bundle bundle) {
                AppMethodBeat.i(170224);
                super.onError(i2, str, bundle);
                AppMethodBeat.o(170224);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onWarning(int i2, String str, Bundle bundle) {
                AppMethodBeat.i(170225);
                super.onWarning(i2, str, bundle);
                AppMethodBeat.o(170225);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onEnterRoom(long j2) {
                AppMethodBeat.i(170226);
                super.onEnterRoom(j2);
                WXLivePusher.this.apiLog("[API] onEnterRoom", "result: ".concat(String.valueOf(j2)));
                if (j2 > 0) {
                    WXLivePusher.this.mEnterRoom = true;
                    sendEventNotify(1018, "onEnterRoom success, time cost[" + j2 + "]");
                    if (WXLivePusher.this.mNeedCheckRole) {
                        if (WXLivePusher.this.mStartAudio || WXLivePusher.this.mStartPreview) {
                            WXLivePusher.this.mTRTCCloud.switchRole(20);
                            AppMethodBeat.o(170226);
                            return;
                        }
                        WXLivePusher.this.mTRTCCloud.switchRole(21);
                        AppMethodBeat.o(170226);
                        return;
                    }
                } else {
                    WXLivePusher.this.mEnterRoom = false;
                    sendEventNotify(1022, "onEnterRoom failed, error code[" + j2 + "]");
                }
                AppMethodBeat.o(170226);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onExitRoom(int i2) {
                AppMethodBeat.i(170227);
                WXLivePusher.this.apiLog("[API] onExitRoom", "reason: ".concat(String.valueOf(i2)));
                super.onExitRoom(i2);
                WXLivePusher.this.mEnterRoom = false;
                sendEventNotify(1019, "onExitRoom reason[" + i2 + "]");
                AppMethodBeat.o(170227);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onRemoteUserEnterRoom(String str) {
                AppMethodBeat.i(170228);
                super.onUserEnter(str);
                WXLivePusher.this.apiLog("[API] onRemoteUserEnterRoom", "userId: ".concat(String.valueOf(str)));
                sendEventNotify(1031, getUserEnterJSONObject(str));
                AppMethodBeat.o(170228);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onRemoteUserLeaveRoom(String str, int i2) {
                AppMethodBeat.i(170229);
                super.onUserExit(str, i2);
                WXLivePusher.this.apiLog("[API] onRemoteUserLeaveRoom", "userId: " + str + ", reason: " + i2);
                sendEventNotify(1032, getUserExitJSONObject(str));
                AppMethodBeat.o(170229);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserVideoAvailable(String str, boolean z) {
                AppMethodBeat.i(170230);
                super.onUserVideoAvailable(str, z);
                WXLivePusher.this.apiLog("[API] onUserVideoAvailable", "userId: " + str + ", available: " + z);
                String str2 = "room://cloud.tencent.com/rtc?userid=" + str + "&streamtype=main";
                sendEventNotify(1033, getVideoAvailableJSONObject(str, str2, "main", z));
                if (z) {
                    WXLivePusher.access$700(WXLivePusher.this, true, str, str2);
                    AppMethodBeat.o(170230);
                    return;
                }
                WXLivePusher.access$700(WXLivePusher.this, false, str, "");
                AppMethodBeat.o(170230);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserAudioAvailable(String str, boolean z) {
                AppMethodBeat.i(170231);
                super.onUserAudioAvailable(str, z);
                WXLivePusher.this.apiLog("[API] onUserAudioAvailable", "userId: " + str + ", available: " + z);
                sendEventNotify(1034, getAudioAvailableJSONObject(str, "room://cloud.tencent.com/rtc?userid=" + str + "&streamtype=main", z));
                AppMethodBeat.o(170231);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserSubStreamAvailable(String str, boolean z) {
                AppMethodBeat.i(170232);
                super.onUserSubStreamAvailable(str, z);
                WXLivePusher.this.apiLog("[API] onUserSubStreamAvailable", "userId: " + str + ", available: " + z);
                String str2 = "room://cloud.tencent.com/rtc?userid=" + str + "&streamtype=aux";
                if (z) {
                    sendEventNotify(1033, getVideoAvailableJSONObject(str, str2, "aux", true));
                } else {
                    sendEventNotify(1033, getVideoAvailableJSONObject(str, str2, "aux", false));
                }
                WXLivePusher.access$800(WXLivePusher.this, z, str, str2);
                AppMethodBeat.o(170232);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i2) {
                AppMethodBeat.i(170233);
                if (WXLivePusher.this.mAudioVolumeEvaluationInterval > 0) {
                    Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TRTCCloudDef.TRTCVolumeInfo next = it.next();
                        if (next != null && next.userId != null && WXLivePusher.this.mTRTCParams != null && next.userId.equalsIgnoreCase(WXLivePusher.this.mTRTCParams.userId)) {
                            if (WXLivePusher.this.mAudioVolumeEvaluationListener != null) {
                                WXLivePusher.this.mAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(next.volume);
                            }
                        }
                    }
                }
                WXLivePusher.this.mTRTCCloud.notifyUserVoiceVolume(arrayList, i2);
                AppMethodBeat.o(170233);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onStatistics(TRTCStatistics tRTCStatistics) {
                AppMethodBeat.i(170234);
                WXLivePusher.this.mTRTCCloud.notifyStatistics(tRTCStatistics);
                AppMethodBeat.o(170234);
            }

            @Override // com.tencent.trtc.TRTCCloudListener
            public void onRecvSEIMsg(String str, byte[] bArr) {
                AppMethodBeat.i(170235);
                WXLivePusher.this.mTRTCCloud.notifySEIMessage(str, bArr);
                AppMethodBeat.o(170235);
            }

            private JSONObject getUserEnterJSONObject(String str) {
                AppMethodBeat.i(170236);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", str);
                    AppMethodBeat.o(170236);
                    return jSONObject;
                } catch (Exception e2) {
                    TXCLog.e(WXLivePusher.TAG, "build json object failed.", e2);
                    AppMethodBeat.o(170236);
                    return null;
                }
            }

            private JSONObject getUserExitJSONObject(String str) {
                AppMethodBeat.i(170237);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", str);
                    AppMethodBeat.o(170237);
                    return jSONObject;
                } catch (Exception e2) {
                    TXCLog.e(WXLivePusher.TAG, "build json object failed.", e2);
                    AppMethodBeat.o(170237);
                    return null;
                }
            }

            private JSONObject getVideoAvailableJSONObject(String str, String str2, String str3, boolean z) {
                AppMethodBeat.i(170238);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", str);
                    jSONObject.put("playurl", str2);
                    jSONObject.put("streamtype", str3);
                    jSONObject.put("hasvideo", z);
                    AppMethodBeat.o(170238);
                    return jSONObject;
                } catch (Exception e2) {
                    TXCLog.e(WXLivePusher.TAG, "build json object failed.", e2);
                    AppMethodBeat.o(170238);
                    return null;
                }
            }

            private JSONObject getAudioAvailableJSONObject(String str, String str2, boolean z) {
                AppMethodBeat.i(170239);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", str);
                    jSONObject.put("playurl", str2);
                    jSONObject.put("hasaudio", z);
                    AppMethodBeat.o(170239);
                    return jSONObject;
                } catch (Exception e2) {
                    TXCLog.e(WXLivePusher.TAG, "build json object failed.", e2);
                    AppMethodBeat.o(170239);
                    return null;
                }
            }

            private void sendEventNotify(int i2) {
                ITXLivePushListener iTXLivePushListener;
                AppMethodBeat.i(170240);
                if (!(WXLivePusher.this.mPushListener == null || (iTXLivePushListener = (ITXLivePushListener) WXLivePusher.this.mPushListener.get()) == null)) {
                    iTXLivePushListener.onPushEvent(i2, new Bundle());
                }
                AppMethodBeat.o(170240);
            }

            private void sendEventNotify(int i2, String str) {
                ITXLivePushListener iTXLivePushListener;
                AppMethodBeat.i(170241);
                if (!(WXLivePusher.this.mPushListener == null || (iTXLivePushListener = (ITXLivePushListener) WXLivePusher.this.mPushListener.get()) == null)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
                    iTXLivePushListener.onPushEvent(i2, bundle);
                }
                AppMethodBeat.o(170241);
            }

            private void sendEventNotify(int i2, JSONObject jSONObject) {
                ITXLivePushListener iTXLivePushListener;
                AppMethodBeat.i(170242);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONObject2.put("userlist", jSONArray);
                    if (!(WXLivePusher.this.mPushListener == null || (iTXLivePushListener = (ITXLivePushListener) WXLivePusher.this.mPushListener.get()) == null)) {
                        Bundle bundle = new Bundle();
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, jSONObject2.toString());
                        iTXLivePushListener.onPushEvent(i2, bundle);
                    }
                    AppMethodBeat.o(170242);
                } catch (Exception e2) {
                    TXCLog.e(WXLivePusher.TAG, "send event failed.", e2);
                    AppMethodBeat.o(170242);
                }
            }
        };
        this.mTRTCParams = new TRTCCloudDef.TRTCParams();
        this.mTRTCCloud = WXTRTCCloud.sharedInstance(context);
        this.mTRTCCloud.setListener(this.mTRTCCloudListener);
        AppMethodBeat.o(13945);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.i(13946);
        super.setPushListener(iTXLivePushListener);
        this.mTRTCCloud.setPushListener(iTXLivePushListener);
        this.mPushListener = new WeakReference<>(iTXLivePushListener);
        AppMethodBeat.o(13946);
    }

    public void setPusherUrl(String str) {
        AppMethodBeat.i(13947);
        this.mIsTRTC = isTRTCPusherUrl(str);
        AppMethodBeat.o(13947);
    }

    public void setConfig(WXLivePushConfig wXLivePushConfig) {
        AppMethodBeat.i(13948);
        super.setConfig((TXLivePushConfig) wXLivePushConfig);
        if (this.mIsTRTC) {
            apiLog("[API] setConfig", "config: ".concat(String.valueOf(wXLivePushConfig)) != null ? wXLivePushConfig.toString() : "");
            if (this.mEnterRoom) {
                updateConfig(false, wXLivePushConfig);
            }
        }
        this.mPushConfig = wXLivePushConfig.clone();
        AppMethodBeat.o(13948);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setSurface(Surface surface) {
        AppMethodBeat.i(13949);
        super.setSurface(surface);
        this.mTRTCCloud.setLocalSurface(surface);
        AppMethodBeat.o(13949);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setSurfaceSize(int i2, int i3) {
        AppMethodBeat.i(13950);
        super.setSurfaceSize(i2, i3);
        this.mTRTCCloud.setLocalSurfaceSize(i2, i3);
        AppMethodBeat.o(13950);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean setBeautyFilter(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(13951);
        super.setBeautyFilter(i2, i3, i4, i5);
        this.mTRTCCloud.setBeautyStyle(i2, i3, i4, i5);
        AppMethodBeat.o(13951);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(13952);
        apiLog("[API] startCameraPreview", "view: ".concat(String.valueOf(tXCloudVideoView)));
        if (this.mIsTRTC) {
            this.mTRTCCloud.startLocalPreview(this.mPushConfig.mFrontCamera, tXCloudVideoView);
        } else {
            super.startCameraPreview(tXCloudVideoView);
        }
        this.mVideoView = tXCloudVideoView;
        this.mStartPreview = true;
        checkSwitchAnchor();
        AppMethodBeat.o(13952);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void stopCameraPreview(boolean z) {
        AppMethodBeat.i(13953);
        apiLog("[API] stopCameraPreview", "isNeedClearLastImg: ".concat(String.valueOf(z)));
        if (this.mIsTRTC) {
            this.mTRTCCloud.stopLocalPreview();
        } else {
            super.stopCameraPreview(true);
        }
        this.mStartPreview = false;
        checkSwitchAudience();
        AppMethodBeat.o(13953);
    }

    public void startAudioRecord() {
        AppMethodBeat.i(13954);
        if (this.mIsTRTC) {
            this.mTRTCCloud.startLocalAudio();
        }
        this.mStartAudio = true;
        checkSwitchAnchor();
        AppMethodBeat.o(13954);
    }

    public void stopAudioRecord() {
        AppMethodBeat.i(13955);
        if (this.mIsTRTC) {
            this.mTRTCCloud.stopLocalAudio();
        }
        this.mStartAudio = false;
        checkSwitchAudience();
        AppMethodBeat.o(13955);
    }

    public int startDumpAudioData(String str) {
        AppMethodBeat.i(170217);
        if (this.mIsTRTC) {
            TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams = new TRTCCloudDef.TRTCAudioRecordingParams();
            tRTCAudioRecordingParams.filePath = str;
            int startAudioRecording = this.mTRTCCloud.startAudioRecording(tRTCAudioRecordingParams);
            AppMethodBeat.o(170217);
            return startAudioRecording;
        }
        int internalStartDumpAudioData = internalStartDumpAudioData(str);
        AppMethodBeat.o(170217);
        return internalStartDumpAudioData;
    }

    private int internalStartDumpAudioData(String str) {
        AppMethodBeat.i(170218);
        TXCAudioEngine.getInstance().setAudioDumpingListener(new TXCAudioEngineJNI.a() {
            /* class com.tencent.rtmp.WXLivePusher.AnonymousClass1 */

            @Override // com.tencent.liteav.audio.impl.TXCAudioEngineJNI.a
            public void onLocalAudioWriteFailed() {
                ITXLivePushListener iTXLivePushListener;
                AppMethodBeat.i(170223);
                if (!(WXLivePusher.this.mPushListener == null || (iTXLivePushListener = (ITXLivePushListener) WXLivePusher.this.mPushListener.get()) == null)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "write file failed when recording audio");
                    iTXLivePushListener.onPushEvent(TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL, bundle);
                }
                AppMethodBeat.o(170223);
            }
        });
        int startLocalAudioDumping = TXCAudioEngine.getInstance().startLocalAudioDumping(48000, 16, str);
        AppMethodBeat.o(170218);
        return startLocalAudioDumping;
    }

    public void stopDumpAudioData() {
        AppMethodBeat.i(170219);
        if (this.mIsTRTC) {
            this.mTRTCCloud.stopAudioRecording();
            AppMethodBeat.o(170219);
            return;
        }
        internalStopDumpAudioData();
        AppMethodBeat.o(170219);
    }

    private void internalStopDumpAudioData() {
        AppMethodBeat.i(170220);
        TXCAudioEngine.getInstance().stopLocalAudioDumping();
        AppMethodBeat.o(170220);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void switchCamera() {
        AppMethodBeat.i(13956);
        if (this.mIsTRTC) {
            this.mPushConfig.mFrontCamera = !this.mPushConfig.mFrontCamera;
            this.mTRTCCloud.switchCamera();
            AppMethodBeat.o(13956);
            return;
        }
        super.switchCamera();
        AppMethodBeat.o(13956);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean setMirror(boolean z) {
        AppMethodBeat.i(13957);
        super.setMirror(z);
        this.mTRTCCloud.setVideoEncoderMirror(z);
        AppMethodBeat.o(13957);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setMute(boolean z) {
        AppMethodBeat.i(13958);
        apiLog("[API] setMute", "mute: ".concat(String.valueOf(z)));
        super.setMute(z);
        this.mTRTCCloud.muteLocalAudio(z);
        AppMethodBeat.o(13958);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean turnOnFlashLight(boolean z) {
        AppMethodBeat.i(13959);
        if (this.mIsTRTC) {
            boolean enableTorch = this.mTRTCCloud.enableTorch(z);
            AppMethodBeat.o(13959);
            return enableTorch;
        }
        boolean turnOnFlashLight = super.turnOnFlashLight(z);
        AppMethodBeat.o(13959);
        return turnOnFlashLight;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public int getMaxZoom() {
        AppMethodBeat.i(13960);
        if (this.mIsTRTC) {
            int maxZoom = this.mTRTCCloud.getMaxZoom();
            AppMethodBeat.o(13960);
            return maxZoom;
        }
        int maxZoom2 = super.getMaxZoom();
        AppMethodBeat.o(13960);
        return maxZoom2;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean setZoom(int i2) {
        AppMethodBeat.i(13961);
        if (this.mIsTRTC) {
            this.mTRTCCloud.setZoom(i2);
        } else {
            super.setZoom(i2);
        }
        AppMethodBeat.o(13961);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setFocusPosition(float f2, float f3) {
        AppMethodBeat.i(13962);
        if (this.mIsTRTC) {
            this.mTRTCCloud.setFocusPosition(f2, f3);
            AppMethodBeat.o(13962);
            return;
        }
        super.setFocusPosition(f2, f3);
        AppMethodBeat.o(13962);
    }

    public void showDebugLog(boolean z) {
        AppMethodBeat.i(13963);
        if (this.mVideoView != null) {
            this.mVideoView.showLog(z);
        }
        this.mTRTCCloud.showDebugView(z ? 2 : 0);
        AppMethodBeat.o(13963);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean isPushing() {
        AppMethodBeat.i(13964);
        if (this.mIsTRTC) {
            boolean z = this.mEnterRoom;
            AppMethodBeat.o(13964);
            return z;
        }
        boolean isPushing = super.isPushing();
        AppMethodBeat.o(13964);
        return isPushing;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setFilter(Bitmap bitmap) {
        AppMethodBeat.i(182235);
        super.setFilter(bitmap);
        this.mTRTCCloud.setFilter(bitmap);
        AppMethodBeat.o(182235);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        AppMethodBeat.i(182236);
        if (!this.mIsTRTC) {
            super.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
        }
        this.mAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
        AppMethodBeat.o(182236);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void enableAudioVolumeEvaluation(int i2) {
        AppMethodBeat.i(182237);
        if (!this.mIsTRTC) {
            super.enableAudioVolumeEvaluation(i2);
        }
        this.mAudioVolumeEvaluationInterval = i2;
        AppMethodBeat.o(182237);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public int startPusher(String str) {
        AppMethodBeat.i(13965);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(13965);
            return -1;
        }
        this.mIsRtmpProxy = isRtmpProxyUrl(str);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] startPusher", "url:" + str + ", isTRTC: " + this.mIsTRTC, 0);
        }
        boolean isTRTCPusherUrl = isTRTCPusherUrl(str);
        if (!isTRTCPusherUrl) {
            this.mIsTRTC = isTRTCPusherUrl;
            int startPusher = super.startPusher(str);
            AppMethodBeat.o(13965);
            return startPusher;
        } else if (!parseTRTCParams(str)) {
            TXCLog.e(TAG, "parse pusherUrl failed!!!");
            AppMethodBeat.o(13965);
            return -1;
        } else {
            apiLog("[API] startPusher", "url: " + str + ", isTRTC: " + this.mIsTRTC);
            if (!this.mIsTRTC && isTRTCPusherUrl) {
                if (this.mStartPreview) {
                    super.stopCameraPreview(true);
                    this.mTRTCCloud.startLocalPreview(true, this.mVideoView);
                }
                if (this.mStartAudio) {
                    this.mTRTCCloud.startLocalAudio();
                }
            }
            if (!this.mNeedCheckRole) {
                this.mTRTCParams.role = 20;
            } else if (this.mStartPreview || this.mStartAudio) {
                this.mTRTCParams.role = 20;
            } else {
                this.mTRTCParams.role = 21;
            }
            this.mIsTRTC = isTRTCPusherUrl;
            updateConfig(true, this.mPushConfig);
            this.mTRTCCloud.setDefaultStreamRecvMode(this.mAutoRecvAudio, this.mAutoRecvVideo);
            this.mTRTCCloud.enableAudioVolumeEvaluation(300);
            this.mTRTCCloud.enterRoom(this.mTRTCParams, this.mAppScene);
            AppMethodBeat.o(13965);
            return 0;
        }
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void stopPusher() {
        AppMethodBeat.i(13966);
        if (this.mIsRtmpProxy) {
            Monitor.a(1, "[API] stopPusher", "isTRTC: " + this.mIsTRTC, 0);
        }
        if (this.mIsTRTC) {
            apiLog("[API] stopPusher", "isTRTC: " + this.mIsTRTC);
            this.mTRTCCloud.exitRoom();
            this.mTRTCCloud.setLocalViewMirror(0);
        } else {
            internalStopDumpAudioData();
            super.stopPusher();
        }
        resetParams();
        AppMethodBeat.o(13966);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void pausePusher() {
        AppMethodBeat.i(13967);
        apiLog("[API] pausePusher", "isTRTC: " + this.mIsTRTC);
        if (this.mIsTRTC) {
            if (this.mStartPreview && (this.mPushConfig.mPauseFlag & 1) == 1) {
                this.mTRTCCloud.pausePusher();
            }
            if (this.mStartAudio && (this.mPushConfig.mPauseFlag & 2) == 2) {
                this.mTRTCCloud.muteLocalAudio(true);
                AppMethodBeat.o(13967);
                return;
            }
        } else {
            super.pausePusher();
        }
        AppMethodBeat.o(13967);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void resumePusher() {
        AppMethodBeat.i(13968);
        apiLog("[API] resumePusher", "isTRTC: " + this.mIsTRTC);
        if (this.mIsTRTC) {
            if (this.mStartPreview && (this.mPushConfig.mPauseFlag & 1) == 1) {
                this.mTRTCCloud.resumePusher();
            }
            if (this.mStartAudio && (this.mPushConfig.mPauseFlag & 2) == 2) {
                this.mTRTCCloud.muteLocalAudio(false);
                AppMethodBeat.o(13968);
                return;
            }
        } else {
            super.resumePusher();
        }
        AppMethodBeat.o(13968);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void snapshot(final TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(13969);
        if (this.mIsTRTC) {
            this.mTRTCCloud.snapshotVideo(null, 0, new TRTCCloudListener.TRTCSnapshotListener() {
                /* class com.tencent.rtmp.WXLivePusher.AnonymousClass2 */

                @Override // com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener
                public void onSnapshotComplete(Bitmap bitmap) {
                    AppMethodBeat.i(182245);
                    if (iTXSnapshotListener != null) {
                        iTXSnapshotListener.onSnapshot(bitmap);
                    }
                    AppMethodBeat.o(182245);
                }
            });
            AppMethodBeat.o(13969);
            return;
        }
        super.snapshot(iTXSnapshotListener);
        AppMethodBeat.o(13969);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify) {
        AppMethodBeat.i(13970);
        super.setBGMNofify(onBGMNotify);
        this.mBGMNotify = new WeakReference<>(onBGMNotify);
        AppMethodBeat.o(13970);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean playBGM(String str) {
        AppMethodBeat.i(13971);
        if (this.mIsTRTC) {
            this.mTRTCCloud.playBGM(str, new TRTCCloud.BGMNotify() {
                /* class com.tencent.rtmp.WXLivePusher.AnonymousClass3 */

                @Override // com.tencent.trtc.TRTCCloud.BGMNotify
                public void onBGMStart(int i2) {
                    TXLivePusher.OnBGMNotify onBGMNotify;
                    AppMethodBeat.i(170244);
                    if (!(WXLivePusher.this.mBGMNotify == null || (onBGMNotify = (TXLivePusher.OnBGMNotify) WXLivePusher.this.mBGMNotify.get()) == null)) {
                        onBGMNotify.onBGMStart();
                    }
                    AppMethodBeat.o(170244);
                }

                @Override // com.tencent.trtc.TRTCCloud.BGMNotify
                public void onBGMProgress(long j2, long j3) {
                    TXLivePusher.OnBGMNotify onBGMNotify;
                    AppMethodBeat.i(170245);
                    if (!(WXLivePusher.this.mBGMNotify == null || (onBGMNotify = (TXLivePusher.OnBGMNotify) WXLivePusher.this.mBGMNotify.get()) == null)) {
                        onBGMNotify.onBGMProgress(j2, j3);
                    }
                    AppMethodBeat.o(170245);
                }

                @Override // com.tencent.trtc.TRTCCloud.BGMNotify
                public void onBGMComplete(int i2) {
                    TXLivePusher.OnBGMNotify onBGMNotify;
                    AppMethodBeat.i(170246);
                    if (!(WXLivePusher.this.mBGMNotify == null || (onBGMNotify = (TXLivePusher.OnBGMNotify) WXLivePusher.this.mBGMNotify.get()) == null)) {
                        onBGMNotify.onBGMComplete(i2);
                    }
                    AppMethodBeat.o(170246);
                }
            });
            AppMethodBeat.o(13971);
            return true;
        }
        boolean playBGM = super.playBGM(str);
        AppMethodBeat.o(13971);
        return playBGM;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean stopBGM() {
        AppMethodBeat.i(13972);
        if (this.mIsTRTC) {
            this.mTRTCCloud.stopBGM();
        } else {
            super.stopBGM();
        }
        AppMethodBeat.o(13972);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean pauseBGM() {
        AppMethodBeat.i(13973);
        if (this.mIsTRTC) {
            this.mTRTCCloud.pauseBGM();
        } else {
            super.pauseBGM();
        }
        AppMethodBeat.o(13973);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean resumeBGM() {
        AppMethodBeat.i(13974);
        if (this.mIsTRTC) {
            this.mTRTCCloud.resumeBGM();
        } else {
            super.resumeBGM();
        }
        AppMethodBeat.o(13974);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean setBGMVolume(float f2) {
        AppMethodBeat.i(13975);
        if (this.mIsTRTC) {
            this.mTRTCCloud.setBGMVolume(Math.round(100.0f * f2));
        } else {
            super.setBGMVolume(f2);
        }
        AppMethodBeat.o(13975);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean setMicVolume(float f2) {
        AppMethodBeat.i(13976);
        if (this.mIsTRTC) {
            this.mTRTCCloud.setMicVolumeOnMixing(Math.round(100.0f * f2));
        } else {
            super.setMicVolume(f2);
        }
        AppMethodBeat.o(13976);
        return true;
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public void setReverb(int i2) {
        AppMethodBeat.i(13977);
        if (this.mIsTRTC) {
            this.mTRTCCloud.setReverbType(i2);
            AppMethodBeat.o(13977);
            return;
        }
        super.setReverb(i2);
        AppMethodBeat.o(13977);
    }

    @Override // com.tencent.rtmp.TXLivePusher
    public boolean sendMessageEx(byte[] bArr) {
        AppMethodBeat.i(13978);
        if (this.mIsTRTC) {
            boolean sendSEIMsg = this.mTRTCCloud.sendSEIMsg(bArr, 1);
            AppMethodBeat.o(13978);
            return sendSEIMsg;
        }
        boolean sendMessageEx = super.sendMessageEx(bArr);
        AppMethodBeat.o(13978);
        return sendMessageEx;
    }

    public void resetParams() {
        AppMethodBeat.i(13979);
        this.mAppScene = 0;
        this.mIsTRTC = false;
        this.mStartPreview = false;
        this.mStartAudio = false;
        this.mEnterRoom = false;
        this.mNeedCheckRole = false;
        this.mAutoRecvAudio = true;
        this.mAutoRecvVideo = true;
        clearMainStream();
        clearSubStream();
        AppMethodBeat.o(13979);
    }

    private void checkSwitchAnchor() {
        AppMethodBeat.i(13980);
        if (this.mIsTRTC && this.mNeedCheckRole && this.mEnterRoom && (this.mStartPreview || this.mStartAudio)) {
            this.mTRTCCloud.switchRole(20);
        }
        AppMethodBeat.o(13980);
    }

    private void checkSwitchAudience() {
        AppMethodBeat.i(13981);
        if (this.mIsTRTC && this.mNeedCheckRole && this.mEnterRoom && !this.mStartPreview && !this.mStartAudio) {
            this.mTRTCCloud.switchRole(21);
        }
        AppMethodBeat.o(13981);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005a, code lost:
        if (r11.mHomeOrientation == r9.mPushConfig.mHomeOrientation) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateConfig(boolean r10, com.tencent.rtmp.WXLivePushConfig r11) {
        /*
        // Method dump skipped, instructions count: 524
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.WXLivePusher.updateConfig(boolean, com.tencent.rtmp.WXLivePushConfig):void");
    }

    private boolean isTRTCPusherUrl(String str) {
        AppMethodBeat.i(13983);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(13983);
            return false;
        } else if (str.startsWith(RTC_ADDRESS1) || str.startsWith(RTC_ADDRESS2)) {
            AppMethodBeat.o(13983);
            return true;
        } else {
            AppMethodBeat.o(13983);
            return false;
        }
    }

    private boolean isRtmpProxyUrl(String str) {
        AppMethodBeat.i(259968);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(259968);
            return false;
        } else if (str.startsWith(RTC_ADDRESS1) || str.startsWith(RTC_ADDRESS2)) {
            AppMethodBeat.o(259968);
            return false;
        } else {
            boolean startsWith = str.startsWith(RTMP_PROXY_ADDRESS);
            AppMethodBeat.o(259968);
            return startsWith;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c1 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseTRTCParams(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 778
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.WXLivePusher.parseTRTCParams(java.lang.String):boolean");
    }

    private void clearMainStream() {
        AppMethodBeat.i(13985);
        synchronized (this) {
            try {
                this.mMapMainStream.clear();
            } finally {
                AppMethodBeat.o(13985);
            }
        }
    }

    private void clearSubStream() {
        AppMethodBeat.i(13986);
        synchronized (this) {
            try {
                this.mMapSubStream.clear();
            } finally {
                AppMethodBeat.o(13986);
            }
        }
    }

    private void notifyMainStreamChange(boolean z, String str, String str2) {
        AppMethodBeat.i(13987);
        synchronized (this) {
            if (z) {
                try {
                    this.mMapMainStream.put(str, str2);
                } catch (Throwable th) {
                    AppMethodBeat.o(13987);
                    throw th;
                }
            } else {
                this.mMapMainStream.remove(str);
            }
        }
        notifyFullUserList();
        AppMethodBeat.o(13987);
    }

    private void notifySubStreamChange(boolean z, String str, String str2) {
        AppMethodBeat.i(13988);
        synchronized (this) {
            if (z) {
                try {
                    this.mMapSubStream.put(str, str2);
                } catch (Throwable th) {
                    AppMethodBeat.o(13988);
                    throw th;
                }
            } else {
                this.mMapSubStream.remove(str);
            }
        }
        notifyFullUserList();
        AppMethodBeat.o(13988);
    }

    private void notifyFullUserList() {
        ITXLivePushListener iTXLivePushListener;
        AppMethodBeat.i(13989);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("userlist", jSONArray);
            synchronized (this) {
                try {
                    for (String str : this.mMapMainStream.keySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("userid", str);
                        jSONObject2.put("playurl", this.mMapMainStream.get(str));
                        jSONArray.put(jSONObject2);
                    }
                } finally {
                    AppMethodBeat.o(13989);
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONObject.put("userlist_aux", jSONArray2);
            synchronized (this) {
                try {
                    for (String str2 : this.mMapSubStream.keySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("userid", str2);
                        jSONObject3.put("playurl", this.mMapSubStream.get(str2));
                        jSONArray2.put(jSONObject3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!(this.mPushListener == null || (iTXLivePushListener = this.mPushListener.get()) == null)) {
                Bundle bundle = new Bundle();
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, jSONObject.toString());
                iTXLivePushListener.onPushEvent(1020, bundle);
            }
            AppMethodBeat.o(13989);
        } catch (Exception e2) {
            TXCLog.e(TAG, "notify full user list failed.", e2);
            AppMethodBeat.o(13989);
        }
    }

    public void apiLog(String str, String str2) {
        AppMethodBeat.i(259969);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = "wx_livepusher(" + hashCode() + ") " + str;
        TXCLog.i(TAG, str3 + " " + str2);
        Monitor.a(1, str3, str2, 0);
        AppMethodBeat.o(259969);
    }
}
