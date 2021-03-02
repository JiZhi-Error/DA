package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ano extends a {
    public LinkedList<String> Lyn = new LinkedList<>();
    public LinkedList<String> Lyo = new LinkedList<>();

    public ano() {
        AppMethodBeat.i(127490);
        AppMethodBeat.o(127490);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127491);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.Lyn);
            aVar.e(2, 1, this.Lyo);
            AppMethodBeat.o(127491);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.Lyn) + 0 + g.a.a.a.c(2, 1, this.Lyo);
            AppMethodBeat.o(127491);
            return c2;
        } else if (i2 == 2) {
            this.Lyn.clear();
            this.Lyo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127491);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ano ano = (ano) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ano.Lyn.add(aVar3.UbS.readString());
                    AppMethodBeat.o(127491);
                    return 0;
                case 2:
                    ano.Lyo.add(aVar3.UbS.readString());
                    AppMethodBeat.o(127491);
                    return 0;
                default:
                    AppMethodBeat.o(127491);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127491);
            return -1;
        }
    }
}
