package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;

public interface u {
    List<String> btQ(String str);

    public static final class a implements u {
        public static final a TvR = new a();

        static {
            AppMethodBeat.i(58248);
            AppMethodBeat.o(58248);
        }

        private a() {
        }

        @Override // kotlin.l.b.a.b.d.b.u
        public final List<String> btQ(String str) {
            AppMethodBeat.i(58247);
            p.h(str, "packageFqName");
            v vVar = v.SXr;
            AppMethodBeat.o(58247);
            return vVar;
        }
    }
}
