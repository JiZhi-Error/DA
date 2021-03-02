package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eir extends a {
    public int Kmn;
    public int NhR;
    public String NhS;
    public int NhT;
    public int NhU;
    public LinkedList<eiw> NhV = new LinkedList<>();
    public boolean NhW;
    public boolean dEF;

    public eir() {
        AppMethodBeat.i(153003);
        AppMethodBeat.o(153003);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153004);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.NhR);
            if (this.NhS != null) {
                aVar.e(2, this.NhS);
            }
            aVar.aM(3, this.Kmn);
            aVar.aM(4, this.NhT);
            aVar.aM(5, this.NhU);
            aVar.e(6, 8, this.NhV);
            aVar.cc(7, this.NhW);
            aVar.cc(8, this.dEF);
            AppMethodBeat.o(153004);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.NhR) + 0;
            if (this.NhS != null) {
                bu += g.a.a.b.b.a.f(2, this.NhS);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Kmn) + g.a.a.b.b.a.bu(4, this.NhT) + g.a.a.b.b.a.bu(5, this.NhU) + g.a.a.a.c(6, 8, this.NhV) + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(153004);
            return bu2;
        } else if (i2 == 2) {
            this.NhV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153004);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eir eir = (eir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eir.NhR = aVar3.UbS.zi();
                    AppMethodBeat.o(153004);
                    return 0;
                case 2:
                    eir.NhS = aVar3.UbS.readString();
                    AppMethodBeat.o(153004);
                    return 0;
                case 3:
                    eir.Kmn = aVar3.UbS.zi();
                    AppMethodBeat.o(153004);
                    return 0;
                case 4:
                    eir.NhT = aVar3.UbS.zi();
                    AppMethodBeat.o(153004);
                    return 0;
                case 5:
                    eir.NhU = aVar3.UbS.zi();
                    AppMethodBeat.o(153004);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eiw eiw = new eiw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eiw.populateBuilderWithField(aVar4, eiw, a.getNextFieldNumber(aVar4))) {
                        }
                        eir.NhV.add(eiw);
                    }
                    AppMethodBeat.o(153004);
                    return 0;
                case 7:
                    eir.NhW = aVar3.UbS.yZ();
                    AppMethodBeat.o(153004);
                    return 0;
                case 8:
                    eir.dEF = aVar3.UbS.yZ();
                    AppMethodBeat.o(153004);
                    return 0;
                default:
                    AppMethodBeat.o(153004);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153004);
            return -1;
        }
    }
}
