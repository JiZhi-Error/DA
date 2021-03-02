package rx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;
import rx.internal.a.c;

public final class b<T> implements e<T> {
    private boolean Ukt;
    private final c<T> Ukv = c.hQG();
    private final e<? super T> UnG;
    private a UnH;
    private volatile boolean terminated;

    static final class a {
        Object[] SYh;
        int size;

        a() {
        }

        public final void add(Object obj) {
            Object[] objArr;
            AppMethodBeat.i(90427);
            int i2 = this.size;
            Object[] objArr2 = this.SYh;
            if (objArr2 == null) {
                objArr = new Object[16];
                this.SYh = objArr;
            } else if (i2 == objArr2.length) {
                objArr = new Object[((i2 >> 2) + i2)];
                System.arraycopy(objArr2, 0, objArr, 0, i2);
                this.SYh = objArr;
            } else {
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.size = i2 + 1;
            AppMethodBeat.o(90427);
        }
    }

    public b(e<? super T> eVar) {
        AppMethodBeat.i(90428);
        this.UnG = eVar;
        AppMethodBeat.o(90428);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r8.UnG.gL(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = r8.UnH;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        if (r0 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
        r8.Ukt = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90429);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        r8.terminated = true;
        rx.a.b.a(r0, r8.UnG, r9);
        com.tencent.matrix.trace.core.AppMethodBeat.o(90429);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
        r8.UnH = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
        r2 = r0.SYh;
        r3 = r2.length;
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0065, code lost:
        if (r0 >= r3) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0067, code lost:
        r4 = r2[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0069, code lost:
        if (r4 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0071, code lost:
        if (rx.internal.a.c.a(r8.UnG, r4) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0073, code lost:
        r8.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(90429);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0080, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0081, code lost:
        r8.terminated = true;
        rx.a.b.N(r0);
        r8.UnG.onError(rx.a.g.a(r0, r9));
        com.tencent.matrix.trace.core.AppMethodBeat.o(90429);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0094, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    @Override // rx.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void gL(T r9) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.c.b.gL(java.lang.Object):void");
    }

    @Override // rx.e
    public final void onError(Throwable th) {
        AppMethodBeat.i(90430);
        rx.a.b.N(th);
        if (this.terminated) {
            AppMethodBeat.o(90430);
            return;
        }
        synchronized (this) {
            try {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.Ukt) {
                        a aVar = this.UnH;
                        if (aVar == null) {
                            aVar = new a();
                            this.UnH = aVar;
                        }
                        aVar.add(c.P(th));
                        AppMethodBeat.o(90430);
                        return;
                    }
                    this.Ukt = true;
                    this.UnG.onError(th);
                    AppMethodBeat.o(90430);
                }
            } finally {
                AppMethodBeat.o(90430);
            }
        }
    }

    @Override // rx.e
    public final void hQw() {
        AppMethodBeat.i(90431);
        if (this.terminated) {
            AppMethodBeat.o(90431);
            return;
        }
        synchronized (this) {
            try {
                if (!this.terminated) {
                    this.terminated = true;
                    if (this.Ukt) {
                        a aVar = this.UnH;
                        if (aVar == null) {
                            aVar = new a();
                            this.UnH = aVar;
                        }
                        aVar.add(c.hQH());
                        AppMethodBeat.o(90431);
                        return;
                    }
                    this.Ukt = true;
                    this.UnG.hQw();
                    AppMethodBeat.o(90431);
                }
            } finally {
                AppMethodBeat.o(90431);
            }
        }
    }
}
