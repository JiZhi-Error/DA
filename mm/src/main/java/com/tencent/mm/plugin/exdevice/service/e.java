package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q.a {
    private static e rDA = new e();

    static {
        AppMethodBeat.i(23648);
        AppMethodBeat.o(23648);
    }

    private e() {
    }

    public static e cLd() {
        return rDA;
    }

    public final boolean aV(final String str, final boolean z) {
        AppMethodBeat.i(23646);
        Log.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
        if (str == null) {
            Log.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            AppMethodBeat.o(23646);
            return false;
        } else if (u.cLy().rxT == null) {
            Log.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            ad.cKS().am(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.service.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(23645);
                    if (u.cLy().rxT != null) {
                        u.cLy().rxT.a(str, z, e.this);
                    }
                    AppMethodBeat.o(23645);
                }
            });
            AppMethodBeat.o(23646);
            return false;
        } else {
            boolean a2 = u.cLy().rxT.a(str, z, this);
            AppMethodBeat.o(23646);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.exdevice.service.q
    public final void a(double d2, int i2, int i3, byte[] bArr, double d3, int i4, String str) {
        AppMethodBeat.i(23647);
        Log.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", Double.valueOf(d2), Integer.valueOf(i2), Integer.valueOf(i3), b.bw(bArr), Double.valueOf(d3), str, Integer.valueOf(i4));
        ei eiVar = new ei();
        String bw = b.bw(bArr);
        if (bw.length() >= 32) {
            bw = bw.substring(0, 8) + "-" + bw.substring(8, 12) + "-" + bw.substring(12, 16) + "-" + bw.substring(16, 20) + "-" + bw.substring(20);
        }
        eiVar.dHG.dHE = bw;
        eiVar.dHG.dHJ = d2;
        eiVar.dHG.dHH = i2;
        eiVar.dHG.dHI = i3;
        eiVar.dHG.dHK = d3;
        eiVar.dHG.dHL = str;
        eiVar.dHG.dHM = i4;
        EventCenter.instance.publish(eiVar);
        AppMethodBeat.o(23647);
    }
}
