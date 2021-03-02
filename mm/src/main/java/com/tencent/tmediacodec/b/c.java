package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tmediacodec.a.a;
import com.tencent.tmediacodec.e.a;

public interface c {
    void a(int i2, int i3, long j2, int i4);

    void a(a aVar);

    a.b b(e eVar);

    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2);

    int dequeueInputBuffer(long j2);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2);

    void flush();

    MediaCodec hps();

    void hpt();

    void hpu();

    void release();

    void releaseOutputBuffer(int i2, boolean z);

    @TargetApi(23)
    void setOutputSurface(Surface surface);

    void start();

    void stop();
}
