package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class eyp extends a {
    public b Nvo;
    public String UserName;
    public String iAc;
    public String oUJ;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32527);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(32527);
                throw bVar;
            } else if (this.oUJ == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(32527);
                throw bVar2;
            } else if (this.iAc == null) {
                g.a.a.b bVar3 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32527);
                throw bVar3;
            } else {
                aVar.aM(1, this.xNF);
                if (this.UserName != null) {
                    aVar.e(2, this.UserName);
                }
                if (this.oUJ != null) {
                    aVar.e(3, this.oUJ);
                }
                if (this.iAc != null) {
                    aVar.e(4, this.iAc);
                }
                if (this.Nvo != null) {
                    aVar.c(5, this.Nvo);
                }
                AppMethodBeat.o(32527);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNF) + 0;
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.oUJ != null) {
                bu += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(4, this.iAc);
            }
            if (this.Nvo != null) {
                bu += g.a.a.b.b.a.b(5, this.Nvo);
            }
            AppMethodBeat.o(32527);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.UserName == null) {
                g.a.a.b bVar4 = new g.a.a.b("Not all required fields were included: UserName");
                AppMethodBeat.o(32527);
                throw bVar4;
            } else if (this.oUJ == null) {
                g.a.a.b bVar5 = new g.a.a.b("Not all required fields were included: NickName");
                AppMethodBeat.o(32527);
                throw bVar5;
            } else if (this.iAc == null) {
                g.a.a.b bVar6 = new g.a.a.b("Not all required fields were included: Content");
                AppMethodBeat.o(32527);
                throw bVar6;
            } else {
                AppMethodBeat.o(32527);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyp eyp = (eyp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyp.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(32527);
                    return 0;
                case 2:
                    eyp.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(32527);
                    return 0;
                case 3:
                    eyp.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32527);
                    return 0;
                case 4:
                    eyp.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32527);
                    return 0;
                case 5:
                    eyp.Nvo = aVar3.UbS.hPo();
                    AppMethodBeat.o(32527);
                    return 0;
                default:
                    AppMethodBeat.o(32527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32527);
            return -1;
        }
    }
}
