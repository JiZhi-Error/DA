package com.tencent.mm.media.d;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.media.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBZ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "outputFps", "", "enableHevc", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IZLkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class i extends f {
    public static final a ieP = new a((byte) 0);
    private final String TAG;
    private MediaCodec.BufferInfo bufferInfo;
    private volatile boolean ieI;

    static {
        AppMethodBeat.i(93548);
        AppMethodBeat.o(93548);
    }

    public /* synthetic */ i(long j2, com.tencent.mm.media.f.a aVar, b bVar) {
        this(0, j2, aVar, null, 0, false, bVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(long j2, long j3, com.tencent.mm.media.f.a aVar, Surface surface, int i2, boolean z, b<? super f, x> bVar) {
        super(j2, j3, aVar, surface, i2, z);
        p.h(aVar, "mediaExtractorWrapper");
        AppMethodBeat.i(259082);
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.TAG = "MicroMsg.MediaCodecTransDecoder";
        try {
            this.mediaFormat = aVar.igh;
            this.iec = z.DZ(aVar.aMs());
            z zVar = this.iec;
            if (zVar == null) {
                p.hyc();
            }
            zVar.a(this.mediaFormat, surface, 0);
            z zVar2 = this.iec;
            if (zVar2 == null) {
                p.hyc();
            }
            zVar2.start();
            if (bVar != null) {
                bVar.invoke(this);
                AppMethodBeat.o(259082);
                return;
            }
            AppMethodBeat.o(259082);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "create decoder error:" + e2.getMessage(), new Object[0]);
            IllegalStateException illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.o(259082);
            throw illegalStateException;
        }
    }

    @Override // com.tencent.mm.media.d.f
    public final void startDecode() {
        AppMethodBeat.i(93544);
        do {
        } while (!aMf());
        Log.i(this.TAG, "inputDecoder end");
        try {
            synchronized (this.ieu) {
                try {
                    if (this.isFinished) {
                        Log.i(this.TAG, "drainDecoder already finished");
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(93544);
                    throw th;
                }
            }
            Log.i(this.TAG, "sendDecoderEOS");
            z zVar = this.iec;
            if (zVar == null) {
                p.hyc();
            }
            ByteBuffer[] inputBuffers = zVar.getInputBuffers();
            z zVar2 = this.iec;
            if (zVar2 == null) {
                p.hyc();
            }
            int dequeueInputBuffer = zVar2.dequeueInputBuffer(Util.MILLSECONDS_OF_MINUTE);
            while (true) {
                if (dequeueInputBuffer < 0) {
                    if (aMg()) {
                        break;
                    }
                    z zVar3 = this.iec;
                    if (zVar3 == null) {
                        p.hyc();
                    }
                    dequeueInputBuffer = zVar3.dequeueInputBuffer(Util.MILLSECONDS_OF_MINUTE);
                } else {
                    if (dequeueInputBuffer >= 0) {
                        ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                        byteBuffer.clear();
                        com.tencent.mm.media.f.a aVar = this.iei;
                        if (aVar == null) {
                            p.hyc();
                        }
                        p.g(byteBuffer, "inputBuffer");
                        com.tencent.mm.media.f.a.a(aVar, byteBuffer);
                        long sampleTime = this.iei.getSampleTime();
                        byteBuffer.position(0);
                        if (dequeueInputBuffer >= 0) {
                            z zVar4 = this.iec;
                            if (zVar4 == null) {
                                p.hyc();
                            }
                            zVar4.a(dequeueInputBuffer, 0, sampleTime, 4);
                        }
                    }
                    aMg();
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "sendDecoderEOS error", new Object[0]);
        }
        releaseDecoder();
        kotlin.g.a.a<x> aVar2 = this.iep;
        if (aVar2 != null) {
            aVar2.invoke();
            AppMethodBeat.o(93544);
            return;
        }
        AppMethodBeat.o(93544);
    }

    private final boolean aMg() {
        b<? super MediaFormat, x> bVar;
        AppMethodBeat.i(93546);
        try {
            Log.i(this.TAG, "drainDecoder");
            synchronized (this.ieu) {
                try {
                    if (this.isFinished) {
                        Log.i(this.TAG, "drainDecoder already finished");
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(93546);
                }
            }
            z zVar = this.iec;
            if (zVar == null) {
                p.hyc();
            }
            int dequeueOutputBuffer = zVar.dequeueOutputBuffer(this.bufferInfo, 100);
            while (true) {
                if (dequeueOutputBuffer == -1) {
                    Log.i(this.TAG, "no output from decoder available, break");
                    break;
                } else if (dequeueOutputBuffer == -3) {
                    Log.i(this.TAG, "decoder output buffers changed");
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    z zVar2 = this.iec;
                    if (zVar2 == null) {
                        p.hyc();
                    }
                    this.mediaFormat = zVar2.getOutputFormat();
                    Log.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
                    MediaFormat mediaFormat = this.mediaFormat;
                    if (mediaFormat != null && (bVar = this.ieq) != null) {
                        bVar.invoke(mediaFormat);
                    }
                } else if (dequeueOutputBuffer < 0) {
                    Log.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)));
                    break;
                } else {
                    long j2 = this.bufferInfo.presentationTimeUs;
                    Log.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(j2)));
                    if (j2 >= this.startTimeMs * 1000 || (this.bufferInfo.flags & 4) != 0) {
                        if (this.bufferInfo.size == 0) {
                            z zVar3 = this.iec;
                            if (zVar3 == null) {
                                p.hyc();
                            }
                            zVar3.releaseOutputBuffer(dequeueOutputBuffer, false);
                            z zVar4 = this.iec;
                            if (zVar4 == null) {
                                p.hyc();
                            }
                            dequeueOutputBuffer = zVar4.dequeueOutputBuffer(this.bufferInfo, 100);
                            if (dequeueOutputBuffer < 0) {
                                break;
                            }
                        } else {
                            a(dequeueOutputBuffer, this.bufferInfo);
                            if (this.endTimeMs * 1000 != 1 && j2 >= this.endTimeMs * 1000) {
                                Log.e(this.TAG, "exceed endTimeMs");
                                AppMethodBeat.o(93546);
                                return true;
                            } else if ((this.bufferInfo.flags & 4) != 0) {
                                try {
                                    z zVar5 = this.iec;
                                    if (zVar5 == null) {
                                        p.hyc();
                                    }
                                    zVar5.stop();
                                    z zVar6 = this.iec;
                                    if (zVar6 == null) {
                                        p.hyc();
                                    }
                                    zVar6.release();
                                } catch (Exception e2) {
                                }
                                AppMethodBeat.o(93546);
                                return true;
                            } else {
                                AppMethodBeat.o(93546);
                                return false;
                            }
                        }
                    } else {
                        z zVar7 = this.iec;
                        if (zVar7 == null) {
                            p.hyc();
                        }
                        zVar7.releaseOutputBuffer(dequeueOutputBuffer, false);
                        Log.i(this.TAG, "decoder pts: " + j2 + ", not reach start: " + (this.startTimeMs * 1000));
                        AppMethodBeat.o(93546);
                        return false;
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            Log.printErrStackTrace(this.TAG, e3, "drainDecoder error", new Object[0]);
            if (this.iex) {
                e eVar = e.ilC;
                e.aOK();
            }
            AppMethodBeat.o(93546);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder$Companion;", "", "()V", "DECODE_TIMEOUT", "", InstanceID.ERROR_TIMEOUT, "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final boolean aMf() {
        AppMethodBeat.i(93545);
        try {
            synchronized (this.ieu) {
                try {
                    if (this.isFinished) {
                        Log.i(this.TAG, "inputDecoder already finished");
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(93545);
                }
            }
            Log.i(this.TAG, "inputDecoder");
            long currentTicks = Util.currentTicks();
            z zVar = this.iec;
            if (zVar == null) {
                p.hyc();
            }
            ByteBuffer[] inputBuffers = zVar.getInputBuffers();
            if (inputBuffers == null) {
                AppMethodBeat.o(93545);
                return false;
            }
            z zVar2 = this.iec;
            if (zVar2 == null) {
                p.hyc();
            }
            int dequeueInputBuffer = zVar2.dequeueInputBuffer(Util.MILLSECONDS_OF_MINUTE);
            int i2 = 0;
            while (dequeueInputBuffer < 0 && i2 < 15) {
                if (aMg()) {
                    return true;
                }
                z zVar3 = this.iec;
                if (zVar3 == null) {
                    p.hyc();
                }
                dequeueInputBuffer = zVar3.dequeueInputBuffer(Util.MILLSECONDS_OF_MINUTE);
                i2++;
            }
            this.ieI = false;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                com.tencent.mm.media.f.a aVar = this.iei;
                if (aVar == null) {
                    p.hyc();
                }
                p.g(byteBuffer, "inputBuffer");
                if (!com.tencent.mm.media.f.a.a(aVar, byteBuffer)) {
                    Log.i(this.TAG, "read sample end");
                    AppMethodBeat.o(93545);
                    return true;
                }
                long sampleTime = this.iei.getSampleTime();
                int i3 = this.iei.sampleSize;
                byteBuffer.position(0);
                Log.i(this.TAG, "sampleTime : " + sampleTime + " us");
                if (i3 < 0 || sampleTime >= this.endTimeMs * 1000) {
                    this.ieI = true;
                    Log.i(this.TAG, "sawInputEOS");
                }
                z zVar4 = this.iec;
                if (zVar4 == null) {
                    p.hyc();
                }
                zVar4.a(dequeueInputBuffer, i3, sampleTime, this.ieI ? 4 : 0);
            } else {
                Log.w(this.TAG, "input buffer not available");
            }
            boolean aMg = aMg();
            Log.i(this.TAG, "inputDecoder cost " + Util.ticksToNow(currentTicks));
            if (aMg) {
                Log.i(this.TAG, "drainDecoder eos");
                AppMethodBeat.o(93545);
                return true;
            }
            boolean z = this.ieI;
            AppMethodBeat.o(93545);
            return z;
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "inputDecoder error", new Object[0]);
            if (this.iex) {
                e eVar = e.ilC;
                e.aOK();
            }
            AppMethodBeat.o(93545);
            return true;
        }
    }
}
