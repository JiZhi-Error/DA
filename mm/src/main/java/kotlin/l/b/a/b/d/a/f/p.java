package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.ab;

/* access modifiers changed from: package-private */
public final class p {
    final ab Tbs;
    final d TuO;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.TuO, r4.TuO) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 58125(0xe30d, float:8.145E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.f.p
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.d.a.f.p r4 = (kotlin.l.b.a.b.d.a.f.p) r4
            kotlin.l.b.a.b.m.ab r0 = r3.Tbs
            kotlin.l.b.a.b.m.ab r1 = r4.Tbs
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.d.a.f.d r0 = r3.TuO
            kotlin.l.b.a.b.d.a.f.d r1 = r4.TuO
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.f.p.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(58124);
        ab abVar = this.Tbs;
        int hashCode = (abVar != null ? abVar.hashCode() : 0) * 31;
        d dVar = this.TuO;
        if (dVar != null) {
            i2 = dVar.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(58124);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(58123);
        String str = "TypeAndDefaultQualifiers(type=" + this.Tbs + ", defaultQualifiers=" + this.TuO + ")";
        AppMethodBeat.o(58123);
        return str;
    }

    public p(ab abVar, d dVar) {
        kotlin.g.b.p.h(abVar, "type");
        AppMethodBeat.i(58122);
        this.Tbs = abVar;
        this.TuO = dVar;
        AppMethodBeat.o(58122);
    }
}
