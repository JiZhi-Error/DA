package com.tencent.mm.media.e;

import com.tencent.f.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/media/encoder/X264TransEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "width", "height", "(III)V", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeThreadStart", "", "frameCount", "isCancel", "isStop", "startTime", "", "stopLock", "Ljava/lang/Object;", "writeDataThread", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThreadLoop", "", "getFrameCount", "getRecordTimes", "start", "stop", "writeRGBData", "data", "Ljava/nio/Buffer;", "", "Companion", "plugin-mediaeditor_release"})
public final class g {
    public static final a ifC = new a((byte) 0);
    public final int bufId;
    public int frameCount;
    private final int height;
    private int ifA;
    public boolean ifB;
    public f<?> ifx;
    public final MMHandler ify = new MMHandler("X264TransEncoder_writeDataThread");
    public boolean ifz;
    public boolean isStop;
    public long startTime;
    public final Object stopLock = new Object();
    private final int width;

    static {
        AppMethodBeat.i(93666);
        AppMethodBeat.o(93666);
    }

    public g(int i2, int i3, int i4) {
        AppMethodBeat.i(93665);
        this.bufId = i2;
        this.width = i3;
        this.height = i4;
        Log.i("MicroMsg.X264TransEncoder", "create X264TransEncoder, width:" + this.width + ", height:" + this.height);
        AppMethodBeat.o(93665);
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.tencent.f.e.f<R>, com.tencent.f.e.f<?> */
    public final void start() {
        AppMethodBeat.i(93661);
        this.isStop = false;
        this.ifz = false;
        this.frameCount = 0;
        this.startTime = Util.currentTicks();
        SightVideoJNI.setRotateForBufId(this.bufId, 0);
        this.ifx = (f<R>) f.hmn().hms().c(new b(this));
        this.ifB = false;
        Log.i("MicroMsg.X264TransEncoder", "start");
        AppMethodBeat.o(93661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransEncoder$writeRGBData$1$1"})
    public static final class c implements Runnable {
        final /* synthetic */ g ifD;
        final /* synthetic */ int ifE;
        final /* synthetic */ int ifF;
        final /* synthetic */ int[] ifG;

        public c(g gVar, int i2, int i3, int[] iArr) {
            this.ifD = gVar;
            this.ifE = i2;
            this.ifF = i3;
            this.ifG = iArr;
        }

        public final void run() {
            AppMethodBeat.i(93660);
            if (this.ifD.isStop || this.ifD.ifz) {
                Log.e("MicroMsg.X264TransEncoder", "writeRGBData, already stop or cancel, ignore");
                AppMethodBeat.o(93660);
                return;
            }
            long currentTicks = Util.currentTicks();
            byte[] h2 = k.zwi.h(Integer.valueOf(((this.ifE * this.ifF) * 3) / 2));
            SightVideoJNI.rgbaToNV21(this.ifG, h2, this.ifE, this.ifF);
            Log.i("MicroMsg.X264TransEncoder", "rgbaToNV21 cost " + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
            long currentTicks2 = Util.currentTicks();
            SightVideoJNI.writeYuvDataForMMSight(this.ifD.bufId, h2, h2.length, this.ifE, this.ifF, false, false, this.ifE, this.ifF);
            StringBuilder append = new StringBuilder("writeRGBData ").append(this.ifE).append(", ").append(this.ifF).append(" cost ").append(Util.ticksToNow(currentTicks2)).append("ms, ");
            g gVar = this.ifD;
            int i2 = gVar.frameCount;
            gVar.frameCount = i2 + 1;
            Log.i("MicroMsg.X264TransEncoder", append.append(i2).toString());
            k.zwi.k(h2);
            if (!this.ifD.ifB) {
                f fVar = this.ifD.ifx;
                if (fVar != null) {
                    fVar.begin();
                }
                this.ifD.ifB = true;
            }
            AppMethodBeat.o(93660);
        }
    }

    public static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(93664);
        gVar.stop(false);
        AppMethodBeat.o(93664);
    }

    public final void stop(boolean z) {
        AppMethodBeat.i(93663);
        Log.i("MicroMsg.X264TransEncoder", "stop isCancel:".concat(String.valueOf(z)));
        long currentTicks = Util.currentTicks();
        synchronized (this.stopLock) {
            try {
                this.isStop = true;
                this.ifz = z;
                this.ify.quit();
                f<?> fVar = this.ifx;
                if (fVar != null) {
                    fVar.take();
                }
                Log.i("MicroMsg.X264TransEncoder", "stop finish, cost:" + Util.ticksToNow(currentTicks) + LocaleUtil.MALAY);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(93663);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/encoder/X264TransEncoder$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
    static final class b<I, O> implements com.tencent.f.e.a<E, R> {
        final /* synthetic */ g ifD;

        b(g gVar) {
            this.ifD = gVar;
        }

        @Override // com.tencent.f.e.a
        public final /* synthetic */ Object bT(Object obj) {
            AppMethodBeat.i(184138);
            g.b(this.ifD);
            x xVar = x.SXb;
            AppMethodBeat.o(184138);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(g gVar) {
        AppMethodBeat.i(93667);
        while (!gVar.isStop) {
            long currentTicks = Util.currentTicks();
            int triggerEncode = SightVideoJNI.triggerEncode(gVar.bufId, Math.max(0, gVar.ifA), false);
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i("MicroMsg.X264TransEncoder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(gVar.ifA), Integer.valueOf(triggerEncode), Long.valueOf(currentThread.getId()));
            if (Math.abs(triggerEncode - gVar.ifA) <= 5) {
                try {
                    Thread.sleep(100);
                } catch (Exception e2) {
                    Log.e("MicroMsg.X264TransEncoder", "thread sleep error");
                }
            }
            gVar.ifA = triggerEncode;
        }
        long currentTicks2 = Util.currentTicks();
        if (!gVar.ifz) {
            gVar.ifA = SightVideoJNI.triggerEncode(gVar.bufId, gVar.ifA, true);
        }
        Thread currentThread2 = Thread.currentThread();
        p.g(currentThread2, "Thread.currentThread()");
        Log.i("MicroMsg.X264TransEncoder", "end: trgger encode use %dms, curEncode index %d, markCancel %s, threadId: %s", Long.valueOf(Util.ticksToNow(currentTicks2)), Integer.valueOf(gVar.ifA), Boolean.valueOf(gVar.ifz), Long.valueOf(currentThread2.getId()));
        AppMethodBeat.o(93667);
    }
}
