package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.k;
import kotlin.l.b.a.b.d.a.e.y;

public final class m extends r implements k {
    public final Constructor<?> Tnp;

    public m(Constructor<?> constructor) {
        p.h(constructor, "member");
        AppMethodBeat.i(57478);
        this.Tnp = constructor;
        AppMethodBeat.o(57478);
    }

    @Override // kotlin.l.b.a.b.d.a.e.k
    public final List<y> hAw() {
        boolean z;
        Type[] typeArr;
        Annotation[][] annotationArr;
        AppMethodBeat.i(57476);
        Type[] genericParameterTypes = this.Tnp.getGenericParameterTypes();
        p.g(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            v vVar = v.SXr;
            AppMethodBeat.o(57476);
            return vVar;
        }
        Class<?> declaringClass = this.Tnp.getDeclaringClass();
        p.g(declaringClass, "klass");
        if (declaringClass.getDeclaringClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
            typeArr = genericParameterTypes;
        } else {
            typeArr = (Type[]) e.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = this.Tnp.getParameterAnnotations();
        if (parameterAnnotations.length < typeArr.length) {
            IllegalStateException illegalStateException = new IllegalStateException("Illegal generic signature: " + this.Tnp);
            AppMethodBeat.o(57476);
            throw illegalStateException;
        }
        if (parameterAnnotations.length > typeArr.length) {
            p.g(parameterAnnotations, "annotations");
            annotationArr = (Annotation[][]) e.copyOfRange(parameterAnnotations, parameterAnnotations.length - typeArr.length, parameterAnnotations.length);
        } else {
            annotationArr = parameterAnnotations;
        }
        p.g(typeArr, "realTypes");
        p.g(annotationArr, "realAnnotations");
        List<y> a2 = a(typeArr, annotationArr, this.Tnp.isVarArgs());
        AppMethodBeat.o(57476);
        return a2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.x
    public final List<x> hAt() {
        AppMethodBeat.i(57477);
        TypeVariable<Constructor<?>>[] typeParameters = this.Tnp.getTypeParameters();
        p.g(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57477);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.b.d.b.r
    public final /* bridge */ /* synthetic */ Member hyV() {
        return this.Tnp;
    }
}
