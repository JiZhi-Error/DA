package kotlin.l.b.a.b.b.d.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d.b.f;
import kotlin.l.b.a.b.b.d.b.t;
import kotlin.l.b.a.b.b.d.b.w;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.p;
import kotlin.l.b.a.b.d.a.e.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.h;

public abstract class r extends n implements f, t, p {
    public abstract Member hyV();

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hCQ() {
        return t.a.a(this);
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hCR() {
        return t.a.c(this);
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hgu() {
        return t.a.b(this);
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final ba hzE() {
        return t.a.d(this);
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ a l(b bVar) {
        kotlin.g.b.p.h(bVar, "fqName");
        return f.a.a(this, bVar);
    }

    @Override // kotlin.l.b.a.b.b.d.b.f
    public final AnnotatedElement hCG() {
        Member hyV = hyV();
        if (hyV != null) {
            return (AnnotatedElement) hyV;
        }
        throw new kotlin.t("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }

    @Override // kotlin.l.b.a.b.b.d.b.t
    public final int getModifiers() {
        return hyV().getModifiers();
    }

    @Override // kotlin.l.b.a.b.d.a.e.s
    public final kotlin.l.b.a.b.f.f hAH() {
        String name = hyV().getName();
        if (name != null) {
            return kotlin.l.b.a.b.f.f.btY(name);
        }
        kotlin.l.b.a.b.f.f fVar = h.TDd;
        kotlin.g.b.p.g(fVar, "SpecialNames.NO_NAME_PROVIDED");
        return fVar;
    }

    /* access modifiers changed from: protected */
    public final List<y> a(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        String str;
        kotlin.g.b.p.h(typeArr, "parameterTypes");
        kotlin.g.b.p.h(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        a aVar = a.TmV;
        List<String> b2 = a.b(hyV());
        int size = b2 != null ? b2.size() - typeArr.length : 0;
        int length = typeArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            w.a aVar2 = w.Tnu;
            w b3 = w.a.b(typeArr[i2]);
            if (b2 != null) {
                String str2 = (String) j.L(b2, i2 + size);
                if (str2 == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + size + " (name=" + hAH() + " type=" + b3 + ") in " + b2 + "@ReflectJavaMember").toString());
                }
                str = str2;
            } else {
                str = null;
            }
            arrayList.add(new y(b3, annotationArr[i2], str, z && i2 == e.V(typeArr)));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && kotlin.g.b.p.j(hyV(), ((r) obj).hyV());
    }

    public int hashCode() {
        return hyV().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + hyV();
    }

    @Override // kotlin.l.b.a.b.d.a.e.p
    public final /* synthetic */ g hDc() {
        Class<?> declaringClass = hyV().getDeclaringClass();
        kotlin.g.b.p.g(declaringClass, "member.declaringClass");
        return new j(declaringClass);
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ Collection hCP() {
        return f.a.a(this);
    }
}
