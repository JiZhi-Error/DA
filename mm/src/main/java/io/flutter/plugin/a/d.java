package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d {
    final l SSe;
    final String name;
    final c wJt;

    public interface a {
        void awU();

        void b(String str, String str2, Object obj);

        void ba(Object obj);
    }

    public interface c {
        void a(Object obj, a aVar);

        void sT();
    }

    public d(c cVar, String str) {
        this(cVar, str, o.SSr);
    }

    private d(c cVar, String str, l lVar) {
        this.wJt = cVar;
        this.name = str;
        this.SSe = lVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(9835);
        this.wJt.a(this.name, cVar == null ? null : new b(cVar));
        AppMethodBeat.o(9835);
    }

    final class b implements c.a {
        private final c SSf;
        final AtomicReference<a> SSg = new AtomicReference<>(null);

        b(c cVar) {
            AppMethodBeat.i(9843);
            this.SSf = cVar;
            AppMethodBeat.o(9843);
        }

        @Override // io.flutter.plugin.a.c.a
        public final void a(ByteBuffer byteBuffer, c.b bVar) {
            AppMethodBeat.i(9844);
            j K = d.this.SSe.K(byteBuffer);
            if (K.method.equals("listen")) {
                Object obj = K.SxX;
                a aVar = new a(this, (byte) 0);
                if (this.SSg.getAndSet(aVar) != null) {
                    try {
                        this.SSf.sT();
                    } catch (RuntimeException e2) {
                        new StringBuilder("EventChannel#").append(d.this.name);
                    }
                }
                try {
                    this.SSf.a(obj, aVar);
                    bVar.I(d.this.SSe.eQ(null));
                    AppMethodBeat.o(9844);
                } catch (RuntimeException e3) {
                    this.SSg.set(null);
                    new StringBuilder("EventChannel#").append(d.this.name);
                    bVar.I(d.this.SSe.h("error", e3.getMessage(), null));
                    AppMethodBeat.o(9844);
                }
            } else if (!K.method.equals("cancel")) {
                bVar.I(null);
                AppMethodBeat.o(9844);
            } else if (this.SSg.getAndSet(null) != null) {
                try {
                    this.SSf.sT();
                    bVar.I(d.this.SSe.eQ(null));
                    AppMethodBeat.o(9844);
                } catch (RuntimeException e4) {
                    new StringBuilder("EventChannel#").append(d.this.name);
                    bVar.I(d.this.SSe.h("error", e4.getMessage(), null));
                    AppMethodBeat.o(9844);
                }
            } else {
                bVar.I(d.this.SSe.h("error", "No active stream to cancel", null));
                AppMethodBeat.o(9844);
            }
        }

        final class a implements a {
            final AtomicBoolean SSi;

            private a() {
                AppMethodBeat.i(9831);
                this.SSi = new AtomicBoolean(false);
                AppMethodBeat.o(9831);
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }

            @Override // io.flutter.plugin.a.d.a
            public final void ba(Object obj) {
                AppMethodBeat.i(9832);
                if (this.SSi.get() || b.this.SSg.get() != this) {
                    AppMethodBeat.o(9832);
                    return;
                }
                d.this.wJt.a(d.this.name, d.this.SSe.eQ(obj));
                AppMethodBeat.o(9832);
            }

            @Override // io.flutter.plugin.a.d.a
            public final void b(String str, String str2, Object obj) {
                AppMethodBeat.i(9833);
                if (this.SSi.get() || b.this.SSg.get() != this) {
                    AppMethodBeat.o(9833);
                    return;
                }
                d.this.wJt.a(d.this.name, d.this.SSe.h(str, str2, obj));
                AppMethodBeat.o(9833);
            }

            @Override // io.flutter.plugin.a.d.a
            public final void awU() {
                AppMethodBeat.i(9834);
                if (this.SSi.getAndSet(true) || b.this.SSg.get() != this) {
                    AppMethodBeat.o(9834);
                    return;
                }
                d.this.wJt.a(d.this.name, (ByteBuffer) null);
                AppMethodBeat.o(9834);
            }
        }
    }
}
