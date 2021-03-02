package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePusher {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mTXTxLivePusherImpl;

    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4);

        void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4, boolean z);
    }

    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i2);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    @Deprecated
    public interface OnBGMNotify {
        void onBGMComplete(int i2);

        void onBGMProgress(long j2, long j3);

        void onBGMStart();
    }

    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i2, int i3, int i4);

        void onTextureDestoryed();
    }

    public TXLivePusher(Context context) {
        AppMethodBeat.i(13556);
        this.mTXTxLivePusherImpl = new b(context);
        AppMethodBeat.o(13556);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.i(13557);
        this.mTXTxLivePusherImpl.a(tXLivePushConfig);
        AppMethodBeat.o(13557);
    }

    public TXLivePushConfig getConfig() {
        AppMethodBeat.i(13558);
        TXLivePushConfig i2 = this.mTXTxLivePusherImpl.i();
        AppMethodBeat.o(13558);
        return i2;
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.i(13559);
        this.mTXTxLivePusherImpl.a(iTXLivePushListener);
        AppMethodBeat.o(13559);
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(13560);
        this.mTXTxLivePusherImpl.a(tXCloudVideoView);
        AppMethodBeat.o(13560);
    }

    public void stopCameraPreview(boolean z) {
        AppMethodBeat.i(13561);
        this.mTXTxLivePusherImpl.b(z);
        AppMethodBeat.o(13561);
    }

    public int startPusher(String str) {
        AppMethodBeat.i(13562);
        int a2 = this.mTXTxLivePusherImpl.a(str);
        AppMethodBeat.o(13562);
        return a2;
    }

    public void stopPusher() {
        AppMethodBeat.i(13563);
        this.mTXTxLivePusherImpl.j();
        AppMethodBeat.o(13563);
    }

    public void startScreenCapture() {
        AppMethodBeat.i(13564);
        this.mTXTxLivePusherImpl.n();
        AppMethodBeat.o(13564);
    }

    public void stopScreenCapture() {
        AppMethodBeat.i(13565);
        this.mTXTxLivePusherImpl.o();
        AppMethodBeat.o(13565);
    }

    public void pausePusher() {
        AppMethodBeat.i(13566);
        this.mTXTxLivePusherImpl.k();
        AppMethodBeat.o(13566);
    }

    public void resumePusher() {
        AppMethodBeat.i(13567);
        this.mTXTxLivePusherImpl.l();
        AppMethodBeat.o(13567);
    }

    public boolean isPushing() {
        AppMethodBeat.i(13568);
        boolean m = this.mTXTxLivePusherImpl.m();
        AppMethodBeat.o(13568);
        return m;
    }

    public void setVideoQuality(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(13569);
        this.mTXTxLivePusherImpl.a(i2, z, z2);
        AppMethodBeat.o(13569);
    }

    public void switchCamera() {
        AppMethodBeat.i(13570);
        this.mTXTxLivePusherImpl.p();
        AppMethodBeat.o(13570);
    }

    public boolean setMirror(boolean z) {
        AppMethodBeat.i(13571);
        boolean c2 = this.mTXTxLivePusherImpl.c(z);
        AppMethodBeat.o(13571);
        return c2;
    }

    public void setRenderRotation(int i2) {
        AppMethodBeat.i(13572);
        this.mTXTxLivePusherImpl.a(i2);
        AppMethodBeat.o(13572);
    }

    public boolean turnOnFlashLight(boolean z) {
        AppMethodBeat.i(13573);
        boolean d2 = this.mTXTxLivePusherImpl.d(z);
        AppMethodBeat.o(13573);
        return d2;
    }

    public int getMaxZoom() {
        AppMethodBeat.i(13574);
        int q = this.mTXTxLivePusherImpl.q();
        AppMethodBeat.o(13574);
        return q;
    }

    public boolean setZoom(int i2) {
        AppMethodBeat.i(13575);
        boolean b2 = this.mTXTxLivePusherImpl.b(i2);
        AppMethodBeat.o(13575);
        return b2;
    }

    public void setExposureCompensation(float f2) {
        AppMethodBeat.i(13576);
        this.mTXTxLivePusherImpl.a(f2);
        AppMethodBeat.o(13576);
    }

    public TXBeautyManager getBeautyManager() {
        AppMethodBeat.i(13577);
        TXBeautyManager r = this.mTXTxLivePusherImpl.r();
        AppMethodBeat.o(13577);
        return r;
    }

    public boolean setBeautyFilter(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(13578);
        boolean a2 = this.mTXTxLivePusherImpl.a(i2, i3, i4, i5);
        AppMethodBeat.o(13578);
        return a2;
    }

    @Deprecated
    public void setFilter(Bitmap bitmap) {
        AppMethodBeat.i(13579);
        getBeautyManager().setFilter(bitmap);
        AppMethodBeat.o(13579);
    }

    @Deprecated
    public void setSpecialRatio(float f2) {
        AppMethodBeat.i(13580);
        getBeautyManager().setFilterStrength(f2);
        AppMethodBeat.o(13580);
    }

    @Deprecated
    public void setEyeScaleLevel(int i2) {
        AppMethodBeat.i(13581);
        getBeautyManager().setEyeScaleLevel(i2);
        AppMethodBeat.o(13581);
    }

    @Deprecated
    public void setFaceSlimLevel(int i2) {
        AppMethodBeat.i(13582);
        getBeautyManager().setFaceSlimLevel(i2);
        AppMethodBeat.o(13582);
    }

    @Deprecated
    public void setFaceVLevel(int i2) {
        AppMethodBeat.i(13583);
        getBeautyManager().setFaceVLevel(i2);
        AppMethodBeat.o(13583);
    }

    @Deprecated
    public void setChinLevel(int i2) {
        AppMethodBeat.i(13584);
        getBeautyManager().setChinLevel(i2);
        AppMethodBeat.o(13584);
    }

    @Deprecated
    public void setFaceShortLevel(int i2) {
        AppMethodBeat.i(13585);
        getBeautyManager().setFaceShortLevel(i2);
        AppMethodBeat.o(13585);
    }

    @Deprecated
    public void setNoseSlimLevel(int i2) {
        AppMethodBeat.i(13586);
        getBeautyManager().setNoseSlimLevel(i2);
        AppMethodBeat.o(13586);
    }

    @TargetApi(18)
    @Deprecated
    public boolean setGreenScreenFile(String str) {
        AppMethodBeat.i(13587);
        getBeautyManager().setGreenScreenFile(str);
        AppMethodBeat.o(13587);
        return true;
    }

    @Deprecated
    public void setMotionTmpl(String str) {
        AppMethodBeat.i(13588);
        getBeautyManager().setMotionTmpl(str);
        AppMethodBeat.o(13588);
    }

    @Deprecated
    public void setMotionMute(boolean z) {
        AppMethodBeat.i(13589);
        getBeautyManager().setMotionMute(z);
        AppMethodBeat.o(13589);
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(13590);
        this.mTXTxLivePusherImpl.e(z);
        AppMethodBeat.o(13590);
    }

    public TXAudioEffectManager getAudioEffectManager() {
        AppMethodBeat.i(222652);
        TXAudioEffectManagerImpl autoCacheHolder = TXAudioEffectManagerImpl.getAutoCacheHolder();
        AppMethodBeat.o(222652);
        return autoCacheHolder;
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        AppMethodBeat.i(182243);
        this.mTXTxLivePusherImpl.a(iTXAudioVolumeEvaluationListener);
        AppMethodBeat.o(182243);
    }

    public void enableAudioVolumeEvaluation(int i2) {
        AppMethodBeat.i(182244);
        this.mTXTxLivePusherImpl.f(i2);
        AppMethodBeat.o(182244);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.i(13603);
        this.mTXTxLivePusherImpl.a(iTXVideoRecordListener);
        AppMethodBeat.o(13603);
    }

    public int startRecord(String str) {
        AppMethodBeat.i(13604);
        int d2 = this.mTXTxLivePusherImpl.d(str);
        AppMethodBeat.o(13604);
        return d2;
    }

    public void stopRecord() {
        AppMethodBeat.i(13605);
        this.mTXTxLivePusherImpl.w();
        AppMethodBeat.o(13605);
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(13606);
        this.mTXTxLivePusherImpl.a(iTXSnapshotListener);
        AppMethodBeat.o(13606);
    }

    public int sendCustomVideoTexture(int i2, int i3, int i4) {
        AppMethodBeat.i(13607);
        int c2 = this.mTXTxLivePusherImpl.c(i2, i3, i4);
        AppMethodBeat.o(13607);
        return c2;
    }

    public int sendCustomVideoData(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(13608);
        int a2 = this.mTXTxLivePusherImpl.a(bArr, i2, i3, i4);
        AppMethodBeat.o(13608);
        return a2;
    }

    public void sendCustomPCMData(byte[] bArr) {
        AppMethodBeat.i(13609);
        this.mTXTxLivePusherImpl.a(bArr);
        AppMethodBeat.o(13609);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        AppMethodBeat.i(13610);
        this.mTXTxLivePusherImpl.a(videoCustomProcessListener);
        AppMethodBeat.o(13610);
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        AppMethodBeat.i(13611);
        this.mTXTxLivePusherImpl.a(audioCustomProcessListener);
        AppMethodBeat.o(13611);
    }

    public void setSurface(Surface surface) {
        AppMethodBeat.i(13612);
        this.mTXTxLivePusherImpl.a(surface);
        AppMethodBeat.o(13612);
    }

    public void setSurfaceSize(int i2, int i3) {
        AppMethodBeat.i(13613);
        this.mTXTxLivePusherImpl.a(i2, i3);
        AppMethodBeat.o(13613);
    }

    public void setFocusPosition(float f2, float f3) {
        AppMethodBeat.i(13614);
        this.mTXTxLivePusherImpl.a(f2, f3);
        AppMethodBeat.o(13614);
    }

    public boolean sendMessageEx(byte[] bArr) {
        AppMethodBeat.i(13615);
        boolean b2 = this.mTXTxLivePusherImpl.b(bArr);
        AppMethodBeat.o(13615);
        return b2;
    }

    @Deprecated
    public void sendMessage(byte[] bArr) {
        AppMethodBeat.i(13616);
        this.mTXTxLivePusherImpl.c(bArr);
        AppMethodBeat.o(13616);
    }

    public void onLogRecord(String str) {
        AppMethodBeat.i(13617);
        this.mTXTxLivePusherImpl.e(str);
        AppMethodBeat.o(13617);
    }

    @Deprecated
    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        AppMethodBeat.i(13591);
        this.mTXTxLivePusherImpl.a(onBGMNotify);
        AppMethodBeat.o(13591);
    }

    @Deprecated
    public boolean playBGM(String str) {
        AppMethodBeat.i(13592);
        boolean b2 = this.mTXTxLivePusherImpl.b(str);
        AppMethodBeat.o(13592);
        return b2;
    }

    @Deprecated
    public boolean stopBGM() {
        AppMethodBeat.i(13593);
        boolean s = this.mTXTxLivePusherImpl.s();
        AppMethodBeat.o(13593);
        return s;
    }

    @Deprecated
    public boolean pauseBGM() {
        AppMethodBeat.i(13594);
        boolean u = this.mTXTxLivePusherImpl.u();
        AppMethodBeat.o(13594);
        return u;
    }

    @Deprecated
    public boolean resumeBGM() {
        AppMethodBeat.i(13595);
        boolean v = this.mTXTxLivePusherImpl.v();
        AppMethodBeat.o(13595);
        return v;
    }

    @Deprecated
    public int getMusicDuration(String str) {
        AppMethodBeat.i(13596);
        int c2 = this.mTXTxLivePusherImpl.c(str);
        AppMethodBeat.o(13596);
        return c2;
    }

    @Deprecated
    public boolean setBGMVolume(float f2) {
        AppMethodBeat.i(13597);
        boolean b2 = this.mTXTxLivePusherImpl.b(f2);
        AppMethodBeat.o(13597);
        return b2;
    }

    @Deprecated
    public boolean setMicVolume(float f2) {
        AppMethodBeat.i(13598);
        boolean c2 = this.mTXTxLivePusherImpl.c(f2);
        AppMethodBeat.o(13598);
        return c2;
    }

    @Deprecated
    public void setBGMPitch(float f2) {
        AppMethodBeat.i(13599);
        this.mTXTxLivePusherImpl.d(f2);
        AppMethodBeat.o(13599);
    }

    @Deprecated
    public void setReverb(int i2) {
        AppMethodBeat.i(13600);
        this.mTXTxLivePusherImpl.d(i2);
        AppMethodBeat.o(13600);
    }

    @Deprecated
    public void setVoiceChangerType(int i2) {
        AppMethodBeat.i(13601);
        this.mTXTxLivePusherImpl.e(i2);
        AppMethodBeat.o(13601);
    }

    @Deprecated
    public boolean setBGMPosition(int i2) {
        AppMethodBeat.i(13602);
        boolean c2 = this.mTXTxLivePusherImpl.c(i2);
        AppMethodBeat.o(13602);
        return c2;
    }
}
