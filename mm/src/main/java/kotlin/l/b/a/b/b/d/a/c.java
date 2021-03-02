package kotlin.l.b.a.b.b.d.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.a.e;
import kotlin.g.a;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.d.b.b;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.d;
import kotlin.t;

/* access modifiers changed from: package-private */
public final class c {
    public static final c TmH = new c();

    static {
        AppMethodBeat.i(57358);
        AppMethodBeat.o(57358);
    }

    private c() {
    }

    public static void a(Class<?> cls, p.c cVar) {
        AppMethodBeat.i(57353);
        kotlin.g.b.p.h(cls, "klass");
        kotlin.g.b.p.h(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            kotlin.g.b.p.g(annotation, "annotation");
            a(cVar, annotation);
        }
        cVar.Td();
        AppMethodBeat.o(57353);
    }

    static void a(p.c cVar, Annotation annotation) {
        AppMethodBeat.i(57354);
        Class<?> a2 = a.a(a.a(annotation));
        p.a a3 = cVar.a(b.bB(a2), new b(annotation));
        if (a3 != null) {
            TmH.a(a3, annotation, a2);
            AppMethodBeat.o(57354);
            return;
        }
        AppMethodBeat.o(57354);
    }

    /* access modifiers changed from: package-private */
    public final void a(p.a aVar, Annotation annotation, Class<?> cls) {
        AppMethodBeat.i(57355);
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                if (invoke == null) {
                    kotlin.g.b.p.hyc();
                }
                kotlin.g.b.p.g(method, FirebaseAnalytics.b.METHOD);
                f btY = f.btY(method.getName());
                kotlin.g.b.p.g(btY, "Name.identifier(method.name)");
                a(aVar, btY, invoke);
            } catch (IllegalAccessException e2) {
            }
        }
        aVar.Td();
        AppMethodBeat.o(57355);
    }

    private static kotlin.l.b.a.b.j.b.f bv(Class<?> cls) {
        kotlin.l.b.a.b.f.b bVar;
        kotlin.l.b.a.b.f.b bVar2;
        AppMethodBeat.i(57356);
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
            kotlin.g.b.p.g(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            kotlin.l.b.a.b.f.a bB = b.bB(cls);
            kotlin.l.b.a.b.a.b.c cVar = kotlin.l.b.a.b.a.b.c.TfZ;
            kotlin.l.b.a.b.f.b hJd = bB.hJd();
            kotlin.g.b.p.g(hJd, "javaClassId.asSingleFqName()");
            kotlin.l.b.a.b.f.a c2 = kotlin.l.b.a.b.a.b.c.c(hJd);
            if (c2 != null) {
                bB = c2;
            }
            kotlin.l.b.a.b.j.b.f fVar = new kotlin.l.b.a.b.j.b.f(bB, i2);
            AppMethodBeat.o(57356);
            return fVar;
        } else if (kotlin.g.b.p.j(cls, Void.TYPE)) {
            kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(g.TcO.TcW.hJj());
            kotlin.g.b.p.g(p, "ClassId.topLevel(KotlinB…s.FQ_NAMES.unit.toSafe())");
            kotlin.l.b.a.b.j.b.f fVar2 = new kotlin.l.b.a.b.j.b.f(p, i2);
            AppMethodBeat.o(57356);
            return fVar2;
        } else {
            d buk = d.buk(cls.getName());
            kotlin.g.b.p.g(buk, "JvmPrimitiveType.get(currentClass.name)");
            h hKJ = buk.hKJ();
            kotlin.g.b.p.g(hKJ, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
            if (i2 > 0) {
                if (hKJ.TeG != null) {
                    bVar2 = hKJ.TeG;
                    if (bVar2 == null) {
                        h.atM(4);
                    }
                } else {
                    hKJ.TeG = g.TcD.p(hKJ.TeE);
                    bVar2 = hKJ.TeG;
                    if (bVar2 == null) {
                        h.atM(5);
                    }
                }
                kotlin.l.b.a.b.f.a p2 = kotlin.l.b.a.b.f.a.p(bVar2);
                kotlin.g.b.p.g(p2, "ClassId.topLevel(primitiveType.arrayTypeFqName)");
                kotlin.l.b.a.b.j.b.f fVar3 = new kotlin.l.b.a.b.j.b.f(p2, i2 - 1);
                AppMethodBeat.o(57356);
                return fVar3;
            }
            if (hKJ.TeF != null) {
                bVar = hKJ.TeF;
                if (bVar == null) {
                    h.atM(1);
                }
            } else {
                hKJ.TeF = g.TcD.p(hKJ.TeD);
                bVar = hKJ.TeF;
                if (bVar == null) {
                    h.atM(2);
                }
            }
            kotlin.l.b.a.b.f.a p3 = kotlin.l.b.a.b.f.a.p(bVar);
            kotlin.g.b.p.g(p3, "ClassId.topLevel(primitiveType.typeFqName)");
            kotlin.l.b.a.b.j.b.f fVar4 = new kotlin.l.b.a.b.j.b.f(p3, i2);
            AppMethodBeat.o(57356);
            return fVar4;
        }
    }

    private final void a(p.a aVar, f fVar, Object obj) {
        AppMethodBeat.i(57357);
        Class<?> cls = obj.getClass();
        if (kotlin.g.b.p.j(cls, Class.class)) {
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.Class<*>");
                AppMethodBeat.o(57357);
                throw tVar;
            }
            aVar.a(fVar, bv((Class) obj));
            AppMethodBeat.o(57357);
        } else if (h.TmM.contains(cls)) {
            aVar.a(fVar, obj);
            AppMethodBeat.o(57357);
        } else if (b.by(cls)) {
            Class<?> enclosingClass = cls.isEnum() ? cls : cls.getEnclosingClass();
            kotlin.g.b.p.g(enclosingClass, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
            kotlin.l.b.a.b.f.a bB = b.bB(enclosingClass);
            if (obj == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Enum<*>");
                AppMethodBeat.o(57357);
                throw tVar2;
            }
            f btY = f.btY(((Enum) obj).name());
            kotlin.g.b.p.g(btY, "Name.identifier((value as Enum<*>).name)");
            aVar.a(fVar, bB, btY);
            AppMethodBeat.o(57357);
        } else if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            kotlin.g.b.p.g(interfaces, "clazz.interfaces");
            Class<?> cls2 = (Class) e.T(interfaces);
            kotlin.g.b.p.g(cls2, "annotationClass");
            p.a a2 = aVar.a(fVar, b.bB(cls2));
            if (a2 == null) {
                AppMethodBeat.o(57357);
            } else if (obj == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Annotation");
                AppMethodBeat.o(57357);
                throw tVar3;
            } else {
                a(a2, (Annotation) obj, cls2);
                AppMethodBeat.o(57357);
            }
        } else if (cls.isArray()) {
            p.b n = aVar.n(fVar);
            if (n == null) {
                AppMethodBeat.o(57357);
                return;
            }
            Class<?> componentType = cls.getComponentType();
            kotlin.g.b.p.g(componentType, "componentType");
            if (componentType.isEnum()) {
                kotlin.l.b.a.b.f.a bB2 = b.bB(componentType);
                if (obj == null) {
                    t tVar4 = new t("null cannot be cast to non-null type kotlin.Array<*>");
                    AppMethodBeat.o(57357);
                    throw tVar4;
                }
                Object[] objArr = (Object[]) obj;
                for (Object obj2 : objArr) {
                    if (obj2 == null) {
                        t tVar5 = new t("null cannot be cast to non-null type kotlin.Enum<*>");
                        AppMethodBeat.o(57357);
                        throw tVar5;
                    }
                    f btY2 = f.btY(((Enum) obj2).name());
                    kotlin.g.b.p.g(btY2, "Name.identifier((element as Enum<*>).name)");
                    n.a(bB2, btY2);
                }
            } else if (kotlin.g.b.p.j(componentType, Class.class)) {
                if (obj == null) {
                    t tVar6 = new t("null cannot be cast to non-null type kotlin.Array<*>");
                    AppMethodBeat.o(57357);
                    throw tVar6;
                }
                Object[] objArr2 = (Object[]) obj;
                for (Object obj3 : objArr2) {
                    if (obj3 == null) {
                        t tVar7 = new t("null cannot be cast to non-null type java.lang.Class<*>");
                        AppMethodBeat.o(57357);
                        throw tVar7;
                    }
                    n.a(bv((Class) obj3));
                }
            } else if (obj == null) {
                t tVar8 = new t("null cannot be cast to non-null type kotlin.Array<*>");
                AppMethodBeat.o(57357);
                throw tVar8;
            } else {
                for (Object obj4 : (Object[]) obj) {
                    n.fr(obj4);
                }
            }
            n.Td();
            AppMethodBeat.o(57357);
        } else {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            AppMethodBeat.o(57357);
            throw unsupportedOperationException;
        }
    }
}
