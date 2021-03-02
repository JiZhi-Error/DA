package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.f;
import kotlin.l.b.a.b.d.a.e.v;

public final class i extends w implements f {
    private final w Tne;
    private final Type Tnf;

    public i(Type type) {
        w b2;
        p.h(type, "reflectType");
        AppMethodBeat.i(57424);
        this.Tnf = type;
        Type type2 = this.Tnf;
        if (type2 instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
            p.g(genericComponentType, "genericComponentType");
            b2 = w.a.b(genericComponentType);
        } else if (!(type2 instanceof Class) || !((Class) type2).isArray()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Not an array type (" + this.Tnf.getClass() + "): " + this.Tnf);
            AppMethodBeat.o(57424);
            throw illegalArgumentException;
        } else {
            Class<?> componentType = ((Class) type2).getComponentType();
            p.g(componentType, "getComponentType()");
            b2 = w.a.b(componentType);
        }
        this.Tne = b2;
        AppMethodBeat.o(57424);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.b.d.b.w
    public final Type hCJ() {
        return this.Tnf;
    }

    @Override // kotlin.l.b.a.b.d.a.e.f
    public final /* bridge */ /* synthetic */ v hCI() {
        return this.Tne;
    }
}
