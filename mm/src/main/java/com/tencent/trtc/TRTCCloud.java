package com.tencent.trtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

public abstract class TRTCCloud {
    private static a mTXLogListener = null;
    static WeakReference<TRTCCloud> sInstance = null;

    @Deprecated
    public interface BGMNotify {
        void onBGMComplete(int i2);

        void onBGMProgress(long j2, long j3);

        void onBGMStart(int i2);
    }

    public static native void setNetEnv(int i2);

    public abstract void ConnectOtherRoom(String str);

    public abstract void DisconnectOtherRoom();

    public abstract void callExperimentalAPI(String str);

    public abstract TRTCCloud createSubCloud();

    public abstract void destroySubCloud(TRTCCloud tRTCCloud);

    public abstract void enableAudioEarMonitoring(boolean z);

    public abstract void enableAudioVolumeEvaluation(int i2);

    public abstract void enableCustomAudioCapture(boolean z);

    public abstract void enableCustomVideoCapture(boolean z);

    public abstract int enableEncSmallVideoStream(boolean z, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract boolean enableTorch(boolean z);

    public abstract void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i2);

    public abstract void exitRoom();

    public abstract int getAudioCaptureVolume();

    public abstract TXAudioEffectManager getAudioEffectManager();

    public abstract int getAudioPlayoutVolume();

    @Deprecated
    public abstract int getBGMDuration(String str);

    public abstract TXBeautyManager getBeautyManager();

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraFocusPositionInPreviewSupported();

    public abstract boolean isCameraTorchSupported();

    public abstract boolean isCameraZoomSupported();

    public abstract void muteAllRemoteAudio(boolean z);

    public abstract void muteAllRemoteVideoStreams(boolean z);

    public abstract void muteLocalAudio(boolean z);

    public abstract void muteLocalVideo(boolean z);

    public abstract void muteRemoteAudio(String str, boolean z);

    public abstract void muteRemoteVideoStream(String str, boolean z);

    @Deprecated
    public abstract void pauseAudioEffect(int i2);

    @Deprecated
    public abstract void pauseBGM();

    public abstract void pauseScreenCapture();

    @Deprecated
    public abstract void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam);

    @Deprecated
    public abstract void playBGM(String str, BGMNotify bGMNotify);

    @Deprecated
    public abstract void resumeAudioEffect(int i2);

    @Deprecated
    public abstract void resumeBGM();

    public abstract void resumeScreenCapture();

    @Deprecated
    public abstract void selectMotionTmpl(String str);

    public abstract void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract boolean sendCustomCmdMsg(int i2, byte[] bArr, boolean z, boolean z2);

    public abstract void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    public abstract boolean sendSEIMsg(byte[] bArr, int i2);

    @Deprecated
    public abstract void setAllAudioEffectsVolume(int i2);

    public abstract void setAudioCaptureVolume(int i2);

    @Deprecated
    public abstract void setAudioEffectVolume(int i2, int i3);

    public abstract void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener);

    public abstract void setAudioPlayoutVolume(int i2);

    public abstract void setAudioQuality(int i2);

    public abstract void setAudioRoute(int i2);

    @Deprecated
    public abstract void setBGMPlayoutVolume(int i2);

    @Deprecated
    public abstract int setBGMPosition(int i2);

    @Deprecated
    public abstract void setBGMPublishVolume(int i2);

    @Deprecated
    public abstract void setBGMVolume(int i2);

    @Deprecated
    public abstract void setBeautyStyle(int i2, int i3, int i4, int i5);

    @Deprecated
    public abstract void setChinLevel(int i2);

    public abstract void setDebugViewMargin(String str, TRTCViewMargin tRTCViewMargin);

    public abstract void setDefaultStreamRecvMode(boolean z, boolean z2);

    @Deprecated
    public abstract void setEyeScaleLevel(int i2);

    @Deprecated
    public abstract void setFaceShortLevel(int i2);

    @Deprecated
    public abstract void setFaceSlimLevel(int i2);

    @Deprecated
    public abstract void setFaceVLevel(int i2);

    @Deprecated
    public abstract void setFilter(Bitmap bitmap);

    @Deprecated
    public abstract void setFilterConcentration(float f2);

    public abstract void setFocusPosition(int i2, int i3);

    public abstract void setGSensorMode(int i2);

    @TargetApi(18)
    @Deprecated
    public abstract boolean setGreenScreenFile(String str);

    public abstract void setListener(TRTCCloudListener tRTCCloudListener);

    public abstract void setListenerHandler(Handler handler);

    public abstract int setLocalVideoRenderListener(int i2, int i3, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract void setLocalViewFillMode(int i2);

    public abstract void setLocalViewMirror(int i2);

    public abstract void setLocalViewRotation(int i2);

    @Deprecated
    public abstract void setMicVolumeOnMixing(int i2);

    public abstract void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig);

    @Deprecated
    public abstract void setMotionMute(boolean z);

    public abstract void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam);

    @Deprecated
    public abstract void setNoseSlimLevel(int i2);

    public abstract int setPriorRemoteVideoStreamType(int i2);

    public abstract void setRemoteAudioVolume(String str, int i2);

    public abstract void setRemoteSubStreamViewFillMode(String str, int i2);

    public abstract void setRemoteSubStreamViewRotation(String str, int i2);

    public abstract int setRemoteVideoRenderListener(String str, int i2, int i3, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract int setRemoteVideoStreamType(String str, int i2);

    public abstract void setRemoteViewFillMode(String str, int i2);

    public abstract void setRemoteViewRotation(String str, int i2);

    @Deprecated
    public abstract void setReverbType(int i2);

    public abstract void setSystemVolumeType(int i2);

    public abstract void setVideoEncoderMirror(boolean z);

    public abstract void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoEncoderRotation(int i2);

    public abstract void setVideoMuteImage(Bitmap bitmap, int i2);

    @Deprecated
    public abstract boolean setVoiceChangerType(int i2);

    public abstract void setWatermark(Bitmap bitmap, int i2, float f2, float f3, float f4);

    public abstract void setZoom(int i2);

    public abstract void showDebugView(int i2);

    public abstract void snapshotVideo(String str, int i2, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    public abstract int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams);

    public abstract void startLocalAudio();

    public abstract void startLocalPreview(boolean z, TXCloudVideoView tXCloudVideoView);

    public abstract void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam);

    public abstract void startPublishing(String str, int i2);

    public abstract void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView);

    public abstract void startRemoteView(String str, TXCloudVideoView tXCloudVideoView);

    public abstract void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    public abstract void startSpeedTest(int i2, String str, String str2);

    @Deprecated
    public abstract void stopAllAudioEffects();

    public abstract void stopAllRemoteView();

    @Deprecated
    public abstract void stopAudioEffect(int i2);

    public abstract void stopAudioRecording();

    @Deprecated
    public abstract void stopBGM();

    public abstract void stopLocalAudio();

    public abstract void stopLocalPreview();

    public abstract void stopPublishCDNStream();

    public abstract void stopPublishing();

    public abstract void stopRemoteSubStreamView(String str);

    public abstract void stopRemoteView(String str);

    public abstract void stopScreenCapture();

    public abstract void stopSpeedTest();

    public abstract void switchCamera();

    public abstract void switchRole(int i2);

    public static TRTCCloud sharedInstance(Context context) {
        return TRTCCloudImpl.sharedInstance(context);
    }

    public static void destroySharedInstance() {
        TRTCCloudImpl.destroySharedInstance();
    }

    public static String getSDKVersion() {
        return TXCCommonUtil.getSDKVersionStr();
    }

    public static void setLogLevel(int i2) {
        TXCLog.setLevel(i2);
    }

    public static void setConsoleEnabled(boolean z) {
        TXCLog.setConsoleEnabled(z);
    }

    public static void setLogCompressEnabled(boolean z) {
        TXCLog.setLogCompressEnabled(z);
    }

    public static void setLogDirPath(String str) {
        TXCLog.setLogDirPath(str);
    }

    static class a implements TXCLog.a {
        TRTCCloudListener.TRTCLogListener Spl;

        public a() {
            this.Spl = null;
            this.Spl = null;
        }

        @Override // com.tencent.liteav.basic.log.TXCLog.a
        public final void a(int i2, String str, String str2) {
            AppMethodBeat.i(222694);
            TRTCCloudListener.TRTCLogListener tRTCLogListener = this.Spl;
            if (tRTCLogListener != null) {
                tRTCLogListener.onLog(str2, i2, str);
            }
            AppMethodBeat.o(222694);
        }
    }

    public static void setLogListener(TRTCCloudListener.TRTCLogListener tRTCLogListener) {
        if (mTXLogListener != null) {
            mTXLogListener.Spl = null;
        }
        if (tRTCLogListener != null) {
            a aVar = new a();
            mTXLogListener = aVar;
            aVar.Spl = tRTCLogListener;
        } else {
            mTXLogListener = null;
        }
        TXCLog.setListener(mTXLogListener);
    }

    public static class TRTCViewMargin {
        public float bottomMargin = 0.0f;
        public float leftMargin = 0.0f;
        public float rightMargin = 0.0f;
        public float topMargin = 0.0f;

        public TRTCViewMargin(float f2, float f3, float f4, float f5) {
            this.leftMargin = f2;
            this.topMargin = f4;
            this.rightMargin = f3;
            this.bottomMargin = f5;
        }
    }
}
