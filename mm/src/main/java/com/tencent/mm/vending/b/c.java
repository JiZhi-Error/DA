package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _callback, a aVar);

    public c() {
    }

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void invoke() {
        a(null);
    }

    public final synchronized void invoke(a aVar) {
        a(aVar);
    }

    private void a(final a aVar) {
        Iterator<b> it = getQueueImpl().iterator();
        while (it.hasNext()) {
            final b next = it.next();
            if (next != null) {
                if (next.mScheduler != null) {
                    this.mSchedulerInvoker.c(next.mScheduler);
                } else {
                    this.mSchedulerInvoker.c(d.current());
                }
                this.mSchedulerInvoker.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                    /* class com.tencent.mm.vending.b.c.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Void r5) {
                        AppMethodBeat.i(74904);
                        Void r52 = r5;
                        c.this.a(next.QZG, aVar);
                        AppMethodBeat.o(74904);
                        return r52;
                    }
                }, com.tencent.mm.vending.c.a.QZL, true);
            }
        }
    }

    public final b<_Callback> add(_Callback _callback) {
        return add(new b(_callback, this));
    }

    public final void remove(_Callback _callback) {
        remove(new b(_callback, this));
    }
}
