package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public class u extends a {
    public String dDM;
    public String dFv;
    public String gCv;
    public int msgType;
    public double qwJ;
    public int qwL;
    public String qwM;
    public int scene;
    public int status;
    public String type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91250);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(91250);
                throw bVar;
            } else if (this.dDM == null) {
                b bVar2 = new b("Not all required fields were included: transactionId");
                AppMethodBeat.o(91250);
                throw bVar2;
            } else if (this.dFv == null) {
                b bVar3 = new b("Not all required fields were included: feeType");
                AppMethodBeat.o(91250);
                throw bVar3;
            } else {
                if (this.username != null) {
                    aVar.e(1, this.username);
                }
                if (this.dDM != null) {
                    aVar.e(2, this.dDM);
                }
                aVar.e(3, this.qwJ);
                if (this.dFv != null) {
                    aVar.e(4, this.dFv);
                }
                aVar.aM(5, this.qwL);
                aVar.aM(6, this.scene);
                aVar.aM(7, this.status);
                if (this.gCv != null) {
                    aVar.e(8, this.gCv);
                }
                if (this.qwM != null) {
                    aVar.e(9, this.qwM);
                }
                aVar.aM(10, this.msgType);
                if (this.type != null) {
                    aVar.e(11, this.type);
                }
                AppMethodBeat.o(91250);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.dDM != null) {
                f2 += g.a.a.b.b.a.f(2, this.dDM);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 8;
            if (this.dFv != null) {
                fS += g.a.a.b.b.a.f(4, this.dFv);
            }
            int bu = fS + g.a.a.b.b.a.bu(5, this.qwL) + g.a.a.b.b.a.bu(6, this.scene) + g.a.a.b.b.a.bu(7, this.status);
            if (this.gCv != null) {
                bu += g.a.a.b.b.a.f(8, this.gCv);
            }
            if (this.qwM != null) {
                bu += g.a.a.b.b.a.f(9, this.qwM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.msgType);
            if (this.type != null) {
                bu2 += g.a.a.b.b.a.f(11, this.type);
            }
            AppMethodBeat.o(91250);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar4 = new b("Not all required fields were included: username");
                AppMethodBeat.o(91250);
                throw bVar4;
            } else if (this.dDM == null) {
                b bVar5 = new b("Not all required fields were included: transactionId");
                AppMethodBeat.o(91250);
                throw bVar5;
            } else if (this.dFv == null) {
                b bVar6 = new b("Not all required fields were included: feeType");
                AppMethodBeat.o(91250);
                throw bVar6;
            } else {
                AppMethodBeat.o(91250);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                case 2:
                    uVar.dDM = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                case 3:
                    uVar.qwJ = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91250);
                    return 0;
                case 4:
                    uVar.dFv = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                case 5:
                    uVar.qwL = aVar3.UbS.zi();
                    AppMethodBeat.o(91250);
                    return 0;
                case 6:
                    uVar.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(91250);
                    return 0;
                case 7:
                    uVar.status = aVar3.UbS.zi();
                    AppMethodBeat.o(91250);
                    return 0;
                case 8:
                    uVar.gCv = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                case 9:
                    uVar.qwM = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                case 10:
                    uVar.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(91250);
                    return 0;
                case 11:
                    uVar.type = aVar3.UbS.readString();
                    AppMethodBeat.o(91250);
                    return 0;
                default:
                    AppMethodBeat.o(91250);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91250);
            return -1;
        }
    }
}
