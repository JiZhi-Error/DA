package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class n {
    private final Map<String, Map<String, List<Pair<String, String>>>> sAz = new HashMap();
    private final c sGp = new c() {
        /* class com.tencent.mm.plugin.expt.hellhound.a.b.b.n.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            boolean z;
            AppMethodBeat.i(220526);
            if (TextUtils.isEmpty(str) || !str.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")) {
                AppMethodBeat.o(220526);
            } else if (!"onMMMenuItemSelected".equals(str2) || !"(Landroid/view/MenuItem;I)V".equals(str3)) {
                AppMethodBeat.o(220526);
            } else if (objArr == null || objArr.length < 2) {
                AppMethodBeat.o(220526);
            } else if (!(objArr[0] instanceof MenuItem)) {
                AppMethodBeat.o(220526);
            } else {
                int itemId = ((MenuItem) objArr[0]).getItemId();
                if (itemId == 6) {
                    z = true;
                } else {
                    z = false;
                }
                c.sEl = z;
                Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnEnter: itemId=%d, %b", Integer.valueOf(itemId), Boolean.valueOf(c.sEl));
                AppMethodBeat.o(220526);
            }
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
            AppMethodBeat.i(220527);
            if (TextUtils.isEmpty(str) || !str.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$")) {
                AppMethodBeat.o(220527);
            } else if (!"onMMMenuItemSelected".equals(str2) || !"(Landroid/view/MenuItem;I)V".equals(str3)) {
                AppMethodBeat.o(220527);
            } else {
                Log.i("HABBYGE-MALI.SnsFinderMonitor", "mSnsFinderListener, runOnExit: %b", Boolean.valueOf(c.sEl));
                AppMethodBeat.o(220527);
            }
        }
    };

    public n() {
        AppMethodBeat.i(220528);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener", arrayList);
        this.sAz.put("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI$", hashMap);
        AppMethodBeat.o(220528);
    }

    public final void cMH() {
        AppMethodBeat.i(220529);
        a.axP();
        a.e(this.sAz, this.sGp);
        AppMethodBeat.o(220529);
    }

    public final void cOG() {
        AppMethodBeat.i(220530);
        a.axP();
        a.f(this.sAz, this.sGp);
        AppMethodBeat.o(220530);
    }

    static void c(cyl cyl) {
        AppMethodBeat.i(220531);
        if (cyl == null) {
            AppMethodBeat.o(220531);
            return;
        }
        if ("143".equals(b.aqn(cyl.sessionId)) && c.sEl) {
            Log.d("HABBYGE-MALI.SnsFinderMonitor", "begin19943, sessionId=%s, startTime=%s, endTime=%s", cyl.sessionId, Long.valueOf(cyl.startTime), Long.valueOf(cyl.endTime));
        }
        AppMethodBeat.o(220531);
    }

    static void d(cyl cyl) {
        AppMethodBeat.i(220532);
        if (cyl == null) {
            AppMethodBeat.o(220532);
            return;
        }
        String aqn = b.aqn(cyl.sessionId);
        if ("143".equals(aqn) && c.sEl) {
            Log.d("HABBYGE-MALI.SnsFinderMonitor", "stop19943, sessionId=%s, startTime=%s, endTime=%s", cyl.sessionId, Long.valueOf(cyl.startTime), Long.valueOf(cyl.endTime));
            com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte) 0);
            bVar.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.cPU().cMD();
            bVar.dMl = "All-Sns";
            bVar.sGC = cyl.startTime;
            bVar.sGD = cyl.endTime;
            bVar.sGB = cyl.endTime - cyl.startTime;
            bVar.sGE = com.tencent.mm.plugin.expt.hellhound.core.b.cNB();
            bVar.sGF = aqn;
            bVar.dYn = c.b.INOUT.value;
            com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(bVar);
        }
        AppMethodBeat.o(220532);
    }
}
