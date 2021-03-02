package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bbh extends a {
    public int LKI;
    public bbi LKJ;
    public LinkedList<bbi> LKK = new LinkedList<>();

    public bbh() {
        AppMethodBeat.i(209648);
        AppMethodBeat.o(209648);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169043);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LKI);
            if (this.LKJ != null) {
                aVar.ni(2, this.LKJ.computeSize());
                this.LKJ.writeFields(aVar);
            }
            aVar.e(3, 8, this.LKK);
            AppMethodBeat.o(169043);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LKI) + 0;
            if (this.LKJ != null) {
                bu += g.a.a.a.nh(2, this.LKJ.computeSize());
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.LKK);
            AppMethodBeat.o(169043);
            return c2;
        } else if (i2 == 2) {
            this.LKK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169043);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbh bbh = (bbh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbh.LKI = aVar3.UbS.zi();
                    AppMethodBeat.o(169043);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bbi bbi = new bbi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bbi.populateBuilderWithField(aVar4, bbi, a.getNextFieldNumber(aVar4))) {
                        }
                        bbh.LKJ = bbi;
                    }
                    AppMethodBeat.o(169043);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bbi bbi2 = new bbi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bbi2.populateBuilderWithField(aVar5, bbi2, a.getNextFieldNumber(aVar5))) {
                        }
                        bbh.LKK.add(bbi2);
                    }
                    AppMethodBeat.o(169043);
                    return 0;
                default:
                    AppMethodBeat.o(169043);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169043);
            return -1;
        }
    }
}
