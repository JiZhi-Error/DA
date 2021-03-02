package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dqe extends a {
    public LinkedList<ahg> LpW = new LinkedList<>();
    public ehu MTh;
    public ahf MTi;
    public int MTj;
    public boolean MTk;
    public aep MTl;
    public bj MTm;
    public int type;
    public String url;

    public dqe() {
        AppMethodBeat.i(91676);
        AppMethodBeat.o(91676);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91677);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.MTh != null) {
                aVar.ni(3, this.MTh.computeSize());
                this.MTh.writeFields(aVar);
            }
            if (this.MTi != null) {
                aVar.ni(4, this.MTi.computeSize());
                this.MTi.writeFields(aVar);
            }
            aVar.aM(5, this.MTj);
            aVar.cc(6, this.MTk);
            aVar.e(7, 8, this.LpW);
            if (this.MTl != null) {
                aVar.ni(8, this.MTl.computeSize());
                this.MTl.writeFields(aVar);
            }
            if (this.MTm != null) {
                aVar.ni(9, this.MTm.computeSize());
                this.MTm.writeFields(aVar);
            }
            AppMethodBeat.o(91677);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.MTh != null) {
                bu += g.a.a.a.nh(3, this.MTh.computeSize());
            }
            if (this.MTi != null) {
                bu += g.a.a.a.nh(4, this.MTi.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MTj) + g.a.a.b.b.a.fS(6) + 1 + g.a.a.a.c(7, 8, this.LpW);
            if (this.MTl != null) {
                bu2 += g.a.a.a.nh(8, this.MTl.computeSize());
            }
            if (this.MTm != null) {
                bu2 += g.a.a.a.nh(9, this.MTm.computeSize());
            }
            AppMethodBeat.o(91677);
            return bu2;
        } else if (i2 == 2) {
            this.LpW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91677);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dqe dqe = (dqe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dqe.type = aVar3.UbS.zi();
                    AppMethodBeat.o(91677);
                    return 0;
                case 2:
                    dqe.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91677);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehu ehu = new ehu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehu.populateBuilderWithField(aVar4, ehu, a.getNextFieldNumber(aVar4))) {
                        }
                        dqe.MTh = ehu;
                    }
                    AppMethodBeat.o(91677);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahf ahf = new ahf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahf.populateBuilderWithField(aVar5, ahf, a.getNextFieldNumber(aVar5))) {
                        }
                        dqe.MTi = ahf;
                    }
                    AppMethodBeat.o(91677);
                    return 0;
                case 5:
                    dqe.MTj = aVar3.UbS.zi();
                    AppMethodBeat.o(91677);
                    return 0;
                case 6:
                    dqe.MTk = aVar3.UbS.yZ();
                    AppMethodBeat.o(91677);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ahg ahg = new ahg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ahg.populateBuilderWithField(aVar6, ahg, a.getNextFieldNumber(aVar6))) {
                        }
                        dqe.LpW.add(ahg);
                    }
                    AppMethodBeat.o(91677);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aep aep = new aep();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aep.populateBuilderWithField(aVar7, aep, a.getNextFieldNumber(aVar7))) {
                        }
                        dqe.MTl = aep;
                    }
                    AppMethodBeat.o(91677);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bj bjVar = new bj();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bjVar.populateBuilderWithField(aVar8, bjVar, a.getNextFieldNumber(aVar8))) {
                        }
                        dqe.MTm = bjVar;
                    }
                    AppMethodBeat.o(91677);
                    return 0;
                default:
                    AppMethodBeat.o(91677);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91677);
            return -1;
        }
    }
}
