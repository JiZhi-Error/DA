package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.Util;

public final class w {

    public static class a extends l.d implements l.b {
        public byte[] dLi = null;
        public long iUm = -1;

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(133119);
            byte[] bArr = new byte[(this.dLi.length + 8)];
            int nowMilliSecond = (int) (Util.nowMilliSecond() - this.iUm);
            bArr[0] = (byte) ((nowMilliSecond >> 24) & 255);
            bArr[1] = (byte) ((nowMilliSecond >> 16) & 255);
            bArr[2] = (byte) ((nowMilliSecond >> 8) & 255);
            bArr[3] = (byte) (nowMilliSecond & 255);
            bArr[4] = (byte) ((this.dLi.length >> 24) & 255);
            bArr[5] = (byte) ((this.dLi.length >> 16) & 255);
            bArr[6] = (byte) ((this.dLi.length >> 8) & 255);
            bArr[7] = (byte) (this.dLi.length & 255);
            System.arraycopy(this.dLi, 0, bArr, 8, this.dLi.length);
            Util.dumpHex(bArr);
            AppMethodBeat.o(133119);
            return bArr;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 1000000190;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 268369922;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final boolean getShortSupport() {
            return false;
        }
    }

    public static class b extends l.e implements l.c {
        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            return 0;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return -1;
        }
    }
}
