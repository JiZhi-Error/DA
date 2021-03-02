package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ewp extends a {
    public LinkedList<ewo> Nui = new LinkedList<>();
    public int oTz;

    public ewp() {
        AppMethodBeat.i(32513);
        AppMethodBeat.o(32513);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32514);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Nui);
            aVar.aM(2, this.oTz);
            AppMethodBeat.o(32514);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Nui) + 0 + g.a.a.b.b.a.bu(2, this.oTz);
            AppMethodBeat.o(32514);
            return c2;
        } else if (i2 == 2) {
            this.Nui.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32514);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ewp ewp = (ewp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ewo ewo = new ewo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ewo.populateBuilderWithField(aVar4, ewo, a.getNextFieldNumber(aVar4))) {
                        }
                        ewp.Nui.add(ewo);
                    }
                    AppMethodBeat.o(32514);
                    return 0;
                case 2:
                    ewp.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(32514);
                    return 0;
                default:
                    AppMethodBeat.o(32514);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32514);
            return -1;
        }
    }
}
