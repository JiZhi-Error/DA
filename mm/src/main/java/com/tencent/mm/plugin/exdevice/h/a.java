package com.tencent.mm.plugin.exdevice.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static void q(long j2, int i2) {
        AppMethodBeat.i(23587);
        b anI = ad.cKL().anI(String.valueOf(j2));
        if (anI == null) {
            Log.e("MicroMsg.exdevice.BTDeviceReport", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23587);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(anI.field_deviceType).append(',');
        sb.append(anI.field_deviceID).append(',');
        sb.append(i2);
        h.INSTANCE.kvStat(11232, sb.toString());
        AppMethodBeat.o(23587);
    }
}
