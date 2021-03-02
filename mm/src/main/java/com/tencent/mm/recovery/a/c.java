package com.tencent.mm.recovery.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.net.b;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.recoveryv2.f;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    public static void a(final Context context, cxv cxv, final android.support.v4.e.c<Integer> cVar, final boolean z) {
        AppMethodBeat.i(193914);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        b bVar = new b(cxv);
        f.i("MicroMsg.recovery.operatorFallback", "NetSceneBaseMMTLSCheck#doSceneSync()");
        bVar.a(new b.a() {
            /* class com.tencent.mm.recovery.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.hp.net.b.a
            public final void a(int i2, com.tencent.mm.plugin.hp.d.b bVar) {
                AppMethodBeat.i(193913);
                f.i("MicroMsg.recovery.operatorFallback", "onCheckEnd, error = " + i2 + ", response = " + bVar);
                if (i2 == 0 || i2 == -5) {
                    f.i("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp successful");
                    if (i2 == -5 || bVar == null || TextUtils.isEmpty(bVar.pkK)) {
                        atomicInteger.set(1);
                        cVar.accept(Integer.valueOf(atomicInteger.get()));
                        AppMethodBeat.o(193913);
                        return;
                    }
                    com.tencent.mm.recovery.b.a(context, bVar.pkK, (long) Math.max(bVar.fileSize, 0), bVar.pkL, cVar, z);
                    AppMethodBeat.o(193913);
                    return;
                }
                f.w("MicroMsg.recovery.operatorFallback", "fetchTinkerPatch cgi rsp error, abort");
                atomicInteger.set(Math.abs(i2) + 20);
                cVar.accept(Integer.valueOf(atomicInteger.get()));
                AppMethodBeat.o(193913);
            }
        });
        AppMethodBeat.o(193914);
    }
}
