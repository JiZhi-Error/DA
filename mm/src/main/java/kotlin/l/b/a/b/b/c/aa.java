package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.r;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.p;
import kotlin.l.b.a.b.o.i;

public class aa extends al implements ah {
    private List<as> Thx;
    private ak TkJ;
    protected ak TkK;
    public ba TkL;
    protected final boolean TkQ;
    private final boolean TkR;
    private final boolean Tkp;
    private final w Tkq;
    private Collection<? extends ah> TlU;
    private final ah TlV;
    protected final boolean TlW;
    private final boolean TlX;
    protected final boolean TlY;
    public ab TlZ;
    private final b.a Tla;
    protected aj Tma;
    protected boolean Tmb;
    protected r Tmc;
    protected r Tmd;

    public static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57243);
        switch (i2) {
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 35:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                i3 = 2;
                break;
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 35:
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
            case 16:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 30:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 32:
                objArr[0] = "source";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 14:
                objArr[0] = "outType";
                break;
            case 15:
                objArr[0] = "typeParameters";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
                objArr[0] = "copyConfiguration";
                break;
            case 25:
                objArr[0] = "substitutor";
                break;
            case 26:
                objArr[0] = "accessorDescriptor";
                break;
            case 27:
                objArr[0] = "newOwner";
                break;
            case 28:
                objArr[0] = "newModality";
                break;
            case 29:
                objArr[0] = "newVisibility";
                break;
            case 31:
                objArr[0] = "newName";
                break;
            case 35:
                objArr[0] = "overriddenDescriptors";
                break;
        }
        switch (i2) {
            case 17:
                objArr[1] = "getTypeParameters";
                break;
            case 18:
                objArr[1] = "getReturnType";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAccessors";
                break;
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 35:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 23:
                objArr[1] = "getSourceToUseForCopy";
                break;
            case 33:
                objArr[1] = "getOriginal";
                break;
            case 34:
                objArr[1] = "getKind";
                break;
            case 36:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 37:
                objArr[1] = "copy";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
            case 15:
                objArr[2] = "setType";
                break;
            case 16:
                objArr[2] = "setVisibility";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "doSubstitute";
                break;
            case 25:
            case 26:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 35:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                illegalStateException = new IllegalStateException(format);
                break;
            case 22:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 35:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57243);
        throw illegalStateException;
    }

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap
    public final /* synthetic */ kotlin.l.b.a.b.b.a f(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57240);
        ah d2 = d(baVar);
        AppMethodBeat.o(57240);
        return d2;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57238);
        ah hBq = hBq();
        AppMethodBeat.o(57238);
        return hBq;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final /* synthetic */ kotlin.l.b.a.b.b.a hAv() {
        AppMethodBeat.i(57237);
        ah hBq = hBq();
        AppMethodBeat.o(57237);
        return hBq;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final /* synthetic */ b hAz() {
        AppMethodBeat.i(57242);
        ah hBq = hBq();
        AppMethodBeat.o(57242);
        return hBq;
    }

    @Override // kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.c.k
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57239);
        ah hBq = hBq();
        AppMethodBeat.o(57239);
        return hBq;
    }

    @Override // kotlin.l.b.a.b.b.c.ak
    public final /* synthetic */ ax hCq() {
        AppMethodBeat.i(57236);
        ah hBq = hBq();
        AppMethodBeat.o(57236);
        return hBq;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected aa(l lVar, ah ahVar, g gVar, w wVar, ba baVar, boolean z, f fVar, b.a aVar, an anVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(lVar, gVar, fVar, z, anVar);
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
        if (aVar == null) {
            atM(5);
        }
        if (anVar == null) {
            atM(6);
        }
        AppMethodBeat.i(57216);
        this.TlU = null;
        this.Tkq = wVar;
        this.TkL = baVar;
        this.TlV = ahVar == null ? this : ahVar;
        this.Tla = aVar;
        this.TlW = z2;
        this.TlX = z3;
        this.TkQ = z4;
        this.TkR = z5;
        this.Tkp = z6;
        this.TlY = z7;
        AppMethodBeat.o(57216);
    }

    public static aa a(l lVar, g gVar, w wVar, ba baVar, f fVar, b.a aVar, an anVar) {
        AppMethodBeat.i(57217);
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
        if (aVar == null) {
            atM(12);
        }
        if (anVar == null) {
            atM(13);
        }
        aa aaVar = new aa(lVar, null, gVar, wVar, baVar, true, fVar, aVar, anVar, false, false, false, false, false, false);
        AppMethodBeat.o(57217);
        return aaVar;
    }

    public final void a(ab abVar, List<? extends as> list, ak akVar, ak akVar2) {
        AppMethodBeat.i(57218);
        if (abVar == null) {
            atM(14);
        }
        if (list == null) {
            atM(15);
        }
        M(abVar);
        this.Thx = new ArrayList(list);
        this.TkJ = akVar2;
        this.TkK = akVar;
        AppMethodBeat.o(57218);
    }

    public final void a(ab abVar, aj ajVar) {
        AppMethodBeat.i(57219);
        a(abVar, ajVar, (r) null, (r) null);
        AppMethodBeat.o(57219);
    }

    public final void a(ab abVar, aj ajVar, r rVar, r rVar2) {
        this.TlZ = abVar;
        this.Tma = ajVar;
        this.Tmc = rVar;
        this.Tmd = rVar2;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final List<as> hAt() {
        AppMethodBeat.i(57220);
        List<as> list = this.Thx;
        if (list == null) {
            atM(17);
        }
        AppMethodBeat.o(57220);
        return list;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final ak hAr() {
        return this.TkJ;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final ak hAs() {
        return this.TkK;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final ab hAu() {
        AppMethodBeat.i(57221);
        ab hBy = hBy();
        if (hBy == null) {
            atM(18);
        }
        AppMethodBeat.o(57221);
        return hBy;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final w hzC() {
        AppMethodBeat.i(57222);
        w wVar = this.Tkq;
        if (wVar == null) {
            atM(19);
        }
        AppMethodBeat.o(57222);
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        AppMethodBeat.i(57223);
        ba baVar = this.TkL;
        if (baVar == null) {
            atM(20);
        }
        AppMethodBeat.o(57223);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final aj hBo() {
        return this.Tma;
    }

    @Override // kotlin.l.b.a.b.b.ax
    public final boolean hBI() {
        return this.TlW;
    }

    @Override // kotlin.l.b.a.b.b.c.ak, kotlin.l.b.a.b.b.ax
    public boolean hBH() {
        return this.TlX;
    }

    @Override // kotlin.l.b.a.b.b.v
    public boolean isExternal() {
        return this.Tkp;
    }

    @Override // kotlin.l.b.a.b.b.ay
    public final boolean hBJ() {
        return this.TlY;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final List<ag> hBp() {
        AppMethodBeat.i(57224);
        ArrayList arrayList = new ArrayList(2);
        if (this.TlZ != null) {
            arrayList.add(this.TlZ);
        }
        if (this.Tma != null) {
            arrayList.add(this.Tma);
        }
        AppMethodBeat.o(57224);
        return arrayList;
    }

    public class a {
        f TjT = aa.this.hAH();
        ak TkK = aa.this.TkK;
        ba TkL = aa.this.hzE();
        w Tkq = aa.this.hzC();
        ah TlV = null;
        b.a Tla = aa.this.hAA();
        ay Tlg = ay.TOD;
        boolean Tln = true;
        boolean Tlp = false;
        List<as> Tlr = null;
        l Tme = aa.this.hzx();

        static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57215);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case 13:
                case 16:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    i3 = 2;
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case 13:
                case 16:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "modality";
                    break;
                case 6:
                    objArr[0] = "visibility";
                    break;
                case 8:
                    objArr[0] = "kind";
                    break;
                case 10:
                    objArr[0] = "typeParameters";
                    break;
                case 13:
                    objArr[0] = "substitution";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "setOwner";
                    break;
                case 2:
                    objArr[1] = "setOriginal";
                    break;
                case 3:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case 13:
                case 16:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 5:
                    objArr[1] = "setModality";
                    break;
                case 7:
                    objArr[1] = "setVisibility";
                    break;
                case 9:
                    objArr[1] = "setKind";
                    break;
                case 11:
                    objArr[1] = "setTypeParameters";
                    break;
                case 12:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 14:
                    objArr[1] = "setSubstitution";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    break;
                case 4:
                    objArr[2] = "setModality";
                    break;
                case 6:
                    objArr[2] = "setVisibility";
                    break;
                case 8:
                    objArr[2] = "setKind";
                    break;
                case 10:
                    objArr[2] = "setTypeParameters";
                    break;
                case 13:
                    objArr[2] = "setSubstitution";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 4:
                case 6:
                case 8:
                case 10:
                case 13:
                case 16:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57215);
            throw illegalStateException;
        }

        public a() {
            AppMethodBeat.i(57212);
            AppMethodBeat.o(57212);
        }

        public final a g(b bVar) {
            AppMethodBeat.i(57213);
            this.TlV = (ah) bVar;
            if (this == null) {
                atM(2);
            }
            AppMethodBeat.o(57213);
            return this;
        }

        public final ah hCr() {
            AppMethodBeat.i(57214);
            ah a2 = aa.this.a(this);
            AppMethodBeat.o(57214);
            return a2;
        }
    }

    private a hCp() {
        AppMethodBeat.i(57226);
        a aVar = new a();
        AppMethodBeat.o(57226);
        return aVar;
    }

    private static ba a(ba baVar, b.a aVar) {
        AppMethodBeat.i(57228);
        if (aVar != b.a.FAKE_OVERRIDE || !az.b(baVar.hBN())) {
            AppMethodBeat.o(57228);
            return baVar;
        }
        ba baVar2 = az.ThX;
        AppMethodBeat.o(57228);
        return baVar2;
    }

    private static t a(kotlin.l.b.a.b.m.ba baVar, ag agVar) {
        AppMethodBeat.i(57229);
        if (baVar == null) {
            atM(25);
        }
        if (agVar == null) {
            atM(26);
        }
        if (agVar.hAU() != null) {
            t c2 = agVar.hAU().c(baVar);
            AppMethodBeat.o(57229);
            return c2;
        }
        AppMethodBeat.o(57229);
        return null;
    }

    /* access modifiers changed from: protected */
    public aa a(l lVar, w wVar, ba baVar, ah ahVar, b.a aVar, f fVar, an anVar) {
        AppMethodBeat.i(57230);
        if (lVar == null) {
            atM(27);
        }
        if (wVar == null) {
            atM(28);
        }
        if (baVar == null) {
            atM(29);
        }
        if (aVar == null) {
            atM(30);
        }
        if (fVar == null) {
            atM(31);
        }
        if (anVar == null) {
            atM(32);
        }
        aa aaVar = new aa(lVar, ahVar, hzL(), wVar, baVar, this.TmC, fVar, aVar, anVar, this.TlW, hBH(), this.TkQ, this.TkR, isExternal(), this.TlY);
        AppMethodBeat.o(57230);
        return aaVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57231);
        R a2 = nVar.a(this, d2);
        AppMethodBeat.o(57231);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.l.b.a.b.b.ah] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // kotlin.l.b.a.b.b.ah
    public final ah hBq() {
        AppMethodBeat.i(57232);
        ah ahVar = this.TlV;
        ?? r2 = this;
        if (ahVar != this) {
            r2 = this.TlV.hBq();
        }
        if (r2 == 0) {
            atM(33);
        }
        AppMethodBeat.o(57232);
        return r2;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final b.a hAA() {
        AppMethodBeat.i(57233);
        b.a aVar = this.Tla;
        if (aVar == null) {
            atM(34);
        }
        AppMethodBeat.o(57233);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return this.TkQ;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return this.TkR;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final r hBr() {
        return this.Tmc;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final r hBs() {
        return this.Tmd;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.l.b.a.b.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.l.b.a.b.b.b
    public final void x(Collection<? extends b> collection) {
        AppMethodBeat.i(57234);
        if (collection == 0) {
            atM(35);
        }
        this.TlU = collection;
        AppMethodBeat.o(57234);
    }

    @Override // kotlin.l.b.a.b.b.ah, kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public final Collection<? extends ah> hAy() {
        AppMethodBeat.i(57235);
        Collection<? extends ah> emptyList = this.TlU != null ? this.TlU : Collections.emptyList();
        if (emptyList == null) {
            atM(36);
        }
        AppMethodBeat.o(57235);
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.ak
    public <V> V a(a.AbstractC2276a<V> aVar) {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final ah d(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57225);
        if (baVar == null) {
            atM(22);
        }
        if (baVar.Tlg.isEmpty()) {
            AppMethodBeat.o(57225);
            return this;
        }
        a hCp = hCp();
        ay hLK = baVar.hLK();
        if (hLK == null) {
            a.atM(13);
        }
        hCp.Tlg = hLK;
        ah hCr = hCp.g(hBq()).hCr();
        AppMethodBeat.o(57225);
        return hCr;
    }

    /* access modifiers changed from: protected */
    public final ah a(a aVar) {
        an anVar;
        List<as> list;
        ak akVar;
        ad adVar;
        ai hBn;
        ab abVar;
        aj hBo;
        ac acVar;
        o oVar;
        o oVar2;
        AppMethodBeat.i(57227);
        l lVar = aVar.Tme;
        w wVar = aVar.Tkq;
        ba baVar = aVar.TkL;
        ah ahVar = aVar.TlV;
        b.a aVar2 = aVar.Tla;
        f fVar = aVar.TjT;
        boolean z = aVar.Tlp;
        ah ahVar2 = aVar.TlV;
        if (z) {
            if (ahVar2 == null) {
                ahVar2 = hBq();
            }
            anVar = ahVar2.hzM();
        } else {
            anVar = an.ThK;
        }
        if (anVar == null) {
            atM(23);
        }
        aa a2 = a(lVar, wVar, baVar, ahVar, aVar2, fVar, anVar);
        if (aVar.Tlr == null) {
            list = hAt();
        } else {
            list = aVar.Tlr;
        }
        ArrayList arrayList = new ArrayList(list.size());
        kotlin.l.b.a.b.m.ba a3 = p.a(list, aVar.Tlg, a2, arrayList);
        ab c2 = a3.c(hBy(), bh.OUT_VARIANCE);
        if (c2 == null) {
            AppMethodBeat.o(57227);
            return null;
        }
        ak akVar2 = aVar.TkK;
        if (akVar2 != null) {
            akVar = akVar2.e(a3);
            if (akVar == null) {
                AppMethodBeat.o(57227);
                return null;
            }
        } else {
            akVar = null;
        }
        if (this.TkJ != null) {
            ab c3 = a3.c(this.TkJ.hBy(), bh.IN_VARIANCE);
            if (c3 == null) {
                AppMethodBeat.o(57227);
                return null;
            }
            adVar = new ad(a2, new kotlin.l.b.a.b.j.f.a.b(a2, c3, this.TkJ.hBt()), this.TkJ.hzL());
        } else {
            adVar = null;
        }
        a2.a(c2, arrayList, akVar, adVar);
        if (this.TlZ == null) {
            abVar = null;
        } else {
            g hzL = this.TlZ.hzL();
            w wVar2 = aVar.Tkq;
            ba a4 = a(this.TlZ.hzE(), aVar.Tla);
            boolean z2 = this.TlZ.isDefault;
            boolean z3 = this.TlZ.Tkp;
            boolean z4 = this.TlZ.TkO;
            b.a aVar3 = aVar.Tla;
            if (aVar.TlV == null) {
                hBn = null;
            } else {
                hBn = aVar.TlV.hBn();
            }
            abVar = new ab(a2, hzL, wVar2, a4, z2, z3, z4, aVar3, hBn, an.ThK);
        }
        if (abVar != null) {
            ab hAu = this.TlZ.hAu();
            abVar.Tlb = a(a3, this.TlZ);
            abVar.J(hAu != null ? a3.c(hAu, bh.OUT_VARIANCE) : null);
        }
        if (this.Tma == null) {
            acVar = null;
        } else {
            g hzL2 = this.Tma.hzL();
            w wVar3 = aVar.Tkq;
            ba a5 = a(this.Tma.hzE(), aVar.Tla);
            boolean isDefault = this.Tma.isDefault();
            boolean isExternal = this.Tma.isExternal();
            boolean hzI = this.Tma.hzI();
            b.a aVar4 = aVar.Tla;
            if (aVar.TlV == null) {
                hBo = null;
            } else {
                hBo = aVar.TlV.hBo();
            }
            acVar = new ac(a2, hzL2, wVar3, a5, isDefault, isExternal, hzI, aVar4, hBo, an.ThK);
        }
        if (acVar != null) {
            List<av> a6 = p.a((t) acVar, this.Tma.hAw(), a3, false, false, (boolean[]) null);
            if (a6 == null) {
                a2.Tmb = true;
                a6 = Collections.singletonList(ac.a(acVar, kotlin.l.b.a.b.j.d.a.G(aVar.Tme).hzh(), this.Tma.hAw().get(0).hzL()));
            }
            if (a6.size() != 1) {
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(57227);
                throw illegalStateException;
            }
            acVar.Tlb = a(a3, this.Tma);
            acVar.a(a6.get(0));
        }
        if (this.Tmc == null) {
            oVar = null;
        } else {
            oVar = new o(this.Tmc.hzL(), a2);
        }
        if (this.Tmd == null) {
            oVar2 = null;
        } else {
            oVar2 = new o(this.Tmd.hzL(), a2);
        }
        a2.a(abVar, acVar, oVar, oVar2);
        if (aVar.Tln) {
            i hLZ = i.hLZ();
            for (ah ahVar3 : hAy()) {
                hLZ.add(ahVar3.d(a3));
            }
            a2.x(hLZ);
        }
        if (hBH() && this.TmD != null) {
            a2.a(this.TmD);
        }
        AppMethodBeat.o(57227);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.ah
    public final /* bridge */ /* synthetic */ ai hBn() {
        return this.TlZ;
    }

    @Override // kotlin.l.b.a.b.b.b
    public final /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        AppMethodBeat.i(57241);
        a hCp = hCp();
        if (lVar == null) {
            a.atM(0);
        }
        hCp.Tme = lVar;
        a g2 = hCp.g(null);
        if (wVar == null) {
            a.atM(4);
        }
        g2.Tkq = wVar;
        if (baVar == null) {
            a.atM(6);
        }
        g2.TkL = baVar;
        if (aVar == null) {
            a.atM(8);
        }
        g2.Tla = aVar;
        g2.Tln = false;
        ah hCr = g2.hCr();
        if (hCr == null) {
            atM(37);
        }
        AppMethodBeat.o(57241);
        return hCr;
    }
}
