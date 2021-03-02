package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.a;

public final class t<T extends a> {
    private final T TLj;
    private final T TLk;
    private final kotlin.l.b.a.b.f.a Tfj;
    private final String filePath;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (kotlin.g.b.p.j(r3.Tfj, r4.Tfj) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 60322(0xeba2, float:8.4529E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0036
            boolean r0 = r4 instanceof kotlin.l.b.a.b.k.a.t
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.k.a.t r4 = (kotlin.l.b.a.b.k.a.t) r4
            T extends kotlin.l.b.a.b.e.b.a r0 = r3.TLj
            T extends kotlin.l.b.a.b.e.b.a r1 = r4.TLj
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            T extends kotlin.l.b.a.b.e.b.a r0 = r3.TLk
            T extends kotlin.l.b.a.b.e.b.a r1 = r4.TLk
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.filePath
            java.lang.String r1 = r4.filePath
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.f.a r0 = r3.Tfj
            kotlin.l.b.a.b.f.a r1 = r4.Tfj
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
        L_0x0036:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003a:
            return r0
        L_0x003b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.t.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(60321);
        T t = this.TLj;
        int hashCode = (t != null ? t.hashCode() : 0) * 31;
        T t2 = this.TLk;
        int hashCode2 = ((t2 != null ? t2.hashCode() : 0) + hashCode) * 31;
        String str = this.filePath;
        int hashCode3 = ((str != null ? str.hashCode() : 0) + hashCode2) * 31;
        kotlin.l.b.a.b.f.a aVar = this.Tfj;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        AppMethodBeat.o(60321);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(60320);
        String str = "IncompatibleVersionErrorData(actualVersion=" + this.TLj + ", expectedVersion=" + this.TLk + ", filePath=" + this.filePath + ", classId=" + this.Tfj + ")";
        AppMethodBeat.o(60320);
        return str;
    }

    public t(T t, T t2, String str, kotlin.l.b.a.b.f.a aVar) {
        p.h(t, "actualVersion");
        p.h(t2, "expectedVersion");
        p.h(str, "filePath");
        p.h(aVar, "classId");
        AppMethodBeat.i(60319);
        this.TLj = t;
        this.TLk = t2;
        this.filePath = str;
        this.Tfj = aVar;
        AppMethodBeat.o(60319);
    }
}
