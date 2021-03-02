package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.exdevice.f.k;
import com.tencent.mm.plugin.exdevice.f.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class f extends d {
    public f(long j2, int i2, int i3, byte[] bArr) {
        super(j2, i2, i3, bArr);
        AppMethodBeat.i(23153);
        Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "ExDeviceCmdSendDataToManufacturer deviceId = " + j2 + " seq = " + i2 + " cmdId = " + i3);
        AppMethodBeat.o(23153);
    }

    public final void b(int i2, String str, byte[] bArr) {
        AppMethodBeat.i(23154);
        Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "setSendDataToManufacturerResponse ret = " + i2 + str);
        l lVar = new l();
        lVar.rCc = aQ(i2, str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        lVar.oTm = new b(bArr);
        this.rxz = lVar;
        this.rxx = 20002;
        AppMethodBeat.o(23154);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.exdevice.c.d
    public final a bu(byte[] bArr) {
        AppMethodBeat.i(23155);
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "data is null");
            AppMethodBeat.o(23155);
            return null;
        }
        k kVar = new k();
        try {
            kVar.parseFrom(bArr);
            this.rxA = kVar;
            Log.i("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest cmd has been received");
            AppMethodBeat.o(23155);
            return kVar;
        } catch (IOException e2) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", "SendDataToManufacturerSvrRequest.parseFrom Failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdSendDataToManufacturer", e2, "", new Object[0]);
            AppMethodBeat.o(23155);
            return null;
        }
    }
}
