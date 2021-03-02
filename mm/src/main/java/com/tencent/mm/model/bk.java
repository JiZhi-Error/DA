package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.sdk.platformtools.Util;

public final class bk {

    public static class a extends l.d implements l.b {
        public bxm iDS = new bxm();

        public a() {
            AppMethodBeat.i(20361);
            AppMethodBeat.o(20361);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(20362);
            setRsaInfo(ac.gtR());
            this.iDS.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.iDS.setBaseRequest(l.a(this));
            byte[] byteArray = this.iDS.toByteArray();
            AppMethodBeat.o(20362);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 616;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public bxn iDT = new bxn();

        public b() {
            AppMethodBeat.i(20363);
            AppMethodBeat.o(20363);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(20364);
            this.iDT = (bxn) new bxn().parseFrom(bArr);
            l.a(this, this.iDT.getBaseResponse());
            int i2 = this.iDT.getBaseResponse().Ret;
            AppMethodBeat.o(20364);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
