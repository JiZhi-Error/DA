package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class uq extends a {
    public String ANo;
    public ehf KEN;
    public dqe KEP;
    public String KNW;
    public ccy Led;
    public LinkedList<ehf> Lee = new LinkedList<>();
    public int Lef;
    public int Leg;
    public String dDj;
    public int state;

    public uq() {
        AppMethodBeat.i(91394);
        AppMethodBeat.o(91394);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91395);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Led != null) {
                aVar.ni(1, this.Led.computeSize());
                this.Led.writeFields(aVar);
            }
            if (this.KEN != null) {
                aVar.ni(2, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            aVar.e(3, 8, this.Lee);
            if (this.ANo != null) {
                aVar.e(4, this.ANo);
            }
            if (this.dDj != null) {
                aVar.e(5, this.dDj);
            }
            if (this.KEP != null) {
                aVar.ni(6, this.KEP.computeSize());
                this.KEP.writeFields(aVar);
            }
            aVar.aM(7, this.state);
            aVar.aM(8, this.Lef);
            aVar.aM(9, this.Leg);
            if (this.KNW != null) {
                aVar.e(10, this.KNW);
            }
            AppMethodBeat.o(91395);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Led != null ? g.a.a.a.nh(1, this.Led.computeSize()) + 0 : 0;
            if (this.KEN != null) {
                nh += g.a.a.a.nh(2, this.KEN.computeSize());
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.Lee);
            if (this.ANo != null) {
                c2 += g.a.a.b.b.a.f(4, this.ANo);
            }
            if (this.dDj != null) {
                c2 += g.a.a.b.b.a.f(5, this.dDj);
            }
            if (this.KEP != null) {
                c2 += g.a.a.a.nh(6, this.KEP.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(7, this.state) + g.a.a.b.b.a.bu(8, this.Lef) + g.a.a.b.b.a.bu(9, this.Leg);
            if (this.KNW != null) {
                bu += g.a.a.b.b.a.f(10, this.KNW);
            }
            AppMethodBeat.o(91395);
            return bu;
        } else if (i2 == 2) {
            this.Lee.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91395);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            uq uqVar = (uq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccy ccy = new ccy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccy.populateBuilderWithField(aVar4, ccy, a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.Led = ccy;
                    }
                    AppMethodBeat.o(91395);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf.populateBuilderWithField(aVar5, ehf, a.getNextFieldNumber(aVar5))) {
                        }
                        uqVar.KEN = ehf;
                    }
                    AppMethodBeat.o(91395);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf2.populateBuilderWithField(aVar6, ehf2, a.getNextFieldNumber(aVar6))) {
                        }
                        uqVar.Lee.add(ehf2);
                    }
                    AppMethodBeat.o(91395);
                    return 0;
                case 4:
                    uqVar.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(91395);
                    return 0;
                case 5:
                    uqVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91395);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqe dqe = new dqe();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqe.populateBuilderWithField(aVar7, dqe, a.getNextFieldNumber(aVar7))) {
                        }
                        uqVar.KEP = dqe;
                    }
                    AppMethodBeat.o(91395);
                    return 0;
                case 7:
                    uqVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91395);
                    return 0;
                case 8:
                    uqVar.Lef = aVar3.UbS.zi();
                    AppMethodBeat.o(91395);
                    return 0;
                case 9:
                    uqVar.Leg = aVar3.UbS.zi();
                    AppMethodBeat.o(91395);
                    return 0;
                case 10:
                    uqVar.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91395);
                    return 0;
                default:
                    AppMethodBeat.o(91395);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91395);
            return -1;
        }
    }
}
