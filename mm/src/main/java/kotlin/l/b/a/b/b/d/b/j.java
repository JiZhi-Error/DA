package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.ad;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d.b.f;
import kotlin.l.b.a.b.b.d.b.t;
import kotlin.m.i;

public final class j extends n implements f, t, kotlin.l.b.a.b.d.a.e.g {
    public final Class<?> TmJ;

    static final /* synthetic */ class a extends n implements kotlin.g.a.b<Member, Boolean> {
        public static final a Tng = new a();

        static {
            AppMethodBeat.i(57427);
            AppMethodBeat.o(57427);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57426);
            kotlin.l.b bp = aa.bp(Member.class);
            AppMethodBeat.o(57426);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Member member) {
            AppMethodBeat.i(57425);
            Member member2 = member;
            p.h(member2, "p1");
            Boolean valueOf = Boolean.valueOf(member2.isSynthetic());
            AppMethodBeat.o(57425);
            return valueOf;
        }
    }

    static final /* synthetic */ class b extends n implements kotlin.g.a.b<Constructor<?>, m> {
        public static final b Tnh = new b();

        static {
            AppMethodBeat.i(57430);
            AppMethodBeat.o(57430);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57429);
            kotlin.l.b bp = aa.bp(m.class);
            AppMethodBeat.o(57429);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ m invoke(Constructor<?> constructor) {
            AppMethodBeat.i(57428);
            Constructor<?> constructor2 = constructor;
            p.h(constructor2, "p1");
            m mVar = new m(constructor2);
            AppMethodBeat.o(57428);
            return mVar;
        }
    }

    static final /* synthetic */ class c extends n implements kotlin.g.a.b<Member, Boolean> {
        public static final c Tni = new c();

        static {
            AppMethodBeat.i(57433);
            AppMethodBeat.o(57433);
        }

        c() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57432);
            kotlin.l.b bp = aa.bp(Member.class);
            AppMethodBeat.o(57432);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "isSynthetic";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Member member) {
            AppMethodBeat.i(57431);
            Member member2 = member;
            p.h(member2, "p1");
            Boolean valueOf = Boolean.valueOf(member2.isSynthetic());
            AppMethodBeat.o(57431);
            return valueOf;
        }
    }

    static final /* synthetic */ class d extends n implements kotlin.g.a.b<Field, p> {
        public static final d Tnj = new d();

        static {
            AppMethodBeat.i(57436);
            AppMethodBeat.o(57436);
        }

        d() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57435);
            kotlin.l.b bp = aa.bp(p.class);
            AppMethodBeat.o(57435);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ p invoke(Field field) {
            AppMethodBeat.i(57434);
            Field field2 = field;
            p.h(field2, "p1");
            p pVar = new p(field2);
            AppMethodBeat.o(57434);
            return pVar;
        }
    }

    static final class e extends q implements kotlin.g.a.b<Class<?>, Boolean> {
        public static final e Tnk = new e();

        static {
            AppMethodBeat.i(57438);
            AppMethodBeat.o(57438);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Class<?> cls) {
            boolean z;
            AppMethodBeat.i(57437);
            Class<?> cls2 = cls;
            p.g(cls2, LocaleUtil.ITALIAN);
            String simpleName = cls2.getSimpleName();
            p.g(simpleName, "it.simpleName");
            if (simpleName.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(57437);
            return valueOf;
        }
    }

    static final class f extends q implements kotlin.g.a.b<Class<?>, kotlin.l.b.a.b.f.f> {
        public static final f Tnl = new f();

        static {
            AppMethodBeat.i(57440);
            AppMethodBeat.o(57440);
        }

        f() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.l.b.a.b.f.f invoke(Class<?> cls) {
            AppMethodBeat.i(57439);
            Class<?> cls2 = cls;
            p.g(cls2, LocaleUtil.ITALIAN);
            String simpleName = cls2.getSimpleName();
            if (!kotlin.l.b.a.b.f.f.btZ(simpleName)) {
                simpleName = null;
            }
            if (simpleName != null) {
                kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(simpleName);
                AppMethodBeat.o(57439);
                return btY;
            }
            AppMethodBeat.o(57439);
            return null;
        }
    }

    static final class g extends q implements kotlin.g.a.b<Method, Boolean> {
        final /* synthetic */ j Tnm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(j jVar) {
            super(1);
            this.Tnm = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
            if (r2 != false) goto L_0x0016;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(java.lang.reflect.Method r7) {
            /*
            // Method dump skipped, instructions count: 120
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.b.d.b.j.g.invoke(java.lang.Object):java.lang.Object");
        }
    }

    static final /* synthetic */ class h extends n implements kotlin.g.a.b<Method, s> {
        public static final h Tnn = new h();

        static {
            AppMethodBeat.i(57444);
            AppMethodBeat.o(57444);
        }

        h() {
            super(1);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(57443);
            kotlin.l.b bp = aa.bp(s.class);
            AppMethodBeat.o(57443);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ s invoke(Method method) {
            AppMethodBeat.i(57442);
            Method method2 = method;
            p.h(method2, "p1");
            s sVar = new s(method2);
            AppMethodBeat.o(57442);
            return sVar;
        }
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hCQ() {
        AppMethodBeat.i(57464);
        boolean a2 = t.a.a(this);
        AppMethodBeat.o(57464);
        return a2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hCR() {
        AppMethodBeat.i(57466);
        boolean c2 = t.a.c(this);
        AppMethodBeat.o(57466);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final boolean hgu() {
        AppMethodBeat.i(57465);
        boolean b2 = t.a.b(this);
        AppMethodBeat.o(57465);
        return b2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.r
    public final ba hzE() {
        AppMethodBeat.i(57467);
        ba d2 = t.a.d(this);
        AppMethodBeat.o(57467);
        return d2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ kotlin.l.b.a.b.d.a.e.a l(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(57463);
        p.h(bVar, "fqName");
        c a2 = f.a.a(this, bVar);
        AppMethodBeat.o(57463);
        return a2;
    }

    public j(Class<?> cls) {
        p.h(cls, "klass");
        AppMethodBeat.i(57461);
        this.TmJ = cls;
        AppMethodBeat.o(57461);
    }

    @Override // kotlin.l.b.a.b.b.d.b.t
    public final int getModifiers() {
        AppMethodBeat.i(57445);
        int modifiers = this.TmJ.getModifiers();
        AppMethodBeat.o(57445);
        return modifiers;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final kotlin.l.b.a.b.f.b hBk() {
        AppMethodBeat.i(57447);
        kotlin.l.b.a.b.f.b hJd = b.bB(this.TmJ).hJd();
        p.g(hJd, "klass.classId.asSingleFqName()");
        AppMethodBeat.o(57447);
        return hJd;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final Collection<kotlin.l.b.a.b.d.a.e.j> hBV() {
        AppMethodBeat.i(57449);
        if (p.j(this.TmJ, Object.class)) {
            v vVar = v.SXr;
            AppMethodBeat.o(57449);
            return vVar;
        }
        ad adVar = new ad(2);
        Class genericSuperclass = this.TmJ.getGenericSuperclass();
        if (genericSuperclass == null) {
        }
        adVar.add(genericSuperclass);
        Type[] genericInterfaces = this.TmJ.getGenericInterfaces();
        p.g(genericInterfaces, "klass.genericInterfaces");
        adVar.eS(genericInterfaces);
        List<Type> listOf = kotlin.a.j.listOf((Object[]) ((Type[]) adVar.toArray(new Type[adVar.dtS.size()])));
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(listOf, 10));
        for (Type type : listOf) {
            arrayList.add(new l(type));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57449);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.s
    public final kotlin.l.b.a.b.f.f hAH() {
        AppMethodBeat.i(57453);
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(this.TmJ.getSimpleName());
        p.g(btY, "Name.identifier(klass.simpleName)");
        AppMethodBeat.o(57453);
        return btY;
    }

    @Override // kotlin.l.b.a.b.d.a.e.x
    public final List<x> hAt() {
        AppMethodBeat.i(57454);
        TypeVariable<Class<?>>[] typeParameters = this.TmJ.getTypeParameters();
        p.g(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(57454);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final boolean isInterface() {
        AppMethodBeat.i(57455);
        boolean isInterface = this.TmJ.isInterface();
        AppMethodBeat.o(57455);
        return isInterface;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final boolean hCO() {
        AppMethodBeat.i(258554);
        boolean isAnnotation = this.TmJ.isAnnotation();
        AppMethodBeat.o(258554);
        return isAnnotation;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final boolean isEnum() {
        AppMethodBeat.i(57457);
        boolean isEnum = this.TmJ.isEnum();
        AppMethodBeat.o(57457);
        return isEnum;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57458);
        if (!(obj instanceof j) || !p.j(this.TmJ, ((j) obj).TmJ)) {
            AppMethodBeat.o(57458);
            return false;
        }
        AppMethodBeat.o(57458);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(57459);
        int hashCode = this.TmJ.hashCode();
        AppMethodBeat.o(57459);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(57460);
        String str = getClass().getName() + ": " + this.TmJ;
        AppMethodBeat.o(57460);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.d.b.f
    public final /* bridge */ /* synthetic */ AnnotatedElement hCG() {
        return this.TmJ;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final /* synthetic */ Collection hCK() {
        AppMethodBeat.i(57446);
        Class<?>[] declaredClasses = this.TmJ.getDeclaredClasses();
        p.g(declaredClasses, "klass.declaredClasses");
        List c2 = i.c(i.e(i.b(kotlin.a.e.aa(declaredClasses), (kotlin.g.a.b) e.Tnk), f.Tnl));
        AppMethodBeat.o(57446);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final /* synthetic */ kotlin.l.b.a.b.d.a.e.g hCL() {
        j jVar;
        AppMethodBeat.i(57448);
        Class<?> declaringClass = this.TmJ.getDeclaringClass();
        if (declaringClass != null) {
            jVar = new j(declaringClass);
        } else {
            jVar = null;
        }
        j jVar2 = jVar;
        AppMethodBeat.o(57448);
        return jVar2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final /* synthetic */ Collection hCM() {
        AppMethodBeat.i(57450);
        Method[] declaredMethods = this.TmJ.getDeclaredMethods();
        p.g(declaredMethods, "klass.declaredMethods");
        List c2 = i.c(i.d(i.a(kotlin.a.e.aa(declaredMethods), new g(this)), h.Tnn));
        AppMethodBeat.o(57450);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final /* synthetic */ Collection hCN() {
        AppMethodBeat.i(57451);
        Field[] declaredFields = this.TmJ.getDeclaredFields();
        p.g(declaredFields, "klass.declaredFields");
        List c2 = i.c(i.d(i.b(kotlin.a.e.aa(declaredFields), (kotlin.g.a.b) c.Tni), d.Tnj));
        AppMethodBeat.o(57451);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.g
    public final /* synthetic */ Collection hxW() {
        AppMethodBeat.i(57452);
        Constructor<?>[] declaredConstructors = this.TmJ.getDeclaredConstructors();
        p.g(declaredConstructors, "klass.declaredConstructors");
        List c2 = i.c(i.d(i.b(kotlin.a.e.aa(declaredConstructors), (kotlin.g.a.b) a.Tng), b.Tnh));
        AppMethodBeat.o(57452);
        return c2;
    }

    @Override // kotlin.l.b.a.b.d.a.e.d
    public final /* synthetic */ Collection hCP() {
        AppMethodBeat.i(57462);
        List<c> a2 = f.a.a(this);
        AppMethodBeat.o(57462);
        return a2;
    }
}
