package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.eqj;
import com.tencent.mm.sdk.platformtools.Util;

public final class bm {

    public static class a extends l.d implements l.b {
        public eqi iDW = new eqi();

        public a() {
            AppMethodBeat.i(20369);
            AppMethodBeat.o(20369);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(20370);
            setRsaInfo(ac.gtR());
            this.iDW.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.iDW.setBaseRequest(l.a(this));
            byte[] byteArray = this.iDW.toByteArray();
            AppMethodBeat.o(20370);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 617;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public eqj iDX = new eqj();

        public b() {
            AppMethodBeat.i(20371);
            AppMethodBeat.o(20371);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(20372);
            this.iDX = (eqj) new eqj().parseFrom(bArr);
            l.a(this, this.iDX.getBaseResponse());
            int i2 = this.iDX.getBaseResponse().Ret;
            AppMethodBeat.o(20372);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
