package kotlin.l.b.a.b.d.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.c.f;
import kotlin.l.b.a.b.b.c.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;

public class c extends f implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!c.class.desiredAssertionStatus());
    private Boolean Tqx;
    private Boolean Tqy;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57707);
        switch (i2) {
            case 11:
            case 18:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 11:
            case 18:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        switch (i2) {
            case 11:
                objArr[1] = "createSubstitutedCopy";
                break;
            case 18:
                objArr[1] = "enhance";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 11:
            case 18:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57707);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57706);
        AppMethodBeat.o(57706);
    }

    @Override // kotlin.l.b.a.b.b.c.f, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ p a(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57704);
        c c2 = c(lVar, tVar, aVar, fVar, gVar, anVar);
        AppMethodBeat.o(57704);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.b.b
    public final /* synthetic */ b a(ab abVar, List list, ab abVar2, o oVar) {
        ak a2;
        AppMethodBeat.i(57705);
        if (abVar2 == null) {
            atM(17);
        }
        c c2 = c(hBY(), null, hAA(), null, hzL(), hzM());
        if (abVar == null) {
            a2 = null;
        } else {
            g.a aVar = g.TiC;
            a2 = kotlin.l.b.a.b.j.b.a(c2, abVar, g.a.hBP());
        }
        c2.a(a2, this.TkK, hAt(), k.a(list, hAw(), c2), abVar2, hzC(), hzE());
        if (oVar != null) {
            c2.a((a.AbstractC2276a) oVar.first, (Object) oVar.second);
        }
        AppMethodBeat.o(57705);
        return c2;
    }

    @Override // kotlin.l.b.a.b.b.c.f
    public final /* synthetic */ f b(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57703);
        c c2 = c(lVar, tVar, aVar, fVar, gVar, anVar);
        AppMethodBeat.o(57703);
        return c2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private c(e eVar, c cVar, g gVar, boolean z, b.a aVar, an anVar) {
        super(eVar, cVar, gVar, z, aVar, anVar);
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
        AppMethodBeat.i(57696);
        this.Tqx = null;
        this.Tqy = null;
        AppMethodBeat.o(57696);
    }

    public static c a(e eVar, g gVar, boolean z, an anVar) {
        AppMethodBeat.i(57697);
        if (eVar == null) {
            atM(4);
        }
        if (gVar == null) {
            atM(5);
        }
        if (anVar == null) {
            atM(6);
        }
        c cVar = new c(eVar, null, gVar, z, b.a.DECLARATION, anVar);
        AppMethodBeat.o(57697);
        return cVar;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final boolean hCc() {
        AppMethodBeat.i(57698);
        if ($assertionsDisabled || this.Tqx != null) {
            boolean booleanValue = this.Tqx.booleanValue();
            AppMethodBeat.o(57698);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasStableParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(57698);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final void EC(boolean z) {
        AppMethodBeat.i(57699);
        this.Tqx = Boolean.valueOf(z);
        AppMethodBeat.o(57699);
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final boolean hAx() {
        AppMethodBeat.i(57700);
        if ($assertionsDisabled || this.Tqy != null) {
            boolean booleanValue = this.Tqy.booleanValue();
            AppMethodBeat.o(57700);
            return booleanValue;
        }
        AssertionError assertionError = new AssertionError("hasSynthesizedParameterNames was not set: ".concat(String.valueOf(this)));
        AppMethodBeat.o(57700);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final void ED(boolean z) {
        AppMethodBeat.i(57701);
        this.Tqy = Boolean.valueOf(z);
        AppMethodBeat.o(57701);
    }

    private c c(l lVar, t tVar, b.a aVar, kotlin.l.b.a.b.f.f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57702);
        if (lVar == null) {
            atM(7);
        }
        if (aVar == null) {
            atM(8);
        }
        if (gVar == null) {
            atM(9);
        }
        if (anVar == null) {
            atM(10);
        }
        if (aVar != b.a.DECLARATION && aVar != b.a.SYNTHESIZED) {
            IllegalStateException illegalStateException = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
            AppMethodBeat.o(57702);
            throw illegalStateException;
        } else if ($assertionsDisabled || fVar == null) {
            e eVar = (e) lVar;
            c cVar = (c) tVar;
            if (eVar == null) {
                atM(12);
            }
            if (aVar == null) {
                atM(13);
            }
            if (anVar == null) {
                atM(14);
            }
            if (gVar == null) {
                atM(15);
            }
            c cVar2 = new c(eVar, cVar, gVar, this.lNt, aVar, anVar);
            cVar2.EC(hCc());
            cVar2.ED(hAx());
            AppMethodBeat.o(57702);
            return cVar2;
        } else {
            AssertionError assertionError = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(57702);
            throw assertionError;
        }
    }
}
