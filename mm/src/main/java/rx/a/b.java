package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import rx.e;

public final class b {
    public static void N(Throwable th) {
        if (th instanceof f) {
            throw ((f) th);
        } else if (th instanceof e) {
            throw ((e) th);
        } else if (th instanceof d) {
            throw ((d) th);
        } else if (th instanceof StackOverflowError) {
            throw ((StackOverflowError) th);
        } else if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static void d(Throwable th, Throwable th2) {
        AppMethodBeat.i(90045);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                AppMethodBeat.o(90045);
                return;
            }
            th = th.getCause();
            if (!hashSet.contains(th.getCause())) {
                hashSet.add(th.getCause());
                i2 = i3;
            }
        }
        try {
            th.initCause(th2);
            AppMethodBeat.o(90045);
        } catch (Throwable th3) {
            AppMethodBeat.o(90045);
        }
    }

    public static Throwable O(Throwable th) {
        AppMethodBeat.i(90046);
        int i2 = 0;
        while (th.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                RuntimeException runtimeException = new RuntimeException("Stack too deep to get final cause");
                AppMethodBeat.o(90046);
                return runtimeException;
            }
            th = th.getCause();
            i2 = i3;
        }
        AppMethodBeat.o(90046);
        return th;
    }

    public static void kP(List<? extends Throwable> list) {
        AppMethodBeat.i(90047);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(90047);
        } else if (list.size() == 1) {
            Throwable th = (Throwable) list.get(0);
            if (th instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.o(90047);
                throw runtimeException;
            } else if (th instanceof Error) {
                Error error = (Error) th;
                AppMethodBeat.o(90047);
                throw error;
            } else {
                RuntimeException runtimeException2 = new RuntimeException(th);
                AppMethodBeat.o(90047);
                throw runtimeException2;
            }
        } else {
            a aVar = new a(list, (byte) 0);
            AppMethodBeat.o(90047);
            throw aVar;
        }
    }

    public static void a(Throwable th, e<?> eVar, Object obj) {
        AppMethodBeat.i(90048);
        N(th);
        eVar.onError(g.a(th, obj));
        AppMethodBeat.o(90048);
    }

    public static void a(Throwable th, e<?> eVar) {
        AppMethodBeat.i(90049);
        N(th);
        eVar.onError(th);
        AppMethodBeat.o(90049);
    }
}
