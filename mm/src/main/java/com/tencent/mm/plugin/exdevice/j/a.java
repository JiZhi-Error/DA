package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public class a implements c {
    private long rDg = -1;
    private m rEA = null;
    protected c rEy = null;
    protected d rEz = null;

    public a(c cVar, d dVar) {
        this.rEy = cVar;
        this.rEz = dVar;
    }

    public final void a(d dVar) {
        this.rEz = dVar;
    }

    public final boolean b(m mVar) {
        AppMethodBeat.i(23795);
        if (mVar == null) {
            Log.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            AppMethodBeat.o(23795);
            return false;
        } else if (this.rEA != null) {
            Log.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            AppMethodBeat.o(23795);
            return false;
        } else {
            Log.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", Short.valueOf(this.rEy.cKg()), Short.valueOf(this.rEy.rxx), Long.valueOf(this.rEy.pkb));
            m mVar2 = new m(this.rEy, this);
            long a2 = mVar.a(mVar2);
            if (-1 == a2) {
                Log.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                AppMethodBeat.o(23795);
                return false;
            }
            this.rEA = mVar2;
            this.rDg = a2;
            m mVar3 = this.rEA;
            Assert.assertNotNull(mVar3.rEU);
            l lVar = mVar3.rEU;
            lVar.rEN = false;
            lVar.rEO = false;
            bg.aAk().getWorkerHandler().postDelayed(lVar.rEP, 15000);
            AppMethodBeat.o(23795);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.j.c
    public final void a(long j2, int i2, int i3, String str, p pVar) {
        AppMethodBeat.i(23796);
        Log.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.rEy.pkb), Short.valueOf(this.rEy.cKg()), Short.valueOf(this.rEy.rxx));
        com.tencent.mm.plugin.exdevice.h.a.q(this.rEy.pkb, i2 == 0 ? 1 : 0);
        if (pVar == null || pVar == this.rEA) {
            if (-1 == i2 && -2 == i3) {
                Log.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.rEy.rxy != null ? this.rEy.rxy.rBL : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                Log.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", Integer.valueOf(this.rEy.rxy.rBL), Long.valueOf(this.rEy.pkb));
                if (!(u.cLy().rxT != null && u.cLy().rxT.De(this.rEy.pkb))) {
                    Log.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.rEz != null) {
                this.rEz.a(j2, i2, i3, str);
            }
            this.rEA = null;
            AppMethodBeat.o(23796);
            return;
        }
        Log.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
        AppMethodBeat.o(23796);
    }
}
