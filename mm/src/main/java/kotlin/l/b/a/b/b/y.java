package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public interface y extends l {
    <T> T a(a<T> aVar);

    Collection<b> a(b bVar, kotlin.g.a.b<? super f, Boolean> bVar2);

    boolean a(y yVar);

    ad e(b bVar);

    g hBh();

    List<y> hBi();

    public static final class a<T> {
        private final String name;

        public a(String str) {
            p.h(str, "name");
            AppMethodBeat.i(56864);
            this.name = str;
            AppMethodBeat.o(56864);
        }

        public final String toString() {
            return this.name;
        }
    }
}
