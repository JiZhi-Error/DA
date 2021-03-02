package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class tg extends a {
    public String LbP;
    public int LbQ;
    public String LbR;
    public String abi;
    public String kxx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116466);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LbP != null) {
                aVar.e(1, this.LbP);
            }
            aVar.aM(2, this.LbQ);
            if (this.abi != null) {
                aVar.e(3, this.abi);
            }
            if (this.kxx != null) {
                aVar.e(4, this.kxx);
            }
            if (this.LbR != null) {
                aVar.e(5, this.LbR);
            }
            AppMethodBeat.o(116466);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LbP != null ? g.a.a.b.b.a.f(1, this.LbP) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LbQ);
            if (this.abi != null) {
                f2 += g.a.a.b.b.a.f(3, this.abi);
            }
            if (this.kxx != null) {
                f2 += g.a.a.b.b.a.f(4, this.kxx);
            }
            if (this.LbR != null) {
                f2 += g.a.a.b.b.a.f(5, this.LbR);
            }
            AppMethodBeat.o(116466);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116466);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tg tgVar = (tg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tgVar.LbP = aVar3.UbS.readString();
                    AppMethodBeat.o(116466);
                    return 0;
                case 2:
                    tgVar.LbQ = aVar3.UbS.zi();
                    AppMethodBeat.o(116466);
                    return 0;
                case 3:
                    tgVar.abi = aVar3.UbS.readString();
                    AppMethodBeat.o(116466);
                    return 0;
                case 4:
                    tgVar.kxx = aVar3.UbS.readString();
                    AppMethodBeat.o(116466);
                    return 0;
                case 5:
                    tgVar.LbR = aVar3.UbS.readString();
                    AppMethodBeat.o(116466);
                    return 0;
                default:
                    AppMethodBeat.o(116466);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116466);
            return -1;
        }
    }
}
