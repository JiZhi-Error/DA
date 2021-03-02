package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;

public final class m extends a {

    public static class a extends l.d implements l.b {
        public int KzG = 0;
        public int netType;

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(32084);
            ls lsVar = new ls();
            lsVar.KOj = d.KyO;
            lsVar.KPr = 2;
            lsVar.KPs = this.netType;
            lsVar.KPt = this.KzG;
            Log.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(lsVar.KPt), Integer.valueOf(lsVar.KPs), Integer.valueOf(lsVar.KOj), Integer.valueOf(lsVar.KPr));
            byte[] bArr = null;
            try {
                bArr = lsVar.toByteArray();
            } catch (IOException e2) {
                Log.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", Util.stackTraceToString(e2));
            }
            AppMethodBeat.o(32084);
            return bArr;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return 0;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 312;
        }

        @Override // com.tencent.mm.protocal.l.b, com.tencent.mm.protocal.l.d
        public final boolean isRawData() {
            return true;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final boolean getShortSupport() {
            return false;
        }
    }

    public static class b extends l.e implements l.c {
        public lt KzH = new lt();

        public b() {
            AppMethodBeat.i(32085);
            AppMethodBeat.o(32085);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(32086);
            this.KzH = (lt) new lt().parseFrom(bArr);
            Log.d("MicroMsg.MMBgFg", "retcode:" + this.KzH.dDN);
            int i2 = this.KzH.dDN;
            AppMethodBeat.o(32086);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 1000000312;
        }

        @Override // com.tencent.mm.protocal.l.c, com.tencent.mm.protocal.l.e
        public final boolean isRawData() {
            return true;
        }
    }
}
