package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0012\u0018\u0000 #2\u00020\u0001:\u0002#$Bl\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012M\u0010\u0004\u001aI\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0002J \u0010\"\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016R\u0010\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u001a0\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "farmat", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "encoderStart", "", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d extends a {
    public static final a ifn = new a((byte) 0);
    private List<b> ifj = Collections.synchronizedList(new ArrayList());
    private boolean ifk;
    private boolean ifl;
    private c ifm = new c(this);

    static {
        AppMethodBeat.i(93636);
        AppMethodBeat.o(93636);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(MediaFormat mediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> qVar, kotlin.g.a.a<x> aVar) {
        super(mediaFormat, qVar, aVar);
        p.h(mediaFormat, "mediaFormat");
        p.h(qVar, "frameEncodeCallback");
        p.h(aVar, "frameEncodeEndCallback");
        AppMethodBeat.i(93635);
        try {
            this.ieT.setCallback(this.ifm);
            AppMethodBeat.o(93635);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", e2, "", new Object[0]);
            AppMethodBeat.o(93635);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, hxF = {"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", FirebaseAnalytics.b.INDEX, "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class c extends MediaCodec.Callback {
        final /* synthetic */ d ifp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(d dVar) {
            this.ifp = dVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(93630);
            p.h(mediaCodec, "codec");
            p.h(bufferInfo, "info");
            try {
                Log.d("MicroMsg.MediaCodecAACEncoderAsync", "encoderOutputBufferIndex: %s", Integer.valueOf(i2));
                if (i2 == -1) {
                    Log.d("MicroMsg.MediaCodecAACEncoderAsync", "no output available, break");
                    AppMethodBeat.o(93630);
                } else if (i2 == -2) {
                    d dVar = this.ifp;
                    MediaFormat outputFormat = this.ifp.ieT.getOutputFormat();
                    p.g(outputFormat, "encoder.outputFormat");
                    dVar.d(outputFormat);
                    Log.i("MicroMsg.MediaCodecAACEncoderAsync", "dstMediaFormat change: %s", this.ifp.ieU);
                    AppMethodBeat.o(93630);
                } else if (i2 < 0) {
                    Log.e("MicroMsg.MediaCodecAACEncoderAsync", "unexpected encoderOutputBufferIndex: %s", Integer.valueOf(i2));
                    AppMethodBeat.o(93630);
                } else {
                    if ((bufferInfo.flags & 2) != 0) {
                        Log.v("MicroMsg.MediaCodecAACEncoderAsync", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(bufferInfo.size), Boolean.TRUE);
                        bufferInfo.size = 0;
                    }
                    Log.v("MicroMsg.MediaCodecAACEncoderAsync", "perform encoding");
                    this.ifp.f(this.ifp.ieT.getOutputBuffer(i2), bufferInfo);
                    this.ifp.ieT.releaseOutputBuffer(i2, false);
                    if ((bufferInfo.flags & 4) != 0 || this.ifp.ifk) {
                        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "receive EOS!");
                        this.ifp.aMj();
                        AppMethodBeat.o(93630);
                        return;
                    }
                    AppMethodBeat.o(93630);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", e2, "drainEncoder error: %s", e2.getMessage());
                AppMethodBeat.o(93630);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            boolean z;
            AppMethodBeat.i(93631);
            p.h(mediaCodec, "codec");
            try {
                Log.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer ".concat(String.valueOf(i2)));
                if (this.ifp.ifj.size() == 0) {
                    Log.i("MicroMsg.MediaCodecAACEncoderAsync", "current data is null");
                    this.ifp.ieT.a(i2, 0, 0, 0);
                    AppMethodBeat.o(93631);
                    return;
                }
                Log.i("MicroMsg.MediaCodecAACEncoderAsync", "has input buffer avaiable".concat(String.valueOf(i2)));
                if (this.ifp.idt) {
                    Log.i("MicroMsg.MediaCodecAACEncoderAsync", "sendDataToEncoder end now");
                    AppMethodBeat.o(93631);
                    return;
                }
                this.ifp.ieV = Util.currentTicks();
                if (i2 < 0) {
                    Log.d("MicroMsg.MediaCodecAACEncoderAsync", "encoder no input buffer available, drain first");
                    AppMethodBeat.o(93631);
                    return;
                }
                List list = this.ifp.ifj;
                p.g(list, "inputDataSource");
                b bVar = (b) j.ks(list);
                byte[] bArr = bVar.dtQ;
                long j2 = bVar.pts;
                boolean z2 = bVar.ifo;
                Log.i("MicroMsg.MediaCodecAACEncoderAsync", "encode data, pts:" + j2 + ", isLast:" + z2 + ", pcmData:" + (bArr != null ? Integer.valueOf(bArr.length) : null) + ", inputDataSource.size:" + this.ifp.ifj.size());
                if (bArr == null) {
                    AppMethodBeat.o(93631);
                    return;
                }
                if (i2 >= 0) {
                    ByteBuffer inputBuffer = this.ifp.ieT.getInputBuffer(i2);
                    if (inputBuffer != null) {
                        inputBuffer.clear();
                    }
                    if (inputBuffer != null) {
                        inputBuffer.position(0);
                    }
                    if (inputBuffer != null) {
                        inputBuffer.put(bArr);
                    }
                    if (z2) {
                        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "last, send EOS and try delay stop encoder");
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.ifp.ifk = true;
                        Log.i("MicroMsg.MediaCodecAACEncoderAsync", "EOS received in sendAudioToEncoder");
                        this.ifp.ieT.a(i2, bArr.length, j2, 4);
                    } else {
                        this.ifp.ieT.a(i2, bArr.length, j2, 0);
                    }
                    this.ifp.ifj.remove(bVar);
                    AppMethodBeat.o(93631);
                    return;
                }
                AppMethodBeat.o(93631);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MediaCodecAACEncoderAsync", e2, "onInputBufferAvailable error", new Object[0]);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(93632);
            p.h(mediaCodec, "codec");
            p.h(mediaFormat, "format");
            Log.i("MicroMsg.MediaCodecAACEncoderAsync", "onOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
            AppMethodBeat.o(93632);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(93633);
            p.h(mediaCodec, "codec");
            p.h(codecException, "e");
            Log.e("MicroMsg.MediaCodecAACEncoderAsync", "onError, e:" + codecException.getMessage() + ", " + codecException);
            AppMethodBeat.o(93633);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "", "pcmData", "", "pts", "", "isLast", "", "([BJZ)V", "()Z", "setLast", "(Z)V", "getPcmData", "()[B", "setPcmData", "([B)V", "getPts", "()J", "setPts", "(J)V", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    public static final class b {
        byte[] dtQ;
        boolean ifo;
        long pts;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r5.ifo == r6.ifo) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 93629(0x16dbd, float:1.31202E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.media.e.d.b
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.media.e.d$b r6 = (com.tencent.mm.media.e.d.b) r6
                byte[] r0 = r5.dtQ
                byte[] r1 = r6.dtQ
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
                long r0 = r5.pts
                long r2 = r6.pts
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                boolean r0 = r5.ifo
                boolean r1 = r6.ifo
                if (r0 != r1) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.e.d.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(93628);
            byte[] bArr = this.dtQ;
            int hashCode = bArr != null ? Arrays.hashCode(bArr) : 0;
            long j2 = this.pts;
            int i2 = ((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            boolean z = this.ifo;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 + i2;
            AppMethodBeat.o(93628);
            return i6;
        }

        public final String toString() {
            AppMethodBeat.i(93627);
            String str = "EncoderData(pcmData=" + Arrays.toString(this.dtQ) + ", pts=" + this.pts + ", isLast=" + this.ifo + ")";
            AppMethodBeat.o(93627);
            return str;
        }

        public b(byte[] bArr, long j2, boolean z) {
            this.dtQ = bArr;
            this.pts = j2;
            this.ifo = z;
        }
    }

    @Override // com.tencent.mm.media.e.a
    public final void b(byte[] bArr, long j2, boolean z) {
        AppMethodBeat.i(93634);
        p.h(bArr, "data");
        if (bArr != null) {
            this.ifj.add(new b(bArr, j2, z));
            if (!this.ifl) {
                this.ieT.start();
                this.ifl = true;
            }
        }
        AppMethodBeat.o(93634);
    }
}
