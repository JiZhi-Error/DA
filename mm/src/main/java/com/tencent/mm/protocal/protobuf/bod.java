package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bod extends a {
    public LinkedList<boc> LWt = new LinkedList<>();
    public bob LWu;

    public bod() {
        AppMethodBeat.i(82411);
        AppMethodBeat.o(82411);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82412);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LWt);
            if (this.LWu != null) {
                aVar.ni(2, this.LWu.computeSize());
                this.LWu.writeFields(aVar);
            }
            AppMethodBeat.o(82412);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LWt) + 0;
            if (this.LWu != null) {
                c2 += g.a.a.a.nh(2, this.LWu.computeSize());
            }
            AppMethodBeat.o(82412);
            return c2;
        } else if (i2 == 2) {
            this.LWt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82412);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bod bod = (bod) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        boc boc = new boc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = boc.populateBuilderWithField(aVar4, boc, a.getNextFieldNumber(aVar4))) {
                        }
                        bod.LWt.add(boc);
                    }
                    AppMethodBeat.o(82412);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bob bob = new bob();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bob.populateBuilderWithField(aVar5, bob, a.getNextFieldNumber(aVar5))) {
                        }
                        bod.LWu = bob;
                    }
                    AppMethodBeat.o(82412);
                    return 0;
                default:
                    AppMethodBeat.o(82412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82412);
            return -1;
        }
    }
}
