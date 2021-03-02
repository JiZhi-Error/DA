package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.sdk.platformtools.Util;

public final class bl {

    public static class a extends l.d implements l.b {
        public bxq iDU = new bxq();

        public a() {
            AppMethodBeat.i(20365);
            AppMethodBeat.o(20365);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(20366);
            setRsaInfo(ac.gtR());
            this.iDU.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.iDU.setBaseRequest(l.a(this));
            byte[] byteArray = this.iDU.toByteArray();
            AppMethodBeat.o(20366);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return ce.CTRL_INDEX;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public bxr iDV = new bxr();

        public b() {
            AppMethodBeat.i(20367);
            AppMethodBeat.o(20367);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(20368);
            this.iDV = (bxr) new bxr().parseFrom(bArr);
            l.a(this, this.iDV.getBaseResponse());
            int i2 = this.iDV.getBaseResponse().Ret;
            AppMethodBeat.o(20368);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
