package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ak extends a {
    public int KCZ;
    public int KDa;
    public int KDb;
    public LinkedList<ai> KDc = new LinkedList<>();
    public int KDd;
    public LinkedList<ai> KDe = new LinkedList<>();

    public ak() {
        AppMethodBeat.i(143963);
        AppMethodBeat.o(143963);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143964);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KCZ);
            aVar.aM(2, this.KDb);
            aVar.e(3, 8, this.KDc);
            aVar.aM(4, this.KDa);
            aVar.aM(5, this.KDd);
            aVar.e(6, 8, this.KDe);
            AppMethodBeat.o(143964);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KCZ) + 0 + g.a.a.b.b.a.bu(2, this.KDb) + g.a.a.a.c(3, 8, this.KDc) + g.a.a.b.b.a.bu(4, this.KDa) + g.a.a.b.b.a.bu(5, this.KDd) + g.a.a.a.c(6, 8, this.KDe);
            AppMethodBeat.o(143964);
            return bu;
        } else if (i2 == 2) {
            this.KDc.clear();
            this.KDe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143964);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ak akVar = (ak) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    akVar.KCZ = aVar3.UbS.zi();
                    AppMethodBeat.o(143964);
                    return 0;
                case 2:
                    akVar.KDb = aVar3.UbS.zi();
                    AppMethodBeat.o(143964);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ai aiVar = new ai();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aiVar.populateBuilderWithField(aVar4, aiVar, a.getNextFieldNumber(aVar4))) {
                        }
                        akVar.KDc.add(aiVar);
                    }
                    AppMethodBeat.o(143964);
                    return 0;
                case 4:
                    akVar.KDa = aVar3.UbS.zi();
                    AppMethodBeat.o(143964);
                    return 0;
                case 5:
                    akVar.KDd = aVar3.UbS.zi();
                    AppMethodBeat.o(143964);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ai aiVar2 = new ai();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aiVar2.populateBuilderWithField(aVar5, aiVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        akVar.KDe.add(aiVar2);
                    }
                    AppMethodBeat.o(143964);
                    return 0;
                default:
                    AppMethodBeat.o(143964);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143964);
            return -1;
        }
    }
}
