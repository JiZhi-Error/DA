package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.c.e;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a {
    private static e.a lne = new e.a() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.debugger.a.AnonymousClass1 */

        @Override // com.tencent.mm.aa.c.e.a
        public final void S(String str, int i2) {
            AppMethodBeat.i(121285);
            Bundle bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("status", i2);
            h.a(MainProcessIPCService.dkO, bundle, C0573a.class, null);
            AppMethodBeat.o(121285);
        }
    };

    static {
        AppMethodBeat.i(121288);
        AppMethodBeat.o(121288);
    }

    public static void d(String str, ArrayList<LogInfo> arrayList) {
        AppMethodBeat.i(121287);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putParcelableArrayList("logList", arrayList);
        c.ayj().m(b.oFD.getClass().getName(), bundle);
        AppMethodBeat.o(121287);
    }

    public static e.a bBZ() {
        return lne;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.a$a  reason: collision with other inner class name */
    static class C0573a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private C0573a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(121286);
            Bundle bundle2 = bundle;
            b.S(bundle2.getString("id"), bundle2.getInt("status"));
            AppMethodBeat.o(121286);
        }
    }
}
