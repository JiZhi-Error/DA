package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dnf extends a {
    public int Dqw;
    public int MQy;
    public int MQz;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String oUj;
    public String pLl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123640);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.oUj != null) {
                aVar.e(1, this.oUj);
            }
            aVar.aM(2, this.MQy);
            if (this.hid != null) {
                aVar.e(3, this.hid);
            }
            if (this.hie != null) {
                aVar.e(4, this.hie);
            }
            aVar.aM(5, this.Dqw);
            aVar.aM(6, this.MQz);
            if (this.hif != null) {
                aVar.e(7, this.hif);
            }
            if (this.hig != null) {
                aVar.e(8, this.hig);
            }
            if (this.pLl != null) {
                aVar.e(9, this.pLl);
            }
            AppMethodBeat.o(123640);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.oUj != null ? g.a.a.b.b.a.f(1, this.oUj) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MQy);
            if (this.hid != null) {
                f2 += g.a.a.b.b.a.f(3, this.hid);
            }
            if (this.hie != null) {
                f2 += g.a.a.b.b.a.f(4, this.hie);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Dqw) + g.a.a.b.b.a.bu(6, this.MQz);
            if (this.hif != null) {
                bu += g.a.a.b.b.a.f(7, this.hif);
            }
            if (this.hig != null) {
                bu += g.a.a.b.b.a.f(8, this.hig);
            }
            if (this.pLl != null) {
                bu += g.a.a.b.b.a.f(9, this.pLl);
            }
            AppMethodBeat.o(123640);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123640);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnf dnf = (dnf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dnf.oUj = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                case 2:
                    dnf.MQy = aVar3.UbS.zi();
                    AppMethodBeat.o(123640);
                    return 0;
                case 3:
                    dnf.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                case 4:
                    dnf.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                case 5:
                    dnf.Dqw = aVar3.UbS.zi();
                    AppMethodBeat.o(123640);
                    return 0;
                case 6:
                    dnf.MQz = aVar3.UbS.zi();
                    AppMethodBeat.o(123640);
                    return 0;
                case 7:
                    dnf.hif = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                case 8:
                    dnf.hig = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                case 9:
                    dnf.pLl = aVar3.UbS.readString();
                    AppMethodBeat.o(123640);
                    return 0;
                default:
                    AppMethodBeat.o(123640);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123640);
            return -1;
        }
    }
}
