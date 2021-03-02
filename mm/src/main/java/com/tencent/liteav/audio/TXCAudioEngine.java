package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class TXCAudioEngine implements b {
    private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
    private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
    private static final String TAG = "AudioEngine :TXCAudioEngine_java";
    private static volatile boolean has_init = false;
    private static boolean has_trae = false;
    private static WeakReference<d> mAudioCoreDataListener = null;
    protected static Context mContext = null;
    protected static final HashMap<String, WeakReference<d>> mJitterDataListenerMap = new HashMap<>();
    private static final Object mJitterDataListenerMapLock = new Object();
    protected static final HashMap<String, WeakReference<c>> mJitterEventListenerMap = new HashMap<>();
    private static final Object mJitterEventListenerMapLock = new Object();
    static TXCAudioEngine sInstance = new TXCAudioEngine();
    private final ArrayList<WeakReference<a>> mCallbackList = new ArrayList<>();
    protected boolean mDeviceIsRecording = false;
    protected boolean mIsCallComed = false;
    protected boolean mIsCustomRecord = false;

    static {
        AppMethodBeat.i(222005);
        AppMethodBeat.o(222005);
    }

    public static TXCAudioEngine getInstance() {
        return sInstance;
    }

    private TXCAudioEngine() {
        AppMethodBeat.i(221933);
        AppMethodBeat.o(221933);
    }

    public static synchronized void CreateInstance(Context context, String str) {
        synchronized (TXCAudioEngine.class) {
            AppMethodBeat.i(221934);
            CreateInstanceWithoutInitDevice(context, str);
            TXCAudioEngineJNI.nativeInitAudioDevice();
            AppMethodBeat.o(221934);
        }
    }

    public static synchronized void CreateInstanceWithoutInitDevice(Context context, String str) {
        boolean z = true;
        synchronized (TXCAudioEngine.class) {
            AppMethodBeat.i(221935);
            TXCLog.i(TAG, "CreateInstance: ");
            mContext = context.getApplicationContext();
            if (has_init) {
                TXCLog.i(TAG, "CreateInstance already created~ ");
                AppMethodBeat.o(221935);
            } else {
                if (TXCAudioEngineJNI.nativeCheckTraeEngine(context)) {
                    has_trae = true;
                }
                if (has_trae) {
                    z = false;
                }
                TXCAudioEngineJNI.nativeUseSysAudioDevice(z);
                if (has_trae) {
                    TXCAudioEngineJNI.InitTraeEngineLibrary(context);
                    TXCAudioEngineJNI.nativeSetTRAEConfig(str);
                    TXCAudioEngineJNI.nativeInitBeforeEngineCreate(context);
                    com.tencent.liteav.audio.impl.a.a().a(context.getApplicationContext());
                    com.tencent.liteav.audio.impl.a.a().a(sInstance);
                    TXCAudioEngineJNI.nativeNewAudioSessionDuplicate(mContext);
                } else {
                    TXCMultAudioTrackPlayer.getInstance();
                    TXCAudioSysRecord.getInstance();
                }
                has_init = true;
                AppMethodBeat.o(221935);
            }
        }
    }

    public static boolean hasTrae() {
        return has_trae;
    }

    public static boolean enableAudioVolumeEvaluation(boolean z, int i2) {
        AppMethodBeat.i(221936);
        TXCLog.i(TAG, "enableAudioVolumeEvaluation : " + z + "interval:" + i2);
        TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(z, i2);
        AppMethodBeat.o(221936);
        return true;
    }

    public void UnInitAudioDevice() {
        AppMethodBeat.i(259859);
        TXCAudioEngineJNI.nativeUnInitAudioDevice();
        AppMethodBeat.o(259859);
    }

    public void setAudioQuality(int i2, int i3) {
        AppMethodBeat.i(221937);
        TXCAudioEngineJNI.nativeSetAudioQuality(i2, i3);
        AppMethodBeat.o(221937);
    }

    public void setEncoderSampleRate(int i2) {
        AppMethodBeat.i(221938);
        TXCAudioEngineJNI.nativeSetEncoderSampleRate(i2);
        AppMethodBeat.o(221938);
    }

    public void setEncoderChannels(int i2) {
        AppMethodBeat.i(221939);
        TXCAudioEngineJNI.nativeSetEncoderChannels(i2);
        AppMethodBeat.o(221939);
    }

    public int getEncoderSampleRate() {
        AppMethodBeat.i(221940);
        int nativeGetEncoderSampleRate = TXCAudioEngineJNI.nativeGetEncoderSampleRate();
        AppMethodBeat.o(221940);
        return nativeGetEncoderSampleRate;
    }

    public int getEncoderChannels() {
        AppMethodBeat.i(221941);
        int nativeGetEncoderChannels = TXCAudioEngineJNI.nativeGetEncoderChannels();
        AppMethodBeat.o(221941);
        return nativeGetEncoderChannels;
    }

    public TXCAudioEncoderConfig getAudioEncoderConfig() {
        AppMethodBeat.i(221942);
        TXCAudioEncoderConfig nativeGetEncoderConfig = TXCAudioEngineJNI.nativeGetEncoderConfig();
        AppMethodBeat.o(221942);
        return nativeGetEncoderConfig;
    }

    public int startLocalAudio(int i2, boolean z) {
        AppMethodBeat.i(221943);
        TXCLog.i(TAG, "startLocalAudio audioFormat:".concat(String.valueOf(i2)));
        if (mContext == null) {
            TXCLog.i(TAG, "Please call CreateInstance fisrt!!!");
            AppMethodBeat.o(221943);
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        TXCAudioEngineJNI.InitTraeEngineLibrary(mContext);
        TXCAudioEngineJNI.nativeStartLocalAudio(i2, z);
        this.mDeviceIsRecording = true;
        AppMethodBeat.o(221943);
        return 0;
    }

    public int stopLocalAudio() {
        AppMethodBeat.i(221944);
        TXCLog.i(TAG, "stopLocalAudio");
        TXCAudioEngineJNI.nativeStopLocalAudio();
        this.mDeviceIsRecording = false;
        AppMethodBeat.o(221944);
        return 0;
    }

    public void pauseLocalAudio() {
        AppMethodBeat.i(221945);
        TXCAudioEngineJNI.nativePauseLocalAudio();
        AppMethodBeat.o(221945);
    }

    public void resumeLocalAudio() {
        AppMethodBeat.i(221946);
        TXCAudioEngineJNI.nativeResumeLocalAudio();
        AppMethodBeat.o(221946);
    }

    public void EnableMixMode(boolean z) {
        AppMethodBeat.i(221947);
        TXCAudioEngineJNI.nativeEnableMixMode(z);
        AppMethodBeat.o(221947);
    }

    public void enableEncodedDataPackWithTRAEHeaderCallback(boolean z) {
        AppMethodBeat.i(221948);
        TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(z);
        AppMethodBeat.o(221948);
    }

    public void enableEncodedDataCallback(boolean z) {
        AppMethodBeat.i(221949);
        TXCAudioEngineJNI.nativeEnableEncodedDataCallback(z);
        AppMethodBeat.o(221949);
    }

    public int pauseAudioCapture(boolean z) {
        AppMethodBeat.i(221950);
        TXCLog.i(TAG, "pauseAudioCapture: ".concat(String.valueOf(z)));
        TXCAudioEngineJNI.pauseAudioCapture(z);
        AppMethodBeat.o(221950);
        return 0;
    }

    public int resumeAudioCapture() {
        AppMethodBeat.i(221951);
        TXCLog.i(TAG, "resumeRecord");
        TXCAudioEngineJNI.resumeAudioCapture();
        AppMethodBeat.o(221951);
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(221952);
        TXCAudioEngineJNI.sendCustomPCMData(bArr, i2, i3);
        AppMethodBeat.o(221952);
    }

    public void sendCustomPCMData(com.tencent.liteav.basic.structs.a aVar) {
        AppMethodBeat.i(221953);
        TXCAudioEngineJNI.sendCustomPCMData(aVar);
        AppMethodBeat.o(221953);
    }

    public boolean setAudioCaptureDataListener(e eVar) {
        AppMethodBeat.i(221954);
        TXCLog.i(TAG, "setRecordListener ");
        if (eVar == null) {
            TXCAudioEngineJNI.setAudioCaptureDataListener(null);
        } else {
            TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference(eVar));
        }
        AppMethodBeat.o(221954);
        return true;
    }

    public boolean muteLocalAudio(boolean z) {
        AppMethodBeat.i(221955);
        TXCLog.i(TAG, "setRecordMute: ".concat(String.valueOf(z)));
        TXCAudioEngineJNI.nativeMuteLocalAudio(z);
        AppMethodBeat.o(221955);
        return true;
    }

    public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType) {
        AppMethodBeat.i(221956);
        TXCLog.i(TAG, "setReverbType: " + tXVoiceReverbType.getNativeValue());
        TXCAudioEngineJNI.nativeSetRecordReverb(tXVoiceReverbType.getNativeValue());
        AppMethodBeat.o(221956);
        return true;
    }

    public boolean setSoftwareCaptureVolume(float f2) {
        AppMethodBeat.i(221957);
        TXCLog.i(TAG, "setRecordVolume: ".concat(String.valueOf(f2)));
        TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(f2);
        AppMethodBeat.o(221957);
        return true;
    }

    public boolean setMixingPlayoutVolume(float f2) {
        AppMethodBeat.i(221958);
        TXCLog.i(TAG, "setPlayoutVolume: ".concat(String.valueOf(f2)));
        TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(f2);
        AppMethodBeat.o(221958);
        return true;
    }

    public void enableSoftAEC(boolean z, int i2) {
        AppMethodBeat.i(221959);
        TXCLog.i(TAG, "enableSoftAEC: enable = " + z + " level = " + i2);
        if (!z) {
            i2 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftAEC(i2);
        AppMethodBeat.o(221959);
    }

    public void enableSoftANS(boolean z, int i2) {
        AppMethodBeat.i(221960);
        TXCLog.i(TAG, "enableSoftANS: enable = " + z + " level = " + i2);
        if (!z) {
            i2 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftANS(i2);
        AppMethodBeat.o(221960);
    }

    public void enableSoftAGC(boolean z, int i2) {
        AppMethodBeat.i(221961);
        TXCLog.i(TAG, "enableSoftAGC: enable = " + z + " level = " + i2);
        if (!z) {
            i2 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftAGC(i2);
        AppMethodBeat.o(221961);
    }

    public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType) {
        AppMethodBeat.i(221962);
        TXCLog.i(TAG, "setVoiceChangerType " + tXVoiceChangerType.getNativeValue());
        TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(tXVoiceChangerType.getNativeValue());
        AppMethodBeat.o(221962);
        return true;
    }

    public boolean setEncoderFECPercent(float f2) {
        AppMethodBeat.i(221963);
        TXCAudioEngineJNI.nativeSetEncoderFECPercent(f2);
        AppMethodBeat.o(221963);
        return true;
    }

    public boolean setAudioEncoderParam(int i2, int i3) {
        AppMethodBeat.i(221964);
        TXCAudioEngineJNI.nativeSetAudioEncoderParam(i2, i3);
        AppMethodBeat.o(221964);
        return true;
    }

    public boolean enableCaptureEOSMode(boolean z) {
        AppMethodBeat.i(221965);
        TXCLog.i(TAG, "enableEosMode ".concat(String.valueOf(z)));
        TXCAudioEngineJNI.nativeEnableCaptureEOSMode(z);
        AppMethodBeat.o(221965);
        return true;
    }

    public boolean isAudioDeviceCapturing() {
        AppMethodBeat.i(221966);
        boolean nativeIsAudioDeviceCapturing = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
        TXCLog.i(TAG, "isRecording: ".concat(String.valueOf(nativeIsAudioDeviceCapturing)));
        AppMethodBeat.o(221966);
        return nativeIsAudioDeviceCapturing;
    }

    public int getAECType() {
        return 2;
    }

    public int getSoftwareCaptureVolumeLevel() {
        AppMethodBeat.i(221967);
        int nativeGetSoftwareCaptureVolumeLevel = TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
        AppMethodBeat.o(221967);
        return nativeGetSoftwareCaptureVolumeLevel;
    }

    public void startRemoteAudio(String str, boolean z) {
        AppMethodBeat.i(221968);
        TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, z, str);
        TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(str, c.a().a("Audio", "LIVE_JitterCycle"));
        TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(str, c.a().a("Audio", "LoadingThreshold"));
        AppMethodBeat.o(221968);
    }

    public void stopRemoteAudio(String str) {
        AppMethodBeat.i(221969);
        if (str == null) {
            AppMethodBeat.o(221969);
            return;
        }
        TXCAudioEngineJNI.nativeStopRemoteAudio(str);
        AppMethodBeat.o(221969);
    }

    public void setSetAudioEngineRemoteStreamDataListener(String str, d dVar) {
        AppMethodBeat.i(221970);
        if (str == null) {
            AppMethodBeat.o(221970);
            return;
        }
        synchronized (mJitterDataListenerMapLock) {
            try {
                mJitterDataListenerMap.put(str, new WeakReference<>(dVar));
            } catch (Throwable th) {
                AppMethodBeat.o(221970);
                throw th;
            }
        }
        TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(str, dVar != null);
        AppMethodBeat.o(221970);
    }

    public static void onAudioPlayPcmData(String str, byte[] bArr, long j2, int i2, int i3) {
        AppMethodBeat.i(221971);
        d dVar = null;
        synchronized (mJitterDataListenerMapLock) {
            try {
                if (mJitterDataListenerMap.get(str) != null) {
                    dVar = mJitterDataListenerMap.get(str).get();
                }
            } finally {
                AppMethodBeat.o(221971);
            }
        }
        if (dVar != null) {
            dVar.onAudioPlayPcmData(str, bArr, j2, i2, i3);
        }
    }

    public void setRemoteAudioStreamEventListener(String str, c cVar) {
        AppMethodBeat.i(221972);
        if (str == null) {
            AppMethodBeat.o(221972);
            return;
        }
        synchronized (mJitterEventListenerMapLock) {
            try {
                mJitterEventListenerMap.put(str, new WeakReference<>(cVar));
            } finally {
                AppMethodBeat.o(221972);
            }
        }
    }

    public static void onAudioJitterBufferNotify(String str, int i2, String str2) {
        AppMethodBeat.i(221973);
        c cVar = null;
        synchronized (mJitterEventListenerMapLock) {
            try {
                if (mJitterEventListenerMap.get(str) != null) {
                    cVar = mJitterEventListenerMap.get(str).get();
                }
            } finally {
                AppMethodBeat.o(221973);
            }
        }
        if (cVar != null) {
            TXCLog.i(TAG, "onAudioJitterBufferNotify  cur state ".concat(String.valueOf(i2)));
            cVar.onAudioJitterBufferNotify(str, i2, str2);
        }
    }

    public void setRemoteAudioCacheParams(String str, boolean z, int i2, int i3, int i4) {
        AppMethodBeat.i(221974);
        TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(str, z, i2, i3, i4);
        AppMethodBeat.o(221974);
    }

    public void muteRemoteAudio(String str, boolean z) {
        AppMethodBeat.i(221975);
        if (str == null) {
            AppMethodBeat.o(221975);
            return;
        }
        TXCAudioEngineJNI.nativeMuteRemoteAudio(str, z);
        AppMethodBeat.o(221975);
    }

    public void muteRemoteAudioInSpeaker(String str, boolean z) {
        AppMethodBeat.i(221976);
        if (str == null) {
            AppMethodBeat.o(221976);
            return;
        }
        TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(str, z);
        AppMethodBeat.o(221976);
    }

    public void setRemotePlayoutVolume(String str, int i2) {
        AppMethodBeat.i(221977);
        if (str == null) {
            AppMethodBeat.o(221977);
            return;
        }
        TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(str, i2);
        AppMethodBeat.o(221977);
    }

    public boolean isRemoteAudioPlaying(String str) {
        AppMethodBeat.i(221978);
        if (str == null) {
            AppMethodBeat.o(221978);
            return false;
        }
        boolean nativeIsRemoteAudioPlaying = TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(str);
        AppMethodBeat.o(221978);
        return nativeIsRemoteAudioPlaying;
    }

    public int getRemotePlayoutVolumeLevel(String str) {
        AppMethodBeat.i(221979);
        if (str == null) {
            AppMethodBeat.o(221979);
            return 0;
        }
        int nativeGetRemotePlayoutVolumeLevel = TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(str);
        AppMethodBeat.o(221979);
        return nativeGetRemotePlayoutVolumeLevel;
    }

    public int getPlaySampleRate() {
        return 48000;
    }

    public int getPlayChannels() {
        return 2;
    }

    public int getPlayAECType() {
        if (has_trae) {
            return 2;
        }
        return 0;
    }

    public void addEventCallback(WeakReference<a> weakReference) {
        AppMethodBeat.i(221980);
        if (weakReference == null) {
            AppMethodBeat.o(221980);
            return;
        }
        synchronized (this.mCallbackList) {
            try {
                this.mCallbackList.add(weakReference);
                TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
            } finally {
                AppMethodBeat.o(221980);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r1.hasNext() == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        ((com.tencent.liteav.basic.b.a) r1.next()).onEvent(r6, r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(221981);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEvent(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.TXCAudioEngine.onEvent(java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    private void handleAudioEvent(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(221982);
        if (i2 == EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE) {
            a.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
            AppMethodBeat.o(221982);
            return;
        }
        if (i2 == EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE) {
            a.a().a("timestamp_rollback_to_stable_samplerate", 0);
            TXCLog.i(TAG, "audio device restart when using stable samplerate");
        }
        AppMethodBeat.o(221982);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r1.hasNext() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        ((com.tencent.liteav.basic.b.a) r1.next()).onError(r6, r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(221983);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.TXCAudioEngine.onError(java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    public static void setPlayoutDataListener(d dVar) {
        AppMethodBeat.i(221984);
        mAudioCoreDataListener = new WeakReference<>(dVar);
        TXCAudioEngineJNI.nativeSetPlayoutDataListener(dVar != null);
        AppMethodBeat.o(221984);
    }

    public static void onCorePlayPcmData(byte[] bArr, long j2, int i2, int i3) {
        d dVar;
        AppMethodBeat.i(221985);
        if (!(mAudioCoreDataListener == null || (dVar = mAudioCoreDataListener.get()) == null)) {
            dVar.onAudioPlayPcmData(null, bArr, j2, i2, i3);
        }
        AppMethodBeat.o(221985);
    }

    public static int getMixingPlayoutVolumeLevel() {
        AppMethodBeat.i(221986);
        int nativeGetMixingPlayoutVolumeLevel = TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
        AppMethodBeat.o(221986);
        return nativeGetMixingPlayoutVolumeLevel;
    }

    public StatusBucket getStatus(int i2) {
        AppMethodBeat.i(221987);
        StatusBucket status = TXCAudioEngineJNI.getStatus(i2);
        AppMethodBeat.o(221987);
        return status;
    }

    public static void setAudioRoute(int i2) {
        AppMethodBeat.i(221988);
        TXCLog.i(TAG, "setAudioRoute: ".concat(String.valueOf(i2)));
        TXCAudioEngineJNI.nativeSetAudioRoute(i2);
        AppMethodBeat.o(221988);
    }

    public static void setSystemVolumeType(int i2) {
        AppMethodBeat.i(221989);
        TXCLog.i(TAG, "setSystemVolumeType: ".concat(String.valueOf(i2)));
        TXCAudioEngineJNI.nativeSetSystemVolumeType(i2);
        AppMethodBeat.o(221989);
    }

    public static void enableAudioEarMonitoring(boolean z) {
        AppMethodBeat.i(221990);
        TXCLog.i(TAG, "enableAudioEarMonitoring: ".concat(String.valueOf(z)));
        TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(z);
        AppMethodBeat.o(221990);
    }

    public static void setAudioEarMonitoringVolume(int i2) {
        AppMethodBeat.i(221991);
        TXCLog.i(TAG, "setAudioEarMonitoringVolume: ".concat(String.valueOf(i2)));
        TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(i2);
        AppMethodBeat.o(221991);
    }

    public int startLocalAudioDumping(int i2, int i3, String str) {
        AppMethodBeat.i(221992);
        int nativeStartLocalAudioDumping = TXCAudioEngineJNI.nativeStartLocalAudioDumping(i2, i3, str);
        AppMethodBeat.o(221992);
        return nativeStartLocalAudioDumping;
    }

    public void stopLocalAudioDumping() {
        AppMethodBeat.i(221993);
        TXCAudioEngineJNI.nativeStopLocalAudioDumping();
        AppMethodBeat.o(221993);
    }

    public void setAudioDumpingListener(TXCAudioEngineJNI.a aVar) {
        AppMethodBeat.i(221994);
        TXCAudioEngineJNI.SetAudioDumpingListener(aVar);
        AppMethodBeat.o(221994);
    }

    public void setCaptureDataCallbackFormat(int i2, int i3, int i4) {
        AppMethodBeat.i(221995);
        TXCLog.i(TAG, "setCaptureDataCallbackFormat: sampleRate-" + i2 + " channels-" + i3 + " length-" + i4);
        TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(i2, i3, i4);
        AppMethodBeat.o(221995);
    }

    public void setPlayoutDataCallbackFormat(int i2, int i3, int i4) {
        AppMethodBeat.i(221996);
        TXCLog.i(TAG, "setPlayoutDataCallbackFormat: sampleRate-" + i2 + " channels-" + i3 + " length-" + i4);
        TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(i2, i3, i4);
        AppMethodBeat.o(221996);
    }

    public void setRemoteStreamDataCallbackFormat(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(221997);
        TXCLog.i(TAG, "setRemoteStreamDataCallbackFormat: id-" + str + " sampleRate-" + i2 + " channels-" + i3 + " length-" + i4);
        TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(str, i2, i3, i4);
        AppMethodBeat.o(221997);
    }

    public void clean() {
        AppMethodBeat.i(221998);
        TXCAudioEngineJNI.nativeClean();
        AppMethodBeat.o(221998);
    }

    public void forceCallbackMixedPlayAudioFrame(boolean z) {
        AppMethodBeat.i(221999);
        TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(z);
        AppMethodBeat.o(221999);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.liteav.audio.impl.b
    public void onCallStateChanged(int i2) {
        AppMethodBeat.i(222000);
        switch (i2) {
            case 0:
                TXCLog.i(TAG, "TelephonyManager.CALL_STATE_IDLE!");
                if (this.mIsCallComed) {
                    this.mIsCallComed = false;
                    TXCAudioEngineJNI.resumeAudioCapture();
                    TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
                    break;
                }
                break;
            case 1:
                TXCLog.i(TAG, "TelephonyManager.CALL_STATE_RINGING!");
                AppMethodBeat.o(222000);
                return;
            case 2:
                TXCLog.i(TAG, "TelephonyManager.CALL_STATE_OFFHOOK!");
                TXCAudioEngineJNI.pauseAudioCapture(true);
                TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
                this.mIsCallComed = true;
                AppMethodBeat.o(222000);
                return;
        }
        AppMethodBeat.o(222000);
    }

    public void enableAutoRestartDevice(boolean z) {
        AppMethodBeat.i(222001);
        TXCAudioEngineJNI.nativeEnableAutoRestartDevice(z);
        AppMethodBeat.o(222001);
    }

    public void setMaxSelectedPlayStreams(int i2) {
        AppMethodBeat.i(222002);
        TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(i2);
        AppMethodBeat.o(222002);
    }

    public static String buildTRAEConfig(Context context, Boolean bool, boolean z, long j2) {
        boolean z2;
        AppMethodBeat.i(222003);
        String str = ((("" + "sharp {\n") + "  os android\n") + "  trae {\n") + "    dev {\n";
        if (bool != null) {
            str = str + "  closeOpensl " + (bool.booleanValue() ? "n" : "y") + "\n";
        }
        if (System.currentTimeMillis() - a.a().b("timestamp_rollback_to_stable_samplerate", 0) < j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        TXCLog.i(TAG, "low latency samplerate, enable: %b, isBlocked: %b, blockTime: %d", Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j2));
        if (!z2 && z && getLowLatencySampleRate(context) == 48000) {
            str = ((((((str + "  component 1\n") + "  cap {\n") + "    hw_sr 48000\n") + "  }\n") + "  play {\n") + "    hw_sr 48000\n") + "  }";
        }
        String str2 = ((str + "    }\n") + "  }\n") + "}";
        AppMethodBeat.o(222003);
        return str2;
    }

    private static int getLowLatencySampleRate(Context context) {
        AudioManager audioManager;
        AppMethodBeat.i(222004);
        if (Build.VERSION.SDK_INT >= 17 && (audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) != null) {
            try {
                int parseInt = Integer.parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
                AppMethodBeat.o(222004);
                return parseInt;
            } catch (NumberFormatException e2) {
                TXCLog.e(TAG, "can't parse low latency samplerate", e2);
            }
        }
        AppMethodBeat.o(222004);
        return -1;
    }
}
