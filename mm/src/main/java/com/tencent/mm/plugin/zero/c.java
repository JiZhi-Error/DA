package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {
    public static volatile com.tencent.mm.co.c<f> JSe;
    public final f JSf;

    public c() {
        AppMethodBeat.i(133022);
        if (JSe != null) {
            this.JSf = JSe.get();
            AppMethodBeat.o(133022);
            return;
        }
        this.JSf = null;
        AppMethodBeat.o(133022);
    }

    public final void dz(Object obj) {
        AppMethodBeat.i(133023);
        if (this.JSf != null) {
            this.JSf.dz(obj);
        }
        AppMethodBeat.o(133023);
    }

    public final boolean a(abn abn, boolean z) {
        AppMethodBeat.i(133024);
        if (!g.aAc()) {
            Log.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
            AppMethodBeat.o(133024);
            return false;
        }
        long nowMilliSecond = Util.nowMilliSecond();
        byte[] a2 = z.a(abn.Lmt);
        Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(nowMilliSecond), Integer.valueOf(abn.Lms), Integer.valueOf(Util.getLength(a2)), Long.valueOf(Thread.currentThread().getId()));
        if (Util.isNullOrNil(a2)) {
            Log.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
            AppMethodBeat.o(133024);
            return false;
        }
        try {
            if (this.JSf != null) {
                this.JSf.a(abn, a2, z);
            }
            Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(nowMilliSecond), Integer.valueOf(abn.Lms), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
            AppMethodBeat.o(133024);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e2, "", new Object[0]);
            AppMethodBeat.o(133024);
            return false;
        }
    }

    public final void dA(Object obj) {
        AppMethodBeat.i(133025);
        if (this.JSf != null) {
            this.JSf.dA(obj);
        }
        AppMethodBeat.o(133025);
    }

    public final void dB(Object obj) {
        AppMethodBeat.i(133026);
        if (this.JSf != null) {
            this.JSf.dB(obj);
        }
        AppMethodBeat.o(133026);
    }
}
