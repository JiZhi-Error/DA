package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface an {
    public static final an ThK = new an() {
        /* class kotlin.l.b.a.b.b.an.AnonymousClass1 */

        public final String toString() {
            return "NO_SOURCE";
        }

        @Override // kotlin.l.b.a.b.b.an
        public final ao hBu() {
            AppMethodBeat.i(56884);
            ao aoVar = ao.ThL;
            if (aoVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
                AppMethodBeat.o(56884);
                throw illegalStateException;
            }
            AppMethodBeat.o(56884);
            return aoVar;
        }
    };

    ao hBu();
}
