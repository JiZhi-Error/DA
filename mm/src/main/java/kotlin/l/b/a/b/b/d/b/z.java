package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.v;

public final class z extends w implements kotlin.l.b.a.b.d.a.e.z {
    private final WildcardType TnA;

    public z(WildcardType wildcardType) {
        p.h(wildcardType, "reflectType");
        AppMethodBeat.i(57520);
        this.TnA = wildcardType;
        AppMethodBeat.o(57520);
    }

    @Override // kotlin.l.b.a.b.d.a.e.z
    public final /* synthetic */ v hDk() {
        w wVar;
        AppMethodBeat.i(57518);
        Type[] upperBounds = this.TnA.getUpperBounds();
        Type[] lowerBounds = this.TnA.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + this.TnA);
            AppMethodBeat.o(57518);
            throw unsupportedOperationException;
        }
        if (lowerBounds.length == 1) {
            p.g(lowerBounds, "lowerBounds");
            Object T = e.T(lowerBounds);
            p.g(T, "lowerBounds.single()");
            wVar = w.a.b((Type) T);
        } else if (upperBounds.length == 1) {
            p.g(upperBounds, "upperBounds");
            Type type = (Type) e.T(upperBounds);
            if (!p.j(type, Object.class)) {
                p.g(type, "ub");
                wVar = w.a.b(type);
            } else {
                wVar = null;
            }
        } else {
            wVar = null;
        }
        w wVar2 = wVar;
        AppMethodBeat.o(57518);
        return wVar2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.z
    public final boolean hDl() {
        AppMethodBeat.i(57519);
        Type[] upperBounds = this.TnA.getUpperBounds();
        p.g(upperBounds, "reflectType.upperBounds");
        boolean z = !p.j((Type) e.R(upperBounds), Object.class);
        AppMethodBeat.o(57519);
        return z;
    }

    @Override // kotlin.l.b.a.b.b.d.b.w
    public final /* bridge */ /* synthetic */ Type hCJ() {
        return this.TnA;
    }
}
