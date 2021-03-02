package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fdr extends a {
    public fdq Nzl;
    public ys Nzm;
    public int dIZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225306);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nzl != null) {
                aVar.ni(1, this.Nzl.computeSize());
                this.Nzl.writeFields(aVar);
            }
            if (this.Nzm != null) {
                aVar.ni(2, this.Nzm.computeSize());
                this.Nzm.writeFields(aVar);
            }
            aVar.aM(3, this.dIZ);
            AppMethodBeat.o(225306);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Nzl != null ? g.a.a.a.nh(1, this.Nzl.computeSize()) + 0 : 0;
            if (this.Nzm != null) {
                nh += g.a.a.a.nh(2, this.Nzm.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.dIZ);
            AppMethodBeat.o(225306);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225306);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdr fdr = (fdr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fdq fdq = new fdq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fdq.populateBuilderWithField(aVar4, fdq, a.getNextFieldNumber(aVar4))) {
                        }
                        fdr.Nzl = fdq;
                    }
                    AppMethodBeat.o(225306);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ys ysVar = new ys();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ysVar.populateBuilderWithField(aVar5, ysVar, a.getNextFieldNumber(aVar5))) {
                        }
                        fdr.Nzm = ysVar;
                    }
                    AppMethodBeat.o(225306);
                    return 0;
                case 3:
                    fdr.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(225306);
                    return 0;
                default:
                    AppMethodBeat.o(225306);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225306);
            return -1;
        }
    }
}
