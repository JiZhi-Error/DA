package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.n.b;

public abstract class k implements b {
    private final kotlin.g.a.b<g, ab> TRm;
    private final String description;
    private final String name;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.a.g, ? extends kotlin.l.b.a.b.m.ab> */
    /* JADX WARN: Multi-variable type inference failed */
    private k(String str, kotlin.g.a.b<? super g, ? extends ab> bVar) {
        this.name = str;
        this.TRm = bVar;
        this.description = "must return " + this.name;
    }

    public /* synthetic */ k(String str, kotlin.g.a.b bVar, byte b2) {
        this(str, bVar);
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String i(t tVar) {
        p.h(tVar, "functionDescriptor");
        return b.a.a(this, tVar);
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String getDescription() {
        return this.description;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final boolean h(t tVar) {
        p.h(tVar, "functionDescriptor");
        return p.j(tVar.hAu(), this.TRm.invoke(kotlin.l.b.a.b.j.d.a.G(tVar)));
    }

    public static final class a extends k {
        public static final a TRn = new a();

        static {
            AppMethodBeat.i(61320);
            AppMethodBeat.o(61320);
        }

        private a() {
            super("Boolean", AnonymousClass1.TRo, (byte) 0);
            AppMethodBeat.i(61319);
            AppMethodBeat.o(61319);
        }
    }

    public static final class b extends k {
        public static final b TRp = new b();

        static {
            AppMethodBeat.i(61324);
            AppMethodBeat.o(61324);
        }

        private b() {
            super("Int", AnonymousClass1.TRq, (byte) 0);
            AppMethodBeat.i(61323);
            AppMethodBeat.o(61323);
        }
    }

    public static final class c extends k {
        public static final c TRr = new c();

        static {
            AppMethodBeat.i(61328);
            AppMethodBeat.o(61328);
        }

        private c() {
            super("Unit", AnonymousClass1.TRs, (byte) 0);
            AppMethodBeat.i(61327);
            AppMethodBeat.o(61327);
        }
    }
}
