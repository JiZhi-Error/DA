package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bg;
import kotlin.t;

public final class l implements kotlin.l.b.a.b.j.a.a.b {
    final av TIo;
    final as TOv;
    private final f TPk;
    kotlin.g.a.a<? extends List<? extends bg>> TPl;
    final l TPm;

    l(av avVar, kotlin.g.a.a<? extends List<? extends bg>> aVar, l lVar, as asVar) {
        p.h(avVar, "projection");
        AppMethodBeat.i(186276);
        this.TIo = avVar;
        this.TPl = aVar;
        this.TPm = lVar;
        this.TOv = asVar;
        this.TPk = g.a(k.PUBLICATION, new a(this));
        AppMethodBeat.o(186276);
    }

    @Override // kotlin.l.b.a.b.m.at
    public final /* synthetic */ Collection hBV() {
        AppMethodBeat.i(61076);
        List<bg> hLx = hLx();
        AppMethodBeat.o(61076);
        return hLx;
    }

    @Override // kotlin.l.b.a.b.j.a.a.b
    public final av hKF() {
        return this.TIo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(av avVar, kotlin.g.a.a aVar, l lVar, as asVar, int i2) {
        this(avVar, (i2 & 2) != 0 ? null : aVar, null, (i2 & 8) != 0 ? null : asVar);
        AppMethodBeat.i(186277);
        AppMethodBeat.o(186277);
    }

    public /* synthetic */ l(av avVar, List list, byte b2) {
        this(avVar, list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private l(av avVar, final List<? extends bg> list) {
        this(avVar, new kotlin.g.a.a<List<? extends bg>>() {
            /* class kotlin.l.b.a.b.m.a.l.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ List<? extends bg> invoke() {
                return list;
            }
        }, null, null, 8);
        p.h(avVar, "projection");
        p.h(list, "supertypes");
        AppMethodBeat.i(61082);
        AppMethodBeat.o(61082);
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final h hzS() {
        return null;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(61078);
        if (this == obj) {
            AppMethodBeat.o(61078);
            return true;
        }
        if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
            AppMethodBeat.o(61078);
            return false;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
            AppMethodBeat.o(61078);
            throw tVar;
        } else {
            l lVar = this.TPm;
            if (lVar != null) {
                this = lVar;
            }
            l lVar2 = ((l) obj).TPm;
            if (this == (lVar2 == null ? (l) obj : lVar2)) {
                AppMethodBeat.o(61078);
                return true;
            }
            AppMethodBeat.o(61078);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(61079);
        while (true) {
            l lVar = this.TPm;
            if (lVar != null) {
                this = lVar;
            } else {
                int hashCode = super.hashCode();
                AppMethodBeat.o(61079);
                return hashCode;
            }
        }
    }

    public final String toString() {
        AppMethodBeat.i(61080);
        String str = "CapturedType(" + this.TIo + ')';
        AppMethodBeat.o(61080);
        return str;
    }

    public final List<bg> hLx() {
        AppMethodBeat.i(61075);
        v vVar = (List) this.TPk.getValue();
        if (vVar == null) {
            vVar = v.SXr;
        }
        AppMethodBeat.o(61075);
        return vVar;
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends bg>> {
        final /* synthetic */ l TPo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(l lVar) {
            super(0);
            this.TPo = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ List<? extends bg> invoke() {
            AppMethodBeat.i(61072);
            kotlin.g.a.a<? extends List<? extends bg>> aVar = this.TPo.TPl;
            if (aVar != null) {
                List list = (List) aVar.invoke();
                AppMethodBeat.o(61072);
                return list;
            }
            AppMethodBeat.o(61072);
            return null;
        }
    }

    static final class b extends q implements kotlin.g.a.a<List<? extends bg>> {
        final /* synthetic */ List TPn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list) {
            super(0);
            this.TPn = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ List<? extends bg> invoke() {
            return this.TPn;
        }
    }

    static final class c extends q implements kotlin.g.a.a<List<? extends bg>> {
        final /* synthetic */ l TPo;
        final /* synthetic */ i TPp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(l lVar, i iVar) {
            super(0);
            this.TPo = lVar;
            this.TPp = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends bg> invoke() {
            AppMethodBeat.i(61073);
            List<bg> hLx = this.TPo.hLx();
            ArrayList arrayList = new ArrayList(j.a(hLx, 10));
            Iterator<T> it = hLx.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().e(this.TPp));
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(61073);
            return arrayList2;
        }
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final kotlin.l.b.a.b.a.g hBh() {
        AppMethodBeat.i(61077);
        ab hBy = this.TIo.hBy();
        p.g(hBy, "projection.type");
        kotlin.l.b.a.b.a.g aM = kotlin.l.b.a.b.m.d.a.aM(hBy);
        AppMethodBeat.o(61077);
        return aM;
    }
}
