package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class op extends a {
    public String KSj;
    public String KUA;
    public int KUx;
    public int KUy;
    public long KUz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124433);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KUx);
            aVar.aM(2, this.KUy);
            aVar.bb(3, this.KUz);
            if (this.KUA != null) {
                aVar.e(4, this.KUA);
            }
            if (this.KSj != null) {
                aVar.e(5, this.KSj);
            }
            AppMethodBeat.o(124433);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KUx) + 0 + g.a.a.b.b.a.bu(2, this.KUy) + g.a.a.b.b.a.r(3, this.KUz);
            if (this.KUA != null) {
                bu += g.a.a.b.b.a.f(4, this.KUA);
            }
            if (this.KSj != null) {
                bu += g.a.a.b.b.a.f(5, this.KSj);
            }
            AppMethodBeat.o(124433);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124433);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            op opVar = (op) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    opVar.KUx = aVar3.UbS.zi();
                    AppMethodBeat.o(124433);
                    return 0;
                case 2:
                    opVar.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(124433);
                    return 0;
                case 3:
                    opVar.KUz = aVar3.UbS.zl();
                    AppMethodBeat.o(124433);
                    return 0;
                case 4:
                    opVar.KUA = aVar3.UbS.readString();
                    AppMethodBeat.o(124433);
                    return 0;
                case 5:
                    opVar.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(124433);
                    return 0;
                default:
                    AppMethodBeat.o(124433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124433);
            return -1;
        }
    }
}
