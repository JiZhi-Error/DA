package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Stack;

class StreamDecodeDataComponent extends BaseDecodeDataComponent {
    private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
    private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
    private static final String TAG = "StreamDecodeDataComponent";
    private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 5000;
    private long mCurrentFrameCount = 0;
    private boolean mNeedFlush = false;
    private final Stack<Integer> mSeekRecord = new Stack<>();
    private int mTrackBufferSizeInByte;

    StreamDecodeDataComponent(CorePlayer corePlayer, PlayerStateRunner playerStateRunner, AudioInformation audioInformation, PlayerCallback playerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback handleDecodeDataCallback, Handler handler, int i2) {
        super(corePlayer, playerStateRunner, audioInformation, playerCallback, handleDecodeDataCallback, handler, i2);
        AppMethodBeat.i(76482);
        AppMethodBeat.o(76482);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void pause(boolean z) {
        AppMethodBeat.i(76483);
        super.pause(z);
        if (z) {
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                try {
                    if (audioTrack.getState() == 1 && audioTrack.getPlayState() != 2) {
                        audioTrack.pause();
                    }
                } catch (IllegalStateException e2) {
                }
            }
            AppMethodBeat.o(76483);
            return;
        }
        AppMethodBeat.o(76483);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public int getAudioStreamType() {
        return 3;
    }

    private BufferInfo initTempBufferInfoIfNeeded(BufferInfo bufferInfo, int i2) {
        AppMethodBeat.i(175617);
        if (bufferInfo == null) {
            bufferInfo = new BufferInfo();
            bufferInfo.setByteBufferCapacity(i2);
        }
        AppMethodBeat.o(175617);
        return bufferInfo;
    }

    private FloatBufferInfo initTempFloatBufferInfoIfNeeded(FloatBufferInfo floatBufferInfo, int i2) {
        AppMethodBeat.i(175618);
        if (floatBufferInfo == null) {
            floatBufferInfo = new FloatBufferInfo();
            floatBufferInfo.setFloatBufferCapacity(i2);
        }
        AppMethodBeat.o(175618);
        return floatBufferInfo;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0681  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x07e7  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0801  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x08ed  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0905  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0925  */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleDecodeData() {
        /*
        // Method dump skipped, instructions count: 2356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent.handleDecodeData():void");
    }

    private boolean createAudioTrack() {
        AppMethodBeat.i(76485);
        Logger.d(TAG, axiliary("createAudioTrack"));
        if (!this.mStateRunner.isEqual(3)) {
            Logger.e(TAG, "mState is not preparing");
            callExceptionCallback(91, 54);
            AppMethodBeat.o(76485);
            return false;
        } else if (this.mInformation.getSampleRate() <= 0) {
            Logger.e(TAG, "mInformation.getSampleRate() failed");
            callExceptionCallback(91, 64);
            AppMethodBeat.o(76485);
            return false;
        } else {
            int i2 = 12;
            int channels = this.mInformation.getChannels();
            if (channels == 1) {
                i2 = 4;
            } else if (channels == 2) {
                i2 = 12;
            } else if (channels == 6) {
                i2 = 252;
            } else if (channels == 8) {
                i2 = 1020;
            }
            Logger.d(TAG, axiliary(this.mInformation.toString()));
            this.mTargetPlaySample = this.mInformation.getSampleRate();
            while (this.mTargetPlaySample > ((long) getMaxSupportSampleRate())) {
                this.mTargetPlaySample /= 2;
            }
            int bitDepth = this.mInformation.getBitDepth();
            if (bitDepth == 0) {
                bitDepth = 2;
            }
            if (isSupportHighBitDepth() && this.mInformation.getBitDepth() >= 3) {
                this.mTargetBitDepth = bitDepth;
                this.isUseFloatForHighDepth = true;
                if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                    Logger.i(TAG, axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
                } else {
                    Logger.i(TAG, axiliary("will use float pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", sample rate: " + this.mTargetPlaySample));
                }
            } else if (isSupportHighBitDepth() || this.mInformation.getBitDepth() < 3) {
                this.mTargetBitDepth = bitDepth;
                Logger.i(TAG, axiliary("will use byte pcm resampled, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            } else {
                this.mTargetBitDepth = 2;
                if (this.mTargetPlaySample != this.mInformation.getSampleRate()) {
                    Logger.i(TAG, axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
                } else {
                    Logger.i(TAG, axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth));
                }
            }
            int i3 = 2;
            if (bitDepth == 1) {
                i3 = 3;
            } else if (bitDepth == 2) {
                i3 = 2;
            } else if (this.isUseFloatForHighDepth) {
                i3 = 4;
            }
            int minPcmBufferSize = (int) this.mHandleDecodeDataCallback.getMinPcmBufferSize();
            int minBufferSize = getMinBufferSize(this.mTargetPlaySample, i2, i3, channels, bitDepth);
            Logger.i(TAG, axiliary("[createAudioTrack] playback_bufsize:" + minBufferSize + " decoderBufsizeInByte:" + minPcmBufferSize));
            if (this.mLeastCommonMultiple > 1) {
                minBufferSize = getLcm(this.mLeastCommonMultiple, minBufferSize);
            }
            if (minBufferSize > minPcmBufferSize) {
                minPcmBufferSize = minBufferSize;
            }
            this.mBuffSize = minPcmBufferSize;
            Logger.i(TAG, axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mTargetPlaySample: %d, playChannel: %d, pcmEncoding: %d", Integer.valueOf(minBufferSize), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mTargetPlaySample), Integer.valueOf(channels), Integer.valueOf(i3))));
            int max = Math.max((int) (Math.floor((double) ((((1 * this.mTargetPlaySample) * ((long) channels)) * 2) / ((long) minBufferSize))) + 1.0d), 1);
            Logger.d(TAG, axiliary("times: " + max + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
            int i4 = max;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                try {
                    this.mTrackBufferSizeInByte = minBufferSize * i4;
                    setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int) this.mTargetPlaySample, i2, i3, this.mTrackBufferSizeInByte, 1));
                    Logger.i(TAG, axiliary("[createAudioTrack] new AudioTrack, sampleRate: " + this.mTargetPlaySample + ", channels: " + i2 + ", bitDepth: " + bitDepth + ", buffer: " + this.mTrackBufferSizeInByte));
                    int state = this.mAudioTrack.getState();
                    if (state == 1) {
                        Logger.i(TAG, axiliary("new AudioTrack succeed"));
                        break;
                    }
                    Logger.e(TAG, axiliary("audioTrack create fail!!! state = ".concat(String.valueOf(state))));
                    this.mAudioTrack.release();
                    i4 -= 2;
                } catch (Throwable th) {
                    Logger.e(TAG, th);
                }
            }
            if (this.mAudioTrack == null || this.mAudioTrack.getState() != 1) {
                this.mCreateAudioTrackFail = true;
                Logger.e(TAG, axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
                setAudioTrack(null);
                callExceptionCallback(92, 66);
                AppMethodBeat.o(76485);
                return false;
            }
            Logger.d(TAG, axiliary("create audioTrack success times = ".concat(String.valueOf(i4))));
            this.mStateRunner.setAudioTrack(this.mAudioTrack);
            AppMethodBeat.o(76485);
            return true;
        }
    }

    private int getGcd(int i2, int i3) {
        while (i3 > 0) {
            int i4 = i2 % i3;
            i2 = i3;
            i3 = i4;
        }
        return i2;
    }

    private int getLcm(int i2, int i3) {
        AppMethodBeat.i(175619);
        int gcd = (i2 * i3) / getGcd(i2, i3);
        AppMethodBeat.o(175619);
        return gcd;
    }

    private void addSeekRecord(int i2) {
        AppMethodBeat.i(76486);
        synchronized (this.mSeekRecord) {
            try {
                Logger.i(TAG, "add seek: ".concat(String.valueOf(i2)));
                this.mSeekRecord.push(Integer.valueOf(i2));
            } finally {
                AppMethodBeat.o(76486);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void flush() {
        this.mNeedFlush = true;
    }

    private long getCalcBitMinSize(AudioInformation audioInformation) {
        AppMethodBeat.i(76487);
        if (audioInformation != null) {
            long sampleRate = (long) ((((float) ((audioInformation.getSampleRate() * ((long) audioInformation.getChannels())) * ((long) audioInformation.getBitDepth()))) * 5.0f) / 1000.0f);
            AppMethodBeat.o(76487);
            return sampleRate;
        }
        AppMethodBeat.o(76487);
        return 0;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void setAudioStreamType(int i2) {
        AppMethodBeat.i(76488);
        if (i2 == this.mAudioStreamType) {
            AppMethodBeat.o(76488);
            return;
        }
        try {
            this.mAudioStreamType = i2;
            if (this.mAudioTrack != null) {
                AudioTrack instantiateAudioTrackCompat = instantiateAudioTrackCompat(i2, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
                Logger.i(TAG, axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
                int playState = this.mAudioTrack.getPlayState();
                if (playState == 3) {
                    pause(false);
                }
                this.mAudioTrack.release();
                setAudioTrack(instantiateAudioTrackCompat);
                this.mStateRunner.setAudioTrack(this.mAudioTrack);
                if (playState == 3) {
                    play();
                }
            }
            AppMethodBeat.o(76488);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            Logger.e(TAG, "failed in setting audio stream type to :".concat(String.valueOf(i2)), e2);
            AppMethodBeat.o(76488);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public long getCurPosition() {
        AppMethodBeat.i(76489);
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack == null || audioTrack.getState() == 0) {
            long j2 = this.mCurPosition;
            AppMethodBeat.o(76489);
            return j2;
        }
        AudioInformation audioInformation = this.mInformation;
        if (audioInformation == null) {
            long j3 = this.mCurPosition;
            AppMethodBeat.o(76489);
            return j3;
        }
        long audioTrackPosition = (long) getAudioTrackPosition(this.mCurrentFrameCount, audioTrack);
        for (IAudioListener iAudioListener : this.audioEffects) {
            audioTrackPosition = iAudioListener.getActualTime(audioTrackPosition);
        }
        long channels = ((long) (audioInformation.getChannels() * this.mTargetBitDepth)) * audioInformation.getPlaySample();
        long curPositionByDecoder = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, channels > 0 ? (((long) this.mTrackBufferSizeInByte) / channels) * 1000 : 0);
        if (curPositionByDecoder < 0) {
            this.mCurPosition = audioTrackPosition;
        } else if (audioTrackPosition <= 0 || Math.abs(audioTrackPosition - curPositionByDecoder) >= 5000) {
            this.mCurPosition = curPositionByDecoder;
        } else {
            this.mCurPosition = audioTrackPosition;
        }
        long j4 = this.mCurPosition;
        AppMethodBeat.o(76489);
        return j4;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void seek(int i2) {
        AppMethodBeat.i(76490);
        addSeekRecord(i2);
        refreshTimeAndNotify(i2);
        AppMethodBeat.o(76490);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
    public void release() {
        AppMethodBeat.i(76491);
        super.release();
        this.mCurrentFrameCount = 0;
        AppMethodBeat.o(76491);
    }
}
