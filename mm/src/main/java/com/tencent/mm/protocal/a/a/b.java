package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> KAA = new LinkedList<>();
    public int KAz;
    public int nettype;
    public int uin;

    public b() {
        AppMethodBeat.i(143940);
        AppMethodBeat.o(143940);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143941);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uin);
            aVar.aM(2, this.KAz);
            aVar.e(3, 8, this.KAA);
            aVar.aM(4, this.nettype);
            AppMethodBeat.o(143941);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KAz) + g.a.a.a.c(3, 8, this.KAA) + g.a.a.b.b.a.bu(4, this.nettype);
            AppMethodBeat.o(143941);
            return bu;
        } else if (i2 == 2) {
            this.KAA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143941);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(143941);
                    return 0;
                case 2:
                    bVar.KAz = aVar3.UbS.zi();
                    AppMethodBeat.o(143941);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar4 = new a();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.KAA.add(aVar4);
                    }
                    AppMethodBeat.o(143941);
                    return 0;
                case 4:
                    bVar.nettype = aVar3.UbS.zi();
                    AppMethodBeat.o(143941);
                    return 0;
                default:
                    AppMethodBeat.o(143941);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143941);
            return -1;
        }
    }
}
