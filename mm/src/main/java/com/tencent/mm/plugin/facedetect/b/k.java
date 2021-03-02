package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Util;

public final class k {

    public static class a extends l.d implements l.b {
        public epl sPL = new epl();

        public a() {
            AppMethodBeat.i(103599);
            AppMethodBeat.o(103599);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(103600);
            setRsaInfo(ac.gtR());
            this.sPL.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.sPL.setBaseRequest(l.a(this));
            setPassKey(this.sPL.KPW.getBuffer().toByteArray());
            byte[] byteArray = this.sPL.toByteArray();
            AppMethodBeat.o(103600);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 930;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public epm sPM = new epm();

        public b() {
            AppMethodBeat.i(103601);
            AppMethodBeat.o(103601);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(103602);
            this.sPM = (epm) new epm().parseFrom(bArr);
            l.a(this, this.sPM.getBaseResponse());
            int i2 = this.sPM.getBaseResponse().Ret;
            AppMethodBeat.o(103602);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
