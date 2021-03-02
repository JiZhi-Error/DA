package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;

public class ae extends p implements am {
    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57293);
        switch (i2) {
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        switch (i2) {
            case 13:
            case 17:
                objArr[1] = "initialize";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 23:
                objArr[1] = "copy";
                break;
            case 24:
                objArr[1] = "newCopyBuilder";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57293);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public /* synthetic */ b a(l lVar, w wVar, ba baVar, b.a aVar) {
        AppMethodBeat.i(57288);
        am c2 = c(lVar, wVar, baVar, aVar, false);
        AppMethodBeat.o(57288);
        return c2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ p a(ak akVar, ak akVar2, List list, List list2, ab abVar, w wVar, ba baVar) {
        AppMethodBeat.i(57287);
        ae b2 = b(akVar, akVar2, list, list2, abVar, wVar, baVar);
        AppMethodBeat.o(57287);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public /* synthetic */ t b(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57285);
        am c2 = c(lVar, wVar, baVar, aVar, z);
        AppMethodBeat.o(57285);
        return c2;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57291);
        am hCu = hCu();
        AppMethodBeat.o(57291);
        return hCu;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t hAT() {
        AppMethodBeat.i(57286);
        am hCu = hCu();
        AppMethodBeat.o(57286);
        return hCu;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ a hAv() {
        AppMethodBeat.i(57290);
        am hCu = hCu();
        AppMethodBeat.o(57290);
        return hCu;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ b hAz() {
        AppMethodBeat.i(57289);
        am hCu = hCu();
        AppMethodBeat.o(57289);
        return hCu;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57292);
        am hCu = hCu();
        AppMethodBeat.o(57292);
        return hCu;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ae(l lVar, am amVar, g gVar, f fVar, b.a aVar, an anVar) {
        super(lVar, amVar, gVar, fVar, aVar, anVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(1);
        }
        if (fVar == null) {
            atM(2);
        }
        if (aVar == null) {
            atM(3);
        }
        if (anVar == null) {
            atM(4);
        }
        AppMethodBeat.i(57277);
        AppMethodBeat.o(57277);
    }

    public static ae a(l lVar, g gVar, f fVar, b.a aVar, an anVar) {
        AppMethodBeat.i(57278);
        if (lVar == null) {
            atM(5);
        }
        if (gVar == null) {
            atM(6);
        }
        if (fVar == null) {
            atM(7);
        }
        if (aVar == null) {
            atM(8);
        }
        if (anVar == null) {
            atM(9);
        }
        ae aeVar = new ae(lVar, null, gVar, fVar, aVar, anVar);
        AppMethodBeat.o(57278);
        return aeVar;
    }

    public final ae b(ak akVar, ak akVar2, List<? extends as> list, List<av> list2, ab abVar, w wVar, ba baVar) {
        AppMethodBeat.i(57279);
        if (list == null) {
            atM(10);
        }
        if (list2 == null) {
            atM(11);
        }
        if (baVar == null) {
            atM(12);
        }
        ae a2 = a(akVar, akVar2, list, list2, abVar, wVar, baVar, null);
        if (a2 == null) {
            atM(13);
        }
        AppMethodBeat.o(57279);
        return a2;
    }

    public ae a(ak akVar, ak akVar2, List<? extends as> list, List<av> list2, ab abVar, w wVar, ba baVar, Map<? extends a.AbstractC2276a<?>, ?> map) {
        AppMethodBeat.i(57280);
        if (list == null) {
            atM(14);
        }
        if (list2 == null) {
            atM(15);
        }
        if (baVar == null) {
            atM(16);
        }
        super.a(akVar, akVar2, list, list2, abVar, wVar, baVar);
        if (map != null && !map.isEmpty()) {
            this.Tlc = new LinkedHashMap(map);
        }
        if (this == null) {
            atM(17);
        }
        AppMethodBeat.o(57280);
        return this;
    }

    public final am hCu() {
        AppMethodBeat.i(57281);
        am amVar = (am) super.hBT();
        if (amVar == null) {
            atM(18);
        }
        AppMethodBeat.o(57281);
        return amVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.b.c.p
    public p a(l lVar, t tVar, b.a aVar, f fVar, g gVar, an anVar) {
        AppMethodBeat.i(57282);
        if (lVar == null) {
            atM(19);
        }
        if (aVar == null) {
            atM(20);
        }
        if (gVar == null) {
            atM(21);
        }
        if (anVar == null) {
            atM(22);
        }
        ae aeVar = new ae(lVar, (am) tVar, gVar, fVar != null ? fVar : hAH(), aVar, anVar);
        AppMethodBeat.o(57282);
        return aeVar;
    }

    public am c(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57283);
        am amVar = (am) super.b(lVar, wVar, baVar, aVar, z);
        if (amVar == null) {
            atM(23);
        }
        AppMethodBeat.o(57283);
        return amVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.l.b.a.b.b.t$a<? extends kotlin.l.b.a.b.b.t>, kotlin.l.b.a.b.b.t$a<? extends kotlin.l.b.a.b.b.am> */
    @Override // kotlin.l.b.a.b.b.am, kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public t.a<? extends am> hBa() {
        AppMethodBeat.i(57284);
        t.a hBa = super.hBa();
        if (hBa == null) {
            atM(24);
        }
        AppMethodBeat.o(57284);
        return hBa;
    }
}
