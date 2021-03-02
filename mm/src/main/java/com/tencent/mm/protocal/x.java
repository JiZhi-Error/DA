package com.tencent.mm.protocal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.charset.StandardCharsets;

public final class x {

    public static class a extends l.d implements l.b {
        public cto KAi = new cto();
        public byte[] Kzv;

        public a() {
            AppMethodBeat.i(133120);
            AppMethodBeat.o(133120);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            byte[] bArr;
            int i2;
            int i3 = -1;
            AppMethodBeat.i(133121);
            setRsaInfo(ac.gtR());
            this.KAi.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.KAi.setBaseRequest(l.a(this));
            this.KAi.Myz = ChannelUtil.historyChannelId;
            aif aif = new aif();
            aif.LrO = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(aif.LrO, pByteArray, pByteArray2);
            byte[] bArr2 = pByteArray.value;
            byte[] bArr3 = pByteArray2.value;
            if (bArr3 != null) {
                bArr = bArr3;
            } else {
                bArr = new byte[0];
            }
            this.Kzv = bArr;
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(aif.LrO);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
            objArr[3] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
            objArr[4] = Util.dumpHex(bArr2);
            objArr[5] = Util.dumpHex(bArr3);
            Log.d("MicroMsg.MMReg2.Req", "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s", objArr);
            aif.KLU = new SKBuiltinBuffer_t().setBuffer(bArr2);
            this.KAi.KLY = aif;
            try {
                byte[] exJ = d.INSTANCE.exJ();
                Object[] objArr2 = new Object[1];
                if (exJ != null) {
                    i2 = exJ.length;
                } else {
                    i2 = -1;
                }
                objArr2[0] = Integer.valueOf(i2);
                Log.d("MicroMsg.MMReg2.Req", "[debug] ccd set on reg, len: %s", objArr2);
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(exJ);
                ewf.NtU = new SKBuiltinBuffer_t().setBuffer(d.INSTANCE.exM());
                Object[] objArr3 = new Object[1];
                if (ewf.NtU != null) {
                    i3 = ewf.NtU.getILen();
                }
                objArr3[0] = Integer.valueOf(i3);
                Log.d("MicroMsg.MMReg2.Req", "[debug] devtok on reg, len: %s", objArr3);
                this.KAi.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.MMReg2.Req", th, "cc throws exception.", new Object[0]);
            }
            this.KAi.KLS = new dfx();
            String bjr = com.tencent.mm.network.b.bjq().bjr();
            if (!TextUtils.isEmpty(bjr)) {
                this.KAi.KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
                this.KAi.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(bjr.getBytes(StandardCharsets.ISO_8859_1));
            } else {
                this.KAi.KLS.LrO = 0;
                this.KAi.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
                Log.e("MicroMsg.MMReg2.Req", "get sign key failed");
            }
            b.a aVar = new b.a();
            aVar.jDD = com.tencent.mm.network.b.bjq().bjr();
            aVar.jDC = com.tencent.mm.network.b.bjq().jDC;
            setCGiVerifyKey(aVar);
            byte[] byteArray = this.KAi.toByteArray();
            AppMethodBeat.o(133121);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 126;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public ctp KAj = new ctp();
        public byte[] KzA;
        private byte[] KzB;
        public int hku = 0;
        private byte[] jDp;
        private byte[] jDq;

        public b() {
            AppMethodBeat.i(133122);
            AppMethodBeat.o(133122);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133123);
            this.hku = 0;
            this.KAj = (ctp) new ctp().parseFrom(bArr);
            l.a(this, this.KAj.getBaseResponse());
            this.hku = 0;
            int i2 = this.KAj.getBaseResponse().Ret;
            AppMethodBeat.o(133123);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }

        public final void b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            AppMethodBeat.i(133124);
            this.KzB = bArr;
            this.jDp = bArr2;
            this.jDq = bArr3;
            Log.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", Util.secPrint(Util.dumpHex(this.KzB)), Util.secPrint(Util.dumpHex(this.jDp)), Util.secPrint(Util.dumpHex(this.jDq)));
            AppMethodBeat.o(133124);
        }

        public final byte[] aiZ(int i2) {
            byte[] bArr = new byte[0];
            switch (i2) {
                case 1:
                    return this.KzB;
                case 2:
                    return this.jDp;
                case 3:
                    return this.jDq;
                default:
                    return bArr;
            }
        }
    }
}
