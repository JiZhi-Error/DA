package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.k;

public final class al<T extends h> {
    public static final a ThI = new a((byte) 0);
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(al.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    private final f ThE;
    private final e ThF;
    private final kotlin.g.a.b<i, T> ThG;
    private final i ThH;

    static {
        AppMethodBeat.i(56881);
        AppMethodBeat.o(56881);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.m.a.i, ? extends T extends kotlin.l.b.a.b.j.f.h> */
    /* JADX WARN: Multi-variable type inference failed */
    private al(e eVar, j jVar, kotlin.g.a.b<? super i, ? extends T> bVar, i iVar) {
        AppMethodBeat.i(56883);
        this.ThF = eVar;
        this.ThG = bVar;
        this.ThH = iVar;
        this.ThE = jVar.al(new b(this));
        AppMethodBeat.o(56883);
    }

    public /* synthetic */ al(e eVar, j jVar, kotlin.g.a.b bVar, i iVar, byte b2) {
        this(eVar, jVar, bVar, iVar);
    }

    public final T b(i iVar) {
        AppMethodBeat.i(56882);
        p.h(iVar, "kotlinTypeRefiner");
        iVar.f(kotlin.l.b.a.b.j.d.a.F(this.ThF));
        T t = (T) ((h) kotlin.l.b.a.b.l.i.a(this.ThE, cLI[0]));
        AppMethodBeat.o(56882);
        return t;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <T extends h> al<T> a(e eVar, j jVar, i iVar, kotlin.g.a.b<? super i, ? extends T> bVar) {
            AppMethodBeat.i(56879);
            p.h(eVar, "classDescriptor");
            p.h(jVar, "storageManager");
            p.h(iVar, "kotlinTypeRefinerForOwnerModule");
            p.h(bVar, "scopeFactory");
            al<T> alVar = new al<>(eVar, jVar, bVar, iVar, (byte) 0);
            AppMethodBeat.o(56879);
            return alVar;
        }
    }

    static final class b extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ al ThJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(al alVar) {
            super(0);
            this.ThJ = alVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(56880);
            h hVar = (h) this.ThJ.ThG.invoke(this.ThJ.ThH);
            AppMethodBeat.o(56880);
            return hVar;
        }
    }
}
