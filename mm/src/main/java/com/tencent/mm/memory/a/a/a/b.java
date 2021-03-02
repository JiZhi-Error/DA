package com.tencent.mm.memory.a.a.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b<T, V> {
    private ConcurrentLinkedQueue<Pair<T, f<T, V>>> iup = new ConcurrentLinkedQueue<>();
    private a iuq = null;
    a<T, V> iur;
    AbstractC0441b<T, V> ius;

    public interface a<K, O> {
        void D(K k, K k2);
    }

    /* renamed from: com.tencent.mm.memory.a.a.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0441b<K, O> {
        int e(K k, K k2, O o);
    }

    public b(a aVar, a<T, V> aVar2, AbstractC0441b<T, V> bVar) {
        AppMethodBeat.i(156510);
        this.iuq = aVar;
        this.iur = aVar2;
        this.ius = bVar;
        AppMethodBeat.o(156510);
    }

    /* access modifiers changed from: package-private */
    public final f<T, V> cc(final T t) {
        Pair<T, f<T, V>> poll;
        AppMethodBeat.i(156512);
        Iterator<Pair<T, f<T, V>>> it = this.iup.iterator();
        while (it.hasNext()) {
            Pair<T, f<T, V>> next = it.next();
            if (next != null && next.first != null && next.first.equals(t)) {
                f<T, V> fVar = (f) next.second;
                AppMethodBeat.o(156512);
                return fVar;
            }
        }
        if (!(this.iup.size() < this.iuq.iuo || (poll = this.iup.poll()) == null || poll.second == null)) {
            ((f) poll.second).trimToSize(-1);
        }
        a aVar = this.iuq;
        int i2 = (int) (((aVar.iun * ((double) aVar.iuk)) * 1.0d) / ((double) aVar.iuo));
        Log.i("MicroMsg.ExtraLruMap", "handlerMap %s %s", t, Integer.valueOf(i2));
        Pair<T, f<T, V>> pair = new Pair<>(t, new h(i2, new f.b<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.b.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.memory.a.a.a.b$a<T, V> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.b.f.b
            public final void c(T t, V v, V v2) {
                AppMethodBeat.i(156508);
                if (b.this.iur != null) {
                    b.this.iur.D(t, t);
                }
                AppMethodBeat.o(156508);
            }
        }, new f.c<T, V>() {
            /* class com.tencent.mm.memory.a.a.a.b.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.tencent.mm.memory.a.a.a.b$b<T, V> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mm.b.f.c
            public final int y(T t, V v) {
                AppMethodBeat.i(156509);
                if (b.this.ius != null) {
                    int e2 = b.this.ius.e(t, t, v);
                    AppMethodBeat.o(156509);
                    return e2;
                }
                AppMethodBeat.o(156509);
                return 0;
            }
        }));
        this.iup.add(pair);
        f<T, V> fVar2 = (f) pair.second;
        AppMethodBeat.o(156512);
        return fVar2;
    }

    public final boolean C(T t, T t2) {
        f fVar;
        AppMethodBeat.i(156511);
        Iterator<Pair<T, f<T, V>>> it = this.iup.iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            Pair<T, f<T, V>> next = it.next();
            if (next != null && next.first != null && next.first.equals(t)) {
                fVar = (f) next.second;
                break;
            }
        }
        if (fVar != null) {
            boolean check = fVar.check(t2);
            AppMethodBeat.o(156511);
            return check;
        }
        AppMethodBeat.o(156511);
        return false;
    }
}
