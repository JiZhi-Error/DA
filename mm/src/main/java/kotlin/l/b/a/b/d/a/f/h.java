package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class h {
    public final g TtX;
    public final boolean TtY;

    private static h a(g gVar, boolean z) {
        AppMethodBeat.i(58041);
        p.h(gVar, "qualifier");
        h hVar = new h(gVar, z);
        AppMethodBeat.o(58041);
        return hVar;
    }

    public static /* synthetic */ h a(h hVar, boolean z) {
        AppMethodBeat.i(58042);
        h a2 = a(hVar.TtX, z);
        AppMethodBeat.o(58042);
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r3.TtY == r4.TtY) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 58045(0xe2bd, float:8.1338E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.f.h
            if (r0 == 0) goto L_0x0023
            kotlin.l.b.a.b.d.a.f.h r4 = (kotlin.l.b.a.b.d.a.f.h) r4
            kotlin.l.b.a.b.d.a.f.g r0 = r3.TtX
            kotlin.l.b.a.b.d.a.f.g r1 = r4.TtX
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
            boolean r0 = r3.TtY
            boolean r1 = r4.TtY
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.f.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(58044);
        g gVar = this.TtX;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        boolean z = this.TtY;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 + hashCode;
        AppMethodBeat.o(58044);
        return i5;
    }

    public final String toString() {
        AppMethodBeat.i(58043);
        String str = "NullabilityQualifierWithMigrationStatus(qualifier=" + this.TtX + ", isForWarningOnly=" + this.TtY + ")";
        AppMethodBeat.o(58043);
        return str;
    }

    public h(g gVar, boolean z) {
        p.h(gVar, "qualifier");
        AppMethodBeat.i(58040);
        this.TtX = gVar;
        this.TtY = z;
        AppMethodBeat.o(58040);
    }

    public /* synthetic */ h(g gVar) {
        this(gVar, false);
    }
}
