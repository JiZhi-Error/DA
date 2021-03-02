package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class zp extends a {
    public LinkedList<String> LkR = new LinkedList<>();
    public String LkS;

    public zp() {
        AppMethodBeat.i(152518);
        AppMethodBeat.o(152518);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152519);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.LkR);
            if (this.LkS != null) {
                aVar.e(2, this.LkS);
            }
            AppMethodBeat.o(152519);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.LkR) + 0;
            if (this.LkS != null) {
                c2 += g.a.a.b.b.a.f(2, this.LkS);
            }
            AppMethodBeat.o(152519);
            return c2;
        } else if (i2 == 2) {
            this.LkR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152519);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zp zpVar = (zp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zpVar.LkR.add(aVar3.UbS.readString());
                    AppMethodBeat.o(152519);
                    return 0;
                case 2:
                    zpVar.LkS = aVar3.UbS.readString();
                    AppMethodBeat.o(152519);
                    return 0;
                default:
                    AppMethodBeat.o(152519);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152519);
            return -1;
        }
    }
}
