package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.sdk.platformtools.Util;

public final class r {

    public static class b extends l.d implements l.b {
        private boolean AEJ = true;
        public alr KzW = new alr();

        public b(boolean z) {
            AppMethodBeat.i(149114);
            this.AEJ = z;
            AppMethodBeat.o(149114);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(149115);
            this.KzW.setBaseRequest(l.a(this));
            if (this.AEJ) {
                byte[] uuidRandom = Util.getUuidRandom();
                setRsaInfo(ac.gtR());
                this.KzW.Luv = com.tencent.mm.bw.b.cD(uuidRandom);
                if (!f.KyZ) {
                    setPassKey(uuidRandom);
                }
            }
            byte[] byteArray = this.KzW.toByteArray();
            AppMethodBeat.o(149115);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return this.AEJ ? 3944 : 836;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class c extends l.e implements l.c {
        public als KzX = new als();

        public c() {
            AppMethodBeat.i(149116);
            AppMethodBeat.o(149116);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(149117);
            this.KzX = (als) new als().parseFrom(bArr);
            l.a(this, this.KzX.getBaseResponse());
            int i2 = this.KzX.getBaseResponse().Ret;
            AppMethodBeat.o(149117);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }

    public static class a extends o {
        private boolean AEJ = true;
        private b KzU;
        private c KzV;

        public a(boolean z) {
            AppMethodBeat.i(149112);
            this.AEJ = z;
            this.KzU = new b(this.AEJ);
            this.KzV = new c();
            AppMethodBeat.o(149112);
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return this.AEJ ? 3944 : 836;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return this.AEJ ? "/cgi-bin/micromsg-bin/fpfreshnl" : "/cgi-bin/micromsg-bin/fpfresh";
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            AppMethodBeat.i(149113);
            if (this.AEJ) {
                AppMethodBeat.o(149113);
                return 1;
            }
            int options = super.getOptions();
            AppMethodBeat.o(149113);
            return options;
        }

        @Override // com.tencent.mm.ak.o
        public final /* bridge */ /* synthetic */ l.d getReqObjImp() {
            return this.KzU;
        }

        @Override // com.tencent.mm.network.s
        public final /* bridge */ /* synthetic */ l.e getRespObj() {
            return this.KzV;
        }
    }
}
