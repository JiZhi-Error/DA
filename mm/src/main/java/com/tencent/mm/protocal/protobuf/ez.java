package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ez extends a {
    public LinkedList<cws> KEp = new LinkedList<>();
    public int KIp;
    public LinkedList<cwr> duo = new LinkedList<>();

    public ez() {
        AppMethodBeat.i(152492);
        AppMethodBeat.o(152492);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152493);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KIp);
            aVar.e(2, 8, this.KEp);
            aVar.e(3, 8, this.duo);
            AppMethodBeat.o(152493);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KIp) + 0 + g.a.a.a.c(2, 8, this.KEp) + g.a.a.a.c(3, 8, this.duo);
            AppMethodBeat.o(152493);
            return bu;
        } else if (i2 == 2) {
            this.KEp.clear();
            this.duo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152493);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ez ezVar = (ez) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ezVar.KIp = aVar3.UbS.zi();
                    AppMethodBeat.o(152493);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cws cws = new cws();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cws.populateBuilderWithField(aVar4, cws, a.getNextFieldNumber(aVar4))) {
                        }
                        ezVar.KEp.add(cws);
                    }
                    AppMethodBeat.o(152493);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cwr cwr = new cwr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cwr.populateBuilderWithField(aVar5, cwr, a.getNextFieldNumber(aVar5))) {
                        }
                        ezVar.duo.add(cwr);
                    }
                    AppMethodBeat.o(152493);
                    return 0;
                default:
                    AppMethodBeat.o(152493);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152493);
            return -1;
        }
    }
}