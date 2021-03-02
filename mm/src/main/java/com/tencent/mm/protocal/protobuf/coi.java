package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class coi extends a {
    public long LHy;
    public coh MuB;
    public LinkedList<coj> MuC = new LinkedList<>();

    public coi() {
        AppMethodBeat.i(209767);
        AppMethodBeat.o(209767);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209768);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LHy);
            if (this.MuB != null) {
                aVar.ni(2, this.MuB.computeSize());
                this.MuB.writeFields(aVar);
            }
            aVar.e(3, 8, this.MuC);
            AppMethodBeat.o(209768);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LHy) + 0;
            if (this.MuB != null) {
                r += g.a.a.a.nh(2, this.MuB.computeSize());
            }
            int c2 = r + g.a.a.a.c(3, 8, this.MuC);
            AppMethodBeat.o(209768);
            return c2;
        } else if (i2 == 2) {
            this.MuC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209768);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coi coi = (coi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    coi.LHy = aVar3.UbS.zl();
                    AppMethodBeat.o(209768);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        coh coh = new coh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = coh.populateBuilderWithField(aVar4, coh, a.getNextFieldNumber(aVar4))) {
                        }
                        coi.MuB = coh;
                    }
                    AppMethodBeat.o(209768);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        coj coj = new coj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = coj.populateBuilderWithField(aVar5, coj, a.getNextFieldNumber(aVar5))) {
                        }
                        coi.MuC.add(coj);
                    }
                    AppMethodBeat.o(209768);
                    return 0;
                default:
                    AppMethodBeat.o(209768);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209768);
            return -1;
        }
    }
}
