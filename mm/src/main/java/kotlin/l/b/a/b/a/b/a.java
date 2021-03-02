package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.c.ae;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.e;
import kotlin.l.b.a.b.l.j;

public final class a extends e {
    private static final f TfJ;
    public static final C2274a TfK = new C2274a((byte) 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(j jVar, kotlin.l.b.a.b.b.e eVar) {
        super(jVar, eVar);
        p.h(jVar, "storageManager");
        p.h(eVar, "containingClass");
        AppMethodBeat.i(56745);
        AppMethodBeat.o(56745);
    }

    /* renamed from: kotlin.l.b.a.b.a.b.a$a  reason: collision with other inner class name */
    public static final class C2274a {
        private C2274a() {
        }

        public /* synthetic */ C2274a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(56746);
        f btY = f.btY("clone");
        p.g(btY, "Name.identifier(\"clone\")");
        TfJ = btY;
        AppMethodBeat.o(56746);
    }

    @Override // kotlin.l.b.a.b.j.f.e
    public final List<t> hzW() {
        AppMethodBeat.i(56744);
        g.a aVar = g.TiC;
        ae a2 = ae.a(this.TJS, g.a.hBP(), TfJ, b.a.DECLARATION, an.ThK);
        a2.b(null, this.TJS.hAO(), v.SXr, v.SXr, kotlin.l.b.a.b.j.d.a.G(this.TJS).hzi(), w.OPEN, az.ThS);
        List<t> listOf = kotlin.a.j.listOf(a2);
        AppMethodBeat.o(56744);
        return listOf;
    }
}
