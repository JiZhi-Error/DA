package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;

public final class z extends ay {
    public final as[] TOb;
    public final av[] TOc;
    private final boolean TOd;

    private /* synthetic */ z(as[] asVarArr, av[] avVarArr) {
        this(asVarArr, avVarArr, false);
    }

    public z(as[] asVarArr, av[] avVarArr, boolean z) {
        p.h(asVarArr, "parameters");
        p.h(avVarArr, "arguments");
        AppMethodBeat.i(60752);
        this.TOb = asVarArr;
        this.TOc = avVarArr;
        this.TOd = z;
        boolean z2 = this.TOb.length <= this.TOc.length;
        if (!aa.SXc || z2) {
            AppMethodBeat.o(60752);
            return;
        }
        AssertionError assertionError = new AssertionError("Number of arguments should not be less then number of parameters, but: parameters=" + this.TOb.length + ", args=" + this.TOc.length);
        AppMethodBeat.o(60752);
        throw assertionError;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z(java.util.List<? extends kotlin.l.b.a.b.b.as> r4, java.util.List<? extends kotlin.l.b.a.b.m.av> r5) {
        /*
            r3 = this;
            r1 = 0
            r2 = 60753(0xed51, float:8.5133E-41)
            java.lang.String r0 = "parameters"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "argumentsList"
            kotlin.g.b.p.h(r5, r0)
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.l.b.a.b.b.as[] r0 = new kotlin.l.b.a.b.b.as[r1]
            java.lang.Object[] r0 = r4.toArray(r0)
            if (r0 != 0) goto L_0x0026
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0026:
            kotlin.l.b.a.b.b.as[] r0 = (kotlin.l.b.a.b.b.as[]) r0
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.l.b.a.b.m.av[] r1 = new kotlin.l.b.a.b.m.av[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            if (r1 != 0) goto L_0x003e
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x003e:
            kotlin.l.b.a.b.m.av[] r1 = (kotlin.l.b.a.b.m.av[]) r1
            r3.<init>(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.z.<init>(java.util.List, java.util.List):void");
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean isEmpty() {
        return this.TOc.length == 0;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean hKG() {
        return this.TOd;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final av N(ab abVar) {
        AppMethodBeat.i(60751);
        p.h(abVar, "key");
        h hzS = abVar.hKE().hzS();
        if (!(hzS instanceof as)) {
            hzS = null;
        }
        as asVar = (as) hzS;
        if (asVar == null) {
            AppMethodBeat.o(60751);
            return null;
        }
        int index = asVar.getIndex();
        if (index >= this.TOb.length || !p.j(this.TOb[index].hzz(), asVar.hzz())) {
            AppMethodBeat.o(60751);
            return null;
        }
        av avVar = this.TOc[index];
        AppMethodBeat.o(60751);
        return avVar;
    }
}
