package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.n;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.sdk.platformtools.Util;

public final class s {

    public static class a extends l.d implements l.b {
        public air keR = new air();

        public a() {
            AppMethodBeat.i(131067);
            AppMethodBeat.o(131067);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(131068);
            setRsaInfo(ac.gtT());
            this.keR.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.keR.setBaseRequest(l.a(this));
            byte[] byteArray = this.keR.toByteArray();
            AppMethodBeat.o(131068);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return n.CTRL_INDEX;
        }
    }

    public static class b extends l.e implements l.c {
        public ais keS = new ais();

        public b() {
            AppMethodBeat.i(131069);
            AppMethodBeat.o(131069);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(131070);
            this.keS = (ais) new ais().parseFrom(bArr);
            l.a(this, this.keS.getBaseResponse());
            int i2 = this.keS.getBaseResponse().Ret;
            AppMethodBeat.o(131070);
            return i2;
        }
    }
}
