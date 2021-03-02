package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.a;
import kotlin.l.b.a.b.d.a.f.h;

public final class k {
    public final h TrC;
    public final Collection<a.EnumC2281a> TrD;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.TrD, r4.TrD) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 57768(0xe1a8, float:8.095E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.c.k
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.d.a.c.k r4 = (kotlin.l.b.a.b.d.a.c.k) r4
            kotlin.l.b.a.b.d.a.f.h r0 = r3.TrC
            kotlin.l.b.a.b.d.a.f.h r1 = r4.TrC
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.util.Collection<kotlin.l.b.a.b.d.a.a$a> r0 = r3.TrD
            java.util.Collection<kotlin.l.b.a.b.d.a.a$a> r1 = r4.TrD
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.k.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(57767);
        h hVar = this.TrC;
        int hashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        Collection<a.EnumC2281a> collection = this.TrD;
        if (collection != null) {
            i2 = collection.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(57767);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(57766);
        String str = "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.TrC + ", qualifierApplicabilityTypes=" + this.TrD + ")";
        AppMethodBeat.o(57766);
        return str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends kotlin.l.b.a.b.d.a.a$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public k(h hVar, Collection<? extends a.EnumC2281a> collection) {
        p.h(hVar, "nullabilityQualifier");
        p.h(collection, "qualifierApplicabilityTypes");
        AppMethodBeat.i(57765);
        this.TrC = hVar;
        this.TrD = collection;
        AppMethodBeat.o(57765);
    }
}
