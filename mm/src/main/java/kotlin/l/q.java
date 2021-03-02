package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    private static final q SZo = new q(null, null);
    public static final a SZp = new a((byte) 0);
    private final r SZm;
    private final o SZn;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.SZn, r4.SZn) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 129550(0x1fa0e, float:1.81538E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof kotlin.l.q
            if (r0 == 0) goto L_0x0027
            kotlin.l.q r4 = (kotlin.l.q) r4
            kotlin.l.r r0 = r3.SZm
            kotlin.l.r r1 = r4.SZm
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            kotlin.l.o r0 = r3.SZn
            kotlin.l.o r1 = r4.SZn
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(129549);
        r rVar = this.SZm;
        int hashCode = (rVar != null ? rVar.hashCode() : 0) * 31;
        o oVar = this.SZn;
        if (oVar != null) {
            i2 = oVar.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(129549);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(129548);
        String str = "KTypeProjection(variance=" + this.SZm + ", type=" + this.SZn + ")";
        AppMethodBeat.o(129548);
        return str;
    }

    public q(r rVar, o oVar) {
        this.SZm = rVar;
        this.SZn = oVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(129547);
        AppMethodBeat.o(129547);
    }
}
