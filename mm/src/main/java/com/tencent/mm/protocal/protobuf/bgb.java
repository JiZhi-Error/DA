package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bgb extends a {
    public LinkedList<dvg> LPI = new LinkedList<>();
    public dvg LPJ;
    public LinkedList<bga> LPK = new LinkedList<>();
    public boolean LPL = false;
    public String LPM;
    public long LPN;
    public String dRM;
    public boolean vtY = false;

    public bgb() {
        AppMethodBeat.i(122501);
        AppMethodBeat.o(122501);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122502);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dRM != null) {
                aVar.e(1, this.dRM);
            }
            aVar.e(2, 8, this.LPI);
            if (this.LPJ != null) {
                aVar.ni(3, this.LPJ.computeSize());
                this.LPJ.writeFields(aVar);
            }
            aVar.e(4, 8, this.LPK);
            aVar.cc(5, this.LPL);
            aVar.cc(6, this.vtY);
            if (this.LPM != null) {
                aVar.e(7, this.LPM);
            }
            aVar.bb(8, this.LPN);
            AppMethodBeat.o(122502);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dRM != null ? g.a.a.b.b.a.f(1, this.dRM) + 0 : 0) + g.a.a.a.c(2, 8, this.LPI);
            if (this.LPJ != null) {
                f2 += g.a.a.a.nh(3, this.LPJ.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(4, 8, this.LPK) + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1;
            if (this.LPM != null) {
                c2 += g.a.a.b.b.a.f(7, this.LPM);
            }
            int r = c2 + g.a.a.b.b.a.r(8, this.LPN);
            AppMethodBeat.o(122502);
            return r;
        } else if (i2 == 2) {
            this.LPI.clear();
            this.LPK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122502);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgb bgb = (bgb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgb.dRM = aVar3.UbS.readString();
                    AppMethodBeat.o(122502);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dvg dvg = new dvg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dvg.populateBuilderWithField(aVar4, dvg, a.getNextFieldNumber(aVar4))) {
                        }
                        bgb.LPI.add(dvg);
                    }
                    AppMethodBeat.o(122502);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dvg dvg2 = new dvg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dvg2.populateBuilderWithField(aVar5, dvg2, a.getNextFieldNumber(aVar5))) {
                        }
                        bgb.LPJ = dvg2;
                    }
                    AppMethodBeat.o(122502);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bga bga = new bga();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bga.populateBuilderWithField(aVar6, bga, a.getNextFieldNumber(aVar6))) {
                        }
                        bgb.LPK.add(bga);
                    }
                    AppMethodBeat.o(122502);
                    return 0;
                case 5:
                    bgb.LPL = aVar3.UbS.yZ();
                    AppMethodBeat.o(122502);
                    return 0;
                case 6:
                    bgb.vtY = aVar3.UbS.yZ();
                    AppMethodBeat.o(122502);
                    return 0;
                case 7:
                    bgb.LPM = aVar3.UbS.readString();
                    AppMethodBeat.o(122502);
                    return 0;
                case 8:
                    bgb.LPN = aVar3.UbS.zl();
                    AppMethodBeat.o(122502);
                    return 0;
                default:
                    AppMethodBeat.o(122502);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122502);
            return -1;
        }
    }
}
