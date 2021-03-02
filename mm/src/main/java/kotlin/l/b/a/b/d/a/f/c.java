package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;

/* access modifiers changed from: package-private */
public final class c<T> {
    final g TtI;
    final T result;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.TtI, r4.TtI) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 58023(0xe2a7, float:8.1308E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.f.c
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.d.a.f.c r4 = (kotlin.l.b.a.b.d.a.f.c) r4
            T r0 = r3.result
            T r1 = r4.result
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.b.a.g r0 = r3.TtI
            kotlin.l.b.a.b.b.a.g r1 = r4.TtI
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.f.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(58022);
        T t = this.result;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        g gVar = this.TtI;
        if (gVar != null) {
            i2 = gVar.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(58022);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(58021);
        String str = "EnhancementResult(result=" + ((Object) this.result) + ", enhancementAnnotations=" + this.TtI + ")";
        AppMethodBeat.o(58021);
        return str;
    }

    public c(T t, g gVar) {
        this.result = t;
        this.TtI = gVar;
    }
}
