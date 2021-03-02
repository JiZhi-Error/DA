package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
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

public class h extends g {
    static final /* synthetic */ boolean $assertionsDisabled = (!h.class.desiredAssertionStatus());
    private final w Tkq;
    private final f Tkr;
    private final at Tks;
    private kotlin.l.b.a.b.j.f.h Tkt;
    private Set<d> Tku;
    private d Tkv;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57057);
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                illegalStateException = new IllegalStateException(format);
                break;
            case 12:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57057);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57056);
        AppMethodBeat.o(57056);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(l lVar, kotlin.l.b.a.b.f.f fVar, w wVar, f fVar2, Collection<ab> collection, an anVar, j jVar) {
        super(jVar, lVar, fVar, anVar);
        if (lVar == null) {
            atM(0);
        }
        if (fVar == null) {
            atM(1);
        }
        if (wVar == null) {
            atM(2);
        }
        if (fVar2 == null) {
            atM(3);
        }
        if (collection == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        if (jVar == null) {
            atM(6);
        }
        AppMethodBeat.i(57043);
        if ($assertionsDisabled || wVar != w.SEALED) {
            this.Tkq = wVar;
            this.Tkr = fVar2;
            this.Tks = new kotlin.l.b.a.b.m.j(this, Collections.emptyList(), collection, jVar);
            AppMethodBeat.o(57043);
            return;
        }
        AssertionError assertionError = new AssertionError("Implement getSealedSubclasses() for this class: " + getClass());
        AppMethodBeat.o(57043);
        throw assertionError;
    }

    public final void a(kotlin.l.b.a.b.j.f.h hVar, Set<d> set, d dVar) {
        AppMethodBeat.i(57044);
        if (hVar == null) {
            atM(7);
        }
        if (set == null) {
            atM(8);
        }
        this.Tkt = hVar;
        this.Tku = set;
        this.Tkv = dVar;
        AppMethodBeat.o(57044);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final g hzL() {
        AppMethodBeat.i(57045);
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        if (hBP == null) {
            atM(9);
        }
        AppMethodBeat.o(57045);
        return hBP;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        AppMethodBeat.i(57046);
        at atVar = this.Tks;
        if (atVar == null) {
            atM(10);
        }
        AppMethodBeat.o(57046);
        return atVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<d> hxW() {
        AppMethodBeat.i(57047);
        Set<d> set = this.Tku;
        if (set == null) {
            atM(11);
        }
        AppMethodBeat.o(57047);
        return set;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final kotlin.l.b.a.b.j.f.h a(i iVar) {
        AppMethodBeat.i(57048);
        if (iVar == null) {
            atM(12);
        }
        kotlin.l.b.a.b.j.f.h hVar = this.Tkt;
        if (hVar == null) {
            atM(13);
        }
        AppMethodBeat.o(57048);
        return hVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h hzy() {
        AppMethodBeat.i(57049);
        h.b bVar = h.b.TKa;
        if (bVar == null) {
            atM(14);
        }
        AppMethodBeat.o(57049);
        return bVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hzA() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final f hzB() {
        AppMethodBeat.i(57050);
        f fVar = this.Tkr;
        if (fVar == null) {
            atM(15);
        }
        AppMethodBeat.o(57050);
        return fVar;
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

    @Override // kotlin.l.b.a.b.b.e
    public final d hzD() {
        return this.Tkv;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        AppMethodBeat.i(57051);
        w wVar = this.Tkq;
        if (wVar == null) {
            atM(16);
        }
        AppMethodBeat.o(57051);
        return wVar;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        AppMethodBeat.i(57052);
        ba baVar = az.ThU;
        if (baVar == null) {
            atM(17);
        }
        AppMethodBeat.o(57052);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        return false;
    }

    public String toString() {
        AppMethodBeat.i(57053);
        String str = "class " + hAH();
        AppMethodBeat.o(57053);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(57054);
        List<as> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(18);
        }
        AppMethodBeat.o(57054);
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<e> hzN() {
        AppMethodBeat.i(57055);
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(19);
        }
        AppMethodBeat.o(57055);
        return emptyList;
    }
}
