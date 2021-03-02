package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;

public class t extends aj {
    private final boolean TIm;
    private final at TNJ;
    private final String TNK;
    private final List<av> ThC;
    private final h Tly;

    public t(at atVar, h hVar) {
        this(atVar, hVar, null, false, null, 28);
        AppMethodBeat.i(60665);
        AppMethodBeat.o(60665);
    }

    public t(at atVar, h hVar, List<? extends av> list) {
        this(atVar, hVar, list, false, null, 16);
    }

    @Override // kotlin.l.b.a.b.m.bg
    public /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60660);
        aj EG = EG(z);
        AppMethodBeat.o(60660);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60658);
        aj d2 = d(gVar);
        AppMethodBeat.o(60658);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60662);
        t j2 = j(iVar);
        AppMethodBeat.o(60662);
        return j2;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public /* synthetic */ bg e(i iVar) {
        AppMethodBeat.i(60663);
        t j2 = j(iVar);
        AppMethodBeat.o(60663);
        return j2;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final at hKE() {
        return this.TNJ;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final h hAp() {
        return this.Tly;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final List<av> hKB() {
        return this.ThC;
    }

    @Override // kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return this.TIm;
    }

    public String hLz() {
        return this.TNK;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.m.av> */
    /* JADX WARN: Multi-variable type inference failed */
    private t(at atVar, h hVar, List<? extends av> list, boolean z, String str) {
        p.h(atVar, "constructor");
        p.h(hVar, "memberScope");
        p.h(list, "arguments");
        p.h(str, "presentableName");
        AppMethodBeat.i(186269);
        this.TNJ = atVar;
        this.Tly = hVar;
        this.ThC = list;
        this.TIm = z;
        this.TNK = str;
        AppMethodBeat.o(186269);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(60655);
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        AppMethodBeat.o(60655);
        return hBP;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public String toString() {
        String a2;
        AppMethodBeat.i(60656);
        StringBuilder append = new StringBuilder().append(this.TNJ.toString());
        if (this.ThC.isEmpty()) {
            a2 = "";
        } else {
            a2 = j.a(this.ThC, ", ", "<", ">", -1, "...", null);
        }
        String sb = append.append(a2).toString();
        AppMethodBeat.o(60656);
        return sb;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj d(g gVar) {
        AppMethodBeat.i(60657);
        p.h(gVar, "newAnnotations");
        t tVar = this;
        AppMethodBeat.o(60657);
        return tVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public aj EG(boolean z) {
        AppMethodBeat.i(60659);
        t tVar = new t(this.TNJ, this.Tly, this.ThC, z, null, 16);
        AppMethodBeat.o(60659);
        return tVar;
    }

    public t j(i iVar) {
        AppMethodBeat.i(60661);
        p.h(iVar, "kotlinTypeRefiner");
        AppMethodBeat.o(60661);
        return this;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ t(kotlin.l.b.a.b.m.at r8, kotlin.l.b.a.b.j.f.h r9, java.util.List r10, boolean r11, java.lang.String r12, int r13) {
        /*
            r7 = this;
            r6 = 186270(0x2d79e, float:2.6102E-40)
            r0 = r13 & 4
            if (r0 == 0) goto L_0x0029
            kotlin.a.v r0 = kotlin.a.v.SXr
            java.util.List r0 = (java.util.List) r0
            r3 = r0
        L_0x000c:
            r0 = r13 & 8
            if (r0 == 0) goto L_0x0027
            r4 = 0
        L_0x0011:
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0025
            java.lang.String r5 = "???"
        L_0x0018:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0025:
            r5 = r12
            goto L_0x0018
        L_0x0027:
            r4 = r11
            goto L_0x0011
        L_0x0029:
            r3 = r10
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.t.<init>(kotlin.l.b.a.b.m.at, kotlin.l.b.a.b.j.f.h, java.util.List, boolean, java.lang.String, int):void");
    }
}
