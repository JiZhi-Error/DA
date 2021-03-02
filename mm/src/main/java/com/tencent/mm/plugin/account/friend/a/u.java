package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;

public final class u {

    public static class a extends l.d implements l.b {
        public bvt keU = new bvt();

        public a() {
            AppMethodBeat.i(131073);
            AppMethodBeat.o(131073);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(131074);
            setRsaInfo(ac.gtR());
            this.keU.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.keU.setBaseRequest(l.a(this));
            byte[] byteArray = this.keU.toByteArray();
            AppMethodBeat.o(131074);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return v2helper.EMethodSetIosMicAbCheckOff;
        }
    }

    public static class b extends l.e implements l.c {
        public bvu keV = new bvu();

        public b() {
            AppMethodBeat.i(131075);
            AppMethodBeat.o(131075);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(131076);
            this.keV = (bvu) new bvu().parseFrom(bArr);
            l.a(this, this.keV.getBaseResponse());
            int i2 = this.keV.getBaseResponse().Ret;
            AppMethodBeat.o(131076);
            return i2;
        }
    }
}
