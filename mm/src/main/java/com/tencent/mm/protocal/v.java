package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;

public final class v {

    public static class a extends l.d implements l.b {
        public ctr KAg = new ctr();

        public a() {
            AppMethodBeat.i(133115);
            AppMethodBeat.o(133115);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(133116);
            byte[] byteArray = this.KAg.toByteArray();
            AppMethodBeat.o(133116);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 138;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 121;
        }
    }

    public static class b extends l.e implements l.c {
        public cts KAh = new cts();

        public b() {
            AppMethodBeat.i(133117);
            AppMethodBeat.o(133117);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(133118);
            this.KAh = (cts) new cts().parseFrom(bArr);
            int i2 = this.KAh.Ret;
            AppMethodBeat.o(133118);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000000121;
        }
    }
}
