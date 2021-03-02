package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;

public interface r {
    public static final r TLh = new r() {
        /* class kotlin.l.b.a.b.k.a.r.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(60316);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "unresolvedSuperClasses";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            switch (i2) {
                case 2:
                    objArr[2] = "reportCannotInferVisibility";
                    break;
                default:
                    objArr[2] = "reportIncompleteHierarchy";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(60316);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.k.a.r
        public final void a(e eVar, List<String> list) {
            AppMethodBeat.i(60314);
            if (eVar == null) {
                atM(0);
            }
            AppMethodBeat.o(60314);
        }

        @Override // kotlin.l.b.a.b.k.a.r
        public final void h(b bVar) {
            AppMethodBeat.i(60315);
            if (bVar == null) {
                atM(2);
            }
            AppMethodBeat.o(60315);
        }
    };

    void a(e eVar, List<String> list);

    void h(b bVar);
}
