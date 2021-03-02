package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aay extends a {
    public int Lmj;
    public LinkedList<aax> Lmk = new LinkedList<>();

    public aay() {
        AppMethodBeat.i(145669);
        AppMethodBeat.o(145669);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(145670);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lmj);
            aVar.e(2, 8, this.Lmk);
            AppMethodBeat.o(145670);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lmj) + 0 + g.a.a.a.c(2, 8, this.Lmk);
            AppMethodBeat.o(145670);
            return bu;
        } else if (i2 == 2) {
            this.Lmk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(145670);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aay aay = (aay) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aay.Lmj = aVar3.UbS.zi();
                    AppMethodBeat.o(145670);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aax aax = new aax();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aax.populateBuilderWithField(aVar4, aax, a.getNextFieldNumber(aVar4))) {
                        }
                        aay.Lmk.add(aax);
                    }
                    AppMethodBeat.o(145670);
                    return 0;
                default:
                    AppMethodBeat.o(145670);
                    return -1;
            }
        } else {
            AppMethodBeat.o(145670);
            return -1;
        }
    }
}
