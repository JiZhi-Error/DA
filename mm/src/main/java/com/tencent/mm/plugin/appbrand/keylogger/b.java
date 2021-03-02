package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    final Map<String, List<com.tencent.mm.plugin.appbrand.keylogger.base.b>> mgp;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.keylogger.b$b  reason: collision with other inner class name */
    public interface AbstractC0730b {
        void a(com.tencent.mm.plugin.appbrand.keylogger.base.b bVar);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private static final b mPe = new b((byte) 0);

        static {
            AppMethodBeat.i(221277);
            AppMethodBeat.o(221277);
        }
    }

    private b() {
        AppMethodBeat.i(221278);
        this.mgp = new HashMap();
        AppMethodBeat.o(221278);
    }

    public final void a(String str, final String str2, final com.tencent.mm.plugin.appbrand.keylogger.base.a aVar, final long j2) {
        AppMethodBeat.i(221279);
        a(str, new AbstractC0730b() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.b.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.keylogger.b.AbstractC0730b
            public final void a(com.tencent.mm.plugin.appbrand.keylogger.base.b bVar) {
                AppMethodBeat.i(221275);
                bVar.b(str2, aVar, j2);
                AppMethodBeat.o(221275);
            }
        });
        AppMethodBeat.o(221279);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, AbstractC0730b bVar) {
        AppMethodBeat.i(221280);
        List<com.tencent.mm.plugin.appbrand.keylogger.base.b> list = this.mgp.get(str);
        if (list == null) {
            AppMethodBeat.o(221280);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            bVar.a(list.get(i2));
        }
        AppMethodBeat.o(221280);
    }
}
