package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dnm extends a {
    public String AesKey;
    public String LxW;
    public String MD5;
    public String MQE;
    public String MQF;
    public String MQG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115963);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LxW == null) {
                b bVar = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(115963);
                throw bVar;
            } else if (this.AesKey == null) {
                b bVar2 = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(115963);
                throw bVar2;
            } else if (this.MD5 == null) {
                b bVar3 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(115963);
                throw bVar3;
            } else if (this.MQE == null) {
                b bVar4 = new b("Not all required fields were included: OriginFileID");
                AppMethodBeat.o(115963);
                throw bVar4;
            } else if (this.MQF == null) {
                b bVar5 = new b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.o(115963);
                throw bVar5;
            } else if (this.MQG == null) {
                b bVar6 = new b("Not all required fields were included: OriginMD5");
                AppMethodBeat.o(115963);
                throw bVar6;
            } else {
                if (this.LxW != null) {
                    aVar.e(1, this.LxW);
                }
                if (this.AesKey != null) {
                    aVar.e(2, this.AesKey);
                }
                if (this.MD5 != null) {
                    aVar.e(3, this.MD5);
                }
                if (this.MQE != null) {
                    aVar.e(4, this.MQE);
                }
                if (this.MQF != null) {
                    aVar.e(5, this.MQF);
                }
                if (this.MQG != null) {
                    aVar.e(6, this.MQG);
                }
                AppMethodBeat.o(115963);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.LxW != null ? g.a.a.b.b.a.f(1, this.LxW) + 0 : 0;
            if (this.AesKey != null) {
                f2 += g.a.a.b.b.a.f(2, this.AesKey);
            }
            if (this.MD5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.MD5);
            }
            if (this.MQE != null) {
                f2 += g.a.a.b.b.a.f(4, this.MQE);
            }
            if (this.MQF != null) {
                f2 += g.a.a.b.b.a.f(5, this.MQF);
            }
            if (this.MQG != null) {
                f2 += g.a.a.b.b.a.f(6, this.MQG);
            }
            AppMethodBeat.o(115963);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LxW == null) {
                b bVar7 = new b("Not all required fields were included: FileID");
                AppMethodBeat.o(115963);
                throw bVar7;
            } else if (this.AesKey == null) {
                b bVar8 = new b("Not all required fields were included: AesKey");
                AppMethodBeat.o(115963);
                throw bVar8;
            } else if (this.MD5 == null) {
                b bVar9 = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(115963);
                throw bVar9;
            } else if (this.MQE == null) {
                b bVar10 = new b("Not all required fields were included: OriginFileID");
                AppMethodBeat.o(115963);
                throw bVar10;
            } else if (this.MQF == null) {
                b bVar11 = new b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.o(115963);
                throw bVar11;
            } else if (this.MQG == null) {
                b bVar12 = new b("Not all required fields were included: OriginMD5");
                AppMethodBeat.o(115963);
                throw bVar12;
            } else {
                AppMethodBeat.o(115963);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnm dnm = (dnm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnm.LxW = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                case 2:
                    dnm.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                case 3:
                    dnm.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                case 4:
                    dnm.MQE = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                case 5:
                    dnm.MQF = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                case 6:
                    dnm.MQG = aVar3.UbS.readString();
                    AppMethodBeat.o(115963);
                    return 0;
                default:
                    AppMethodBeat.o(115963);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115963);
            return -1;
        }
    }
}
