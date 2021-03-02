package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.aa;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.j;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.f.s;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;

public class g extends aa implements b {
    private final boolean TqI;
    private final o<a.AbstractC2276a<?>, ?> TqJ;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57729);
        switch (i2) {
            case 21:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 21:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        switch (i2) {
            case 21:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 21:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57729);
        throw illegalStateException;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected g(l lVar, kotlin.l.b.a.b.b.a.g gVar, w wVar, ba baVar, boolean z, f fVar, an anVar, ah ahVar, b.a aVar, boolean z2, o<a.AbstractC2276a<?>, ?> oVar) {
        super(lVar, ahVar, gVar, wVar, baVar, z, fVar, aVar, anVar, false, false, false, false, false, false);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (wVar == null) {
            atM(2);
        }
        if (baVar == null) {
            atM(3);
        }
        if (fVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        if (aVar == null) {
            atM(6);
        }
        AppMethodBeat.i(57723);
        this.TqI = z2;
        this.TqJ = oVar;
        AppMethodBeat.o(57723);
    }

    public static g a(l lVar, kotlin.l.b.a.b.b.a.g gVar, w wVar, ba baVar, boolean z, f fVar, an anVar, boolean z2) {
        AppMethodBeat.i(57724);
        if (lVar == null) {
            atM(7);
        }
        if (gVar == null) {
            atM(8);
        }
        if (wVar == null) {
            atM(9);
        }
        if (baVar == null) {
            atM(10);
        }
        if (fVar == null) {
            atM(11);
        }
        if (anVar == null) {
            atM(12);
        }
        g gVar2 = new g(lVar, gVar, wVar, baVar, z, fVar, anVar, null, b.a.DECLARATION, z2, null);
        AppMethodBeat.o(57724);
        return gVar2;
    }

    @Override // kotlin.l.b.a.b.b.c.aa
    public final aa a(l lVar, w wVar, ba baVar, ah ahVar, b.a aVar, f fVar, an anVar) {
        AppMethodBeat.i(57725);
        if (lVar == null) {
            atM(13);
        }
        if (wVar == null) {
            atM(14);
        }
        if (baVar == null) {
            atM(15);
        }
        if (aVar == null) {
            atM(16);
        }
        if (fVar == null) {
            atM(17);
        }
        if (anVar == null) {
            atM(18);
        }
        g gVar = new g(lVar, hzL(), wVar, baVar, this.TmC, fVar, anVar, ahVar, aVar, this.TqI, this.TqJ);
        AppMethodBeat.o(57725);
        return gVar;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final boolean hAx() {
        return false;
    }

    @Override // kotlin.l.b.a.b.d.a.b.b
    public final b a(ab abVar, List<l> list, ab abVar2, o<a.AbstractC2276a<?>, ?> oVar) {
        kotlin.l.b.a.b.b.c.ab abVar3;
        ak a2;
        aj hBo;
        ai hBn;
        AppMethodBeat.i(57726);
        if (abVar2 == null) {
            atM(20);
        }
        ah hBq = hBq() == this ? null : hBq();
        g gVar = new g(hzx(), hzL(), hzC(), hzE(), this.TmC, hAH(), hzM(), hBq, hAA(), this.TqI, oVar);
        kotlin.l.b.a.b.b.c.ab abVar4 = this.TlZ;
        if (abVar4 != null) {
            kotlin.l.b.a.b.b.a.g hzL = abVar4.hzL();
            w hzC = abVar4.hzC();
            ba hzE = abVar4.hzE();
            boolean z = abVar4.isDefault;
            boolean z2 = abVar4.Tkp;
            boolean z3 = abVar4.TkO;
            b.a hAA = hAA();
            if (hBq == null) {
                hBn = null;
            } else {
                hBn = hBq.hBn();
            }
            kotlin.l.b.a.b.b.c.ab abVar5 = new kotlin.l.b.a.b.b.c.ab(gVar, hzL, hzC, hzE, z, z2, z3, hAA, hBn, abVar4.hzM());
            abVar5.Tlb = abVar4.Tlb;
            abVar5.J(abVar2);
            abVar3 = abVar5;
        } else {
            abVar3 = null;
        }
        ac acVar = null;
        aj ajVar = this.Tma;
        if (ajVar != null) {
            kotlin.l.b.a.b.b.a.g hzL2 = ajVar.hzL();
            w hzC2 = ajVar.hzC();
            ba hzE2 = ajVar.hzE();
            boolean isDefault = ajVar.isDefault();
            boolean isExternal = ajVar.isExternal();
            boolean hzI = ajVar.hzI();
            b.a hAA2 = hAA();
            if (hBq == null) {
                hBo = null;
            } else {
                hBo = hBq.hBo();
            }
            acVar = new ac(gVar, hzL2, hzC2, hzE2, isDefault, isExternal, hzI, hAA2, hBo, ajVar.hzM());
            acVar.Tlb = acVar.Tlb;
            acVar.a(ajVar.hAw().get(0));
        }
        gVar.a(abVar3, acVar, this.Tmc, this.Tmd);
        gVar.Tmb = this.Tmb;
        if (this.TmD != null) {
            gVar.a(this.TmD);
        }
        gVar.x(hAy());
        if (abVar == null) {
            a2 = null;
        } else {
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            a2 = kotlin.l.b.a.b.j.b.a(this, abVar, g.a.hBP());
        }
        gVar.a(abVar2, hAt(), this.TkK, a2);
        AppMethodBeat.o(57726);
        return gVar;
    }

    @Override // kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.aa, kotlin.l.b.a.b.b.ax
    public final boolean hBH() {
        AppMethodBeat.i(57727);
        ab hBy = hBy();
        if (!this.TqI || !j.F(hBy) || (s.T(hBy) && !kotlin.l.b.a.b.a.g.D(hBy))) {
            AppMethodBeat.o(57727);
            return false;
        }
        AppMethodBeat.o(57727);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [B, V] */
    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.aa
    public final <V> V a(a.AbstractC2276a<V> aVar) {
        AppMethodBeat.i(57728);
        if (this.TqJ == null || !this.TqJ.first.equals(aVar)) {
            AppMethodBeat.o(57728);
            return null;
        }
        B b2 = this.TqJ.second;
        AppMethodBeat.o(57728);
        return b2;
    }
}
