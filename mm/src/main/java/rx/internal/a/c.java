package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import rx.e;

public final class c<T> {
    private static final Object UkA = new Serializable() {
        /* class rx.internal.a.c.AnonymousClass1 */

        public final String toString() {
            return "Notification=>Completed";
        }
    };
    private static final Object UkB = new Serializable() {
        /* class rx.internal.a.c.AnonymousClass2 */

        public final String toString() {
            return "Notification=>NULL";
        }
    };
    private static final c Ukz = new c();

    static {
        AppMethodBeat.i(90234);
        AppMethodBeat.o(90234);
    }

    private c() {
    }

    public static <T> c<T> hQG() {
        return Ukz;
    }

    static final class a implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        final Throwable f2995e;

        public a(Throwable th) {
            this.f2995e = th;
        }

        public final String toString() {
            AppMethodBeat.i(90231);
            String str = "Notification=>Error:" + this.f2995e;
            AppMethodBeat.o(90231);
            return str;
        }
    }

    public static Object gN(T t) {
        if (t == null) {
            return UkB;
        }
        return t;
    }

    public static Object hQH() {
        return UkA;
    }

    public static Object P(Throwable th) {
        AppMethodBeat.i(90232);
        a aVar = new a(th);
        AppMethodBeat.o(90232);
        return aVar;
    }

    public static boolean a(e<? super T> eVar, Object obj) {
        AppMethodBeat.i(90233);
        if (obj == UkA) {
            eVar.hQw();
            AppMethodBeat.o(90233);
            return true;
        } else if (obj == UkB) {
            eVar.gL(null);
            AppMethodBeat.o(90233);
            return false;
        } else if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The lite notification can not be null");
            AppMethodBeat.o(90233);
            throw illegalArgumentException;
        } else if (obj.getClass() == a.class) {
            eVar.onError(((a) obj).f2995e);
            AppMethodBeat.o(90233);
            return true;
        } else {
            eVar.gL(obj);
            AppMethodBeat.o(90233);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static T getValue(Object obj) {
        if (obj == UkB) {
            return null;
        }
        return obj;
    }
}
