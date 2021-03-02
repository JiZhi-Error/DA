package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.emf;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.sdk.platformtools.Util;

public final class c {

    public static class a extends l.d implements l.b {
        public emf Fhq = new emf();

        public a() {
            AppMethodBeat.i(130805);
            AppMethodBeat.o(130805);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(130806);
            setRsaInfo(ac.gtR());
            this.Fhq.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
            this.Fhq.setBaseRequest(l.a(this));
            setPassKey(this.Fhq.KPW.getBuffer().toByteArray());
            byte[] byteArray = this.Fhq.toByteArray();
            AppMethodBeat.o(130806);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return ba.CTRL_INDEX;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends l.e implements l.c {
        public emg Fhr = new emg();

        public b() {
            AppMethodBeat.i(130807);
            AppMethodBeat.o(130807);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(130808);
            this.Fhr = (emg) new emg().parseFrom(bArr);
            l.a(this, this.Fhr.getBaseResponse());
            int i2 = this.Fhr.getBaseResponse().Ret;
            AppMethodBeat.o(130808);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }
}
