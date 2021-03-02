package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public final class f {
    private static final f Uoc = new f();
    static final b Uoi = new b() {
        /* class rx.d.f.AnonymousClass1 */
    };
    private final AtomicReference<b> Uod = new AtomicReference<>();
    private final AtomicReference<d> Uoe = new AtomicReference<>();
    private final AtomicReference<h> Uof = new AtomicReference<>();
    private final AtomicReference<a> Uog = new AtomicReference<>();
    private final AtomicReference<g> Uoh = new AtomicReference<>();

    static {
        AppMethodBeat.i(90495);
        AppMethodBeat.o(90495);
    }

    @Deprecated
    public static f hQW() {
        return Uoc;
    }

    f() {
        AppMethodBeat.i(90488);
        AppMethodBeat.o(90488);
    }

    public final b hQX() {
        AppMethodBeat.i(90489);
        if (this.Uod.get() == null) {
            Object a2 = a(b.class, System.getProperties());
            if (a2 == null) {
                this.Uod.compareAndSet(null, Uoi);
            } else {
                this.Uod.compareAndSet(null, (b) a2);
            }
        }
        b bVar = this.Uod.get();
        AppMethodBeat.o(90489);
        return bVar;
    }

    public final d hQY() {
        AppMethodBeat.i(90490);
        if (this.Uoe.get() == null) {
            Object a2 = a(d.class, System.getProperties());
            if (a2 == null) {
                this.Uoe.compareAndSet(null, e.hQV());
            } else {
                this.Uoe.compareAndSet(null, (d) a2);
            }
        }
        d dVar = this.Uoe.get();
        AppMethodBeat.o(90490);
        return dVar;
    }

    public final h hQZ() {
        AppMethodBeat.i(90491);
        if (this.Uof.get() == null) {
            Object a2 = a(h.class, System.getProperties());
            if (a2 == null) {
                this.Uof.compareAndSet(null, i.hRg());
            } else {
                this.Uof.compareAndSet(null, (h) a2);
            }
        }
        h hVar = this.Uof.get();
        AppMethodBeat.o(90491);
        return hVar;
    }

    public final a hRa() {
        AppMethodBeat.i(90492);
        if (this.Uog.get() == null) {
            Object a2 = a(a.class, System.getProperties());
            if (a2 == null) {
                this.Uog.compareAndSet(null, new a() {
                    /* class rx.d.f.AnonymousClass2 */
                });
            } else {
                this.Uog.compareAndSet(null, (a) a2);
            }
        }
        a aVar = this.Uog.get();
        AppMethodBeat.o(90492);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c5 A[SYNTHETIC, Splitter:B:17:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object a(java.lang.Class<?> r11, java.util.Properties r12) {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.d.f.a(java.lang.Class, java.util.Properties):java.lang.Object");
    }

    public final g hRb() {
        AppMethodBeat.i(90494);
        if (this.Uoh.get() == null) {
            Object a2 = a(g.class, System.getProperties());
            if (a2 == null) {
                this.Uoh.compareAndSet(null, g.hRf());
            } else {
                this.Uoh.compareAndSet(null, (g) a2);
            }
        }
        g gVar = this.Uoh.get();
        AppMethodBeat.o(90494);
        return gVar;
    }
}
