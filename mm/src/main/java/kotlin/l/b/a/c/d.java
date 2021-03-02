package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d<V> {
    private static final d<Object> TSq = new d<>(c.TSn);
    private final c<V> TSr;

    static {
        AppMethodBeat.i(61438);
        AppMethodBeat.o(61438);
    }

    public static <V> d<V> hMc() {
        return (d<V>) TSq;
    }

    private d(c<V> cVar) {
        this.TSr = cVar;
    }

    private d<V> a(c<V> cVar) {
        AppMethodBeat.i(61435);
        if (cVar == this.TSr) {
            AppMethodBeat.o(61435);
            return this;
        }
        d<V> dVar = new d<>(cVar);
        AppMethodBeat.o(61435);
        return dVar;
    }

    public final V get(int i2) {
        AppMethodBeat.i(61436);
        V v = this.TSr.get((long) i2);
        AppMethodBeat.o(61436);
        return v;
    }

    public final d<V> w(int i2, V v) {
        AppMethodBeat.i(61437);
        d<V> a2 = a(this.TSr.e((long) i2, v));
        AppMethodBeat.o(61437);
        return a2;
    }
}
