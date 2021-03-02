package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class f implements i {
    public static f qvI;
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<l, a> oPn = new HashMap();

    public interface a {
        void J(String str, String str2, int i2);

        void a(boolean z, vv vvVar);
    }

    public f() {
        AppMethodBeat.i(63782);
        AppMethodBeat.o(63782);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63783);
        if (qVar instanceof l) {
            l lVar = (l) qVar;
            a aVar = this.oPn.get(qVar);
            if (aVar == null) {
                Log.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                AppMethodBeat.o(63783);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                aVar.a(true, lVar.qwk);
            } else {
                Log.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", lVar);
                aVar.a(false, lVar.qwk);
            }
            this.oPn.remove(qVar);
        }
        AppMethodBeat.o(63783);
    }
}
