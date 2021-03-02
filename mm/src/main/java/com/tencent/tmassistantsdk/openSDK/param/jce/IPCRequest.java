package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCRequest extends JceStruct {
    static byte[] cache_body;
    static IPCHead cache_head;
    public byte[] body = null;
    public IPCHead head = null;

    public IPCRequest() {
    }

    public IPCRequest(IPCHead iPCHead, byte[] bArr) {
        this.head = iPCHead;
        this.body = bArr;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102244);
        jceOutputStream.write((JceStruct) this.head, 0);
        if (this.body != null) {
            jceOutputStream.write(this.body, 1);
        }
        AppMethodBeat.o(102244);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102245);
        if (cache_head == null) {
            cache_head = new IPCHead();
        }
        this.head = (IPCHead) jceInputStream.read((JceStruct) cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = 0;
        }
        this.body = jceInputStream.read(cache_body, 1, false);
        AppMethodBeat.o(102245);
    }
}
