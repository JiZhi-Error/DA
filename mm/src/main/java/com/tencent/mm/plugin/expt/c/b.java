package com.tencent.mm.plugin.expt.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.sdk.event.EventCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final Map<String, List<Pair<String, String>>> sxm = new HashMap();
    private static final com.tencent.mm.hellhoundlib.a.b sxn = new com.tencent.mm.hellhoundlib.a.b() {
        /* class com.tencent.mm.plugin.expt.c.b.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void c(String str, String str2, String str3, String str4, Object obj, Object[] objArr) {
            AppMethodBeat.i(220260);
            lh lhVar = new lh();
            lhVar.dQy.action = 0;
            EventCenter.instance.publish(lhVar);
            AppMethodBeat.o(220260);
        }

        @Override // com.tencent.mm.hellhoundlib.a.b
        public final void a(String str, String str2, String str3, Object obj) {
            AppMethodBeat.i(220261);
            lh lhVar = new lh();
            lhVar.dQy.action = 1;
            EventCenter.instance.publish(lhVar);
            AppMethodBeat.o(220261);
        }
    };

    static {
        AppMethodBeat.i(220263);
        AppMethodBeat.o(220263);
    }

    public static void cMH() {
        AppMethodBeat.i(220262);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("killProcess", "(I)V"));
        sxm.put("android/os/Process", arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Pair.create("exit", "(I)V"));
        sxm.put("java/lang/System", arrayList2);
        a.axP();
        a.a(sxm, sxn);
        AppMethodBeat.o(220262);
    }
}
