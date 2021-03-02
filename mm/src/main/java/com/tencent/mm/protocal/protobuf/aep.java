package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aep extends a {
    public csv LpV;
    public LinkedList<ahg> LpW = new LinkedList<>();
    public LinkedList<erb> LpX = new LinkedList<>();
    public String LpY;

    public aep() {
        AppMethodBeat.i(91431);
        AppMethodBeat.o(91431);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91432);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LpV != null) {
                aVar.ni(1, this.LpV.computeSize());
                this.LpV.writeFields(aVar);
            }
            aVar.e(2, 8, this.LpW);
            aVar.e(3, 8, this.LpX);
            if (this.LpY != null) {
                aVar.e(4, this.LpY);
            }
            AppMethodBeat.o(91432);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LpV != null ? g.a.a.a.nh(1, this.LpV.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LpW) + g.a.a.a.c(3, 8, this.LpX);
            if (this.LpY != null) {
                nh += g.a.a.b.b.a.f(4, this.LpY);
            }
            AppMethodBeat.o(91432);
            return nh;
        } else if (i2 == 2) {
            this.LpW.clear();
            this.LpX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91432);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aep aep = (aep) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csv csv = new csv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csv.populateBuilderWithField(aVar4, csv, a.getNextFieldNumber(aVar4))) {
                        }
                        aep.LpV = csv;
                    }
                    AppMethodBeat.o(91432);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ahg ahg = new ahg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ahg.populateBuilderWithField(aVar5, ahg, a.getNextFieldNumber(aVar5))) {
                        }
                        aep.LpW.add(ahg);
                    }
                    AppMethodBeat.o(91432);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        erb erb = new erb();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = erb.populateBuilderWithField(aVar6, erb, a.getNextFieldNumber(aVar6))) {
                        }
                        aep.LpX.add(erb);
                    }
                    AppMethodBeat.o(91432);
                    return 0;
                case 4:
                    aep.LpY = aVar3.UbS.readString();
                    AppMethodBeat.o(91432);
                    return 0;
                default:
                    AppMethodBeat.o(91432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91432);
            return -1;
        }
    }
}
