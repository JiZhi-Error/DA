package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ServiceLoader;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.ac;

public interface a {
    public static final C2270a Tcu = C2270a.Tcw;

    ac hyY();

    /* renamed from: kotlin.l.b.a.b.a.a$a  reason: collision with other inner class name */
    public static final class C2270a {
        private static final f Tcv = g.a(k.PUBLICATION, C2271a.Tcx);
        static final /* synthetic */ C2270a Tcw = new C2270a();

        public static a hyZ() {
            AppMethodBeat.i(56650);
            a aVar = (a) Tcv.getValue();
            AppMethodBeat.o(56650);
            return aVar;
        }

        static {
            AppMethodBeat.i(56649);
            AppMethodBeat.o(56649);
        }

        private C2270a() {
        }

        /* renamed from: kotlin.l.b.a.b.a.a$a$a  reason: collision with other inner class name */
        static final class C2271a extends q implements kotlin.g.a.a<a> {
            public static final C2271a Tcx = new C2271a();

            static {
                AppMethodBeat.i(56648);
                AppMethodBeat.o(56648);
            }

            C2271a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ a invoke() {
                AppMethodBeat.i(56647);
                ServiceLoader load = ServiceLoader.load(a.class, a.class.getClassLoader());
                p.g(load, "implementations");
                a aVar = (a) j.f(load);
                if (aVar == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
                    AppMethodBeat.o(56647);
                    throw illegalStateException;
                }
                AppMethodBeat.o(56647);
                return aVar;
            }
        }
    }
}
