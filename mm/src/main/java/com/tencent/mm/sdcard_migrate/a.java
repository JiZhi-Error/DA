package com.tencent.mm.sdcard_migrate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a {
    int NGh = 0;
    final C2049a NGi = new C2049a();
    final List<b> rDz = new ArrayList();

    public static abstract class b {
        public abstract void a(C2049a aVar);
    }

    /* renamed from: com.tencent.mm.sdcard_migrate.a$a  reason: collision with other inner class name */
    public final class C2049a {
        public C2049a() {
        }

        public final void gwC() {
            AppMethodBeat.i(176023);
            synchronized (a.this.rDz) {
                try {
                    a.this.NGh++;
                    a.this.rDz.get(a.this.NGh).a(this);
                } finally {
                    AppMethodBeat.o(176023);
                }
            }
        }
    }

    public final a a(b bVar) {
        AppMethodBeat.i(176024);
        this.rDz.add(bVar);
        AppMethodBeat.o(176024);
        return this;
    }

    a(b bVar) {
        AppMethodBeat.i(176025);
        this.rDz.add(bVar);
        AppMethodBeat.o(176025);
    }
}
