package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;

public final class a extends kotlin.l.b.a.b.k.a {
    public static final a TLQ = new a();

    static {
        AppMethodBeat.i(60386);
        AppMethodBeat.o(60386);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a() {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.a.a.<init>():void");
    }

    public static String r(b bVar) {
        AppMethodBeat.i(60384);
        if (bVar.isRoot()) {
            AppMethodBeat.o(60384);
            return "default-package";
        }
        String sG = bVar.hJg().sG();
        p.g(sG, "fqName.shortName().asString()");
        AppMethodBeat.o(60384);
        return sG;
    }
}
