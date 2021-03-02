package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cxo extends a {
    public LinkedList<Integer> LRr = new LinkedList<>();
    public LinkedList<cxl> MBZ = new LinkedList<>();
    public int oTz;

    public cxo() {
        AppMethodBeat.i(43120);
        AppMethodBeat.o(43120);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43121);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oTz);
            aVar.f(2, 2, this.LRr);
            aVar.e(3, 8, this.MBZ);
            AppMethodBeat.o(43121);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTz) + 0 + g.a.a.a.d(2, 2, this.LRr) + g.a.a.a.c(3, 8, this.MBZ);
            AppMethodBeat.o(43121);
            return bu;
        } else if (i2 == 2) {
            this.LRr.clear();
            this.MBZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(43121);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxo cxo = (cxo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxo.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(43121);
                    return 0;
                case 2:
                    cxo.LRr = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(43121);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cxl cxl = new cxl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cxl.populateBuilderWithField(aVar4, cxl, a.getNextFieldNumber(aVar4))) {
                        }
                        cxo.MBZ.add(cxl);
                    }
                    AppMethodBeat.o(43121);
                    return 0;
                default:
                    AppMethodBeat.o(43121);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43121);
            return -1;
        }
    }
}
