package com.tencent.mm.media.e;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.view.Surface;
import android.widget.Toast;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0004J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fXD¢\u0006\u0004\n\u0002\b\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", InstanceID.ERROR_TIMEOUT, "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", FFmpegMetadataRetriever.METADATA_KEY_ENCODER, "Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxy;", "receivedEOS", "", "startTime", "drainEncoder", "encodeFrame", "pts", "finalize", "finishEncode", "getRecordTimes", "releaseEncoder", "Companion", "plugin-mediaeditor_release"})
public final class e extends b {
    public static final a ifs = new a((byte) 0);
    private final String TAG = "MicroMsg.MediaCodecTransEncoder";
    private final MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private HandlerThread ide;
    private MMHandler idf;
    private z ieT;
    private final long ifq = 50000;
    private boolean ifr;
    private long startTime;

    static {
        AppMethodBeat.i(93646);
        AppMethodBeat.o(93646);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(com.tencent.mm.media.b.d dVar, kotlin.g.a.b<? super b, x> bVar) {
        super(dVar, bVar);
        p.h(dVar, "videoCodecConfig");
        AppMethodBeat.i(218732);
        HandlerThread hB = com.tencent.f.c.d.hB("MediaCodecTransEncoder_encodeThread", 0);
        p.g(hB, "SpecialThreadFactory.cre….THREAD_PRIORITY_DEFAULT)");
        this.ide = hB;
        com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOm();
        Log.i(this.TAG, "create mp4encoder " + hashCode());
        z Eb = z.Eb(dVar.name);
        p.g(Eb, "MediaCodecProxy.createBy…me(videoCodecConfig.name)");
        this.ieT = Eb;
        this.ieT.a(dVar.aLU(), (Surface) null, 1);
        if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            if (p.j(aAh.azQ().get(ar.a.USERINFO_LOCAL_SIGHT_RECORD_THROW_ERROR_INT_SYNC, (Object) -1), 1)) {
                Toast.makeText(MMApplicationContext.getContext(), "remuxer 抛出异常", 0).show();
                IllegalStateException illegalStateException = new IllegalStateException("leex test error");
                AppMethodBeat.o(218732);
                throw illegalStateException;
            }
        }
        Surface createInputSurface = this.ieT.createInputSurface();
        p.g(createInputSurface, "encoder.createInputSurface()");
        g(createInputSurface);
        this.ieT.start();
        this.ide.start();
        this.idf = new MMHandler(this.ide.getLooper());
        Log.i(this.TAG, "create mp4encoder finish " + hashCode());
        bVar.invoke(this);
        AppMethodBeat.o(218732);
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMl() {
        AppMethodBeat.i(93640);
        if (0 == this.startTime) {
            this.startTime = Util.currentTicks();
        }
        this.idf.post(new b(this));
        AppMethodBeat.o(93640);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ e ift;

        b(e eVar) {
            this.ift = eVar;
        }

        public final void run() {
            AppMethodBeat.i(93637);
            long currentTicks = Util.currentTicks();
            synchronized (this.ift.iff) {
                try {
                    if (this.ift.ife || this.ift.ifd) {
                        Log.i(this.ift.TAG, "encodeFrame() stop encodeFrame " + this.ift.hashCode() + ", isRelease:" + this.ift.ife + ", isFinishEncode:" + this.ift.ifd);
                        return;
                    }
                    x xVar = x.SXb;
                    e.b(this.ift);
                    Log.d(this.ift.TAG, " drainEncoder cost " + Util.ticksToNow(currentTicks) + "  " + this.ift.hashCode());
                    AppMethodBeat.o(93637);
                } finally {
                    AppMethodBeat.o(93637);
                }
            }
        }
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMi() {
        AppMethodBeat.i(93641);
        if (this.ifr) {
            Log.e(this.TAG, "has received eos");
            AppMethodBeat.o(93641);
            return;
        }
        this.idf.removeCallbacksAndMessages(null);
        this.idf.post(new c(this));
        AppMethodBeat.o(93641);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ e ift;

        c(e eVar) {
            this.ift = eVar;
        }

        public final void run() {
            AppMethodBeat.i(93638);
            synchronized (this.ift.iff) {
                try {
                    if (this.ift.ifd || this.ift.ife || 0 == this.ift.startTime) {
                        Log.i(this.ift.TAG, "finishEncode() already finish " + this.ift.hashCode() + ", isFinishEncode:" + this.ift.ifd + ", isRelease:" + this.ift.ife + ", startTime:" + this.ift.startTime);
                        return;
                    }
                    x xVar = x.SXb;
                    try {
                        Log.i(this.ift.TAG, "finishEncode() hash:" + this.ift.hashCode() + "  isFinishEncode:" + this.ift.ifd + "  startTime:" + this.ift.startTime);
                        this.ift.ieT.signalEndOfInputStream();
                        this.ift.ifd = true;
                        e.b(this.ift);
                        AppMethodBeat.o(93638);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(this.ift.TAG, e2, "finishEncode " + this.ift.hashCode() + " \n signalEndOfInputStream error:" + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(93638);
                    }
                } finally {
                    AppMethodBeat.o(93638);
                }
            }
        }
    }

    @Override // com.tencent.mm.media.e.b
    public final void aMj() {
        AppMethodBeat.i(93642);
        Log.i(this.TAG, "try to release " + hashCode());
        this.idf.post(new d(this));
        AppMethodBeat.o(93642);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ e ift;

        d(e eVar) {
            this.ift = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = com.tencent.mm.sdk.platformtools.Util.currentTicks();
            com.tencent.mm.sdk.platformtools.Log.i(r6.ift.TAG, "releaseEncoder() start " + r6.ift.hashCode());
            r2 = r6.ift.ifc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
            if (r2 == null) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0061, code lost:
            r2.invoke();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
            r6.ift.idf.removeCallbacksAndMessages(null);
            r6.ift.ide.quitSafely();
            r6.ift.ieT.stop();
            r6.ift.ieT.release();
            r6.ift.aMk().release();
            r6.ift.ife = true;
            r2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOn();
            com.tencent.mm.sdk.platformtools.Log.i(r6.ift.TAG, "releaseEncoder() finish: time:" + com.tencent.mm.sdk.platformtools.Util.ticksToNow(r0) + ", " + r6.ift.hashCode());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x00ca, code lost:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93639);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
            com.tencent.mm.sdk.platformtools.Log.e(r6.ift.TAG, "release encoder error " + r6.ift.hashCode() + " \n " + r0.getMessage());
            com.tencent.matrix.trace.core.AppMethodBeat.o(93639);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 265
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.e.e.d.run():void");
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(93643);
        Log.i(this.TAG, "finalize");
        if (!this.ife) {
            this.ieT.release();
        }
        AppMethodBeat.o(93643);
    }

    @Override // com.tencent.mm.media.e.b
    public final long aMm() {
        AppMethodBeat.i(93644);
        long currentTicks = Util.currentTicks() - this.startTime;
        AppMethodBeat.o(93644);
        return currentTicks;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder$Companion;", "", "()V", InstanceID.ERROR_TIMEOUT, "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(93647);
        try {
            int dequeueOutputBuffer = eVar.ieT.dequeueOutputBuffer(eVar.bufferInfo, eVar.ifq);
            Log.i(eVar.TAG, "drainEncoder  outputBufferIndex : ".concat(String.valueOf(dequeueOutputBuffer)));
            int i2 = 0;
            while (true) {
                if (dequeueOutputBuffer == -1) {
                    Log.i(eVar.TAG, "outputBuffer try again later");
                } else if (dequeueOutputBuffer == -2) {
                    Log.i(eVar.TAG, "encoder output format changed " + eVar.ieT.getOutputFormat());
                } else if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer < 0) {
                        Log.e(eVar.TAG, "outputBufferIndex " + dequeueOutputBuffer + ", ignore");
                    } else {
                        Log.d(eVar.TAG, "outputBuffer index: ".concat(String.valueOf(dequeueOutputBuffer)));
                        ByteBuffer[] outputBuffers = eVar.ieT.getOutputBuffers();
                        Log.d(eVar.TAG, "getOutputBuffers");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            RuntimeException runtimeException = new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            AppMethodBeat.o(93647);
                            throw runtimeException;
                        }
                        Log.d(eVar.TAG, "outputBuffers[" + dequeueOutputBuffer + ']');
                        if ((eVar.bufferInfo.flags & 2) != 0) {
                            Log.i(eVar.TAG, "codec config!");
                        }
                        Log.i(eVar.TAG, "bufferInfo.flags : " + (eVar.bufferInfo.flags & 4));
                        if (eVar.bufferInfo.size != 0) {
                            byteBuffer.position(eVar.bufferInfo.offset);
                            byteBuffer.limit(eVar.bufferInfo.offset + eVar.bufferInfo.size);
                            eVar.f(byteBuffer, eVar.bufferInfo);
                            eVar.ieT.releaseOutputBuffer(dequeueOutputBuffer, true);
                        } else if ((eVar.bufferInfo.flags & 4) != 0) {
                            eVar.ifr = true;
                            Log.i(eVar.TAG, "encode end of stream");
                            eVar.aMj();
                            break;
                        } else {
                            Log.d(eVar.TAG, "bufferInfo.size == 0");
                        }
                    }
                }
                dequeueOutputBuffer = eVar.ieT.dequeueOutputBuffer(eVar.bufferInfo, eVar.ifq);
                Log.i(eVar.TAG, "dequeueOutputBuffer start  outputBufferIndex:" + dequeueOutputBuffer + "  timeout:" + i2 + "  " + eVar.hashCode());
                if (dequeueOutputBuffer < 0) {
                    i2++;
                } else {
                    i2 = 0;
                }
                if (dequeueOutputBuffer < 0 && i2 >= 3) {
                    break;
                }
            }
            if (eVar.ifd && i2 >= 3) {
                Log.i(eVar.TAG, "isFinishEncode && timeout >= 3");
                eVar.aMj();
                AppMethodBeat.o(93647);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(eVar.TAG, e2, "drainEncoder error " + eVar.hashCode() + ", \n " + e2.getMessage(), new Object[0]);
            if (eVar.iex) {
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aON();
            }
        }
        AppMethodBeat.o(93647);
    }
}
