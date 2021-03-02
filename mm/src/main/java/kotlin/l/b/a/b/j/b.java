package kotlin.l.b.a.b.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ab;
import kotlin.l.b.a.b.b.c.ac;
import kotlin.l.b.a.b.b.c.ad;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.c.aj;
import kotlin.l.b.a.b.b.c.f;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.m.bh;

public final class b {
    public static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59895);
        switch (i2) {
            case 12:
            case 23:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 12:
            case 23:
            case 25:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        switch (i2) {
            case 12:
                objArr[1] = "createSetter";
                break;
            case 23:
                objArr[1] = "createEnumValuesMethod";
                break;
            case 25:
                objArr[1] = "createEnumValueOfMethod";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 12:
            case 23:
            case 25:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59895);
        throw illegalStateException;
    }

    public static class a extends f {
        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(59884);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "source";
                    break;
                default:
                    objArr[0] = "containingClass";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(59884);
            throw illegalArgumentException;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, an anVar) {
            super(eVar, null, g.a.hBP(), true, b.a.DECLARATION, anVar);
            if (eVar == null) {
                atM(0);
            }
            if (anVar == null) {
                atM(1);
            }
            g.a aVar = g.TiC;
            AppMethodBeat.i(59883);
            a(Collections.emptyList(), c.z(eVar));
            AppMethodBeat.o(59883);
        }
    }

    public static ac a(ah ahVar, g gVar, g gVar2) {
        AppMethodBeat.i(59885);
        if (ahVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (gVar2 == null) {
            atM(2);
        }
        ac a2 = a(ahVar, gVar, gVar2, ahVar.hzM());
        AppMethodBeat.o(59885);
        return a2;
    }

    private static ac a(ah ahVar, g gVar, g gVar2, an anVar) {
        AppMethodBeat.i(59886);
        if (ahVar == null) {
            atM(3);
        }
        if (gVar == null) {
            atM(4);
        }
        if (gVar2 == null) {
            atM(5);
        }
        if (anVar == null) {
            atM(6);
        }
        ac a2 = a(ahVar, gVar, gVar2, true, ahVar.hzE(), anVar);
        AppMethodBeat.o(59886);
        return a2;
    }

    public static ac a(ah ahVar, g gVar, g gVar2, boolean z, ba baVar, an anVar) {
        AppMethodBeat.i(59887);
        if (ahVar == null) {
            atM(7);
        }
        if (gVar == null) {
            atM(8);
        }
        if (gVar2 == null) {
            atM(9);
        }
        if (baVar == null) {
            atM(10);
        }
        if (anVar == null) {
            atM(11);
        }
        ac acVar = new ac(ahVar, gVar, ahVar.hzC(), baVar, z, false, false, b.a.DECLARATION, null, anVar);
        acVar.a(ac.a(acVar, ahVar.hBy(), gVar2));
        AppMethodBeat.o(59887);
        return acVar;
    }

    public static ab a(ah ahVar, g gVar) {
        AppMethodBeat.i(59888);
        if (ahVar == null) {
            atM(13);
        }
        if (gVar == null) {
            atM(14);
        }
        ab b2 = b(ahVar, gVar);
        AppMethodBeat.o(59888);
        return b2;
    }

    private static ab b(ah ahVar, g gVar) {
        AppMethodBeat.i(59889);
        if (ahVar == null) {
            atM(15);
        }
        if (gVar == null) {
            atM(16);
        }
        ab a2 = a(ahVar, gVar, true, ahVar.hzM());
        AppMethodBeat.o(59889);
        return a2;
    }

    public static ab a(ah ahVar, g gVar, boolean z, an anVar) {
        AppMethodBeat.i(59890);
        if (ahVar == null) {
            atM(17);
        }
        if (gVar == null) {
            atM(18);
        }
        if (anVar == null) {
            atM(19);
        }
        ab abVar = new ab(ahVar, gVar, ahVar.hzC(), ahVar.hzE(), z, false, false, b.a.DECLARATION, null, anVar);
        AppMethodBeat.o(59890);
        return abVar;
    }

    public static am w(e eVar) {
        AppMethodBeat.i(59891);
        if (eVar == null) {
            atM(22);
        }
        g.a aVar = g.TiC;
        ae b2 = ae.a(eVar, g.a.hBP(), c.THt, b.a.SYNTHESIZED, eVar.hzM()).b(null, null, Collections.emptyList(), Collections.emptyList(), kotlin.l.b.a.b.j.d.a.G(eVar).a(bh.INVARIANT, eVar.hAG()), w.FINAL, az.ThU);
        if (b2 == null) {
            atM(23);
        }
        AppMethodBeat.o(59891);
        return b2;
    }

    public static am x(e eVar) {
        AppMethodBeat.i(59892);
        if (eVar == null) {
            atM(24);
        }
        g.a aVar = g.TiC;
        ae a2 = ae.a(eVar, g.a.hBP(), c.THu, b.a.SYNTHESIZED, eVar.hzM());
        g.a aVar2 = g.TiC;
        ae b2 = a2.b(null, null, Collections.emptyList(), Collections.singletonList(new aj(a2, null, 0, g.a.hBP(), kotlin.l.b.a.b.f.f.btY("value"), kotlin.l.b.a.b.j.d.a.G(eVar).hzr(), false, false, false, null, eVar.hzM())), eVar.hAG(), w.FINAL, az.ThU);
        if (b2 == null) {
            atM(25);
        }
        AppMethodBeat.o(59892);
        return b2;
    }

    public static boolean g(t tVar) {
        AppMethodBeat.i(59893);
        if (tVar == null) {
            atM(28);
        }
        if (tVar.hAA() != b.a.SYNTHESIZED || !c.y(tVar.hzx())) {
            AppMethodBeat.o(59893);
            return false;
        }
        AppMethodBeat.o(59893);
        return true;
    }

    public static ak a(kotlin.l.b.a.b.b.a aVar, kotlin.l.b.a.b.m.ab abVar, g gVar) {
        AppMethodBeat.i(59894);
        if (aVar == null) {
            atM(29);
        }
        if (gVar == null) {
            atM(30);
        }
        if (abVar == null) {
            AppMethodBeat.o(59894);
            return null;
        }
        ad adVar = new ad(aVar, new kotlin.l.b.a.b.j.f.a.b(aVar, abVar, null), gVar);
        AppMethodBeat.o(59894);
        return adVar;
    }
}
