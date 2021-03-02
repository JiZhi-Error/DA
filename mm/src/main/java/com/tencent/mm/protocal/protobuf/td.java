package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class td extends a {
    public int Lbw;
    public LinkedList<Integer> Lbx = new LinkedList<>();

    public td() {
        AppMethodBeat.i(133164);
        AppMethodBeat.o(133164);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133165);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lbw);
            aVar.f(2, 2, this.Lbx);
            AppMethodBeat.o(133165);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lbw) + 0 + g.a.a.a.d(2, 2, this.Lbx);
            AppMethodBeat.o(133165);
            return bu;
        } else if (i2 == 2) {
            this.Lbx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(133165);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            td tdVar = (td) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tdVar.Lbw = aVar3.UbS.zi();
                    AppMethodBeat.o(133165);
                    return 0;
                case 2:
                    tdVar.Lbx = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(133165);
                    return 0;
                default:
                    AppMethodBeat.o(133165);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133165);
            return -1;
        }
    }
}
