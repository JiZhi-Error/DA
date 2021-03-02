package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {

    public static class a extends l.d implements l.b {
        public bjh sPH = new bjh();

        public a() {
            AppMethodBeat.i(103591);
            AppMethodBeat.o(103591);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(103592);
            setRsaInfo(ac.gtR());
            this.sPH.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.sPH.setBaseRequest(l.a(this));
            setPassKey(this.sPH.KPW.getBuffer().toByteArray());
            byte[] byteArray = this.sPH.toByteArray();
            AppMethodBeat.o(103592);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 733;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public bji sPI = new bji();

        public b() {
            AppMethodBeat.i(103593);
            AppMethodBeat.o(103593);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(103594);
            this.sPI = (bji) new bji().parseFrom(bArr);
            l.a(this, this.sPI.getBaseResponse());
            int i2 = this.sPI.getBaseResponse().Ret;
            AppMethodBeat.o(103594);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
