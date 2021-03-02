package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.a.b;
import rx.j;

public final class i implements j {
    public List<j> UnA;
    public volatile boolean UnB;

    public i() {
    }

    public i(j... jVarArr) {
        AppMethodBeat.i(90119);
        this.UnA = new LinkedList(Arrays.asList(jVarArr));
        AppMethodBeat.o(90119);
    }

    public i(j jVar) {
        AppMethodBeat.i(90120);
        this.UnA = new LinkedList();
        this.UnA.add(jVar);
        AppMethodBeat.o(90120);
    }

    @Override // rx.j
    public final boolean hQB() {
        return this.UnB;
    }

    public final void b(j jVar) {
        AppMethodBeat.i(90121);
        if (jVar.hQB()) {
            AppMethodBeat.o(90121);
            return;
        }
        if (!this.UnB) {
            synchronized (this) {
                try {
                    if (!this.UnB) {
                        List list = this.UnA;
                        if (list == null) {
                            list = new LinkedList();
                            this.UnA = list;
                        }
                        list.add(jVar);
                        return;
                    }
                } finally {
                    AppMethodBeat.o(90121);
                }
            }
        }
        jVar.hQA();
        AppMethodBeat.o(90121);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        C(r0);
     */
    @Override // rx.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hQA() {
        /*
            r3 = this;
            r2 = 90122(0x1600a, float:1.26288E-40)
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
            java.util.List<rx.j> r0 = r3.UnA
            r1 = 0
            r3.UnA = r1
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
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.i.hQA():void");
    }

    private static void C(Collection<j> collection) {
        ArrayList arrayList;
        AppMethodBeat.i(90123);
        if (collection == null) {
            AppMethodBeat.o(90123);
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
        b.kP(arrayList2);
        AppMethodBeat.o(90123);
    }
}
