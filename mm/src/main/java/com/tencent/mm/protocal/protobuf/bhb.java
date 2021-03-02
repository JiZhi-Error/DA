package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class bhb extends a {
    public String LQP;
    public int LQQ;
    public int LQR;
    public long LQS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152542);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LQP != null) {
                aVar.e(1, this.LQP);
            }
            aVar.aM(2, this.LQQ);
            aVar.aM(3, this.LQR);
            aVar.bb(99, this.LQS);
            AppMethodBeat.o(152542);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LQP != null ? g.a.a.b.b.a.f(1, this.LQP) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LQQ) + g.a.a.b.b.a.bu(3, this.LQR) + g.a.a.b.b.a.r(99, this.LQS);
            AppMethodBeat.o(152542);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152542);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhb bhb = (bhb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhb.LQP = aVar3.UbS.readString();
                    AppMethodBeat.o(152542);
                    return 0;
                case 2:
                    bhb.LQQ = aVar3.UbS.zi();
                    AppMethodBeat.o(152542);
                    return 0;
                case 3:
                    bhb.LQR = aVar3.UbS.zi();
                    AppMethodBeat.o(152542);
                    return 0;
                case 99:
                    bhb.LQS = aVar3.UbS.zl();
                    AppMethodBeat.o(152542);
                    return 0;
                default:
                    AppMethodBeat.o(152542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152542);
            return -1;
        }
    }
}
