package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cmr extends a {
    public int KXC;
    public String Mse;
    public String Msf;
    public String dNI;
    public String qFU;
    public String qGB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(227877);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.qGB != null) {
                aVar.e(2, this.qGB);
            }
            if (this.Mse != null) {
                aVar.e(3, this.Mse);
            }
            if (this.Msf != null) {
                aVar.e(4, this.Msf);
            }
            aVar.aM(5, this.KXC);
            if (this.qFU != null) {
                aVar.e(6, this.qFU);
            }
            AppMethodBeat.o(227877);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.qGB != null) {
                f2 += g.a.a.b.b.a.f(2, this.qGB);
            }
            if (this.Mse != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mse);
            }
            if (this.Msf != null) {
                f2 += g.a.a.b.b.a.f(4, this.Msf);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KXC);
            if (this.qFU != null) {
                bu += g.a.a.b.b.a.f(6, this.qFU);
            }
            AppMethodBeat.o(227877);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(227877);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmr cmr = (cmr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmr.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(227877);
                    return 0;
                case 2:
                    cmr.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(227877);
                    return 0;
                case 3:
                    cmr.Mse = aVar3.UbS.readString();
                    AppMethodBeat.o(227877);
                    return 0;
                case 4:
                    cmr.Msf = aVar3.UbS.readString();
                    AppMethodBeat.o(227877);
                    return 0;
                case 5:
                    cmr.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(227877);
                    return 0;
                case 6:
                    cmr.qFU = aVar3.UbS.readString();
                    AppMethodBeat.o(227877);
                    return 0;
                default:
                    AppMethodBeat.o(227877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(227877);
            return -1;
        }
    }
}
