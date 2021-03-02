package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e {
    private final g pfP = new g();
    public final h pfQ = new h();

    public e() {
        AppMethodBeat.i(22442);
        AppMethodBeat.o(22442);
    }

    public final boolean aV(byte[] bArr) {
        AppMethodBeat.i(22443);
        if (Util.isNullOrNil(bArr)) {
            Log.e("MicroMsg.exdevice.IBeaconProtocal", "dataIn is null or nil");
            AppMethodBeat.o(22443);
            return false;
        }
        a aVar = new a(bArr.length);
        aVar.U(bArr, bArr.length);
        boolean a2 = this.pfP.a(aVar);
        if (!a2) {
            Log.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionA.ParseTLV Failed!!!");
            AppMethodBeat.o(22443);
            return a2;
        }
        boolean a3 = this.pfQ.a(aVar);
        if (!a3) {
            Log.d("MicroMsg.exdevice.IBeaconProtocal", "mSectionB.ParseTLV Failed!!!");
            AppMethodBeat.o(22443);
            return a3;
        }
        AppMethodBeat.o(22443);
        return a3;
    }
}
