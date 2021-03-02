package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cpn extends a {
    public cpm MvE;
    public int MvF;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225976);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            if (this.MvE != null) {
                aVar.ni(2, this.MvE.computeSize());
                this.MvE.writeFields(aVar);
            }
            aVar.aM(3, this.MvF);
            AppMethodBeat.o(225976);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.MvE != null) {
                bu += g.a.a.a.nh(2, this.MvE.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MvF);
            AppMethodBeat.o(225976);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225976);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpn cpn = (cpn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cpn.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(225976);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cpm cpm = new cpm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cpm.populateBuilderWithField(aVar4, cpm, a.getNextFieldNumber(aVar4))) {
                        }
                        cpn.MvE = cpm;
                    }
                    AppMethodBeat.o(225976);
                    return 0;
                case 3:
                    cpn.MvF = aVar3.UbS.zi();
                    AppMethodBeat.o(225976);
                    return 0;
                default:
                    AppMethodBeat.o(225976);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225976);
            return -1;
        }
    }
}
