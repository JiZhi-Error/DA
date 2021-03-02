package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.storage.j;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cfv;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {

    public static class a extends l.d implements l.b {
        public cfv CxL = new cfv();

        public a() {
            AppMethodBeat.i(143787);
            AppMethodBeat.o(143787);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(143788);
            setRsaInfo(ac.gtS());
            this.CxL.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.CxL.setBaseRequest(l.a(this));
            byte[] byteArray = this.CxL.toByteArray();
            AppMethodBeat.o(143788);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return j.CTRL_INDEX;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }
}
