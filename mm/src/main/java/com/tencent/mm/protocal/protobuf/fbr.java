package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fbr extends a {
    public dda NxO;
    public dda NxP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110919);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NxO != null) {
                aVar.ni(1, this.NxO.computeSize());
                this.NxO.writeFields(aVar);
            }
            if (this.NxP != null) {
                aVar.ni(2, this.NxP.computeSize());
                this.NxP.writeFields(aVar);
            }
            AppMethodBeat.o(110919);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NxO != null ? g.a.a.a.nh(1, this.NxO.computeSize()) + 0 : 0;
            if (this.NxP != null) {
                nh += g.a.a.a.nh(2, this.NxP.computeSize());
            }
            AppMethodBeat.o(110919);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110919);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbr fbr = (fbr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dda dda = new dda();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dda.populateBuilderWithField(aVar4, dda, a.getNextFieldNumber(aVar4))) {
                        }
                        fbr.NxO = dda;
                    }
                    AppMethodBeat.o(110919);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dda dda2 = new dda();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dda2.populateBuilderWithField(aVar5, dda2, a.getNextFieldNumber(aVar5))) {
                        }
                        fbr.NxP = dda2;
                    }
                    AppMethodBeat.o(110919);
                    return 0;
                default:
                    AppMethodBeat.o(110919);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110919);
            return -1;
        }
    }
}
