package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TXAudioEffectManagerImpl implements TXAudioEffectManager {
    private static final int EFFECT_PLAYER_ID_TYPE = 2;
    private static final int NEW_BGM_PLAYER_ID_TYPE = 1;
    private static final int OLD_BGM_PLAYER_ID_TYPE = 0;
    private static final String TAG = "AudioCenter:TXAudioEffectManager";
    private static final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private static HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mMusicObserverMap = new HashMap<>();
    private final int mIdType;
    private List<Long> mPlayingMusicIDList;

    private static native void nativeClassInit();

    private native long nativeGetCurrentPositionInMs(long j2);

    private static native long nativeGetDurationMSByPath(String str);

    private native void nativePause(long j2);

    private native void nativeResume(long j2);

    private native void nativeSeekToPosition(long j2, long j3);

    private native void nativeSeekToTime(long j2, int i2);

    private native void nativeSetAllVolume(int i2);

    private native void nativeSetChangerType(long j2, int i2);

    private native void nativeSetMuteDataDurationToPublish(long j2, int i2);

    private native void nativeSetPitch(long j2, float f2);

    private native void nativeSetPlayoutSpeedRate(long j2, float f2);

    private native void nativeSetPlayoutVolume(long j2, int i2);

    private native void nativeSetPublishVolume(long j2, int i2);

    private native void nativeSetReverbType(long j2, int i2);

    private native void nativeSetSpeedRate(long j2, float f2);

    private native void nativeSetVolume(long j2, int i2);

    private native boolean nativeStartPlay(long j2, String str, int i2, boolean z, boolean z2);

    private native void nativeStartPlayRange(long j2, long j3, long j4);

    private native void nativeStopPlay(long j2);

    static /* synthetic */ long access$500(int i2, int i3) {
        AppMethodBeat.i(221831);
        long convertIdToInt64 = convertIdToInt64(i2, i3);
        AppMethodBeat.o(221831);
        return convertIdToInt64;
    }

    static {
        AppMethodBeat.i(221832);
        f.f();
        nativeClassInit();
        AppMethodBeat.o(221832);
    }

    /* access modifiers changed from: package-private */
    public static class AudioEffectManagerHolder {
        private static TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(0);

        private AudioEffectManagerHolder() {
        }

        static {
            AppMethodBeat.i(221795);
            AppMethodBeat.o(221795);
        }
    }

    static class AudioEffectManagerCacheHolder {
        private static TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(2);

        private AudioEffectManagerCacheHolder() {
        }

        static {
            AppMethodBeat.i(221853);
            AppMethodBeat.o(221853);
        }
    }

    static class AudioEffectManagerAutoCacheHolder {
        private static TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(1);

        private AudioEffectManagerAutoCacheHolder() {
        }

        static {
            AppMethodBeat.i(221793);
            AppMethodBeat.o(221793);
        }
    }

    public static TXAudioEffectManagerImpl getInstance() {
        AppMethodBeat.i(221796);
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = AudioEffectManagerHolder.INSTANCE;
        AppMethodBeat.o(221796);
        return tXAudioEffectManagerImpl;
    }

    public static TXAudioEffectManagerImpl getCacheInstance() {
        AppMethodBeat.i(221797);
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = AudioEffectManagerCacheHolder.INSTANCE;
        AppMethodBeat.o(221797);
        return tXAudioEffectManagerImpl;
    }

    public static TXAudioEffectManagerImpl getAutoCacheHolder() {
        AppMethodBeat.i(221798);
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = AudioEffectManagerAutoCacheHolder.INSTANCE;
        AppMethodBeat.o(221798);
        return tXAudioEffectManagerImpl;
    }

    private TXAudioEffectManagerImpl(int i2) {
        AppMethodBeat.i(221799);
        this.mPlayingMusicIDList = new ArrayList();
        this.mIdType = i2;
        AppMethodBeat.o(221799);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void enableVoiceEarMonitor(boolean z) {
        AppMethodBeat.i(221800);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioEarMonitoring(z);
        AppMethodBeat.o(221800);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceEarMonitorVolume(int i2) {
        AppMethodBeat.i(221801);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.setAudioEarMonitoringVolume(i2);
        AppMethodBeat.o(221801);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType) {
        AppMethodBeat.i(221802);
        TXCAudioEngine.getInstance().setReverbType(tXVoiceReverbType);
        AppMethodBeat.o(221802);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType tXVoiceChangerType) {
        AppMethodBeat.i(221803);
        TXCAudioEngine.getInstance().setVoiceChangerType(tXVoiceChangerType);
        AppMethodBeat.o(221803);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setVoiceCaptureVolume(int i2) {
        AppMethodBeat.i(221804);
        TXCAudioEngine.getInstance().setSoftwareCaptureVolume(((float) i2) / 100.0f);
        AppMethodBeat.o(221804);
    }

    public void setAudioPlayoutVolume(int i2) {
        AppMethodBeat.i(221805);
        TXCAudioEngine.getInstance().setMixingPlayoutVolume(((float) i2) / 100.0f);
        AppMethodBeat.o(221805);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicObserver(final int i2, final TXAudioEffectManager.TXMusicPlayObserver tXMusicPlayObserver) {
        AppMethodBeat.i(221806);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.liteav.audio.TXAudioEffectManagerImpl.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(221794);
                if (tXMusicPlayObserver == null) {
                    TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, i2)));
                } else {
                    TXAudioEffectManagerImpl.mMusicObserverMap.put(Long.valueOf(TXAudioEffectManagerImpl.access$500(TXAudioEffectManagerImpl.this.mIdType, i2)), tXMusicPlayObserver);
                }
                TXCLog.i(TXAudioEffectManagerImpl.TAG, "setMusicObserver map count: %d", Integer.valueOf(TXAudioEffectManagerImpl.mMusicObserverMap.size()));
                AppMethodBeat.o(221794);
            }
        };
        if (Looper.myLooper() == mMainHandler.getLooper()) {
            r0.run();
            AppMethodBeat.o(221806);
            return;
        }
        mMainHandler.post(r0);
        AppMethodBeat.o(221806);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam audioMusicParam) {
        long j2 = 0;
        AppMethodBeat.i(221807);
        TXCLog.i(TAG, "startPlay");
        long j3 = audioMusicParam.startTimeMS;
        long j4 = audioMusicParam.endTimeMS;
        if (j3 < 0) {
            j3 = 0;
        }
        if (j4 >= 0) {
            j2 = j4;
        }
        long convertIdToInt64 = convertIdToInt64(this.mIdType, audioMusicParam.id);
        if (!this.mPlayingMusicIDList.contains(Long.valueOf(convertIdToInt64))) {
            this.mPlayingMusicIDList.add(Long.valueOf(convertIdToInt64));
        }
        nativeStartPlayRange(convertIdToInt64, j3, j2);
        boolean nativeStartPlay = nativeStartPlay(convertIdToInt64, audioMusicParam.path, audioMusicParam.loopCount, audioMusicParam.publish, audioMusicParam.isShortFile);
        AppMethodBeat.o(221807);
        return nativeStartPlay;
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void stopPlayMusic(int i2) {
        AppMethodBeat.i(221808);
        long convertIdToInt64 = convertIdToInt64(this.mIdType, i2);
        this.mPlayingMusicIDList.remove(Long.valueOf(convertIdToInt64));
        nativeStopPlay(convertIdToInt64);
        AppMethodBeat.o(221808);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void pausePlayMusic(int i2) {
        AppMethodBeat.i(221809);
        long convertIdToInt64 = convertIdToInt64(this.mIdType, i2);
        this.mPlayingMusicIDList.remove(Long.valueOf(convertIdToInt64));
        nativePause(convertIdToInt64);
        AppMethodBeat.o(221809);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void resumePlayMusic(int i2) {
        AppMethodBeat.i(221810);
        long convertIdToInt64 = convertIdToInt64(this.mIdType, i2);
        if (!this.mPlayingMusicIDList.contains(Long.valueOf(convertIdToInt64))) {
            this.mPlayingMusicIDList.add(Long.valueOf(convertIdToInt64));
        }
        nativeResume(convertIdToInt64);
        AppMethodBeat.o(221810);
    }

    public void interruptAllMusics() {
        AppMethodBeat.i(221811);
        TXCLog.i(TAG, "interruptAllMusics");
        for (Long l : this.mPlayingMusicIDList) {
            nativePause(l.longValue());
        }
        AppMethodBeat.o(221811);
    }

    public void recoverAllMusics() {
        AppMethodBeat.i(221812);
        TXCLog.i(TAG, "recoverAllMusics");
        for (Long l : this.mPlayingMusicIDList) {
            nativeResume(l.longValue());
        }
        AppMethodBeat.o(221812);
    }

    public void stopAllMusics() {
        AppMethodBeat.i(221813);
        TXCLog.i(TAG, "stopAllMusics");
        for (Long l : this.mPlayingMusicIDList) {
            final long longValue = l.longValue();
            nativeStopPlay(longValue);
            mMainHandler.post(new Runnable() {
                /* class com.tencent.liteav.audio.TXAudioEffectManagerImpl.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(221792);
                    TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(longValue));
                    AppMethodBeat.o(221792);
                }
            });
        }
        this.mPlayingMusicIDList.clear();
        AppMethodBeat.o(221813);
    }

    public void setMusicVolume(int i2, int i3) {
        AppMethodBeat.i(221814);
        TXCLog.i(TAG, "setMusicVolume ".concat(String.valueOf(i3)));
        nativeSetVolume(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221814);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPublishVolume(int i2, int i3) {
        AppMethodBeat.i(221815);
        nativeSetPublishVolume(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221815);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPlayoutVolume(int i2, int i3) {
        AppMethodBeat.i(221816);
        nativeSetPlayoutVolume(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221816);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setAllMusicVolume(int i2) {
        AppMethodBeat.i(221817);
        nativeSetAllVolume(i2);
        AppMethodBeat.o(221817);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicPitch(int i2, float f2) {
        AppMethodBeat.i(221818);
        nativeSetPitch(convertIdToInt64(this.mIdType, i2), f2);
        AppMethodBeat.o(221818);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void setMusicSpeedRate(int i2, float f2) {
        AppMethodBeat.i(221819);
        nativeSetSpeedRate(convertIdToInt64(this.mIdType, i2), f2);
        AppMethodBeat.o(221819);
    }

    public void setMusicPlayoutSpeedRate(int i2, float f2) {
        AppMethodBeat.i(221820);
        nativeSetPlayoutSpeedRate(convertIdToInt64(this.mIdType, i2), f2);
        AppMethodBeat.o(221820);
    }

    public void setMusicChangerType(int i2, int i3) {
        AppMethodBeat.i(221821);
        nativeSetChangerType(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221821);
    }

    public void setMusicReverbType(int i2, int i3) {
        AppMethodBeat.i(221822);
        nativeSetReverbType(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221822);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicCurrentPosInMS(int i2) {
        AppMethodBeat.i(221823);
        long nativeGetCurrentPositionInMs = nativeGetCurrentPositionInMs(convertIdToInt64(this.mIdType, i2));
        AppMethodBeat.o(221823);
        return nativeGetCurrentPositionInMs;
    }

    public void seekMusicToPosInBytes(int i2, long j2) {
        AppMethodBeat.i(221824);
        nativeSeekToPosition(convertIdToInt64(this.mIdType, i2), j2);
        AppMethodBeat.o(221824);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public void seekMusicToPosInMS(int i2, int i3) {
        AppMethodBeat.i(221825);
        nativeSeekToTime(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221825);
    }

    public void setMuteDataDurationToPublish(int i2, int i3) {
        AppMethodBeat.i(221826);
        nativeSetMuteDataDurationToPublish(convertIdToInt64(this.mIdType, i2), i3);
        AppMethodBeat.o(221826);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager
    public long getMusicDurationInMS(String str) {
        AppMethodBeat.i(221827);
        long nativeGetDurationMSByPath = nativeGetDurationMSByPath(str);
        AppMethodBeat.o(221827);
        return nativeGetDurationMSByPath;
    }

    public static void onEffectFinish(final long j2, final int i2) {
        AppMethodBeat.i(221828);
        mMainHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXAudioEffectManagerImpl.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(222014);
                TXCLog.i(TXAudioEffectManagerImpl.TAG, "onEffectFinish -> effect id = " + j2 + ", errCode = " + i2);
                if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2)) != null) {
                    ((TXAudioEffectManager.TXMusicPlayObserver) TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2))).onComplete((int) j2, i2);
                }
                AppMethodBeat.o(222014);
            }
        });
        AppMethodBeat.o(221828);
    }

    public static void onEffectStart(final long j2, final int i2) {
        AppMethodBeat.i(221829);
        mMainHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXAudioEffectManagerImpl.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(221868);
                TXCLog.i(TXAudioEffectManagerImpl.TAG, "onEffectStart -> effect id = " + j2 + ", errCode = " + i2);
                if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2)) != null) {
                    ((TXAudioEffectManager.TXMusicPlayObserver) TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2))).onStart((int) j2, i2);
                }
                AppMethodBeat.o(221868);
            }
        });
        AppMethodBeat.o(221829);
    }

    public static void onEffectProgress(final long j2, final long j3, final long j4) {
        AppMethodBeat.i(221830);
        mMainHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXAudioEffectManagerImpl.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(222007);
                if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2)) != null) {
                    ((TXAudioEffectManager.TXMusicPlayObserver) TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(j2))).onPlayProgress((int) j2, j3, j4);
                }
                AppMethodBeat.o(222007);
            }
        });
        AppMethodBeat.o(221830);
    }

    private static long convertIdToInt64(int i2, int i3) {
        return (((long) i2) << 32) | ((long) i3);
    }
}
