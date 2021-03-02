package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.f;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.f.b;

public final class x extends n implements f, w {
    private final TypeVariable<?> Tnv;

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ a l(b bVar) {
        AppMethodBeat.i(57512);
        p.h(bVar, "fqName");
        c a2 = f.a.a(this, bVar);
        AppMethodBeat.o(57512);
        return a2;
    }

    public x(TypeVariable<?> typeVariable) {
        p.h(typeVariable, "typeVariable");
        AppMethodBeat.i(57510);
        this.Tnv = typeVariable;
        AppMethodBeat.o(57510);
    }

    @Override // kotlin.l.b.a.b.b.d.b.f
    public final AnnotatedElement hCG() {
        TypeVariable<?> typeVariable = this.Tnv;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable = null;
        }
        return (AnnotatedElement) typeVariable;
    }

    @Override // kotlin.l.b.a.b.d.a.e.s
    public final kotlin.l.b.a.b.f.f hAH() {
        AppMethodBeat.i(57506);
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(this.Tnv.getName());
        p.g(btY, "Name.identifier(typeVariable.name)");
        AppMethodBeat.o(57506);
        return btY;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57507);
        if (!(obj instanceof x) || !p.j(this.Tnv, ((x) obj).Tnv)) {
            AppMethodBeat.o(57507);
            return false;
        }
        AppMethodBeat.o(57507);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(57508);
        int hashCode = this.Tnv.hashCode();
        AppMethodBeat.o(57508);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57509);
        String str = getClass().getName() + ": " + this.Tnv;
        AppMethodBeat.o(57509);
        return str;
    }

    @Override // kotlin.l.b.a.b.d.a.e.w
    public final /* synthetic */ Collection hDi() {
        Type type;
        AppMethodBeat.i(57505);
        Type[] bounds = this.Tnv.getBounds();
        p.g(bounds, "typeVariable.bounds");
        List arrayList = new ArrayList(bounds.length);
        for (Type type2 : bounds) {
            arrayList.add(new l(type2));
        }
        List list = arrayList;
        l lVar = (l) j.kx(list);
        if (lVar != null) {
            type = lVar.Tnf;
        } else {
            type = null;
        }
        if (p.j(type, Object.class)) {
            list = v.SXr;
        }
        List list2 = list;
        AppMethodBeat.o(57505);
        return list2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ Collection hCP() {
        AppMethodBeat.i(57511);
        List<c> a2 = f.a.a(this);
        AppMethodBeat.o(57511);
        return a2;
    }
}
