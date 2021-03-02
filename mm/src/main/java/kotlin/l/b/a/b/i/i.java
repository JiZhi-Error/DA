package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.l.b.a.b.f.b;

public interface i {
    void D(Set<b> set);

    void E(Set<? extends h> set);

    void EK(boolean z);

    void EL(boolean z);

    void EM(boolean z);

    void EN(boolean z);

    void EO(boolean z);

    void EP(boolean z);

    void EQ(boolean z);

    void a(a aVar);

    void a(b bVar);

    void a(n nVar);

    void a(p pVar);

    a hJV();

    boolean hJW();

    boolean hJX();

    Set<b> hJY();

    void setDebugMode(boolean z);

    public static final class a {
        public static boolean a(i iVar) {
            AppMethodBeat.i(59803);
            boolean z = iVar.hJV().TEW;
            AppMethodBeat.o(59803);
            return z;
        }

        public static boolean b(i iVar) {
            AppMethodBeat.i(59804);
            boolean z = iVar.hJV().TEX;
            AppMethodBeat.o(59804);
            return z;
        }
    }
}
