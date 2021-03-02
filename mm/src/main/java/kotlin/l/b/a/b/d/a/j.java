package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.b;

public interface j {
    g a(a aVar);

    t i(b bVar);

    Set<String> j(b bVar);

    public static final class a {
        public final kotlin.l.b.a.b.f.a Tfj;
        private final byte[] Tpa;
        private final g Tpb;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (kotlin.g.b.p.j(r3.Tpb, r4.Tpb) != false) goto L_0x002c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 57584(0xe0f0, float:8.0692E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002c
                boolean r0 = r4 instanceof kotlin.l.b.a.b.d.a.j.a
                if (r0 == 0) goto L_0x0031
                kotlin.l.b.a.b.d.a.j$a r4 = (kotlin.l.b.a.b.d.a.j.a) r4
                kotlin.l.b.a.b.f.a r0 = r3.Tfj
                kotlin.l.b.a.b.f.a r1 = r4.Tfj
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                byte[] r0 = r3.Tpa
                byte[] r1 = r4.Tpa
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                kotlin.l.b.a.b.d.a.e.g r0 = r3.Tpb
                kotlin.l.b.a.b.d.a.e.g r1 = r4.Tpb
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
            L_0x002c:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0030:
                return r0
            L_0x0031:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.j.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(57583);
            kotlin.l.b.a.b.f.a aVar = this.Tfj;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            byte[] bArr = this.Tpa;
            int hashCode2 = ((bArr != null ? Arrays.hashCode(bArr) : 0) + hashCode) * 31;
            g gVar = this.Tpb;
            if (gVar != null) {
                i2 = gVar.hashCode();
            }
            int i3 = hashCode2 + i2;
            AppMethodBeat.o(57583);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(57582);
            String str = "Request(classId=" + this.Tfj + ", previouslyFoundClassFileContent=" + Arrays.toString(this.Tpa) + ", outerClass=" + this.Tpb + ")";
            AppMethodBeat.o(57582);
            return str;
        }

        private a(kotlin.l.b.a.b.f.a aVar, byte[] bArr, g gVar) {
            p.h(aVar, "classId");
            AppMethodBeat.i(57580);
            this.Tfj = aVar;
            this.Tpa = bArr;
            this.Tpb = gVar;
            AppMethodBeat.o(57580);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(kotlin.l.b.a.b.f.a aVar, byte[] bArr, g gVar, int i2) {
            this(aVar, (i2 & 2) != 0 ? null : bArr, (i2 & 4) != 0 ? null : gVar);
            AppMethodBeat.i(57581);
            AppMethodBeat.o(57581);
        }
    }
}
