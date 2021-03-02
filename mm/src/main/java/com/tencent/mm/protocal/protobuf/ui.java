package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ui extends a {
    public String LdJ;
    public String LdK;
    public String LdL;
    public int LdM;
    public String LdN;
    public un LdO;
    public String LdP;
    public int LdQ;
    public int LdR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113959);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LdJ != null) {
                aVar.e(1, this.LdJ);
            }
            if (this.LdK != null) {
                aVar.e(2, this.LdK);
            }
            if (this.LdL != null) {
                aVar.e(3, this.LdL);
            }
            aVar.aM(4, this.LdM);
            if (this.LdN != null) {
                aVar.e(5, this.LdN);
            }
            if (this.LdO != null) {
                aVar.ni(6, this.LdO.computeSize());
                this.LdO.writeFields(aVar);
            }
            if (this.LdP != null) {
                aVar.e(7, this.LdP);
            }
            aVar.aM(8, this.LdQ);
            aVar.aM(9, this.LdR);
            AppMethodBeat.o(113959);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LdJ != null ? g.a.a.b.b.a.f(1, this.LdJ) + 0 : 0;
            if (this.LdK != null) {
                f2 += g.a.a.b.b.a.f(2, this.LdK);
            }
            if (this.LdL != null) {
                f2 += g.a.a.b.b.a.f(3, this.LdL);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LdM);
            if (this.LdN != null) {
                bu += g.a.a.b.b.a.f(5, this.LdN);
            }
            if (this.LdO != null) {
                bu += g.a.a.a.nh(6, this.LdO.computeSize());
            }
            if (this.LdP != null) {
                bu += g.a.a.b.b.a.f(7, this.LdP);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.LdQ) + g.a.a.b.b.a.bu(9, this.LdR);
            AppMethodBeat.o(113959);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113959);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ui uiVar = (ui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    uiVar.LdJ = aVar3.UbS.readString();
                    AppMethodBeat.o(113959);
                    return 0;
                case 2:
                    uiVar.LdK = aVar3.UbS.readString();
                    AppMethodBeat.o(113959);
                    return 0;
                case 3:
                    uiVar.LdL = aVar3.UbS.readString();
                    AppMethodBeat.o(113959);
                    return 0;
                case 4:
                    uiVar.LdM = aVar3.UbS.zi();
                    AppMethodBeat.o(113959);
                    return 0;
                case 5:
                    uiVar.LdN = aVar3.UbS.readString();
                    AppMethodBeat.o(113959);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        uiVar.LdO = unVar;
                    }
                    AppMethodBeat.o(113959);
                    return 0;
                case 7:
                    uiVar.LdP = aVar3.UbS.readString();
                    AppMethodBeat.o(113959);
                    return 0;
                case 8:
                    uiVar.LdQ = aVar3.UbS.zi();
                    AppMethodBeat.o(113959);
                    return 0;
                case 9:
                    uiVar.LdR = aVar3.UbS.zi();
                    AppMethodBeat.o(113959);
                    return 0;
                default:
                    AppMethodBeat.o(113959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113959);
            return -1;
        }
    }
}
