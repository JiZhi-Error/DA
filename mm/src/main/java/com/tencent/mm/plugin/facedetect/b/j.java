package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.Util;

public final class j {

    public static class a extends l.d implements l.b {
        public dme sPJ = new dme();

        public a() {
            AppMethodBeat.i(103595);
            AppMethodBeat.o(103595);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(103596);
            setRsaInfo(ac.gtR());
            this.sPJ.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.sPJ.setBaseRequest(l.a(this));
            setPassKey(this.sPJ.KPW.getBuffer().toByteArray());
            byte[] byteArray = this.sPJ.toByteArray();
            AppMethodBeat.o(103596);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 931;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public dmf sPK = new dmf();

        public b() {
            AppMethodBeat.i(103597);
            AppMethodBeat.o(103597);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(103598);
            this.sPK = (dmf) new dmf().parseFrom(bArr);
            l.a(this, this.sPK.getBaseResponse());
            int i2 = this.sPK.getBaseResponse().Ret;
            AppMethodBeat.o(103598);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
