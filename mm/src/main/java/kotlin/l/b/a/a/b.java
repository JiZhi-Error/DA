package kotlin.l.b.a.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.w;
import kotlin.l.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014"}, hxF = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", FirebaseAnalytics.b.INDEX, "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection"})
public final class b {
    static final Object d(Object obj, Class<?> cls) {
        AppMethodBeat.i(186238);
        if (obj instanceof Class) {
            AppMethodBeat.o(186238);
            return null;
        }
        if (obj instanceof kotlin.l.b) {
            obj = kotlin.g.a.a((kotlin.l.b) obj);
        } else if (obj instanceof Object[]) {
            if (((Object[]) obj) instanceof Class[]) {
                AppMethodBeat.o(186238);
                return null;
            } else if (!(((Object[]) obj) instanceof kotlin.l.b[])) {
                obj = (Object[]) obj;
            } else if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                AppMethodBeat.o(186238);
                throw tVar;
            } else {
                kotlin.l.b[] bVarArr = (kotlin.l.b[]) obj;
                ArrayList arrayList = new ArrayList(bVarArr.length);
                for (kotlin.l.b bVar : bVarArr) {
                    arrayList.add(kotlin.g.a.a(bVar));
                }
                obj = arrayList.toArray(new Class[0]);
                if (obj == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.Array<T>");
                    AppMethodBeat.o(186238);
                    throw tVar2;
                }
            }
        }
        if (cls.isInstance(obj)) {
            AppMethodBeat.o(186238);
            return obj;
        }
        AppMethodBeat.o(186238);
        return null;
    }

    public static /* synthetic */ Object a(Class cls, Map map) {
        AppMethodBeat.i(56586);
        Set<String> keySet = map.keySet();
        ArrayList arrayList = new ArrayList(j.a(keySet, 10));
        for (String str : keySet) {
            arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
        }
        Object a2 = a(cls, map, arrayList);
        AppMethodBeat.o(56586);
        return a2;
    }

    public static final <T> T a(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        AppMethodBeat.i(56585);
        p.h(cls, "annotationClass");
        p.h(map, "values");
        p.h(list, "methods");
        a aVar = new a(cls, list, map);
        f ah = g.ah(new C2265b(map));
        f ah2 = g.ah(new d(cls, map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, ah2, ah, aVar, map));
        if (t == null) {
            t tVar = new t("null cannot be cast to non-null type T");
            AppMethodBeat.o(56585);
            throw tVar;
        }
        AppMethodBeat.o(56585);
        return t;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"equals", "", "T", "", FacebookRequestErrorClassification.KEY_OTHER, "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Object, Boolean> {
        final /* synthetic */ Map NRx;
        final /* synthetic */ Class TbZ;
        final /* synthetic */ List Tca;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Class cls, List list, Map map) {
            super(1);
            this.TbZ = cls;
            this.Tca = list;
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Object obj) {
            AppMethodBeat.i(56577);
            Boolean valueOf = Boolean.valueOf(fj(obj));
            AppMethodBeat.o(56577);
            return valueOf;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean fj(java.lang.Object r8) {
            /*
            // Method dump skipped, instructions count: 361
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.a.b.a.fj(java.lang.Object):boolean");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, hxF = {"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
    public static final class c implements InvocationHandler {
        final /* synthetic */ Map NRx;
        final /* synthetic */ Class TbZ;
        final /* synthetic */ f Tcb;
        final /* synthetic */ k Tcc = null;
        final /* synthetic */ f Tcd;
        final /* synthetic */ k Tce;
        final /* synthetic */ a Tcf;

        c(Class cls, f fVar, f fVar2, a aVar, Map map) {
            this.TbZ = cls;
            this.Tcb = fVar;
            this.Tcd = fVar2;
            this.Tce = null;
            this.Tcf = aVar;
            this.NRx = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            AppMethodBeat.i(56580);
            p.g(method, FirebaseAnalytics.b.METHOD);
            String name = method.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1776922004:
                        if (name.equals("toString")) {
                            Object value = this.Tcb.getValue();
                            AppMethodBeat.o(56580);
                            return value;
                        }
                        break;
                    case 147696667:
                        if (name.equals("hashCode")) {
                            Object value2 = this.Tcd.getValue();
                            AppMethodBeat.o(56580);
                            return value2;
                        }
                        break;
                    case 1444986633:
                        if (name.equals("annotationType")) {
                            Class cls = this.TbZ;
                            AppMethodBeat.o(56580);
                            return cls;
                        }
                        break;
                }
            }
            if (p.j(name, "equals") && objArr != null && objArr.length == 1) {
                Boolean valueOf = Boolean.valueOf(this.Tcf.fj(e.T(objArr)));
                AppMethodBeat.o(56580);
                return valueOf;
            } else if (this.NRx.containsKey(name)) {
                Object obj2 = this.NRx.get(name);
                AppMethodBeat.o(56580);
                return obj2;
            } else {
                StringBuilder append = new StringBuilder("Method is not supported: ").append(method).append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                w wVar = new w(append.append(e.W(objArr)).append(')').toString());
                AppMethodBeat.o(56580);
                throw wVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "", "invoke"})
    /* renamed from: kotlin.l.b.a.a.b$b  reason: collision with other inner class name */
    public static final class C2265b extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ Map NRx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2265b(Map map) {
            super(0);
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            int hashCode;
            AppMethodBeat.i(56579);
            int i2 = 0;
            for (Map.Entry entry : this.NRx.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) value);
                } else if (value instanceof Object[]) {
                    hashCode = Arrays.hashCode((Object[]) value);
                } else {
                    hashCode = value.hashCode();
                }
                i2 = (hashCode ^ (str.hashCode() * TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH)) + i2;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(56579);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "T", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ Map NRx;
        final /* synthetic */ Class TbZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Class cls, Map map) {
            super(0);
            this.TbZ = cls;
            this.NRx = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(56583);
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(this.TbZ.getCanonicalName());
            j.a(this.NRx.entrySet(), sb, ", ", "(", ")", 0, null, a.Tcg, 48);
            String sb2 = sb.toString();
            p.g(sb2, "StringBuilder().apply(builderAction).toString()");
            AppMethodBeat.o(56583);
            return sb2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "T", "", "entry", "", "invoke"})
        static final class a extends q implements kotlin.g.a.b<Map.Entry<? extends String, ? extends Object>, String> {
            public static final a Tcg = new a();

            static {
                AppMethodBeat.i(56582);
                AppMethodBeat.o(56582);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(Map.Entry<? extends String, ? extends Object> entry) {
                String obj;
                AppMethodBeat.i(56581);
                Map.Entry<? extends String, ? extends Object> entry2 = entry;
                p.h(entry2, "entry");
                String str = (String) entry2.getKey();
                Object value = entry2.getValue();
                if (value instanceof boolean[]) {
                    obj = Arrays.toString((boolean[]) value);
                } else if (value instanceof char[]) {
                    obj = Arrays.toString((char[]) value);
                } else if (value instanceof byte[]) {
                    obj = Arrays.toString((byte[]) value);
                } else if (value instanceof short[]) {
                    obj = Arrays.toString((short[]) value);
                } else if (value instanceof int[]) {
                    obj = Arrays.toString((int[]) value);
                } else if (value instanceof float[]) {
                    obj = Arrays.toString((float[]) value);
                } else if (value instanceof long[]) {
                    obj = Arrays.toString((long[]) value);
                } else if (value instanceof double[]) {
                    obj = Arrays.toString((double[]) value);
                } else if (value instanceof Object[]) {
                    obj = Arrays.toString((Object[]) value);
                } else {
                    obj = value.toString();
                }
                String str2 = str + '=' + obj;
                AppMethodBeat.o(56581);
                return str2;
            }
        }
    }
}
