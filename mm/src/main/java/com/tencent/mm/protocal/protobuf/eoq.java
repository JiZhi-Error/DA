package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eoq extends a {
    public LinkedList<eor> Mzx = new LinkedList<>();
    public boolean lHF;
    public int lHG;
    public int lHH;
    public String lHI;
    public String lHJ;
    public String lHK;
    public String lHL;

    public eoq() {
        AppMethodBeat.i(123670);
        AppMethodBeat.o(123670);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123671);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Mzx);
            aVar.cc(2, this.lHF);
            aVar.aM(3, this.lHG);
            aVar.aM(4, this.lHH);
            if (this.lHI != null) {
                aVar.e(5, this.lHI);
            }
            if (this.lHJ != null) {
                aVar.e(6, this.lHJ);
            }
            if (this.lHK != null) {
                aVar.e(7, this.lHK);
            }
            if (this.lHL != null) {
                aVar.e(8, this.lHL);
            }
            AppMethodBeat.o(123671);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Mzx) + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.lHG) + g.a.a.b.b.a.bu(4, this.lHH);
            if (this.lHI != null) {
                c2 += g.a.a.b.b.a.f(5, this.lHI);
            }
            if (this.lHJ != null) {
                c2 += g.a.a.b.b.a.f(6, this.lHJ);
            }
            if (this.lHK != null) {
                c2 += g.a.a.b.b.a.f(7, this.lHK);
            }
            if (this.lHL != null) {
                c2 += g.a.a.b.b.a.f(8, this.lHL);
            }
            AppMethodBeat.o(123671);
            return c2;
        } else if (i2 == 2) {
            this.Mzx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123671);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoq eoq = (eoq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eor eor = new eor();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eor.populateBuilderWithField(aVar4, eor, a.getNextFieldNumber(aVar4))) {
                        }
                        eoq.Mzx.add(eor);
                    }
                    AppMethodBeat.o(123671);
                    return 0;
                case 2:
                    eoq.lHF = aVar3.UbS.yZ();
                    AppMethodBeat.o(123671);
                    return 0;
                case 3:
                    eoq.lHG = aVar3.UbS.zi();
                    AppMethodBeat.o(123671);
                    return 0;
                case 4:
                    eoq.lHH = aVar3.UbS.zi();
                    AppMethodBeat.o(123671);
                    return 0;
                case 5:
                    eoq.lHI = aVar3.UbS.readString();
                    AppMethodBeat.o(123671);
                    return 0;
                case 6:
                    eoq.lHJ = aVar3.UbS.readString();
                    AppMethodBeat.o(123671);
                    return 0;
                case 7:
                    eoq.lHK = aVar3.UbS.readString();
                    AppMethodBeat.o(123671);
                    return 0;
                case 8:
                    eoq.lHL = aVar3.UbS.readString();
                    AppMethodBeat.o(123671);
                    return 0;
                default:
                    AppMethodBeat.o(123671);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123671);
            return -1;
        }
    }
}
