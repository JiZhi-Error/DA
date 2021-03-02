package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.sdk.platformtools.Log;

public class w extends k.a {
    @Override // com.tencent.mm.plugin.exdevice.service.k
    public void a(long j2, int i2, int i3, int i4, long j3) {
        AppMethodBeat.i(23700);
        Log.i("MicroMsg.exdevice.OnStateChangeCallBack", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d, profileType = %d", b.Dj(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3));
        AppMethodBeat.o(23700);
    }
}
