package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ti extends a {
    public String LbV;
    public LinkedList<String> LbW = new LinkedList<>();

    public ti() {
        AppMethodBeat.i(72427);
        AppMethodBeat.o(72427);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72428);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LbV != null) {
                aVar.e(1, this.LbV);
            }
            aVar.e(2, 1, this.LbW);
            AppMethodBeat.o(72428);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LbV != null ? g.a.a.b.b.a.f(1, this.LbV) + 0 : 0) + g.a.a.a.c(2, 1, this.LbW);
            AppMethodBeat.o(72428);
            return f2;
        } else if (i2 == 2) {
            this.LbW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72428);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ti tiVar = (ti) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tiVar.LbV = aVar3.UbS.readString();
                    AppMethodBeat.o(72428);
                    return 0;
                case 2:
                    tiVar.LbW.add(aVar3.UbS.readString());
                    AppMethodBeat.o(72428);
                    return 0;
                default:
                    AppMethodBeat.o(72428);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72428);
            return -1;
        }
    }
}
