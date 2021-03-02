package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;

public abstract class z {
    public final c SZH;
    public final h SZI;
    public final an Tik;

    public abstract kotlin.l.b.a.b.f.b hLf();

    private z(c cVar, h hVar, an anVar) {
        this.SZH = cVar;
        this.SZI = hVar;
        this.Tik = anVar;
    }

    public /* synthetic */ z(c cVar, h hVar, an anVar, byte b2) {
        this(cVar, hVar, anVar);
    }

    public static final class a extends z {
        final a.b TKA;
        public final a.b.EnumC2306b TLA;
        public final a TLB;
        public final kotlin.l.b.a.b.f.a Tfj;
        public final boolean Thz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(a.b bVar, c cVar, h hVar, an anVar, a aVar) {
            super(cVar, hVar, anVar, (byte) 0);
            p.h(bVar, "classProto");
            p.h(cVar, "nameResolver");
            p.h(hVar, "typeTable");
            AppMethodBeat.i(60347);
            this.TKA = bVar;
            this.TLB = aVar;
            this.Tfj = x.a(cVar, this.TKA.Txs);
            a.b.EnumC2306b bVar2 = kotlin.l.b.a.b.e.b.b.TAY.get(this.TKA.Txb);
            this.TLA = bVar2 == null ? a.b.EnumC2306b.CLASS : bVar2;
            Boolean avk = kotlin.l.b.a.b.e.b.b.TAZ.avk(this.TKA.Txb);
            p.g(avk, "Flags.IS_INNER.get(classProto.flags)");
            this.Thz = avk.booleanValue();
            AppMethodBeat.o(60347);
        }

        @Override // kotlin.l.b.a.b.k.a.z
        public final kotlin.l.b.a.b.f.b hLf() {
            AppMethodBeat.i(60346);
            kotlin.l.b.a.b.f.b hJd = this.Tfj.hJd();
            p.g(hJd, "classId.asSingleFqName()");
            AppMethodBeat.o(60346);
            return hJd;
        }
    }

    public static final class b extends z {
        private final kotlin.l.b.a.b.f.b TiI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(kotlin.l.b.a.b.f.b bVar, c cVar, h hVar, an anVar) {
            super(cVar, hVar, anVar, (byte) 0);
            p.h(bVar, "fqName");
            p.h(cVar, "nameResolver");
            p.h(hVar, "typeTable");
            AppMethodBeat.i(60348);
            this.TiI = bVar;
            AppMethodBeat.o(60348);
        }

        @Override // kotlin.l.b.a.b.k.a.z
        public final kotlin.l.b.a.b.f.b hLf() {
            return this.TiI;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + hLf();
    }
}
