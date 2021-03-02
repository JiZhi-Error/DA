package kotlin.l.b.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.e.c.a.e;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "", "()V", "asString", "", "FakeJavaAnnotationConstructor", "JavaConstructor", "JavaMethod", "KotlinConstructor", "KotlinFunction", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "kotlin-reflection"})
public abstract class c {
    public abstract String sG();

    private c() {
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "methodDesc", "getMethodDesc", "()Ljava/lang/String;", "methodName", "getMethodName", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
    public static final class e extends c {
        final String SZA = this.SZB.sG();
        final e.b SZB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(e.b bVar) {
            super((byte) 0);
            p.h(bVar, "signature");
            AppMethodBeat.i(56290);
            this.SZB = bVar;
            AppMethodBeat.o(56290);
        }

        @Override // kotlin.l.b.a.c
        public final String sG() {
            return this.SZA;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "signature", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMemberSignature$Method;", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "_signature", "", "constructorDesc", "getConstructorDesc", "()Ljava/lang/String;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "asString", "kotlin-reflection"})
    public static final class d extends c {
        private final String SZA = this.SZB.sG();
        final e.b SZB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e.b bVar) {
            super((byte) 0);
            p.h(bVar, "signature");
            AppMethodBeat.i(56289);
            this.SZB = bVar;
            AppMethodBeat.o(56289);
        }

        @Override // kotlin.l.b.a.c
        public final String sG() {
            return this.SZA;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaMethod;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", FirebaseAnalytics.b.METHOD, "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "asString", "", "kotlin-reflection"})
    /* renamed from: kotlin.l.b.a.c$c  reason: collision with other inner class name */
    public static final class C2369c extends c {
        final Method method;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C2369c(Method method2) {
            super((byte) 0);
            p.h(method2, FirebaseAnalytics.b.METHOD);
            AppMethodBeat.i(56288);
            this.method = method2;
            AppMethodBeat.o(56288);
        }

        @Override // kotlin.l.b.a.c
        public final String sG() {
            AppMethodBeat.i(56287);
            String c2 = ad.c(this.method);
            AppMethodBeat.o(56287);
            return c2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$JavaConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "constructor", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getConstructor", "()Ljava/lang/reflect/Constructor;", "asString", "", "kotlin-reflection"})
    public static final class b extends c {
        final Constructor<?> SZy;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
        static final class a extends q implements kotlin.g.a.b<Class<?>, String> {
            public static final a SZz = new a();

            static {
                AppMethodBeat.i(56284);
                AppMethodBeat.o(56284);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(Class<?> cls) {
                AppMethodBeat.i(56283);
                Class<?> cls2 = cls;
                p.g(cls2, LocaleUtil.ITALIAN);
                String bC = kotlin.l.b.a.b.b.d.b.b.bC(cls2);
                AppMethodBeat.o(56283);
                return bC;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Constructor<?> constructor) {
            super((byte) 0);
            p.h(constructor, "constructor");
            AppMethodBeat.i(56286);
            this.SZy = constructor;
            AppMethodBeat.o(56286);
        }

        @Override // kotlin.l.b.a.c
        public final String sG() {
            AppMethodBeat.i(56285);
            Class<?>[] parameterTypes = this.SZy.getParameterTypes();
            p.g(parameterTypes, "constructor.parameterTypes");
            String a2 = kotlin.a.e.a(parameterTypes, "", "<init>(", ")V", 0, (CharSequence) null, a.SZz, 24);
            AppMethodBeat.o(56285);
            return a2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, hxF = {"Lkotlin/reflect/jvm/internal/JvmFunctionSignature$FakeJavaAnnotationConstructor;", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "methods", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getMethods", "()Ljava/util/List;", "asString", "", "kotlin-reflection"})
    public static final class a extends c {
        private final Class<?> SYp;
        final List<Method> SZw;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
        static final class b extends q implements kotlin.g.a.b<Method, String> {
            public static final b SZx = new b();

            static {
                AppMethodBeat.i(56280);
                AppMethodBeat.o(56280);
            }

            b() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(Method method) {
                AppMethodBeat.i(56279);
                Method method2 = method;
                p.g(method2, LocaleUtil.ITALIAN);
                Class<?> returnType = method2.getReturnType();
                p.g(returnType, "it.returnType");
                String bC = kotlin.l.b.a.b.b.d.b.b.bC(returnType);
                AppMethodBeat.o(56279);
                return bC;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Class<?> cls) {
            super((byte) 0);
            p.h(cls, "jClass");
            AppMethodBeat.i(56282);
            this.SYp = cls;
            Method[] declaredMethods = this.SYp.getDeclaredMethods();
            p.g(declaredMethods, "jClass.declaredMethods");
            this.SZw = kotlin.a.e.b(declaredMethods, new C2367a());
            AppMethodBeat.o(56282);
        }

        @Override // kotlin.l.b.a.c
        public final String sG() {
            AppMethodBeat.i(56281);
            String a2 = j.a(this.SZw, "", "<init>(", ")V", 0, (CharSequence) null, b.SZx, 24);
            AppMethodBeat.o(56281);
            return a2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
        /* renamed from: kotlin.l.b.a.c$a$a  reason: collision with other inner class name */
        public static final class C2367a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                AppMethodBeat.i(56278);
                T t3 = t;
                p.g(t3, LocaleUtil.ITALIAN);
                T t4 = t2;
                p.g(t4, LocaleUtil.ITALIAN);
                int a2 = kotlin.b.a.a(t3.getName(), t4.getName());
                AppMethodBeat.o(56278);
                return a2;
            }
        }
    }
}
