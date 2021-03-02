package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioResample {
    public final String TAG;
    private IAVResample avResample;
    private final AudioInfo destAudioInfo;
    private ByteBuffer destBuffer;
    private AudioInfo srcAudioInfo;

    public AudioResample() {
        this(newDefaultDestAudioInfo());
        AppMethodBeat.i(217858);
        AppMethodBeat.o(217858);
    }

    public AudioResample(AudioInfo audioInfo) {
        AppMethodBeat.i(217859);
        this.TAG = "AudioResample@" + Integer.toHexString(hashCode());
        this.destAudioInfo = audioInfo;
        Logger.i(this.TAG, "AudioResample() called with: destAudioInfo = [" + audioInfo + "], thread = " + Thread.currentThread().getName());
        AppMethodBeat.o(217859);
    }

    private static AudioInfo newDefaultDestAudioInfo() {
        AppMethodBeat.i(217860);
        AudioInfo audioInfo = new AudioInfo();
        audioInfo.channelCount = 1;
        audioInfo.sampleRate = 44100;
        audioInfo.pcmEncoding = 2;
        AppMethodBeat.o(217860);
        return audioInfo;
    }

    public AudioInfo getDestAudioInfo() {
        return this.destAudioInfo;
    }

    public ByteBuffer resample(ByteBuffer byteBuffer, AudioInfo audioInfo) {
        AppMethodBeat.i(217861);
        Logger.v(this.TAG, "resample() called with: srcBuffer = [" + byteBuffer + "], srcAudioInfo = [" + audioInfo + "]， thread = " + Thread.currentThread().getName());
        if (!compareAudioInfo(audioInfo) && AVResampleFactory.getInstance().isResampleEnable()) {
            this.avResample = AVResampleFactory.getInstance().newAVResample(audioInfo.sampleRate, audioInfo.channelCount, this.destAudioInfo.sampleRate, this.destAudioInfo.channelCount);
            this.srcAudioInfo = audioInfo;
            Logger.i(this.TAG, "resample: 创建重采样库，class = " + (this.avResample != null ? this.avResample.getClass().getName() : BuildConfig.COMMAND) + ", srcAudioInfo = " + audioInfo + ", thread = " + Thread.currentThread().getName());
        }
        if (this.avResample == null) {
            Logger.w(this.TAG, "resample: avResample 创建失败！");
            AppMethodBeat.o(217861);
            return null;
        }
        byte[] resample = this.avResample.resample(byteBuffer, byteBuffer.limit());
        if (this.destBuffer == null || resample.length > this.destBuffer.limit()) {
            this.destBuffer = ByteBuffer.allocateDirect(resample.length);
            this.destBuffer.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.destBuffer.clear();
        this.destBuffer.put(resample);
        this.destBuffer.position(0);
        this.destBuffer.limit(resample.length);
        ByteBuffer byteBuffer2 = this.destBuffer;
        AppMethodBeat.o(217861);
        return byteBuffer2;
    }

    private boolean compareAudioInfo(AudioInfo audioInfo) {
        if (this.srcAudioInfo != null && this.srcAudioInfo.pcmEncoding == audioInfo.pcmEncoding && this.srcAudioInfo.channelCount == audioInfo.channelCount && this.srcAudioInfo.sampleRate == audioInfo.sampleRate) {
            return true;
        }
        return false;
    }
}
