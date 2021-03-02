package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;

public class f extends p implements d {
    static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    private static final kotlin.l.b.a.b.f.f Tkn = kotlin.l.b.a.b.f.f.bua("<init>");
    protected final boolean lNt;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57042);
        switch (i2) {
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                i3 = 2;
                break;
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 5:
            case 8:
            case 23:
                objArr[0] = "annotations";
                break;
            case 2:
            case 22:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 9:
            case 24:
                objArr[0] = "source";
                break;
            case 4:
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 13:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
            case 14:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "typeParameterDescriptors";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 18:
                objArr[0] = "originalSubstitutor";
                break;
            case 20:
                objArr[0] = "overriddenDescriptors";
                break;
            case 21:
                objArr[0] = "newOwner";
                break;
        }
        switch (i2) {
            case 15:
                objArr[1] = "getContainingDeclaration";
                break;
            case 16:
                objArr[1] = "getConstructedClass";
                break;
            case 17:
                objArr[1] = "getOriginal";
                break;
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl";
                break;
            case 19:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 25:
                objArr[1] = "copy";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "create";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSynthesized";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                objArr[2] = "initialize";
                break;
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            case 20:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 21:
            case 22:
            case 23:
            case 24:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 15:
            case 16:
            case 17:
            case 19:
            case 25:
                illegalStateException = new IllegalStateException(format);
                break;
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57042);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57041);
        AppMethodBeat.o(57041);
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final /* bridge */ /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        AppMethodBeat.i(57033);
        d a2 = a(lVar, wVar, baVar, aVar, false);
        AppMethodBeat.o(57033);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.b.c.p
    public /* synthetic */ p a(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57028);
        f b2 = b(lVar, tVar, aVar, fVar, gVar, anVar);
        AppMethodBeat.o(57028);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final /* synthetic */ k b(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57039);
        d a2 = a(baVar);
        AppMethodBeat.o(57039);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t b(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57029);
        d a2 = a(lVar, wVar, baVar, aVar, z);
        AppMethodBeat.o(57029);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t c(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57030);
        d a2 = a(baVar);
        AppMethodBeat.o(57030);
        return a2;
    }

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ a f(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57038);
        d a2 = a(baVar);
        AppMethodBeat.o(57038);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57036);
        d hAL = hAL();
        AppMethodBeat.o(57036);
        return hAL;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final /* synthetic */ i hAR() {
        AppMethodBeat.i(57040);
        e hBY = hBY();
        AppMethodBeat.o(57040);
        return hBY;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t hAT() {
        AppMethodBeat.i(57031);
        d hAL = hAL();
        AppMethodBeat.o(57031);
        return hAL;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ a hAv() {
        AppMethodBeat.i(57035);
        d hAL = hAL();
        AppMethodBeat.o(57035);
        return hAL;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ b hAz() {
        AppMethodBeat.i(57034);
        d hAL = hAL();
        AppMethodBeat.o(57034);
        return hAL;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57037);
        d hAL = hAL();
        AppMethodBeat.o(57037);
        return hAL;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.t
    public final /* synthetic */ l hzx() {
        AppMethodBeat.i(57032);
        e hBY = hBY();
        AppMethodBeat.o(57032);
        return hBY;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected f(e eVar, k kVar, g gVar, boolean z, b.a aVar, an anVar) {
        super(eVar, kVar, gVar, Tkn, aVar, anVar);
        if (eVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (aVar == null) {
            atM(2);
        }
        if (anVar == null) {
            atM(3);
        }
        AppMethodBeat.i(57015);
        this.lNt = z;
        AppMethodBeat.o(57015);
    }

    public static f a(e eVar, g gVar, an anVar) {
        AppMethodBeat.i(57016);
        if (gVar == null) {
            atM(5);
        }
        if (anVar == null) {
            atM(6);
        }
        f fVar = new f(eVar, null, gVar, true, b.a.DECLARATION, anVar);
        AppMethodBeat.o(57016);
        return fVar;
    }

    public final f a(List<av> list, ba baVar) {
        AppMethodBeat.i(57018);
        if (list == null) {
            atM(13);
        }
        if (baVar == null) {
            atM(14);
        }
        a(list, baVar, hBY().hzO());
        AppMethodBeat.o(57018);
        return this;
    }

    public final e hBY() {
        AppMethodBeat.i(57019);
        e eVar = (e) super.hzx();
        if (eVar == null) {
            atM(15);
        }
        AppMethodBeat.o(57019);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final e hAS() {
        AppMethodBeat.i(57020);
        e hBY = hBY();
        if (hBY == null) {
            atM(16);
        }
        AppMethodBeat.o(57020);
        return hBY;
    }

    @Override // kotlin.l.b.a.b.b.d
    public final d hAL() {
        AppMethodBeat.i(57021);
        d dVar = (d) super.hBT();
        if (dVar == null) {
            atM(17);
        }
        AppMethodBeat.o(57021);
        return dVar;
    }

    @Override // kotlin.l.b.a.b.b.d
    public final d a(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57022);
        if (baVar == null) {
            atM(18);
        }
        d dVar = (d) super.f(baVar);
        AppMethodBeat.o(57022);
        return dVar;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.p
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57023);
        R a2 = nVar.a((k) this, (Object) d2);
        AppMethodBeat.o(57023);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final boolean isPrimary() {
        return this.lNt;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final Collection<? extends t> hAy() {
        AppMethodBeat.i(57024);
        Set emptySet = Collections.emptySet();
        if (emptySet == null) {
            atM(19);
        }
        AppMethodBeat.o(57024);
        return emptySet;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final void x(Collection<? extends b> collection) {
        AppMethodBeat.i(57025);
        if (collection == null) {
            atM(20);
        }
        if ($assertionsDisabled || collection.isEmpty()) {
            AppMethodBeat.o(57025);
            return;
        }
        AssertionError assertionError = new AssertionError("Constructors cannot override anything");
        AppMethodBeat.o(57025);
        throw assertionError;
    }

    /* access modifiers changed from: protected */
    public f b(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57026);
        if (lVar == null) {
            atM(21);
        }
        if (aVar == null) {
            atM(22);
        }
        if (gVar == null) {
            atM(23);
        }
        if (anVar == null) {
            atM(24);
        }
        if (aVar != b.a.DECLARATION && aVar != b.a.SYNTHESIZED) {
            IllegalStateException illegalStateException = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
            AppMethodBeat.o(57026);
            throw illegalStateException;
        } else if ($assertionsDisabled || fVar == null) {
            f fVar2 = new f((e) lVar, this, gVar, this.lNt, b.a.DECLARATION, anVar);
            AppMethodBeat.o(57026);
            return fVar2;
        } else {
            AssertionError assertionError = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(57026);
            throw assertionError;
        }
    }

    private d a(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57027);
        d dVar = (d) super.b(lVar, wVar, baVar, aVar, z);
        if (dVar == null) {
            atM(25);
        }
        AppMethodBeat.o(57027);
        return dVar;
    }

    public final f a(List<av> list, ba baVar, List<as> list2) {
        ak akVar;
        AppMethodBeat.i(57017);
        if (list == null) {
            atM(10);
        }
        if (baVar == null) {
            atM(11);
        }
        if (list2 == null) {
            atM(12);
        }
        e hBY = hBY();
        if (hBY.hzG()) {
            l hzx = hBY.hzx();
            if (hzx instanceof e) {
                akVar = ((e) hzx).hAO();
                super.a(null, akVar, list2, list, null, w.FINAL, baVar);
                AppMethodBeat.o(57017);
                return this;
            }
        }
        akVar = null;
        super.a(null, akVar, list2, list, null, w.FINAL, baVar);
        AppMethodBeat.o(57017);
        return this;
    }
}
