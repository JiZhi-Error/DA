package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.i;
import kotlin.l.b.a.b.d.a.e.j;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.f.b;
import kotlin.t;

public final class l extends w implements j {
    final Type Tnf;
    private final i Tno;

    public l(Type type) {
        j jVar;
        p.h(type, "reflectType");
        AppMethodBeat.i(57475);
        this.Tnf = type;
        Type type2 = this.Tnf;
        if (type2 instanceof Class) {
            jVar = new j((Class) type2);
        } else if (type2 instanceof TypeVariable) {
            jVar = new x((TypeVariable) type2);
        } else if (type2 instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type2).getRawType();
            if (rawType == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.Class<*>");
                AppMethodBeat.o(57475);
                throw tVar;
            }
            jVar = new j((Class) rawType);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Not a classifier type (" + type2.getClass() + "): " + type2);
            AppMethodBeat.o(57475);
            throw illegalStateException;
        }
        this.Tno = jVar;
        AppMethodBeat.o(57475);
    }

    @Override // kotlin.l.b.a.b.b.d.b.w
    public final Type hCJ() {
        return this.Tnf;
    }

    @Override // kotlin.l.b.a.b.d.a.e.j
    public final i hCT() {
        return this.Tno;
    }

    @Override // kotlin.l.b.a.b.d.a.e.j
    public final String hCU() {
        AppMethodBeat.i(57470);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Type not found: " + this.Tnf);
        AppMethodBeat.o(57470);
        throw unsupportedOperationException;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final a l(b bVar) {
        AppMethodBeat.i(57474);
        p.h(bVar, "fqName");
        AppMethodBeat.o(57474);
        return null;
    }

    @Override // kotlin.l.b.a.b.d.a.e.j
    public final String hCV() {
        AppMethodBeat.i(57471);
        String obj = this.Tnf.toString();
        AppMethodBeat.o(57471);
        return obj;
    }

    @Override // kotlin.l.b.a.b.d.a.e.j
    public final boolean hCW() {
        AppMethodBeat.i(57472);
        Type type = this.Tnf;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            p.g(typeParameters, "getTypeParameters()");
            if (!(typeParameters.length == 0)) {
                AppMethodBeat.o(57472);
                return true;
            }
        }
        AppMethodBeat.o(57472);
        return false;
    }

    @Override // kotlin.l.b.a.b.d.a.e.j
    public final List<v> hCX() {
        AppMethodBeat.i(57473);
        List<Type> a2 = b.a(this.Tnf);
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(a2, 10));
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            arrayList.add(w.a.b(it.next()));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57473);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final Collection<a> hCP() {
        return kotlin.a.v.SXr;
    }
}
