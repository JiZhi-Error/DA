package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyPermissionStorage;", "", "()V", "getReqSysPermissionCnt", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "setReqSysPermissionCnt", "", "cnt", "plugin-force-notify_release"})
public final class b {
    public static final b UWa = new b();

    static {
        AppMethodBeat.i(261762);
        AppMethodBeat.o(261762);
    }

    private b() {
    }

    public static int j(ar.a aVar) {
        AppMethodBeat.i(261760);
        p.h(aVar, "key");
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(aVar, 0);
        AppMethodBeat.o(261760);
        return i2;
    }

    public static void d(ar.a aVar, int i2) {
        AppMethodBeat.i(261761);
        p.h(aVar, "key");
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(aVar, Integer.valueOf(i2));
        AppMethodBeat.o(261761);
    }
}
