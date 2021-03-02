package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class n extends a {
    public c rCa;
    public int rCe;
    public int rCf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(23496);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.rCa == null) {
                b bVar = new b("Not all required fields were included: BasePush");
                AppMethodBeat.o(23496);
                throw bVar;
            }
            if (this.rCa != null) {
                aVar.ni(1, this.rCa.computeSize());
                this.rCa.writeFields(aVar);
            }
            aVar.aM(2, this.rCe);
            aVar.aM(3, this.rCf);
            AppMethodBeat.o(23496);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.rCa != null ? g.a.a.a.nh(1, this.rCa.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.rCe) + g.a.a.b.b.a.bu(3, this.rCf);
            AppMethodBeat.o(23496);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.rCa == null) {
                b bVar2 = new b("Not all required fields were included: BasePush");
                AppMethodBeat.o(23496);
                throw bVar2;
            }
            AppMethodBeat.o(23496);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nVar.rCa = cVar;
                    }
                    AppMethodBeat.o(23496);
                    return 0;
                case 2:
                    nVar.rCe = aVar3.UbS.zi();
                    AppMethodBeat.o(23496);
                    return 0;
                case 3:
                    nVar.rCf = aVar3.UbS.zi();
                    AppMethodBeat.o(23496);
                    return 0;
                default:
                    AppMethodBeat.o(23496);
                    return -1;
            }
        } else {
            AppMethodBeat.o(23496);
            return -1;
        }
    }
}
