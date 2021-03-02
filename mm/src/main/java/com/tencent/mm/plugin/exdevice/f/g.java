package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class g extends j {
    public String oTJ;
    public int rBP;
    public int rBQ;
    public int rBR;
    public int rBS;
    public int rBT;
    public String rBU;
    public int rBV;
    public String rBW;
    public int rBX;
    public int rBY;
    public String rBZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23491);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.rCc == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23491);
                throw bVar;
            }
            if (this.rCc != null) {
                aVar.ni(1, this.rCc.computeSize());
                this.rCc.writeFields(aVar);
            }
            aVar.aM(2, this.rBP);
            aVar.aM(3, this.rBQ);
            aVar.aM(4, this.rBR);
            aVar.aM(5, this.rBS);
            aVar.aM(6, this.rBT);
            if (this.rBU != null) {
                aVar.e(11, this.rBU);
            }
            aVar.aM(12, this.rBV);
            if (this.oTJ != null) {
                aVar.e(13, this.oTJ);
            }
            if (this.rBW != null) {
                aVar.e(14, this.rBW);
            }
            aVar.aM(15, this.rBX);
            aVar.aM(16, this.rBY);
            if (this.rBZ != null) {
                aVar.e(17, this.rBZ);
            }
            AppMethodBeat.o(23491);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.rCc != null ? g.a.a.a.nh(1, this.rCc.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rBP) + g.a.a.b.b.a.bu(3, this.rBQ) + g.a.a.b.b.a.bu(4, this.rBR) + g.a.a.b.b.a.bu(5, this.rBS) + g.a.a.b.b.a.bu(6, this.rBT);
            if (this.rBU != null) {
                nh += g.a.a.b.b.a.f(11, this.rBU);
            }
            int bu = nh + g.a.a.b.b.a.bu(12, this.rBV);
            if (this.oTJ != null) {
                bu += g.a.a.b.b.a.f(13, this.oTJ);
            }
            if (this.rBW != null) {
                bu += g.a.a.b.b.a.f(14, this.rBW);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.rBX) + g.a.a.b.b.a.bu(16, this.rBY);
            if (this.rBZ != null) {
                bu2 += g.a.a.b.b.a.f(17, this.rBZ);
            }
            AppMethodBeat.o(23491);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = j.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = j.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.rCc == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(23491);
                throw bVar2;
            }
            AppMethodBeat.o(23491);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        e eVar = new e();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, j.getNextFieldNumber(aVar4))) {
                        }
                        gVar.rCc = eVar;
                    }
                    AppMethodBeat.o(23491);
                    return 0;
                case 2:
                    gVar.rBP = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 3:
                    gVar.rBQ = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 4:
                    gVar.rBR = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 5:
                    gVar.rBS = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 6:
                    gVar.rBT = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 7:
                case 8:
                case 9:
                case 10:
                default:
                    AppMethodBeat.o(23491);
                    return -1;
                case 11:
                    gVar.rBU = aVar3.UbS.readString();
                    AppMethodBeat.o(23491);
                    return 0;
                case 12:
                    gVar.rBV = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 13:
                    gVar.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(23491);
                    return 0;
                case 14:
                    gVar.rBW = aVar3.UbS.readString();
                    AppMethodBeat.o(23491);
                    return 0;
                case 15:
                    gVar.rBX = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 16:
                    gVar.rBY = aVar3.UbS.zi();
                    AppMethodBeat.o(23491);
                    return 0;
                case 17:
                    gVar.rBZ = aVar3.UbS.readString();
                    AppMethodBeat.o(23491);
                    return 0;
            }
        } else {
            AppMethodBeat.o(23491);
            return -1;
        }
    }
}
