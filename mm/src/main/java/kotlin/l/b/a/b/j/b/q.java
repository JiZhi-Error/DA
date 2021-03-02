package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public final class q implements at {
    public final ArrayList<ab> TII;
    private final y Tfp;
    private final long value;

    @Override // kotlin.l.b.a.b.m.at
    public final /* bridge */ /* synthetic */ h hzS() {
        return null;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final Collection<ab> hBV() {
        return this.TII;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final g hBh() {
        AppMethodBeat.i(60090);
        g hBh = this.Tfp.hBh();
        AppMethodBeat.o(60090);
        return hBh;
    }

    public final String toString() {
        AppMethodBeat.i(60091);
        String str = "IntegerValueType(" + this.value + ')';
        AppMethodBeat.o(60091);
        return str;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        return v.SXr;
    }
}
