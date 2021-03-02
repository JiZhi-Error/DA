package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;

public final class ab extends z implements ai {
    private kotlin.l.b.a.b.m.ab Tmg;
    private final ai Tmh;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57256);
        switch (i2) {
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 7:
            case 8:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57256);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57254);
        ai hCs = hCs();
        AppMethodBeat.o(57254);
        return hCs;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ t hAT() {
        AppMethodBeat.i(57251);
        ai hCs = hCs();
        AppMethodBeat.o(57251);
        return hCs;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ a hAv() {
        AppMethodBeat.i(57253);
        ai hCs = hCs();
        AppMethodBeat.o(57253);
        return hCs;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ b hAz() {
        AppMethodBeat.i(57252);
        ai hCs = hCs();
        AppMethodBeat.o(57252);
        return hCs;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57255);
        ai hCs = hCs();
        AppMethodBeat.o(57255);
        return hCs;
    }

    @Override // kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ ag hCo() {
        AppMethodBeat.i(57250);
        ai hCs = hCs();
        AppMethodBeat.o(57250);
        return hCs;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(ah ahVar, g gVar, w wVar, ba baVar, boolean z, boolean z2, boolean z3, b.a aVar, ai aiVar, an anVar) {
        super(wVar, baVar, ahVar, gVar, f.bua("<get-" + ahVar.hAH() + ">"), z, z2, z3, aVar, anVar);
        if (ahVar == null) {
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
        if (aVar == null) {
            atM(4);
        }
        if (anVar == null) {
            atM(5);
        }
        AppMethodBeat.i(57244);
        this.Tmh = aiVar == null ? this : aiVar;
        AppMethodBeat.o(57244);
    }

    public final void J(kotlin.l.b.a.b.m.ab abVar) {
        AppMethodBeat.i(57245);
        if (abVar == null) {
            abVar = hBm().hBy();
        }
        this.Tmg = abVar;
        AppMethodBeat.o(57245);
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.t
    public final Collection<? extends ai> hAy() {
        AppMethodBeat.i(57246);
        Collection<ag> EE = super.EE(true);
        AppMethodBeat.o(57246);
        return EE;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<av> hAw() {
        AppMethodBeat.i(57247);
        List<av> emptyList = Collections.emptyList();
        if (emptyList == null) {
            atM(7);
        }
        AppMethodBeat.o(57247);
        return emptyList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final kotlin.l.b.a.b.m.ab hAu() {
        return this.Tmg;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57248);
        R a2 = nVar.a((ai) this, (Object) d2);
        AppMethodBeat.o(57248);
        return a2;
    }

    private ai hCs() {
        AppMethodBeat.i(57249);
        ai aiVar = this.Tmh;
        if (aiVar == null) {
            atM(8);
        }
        AppMethodBeat.o(57249);
        return aiVar;
    }
}
