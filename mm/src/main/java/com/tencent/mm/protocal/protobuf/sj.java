package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class sj extends a {
    public adh KZU;
    public si KZV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91385);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZU != null) {
                aVar.ni(1, this.KZU.computeSize());
                this.KZU.writeFields(aVar);
            }
            if (this.KZV != null) {
                aVar.ni(2, this.KZV.computeSize());
                this.KZV.writeFields(aVar);
            }
            AppMethodBeat.o(91385);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KZU != null ? g.a.a.a.nh(1, this.KZU.computeSize()) + 0 : 0;
            if (this.KZV != null) {
                nh += g.a.a.a.nh(2, this.KZV.computeSize());
            }
            AppMethodBeat.o(91385);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91385);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sj sjVar = (sj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        adh adh = new adh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = adh.populateBuilderWithField(aVar4, adh, a.getNextFieldNumber(aVar4))) {
                        }
                        sjVar.KZU = adh;
                    }
                    AppMethodBeat.o(91385);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        si siVar = new si();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = siVar.populateBuilderWithField(aVar5, siVar, a.getNextFieldNumber(aVar5))) {
                        }
                        sjVar.KZV = siVar;
                    }
                    AppMethodBeat.o(91385);
                    return 0;
                default:
                    AppMethodBeat.o(91385);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91385);
            return -1;
        }
    }
}
