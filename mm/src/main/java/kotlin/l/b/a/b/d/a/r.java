package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.f;

/* access modifiers changed from: package-private */
public final class r {
    final f TjT;
    final String signature;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.signature, r4.signature) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 57621(0xe115, float:8.0744E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.r
            if (r0 == 0) goto L_0x0027
            kotlin.l.b.a.b.d.a.r r4 = (kotlin.l.b.a.b.d.a.r) r4
            kotlin.l.b.a.b.f.f r0 = r3.TjT
            kotlin.l.b.a.b.f.f r1 = r4.TjT
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r3.signature
            java.lang.String r1 = r4.signature
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.r.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(57620);
        f fVar = this.TjT;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 31;
        String str = this.signature;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(57620);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(57619);
        String str = "NameAndSignature(name=" + this.TjT + ", signature=" + this.signature + ")";
        AppMethodBeat.o(57619);
        return str;
    }

    public r(f fVar, String str) {
        p.h(fVar, "name");
        p.h(str, "signature");
        AppMethodBeat.i(57618);
        this.TjT = fVar;
        this.signature = str;
        AppMethodBeat.o(57618);
    }
}
