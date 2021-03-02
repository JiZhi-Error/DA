package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.o;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.sdk.platformtools.Util;

public final class s {

    public static class b extends l.d implements l.b {
        private boolean AEJ = true;
        public alt KAa = new alt();

        public b(boolean z) {
            AppMethodBeat.i(149120);
            this.AEJ = z;
            AppMethodBeat.o(149120);
        }

        @Override // com.tencent.mm.protocal.l.b
        public final byte[] toProtoBuf() {
            AppMethodBeat.i(149121);
            this.KAa.setBaseRequest(l.a(this));
            if (this.AEJ) {
                byte[] uuidRandom = Util.getUuidRandom();
                setRsaInfo(ac.gtR());
                this.KAa.Luv = com.tencent.mm.bw.b.cD(uuidRandom);
                if (!f.KyZ) {
                    setPassKey(uuidRandom);
                }
            }
            byte[] byteArray = this.KAa.toByteArray();
            AppMethodBeat.o(149121);
            return byteArray;
        }

        @Override // com.tencent.mm.protocal.l.b
        public final int getFuncId() {
            return this.AEJ ? 3789 : 3644;
        }

        @Override // com.tencent.mm.protocal.l.d
        public final int getCmdId() {
            return 0;
        }
    }

    public static class c extends l.e implements l.c {
        public alu KAb = new alu();

        public c() {
            AppMethodBeat.i(149122);
            AppMethodBeat.o(149122);
        }

        @Override // com.tencent.mm.protocal.l.c
        public final int fromProtoBuf(byte[] bArr) {
            AppMethodBeat.i(149123);
            this.KAb = (alu) new alu().parseFrom(bArr);
            l.a(this, this.KAb.getBaseResponse());
            int i2 = this.KAb.getBaseResponse().Ret;
            AppMethodBeat.o(149123);
            return i2;
        }

        @Override // com.tencent.mm.protocal.l.e
        public final int getCmdId() {
            return 0;
        }
    }

    public static class a extends o {
        private boolean AEJ = true;
        private b KzY;
        private c KzZ;

        public a(boolean z) {
            AppMethodBeat.i(149118);
            this.AEJ = z;
            this.KzY = new b(this.AEJ);
            this.KzZ = new c();
            AppMethodBeat.o(149118);
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return this.AEJ ? 3789 : 3644;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return this.AEJ ? "/cgi-bin/micromsg-bin/fpinitnl" : "/cgi-bin/micromsg-bin/fpinit";
        }

        @Override // com.tencent.mm.network.s, com.tencent.mm.ak.o
        public final int getOptions() {
            AppMethodBeat.i(149119);
            if (this.AEJ) {
                AppMethodBeat.o(149119);
                return 1;
            }
            int options = super.getOptions();
            AppMethodBeat.o(149119);
            return options;
        }

        @Override // com.tencent.mm.ak.o
        public final /* bridge */ /* synthetic */ l.d getReqObjImp() {
            return this.KzY;
        }

        @Override // com.tencent.mm.network.s
        public final /* bridge */ /* synthetic */ l.e getRespObj() {
            return this.KzZ;
        }
    }
}
