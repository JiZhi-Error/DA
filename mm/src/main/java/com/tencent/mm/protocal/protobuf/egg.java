package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class egg extends a {
    public LinkedList<cdv> MaA = new LinkedList<>();
    public csv Ngk;
    public LinkedList<ehf> Ngl = new LinkedList<>();

    public egg() {
        AppMethodBeat.i(91709);
        AppMethodBeat.o(91709);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91710);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ngk != null) {
                aVar.ni(1, this.Ngk.computeSize());
                this.Ngk.writeFields(aVar);
            }
            aVar.e(2, 8, this.MaA);
            aVar.e(3, 8, this.Ngl);
            AppMethodBeat.o(91710);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Ngk != null ? g.a.a.a.nh(1, this.Ngk.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.MaA) + g.a.a.a.c(3, 8, this.Ngl);
            AppMethodBeat.o(91710);
            return nh;
        } else if (i2 == 2) {
            this.MaA.clear();
            this.Ngl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91710);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egg egg = (egg) objArr[1];
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
                        egg.Ngk = csv;
                    }
                    AppMethodBeat.o(91710);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cdv cdv = new cdv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cdv.populateBuilderWithField(aVar5, cdv, a.getNextFieldNumber(aVar5))) {
                        }
                        egg.MaA.add(cdv);
                    }
                    AppMethodBeat.o(91710);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf.populateBuilderWithField(aVar6, ehf, a.getNextFieldNumber(aVar6))) {
                        }
                        egg.Ngl.add(ehf);
                    }
                    AppMethodBeat.o(91710);
                    return 0;
                default:
                    AppMethodBeat.o(91710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91710);
            return -1;
        }
    }
}
