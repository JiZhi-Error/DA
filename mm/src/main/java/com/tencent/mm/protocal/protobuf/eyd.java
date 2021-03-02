package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eyd extends a {
    public String Nvm;
    public String dCC;
    public String eda;
    public int isGame;
    public int nbf;
    public String path;
    public int subType;
    public String username;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125852);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.path != null) {
                aVar.e(2, this.path);
            }
            aVar.aM(3, this.version);
            aVar.aM(4, this.nbf);
            if (this.dCC != null) {
                aVar.e(5, this.dCC);
            }
            aVar.aM(6, this.isGame);
            if (this.eda != null) {
                aVar.e(7, this.eda);
            }
            aVar.aM(8, this.subType);
            if (this.Nvm != null) {
                aVar.e(9, this.Nvm);
            }
            AppMethodBeat.o(125852);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(2, this.path);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.nbf);
            if (this.dCC != null) {
                bu += g.a.a.b.b.a.f(5, this.dCC);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.isGame);
            if (this.eda != null) {
                bu2 += g.a.a.b.b.a.f(7, this.eda);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(8, this.subType);
            if (this.Nvm != null) {
                bu3 += g.a.a.b.b.a.f(9, this.Nvm);
            }
            AppMethodBeat.o(125852);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125852);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyd eyd = (eyd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyd.username = aVar3.UbS.readString();
                    AppMethodBeat.o(125852);
                    return 0;
                case 2:
                    eyd.path = aVar3.UbS.readString();
                    AppMethodBeat.o(125852);
                    return 0;
                case 3:
                    eyd.version = aVar3.UbS.zi();
                    AppMethodBeat.o(125852);
                    return 0;
                case 4:
                    eyd.nbf = aVar3.UbS.zi();
                    AppMethodBeat.o(125852);
                    return 0;
                case 5:
                    eyd.dCC = aVar3.UbS.readString();
                    AppMethodBeat.o(125852);
                    return 0;
                case 6:
                    eyd.isGame = aVar3.UbS.zi();
                    AppMethodBeat.o(125852);
                    return 0;
                case 7:
                    eyd.eda = aVar3.UbS.readString();
                    AppMethodBeat.o(125852);
                    return 0;
                case 8:
                    eyd.subType = aVar3.UbS.zi();
                    AppMethodBeat.o(125852);
                    return 0;
                case 9:
                    eyd.Nvm = aVar3.UbS.readString();
                    AppMethodBeat.o(125852);
                    return 0;
                default:
                    AppMethodBeat.o(125852);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125852);
            return -1;
        }
    }
}
