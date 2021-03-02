package kotlin.l.b.a.b.d.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.d.a.e.l;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.f.b;

public interface g {
    public static final g Tqm = new g() {
        /* class kotlin.l.b.a.b.d.a.a.g.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(57678);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = FirebaseAnalytics.b.METHOD;
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(57678);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.d.a.a.g
        public final e n(b bVar) {
            AppMethodBeat.i(57673);
            if (bVar == null) {
                atM(0);
            }
            AppMethodBeat.o(57673);
            return null;
        }

        @Override // kotlin.l.b.a.b.d.a.a.g
        public final void a(q qVar, am amVar) {
            AppMethodBeat.i(57674);
            if (qVar == null) {
                atM(1);
            }
            if (amVar == null) {
                atM(2);
            }
            AppMethodBeat.o(57674);
        }

        @Override // kotlin.l.b.a.b.d.a.a.g
        public final void a(l lVar, k kVar) {
            AppMethodBeat.i(57675);
            if (lVar == null) {
                atM(3);
            }
            if (kVar == null) {
                atM(4);
            }
            AppMethodBeat.o(57675);
        }

        @Override // kotlin.l.b.a.b.d.a.a.g
        public final void b(n nVar, ah ahVar) {
            AppMethodBeat.i(57676);
            if (nVar == null) {
                atM(5);
            }
            if (ahVar == null) {
                atM(6);
            }
            AppMethodBeat.o(57676);
        }

        @Override // kotlin.l.b.a.b.d.a.a.g
        public final void b(kotlin.l.b.a.b.d.a.e.g gVar) {
            AppMethodBeat.i(57677);
            if (gVar == null) {
                atM(7);
            }
            AppMethodBeat.o(57677);
        }
    };

    void a(l lVar, k kVar);

    void a(q qVar, am amVar);

    void b(kotlin.l.b.a.b.d.a.e.g gVar);

    void b(n nVar, ah ahVar);

    e n(b bVar);
}
