package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eby extends a {
    public int NbD;
    public int NbE;
    public int NbF;
    public esq NbG;
    public int NbH;
    public int NbI;
    public int NbJ;
    public int NbK;
    public LinkedList<Integer> NbL = new LinkedList<>();
    public int NbM;
    public LinkedList<Integer> NbN = new LinkedList<>();
    public int NbO;
    public LinkedList<Integer> NbP = new LinkedList<>();
    public String NbQ;

    public eby() {
        AppMethodBeat.i(115851);
        AppMethodBeat.o(115851);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115852);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NbG == null) {
                b bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(115852);
                throw bVar;
            }
            aVar.aM(1, this.NbD);
            aVar.aM(2, this.NbE);
            aVar.aM(3, this.NbF);
            if (this.NbG != null) {
                aVar.ni(4, this.NbG.computeSize());
                this.NbG.writeFields(aVar);
            }
            aVar.aM(5, this.NbH);
            aVar.aM(6, this.NbI);
            aVar.aM(7, this.NbJ);
            aVar.aM(8, this.NbK);
            aVar.f(9, 2, this.NbL);
            aVar.aM(10, this.NbM);
            aVar.f(11, 2, this.NbN);
            aVar.aM(12, this.NbO);
            aVar.f(13, 2, this.NbP);
            if (this.NbQ != null) {
                aVar.e(14, this.NbQ);
            }
            AppMethodBeat.o(115852);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NbD) + 0 + g.a.a.b.b.a.bu(2, this.NbE) + g.a.a.b.b.a.bu(3, this.NbF);
            if (this.NbG != null) {
                bu += g.a.a.a.nh(4, this.NbG.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.NbH) + g.a.a.b.b.a.bu(6, this.NbI) + g.a.a.b.b.a.bu(7, this.NbJ) + g.a.a.b.b.a.bu(8, this.NbK) + g.a.a.a.d(9, 2, this.NbL) + g.a.a.b.b.a.bu(10, this.NbM) + g.a.a.a.d(11, 2, this.NbN) + g.a.a.b.b.a.bu(12, this.NbO) + g.a.a.a.d(13, 2, this.NbP);
            if (this.NbQ != null) {
                bu2 += g.a.a.b.b.a.f(14, this.NbQ);
            }
            AppMethodBeat.o(115852);
            return bu2;
        } else if (i2 == 2) {
            this.NbL.clear();
            this.NbN.clear();
            this.NbP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NbG == null) {
                b bVar2 = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(115852);
                throw bVar2;
            }
            AppMethodBeat.o(115852);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eby eby = (eby) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eby.NbD = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 2:
                    eby.NbE = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 3:
                    eby.NbF = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esq.populateBuilderWithField(aVar4, esq, a.getNextFieldNumber(aVar4))) {
                        }
                        eby.NbG = esq;
                    }
                    AppMethodBeat.o(115852);
                    return 0;
                case 5:
                    eby.NbH = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 6:
                    eby.NbI = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 7:
                    eby.NbJ = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 8:
                    eby.NbK = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 9:
                    eby.NbL = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115852);
                    return 0;
                case 10:
                    eby.NbM = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 11:
                    eby.NbN = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115852);
                    return 0;
                case 12:
                    eby.NbO = aVar3.UbS.zi();
                    AppMethodBeat.o(115852);
                    return 0;
                case 13:
                    eby.NbP = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115852);
                    return 0;
                case 14:
                    eby.NbQ = aVar3.UbS.readString();
                    AppMethodBeat.o(115852);
                    return 0;
                default:
                    AppMethodBeat.o(115852);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115852);
            return -1;
        }
    }
}
