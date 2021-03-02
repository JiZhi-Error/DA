package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0015\u0018\u00002\u00020\u0001BZ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class j extends f {
    final String TAG;
    private HandlerThread decoderThread;
    volatile boolean ieI;
    private boolean ieQ;
    private final a ieR;

    public /* synthetic */ j(long j2, com.tencent.mm.media.f.a aVar, b bVar) {
        this(0, j2, aVar, null, 0, false, bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(long j2, long j3, com.tencent.mm.media.f.a aVar, Surface surface, int i2, boolean z, b<? super f, x> bVar) {
        super(j2, j3, aVar, surface, i2, z);
        p.h(aVar, "mediaExtractorWrapper");
        AppMethodBeat.i(259083);
        this.TAG = "MicroMsg.MediaCodecTransDecoderAsync";
        this.decoderThread = d.hB("MediaCodecTransDecoderAsync_decodeThread", 5);
        this.ieR = new a(this, aVar);
        try {
            this.mediaFormat = aVar.igh;
            this.iec = z.DZ(aVar.aMs());
            Log.i(this.TAG, "mediaExtractorWrapper.getVideoMIME() :" + aVar.aMs());
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                this.decoderThread.start();
                HandlerThread handlerThread = this.decoderThread;
                p.g(handlerThread, "decoderThread");
                Handler handler = new Handler(handlerThread.getLooper());
                z zVar = this.iec;
                if (zVar == null) {
                    p.hyc();
                }
                zVar.setCallback(this.ieR, handler);
            } else {
                z zVar2 = this.iec;
                if (zVar2 == null) {
                    p.hyc();
                }
                zVar2.setCallback(this.ieR);
            }
            z zVar3 = this.iec;
            if (zVar3 == null) {
                p.hyc();
            }
            zVar3.a(this.mediaFormat, surface, 0);
            if (bVar != null) {
                bVar.invoke(this);
                AppMethodBeat.o(259083);
                return;
            }
            AppMethodBeat.o(259083);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "create decoder error:" + e2.getMessage(), new Object[0]);
            IllegalStateException illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.o(259083);
            throw illegalStateException;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", FirebaseAnalytics.b.INDEX, "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class a extends MediaCodec.Callback {
        final /* synthetic */ com.tencent.mm.media.f.a ieO;
        final /* synthetic */ j ieS;

        a(j jVar, com.tencent.mm.media.f.a aVar) {
            this.ieS = jVar;
            this.ieO = aVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(93549);
            p.h(mediaCodec, "codec");
            p.h(bufferInfo, "bufferInfo");
            Log.i(this.ieS.TAG, "onOutputBufferAvailable, index:" + i2 + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size + ", isFinished:" + this.ieS.isFinished);
            if (i2 >= 0) {
                try {
                    long j2 = bufferInfo.presentationTimeUs;
                    Log.i(this.ieS.TAG, "presentationTimeUs : ".concat(String.valueOf(j2)));
                    if (j2 >= this.ieS.startTimeMs * 1000 || (bufferInfo.flags & 4) != 0) {
                        this.ieS.a(i2, bufferInfo);
                        if (this.ieS.endTimeMs * 1000 == 1 || j2 < this.ieS.endTimeMs * 1000) {
                            if ((bufferInfo.flags & 4) != 0 || this.ieS.ieI) {
                                Log.i(this.ieS.TAG, "receive eos!");
                                j.a(this.ieS);
                                this.ieS.releaseDecoder();
                                AppMethodBeat.o(93549);
                                return;
                            }
                            AppMethodBeat.o(93549);
                            return;
                        }
                        Log.e(this.ieS.TAG, "exceed endTimeMs");
                        j.a(this.ieS);
                        this.ieS.releaseDecoder();
                        AppMethodBeat.o(93549);
                        return;
                    }
                    z zVar = this.ieS.iec;
                    if (zVar == null) {
                        p.hyc();
                    }
                    zVar.releaseOutputBuffer(i2, false);
                    Log.i(this.ieS.TAG, "decoder pts: " + j2 + ", not reach start: " + (this.ieS.startTimeMs * 1000));
                    AppMethodBeat.o(93549);
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.ieS.TAG, e2, "onOutputBufferAvailable error", new Object[0]);
                    if (this.ieS.iex) {
                        e eVar = e.ilC;
                        e.aOK();
                    }
                }
            } else {
                z zVar2 = this.ieS.iec;
                if (zVar2 == null) {
                    p.hyc();
                }
                zVar2.releaseOutputBuffer(i2, false);
                AppMethodBeat.o(93549);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            AppMethodBeat.i(93550);
            p.h(mediaCodec, "codec");
            Log.i(this.ieS.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i2)));
            if (i2 >= 0) {
                try {
                    ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i2);
                    if (inputBuffer == null) {
                        t tVar = new t("null cannot be cast to non-null type java.nio.ByteBuffer");
                        AppMethodBeat.o(93550);
                        throw tVar;
                    }
                    inputBuffer.clear();
                    if (com.tencent.mm.media.f.a.a(this.ieO, inputBuffer)) {
                        long sampleTime = this.ieO.getSampleTime();
                        int i3 = this.ieO.sampleSize;
                        Log.i(this.ieS.TAG, "input sampleTime:" + sampleTime + ", sampleSize:" + i3);
                        inputBuffer.position(0);
                        z zVar = this.ieS.iec;
                        if (zVar == null) {
                            p.hyc();
                        }
                        zVar.a(i2, i3, sampleTime, 0);
                        AppMethodBeat.o(93550);
                        return;
                    }
                    Log.i(this.ieS.TAG, "read sample end");
                    this.ieS.ieI = true;
                    z zVar2 = this.ieS.iec;
                    if (zVar2 == null) {
                        p.hyc();
                    }
                    zVar2.a(i2, 0, 0, 4);
                    AppMethodBeat.o(93550);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.ieS.TAG, e2, "onInputBufferAvailable error", new Object[0]);
                    if (this.ieS.iex) {
                        e eVar = e.ilC;
                        e.aOK();
                    }
                }
            }
            AppMethodBeat.o(93550);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(93551);
            p.h(mediaCodec, "codec");
            p.h(mediaFormat, "format");
            this.ieS.mediaFormat = mediaFormat;
            Log.i(this.ieS.TAG, "decoder output format changed: " + this.ieS.mediaFormat);
            MediaFormat mediaFormat2 = this.ieS.mediaFormat;
            if (mediaFormat2 != null) {
                b<? super MediaFormat, x> bVar = this.ieS.ieq;
                if (bVar != null) {
                    bVar.invoke(mediaFormat2);
                    AppMethodBeat.o(93551);
                    return;
                }
                AppMethodBeat.o(93551);
                return;
            }
            AppMethodBeat.o(93551);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(93552);
            p.h(mediaCodec, "codec");
            p.h(codecException, "e");
            Log.e(this.ieS.TAG, "onError, codec:" + mediaCodec + ", " + codecException.isRecoverable() + ' ' + codecException.isTransient() + ' ' + codecException.getDiagnosticInfo());
            if (this.ieS.iex) {
                e eVar = e.ilC;
                e.aOL();
            }
            if (!codecException.isRecoverable() && !codecException.isTransient()) {
                e eVar2 = e.ilC;
                e.aOM();
                this.ieS.releaseDecoder();
                kotlin.g.a.a<x> aVar = this.ieS.ier;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(93552);
                    return;
                }
            }
            AppMethodBeat.o(93552);
        }
    }

    @Override // com.tencent.mm.media.d.f
    public final void releaseDecoder() {
        AppMethodBeat.i(93554);
        super.releaseDecoder();
        try {
            this.decoderThread.quit();
            AppMethodBeat.o(93554);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "releaseDecoder error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(93554);
        }
    }

    @Override // com.tencent.mm.media.d.f
    public final void startDecode() {
        AppMethodBeat.i(93553);
        try {
            z zVar = this.iec;
            if (zVar == null) {
                p.hyc();
            }
            zVar.start();
            AppMethodBeat.o(93553);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "startDecode error", new Object[0]);
            AppMethodBeat.o(93553);
        }
    }

    public static final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(93556);
        Log.i(jVar.TAG, "onDecodeEnd ");
        if (!jVar.ieQ) {
            kotlin.g.a.a<x> aVar = jVar.iep;
            if (aVar != null) {
                aVar.invoke();
            }
            jVar.ieQ = true;
        }
        AppMethodBeat.o(93556);
    }
}
