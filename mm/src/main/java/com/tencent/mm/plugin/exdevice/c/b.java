package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class b extends d {
    public b(long j2, int i2, int i3, byte[] bArr) {
        super(j2, i2, i3, bArr);
        AppMethodBeat.i(23147);
        Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "ExDeviceCmdAuth deviceId = " + j2 + " seq = " + i2 + " cmdId = " + i3);
        AppMethodBeat.o(23147);
    }

    public final void a(int i2, String str, byte[] bArr) {
        AppMethodBeat.i(23148);
        Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------setAuthResponse------ret = " + i2 + "errMsg = " + str);
        com.tencent.mm.plugin.exdevice.f.b bVar = new com.tencent.mm.plugin.exdevice.f.b();
        bVar.rCc = aQ(i2, str);
        bVar.rBJ = com.tencent.mm.bw.b.cD(bArr);
        this.rxz = bVar;
        this.rxx = 20001;
        AppMethodBeat.o(23148);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.exdevice.c.d
    public final a bu(byte[] bArr) {
        AppMethodBeat.i(23149);
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdAuth", "paras body is null");
            AppMethodBeat.o(23149);
            return null;
        }
        com.tencent.mm.plugin.exdevice.f.a aVar = new com.tencent.mm.plugin.exdevice.f.a();
        try {
            aVar.parseFrom(bArr);
            this.rxA = aVar;
            Log.i("MicroMsg.exdevice.ExDeviceCmdAuth", "------AuthRequest------ ClientVersion = " + aVar.rBC + " DeviceName = " + aVar.oTI + " Language = " + aVar.rBI + " TimeZone = " + aVar.rBH);
            AppMethodBeat.o(23149);
            return aVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdAuth", "AuthRequest.parseFrom Failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdAuth", e2, "", new Object[0]);
            AppMethodBeat.o(23149);
            return null;
        }
    }
}
