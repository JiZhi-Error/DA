package com.tencent.mm.plugin.exdevice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.exdevice.f.c;
import com.tencent.mm.plugin.exdevice.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import junit.framework.Assert;

public final class i extends j {
    public i(byte[] bArr, int i2, long j2) {
        AppMethodBeat.i(23160);
        h hVar = new h();
        hVar.rCa = new c();
        hVar.oTm = new b(bArr);
        hVar.oUv = i2;
        this.rxz = hVar;
        this.pkb = j2;
        this.rxx = 30001;
        AppMethodBeat.o(23160);
    }

    @Override // com.tencent.mm.plugin.exdevice.c.c
    public final byte[] cKi() {
        AppMethodBeat.i(23161);
        Assert.assertNotNull(this.rxz);
        try {
            byte[] byteArray = this.rxz.toByteArray();
            AppMethodBeat.o(23161);
            return byteArray;
        } catch (IOException e2) {
            Log.e("MicroMsg.exdevice.ExDevicePushManufacturerSvrSendData", "mResp.toByteArray() Failed!!! %s", e2.getMessage());
            AppMethodBeat.o(23161);
            return null;
        }
    }
}
