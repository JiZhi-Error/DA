package com.tencent.mm.plugin.appbrand.jsapi.video.e.a;

import android.os.Handler;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.h.w;
import com.google.android.exoplayer2.i.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Collections;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B3\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0016\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020\u0018R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter;", "Lcom/google/android/exoplayer2/upstream/TransferListener;", "", "eventHandler", "Landroid/os/Handler;", "eventListener", "Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;", "maxWeight", "", "clock", "Lcom/google/android/exoplayer2/util/Clock;", "(Landroid/os/Handler;Lcom/google/android/exoplayer2/upstream/BandwidthMeter$EventListener;ILcom/google/android/exoplayer2/util/Clock;)V", "bitrateEstimate", "", "sampleBytesTransferred", "sampleStartTimeMs", "slidingPercentile", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceSliding;", "streamCount", "totalBytesTransferred", "totalElapsedTimeMs", "getBitrateEstimate", "notifyBandwidthSample", "", "elapsedMs", "bytes", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "onBytesTransferred", "source", "onTransferEnd", "onTransferStart", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "resetBizrateEstimate", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class a implements d, w<Object> {
    private static final int mBA = 2000;
    private static final long mBB = mBB;
    private static final long mBC = 524288;
    public static final C0713a mBD = new C0713a((byte) 0);
    private final d.a bEX;
    private final c bEZ;
    private int bFa;
    private long bFb;
    private long bFc;
    private long bFd;
    private long bFe;
    long bFf;
    private final Handler eventHandler;
    private final b mBz;

    public a(byte b2) {
        this();
    }

    private a(int i2, c cVar) {
        p.h(cVar, "clock");
        AppMethodBeat.i(235227);
        this.eventHandler = null;
        this.bEX = null;
        this.bEZ = cVar;
        this.mBz = new b(i2);
        this.bFf = -1;
        AppMethodBeat.o(235227);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private /* synthetic */ a() {
        /*
            r4 = this;
            r3 = 235228(0x396dc, float:3.29625E-40)
            int r0 = com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a.mBA
            com.google.android.exoplayer2.i.c r1 = com.google.android.exoplayer2.i.c.bGS
            java.lang.String r2 = "Clock.DEFAULT"
            kotlin.g.b.p.g(r1, r2)
            r4.<init>(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a.<init>():void");
    }

    @Override // com.google.android.exoplayer2.h.d
    public final synchronized long wE() {
        return this.bFf;
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void a(Object obj, j jVar) {
        AppMethodBeat.i(235224);
        p.h(obj, "source");
        p.h(jVar, "dataSpec");
        if (this.bFa == 0) {
            this.bFb = this.bEZ.elapsedRealtime();
        }
        this.bFa++;
        AppMethodBeat.o(235224);
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void d(Object obj, int i2) {
        AppMethodBeat.i(235225);
        p.h(obj, "source");
        this.bFc += (long) i2;
        AppMethodBeat.o(235225);
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void ai(Object obj) {
        b.d dVar;
        synchronized (this) {
            AppMethodBeat.i(235226);
            p.h(obj, "source");
            com.google.android.exoplayer2.i.a.checkState(this.bFa > 0);
            long elapsedRealtime = this.bEZ.elapsedRealtime();
            int i2 = (int) (elapsedRealtime - this.bFb);
            this.bFd += (long) i2;
            this.bFe += this.bFc;
            if (i2 > 0) {
                float f2 = (float) ((this.bFc * 8000) / ((long) i2));
                b bVar = this.mBz;
                int sqrt = (int) Math.sqrt((double) this.bFc);
                if (bVar.bHz != 1) {
                    Collections.sort(bVar.bHx, b.bHu);
                    bVar.bHz = 1;
                }
                if (bVar.bHC > 0) {
                    bVar.bHC--;
                    dVar = bVar.mBI[bVar.bHC];
                } else {
                    dVar = new b.d();
                }
                if (dVar == null) {
                    p.hyc();
                }
                int i3 = bVar.bHA;
                bVar.bHA = i3 + 1;
                dVar.index = i3;
                dVar.weight = sqrt;
                dVar.value = f2;
                bVar.bHx.add(dVar);
                bVar.bHB += sqrt;
                while (bVar.bHB > bVar.bHw) {
                    int i4 = bVar.bHB - bVar.bHw;
                    b.d dVar2 = bVar.bHx.get(0);
                    p.g(dVar2, "this.samples[0]");
                    b.d dVar3 = dVar2;
                    if (dVar3.weight <= i4) {
                        bVar.bHB -= dVar3.weight;
                        bVar.bHx.remove(0);
                        if (bVar.bHC < 5) {
                            b.d[] dVarArr = bVar.mBI;
                            int i5 = bVar.bHC;
                            bVar.bHC = i5 + 1;
                            dVarArr[i5] = dVar3;
                        }
                    } else {
                        dVar3.weight -= i4;
                        bVar.bHB -= i4;
                    }
                }
                if (this.bFd >= mBB || this.bFe >= mBC) {
                    b bVar2 = this.mBz;
                    int size = bVar2.bHx.size();
                    float f3 = 0.0f;
                    for (int i6 = 0; i6 < size; i6++) {
                        f3 += bVar2.bHx.get(i6).value * (((float) bVar2.bHx.get(i6).weight) / ((float) bVar2.bHB));
                    }
                    float f4 = f3 == 0.0f ? bVar2.bHx.isEmpty() ? -1.0f : bVar2.bHx.get(bVar2.bHx.size() - 1).value : f3;
                    this.bFf = (Float.isNaN(f4) || f4 < 0.0f) ? -1 : (long) f4;
                }
            }
            long j2 = this.bFc;
            long j3 = this.bFf;
            if (!(this.eventHandler == null || this.bEX == null)) {
                this.eventHandler.post(new b(this, i2, j2, j3));
            }
            this.bFa--;
            if (this.bFa > 0) {
                this.bFb = elapsedRealtime;
            }
            this.bFc = 0;
            AppMethodBeat.o(235226);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a mBE;
        final /* synthetic */ int mBF;
        final /* synthetic */ long mBG;
        final /* synthetic */ long mBH;

        b(a aVar, int i2, long j2, long j3) {
            this.mBE = aVar;
            this.mBF = i2;
            this.mBG = j2;
            this.mBH = j3;
        }

        public final void run() {
            AppMethodBeat.i(235223);
            d.a unused = this.mBE.bEX;
            AppMethodBeat.o(235223);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/advance/AdvanceBandwidthMeter$Companion;", "", "()V", "BYTES_TRANSFERRED_FOR_ESTIMATE", "", "DEFAULT_MAX_WEIGHT", "", "getDEFAULT_MAX_WEIGHT", "()I", "ELAPSED_MILLIS_FOR_ESTIMATE", "luggage-commons-jsapi-video-ext_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.e.a.a$a  reason: collision with other inner class name */
    public static final class C0713a {
        private C0713a() {
        }

        public /* synthetic */ C0713a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(235229);
        AppMethodBeat.o(235229);
    }
}
