package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ajs extends a {
    public int Ltf;
    public int Ltg;
    public String Lth;
    public String dQx;
    public String qGB;
    public int xGz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(179487);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ltf);
            aVar.aM(2, this.Ltg);
            aVar.aM(3, this.xGz);
            if (this.dQx != null) {
                aVar.e(4, this.dQx);
            }
            if (this.qGB != null) {
                aVar.e(5, this.qGB);
            }
            if (this.Lth != null) {
                aVar.e(6, this.Lth);
            }
            AppMethodBeat.o(179487);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ltf) + 0 + g.a.a.b.b.a.bu(2, this.Ltg) + g.a.a.b.b.a.bu(3, this.xGz);
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(4, this.dQx);
            }
            if (this.qGB != null) {
                bu += g.a.a.b.b.a.f(5, this.qGB);
            }
            if (this.Lth != null) {
                bu += g.a.a.b.b.a.f(6, this.Lth);
            }
            AppMethodBeat.o(179487);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(179487);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajs ajs = (ajs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajs.Ltf = aVar3.UbS.zi();
                    AppMethodBeat.o(179487);
                    return 0;
                case 2:
                    ajs.Ltg = aVar3.UbS.zi();
                    AppMethodBeat.o(179487);
                    return 0;
                case 3:
                    ajs.xGz = aVar3.UbS.zi();
                    AppMethodBeat.o(179487);
                    return 0;
                case 4:
                    ajs.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(179487);
                    return 0;
                case 5:
                    ajs.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(179487);
                    return 0;
                case 6:
                    ajs.Lth = aVar3.UbS.readString();
                    AppMethodBeat.o(179487);
                    return 0;
                default:
                    AppMethodBeat.o(179487);
                    return -1;
            }
        } else {
            AppMethodBeat.o(179487);
            return -1;
        }
    }
}
