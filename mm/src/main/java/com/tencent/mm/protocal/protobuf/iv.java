package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class iv extends a {
    public boolean KNp;
    public LinkedList<iw> KNq = new LinkedList<>();

    public iv() {
        AppMethodBeat.i(91352);
        AppMethodBeat.o(91352);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91353);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.KNp);
            aVar.e(2, 8, this.KNq);
            AppMethodBeat.o(91353);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.a.c(2, 8, this.KNq);
            AppMethodBeat.o(91353);
            return fS;
        } else if (i2 == 2) {
            this.KNq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91353);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            iv ivVar = (iv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ivVar.KNp = aVar3.UbS.yZ();
                    AppMethodBeat.o(91353);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        iw iwVar = new iw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iwVar.populateBuilderWithField(aVar4, iwVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ivVar.KNq.add(iwVar);
                    }
                    AppMethodBeat.o(91353);
                    return 0;
                default:
                    AppMethodBeat.o(91353);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91353);
            return -1;
        }
    }
}
