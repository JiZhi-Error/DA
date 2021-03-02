package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;
import kotlin.x;

public abstract class k extends g<x> {
    public static final a TIz = new a((byte) 0);

    public k() {
        super(x.SXb);
    }

    public static final class b extends k {
        private final String message;

        public b(String str) {
            p.h(str, "message");
            AppMethodBeat.i(60068);
            this.message = str;
            AppMethodBeat.o(60068);
        }

        @Override // kotlin.l.b.a.b.j.b.g
        public final /* synthetic */ ab b(y yVar) {
            AppMethodBeat.i(60067);
            p.h(yVar, "module");
            aj bun = u.bun(this.message);
            p.g(bun, "ErrorUtils.createErrorType(message)");
            aj ajVar = bun;
            AppMethodBeat.o(60067);
            return ajVar;
        }

        @Override // kotlin.l.b.a.b.j.b.g
        public final String toString() {
            return this.message;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static k bui(String str) {
            AppMethodBeat.i(60066);
            p.h(str, "message");
            b bVar = new b(str);
            AppMethodBeat.o(60066);
            return bVar;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.j.b.g
    public final /* synthetic */ x getValue() {
        throw new UnsupportedOperationException();
    }
}
