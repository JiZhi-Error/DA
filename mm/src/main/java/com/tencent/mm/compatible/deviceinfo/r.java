package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

final class r {
    static void ov(int i2) {
        AppMethodBeat.i(155742);
        Log.i("MicroMsg.DeviceInfoDiagHelper", "[+] report idkey id: %s, key: %s, val: %s, isImportant: %s", 1064, Integer.valueOf(i2), 1, Boolean.TRUE);
        e.INSTANCE.idkeyStat(1064, (long) i2, 1, true);
        AppMethodBeat.o(155742);
    }
}
