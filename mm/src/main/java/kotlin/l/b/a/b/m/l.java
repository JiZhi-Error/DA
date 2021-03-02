package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.c.e;

public final class l extends n implements e, k {
    public static final a TNF = new a((byte) 0);
    final aj TNE;

    static {
        AppMethodBeat.i(60631);
        AppMethodBeat.o(60631);
    }

    private l(aj ajVar) {
        this.TNE = ajVar;
    }

    public /* synthetic */ l(aj ajVar, byte b2) {
        this(ajVar);
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg EF(boolean z) {
        AppMethodBeat.i(60628);
        aj EG = EG(z);
        AppMethodBeat.o(60628);
        return EG;
    }

    @Override // kotlin.l.b.a.b.m.bg
    public final /* synthetic */ bg b(g gVar) {
        AppMethodBeat.i(60625);
        l g2 = g(gVar);
        AppMethodBeat.o(60625);
        return g2;
    }

    @Override // kotlin.l.b.a.b.m.n
    public final /* synthetic */ n b(aj ajVar) {
        AppMethodBeat.i(60630);
        p.h(ajVar, "delegate");
        l lVar = new l(ajVar);
        AppMethodBeat.o(60630);
        return lVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final /* synthetic */ aj d(g gVar) {
        AppMethodBeat.i(60626);
        l g2 = g(gVar);
        AppMethodBeat.o(60626);
        return g2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
            if (kotlin.l.b.a.b.m.a.q.d(r4) == false) goto L_0x0041;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static kotlin.l.b.a.b.m.l a(kotlin.l.b.a.b.m.bg r4) {
            /*
            // Method dump skipped, instructions count: 160
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.l.a.a(kotlin.l.b.a.b.m.bg):kotlin.l.b.a.b.m.l");
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.n
    public final aj hDW() {
        return this.TNE;
    }

    @Override // kotlin.l.b.a.b.m.n, kotlin.l.b.a.b.m.ab
    public final boolean hEa() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final ab Q(ab abVar) {
        AppMethodBeat.i(60623);
        p.h(abVar, "replacement");
        bg b2 = am.b(abVar.hLF());
        AppMethodBeat.o(60623);
        return b2;
    }

    private l g(g gVar) {
        AppMethodBeat.i(60624);
        p.h(gVar, "newAnnotations");
        l lVar = new l(this.TNE.d(gVar));
        AppMethodBeat.o(60624);
        return lVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final aj EG(boolean z) {
        AppMethodBeat.i(60627);
        if (z) {
            aj EG = this.TNE.EG(z);
            AppMethodBeat.o(60627);
            return EG;
        }
        l lVar = this;
        AppMethodBeat.o(60627);
        return lVar;
    }

    @Override // kotlin.l.b.a.b.m.aj
    public final String toString() {
        AppMethodBeat.i(60629);
        String str = this.TNE + "!!";
        AppMethodBeat.o(60629);
        return str;
    }

    @Override // kotlin.l.b.a.b.m.k
    public final boolean hDZ() {
        AppMethodBeat.i(60622);
        if ((this.TNE.hKE() instanceof kotlin.l.b.a.b.m.a.p) || (this.TNE.hKE().hzS() instanceof as)) {
            AppMethodBeat.o(60622);
            return true;
        }
        AppMethodBeat.o(60622);
        return false;
    }
}
