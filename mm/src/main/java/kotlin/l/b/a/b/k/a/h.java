package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.c;

public final class h {
    final c SZH;
    final a.b TKA;
    final kotlin.l.b.a.b.e.b.a TKB;
    final an TKC;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (kotlin.g.b.p.j(r3.TKC, r4.TKC) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 60291(0xeb83, float:8.4486E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0036
            boolean r0 = r4 instanceof kotlin.l.b.a.b.k.a.h
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.k.a.h r4 = (kotlin.l.b.a.b.k.a.h) r4
            kotlin.l.b.a.b.e.b.c r0 = r3.SZH
            kotlin.l.b.a.b.e.b.c r1 = r4.SZH
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.e.a$b r0 = r3.TKA
            kotlin.l.b.a.b.e.a$b r1 = r4.TKA
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.e.b.a r0 = r3.TKB
            kotlin.l.b.a.b.e.b.a r1 = r4.TKB
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003b
            kotlin.l.b.a.b.b.an r0 = r3.TKC
            kotlin.l.b.a.b.b.an r1 = r4.TKC
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(60290);
        c cVar = this.SZH;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        a.b bVar = this.TKA;
        int hashCode2 = ((bVar != null ? bVar.hashCode() : 0) + hashCode) * 31;
        kotlin.l.b.a.b.e.b.a aVar = this.TKB;
        int hashCode3 = ((aVar != null ? aVar.hashCode() : 0) + hashCode2) * 31;
        an anVar = this.TKC;
        if (anVar != null) {
            i2 = anVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        AppMethodBeat.o(60290);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(60289);
        String str = "ClassData(nameResolver=" + this.SZH + ", classProto=" + this.TKA + ", metadataVersion=" + this.TKB + ", sourceElement=" + this.TKC + ")";
        AppMethodBeat.o(60289);
        return str;
    }

    public h(c cVar, a.b bVar, kotlin.l.b.a.b.e.b.a aVar, an anVar) {
        p.h(cVar, "nameResolver");
        p.h(bVar, "classProto");
        p.h(aVar, "metadataVersion");
        p.h(anVar, "sourceElement");
        AppMethodBeat.i(60288);
        this.SZH = cVar;
        this.TKA = bVar;
        this.TKB = aVar;
        this.TKC = anVar;
        AppMethodBeat.o(60288);
    }
}
