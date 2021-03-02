package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class j {
    public static volatile boolean TSh = false;
    private static final Object TbD = new Object() {
        /* class kotlin.l.b.a.b.o.j.AnonymousClass1 */

        public final String toString() {
            return "NULL_VALUE";
        }
    };

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(61412);
        switch (i2) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
            case 3:
                objArr[0] = "throwable";
                break;
            default:
                objArr[0] = "value";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                objArr[1] = "escapeNull";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "escapeThrowable";
                break;
            case 4:
                objArr[2] = "unescapeExceptionOrNull";
                break;
            default:
                objArr[2] = "unescapeNull";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 2:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(61412);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(61411);
        AppMethodBeat.o(61411);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private final Throwable throwable;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(61406);
            switch (i2) {
                case 1:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
                    break;
                default:
                    objArr[0] = "throwable";
                    break;
            }
            switch (i2) {
                case 1:
                    objArr[1] = "getThrowable";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
                    break;
            }
            switch (i2) {
                case 1:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(61406);
            throw illegalStateException;
        }

        /* synthetic */ a(Throwable th, byte b2) {
            this(th);
        }

        private a(Throwable th) {
            if (th == null) {
                atM(0);
            }
            AppMethodBeat.i(61403);
            this.throwable = th;
            AppMethodBeat.o(61403);
        }

        public final Throwable getThrowable() {
            AppMethodBeat.i(61404);
            Throwable th = this.throwable;
            if (th == null) {
                atM(1);
            }
            AppMethodBeat.o(61404);
            return th;
        }

        public final String toString() {
            AppMethodBeat.i(61405);
            String th = this.throwable.toString();
            AppMethodBeat.o(61405);
            return th;
        }
    }

    public static <V> Object fH(V v) {
        AppMethodBeat.i(61407);
        if (v == null) {
            v = (V) TbD;
            if (v == null) {
                atM(1);
            }
            AppMethodBeat.o(61407);
        } else {
            if (v == null) {
                atM(2);
            }
            AppMethodBeat.o(61407);
        }
        return v;
    }

    public static Object v(Throwable th) {
        AppMethodBeat.i(61408);
        a aVar = new a(th, (byte) 0);
        AppMethodBeat.o(61408);
        return aVar;
    }

    public static <V> V fI(Object obj) {
        AppMethodBeat.i(61409);
        if (obj == null) {
            atM(4);
        }
        V v = (V) fJ(obj);
        if (v == null) {
            atM(0);
        }
        if (v == TbD) {
            AppMethodBeat.o(61409);
            return null;
        }
        AppMethodBeat.o(61409);
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V fJ(Object obj) {
        AppMethodBeat.i(61410);
        if (obj instanceof a) {
            Throwable throwable = ((a) obj).getThrowable();
            if (!TSh || !c.u(throwable)) {
                p.h(throwable, "e");
                AppMethodBeat.o(61410);
                throw throwable;
            }
            b bVar = new b(throwable);
            AppMethodBeat.o(61410);
            throw bVar;
        }
        AppMethodBeat.o(61410);
        return obj;
    }

    public static class b extends RuntimeException {
        public b(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }
}
