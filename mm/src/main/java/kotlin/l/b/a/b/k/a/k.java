package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.h;
import kotlin.o;

public interface k {
    public static final a TKI = a.TKK;

    o<a.AbstractC2276a<?>, Object> a(a.h hVar, t tVar, h hVar2, ad adVar);

    public static final class a {
        private static final k TKJ = new C2356a();
        static final /* synthetic */ a TKK = new a();

        /* renamed from: kotlin.l.b.a.b.k.a.k$a$a  reason: collision with other inner class name */
        public static final class C2356a implements k {
            C2356a() {
            }

            @Override // kotlin.l.b.a.b.k.a.k
            public final o a(a.h hVar, t tVar, h hVar2, ad adVar) {
                AppMethodBeat.i(60301);
                p.h(hVar, "proto");
                p.h(tVar, "ownerFunction");
                p.h(hVar2, "typeTable");
                p.h(adVar, "typeDeserializer");
                AppMethodBeat.o(60301);
                return null;
            }
        }

        static {
            AppMethodBeat.i(60302);
            AppMethodBeat.o(60302);
        }

        private a() {
        }

        public static k hLd() {
            return TKJ;
        }
    }
}
