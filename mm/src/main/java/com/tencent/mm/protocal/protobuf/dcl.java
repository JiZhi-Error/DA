package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcl extends a {
    public LinkedList<ehi> MGX = new LinkedList<>();
    public String MHB;
    public String MHC;
    public LinkedList<Integer> MHD = new LinkedList<>();
    public LinkedList<Integer> MHE = new LinkedList<>();
    public String MHF;
    public boolean MHG;

    public dcl() {
        AppMethodBeat.i(209787);
        AppMethodBeat.o(209787);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209788);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MHB != null) {
                aVar.e(1, this.MHB);
            }
            if (this.MHC != null) {
                aVar.e(2, this.MHC);
            }
            aVar.e(3, 8, this.MGX);
            aVar.e(4, 2, this.MHD);
            aVar.e(5, 2, this.MHE);
            if (this.MHF != null) {
                aVar.e(6, this.MHF);
            }
            aVar.cc(7, this.MHG);
            AppMethodBeat.o(209788);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MHB != null ? g.a.a.b.b.a.f(1, this.MHB) + 0 : 0;
            if (this.MHC != null) {
                f2 += g.a.a.b.b.a.f(2, this.MHC);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.MGX) + g.a.a.a.c(4, 2, this.MHD) + g.a.a.a.c(5, 2, this.MHE);
            if (this.MHF != null) {
                c2 += g.a.a.b.b.a.f(6, this.MHF);
            }
            int fS = c2 + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(209788);
            return fS;
        } else if (i2 == 2) {
            this.MGX.clear();
            this.MHD.clear();
            this.MHE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209788);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcl dcl = (dcl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dcl.MHB = aVar3.UbS.readString();
                    AppMethodBeat.o(209788);
                    return 0;
                case 2:
                    dcl.MHC = aVar3.UbS.readString();
                    AppMethodBeat.o(209788);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehi ehi = new ehi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehi.populateBuilderWithField(aVar4, ehi, a.getNextFieldNumber(aVar4))) {
                        }
                        dcl.MGX.add(ehi);
                    }
                    AppMethodBeat.o(209788);
                    return 0;
                case 4:
                    dcl.MHD.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(209788);
                    return 0;
                case 5:
                    dcl.MHE.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(209788);
                    return 0;
                case 6:
                    dcl.MHF = aVar3.UbS.readString();
                    AppMethodBeat.o(209788);
                    return 0;
                case 7:
                    dcl.MHG = aVar3.UbS.yZ();
                    AppMethodBeat.o(209788);
                    return 0;
                default:
                    AppMethodBeat.o(209788);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209788);
            return -1;
        }
    }
}
