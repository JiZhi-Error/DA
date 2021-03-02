package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cl extends a {
    public ee xMt;
    public dd xMu;
    public ad xMv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41797);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMt != null) {
                aVar.ni(1, this.xMt.computeSize());
                this.xMt.writeFields(aVar);
            }
            if (this.xMu != null) {
                aVar.ni(2, this.xMu.computeSize());
                this.xMu.writeFields(aVar);
            }
            if (this.xMv != null) {
                aVar.ni(3, this.xMv.computeSize());
                this.xMv.writeFields(aVar);
            }
            AppMethodBeat.o(41797);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xMt != null ? g.a.a.a.nh(1, this.xMt.computeSize()) + 0 : 0;
            if (this.xMu != null) {
                nh += g.a.a.a.nh(2, this.xMu.computeSize());
            }
            if (this.xMv != null) {
                nh += g.a.a.a.nh(3, this.xMv.computeSize());
            }
            AppMethodBeat.o(41797);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41797);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cl clVar = (cl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ee eeVar = new ee();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eeVar.populateBuilderWithField(aVar4, eeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        clVar.xMt = eeVar;
                    }
                    AppMethodBeat.o(41797);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dd ddVar = new dd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ddVar.populateBuilderWithField(aVar5, ddVar, a.getNextFieldNumber(aVar5))) {
                        }
                        clVar.xMu = ddVar;
                    }
                    AppMethodBeat.o(41797);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ad adVar = new ad();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = adVar.populateBuilderWithField(aVar6, adVar, a.getNextFieldNumber(aVar6))) {
                        }
                        clVar.xMv = adVar;
                    }
                    AppMethodBeat.o(41797);
                    return 0;
                default:
                    AppMethodBeat.o(41797);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41797);
            return -1;
        }
    }
}
