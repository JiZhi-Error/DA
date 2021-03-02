package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public abstract class d extends c {
    protected a rxA = null;
    private short rxB = -1;
    private short rxC = -1;

    /* access modifiers changed from: protected */
    public abstract a bu(byte[] bArr);

    public d(long j2, int i2, int i3, byte[] bArr) {
        Log.i("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "onDeviceRequest deviceId = " + j2 + " seq = " + i2 + " cmdId = " + i3);
        this.pkb = j2;
        this.rxB = (short) i3;
        this.rxC = (short) i2;
        bu(bArr);
    }

    @Override // com.tencent.mm.plugin.exdevice.c.c
    public final short cKg() {
        return this.rxB;
    }

    @Override // com.tencent.mm.plugin.exdevice.c.c
    public final short cKh() {
        return this.rxC;
    }

    public final a cKj() {
        return this.rxA;
    }

    @Override // com.tencent.mm.plugin.exdevice.c.c
    public final byte[] cKi() {
        try {
            return this.rxz.toByteArray();
        } catch (IOException e2) {
            Log.e("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", "mResp.toByteArray() Failed!!! %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceCmdBaseReqResp", e2, "", new Object[0]);
            return null;
        }
    }
}
