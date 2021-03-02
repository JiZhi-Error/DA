package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dgm extends a {
    public String LPg;
    public int LPy;
    public int Ltc;
    public String MD5;
    public int MLe;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155451);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LPy);
            if (this.LPg != null) {
                aVar.e(2, this.LPg);
            }
            if (this.MD5 != null) {
                aVar.e(3, this.MD5);
            }
            aVar.aM(4, this.Ltc);
            aVar.aM(5, this.MLe);
            AppMethodBeat.o(155451);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LPy) + 0;
            if (this.LPg != null) {
                bu += g.a.a.b.b.a.f(2, this.LPg);
            }
            if (this.MD5 != null) {
                bu += g.a.a.b.b.a.f(3, this.MD5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.Ltc) + g.a.a.b.b.a.bu(5, this.MLe);
            AppMethodBeat.o(155451);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155451);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgm dgm = (dgm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dgm.LPy = aVar3.UbS.zi();
                    AppMethodBeat.o(155451);
                    return 0;
                case 2:
                    dgm.LPg = aVar3.UbS.readString();
                    AppMethodBeat.o(155451);
                    return 0;
                case 3:
                    dgm.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(155451);
                    return 0;
                case 4:
                    dgm.Ltc = aVar3.UbS.zi();
                    AppMethodBeat.o(155451);
                    return 0;
                case 5:
                    dgm.MLe = aVar3.UbS.zi();
                    AppMethodBeat.o(155451);
                    return 0;
                default:
                    AppMethodBeat.o(155451);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155451);
            return -1;
        }
    }
}
