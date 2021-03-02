package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI {
    private static final String TAG = "TXCAudioEngineJNI";
    private static WeakReference<e> mAudioCaptureDataListener = null;
    private static a mAudioDumpingListener = null;

    public interface a {
        void onLocalAudioWriteFailed();
    }

    public static native void nativeAppendLibraryPath(String str);

    public static native void nativeCacheClassForNative();

    public static native void nativeClean();

    public static native void nativeDeleteAudioSessionDuplicate();

    public static native void nativeEnableAudioEarMonitoring(boolean z);

    public static native void nativeEnableAudioVolumeEvaluation(boolean z, int i2);

    public static native void nativeEnableAutoRestartDevice(boolean z);

    public static native void nativeEnableCaptureEOSMode(boolean z);

    public static native void nativeEnableEncodedDataCallback(boolean z);

    public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean z);

    public static native void nativeEnableMixMode(boolean z);

    public static native void nativeForceCallbackMixedPlayAudioFrame(boolean z);

    public static native int nativeGetEncoderChannels();

    public static native TXCAudioEncoderConfig nativeGetEncoderConfig();

    public static native int nativeGetEncoderSampleRate();

    public static native int nativeGetMixingPlayoutVolumeLevel();

    public static native int nativeGetRemotePlayoutVolumeLevel(String str);

    public static native int nativeGetSoftwareCaptureVolumeLevel();

    public static native StatusBucket nativeGetStatus(int i2);

    public static native void nativeInitAudioDevice();

    public static native void nativeInitBeforeEngineCreate(Context context);

    public static native boolean nativeIsAudioDeviceCapturing();

    public static native boolean nativeIsAudioDevicePlaying();

    public static native boolean nativeIsRemoteAudioPlaying(String str);

    public static native void nativeMuteLocalAudio(boolean z);

    public static native void nativeMuteRemoteAudio(String str, boolean z);

    public static native void nativeMuteRemoteAudioInSpeaker(String str, boolean z);

    public static native void nativeNewAudioSessionDuplicate(Context context);

    public static native void nativePauseAudioCapture(boolean z);

    public static native void nativePauseLocalAudio();

    public static native void nativeResumeAudioCapture();

    public static native void nativeResumeLocalAudio();

    public static native void nativeSendCustomPCMData(byte[] bArr, int i2, long j2, int i3, int i4);

    public static native void nativeSetAudioEarMonitoringVolume(int i2);

    public static native void nativeSetAudioEncoderParam(int i2, int i3);

    public static native void nativeSetAudioEngineCaptureDataCallback(boolean z);

    public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean z);

    public static native void nativeSetAudioEngineEncodedDataCallback(boolean z);

    public static native void nativeSetAudioEngineRemoteStreamDataListener(String str, boolean z);

    public static native void nativeSetAudioPlayoutTunnelEnabled(boolean z);

    public static native void nativeSetAudioQuality(int i2, int i3);

    public static native void nativeSetAudioRoute(int i2);

    public static native void nativeSetCaptureDataCallbackFormat(int i2, int i3, int i4);

    public static native void nativeSetCaptureVoiceChanger(int i2);

    public static native void nativeSetEncoderChannels(int i2);

    public static native void nativeSetEncoderFECPercent(float f2);

    public static native void nativeSetEncoderSampleRate(int i2);

    public static native void nativeSetEventCallbackEnabled(boolean z);

    public static native void nativeSetMaxSelectedPlayStreams(int i2);

    public static native void nativeSetMixingPlayoutVolume(float f2);

    public static native void nativeSetPlayoutDataCallbackFormat(int i2, int i3, int i4);

    public static native void nativeSetPlayoutDataListener(boolean z);

    public static native void nativeSetPlayoutDevice(int i2);

    public static native void nativeSetRecordReverb(int i2);

    public static native void nativeSetRemoteAudioBlockThreshold(String str, long j2);

    public static native void nativeSetRemoteAudioCacheParams(String str, boolean z, int i2, int i3, int i4);

    public static native void nativeSetRemoteAudioJitterCycle(String str, long j2);

    public static native void nativeSetRemotePlayoutVolume(String str, int i2);

    public static native void nativeSetRemoteStreamDataCallbackFormat(String str, int i2, int i3, int i4);

    public static native void nativeSetSoftAEC(int i2);

    public static native void nativeSetSoftAGC(int i2);

    public static native void nativeSetSoftANS(int i2);

    public static native void nativeSetSoftwareCaptureVolume(float f2);

    public static native void nativeSetSystemVolumeType(int i2);

    public static native void nativeSetTRAEConfig(String str);

    public static native void nativeStartLocalAudio(int i2, boolean z);

    public static native int nativeStartLocalAudioDumping(int i2, int i3, String str);

    public static native String nativeStartRemoteAudio(TXCAudioEngine tXCAudioEngine, boolean z, String str);

    public static native void nativeStopLocalAudio();

    public static native void nativeStopLocalAudioDumping();

    public static native void nativeStopRemoteAudio(String str);

    public static native void nativeUnInitAudioDevice();

    public static native void nativeUnInitEngine();

    public static native void nativeUseSysAudioDevice(boolean z);

    static {
        AppMethodBeat.i(221897);
        f.f();
        nativeCacheClassForNative();
        AppMethodBeat.o(221897);
    }

    public static void setAudioCaptureDataListener(WeakReference<e> weakReference) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(221882);
        mAudioCaptureDataListener = weakReference;
        if (weakReference == null) {
            z = false;
        } else {
            z = true;
        }
        nativeSetAudioEngineCaptureDataCallback(z);
        if (mAudioCaptureDataListener == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        nativeSetAudioEngineCaptureRawDataCallback(z2);
        if (mAudioCaptureDataListener != null) {
            z3 = true;
        }
        nativeSetAudioEngineEncodedDataCallback(z3);
        AppMethodBeat.o(221882);
    }

    public static void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(221883);
        if (!(mAudioCaptureDataListener == null || mAudioCaptureDataListener.get() == null)) {
            mAudioCaptureDataListener.get().onRecordRawPcmData(bArr, j2, i2, i3, i4, false);
        }
        AppMethodBeat.o(221883);
    }

    public static void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(221884);
        if (!(mAudioCaptureDataListener == null || mAudioCaptureDataListener.get() == null)) {
            mAudioCaptureDataListener.get().onRecordPcmData(bArr, j2, i2, i3, i4);
        }
        AppMethodBeat.o(221884);
    }

    public static void onRecordEncData(byte[] bArr, long j2, int i2, int i3) {
        AppMethodBeat.i(221885);
        if (!(mAudioCaptureDataListener == null || mAudioCaptureDataListener.get() == null)) {
            mAudioCaptureDataListener.get().onRecordEncData(bArr, j2, i2, i3, 16);
        }
        AppMethodBeat.o(221885);
    }

    public static void onRecordError(int i2, String str) {
        AppMethodBeat.i(221886);
        TXCLog.e(TAG, "onRecordError: " + i2 + ", " + str);
        if (!(mAudioCaptureDataListener == null || mAudioCaptureDataListener.get() == null)) {
            mAudioCaptureDataListener.get().onRecordError(i2, str);
        }
        AppMethodBeat.o(221886);
    }

    public static void onEvent(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(221887);
        TXCAudioEngine.getInstance().onEvent(str, i2, str2, str3);
        AppMethodBeat.o(221887);
    }

    public static void onError(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(221888);
        TXCAudioEngine.getInstance().onError(str, i2, str2, str3);
        AppMethodBeat.o(221888);
    }

    public static void onLocalAudioWriteFail() {
        AppMethodBeat.i(221889);
        if (mAudioDumpingListener != null) {
            mAudioDumpingListener.onLocalAudioWriteFailed();
        }
        AppMethodBeat.o(221889);
    }

    public static void SetAudioDumpingListener(a aVar) {
        mAudioDumpingListener = aVar;
    }

    public static void InitTraeEngineLibrary(Context context) {
        AppMethodBeat.i(221890);
        if (context == null) {
            TXCLog.e(TAG, "InitTraeEngineLibrary failed, context is null!");
            AppMethodBeat.o(221890);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            String str2 = applicationInfo.dataDir + "/lib";
            String str3 = "/data/data/" + applicationInfo.packageName + "/lib";
            String g2 = f.g();
            if (g2 == null) {
                g2 = "";
            }
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str)));
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str2)));
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(str3)));
            nativeAppendLibraryPath("add_libpath:".concat(String.valueOf(g2)));
            AppMethodBeat.o(221890);
        } catch (UnsatisfiedLinkError e2) {
            TXCLog.e(TAG, "init trae engine library failed.", e2);
            AppMethodBeat.o(221890);
        }
    }

    public static boolean nativeCheckTraeEngine(Context context) {
        boolean z;
        AppMethodBeat.i(221891);
        if (context == null) {
            TXCLog.e(TAG, "nativeCheckTraeEngine failed, context is null!");
            AppMethodBeat.o(221891);
            return false;
        } else if (f.a("traeimp-rtmp")) {
            TXCLog.e(TAG, "link traeimp-rtmp success !");
            AppMethodBeat.o(221891);
            return true;
        } else {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String str = applicationInfo.nativeLibraryDir;
            String str2 = applicationInfo.dataDir + "/lib";
            String str3 = "/data/data/" + applicationInfo.packageName + "/lib";
            String g2 = f.g();
            if (g2 == null) {
                g2 = "";
            }
            if (new File(str + "/libtraeimp-rtmp.so").exists()) {
                z = true;
            } else {
                TXCLog.w(TAG, "nativeCheckTraeEngine load so error " + str + "/libtraeimp-rtmp.so");
                if (new File(str2 + "/libtraeimp-rtmp.so").exists()) {
                    z = true;
                } else {
                    TXCLog.w(TAG, "nativeCheckTraeEngine load so error " + str2 + "/libtraeimp-rtmp.so");
                    if (new File(str3 + "/libtraeimp-rtmp.so").exists()) {
                        z = true;
                    } else {
                        TXCLog.w(TAG, "nativeCheckTraeEngine load so error " + str3 + "/libtraeimp-rtmp.so");
                        if (new File(g2 + "/libtraeimp-rtmp.so").exists()) {
                            z = true;
                        } else {
                            TXCLog.w(TAG, "nativeCheckTraeEngine load so error " + g2 + "/libtraeimp-rtmp.so");
                            z = false;
                        }
                    }
                }
            }
            if (z) {
                AppMethodBeat.o(221891);
                return true;
            }
            TXCLog.e(TAG, "nativeCheckTraeEngine failed, can not find trae libs !");
            AppMethodBeat.o(221891);
            return false;
        }
    }

    public static void pauseAudioCapture(boolean z) {
        AppMethodBeat.i(221892);
        nativePauseAudioCapture(z);
        AppMethodBeat.o(221892);
    }

    public static void resumeAudioCapture() {
        AppMethodBeat.i(221893);
        nativeResumeAudioCapture();
        AppMethodBeat.o(221893);
    }

    public static void sendCustomPCMData(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(221894);
        nativeSendCustomPCMData(bArr, bArr.length, 0, i2, i3);
        AppMethodBeat.o(221894);
    }

    public static void sendCustomPCMData(com.tencent.liteav.basic.structs.a aVar) {
        AppMethodBeat.i(221895);
        nativeSendCustomPCMData(aVar.f425f, aVar.f425f.length, aVar.f424e, aVar.f420a, aVar.f421b);
        AppMethodBeat.o(221895);
    }

    public static StatusBucket getStatus(int i2) {
        AppMethodBeat.i(221896);
        StatusBucket nativeGetStatus = nativeGetStatus(i2);
        AppMethodBeat.o(221896);
        return nativeGetStatus;
    }
}
