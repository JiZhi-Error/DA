package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Set;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.f.f;

public interface h extends j {
    public static final a TJW = a.TJY;

    Collection<? extends ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar);

    @Override // kotlin.l.b.a.b.j.f.j
    Collection<? extends am> b(f fVar, kotlin.l.b.a.b.c.a.a aVar);

    Set<f> hCa();

    Set<f> hCb();

    public static final class b extends i {
        public static final b TKa = new b();

        static {
            AppMethodBeat.i(60216);
            AppMethodBeat.o(60216);
        }

        private b() {
        }

        @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Set<f> hCa() {
            return x.SXt;
        }

        @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Set<f> hCb() {
            return x.SXt;
        }
    }

    public static final class a {
        private static final kotlin.g.a.b<f, Boolean> TJX = C2348a.TJZ;
        static final /* synthetic */ a TJY = new a();

        /* renamed from: kotlin.l.b.a.b.j.f.h$a$a  reason: collision with other inner class name */
        static final class C2348a extends q implements kotlin.g.a.b<f, Boolean> {
            public static final C2348a TJZ = new C2348a();

            static {
                AppMethodBeat.i(60214);
                AppMethodBeat.o(60214);
            }

            C2348a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(f fVar) {
                AppMethodBeat.i(60213);
                p.h(fVar, LocaleUtil.ITALIAN);
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(60213);
                return bool;
            }
        }

        static {
            AppMethodBeat.i(60215);
            AppMethodBeat.o(60215);
        }

        private a() {
        }

        public static kotlin.g.a.b<f, Boolean> hKZ() {
            return TJX;
        }
    }
}
