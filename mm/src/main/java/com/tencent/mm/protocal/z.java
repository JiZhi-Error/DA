package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class z {

    public static class a extends l.d implements l.b {
        public dtl KAp = new dtl();

        public a() {
            AppMethodBeat.i(152472);
            AppMethodBeat.o(152472);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(152473);
            this.KAp.setBaseRequest(l.a(this));
            byte[] byteArray = this.KAp.toByteArray();
            AppMethodBeat.o(152473);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 42;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
        }
    }

    public static class b extends l.e implements l.c {
        public dtm KAq = new dtm();

        public b() {
            AppMethodBeat.i(152474);
            AppMethodBeat.o(152474);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(152475);
            this.KAq = (dtm) new dtm().parseFrom(bArr);
            l.a(this, this.KAq.getBaseResponse());
            int i2 = this.KAq.getBaseResponse().Ret;
            AppMethodBeat.o(152475);
            return i2;
        }
    }
}
