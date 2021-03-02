package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class etp extends a {
    public int KXP;
    public LinkedList<eto> NqL = new LinkedList<>();
    public int oTz;

    public etp() {
        AppMethodBeat.i(115874);
        AppMethodBeat.o(115874);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115875);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oTz);
            aVar.e(2, 8, this.NqL);
            aVar.aM(3, this.KXP);
            AppMethodBeat.o(115875);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oTz) + 0 + g.a.a.a.c(2, 8, this.NqL) + g.a.a.b.b.a.bu(3, this.KXP);
            AppMethodBeat.o(115875);
            return bu;
        } else if (i2 == 2) {
            this.NqL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115875);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etp etp = (etp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    etp.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(115875);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eto eto = new eto();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eto.populateBuilderWithField(aVar4, eto, a.getNextFieldNumber(aVar4))) {
                        }
                        etp.NqL.add(eto);
                    }
                    AppMethodBeat.o(115875);
                    return 0;
                case 3:
                    etp.KXP = aVar3.UbS.zi();
                    AppMethodBeat.o(115875);
                    return 0;
                default:
                    AppMethodBeat.o(115875);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115875);
            return -1;
        }
    }
}
