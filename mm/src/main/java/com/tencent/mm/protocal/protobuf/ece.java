package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ece extends a {
    public String Nco;
    public boolean Ncp;
    public boolean Ncq;
    public String appName;
    public int cmD;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116816);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nco != null) {
                aVar.e(1, this.Nco);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            aVar.aM(3, this.cmD);
            aVar.cc(4, this.Ncp);
            aVar.cc(5, this.Ncq);
            AppMethodBeat.o(116816);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nco != null ? g.a.a.b.b.a.f(1, this.Nco) + 0 : 0;
            if (this.appName != null) {
                f2 += g.a.a.b.b.a.f(2, this.appName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.cmD) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(116816);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116816);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ece ece = (ece) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ece.Nco = aVar3.UbS.readString();
                    AppMethodBeat.o(116816);
                    return 0;
                case 2:
                    ece.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(116816);
                    return 0;
                case 3:
                    ece.cmD = aVar3.UbS.zi();
                    AppMethodBeat.o(116816);
                    return 0;
                case 4:
                    ece.Ncp = aVar3.UbS.yZ();
                    AppMethodBeat.o(116816);
                    return 0;
                case 5:
                    ece.Ncq = aVar3.UbS.yZ();
                    AppMethodBeat.o(116816);
                    return 0;
                default:
                    AppMethodBeat.o(116816);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116816);
            return -1;
        }
    }
}
