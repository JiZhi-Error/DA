package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bga extends a {
    public long LPF = 0;
    public LinkedList<cbn> LPG = new LinkedList<>();
    public LinkedList<erd> LPH = new LinkedList<>();
    public String name;
    public long startTime = -1;

    public bga() {
        AppMethodBeat.i(122499);
        AppMethodBeat.o(122499);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122500);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.bb(2, this.startTime);
            aVar.bb(3, this.LPF);
            aVar.e(4, 8, this.LPG);
            aVar.e(5, 8, this.LPH);
            AppMethodBeat.o(122500);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.b.b.a.r(2, this.startTime) + g.a.a.b.b.a.r(3, this.LPF) + g.a.a.a.c(4, 8, this.LPG) + g.a.a.a.c(5, 8, this.LPH);
            AppMethodBeat.o(122500);
            return f2;
        } else if (i2 == 2) {
            this.LPG.clear();
            this.LPH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122500);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bga bga = (bga) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bga.name = aVar3.UbS.readString();
                    AppMethodBeat.o(122500);
                    return 0;
                case 2:
                    bga.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122500);
                    return 0;
                case 3:
                    bga.LPF = aVar3.UbS.zl();
                    AppMethodBeat.o(122500);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbn cbn = new cbn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbn.populateBuilderWithField(aVar4, cbn, a.getNextFieldNumber(aVar4))) {
                        }
                        bga.LPG.add(cbn);
                    }
                    AppMethodBeat.o(122500);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        erd erd = new erd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = erd.populateBuilderWithField(aVar5, erd, a.getNextFieldNumber(aVar5))) {
                        }
                        bga.LPH.add(erd);
                    }
                    AppMethodBeat.o(122500);
                    return 0;
                default:
                    AppMethodBeat.o(122500);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122500);
            return -1;
        }
    }
}
