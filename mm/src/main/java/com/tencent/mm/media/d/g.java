package com.tencent.mm.media.d;

import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class g extends e {
    private static final String TAG = TAG;
    private static final long ieE = 60000;
    public static final a ieF = new a((byte) 0);
    private boolean codeOver;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(com.tencent.mm.media.f.a aVar, String str, long j2, long j3, m<? super byte[], ? super Long, x> mVar, kotlin.g.a.a<x> aVar2) {
        super(aVar, str, j2, j3, mVar, aVar2);
        p.h(aVar, "mediaExtractorWrapper");
        p.h(str, "audioId");
        AppMethodBeat.i(93534);
        AppMethodBeat.o(93534);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public g(com.tencent.mm.media.f.a aVar, String str, long j2, long j3) {
        this(aVar, str, j2, j3, null, null);
        p.h(aVar, "mediaExtractorWrapper");
        p.h(str, "audioId");
        AppMethodBeat.i(93535);
        AppMethodBeat.o(93535);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder$Companion;", "", "()V", "TAG", "", InstanceID.ERROR_TIMEOUT, "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(93536);
        AppMethodBeat.o(93536);
    }

    private final boolean aMd() {
        Boolean bool;
        boolean z;
        int i2;
        int i3;
        AppMethodBeat.i(93531);
        try {
            synchronized (this.stopLock) {
                try {
                    if (this.ied) {
                        Log.i(TAG, "readNextSample decoder stop");
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(93531);
                    throw th;
                }
            }
            z zVar = this.iec;
            if (zVar != null) {
                this.ief = Util.currentTicks();
                int dequeueInputBuffer = zVar.dequeueInputBuffer(100);
                if (dequeueInputBuffer < 0) {
                    aMe();
                }
                if (dequeueInputBuffer < 0) {
                    AppMethodBeat.o(93531);
                    return false;
                }
                Log.i(TAG, "inputIndex: ".concat(String.valueOf(dequeueInputBuffer)));
                this.ief = Util.currentTicks();
                ByteBuffer byteBuffer = zVar.getInputBuffers()[dequeueInputBuffer];
                if (byteBuffer != null) {
                    byteBuffer.clear();
                }
                com.tencent.mm.media.f.a aVar = this.iei;
                if (aVar != null) {
                    p.g(byteBuffer, "inputBuffer");
                    bool = Boolean.valueOf(com.tencent.mm.media.f.a.a(aVar, byteBuffer));
                } else {
                    bool = null;
                }
                if (p.j(bool, Boolean.FALSE)) {
                    Log.i(TAG, "read sample end");
                    z = true;
                } else {
                    z = false;
                }
                long j2 = 0;
                if (!z) {
                    com.tencent.mm.media.f.a aVar2 = this.iei;
                    if (aVar2 != null) {
                        i2 = aVar2.sampleSize;
                    } else {
                        i2 = 0;
                    }
                    if (byteBuffer != null) {
                        byteBuffer.position(0);
                    }
                    com.tencent.mm.media.f.a aVar3 = this.iei;
                    j2 = aVar3 != null ? aVar3.getSampleTime() : -1;
                    Log.i(TAG, "sampleTime : " + j2 + ", sampleSize:" + i2);
                    if (i2 < 0 || j2 >= this.endTimeMs * 1000) {
                        Log.i(TAG, "sawInputEOS");
                        z = true;
                    }
                } else {
                    i2 = 0;
                }
                if (z) {
                    i3 = 4;
                } else {
                    i3 = 0;
                }
                zVar.a(dequeueInputBuffer, i2, j2, i3);
                if (z) {
                    aMc();
                }
                aMe();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        AppMethodBeat.o(93531);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r2 = r14.iec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r2 == null) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r0 = new android.media.MediaCodec.BufferInfo();
        kotlin.g.b.p.h(r0, "<set-?>");
        r14.bufferInfo = r0;
        r0 = r2.dequeueOutputBuffer(r14.bufferInfo, com.tencent.mm.media.d.g.ieE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        if (r0 != -2) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r14.ida = r2.getOutputFormat();
        r0 = r14.ida;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if (r0 == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0.containsKey("sample-rate") != true) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r0 = r14.ida;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (r0 == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        r0 = r0.getInteger("sample-rate");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        if (r0 <= 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r14.iee = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        com.tencent.mm.sdk.platformtools.Log.i(com.tencent.mm.media.d.g.TAG, "onOutputFormatChanged:" + r14.ida + ", aacSampleRate:" + r14.iee + ", audioId:" + r14.dtX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        r0 = r2.dequeueOutputBuffer(r14.bufferInfo, com.tencent.mm.media.d.g.ieE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (r0 >= 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c2, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        if (r0 < 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        r3 = r2.getOutputBuffers()[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        if (r3 != null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
        com.tencent.mm.sdk.platformtools.Log.e(com.tencent.mm.media.d.g.TAG, "ERROR, retrieve decoderOutputBuffer is null!!");
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        r4 = r14.bufferInfo.presentationTimeUs;
        com.tencent.mm.sdk.platformtools.Log.i(com.tencent.mm.media.d.g.TAG, "presentationTimeUs : ".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        if (r4 >= (r14.startTimeMs * 1000)) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        if ((r14.bufferInfo.flags & 4) != 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0101, code lost:
        r2.releaseOutputBuffer(r0, false);
        com.tencent.mm.sdk.platformtools.Log.i(com.tencent.mm.media.d.g.TAG, "decoder pts: " + r4 + ", not reach start: " + (r14.startTimeMs * 1000));
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0134, code lost:
        if (r14.bufferInfo.size <= 0) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0136, code lost:
        e(r3, r14.bufferInfo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013b, code lost:
        r2.releaseOutputBuffer(r0, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0146, code lost:
        if ((r14.endTimeMs * 1000) == 1) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x014d, code lost:
        if (r4 < (r14.endTimeMs * 1000)) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x014f, code lost:
        com.tencent.mm.sdk.platformtools.Log.e(com.tencent.mm.media.d.g.TAG, "exceed endTimeMs");
        aMc();
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0168, code lost:
        if ((r14.bufferInfo.flags & 4) == 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x016a, code lost:
        com.tencent.mm.sdk.platformtools.Log.i(com.tencent.mm.media.d.g.TAG, "receive EOS!");
        aMc();
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(93532);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aMe() {
        /*
        // Method dump skipped, instructions count: 386
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.d.g.aMe():void");
    }

    @Override // com.tencent.mm.media.d.e
    public final void startDecoder() {
        AppMethodBeat.i(93533);
        z zVar = this.iec;
        if (zVar != null) {
            zVar.start();
        }
        while (!this.codeOver && !this.ied) {
            aMd();
        }
        aMc();
        AppMethodBeat.o(93533);
    }
}
