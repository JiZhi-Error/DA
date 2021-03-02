package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ahf extends a {
    public LinkedList<ahg> LpW = new LinkedList<>();
    public String content;
    public String title;

    public ahf() {
        AppMethodBeat.i(91433);
        AppMethodBeat.o(91433);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91434);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LpW);
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            AppMethodBeat.o(91434);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LpW) + 0;
            if (this.content != null) {
                c2 += g.a.a.b.b.a.f(2, this.content);
            }
            if (this.title != null) {
                c2 += g.a.a.b.b.a.f(3, this.title);
            }
            AppMethodBeat.o(91434);
            return c2;
        } else if (i2 == 2) {
            this.LpW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91434);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahf ahf = (ahf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahg ahg = new ahg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahg.populateBuilderWithField(aVar4, ahg, a.getNextFieldNumber(aVar4))) {
                        }
                        ahf.LpW.add(ahg);
                    }
                    AppMethodBeat.o(91434);
                    return 0;
                case 2:
                    ahf.content = aVar3.UbS.readString();
                    AppMethodBeat.o(91434);
                    return 0;
                case 3:
                    ahf.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91434);
                    return 0;
                default:
                    AppMethodBeat.o(91434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91434);
            return -1;
        }
    }
}
