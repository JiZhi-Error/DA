package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V> {
    private static final b<Object, Object> TSl = new b<>(d.hMc(), 0);
    private final d<a<e<K, V>>> TSm;
    private final int size;

    static {
        AppMethodBeat.i(61428);
        AppMethodBeat.o(61428);
    }

    public static <K, V> b<K, V> hMb() {
        AppMethodBeat.i(61424);
        b<K, V> bVar = (b<K, V>) TSl;
        if (bVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/pcollections/HashPMap", "empty"));
            AppMethodBeat.o(61424);
            throw illegalStateException;
        }
        AppMethodBeat.o(61424);
        return bVar;
    }

    private b(d<a<e<K, V>>> dVar, int i2) {
        this.TSm = dVar;
        this.size = i2;
    }

    public final b<K, V> X(K k, V v) {
        AppMethodBeat.i(61425);
        a<e<K, V>> avQ = avQ(k.hashCode());
        int i2 = avQ.size;
        int a2 = a(avQ, k);
        if (a2 != -1) {
            avQ = avQ.avO(a2);
        }
        a<e<K, V>> fK = avQ.fK(new e<>(k, v));
        b<K, V> bVar = new b<>(this.TSm.w(k.hashCode(), fK), fK.size + (this.size - i2));
        AppMethodBeat.o(61425);
        return bVar;
    }

    public final a<e<K, V>> avQ(int i2) {
        AppMethodBeat.i(61426);
        a<e<K, V>> aVar = this.TSm.get(i2);
        if (aVar == null) {
            a<e<K, V>> hMa = a.hMa();
            AppMethodBeat.o(61426);
            return hMa;
        }
        AppMethodBeat.o(61426);
        return aVar;
    }

    private static <K, V> int a(a<e<K, V>> aVar, Object obj) {
        AppMethodBeat.i(61427);
        int i2 = 0;
        while (aVar != null && aVar.size > 0) {
            if (aVar.first.key.equals(obj)) {
                AppMethodBeat.o(61427);
                return i2;
            }
            aVar = aVar.TSj;
            i2++;
        }
        AppMethodBeat.o(61427);
        return -1;
    }
}
