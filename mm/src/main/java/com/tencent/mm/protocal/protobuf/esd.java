package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class esd extends a {
    public esc Npo;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(239540);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Npo != null) {
                aVar.ni(1, this.Npo.computeSize());
                this.Npo.writeFields(aVar);
            }
            aVar.aM(2, this.status);
            AppMethodBeat.o(239540);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Npo != null ? g.a.a.a.nh(1, this.Npo.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.status);
            AppMethodBeat.o(239540);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(239540);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            esd esd = (esd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esc esc = new esc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esc.populateBuilderWithField(aVar4, esc, a.getNextFieldNumber(aVar4))) {
                        }
                        esd.Npo = esc;
                    }
                    AppMethodBeat.o(239540);
                    return 0;
                case 2:
                    esd.status = aVar3.UbS.zi();
                    AppMethodBeat.o(239540);
                    return 0;
                default:
                    AppMethodBeat.o(239540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(239540);
            return -1;
        }
    }
}
