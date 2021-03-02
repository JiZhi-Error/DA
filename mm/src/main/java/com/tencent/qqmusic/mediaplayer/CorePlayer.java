package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.tav.core.AssetExtension;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
public class CorePlayer implements BaseDecodeDataComponent.HandleDecodeDataCallback, Runnable {
    private static final AtomicInteger PLAYER_ID_CREATOR = new AtomicInteger(0);
    private static final String TAG = "CorePlayer";
    private final PlayerCallback mCallback;
    private IDataSource mDataSource;
    private final BaseDecoder mDecoder;
    private final Handler mEventHandler;
    private final QMThreadExecutor mExecutor;
    protected AudioInformation mInformation;
    volatile boolean mIsExit = false;
    private INativeDataSource mNativeDataSource;
    private BaseDecodeDataComponent mPcmCompnent;
    private String mPlayPath = null;
    private int mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    private int mPlayerMode = 0;
    private Float mSpeedToSet = null;
    private final PlayerStateRunner mStateRunner = new PlayerStateRunner(0);
    private String mThreadName = "Unnamed";
    private PerformanceTracer performanceTracer = null;

    static {
        AppMethodBeat.i(76711);
        AppMethodBeat.o(76711);
    }

    CorePlayer(IDataSource iDataSource, INativeDataSource iNativeDataSource, PlayerCallback playerCallback, Looper looper, BaseDecoder baseDecoder, QMThreadExecutor qMThreadExecutor) {
        AppMethodBeat.i(76677);
        if (iDataSource != null && iNativeDataSource != null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
            AppMethodBeat.o(76677);
            throw illegalArgumentException;
        } else if (iDataSource == null && iNativeDataSource == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("at least on data source is required!");
            AppMethodBeat.o(76677);
            throw illegalArgumentException2;
        } else {
            this.mEventHandler = new Handler(looper);
            this.mDecoder = baseDecoder;
            this.mDataSource = iDataSource;
            this.mNativeDataSource = iNativeDataSource;
            this.mCallback = playerCallback;
            this.mStateRunner.transfer(1);
            this.mExecutor = qMThreadExecutor;
            AppMethodBeat.o(76677);
        }
    }

    /* access modifiers changed from: package-private */
    public void setSpeed(float f2) {
        AppMethodBeat.i(175612);
        if (this.mPcmCompnent == null) {
            this.mSpeedToSet = Float.valueOf(f2);
            AppMethodBeat.o(175612);
            return;
        }
        this.mPcmCompnent.setSpeed(f2);
        AppMethodBeat.o(175612);
    }

    /* access modifiers changed from: package-private */
    public float getSpeed() {
        AppMethodBeat.i(190287);
        float f2 = 1.0f;
        if (this.mPcmCompnent != null) {
            f2 = this.mPcmCompnent.getSpeed();
        } else if (this.mSpeedToSet != null) {
            f2 = this.mSpeedToSet.floatValue();
        }
        AppMethodBeat.o(190287);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public void setThreadName(String str) {
        this.mThreadName = str;
    }

    private void exitNotCallback() {
        AppMethodBeat.i(76678);
        Logger.i(TAG, axiliary("exitNotCallback"));
        this.mIsExit = true;
        AppMethodBeat.o(76678);
    }

    /* access modifiers changed from: package-private */
    public void changePlayThreadPriorityImmediately() {
        AppMethodBeat.i(76679);
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76679);
            return;
        }
        this.mPcmCompnent.changePlayThreadPriorityImmediately();
        AppMethodBeat.o(76679);
    }

    private boolean isPathExternalStorage(String str) {
        AppMethodBeat.i(76680);
        if (str.contains("emulated/0") || str.contains("sdcard0")) {
            AppMethodBeat.o(76680);
            return false;
        }
        AppMethodBeat.o(76680);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:141:0x0411  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x023b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 1330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.CorePlayer.run():void");
    }

    private void callExceptionCallback(int i2, int i3) {
        AppMethodBeat.i(76682);
        callExceptionCallback(i2, i3, 0);
        AppMethodBeat.o(76682);
    }

    private void callExceptionCallback(int i2, int i3, int i4) {
        AppMethodBeat.i(76683);
        this.mCallback.playerException(this, i2, i3, i4);
        AppMethodBeat.o(76683);
    }

    private String axiliary(String str) {
        AppMethodBeat.i(76684);
        String str2 = "ID: " + this.mPlayerID + ". " + str;
        AppMethodBeat.o(76684);
        return str2;
    }

    private void decodeEndOrFailed(int i2, int i3) {
        int i4 = 68;
        AppMethodBeat.i(76685);
        Logger.d(TAG, axiliary("decodeEndOrFailed"));
        try {
            if (this.mPcmCompnent == null) {
                Logger.e(TAG, axiliary("mPcmCompnent null! Exiting"));
                AppMethodBeat.o(76685);
                return;
            }
            if (this.mInformation != null) {
                Logger.i(TAG, axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess()))));
                i2 &= this.mDecoder.getErrorCodeMask();
            }
            if (this.mIsExit || !this.mPcmCompnent.hasDecodeDataSuccess()) {
                Logger.i(TAG, axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
                exitNotCallback();
                this.mStateRunner.transfer(9);
                if (TextUtils.isEmpty(this.mPlayPath) || !isPathExternalStorage(this.mPlayPath)) {
                    i4 = 67;
                }
                callExceptionCallback(i3, i4, i2);
                AppMethodBeat.o(76685);
            } else if (getCurPositionByDecoder() < getDuration() - 5000) {
                Logger.e(TAG, axiliary("Decode failed! Exiting."));
                if (TextUtils.isEmpty(this.mPlayPath) || !isPathExternalStorage(this.mPlayPath)) {
                    i4 = 67;
                }
                callExceptionCallback(i3, i4, i2);
                this.mStateRunner.transfer(6);
                AppMethodBeat.o(76685);
            } else {
                if (i3 == 92) {
                    Logger.i(TAG, axiliary("Decode ended! Exiting."));
                    this.mStateRunner.transfer(7);
                }
                AppMethodBeat.o(76685);
            }
        } catch (Throwable th) {
            Logger.e(TAG, th);
            AppMethodBeat.o(76685);
        }
    }

    public void setLeastCommonMultiple(int i2) {
        AppMethodBeat.i(175613);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.setLeastCommonMultiple(i2);
        }
        AppMethodBeat.o(175613);
    }

    /* access modifiers changed from: package-private */
    public long getDuration() {
        AppMethodBeat.i(76686);
        if (this.mInformation != null) {
            try {
                long duration = this.mInformation.getDuration();
                AppMethodBeat.o(76686);
                return duration;
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
        }
        AppMethodBeat.o(76686);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getPlayerState() {
        AppMethodBeat.i(76687);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76687);
            return 0;
        }
        int playerState = this.mPcmCompnent.getPlayerState();
        AppMethodBeat.o(76687);
        return playerState;
    }

    /* access modifiers changed from: package-private */
    public long getCurPosition() {
        AppMethodBeat.i(76688);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76688);
            return 0;
        }
        long curPosition = this.mPcmCompnent.getCurPosition();
        AppMethodBeat.o(76688);
        return curPosition;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasDecodeData() {
        boolean hasDecodeData;
        AppMethodBeat.i(76689);
        if (this.mPcmCompnent == null) {
            hasDecodeData = false;
            AppMethodBeat.o(76689);
        } else {
            hasDecodeData = this.mPcmCompnent.hasDecodeData();
            AppMethodBeat.o(76689);
        }
        return hasDecodeData;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasDecodeDataSuccess() {
        boolean hasDecodeDataSuccess;
        AppMethodBeat.i(76690);
        if (this.mPcmCompnent == null) {
            hasDecodeDataSuccess = false;
            AppMethodBeat.o(76690);
        } else {
            hasDecodeDataSuccess = this.mPcmCompnent.hasDecodeDataSuccess();
            AppMethodBeat.o(76690);
        }
        return hasDecodeDataSuccess;
    }

    /* access modifiers changed from: package-private */
    public boolean isInit() {
        AppMethodBeat.i(76691);
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76691);
            return false;
        }
        boolean isInit = this.mPcmCompnent.isInit();
        AppMethodBeat.o(76691);
        return isInit;
    }

    /* access modifiers changed from: package-private */
    public AudioInformation getCurrentAudioInformation() {
        return this.mInformation;
    }

    /* access modifiers changed from: package-private */
    public int getSessionId() {
        AppMethodBeat.i(76692);
        if (this.mPcmCompnent != null) {
            int sessionId = this.mPcmCompnent.getSessionId();
            AppMethodBeat.o(76692);
            return sessionId;
        }
        AppMethodBeat.o(76692);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void addAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(76693);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.addAudioListener(iAudioListener);
        }
        AppMethodBeat.o(76693);
    }

    /* access modifiers changed from: package-private */
    public void removeAudioListener(IAudioListener iAudioListener) {
        AppMethodBeat.i(76694);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.removeAudioListener(iAudioListener);
        }
        AppMethodBeat.o(76694);
    }

    public void prepare() {
        AppMethodBeat.i(76695);
        Logger.i(TAG, axiliary("prepare"));
        this.mStateRunner.transfer(3);
        this.mExecutor.execute(this, null);
        AppMethodBeat.o(76695);
    }

    /* access modifiers changed from: package-private */
    public void play() {
        AppMethodBeat.i(76696);
        Logger.i(TAG, axiliary(AssetExtension.SCENE_PLAY));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76696);
            return;
        }
        this.mPcmCompnent.play();
        AppMethodBeat.o(76696);
    }

    /* access modifiers changed from: package-private */
    public void pause(boolean z) {
        AppMethodBeat.i(76697);
        Logger.i(TAG, axiliary("pause"));
        if (this.mPcmCompnent == null) {
            AppMethodBeat.o(76697);
            return;
        }
        this.mPcmCompnent.pause(z);
        AppMethodBeat.o(76697);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        AppMethodBeat.i(76698);
        Logger.i(TAG, axiliary("stop"));
        if (this.mPcmCompnent == null) {
            exitNotCallback();
            AppMethodBeat.o(76698);
            return;
        }
        this.mPcmCompnent.stop();
        AppMethodBeat.o(76698);
    }

    public void release() {
        AppMethodBeat.i(76699);
        Logger.i(TAG, axiliary("release"));
        this.mEventHandler.removeCallbacksAndMessages(null);
        exitNotCallback();
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.releaseNotify();
        }
        this.mStateRunner.transfer(8);
        AppMethodBeat.o(76699);
    }

    /* access modifiers changed from: package-private */
    public void setVolume(float f2, float f3) {
        AppMethodBeat.i(76700);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.setVolume(f2, f3);
        }
        AppMethodBeat.o(76700);
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        AppMethodBeat.i(76701);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.flush();
        }
        AppMethodBeat.o(76701);
    }

    /* access modifiers changed from: package-private */
    public void setAudioStreamType(int i2) {
        AppMethodBeat.i(76702);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.setAudioStreamType(i2);
        }
        AppMethodBeat.o(76702);
    }

    /* access modifiers changed from: package-private */
    public void setPlayerMode(int i2) {
        this.mPlayerMode = i2;
    }

    /* access modifiers changed from: package-private */
    public int getPlayerMode() {
        return this.mPlayerMode;
    }

    public void seek(int i2) {
        AppMethodBeat.i(76703);
        if (this.mPcmCompnent != null) {
            this.mPcmCompnent.seek(i2);
        }
        AppMethodBeat.o(76703);
    }

    /* access modifiers changed from: package-private */
    public SeekTable createSeekTable() {
        AppMethodBeat.i(76704);
        if (this.mDecoder == null) {
            IllegalStateException illegalStateException = new IllegalStateException("please setDataSource before creating seek table!");
            AppMethodBeat.o(76704);
            throw illegalStateException;
        }
        NativeSeekTable nativeSeekTable = new NativeSeekTable(this.mDecoder);
        AppMethodBeat.o(76704);
        return nativeSeekTable;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public int seekTo(int i2) {
        AppMethodBeat.i(76705);
        int seekTo = this.mDecoder.seekTo(i2);
        AppMethodBeat.o(76705);
        return seekTo;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public long getCurPositionByDecoder() {
        AppMethodBeat.i(76706);
        try {
            long currentTime = this.mDecoder.getCurrentTime();
            AppMethodBeat.o(76706);
            return currentTime;
        } catch (SoNotFindException e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(76706);
            return 0;
        } catch (Throwable th) {
            Logger.e(TAG, "Strange Exception!", th);
            AppMethodBeat.o(76706);
            return 0;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public long getMinPcmBufferSize() {
        AppMethodBeat.i(76707);
        long minBufferSize = this.mDecoder.getMinBufferSize();
        AppMethodBeat.o(76707);
        return minBufferSize;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public int pullDecodeData(int i2, byte[] bArr) {
        AppMethodBeat.i(76708);
        int decodeData = this.mDecoder.decodeData(i2, bArr);
        AppMethodBeat.o(76708);
        return decodeData;
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public void onPullDecodeDataEndOrFailed(int i2, int i3) {
        AppMethodBeat.i(76709);
        decodeEndOrFailed(i2, i3);
        AppMethodBeat.o(76709);
    }

    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.HandleDecodeDataCallback
    public void onAudioTrackChanged(AudioTrack audioTrack) {
        AppMethodBeat.i(76710);
        this.mDecoder.setAudioTrack(audioTrack);
        AppMethodBeat.o(76710);
    }

    public void setPlayPath(String str) {
        this.mPlayPath = str;
    }
}
