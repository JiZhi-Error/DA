package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ab;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.c.o;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.k.a.b.g;
import kotlin.l.b.a.b.k.a.b.j;
import kotlin.l.b.a.b.k.a.b.k;
import kotlin.l.b.a.b.k.a.b.n;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.m.aj;
import kotlin.t;

public final class w {
    private final n TLm;
    private final f Tvk = new f(this.TLm.Tvt.Tge, this.TLm.Tvt.TeR);

    public w(n nVar) {
        p.h(nVar, "c");
        AppMethodBeat.i(60340);
        this.TLm = nVar;
        AppMethodBeat.o(60340);
    }

    public static final /* synthetic */ z a(w wVar, l lVar) {
        AppMethodBeat.i(60341);
        z K = wVar.K(lVar);
        AppMethodBeat.o(60341);
        return K;
    }

    public final ah g(a.m mVar) {
        int avH;
        g hBP;
        j jVar;
        ak akVar;
        ak akVar2;
        ab abVar;
        ac acVar;
        int i2;
        ab a2;
        kotlin.l.b.a.b.m.ab r;
        AppMethodBeat.i(60329);
        p.h(mVar, "proto");
        if (mVar.hEP()) {
            avH = mVar.Txb;
        } else {
            avH = avH(mVar.Tyx);
        }
        l lVar = this.TLm.Tko;
        g a3 = a(mVar, avH, b.PROPERTY);
        aa aaVar = aa.TLC;
        kotlin.l.b.a.b.b.w a4 = aa.a(kotlin.l.b.a.b.e.b.b.TAW.get(avH));
        aa aaVar2 = aa.TLC;
        ba a5 = aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(avH));
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBn.avk(avH);
        p.g(avk, "Flags.IS_VAR.get(flags)");
        boolean booleanValue = avk.booleanValue();
        f b2 = x.b(this.TLm.SZH, mVar.Tyk);
        aa aaVar3 = aa.TLC;
        b.a a6 = aa.a(kotlin.l.b.a.b.e.b.b.TBf.get(avH));
        Boolean avk2 = kotlin.l.b.a.b.e.b.b.TBr.avk(avH);
        p.g(avk2, "Flags.IS_LATEINIT.get(flags)");
        boolean booleanValue2 = avk2.booleanValue();
        Boolean avk3 = kotlin.l.b.a.b.e.b.b.TBq.avk(avH);
        p.g(avk3, "Flags.IS_CONST.get(flags)");
        boolean booleanValue3 = avk3.booleanValue();
        Boolean avk4 = kotlin.l.b.a.b.e.b.b.TBt.avk(avH);
        p.g(avk4, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = avk4.booleanValue();
        Boolean avk5 = kotlin.l.b.a.b.e.b.b.TBu.avk(avH);
        p.g(avk5, "Flags.IS_DELEGATED.get(flags)");
        boolean booleanValue5 = avk5.booleanValue();
        Boolean avk6 = kotlin.l.b.a.b.e.b.b.TBv.avk(avH);
        p.g(avk6, "Flags.IS_EXPECT_PROPERTY.get(flags)");
        j jVar2 = new j(lVar, null, a3, a4, a5, booleanValue, b2, a6, booleanValue2, booleanValue3, booleanValue4, booleanValue5, avk6.booleanValue(), mVar, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
        List<a.r> list = mVar.Txu;
        p.g(list, "proto.typeParameterList");
        n a7 = n.a(this.TLm, jVar2, list);
        Boolean avk7 = kotlin.l.b.a.b.e.b.b.TBo.avk(avH);
        p.g(avk7, "Flags.HAS_GETTER.get(flags)");
        boolean booleanValue6 = avk7.booleanValue();
        if (!booleanValue6 || !kotlin.l.b.a.b.e.b.g.e(mVar)) {
            g.a aVar = g.TiC;
            hBP = g.a.hBP();
        } else {
            hBP = a(mVar, b.PROPERTY_GETTER);
        }
        kotlin.l.b.a.b.m.ab r2 = a7.TKY.r(kotlin.l.b.a.b.e.b.g.a(mVar, this.TLm.SZI));
        List<as> hLg = a7.TKY.hLg();
        ak hAs = hAs();
        a.p b3 = kotlin.l.b.a.b.e.b.g.b(mVar, this.TLm.SZI);
        if (b3 == null || (r = a7.TKY.r(b3)) == null) {
            jVar = jVar2;
            akVar = null;
            akVar2 = hAs;
            hLg = hLg;
        } else {
            akVar = kotlin.l.b.a.b.j.b.a(jVar2, r, hBP);
            akVar2 = hAs;
            jVar = jVar2;
        }
        jVar.a(r2, hLg, akVar2, akVar);
        Boolean avk8 = kotlin.l.b.a.b.e.b.b.TAU.avk(avH);
        p.g(avk8, "Flags.HAS_ANNOTATIONS.get(flags)");
        int a8 = kotlin.l.b.a.b.e.b.b.a(avk8.booleanValue(), kotlin.l.b.a.b.e.b.b.TAV.get(avH), kotlin.l.b.a.b.e.b.b.TAW.get(avH));
        if (booleanValue6) {
            if (mVar.hGx()) {
                i2 = mVar.TyV;
            } else {
                i2 = a8;
            }
            Boolean avk9 = kotlin.l.b.a.b.e.b.b.TBz.avk(i2);
            p.g(avk9, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = avk9.booleanValue();
            Boolean avk10 = kotlin.l.b.a.b.e.b.b.TBA.avk(i2);
            p.g(avk10, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = avk10.booleanValue();
            Boolean avk11 = kotlin.l.b.a.b.e.b.b.TBB.avk(i2);
            p.g(avk11, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = avk11.booleanValue();
            g a9 = a(mVar, i2, b.PROPERTY_GETTER);
            if (booleanValue7) {
                j jVar3 = jVar2;
                aa aaVar4 = aa.TLC;
                kotlin.l.b.a.b.b.w a10 = aa.a(kotlin.l.b.a.b.e.b.b.TAW.get(i2));
                aa aaVar5 = aa.TLC;
                a2 = new ab(jVar3, a9, a10, aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(i2)), !booleanValue7, booleanValue8, booleanValue9, jVar2.hAA(), null, an.ThK);
            } else {
                a2 = kotlin.l.b.a.b.j.b.a(jVar2, a9);
                p.g(a2, "DescriptorFactory.create…er(property, annotations)");
            }
            a2.J(jVar2.hAu());
            abVar = a2;
        } else {
            abVar = null;
        }
        Boolean avk12 = kotlin.l.b.a.b.e.b.b.TBp.avk(avH);
        p.g(avk12, "Flags.HAS_SETTER.get(flags)");
        if (avk12.booleanValue()) {
            if (mVar.hGy()) {
                a8 = mVar.TyW;
            }
            Boolean avk13 = kotlin.l.b.a.b.e.b.b.TBz.avk(a8);
            p.g(avk13, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = avk13.booleanValue();
            Boolean avk14 = kotlin.l.b.a.b.e.b.b.TBA.avk(a8);
            p.g(avk14, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = avk14.booleanValue();
            Boolean avk15 = kotlin.l.b.a.b.e.b.b.TBB.avk(a8);
            p.g(avk15, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = avk15.booleanValue();
            g a11 = a(mVar, a8, b.PROPERTY_SETTER);
            if (booleanValue10) {
                j jVar4 = jVar2;
                aa aaVar6 = aa.TLC;
                kotlin.l.b.a.b.b.w a12 = aa.a(kotlin.l.b.a.b.e.b.b.TAW.get(a8));
                aa aaVar7 = aa.TLC;
                ac acVar2 = new ac(jVar4, a11, a12, aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(a8)), !booleanValue10, booleanValue11, booleanValue12, jVar2.hAA(), null, an.ThK);
                acVar2.a((av) kotlin.a.j.kw(n.a(a7, acVar2, v.SXr).TKZ.a(kotlin.a.j.listOf(mVar.TyU), mVar, b.PROPERTY_SETTER)));
                acVar = acVar2;
            } else {
                g.a aVar2 = g.TiC;
                acVar = kotlin.l.b.a.b.j.b.a(jVar2, a11, g.a.hBP());
                p.g(acVar, "DescriptorFactory.create…ptor */\n                )");
            }
        } else {
            acVar = null;
        }
        Boolean avk16 = kotlin.l.b.a.b.e.b.b.TBs.avk(avH);
        p.g(avk16, "Flags.HAS_CONSTANT.get(flags)");
        if (avk16.booleanValue()) {
            jVar2.a(this.TLm.Tvt.TcN.am(new d(this, mVar, jVar2)));
        }
        jVar2.a(abVar, acVar, new o(a(mVar, false), jVar2), new o(a(mVar, true), jVar2), g.a.COMPATIBLE);
        j jVar5 = jVar2;
        AppMethodBeat.o(60329);
        return jVar5;
    }

    private final void a(k kVar, ak akVar, ak akVar2, List<? extends as> list, List<? extends av> list2, kotlin.l.b.a.b.m.ab abVar, kotlin.l.b.a.b.b.w wVar, ba baVar, Map<? extends a.AbstractC2276a<?>, ?> map, boolean z) {
        AppMethodBeat.i(186259);
        kVar.a(akVar, akVar2, list, list2, abVar, wVar, baVar, map, g.a.COMPATIBLE);
        AppMethodBeat.o(186259);
    }

    private static int avH(int i2) {
        return (i2 & 63) + ((i2 >> 8) << 6);
    }

    public final am g(a.h hVar) {
        int avH;
        kotlin.l.b.a.b.b.a.g hBP;
        i iVar;
        k kVar;
        w wVar;
        ak akVar;
        kotlin.l.b.a.b.m.ab r;
        AppMethodBeat.i(60331);
        p.h(hVar, "proto");
        if (hVar.hEP()) {
            avH = hVar.Txb;
        } else {
            avH = avH(hVar.Tyx);
        }
        kotlin.l.b.a.b.b.a.g a2 = a(hVar, avH, b.FUNCTION);
        if (kotlin.l.b.a.b.e.b.g.f(hVar)) {
            hBP = a(hVar, b.FUNCTION);
        } else {
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            hBP = g.a.hBP();
        }
        if (p.j(kotlin.l.b.a.b.j.d.a.o(this.TLm.Tko).p(x.b(this.TLm.SZH, hVar.Tyk)), ac.TLE)) {
            i.a aVar2 = i.TBK;
            iVar = i.TBJ;
        } else {
            iVar = this.TLm.TLa;
        }
        l lVar = this.TLm.Tko;
        f b2 = x.b(this.TLm.SZH, hVar.Tyk);
        aa aaVar = aa.TLC;
        k kVar2 = new k(lVar, a2, b2, aa.a(kotlin.l.b.a.b.e.b.b.TBf.get(avH)), hVar, this.TLm.SZH, this.TLm.SZI, iVar, this.TLm.TLb);
        List<a.r> list = hVar.Txu;
        p.g(list, "proto.typeParameterList");
        n a3 = n.a(this.TLm, kVar2, list);
        a.p b3 = kotlin.l.b.a.b.e.b.g.b(hVar, this.TLm.SZI);
        if (b3 == null || (r = a3.TKY.r(b3)) == null) {
            kVar = kVar2;
            wVar = this;
            akVar = null;
        } else {
            akVar = kotlin.l.b.a.b.j.b.a(kVar2, r, hBP);
            kVar = kVar2;
            wVar = this;
        }
        ak hAs = hAs();
        List<as> hLg = a3.TKY.hLg();
        w wVar2 = a3.TKZ;
        List<a.t> list2 = hVar.TxT;
        p.g(list2, "proto.valueParameterList");
        List<av> a4 = wVar2.a(list2, hVar, b.FUNCTION);
        kotlin.l.b.a.b.m.ab r2 = a3.TKY.r(kotlin.l.b.a.b.e.b.g.a(hVar, this.TLm.SZI));
        aa aaVar2 = aa.TLC;
        kotlin.l.b.a.b.b.w a5 = aa.a(kotlin.l.b.a.b.e.b.b.TAW.get(avH));
        aa aaVar3 = aa.TLC;
        ba a6 = aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(avH));
        Map<? extends a.AbstractC2276a<?>, ?> emptyMap = ae.emptyMap();
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBl.avk(avH);
        p.g(avk, "Flags.IS_SUSPEND.get(flags)");
        wVar.a(kVar, akVar, hAs, hLg, a4, r2, a5, a6, emptyMap, avk.booleanValue());
        Boolean avk2 = kotlin.l.b.a.b.e.b.b.TBg.avk(avH);
        p.g(avk2, "Flags.IS_OPERATOR.get(flags)");
        kVar2.TkM = avk2.booleanValue();
        Boolean avk3 = kotlin.l.b.a.b.e.b.b.TBh.avk(avH);
        p.g(avk3, "Flags.IS_INFIX.get(flags)");
        kVar2.TkN = avk3.booleanValue();
        Boolean avk4 = kotlin.l.b.a.b.e.b.b.TBk.avk(avH);
        p.g(avk4, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        kVar2.Tkp = avk4.booleanValue();
        Boolean avk5 = kotlin.l.b.a.b.e.b.b.TBi.avk(avH);
        p.g(avk5, "Flags.IS_INLINE.get(flags)");
        kVar2.TkO = avk5.booleanValue();
        Boolean avk6 = kotlin.l.b.a.b.e.b.b.TBj.avk(avH);
        p.g(avk6, "Flags.IS_TAILREC.get(flags)");
        kVar2.TkP = avk6.booleanValue();
        Boolean avk7 = kotlin.l.b.a.b.e.b.b.TBl.avk(avH);
        p.g(avk7, "Flags.IS_SUSPEND.get(flags)");
        kVar2.TkU = avk7.booleanValue();
        Boolean avk8 = kotlin.l.b.a.b.e.b.b.TBm.avk(avH);
        p.g(avk8, "Flags.IS_EXPECT_FUNCTION.get(flags)");
        kVar2.TkQ = avk8.booleanValue();
        this.TLm.Tvt.TKT.a(hVar, kVar2, this.TLm.SZI, this.TLm.TKY);
        k kVar3 = kVar2;
        AppMethodBeat.o(60331);
        return kVar3;
    }

    public final ar f(a.q qVar) {
        a.p avo;
        a.p avo2;
        AppMethodBeat.i(60332);
        p.h(qVar, "proto");
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        List<a.C2299a> list = qVar.TzK;
        p.g(list, "proto.annotationList");
        List<a.C2299a> list2 = list;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
        for (T t : list2) {
            f fVar = this.Tvk;
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(fVar.b(t, this.TLm.SZH));
        }
        kotlin.l.b.a.b.b.a.g kA = g.a.kA(arrayList);
        aa aaVar = aa.TLC;
        kotlin.l.b.a.b.k.a.b.l lVar = new kotlin.l.b.a.b.k.a.b.l(this.TLm.Tvt.TcN, this.TLm.Tko, kA, x.b(this.TLm.SZH, qVar.Tyk), aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(qVar.Txb)), qVar, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
        List<a.r> list3 = qVar.Txu;
        p.g(list3, "proto.typeParameterList");
        n a2 = n.a(this.TLm, lVar, list3);
        List<as> hLg = a2.TKY.hLg();
        ad adVar = a2.TKY;
        h hVar = this.TLm.SZI;
        p.h(qVar, "$this$underlyingType");
        p.h(hVar, "typeTable");
        if (qVar.hHr()) {
            avo = qVar.TzG;
            p.g(avo, "underlyingType");
        } else if (qVar.hHs()) {
            avo = hVar.avo(qVar.TzH);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
            AppMethodBeat.o(60332);
            throw illegalStateException;
        }
        aj s = adVar.s(avo);
        ad adVar2 = a2.TKY;
        h hVar2 = this.TLm.SZI;
        p.h(qVar, "$this$expandedType");
        p.h(hVar2, "typeTable");
        if (qVar.hHt()) {
            avo2 = qVar.TzI;
            p.g(avo2, "expandedType");
        } else if (qVar.hHu()) {
            avo2 = hVar2.avo(qVar.TzJ);
        } else {
            IllegalStateException illegalStateException2 = new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
            AppMethodBeat.o(60332);
            throw illegalStateException2;
        }
        lVar.a(hLg, s, adVar2.s(avo2), g.a.COMPATIBLE);
        kotlin.l.b.a.b.k.a.b.l lVar2 = lVar;
        AppMethodBeat.o(60332);
        return lVar2;
    }

    private final ak hAs() {
        AppMethodBeat.i(60333);
        l lVar = this.TLm.Tko;
        if (!(lVar instanceof kotlin.l.b.a.b.b.e)) {
            lVar = null;
        }
        kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) lVar;
        if (eVar != null) {
            ak hAO = eVar.hAO();
            AppMethodBeat.o(60333);
            return hAO;
        }
        AppMethodBeat.o(60333);
        return null;
    }

    public final kotlin.l.b.a.b.b.d a(a.c cVar, boolean z) {
        AppMethodBeat.i(60334);
        p.h(cVar, "proto");
        l lVar = this.TLm.Tko;
        if (lVar == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            AppMethodBeat.o(60334);
            throw tVar;
        }
        kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) lVar;
        kotlin.l.b.a.b.k.a.b.d dVar = new kotlin.l.b.a.b.k.a.b.d(eVar, a(cVar, cVar.Txb, b.FUNCTION), z, b.a.DECLARATION, cVar, this.TLm.SZH, this.TLm.SZI, this.TLm.TLa, this.TLm.TLb);
        w wVar = n.a(this.TLm, dVar, v.SXr).TKZ;
        List<a.t> list = cVar.TxT;
        p.g(list, "proto.valueParameterList");
        List<av> a2 = wVar.a(list, cVar, b.FUNCTION);
        aa aaVar = aa.TLC;
        dVar.a(a2, aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(cVar.Txb)));
        dVar.I(eVar.hAG());
        p.g(dVar.hAw(), "descriptor.valueParameters");
        p.g(dVar.hAt(), "descriptor.typeParameters");
        dVar.hAu();
        dVar.a(g.a.COMPATIBLE);
        kotlin.l.b.a.b.k.a.b.d dVar2 = dVar;
        AppMethodBeat.o(60334);
        return dVar2;
    }

    private final kotlin.l.b.a.b.b.a.g a(q qVar, int i2, b bVar) {
        AppMethodBeat.i(60335);
        if (!kotlin.l.b.a.b.e.b.b.TAU.avk(i2).booleanValue()) {
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
            AppMethodBeat.o(60335);
            return hBP;
        }
        n nVar = new n(this.TLm.Tvt.TcN, new a(this, qVar, bVar));
        AppMethodBeat.o(60335);
        return nVar;
    }

    private final kotlin.l.b.a.b.b.a.g a(a.m mVar, boolean z) {
        AppMethodBeat.i(60336);
        if (!kotlin.l.b.a.b.e.b.b.TAU.avk(mVar.Txb).booleanValue()) {
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
            AppMethodBeat.o(60336);
            return hBP;
        }
        n nVar = new n(this.TLm.Tvt.TcN, new b(this, z, mVar));
        AppMethodBeat.o(60336);
        return nVar;
    }

    private final kotlin.l.b.a.b.b.a.g a(q qVar, b bVar) {
        AppMethodBeat.i(60337);
        kotlin.l.b.a.b.k.a.b.b bVar2 = new kotlin.l.b.a.b.k.a.b.b(this.TLm.Tvt.TcN, new c(this, qVar, bVar));
        AppMethodBeat.o(60337);
        return bVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.l.b.a.b.b.av> a(java.util.List<kotlin.l.b.a.b.e.a.t> r25, kotlin.l.b.a.b.h.q r26, kotlin.l.b.a.b.k.a.b r27) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.w.a(java.util.List, kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.k.a.b):java.util.List");
    }

    private final z K(l lVar) {
        AppMethodBeat.i(60339);
        if (lVar instanceof kotlin.l.b.a.b.b.ab) {
            z.b bVar = new z.b(((kotlin.l.b.a.b.b.ab) lVar).hBk(), this.TLm.SZH, this.TLm.SZI, this.TLm.TLb);
            AppMethodBeat.o(60339);
            return bVar;
        } else if (lVar instanceof kotlin.l.b.a.b.k.a.b.e) {
            z.a aVar = ((kotlin.l.b.a.b.k.a.b.e) lVar).TMd;
            AppMethodBeat.o(60339);
            return aVar;
        } else {
            AppMethodBeat.o(60339);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.l.b.a.b.j.b.g<?>> {
        final /* synthetic */ w TLn;
        final /* synthetic */ a.m TLr;
        final /* synthetic */ j TLs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(w wVar, a.m mVar, j jVar) {
            super(0);
            this.TLn = wVar;
            this.TLr = mVar;
            this.TLs = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.j.b.g<?> invoke() {
            AppMethodBeat.i(60327);
            z a2 = w.a(this.TLn, this.TLn.TLm.Tko);
            if (a2 == null) {
                p.hyc();
            }
            c<kotlin.l.b.a.b.b.a.c, kotlin.l.b.a.b.j.b.g<?>> cVar = this.TLn.TLm.Tvt.TKO;
            a.m mVar = this.TLr;
            kotlin.l.b.a.b.m.ab hAu = this.TLs.hAu();
            p.g(hAu, "property.returnType");
            kotlin.l.b.a.b.j.b.g<?> a3 = cVar.a(a2, mVar, hAu);
            AppMethodBeat.o(60327);
            return a3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
        final /* synthetic */ w TLn;
        final /* synthetic */ q TLo;
        final /* synthetic */ b TLp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar, q qVar, b bVar) {
            super(0);
            this.TLn = wVar;
            this.TLo = qVar;
            this.TLp = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
            v vVar;
            AppMethodBeat.i(60324);
            z a2 = w.a(this.TLn, this.TLn.TLm.Tko);
            if (a2 != null) {
                vVar = kotlin.a.j.p(this.TLn.TLm.Tvt.TKO.a(a2, this.TLo, this.TLp));
            } else {
                vVar = null;
            }
            if (vVar == null) {
                vVar = v.SXr;
            }
            AppMethodBeat.o(60324);
            return vVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
        final /* synthetic */ w TLn;
        final /* synthetic */ boolean TLq;
        final /* synthetic */ a.m TLr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar, boolean z, a.m mVar) {
            super(0);
            this.TLn = wVar;
            this.TLq = z;
            this.TLr = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
            v vVar;
            AppMethodBeat.i(60325);
            z a2 = w.a(this.TLn, this.TLn.TLm.Tko);
            if (a2 == null) {
                vVar = null;
            } else if (this.TLq) {
                vVar = kotlin.a.j.p(this.TLn.TLm.Tvt.TKO.b(a2, this.TLr));
            } else {
                vVar = kotlin.a.j.p(this.TLn.TLm.Tvt.TKO.a(a2, this.TLr));
            }
            if (vVar == null) {
                vVar = v.SXr;
            }
            AppMethodBeat.o(60325);
            return vVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
        final /* synthetic */ w TLn;
        final /* synthetic */ q TLo;
        final /* synthetic */ b TLp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(w wVar, q qVar, b bVar) {
            super(0);
            this.TLn = wVar;
            this.TLo = qVar;
            this.TLp = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
            v vVar;
            AppMethodBeat.i(60326);
            z a2 = w.a(this.TLn, this.TLn.TLm.Tko);
            if (a2 != null) {
                vVar = this.TLn.TLm.Tvt.TKO.b(a2, this.TLo, this.TLp);
            } else {
                vVar = null;
            }
            if (vVar == null) {
                vVar = v.SXr;
            }
            AppMethodBeat.o(60326);
            return vVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
        final /* synthetic */ w TLn;
        final /* synthetic */ a.t TLt;
        final /* synthetic */ z TLu;
        final /* synthetic */ q TLv;
        final /* synthetic */ b TLw;
        final /* synthetic */ kotlin.l.b.a.b.b.a TLx;
        final /* synthetic */ int hAM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(int i2, a.t tVar, w wVar, z zVar, q qVar, b bVar, kotlin.l.b.a.b.b.a aVar) {
            super(0);
            this.hAM = i2;
            this.TLt = tVar;
            this.TLn = wVar;
            this.TLu = zVar;
            this.TLv = qVar;
            this.TLw = bVar;
            this.TLx = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
            AppMethodBeat.i(60328);
            List p = kotlin.a.j.p(this.TLn.TLm.Tvt.TKO.a(this.TLu, this.TLv, this.TLw, this.hAM, this.TLt));
            AppMethodBeat.o(60328);
            return p;
        }
    }
}
