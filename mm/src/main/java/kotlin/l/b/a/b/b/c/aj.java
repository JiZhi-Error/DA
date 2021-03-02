package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ba;
import kotlin.t;

public class aj extends ak implements av {
    public static final a Tmy = new a((byte) 0);
    private final av Tmt;
    private final boolean Tmu;
    final boolean Tmv;
    final boolean Tmw;
    final ab Tmx;
    private final int index;

    static {
        AppMethodBeat.i(57348);
        AppMethodBeat.o(57348);
    }

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap
    public final /* synthetic */ kotlin.l.b.a.b.b.a f(ba baVar) {
        AppMethodBeat.i(57342);
        p.h(baVar, "substitutor");
        if (baVar.Tlg.isEmpty()) {
            aj ajVar = this;
            AppMethodBeat.o(57342);
            return ajVar;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57342);
        throw unsupportedOperationException;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57338);
        av hBC = hBC();
        AppMethodBeat.o(57338);
        return hBC;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final /* synthetic */ kotlin.l.b.a.b.b.a hAv() {
        AppMethodBeat.i(57340);
        av hBC = hBC();
        AppMethodBeat.o(57340);
        return hBC;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final /* bridge */ /* synthetic */ g hBG() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final boolean hBI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.k
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57339);
        av hBC = hBC();
        AppMethodBeat.o(57339);
        return hBC;
    }

    @Override // kotlin.l.b.a.b.b.c.ak
    public final /* synthetic */ ax hCq() {
        AppMethodBeat.i(57341);
        av hBC = hBC();
        AppMethodBeat.o(57341);
        return hBC;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.au, kotlin.l.b.a.b.b.c.k
    public final /* synthetic */ l hzx() {
        AppMethodBeat.i(57335);
        kotlin.l.b.a.b.b.a hBz = hBz();
        AppMethodBeat.o(57335);
        return hBz;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final int getIndex() {
        return this.index;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final boolean hBD() {
        return this.Tmv;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final boolean hBE() {
        return this.Tmw;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final ab hBB() {
        return this.Tmx;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj(kotlin.l.b.a.b.b.a aVar, av avVar, int i2, kotlin.l.b.a.b.b.a.g gVar, f fVar, ab abVar, boolean z, boolean z2, boolean z3, ab abVar2, an anVar) {
        super(aVar, gVar, fVar, abVar, anVar);
        p.h(aVar, "containingDeclaration");
        p.h(gVar, "annotations");
        p.h(fVar, "name");
        p.h(abVar, "outType");
        p.h(anVar, "source");
        AppMethodBeat.i(57347);
        this.index = i2;
        this.Tmu = z;
        this.Tmv = z2;
        this.Tmw = z3;
        this.Tmx = abVar2;
        this.Tmt = avVar == null ? this : avVar;
        AppMethodBeat.o(57347);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b extends aj {
        private final kotlin.f Tmz;

        public final List<ax> hCz() {
            AppMethodBeat.i(57331);
            List<ax> list = (List) this.Tmz.getValue();
            AppMethodBeat.o(57331);
            return list;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(kotlin.l.b.a.b.b.a aVar, av avVar, int i2, kotlin.l.b.a.b.b.a.g gVar, f fVar, ab abVar, boolean z, boolean z2, boolean z3, ab abVar2, an anVar, kotlin.g.a.a<? extends List<? extends ax>> aVar2) {
            super(aVar, avVar, i2, gVar, fVar, abVar, z, z2, z3, abVar2, anVar);
            p.h(aVar, "containingDeclaration");
            p.h(gVar, "annotations");
            p.h(fVar, "name");
            p.h(abVar, "outType");
            p.h(anVar, "source");
            p.h(aVar2, "destructuringVariables");
            AppMethodBeat.i(57333);
            this.Tmz = kotlin.g.ah(aVar2);
            AppMethodBeat.o(57333);
        }

        @Override // kotlin.l.b.a.b.b.c.aj, kotlin.l.b.a.b.b.av
        public final av a(kotlin.l.b.a.b.b.a aVar, f fVar, int i2) {
            AppMethodBeat.i(57332);
            p.h(aVar, "newOwner");
            p.h(fVar, "newName");
            kotlin.l.b.a.b.b.a.g hzL = hzL();
            p.g(hzL, "annotations");
            ab hBy = hBy();
            p.g(hBy, "type");
            boolean hBA = hBA();
            boolean z = this.Tmv;
            boolean z2 = this.Tmw;
            ab abVar = this.Tmx;
            an anVar = an.ThK;
            p.g(anVar, "SourceElement.NO_SOURCE");
            b bVar = new b(aVar, null, i2, hzL, fVar, hBy, hBA, z, z2, abVar, anVar, new a(this));
            AppMethodBeat.o(57332);
            return bVar;
        }

        static final class a extends q implements kotlin.g.a.a<List<? extends ax>> {
            final /* synthetic */ b TmA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.TmA = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends ax> invoke() {
                AppMethodBeat.i(57329);
                List<ax> hCz = this.TmA.hCz();
                AppMethodBeat.o(57329);
                return hCz;
            }
        }
    }

    @Override // kotlin.l.b.a.b.b.av
    public final kotlin.l.b.a.b.b.a hBz() {
        AppMethodBeat.i(57334);
        l hzx = super.hzx();
        if (hzx == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
            AppMethodBeat.o(57334);
            throw tVar;
        }
        kotlin.l.b.a.b.b.a aVar = (kotlin.l.b.a.b.b.a) hzx;
        AppMethodBeat.o(57334);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final boolean hBA() {
        AppMethodBeat.i(57336);
        if (this.Tmu) {
            kotlin.l.b.a.b.b.a hBz = hBz();
            if (hBz == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
                AppMethodBeat.o(57336);
                throw tVar;
            }
            b.a hAA = ((kotlin.l.b.a.b.b.b) hBz).hAA();
            p.g(hAA, "(containingDeclaration a…bleMemberDescriptor).kind");
            if (hAA.hAB()) {
                AppMethodBeat.o(57336);
                return true;
            }
        }
        AppMethodBeat.o(57336);
        return false;
    }

    @Override // kotlin.l.b.a.b.b.av
    public final av hBC() {
        AppMethodBeat.i(57337);
        if (this.Tmt == this) {
            aj ajVar = this;
            AppMethodBeat.o(57337);
            return ajVar;
        }
        av hBC = this.Tmt.hBC();
        AppMethodBeat.o(57337);
        return hBC;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57343);
        p.h(nVar, "visitor");
        R a2 = nVar.a(this, d2);
        AppMethodBeat.o(57343);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final boolean hBF() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.av
    public av a(kotlin.l.b.a.b.b.a aVar, f fVar, int i2) {
        AppMethodBeat.i(57344);
        p.h(aVar, "newOwner");
        p.h(fVar, "newName");
        kotlin.l.b.a.b.b.a.g hzL = hzL();
        p.g(hzL, "annotations");
        ab hBy = hBy();
        p.g(hBy, "type");
        boolean hBA = hBA();
        boolean z = this.Tmv;
        boolean z2 = this.Tmw;
        ab abVar = this.Tmx;
        an anVar = an.ThK;
        p.g(anVar, "SourceElement.NO_SOURCE");
        aj ajVar = new aj(aVar, null, i2, hzL, fVar, hBy, hBA, z, z2, abVar, anVar);
        AppMethodBeat.o(57344);
        return ajVar;
    }

    @Override // kotlin.l.b.a.b.b.p
    public final kotlin.l.b.a.b.b.ba hzE() {
        AppMethodBeat.i(57345);
        kotlin.l.b.a.b.b.ba baVar = az.ThV;
        p.g(baVar, "Visibilities.LOCAL");
        AppMethodBeat.o(57345);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.av
    public final Collection<av> hAy() {
        AppMethodBeat.i(57346);
        Collection<? extends kotlin.l.b.a.b.b.a> hAy = hBz().hAy();
        p.g(hAy, "containingDeclaration.overriddenDescriptors");
        Collection<? extends kotlin.l.b.a.b.b.a> collection = hAy;
        ArrayList arrayList = new ArrayList(j.a(collection, 10));
        for (T t : collection) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(t.hAw().get(this.index));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57346);
        return arrayList2;
    }

    public static final aj a(kotlin.l.b.a.b.b.a aVar, av avVar, int i2, kotlin.l.b.a.b.b.a.g gVar, f fVar, ab abVar, boolean z, boolean z2, boolean z3, ab abVar2, an anVar, kotlin.g.a.a<? extends List<? extends ax>> aVar2) {
        AppMethodBeat.i(57349);
        p.h(aVar, "containingDeclaration");
        p.h(gVar, "annotations");
        p.h(fVar, "name");
        p.h(abVar, "outType");
        p.h(anVar, "source");
        if (aVar2 == null) {
            aj ajVar = new aj(aVar, avVar, i2, gVar, fVar, abVar, z, z2, z3, abVar2, anVar);
            AppMethodBeat.o(57349);
            return ajVar;
        }
        b bVar = new b(aVar, avVar, i2, gVar, fVar, abVar, z, z2, z3, abVar2, anVar, aVar2);
        AppMethodBeat.o(57349);
        return bVar;
    }
}
