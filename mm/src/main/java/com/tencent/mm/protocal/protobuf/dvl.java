package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvl extends a {
    public cyl MWs;
    public cyh MWt;
    public cyl MWu;
    public cyh MWv;
    public boolean MWw = false;
    public boolean MWx = false;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220726);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MWs != null) {
                aVar.ni(1, this.MWs.computeSize());
                this.MWs.writeFields(aVar);
            }
            if (this.MWt != null) {
                aVar.ni(2, this.MWt.computeSize());
                this.MWt.writeFields(aVar);
            }
            if (this.MWu != null) {
                aVar.ni(3, this.MWu.computeSize());
                this.MWu.writeFields(aVar);
            }
            if (this.MWv != null) {
                aVar.ni(4, this.MWv.computeSize());
                this.MWv.writeFields(aVar);
            }
            aVar.cc(5, this.MWw);
            aVar.cc(6, this.MWx);
            AppMethodBeat.o(220726);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MWs != null ? g.a.a.a.nh(1, this.MWs.computeSize()) + 0 : 0;
            if (this.MWt != null) {
                nh += g.a.a.a.nh(2, this.MWt.computeSize());
            }
            if (this.MWu != null) {
                nh += g.a.a.a.nh(3, this.MWu.computeSize());
            }
            if (this.MWv != null) {
                nh += g.a.a.a.nh(4, this.MWv.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(220726);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220726);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvl dvl = (dvl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyl cyl = new cyl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyl.populateBuilderWithField(aVar4, cyl, a.getNextFieldNumber(aVar4))) {
                        }
                        dvl.MWs = cyl;
                    }
                    AppMethodBeat.o(220726);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyh cyh = new cyh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyh.populateBuilderWithField(aVar5, cyh, a.getNextFieldNumber(aVar5))) {
                        }
                        dvl.MWt = cyh;
                    }
                    AppMethodBeat.o(220726);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cyl cyl2 = new cyl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cyl2.populateBuilderWithField(aVar6, cyl2, a.getNextFieldNumber(aVar6))) {
                        }
                        dvl.MWu = cyl2;
                    }
                    AppMethodBeat.o(220726);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cyh cyh2 = new cyh();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cyh2.populateBuilderWithField(aVar7, cyh2, a.getNextFieldNumber(aVar7))) {
                        }
                        dvl.MWv = cyh2;
                    }
                    AppMethodBeat.o(220726);
                    return 0;
                case 5:
                    dvl.MWw = aVar3.UbS.yZ();
                    AppMethodBeat.o(220726);
                    return 0;
                case 6:
                    dvl.MWx = aVar3.UbS.yZ();
                    AppMethodBeat.o(220726);
                    return 0;
                default:
                    AppMethodBeat.o(220726);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220726);
            return -1;
        }
    }
}
