package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.n.n;
import kotlin.t;

public final class a implements kotlin.l.b.a.b.b.b.b {
    public static final C2272a Tfq = new C2272a((byte) 0);
    private final j TcN;
    private final y Tfp;

    static {
        AppMethodBeat.i(56715);
        AppMethodBeat.o(56715);
    }

    public a(j jVar, y yVar) {
        p.h(jVar, "storageManager");
        p.h(yVar, "module");
        AppMethodBeat.i(56714);
        this.TcN = jVar;
        this.Tfp = yVar;
        AppMethodBeat.o(56714);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        final b.c Tfr;
        final int arity;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.arity == r4.arity) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 56710(0xdd86, float:7.9468E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof kotlin.l.b.a.b.a.a.a.b
                if (r0 == 0) goto L_0x0023
                kotlin.l.b.a.b.a.a.a$b r4 = (kotlin.l.b.a.b.a.a.a.b) r4
                kotlin.l.b.a.b.a.a.b$c r0 = r3.Tfr
                kotlin.l.b.a.b.a.a.b$c r1 = r4.Tfr
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.arity
                int r1 = r4.arity
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.a.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(56709);
            b.c cVar = this.Tfr;
            int hashCode = ((cVar != null ? cVar.hashCode() : 0) * 31) + this.arity;
            AppMethodBeat.o(56709);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(56708);
            String str = "KindWithArity(kind=" + this.Tfr + ", arity=" + this.arity + ")";
            AppMethodBeat.o(56708);
            return str;
        }

        public b(b.c cVar, int i2) {
            p.h(cVar, "kind");
            AppMethodBeat.i(56707);
            this.Tfr = cVar;
            this.arity = i2;
            AppMethodBeat.o(56707);
        }
    }

    /* renamed from: kotlin.l.b.a.b.a.a.a$a  reason: collision with other inner class name */
    public static final class C2272a {
        private C2272a() {
        }

        public /* synthetic */ C2272a(byte b2) {
            this();
        }

        static b a(String str, kotlin.l.b.a.b.f.b bVar) {
            b.c cVar;
            boolean z;
            Integer valueOf;
            boolean z2;
            AppMethodBeat.i(56705);
            b.c.a aVar = b.c.TfH;
            p.h(bVar, "packageFqName");
            p.h(str, "className");
            b.c[] values = b.c.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    cVar = null;
                    break;
                }
                b.c cVar2 = values[i2];
                if (!p.j(cVar2.TfF, bVar) || !n.J(str, cVar2.TfG, false)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    cVar = cVar2;
                    break;
                }
                i2++;
            }
            if (cVar == null) {
                AppMethodBeat.o(56705);
                return null;
            }
            int length2 = cVar.TfG.length();
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(56705);
                throw tVar;
            }
            String substring = str.substring(length2);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                valueOf = null;
            } else {
                int length3 = substring.length();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= length3) {
                        valueOf = Integer.valueOf(i4);
                        break;
                    }
                    int charAt = substring.charAt(i3) - '0';
                    if (charAt < 0 || 9 < charAt) {
                        valueOf = null;
                    } else {
                        i3++;
                        i4 = charAt + (i4 * 10);
                    }
                }
            }
            if (valueOf != null) {
                b bVar2 = new b(cVar, valueOf.intValue());
                AppMethodBeat.o(56705);
                return bVar2;
            }
            AppMethodBeat.o(56705);
            return null;
        }

        public static b.c b(String str, kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(56706);
            p.h(str, "className");
            p.h(bVar, "packageFqName");
            b a2 = a(str, bVar);
            if (a2 != null) {
                b.c cVar = a2.Tfr;
                AppMethodBeat.o(56706);
                return cVar;
            }
            AppMethodBeat.o(56706);
            return null;
        }
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final boolean a(kotlin.l.b.a.b.f.b bVar, f fVar) {
        AppMethodBeat.i(56711);
        p.h(bVar, "packageFqName");
        p.h(fVar, "name");
        String sG = fVar.sG();
        p.g(sG, "name.asString()");
        if ((n.J(sG, "Function", false) || n.J(sG, "KFunction", false) || n.J(sG, "SuspendFunction", false) || n.J(sG, "KSuspendFunction", false)) && C2272a.a(sG, bVar) != null) {
            AppMethodBeat.o(56711);
            return true;
        }
        AppMethodBeat.o(56711);
        return false;
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final e b(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(56712);
        p.h(aVar, "classId");
        if (aVar.BPb || aVar.hJc()) {
            AppMethodBeat.o(56712);
            return null;
        }
        String sG = aVar.hIZ().sG();
        p.g(sG, "classId.relativeClassName.asString()");
        if (!n.a((CharSequence) sG, (CharSequence) "Function", false)) {
            AppMethodBeat.o(56712);
            return null;
        }
        kotlin.l.b.a.b.f.b hIY = aVar.hIY();
        p.g(hIY, "classId.packageFqName");
        b a2 = C2272a.a(sG, hIY);
        if (a2 == null) {
            AppMethodBeat.o(56712);
            return null;
        }
        b.c cVar = a2.Tfr;
        int i2 = a2.arity;
        ArrayList arrayList = new ArrayList();
        for (T t : this.Tfp.e(hIY).getFragments()) {
            if (t instanceof kotlin.l.b.a.b.a.b) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof kotlin.l.b.a.b.a.e) {
                arrayList3.add(obj);
            }
        }
        kotlin.l.b.a.b.a.e eVar = (kotlin.l.b.a.b.a.e) kotlin.a.j.kt(arrayList3);
        b bVar = new b(this.TcN, eVar != null ? eVar : (kotlin.l.b.a.b.a.b) kotlin.a.j.ks(arrayList2), cVar, i2);
        AppMethodBeat.o(56712);
        return bVar;
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final Collection<e> b(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56713);
        p.h(bVar, "packageFqName");
        x xVar = x.SXt;
        AppMethodBeat.o(56713);
        return xVar;
    }
}
