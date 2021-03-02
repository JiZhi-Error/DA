package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ayl extends a {
    public String LIM;
    public long LIN;
    public LinkedList<String> LIO = new LinkedList<>();

    public ayl() {
        AppMethodBeat.i(209592);
        AppMethodBeat.o(209592);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209593);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LIM != null) {
                aVar.e(1, this.LIM);
            }
            aVar.bb(2, this.LIN);
            aVar.e(3, 1, this.LIO);
            AppMethodBeat.o(209593);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LIM != null ? g.a.a.b.b.a.f(1, this.LIM) + 0 : 0) + g.a.a.b.b.a.r(2, this.LIN) + g.a.a.a.c(3, 1, this.LIO);
            AppMethodBeat.o(209593);
            return f2;
        } else if (i2 == 2) {
            this.LIO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209593);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayl ayl = (ayl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayl.LIM = aVar3.UbS.readString();
                    AppMethodBeat.o(209593);
                    return 0;
                case 2:
                    ayl.LIN = aVar3.UbS.zl();
                    AppMethodBeat.o(209593);
                    return 0;
                case 3:
                    ayl.LIO.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209593);
                    return 0;
                default:
                    AppMethodBeat.o(209593);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209593);
            return -1;
        }
    }
}
