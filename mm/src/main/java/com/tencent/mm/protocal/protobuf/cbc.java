package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbc extends a {
    public jm Mgs;
    public tg Mgt;
    public cop Mgu;
    public ecz Mgv;
    public drg Mgw;
    public abp Mgx;
    public ant Mgy;
    public bgc Mgz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116471);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mgs != null) {
                aVar.ni(1, this.Mgs.computeSize());
                this.Mgs.writeFields(aVar);
            }
            if (this.Mgt != null) {
                aVar.ni(2, this.Mgt.computeSize());
                this.Mgt.writeFields(aVar);
            }
            if (this.Mgu != null) {
                aVar.ni(3, this.Mgu.computeSize());
                this.Mgu.writeFields(aVar);
            }
            if (this.Mgv != null) {
                aVar.ni(4, this.Mgv.computeSize());
                this.Mgv.writeFields(aVar);
            }
            if (this.Mgw != null) {
                aVar.ni(6, this.Mgw.computeSize());
                this.Mgw.writeFields(aVar);
            }
            if (this.Mgx != null) {
                aVar.ni(7, this.Mgx.computeSize());
                this.Mgx.writeFields(aVar);
            }
            if (this.Mgy != null) {
                aVar.ni(8, this.Mgy.computeSize());
                this.Mgy.writeFields(aVar);
            }
            if (this.Mgz != null) {
                aVar.ni(9, this.Mgz.computeSize());
                this.Mgz.writeFields(aVar);
            }
            AppMethodBeat.o(116471);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mgs != null ? g.a.a.a.nh(1, this.Mgs.computeSize()) + 0 : 0;
            if (this.Mgt != null) {
                nh += g.a.a.a.nh(2, this.Mgt.computeSize());
            }
            if (this.Mgu != null) {
                nh += g.a.a.a.nh(3, this.Mgu.computeSize());
            }
            if (this.Mgv != null) {
                nh += g.a.a.a.nh(4, this.Mgv.computeSize());
            }
            if (this.Mgw != null) {
                nh += g.a.a.a.nh(6, this.Mgw.computeSize());
            }
            if (this.Mgx != null) {
                nh += g.a.a.a.nh(7, this.Mgx.computeSize());
            }
            if (this.Mgy != null) {
                nh += g.a.a.a.nh(8, this.Mgy.computeSize());
            }
            if (this.Mgz != null) {
                nh += g.a.a.a.nh(9, this.Mgz.computeSize());
            }
            AppMethodBeat.o(116471);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116471);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbc cbc = (cbc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jm jmVar = new jm();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jmVar.populateBuilderWithField(aVar4, jmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cbc.Mgs = jmVar;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        tg tgVar = new tg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tgVar.populateBuilderWithField(aVar5, tgVar, a.getNextFieldNumber(aVar5))) {
                        }
                        cbc.Mgt = tgVar;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cop cop = new cop();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cop.populateBuilderWithField(aVar6, cop, a.getNextFieldNumber(aVar6))) {
                        }
                        cbc.Mgu = cop;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ecz ecz = new ecz();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ecz.populateBuilderWithField(aVar7, ecz, a.getNextFieldNumber(aVar7))) {
                        }
                        cbc.Mgv = ecz;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(116471);
                    return -1;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        drg drg = new drg();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = drg.populateBuilderWithField(aVar8, drg, a.getNextFieldNumber(aVar8))) {
                        }
                        cbc.Mgw = drg;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        abp abp = new abp();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = abp.populateBuilderWithField(aVar9, abp, a.getNextFieldNumber(aVar9))) {
                        }
                        cbc.Mgx = abp;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        ant ant = new ant();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = ant.populateBuilderWithField(aVar10, ant, a.getNextFieldNumber(aVar10))) {
                        }
                        cbc.Mgy = ant;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bgc bgc = new bgc();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bgc.populateBuilderWithField(aVar11, bgc, a.getNextFieldNumber(aVar11))) {
                        }
                        cbc.Mgz = bgc;
                    }
                    AppMethodBeat.o(116471);
                    return 0;
            }
        } else {
            AppMethodBeat.o(116471);
            return -1;
        }
    }
}
