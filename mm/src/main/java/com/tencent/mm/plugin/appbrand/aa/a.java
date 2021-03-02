package com.tencent.mm.plugin.appbrand.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private final Map<String, List<Object>> mgp;

    /* synthetic */ a(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.aa.a$a  reason: collision with other inner class name */
    public static final class C0530a {
        private static final a nOe = new a((byte) 0);

        static {
            AppMethodBeat.i(140789);
            AppMethodBeat.o(140789);
        }
    }

    private a() {
        AppMethodBeat.i(140790);
        this.mgp = new HashMap();
        AppMethodBeat.o(140790);
    }

    public final void a(String str, final String str2, final b.EnumC0531b bVar) {
        AppMethodBeat.i(140791);
        new Object() {
            /* class com.tencent.mm.plugin.appbrand.aa.a.AnonymousClass1 */
            final /* synthetic */ long kxd = 20;
        };
        aeY(str);
        AppMethodBeat.o(140791);
    }

    public final void M(String str, final String str2, final String str3) {
        AppMethodBeat.i(140792);
        new Object() {
            /* class com.tencent.mm.plugin.appbrand.aa.a.AnonymousClass2 */
        };
        aeY(str);
        AppMethodBeat.o(140792);
    }

    private void aeY(String str) {
        AppMethodBeat.i(230004);
        List<Object> list = this.mgp.get(str);
        if (list == null) {
            AppMethodBeat.o(230004);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2);
        }
        AppMethodBeat.o(230004);
    }
}
