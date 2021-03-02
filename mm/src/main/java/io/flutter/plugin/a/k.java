package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import java.nio.ByteBuffer;

public final class k {
    final l SSe;
    final String name;
    private final c wJt;

    public interface c {
        void a(j jVar, d dVar);
    }

    public interface d {
        void b(String str, String str2, Object obj);

        void ba(Object obj);

        void dLv();
    }

    public k(c cVar, String str) {
        this(cVar, str, o.SSr);
    }

    public k(c cVar, String str, l lVar) {
        this.wJt = cVar;
        this.name = str;
        this.SSe = lVar;
    }

    public final void a(String str, Object obj, d dVar) {
        AppMethodBeat.i(9837);
        this.wJt.a(this.name, this.SSe.b(new j(str, obj)), dVar == null ? null : new b(dVar));
        AppMethodBeat.o(9837);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(9838);
        this.wJt.a(this.name, cVar == null ? null : new a(cVar));
        AppMethodBeat.o(9838);
    }

    final class b implements c.b {
        private final d SxY;

        b(d dVar) {
            this.SxY = dVar;
        }

        @Override // io.flutter.plugin.a.c.b
        public final void I(ByteBuffer byteBuffer) {
            AppMethodBeat.i(9866);
            if (byteBuffer == null) {
                try {
                    this.SxY.dLv();
                    AppMethodBeat.o(9866);
                } catch (RuntimeException e2) {
                    new StringBuilder("MethodChannel#").append(k.this.name);
                    AppMethodBeat.o(9866);
                }
            } else {
                try {
                    this.SxY.ba(k.this.SSe.L(byteBuffer));
                    AppMethodBeat.o(9866);
                } catch (e e3) {
                    this.SxY.b(e3.code, e3.getMessage(), e3.hgl);
                    AppMethodBeat.o(9866);
                }
            }
        }
    }

    final class a implements c.a {
        private final c SRi;

        a(c cVar) {
            this.SRi = cVar;
        }

        @Override // io.flutter.plugin.a.c.a
        public final void a(ByteBuffer byteBuffer, final c.b bVar) {
            AppMethodBeat.i(9867);
            try {
                this.SRi.a(k.this.SSe.K(byteBuffer), new d() {
                    /* class io.flutter.plugin.a.k.a.AnonymousClass1 */

                    @Override // io.flutter.plugin.a.k.d
                    public final void ba(Object obj) {
                        AppMethodBeat.i(9839);
                        bVar.I(k.this.SSe.eQ(obj));
                        AppMethodBeat.o(9839);
                    }

                    @Override // io.flutter.plugin.a.k.d
                    public final void b(String str, String str2, Object obj) {
                        AppMethodBeat.i(9840);
                        bVar.I(k.this.SSe.h(str, str2, obj));
                        AppMethodBeat.o(9840);
                    }

                    @Override // io.flutter.plugin.a.k.d
                    public final void dLv() {
                        AppMethodBeat.i(9841);
                        bVar.I(null);
                        AppMethodBeat.o(9841);
                    }
                });
                AppMethodBeat.o(9867);
            } catch (RuntimeException e2) {
                new StringBuilder("MethodChannel#").append(k.this.name);
                bVar.I(k.this.SSe.h("error", e2.getMessage(), null));
                AppMethodBeat.o(9867);
            }
        }
    }
}
