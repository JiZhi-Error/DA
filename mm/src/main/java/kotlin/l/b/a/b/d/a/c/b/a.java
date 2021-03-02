package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.d.a.a.l;

public final class a {
    final l Ttb;
    final b Ttc;
    final boolean Ttd;
    final as Tte;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (kotlin.g.b.p.j(r3.Tte, r4.Tte) != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 57953(0xe261, float:8.121E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0032
            boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.c.b.a
            if (r0 == 0) goto L_0x0037
            kotlin.l.b.a.b.d.a.c.b.a r4 = (kotlin.l.b.a.b.d.a.c.b.a) r4
            kotlin.l.b.a.b.d.a.a.l r0 = r3.Ttb
            kotlin.l.b.a.b.d.a.a.l r1 = r4.Ttb
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            kotlin.l.b.a.b.d.a.c.b.b r0 = r3.Ttc
            kotlin.l.b.a.b.d.a.c.b.b r1 = r4.Ttc
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            boolean r0 = r3.Ttd
            boolean r1 = r4.Ttd
            if (r0 != r1) goto L_0x0037
            kotlin.l.b.a.b.b.as r0 = r3.Tte
            kotlin.l.b.a.b.b.as r1 = r4.Tte
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
        L_0x0032:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0036:
            return r0
        L_0x0037:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.b.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(57952);
        l lVar = this.Ttb;
        int hashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
        b bVar = this.Ttc;
        int hashCode2 = ((bVar != null ? bVar.hashCode() : 0) + hashCode) * 31;
        boolean z = this.Ttd;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i3 + hashCode2) * 31;
        as asVar = this.Tte;
        if (asVar != null) {
            i2 = asVar.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(57952);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(57951);
        String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.Ttb + ", flexibility=" + this.Ttc + ", isForAnnotationParameter=" + this.Ttd + ", upperBoundOfTypeParameter=" + this.Tte + ")";
        AppMethodBeat.o(57951);
        return str;
    }

    private a(l lVar, b bVar, boolean z, as asVar) {
        p.h(lVar, "howThisTypeIsUsed");
        p.h(bVar, "flexibility");
        AppMethodBeat.i(57949);
        this.Ttb = lVar;
        this.Ttc = bVar;
        this.Ttd = z;
        this.Tte = asVar;
        AppMethodBeat.o(57949);
    }

    public /* synthetic */ a(l lVar, boolean z, as asVar) {
        this(lVar, b.INFLEXIBLE, z, asVar);
        AppMethodBeat.i(57950);
        AppMethodBeat.o(57950);
    }

    public final a a(b bVar) {
        AppMethodBeat.i(57948);
        p.h(bVar, "flexibility");
        l lVar = this.Ttb;
        boolean z = this.Ttd;
        as asVar = this.Tte;
        p.h(lVar, "howThisTypeIsUsed");
        p.h(bVar, "flexibility");
        a aVar = new a(lVar, bVar, z, asVar);
        AppMethodBeat.o(57948);
        return aVar;
    }
}
