package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aym extends a {
    public LinkedList<FinderContact> LIH = new LinkedList<>();
    public int LII;

    public aym() {
        AppMethodBeat.i(209594);
        AppMethodBeat.o(209594);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209595);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LIH);
            aVar.aM(2, this.LII);
            AppMethodBeat.o(209595);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LIH) + 0 + g.a.a.b.b.a.bu(2, this.LII);
            AppMethodBeat.o(209595);
            return c2;
        } else if (i2 == 2) {
            this.LIH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209595);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aym aym = (aym) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderContact.populateBuilderWithField(aVar4, finderContact, a.getNextFieldNumber(aVar4))) {
                        }
                        aym.LIH.add(finderContact);
                    }
                    AppMethodBeat.o(209595);
                    return 0;
                case 2:
                    aym.LII = aVar3.UbS.zi();
                    AppMethodBeat.o(209595);
                    return 0;
                default:
                    AppMethodBeat.o(209595);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209595);
            return -1;
        }
    }
}