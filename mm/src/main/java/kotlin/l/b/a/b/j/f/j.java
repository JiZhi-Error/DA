package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.a.b;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;

public interface j {
    Collection<l> a(d dVar, b<? super f, Boolean> bVar);

    Collection<? extends t> b(f fVar, kotlin.l.b.a.b.c.a.a aVar);

    h c(f fVar, kotlin.l.b.a.b.c.a.a aVar);

    public static final class a {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.l.b.a.b.j.f.j */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(j jVar, d dVar, b bVar, int i2) {
            AppMethodBeat.i(60217);
            if ((i2 & 1) != 0) {
                dVar = d.TJE;
            }
            if ((i2 & 2) != 0) {
                h.a aVar = h.TJW;
                bVar = h.a.hKZ();
            }
            Collection<l> a2 = jVar.a(dVar, bVar);
            AppMethodBeat.o(60217);
            return a2;
        }
    }
}
