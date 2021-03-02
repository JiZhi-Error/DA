package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;

public final class f {
    public final int TIt;
    public final a Tfj;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r3.TIt == r4.TIt) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 60053(0xea95, float:8.4152E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof kotlin.l.b.a.b.j.b.f
            if (r0 == 0) goto L_0x0023
            kotlin.l.b.a.b.j.b.f r4 = (kotlin.l.b.a.b.j.b.f) r4
            kotlin.l.b.a.b.f.a r0 = r3.Tfj
            kotlin.l.b.a.b.f.a r1 = r4.Tfj
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
            int r0 = r3.TIt
            int r1 = r4.TIt
            if (r0 != r1) goto L_0x0023
        L_0x001e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0022:
            return r0
        L_0x0023:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.j.b.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(60052);
        a aVar = this.Tfj;
        int hashCode = ((aVar != null ? aVar.hashCode() : 0) * 31) + this.TIt;
        AppMethodBeat.o(60052);
        return hashCode;
    }

    public f(a aVar, int i2) {
        p.h(aVar, "classId");
        AppMethodBeat.i(60051);
        this.Tfj = aVar;
        this.TIt = i2;
        AppMethodBeat.o(60051);
    }

    public final String toString() {
        AppMethodBeat.i(60050);
        StringBuilder sb = new StringBuilder();
        int i2 = this.TIt;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.Tfj);
        int i4 = this.TIt;
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append(">");
        }
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(60050);
        return sb2;
    }
}
