package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor {
    private final String TAG = ("AudioCompositor@" + Integer.toHexString(hashCode()));
    private AudioMixer audioMixer;
    private final AudioResample audioResample;
    private ShortBuffer currentSamples;
    private ShortBuffer lastSamples;

    public AudioCompositor(AudioInfo audioInfo) {
        AppMethodBeat.i(217845);
        this.audioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
        this.audioResample = new AudioResample();
        AppMethodBeat.o(217845);
    }

    public void setAudioInfo(AudioInfo audioInfo) {
        AppMethodBeat.i(217846);
        this.audioMixer = new AudioMixer(audioInfo.sampleRate, audioInfo.channelCount);
        AppMethodBeat.o(217846);
    }

    public synchronized void clear() {
        this.currentSamples = null;
        this.lastSamples = null;
    }

    public synchronized CMSampleBuffer readMergeSample(AudioDecoderTrack audioDecoderTrack, AudioMixInputParameters audioMixInputParameters, CMSampleBuffer cMSampleBuffer) {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(217847);
            if (cMSampleBuffer == null || cMSampleBuffer.getSampleByteBuffer() == null || audioDecoderTrack == null) {
                this.currentSamples = null;
                this.lastSamples = null;
                AppMethodBeat.o(217847);
            } else {
                int limit = cMSampleBuffer.getSampleByteBuffer().asShortBuffer().limit();
                if (this.currentSamples == null || this.currentSamples.capacity() < limit) {
                    ByteBuffer allocate = ByteBuffer.allocate(limit * 2);
                    allocate.order(cMSampleBuffer.getSampleByteBuffer().order());
                    this.currentSamples = allocate.asShortBuffer();
                } else {
                    this.currentSamples.clear();
                }
                if (this.lastSamples != null && this.lastSamples.remaining() > 0) {
                    if (limit < this.lastSamples.remaining()) {
                        int position = this.lastSamples.position();
                        int limit2 = this.lastSamples.limit();
                        this.lastSamples.limit(position + limit);
                        this.currentSamples.put(this.lastSamples);
                        this.lastSamples.limit(limit2);
                        this.lastSamples.position(position + limit);
                    } else {
                        this.currentSamples.put(this.lastSamples);
                        this.lastSamples.position(this.lastSamples.limit());
                    }
                }
                int position2 = this.currentSamples.position();
                while (true) {
                    if (position2 >= limit) {
                        break;
                    }
                    try {
                        CMSampleBuffer readSample = audioDecoderTrack.readSample(cMSampleBuffer.getTime());
                        int i3 = i2 + 1;
                        Logger.v(this.TAG, "readMergeSample: loopCount = " + i2 + ", audioBuffer = " + readSample);
                        if (readSample.getState().getStateCode() <= -1) {
                            AppMethodBeat.o(217847);
                            break;
                        }
                        audioDecoderTrack.asyncReadNextSample(readSample.getTime());
                        float volumeAtTime = audioMixInputParameters != null ? audioMixInputParameters.getVolumeAtTime(readSample.getTime()) : 1.0f;
                        if (readSample.getSampleByteBuffer() == null || readSample.getSampleByteBuffer().limit() <= 0) {
                            i2 = i3;
                        } else {
                            AudioInfo resample = resample(readSample, audioDecoderTrack.getAudioInfo());
                            if (!(audioMixInputParameters == null || audioMixInputParameters.getAudioTapProcessor() == null)) {
                                AudioTapProcessor audioTapProcessor = audioMixInputParameters.getAudioTapProcessor();
                                readSample.setSampleByteBuffer(audioTapProcessor.processAudioPCM(readSample.getTime(), readSample.getSampleByteBuffer(), resample));
                                resample = audioTapProcessor.getDestAudioInfo();
                            }
                            ShortBuffer asShortBuffer = processFrame(readSample.getSampleByteBuffer(), volumeAtTime, 1.0f, resample).asShortBuffer();
                            if (asShortBuffer.limit() > limit - position2) {
                                int limit3 = asShortBuffer.limit() - (limit - position2);
                                if (this.lastSamples == null || this.lastSamples.capacity() < limit3) {
                                    ByteBuffer allocate2 = ByteBuffer.allocate(limit3 * 2);
                                    allocate2.order(cMSampleBuffer.getSampleByteBuffer().order());
                                    this.lastSamples = allocate2.asShortBuffer();
                                } else {
                                    this.lastSamples.clear();
                                }
                                asShortBuffer.position(limit - position2);
                                this.lastSamples.put(asShortBuffer);
                                this.lastSamples.flip();
                                asShortBuffer.position(0);
                                asShortBuffer.limit(limit - position2);
                                this.currentSamples.put(asShortBuffer);
                            } else {
                                this.currentSamples.put(asShortBuffer);
                                int limit4 = position2 + asShortBuffer.limit();
                                i2 = i3;
                                position2 = limit4;
                            }
                        }
                    } catch (Throwable th) {
                        Logger.e(this.TAG, "readMergeSample: ", th);
                        cMSampleBuffer = new CMSampleBuffer(CMSampleState.fromError(-1, "catch error", th));
                        AppMethodBeat.o(217847);
                    }
                }
                this.currentSamples.flip();
                CMSampleBuffer cMSampleBuffer2 = new CMSampleBuffer(cMSampleBuffer.getTime(), this.audioMixer.mergeSamples(cMSampleBuffer.getSampleByteBuffer().asShortBuffer(), this.currentSamples));
                AppMethodBeat.o(217847);
                cMSampleBuffer = cMSampleBuffer2;
            }
        }
        return cMSampleBuffer;
    }

    public ByteBuffer processFrame(ByteBuffer byteBuffer, float f2, float f3, AudioInfo audioInfo) {
        AppMethodBeat.i(217848);
        this.audioMixer.setAudioInfo(audioInfo.sampleRate, audioInfo.channelCount, audioInfo.pcmEncoding);
        ByteBuffer processBytes = this.audioMixer.processBytes(byteBuffer, f3, f2, 1.0f);
        AppMethodBeat.o(217848);
        return processBytes;
    }

    private AudioInfo resample(CMSampleBuffer cMSampleBuffer, AudioInfo audioInfo) {
        ByteBuffer byteBuffer;
        AppMethodBeat.i(217849);
        ByteBuffer sampleByteBuffer = cMSampleBuffer.getSampleByteBuffer();
        if (sampleByteBuffer == null || sampleByteBuffer.limit() <= 0) {
            Logger.d(this.audioResample.TAG, "resample: 不进行重采样 byteBuffer = ".concat(String.valueOf(sampleByteBuffer)));
            AppMethodBeat.o(217849);
        } else {
            if (!AVResampleFactory.getInstance().isResampleEnable() || (byteBuffer = this.audioResample.resample(sampleByteBuffer, audioInfo)) == null) {
                byteBuffer = sampleByteBuffer;
            } else {
                audioInfo = this.audioResample.getDestAudioInfo();
            }
            cMSampleBuffer.setSampleByteBuffer(byteBuffer);
            AppMethodBeat.o(217849);
        }
        return audioInfo;
    }
}
