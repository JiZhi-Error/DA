package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.b.d;
import com.tencent.mm.media.k.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\f\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "releaseEncoder", "plugin-mediaeditor_release"})
public final class f extends b {
    final String TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    HandlerThread ide;
    z ieT;
    private Handler ifu;
    private a ifv;
    long startTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(d dVar, kotlin.g.a.b<? super b, x> bVar) {
        super(dVar, bVar);
        p.h(dVar, "videoCodecConfig");
        AppMethodBeat.i(93658);
        z Eb = z.Eb(dVar.name);
        p.g(Eb, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
        this.ieT = Eb;
        HandlerThread hB = com.tencent.f.c.d.hB("MediaCodecTransEncoder_encodeThread", 5);
        p.g(hB, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
        this.ide = hB;
        this.ifv = new a(this);
        Log.i(this.TAG, "MediaCodecTransEncoderAsync start");
        e eVar = e.ilC;
        e.aOo();
        e eVar2 = e.ilC;
        e.aNY();
        this.ieT.a(dVar.aLU(), (Surface) null, 1);
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            if (p.j(aAh.azQ().get(ar.a.USERINFO_LOCAL_SIGHT_REMUX_THROW_ERROR_INT_SYNC, (Object) -1), 1)) {
                Toast.makeText(MMApplicationContext.getContext(), "remuxer 抛出异常", 0).show();
                IllegalStateException illegalStateException = new IllegalStateException("leex test error");
                AppMethodBeat.o(93658);
                throw illegalStateException;
            }
        }
        Log.i(this.TAG, "MediaCodecTransEncoderAsync end");
        e eVar3 = e.ilC;
        e.aNZ();
        if (com.tencent.mm.compatible.util.d.oD(23)) {
            this.ide.start();
            this.ifu = new Handler(this.ide.getLooper());
            z zVar = this.ieT;
            a aVar = this.ifv;
            Handler handler = this.ifu;
            if (handler == null) {
                p.btv("encodeHandler");
            }
            zVar.setCallback(aVar, handler);
        } else {
            this.ieT.setCallback(this.ifv);
        }
        Surface createInputSurface = this.ieT.createInputSurface();
        p.g(createInputSurface, "encoder.createInputSurface()");
        g(createInputSurface);
        this.ieT.start();
        bVar.invoke(this);
        AppMethodBeat.o(93658);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", FirebaseAnalytics.b.INDEX, "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class a extends MediaCodec.Callback {
        final /* synthetic */ f ifw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(f fVar) {
            this.ifw = fVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            AppMethodBeat.i(93648);
            p.h(mediaCodec, "codec");
            p.h(bufferInfo, "bufferInfo");
            Log.d(this.ifw.TAG, "onOutputBufferAvailable index:" + i2 + ", info.size: " + bufferInfo.size);
            if (i2 >= 0) {
                try {
                    ByteBuffer outputBuffer = this.ifw.ieT.getOutputBuffer(i2);
                    if ((bufferInfo.flags & 2) != 0) {
                        Log.i(this.ifw.TAG, "codec config!");
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        Log.i(this.ifw.TAG, "encode end of stream");
                        this.ifw.aMj();
                        AppMethodBeat.o(93648);
                        return;
                    }
                    if (bufferInfo.size != 0) {
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        f fVar = this.ifw;
                        p.g(outputBuffer, "outputBuffer");
                        fVar.f(outputBuffer, bufferInfo);
                        this.ifw.ieT.releaseOutputBuffer(i2, bufferInfo.presentationTimeUs);
                    }
                    AppMethodBeat.o(93648);
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.ifw.TAG, e2, "onOutputBufferAvailable error", new Object[0]);
                    if (this.ifw.iex) {
                        e eVar = e.ilC;
                        e.aON();
                    }
                    AppMethodBeat.o(93648);
                }
            } else {
                this.ifw.ieT.releaseOutputBuffer(i2, false);
                AppMethodBeat.o(93648);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            AppMethodBeat.i(93649);
            p.h(mediaCodec, "codec");
            Log.i(this.ifw.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i2)));
            AppMethodBeat.o(93649);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(93650);
            p.h(mediaCodec, "codec");
            p.h(mediaFormat, "format");
            Log.i(this.ifw.TAG, "encoder output format changed " + this.ifw.ieT.getOutputFormat());
            AppMethodBeat.o(93650);
        }

        public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            AppMethodBeat.i(93651);
            p.h(mediaCodec, "codec");
            p.h(codecException, "e");
            Log.e(this.ifw.TAG, "codec Error, e:".concat(String.valueOf(codecException)));
            if (this.ifw.iex) {
                e eVar = e.ilC;
                e.aOO();
            }
            this.ifw.aMj();
            AppMethodBeat.o(93651);
        }
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMl() {
        AppMethodBeat.i(93654);
        if (0 == this.startTime) {
            this.startTime = Util.currentTicks();
        }
        AppMethodBeat.o(93654);
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMi() {
        AppMethodBeat.i(93655);
        try {
            Handler handler = this.ifu;
            if (handler == null) {
                p.btv("encodeHandler");
            }
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.ifu;
            if (handler2 == null) {
                p.btv("encodeHandler");
            }
            handler2.post(new b(this));
            AppMethodBeat.o(93655);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "finishEncode " + hashCode() + " \n signalEndOfInputStream error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(93655);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ f ifw;

        b(f fVar) {
            this.ifw = fVar;
        }

        public final void run() {
            AppMethodBeat.i(93652);
            synchronized (this.ifw.iff) {
                try {
                    if (this.ifw.ifd || this.ifw.ife || 0 == this.ifw.startTime) {
                        Log.i(this.ifw.TAG, "finishEncode() already finish " + this.ifw.hashCode() + ", isFinishEncode:" + this.ifw.ifd + ", isRelease:" + this.ifw.ife + ", startTime:" + this.ifw.startTime);
                        return;
                    }
                    x xVar = x.SXb;
                    Log.i(this.ifw.TAG, "finishEncode() hash:" + this.ifw.hashCode() + "  isFinishEncode:" + this.ifw.ifd + "  startTime:" + this.ifw.startTime);
                    this.ifw.ieT.signalEndOfInputStream();
                    this.ifw.ifd = true;
                    AppMethodBeat.o(93652);
                } finally {
                    AppMethodBeat.o(93652);
                }
            }
        }
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMj() {
        AppMethodBeat.i(93656);
        try {
            Handler handler = this.ifu;
            if (handler == null) {
                p.btv("encodeHandler");
            }
            handler.post(new c(this));
            AppMethodBeat.o(93656);
        } catch (Exception e2) {
            Log.e(this.TAG, "release encoder error " + e2.getMessage());
            AppMethodBeat.o(93656);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ f ifw;

        c(f fVar) {
            this.ifw = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
            r0 = com.tencent.mm.sdk.platformtools.Util.currentTicks();
            com.tencent.mm.sdk.platformtools.Log.i(r6.ifw.TAG, "releaseEncoder() start " + r6.ifw.hashCode());
            r2 = r6.ifw.ifc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
            if (r2 == null) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r2.invoke();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
            r6.ifw.ide.quitSafely();
            r6.ifw.ieT.stop();
            r6.ifw.ieT.release();
            r6.ifw.aMk().release();
            r6.ifw.ife = true;
            r2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOp();
            com.tencent.mm.sdk.platformtools.Log.i(r6.ifw.TAG, "releaseEncoder() finish: time:" + com.tencent.mm.sdk.platformtools.Util.ticksToNow(r0) + ", " + r6.ifw.hashCode());
            com.tencent.matrix.trace.core.AppMethodBeat.o(93653);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 191
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.e.f.c.run():void");
        }
    }

    @Override // com.tencent.mm.media.e.b
    public final long aMm() {
        AppMethodBeat.i(93657);
        long currentTicks = Util.currentTicks() - this.startTime;
        AppMethodBeat.o(93657);
        return currentTicks;
    }
}
