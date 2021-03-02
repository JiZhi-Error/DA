package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.c.b;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.d.a.c.b.d;
import kotlin.l.b.a.b.d.a.c.e;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.j;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;

public final class n extends b {
    private final h Trn;
    private final e TsZ = new e(this.Trn, this.Tta);
    private final w Tta;

    @Override // kotlin.l.b.a.b.b.c.e
    public final List<ab> hBW() {
        AppMethodBeat.i(57945);
        Collection<j> hDi = this.Tta.hDi();
        if (hDi.isEmpty()) {
            aj hzi = this.Trn.Trv.Tfp.hBh().hzi();
            p.g(hzi, "c.module.builtIns.anyType");
            aj hzj = this.Trn.Trv.Tfp.hBh().hzj();
            p.g(hzj, "c.module.builtIns.nullableAnyType");
            List<ab> listOf = kotlin.a.j.listOf(ac.a(hzi, hzj));
            AppMethodBeat.o(57945);
            return listOf;
        }
        Collection<j> collection = hDi;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.Trn.Tru.a((v) it.next(), d.a(l.Tqv, false, this, 1)));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57945);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.b.c.e
    public final void H(ab abVar) {
        AppMethodBeat.i(57946);
        p.h(abVar, "type");
        AppMethodBeat.o(57946);
    }

    @Override // kotlin.l.b.a.b.b.a.b, kotlin.l.b.a.b.b.a.a
    public final /* bridge */ /* synthetic */ g hzL() {
        return this.TsZ;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(h hVar, w wVar, int i2, kotlin.l.b.a.b.b.l lVar) {
        super(hVar.Trv.TcN, lVar, wVar.hAH(), bh.INVARIANT, false, i2, an.ThK, hVar.Trv.Tkm);
        p.h(hVar, "c");
        p.h(wVar, "javaTypeParameter");
        p.h(lVar, "containingDeclaration");
        AppMethodBeat.i(57947);
        this.Trn = hVar;
        this.Tta = wVar;
        AppMethodBeat.o(57947);
    }
}
