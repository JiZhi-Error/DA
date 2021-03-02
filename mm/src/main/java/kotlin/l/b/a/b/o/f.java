package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class f {
    public final String Itb;
    public final int TRT;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r3.TRT == r4.TRT) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 61372(0xefbc, float:8.6E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x001e
            boolean r0 = r4 instanceof kotlin.l.b.a.b.o.f
            if (r0 == 0) goto L_0x0023
            kotlin.l.b.a.b.o.f r4 = (kotlin.l.b.a.b.o.f) r4
            java.lang.String r0 = r3.Itb
            java.lang.String r1 = r4.Itb
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0023
            int r0 = r3.TRT
            int r1 = r4.TRT
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.o.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(61371);
        String str = this.Itb;
        int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.TRT;
        AppMethodBeat.o(61371);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(61370);
        String str = "NumberWithRadix(number=" + this.Itb + ", radix=" + this.TRT + ")";
        AppMethodBeat.o(61370);
        return str;
    }

    public f(String str, int i2) {
        p.h(str, "number");
        AppMethodBeat.i(61369);
        this.Itb = str;
        this.TRT = i2;
        AppMethodBeat.o(61369);
    }
}
