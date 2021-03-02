package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ecl extends a {
    public String NcC;
    public String NcD;
    public String NcE;
    public String NcF;
    public int jll;
    public int jlm;
    public int jln;
    public int jlo;
    public int opType;
    public long timeStamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125841);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NcC == null) {
                b bVar = new b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.o(125841);
                throw bVar;
            } else if (this.NcD == null) {
                b bVar2 = new b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.o(125841);
                throw bVar2;
            } else if (this.NcE == null) {
                b bVar3 = new b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.o(125841);
                throw bVar3;
            } else if (this.NcF == null) {
                b bVar4 = new b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.o(125841);
                throw bVar4;
            } else {
                aVar.aM(1, this.opType);
                aVar.aM(2, this.jlo);
                aVar.aM(3, this.jll);
                aVar.bb(4, this.timeStamp);
                aVar.aM(5, this.jlm);
                aVar.aM(6, this.jln);
                if (this.NcC != null) {
                    aVar.e(7, this.NcC);
                }
                if (this.NcD != null) {
                    aVar.e(8, this.NcD);
                }
                if (this.NcE != null) {
                    aVar.e(9, this.NcE);
                }
                if (this.NcF != null) {
                    aVar.e(10, this.NcF);
                }
                AppMethodBeat.o(125841);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.opType) + 0 + g.a.a.b.b.a.bu(2, this.jlo) + g.a.a.b.b.a.bu(3, this.jll) + g.a.a.b.b.a.r(4, this.timeStamp) + g.a.a.b.b.a.bu(5, this.jlm) + g.a.a.b.b.a.bu(6, this.jln);
            if (this.NcC != null) {
                bu += g.a.a.b.b.a.f(7, this.NcC);
            }
            if (this.NcD != null) {
                bu += g.a.a.b.b.a.f(8, this.NcD);
            }
            if (this.NcE != null) {
                bu += g.a.a.b.b.a.f(9, this.NcE);
            }
            if (this.NcF != null) {
                bu += g.a.a.b.b.a.f(10, this.NcF);
            }
            AppMethodBeat.o(125841);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NcC == null) {
                b bVar5 = new b("Not all required fields were included: StatusDesc1");
                AppMethodBeat.o(125841);
                throw bVar5;
            } else if (this.NcD == null) {
                b bVar6 = new b("Not all required fields were included: StatusDesc2");
                AppMethodBeat.o(125841);
                throw bVar6;
            } else if (this.NcE == null) {
                b bVar7 = new b("Not all required fields were included: DataFlowSourceInfo");
                AppMethodBeat.o(125841);
                throw bVar7;
            } else if (this.NcF == null) {
                b bVar8 = new b("Not all required fields were included: DataFlowResultInfo");
                AppMethodBeat.o(125841);
                throw bVar8;
            } else {
                AppMethodBeat.o(125841);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecl ecl = (ecl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecl.opType = aVar3.UbS.zi();
                    AppMethodBeat.o(125841);
                    return 0;
                case 2:
                    ecl.jlo = aVar3.UbS.zi();
                    AppMethodBeat.o(125841);
                    return 0;
                case 3:
                    ecl.jll = aVar3.UbS.zi();
                    AppMethodBeat.o(125841);
                    return 0;
                case 4:
                    ecl.timeStamp = aVar3.UbS.zl();
                    AppMethodBeat.o(125841);
                    return 0;
                case 5:
                    ecl.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(125841);
                    return 0;
                case 6:
                    ecl.jln = aVar3.UbS.zi();
                    AppMethodBeat.o(125841);
                    return 0;
                case 7:
                    ecl.NcC = aVar3.UbS.readString();
                    AppMethodBeat.o(125841);
                    return 0;
                case 8:
                    ecl.NcD = aVar3.UbS.readString();
                    AppMethodBeat.o(125841);
                    return 0;
                case 9:
                    ecl.NcE = aVar3.UbS.readString();
                    AppMethodBeat.o(125841);
                    return 0;
                case 10:
                    ecl.NcF = aVar3.UbS.readString();
                    AppMethodBeat.o(125841);
                    return 0;
                default:
                    AppMethodBeat.o(125841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125841);
            return -1;
        }
    }
}
