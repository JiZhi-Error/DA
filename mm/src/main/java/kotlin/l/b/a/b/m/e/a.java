package kotlin.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T> {
    final T TPY;
    public final T TPZ;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.TPZ, r4.TPZ) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 61259(0xef4b, float:8.5842E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.b.a.b.m.e.a
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.m.e.a r4 = (kotlin.l.b.a.b.m.e.a) r4
            T r0 = r3.TPY
            T r1 = r4.TPY
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            T r0 = r3.TPZ
            T r1 = r4.TPZ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.e.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(61258);
        T t = this.TPY;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.TPZ;
        if (t2 != null) {
            i2 = t2.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(61258);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(61257);
        String str = "ApproximationBounds(lower=" + ((Object) this.TPY) + ", upper=" + ((Object) this.TPZ) + ")";
        AppMethodBeat.o(61257);
        return str;
    }

    public a(T t, T t2) {
        this.TPY = t;
        this.TPZ = t2;
    }
}
