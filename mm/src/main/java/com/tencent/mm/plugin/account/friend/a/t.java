package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Util;

public final class t {

    public static class a extends l.d implements l.b {
        public bui keT = new bui();

        public a() {
            AppMethodBeat.i(131071);
            AppMethodBeat.o(131071);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(131072);
            setRsaInfo(ac.gtT());
            this.keT.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.keT.setBaseRequest(l.a(this));
            byte[] byteArray = this.keT.toByteArray();
            AppMethodBeat.o(131072);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 572;
        }
    }
}
