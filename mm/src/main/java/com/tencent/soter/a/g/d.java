package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.e;

public abstract class d {
    boolean RQG = false;
    public b RQW;

    /* access modifiers changed from: package-private */
    public abstract void b(e eVar);

    /* access modifiers changed from: package-private */
    public abstract void execute();

    /* access modifiers changed from: package-private */
    public abstract boolean hlM();

    /* access modifiers changed from: package-private */
    public abstract void hlN();

    /* access modifiers changed from: package-private */
    public final synchronized void c(final e eVar) {
        if (this.RQG) {
            com.tencent.soter.core.c.d.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            b(eVar);
            f hlO = f.hlO();
            com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: removing task: %d", Integer.valueOf(hashCode()));
            synchronized (hlO.RRi) {
                if (f.RRh.get(hashCode()) == null) {
                    com.tencent.soter.core.c.d.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(hashCode()));
                } else {
                    f.RRh.remove(hashCode());
                }
            }
            g.hlR().postToMainThread(new Runnable() {
                /* class com.tencent.soter.a.g.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(30);
                    d dVar = d.this;
                    e eVar = eVar;
                    if (dVar.RQW != null && !dVar.RQG) {
                        dVar.RQW.a(eVar);
                        dVar.RQG = true;
                    }
                    AppMethodBeat.o(30);
                }
            });
        }
    }
}
