package com.tencent.mm.plugin.d.a.a;

import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j {
    protected int mLength = -1;
    protected byte pgv = 0;
    protected byte[] pgw = null;

    /* access modifiers changed from: package-private */
    public abstract boolean aW(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            Log.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.T(bArr, 1);
        byte b2 = bArr[0];
        if (b2 + 1 > aVar.getSize()) {
            Log.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", Integer.valueOf(b2), Integer.valueOf(aVar.getSize()));
            return false;
        } else if (b2 <= 1) {
            Log.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", Integer.valueOf(b2));
            return false;
        } else {
            this.mLength = b2;
            aVar.T(bArr, 1);
            this.pgv = bArr[0];
            this.pgw = new byte[(this.mLength - 1)];
            aVar.T(this.pgw, this.pgw.length);
            return aW(this.pgw);
        }
    }
}
