package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.n.a.a;
import kotlin.n.n;

public final class s {
    private static f a(f fVar, boolean z) {
        AppMethodBeat.i(57622);
        p.h(fVar, "methodName");
        f a2 = a(fVar, "set", false, z ? "is" : null, 4);
        AppMethodBeat.o(57622);
        return a2;
    }

    private static /* synthetic */ f a(f fVar, String str, boolean z, String str2, int i2) {
        AppMethodBeat.i(57624);
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        f a2 = a(fVar, str, z, str2);
        AppMethodBeat.o(57624);
        return a2;
    }

    public static final List<f> i(f fVar) {
        AppMethodBeat.i(57625);
        p.h(fVar, "name");
        String sG = fVar.sG();
        p.g(sG, "name.asString()");
        if (o.btH(sG)) {
            p.h(fVar, "methodName");
            f a2 = a(fVar, "get", false, null, 12);
            if (a2 == null) {
                a2 = a(fVar, "is", false, null, 8);
            }
            List<f> eR = j.eR(a2);
            AppMethodBeat.o(57625);
            return eR;
        } else if (o.btI(sG)) {
            p.h(fVar, "methodName");
            List<f> ad = j.ad(a(fVar, false), a(fVar, true));
            AppMethodBeat.o(57625);
            return ad;
        } else {
            e eVar = e.ToV;
            List<f> h2 = e.h(fVar);
            AppMethodBeat.o(57625);
            return h2;
        }
    }

    private static final f a(f fVar, String str, boolean z, String str2) {
        AppMethodBeat.i(57623);
        if (fVar.TDa) {
            AppMethodBeat.o(57623);
            return null;
        }
        String identifier = fVar.getIdentifier();
        p.g(identifier, "methodName.identifier");
        if (!n.J(identifier, str, false)) {
            AppMethodBeat.o(57623);
            return null;
        } else if (identifier.length() == str.length()) {
            AppMethodBeat.o(57623);
            return null;
        } else {
            char charAt = identifier.charAt(str.length());
            if ('a' <= charAt && 'z' >= charAt) {
                AppMethodBeat.o(57623);
                return null;
            } else if (str2 != null) {
                if (!aa.SXc || z) {
                    f btY = f.btY(str2 + n.b(identifier, str));
                    AppMethodBeat.o(57623);
                    return btY;
                }
                AssertionError assertionError = new AssertionError("Assertion failed");
                AppMethodBeat.o(57623);
                throw assertionError;
            } else if (!z) {
                AppMethodBeat.o(57623);
                return fVar;
            } else {
                String bur = a.bur(n.b(identifier, str));
                if (!f.btZ(bur)) {
                    AppMethodBeat.o(57623);
                    return null;
                }
                f btY2 = f.btY(bur);
                AppMethodBeat.o(57623);
                return btY2;
            }
        }
    }
}
