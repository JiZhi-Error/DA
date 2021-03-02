package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bj extends a {
    public LinkedList<bi> KEQ = new LinkedList<>();
    public ehf KER;

    public bj() {
        AppMethodBeat.i(91343);
        AppMethodBeat.o(91343);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91344);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KEQ);
            if (this.KER != null) {
                aVar.ni(2, this.KER.computeSize());
                this.KER.writeFields(aVar);
            }
            AppMethodBeat.o(91344);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KEQ) + 0;
            if (this.KER != null) {
                c2 += g.a.a.a.nh(2, this.KER.computeSize());
            }
            AppMethodBeat.o(91344);
            return c2;
        } else if (i2 == 2) {
            this.KEQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91344);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bj bjVar = (bj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bi biVar = new bi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = biVar.populateBuilderWithField(aVar4, biVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bjVar.KEQ.add(biVar);
                    }
                    AppMethodBeat.o(91344);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        bjVar.KER = ehf;
                    }
                    AppMethodBeat.o(91344);
                    return 0;
                default:
                    AppMethodBeat.o(91344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91344);
            return -1;
        }
    }
}
