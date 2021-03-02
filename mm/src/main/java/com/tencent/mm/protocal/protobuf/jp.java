package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.a;

public final class jp extends dop {
    private byte[] KOg;

    public jp(byte[] bArr) {
        this.KOg = bArr;
    }

    @Override // com.tencent.mm.bw.a
    public final byte[] toByteArray() {
        AppMethodBeat.i(197129);
        validate();
        int computeSize = this.BaseRequest.computeSize();
        byte[] bArr = new byte[a.nh(1, computeSize)];
        g.a.a.c.a aVar = new g.a.a.c.a(bArr);
        aVar.ni(1, computeSize);
        this.BaseRequest.writeFields(aVar);
        aVar.hPu();
        byte[] bArr2 = new byte[(bArr.length + this.KOg.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.KOg, 0, bArr2, bArr.length, this.KOg.length);
        AppMethodBeat.o(197129);
        return bArr2;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        return -1;
    }
}
