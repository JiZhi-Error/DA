package com.tencent.f.j;

import com.tencent.f.j.d;
import com.tencent.f.j.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class b implements d.AbstractC0139d, e.a {
    private a RUV;

    /* access modifiers changed from: package-private */
    public interface a {
    }

    public b(a aVar) {
        this.RUV = aVar;
    }

    @Override // com.tencent.f.j.d.AbstractC0139d
    public final void a(e eVar) {
        AppMethodBeat.i(183408);
        eVar.RVg = this;
        eVar.RUL.g(eVar);
        AppMethodBeat.o(183408);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r0 >= r3) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r1 = r2.RVf[r0];
        r2.RVf[r0] = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r1.queueIdle() != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.RVe.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0083, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0084, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0085, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r2.RVe.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(183409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0092, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0095, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(183409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(183409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    @Override // com.tencent.f.j.e.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.f.j.a r8, com.tencent.f.j.e r9) {
        /*
        // Method dump skipped, instructions count: 165
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.f.j.b.a(com.tencent.f.j.a, com.tencent.f.j.e):void");
    }

    @Override // com.tencent.f.j.e.a
    public final void b(e eVar) {
        AppMethodBeat.i(183410);
        d dVar = eVar.serial.RUS;
        synchronized (dVar) {
            try {
                if (dVar.RVc.remove(eVar)) {
                    dVar.RVa.removeMessages(1, eVar);
                }
                Iterator<e> it = dVar.RVd.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (next == eVar) {
                        if (!next.isCancelled()) {
                            next.cancel(false);
                        }
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(183410);
            }
        }
    }
}
