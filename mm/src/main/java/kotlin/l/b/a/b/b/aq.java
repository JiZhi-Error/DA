package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.x;

public interface aq {
    Collection<ab> a(at atVar, Collection<? extends ab> collection, b<? super at, ? extends Iterable<? extends ab>> bVar, b<? super ab, x> bVar2);

    public static final class a implements aq {
        public static final a ThM = new a();

        static {
            AppMethodBeat.i(56886);
            AppMethodBeat.o(56886);
        }

        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Collection<? extends kotlin.l.b.a.b.m.ab> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.l.b.a.b.b.aq
        public final Collection<ab> a(at atVar, Collection<? extends ab> collection, b<? super at, ? extends Iterable<? extends ab>> bVar, b<? super ab, x> bVar2) {
            AppMethodBeat.i(56885);
            p.h(atVar, "currentTypeConstructor");
            p.h(collection, "superTypes");
            p.h(bVar, "neighbors");
            p.h(bVar2, "reportLoop");
            AppMethodBeat.o(56885);
            return collection;
        }
    }
}
