package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.sdk.platformtools.Util;

public final class v {

    public static class a extends l.d implements l.b {
        public bxj keW = new bxj();

        public a() {
            AppMethodBeat.i(131077);
            AppMethodBeat.o(131077);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(131078);
            setRsaInfo(ac.gtT());
            this.keW.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.keW.setBaseRequest(l.a(this));
            byte[] byteArray = this.keW.toByteArray();
            AppMethodBeat.o(131078);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 107;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 48;
        }
    }
}
