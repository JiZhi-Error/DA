package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ServiceFreeActionResponse extends JceStruct {
    static byte[] cache_revertField;
    public byte[] revertField = null;

    public ServiceFreeActionResponse() {
    }

    public ServiceFreeActionResponse(byte[] bArr) {
        this.revertField = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102256);
        if (this.revertField != null) {
            jceOutputStream.write(this.revertField, 0);
        }
        AppMethodBeat.o(102256);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102257);
        if (cache_revertField == null) {
            byte[] bArr = new byte[1];
            cache_revertField = bArr;
            bArr[0] = 0;
        }
        this.revertField = jceInputStream.read(cache_revertField, 0, false);
        AppMethodBeat.o(102257);
    }
}
