package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bh;

/* access modifiers changed from: package-private */
public final class c implements as {
    private final as Thb;
    private final l Thc;
    private final int Thd;

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(56837);
        R r = (R) this.Thb.a(nVar, d2);
        AppMethodBeat.o(56837);
        return r;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final aj hAG() {
        AppMethodBeat.i(56838);
        aj hAG = this.Thb.hAG();
        AppMethodBeat.o(56838);
        return hAG;
    }

    @Override // kotlin.l.b.a.b.b.z
    public final f hAH() {
        AppMethodBeat.i(56839);
        f hAH = this.Thb.hAH();
        AppMethodBeat.o(56839);
        return hAH;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final j hAI() {
        AppMethodBeat.i(186241);
        j hAI = this.Thb.hAI();
        AppMethodBeat.o(186241);
        return hAI;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final bh hAJ() {
        AppMethodBeat.i(56843);
        bh hAJ = this.Thb.hAJ();
        AppMethodBeat.o(56843);
        return hAJ;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final boolean hAK() {
        AppMethodBeat.i(56844);
        boolean hAK = this.Thb.hAK();
        AppMethodBeat.o(56844);
        return hAK;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final List<ab> hyo() {
        AppMethodBeat.i(56842);
        List<ab> hyo = this.Thb.hyo();
        AppMethodBeat.o(56842);
        return hyo;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(56836);
        g hzL = this.Thb.hzL();
        AppMethodBeat.o(56836);
        return hzL;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        AppMethodBeat.i(56840);
        an hzM = this.Thb.hzM();
        AppMethodBeat.o(56840);
        return hzM;
    }

    @Override // kotlin.l.b.a.b.b.as, kotlin.l.b.a.b.b.h
    public final at hzz() {
        AppMethodBeat.i(56841);
        at hzz = this.Thb.hzz();
        AppMethodBeat.o(56841);
        return hzz;
    }

    public c(as asVar, l lVar, int i2) {
        p.h(asVar, "originalDescriptor");
        p.h(lVar, "declarationDescriptor");
        AppMethodBeat.i(56835);
        this.Thb = asVar;
        this.Thc = lVar;
        this.Thd = i2;
        AppMethodBeat.o(56835);
    }

    @Override // kotlin.l.b.a.b.b.l
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(56831);
        as hAD = hAD();
        AppMethodBeat.o(56831);
        return hAD;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final /* synthetic */ h hAF() {
        AppMethodBeat.i(56832);
        as hAD = hAD();
        AppMethodBeat.o(56832);
        return hAD;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final boolean hAC() {
        return true;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final as hAD() {
        AppMethodBeat.i(56830);
        as hAD = this.Thb.hAD();
        p.g(hAD, "originalDescriptor.original");
        AppMethodBeat.o(56830);
        return hAD;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public final l hzx() {
        return this.Thc;
    }

    @Override // kotlin.l.b.a.b.b.as
    public final int getIndex() {
        AppMethodBeat.i(56833);
        int index = this.Thd + this.Thb.getIndex();
        AppMethodBeat.o(56833);
        return index;
    }

    public final String toString() {
        AppMethodBeat.i(56834);
        String str = this.Thb + "[inner-copy]";
        AppMethodBeat.o(56834);
        return str;
    }
}
