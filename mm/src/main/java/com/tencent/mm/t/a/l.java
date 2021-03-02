package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class l extends a {
    public a gTO;
    public p gTP;
    public i gTQ;
    public b gTR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194684);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.gTO != null) {
                aVar.ni(1, this.gTO.computeSize());
                this.gTO.writeFields(aVar);
            }
            if (this.gTP != null) {
                aVar.ni(2, this.gTP.computeSize());
                this.gTP.writeFields(aVar);
            }
            if (this.gTQ != null) {
                aVar.ni(3, this.gTQ.computeSize());
                this.gTQ.writeFields(aVar);
            }
            if (this.gTR != null) {
                aVar.ni(4, this.gTR.computeSize());
                this.gTR.writeFields(aVar);
            }
            AppMethodBeat.o(194684);
            return 0;
        } else if (i2 == 1) {
            int nh = this.gTO != null ? g.a.a.a.nh(1, this.gTO.computeSize()) + 0 : 0;
            if (this.gTP != null) {
                nh += g.a.a.a.nh(2, this.gTP.computeSize());
            }
            if (this.gTQ != null) {
                nh += g.a.a.a.nh(3, this.gTQ.computeSize());
            }
            if (this.gTR != null) {
                nh += g.a.a.a.nh(4, this.gTR.computeSize());
            }
            AppMethodBeat.o(194684);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194684);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar4 = new a();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        lVar.gTO = aVar4;
                    }
                    AppMethodBeat.o(194684);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        p pVar = new p();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = pVar.populateBuilderWithField(aVar6, pVar, a.getNextFieldNumber(aVar6))) {
                        }
                        lVar.gTP = pVar;
                    }
                    AppMethodBeat.o(194684);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        i iVar = new i();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = iVar.populateBuilderWithField(aVar7, iVar, a.getNextFieldNumber(aVar7))) {
                        }
                        lVar.gTQ = iVar;
                    }
                    AppMethodBeat.o(194684);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        b bVar = new b();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bVar.populateBuilderWithField(aVar8, bVar, a.getNextFieldNumber(aVar8))) {
                        }
                        lVar.gTR = bVar;
                    }
                    AppMethodBeat.o(194684);
                    return 0;
                default:
                    AppMethodBeat.o(194684);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194684);
            return -1;
        }
    }
}
