package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends ae implements i {
    private String mDeviceType = null;
    private int rcy = -1;
    private String rzn = null;
    private String rzo = null;

    public k(String str, String str2, String str3, int i2) {
        this.rzn = str;
        this.mDeviceType = str2;
        this.rzo = str3;
        this.rcy = i2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(23811);
        Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        bg.azz().b(1090, this);
        AppMethodBeat.o(23811);
    }

    @Override // com.tencent.mm.plugin.exdevice.model.ae
    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(23812);
        Log.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.rzn + ",deviceType=" + this.mDeviceType + ",deviceId=" + this.rzo + ",reqType=" + this.rcy);
        bg.azz().a(1090, this);
        bg.azz().a(new s(this.rzn, this.mDeviceType, this.rzo, this.rcy), 0);
        AppMethodBeat.o(23812);
        return false;
    }
}
