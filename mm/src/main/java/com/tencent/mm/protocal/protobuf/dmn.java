package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dmn extends a {
    public b Lqr;
    public int MJT;
    public String MQb;
    public int oUv;
    public int rBX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(138185);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MQb != null) {
                aVar.e(1, this.MQb);
            }
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.rBX);
            aVar.aM(4, this.MJT);
            if (this.Lqr != null) {
                aVar.c(5, this.Lqr);
            }
            AppMethodBeat.o(138185);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MQb != null ? g.a.a.b.b.a.f(1, this.MQb) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.rBX) + g.a.a.b.b.a.bu(4, this.MJT);
            if (this.Lqr != null) {
                f2 += g.a.a.b.b.a.b(5, this.Lqr);
            }
            AppMethodBeat.o(138185);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(138185);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmn dmn = (dmn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dmn.MQb = aVar3.UbS.readString();
                    AppMethodBeat.o(138185);
                    return 0;
                case 2:
                    dmn.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(138185);
                    return 0;
                case 3:
                    dmn.rBX = aVar3.UbS.zi();
                    AppMethodBeat.o(138185);
                    return 0;
                case 4:
                    dmn.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(138185);
                    return 0;
                case 5:
                    dmn.Lqr = aVar3.UbS.hPo();
                    AppMethodBeat.o(138185);
                    return 0;
                default:
                    AppMethodBeat.o(138185);
                    return -1;
            }
        } else {
            AppMethodBeat.o(138185);
            return -1;
        }
    }
}
