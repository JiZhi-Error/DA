package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class nr extends a {
    public String KQV;
    public LinkedList<nq> KTe = new LinkedList<>();
    public int KTf;

    public nr() {
        AppMethodBeat.i(124413);
        AppMethodBeat.o(124413);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124414);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.KTe);
            aVar.aM(2, this.KTf);
            if (this.KQV != null) {
                aVar.e(3, this.KQV);
            }
            AppMethodBeat.o(124414);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.KTe) + 0 + g.a.a.b.b.a.bu(2, this.KTf);
            if (this.KQV != null) {
                c2 += g.a.a.b.b.a.f(3, this.KQV);
            }
            AppMethodBeat.o(124414);
            return c2;
        } else if (i2 == 2) {
            this.KTe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124414);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nr nrVar = (nr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        nq nqVar = new nq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nqVar.populateBuilderWithField(aVar4, nqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nrVar.KTe.add(nqVar);
                    }
                    AppMethodBeat.o(124414);
                    return 0;
                case 2:
                    nrVar.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(124414);
                    return 0;
                case 3:
                    nrVar.KQV = aVar3.UbS.readString();
                    AppMethodBeat.o(124414);
                    return 0;
                default:
                    AppMethodBeat.o(124414);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124414);
            return -1;
        }
    }
}
