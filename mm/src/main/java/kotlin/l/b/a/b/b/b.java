package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public interface b extends a, v {
    b a(l lVar, w wVar, ba baVar, a aVar);

    a hAA();

    @Override // kotlin.l.b.a.b.b.a
    Collection<? extends b> hAy();

    b hAz();

    void x(Collection<? extends b> collection);

    public enum a {
        DECLARATION,
        FAKE_OVERRIDE,
        DELEGATION,
        SYNTHESIZED;

        public static a valueOf(String str) {
            AppMethodBeat.i(56828);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(56828);
            return aVar;
        }

        static {
            AppMethodBeat.i(56829);
            AppMethodBeat.o(56829);
        }

        public final boolean hAB() {
            return this != FAKE_OVERRIDE;
        }
    }
}
