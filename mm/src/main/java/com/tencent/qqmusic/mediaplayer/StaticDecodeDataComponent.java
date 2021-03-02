package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.ArrayList;
import java.util.List;

class StaticDecodeDataComponent extends BaseDecodeDataComponent {
    private static final String TAG = "StaticDecodeDataComponent";
    private int mAllBufferSize;
    private List<BufferInfo> mAllPcmBufferList;
    private boolean mHasTerminal = false;
    private boolean mIsfirstStarted;

    StaticDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i2) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i2);
        this.mBuffSize = 8192;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public int getAudioStreamType() {
        return 3;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public long getCurPosition() {
        AppMethodBeat.i(76741);
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || audioTrack.getState() == 0) {
            long j2 = this.mCurPosition;
            AppMethodBeat.o(76741);
            return j2;
        }
        this.mCurPosition = (long) getAudioTrackPosition(0, audioTrack);
        long j3 = this.mCurPosition;
        AppMethodBeat.o(76741);
        return j3;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void handleDecodeData() {
        AppMethodBeat.i(76742);
        if (this.mInformation != null) {
            try {
                if (0 == this.mInformation.getSampleRate()) {
                    Logger.e(TAG, "failed to getSampleRate");
                    this.mStateRunner.transfer(9);
                    callExceptionCallback(91, 63);
                    AppMethodBeat.o(76742);
                    return;
                }
                this.mHasInit = true;
                if (!decodeAllData()) {
                    Logger.e(TAG, "failed to decodeAllData");
                    this.mStateRunner.transfer(9);
                    AppMethodBeat.o(76742);
                } else if (!createAudioTrack()) {
                    Logger.e(TAG, "failed to createAudioTrack");
                    this.mStateRunner.transfer(9);
                    AppMethodBeat.o(76742);
                } else if (!writeAudioTrack() && !this.mHasTerminal) {
                    Logger.e(TAG, "failed to writeAudioTrack");
                    this.mStateRunner.transfer(9);
                    AppMethodBeat.o(76742);
                } else if (this.mHasTerminal) {
                    this.mStateRunner.transfer(7);
                    AppMethodBeat.o(76742);
                } else {
                    if (!this.mStateRunner.transfer(2, 3)) {
                        Logger.e(TAG, "failed to transfer to PREPARED because cur State is NOT PREPARING!!");
                        AppMethodBeat.o(76742);
                        return;
                    }
                    this.mIsfirstStarted = false;
                    initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
                    postRunnable(new Runnable() {
                        /* class com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(76481);
                            if (StaticDecodeDataComponent.this.getPlayerState() == 8) {
                                Logger.w(StaticDecodeDataComponent.TAG, "[run] state changed to END during postRunnable!");
                                AppMethodBeat.o(76481);
                                return;
                            }
                            StaticDecodeDataComponent.this.mCallback.playerPrepared(StaticDecodeDataComponent.this.mCorePlayer);
                            AppMethodBeat.o(76481);
                        }
                    }, 0);
                    Logger.i(TAG, axiliary("prepared. waiting..."));
                    this.mSignalControl.doWait(20, 100, new WaitNotify.WaitListener() {
                        /* class com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.AnonymousClass2 */

                        @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
                        public boolean keepWaiting() {
                            AppMethodBeat.i(190296);
                            if (StaticDecodeDataComponent.this.getPlayerState() == 2) {
                                AppMethodBeat.o(190296);
                                return true;
                            }
                            AppMethodBeat.o(190296);
                            return false;
                        }
                    });
                    Logger.i(TAG, axiliary("woke after preparing"));
                    playAudioTrack();
                    AppMethodBeat.o(76742);
                }
            } catch (SoNotFindException e2) {
                Logger.e(TAG, e2);
            }
        } else {
            Logger.e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(9);
            callExceptionCallback(91, 63);
            AppMethodBeat.o(76742);
        }
    }

    private boolean decodeAllData() {
        AppMethodBeat.i(76743);
        this.mAllPcmBufferList = new ArrayList();
        while (true) {
            if (this.mCorePlayer.mIsExit) {
                break;
            }
            BufferInfo bufferInfo = new BufferInfo();
            bufferInfo.setByteBufferCapacity(this.mBuffSize);
            try {
                int pullDecodeData = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, bufferInfo.byteBuffer);
                this.mHasDecode = true;
                if (pullDecodeData > 0) {
                    bufferInfo.bufferSize = pullDecodeData;
                    this.mAllPcmBufferList.add(bufferInfo);
                    if (!this.mHasDecodeSuccess) {
                        this.mHasDecodeSuccess = true;
                    }
                } else if (pullDecodeData == 0) {
                    bufferInfo.bufferSize = this.mBuffSize;
                    this.mAllPcmBufferList.add(bufferInfo);
                    Logger.i(TAG, "static decode end");
                } else {
                    this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(pullDecodeData, 91);
                    AppMethodBeat.o(76743);
                    return false;
                }
            } catch (SoNotFindException e2) {
                Logger.e(TAG, e2);
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 62);
                AppMethodBeat.o(76743);
                return false;
            } catch (Throwable th) {
                Logger.e(TAG, th);
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 67);
                AppMethodBeat.o(76743);
                return false;
            }
        }
        if (!this.mAllPcmBufferList.isEmpty()) {
            int i2 = 0;
            for (BufferInfo bufferInfo2 : this.mAllPcmBufferList) {
                i2 = bufferInfo2.bufferSize + i2;
            }
            Logger.i(TAG, "static totalBufferSize = ".concat(String.valueOf(i2)));
            this.mDecodeBufferInfo.setByteBufferCapacity(i2);
            int i3 = 0;
            for (BufferInfo bufferInfo3 : this.mAllPcmBufferList) {
                System.arraycopy(bufferInfo3.byteBuffer, 0, this.mDecodeBufferInfo.byteBuffer, i3, bufferInfo3.bufferSize);
                i3 += bufferInfo3.bufferSize;
                this.mDecodeBufferInfo.bufferSize += bufferInfo3.bufferSize;
                this.mAllBufferSize = bufferInfo3.bufferSize + this.mAllBufferSize;
            }
        }
        AppMethodBeat.o(76743);
        return true;
    }

    private boolean createAudioTrack() {
        int i2 = 3;
        AppMethodBeat.i(76744);
        Logger.d(TAG, axiliary("createAudioTrack"));
        if (this.mInformation == null) {
            Logger.e(TAG, axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(9);
            callExceptionCallback(91, 63);
            AppMethodBeat.o(76744);
            return false;
        }
        if (!this.mStateRunner.isEqual(3)) {
            Logger.e(TAG, axiliary("mState is not preparing"));
            callExceptionCallback(91, 54);
            AppMethodBeat.o(76744);
            return false;
        } else if (this.mInformation.getSampleRate() <= 0) {
            Logger.e(TAG, axiliary("mInformation.getSampleRate() failed"));
            callExceptionCallback(91, 64);
            AppMethodBeat.o(76744);
            return false;
        } else {
            int i3 = 12;
            int channels = this.mInformation.getChannels();
            if (channels == 1) {
                i3 = 4;
            } else if (channels == 2) {
                i3 = 12;
            } else if (channels == 6) {
                i3 = 252;
            } else if (channels == 8) {
                i3 = 1020;
            }
            this.mTargetPlaySample = this.mInformation.getSampleRate();
            int bitDepth = this.mInformation.getBitDepth();
            while (this.mTargetPlaySample > ((long) getMaxSupportSampleRate())) {
                this.mTargetPlaySample /= 2;
            }
            if (isSupportHighBitDepth() && bitDepth >= 3) {
                this.mTargetBitDepth = bitDepth;
                this.isUseFloatForHighDepth = true;
                if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                    Logger.i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + bitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
                } else {
                    Logger.i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + bitDepth + ", sample rate: " + this.mTargetPlaySample));
                }
            } else if (isSupportHighBitDepth() || bitDepth < 3) {
                this.mTargetBitDepth = bitDepth;
                Logger.i(TAG, axiliary("will use byte pcm resampled, bitDept: " + bitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                this.mTargetBitDepth = 2;
                if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                    Logger.i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + bitDepth + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
                } else {
                    Logger.i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + bitDepth + ", target bitDept: " + this.mTargetBitDepth));
                }
            }
            if (bitDepth != 1) {
                if (bitDepth == 2) {
                    i2 = 2;
                } else if (this.isUseFloatForHighDepth) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
            }
            Logger.d(TAG, axiliary(String.format("mTargetPlaySample: %d, playChannel: %d", Long.valueOf(this.mTargetPlaySample), Integer.valueOf(channels))));
            try {
                setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int) this.mTargetPlaySample, i3, i2, this.mAllBufferSize, 0));
                if (this.mSpeedToSet != null && Build.VERSION.SDK_INT >= 23) {
                    Logger.i(TAG, axiliary("setSpeed:" + this.mSpeedToSet));
                    PlaybackParams playbackParams = this.mAudioTrack.getPlaybackParams();
                    playbackParams.setSpeed(this.mSpeedToSet.floatValue());
                    this.mSpeedToSet = null;
                    this.mAudioTrack.setPlaybackParams(playbackParams);
                }
                if (this.mAudioTrack.getState() == 2) {
                    Logger.d(TAG, axiliary("new AudioTrack succeed"));
                }
            } catch (Throwable th) {
                Logger.e(TAG, th);
            }
            if (this.mAudioTrack == null || this.mAudioTrack.getState() != 2) {
                this.mCreateAudioTrackFail = true;
                Logger.e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
                setAudioTrack(null);
                this.mStateRunner.transfer(9);
                callExceptionCallback(91, 66);
                AppMethodBeat.o(76744);
                return false;
            }
            Logger.d(TAG, axiliary("create audioTrack success"));
            AppMethodBeat.o(76744);
            return true;
        }
    }

    private boolean writeAudioTrack() {
        AppMethodBeat.i(76745);
        BufferInfo bufferInfo = new BufferInfo();
        if (this.mDecodeBufferInfo.byteBuffer == null || this.mAudioTrack == null) {
            AppMethodBeat.o(76745);
            return false;
        }
        if (this.mTargetBitDepth != this.mInformation.getBitDepth()) {
            handleHighBitDepth(this.mDecodeBufferInfo, bufferInfo);
            this.mDecodeBufferInfo.fillInto(bufferInfo);
        }
        if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
            handleHighSample(this.mDecodeBufferInfo, bufferInfo);
            this.mDecodeBufferInfo.fillInto(bufferInfo);
        }
        if (this.isUseFloatForHighDepth) {
            convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
            processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
        } else {
            processAudioListeners(this.mDecodeBufferInfo, bufferInfo);
            this.mDecodeBufferInfo.fillInto(bufferInfo);
        }
        this.mHasTerminal = false;
        int size = this.mTerminalAudioEffectList.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            IAudioListener iAudioListener = (IAudioListener) this.mTerminalAudioEffectList.get(size);
            if (iAudioListener.isEnabled()) {
                if (this.isUseFloatForHighDepth) {
                    iAudioListener.onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
                } else {
                    iAudioListener.onPcm(this.mDecodeBufferInfo, this.mDecodeBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
                }
                this.mHasTerminal = true;
            } else {
                size--;
            }
        }
        if (!this.mHasTerminal) {
            if (!this.isUseFloatForHighDepth || Build.VERSION.SDK_INT < 21) {
                int write = this.mAudioTrack.write(this.mDecodeBufferInfo.byteBuffer, 0, this.mDecodeBufferInfo.bufferSize);
                if (write < 0) {
                    Logger.e(TAG, axiliary("mAudioTrack write bytes failed: " + write + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                    this.mStateRunner.transfer(9);
                    callExceptionCallback(91, 102);
                    AppMethodBeat.o(76745);
                    return false;
                } else if (write != this.mDecodeBufferInfo.bufferSize) {
                    Logger.w(TAG, axiliary("mAudioTrack write bytes not equal: " + write + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                }
            } else {
                int write2 = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
                if (write2 < 0) {
                    Logger.e(TAG, axiliary("mAudioTrack write float failed: " + write2 + ", expect: " + this.mFloatBufferInfo.bufferSize));
                    this.mStateRunner.transfer(9);
                    callExceptionCallback(91, 102);
                    AppMethodBeat.o(76745);
                    return false;
                } else if (write2 != this.mFloatBufferInfo.bufferSize) {
                    Logger.w(TAG, axiliary("mAudioTrack write float not equal: " + write2 + ", expect: " + this.mFloatBufferInfo.bufferSize));
                }
            }
            AppMethodBeat.o(76745);
            return true;
        }
        Logger.i(TAG, "mTerminalAudioEffectList has blocked");
        AppMethodBeat.o(76745);
        return false;
    }

    private void playAudioTrack() {
        AppMethodBeat.i(76746);
        this.mAudioTrack.reloadStaticData();
        while (!this.mCorePlayer.mIsExit) {
            if (!isPaused()) {
                if (isIdle()) {
                    break;
                } else if (isError()) {
                    Logger.e(TAG, "static play error");
                    AppMethodBeat.o(76746);
                    return;
                } else if (isStopped()) {
                    if (this.mAudioTrack.getPlayState() != 1) {
                        this.mAudioTrack.stop();
                    }
                    postRunnable(new Runnable() {
                        /* class com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.AnonymousClass4 */

                        public void run() {
                            AppMethodBeat.i(76724);
                            StaticDecodeDataComponent.this.mCallback.playerStopped(StaticDecodeDataComponent.this.mCorePlayer);
                            AppMethodBeat.o(76724);
                        }
                    }, 20);
                    AppMethodBeat.o(76746);
                    return;
                } else if (isCompleted()) {
                    this.mCorePlayer.mIsExit = true;
                    AppMethodBeat.o(76746);
                    return;
                } else if (isPlaying()) {
                    if (this.mAudioTrack.getPlayState() == 2) {
                        this.mAudioTrack.play();
                    } else if (this.mAudioTrack.getPlayState() == 1) {
                        if (!this.mIsfirstStarted) {
                            this.mIsfirstStarted = true;
                            this.mAudioTrack.play();
                            this.mCallback.playerStarted(this.mCorePlayer);
                        }
                    } else if (((long) AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack)) * ((long) this.mInformation.getChannels()) * ((long) this.mTargetBitDepth) >= ((long) this.mAllBufferSize)) {
                        this.mStateRunner.transfer(7);
                        Logger.i(TAG, "static play completed");
                        postRunnable(new Runnable() {
                            /* class com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.AnonymousClass5 */

                            public void run() {
                                AppMethodBeat.i(190297);
                                StaticDecodeDataComponent.this.mCallback.playerEnded(StaticDecodeDataComponent.this.mCorePlayer);
                                AppMethodBeat.o(190297);
                            }
                        }, 20);
                    }
                }
            } else {
                if (this.mAudioTrack.getPlayState() != 2) {
                    this.mAudioTrack.pause();
                }
                postRunnable(new Runnable() {
                    /* class com.tencent.qqmusic.mediaplayer.StaticDecodeDataComponent.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(76712);
                        StaticDecodeDataComponent.this.mCallback.playerPaused(StaticDecodeDataComponent.this.mCorePlayer);
                        AppMethodBeat.o(76712);
                    }
                }, 20);
                doWaitForPaused();
            }
        }
        AppMethodBeat.o(76746);
    }
}
