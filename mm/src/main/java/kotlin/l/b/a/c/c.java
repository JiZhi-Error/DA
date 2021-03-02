package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class c<V> {
    static final c<Object> TSn = new c<>();
    private final c<V> TSo;
    private final c<V> TSp;
    private final long key;
    private final int size;
    private final V value;

    static {
        AppMethodBeat.i(61434);
        AppMethodBeat.o(61434);
    }

    private c() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.TSo = null;
        this.TSp = null;
    }

    private c(long j2, V v, c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(61429);
        this.key = j2;
        this.value = v;
        this.TSo = cVar;
        this.TSp = cVar2;
        this.size = cVar.size + 1 + cVar2.size;
        AppMethodBeat.o(61429);
    }

    private c<V> Pk(long j2) {
        AppMethodBeat.i(61430);
        if (this.size == 0 || j2 == this.key) {
            AppMethodBeat.o(61430);
            return this;
        }
        c<V> cVar = new c<>(j2, this.value, this.TSo, this.TSp);
        AppMethodBeat.o(61430);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final V get(long j2) {
        long j3;
        c<V> cVar;
        while (true) {
            j2 -= j3;
            if (cVar.size == 0) {
                return null;
            }
            if (j2 < cVar.key) {
                cVar = cVar.TSo;
                j3 = cVar.key;
            } else if (j2 <= cVar.key) {
                return cVar.value;
            } else {
                cVar = cVar.TSp;
                j3 = cVar.key;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final c<V> e(long j2, V v) {
        AppMethodBeat.i(61431);
        if (this.size == 0) {
            c<V> cVar = new c<>(j2, v, this, this);
            AppMethodBeat.o(61431);
            return cVar;
        } else if (j2 < this.key) {
            c<V> a2 = a(this.TSo.e(j2 - this.key, v), this.TSp);
            AppMethodBeat.o(61431);
            return a2;
        } else if (j2 > this.key) {
            c<V> a3 = a(this.TSo, this.TSp.e(j2 - this.key, v));
            AppMethodBeat.o(61431);
            return a3;
        } else if (v == this.value) {
            AppMethodBeat.o(61431);
            return this;
        } else {
            c<V> cVar2 = new c<>(j2, v, this.TSo, this.TSp);
            AppMethodBeat.o(61431);
            return cVar2;
        }
    }

    private c<V> a(c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(61432);
        if (cVar == this.TSo && cVar2 == this.TSp) {
            AppMethodBeat.o(61432);
            return this;
        }
        c<V> a2 = a(this.key, this.value, cVar, cVar2);
        AppMethodBeat.o(61432);
        return a2;
    }

    private static <V> c<V> a(long j2, V v, c<V> cVar, c<V> cVar2) {
        AppMethodBeat.i(61433);
        if (((c) cVar).size + ((c) cVar2).size > 1) {
            if (((c) cVar).size >= ((c) cVar2).size * 5) {
                c<V> cVar3 = ((c) cVar).TSo;
                c<V> cVar4 = ((c) cVar).TSp;
                if (((c) cVar4).size < ((c) cVar3).size * 2) {
                    c<V> cVar5 = new c<>(((c) cVar).key + j2, ((c) cVar).value, cVar3, new c(-((c) cVar).key, v, cVar4.Pk(((c) cVar4).key + ((c) cVar).key), cVar2));
                    AppMethodBeat.o(61433);
                    return cVar5;
                }
                c<V> cVar6 = ((c) cVar4).TSo;
                c<V> cVar7 = ((c) cVar4).TSp;
                c<V> cVar8 = new c<>(((c) cVar4).key + ((c) cVar).key + j2, ((c) cVar4).value, new c(-((c) cVar4).key, ((c) cVar).value, cVar3, cVar6.Pk(((c) cVar6).key + ((c) cVar4).key)), new c((-((c) cVar).key) - ((c) cVar4).key, v, cVar7.Pk(((c) cVar4).key + ((c) cVar7).key + ((c) cVar).key), cVar2));
                AppMethodBeat.o(61433);
                return cVar8;
            } else if (((c) cVar2).size >= ((c) cVar).size * 5) {
                c<V> cVar9 = ((c) cVar2).TSo;
                c<V> cVar10 = ((c) cVar2).TSp;
                if (((c) cVar9).size < ((c) cVar10).size * 2) {
                    c<V> cVar11 = new c<>(((c) cVar2).key + j2, ((c) cVar2).value, new c(-((c) cVar2).key, v, cVar, cVar9.Pk(((c) cVar9).key + ((c) cVar2).key)), cVar10);
                    AppMethodBeat.o(61433);
                    return cVar11;
                }
                c<V> cVar12 = ((c) cVar9).TSo;
                c<V> cVar13 = ((c) cVar9).TSp;
                c<V> cVar14 = new c<>(((c) cVar9).key + ((c) cVar2).key + j2, ((c) cVar9).value, new c((-((c) cVar2).key) - ((c) cVar9).key, v, cVar, cVar12.Pk(((c) cVar12).key + ((c) cVar9).key + ((c) cVar2).key)), new c(-((c) cVar9).key, ((c) cVar2).value, cVar13.Pk(((c) cVar13).key + ((c) cVar9).key), cVar10));
                AppMethodBeat.o(61433);
                return cVar14;
            }
        }
        c<V> cVar15 = new c<>(j2, v, cVar, cVar2);
        AppMethodBeat.o(61433);
        return cVar15;
    }
}
