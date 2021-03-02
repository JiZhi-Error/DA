package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.n.n;

public final class i<T> {
    private int TvC;
    private T TvD;
    private final l<T> TvE;

    public final void hEk() {
        if (this.TvD == null) {
            this.TvC++;
        }
    }

    public final void fs(T t) {
        AppMethodBeat.i(58197);
        p.h(t, "objectType");
        ft(t);
        AppMethodBeat.o(58197);
    }

    /* access modifiers changed from: package-private */
    public final void ft(T t) {
        AppMethodBeat.i(58198);
        p.h(t, "type");
        if (this.TvD == null) {
            if (this.TvC > 0) {
                t = this.TvE.btM(n.r("[", this.TvC) + this.TvE.toString(t));
            }
            this.TvD = t;
        }
        AppMethodBeat.o(58198);
    }
}
