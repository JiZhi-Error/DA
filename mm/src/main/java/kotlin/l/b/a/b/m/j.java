package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.j.c;

public final class j extends b implements at {
    private final e ThF;
    private final Collection<ab> TlT;
    private final List<as> parameters;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60620);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getParameters";
                break;
            case 5:
                objArr[1] = "getDeclarationDescriptor";
                break;
            case 6:
                objArr[1] = "computeSupertypes";
                break;
            case 7:
                objArr[1] = "getSupertypeLoopChecker";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60620);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.m.at, kotlin.l.b.a.b.m.b
    public final /* synthetic */ h hzS() {
        AppMethodBeat.i(60619);
        e hzT = hzT();
        AppMethodBeat.o(60619);
        return hzT;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(e eVar, List<? extends as> list, Collection<ab> collection, kotlin.l.b.a.b.l.j jVar) {
        super(jVar);
        if (list == null) {
            atM(1);
        }
        if (collection == null) {
            atM(2);
        }
        if (jVar == null) {
            atM(3);
        }
        AppMethodBeat.i(60613);
        this.ThF = eVar;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.TlT = Collections.unmodifiableCollection(collection);
        AppMethodBeat.o(60613);
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        AppMethodBeat.i(60614);
        List<as> list = this.parameters;
        if (list == null) {
            atM(4);
        }
        AppMethodBeat.o(60614);
        return list;
    }

    public final String toString() {
        AppMethodBeat.i(60615);
        String sG = c.n(this.ThF).sG();
        AppMethodBeat.o(60615);
        return sG;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return true;
    }

    @Override // kotlin.l.b.a.b.m.b
    public final e hzT() {
        AppMethodBeat.i(60616);
        e eVar = this.ThF;
        if (eVar == null) {
            atM(5);
        }
        AppMethodBeat.o(60616);
        return eVar;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.h
    public final Collection<ab> hzR() {
        AppMethodBeat.i(60617);
        Collection<ab> collection = this.TlT;
        if (collection == null) {
            atM(6);
        }
        AppMethodBeat.o(60617);
        return collection;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.h
    public final aq hzV() {
        AppMethodBeat.i(60618);
        aq.a aVar = aq.a.ThM;
        if (aVar == null) {
            atM(7);
        }
        AppMethodBeat.o(60618);
        return aVar;
    }
}
