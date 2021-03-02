package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.Util;

public final class t {

    public static class a extends l.d implements l.b {
        public bkv KAc = new bkv();

        public a() {
            AppMethodBeat.i(133107);
            AppMethodBeat.o(133107);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(133108);
            setRsaInfo(ac.gtT());
            this.KAc.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.KAc.LTJ = ac.gtR().ver;
            this.KAc.setBaseRequest(l.a(this));
            byte[] byteArray = this.KAc.toByteArray();
            AppMethodBeat.o(133108);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 381;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends l.e implements l.c {
        public bkw KAd = new bkw();

        public b() {
            AppMethodBeat.i(133109);
            AppMethodBeat.o(133109);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133110);
            this.KAd = (bkw) new bkw().parseFrom(bArr);
            l.a(this, this.KAd.getBaseResponse());
            int i2 = this.KAd.getBaseResponse().Ret;
            AppMethodBeat.o(133110);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000000179;
        }
    }
}
