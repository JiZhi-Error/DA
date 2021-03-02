package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.e;
import kotlin.w;

public class p {
    private p() {
    }

    public static String I(String str, Object obj) {
        AppMethodBeat.i(128973);
        String str2 = str + obj;
        AppMethodBeat.o(128973);
        return str2;
    }

    public static void hyc() {
        AppMethodBeat.i(128974);
        e eVar = (e) r(new e());
        AppMethodBeat.o(128974);
        throw eVar;
    }

    public static void btv(String str) {
        AppMethodBeat.i(128975);
        w wVar = (w) r(new w("lateinit property " + str + " has not been initialized"));
        AppMethodBeat.o(128975);
        throw wVar;
    }

    public static void g(Object obj, String str) {
        AppMethodBeat.i(128976);
        if (obj == null) {
            IllegalStateException illegalStateException = (IllegalStateException) r(new IllegalStateException(str + " must not be null"));
            AppMethodBeat.o(128976);
            throw illegalStateException;
        }
        AppMethodBeat.o(128976);
    }

    public static void h(Object obj, String str) {
        AppMethodBeat.i(128977);
        if (obj == null) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            IllegalArgumentException illegalArgumentException = (IllegalArgumentException) r(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str));
            AppMethodBeat.o(128977);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(128977);
    }

    public static int compare(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static boolean j(Object obj, Object obj2) {
        AppMethodBeat.i(128978);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(128978);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(128978);
            return true;
        } else {
            AppMethodBeat.o(128978);
            return false;
        }
    }

    public static boolean a(Float f2) {
        AppMethodBeat.i(128979);
        if (f2 == null || f2.floatValue() != 0.0f) {
            AppMethodBeat.o(128979);
            return false;
        }
        AppMethodBeat.o(128979);
        return true;
    }

    private static <T extends Throwable> T r(T t) {
        AppMethodBeat.i(128980);
        T t2 = (T) c(t, p.class.getName());
        AppMethodBeat.o(128980);
        return t2;
    }

    static <T extends Throwable> T c(T t, String str) {
        AppMethodBeat.i(128981);
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        AppMethodBeat.o(128981);
        return t;
    }

    public static void hyd() {
        AppMethodBeat.i(206191);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        AppMethodBeat.o(206191);
        throw unsupportedOperationException;
    }
}
