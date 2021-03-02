package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dg extends a {
    public String dOe;
    public LinkedList<String> ybk = new LinkedList<>();

    public dg() {
        AppMethodBeat.i(218980);
        AppMethodBeat.o(218980);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(218981);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dOe != null) {
                aVar.e(1, this.dOe);
            }
            aVar.e(2, 1, this.ybk);
            AppMethodBeat.o(218981);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dOe != null ? g.a.a.b.b.a.f(1, this.dOe) + 0 : 0) + g.a.a.a.c(2, 1, this.ybk);
            AppMethodBeat.o(218981);
            return f2;
        } else if (i2 == 2) {
            this.ybk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(218981);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dgVar.dOe = aVar3.UbS.readString();
                    AppMethodBeat.o(218981);
                    return 0;
                case 2:
                    dgVar.ybk.add(aVar3.UbS.readString());
                    AppMethodBeat.o(218981);
                    return 0;
                default:
                    AppMethodBeat.o(218981);
                    return -1;
            }
        } else {
            AppMethodBeat.o(218981);
            return -1;
        }
    }
}
