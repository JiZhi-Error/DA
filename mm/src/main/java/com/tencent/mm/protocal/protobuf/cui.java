package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cui extends a {
    public LinkedList<Double> AZP = new LinkedList<>();
    public ddh MzB;
    public double MzC;
    public String text;

    public cui() {
        AppMethodBeat.i(118410);
        AppMethodBeat.o(118410);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118411);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.text != null) {
                aVar.e(1, this.text);
            }
            if (this.MzB != null) {
                aVar.ni(2, this.MzB.computeSize());
                this.MzB.writeFields(aVar);
            }
            aVar.e(3, this.MzC);
            aVar.e(4, 4, this.AZP);
            AppMethodBeat.o(118411);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.text != null ? g.a.a.b.b.a.f(1, this.text) + 0 : 0;
            if (this.MzB != null) {
                f2 += g.a.a.a.nh(2, this.MzB.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.a.c(4, 4, this.AZP);
            AppMethodBeat.o(118411);
            return fS;
        } else if (i2 == 2) {
            this.AZP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118411);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cui cui = (cui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cui.text = aVar3.UbS.readString();
                    AppMethodBeat.o(118411);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ddh ddh = new ddh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ddh.populateBuilderWithField(aVar4, ddh, a.getNextFieldNumber(aVar4))) {
                        }
                        cui.MzB = ddh;
                    }
                    AppMethodBeat.o(118411);
                    return 0;
                case 3:
                    cui.MzC = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(118411);
                    return 0;
                case 4:
                    cui.AZP.add(Double.valueOf(Double.longBitsToDouble(aVar3.UbS.zn())));
                    AppMethodBeat.o(118411);
                    return 0;
                default:
                    AppMethodBeat.o(118411);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118411);
            return -1;
        }
    }
}
