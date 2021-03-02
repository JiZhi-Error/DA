package com.tencent.mm.plugin.appbrand.g.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.g;
import rx.internal.a.l;
import rx.internal.util.h;
import rx.schedulers.Schedulers;

public abstract class b<T> {
    public final d.c<T, T> llt = new d.c<T, T>() {
        /* class com.tencent.mm.plugin.appbrand.g.d.b.AnonymousClass1 */

        @Override // rx.b.e
        public final /* synthetic */ Object call(Object obj) {
            d<T> a2;
            AppMethodBeat.i(159033);
            d dVar = (d) obj;
            g io2 = Schedulers.io();
            if (dVar instanceof h) {
                a2 = ((h) dVar).b(io2);
            } else {
                a2 = d.a((d.a) new l(dVar, io2));
            }
            d<T> a3 = a2.a(a.bBF());
            AppMethodBeat.o(159033);
            return a3;
        }
    };
}
