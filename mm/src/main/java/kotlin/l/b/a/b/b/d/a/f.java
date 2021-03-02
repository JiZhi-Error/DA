package kotlin.l.b.a.b.b.d.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.l.b.a.b.d.b.a.a;
import kotlin.l.b.a.b.d.b.a.b;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.n.n;

public final class f implements p {
    public static final a TmL = new a((byte) 0);
    public final Class<?> TmJ;
    public final kotlin.l.b.a.b.d.b.a.a TmK;

    static {
        AppMethodBeat.i(57372);
        AppMethodBeat.o(57372);
    }

    private f(Class<?> cls, kotlin.l.b.a.b.d.b.a.a aVar) {
        this.TmJ = cls;
        this.TmK = aVar;
    }

    public /* synthetic */ f(Class cls, kotlin.l.b.a.b.d.b.a.a aVar, byte b2) {
        this(cls, aVar);
    }

    @Override // kotlin.l.b.a.b.d.b.p
    public final kotlin.l.b.a.b.d.b.a.a hCA() {
        return this.TmK;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f bw(Class<?> cls) {
            kotlin.l.b.a.b.d.b.a.a aVar;
            c cVar;
            boolean z = true;
            AppMethodBeat.i(57364);
            kotlin.g.b.p.h(cls, "klass");
            b bVar = new b();
            c cVar2 = c.TmH;
            c.a(cls, bVar);
            if (bVar.TwE == null || bVar.TwD == null) {
                aVar = null;
            } else {
                kotlin.l.b.a.b.e.c.a.f fVar = new kotlin.l.b.a.b.e.c.a.f(bVar.TwD, (bVar.Twr & 8) != 0);
                if (!fVar.hIi()) {
                    bVar.Twp = bVar.Two;
                    bVar.Two = null;
                } else {
                    if (!(bVar.TwE == a.EnumC2293a.CLASS || bVar.TwE == a.EnumC2293a.FILE_FACADE || bVar.TwE == a.EnumC2293a.MULTIFILE_CLASS_PART)) {
                        z = false;
                    }
                    if (z && bVar.Two == null) {
                        aVar = null;
                    }
                }
                a.EnumC2293a aVar2 = bVar.TwE;
                if (bVar.Twn != null) {
                    cVar = bVar.Twn;
                } else {
                    cVar = c.TCz;
                }
                aVar = new kotlin.l.b.a.b.d.b.a.a(aVar2, fVar, cVar, bVar.Two, bVar.Twp, bVar.strings, bVar.Twq, bVar.Twr, bVar.packageName);
            }
            if (aVar == null) {
                AppMethodBeat.o(57364);
                return null;
            }
            f fVar2 = new f(cls, aVar, (byte) 0);
            AppMethodBeat.o(57364);
            return fVar2;
        }
    }

    @Override // kotlin.l.b.a.b.d.b.p
    public final String getLocation() {
        AppMethodBeat.i(57365);
        StringBuilder sb = new StringBuilder();
        String name = this.TmJ.getName();
        kotlin.g.b.p.g(name, "klass.name");
        String sb2 = sb.append(n.a(name, '.', '/')).append(".class").toString();
        AppMethodBeat.o(57365);
        return sb2;
    }

    @Override // kotlin.l.b.a.b.d.b.p
    public final kotlin.l.b.a.b.f.a hyy() {
        AppMethodBeat.i(185981);
        kotlin.l.b.a.b.f.a bB = kotlin.l.b.a.b.b.d.b.b.bB(this.TmJ);
        AppMethodBeat.o(185981);
        return bB;
    }

    @Override // kotlin.l.b.a.b.d.b.p
    public final void a(p.c cVar) {
        AppMethodBeat.i(57367);
        kotlin.g.b.p.h(cVar, "visitor");
        c cVar2 = c.TmH;
        c.a(this.TmJ, cVar);
        AppMethodBeat.o(57367);
    }

    @Override // kotlin.l.b.a.b.d.b.p
    public final void a(p.d dVar) {
        AppMethodBeat.i(57368);
        kotlin.g.b.p.h(dVar, "visitor");
        c cVar = c.TmH;
        Class<?> cls = this.TmJ;
        kotlin.g.b.p.h(cls, "klass");
        kotlin.g.b.p.h(dVar, "memberVisitor");
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            kotlin.g.b.p.g(method, FirebaseAnalytics.b.METHOD);
            kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(method.getName());
            kotlin.g.b.p.g(btY, "Name.identifier(method.name)");
            l lVar = l.TmT;
            p.e a2 = dVar.a(btY, l.d(method));
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                kotlin.g.b.p.g(annotation, "annotation");
                c.a(a2, annotation);
            }
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            kotlin.g.b.p.g(parameterAnnotations, "method.parameterAnnotations");
            int length = parameterAnnotations.length;
            for (int i2 = 0; i2 < length; i2++) {
                Annotation[] annotationArr = parameterAnnotations[i2];
                for (Annotation annotation2 : annotationArr) {
                    Class<?> a3 = kotlin.g.a.a(kotlin.g.a.a(annotation2));
                    kotlin.l.b.a.b.f.a bB = kotlin.l.b.a.b.b.d.b.b.bB(a3);
                    kotlin.g.b.p.g(annotation2, "annotation");
                    p.a a4 = a2.a(i2, bB, new b(annotation2));
                    if (a4 != null) {
                        c.TmH.a(a4, annotation2, a3);
                    }
                }
            }
            a2.Td();
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            kotlin.l.b.a.b.f.f bua = kotlin.l.b.a.b.f.f.bua("<init>");
            kotlin.g.b.p.g(bua, "Name.special(\"<init>\")");
            l lVar2 = l.TmT;
            kotlin.g.b.p.g(constructor, "constructor");
            p.e a5 = dVar.a(bua, l.a(constructor));
            Annotation[] declaredAnnotations2 = constructor.getDeclaredAnnotations();
            for (Annotation annotation3 : declaredAnnotations2) {
                kotlin.g.b.p.g(annotation3, "annotation");
                c.a(a5, annotation3);
            }
            Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
            kotlin.g.b.p.g(parameterAnnotations2, "parameterAnnotations");
            if (!(parameterAnnotations2.length == 0)) {
                int length2 = constructor.getParameterTypes().length - parameterAnnotations2.length;
                int length3 = parameterAnnotations2.length;
                for (int i3 = 0; i3 < length3; i3++) {
                    Annotation[] annotationArr2 = parameterAnnotations2[i3];
                    for (Annotation annotation4 : annotationArr2) {
                        Class<?> a6 = kotlin.g.a.a(kotlin.g.a.a(annotation4));
                        kotlin.l.b.a.b.f.a bB2 = kotlin.l.b.a.b.b.d.b.b.bB(a6);
                        kotlin.g.b.p.g(annotation4, "annotation");
                        p.a a7 = a5.a(i3 + length2, bB2, new b(annotation4));
                        if (a7 != null) {
                            c.TmH.a(a7, annotation4, a6);
                        }
                    }
                }
            }
            a5.Td();
        }
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            kotlin.g.b.p.g(field, "field");
            kotlin.l.b.a.b.f.f btY2 = kotlin.l.b.a.b.f.f.btY(field.getName());
            kotlin.g.b.p.g(btY2, "Name.identifier(field.name)");
            l lVar3 = l.TmT;
            p.c b2 = dVar.b(btY2, l.f(field));
            Annotation[] declaredAnnotations3 = field.getDeclaredAnnotations();
            for (Annotation annotation5 : declaredAnnotations3) {
                kotlin.g.b.p.g(annotation5, "annotation");
                c.a(b2, annotation5);
            }
            b2.Td();
        }
        AppMethodBeat.o(57368);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57369);
        if (!(obj instanceof f) || !kotlin.g.b.p.j(this.TmJ, ((f) obj).TmJ)) {
            AppMethodBeat.o(57369);
            return false;
        }
        AppMethodBeat.o(57369);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(57370);
        int hashCode = this.TmJ.hashCode();
        AppMethodBeat.o(57370);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57371);
        String str = getClass().getName() + ": " + this.TmJ;
        AppMethodBeat.o(57371);
        return str;
    }
}
