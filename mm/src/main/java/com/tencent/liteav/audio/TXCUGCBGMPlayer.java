package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
    private int mBGMId;
    private long mEndTimeMS;
    private boolean mIsRunning;
    private long mSeekBytes;
    private float mSpeedRate;
    private long mStartTimeMS;
    private float mVolume;
    private WeakReference<f> mWeakListener;

    static {
        AppMethodBeat.i(16297);
        f.f();
        AppMethodBeat.o(16297);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static TXCUGCBGMPlayer f157a = new TXCUGCBGMPlayer();

        static {
            AppMethodBeat.i(222008);
            AppMethodBeat.o(222008);
        }

        public static TXCUGCBGMPlayer a() {
            return f157a;
        }
    }

    public static TXCUGCBGMPlayer getInstance() {
        AppMethodBeat.i(16281);
        TXCUGCBGMPlayer a2 = a.a();
        AppMethodBeat.o(16281);
        return a2;
    }

    private TXCUGCBGMPlayer() {
        AppMethodBeat.i(221833);
        this.mWeakListener = null;
        this.mIsRunning = false;
        this.mVolume = 1.0f;
        this.mSpeedRate = 1.0f;
        this.mStartTimeMS = 0;
        this.mEndTimeMS = 0;
        this.mSeekBytes = 0;
        this.mBGMId = Integer.MIN_VALUE;
        TXCMultAudioTrackPlayer.getInstance();
        AppMethodBeat.o(221833);
    }

    public synchronized void setOnPlayListener(f fVar) {
        AppMethodBeat.i(16282);
        if (fVar == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference<>(fVar);
        AppMethodBeat.o(16282);
    }

    public void startPlay(String str, boolean z) {
        AppMethodBeat.i(221834);
        TXCLog.i(TAG, "startPlay:" + str + "record:" + z);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(221834);
            return;
        }
        if (this.mIsRunning) {
            TXCLog.w(TAG, "BGM is playing, restarting...");
            stopPlay();
        }
        this.mSeekBytes = 0;
        this.mIsRunning = true;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, str);
        audioMusicParam.publish = z;
        audioMusicParam.loopCount = 0;
        audioMusicParam.startTimeMS = this.mStartTimeMS;
        audioMusicParam.endTimeMS = this.mEndTimeMS;
        audioMusicParam.isShortFile = true;
        TXCLog.i(TAG, "start bgm play : filePath = " + str + " publish:" + z + " startTimeMS:" + this.mStartTimeMS + " endTimeMS:" + this.mEndTimeMS + " isShortFile:" + audioMusicParam.isShortFile + "mVolume:" + this.mVolume);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int) (this.mVolume * 100.0f));
        TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, this.mSpeedRate);
        if (z) {
            TXAudioEffectManagerImpl.getCacheInstance().setMuteDataDurationToPublish(this.mBGMId, 200);
        }
        boolean startPlayMusic = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(audioMusicParam);
        TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, this);
        if (!startPlayMusic) {
            onPlayEnd(-1);
            AppMethodBeat.o(221834);
            return;
        }
        onPlayStart();
        AppMethodBeat.o(221834);
    }

    public void stopPlay() {
        AppMethodBeat.i(16284);
        TXCLog.i(TAG, "stopPlay");
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, null);
                TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(this.mBGMId);
            } catch (Throwable th) {
                AppMethodBeat.o(16284);
                throw th;
            }
        }
        TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16284);
    }

    public void pause() {
        AppMethodBeat.i(16285);
        TXCLog.i(TAG, "pause");
        TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(this.mBGMId);
        AppMethodBeat.o(16285);
    }

    public void resume() {
        AppMethodBeat.i(16286);
        TXCLog.i(TAG, "resume");
        TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(this.mBGMId);
        AppMethodBeat.o(16286);
    }

    public void setVolume(float f2) {
        AppMethodBeat.i(16287);
        TXCLog.i(TAG, "setVolume:".concat(String.valueOf(f2)));
        this.mVolume = f2;
        TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int) (100.0f * f2));
        AppMethodBeat.o(16287);
    }

    public void setSpeedRate(float f2) {
        AppMethodBeat.i(16288);
        TXCLog.i(TAG, "setSpeedRate:".concat(String.valueOf(f2)));
        this.mSpeedRate = f2;
        TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, f2);
        AppMethodBeat.o(16288);
    }

    public void setChangerType(int i2) {
        AppMethodBeat.i(221835);
        TXCLog.i(TAG, "changerType:".concat(String.valueOf(i2)));
        TXAudioEffectManagerImpl.getCacheInstance().setMusicChangerType(this.mBGMId, i2);
        AppMethodBeat.o(221835);
    }

    public void setReverbType(int i2) {
        AppMethodBeat.i(221836);
        TXCLog.i(TAG, "int reverbType:".concat(String.valueOf(i2)));
        TXAudioEffectManagerImpl.getCacheInstance().setMusicReverbType(this.mBGMId, i2);
        AppMethodBeat.o(221836);
    }

    public void playFromTime(long j2, long j3) {
        AppMethodBeat.i(16289);
        TXCLog.i(TAG, "startPlayRange:" + j2 + ", " + j3);
        this.mStartTimeMS = j2;
        this.mEndTimeMS = j3;
        AppMethodBeat.o(16289);
    }

    public void seekBytes(long j2) {
        AppMethodBeat.i(16290);
        TXCLog.i(TAG, "seekBytes:".concat(String.valueOf(j2)));
        if (j2 < 0) {
            TXCLog.e(TAG, "seek bytes can not be negative. change to 0");
            j2 = 0;
        }
        this.mSeekBytes = j2;
        TXAudioEffectManagerImpl.getCacheInstance().seekMusicToPosInBytes(this.mBGMId, j2);
        AppMethodBeat.o(16290);
    }

    public long getDurationMS(String str) {
        AppMethodBeat.i(16292);
        long musicDurationInMS = TXAudioEffectManagerImpl.getCacheInstance().getMusicDurationInMS(str);
        AppMethodBeat.o(16292);
        return musicDurationInMS;
    }

    private void onPlayStart() {
        AppMethodBeat.i(16293);
        f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } finally {
                AppMethodBeat.o(16293);
            }
        }
        if (fVar != null) {
            fVar.onPlayStart();
        }
    }

    private void onPlayEnd(int i2) {
        AppMethodBeat.i(16294);
        f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } finally {
                AppMethodBeat.o(16294);
            }
        }
        if (fVar != null) {
            fVar.onPlayEnd(i2);
        }
    }

    private void onPlayProgress(long j2, long j3) {
        AppMethodBeat.i(16295);
        f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } finally {
                AppMethodBeat.o(16295);
            }
        }
        if (fVar != null) {
            fVar.onPlayProgress(j2, j3);
        }
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i2, long j2, long j3) {
        AppMethodBeat.i(221837);
        onPlayProgress(j2, j3);
        AppMethodBeat.o(221837);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i2, int i3) {
        AppMethodBeat.i(221838);
        onPlayStart();
        AppMethodBeat.o(221838);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i2, int i3) {
        AppMethodBeat.i(221839);
        onPlayEnd(i3);
        AppMethodBeat.o(221839);
    }
}
