package com.tencent.trtc;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;

public abstract class TRTCCloudListener {

    public interface TRTCAudioFrameListener {
        void onCapturedRawAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

        void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame, String str);
    }

    public static abstract class TRTCLogListener {
        public abstract void onLog(String str, int i2, String str2);
    }

    public interface TRTCSnapshotListener {
        void onSnapshotComplete(Bitmap bitmap);
    }

    public interface TRTCVideoRenderListener {
        void onRenderVideoFrame(String str, int i2, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);
    }

    public void onError(int i2, String str, Bundle bundle) {
    }

    public void onWarning(int i2, String str, Bundle bundle) {
    }

    public void onEnterRoom(long j2) {
    }

    public void onExitRoom(int i2) {
    }

    public void onSwitchRole(int i2, String str) {
    }

    public void onConnectOtherRoom(String str, int i2, String str2) {
    }

    public void onDisConnectOtherRoom(int i2, String str) {
    }

    public void onRemoteUserEnterRoom(String str) {
    }

    public void onRemoteUserLeaveRoom(String str, int i2) {
    }

    public void onUserVideoAvailable(String str, boolean z) {
    }

    public void onUserSubStreamAvailable(String str, boolean z) {
    }

    public void onUserAudioAvailable(String str, boolean z) {
    }

    public void onFirstVideoFrame(String str, int i2, int i3, int i4) {
    }

    public void onFirstAudioFrame(String str) {
    }

    public void onSendFirstLocalVideoFrame(int i2) {
    }

    public void onSendFirstLocalAudioFrame() {
    }

    @Deprecated
    public void onUserEnter(String str) {
    }

    @Deprecated
    public void onUserExit(String str, int i2) {
    }

    public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
    }

    public void onStatistics(TRTCStatistics tRTCStatistics) {
    }

    public void onConnectionLost() {
    }

    public void onTryToReconnect() {
    }

    public void onConnectionRecovery() {
    }

    public void onSpeedTest(TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult, int i2, int i3) {
    }

    public void onCameraDidReady() {
    }

    public void onMicDidReady() {
    }

    public void onAudioRouteChanged(int i2, int i3) {
    }

    public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i2) {
    }

    public void onRecvCustomCmdMsg(String str, int i2, int i3, byte[] bArr) {
    }

    public void onMissCustomCmdMsg(String str, int i2, int i3, int i4) {
    }

    public void onRecvSEIMsg(String str, byte[] bArr) {
    }

    public void onStartPublishing(int i2, String str) {
    }

    public void onStopPublishing(int i2, String str) {
    }

    public void onStartPublishCDNStream(int i2, String str) {
    }

    public void onStopPublishCDNStream(int i2, String str) {
    }

    public void onSetMixTranscodingConfig(int i2, String str) {
    }

    public void onAudioEffectFinished(int i2, int i3) {
    }

    public void onScreenCaptureStarted() {
    }

    public void onScreenCapturePaused() {
    }

    public void onScreenCaptureResumed() {
    }

    public void onScreenCaptureStopped(int i2) {
    }
}
