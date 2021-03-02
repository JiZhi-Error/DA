package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.m.bh;
import kotlin.m;

public final class aa {
    public static final aa TLC = new aa();

    static {
        AppMethodBeat.i(60356);
        AppMethodBeat.o(60356);
    }

    private aa() {
    }

    public static b.a a(a.i iVar) {
        AppMethodBeat.i(60350);
        if (iVar != null) {
            switch (ab.$EnumSwitchMapping$0[iVar.ordinal()]) {
                case 1:
                    b.a aVar = b.a.DECLARATION;
                    AppMethodBeat.o(60350);
                    return aVar;
                case 2:
                    b.a aVar2 = b.a.FAKE_OVERRIDE;
                    AppMethodBeat.o(60350);
                    return aVar2;
                case 3:
                    b.a aVar3 = b.a.DELEGATION;
                    AppMethodBeat.o(60350);
                    return aVar3;
                case 4:
                    b.a aVar4 = b.a.SYNTHESIZED;
                    AppMethodBeat.o(60350);
                    return aVar4;
            }
        }
        b.a aVar5 = b.a.DECLARATION;
        AppMethodBeat.o(60350);
        return aVar5;
    }

    public static w a(a.j jVar) {
        AppMethodBeat.i(60351);
        if (jVar != null) {
            switch (ab.uqL[jVar.ordinal()]) {
                case 1:
                    w wVar = w.FINAL;
                    AppMethodBeat.o(60351);
                    return wVar;
                case 2:
                    w wVar2 = w.OPEN;
                    AppMethodBeat.o(60351);
                    return wVar2;
                case 3:
                    w wVar3 = w.ABSTRACT;
                    AppMethodBeat.o(60351);
                    return wVar3;
                case 4:
                    w wVar4 = w.SEALED;
                    AppMethodBeat.o(60351);
                    return wVar4;
            }
        }
        w wVar5 = w.FINAL;
        AppMethodBeat.o(60351);
        return wVar5;
    }

    public static ba a(a.w wVar) {
        ba baVar;
        AppMethodBeat.i(60352);
        if (wVar != null) {
            switch (ab.vkf[wVar.ordinal()]) {
                case 1:
                    baVar = az.ThT;
                    break;
                case 2:
                    baVar = az.ThQ;
                    break;
                case 3:
                    baVar = az.ThR;
                    break;
                case 4:
                    baVar = az.ThS;
                    break;
                case 5:
                    baVar = az.ThU;
                    break;
                case 6:
                    baVar = az.ThV;
                    break;
            }
            p.g(baVar, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
            AppMethodBeat.o(60352);
            return baVar;
        }
        baVar = az.ThQ;
        p.g(baVar, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
        AppMethodBeat.o(60352);
        return baVar;
    }

    public static f a(a.b.EnumC2306b bVar) {
        AppMethodBeat.i(60353);
        if (bVar != null) {
            switch (ab.vlj[bVar.ordinal()]) {
                case 1:
                    f fVar = f.CLASS;
                    AppMethodBeat.o(60353);
                    return fVar;
                case 2:
                    f fVar2 = f.INTERFACE;
                    AppMethodBeat.o(60353);
                    return fVar2;
                case 3:
                    f fVar3 = f.ENUM_CLASS;
                    AppMethodBeat.o(60353);
                    return fVar3;
                case 4:
                    f fVar4 = f.ENUM_ENTRY;
                    AppMethodBeat.o(60353);
                    return fVar4;
                case 5:
                    f fVar5 = f.ANNOTATION_CLASS;
                    AppMethodBeat.o(60353);
                    return fVar5;
                case 6:
                case 7:
                    f fVar6 = f.OBJECT;
                    AppMethodBeat.o(60353);
                    return fVar6;
            }
        }
        f fVar7 = f.CLASS;
        AppMethodBeat.o(60353);
        return fVar7;
    }

    public static bh b(a.r.b bVar) {
        AppMethodBeat.i(60354);
        p.h(bVar, "variance");
        switch (ab.vll[bVar.ordinal()]) {
            case 1:
                bh bhVar = bh.IN_VARIANCE;
                AppMethodBeat.o(60354);
                return bhVar;
            case 2:
                bh bhVar2 = bh.OUT_VARIANCE;
                AppMethodBeat.o(60354);
                return bhVar2;
            case 3:
                bh bhVar3 = bh.INVARIANT;
                AppMethodBeat.o(60354);
                return bhVar3;
            default:
                m mVar = new m();
                AppMethodBeat.o(60354);
                throw mVar;
        }
    }

    public static bh b(a.p.C2320a.b bVar) {
        AppMethodBeat.i(60355);
        p.h(bVar, "projection");
        switch (ab.TLD[bVar.ordinal()]) {
            case 1:
                bh bhVar = bh.IN_VARIANCE;
                AppMethodBeat.o(60355);
                return bhVar;
            case 2:
                bh bhVar2 = bh.OUT_VARIANCE;
                AppMethodBeat.o(60355);
                return bhVar2;
            case 3:
                bh bhVar3 = bh.INVARIANT;
                AppMethodBeat.o(60355);
                return bhVar3;
            case 4:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Only IN, OUT and INV are supported. Actual argument: ".concat(String.valueOf(bVar)));
                AppMethodBeat.o(60355);
                throw illegalArgumentException;
            default:
                m mVar = new m();
                AppMethodBeat.o(60355);
                throw mVar;
        }
    }
}
