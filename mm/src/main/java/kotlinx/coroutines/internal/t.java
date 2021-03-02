package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;

public final class t {
    private static final String TWg;
    private static final String TWh;

    static {
        Object r0;
        Object r02;
        AppMethodBeat.i(192484);
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(Class.forName("kotlin.d.b.a.a").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m49exceptionOrNullimpl(r0) != null) {
            r0 = "kotlin.d.b.a.a";
        }
        TWg = (String) r0;
        try {
            Result.Companion companion3 = Result.Companion;
            r02 = Result.m46constructorimpl(Class.forName("kotlinx.coroutines.internal.t").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            r02 = Result.m46constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m49exceptionOrNullimpl(r02) != null) {
            r02 = "kotlinx.coroutines.internal.t";
        }
        TWh = (String) r02;
        AppMethodBeat.o(192484);
    }

    private static final <E extends Throwable> E a(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        int i2 = 0;
        AppMethodBeat.i(192479);
        arrayDeque.addFirst(new StackTraceElement("\b\b\b(".concat(String.valueOf("Coroutine boundary")), "\b", "\b", -1));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int a2 = a(stackTrace, TWg);
        if (a2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(192479);
                throw tVar;
            }
            e3.setStackTrace((StackTraceElement[]) array);
            AppMethodBeat.o(192479);
        } else {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + a2)];
            for (int i3 = 0; i3 < a2; i3++) {
                stackTraceElementArr[i3] = stackTrace[i3];
            }
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr[a2 + i2] = it.next();
                i2++;
            }
            e3.setStackTrace(stackTraceElementArr);
            AppMethodBeat.o(192479);
        }
        return e3;
    }

    public static final <E extends Throwable> E I(E e2) {
        boolean z = false;
        AppMethodBeat.i(192481);
        E e3 = (E) e2.getCause();
        if (e3 == null || (!p.j(e3.getClass(), e2.getClass()))) {
            AppMethodBeat.o(192481);
            return e2;
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (a(stackTrace[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            AppMethodBeat.o(192481);
            return e3;
        }
        AppMethodBeat.o(192481);
        return e2;
    }

    private static boolean a(StackTraceElement stackTraceElement) {
        AppMethodBeat.i(192482);
        boolean J = n.J(stackTraceElement.getClassName(), "\b\b\b", false);
        AppMethodBeat.o(192482);
        return J;
    }

    private static final void a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        boolean z;
        AppMethodBeat.i(192480);
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (a(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i3) {
            while (true) {
                StackTraceElement stackTraceElement = stackTraceElementArr[length2];
                StackTraceElement last = arrayDeque.getLast();
                if (stackTraceElement.getLineNumber() != last.getLineNumber() || !p.j(stackTraceElement.getMethodName(), last.getMethodName()) || !p.j(stackTraceElement.getFileName(), last.getFileName()) || !p.j(stackTraceElement.getClassName(), last.getClassName())) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 == i3) {
                    break;
                }
                length2--;
            }
        }
        AppMethodBeat.o(192480);
    }

    private static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        AppMethodBeat.i(192483);
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (p.j(str, stackTraceElementArr[i2].getClassName())) {
                AppMethodBeat.o(192483);
                return i2;
            }
        }
        AppMethodBeat.o(192483);
        return -1;
    }

    public static final /* synthetic */ Throwable a(Throwable th, e eVar) {
        o U;
        boolean z;
        AppMethodBeat.i(192485);
        Throwable cause = th.getCause();
        if (cause == null || !p.j(cause.getClass(), th.getClass())) {
            U = s.U(th, new StackTraceElement[0]);
        } else {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (a(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                U = s.U(cause, stackTrace);
            } else {
                U = s.U(th, new StackTraceElement[0]);
            }
        }
        A a2 = U.first;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) U.second;
        Throwable G = f.G(a2);
        if (G == null) {
            AppMethodBeat.o(192485);
            return th;
        } else if (!p.j(G.getMessage(), a2.getMessage())) {
            AppMethodBeat.o(192485);
            return th;
        } else {
            ArrayDeque arrayDeque = new ArrayDeque();
            StackTraceElement stackTraceElement = eVar.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayDeque.add(stackTraceElement);
            }
            while (true) {
                if (!(eVar instanceof e)) {
                    eVar = null;
                }
                if (eVar != null && (eVar = eVar.getCallerFrame()) != null) {
                    StackTraceElement stackTraceElement2 = eVar.getStackTraceElement();
                    if (stackTraceElement2 != null) {
                        arrayDeque.add(stackTraceElement2);
                    }
                }
            }
            if (arrayDeque.isEmpty()) {
                AppMethodBeat.o(192485);
                return th;
            }
            if (a2 != th) {
                a(stackTraceElementArr, arrayDeque);
            }
            Throwable a3 = a(a2, G, arrayDeque);
            AppMethodBeat.o(192485);
            return a3;
        }
    }
}
