package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eak extends a {
    public dck MZM;
    public int MZN;
    public int MZO;
    public int MZP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209816);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MZM != null) {
                aVar.ni(1, this.MZM.computeSize());
                this.MZM.writeFields(aVar);
            }
            aVar.aM(2, this.MZN);
            aVar.aM(3, this.MZO);
            aVar.aM(4, this.MZP);
            AppMethodBeat.o(209816);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MZM != null ? g.a.a.a.nh(1, this.MZM.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MZN) + g.a.a.b.b.a.bu(3, this.MZO) + g.a.a.b.b.a.bu(4, this.MZP);
            AppMethodBeat.o(209816);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209816);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eak eak = (eak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dck dck = new dck();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dck.populateBuilderWithField(aVar4, dck, a.getNextFieldNumber(aVar4))) {
                        }
                        eak.MZM = dck;
                    }
                    AppMethodBeat.o(209816);
                    return 0;
                case 2:
                    eak.MZN = aVar3.UbS.zi();
                    AppMethodBeat.o(209816);
                    return 0;
                case 3:
                    eak.MZO = aVar3.UbS.zi();
                    AppMethodBeat.o(209816);
                    return 0;
                case 4:
                    eak.MZP = aVar3.UbS.zi();
                    AppMethodBeat.o(209816);
                    return 0;
                default:
                    AppMethodBeat.o(209816);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209816);
            return -1;
        }
    }
}
