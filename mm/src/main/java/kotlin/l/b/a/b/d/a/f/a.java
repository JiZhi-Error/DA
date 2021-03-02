package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.m.ab;

final class a implements c {
    public static final a TtG = new a();

    static {
        AppMethodBeat.i(58015);
        AppMethodBeat.o(58015);
    }

    private a() {
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final b hBk() {
        AppMethodBeat.i(58016);
        b b2 = c.a.b(this);
        AppMethodBeat.o(58016);
        return b2;
    }

    private static Void hDX() {
        AppMethodBeat.i(58011);
        IllegalStateException illegalStateException = new IllegalStateException("No methods should be called on this descriptor. Only its presence matters".toString());
        AppMethodBeat.o(58011);
        throw illegalStateException;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final ab hBy() {
        AppMethodBeat.i(58012);
        hDX();
        AppMethodBeat.o(58012);
        throw null;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final Map<f, g<?>> hBO() {
        AppMethodBeat.i(58013);
        hDX();
        AppMethodBeat.o(58013);
        throw null;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final an hzM() {
        AppMethodBeat.i(58014);
        hDX();
        AppMethodBeat.o(58014);
        throw null;
    }

    public final String toString() {
        return "[EnhancedType]";
    }
}
