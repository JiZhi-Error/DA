package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class boc extends a {
    public cat KOZ;
    public int LWr;
    public int LWs;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82410);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KOZ == null) {
                b bVar = new b("Not all required fields were included: Device");
                AppMethodBeat.o(82410);
                throw bVar;
            }
            aVar.aM(1, this.LWr);
            aVar.aM(2, this.LWs);
            if (this.KOZ != null) {
                aVar.ni(3, this.KOZ.computeSize());
                this.KOZ.writeFields(aVar);
            }
            AppMethodBeat.o(82410);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LWr) + 0 + g.a.a.b.b.a.bu(2, this.LWs);
            if (this.KOZ != null) {
                bu += g.a.a.a.nh(3, this.KOZ.computeSize());
            }
            AppMethodBeat.o(82410);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KOZ == null) {
                b bVar2 = new b("Not all required fields were included: Device");
                AppMethodBeat.o(82410);
                throw bVar2;
            }
            AppMethodBeat.o(82410);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            boc boc = (boc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    boc.LWr = aVar3.UbS.zi();
                    AppMethodBeat.o(82410);
                    return 0;
                case 2:
                    boc.LWs = aVar3.UbS.zi();
                    AppMethodBeat.o(82410);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        boc.KOZ = cat;
                    }
                    AppMethodBeat.o(82410);
                    return 0;
                default:
                    AppMethodBeat.o(82410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82410);
            return -1;
        }
    }
}
