package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bd extends a {
    public String AZI;
    public String IconUrl;
    public String Name;
    public String iAc;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91340);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.AZI != null) {
                aVar.e(2, this.AZI);
            }
            aVar.aM(3, this.oUv);
            if (this.iAc != null) {
                aVar.e(4, this.iAc);
            }
            if (this.IconUrl != null) {
                aVar.e(5, this.IconUrl);
            }
            AppMethodBeat.o(91340);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.AZI != null) {
                f2 += g.a.a.b.b.a.f(2, this.AZI);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oUv);
            if (this.iAc != null) {
                bu += g.a.a.b.b.a.f(4, this.iAc);
            }
            if (this.IconUrl != null) {
                bu += g.a.a.b.b.a.f(5, this.IconUrl);
            }
            AppMethodBeat.o(91340);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91340);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bd bdVar = (bd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(91340);
                    return 0;
                case 2:
                    bdVar.AZI = aVar3.UbS.readString();
                    AppMethodBeat.o(91340);
                    return 0;
                case 3:
                    bdVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(91340);
                    return 0;
                case 4:
                    bdVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(91340);
                    return 0;
                case 5:
                    bdVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(91340);
                    return 0;
                default:
                    AppMethodBeat.o(91340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91340);
            return -1;
        }
    }
}
