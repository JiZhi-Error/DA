package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class g extends RuntimeException {
    public static Throwable a(Throwable th, Object obj) {
        AppMethodBeat.i(90054);
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable O = b.O(th);
        if (!(O instanceof a) || ((a) O).value != obj) {
            b.d(th, new a(obj));
            AppMethodBeat.o(90054);
        } else {
            AppMethodBeat.o(90054);
        }
        return th;
    }

    public static class a extends RuntimeException {
        final Object value;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(java.lang.Object r5) {
            /*
            // Method dump skipped, instructions count: 109
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.a.g.a.<init>(java.lang.Object):void");
        }

        /* renamed from: rx.a.g$a$a  reason: collision with other inner class name */
        static final class C2389a {
            static final Set<Class<?>> Ukm;

            static {
                AppMethodBeat.i(90052);
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                Ukm = hashSet;
                AppMethodBeat.o(90052);
            }
        }
    }
}
