package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class blg extends a {
    public int LUj;
    public int LUk;
    public int LUl;
    public int LlA;
    public b LlC;
    public cbh LlD;
    public int Lly;
    public int Llz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143973);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lly);
            aVar.aM(2, this.Llz);
            aVar.aM(3, this.LlA);
            if (this.LlC != null) {
                aVar.c(4, this.LlC);
            }
            aVar.aM(5, this.LUj);
            aVar.aM(6, this.LUk);
            aVar.aM(7, this.LUl);
            if (this.LlD != null) {
                aVar.ni(8, this.LlD.computeSize());
                this.LlD.writeFields(aVar);
            }
            AppMethodBeat.o(143973);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lly) + 0 + g.a.a.b.b.a.bu(2, this.Llz) + g.a.a.b.b.a.bu(3, this.LlA);
            if (this.LlC != null) {
                bu += g.a.a.b.b.a.b(4, this.LlC);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LUj) + g.a.a.b.b.a.bu(6, this.LUk) + g.a.a.b.b.a.bu(7, this.LUl);
            if (this.LlD != null) {
                bu2 += g.a.a.a.nh(8, this.LlD.computeSize());
            }
            AppMethodBeat.o(143973);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143973);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blg blg = (blg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    blg.Lly = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 2:
                    blg.Llz = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 3:
                    blg.LlA = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 4:
                    blg.LlC = aVar3.UbS.hPo();
                    AppMethodBeat.o(143973);
                    return 0;
                case 5:
                    blg.LUj = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 6:
                    blg.LUk = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 7:
                    blg.LUl = aVar3.UbS.zi();
                    AppMethodBeat.o(143973);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbh cbh = new cbh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbh.populateBuilderWithField(aVar4, cbh, a.getNextFieldNumber(aVar4))) {
                        }
                        blg.LlD = cbh;
                    }
                    AppMethodBeat.o(143973);
                    return 0;
                default:
                    AppMethodBeat.o(143973);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143973);
            return -1;
        }
    }
}
