package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pz extends a {
    public int KWQ;
    public int KWR;
    public LinkedList<qa> KWS = new LinkedList<>();
    public int type;
    public int uin;
    public int version;

    public pz() {
        AppMethodBeat.i(124455);
        AppMethodBeat.o(124455);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124456);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uin);
            aVar.aM(2, this.KWQ);
            aVar.aM(3, this.KWR);
            aVar.e(4, 8, this.KWS);
            aVar.aM(5, this.version);
            aVar.aM(6, this.type);
            AppMethodBeat.o(124456);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KWQ) + g.a.a.b.b.a.bu(3, this.KWR) + g.a.a.a.c(4, 8, this.KWS) + g.a.a.b.b.a.bu(5, this.version) + g.a.a.b.b.a.bu(6, this.type);
            AppMethodBeat.o(124456);
            return bu;
        } else if (i2 == 2) {
            this.KWS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124456);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pz pzVar = (pz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pzVar.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(124456);
                    return 0;
                case 2:
                    pzVar.KWQ = aVar3.UbS.zi();
                    AppMethodBeat.o(124456);
                    return 0;
                case 3:
                    pzVar.KWR = aVar3.UbS.zi();
                    AppMethodBeat.o(124456);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        qa qaVar = new qa();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = qaVar.populateBuilderWithField(aVar4, qaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pzVar.KWS.add(qaVar);
                    }
                    AppMethodBeat.o(124456);
                    return 0;
                case 5:
                    pzVar.version = aVar3.UbS.zi();
                    AppMethodBeat.o(124456);
                    return 0;
                case 6:
                    pzVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(124456);
                    return 0;
                default:
                    AppMethodBeat.o(124456);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124456);
            return -1;
        }
    }
}
