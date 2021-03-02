package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class akh extends a {
    public int Ltq;
    public int Ltr;
    public int Lts;
    public String Ltt;
    public int Ltu;
    public String Ltv;
    public int Ltw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220698);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ltq);
            aVar.aM(2, this.Ltr);
            aVar.aM(3, this.Lts);
            if (this.Ltt != null) {
                aVar.e(4, this.Ltt);
            }
            aVar.aM(5, this.Ltu);
            if (this.Ltv != null) {
                aVar.e(6, this.Ltv);
            }
            aVar.aM(7, this.Ltw);
            AppMethodBeat.o(220698);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ltq) + 0 + g.a.a.b.b.a.bu(2, this.Ltr) + g.a.a.b.b.a.bu(3, this.Lts);
            if (this.Ltt != null) {
                bu += g.a.a.b.b.a.f(4, this.Ltt);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Ltu);
            if (this.Ltv != null) {
                bu2 += g.a.a.b.b.a.f(6, this.Ltv);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(7, this.Ltw);
            AppMethodBeat.o(220698);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220698);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            akh akh = (akh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akh.Ltq = aVar3.UbS.zi();
                    AppMethodBeat.o(220698);
                    return 0;
                case 2:
                    akh.Ltr = aVar3.UbS.zi();
                    AppMethodBeat.o(220698);
                    return 0;
                case 3:
                    akh.Lts = aVar3.UbS.zi();
                    AppMethodBeat.o(220698);
                    return 0;
                case 4:
                    akh.Ltt = aVar3.UbS.readString();
                    AppMethodBeat.o(220698);
                    return 0;
                case 5:
                    akh.Ltu = aVar3.UbS.zi();
                    AppMethodBeat.o(220698);
                    return 0;
                case 6:
                    akh.Ltv = aVar3.UbS.readString();
                    AppMethodBeat.o(220698);
                    return 0;
                case 7:
                    akh.Ltw = aVar3.UbS.zi();
                    AppMethodBeat.o(220698);
                    return 0;
                default:
                    AppMethodBeat.o(220698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220698);
            return -1;
        }
    }
}
