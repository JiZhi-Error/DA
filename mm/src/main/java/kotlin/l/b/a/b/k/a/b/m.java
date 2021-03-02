package kotlin.l.b.a.b.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.c.b;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.k.a.ad;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.m.ab;

public final class m extends b {
    final n TLm;
    private final b TMK = new b(this.TLm.Tvt.TcN, new a(this));
    final a.r TML;

    @Override // kotlin.l.b.a.b.b.c.e
    public final /* synthetic */ void H(ab abVar) {
        AppMethodBeat.i(60491);
        p.h(abVar, "type");
        IllegalStateException illegalStateException = new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: ".concat(String.valueOf(this)));
        AppMethodBeat.o(60491);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.b.c.e
    public final List<ab> hBW() {
        boolean z;
        ArrayList arrayList;
        AppMethodBeat.i(60490);
        a.r rVar = this.TML;
        h hVar = this.TLm.SZI;
        p.h(rVar, "$this$upperBounds");
        p.h(hVar, "typeTable");
        List<a.p> list = rVar.TzO;
        if (!list.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            arrayList = list;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            List<Integer> list2 = rVar.TzP;
            p.g(list2, "upperBoundIdList");
            List<Integer> list3 = list2;
            ArrayList arrayList2 = new ArrayList(j.a(list3, 10));
            for (T t : list3) {
                p.g(t, LocaleUtil.ITALIAN);
                arrayList2.add(hVar.avo(t.intValue()));
            }
            arrayList = arrayList2;
        }
        if (arrayList.isEmpty()) {
            List<ab> listOf = j.listOf(kotlin.l.b.a.b.j.d.a.G(this).hzk());
            AppMethodBeat.o(60490);
            return listOf;
        }
        ArrayList<T> arrayList3 = arrayList;
        ad adVar = this.TLm.TKY;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (T t2 : arrayList3) {
            arrayList4.add(adVar.r(t2));
        }
        ArrayList arrayList5 = arrayList4;
        AppMethodBeat.o(60490);
        return arrayList5;
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends c>> {
        final /* synthetic */ m TMM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m mVar) {
            super(0);
            this.TMM = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends c> invoke() {
            AppMethodBeat.i(60489);
            List p = j.p(this.TMM.TLm.Tvt.TKO.a(this.TMM.TML, this.TMM.TLm.SZH));
            AppMethodBeat.o(60489);
            return p;
        }
    }

    @Override // kotlin.l.b.a.b.b.a.b, kotlin.l.b.a.b.b.a.a
    public final /* bridge */ /* synthetic */ g hzL() {
        return this.TMK;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m(kotlin.l.b.a.b.k.a.n r11, kotlin.l.b.a.b.e.a.r r12, int r13) {
        /*
            r10 = this;
            r9 = 60492(0xec4c, float:8.4767E-41)
            java.lang.String r0 = "c"
            kotlin.g.b.p.h(r11, r0)
            java.lang.String r0 = "proto"
            kotlin.g.b.p.h(r12, r0)
            kotlin.l.b.a.b.k.a.l r0 = r11.Tvt
            kotlin.l.b.a.b.l.j r1 = r0.TcN
            kotlin.l.b.a.b.b.l r2 = r11.Tko
            kotlin.l.b.a.b.e.b.c r0 = r11.SZH
            int r3 = r12.Tyk
            kotlin.l.b.a.b.f.f r3 = kotlin.l.b.a.b.k.a.x.b(r0, r3)
            kotlin.l.b.a.b.k.a.aa r0 = kotlin.l.b.a.b.k.a.aa.TLC
            kotlin.l.b.a.b.e.a$r$b r0 = r12.TzN
            java.lang.String r4 = "proto.variance"
            kotlin.g.b.p.g(r0, r4)
            kotlin.l.b.a.b.m.bh r4 = kotlin.l.b.a.b.k.a.aa.b(r0)
            boolean r5 = r12.TzM
            kotlin.l.b.a.b.b.an r7 = kotlin.l.b.a.b.b.an.ThK
            kotlin.l.b.a.b.b.aq$a r8 = kotlin.l.b.a.b.b.aq.a.ThM
            kotlin.l.b.a.b.b.aq r8 = (kotlin.l.b.a.b.b.aq) r8
            r0 = r10
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r9)
            r10.TLm = r11
            r10.TML = r12
            kotlin.l.b.a.b.k.a.b.b r1 = new kotlin.l.b.a.b.k.a.b.b
            kotlin.l.b.a.b.k.a.n r0 = r10.TLm
            kotlin.l.b.a.b.k.a.l r0 = r0.Tvt
            kotlin.l.b.a.b.l.j r2 = r0.TcN
            kotlin.l.b.a.b.k.a.b.m$a r0 = new kotlin.l.b.a.b.k.a.b.m$a
            r0.<init>(r10)
            kotlin.g.a.a r0 = (kotlin.g.a.a) r0
            r1.<init>(r2, r0)
            r10.TMK = r1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.b.m.<init>(kotlin.l.b.a.b.k.a.n, kotlin.l.b.a.b.e.a$r, int):void");
    }
}
