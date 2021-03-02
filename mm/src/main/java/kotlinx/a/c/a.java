package kotlinx.a.c;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.c.a.l;
import kotlinx.a.c.a.r;
import kotlinx.a.c.d;
import kotlinx.a.d.b;
import kotlinx.a.d.c;
import kotlinx.a.d.e;
import kotlinx.a.f;

public final class a {
    private static final a TZg = new a(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
    private static final a TZh = new a(new d(false, true, true, true, false, false, true, null, true, null, null, 1713));
    private static final a TZi = new a(new d(false, false, false, false, false, true, false, null, true, null, null, 1759));
    private static final a TZj = new a(new d(false, true, true, true, false, false, false, null, true, null, null, 1777));
    private static final a TZk = new a(d.TZC);
    public static final C2377a TZl = new C2377a((byte) 0);
    public final b TZe;
    public final d TZf;

    private a(d dVar, b bVar) {
        p.h(dVar, "configuration");
        p.h(bVar, "context");
        AppMethodBeat.i(225752);
        this.TZf = dVar;
        b bVar2 = n.TZN;
        p.h(bVar, "$this$plus");
        p.h(bVar2, FacebookRequestErrorClassification.KEY_OTHER);
        this.TZe = c.Y(new e.a(bVar, bVar2));
        if (!this.TZf.TZy) {
            this.TZe.a(new kotlinx.a.c.a.b(this.TZf.TZz));
        }
        AppMethodBeat.o(225752);
    }

    private /* synthetic */ a(d dVar) {
        this(dVar, kotlinx.a.d.a.UaI);
        AppMethodBeat.i(225753);
        AppMethodBeat.o(225753);
    }

    public a() {
        this(new d(false, false, false, false, false, false, false, null, true, null, null, 1791));
        AppMethodBeat.i(225754);
        AppMethodBeat.o(225754);
    }

    public final <T> T a(f<T> fVar, String str) {
        boolean z;
        AppMethodBeat.i(225751);
        p.h(fVar, "deserializer");
        p.h(str, "string");
        kotlinx.a.c.a.f fVar2 = new kotlinx.a.c.a.f(str);
        T t = (T) kotlinx.a.e.c(new l(this, r.OBJ, fVar2), fVar);
        if (fVar2.Ual == 12) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException("Reader has not consumed the whole input: ".concat(String.valueOf(fVar2)).toString());
            AppMethodBeat.o(225751);
            throw illegalStateException;
        }
        AppMethodBeat.o(225751);
        return t;
    }

    /* renamed from: kotlinx.a.c.a$a */
    public static final class C2377a {
        private C2377a() {
        }

        public /* synthetic */ C2377a(byte b2) {
            this();
        }

        public static <T> T a(f<T> fVar, String str) {
            AppMethodBeat.i(225814);
            p.h(fVar, "deserializer");
            p.h(str, "string");
            T t = (T) a.TZk.a(fVar, str);
            AppMethodBeat.o(225814);
            return t;
        }
    }

    static {
        AppMethodBeat.i(225755);
        d.a aVar = d.TZE;
        AppMethodBeat.o(225755);
    }
}
