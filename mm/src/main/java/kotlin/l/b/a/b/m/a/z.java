package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.e.b;
import kotlin.n.n;

public final class z {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.l.b.a.b.m.ab a(kotlin.l.b.a.b.m.ab r11, kotlin.l.b.a.b.m.ab r12, kotlin.l.b.a.b.m.a.x r13) {
        /*
        // Method dump skipped, instructions count: 322
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.a.z.a(kotlin.l.b.a.b.m.ab, kotlin.l.b.a.b.m.ab, kotlin.l.b.a.b.m.a.x):kotlin.l.b.a.b.m.ab");
    }

    private static final ab aL(ab abVar) {
        AppMethodBeat.i(61192);
        T t = b.aP(abVar).TPZ;
        AppMethodBeat.o(61192);
        return t;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<String, StringBuilder> {
        final /* synthetic */ StringBuilder TPM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(StringBuilder sb) {
            super(1);
            this.TPM = sb;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ StringBuilder invoke(String str) {
            AppMethodBeat.i(61189);
            StringBuilder buq = buq(str);
            AppMethodBeat.o(61189);
            return buq;
        }

        public final StringBuilder buq(String str) {
            AppMethodBeat.i(61190);
            p.h(str, "$this$unaryPlus");
            StringBuilder append = this.TPM.append(str);
            p.g(append, "append(value)");
            StringBuilder i2 = n.i(append);
            AppMethodBeat.o(61190);
            return i2;
        }
    }

    private static final String e(at atVar) {
        AppMethodBeat.i(61193);
        StringBuilder sb = new StringBuilder();
        a aVar = new a(sb);
        aVar.buq("type: ".concat(String.valueOf(atVar)));
        aVar.buq("hashCode: " + atVar.hashCode());
        aVar.buq("javaClass: " + atVar.getClass().getCanonicalName());
        for (h hzS = atVar.hzS(); hzS != null; hzS = hzS.hzx()) {
            aVar.buq("fqName: " + c.TFg.k(hzS));
            aVar.buq("javaClass: " + hzS.getClass().getCanonicalName());
        }
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        AppMethodBeat.o(61193);
        return sb2;
    }
}
