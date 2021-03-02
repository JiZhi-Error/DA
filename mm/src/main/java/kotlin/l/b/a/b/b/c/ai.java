package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.bh;

public final class ai extends e {
    private final b<ab, Void> Tmr;
    private final List<ab> Tms;
    private boolean initialized;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57328);
        switch (i2) {
            case 5:
            case 28:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 28:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "createWithDefaultBound";
                break;
            case 28:
                objArr[1] = "resolveUpperBounds";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 28:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57328);
        throw illegalStateException;
    }

    public static as a(l lVar, g gVar, bh bhVar, f fVar, int i2, j jVar) {
        AppMethodBeat.i(186246);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (bhVar == null) {
            atM(2);
        }
        if (fVar == null) {
            atM(3);
        }
        if (jVar == null) {
            atM(4);
        }
        ai a2 = a(lVar, gVar, false, bhVar, fVar, i2, an.ThK, jVar);
        a2.K(a.G(lVar).hzk());
        a2.setInitialized();
        if (a2 == null) {
            atM(5);
        }
        AppMethodBeat.o(186246);
        return a2;
    }

    public static ai a(l lVar, g gVar, boolean z, bh bhVar, f fVar, int i2, an anVar, j jVar) {
        AppMethodBeat.i(186247);
        if (lVar == null) {
            atM(6);
        }
        if (gVar == null) {
            atM(7);
        }
        if (bhVar == null) {
            atM(8);
        }
        if (fVar == null) {
            atM(9);
        }
        if (anVar == null) {
            atM(10);
        }
        if (jVar == null) {
            atM(11);
        }
        ai a2 = a(lVar, gVar, z, bhVar, fVar, i2, anVar, aq.a.ThM, jVar);
        AppMethodBeat.o(186247);
        return a2;
    }

    private static ai a(l lVar, g gVar, boolean z, bh bhVar, f fVar, int i2, an anVar, aq aqVar, j jVar) {
        AppMethodBeat.i(186248);
        if (lVar == null) {
            atM(12);
        }
        if (gVar == null) {
            atM(13);
        }
        if (bhVar == null) {
            atM(14);
        }
        if (fVar == null) {
            atM(15);
        }
        if (anVar == null) {
            atM(16);
        }
        if (aqVar == null) {
            atM(17);
        }
        if (jVar == null) {
            atM(18);
        }
        ai aiVar = new ai(lVar, gVar, z, bhVar, fVar, i2, anVar, aqVar, jVar);
        AppMethodBeat.o(186248);
        return aiVar;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ai(l lVar, g gVar, boolean z, bh bhVar, f fVar, int i2, an anVar, aq aqVar, j jVar) {
        super(jVar, lVar, gVar, fVar, bhVar, z, i2, anVar, aqVar);
        if (lVar == null) {
            atM(19);
        }
        if (gVar == null) {
            atM(20);
        }
        if (bhVar == null) {
            atM(21);
        }
        if (fVar == null) {
            atM(22);
        }
        if (anVar == null) {
            atM(23);
        }
        if (aqVar == null) {
            atM(24);
        }
        if (jVar == null) {
            atM(25);
        }
        AppMethodBeat.i(186249);
        this.Tms = new ArrayList(1);
        this.initialized = false;
        this.Tmr = null;
        AppMethodBeat.o(186249);
    }

    private void hCx() {
        AppMethodBeat.i(57321);
        if (this.initialized) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is already initialized: " + hCy());
            AppMethodBeat.o(57321);
            throw illegalStateException;
        }
        AppMethodBeat.o(57321);
    }

    private String hCy() {
        AppMethodBeat.i(57322);
        String str = hAH() + " declared in " + c.n(hzx());
        AppMethodBeat.o(57322);
        return str;
    }

    public final void setInitialized() {
        AppMethodBeat.i(57323);
        hCx();
        this.initialized = true;
        AppMethodBeat.o(57323);
    }

    public final void K(ab abVar) {
        AppMethodBeat.i(57324);
        if (abVar == null) {
            atM(26);
        }
        hCx();
        L(abVar);
        AppMethodBeat.o(57324);
    }

    private void L(ab abVar) {
        AppMethodBeat.i(57325);
        if (ad.ap(abVar)) {
            AppMethodBeat.o(57325);
            return;
        }
        this.Tms.add(abVar);
        AppMethodBeat.o(57325);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.b.c.e
    public final void H(ab abVar) {
        AppMethodBeat.i(57326);
        if (abVar == null) {
            atM(27);
        }
        if (this.Tmr == null) {
            AppMethodBeat.o(57326);
            return;
        }
        this.Tmr.invoke(abVar);
        AppMethodBeat.o(57326);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.b.c.e
    public final List<ab> hBW() {
        AppMethodBeat.i(57327);
        if (!this.initialized) {
            IllegalStateException illegalStateException = new IllegalStateException("Type parameter descriptor is not initialized: " + hCy());
            AppMethodBeat.o(57327);
            throw illegalStateException;
        }
        List<ab> list = this.Tms;
        if (list == null) {
            atM(28);
        }
        AppMethodBeat.o(57327);
        return list;
    }
}
