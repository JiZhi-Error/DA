package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;

public final class q {
    public static final String x(f fVar) {
        AppMethodBeat.i(59869);
        p.h(fVar, "$this$render");
        if (y(fVar)) {
            StringBuilder sb = new StringBuilder();
            String sG = fVar.sG();
            p.g(sG, "asString()");
            String sb2 = sb.append("`".concat(String.valueOf(sG))).append('`').toString();
            AppMethodBeat.o(59869);
            return sb2;
        }
        String sG2 = fVar.sG();
        p.g(sG2, "asString()");
        AppMethodBeat.o(59869);
        return sG2;
    }

    public static final String g(c cVar) {
        AppMethodBeat.i(59871);
        p.h(cVar, "$this$render");
        List<f> hJl = cVar.hJl();
        p.g(hJl, "pathSegments()");
        String kH = kH(hJl);
        AppMethodBeat.o(59871);
        return kH;
    }

    public static final String kH(List<f> list) {
        AppMethodBeat.i(59872);
        p.h(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(x(fVar));
        }
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(59872);
        return sb2;
    }

    private static final boolean y(f fVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(59870);
        if (fVar.TDa) {
            AppMethodBeat.o(59870);
            return false;
        }
        String sG = fVar.sG();
        p.g(sG, "asString()");
        if (!l.TGW.contains(sG)) {
            String str = sG;
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = false;
                    break;
                }
                char charAt = str.charAt(i2);
                if (Character.isLetterOrDigit(charAt) || charAt == '_') {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                AppMethodBeat.o(59870);
                return false;
            }
        }
        AppMethodBeat.o(59870);
        return true;
    }
}
