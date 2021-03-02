package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;

public final class q extends ay {
    public static final a TNI = new a((byte) 0);
    private final ay TNG;
    private final ay TNH;

    static {
        AppMethodBeat.i(60647);
        AppMethodBeat.o(60647);
    }

    private /* synthetic */ q(ay ayVar, ay ayVar2, byte b2) {
        this(ayVar, ayVar2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private q(ay ayVar, ay ayVar2) {
        this.TNG = ayVar;
        this.TNH = ayVar2;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final av N(ab abVar) {
        AppMethodBeat.i(60642);
        p.h(abVar, "key");
        av N = this.TNG.N(abVar);
        if (N == null) {
            N = this.TNH.N(abVar);
        }
        AppMethodBeat.o(60642);
        return N;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final ab a(ab abVar, bh bhVar) {
        AppMethodBeat.i(60643);
        p.h(abVar, "topLevelType");
        p.h(bhVar, "position");
        ab a2 = this.TNH.a(this.TNG.a(abVar, bhVar), bhVar);
        AppMethodBeat.o(60643);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean isEmpty() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean hLy() {
        AppMethodBeat.i(60644);
        if (this.TNG.hLy() || this.TNH.hLy()) {
            AppMethodBeat.o(60644);
            return true;
        }
        AppMethodBeat.o(60644);
        return false;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final boolean hKG() {
        AppMethodBeat.i(60645);
        if (this.TNG.hKG() || this.TNH.hKG()) {
            AppMethodBeat.o(60645);
            return true;
        }
        AppMethodBeat.o(60645);
        return false;
    }

    @Override // kotlin.l.b.a.b.m.ay
    public final g h(g gVar) {
        AppMethodBeat.i(60646);
        p.h(gVar, "annotations");
        g h2 = this.TNH.h(this.TNG.h(gVar));
        AppMethodBeat.o(60646);
        return h2;
    }

    public static final ay a(ay ayVar, ay ayVar2) {
        AppMethodBeat.i(60648);
        p.h(ayVar, "first");
        p.h(ayVar2, "second");
        if (ayVar.isEmpty()) {
            AppMethodBeat.o(60648);
            return ayVar2;
        } else if (ayVar2.isEmpty()) {
            AppMethodBeat.o(60648);
            return ayVar;
        } else {
            q qVar = new q(ayVar, ayVar2, (byte) 0);
            AppMethodBeat.o(60648);
            return qVar;
        }
    }
}
