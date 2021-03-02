package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public abstract class ay {
    public static final ay TOD = new b();
    public static final a TOE = new a((byte) 0);

    public abstract av N(ab abVar);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b extends ay {
        b() {
        }

        @Override // kotlin.l.b.a.b.m.ay
        public final /* synthetic */ av N(ab abVar) {
            AppMethodBeat.i(60842);
            p.h(abVar, "key");
            AppMethodBeat.o(60842);
            return null;
        }

        @Override // kotlin.l.b.a.b.m.ay
        public final boolean isEmpty() {
            return true;
        }

        public final String toString() {
            return "Empty TypeSubstitution";
        }
    }

    public ab a(ab abVar, bh bhVar) {
        p.h(abVar, "topLevelType");
        p.h(bhVar, "position");
        return abVar;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean hLy() {
        return false;
    }

    public boolean hKG() {
        return false;
    }

    public g h(g gVar) {
        p.h(gVar, "annotations");
        return gVar;
    }

    public final ba hLJ() {
        ba d2 = ba.d(this);
        p.g(d2, "TypeSubstitutor.create(this)");
        return d2;
    }
}
