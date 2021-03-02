package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCLiveBGMPlayer";
    private int mBGMId;
    private final Handler mHandler;
    private boolean mIsPause;
    private boolean mIsRunning;
    private WeakReference<f> mWeakListener;

    static {
        AppMethodBeat.i(16236);
        f.f();
        AppMethodBeat.o(16236);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static TXCLiveBGMPlayer f155a = new TXCLiveBGMPlayer();

        static {
            AppMethodBeat.i(222006);
            AppMethodBeat.o(222006);
        }

        public static TXCLiveBGMPlayer a() {
            return f155a;
        }
    }

    public static TXCLiveBGMPlayer getInstance() {
        AppMethodBeat.i(16222);
        TXCLiveBGMPlayer a2 = a.a();
        AppMethodBeat.o(16222);
        return a2;
    }

    private TXCLiveBGMPlayer() {
        AppMethodBeat.i(221840);
        this.mIsRunning = false;
        this.mIsPause = false;
        this.mWeakListener = null;
        this.mBGMId = Integer.MAX_VALUE;
        this.mHandler = new Handler(Looper.getMainLooper());
        AppMethodBeat.o(221840);
    }

    public synchronized void setOnPlayListener(f fVar) {
        AppMethodBeat.i(16223);
        if (fVar == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference<>(fVar);
        AppMethodBeat.o(16223);
    }

    public boolean startPlay(String str) {
        AppMethodBeat.i(16224);
        if (str == null || str.isEmpty()) {
            TXCLog.e(TAG, "start live bgm failed! invalid params!");
            AppMethodBeat.o(16224);
            return false;
        }
        this.mIsRunning = true;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, str);
        audioMusicParam.publish = true;
        audioMusicParam.loopCount = 0;
        boolean startPlayMusic = TXAudioEffectManagerImpl.getInstance().startPlayMusic(audioMusicParam);
        TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, this);
        if (!startPlayMusic) {
            onPlayEnd(-1);
            AppMethodBeat.o(16224);
            return false;
        }
        TXCLog.i(TAG, "start bgm play : filePath = ".concat(String.valueOf(str)));
        AppMethodBeat.o(16224);
        return true;
    }

    public boolean stopPlay() {
        AppMethodBeat.i(16225);
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, null);
        TXAudioEffectManagerImpl.getInstance().stopPlayMusic(this.mBGMId);
        this.mIsPause = false;
        TXCLog.i(TAG, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(16225);
        return true;
    }

    public void stopAll() {
        AppMethodBeat.i(221841);
        TXAudioEffectManagerImpl.getInstance().stopAllMusics();
        TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
        TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
        AppMethodBeat.o(221841);
    }

    public boolean isRunning() {
        return this.mIsRunning && !this.mIsPause;
    }

    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public boolean pause() {
        AppMethodBeat.i(16226);
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        TXAudioEffectManagerImpl.getInstance().pausePlayMusic(this.mBGMId);
        AppMethodBeat.o(16226);
        return true;
    }

    public boolean resume() {
        AppMethodBeat.i(16227);
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        TXAudioEffectManagerImpl.getInstance().resumePlayMusic(this.mBGMId);
        AppMethodBeat.o(16227);
        return true;
    }

    public boolean setVolume(float f2) {
        AppMethodBeat.i(16228);
        TXCLog.i(TAG, r.NAME);
        TXAudioEffectManagerImpl.getInstance().setMusicVolume(this.mBGMId, (int) (100.0f * f2));
        AppMethodBeat.o(16228);
        return true;
    }

    public boolean setPlayoutVolume(float f2) {
        AppMethodBeat.i(221842);
        TXCLog.i(TAG, "setPlayoutVolume:".concat(String.valueOf(f2)));
        TXAudioEffectManagerImpl.getInstance().setMusicPlayoutVolume(this.mBGMId, (int) (100.0f * f2));
        AppMethodBeat.o(221842);
        return true;
    }

    public boolean setPublishVolume(float f2) {
        AppMethodBeat.i(221843);
        TXAudioEffectManagerImpl.getInstance().setMusicPublishVolume(this.mBGMId, (int) (100.0f * f2));
        AppMethodBeat.o(221843);
        return true;
    }

    public int getBGMDuration(String str) {
        AppMethodBeat.i(16229);
        int musicDurationInMS = (int) TXAudioEffectManagerImpl.getInstance().getMusicDurationInMS(str);
        AppMethodBeat.o(16229);
        return musicDurationInMS;
    }

    public long getBGMGetCurrentProgressInMs(String str) {
        AppMethodBeat.i(221844);
        if (str == null) {
            long musicCurrentPosInMS = TXAudioEffectManagerImpl.getInstance().getMusicCurrentPosInMS(this.mBGMId);
            AppMethodBeat.o(221844);
            return musicCurrentPosInMS;
        }
        AppMethodBeat.o(221844);
        return 0;
    }

    public void setBGMPosition(int i2) {
        AppMethodBeat.i(221845);
        TXAudioEffectManagerImpl.getInstance().seekMusicToPosInMS(this.mBGMId, i2);
        AppMethodBeat.o(221845);
    }

    public void setPitch(float f2) {
        AppMethodBeat.i(16231);
        TXAudioEffectManagerImpl.getInstance().setMusicPitch(this.mBGMId, f2);
        AppMethodBeat.o(16231);
    }

    private void onPlayStart(int i2) {
        AppMethodBeat.i(221846);
        final f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(221846);
                throw th;
            }
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXCLiveBGMPlayer.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(16280);
                if (fVar != null) {
                    fVar.onPlayStart();
                }
                AppMethodBeat.o(16280);
            }
        });
        AppMethodBeat.o(221846);
    }

    private void onPlayEnd(final int i2) {
        AppMethodBeat.i(16233);
        final f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(16233);
                throw th;
            }
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXCLiveBGMPlayer.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(16330);
                if (fVar != null) {
                    fVar.onPlayEnd(i2);
                }
                AppMethodBeat.o(16330);
            }
        });
        AppMethodBeat.o(16233);
    }

    private void onPlayProgress(final long j2, final long j3) {
        AppMethodBeat.i(16234);
        final f fVar = null;
        synchronized (this) {
            try {
                if (this.mWeakListener != null) {
                    fVar = this.mWeakListener.get();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(16234);
                throw th;
            }
        }
        this.mHandler.post(new Runnable() {
            /* class com.tencent.liteav.audio.TXCLiveBGMPlayer.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(221788);
                if (fVar != null) {
                    fVar.onPlayProgress(j2, j3);
                }
                AppMethodBeat.o(221788);
            }
        });
        AppMethodBeat.o(16234);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onPlayProgress(int i2, long j2, long j3) {
        AppMethodBeat.i(221847);
        onPlayProgress(j2, j3);
        AppMethodBeat.o(221847);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onStart(int i2, int i3) {
        AppMethodBeat.i(221848);
        onPlayStart(i3);
        AppMethodBeat.o(221848);
    }

    @Override // com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver
    public void onComplete(int i2, int i3) {
        AppMethodBeat.i(221849);
        onPlayEnd(i3);
        AppMethodBeat.o(221849);
    }
}
