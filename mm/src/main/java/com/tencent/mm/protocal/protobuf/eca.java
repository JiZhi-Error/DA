package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eca extends a {
    public int Llx;
    public int LsZ;
    public int NbR;
    public int NbS;
    public int NbT;
    public int NbU;
    public int NbV;
    public LinkedList<Integer> NbW = new LinkedList<>();
    public int NbX;
    public int NbY;
    public LinkedList<Integer> NbZ = new LinkedList<>();
    public int Nca;
    public int Ncb;

    public eca() {
        AppMethodBeat.i(115853);
        AppMethodBeat.o(115853);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115854);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LsZ);
            aVar.aM(2, this.NbR);
            aVar.aM(3, this.Llx);
            aVar.aM(4, this.NbS);
            aVar.aM(5, this.NbT);
            aVar.aM(6, this.NbU);
            aVar.aM(7, this.NbV);
            aVar.e(8, 2, this.NbW);
            aVar.aM(9, this.NbX);
            aVar.aM(10, this.NbY);
            aVar.e(11, 2, this.NbZ);
            aVar.aM(12, this.Nca);
            aVar.aM(13, this.Ncb);
            AppMethodBeat.o(115854);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LsZ) + 0 + g.a.a.b.b.a.bu(2, this.NbR) + g.a.a.b.b.a.bu(3, this.Llx) + g.a.a.b.b.a.bu(4, this.NbS) + g.a.a.b.b.a.bu(5, this.NbT) + g.a.a.b.b.a.bu(6, this.NbU) + g.a.a.b.b.a.bu(7, this.NbV) + g.a.a.a.c(8, 2, this.NbW) + g.a.a.b.b.a.bu(9, this.NbX) + g.a.a.b.b.a.bu(10, this.NbY) + g.a.a.a.c(11, 2, this.NbZ) + g.a.a.b.b.a.bu(12, this.Nca) + g.a.a.b.b.a.bu(13, this.Ncb);
            AppMethodBeat.o(115854);
            return bu;
        } else if (i2 == 2) {
            this.NbW.clear();
            this.NbZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115854);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eca eca = (eca) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eca.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 2:
                    eca.NbR = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 3:
                    eca.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 4:
                    eca.NbS = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 5:
                    eca.NbT = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 6:
                    eca.NbU = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 7:
                    eca.NbV = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 8:
                    eca.NbW.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115854);
                    return 0;
                case 9:
                    eca.NbX = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 10:
                    eca.NbY = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 11:
                    eca.NbZ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115854);
                    return 0;
                case 12:
                    eca.Nca = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                case 13:
                    eca.Ncb = aVar3.UbS.zi();
                    AppMethodBeat.o(115854);
                    return 0;
                default:
                    AppMethodBeat.o(115854);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115854);
            return -1;
        }
    }
}
