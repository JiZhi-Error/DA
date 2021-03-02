package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.p;

public final class s extends t {
    private at Tks;
    private final t TlB;
    private final ba TlC;
    private ba TlD;
    private List<as> TlE;
    private List<as> TlF;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalArgumentException;
        AppMethodBeat.i(57167);
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            default:
                str = "@NotNull method %s.%s must not return null";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                i3 = 3;
                break;
            default:
                i3 = 2;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 2:
            case 8:
                objArr[0] = "typeArguments";
                break;
            case 3:
            case 6:
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 5:
            case 10:
                objArr[0] = "typeSubstitution";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getConstructors";
                break;
            case 18:
                objArr[1] = "getAnnotations";
                break;
            case 19:
                objArr[1] = "getName";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getContainingDeclaration";
                break;
            case 23:
                objArr[1] = "substitute";
                break;
            case 24:
                objArr[1] = "getKind";
                break;
            case 25:
                objArr[1] = "getModality";
                break;
            case 26:
                objArr[1] = "getVisibility";
                break;
            case 27:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 28:
                objArr[1] = "getSource";
                break;
            case 29:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 30:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
                objArr[2] = "getMemberScope";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 22:
                illegalArgumentException = new IllegalArgumentException(format);
                break;
            default:
                illegalArgumentException = new IllegalStateException(format);
                break;
        }
        AppMethodBeat.o(57167);
        throw illegalArgumentException;
    }

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap
    public final /* synthetic */ i f(ba baVar) {
        AppMethodBeat.i(57166);
        if (baVar == null) {
            atM(22);
        }
        if (baVar.Tlg.isEmpty()) {
            AppMethodBeat.o(57166);
            return this;
        }
        s sVar = new s(this, ba.b(baVar.hLK(), hCf().hLK()));
        AppMethodBeat.o(57166);
        return sVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57165);
        e hAP = hAP();
        AppMethodBeat.o(57165);
        return hAP;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final /* synthetic */ h hAF() {
        AppMethodBeat.i(57164);
        e hAP = hAP();
        AppMethodBeat.o(57164);
        return hAP;
    }

    public s(t tVar, ba baVar) {
        this.TlB = tVar;
        this.TlC = baVar;
    }

    private ba hCf() {
        AppMethodBeat.i(57133);
        if (this.TlD == null) {
            if (this.TlC.Tlg.isEmpty()) {
                this.TlD = this.TlC;
            } else {
                List<as> parameters = this.TlB.hzz().getParameters();
                this.TlE = new ArrayList(parameters.size());
                this.TlD = p.a(parameters, this.TlC.hLK(), this, this.TlE);
                this.TlF = j.c((Iterable) this.TlE, (b) new b<as, Boolean>() {
                    /* class kotlin.l.b.a.b.b.c.s.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ Boolean invoke(as asVar) {
                        boolean z;
                        AppMethodBeat.i(57132);
                        if (!asVar.hAC()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Boolean valueOf = Boolean.valueOf(z);
                        AppMethodBeat.o(57132);
                        return valueOf;
                    }
                });
            }
        }
        ba baVar = this.TlD;
        AppMethodBeat.o(57133);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        AppMethodBeat.i(57134);
        at hzz = this.TlB.hzz();
        if (this.TlC.Tlg.isEmpty()) {
            if (hzz == null) {
                atM(0);
            }
            AppMethodBeat.o(57134);
        } else {
            if (this.Tks == null) {
                ba hCf = hCf();
                Collection<ab> hBV = hzz.hBV();
                ArrayList arrayList = new ArrayList(hBV.size());
                for (ab abVar : hBV) {
                    arrayList.add(hCf.c(abVar, bh.INVARIANT));
                }
                this.Tks = new kotlin.l.b.a.b.m.j(this, this.TlE, arrayList, kotlin.l.b.a.b.l.b.TMN);
            }
            hzz = this.Tks;
            if (hzz == null) {
                atM(1);
            }
            AppMethodBeat.o(57134);
        }
        return hzz;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final kotlin.l.b.a.b.j.f.h a(ay ayVar, kotlin.l.b.a.b.m.a.i iVar) {
        AppMethodBeat.i(57135);
        if (ayVar == null) {
            atM(5);
        }
        if (iVar == null) {
            atM(6);
        }
        kotlin.l.b.a.b.j.f.h a2 = this.TlB.a(ayVar, iVar);
        if (this.TlC.Tlg.isEmpty()) {
            if (a2 == null) {
                atM(7);
            }
            AppMethodBeat.o(57135);
            return a2;
        }
        kotlin.l.b.a.b.j.f.l lVar = new kotlin.l.b.a.b.j.f.l(a2, hCf());
        AppMethodBeat.o(57135);
        return lVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h a(ay ayVar) {
        AppMethodBeat.i(57136);
        if (ayVar == null) {
            atM(10);
        }
        kotlin.l.b.a.b.j.f.h a2 = a(ayVar, a.d(c.s(this)));
        if (a2 == null) {
            atM(11);
        }
        AppMethodBeat.o(57136);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h hAM() {
        AppMethodBeat.i(57137);
        kotlin.l.b.a.b.j.f.h a2 = a(a.d(c.s(this.TlB)));
        if (a2 == null) {
            atM(12);
        }
        AppMethodBeat.o(57137);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final kotlin.l.b.a.b.j.f.h a(kotlin.l.b.a.b.m.a.i iVar) {
        AppMethodBeat.i(57138);
        if (iVar == null) {
            atM(13);
        }
        kotlin.l.b.a.b.j.f.h a2 = this.TlB.a(iVar);
        if (this.TlC.Tlg.isEmpty()) {
            if (a2 == null) {
                atM(14);
            }
            AppMethodBeat.o(57138);
            return a2;
        }
        kotlin.l.b.a.b.j.f.l lVar = new kotlin.l.b.a.b.j.f.l(a2, hCf());
        AppMethodBeat.o(57138);
        return lVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h hzy() {
        AppMethodBeat.i(57139);
        kotlin.l.b.a.b.j.f.h hzy = this.TlB.hzy();
        if (hzy == null) {
            atM(15);
        }
        AppMethodBeat.o(57139);
        return hzy;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.h
    public final aj hAG() {
        AppMethodBeat.i(57140);
        aj a2 = ac.a(hzL(), hzz(), bc.kI(hzz().getParameters()), false, hAM());
        AppMethodBeat.o(57140);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final ak hAO() {
        AppMethodBeat.i(57141);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(57141);
        throw unsupportedOperationException;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<d> hxW() {
        AppMethodBeat.i(57142);
        Collection<d> hxW = this.TlB.hxW();
        ArrayList arrayList = new ArrayList(hxW.size());
        for (d dVar : hxW) {
            arrayList.add(((d) dVar.hBa().d(dVar.hAL()).a(dVar.hzC()).a(dVar.hzE()).a(dVar.hAA()).EB(false).hBg()).a(hCf()));
        }
        AppMethodBeat.o(57142);
        return arrayList;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(57143);
        g hzL = this.TlB.hzL();
        if (hzL == null) {
            atM(18);
        }
        AppMethodBeat.o(57143);
        return hzL;
    }

    @Override // kotlin.l.b.a.b.b.z
    public final f hAH() {
        AppMethodBeat.i(57144);
        f hAH = this.TlB.hAH();
        if (hAH == null) {
            atM(19);
        }
        AppMethodBeat.o(57144);
        return hAH;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hAP() {
        AppMethodBeat.i(57145);
        e hAP = this.TlB.hAP();
        if (hAP == null) {
            atM(20);
        }
        AppMethodBeat.o(57145);
        return hAP;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public final l hzx() {
        AppMethodBeat.i(57146);
        l hzx = this.TlB.hzx();
        if (hzx == null) {
            atM(21);
        }
        AppMethodBeat.o(57146);
        return hzx;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hzA() {
        AppMethodBeat.i(57147);
        e hzA = this.TlB.hzA();
        AppMethodBeat.o(57147);
        return hzA;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.f hzB() {
        AppMethodBeat.i(57148);
        kotlin.l.b.a.b.b.f hzB = this.TlB.hzB();
        if (hzB == null) {
            atM(24);
        }
        AppMethodBeat.o(57148);
        return hzB;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        AppMethodBeat.i(57149);
        w hzC = this.TlB.hzC();
        if (hzC == null) {
            atM(25);
        }
        AppMethodBeat.o(57149);
        return hzC;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final kotlin.l.b.a.b.b.ba hzE() {
        AppMethodBeat.i(57150);
        kotlin.l.b.a.b.b.ba hzE = this.TlB.hzE();
        if (hzE == null) {
            atM(26);
        }
        AppMethodBeat.o(57150);
        return hzE;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        AppMethodBeat.i(57151);
        boolean hzG = this.TlB.hzG();
        AppMethodBeat.o(57151);
        return hzG;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        AppMethodBeat.i(57152);
        boolean hzH = this.TlB.hzH();
        AppMethodBeat.o(57152);
        return hzH;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        AppMethodBeat.i(57153);
        boolean hzI = this.TlB.hzI();
        AppMethodBeat.o(57153);
        return hzI;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean isExternal() {
        AppMethodBeat.i(57154);
        boolean isExternal = this.TlB.isExternal();
        AppMethodBeat.o(57154);
        return isExternal;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        AppMethodBeat.i(57155);
        boolean hzF = this.TlB.hzF();
        AppMethodBeat.o(57155);
        return hzF;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        AppMethodBeat.i(57156);
        boolean hzJ = this.TlB.hzJ();
        AppMethodBeat.o(57156);
        return hzJ;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        AppMethodBeat.i(57157);
        boolean hzK = this.TlB.hzK();
        AppMethodBeat.o(57157);
        return hzK;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57158);
        R a2 = nVar.a(this, d2);
        AppMethodBeat.o(57158);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h hAN() {
        AppMethodBeat.i(57159);
        kotlin.l.b.a.b.j.f.h hAN = this.TlB.hAN();
        if (hAN == null) {
            atM(27);
        }
        AppMethodBeat.o(57159);
        return hAN;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final d hzD() {
        AppMethodBeat.i(57160);
        d hzD = this.TlB.hzD();
        AppMethodBeat.o(57160);
        return hzD;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        AppMethodBeat.i(57161);
        an anVar = an.ThK;
        if (anVar == null) {
            atM(28);
        }
        AppMethodBeat.o(57161);
        return anVar;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(57162);
        hCf();
        List<as> list = this.TlF;
        if (list == null) {
            atM(29);
        }
        AppMethodBeat.o(57162);
        return list;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<e> hzN() {
        AppMethodBeat.i(57163);
        Collection<e> hzN = this.TlB.hzN();
        if (hzN == null) {
            atM(30);
        }
        AppMethodBeat.o(57163);
        return hzN;
    }
}
