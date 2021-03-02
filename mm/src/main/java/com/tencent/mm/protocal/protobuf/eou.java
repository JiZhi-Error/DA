package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eou extends a {
    public String KHk;
    public String LoI;
    public String NmU;
    public String UserName;
    public String ked;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117939);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(117939);
                throw bVar;
            } else if (this.NmU == null) {
                b bVar2 = new b("Not all required fields were included: MatchWord");
                AppMethodBeat.o(117939);
                throw bVar2;
            } else {
                if (this.UserName != null) {
                    aVar.e(1, this.UserName);
                }
                if (this.NmU != null) {
                    aVar.e(2, this.NmU);
                }
                if (this.oUJ != null) {
                    aVar.e(3, this.oUJ);
                }
                if (this.LoI != null) {
                    aVar.e(4, this.LoI);
                }
                if (this.ked != null) {
                    aVar.e(5, this.ked);
                }
                if (this.KHk != null) {
                    aVar.e(6, this.KHk);
                }
                AppMethodBeat.o(117939);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.NmU != null) {
                f2 += g.a.a.b.b.a.f(2, this.NmU);
            }
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.LoI != null) {
                f2 += g.a.a.b.b.a.f(4, this.LoI);
            }
            if (this.ked != null) {
                f2 += g.a.a.b.b.a.f(5, this.ked);
            }
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(6, this.KHk);
            }
            AppMethodBeat.o(117939);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                b bVar3 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(117939);
                throw bVar3;
            } else if (this.NmU == null) {
                b bVar4 = new b("Not all required fields were included: MatchWord");
                AppMethodBeat.o(117939);
                throw bVar4;
            } else {
                AppMethodBeat.o(117939);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eou eou = (eou) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eou.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                case 2:
                    eou.NmU = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                case 3:
                    eou.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                case 4:
                    eou.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                case 5:
                    eou.ked = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                case 6:
                    eou.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(117939);
                    return 0;
                default:
                    AppMethodBeat.o(117939);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117939);
            return -1;
        }
    }
}
