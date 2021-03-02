package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class crj extends a {
    public String CEI;
    public int LZv;
    public String LZw;
    public int Lia;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116456);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.CEI != null) {
                aVar.e(1, this.CEI);
            }
            aVar.aM(2, this.LZv);
            if (this.LZw != null) {
                aVar.e(3, this.LZw);
            }
            aVar.aM(4, this.Lia);
            AppMethodBeat.o(116456);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.CEI != null ? g.a.a.b.b.a.f(1, this.CEI) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LZv);
            if (this.LZw != null) {
                f2 += g.a.a.b.b.a.f(3, this.LZw);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lia);
            AppMethodBeat.o(116456);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116456);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            crj crj = (crj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crj.CEI = aVar3.UbS.readString();
                    AppMethodBeat.o(116456);
                    return 0;
                case 2:
                    crj.LZv = aVar3.UbS.zi();
                    AppMethodBeat.o(116456);
                    return 0;
                case 3:
                    crj.LZw = aVar3.UbS.readString();
                    AppMethodBeat.o(116456);
                    return 0;
                case 4:
                    crj.Lia = aVar3.UbS.zi();
                    AppMethodBeat.o(116456);
                    return 0;
                default:
                    AppMethodBeat.o(116456);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116456);
            return -1;
        }
    }
}
