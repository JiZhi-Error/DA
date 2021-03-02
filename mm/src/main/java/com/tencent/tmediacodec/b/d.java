package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.a.a;
import com.tencent.tmediacodec.e.a;
import com.tencent.tmediacodec.g.b;

public final class d implements c {
    private final MediaCodec btk;

    public d(MediaCodec mediaCodec) {
        this.btk = mediaCodec;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void a(a aVar) {
        AppMethodBeat.i(190101);
        b.bqS("DirectCodecWrapper");
        AppMethodBeat.o(190101);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final MediaCodec hps() {
        return this.btk;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final a.b b(e eVar) {
        AppMethodBeat.i(190102);
        b.bqS("DirectCodecWrapper");
        a.b bVar = a.b.KEEP_CODEC_RESULT_NO;
        AppMethodBeat.o(190102);
        return bVar;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void hpt() {
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void hpu() {
        AppMethodBeat.i(190103);
        b.bqS("DirectCodecWrapper");
        AppMethodBeat.o(190103);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i2) {
        AppMethodBeat.i(190104);
        this.btk.configure(mediaFormat, surface, mediaCrypto, 0);
        AppMethodBeat.o(190104);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void start() {
        AppMethodBeat.i(190105);
        this.btk.start();
        AppMethodBeat.o(190105);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void flush() {
        AppMethodBeat.i(190106);
        this.btk.flush();
        AppMethodBeat.o(190106);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void stop() {
        AppMethodBeat.i(190107);
        this.btk.stop();
        AppMethodBeat.o(190107);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void release() {
        AppMethodBeat.i(190108);
        this.btk.release();
        AppMethodBeat.o(190108);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void releaseOutputBuffer(int i2, boolean z) {
        AppMethodBeat.i(190109);
        this.btk.releaseOutputBuffer(i2, z);
        AppMethodBeat.o(190109);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final void a(int i2, int i3, long j2, int i4) {
        AppMethodBeat.i(190110);
        this.btk.queueInputBuffer(i2, 0, i3, j2, i4);
        AppMethodBeat.o(190110);
    }

    @Override // com.tencent.tmediacodec.b.c
    public final int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j2) {
        AppMethodBeat.i(190111);
        int dequeueOutputBuffer = this.btk.dequeueOutputBuffer(bufferInfo, j2);
        AppMethodBeat.o(190111);
        return dequeueOutputBuffer;
    }

    @Override // com.tencent.tmediacodec.b.c
    public final int dequeueInputBuffer(long j2) {
        AppMethodBeat.i(190112);
        int dequeueInputBuffer = this.btk.dequeueInputBuffer(j2);
        AppMethodBeat.o(190112);
        return dequeueInputBuffer;
    }

    @Override // com.tencent.tmediacodec.b.c
    @TargetApi(23)
    public final void setOutputSurface(Surface surface) {
        AppMethodBeat.i(190113);
        this.btk.setOutputSurface(surface);
        AppMethodBeat.o(190113);
    }
}
