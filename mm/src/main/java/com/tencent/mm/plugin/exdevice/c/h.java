package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends j {
    public h(int i2, int i3, long j2) {
        AppMethodBeat.i(23157);
        n nVar = new n();
        nVar.rCa = new c();
        nVar.rCe = i2;
        nVar.rCf = i3;
        this.rxz = nVar;
        this.pkb = j2;
        this.rxx = 30002;
        AppMethodBeat.o(23157);
    }

    @Override // com.tencent.mm.plugin.exdevice.c.c
    public final byte[] cKi() {
        AppMethodBeat.i(23158);
        byte[] bArr = null;
        try {
            bArr = this.rxz.toByteArray();
        } catch (Exception e2) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "mResp.toByteArray() Failed!!! %s", e2.getMessage());
        }
        AppMethodBeat.o(23158);
        return bArr;
    }

    public final int cKk() {
        AppMethodBeat.i(23159);
        n nVar = (n) this.rxz;
        if (nVar == null) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdSwitchViewPush", "null = pushReq");
            AppMethodBeat.o(23159);
            return -1;
        }
        int i2 = nVar.rCe;
        AppMethodBeat.o(23159);
        return i2;
    }
}
