package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import java.util.Collections;

public final class h implements b {
    private static long bFf;
    private static int mxY;
    private static long mxZ;
    private int bFa;
    private final Handler eventHandler;
    private final b.a mxU;
    private final c mxV;
    private final p mxW;
    private long mxX;
    private long startTimeMs;

    public h() {
        this((byte) 0);
    }

    public h(byte b2) {
        this(new q());
        AppMethodBeat.i(234726);
        AppMethodBeat.o(234726);
    }

    private h(c cVar) {
        this(null, null, cVar);
    }

    private h(Handler handler, b.a aVar, c cVar) {
        AppMethodBeat.i(234727);
        this.eventHandler = null;
        this.mxU = null;
        this.mxV = cVar;
        this.mxW = new p();
        bFf = -1;
        AppMethodBeat.o(234727);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.s
    public final synchronized void onTransferStart() {
        AppMethodBeat.i(234728);
        if (this.bFa == 0) {
            this.startTimeMs = this.mxV.elapsedRealtime();
        }
        this.bFa++;
        AppMethodBeat.o(234728);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.s
    public final synchronized void xx(int i2) {
        this.mxX += (long) i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.b.s
    public final synchronized void onTransferEnd() {
        p.a aVar;
        float f2;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(234729);
            a.checkState(this.bFa > 0);
            long elapsedRealtime = this.mxV.elapsedRealtime();
            int i3 = (int) (elapsedRealtime - this.startTimeMs);
            mxY = i3;
            if (i3 > 0) {
                float f3 = (float) ((this.mxX * 8000) / ((long) mxY));
                p pVar = this.mxW;
                int sqrt = (int) Math.sqrt((double) this.mxX);
                if (pVar.bHz != 1) {
                    Collections.sort(pVar.bHx, p.bHu);
                    pVar.bHz = 1;
                }
                if (pVar.bHC > 0) {
                    p.a[] aVarArr = pVar.myp;
                    int i4 = pVar.bHC - 1;
                    pVar.bHC = i4;
                    aVar = aVarArr[i4];
                } else {
                    aVar = new p.a((byte) 0);
                }
                int i5 = pVar.bHA;
                pVar.bHA = i5 + 1;
                aVar.index = i5;
                aVar.weight = sqrt;
                aVar.value = f3;
                pVar.bHx.add(aVar);
                pVar.bHB += sqrt;
                while (pVar.bHB > pVar.bHw) {
                    int i6 = pVar.bHB - pVar.bHw;
                    p.a aVar2 = pVar.bHx.get(0);
                    if (aVar2.weight <= i6) {
                        pVar.bHB -= aVar2.weight;
                        pVar.bHx.remove(0);
                        if (pVar.bHC < 5) {
                            p.a[] aVarArr2 = pVar.myp;
                            int i7 = pVar.bHC;
                            pVar.bHC = i7 + 1;
                            aVarArr2[i7] = aVar2;
                        }
                    } else {
                        aVar2.weight -= i6;
                        pVar.bHB -= i6;
                    }
                }
                p pVar2 = this.mxW;
                if (pVar2.bHz != 0) {
                    Collections.sort(pVar2.bHx, p.bHv);
                    pVar2.bHz = 0;
                }
                float f4 = 0.5f * ((float) pVar2.bHB);
                int i8 = 0;
                while (true) {
                    if (i8 < pVar2.bHx.size()) {
                        p.a aVar3 = pVar2.bHx.get(i8);
                        i2 = aVar3.weight + i2;
                        if (((float) i2) >= f4) {
                            f2 = aVar3.value;
                            break;
                        }
                        i8++;
                    } else {
                        f2 = pVar2.bHx.isEmpty() ? Float.NaN : pVar2.bHx.get(pVar2.bHx.size() - 1).value;
                    }
                }
                long j2 = Float.isNaN(f2) ? -1 : (long) f2;
                bFf = j2;
                mxZ = j2;
                final int i9 = mxY;
                final long j3 = this.mxX;
                final long j4 = bFf;
                if (!(this.eventHandler == null || this.mxU == null)) {
                    this.eventHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.video.b.b.h.AnonymousClass1 */

                        public final void run() {
                        }
                    });
                }
            }
            this.bFa--;
            if (this.bFa > 0) {
                this.startTimeMs = elapsedRealtime;
            }
            this.mxX = 0;
            AppMethodBeat.o(234729);
        }
    }
}
