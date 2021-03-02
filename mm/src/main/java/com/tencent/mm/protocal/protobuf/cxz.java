package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cxz extends a {
    public String APx;
    public LinkedList<cxy> MCQ = new LinkedList<>();
    public int MCR;
    public int MCS;
    public doy MCT;
    public int MCU;
    public LinkedList<cxx> MCV = new LinkedList<>();
    public boolean MCW;
    public LinkedList<doy> MCX = new LinkedList<>();
    public int state;

    public cxz() {
        AppMethodBeat.i(117544);
        AppMethodBeat.o(117544);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117545);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.APx == null) {
                b bVar = new b("Not all required fields were included: pid");
                AppMethodBeat.o(117545);
                throw bVar;
            }
            if (this.APx != null) {
                aVar.e(1, this.APx);
            }
            aVar.aM(2, this.state);
            aVar.e(3, 8, this.MCQ);
            aVar.aM(4, this.MCR);
            aVar.aM(5, this.MCS);
            if (this.MCT != null) {
                aVar.ni(6, this.MCT.computeSize());
                this.MCT.writeFields(aVar);
            }
            aVar.aM(7, this.MCU);
            aVar.e(8, 8, this.MCV);
            aVar.cc(9, this.MCW);
            aVar.e(10, 8, this.MCX);
            AppMethodBeat.o(117545);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.APx != null ? g.a.a.b.b.a.f(1, this.APx) + 0 : 0) + g.a.a.b.b.a.bu(2, this.state) + g.a.a.a.c(3, 8, this.MCQ) + g.a.a.b.b.a.bu(4, this.MCR) + g.a.a.b.b.a.bu(5, this.MCS);
            if (this.MCT != null) {
                f2 += g.a.a.a.nh(6, this.MCT.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.MCU) + g.a.a.a.c(8, 8, this.MCV) + g.a.a.b.b.a.fS(9) + 1 + g.a.a.a.c(10, 8, this.MCX);
            AppMethodBeat.o(117545);
            return bu;
        } else if (i2 == 2) {
            this.MCQ.clear();
            this.MCV.clear();
            this.MCX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.APx == null) {
                b bVar2 = new b("Not all required fields were included: pid");
                AppMethodBeat.o(117545);
                throw bVar2;
            }
            AppMethodBeat.o(117545);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxz cxz = (cxz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxz.APx = aVar3.UbS.readString();
                    AppMethodBeat.o(117545);
                    return 0;
                case 2:
                    cxz.state = aVar3.UbS.zi();
                    AppMethodBeat.o(117545);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cxy cxy = new cxy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cxy.populateBuilderWithField(aVar4, cxy, a.getNextFieldNumber(aVar4))) {
                        }
                        cxz.MCQ.add(cxy);
                    }
                    AppMethodBeat.o(117545);
                    return 0;
                case 4:
                    cxz.MCR = aVar3.UbS.zi();
                    AppMethodBeat.o(117545);
                    return 0;
                case 5:
                    cxz.MCS = aVar3.UbS.zi();
                    AppMethodBeat.o(117545);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        doy doy = new doy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = doy.populateBuilderWithField(aVar5, doy, a.getNextFieldNumber(aVar5))) {
                        }
                        cxz.MCT = doy;
                    }
                    AppMethodBeat.o(117545);
                    return 0;
                case 7:
                    cxz.MCU = aVar3.UbS.zi();
                    AppMethodBeat.o(117545);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cxx cxx = new cxx();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cxx.populateBuilderWithField(aVar6, cxx, a.getNextFieldNumber(aVar6))) {
                        }
                        cxz.MCV.add(cxx);
                    }
                    AppMethodBeat.o(117545);
                    return 0;
                case 9:
                    cxz.MCW = aVar3.UbS.yZ();
                    AppMethodBeat.o(117545);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        doy doy2 = new doy();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = doy2.populateBuilderWithField(aVar7, doy2, a.getNextFieldNumber(aVar7))) {
                        }
                        cxz.MCX.add(doy2);
                    }
                    AppMethodBeat.o(117545);
                    return 0;
                default:
                    AppMethodBeat.o(117545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117545);
            return -1;
        }
    }
}
