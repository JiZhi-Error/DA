package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e implements i {
    Map<Integer, Set<u>> iMA = new HashMap();

    public e() {
        AppMethodBeat.i(151661);
        g.aAg().hqi.a(452, this);
        AppMethodBeat.o(151661);
    }

    public final void a(final int i2, final u uVar) {
        AppMethodBeat.i(151662);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.app.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(151658);
                if (!e.this.iMA.containsKey(Integer.valueOf(i2))) {
                    e.this.iMA.put(Integer.valueOf(i2), new HashSet());
                }
                if (e.this.iMA.get(Integer.valueOf(i2)) != null && !e.this.iMA.get(Integer.valueOf(i2)).contains(uVar)) {
                    e.this.iMA.get(Integer.valueOf(i2)).add(uVar);
                }
                AppMethodBeat.o(151658);
            }
        });
        AppMethodBeat.o(151662);
    }

    public final void b(final int i2, final u uVar) {
        AppMethodBeat.i(151663);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.app.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(151659);
                if (e.this.iMA.get(Integer.valueOf(i2)) != null) {
                    e.this.iMA.get(Integer.valueOf(i2)).remove(uVar);
                }
                AppMethodBeat.o(151659);
            }
        });
        AppMethodBeat.o(151663);
    }

    public static void a(int i2, aa aaVar) {
        AppMethodBeat.i(151664);
        g.aAg().hqi.a(new ab(i2, aaVar), 0);
        AppMethodBeat.o(151664);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(151665);
        if (!(qVar instanceof ab)) {
            Log.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
            AppMethodBeat.o(151665);
            return;
        }
        ab abVar = (ab) qVar;
        Set<u> set = this.iMA.get(Integer.valueOf(abVar.JWw));
        if (set != null && set.size() > 0) {
            HashSet<u> hashSet = new HashSet();
            hashSet.addAll(set);
            for (u uVar : hashSet) {
                if (uVar != null && set.contains(uVar)) {
                    uVar.a(i2, i3, str, abVar.JWx);
                }
            }
        }
        AppMethodBeat.o(151665);
    }
}
