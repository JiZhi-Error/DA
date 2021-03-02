package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    /* renamed from: com.tencent.mm.co.a$a  reason: collision with other inner class name */
    public interface AbstractC0297a<_Callback> {
        void bw(_Callback _callback);
    }

    public a() {
        super(new e());
        AppMethodBeat.i(158413);
        AppMethodBeat.o(158413);
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final AbstractC0297a<_Callback> aVar) {
        AppMethodBeat.i(158414);
        Iterator<b> it = getQueue().iterator();
        while (it.hasNext()) {
            final b next = it.next();
            if (next != null) {
                if (next.mScheduler != null) {
                    this.mSchedulerInvoker.c(next.mScheduler);
                    this.mSchedulerInvoker.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                        /* class com.tencent.mm.co.a.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(Void r4) {
                            AppMethodBeat.i(158412);
                            Void r42 = r4;
                            aVar.bw(next.QZG);
                            AppMethodBeat.o(158412);
                            return r42;
                        }
                    }, com.tencent.mm.vending.c.a.QZL, true);
                } else {
                    aVar.bw(next.QZG);
                }
            }
        }
        AppMethodBeat.o(158414);
    }

    public b<_Callback> add(_Callback _callback) {
        AppMethodBeat.i(158415);
        b<_Callback> add = super.add(new b(_callback, this));
        AppMethodBeat.o(158415);
        return add;
    }

    public final void remove(_Callback _callback) {
        AppMethodBeat.i(158416);
        super.remove(new b(_callback, this));
        AppMethodBeat.o(158416);
    }
}
