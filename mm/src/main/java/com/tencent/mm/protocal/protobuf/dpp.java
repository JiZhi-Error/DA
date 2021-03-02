package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dpp extends a {
    public LinkedList<cos> MSO = new LinkedList<>();
    public String title;

    public dpp() {
        AppMethodBeat.i(72583);
        AppMethodBeat.o(72583);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72584);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.MSO);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            AppMethodBeat.o(72584);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.MSO) + 0;
            if (this.title != null) {
                c2 += g.a.a.b.b.a.f(2, this.title);
            }
            AppMethodBeat.o(72584);
            return c2;
        } else if (i2 == 2) {
            this.MSO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72584);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpp dpp = (dpp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cos cos = new cos();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cos.populateBuilderWithField(aVar4, cos, a.getNextFieldNumber(aVar4))) {
                        }
                        dpp.MSO.add(cos);
                    }
                    AppMethodBeat.o(72584);
                    return 0;
                case 2:
                    dpp.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72584);
                    return 0;
                default:
                    AppMethodBeat.o(72584);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72584);
            return -1;
        }
    }
}
