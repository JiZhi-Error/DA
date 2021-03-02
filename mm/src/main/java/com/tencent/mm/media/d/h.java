package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tBy\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJ)V", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "sawInputEOS", "", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class h extends e {
    private static final String TAG = TAG;
    public static final a ieK = new a((byte) 0);
    private int ieG;
    private long ieH;
    private boolean ieI;
    private MediaCodec.Callback ieJ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(com.tencent.mm.media.f.a aVar, String str, long j2, long j3, m<? super byte[], ? super Long, x> mVar, kotlin.g.a.a<x> aVar2) {
        super(aVar, str, j2, j3, mVar, aVar2);
        p.h(aVar, "mediaExtractorWrapper");
        p.h(str, "audioId");
        AppMethodBeat.i(93541);
        this.ieH = j3;
        this.ieJ = new b(this, str, j2, aVar);
        z zVar = this.iec;
        if (zVar != null) {
            zVar.setCallback(this.ieJ);
            AppMethodBeat.o(93541);
            return;
        }
        AppMethodBeat.o(93541);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(com.tencent.mm.media.f.a aVar, String str, long j2, long j3) {
        this(aVar, str, j2, j3, null, null);
        p.h(aVar, "mediaExtractorWrapper");
        p.h(str, "audioId");
        AppMethodBeat.i(93542);
        AppMethodBeat.o(93542);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", FirebaseAnalytics.b.INDEX, "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class b extends MediaCodec.Callback {
        final /* synthetic */ h ieL;
        final /* synthetic */ String ieM;
        final /* synthetic */ long ieN;
        final /* synthetic */ com.tencent.mm.media.f.a ieO;

        b(h hVar, String str, long j2, com.tencent.mm.media.f.a aVar) {
            this.ieL = hVar;
            this.ieM = str;
            this.ieN = j2;
            this.ieO = aVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(93537);
            p.h(mediaCodec, "codec");
            p.h(bufferInfo, "bufferInfo");
            try {
                Log.i(h.TAG, "onOutputBufferAvailable, index:" + i2 + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size + ", audioId:" + this.ieM);
                if (i2 >= 0) {
                    long j2 = bufferInfo.presentationTimeUs;
                    Log.i(h.TAG, "presentationTimeUs : ".concat(String.valueOf(j2)));
                    if (j2 < this.ieN * 1000 && (bufferInfo.flags & 4) == 0) {
                        z zVar = this.ieL.iec;
                        if (zVar != null) {
                            zVar.releaseOutputBuffer(i2, false);
                        }
                        Log.i(h.TAG, "decoder pts: " + j2 + ", not reach start: " + (this.ieN * 1000) + ", audioId:" + this.ieM);
                        AppMethodBeat.o(93537);
                    } else if (bufferInfo.size == 0) {
                        Log.i(h.TAG, "decode zero size:" + this.ieM + ", zeroCount:" + this.ieL.ieG);
                        this.ieL.ieG++;
                        z zVar2 = this.ieL.iec;
                        if (zVar2 != null) {
                            zVar2.releaseOutputBuffer(i2, false);
                            AppMethodBeat.o(93537);
                            return;
                        }
                        AppMethodBeat.o(93537);
                    } else {
                        z zVar3 = this.ieL.iec;
                        this.ieL.e(zVar3 != null ? zVar3.getOutputBuffer(i2) : null, bufferInfo);
                        z zVar4 = this.ieL.iec;
                        if (zVar4 != null) {
                            zVar4.releaseOutputBuffer(i2, false);
                        }
                        if (this.ieL.ieH * 1000 == 1 || j2 < this.ieL.ieH * 1000) {
                            if ((bufferInfo.flags & 4) != 0 || this.ieL.ieI) {
                                Log.i(h.TAG, "receive eos! audioId:" + this.ieM);
                                this.ieL.aMc();
                                AppMethodBeat.o(93537);
                                return;
                            }
                            AppMethodBeat.o(93537);
                            return;
                        }
                        Log.e(h.TAG, "exceed endTimeMs, audioId:" + this.ieM);
                        this.ieL.aMc();
                        AppMethodBeat.o(93537);
                    }
                } else {
                    z zVar5 = this.ieL.iec;
                    if (zVar5 != null) {
                        zVar5.releaseOutputBuffer(i2, false);
                        AppMethodBeat.o(93537);
                        return;
                    }
                    AppMethodBeat.o(93537);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(h.TAG, e2, "", new Object[0]);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            int i3;
            AppMethodBeat.i(93538);
            p.h(mediaCodec, "codec");
            try {
                Log.i(h.TAG, "onInputBufferAvailable, index:" + i2 + ", audioId:" + this.ieM);
                this.ieL.ief = Util.currentTicks();
                if (i2 < 0) {
                    AppMethodBeat.o(93538);
                    return;
                }
                z zVar = this.ieL.iec;
                ByteBuffer inputBuffer = zVar != null ? zVar.getInputBuffer(i2) : null;
                if (inputBuffer != null) {
                    inputBuffer.clear();
                }
                if (inputBuffer == null) {
                    AppMethodBeat.o(93538);
                    return;
                }
                this.ieL.ieI = false;
                if (!com.tencent.mm.media.f.a.a(this.ieO, inputBuffer)) {
                    Log.i(h.TAG, "read sample end");
                    this.ieL.ieI = true;
                }
                long j2 = 0;
                if (!this.ieL.ieI) {
                    i3 = this.ieO.sampleSize;
                    inputBuffer.position(0);
                    j2 = this.ieO.getSampleTime();
                    Log.i(h.TAG, "sampleTime : " + j2 + ", sampleSize:" + i3 + ", audioId:" + this.ieM);
                    if (i3 < 0 || j2 >= this.ieL.ieH * 1000) {
                        this.ieL.ieI = true;
                        Log.i(h.TAG, "sawInputEOS, audioId:" + this.ieM);
                    }
                } else {
                    i3 = 0;
                }
                z zVar2 = this.ieL.iec;
                if (zVar2 != null) {
                    zVar2.a(i2, i3, j2, this.ieL.ieI ? 4 : 0);
                    AppMethodBeat.o(93538);
                    return;
                }
                AppMethodBeat.o(93538);
            } catch (Exception e2) {
                Log.printErrStackTrace(h.TAG, e2, "", new Object[0]);
                AppMethodBeat.o(93538);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(93539);
            p.h(mediaCodec, "codec");
            p.h(mediaFormat, "format");
            this.ieL.ida = mediaFormat;
            MediaFormat mediaFormat2 = this.ieL.ida;
            if (mediaFormat2 != null && mediaFormat2.containsKey("sample-rate")) {
                MediaFormat mediaFormat3 = this.ieL.ida;
                int integer = mediaFormat3 != null ? mediaFormat3.getInteger("sample-rate") : 0;
                if (integer > 0) {
                    this.ieL.iee = integer;
                }
            }
            Log.i(h.TAG, "onOutputFormatChanged:" + this.ieL.ida + ", aacSampleRate:" + this.ieL.iee + ", audioId:" + this.ieM);
            AppMethodBeat.o(93539);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(218731);
            p.h(mediaCodec, "codec");
            p.h(codecException, "e");
            AppMethodBeat.o(218731);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$Companion;", "", "()V", "DecodePadingMs", "", "TAG", "", "ZeroCountUpperBound", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(93543);
        AppMethodBeat.o(93543);
    }

    @Override // com.tencent.mm.media.d.e
    public final void startDecoder() {
        AppMethodBeat.i(93540);
        try {
            z zVar = this.iec;
            if (zVar != null) {
                zVar.start();
            }
            Log.i(TAG, "startDecoder " + this.dtX);
            AppMethodBeat.o(93540);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "startDecoder error", new Object[0]);
            AppMethodBeat.o(93540);
        }
    }
}
