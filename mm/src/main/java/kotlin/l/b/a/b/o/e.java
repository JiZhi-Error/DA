package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

public final class e {
    public static final e TRO = new e(g.WARN, null, ae.emptyMap(), (byte) 0);
    public static final e TRP;
    public static final e TRQ;
    public static final a TRR = new a((byte) 0);
    private final f TRJ;
    public final g TRK;
    public final g TRL;
    public final Map<String, g> TRM;
    public final boolean TRN;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r3.TRN == r4.TRN) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 61368(0xefb8, float:8.5995E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0032
            boolean r0 = r4 instanceof kotlin.l.b.a.b.o.e
            if (r0 == 0) goto L_0x0037
            kotlin.l.b.a.b.o.e r4 = (kotlin.l.b.a.b.o.e) r4
            kotlin.l.b.a.b.o.g r0 = r3.TRK
            kotlin.l.b.a.b.o.g r1 = r4.TRK
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            kotlin.l.b.a.b.o.g r0 = r3.TRL
            kotlin.l.b.a.b.o.g r1 = r4.TRL
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            java.util.Map<java.lang.String, kotlin.l.b.a.b.o.g> r0 = r3.TRM
            java.util.Map<java.lang.String, kotlin.l.b.a.b.o.g> r1 = r4.TRM
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            boolean r0 = r3.TRN
            boolean r1 = r4.TRN
            if (r0 != r1) goto L_0x0037
        L_0x0032:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0036:
            return r0
        L_0x0037:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.o.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(61367);
        g gVar = this.TRK;
        int hashCode = (gVar != null ? gVar.hashCode() : 0) * 31;
        g gVar2 = this.TRL;
        int hashCode2 = ((gVar2 != null ? gVar2.hashCode() : 0) + hashCode) * 31;
        Map<String, g> map = this.TRM;
        if (map != null) {
            i2 = map.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.TRN;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = i4 + i3;
        AppMethodBeat.o(61367);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(61366);
        String str = "Jsr305State(global=" + this.TRK + ", migration=" + this.TRL + ", user=" + this.TRM + ", enableCompatqualCheckerFrameworkAnnotations=" + this.TRN + ")";
        AppMethodBeat.o(61366);
        return str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Map<java.lang.String, ? extends kotlin.l.b.a.b.o.g> */
    /* JADX WARN: Multi-variable type inference failed */
    private e(g gVar, g gVar2, Map<String, ? extends g> map) {
        p.h(gVar, "global");
        p.h(map, "user");
        AppMethodBeat.i(61365);
        this.TRK = gVar;
        this.TRL = gVar2;
        this.TRM = map;
        this.TRN = true;
        this.TRJ = g.ah(new b(this));
        AppMethodBeat.o(61365);
    }

    private /* synthetic */ e(g gVar, g gVar2, Map map, byte b2) {
        this(gVar, gVar2, map);
    }

    public final boolean hLT() {
        return this == TRP;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(61364);
        g gVar = g.IGNORE;
        TRP = new e(gVar, gVar, ae.emptyMap(), (byte) 0);
        g gVar2 = g.STRICT;
        TRQ = new e(gVar2, gVar2, ae.emptyMap(), (byte) 0);
        AppMethodBeat.o(61364);
    }

    static final class b extends q implements kotlin.g.a.a<String[]> {
        final /* synthetic */ e TRS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar) {
            super(0);
            this.TRS = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String[] invoke() {
            AppMethodBeat.i(61363);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.TRS.TRK.description);
            g gVar = this.TRS.TRL;
            if (gVar != null) {
                arrayList.add("under-migration:" + gVar.description);
            }
            for (Map.Entry<String, g> entry : this.TRS.TRM.entrySet()) {
                arrayList.add("@" + entry.getKey() + ':' + entry.getValue().description);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(61363);
                throw tVar;
            }
            String[] strArr = (String[]) array;
            AppMethodBeat.o(61363);
            return strArr;
        }
    }
}
