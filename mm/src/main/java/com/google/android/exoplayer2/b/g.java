package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Exception;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private int bhm;
    private final Thread bhr;
    private final LinkedList<I> bhs = new LinkedList<>();
    private final LinkedList<O> bht = new LinkedList<>();
    protected final I[] bhu;
    private final O[] bhv;
    protected int bhw;
    private int bhx;
    private I bhy;
    private boolean bhz;
    private E exception;
    private final Object lock = new Object();
    private boolean released;

    /* access modifiers changed from: protected */
    public abstract E a(I i2, O o, boolean z);

    /* access modifiers changed from: protected */
    public abstract I uo();

    /* access modifiers changed from: protected */
    public abstract O up();

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.LinkedList<I extends com.google.android.exoplayer2.b.e> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.exoplayer2.b.c
    public final /* synthetic */ void af(Object obj) {
        e eVar = (e) obj;
        synchronized (this.lock) {
            a.checkArgument(eVar == this.bhy);
            this.bhs.addLast(eVar);
            ul();
            this.bhy = null;
        }
    }

    protected g(I[] iArr, O[] oArr) {
        this.bhu = iArr;
        this.bhw = 2;
        for (int i2 = 0; i2 < this.bhw; i2++) {
            this.bhu[i2] = uo();
        }
        this.bhv = oArr;
        this.bhx = 2;
        for (int i3 = 0; i3 < this.bhx; i3++) {
            this.bhv[i3] = up();
        }
        this.bhr = new Thread() {
            /* class com.google.android.exoplayer2.b.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(91856);
                do {
                    try {
                    } catch (InterruptedException e2) {
                        IllegalStateException illegalStateException = new IllegalStateException(e2);
                        AppMethodBeat.o(91856);
                        throw illegalStateException;
                    }
                } while (g.this.um());
                AppMethodBeat.o(91856);
            }
        };
        this.bhr.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: uj */
    public I uf() {
        I i2;
        I i3;
        synchronized (this.lock) {
            a.checkState(this.bhy == null);
            if (this.bhw == 0) {
                i2 = null;
            } else {
                I[] iArr = this.bhu;
                int i4 = this.bhw - 1;
                this.bhw = i4;
                i2 = iArr[i4];
            }
            this.bhy = i2;
            i3 = this.bhy;
        }
        return i3;
    }

    /* access modifiers changed from: private */
    /* renamed from: uk */
    public O ug() {
        O removeFirst;
        synchronized (this.lock) {
            if (this.bht.isEmpty()) {
                removeFirst = null;
            } else {
                removeFirst = this.bht.removeFirst();
            }
        }
        return removeFirst;
    }

    /* access modifiers changed from: protected */
    public void a(O o) {
        synchronized (this.lock) {
            b(o);
            ul();
        }
    }

    @Override // com.google.android.exoplayer2.b.c
    public final void flush() {
        synchronized (this.lock) {
            this.bhz = true;
            this.bhm = 0;
            if (this.bhy != null) {
                a(this.bhy);
                this.bhy = null;
            }
            while (!this.bhs.isEmpty()) {
                a(this.bhs.removeFirst());
            }
            while (!this.bht.isEmpty()) {
                b(this.bht.removeFirst());
            }
        }
    }

    @Override // com.google.android.exoplayer2.b.c
    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.bhr.join();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
        }
    }

    private void ul() {
        if (un()) {
            this.lock.notify();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if (r0.ud() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r3.dK(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r6.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r6.bhz == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r0.uc() == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r3.dK(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        r6.exception = a(r0, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        if (r6.exception == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0065, code lost:
        r2 = r6.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0067, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r3.uc() == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0074, code lost:
        r6.bhm++;
        b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0081, code lost:
        r3.bhm = r6.bhm;
        r6.bhm = 0;
        r6.bht.addLast(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean um() {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.um():boolean");
    }

    private boolean un() {
        return !this.bhs.isEmpty() && this.bhx > 0;
    }

    private void a(I i2) {
        i2.clear();
        I[] iArr = this.bhu;
        int i3 = this.bhw;
        this.bhw = i3 + 1;
        iArr[i3] = i2;
    }

    private void b(O o) {
        o.clear();
        O[] oArr = this.bhv;
        int i2 = this.bhx;
        this.bhx = i2 + 1;
        oArr[i2] = o;
    }
}
