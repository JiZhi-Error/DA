package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.io;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k {

    public static class a extends l.d implements l.b {
        public io KzC = new io();
        public byte[] KzD;
        public byte[] KzE;

        public a() {
            AppMethodBeat.i(32080);
            AppMethodBeat.o(32080);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(32081);
            this.KzC.setBaseRequest(l.a(this));
            Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.KzD, Integer.valueOf(this.KzC.KMC), this.KzC.KMD, this.KzC.KME, this.KzC.KMF, Integer.valueOf(this.KzC.Scene), Long.valueOf(this.KzC.oTS), this.KzC.KMG, this.KzC.KMH);
            byte[] byteArray = this.KzC.toByteArray();
            AppMethodBeat.o(32081);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 1000;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 1000;
        }
    }

    public static class b extends l.e implements l.c {
        public iq KzF = new iq();

        public b() {
            AppMethodBeat.i(32082);
            AppMethodBeat.o(32082);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(32083);
            this.KzF = (iq) new iq().parseFrom(bArr);
            Log.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.KzF.Ret), this.KzF.KMI, this.KzF.KMJ);
            int i2 = this.KzF.Ret;
            AppMethodBeat.o(32083);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000;
        }
    }
}
