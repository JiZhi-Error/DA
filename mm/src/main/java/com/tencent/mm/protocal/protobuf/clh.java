package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class clh extends a {
    public int KSa;
    public int MjZ;
    public int MqC;
    public int MqD;
    public String MqE;
    public int MqF;
    public int Scene;
    public String dNI;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147770);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.aM(3, this.MjZ);
            aVar.aM(4, this.KSa);
            aVar.aM(5, this.Scene);
            aVar.aM(6, this.MqC);
            aVar.aM(7, this.MqD);
            if (this.MqE != null) {
                aVar.e(8, this.MqE);
            }
            aVar.aM(9, this.MqF);
            AppMethodBeat.o(147770);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MjZ) + g.a.a.b.b.a.bu(4, this.KSa) + g.a.a.b.b.a.bu(5, this.Scene) + g.a.a.b.b.a.bu(6, this.MqC) + g.a.a.b.b.a.bu(7, this.MqD);
            if (this.MqE != null) {
                bu += g.a.a.b.b.a.f(8, this.MqE);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.MqF);
            AppMethodBeat.o(147770);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147770);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clh clh = (clh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clh.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(147770);
                    return 0;
                case 2:
                    clh.username = aVar3.UbS.readString();
                    AppMethodBeat.o(147770);
                    return 0;
                case 3:
                    clh.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                case 4:
                    clh.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                case 5:
                    clh.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                case 6:
                    clh.MqC = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                case 7:
                    clh.MqD = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                case 8:
                    clh.MqE = aVar3.UbS.readString();
                    AppMethodBeat.o(147770);
                    return 0;
                case 9:
                    clh.MqF = aVar3.UbS.zi();
                    AppMethodBeat.o(147770);
                    return 0;
                default:
                    AppMethodBeat.o(147770);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147770);
            return -1;
        }
    }
}
