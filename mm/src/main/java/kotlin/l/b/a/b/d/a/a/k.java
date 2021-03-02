package kotlin.l.b.a.b.d.a.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.m.ab;

public interface k {
    public static final k Tqq = new k() {
        /* class kotlin.l.b.a.b.d.a.a.k.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(57690);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = FirebaseAnalytics.b.METHOD;
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            switch (i2) {
                case 5:
                case 6:
                    objArr[2] = "reportSignatureErrors";
                    break;
                default:
                    objArr[2] = "resolvePropagatedSignature";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(57690);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.d.a.a.k
        public final a a(q qVar, e eVar, ab abVar, List<av> list, List<as> list2) {
            AppMethodBeat.i(57688);
            if (qVar == null) {
                atM(0);
            }
            if (eVar == null) {
                atM(1);
            }
            if (abVar == null) {
                atM(2);
            }
            if (list == null) {
                atM(3);
            }
            if (list2 == null) {
                atM(4);
            }
            a aVar = new a(abVar, list, list2, Collections.emptyList());
            AppMethodBeat.o(57688);
            return aVar;
        }

        @Override // kotlin.l.b.a.b.d.a.a.k
        public final void a(b bVar, List<String> list) {
            AppMethodBeat.i(57689);
            if (bVar == null) {
                atM(5);
            }
            if (list == null) {
                atM(6);
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
            AppMethodBeat.o(57689);
            throw unsupportedOperationException;
        }
    };

    a a(q qVar, e eVar, ab abVar, List<av> list, List<as> list2);

    void a(b bVar, List<String> list);

    public static class a {
        public final List<as> Thx;
        public final boolean TkV;
        public final ab Tmg;
        public final ab Tqr;
        public final List<av> Tqs;
        public final List<String> Tqt;

        public static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57692);
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            switch (i2) {
                case 4:
                    objArr[1] = "getReturnType";
                    break;
                case 5:
                    objArr[1] = "getValueParameters";
                    break;
                case 6:
                    objArr[1] = "getTypeParameters";
                    break;
                case 7:
                    objArr[1] = "getErrors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
            }
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 4:
                case 5:
                case 6:
                case 7:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57692);
            throw illegalStateException;
        }

        public a(ab abVar, List<av> list, List<as> list2, List<String> list3) {
            if (abVar == null) {
                atM(0);
            }
            if (list == null) {
                atM(1);
            }
            if (list2 == null) {
                atM(2);
            }
            if (list3 == null) {
                atM(3);
            }
            AppMethodBeat.i(57691);
            this.Tmg = abVar;
            this.Tqr = null;
            this.Tqs = list;
            this.Thx = list2;
            this.Tqt = list3;
            this.TkV = false;
            AppMethodBeat.o(57691);
        }
    }
}
