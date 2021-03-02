package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class akg extends a {
    public int KZx;
    public String Name;
    public String PriceType;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91446);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            aVar.aM(2, this.KZx);
            if (this.PriceType != null) {
                aVar.e(3, this.PriceType);
            }
            aVar.aM(4, this.xNF);
            AppMethodBeat.o(91446);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KZx);
            if (this.PriceType != null) {
                f2 += g.a.a.b.b.a.f(3, this.PriceType);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.xNF);
            AppMethodBeat.o(91446);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91446);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akg akg = (akg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akg.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(91446);
                    return 0;
                case 2:
                    akg.KZx = aVar3.UbS.zi();
                    AppMethodBeat.o(91446);
                    return 0;
                case 3:
                    akg.PriceType = aVar3.UbS.readString();
                    AppMethodBeat.o(91446);
                    return 0;
                case 4:
                    akg.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(91446);
                    return 0;
                default:
                    AppMethodBeat.o(91446);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91446);
            return -1;
        }
    }
}
