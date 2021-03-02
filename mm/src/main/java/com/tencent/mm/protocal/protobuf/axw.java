package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class axw extends a {
    public axx ApI;
    public axy Aqo;
    public LinkedList<axz> LId = new LinkedList<>();

    public axw() {
        AppMethodBeat.i(209576);
        AppMethodBeat.o(209576);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209577);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LId);
            if (this.Aqo != null) {
                aVar.ni(2, this.Aqo.computeSize());
                this.Aqo.writeFields(aVar);
            }
            if (this.ApI != null) {
                aVar.ni(3, this.ApI.computeSize());
                this.ApI.writeFields(aVar);
            }
            AppMethodBeat.o(209577);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LId) + 0;
            if (this.Aqo != null) {
                c2 += g.a.a.a.nh(2, this.Aqo.computeSize());
            }
            if (this.ApI != null) {
                c2 += g.a.a.a.nh(3, this.ApI.computeSize());
            }
            AppMethodBeat.o(209577);
            return c2;
        } else if (i2 == 2) {
            this.LId.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209577);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axw axw = (axw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axz axz = new axz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axz.populateBuilderWithField(aVar4, axz, a.getNextFieldNumber(aVar4))) {
                        }
                        axw.LId.add(axz);
                    }
                    AppMethodBeat.o(209577);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axy axy = new axy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axy.populateBuilderWithField(aVar5, axy, a.getNextFieldNumber(aVar5))) {
                        }
                        axw.Aqo = axy;
                    }
                    AppMethodBeat.o(209577);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        axx axx = new axx();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = axx.populateBuilderWithField(aVar6, axx, a.getNextFieldNumber(aVar6))) {
                        }
                        axw.ApI = axx;
                    }
                    AppMethodBeat.o(209577);
                    return 0;
                default:
                    AppMethodBeat.o(209577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209577);
            return -1;
        }
    }
}
