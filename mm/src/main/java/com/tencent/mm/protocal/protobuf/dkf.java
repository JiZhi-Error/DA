package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dkf extends a {
    public int Category;
    public int MOb;
    public int MOc;
    public LinkedList<String> MOd = new LinkedList<>();
    public int MOe;

    public dkf() {
        AppMethodBeat.i(117893);
        AppMethodBeat.o(117893);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117894);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MOb);
            aVar.aM(2, this.MOc);
            aVar.aM(3, this.Category);
            aVar.e(4, 1, this.MOd);
            aVar.aM(5, this.MOe);
            AppMethodBeat.o(117894);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MOb) + 0 + g.a.a.b.b.a.bu(2, this.MOc) + g.a.a.b.b.a.bu(3, this.Category) + g.a.a.a.c(4, 1, this.MOd) + g.a.a.b.b.a.bu(5, this.MOe);
            AppMethodBeat.o(117894);
            return bu;
        } else if (i2 == 2) {
            this.MOd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117894);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dkf dkf = (dkf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dkf.MOb = aVar3.UbS.zi();
                    AppMethodBeat.o(117894);
                    return 0;
                case 2:
                    dkf.MOc = aVar3.UbS.zi();
                    AppMethodBeat.o(117894);
                    return 0;
                case 3:
                    dkf.Category = aVar3.UbS.zi();
                    AppMethodBeat.o(117894);
                    return 0;
                case 4:
                    dkf.MOd.add(aVar3.UbS.readString());
                    AppMethodBeat.o(117894);
                    return 0;
                case 5:
                    dkf.MOe = aVar3.UbS.zi();
                    AppMethodBeat.o(117894);
                    return 0;
                default:
                    AppMethodBeat.o(117894);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117894);
            return -1;
        }
    }
}
