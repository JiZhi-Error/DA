package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public class x extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!x.class.desiredAssertionStatus());
    private final j TcN;
    private List<as> Thx;
    private final boolean Thz;
    private ba TkL;
    private w Tkq;
    private final f Tkr;
    private at Tks;
    private final Collection<ab> TlT;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57211);
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                illegalStateException = new IllegalStateException(format);
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57211);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57210);
        AppMethodBeat.o(57210);
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* synthetic */ Collection hxW() {
        AppMethodBeat.i(57209);
        Set<d> hCm = hCm();
        AppMethodBeat.o(57209);
        return hCm;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(l lVar, f fVar, kotlin.l.b.a.b.f.f fVar2, an anVar, j jVar) {
        super(jVar, lVar, fVar2, anVar);
        if (fVar == null) {
            atM(1);
        }
        if (fVar2 == null) {
            atM(2);
        }
        if (anVar == null) {
            atM(3);
        }
        if (jVar == null) {
            atM(4);
        }
        AppMethodBeat.i(57193);
        this.TlT = new ArrayList();
        this.TcN = jVar;
        if ($assertionsDisabled || fVar != f.OBJECT) {
            this.Tkr = fVar;
            this.Thz = false;
            AppMethodBeat.o(57193);
            return;
        }
        AssertionError assertionError = new AssertionError("Fix isCompanionObject()");
        AppMethodBeat.o(57193);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hzA() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(57194);
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        if (hBP == null) {
            atM(5);
        }
        AppMethodBeat.o(57194);
        return hBP;
    }

    public final void b(w wVar) {
        AppMethodBeat.i(57195);
        if (wVar == null) {
            atM(6);
        }
        if ($assertionsDisabled || wVar != w.SEALED) {
            this.Tkq = wVar;
            AppMethodBeat.o(57195);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.o(57195);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        AppMethodBeat.i(57196);
        w wVar = this.Tkq;
        if (wVar == null) {
            atM(7);
        }
        AppMethodBeat.o(57196);
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final f hzB() {
        AppMethodBeat.i(57197);
        f fVar = this.Tkr;
        if (fVar == null) {
            atM(8);
        }
        AppMethodBeat.o(57197);
        return fVar;
    }

    public final void d(ba baVar) {
        AppMethodBeat.i(57198);
        if (baVar == null) {
            atM(9);
        }
        this.TkL = baVar;
        AppMethodBeat.o(57198);
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        AppMethodBeat.i(57199);
        ba baVar = this.TkL;
        if (baVar == null) {
            atM(10);
        }
        AppMethodBeat.o(57199);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        return this.Thz;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        AppMethodBeat.i(57200);
        at atVar = this.Tks;
        if (atVar == null) {
            atM(11);
        }
        AppMethodBeat.o(57200);
        return atVar;
    }

    private static Set<d> hCm() {
        AppMethodBeat.i(57201);
        Set<d> emptySet = Collections.emptySet();
        if (emptySet == null) {
            atM(13);
        }
        AppMethodBeat.o(57201);
        return emptySet;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final d hzD() {
        return null;
    }

    public final void kD(List<as> list) {
        AppMethodBeat.i(57202);
        if (list == null) {
            atM(14);
        }
        if (this.Thx != null) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameters are already set for " + hAH());
            AppMethodBeat.o(57202);
            throw illegalStateException;
        }
        this.Thx = new ArrayList(list);
        AppMethodBeat.o(57202);
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(57203);
        List<as> list = this.Thx;
        if (list == null) {
            atM(15);
        }
        AppMethodBeat.o(57203);
        return list;
    }

    public final void hCn() {
        AppMethodBeat.i(57204);
        if ($assertionsDisabled || this.Tks == null) {
            this.Tks = new kotlin.l.b.a.b.m.j(this, this.Thx, this.TlT, this.TcN);
            Iterator<d> it = hCm().iterator();
            while (it.hasNext()) {
                ((f) it.next()).I(hAG());
            }
            AppMethodBeat.o(57204);
            return;
        }
        AssertionError assertionError = new AssertionError(this.Tks);
        AppMethodBeat.o(57204);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final h a(i iVar) {
        AppMethodBeat.i(57205);
        if (iVar == null) {
            atM(16);
        }
        h.b bVar = h.b.TKa;
        if (bVar == null) {
            atM(17);
        }
        AppMethodBeat.o(57205);
        return bVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final h hzy() {
        AppMethodBeat.i(57206);
        h.b bVar = h.b.TKa;
        if (bVar == null) {
            atM(18);
        }
        AppMethodBeat.o(57206);
        return bVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<e> hzN() {
        AppMethodBeat.i(57207);
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(19);
        }
        AppMethodBeat.o(57207);
        return emptyList;
    }

    public String toString() {
        AppMethodBeat.i(57208);
        String i2 = j.i(this);
        AppMethodBeat.o(57208);
        return i2;
    }
}
