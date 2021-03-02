package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import rx.j;

public final class b implements j {
    public volatile boolean UnB;
    private Set<j> UoK;

    @Override // rx.j
    public final boolean hQB() {
        return this.UnB;
    }

    public final void b(j jVar) {
        AppMethodBeat.i(90435);
        if (jVar.hQB()) {
            AppMethodBeat.o(90435);
            return;
        }
        if (!this.UnB) {
            synchronized (this) {
                try {
                    if (!this.UnB) {
                        if (this.UoK == null) {
                            this.UoK = new HashSet(4);
                        }
                        this.UoK.add(jVar);
                        return;
                    }
                } finally {
                    AppMethodBeat.o(90435);
                }
            }
        }
        jVar.hQA();
        AppMethodBeat.o(90435);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (r0 == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r3.hQA();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(rx.j r3) {
        /*
            r2 = this;
            r1 = 90436(0x16144, float:1.26728E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            boolean r0 = r2.UnB
            if (r0 != 0) goto L_0x0024
            monitor-enter(r2)
            boolean r0 = r2.UnB     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0013
            java.util.Set<rx.j> r0 = r2.UoK     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0018
        L_0x0013:
            monitor-exit(r2)     // Catch:{ all -> 0x0028 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
        L_0x0017:
            return
        L_0x0018:
            java.util.Set<rx.j> r0 = r2.UoK
            boolean r0 = r0.remove(r3)
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0024
            r3.hQA()
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x0017
        L_0x0028:
            r0 = move-exception
            monitor-exit(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.f.b.e(rx.j):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        C(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear() {
        /*
            r3 = this;
            r2 = 90437(0x16145, float:1.26729E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r3.UnB
            if (r0 != 0) goto L_0x0021
            monitor-enter(r3)
            boolean r0 = r3.UnB     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0013
            java.util.Set<rx.j> r0 = r3.UoK     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0018
        L_0x0013:
            monitor-exit(r3)     // Catch:{ all -> 0x0025 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0017:
            return
        L_0x0018:
            java.util.Set<rx.j> r0 = r3.UoK
            r1 = 0
            r3.UoK = r1
            monitor-exit(r3)
            C(r0)
        L_0x0021:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0017
        L_0x0025:
            r0 = move-exception
            monitor-exit(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.f.b.clear():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        C(r0);
     */
    @Override // rx.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hQA() {
        /*
            r3 = this;
            r2 = 90438(0x16146, float:1.2673E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = r3.UnB
            if (r0 != 0) goto L_0x0020
            monitor-enter(r3)
            boolean r0 = r3.UnB     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0014
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0013:
            return
        L_0x0014:
            r0 = 1
            r3.UnB = r0
            java.util.Set<rx.j> r0 = r3.UoK
            r1 = 0
            r3.UoK = r1
            monitor-exit(r3)
            C(r0)
        L_0x0020:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0013
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.f.b.hQA():void");
    }

    private static void C(Collection<j> collection) {
        ArrayList arrayList;
        AppMethodBeat.i(90439);
        if (collection == null) {
            AppMethodBeat.o(90439);
            return;
        }
        ArrayList arrayList2 = null;
        for (j jVar : collection) {
            try {
                jVar.hQA();
            } catch (Throwable th) {
                if (arrayList2 == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = arrayList2;
                }
                arrayList.add(th);
                arrayList2 = arrayList;
            }
        }
        rx.a.b.kP(arrayList2);
        AppMethodBeat.o(90439);
    }
}
