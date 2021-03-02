package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a.a;
import com.tencent.mm.plugin.ipcall.model.c.d;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class b implements d.a {
    public MMActivity gte;
    public a yqo = new a();
    public d yqr = new d();
    public j yqs;
    public long yqt = 0;

    public b() {
        AppMethodBeat.i(25419);
        AppMethodBeat.o(25419);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(25420);
        this.yqs = jVar;
        if (jVar != null) {
            i.eax().qm(false);
        }
        AppMethodBeat.o(25420);
    }

    public final void a(a.b bVar) {
        this.yqo.ypz = bVar;
    }

    public final void eaK() {
        AppMethodBeat.i(25421);
        this.yqr.yqC = this;
        d dVar = this.yqr;
        if (!dVar.qUq.hasRegistered()) {
            dVar.qUq.setSensorCallBack(dVar);
            if (dVar.qUp.startShake(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.model.c.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25433);
                    d.this.lastShakeTime = Util.currentTicks();
                    AppMethodBeat.o(25433);
                }
            })) {
                dVar.lastShakeTime = 0;
                AppMethodBeat.o(25421);
                return;
            }
            dVar.lastShakeTime = -1;
        }
        AppMethodBeat.o(25421);
    }

    public final void qw(boolean z) {
        AppMethodBeat.i(25422);
        this.yqo.cV(z);
        AppMethodBeat.o(25422);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.c.d.a
    public final void qx(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(25423);
        Log.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", Boolean.valueOf(z));
        if (this.gte != null) {
            MMActivity mMActivity = this.gte;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (i.eaw().eam()) {
            if (z) {
                this.yqo.cV(false);
                AppMethodBeat.o(25423);
                return;
            }
            this.yqo.eaE();
        }
        AppMethodBeat.o(25423);
    }

    public final int eaL() {
        AppMethodBeat.i(25426);
        a aVar = this.yqo.ypA;
        if (aVar == null) {
            AppMethodBeat.o(25426);
            return 0;
        } else if (aVar.qrz == null || !aVar.isStart) {
            AppMethodBeat.o(25426);
            return -1;
        } else {
            int bhV = aVar.qrz.bhV();
            AppMethodBeat.o(25426);
            return bhV;
        }
    }
}
