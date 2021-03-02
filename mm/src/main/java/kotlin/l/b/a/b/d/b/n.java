package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.k.a.u;

public interface n extends u {
    a a(g gVar);

    a c(kotlin.l.b.a.b.f.a aVar);

    public static abstract class a {

        /* renamed from: kotlin.l.b.a.b.d.b.n$a$a  reason: collision with other inner class name */
        public static final class C2298a extends a {
            public final byte[] content;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(58219);
                if (this == obj || ((obj instanceof C2298a) && p.j(this.content, ((C2298a) obj).content))) {
                    AppMethodBeat.o(58219);
                    return true;
                }
                AppMethodBeat.o(58219);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(58218);
                byte[] bArr = this.content;
                if (bArr != null) {
                    int hashCode = Arrays.hashCode(bArr);
                    AppMethodBeat.o(58218);
                    return hashCode;
                }
                AppMethodBeat.o(58218);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(58217);
                String str = "ClassFileContent(content=" + Arrays.toString(this.content) + ")";
                AppMethodBeat.o(58217);
                return str;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final p hEo() {
            a aVar;
            if (!(this instanceof b)) {
                aVar = null;
            } else {
                aVar = this;
            }
            b bVar = (b) aVar;
            if (bVar != null) {
                return bVar.TvO;
            }
            return null;
        }

        public static final class b extends a {
            final p TvO;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(58223);
                if (this == obj || ((obj instanceof b) && p.j(this.TvO, ((b) obj).TvO))) {
                    AppMethodBeat.o(58223);
                    return true;
                }
                AppMethodBeat.o(58223);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(58222);
                p pVar = this.TvO;
                if (pVar != null) {
                    int hashCode = pVar.hashCode();
                    AppMethodBeat.o(58222);
                    return hashCode;
                }
                AppMethodBeat.o(58222);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(58221);
                String str = "KotlinClass(kotlinJvmBinaryClass=" + this.TvO + ")";
                AppMethodBeat.o(58221);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(p pVar) {
                super((byte) 0);
                p.h(pVar, "kotlinJvmBinaryClass");
                AppMethodBeat.i(58220);
                this.TvO = pVar;
                AppMethodBeat.o(58220);
            }
        }
    }
}
