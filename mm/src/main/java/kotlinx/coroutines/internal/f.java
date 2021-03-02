package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.rtmp.sharp.jni.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, hxF = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", QLog.TAG_REPORTLEVEL_USER, "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"})
public final class f {
    private static final int TVE = c(Throwable.class, -1);
    private static final ReentrantReadWriteLock TVF = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.g.a.b<Throwable, Throwable>> TVG = new WeakHashMap<>();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_USER, "", LocaleUtil.ITALIAN, "invoke"})
    /* renamed from: kotlinx.coroutines.internal.f$f  reason: collision with other inner class name */
    public static final class C2380f extends q implements kotlin.g.a.b {
        public static final C2380f TVI = new C2380f();

        static {
            AppMethodBeat.i(192477);
            AppMethodBeat.o(192477);
        }

        C2380f() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", QLog.TAG_REPORTLEVEL_USER, "", LocaleUtil.ITALIAN, "invoke"})
    public static final class g extends q implements kotlin.g.a.b {
        public static final g TVJ = new g();

        static {
            AppMethodBeat.i(192450);
            AppMethodBeat.o(192450);
        }

        g() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return null;
        }
    }

    static {
        AppMethodBeat.i(192490);
        AppMethodBeat.o(192490);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public static final <E extends java.lang.Throwable> E G(E r10) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.f.G(java.lang.Throwable):java.lang.Throwable");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
    public static final class a extends q implements kotlin.g.a.b<Throwable, Throwable> {
        final /* synthetic */ Constructor TVH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.TVH = constructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Throwable invoke(Throwable th) {
            AppMethodBeat.i(192458);
            Throwable H = H(th);
            AppMethodBeat.o(192458);
            return H;
        }

        private Throwable H(Throwable th) {
            Object obj;
            AppMethodBeat.i(192459);
            try {
                Result.Companion companion = Result.Companion;
                Object newInstance = this.TVH.newInstance(th.getMessage(), th);
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Throwable");
                    AppMethodBeat.o(192459);
                    throw tVar;
                }
                obj = Result.m46constructorimpl((Throwable) newInstance);
                if (Result.m52isFailureimpl(obj)) {
                    obj = null;
                }
                Throwable th2 = (Throwable) obj;
                AppMethodBeat.o(192459);
                return th2;
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m46constructorimpl(ResultKt.createFailure(th3));
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
    public static final class b extends q implements kotlin.g.a.b<Throwable, Throwable> {
        final /* synthetic */ Constructor TVH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.TVH = constructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Throwable invoke(Throwable th) {
            AppMethodBeat.i(192486);
            Throwable H = H(th);
            AppMethodBeat.o(192486);
            return H;
        }

        private Throwable H(Throwable th) {
            Object obj;
            AppMethodBeat.i(192487);
            try {
                Result.Companion companion = Result.Companion;
                Object newInstance = this.TVH.newInstance(th);
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Throwable");
                    AppMethodBeat.o(192487);
                    throw tVar;
                }
                obj = Result.m46constructorimpl((Throwable) newInstance);
                if (Result.m52isFailureimpl(obj)) {
                    obj = null;
                }
                Throwable th2 = (Throwable) obj;
                AppMethodBeat.o(192487);
                return th2;
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m46constructorimpl(ResultKt.createFailure(th3));
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
    public static final class c extends q implements kotlin.g.a.b<Throwable, Throwable> {
        final /* synthetic */ Constructor TVH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.TVH = constructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Throwable invoke(Throwable th) {
            AppMethodBeat.i(192446);
            Throwable H = H(th);
            AppMethodBeat.o(192446);
            return H;
        }

        private Throwable H(Throwable th) {
            Object obj;
            AppMethodBeat.i(192447);
            try {
                Result.Companion companion = Result.Companion;
                Object newInstance = this.TVH.newInstance(th.getMessage());
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Throwable");
                    AppMethodBeat.o(192447);
                    throw tVar;
                }
                Throwable th2 = (Throwable) newInstance;
                th2.initCause(th);
                obj = Result.m46constructorimpl(th2);
                if (Result.m52isFailureimpl(obj)) {
                    obj = null;
                }
                Throwable th3 = (Throwable) obj;
                AppMethodBeat.o(192447);
                return th3;
            } catch (Throwable th4) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m46constructorimpl(ResultKt.createFailure(th4));
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"})
    public static final class d extends q implements kotlin.g.a.b<Throwable, Throwable> {
        final /* synthetic */ Constructor TVH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.TVH = constructor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Throwable invoke(Throwable th) {
            AppMethodBeat.i(192460);
            Throwable H = H(th);
            AppMethodBeat.o(192460);
            return H;
        }

        private Throwable H(Throwable th) {
            Object obj;
            AppMethodBeat.i(192461);
            try {
                Result.Companion companion = Result.Companion;
                Object newInstance = this.TVH.newInstance(new Object[0]);
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Throwable");
                    AppMethodBeat.o(192461);
                    throw tVar;
                }
                Throwable th2 = (Throwable) newInstance;
                th2.initCause(th);
                obj = Result.m46constructorimpl(th2);
                if (Result.m52isFailureimpl(obj)) {
                    obj = null;
                }
                Throwable th3 = (Throwable) obj;
                AppMethodBeat.o(192461);
                return th3;
            } catch (Throwable th4) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m46constructorimpl(ResultKt.createFailure(th4));
            }
        }
    }

    private static final int c(Class<?> cls, int i2) {
        Integer r0;
        int i3;
        AppMethodBeat.i(192489);
        kotlin.g.a.bo(cls);
        try {
            Result.Companion companion = Result.Companion;
            int i4 = 0;
            while (true) {
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                int i5 = 0;
                for (int i6 = 0; i6 < length; i6++) {
                    if (!Modifier.isStatic(declaredFields[i6].getModifiers())) {
                        i5++;
                    }
                }
                i3 = i5 + i4;
                cls = cls.getSuperclass();
                if (cls == null) {
                    break;
                }
                i4 = i3;
            }
            r0 = Result.m46constructorimpl(Integer.valueOf(i3));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.m52isFailureimpl(r0)) {
            r0 = valueOf;
        }
        int intValue = ((Number) r0).intValue();
        AppMethodBeat.o(192489);
        return intValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class e<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(192451);
            int a2 = kotlin.b.a.a(Integer.valueOf(t2.getParameterTypes().length), Integer.valueOf(t.getParameterTypes().length));
            AppMethodBeat.o(192451);
            return a2;
        }
    }
}
