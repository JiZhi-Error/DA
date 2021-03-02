package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.d;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.y;

public final class s extends r implements q {
    public final Method Tns;

    public s(Method method) {
        p.h(method, "member");
        AppMethodBeat.i(57490);
        this.Tns = method;
        AppMethodBeat.o(57490);
    }

    @Override // kotlin.l.b.a.b.d.a.e.q
    public final List<y> hAw() {
        AppMethodBeat.i(57486);
        Type[] genericParameterTypes = this.Tns.getGenericParameterTypes();
        p.g(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = this.Tns.getParameterAnnotations();
        p.g(parameterAnnotations, "member.parameterAnnotations");
        List<y> a2 = a(genericParameterTypes, parameterAnnotations, this.Tns.isVarArgs());
        AppMethodBeat.o(57486);
        return a2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.q
    public final /* synthetic */ v hDd() {
        AppMethodBeat.i(57487);
        w.a aVar = w.Tnu;
        Type genericReturnType = this.Tns.getGenericReturnType();
        p.g(genericReturnType, "member.genericReturnType");
        w b2 = w.a.b(genericReturnType);
        AppMethodBeat.o(57487);
        return b2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.q
    public final b hDe() {
        d dVar = null;
        AppMethodBeat.i(57488);
        Object defaultValue = this.Tns.getDefaultValue();
        if (defaultValue != null) {
            d.a aVar = d.Tnd;
            dVar = d.a.a(defaultValue, null);
        }
        d dVar2 = dVar;
        AppMethodBeat.o(57488);
        return dVar2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.x
    public final List<x> hAt() {
        AppMethodBeat.i(57489);
        TypeVariable<Method>[] typeParameters = this.Tns.getTypeParameters();
        p.g(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57489);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.b.d.b.r
    public final /* bridge */ /* synthetic */ Member hyV() {
        return this.Tns;
    }

    @Override // kotlin.l.b.a.b.d.a.e.q
    public final boolean hDf() {
        AppMethodBeat.i(57491);
        if (hDe() != null) {
            AppMethodBeat.o(57491);
            return true;
        }
        AppMethodBeat.o(57491);
        return false;
    }
}
