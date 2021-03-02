package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.f.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.o.d;
import kotlin.n.n;

public final class aa {
    private static final <T> T a(l<T> lVar, T t, boolean z) {
        AppMethodBeat.i(58274);
        if (z) {
            T fu = lVar.fu(t);
            AppMethodBeat.o(58274);
            return fu;
        }
        AppMethodBeat.o(58274);
        return t;
    }

    public static /* synthetic */ Object a(ab abVar, l lVar, y yVar, w wVar) {
        AppMethodBeat.i(58276);
        Object a2 = a(abVar, lVar, yVar, wVar, null, d.hLS());
        AppMethodBeat.o(58276);
        return a2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x0008 */
    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: kotlin.l.b.a.b.d.b.l<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: kotlin.l.b.a.b.d.b.i<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011c, code lost:
        if (r1 == false) goto L_0x011e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0098 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0140  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(kotlin.l.b.a.b.m.ab r13, kotlin.l.b.a.b.d.b.l<T> r14, kotlin.l.b.a.b.d.b.y r15, kotlin.l.b.a.b.d.b.w<? extends T> r16, kotlin.l.b.a.b.d.b.i<T> r17, kotlin.g.a.q<? super kotlin.l.b.a.b.m.ab, ? super T, ? super kotlin.l.b.a.b.d.b.y, kotlin.x> r18) {
        /*
        // Method dump skipped, instructions count: 894
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.b.aa.a(kotlin.l.b.a.b.m.ab, kotlin.l.b.a.b.d.b.l, kotlin.l.b.a.b.d.b.y, kotlin.l.b.a.b.d.b.w, kotlin.l.b.a.b.d.b.i, kotlin.g.a.q):java.lang.Object");
    }

    public static final String a(e eVar, w<?> wVar) {
        l lVar;
        AppMethodBeat.i(58277);
        p.h(eVar, "klass");
        p.h(wVar, "typeMappingConfiguration");
        wVar.v(eVar);
        l hzx = eVar.hzx();
        p.g(hzx, "klass.containingDeclaration");
        f v = h.v(eVar.hAH());
        p.g(v, "SpecialNames.safeIdentifier(klass.name)");
        String identifier = v.getIdentifier();
        p.g(identifier, "SpecialNames.safeIdentifier(klass.name).identifier");
        if (hzx instanceof kotlin.l.b.a.b.b.ab) {
            b hBk = ((kotlin.l.b.a.b.b.ab) hzx).hBk();
            if (hBk.TCR.TCW.isEmpty()) {
                AppMethodBeat.o(58277);
                return identifier;
            }
            StringBuilder sb = new StringBuilder();
            String sG = hBk.sG();
            p.g(sG, "fqName.asString()");
            String sb2 = sb.append(n.a(sG, '.', '/')).append('/').append(identifier).toString();
            AppMethodBeat.o(58277);
            return sb2;
        }
        if (!(hzx instanceof e)) {
            lVar = null;
        } else {
            lVar = hzx;
        }
        e eVar2 = (e) lVar;
        if (eVar2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected container: " + hzx + " for " + eVar);
            AppMethodBeat.o(58277);
            throw illegalArgumentException;
        }
        wVar.u(eVar2);
        String str = a(eVar2, wVar) + '$' + identifier;
        AppMethodBeat.o(58277);
        return str;
    }
}
