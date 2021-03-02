package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class jb extends a {
    public cui KNA;
    public int KNB;
    public int KNC;
    public int KND;
    public cui KNx;
    public cui KNy;
    public cui KNz;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118406);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.KNx != null) {
                aVar.ni(2, this.KNx.computeSize());
                this.KNx.writeFields(aVar);
            }
            if (this.KNy != null) {
                aVar.ni(3, this.KNy.computeSize());
                this.KNy.writeFields(aVar);
            }
            if (this.KNz != null) {
                aVar.ni(4, this.KNz.computeSize());
                this.KNz.writeFields(aVar);
            }
            if (this.KNA != null) {
                aVar.ni(11, this.KNA.computeSize());
                this.KNA.writeFields(aVar);
            }
            aVar.aM(100, this.KNB);
            aVar.aM(101, this.KNC);
            aVar.aM(102, this.KND);
            AppMethodBeat.o(118406);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.KNx != null) {
                bu += g.a.a.a.nh(2, this.KNx.computeSize());
            }
            if (this.KNy != null) {
                bu += g.a.a.a.nh(3, this.KNy.computeSize());
            }
            if (this.KNz != null) {
                bu += g.a.a.a.nh(4, this.KNz.computeSize());
            }
            if (this.KNA != null) {
                bu += g.a.a.a.nh(11, this.KNA.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(100, this.KNB) + g.a.a.b.b.a.bu(101, this.KNC) + g.a.a.b.b.a.bu(102, this.KND);
            AppMethodBeat.o(118406);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118406);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jb jbVar = (jb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jbVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(118406);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cui cui = new cui();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cui.populateBuilderWithField(aVar4, cui, a.getNextFieldNumber(aVar4))) {
                        }
                        jbVar.KNx = cui;
                    }
                    AppMethodBeat.o(118406);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cui cui2 = new cui();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cui2.populateBuilderWithField(aVar5, cui2, a.getNextFieldNumber(aVar5))) {
                        }
                        jbVar.KNy = cui2;
                    }
                    AppMethodBeat.o(118406);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cui cui3 = new cui();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cui3.populateBuilderWithField(aVar6, cui3, a.getNextFieldNumber(aVar6))) {
                        }
                        jbVar.KNz = cui3;
                    }
                    AppMethodBeat.o(118406);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cui cui4 = new cui();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cui4.populateBuilderWithField(aVar7, cui4, a.getNextFieldNumber(aVar7))) {
                        }
                        jbVar.KNA = cui4;
                    }
                    AppMethodBeat.o(118406);
                    return 0;
                case 100:
                    jbVar.KNB = aVar3.UbS.zi();
                    AppMethodBeat.o(118406);
                    return 0;
                case 101:
                    jbVar.KNC = aVar3.UbS.zi();
                    AppMethodBeat.o(118406);
                    return 0;
                case 102:
                    jbVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(118406);
                    return 0;
                default:
                    AppMethodBeat.o(118406);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118406);
            return -1;
        }
    }
}
