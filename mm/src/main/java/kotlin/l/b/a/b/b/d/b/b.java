package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.c;
import kotlin.g.a.d;
import kotlin.g.a.e;
import kotlin.g.a.f;
import kotlin.g.a.g;
import kotlin.g.a.h;
import kotlin.g.a.i;
import kotlin.g.a.k;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.n;
import kotlin.g.a.o;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.s;

public final class b {
    private static final Map<Class<? extends c<?>>, Integer> SYq;
    private static final List<kotlin.l.b<? extends Object>> TmY;
    private static final Map<Class<? extends Object>, Class<? extends Object>> TmZ;
    private static final Map<Class<? extends Object>, Class<? extends Object>> Tna;

    public static final ClassLoader bx(Class<?> cls) {
        AppMethodBeat.i(57399);
        p.h(cls, "$this$safeClassLoader");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
            p.g(classLoader, "ClassLoader.getSystemClassLoader()");
        }
        AppMethodBeat.o(57399);
        return classLoader;
    }

    public static final boolean by(Class<?> cls) {
        AppMethodBeat.i(57400);
        p.h(cls, "$this$isEnumClassOrSpecializedEnumEntryClass");
        boolean isAssignableFrom = Enum.class.isAssignableFrom(cls);
        AppMethodBeat.o(57400);
        return isAssignableFrom;
    }

    static {
        int i2 = 0;
        AppMethodBeat.i(57407);
        List<kotlin.l.b<? extends Object>> listOf = j.listOf((Object[]) new kotlin.l.b[]{aa.bp(Boolean.TYPE), aa.bp(Byte.TYPE), aa.bp(Character.TYPE), aa.bp(Double.TYPE), aa.bp(Float.TYPE), aa.bp(Integer.TYPE), aa.bp(Long.TYPE), aa.bp(Short.TYPE)});
        TmY = listOf;
        List<kotlin.l.b<? extends Object>> list = listOf;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (T t : list) {
            arrayList.add(s.U(kotlin.g.a.c(t), kotlin.g.a.b(t)));
        }
        TmZ = ae.E(arrayList);
        List<kotlin.l.b<? extends Object>> list2 = TmY;
        ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
        for (T t2 : list2) {
            arrayList2.add(s.U(kotlin.g.a.b(t2), kotlin.g.a.c(t2)));
        }
        Tna = ae.E(arrayList2);
        List listOf2 = j.listOf((Object[]) new Class[]{kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, r.class, kotlin.g.a.s.class, t.class, u.class, v.class, w.class, kotlin.g.a.c.class, d.class, e.class, f.class, g.class, h.class, i.class, kotlin.g.a.j.class, k.class, l.class, n.class, o.class, kotlin.g.a.p.class});
        ArrayList arrayList3 = new ArrayList(j.a(listOf2, 10));
        for (Object obj : listOf2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            arrayList3.add(s.U((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        SYq = ae.E(arrayList3);
        AppMethodBeat.o(57407);
    }

    public static final Class<?> bz(Class<?> cls) {
        AppMethodBeat.i(57401);
        p.h(cls, "$this$primitiveByWrapper");
        Class<? extends Object> cls2 = TmZ.get(cls);
        AppMethodBeat.o(57401);
        return cls2;
    }

    public static final Class<?> bA(Class<?> cls) {
        AppMethodBeat.i(57402);
        p.h(cls, "$this$wrapperByPrimitive");
        Class<? extends Object> cls2 = Tna.get(cls);
        AppMethodBeat.o(57402);
        return cls2;
    }

    public static final kotlin.l.b.a.b.f.a bB(Class<?> cls) {
        kotlin.l.b.a.b.f.a bB;
        AppMethodBeat.i(57403);
        p.h(cls, "$this$classId");
        if (cls.isPrimitive()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't compute ClassId for primitive type: ".concat(String.valueOf(cls)));
            AppMethodBeat.o(57403);
            throw illegalArgumentException;
        } else if (cls.isArray()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Can't compute ClassId for array type: ".concat(String.valueOf(cls)));
            AppMethodBeat.o(57403);
            throw illegalArgumentException2;
        } else {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                p.g(simpleName, "simpleName");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    if (declaringClass == null || (bB = bB(declaringClass)) == null) {
                        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(cls.getName()));
                        p.g(p, "ClassId.topLevel(FqName(name))");
                        AppMethodBeat.o(57403);
                        return p;
                    }
                    kotlin.l.b.a.b.f.a o = bB.o(kotlin.l.b.a.b.f.f.btY(cls.getSimpleName()));
                    AppMethodBeat.o(57403);
                    return o;
                }
            }
            kotlin.l.b.a.b.f.b bVar = new kotlin.l.b.a.b.f.b(cls.getName());
            kotlin.l.b.a.b.f.a aVar = new kotlin.l.b.a.b.f.a(bVar.hJf(), kotlin.l.b.a.b.f.b.r(bVar.hJg()), true);
            AppMethodBeat.o(57403);
            return aVar;
        }
    }

    public static final String bC(Class<?> cls) {
        AppMethodBeat.i(57404);
        p.h(cls, "$this$desc");
        if (p.j(cls, Void.TYPE)) {
            AppMethodBeat.o(57404);
            return "V";
        }
        String name = bD(cls).getName();
        p.g(name, "createArrayType().name");
        if (name == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(57404);
            throw tVar;
        }
        String substring = name.substring(1);
        p.g(substring, "(this as java.lang.String).substring(startIndex)");
        String a2 = kotlin.n.n.a(substring, '.', '/');
        AppMethodBeat.o(57404);
        return a2;
    }

    public static final Class<?> bD(Class<?> cls) {
        AppMethodBeat.i(57405);
        p.h(cls, "$this$createArrayType");
        Class<?> cls2 = Array.newInstance(cls, 0).getClass();
        AppMethodBeat.o(57405);
        return cls2;
    }

    public static final List<Type> a(Type type) {
        AppMethodBeat.i(57406);
        p.h(type, "$this$parameterizedTypeArguments");
        if (!(type instanceof ParameterizedType)) {
            kotlin.a.v vVar = kotlin.a.v.SXr;
            AppMethodBeat.o(57406);
            return vVar;
        } else if (((ParameterizedType) type).getOwnerType() == null) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            p.g(actualTypeArguments, "actualTypeArguments");
            List<Type> W = kotlin.a.e.W(actualTypeArguments);
            AppMethodBeat.o(57406);
            return W;
        } else {
            List<Type> c2 = kotlin.m.i.c(kotlin.m.i.c(kotlin.m.i.b(type, a.Tnb), C2280b.Tnc));
            AppMethodBeat.o(57406);
            return c2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.b<ParameterizedType, ParameterizedType> {
        public static final a Tnb = new a();

        static {
            AppMethodBeat.i(57396);
            AppMethodBeat.o(57396);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ParameterizedType invoke(ParameterizedType parameterizedType) {
            AppMethodBeat.i(57395);
            ParameterizedType parameterizedType2 = parameterizedType;
            p.h(parameterizedType2, LocaleUtil.ITALIAN);
            Type ownerType = parameterizedType2.getOwnerType();
            if (!(ownerType instanceof ParameterizedType)) {
                ownerType = null;
            }
            ParameterizedType parameterizedType3 = (ParameterizedType) ownerType;
            AppMethodBeat.o(57395);
            return parameterizedType3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.b.d.b.b$b  reason: collision with other inner class name */
    public static final class C2280b extends kotlin.g.b.q implements kotlin.g.a.b<ParameterizedType, kotlin.m.h<? extends Type>> {
        public static final C2280b Tnc = new C2280b();

        static {
            AppMethodBeat.i(57398);
            AppMethodBeat.o(57398);
        }

        C2280b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.m.h<? extends Type> invoke(ParameterizedType parameterizedType) {
            AppMethodBeat.i(57397);
            ParameterizedType parameterizedType2 = parameterizedType;
            p.h(parameterizedType2, LocaleUtil.ITALIAN);
            Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
            p.g(actualTypeArguments, "it.actualTypeArguments");
            kotlin.m.h aa = kotlin.a.e.aa(actualTypeArguments);
            AppMethodBeat.o(57397);
            return aa;
        }
    }
}
