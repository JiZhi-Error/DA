package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;

public final class y {
    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(56521);
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        switch (i2) {
            case 1:
            case 2:
                objArr[2] = "lazySoft";
                break;
            default:
                objArr[2] = "lazy";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(56521);
        throw illegalArgumentException;
    }

    public static abstract class c<T> {
        private static final Object TbD = new Object() {
            /* class kotlin.l.b.a.y.c.AnonymousClass1 */
        };

        public abstract T invoke();

        protected static Object ff(T t) {
            return t == null ? TbD : t;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        protected static T fg(Object obj) {
            if (obj == TbD) {
                return null;
            }
            return obj;
        }
    }

    public static class b<T> extends c<T> {
        private final kotlin.g.a.a<T> SWT;
        private volatile Object value;

        @Override // kotlin.l.b.a.y.c
        public final T invoke() {
            AppMethodBeat.i(56517);
            Object obj = this.value;
            if (obj != null) {
                T t = (T) fg(obj);
                AppMethodBeat.o(56517);
                return t;
            }
            T invoke = this.SWT.invoke();
            this.value = ff(invoke);
            AppMethodBeat.o(56517);
            return invoke;
        }

        public b(kotlin.g.a.a<T> aVar) {
            if (aVar == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
                AppMethodBeat.o(56516);
                throw illegalArgumentException;
            }
            AppMethodBeat.i(56516);
            this.value = null;
            this.SWT = aVar;
            AppMethodBeat.o(56516);
        }
    }

    public static class a<T> extends c<T> {
        private final kotlin.g.a.a<T> SWT;
        private volatile SoftReference<Object> TbC;

        @Override // kotlin.l.b.a.y.c
        public final T invoke() {
            Object obj;
            AppMethodBeat.i(56515);
            SoftReference<Object> softReference = this.TbC;
            if (softReference == null || (obj = softReference.get()) == null) {
                T invoke = this.SWT.invoke();
                this.TbC = new SoftReference<>(ff(invoke));
                AppMethodBeat.o(56515);
                return invoke;
            }
            T t = (T) fg(obj);
            AppMethodBeat.o(56515);
            return t;
        }

        public a(T t, kotlin.g.a.a<T> aVar) {
            if (aVar == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
                AppMethodBeat.o(56514);
                throw illegalArgumentException;
            }
            AppMethodBeat.i(56514);
            this.TbC = null;
            this.SWT = aVar;
            if (t != null) {
                this.TbC = new SoftReference<>(ff(t));
            }
            AppMethodBeat.o(56514);
        }
    }

    public static <T> b<T> aj(kotlin.g.a.a<T> aVar) {
        AppMethodBeat.i(56518);
        b<T> bVar = new b<>(aVar);
        AppMethodBeat.o(56518);
        return bVar;
    }

    public static <T> a<T> a(T t, kotlin.g.a.a<T> aVar) {
        AppMethodBeat.i(56519);
        if (aVar == null) {
            atM(1);
        }
        a<T> aVar2 = new a<>(t, aVar);
        AppMethodBeat.o(56519);
        return aVar2;
    }

    public static <T> a<T> ak(kotlin.g.a.a<T> aVar) {
        AppMethodBeat.i(56520);
        if (aVar == null) {
            atM(2);
        }
        a<T> a2 = a(null, aVar);
        AppMethodBeat.o(56520);
        return a2;
    }
}
