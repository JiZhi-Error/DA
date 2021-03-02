package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ni extends a {
    public ng KSJ;
    public LinkedList<nh> KSK = new LinkedList<>();
    public String KSL;

    public ni() {
        AppMethodBeat.i(124400);
        AppMethodBeat.o(124400);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124401);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KSJ != null) {
                aVar.ni(1, this.KSJ.computeSize());
                this.KSJ.writeFields(aVar);
            }
            aVar.e(2, 8, this.KSK);
            if (this.KSL != null) {
                aVar.e(6, this.KSL);
            }
            AppMethodBeat.o(124401);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.KSJ != null ? g.a.a.a.nh(1, this.KSJ.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KSK);
            if (this.KSL != null) {
                nh += g.a.a.b.b.a.f(6, this.KSL);
            }
            AppMethodBeat.o(124401);
            return nh;
        } else if (i2 == 2) {
            this.KSK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124401);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ni niVar = (ni) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ng ngVar = new ng();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ngVar.populateBuilderWithField(aVar4, ngVar, a.getNextFieldNumber(aVar4))) {
                        }
                        niVar.KSJ = ngVar;
                    }
                    AppMethodBeat.o(124401);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        nh nhVar = new nh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nhVar.populateBuilderWithField(aVar5, nhVar, a.getNextFieldNumber(aVar5))) {
                        }
                        niVar.KSK.add(nhVar);
                    }
                    AppMethodBeat.o(124401);
                    return 0;
                case 3:
                case 4:
                case 5:
                default:
                    AppMethodBeat.o(124401);
                    return -1;
                case 6:
                    niVar.KSL = aVar3.UbS.readString();
                    AppMethodBeat.o(124401);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124401);
            return -1;
        }
    }
}
