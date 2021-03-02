package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eig extends a {
    public String GaP;
    public String Nhw;
    public int Nhx;
    public String qcK;
    public String sign;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91717);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nhw != null) {
                aVar.e(4, this.Nhw);
            }
            if (this.sign != null) {
                aVar.e(5, this.sign);
            }
            if (this.qcK != null) {
                aVar.e(6, this.qcK);
            }
            aVar.aM(7, this.Nhx);
            if (this.GaP != null) {
                aVar.e(8, this.GaP);
            }
            AppMethodBeat.o(91717);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nhw != null ? g.a.a.b.b.a.f(4, this.Nhw) + 0 : 0;
            if (this.sign != null) {
                f2 += g.a.a.b.b.a.f(5, this.sign);
            }
            if (this.qcK != null) {
                f2 += g.a.a.b.b.a.f(6, this.qcK);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.Nhx);
            if (this.GaP != null) {
                bu += g.a.a.b.b.a.f(8, this.GaP);
            }
            AppMethodBeat.o(91717);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91717);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eig eig = (eig) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 4:
                    eig.Nhw = aVar3.UbS.readString();
                    AppMethodBeat.o(91717);
                    return 0;
                case 5:
                    eig.sign = aVar3.UbS.readString();
                    AppMethodBeat.o(91717);
                    return 0;
                case 6:
                    eig.qcK = aVar3.UbS.readString();
                    AppMethodBeat.o(91717);
                    return 0;
                case 7:
                    eig.Nhx = aVar3.UbS.zi();
                    AppMethodBeat.o(91717);
                    return 0;
                case 8:
                    eig.GaP = aVar3.UbS.readString();
                    AppMethodBeat.o(91717);
                    return 0;
                default:
                    AppMethodBeat.o(91717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91717);
            return -1;
        }
    }
}
