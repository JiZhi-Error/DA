package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ckt extends a {
    public String KRe;
    public int Lia;
    public String Mqu;
    public String Mqv;
    public String type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116340);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mqu != null) {
                aVar.e(1, this.Mqu);
            }
            if (this.KRe != null) {
                aVar.e(2, this.KRe);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            aVar.aM(4, this.Lia);
            if (this.Mqv != null) {
                aVar.e(5, this.Mqv);
            }
            AppMethodBeat.o(116340);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mqu != null ? g.a.a.b.b.a.f(1, this.Mqu) + 0 : 0;
            if (this.KRe != null) {
                f2 += g.a.a.b.b.a.f(2, this.KRe);
            }
            if (this.type != null) {
                f2 += g.a.a.b.b.a.f(3, this.type);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Lia);
            if (this.Mqv != null) {
                bu += g.a.a.b.b.a.f(5, this.Mqv);
            }
            AppMethodBeat.o(116340);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116340);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ckt ckt = (ckt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckt.Mqu = aVar3.UbS.readString();
                    AppMethodBeat.o(116340);
                    return 0;
                case 2:
                    ckt.KRe = aVar3.UbS.readString();
                    AppMethodBeat.o(116340);
                    return 0;
                case 3:
                    ckt.type = aVar3.UbS.readString();
                    AppMethodBeat.o(116340);
                    return 0;
                case 4:
                    ckt.Lia = aVar3.UbS.zi();
                    AppMethodBeat.o(116340);
                    return 0;
                case 5:
                    ckt.Mqv = aVar3.UbS.readString();
                    AppMethodBeat.o(116340);
                    return 0;
                default:
                    AppMethodBeat.o(116340);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116340);
            return -1;
        }
    }
}
