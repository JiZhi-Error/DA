package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eip extends a {
    public int LHa;
    public int NhL;
    public String NhM;
    public eio NhN;
    public boolean dEF;
    public String id;
    public int iqg;
    public String lYE;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153001);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LHa);
            aVar.aM(2, this.iqg);
            aVar.aM(3, this.NhL);
            aVar.aM(4, this.type);
            if (this.id != null) {
                aVar.e(5, this.id);
            }
            if (this.lYE != null) {
                aVar.e(6, this.lYE);
            }
            if (this.NhM != null) {
                aVar.e(7, this.NhM);
            }
            if (this.NhN != null) {
                aVar.ni(8, this.NhN.computeSize());
                this.NhN.writeFields(aVar);
            }
            aVar.cc(9, this.dEF);
            AppMethodBeat.o(153001);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LHa) + 0 + g.a.a.b.b.a.bu(2, this.iqg) + g.a.a.b.b.a.bu(3, this.NhL) + g.a.a.b.b.a.bu(4, this.type);
            if (this.id != null) {
                bu += g.a.a.b.b.a.f(5, this.id);
            }
            if (this.lYE != null) {
                bu += g.a.a.b.b.a.f(6, this.lYE);
            }
            if (this.NhM != null) {
                bu += g.a.a.b.b.a.f(7, this.NhM);
            }
            if (this.NhN != null) {
                bu += g.a.a.a.nh(8, this.NhN.computeSize());
            }
            int fS = bu + g.a.a.b.b.a.fS(9) + 1;
            AppMethodBeat.o(153001);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153001);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eip eip = (eip) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eip.LHa = aVar3.UbS.zi();
                    AppMethodBeat.o(153001);
                    return 0;
                case 2:
                    eip.iqg = aVar3.UbS.zi();
                    AppMethodBeat.o(153001);
                    return 0;
                case 3:
                    eip.NhL = aVar3.UbS.zi();
                    AppMethodBeat.o(153001);
                    return 0;
                case 4:
                    eip.type = aVar3.UbS.zi();
                    AppMethodBeat.o(153001);
                    return 0;
                case 5:
                    eip.id = aVar3.UbS.readString();
                    AppMethodBeat.o(153001);
                    return 0;
                case 6:
                    eip.lYE = aVar3.UbS.readString();
                    AppMethodBeat.o(153001);
                    return 0;
                case 7:
                    eip.NhM = aVar3.UbS.readString();
                    AppMethodBeat.o(153001);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eio eio = new eio();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eio.populateBuilderWithField(aVar4, eio, a.getNextFieldNumber(aVar4))) {
                        }
                        eip.NhN = eio;
                    }
                    AppMethodBeat.o(153001);
                    return 0;
                case 9:
                    eip.dEF = aVar3.UbS.yZ();
                    AppMethodBeat.o(153001);
                    return 0;
                default:
                    AppMethodBeat.o(153001);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153001);
            return -1;
        }
    }
}
