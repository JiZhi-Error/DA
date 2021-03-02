package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBl\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012M\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\rH\u0003J\"\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoder;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "currentPts", "", "drainEncoder", "sendDataToEncoder", "pcmData", "", "pts", "isLast", "", "startEncoder", "Companion", "plugin-mediaeditor_release"})
public final class c extends a {
    public static final a ifi = new a((byte) 0);

    static {
        AppMethodBeat.i(93626);
        AppMethodBeat.o(93626);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(MediaFormat mediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> qVar, kotlin.g.a.a<x> aVar) {
        super(mediaFormat, qVar, aVar);
        p.h(mediaFormat, "mediaFormat");
        p.h(qVar, "frameEncodeCallback");
        p.h(aVar, "frameEncodeEndCallback");
        AppMethodBeat.i(93625);
        this.ieT.start();
        AppMethodBeat.o(93625);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoder$Companion;", "", "()V", "TAG", "", InstanceID.ERROR_TIMEOUT, "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0 = new android.media.MediaCodec.BufferInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r1 = r10.ieT.dequeueOutputBuffer(r0, 100);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MediaCodecAACEncoder", "encoderOutputBufferIndex: %s", java.lang.Integer.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r1 != -1) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MediaCodecAACEncoder", "no output available, break");
        com.tencent.matrix.trace.core.AppMethodBeat.o(93623);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0079, code lost:
        if (r1 != -2) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        r1 = r10.ieT.getOutputFormat();
        kotlin.g.b.p.g(r1, "encoder.outputFormat");
        d(r1);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MediaCodecAACEncoder", "dstMediaFormat change: %s", r10.ieU);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        if (r1 >= 0) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MediaCodecAACEncoder", "unexpected encoderOutputBufferIndex: %s", java.lang.Integer.valueOf(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b7, code lost:
        if ((r0.flags & 2) == 0) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b9, code lost:
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MediaCodecAACEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", java.lang.Integer.valueOf(r0.size), java.lang.Boolean.TRUE);
        r0.size = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d6, code lost:
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.MediaCodecAACEncoder", "perform encoding");
        r2 = r10.ieT.getOutputBuffers()[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e7, code lost:
        if (r2 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e9, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.MediaCodecAACEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        com.tencent.matrix.trace.core.AppMethodBeat.o(93623);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        if (r0.size <= 0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fe, code lost:
        f(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0101, code lost:
        r10.ieT.releaseOutputBuffer(r1, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x010b, code lost:
        if ((r0.flags & 4) == 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010d, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MediaCodecAACEncoder", "receive EOS!");
        r10.ieT.stop();
        r10.ieT.release();
        com.tencent.matrix.trace.core.AppMethodBeat.o(93623);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aMn() {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.e.c.aMn():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r10.ieV = com.tencent.mm.sdk.platformtools.Util.currentTicks();
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MediaCodecAACEncoder", "sendDataToEncoder, pcmData size:" + r11.length + ", pts:" + r12 + ", isLast:" + r14);
        r2 = r10.ieT.dequeueInputBuffer(100);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0087, code lost:
        if (r2 >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MediaCodecAACEncoder", "encoder no input buffer available, drain first");
        aMn();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0095, code lost:
        if (r2 < 0) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        r0 = r10.ieT.getInputBuffers()[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009f, code lost:
        if (r0 == null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a1, code lost:
        r0.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
        if (r0 == null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a6, code lost:
        r0.position(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r0 == null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ac, code lost:
        r0.put(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00af, code lost:
        if (r14 == false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b1, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MediaCodecAACEncoder", "last, send EOS and try delay stop encoder");
        r0 = true;
        aMj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        if (r0 == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c0, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.MediaCodecAACEncoder", "EOS received in sendAudioToEncoder");
        r10.ieT.a(r2, r11.length, r12, 4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d1, code lost:
        aMn();
        com.tencent.matrix.trace.core.AppMethodBeat.o(93624);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e2, code lost:
        r10.ieT.a(r2, r11.length, r12, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00eb, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    @Override // com.tencent.mm.media.e.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(byte[] r11, long r12, boolean r14) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.e.c.b(byte[], long, boolean):void");
    }
}
