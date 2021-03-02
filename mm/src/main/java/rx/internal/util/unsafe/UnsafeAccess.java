package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeAccess {
    private static final boolean DISABLED_BY_USER;
    public static final Unsafe UNSAFE;

    static {
        Unsafe unsafe;
        boolean z = true;
        AppMethodBeat.i(90130);
        if (System.getProperty("rx.unsafe-disable") == null) {
            z = false;
        }
        DISABLED_BY_USER = z;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable th) {
            unsafe = null;
        }
        UNSAFE = unsafe;
        AppMethodBeat.o(90130);
    }

    private UnsafeAccess() {
        AppMethodBeat.i(90124);
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        AppMethodBeat.o(90124);
        throw illegalStateException;
    }

    public static boolean isUnsafeAvailable() {
        return UNSAFE != null && !DISABLED_BY_USER;
    }

    public static int getAndIncrementInt(Object obj, long j2) {
        int intVolatile;
        AppMethodBeat.i(90125);
        do {
            intVolatile = UNSAFE.getIntVolatile(obj, j2);
        } while (!UNSAFE.compareAndSwapInt(obj, j2, intVolatile, intVolatile + 1));
        AppMethodBeat.o(90125);
        return intVolatile;
    }

    public static int getAndAddInt(Object obj, long j2, int i2) {
        int intVolatile;
        AppMethodBeat.i(90126);
        do {
            intVolatile = UNSAFE.getIntVolatile(obj, j2);
        } while (!UNSAFE.compareAndSwapInt(obj, j2, intVolatile, intVolatile + i2));
        AppMethodBeat.o(90126);
        return intVolatile;
    }

    public static int getAndSetInt(Object obj, long j2, int i2) {
        int intVolatile;
        AppMethodBeat.i(90127);
        do {
            intVolatile = UNSAFE.getIntVolatile(obj, j2);
        } while (!UNSAFE.compareAndSwapInt(obj, j2, intVolatile, i2));
        AppMethodBeat.o(90127);
        return intVolatile;
    }

    public static boolean compareAndSwapInt(Object obj, long j2, int i2, int i3) {
        AppMethodBeat.i(90128);
        boolean compareAndSwapInt = UNSAFE.compareAndSwapInt(obj, j2, i2, i3);
        AppMethodBeat.o(90128);
        return compareAndSwapInt;
    }

    public static long addressOf(Class<?> cls, String str) {
        AppMethodBeat.i(90129);
        try {
            long objectFieldOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
            AppMethodBeat.o(90129);
            return objectFieldOffset;
        } catch (NoSuchFieldException e2) {
            InternalError internalError = new InternalError();
            internalError.initCause(e2);
            AppMethodBeat.o(90129);
            throw internalError;
        }
    }
}
