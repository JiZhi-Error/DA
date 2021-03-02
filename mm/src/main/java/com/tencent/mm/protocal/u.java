package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctk;

public final class u {

    public static class a extends l.d implements l.b {
        public ctj KAe = new ctj();

        public a() {
            AppMethodBeat.i(133111);
            AppMethodBeat.o(133111);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(133112);
            this.KAe.setBaseRequest(l.a(this));
            byte[] byteArray = this.KAe.toByteArray();
            AppMethodBeat.o(133112);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 27;
        }
    }

    public static class b extends l.e implements l.c {
        public ctk KAf = new ctk();

        public b() {
            AppMethodBeat.i(133113);
            AppMethodBeat.o(133113);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133114);
            this.KAf = (ctk) new ctk().parseFrom(bArr);
            l.a(this, this.KAf.getBaseResponse());
            int i2 = this.KAf.getBaseResponse().Ret;
            AppMethodBeat.o(133114);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000000027;
        }
    }
}
