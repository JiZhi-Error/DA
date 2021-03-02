package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bcq extends a {
    public int LLK;
    public LinkedList<FinderContact> LLL = new LinkedList<>();
    public int msj;
    public int type;

    public bcq() {
        AppMethodBeat.i(209680);
        AppMethodBeat.o(209680);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209681);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            aVar.aM(2, this.msj);
            aVar.aM(3, this.LLK);
            aVar.e(4, 8, this.LLL);
            AppMethodBeat.o(209681);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.bu(2, this.msj) + g.a.a.b.b.a.bu(3, this.LLK) + g.a.a.a.c(4, 8, this.LLL);
            AppMethodBeat.o(209681);
            return bu;
        } else if (i2 == 2) {
            this.LLL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209681);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcq bcq = (bcq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcq.type = aVar3.UbS.zi();
                    AppMethodBeat.o(209681);
                    return 0;
                case 2:
                    bcq.msj = aVar3.UbS.zi();
                    AppMethodBeat.o(209681);
                    return 0;
                case 3:
                    bcq.LLK = aVar3.UbS.zi();
                    AppMethodBeat.o(209681);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        bcq.LLL.add(finderContact);
                    }
                    AppMethodBeat.o(209681);
                    return 0;
                default:
                    AppMethodBeat.o(209681);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209681);
            return -1;
        }
    }
}
