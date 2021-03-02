package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.ResourceLoadUtil;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioMixer {
    public static final int OUTPUT_CHANNEL_COUNT = 1;
    public static final int OUTPUT_SAMPLE_RATE = 44100;
    private static final int SIGNED_SHORT_LIMIT = 32768;
    private static final String TAG = "AudioMixer";
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private ByteBuffer cachedByteBuffer;
    private ByteBuffer cachedMergedBuffer;
    private short[] cachedMergedBytes;
    private int destAudioChannelCount;
    private int destAudioSampleRate;
    private ByteBuffer emptyAudioBuffer;
    private long nativeContext;
    private int pcmEncoding;
    private short[] resampleBuffer;
    private short[] sampleBuffer;
    private float sampleFactor;
    private boolean singleChannel;
    private int srcNumChannels;
    private int srcSampleRate;

    private native void nativeRelease(long j2);

    private native long nativeSetup(int i2, int i3);

    private native void readShortFromStream(long j2, short[] sArr);

    private native int writeShortToStream(long j2, short[] sArr, int i2, float f2, float f3, float f4);

    public AudioMixer() {
        this(44100, 1);
    }

    public AudioMixer(int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(218122);
        this.srcSampleRate = 44100;
        this.srcNumChannels = 1;
        this.destAudioSampleRate = i2;
        this.destAudioChannelCount = i3;
        this.nativeContext = nativeSetup(this.destAudioSampleRate, this.destAudioChannelCount);
        this.sampleFactor = 1.0f;
        this.singleChannel = i3 != 1 ? false : z;
        this.pcmEncoding = 2;
        AppMethodBeat.o(218122);
    }

    public void setAudioInfo(int i2, int i3, int i4) {
        boolean z = true;
        this.srcSampleRate = i2;
        this.srcNumChannels = i3;
        this.sampleFactor = ((float) (this.destAudioSampleRate * this.destAudioChannelCount)) / (((float) (i2 * i3)) * 1.0f);
        if (i3 != 1) {
            z = false;
        }
        this.singleChannel = z;
        this.pcmEncoding = i4;
    }

    public int getDestAudioChannelCount() {
        return this.destAudioChannelCount;
    }

    private short[] getCachedSampleBuffer(int i2) {
        if (this.sampleBuffer != null && this.sampleBuffer.length >= i2) {
            return this.sampleBuffer;
        }
        short[] sArr = new short[i2];
        this.sampleBuffer = sArr;
        return sArr;
    }

    private int getResampleLength(int i2) {
        int i3 = (int) (((float) i2) * this.sampleFactor);
        if (i3 % 2 == 1) {
            return i3 - 1;
        }
        return i3;
    }

    private short[] resample(short[] sArr, int i2) {
        short[] sArr2;
        int i3 = 0;
        AppMethodBeat.i(218123);
        if (this.sampleFactor == 1.0f) {
            AppMethodBeat.o(218123);
            return sArr;
        } else if (Float.compare(this.sampleFactor, 0.5f) == 0) {
            short[] downRemix = downRemix(sArr);
            AppMethodBeat.o(218123);
            return downRemix;
        } else {
            int resampleLength = getResampleLength(i2);
            if (this.resampleBuffer == null || this.resampleBuffer.length < resampleLength) {
                sArr2 = new short[resampleLength];
                this.resampleBuffer = sArr2;
            } else {
                sArr2 = this.resampleBuffer;
            }
            float f2 = 1.0f / this.sampleFactor;
            if (this.singleChannel) {
                while (i3 < resampleLength) {
                    short s = sArr[(int) (((float) i3) * f2)];
                    sArr2[i3 + 1] = s;
                    sArr2[i3] = s;
                    i3 += 2;
                }
            } else {
                while (i3 < resampleLength) {
                    int i4 = ((int) (((double) i3) * 0.5d * ((double) f2))) * 2;
                    sArr2[i3] = sArr[i4];
                    sArr2[i3 + 1] = sArr[i4 + 1];
                    i3 += 2;
                }
            }
            AppMethodBeat.o(218123);
            return sArr2;
        }
    }

    private short[] downRemix(short[] sArr) {
        AppMethodBeat.i(218124);
        ShortBuffer wrap = ShortBuffer.wrap(sArr);
        ShortBuffer allocate = ShortBuffer.allocate(sArr.length);
        downRemix(wrap, allocate);
        short[] array = allocate.array();
        AppMethodBeat.o(218124);
        return array;
    }

    public void downRemix(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        AppMethodBeat.i(218125);
        int min = Math.min(shortBuffer.remaining() / 2, shortBuffer2.remaining());
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = ((shortBuffer.get() + 32768) + (shortBuffer.get() + 32768)) / 2;
            if (i3 >= 65536) {
                i3 = -1;
            }
            shortBuffer2.put((short) (i3 - 32768));
        }
        AppMethodBeat.o(218125);
    }

    public ByteBuffer processBytes(ByteBuffer byteBuffer, float f2, float f3, float f4) {
        int limit;
        short[] cachedSampleBuffer;
        int i2;
        ByteBuffer byteBuffer2;
        AppMethodBeat.i(218126);
        if (f2 == 1.0f && f3 == 1.0f && f4 == 1.0f && this.sampleFactor == 1.0f) {
            AppMethodBeat.o(218126);
            return byteBuffer;
        }
        if (this.pcmEncoding == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            limit = asShortBuffer.limit();
            cachedSampleBuffer = getCachedSampleBuffer(limit);
            asShortBuffer.get(cachedSampleBuffer, 0, limit);
        } else if (this.pcmEncoding == 3) {
            limit = byteBuffer.limit();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            cachedSampleBuffer = getCachedSampleBuffer(limit);
            for (int i3 = 0; i3 < limit; i3++) {
                cachedSampleBuffer[i3] = (short) bArr[i3];
            }
        } else {
            AppMethodBeat.o(218126);
            return byteBuffer;
        }
        short[] resample = resample(cachedSampleBuffer, limit);
        int resampleLength = getResampleLength(limit);
        if (f3 == 0.0f) {
            i2 = (int) (((float) resampleLength) / f2);
        } else {
            if (!(f2 == 1.0f && f3 == 1.0f && f4 == 1.0f)) {
                resampleLength = writeShortToStream(this.nativeContext, resample, resampleLength / this.destAudioChannelCount, f2, f3, f4) * this.destAudioChannelCount;
                resample = getCachedSampleBuffer(resampleLength);
                readShortFromStream(this.nativeContext, resample);
            }
            i2 = resampleLength;
        }
        if (f3 == 0.0f) {
            if (this.emptyAudioBuffer == null || this.emptyAudioBuffer.limit() < i2 * 2) {
                this.emptyAudioBuffer = ByteBuffer.allocate(i2 * 2);
                this.emptyAudioBuffer.order(byteBuffer.order());
                this.emptyAudioBuffer.put(new byte[(i2 * 2)]);
            }
            byteBuffer2 = this.emptyAudioBuffer;
        } else {
            if (this.cachedByteBuffer == null || this.cachedByteBuffer.capacity() < i2 * 2) {
                byteBuffer2 = ByteBuffer.allocate(i2 * 2);
                this.cachedByteBuffer = byteBuffer2;
                byteBuffer2.order(byteBuffer.order());
            } else {
                byteBuffer2 = this.cachedByteBuffer;
                byteBuffer2.clear();
            }
            byteBuffer2.asShortBuffer().put(resample, 0, i2);
        }
        byteBuffer2.position(0);
        byteBuffer2.limit(i2 * 2);
        AppMethodBeat.o(218126);
        return byteBuffer2;
    }

    public ByteBuffer mergeSamples(ShortBuffer shortBuffer, ShortBuffer shortBuffer2) {
        AppMethodBeat.i(218127);
        if (this.cachedMergedBuffer == null || this.cachedMergedBuffer.capacity() < shortBuffer.limit() * 2) {
            this.cachedMergedBuffer = ByteBuffer.allocate(shortBuffer.limit() * 2);
            this.cachedMergedBuffer.order(shortBuffer.order());
        } else {
            this.cachedMergedBuffer.clear();
        }
        if (this.cachedMergedBytes == null || this.cachedMergedBytes.length < shortBuffer.limit() * 2) {
            this.cachedMergedBytes = new short[(shortBuffer.limit() * 2)];
        }
        ShortBuffer asShortBuffer = this.cachedMergedBuffer.asShortBuffer();
        short[] sArr = this.cachedMergedBytes;
        int min = Math.min(shortBuffer.limit(), shortBuffer2.limit());
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = shortBuffer.get(i2) + shortBuffer2.get(i2);
            if (i3 < -32768) {
                i3 = -32768;
            } else if (i3 > 32767) {
                i3 = 32767;
            }
            sArr[i2] = (short) i3;
        }
        asShortBuffer.put(sArr, 0, min);
        if (min < shortBuffer.limit()) {
            shortBuffer.position(min);
            asShortBuffer.put(shortBuffer);
        }
        this.cachedMergedBuffer.position(0);
        this.cachedMergedBuffer.limit(shortBuffer.limit() * 2);
        ByteBuffer byteBuffer = this.cachedMergedBuffer;
        AppMethodBeat.o(218127);
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(218128);
        release();
        AppMethodBeat.o(218128);
    }

    public final void release() {
        AppMethodBeat.i(218129);
        nativeRelease(this.nativeContext);
        this.nativeContext = 0;
        AppMethodBeat.o(218129);
    }

    static {
        AppMethodBeat.i(218130);
        if (!ResourceLoadUtil.isLoaded()) {
            try {
                System.out.println("loadlibrary : tav start");
                System.loadLibrary("tav");
                ResourceLoadUtil.setLoaded(true);
                System.out.println("loadlibrary : tav end");
                AppMethodBeat.o(218130);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(218130);
    }
}
