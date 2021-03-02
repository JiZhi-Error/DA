package com.tencent.qqmusic.mediaplayer;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.tav.core.AssetExtension;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class BaseDecodeDataComponent {
    static final int CALL_PREPARED_DELAY_TIME = 20;
    private static int MAX_PLAY_SAMPLE_RATE = 0;
    private static final String TAG = "BaseDecodeDataComponent";
    final List<IAudioListener> audioEffects = new ArrayList(3);
    boolean isUseFloatForHighDepth = false;
    int mAudioStreamType = getAudioStreamType();
    AudioTrack mAudioTrack;
    int mBuffSize;
    final PlayerCallback mCallback;
    final CorePlayer mCorePlayer;
    boolean mCreateAudioTrackFail = false;
    long mCurPosition = 0;
    final BufferInfo mDecodeBufferInfo = new BufferInfo();
    private final Handler mEventHandler;
    final FloatBufferInfo mFloatBufferInfo = new FloatBufferInfo();
    final HandleDecodeDataCallback mHandleDecodeDataCallback;
    boolean mHasDecode = false;
    boolean mHasDecodeSuccess = false;
    boolean mHasInit = false;
    final AudioInformation mInformation;
    int mLeastCommonMultiple = 1;
    volatile boolean mNeedChangePlayThreadPriority = false;
    private final int mPlayerID;
    final WaitNotify mSignalControl = new WaitNotify();
    Float mSpeedToSet = null;
    final PlayerStateRunner mStateRunner;
    int mTargetBitDepth = 2;
    long mTargetPlaySample;
    final List<IAudioListener> mTerminalAudioEffectList = new ArrayList();
    PerformanceTracer performanceTracer = null;

    /* access modifiers changed from: package-private */
    public interface HandleDecodeDataCallback {
        long getCurPositionByDecoder();

        long getMinPcmBufferSize();

        void onAudioTrackChanged(AudioTrack audioTrack);

        void onPullDecodeDataEndOrFailed(int i2, int i3);

        int pullDecodeData(int i2, byte[] bArr);

        int seekTo(int i2);
    }

    /* access modifiers changed from: package-private */
    public abstract int getAudioStreamType();

    /* access modifiers changed from: package-private */
    public abstract long getCurPosition();

    /* access modifiers changed from: package-private */
    public abstract void handleDecodeData();

    BaseDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i2) {
        this.mCorePlayer = corePlayer;
        this.mStateRunner = playerStateRunner;
        this.mInformation = audioInformation;
        this.mCallback = playerCallback;
        this.mHandleDecodeDataCallback = handleDecodeDataCallback;
        this.mEventHandler = handler;
        this.mPlayerID = i2;
    }

    /* access modifiers changed from: package-private */
    public void setSpeed(float f2) {
        this.mSpeedToSet = Float.valueOf(f2);
    }

    /* access modifiers changed from: package-private */
    public float getSpeed() {
        if (this.mSpeedToSet != null) {
            return this.mSpeedToSet.floatValue();
        }
        if (Build.VERSION.SDK_INT < 23 || this.mAudioTrack == null) {
            return 1.0f;
        }
        return this.mAudioTrack.getPlaybackParams().getSpeed();
    }

    /* access modifiers changed from: package-private */
    public void postRunnable(Runnable runnable, int i2) {
        this.mEventHandler.postDelayed(runnable, (long) i2);
    }

    /* access modifiers changed from: package-private */
    public String axiliary(String str) {
        return "ID: " + this.mPlayerID + ". " + str;
    }

    /* access modifiers changed from: package-private */
    public void changePlayThreadPriorityImmediately() {
        Logger.d(TAG, axiliary("changePlayThreadPriorityImmediately"));
        this.mNeedChangePlayThreadPriority = true;
    }

    /* access modifiers changed from: package-private */
    public void callExceptionCallback(int i2, int i3) {
        callExceptionCallback(i2, i3, 0);
    }

    private void callExceptionCallback(int i2, int i3, int i4) {
        this.mCallback.playerException(this.mCorePlayer, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int getPlayerState() {
        return this.mStateRunner.get().intValue();
    }

    /* access modifiers changed from: package-private */
    public void refreshTimeAndNotify(int i2) {
        if (this.mSignalControl.isWaiting() && isPlaying()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: seek, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* access modifiers changed from: package-private */
    public void seek(int i2) {
    }

    /* access modifiers changed from: package-private */
    public void play() {
        Logger.i(TAG, axiliary(AssetExtension.SCENE_PLAY));
        this.mStateRunner.transfer(4, 5, 2, 6, 4);
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: play, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* access modifiers changed from: package-private */
    public void pause(boolean z) {
        Logger.i(TAG, axiliary("pause"));
        this.mStateRunner.transfer(5, 4, 2);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        Logger.i(TAG, axiliary("stop"));
        if (this.mStateRunner.transfer(6, 4, 5, 2) && this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: stop, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSupportHighBitDepth() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* access modifiers changed from: package-private */
    public int getMaxSupportSampleRate() {
        if (MAX_PLAY_SAMPLE_RATE > 0) {
            return MAX_PLAY_SAMPLE_RATE;
        }
        try {
            Field declaredField = AudioFormat.class.getDeclaredField("SAMPLE_RATE_HZ_MAX");
            declaredField.setAccessible(true);
            MAX_PLAY_SAMPLE_RATE = declaredField.getInt(null);
            Logger.i(TAG, axiliary("get the max sample rate support by system from AudioFormat = " + MAX_PLAY_SAMPLE_RATE));
            return MAX_PLAY_SAMPLE_RATE;
        } catch (Throwable th) {
            Logger.i(TAG, axiliary("can't reflect max sample rate, use default sample rate"));
            if (Build.VERSION.SDK_INT < 21) {
                return 48000;
            }
            if (Build.VERSION.SDK_INT < 22) {
                return 96000;
            }
            return 192000;
        }
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isError() {
        return this.mStateRunner.isEqual(9);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isIdle() {
        return this.mStateRunner.isEqual(0);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isPlaying() {
        return this.mStateRunner.isEqual(4);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isPaused() {
        return this.mStateRunner.isEqual(5);
    }

    /* access modifiers changed from: protected */
    public synchronized boolean isStopped() {
        return this.mStateRunner.isEqual(6);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isCompleted() {
        return this.mStateRunner.isEqual(7);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.stop();
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
            try {
                this.mAudioTrack.flush();
            } catch (Throwable th2) {
                Logger.e(TAG, th2);
            }
            try {
                this.mAudioTrack.release();
            } catch (Throwable th3) {
                Logger.e(TAG, th3);
            }
            try {
                destroyAudioListeners();
            } catch (Throwable th4) {
                Logger.i(TAG, "[run] failed to destroyAudioListeners!", th4);
            }
            setAudioTrack(null);
            Logger.d(TAG, axiliary("finally release audioTrack"));
        }
        if (!this.mCorePlayer.mIsExit) {
            if (this.mStateRunner.isEqual(7)) {
                this.mCallback.playerEnded(this.mCorePlayer);
            } else {
                this.mCallback.playerStopped(this.mCorePlayer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseNotify() {
        if (this.mSignalControl.isWaiting()) {
            Logger.d(TAG, axiliary("lock is Waiting, event: release, doNotify"));
            this.mSignalControl.doNotify();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAudioStreamType(int i2) {
        if (i2 != this.mAudioStreamType) {
            this.mAudioStreamType = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasDecodeData() {
        return this.mHasDecode;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean hasDecodeDataSuccess() {
        return this.mHasDecodeSuccess;
    }

    /* access modifiers changed from: package-private */
    public boolean isInit() {
        return this.mHasInit;
    }

    /* access modifiers changed from: package-private */
    public int getSessionId() {
        if (this.mAudioTrack != null) {
            return this.mAudioTrack.getAudioSessionId();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void setVolume(float f2, float f3) {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.setStereoVolume(f2, f3);
            } catch (IllegalStateException e2) {
                Logger.e(TAG, r.NAME, e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void flush() {
    }

    /* access modifiers changed from: package-private */
    public void handleHighBitDepth(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        if (this.isUseFloatForHighDepth) {
            bufferInfo.fillInto(bufferInfo2);
            return;
        }
        try {
            PcmConvertionUtil.convertBitDepthTo16(bufferInfo, bufferInfo2, this.mInformation.getBitDepth());
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinBufferSize(long j2, int i2, int i3, int i4, int i5) {
        int minBufferSize = AudioTrack.getMinBufferSize((int) j2, i2, i3);
        if (minBufferSize >= 0) {
            return minBufferSize;
        }
        Logger.i(TAG, axiliary("minBufferSize = " + minBufferSize + " mTargetPlaySample = " + j2 + "  channelConfiguration = " + i2 + "   pcmEncoding = " + i3));
        return i4 * 3536 * i5;
    }

    /* access modifiers changed from: package-private */
    public void handleHighSample(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        try {
            PcmConvertionUtil.reSample(bufferInfo, bufferInfo2, this.mInformation.getSampleRate(), this.mTargetPlaySample, this.mTargetBitDepth);
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* access modifiers changed from: package-private */
    public void convertBytePcmToFloatPcm(BufferInfo bufferInfo, FloatBufferInfo floatBufferInfo) {
        try {
            PcmConvertionUtil.convertByteBufferToFloatBuffer(bufferInfo, floatBufferInfo, this.mInformation.getBitDepth());
        } catch (Throwable th) {
            Logger.e(TAG, th);
        }
    }

    /* access modifiers changed from: package-private */
    public void processAudioListeners(BufferInfo bufferInfo, BufferInfo bufferInfo2) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.size() == 0) {
                bufferInfo.fillInto(bufferInfo2);
            } else {
                BufferInfo bufferInfo3 = bufferInfo2;
                BufferInfo bufferInfo4 = bufferInfo;
                for (IAudioListener iAudioListener : this.audioEffects) {
                    if (!iAudioListener.isEnabled()) {
                        bufferInfo4.fillInto(bufferInfo3);
                    } else if (processAudioListener(iAudioListener, bufferInfo4, bufferInfo3, this.mCorePlayer.getCurPositionByDecoder())) {
                        bufferInfo4 = bufferInfo3;
                        bufferInfo3 = bufferInfo4;
                    } else {
                        bufferInfo4.fillInto(bufferInfo3);
                    }
                }
                if (bufferInfo4 == bufferInfo) {
                    bufferInfo.fillInto(bufferInfo2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public long calculatePcmPlayTime(byte[] bArr, int i2, int i3, long j2) {
        if (i2 == 0 || i3 == 0 || j2 == 0) {
            return 0;
        }
        return (long) ((((((float) bArr.length) * 1000.0f) / ((float) i2)) / ((float) i3)) / ((float) j2));
    }

    /* access modifiers changed from: protected */
    public long calculatePcmPlayTime(float[] fArr, int i2, long j2) {
        if (i2 == 0 || j2 == 0) {
            return 0;
        }
        return (long) (((((float) fArr.length) * 1000.0f) / ((float) i2)) / ((float) j2));
    }

    /* access modifiers changed from: package-private */
    public void processAudioListeners(FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.size() == 0) {
                floatBufferInfo.copy(floatBufferInfo2);
            } else {
                FloatBufferInfo floatBufferInfo3 = floatBufferInfo2;
                FloatBufferInfo floatBufferInfo4 = floatBufferInfo;
                for (IAudioListener iAudioListener : this.audioEffects) {
                    if (!iAudioListener.isEnabled()) {
                        floatBufferInfo4.copy(floatBufferInfo3);
                    } else if (processAudioListener(iAudioListener, floatBufferInfo4, floatBufferInfo3, this.mCorePlayer.getCurPositionByDecoder())) {
                        floatBufferInfo4 = floatBufferInfo3;
                        floatBufferInfo3 = floatBufferInfo4;
                    } else {
                        floatBufferInfo4.copy(floatBufferInfo3);
                    }
                }
                if (floatBufferInfo4 == floatBufferInfo) {
                    floatBufferInfo.copy(floatBufferInfo2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addAudioListener(IAudioListener iAudioListener) {
        long j2;
        if (iAudioListener.isTerminal()) {
            synchronized (this.mTerminalAudioEffectList) {
                if (!this.mTerminalAudioEffectList.contains(iAudioListener)) {
                    this.mTerminalAudioEffectList.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] terminal audio added: ".concat(String.valueOf(iAudioListener)));
                }
            }
        } else {
            synchronized (this.audioEffects) {
                if (!this.audioEffects.contains(iAudioListener)) {
                    this.audioEffects.add(iAudioListener);
                    Logger.i(TAG, "[addAudioListener] audio added: ".concat(String.valueOf(iAudioListener)));
                }
            }
        }
        if (this.mInformation == null || this.mInformation.getPlaySample() <= 0 || this.mInformation.getChannels() <= 0) {
            Logger.i(TAG, "[addAudioListener] audio information not ready. init will be delayed.");
            return;
        }
        try {
            j2 = iAudioListener.onPlayerReady(this.mTargetBitDepth, this.mInformation, getCurPosition());
        } catch (Throwable th) {
            Logger.e(TAG, "[addAudioListener] failed to init audio: ".concat(String.valueOf(iAudioListener)), th);
            j2 = 0;
        }
        if (j2 != 0) {
            Logger.e(TAG, "[addAudioListener] failed to init audio %s, ret: %d", iAudioListener, Long.valueOf(j2));
        }
    }

    /* access modifiers changed from: package-private */
    public void initAudioListeners(int i2, AudioInformation audioInformation, long j2) {
        synchronized (this.audioEffects) {
            for (IAudioListener iAudioListener : this.audioEffects) {
                iAudioListener.onPlayerReady(i2, audioInformation, j2);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener iAudioListener2 : this.mTerminalAudioEffectList) {
                iAudioListener2.onPlayerReady(i2, audioInformation, j2);
            }
        }
    }

    private void destroyAudioListeners() {
        synchronized (this.audioEffects) {
            for (IAudioListener iAudioListener : this.audioEffects) {
                iAudioListener.onPlayerStopped();
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener iAudioListener2 : this.mTerminalAudioEffectList) {
                iAudioListener2.onPlayerStopped();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAudioListener(IAudioListener iAudioListener) {
        synchronized (this.audioEffects) {
            if (this.audioEffects.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] audio removed: ".concat(String.valueOf(iAudioListener)));
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            if (this.mTerminalAudioEffectList.remove(iAudioListener)) {
                Logger.i(TAG, "[removeAudioListener] terminal audio removed: ".concat(String.valueOf(iAudioListener)));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifySeekCompleteForAudioListeners(long j2) {
        synchronized (this.audioEffects) {
            for (IAudioListener iAudioListener : this.audioEffects) {
                iAudioListener.onPlayerSeekComplete(j2);
            }
        }
        synchronized (this.mTerminalAudioEffectList) {
            for (IAudioListener iAudioListener2 : this.mTerminalAudioEffectList) {
                iAudioListener2.onPlayerSeekComplete(j2);
            }
        }
    }

    private static boolean processAudioListener(IAudioListener iAudioListener, BufferInfo bufferInfo, BufferInfo bufferInfo2, long j2) {
        try {
            bufferInfo2.setByteBufferCapacity(bufferInfo.bufferSize);
            return iAudioListener.onPcm(bufferInfo, bufferInfo2, j2);
        } catch (Throwable th) {
            Logger.e(TAG, "[processAudioListener] failed. audio: ".concat(String.valueOf(iAudioListener)), th);
            return false;
        }
    }

    private static boolean processAudioListener(IAudioListener iAudioListener, FloatBufferInfo floatBufferInfo, FloatBufferInfo floatBufferInfo2, long j2) {
        try {
            floatBufferInfo2.setFloatBufferCapacity(floatBufferInfo.bufferSize);
            return iAudioListener.onPcm(floatBufferInfo, floatBufferInfo2, j2);
        } catch (Throwable th) {
            Logger.e(TAG, "[processAudioListener] failed. audio: ".concat(String.valueOf(iAudioListener)), th);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void setPerformanceTracer(PerformanceTracer performanceTracer2) {
        this.performanceTracer = performanceTracer2;
    }

    static int getAudioTrackPosition(long j2, AudioTrack audioTrack) {
        long j3 = 0;
        if (audioTrack != null) {
            try {
                j3 = Math.round((((double) (((long) audioTrack.getPlaybackHeadPosition()) + j2)) / ((double) audioTrack.getSampleRate())) * 1000.0d);
            } catch (Exception e2) {
                Logger.e(TAG, "getAudioTrackPosition", e2);
            }
        }
        return (int) j3;
    }

    /* access modifiers changed from: package-private */
    public void doWaitForPaused() {
        this.mSignalControl.doWait(2000, 5, new WaitNotify.WaitListener() {
            /* class com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
            public boolean keepWaiting() {
                AppMethodBeat.i(76569);
                boolean isPaused = BaseDecodeDataComponent.this.isPaused();
                AppMethodBeat.o(76569);
                return isPaused;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setLeastCommonMultiple(int i2) {
        if (i2 <= 0) {
            Logger.e(TAG, "wrong least common multiple: ".concat(String.valueOf(i2)));
        } else {
            this.mLeastCommonMultiple = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAudioTrack(AudioTrack audioTrack) {
        this.mAudioTrack = audioTrack;
        this.mHandleDecodeDataCallback.onAudioTrackChanged(audioTrack);
    }

    static AudioTrack instantiateAudioTrackCompat(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT < 21) {
            return new AudioTrack(i2, i3, i4, i5, i6, i7);
        }
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i2);
        AudioFormat.Builder builder2 = new AudioFormat.Builder();
        builder2.setSampleRate(i3);
        builder2.setEncoding(i5);
        builder2.setChannelMask(i4);
        if (Build.VERSION.SDK_INT >= 23) {
            return new AudioTrack.Builder().setAudioAttributes(builder.build()).setAudioFormat(builder2.build()).setBufferSizeInBytes(i6).setTransferMode(i7).build();
        }
        return new AudioTrack(builder.build(), builder2.build(), i6, i7, 0);
    }
}
