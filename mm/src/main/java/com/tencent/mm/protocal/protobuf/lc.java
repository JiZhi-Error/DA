package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class lc extends a {
    public LinkedList<lb> KOT = new LinkedList<>();
    public la KOU;
    public int KOV;

    public lc() {
        AppMethodBeat.i(82389);
        AppMethodBeat.o(82389);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82390);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KOT);
            if (this.KOU != null) {
                aVar.ni(2, this.KOU.computeSize());
                this.KOU.writeFields(aVar);
            }
            aVar.aM(3, this.KOV);
            AppMethodBeat.o(82390);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KOT) + 0;
            if (this.KOU != null) {
                c2 += g.a.a.a.nh(2, this.KOU.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.KOV);
            AppMethodBeat.o(82390);
            return bu;
        } else if (i2 == 2) {
            this.KOT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82390);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            lc lcVar = (lc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        lb lbVar = new lb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lbVar.populateBuilderWithField(aVar4, lbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lcVar.KOT.add(lbVar);
                    }
                    AppMethodBeat.o(82390);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        la laVar = new la();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = laVar.populateBuilderWithField(aVar5, laVar, a.getNextFieldNumber(aVar5))) {
                        }
                        lcVar.KOU = laVar;
                    }
                    AppMethodBeat.o(82390);
                    return 0;
                case 3:
                    lcVar.KOV = aVar3.UbS.zi();
                    AppMethodBeat.o(82390);
                    return 0;
                default:
                    AppMethodBeat.o(82390);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82390);
            return -1;
        }
    }
}
