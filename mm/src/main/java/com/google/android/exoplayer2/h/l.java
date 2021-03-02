package com.google.android.exoplayer2.h;

import android.os.Handler;
import com.google.android.exoplayer2.h.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import java.util.Collections;

public final class l implements d, w<Object> {
    private final d.a bEX;
    private final r bEY;
    private final c bEZ;
    private int bFa;
    private long bFb;
    private long bFc;
    private long bFd;
    private long bFe;
    private long bFf;
    private final Handler eventHandler;

    public l() {
        this(null, null);
    }

    public l(Handler handler, d.a aVar) {
        this(handler, aVar, (byte) 0);
    }

    private l(Handler handler, d.a aVar, byte b2) {
        this(handler, aVar, c.bGS);
    }

    private l(Handler handler, d.a aVar, c cVar) {
        AppMethodBeat.i(93056);
        this.eventHandler = handler;
        this.bEX = aVar;
        this.bEY = new r(2000);
        this.bEZ = cVar;
        this.bFf = -1;
        AppMethodBeat.o(93056);
    }

    @Override // com.google.android.exoplayer2.h.d
    public final synchronized long wE() {
        return this.bFf;
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void a(Object obj, j jVar) {
        AppMethodBeat.i(196064);
        if (this.bFa == 0) {
            this.bFb = this.bEZ.elapsedRealtime();
        }
        this.bFa++;
        AppMethodBeat.o(196064);
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void d(Object obj, int i2) {
        this.bFc += (long) i2;
    }

    @Override // com.google.android.exoplayer2.h.w
    public final synchronized void ai(Object obj) {
        r.a aVar;
        float f2;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(196065);
            a.checkState(this.bFa > 0);
            long elapsedRealtime = this.bEZ.elapsedRealtime();
            final int i3 = (int) (elapsedRealtime - this.bFb);
            this.bFd += (long) i3;
            this.bFe += this.bFc;
            if (i3 > 0) {
                float f3 = (float) ((this.bFc * 8000) / ((long) i3));
                r rVar = this.bEY;
                int sqrt = (int) Math.sqrt((double) this.bFc);
                if (rVar.bHz != 1) {
                    Collections.sort(rVar.bHx, r.bHu);
                    rVar.bHz = 1;
                }
                if (rVar.bHC > 0) {
                    r.a[] aVarArr = rVar.bHy;
                    int i4 = rVar.bHC - 1;
                    rVar.bHC = i4;
                    aVar = aVarArr[i4];
                } else {
                    aVar = new r.a((byte) 0);
                }
                int i5 = rVar.bHA;
                rVar.bHA = i5 + 1;
                aVar.index = i5;
                aVar.weight = sqrt;
                aVar.value = f3;
                rVar.bHx.add(aVar);
                rVar.bHB += sqrt;
                while (rVar.bHB > rVar.bHw) {
                    int i6 = rVar.bHB - rVar.bHw;
                    r.a aVar2 = rVar.bHx.get(0);
                    if (aVar2.weight <= i6) {
                        rVar.bHB -= aVar2.weight;
                        rVar.bHx.remove(0);
                        if (rVar.bHC < 5) {
                            r.a[] aVarArr2 = rVar.bHy;
                            int i7 = rVar.bHC;
                            rVar.bHC = i7 + 1;
                            aVarArr2[i7] = aVar2;
                        }
                    } else {
                        aVar2.weight -= i6;
                        rVar.bHB -= i6;
                    }
                }
                if (this.bFd >= 2000 || this.bFe >= g.ACTION_MINI_PROGRAM_LAUNCH) {
                    r rVar2 = this.bEY;
                    if (rVar2.bHz != 0) {
                        Collections.sort(rVar2.bHx, r.bHv);
                        rVar2.bHz = 0;
                    }
                    float f4 = 0.5f * ((float) rVar2.bHB);
                    int i8 = 0;
                    while (true) {
                        if (i8 < rVar2.bHx.size()) {
                            r.a aVar3 = rVar2.bHx.get(i8);
                            i2 = aVar3.weight + i2;
                            if (((float) i2) >= f4) {
                                f2 = aVar3.value;
                                break;
                            }
                            i8++;
                        } else {
                            f2 = rVar2.bHx.isEmpty() ? Float.NaN : rVar2.bHx.get(rVar2.bHx.size() - 1).value;
                        }
                    }
                    this.bFf = Float.isNaN(f2) ? -1 : (long) f2;
                }
            }
            final long j2 = this.bFc;
            final long j3 = this.bFf;
            if (!(this.eventHandler == null || this.bEX == null)) {
                this.eventHandler.post(new Runnable() {
                    /* class com.google.android.exoplayer2.h.l.AnonymousClass1 */

                    public final void run() {
                    }
                });
            }
            int i9 = this.bFa - 1;
            this.bFa = i9;
            if (i9 > 0) {
                this.bFb = elapsedRealtime;
            }
            this.bFc = 0;
            AppMethodBeat.o(196065);
        }
    }
}
