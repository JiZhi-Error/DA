package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.o;

public final class i {
    public final boolean SRd;
    public byte[] SRe;
    k.d SRf;
    boolean SRg;
    boolean SRh;
    private final k.c SRi;
    private k bbv;

    public i(DartExecutor dartExecutor, boolean z) {
        this(new k(dartExecutor, "flutter/restoration", o.SSr), z);
        AppMethodBeat.i(214993);
        AppMethodBeat.o(214993);
    }

    private i(k kVar, boolean z) {
        AppMethodBeat.i(214994);
        this.SRg = false;
        this.SRh = false;
        this.SRi = new k.c() {
            /* class io.flutter.embedding.engine.c.i.AnonymousClass2 */

            @Override // io.flutter.plugin.a.k.c
            public final void a(j jVar, k.d dVar) {
                AppMethodBeat.i(214989);
                String str = jVar.method;
                Object obj = jVar.SxX;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 102230:
                        if (str.equals("get")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 111375:
                        if (str.equals("put")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        i.this.SRe = (byte[]) obj;
                        dVar.ba(null);
                        AppMethodBeat.o(214989);
                        return;
                    case 1:
                        i.this.SRh = true;
                        if (i.this.SRg || !i.this.SRd) {
                            dVar.ba(i.this.SRe);
                            AppMethodBeat.o(214989);
                            return;
                        }
                        i.this.SRf = dVar;
                        AppMethodBeat.o(214989);
                        return;
                    default:
                        dVar.dLv();
                        AppMethodBeat.o(214989);
                        return;
                }
            }
        };
        this.bbv = kVar;
        this.SRd = z;
        kVar.a(this.SRi);
        AppMethodBeat.o(214994);
    }

    public final void de(final byte[] bArr) {
        AppMethodBeat.i(214995);
        this.SRg = true;
        if (this.SRf != null) {
            this.SRf.ba(bArr);
            this.SRf = null;
        } else if (this.SRh) {
            this.bbv.a("push", bArr, new k.d() {
                /* class io.flutter.embedding.engine.c.i.AnonymousClass1 */

                @Override // io.flutter.plugin.a.k.d
                public final void ba(Object obj) {
                    i.this.SRe = bArr;
                }

                @Override // io.flutter.plugin.a.k.d
                public final void b(String str, String str2, Object obj) {
                    AppMethodBeat.i(214988);
                    new StringBuilder("Error ").append(str).append(" while sending restoration data to framework: ").append(str2);
                    a.hwg();
                    AppMethodBeat.o(214988);
                }

                @Override // io.flutter.plugin.a.k.d
                public final void dLv() {
                }
            });
            AppMethodBeat.o(214995);
            return;
        }
        this.SRe = bArr;
        AppMethodBeat.o(214995);
    }
}
