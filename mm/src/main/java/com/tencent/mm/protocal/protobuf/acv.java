package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class acv extends a {
    public LinkedList<String> Loe = new LinkedList<>();
    public int Lof;
    public boolean Log;
    public int Loh;

    public acv() {
        AppMethodBeat.i(186795);
        AppMethodBeat.o(186795);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186796);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.Loe);
            aVar.aM(2, this.Lof);
            aVar.cc(3, this.Log);
            aVar.aM(4, this.Loh);
            AppMethodBeat.o(186796);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.Loe) + 0 + g.a.a.b.b.a.bu(2, this.Lof) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.Loh);
            AppMethodBeat.o(186796);
            return c2;
        } else if (i2 == 2) {
            this.Loe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186796);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            acv acv = (acv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acv.Loe.add(aVar3.UbS.readString());
                    AppMethodBeat.o(186796);
                    return 0;
                case 2:
                    acv.Lof = aVar3.UbS.zi();
                    AppMethodBeat.o(186796);
                    return 0;
                case 3:
                    acv.Log = aVar3.UbS.yZ();
                    AppMethodBeat.o(186796);
                    return 0;
                case 4:
                    acv.Loh = aVar3.UbS.zi();
                    AppMethodBeat.o(186796);
                    return 0;
                default:
                    AppMethodBeat.o(186796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186796);
            return -1;
        }
    }
}
