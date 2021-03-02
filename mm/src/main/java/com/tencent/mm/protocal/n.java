package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Util;

public final class n {

    public static class a extends l.d implements l.b {
        public mh KzI = new mh();

        public a() {
            AppMethodBeat.i(222853);
            AppMethodBeat.o(222853);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(222854);
            setRsaInfo(ac.gtR());
            this.KzI.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.KzI.setBaseRequest(l.a(this));
            byte[] byteArray = this.KzI.toByteArray();
            AppMethodBeat.o(222854);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 145;
        }
    }

    public static class b extends l.e implements l.c {
        public mi KzJ = new mi();

        public b() {
            AppMethodBeat.i(222855);
            AppMethodBeat.o(222855);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(222856);
            this.KzJ = (mi) new mi().parseFrom(bArr);
            l.a(this, this.KzJ.getBaseResponse());
            int i2 = this.KzJ.getBaseResponse().Ret;
            AppMethodBeat.o(222856);
            return i2;
        }
    }
}
