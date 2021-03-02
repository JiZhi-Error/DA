package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.aj;
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
import kotlin.l.b.a.b.m.ab;

public class ac extends z implements aj {
    static final /* synthetic */ boolean $assertionsDisabled = (!ac.class.desiredAssertionStatus());
    private av Tmi;
    private final aj Tmj;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57272);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57272);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(57271);
        AppMethodBeat.o(57271);
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57269);
        aj hCt = hCt();
        AppMethodBeat.o(57269);
        return hCt;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ t hAT() {
        AppMethodBeat.i(57266);
        aj hCt = hCt();
        AppMethodBeat.o(57266);
        return hCt;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ a hAv() {
        AppMethodBeat.i(57268);
        aj hCt = hCt();
        AppMethodBeat.o(57268);
        return hCt;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ b hAz() {
        AppMethodBeat.i(57267);
        aj hCt = hCt();
        AppMethodBeat.o(57267);
        return hCt;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57270);
        aj hCt = hCt();
        AppMethodBeat.o(57270);
        return hCt;
    }

    @Override // kotlin.l.b.a.b.b.c.z
    public final /* synthetic */ ag hCo() {
        AppMethodBeat.i(57265);
        aj hCt = hCt();
        AppMethodBeat.o(57265);
        return hCt;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ac(ah ahVar, g gVar, w wVar, ba baVar, boolean z, boolean z2, boolean z3, b.a aVar, aj ajVar, an anVar) {
        super(wVar, baVar, ahVar, gVar, f.bua("<set-" + ahVar.hAH() + ">"), z, z2, z3, aVar, anVar);
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
        AppMethodBeat.i(57257);
        this.Tmj = ajVar == null ? this : ajVar;
        AppMethodBeat.o(57257);
    }

    public final void a(av avVar) {
        AppMethodBeat.i(57258);
        if (avVar == null) {
            atM(6);
        }
        if ($assertionsDisabled || this.Tmi == null) {
            this.Tmi = avVar;
            AppMethodBeat.o(57258);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(57258);
        throw assertionError;
    }

    public static aj a(aj ajVar, ab abVar, g gVar) {
        AppMethodBeat.i(57259);
        if (ajVar == null) {
            atM(7);
        }
        if (abVar == null) {
            atM(8);
        }
        if (gVar == null) {
            atM(9);
        }
        aj ajVar2 = new aj(ajVar, null, 0, gVar, f.bua("<set-?>"), abVar, false, false, false, null, an.ThK);
        AppMethodBeat.o(57259);
        return ajVar2;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.t
    public final Collection<? extends aj> hAy() {
        AppMethodBeat.i(57260);
        Collection<ag> EE = super.EE(false);
        AppMethodBeat.o(57260);
        return EE;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final List<av> hAw() {
        AppMethodBeat.i(57261);
        if (this.Tmi == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(57261);
            throw illegalStateException;
        }
        List<av> singletonList = Collections.singletonList(this.Tmi);
        if (singletonList == null) {
            atM(11);
        }
        AppMethodBeat.o(57261);
        return singletonList;
    }

    @Override // kotlin.l.b.a.b.b.a
    public final ab hAu() {
        AppMethodBeat.i(57262);
        kotlin.l.b.a.b.m.aj hzq = kotlin.l.b.a.b.j.d.a.G(this).hzq();
        if (hzq == null) {
            atM(12);
        }
        AppMethodBeat.o(57262);
        return hzq;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57263);
        R a2 = nVar.a((aj) this, (Object) d2);
        AppMethodBeat.o(57263);
        return a2;
    }

    private aj hCt() {
        AppMethodBeat.i(57264);
        aj ajVar = this.Tmj;
        if (ajVar == null) {
            atM(13);
        }
        AppMethodBeat.o(57264);
        return ajVar;
    }
}
